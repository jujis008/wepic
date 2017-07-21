package com.wetuo.wepic.core.actions;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import net.coobird.thumbnailator.Thumbnails;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.inject.util.Function;
import com.wetuo.wepic.common.struts.PageAction;
import com.wetuo.wepic.common.util.MD5Code;
import com.wetuo.wepic.core.beans.Blog;
import com.wetuo.wepic.core.beans.BlogCat;
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.core.service.BlogCatService;
import com.wetuo.wepic.core.service.BlogService;
import com.wetuo.wepic.core.service.UserService;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.org.apache.commons.beanutils.BeanUtils;

import freemarker.cache.StrongCacheStorage;

public class BlogAction extends PageAction implements ModelDriven{
   private Object object;
   private BlogService blogService;
   private String msg;
   private int id;
   private int catId;
   private String blogName;
   private String blogContext;
   private int nowPage=1;
   private int pageSize=7;
   private BlogCatService blogCatService;
   protected File pic; 
   protected String picFileName; 
   protected String picContentType; 
   private Blog blog;
   private int endPage;
   private String username;
   private String password;
   private String code;
   private int msg1;
   private UserService userService;
   
	public BlogAction(String className) {
		try{
	object = Class.forName(className).newInstance();
		}catch (Exception e) {
		e.printStackTrace();
		}
       }

	 public String saveBlog(){
		 Blog blog=(Blog)object;
		 String cString=blog.getContext();
		 if(cString.length()>300){
			 cString=cString.substring(1, 280);
			 
		 }
		 blog.setContext(cString);
		 BlogCat blogCat=new BlogCat();
		 blogCat.setId(catId);
		 blog.setBlogCat(blogCat);
		 blog.setShare(0);
		 blog.setHit(0);
		 blog.setType(1);
		 blog.setGood(0);
		 blog.setTransport(0);
		 Object uid=getSession("id");
		 if(uid==null){
			 
			return ""; 
		 }
		 User user=new User();
		 user.setId(Integer.parseInt(uid.toString()));
		 blog.setUser(user);
		 msg="error";
		 SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd");
		 blog.setPublishTime(dateFormat.format(new Date()));
		 if(blogService.save(blog)){
			 msg="ok";
		 }
		
		 
		 return "saveBlog";
		 
	 }
	 
	 
	 /**
	  * 
	  *  * msg1=1;已经应邀
	 * msg1=2;应邀成功
	 * msg1=3;验证码错误
	 * msg1=4;//没有经过实名
	 * msg1=5;没有登录;
	 * msg1=6;权限不够
	  * 
	  * 
	  * 
	  * 
	  * */
	 
	 public String blogLogin() throws Exception{
		 
		
			 String oldCode = getSession("loginValidateCode")+"";
			 //输入验证码
	         if(!code.equals(oldCode)){
	        	 msg1=3;
	        	return "blogLogin";
	         }
	    MD5Code des = new MD5Code("leemenz");
		User userLogn=null;
		String str="^([a-zA-Z0-9]*[._]?[a-zA-Z0-9]+)*@([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)+[\\.][A-Za-z]{2,3}([\\.][A-Za-z]{2})?$";
        Pattern p = Pattern.compile(str);     
        Matcher m = p.matcher(username); 
        Map<String, Object> maplogin=new HashMap<String, Object>();
       if(m.matches()){
    	   maplogin.put("email", username);
    	   
       }else{
    	   maplogin.put("username", username); 
       }
		List<User> listLogin=(List<User>) userService.list(maplogin, 1, 1).getResultList();
		
		if(listLogin.size()==0||listLogin==null){
		msg1=12;
		return "blogLogin";
		}else{
			userLogn=listLogin.get(0);
			username=userLogn.getUsername();
		}	    
		if (this.userService.login(username, des.encrypt(password))) {
			User user=userService.select(username);
			username="";
			ActionContext.getContext().getSession().put("id", user.getId());
			ActionContext.getContext().getSession().put("username", user.getUsername());
			ActionContext.getContext().getSession().put("role", user.getRole());
			String userCatType = user.getUserCat().getType() ;
			ActionContext.getContext().getSession().put("cat",  userCatType );
			msg1=11;
		 
		} 
		 
		 return "blogLogin";
	 }
	
