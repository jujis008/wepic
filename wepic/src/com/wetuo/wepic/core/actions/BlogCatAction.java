package com.wetuo.wepic.core.actions;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ModelDriven;
import com.wetuo.wepic.common.struts.PageAction;
import com.wetuo.wepic.core.beans.Blog;
import com.wetuo.wepic.core.beans.BlogCat;
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.core.service.BlogCatService;
import com.wetuo.wepic.core.service.BlogService;

@SuppressWarnings("serial")
public class BlogCatAction extends PageAction implements ModelDriven{
	private Object object=null;
	private BlogCatService blogCatService;
    private String msg;
    private int id;
    private BlogCat blogCat;
    private BlogService blogService;
    private int nowPage=1;
    private int pageSize=6;
    private String blogCatName;
    private List<BlogCat> list;
	public BlogCatAction(String className) {
		try{
		object = Class.forName(className).newInstance();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}


	public String saveBlogCat(){
		msg="error";
		BlogCat blogCat=(BlogCat)object;
		blogCat.setBlogCat(blogCatName);
		Object userId=getSession("id");
		if(userId!=null){
			User user=new User();
			user.setId(Integer.parseInt(userId.toString()));
			blogCat.setUser(user);
			if(blogCatService.save(blogCat)){
				msg="ok";
			}
		}else{
			msg="login";
		}
		
		
		return "saveBlogCat";
	}

	public String updateBlocat() throws Exception{
		BlogCat blogCat=blogCatService.findById(id);
	    blogCat.setBlogCat(blogCatName);
	    msg="error";
		if(blogCatService.update(blogCat)){
			msg="ok";		
		}
		return "updateBlocat";
	}
	
	
	public String deleteBlogCat(){
		msg="error";
		BlogCat blogCat=blogCatService.findById(id);
		DetachedCriteria criteria=DetachedCriteria.forClass(Blog.class);
		//criteria.createAlias("blogCat", "blogCat1");  
		criteria.add(Restrictions.eq("blogCat", blogCat));
		List<Blog> blogs=blogService.detaByCritieries(criteria);
		for (Blog blog : blogs) {
			blogService.delete(blog);
		}
		if(blogCatService.delete(blogCat)){
			msg="ok";
		}
		
		
		
		return "deleteBlogCat";
	}
	public String findById(){
		
	 blogCat=blogCatService.findById(id);
		
		
	return "findById";	
		
	}
	
	
	public String findByPagerBlogCat(){
		
		Object object=super.getSession("id");
		msg="login";
		if(object!=null){
			int userId=Integer.parseInt(object.toString());
			super.pager=blogCatService.findByPagerBlogCat(nowPage, 6,userId);
			msg="ok";
		}
		
		return "findByPagerBlogCat";
	}
	
	
	
	
	
	public String findAllCat(){
		Object userId=getSession("id");
		msg="login";
		if(userId!=null){
			int id=Integer.parseInt(userId.toString());
			User user=new User();
			user.setId(id);
			DetachedCriteria criteria=DetachedCriteria.forClass(BlogCat.class);
			criteria.add(Restrictions.eq("user", user));
		    list=blogCatService.getblogCatsByDetaCritires(criteria);
		    msg="ok";
			
		}
		
	     return "findAllCat";
		
	}
	
	
	
	
	
	

	public String getBlogCatName() {
		return blogCatName;
	}


	public void setBlogCatName(String blogCatName) {
		this.blogCatName = blogCatName;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public BlogCat getBlogCat() {
		return blogCat;
	}


	public void setBlogCat(BlogCat blogCat) {
		this.blogCat = blogCat;
	}


	public BlogCatService getBlogCatService() {
		return blogCatService;
	}


	public void setBlogCatService(BlogCatService blogCatService) {
		this.blogCatService = blogCatService;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public Object getModel() {
		// TODO Auto-generated method stub
		return null;
	}


	public BlogService getBlogService() {
		return blogService;
	}


	public void setBlogService(BlogService blogService) {
		this.blogService = blogService;
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


	public List<BlogCat> getList() {
		return list;
	}


	public void setList(List<BlogCat> list) {
		this.list = list;
	}
	
	
	
	

}