	 //转载
	 public String transportBlog() throws Exception{
		 Object uid=getSession("id");
		 if(uid==null){
			 
			 msg="login";
		   return "transportBlog";
		 }
		 msg="ok";
		
		 return "transportBlog";
	 }
	 
	 
	 
	 
	public String  zhuanzai() throws Exception{
		
		
		 Object uid=getSession("id");
		 Blog oldblog=blogService.findById(id);
		 Blog blog=new Blog();
		 BeanUtils.copyProperties(blog, oldblog);
		 
		 
		 User user=new User();
		 user.setId(Integer.parseInt(uid.toString()));
		 blog.setBlogName("(转)"+blog.getBlogName());
		 blog.setUser(user);
		 blog.setBlogId(null);
		 BlogCat blogCat=new BlogCat();
		 blogCat.setId(catId);
		 blog.setBlogCat(blogCat);
		 if(oldblog.getType()==2){
			 blog.setOrigBlog(oldblog.getOrigBlog());
		 }else{			 
			 blog.setOrigBlog(oldblog.getBlogId());
			 blog.setShare(blog.getShare()+1);
			 blog.setType(2);
			 
			 
		 }
		
		 msg="error";
		 if(blogService.save(blog)){
			 msg="ok";
			 Blog blog2=blogService.findById(blog.getOrigBlog());
			 blog2.setShare(blog2.getShare()+1);
			 blogService.update(blog2);
			 
			 DetachedCriteria criteria=DetachedCriteria.forClass(Blog.class);
			 criteria.add(Restrictions.eq("origBlog", blog.getOrigBlog()));
			 List<Blog> blogs=blogService.getblogCatsByDetaCritires(criteria);
			 blogService.updateBich(blogs);
		 }
		
		
		return "zhuanzai";
	}
	 
	 
	 public String findByPager(){
		 Object object=getSession("id");
		 if(object==null){
			 return ""; 
		 }
		 int userId =Integer.parseInt(object.toString());
		super.pager=blogService.findByPager(nowPage, pageSize,userId);
		endPage=super.pager.getLastPageNo();
		
		return "findByPager";
	 }
	 
	 public String findByCatPager(){
		 Object object=getSession("id");
		 if(object==null){
			 return ""; 
		 }
		 int userId =Integer.parseInt(object.toString());
		super.pager=blogService.findByCatPager(nowPage, pageSize,userId,catId);
		endPage=super.pager.getLastPageNo();
		
		return "findByCatPager";
	 }
	 
	 
	 
	 
	 public String updateBlog(){
		 Blog blog=blogService.findById(id);
		 BlogCat blogCat=new BlogCat();
		 blogCat.setId(catId);
		 blog.setBlogCat(blogCat);
		 blog.setBlogContext(blogContext);
		 msg="error";
		 if(blogService.update(blog)){
			 msg="ok";
		 }
		 
		 
		 return "updateBlog";
	 }
	
	
	  public String deleteBlog(){
		  Blog blog=blogService.findById(id);
		  msg="error";
		  if(blogService.delete(blog)){
			  msg="ok";
			  
			  
		  }
		  
		  
		  return "deleteBlog";
	  }
	public String uploadimg() throws IOException{
		try{
		String targetDirectory = ServletActionContext.getServletContext().getRealPath("/view/blog/blogPic");
		
		HttpServletRequest request=super.getRequest();
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	
		System.out.println("=================");
		FileUtils.copyFile(pic, new File(targetDirectory+ "/" + picFileName));
		Thumbnails.of(targetDirectory+"/"+picFileName)
		.size(501,500)
	        .keepAspectRatio(true) //默认是true,按比例缩小
	        .outputFormat("JPEG")
	        .toFile(targetDirectory+"/"+picFileName);
		msg=basePath+"/view/blog/blogPic/"+picFileName;
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		return "uploadimg";
	}





			public String blog(){
				DetachedCriteria criteria=DetachedCriteria.forClass(Blog.class);
				blog=blogService.findById(id);
				//blogService.save(blog);
				if(blog.getOrigBlog()==0){
					criteria.add(Restrictions.eq("origBlog", blog.getBlogId()));
					blog.setHit(blog.getHit()+1);
					blogService.update(blog);
					
					
					
					
				}else{
					criteria.add(Restrictions.eq("origBlog", blog.getOrigBlog()));	
					Blog blog2=blogService.findById(blog.getOrigBlog());
					blog2.setHit(blog2.getHit()+1);
					blogService.update(blog2);
				}
				List<Blog> list=blogService.detaByCritieries(criteria);
				for (Blog blog1 : list) {
					blog1.setHit(blog1.getHit()+1);
					blogService.update(blog1);
					
				}
				
				
				
				
				
				
				
				
				
				
				
				
				return "finByblog";
				
			}


















  
    
	public Blog getBlog() {
				return blog;
			}

			public void setBlog(Blog blog) {
				this.blog = blog;
			}

	public BlogCatService getBlogCatService() {
		return blogCatService;
	}

	public void setBlogCatService(BlogCatService blogCatService) {
		this.blogCatService = blogCatService;
	}

	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public BlogService getBlogService() {
		return blogService;
	}

	public void setBlogService(BlogService blogService) {
		this.blogService = blogService;
	}

	public Object getObject() {
		return object;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public Object getModel() {
		// TODO Auto-generated method stub
		return object;
	}

	public String getBlogName() {
		return blogName;
	}

	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}

	public String getBlogContext() {
		return blogContext;
	}

	public void setBlogContext(String blogContext) {
		this.blogContext = blogContext;
	}

	public File getPic() {
		return pic;
	}

	public void setPic(File pic) {
		this.pic = pic;
	}

	public String getPicFileName() {
		return picFileName;
	}

	public void setPicFileName(String picFileName) {
		this.picFileName = picFileName;
	}

	public String getPicContentType() {
		return picContentType;
	}

	public void setPicContentType(String picContentType) {
		this.picContentType = picContentType;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getMsg1() {
		return msg1;
	}

	public void setMsg1(int msg1) {
		this.msg1 = msg1;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	

}
