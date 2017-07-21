package com.wetuo.wepic.core.actions;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.wetuo.wepic.common.struts.PageAction;
import com.wetuo.wepic.core.beans.Blog;
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.core.beans.UserCredit;
import com.wetuo.wepic.core.service.AccountService;
import com.wetuo.wepic.core.service.BlogCatService;
import com.wetuo.wepic.core.service.BlogService;
import com.wetuo.wepic.core.service.ContactService;
import com.wetuo.wepic.core.service.UserCatService;
import com.wetuo.wepic.core.service.UserCreditService;
import com.wetuo.wepic.core.service.UserService;
import com.wetuo.wepic.deal.beans.UserMess;
import com.wetuo.wepic.deal.service.BidService;
import com.wetuo.wepic.publish.service.PublishService;
import com.wetuo.wepic.publish.service.PublishSpecialCatService;

public class ReadOnlySpace extends PageAction{
	private UserService userService;
	private UserCatService userCatService;
	private PublishSpecialCatService publishSpecialCatService;
	private UserCreditService creditService;
	private ContactService contactService;
	private BlogCatService blogCatService;
	private BlogService blogService;
	private int nowPage=1;
	private int pageSize=7;
	private int endPage;
	private int catId;
	private static final long serialVersionUID = 1L;
	private User user ;
	private int id  ; 
    private Blog blog;
	protected String username = null ; 

    
	private AccountService accountService;
	public AccountService getAccountService() {
		return accountService;
	}
    private BidService bidService;
	private PublishService publishService;
	private String role;
	
   

	
	

	 public String userInfoShow2() throws Exception{
		 String name=new String(ServletActionContext.getRequest().getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
		  
				username=name;
			
		 user=userService.select(username);
		  UserCredit userCredit=this.getCreditService().selectByUser(user);
	      int totalMark=(int)userCredit.getTotalMark();
	      int goodRemark=userCredit.getBidGoodRemarkNum();
	      int badRemark=userCredit.getBidBadRemarkNum();
	      int attentionNumber=this.getContactService().findAttentionNumber(user);
	     // int System.out.println(attentionNumber+"******************");
	      int fansNumber=this.getContactService().findFansNumber(user);
	      UserMess userMess=new UserMess();
		  //t userMess.setCredit(userCredit);
		   userMess.setBadRemark(badRemark);
		   userMess.setGoodRemark(goodRemark);
		   userMess.setFansNumber(fansNumber);
		   userMess.setAttentionNumber(attentionNumber);
		   userMess.setTotalMark(totalMark);
		   user.setUserMess(userMess);
			 return "userInfoShow2";
	 }
	 public String userInfoShow()  {
		
	 username=this.getLoginUsername();
	 user=userService.select(super.getLoginUsername());
	  UserCredit userCredit=this.getCreditService().selectByUser(user);
      int totalMark=(int)userCredit.getTotalMark();
      int goodRemark=userCredit.getBidGoodRemarkNum();
      int badRemark=userCredit.getBidBadRemarkNum();
      int attentionNumber=this.getContactService().findAttentionNumber(user);
     // int System.out.println(attentionNumber+"******************");
      int fansNumber=this.getContactService().findFansNumber(user);
      UserMess userMess=new UserMess();
	  //t userMess.setCredit(userCredit);
	   userMess.setBadRemark(badRemark);
	   userMess.setGoodRemark(goodRemark);
	   userMess.setFansNumber(fansNumber);
	   userMess.setAttentionNumber(attentionNumber);
	   userMess.setTotalMark(totalMark);
	   user.setUserMess(userMess);
		 return "userInfoShow";
			
	 }
	 
	 
	 public String readonliyBlogList() throws Exception{
		 String name=ServletActionContext.getRequest().getParameter("name");
//		 new String(target.getBytes("ISO8859_1"), "GBK"); 
		   try {
			username=new String(name.getBytes("iso-8859-1"),"utf-8");
			System.out.println(username);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// username=name;
		User user=userService.select(username); 
		 
		super.pager=blogService.findByPager(nowPage, pageSize,user.getId());
		endPage=super.pager.getLastPageNo();
		 
		 
		 return  "readonliyBlogList";
	 }
	 
	 
	 public String readOnliyFindBuyBlogCat(){
		    String name=ServletActionContext.getRequest().getParameter("name");
		    try {
				username=new String(name.getBytes("iso-8859-1"),"utf-8");
				System.out.println(username);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			User user=userService.select(username); 
			super.pager=blogService.findByCatPager(nowPage, pageSize,user.getId(),catId);
			endPage=super.pager.getLastPageNo();
		 
		 
		 return "readOnliyFindBuyBlogCat";
	 }
	 
	 public String readOnliyFindById(){
		    String name=ServletActionContext.getRequest().getParameter("name");
		    username=name;
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
			
		 
		 
		 
		 
		 
		 return "readOnliyFindById";
	 }
	 
	 
	 
	 
	 
	 public String findByCatlistPage(){
		    String name=ServletActionContext.getRequest().getParameter("name");
		    username=name;
			  try {
				username=new String(name.getBytes("iso-8859-1"),"utf-8");
			   System.out.println(username);
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 user=userService.select(username);
		    
			User user=userService.select(name); 
				super.pager=blogCatService.findByPagerBlogCat(nowPage, pageSize,user.getId());
			
			return "findByCatlistPage";
		 
		 
	 }
	 
	 
	 
	 
	 
	 
	 
		
		public PublishService getPublishService() {
			return publishService;
		}
		public void setPublishService(PublishService publishService) {
			this.publishService = publishService;
		}
		private List<String> menus = new ArrayList<String>();
		
		private String userNameForSpace ;
		
		private List<String> roleList;

		
		
		public BidService getBidService() {
			return bidService;
		}
		public void setBidService(BidService bidService) {
			this.bidService = bidService;
		}
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}

		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		
		
		
		
		public BlogCatService getBlogCatService() {
			return blogCatService;
		}
		public void setBlogCatService(BlogCatService blogCatService) {
			this.blogCatService = blogCatService;
		}
		
		
		public BlogService getBlogService() {
			return blogService;
		}
		public void setBlogService(BlogService blogService) {
			this.blogService = blogService;
		}
		public List<String> getMenus() {
			return menus;
		}
		public void setMenus(List<String> menus) {
			this.menus = menus;
		}
		
		
		public String getUserNameForSpace() {
			return userNameForSpace;
		}
		public void setUserNameForSpace(String userNameForSpace) {
			this.userNameForSpace = userNameForSpace;
		}
		
		public List<String> getRoleList() {
			return roleList;
		}
		public void setRoleList(List<String> roleList) {
			this.roleList = roleList;
		}
		
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		public void setAccountService(AccountService accountService) {
			this.accountService = accountService;
		}
		public UserService getUserService() {
			return userService;
		}
		public void setUserService(UserService userService) {
			this.userService = userService;
		}
	 
	 
		public ContactService getContactService() {
			return contactService;
		}
		public void setContactService(ContactService contactService) {
			this.contactService = contactService;
		}
		public UserCreditService getCreditService() {
			return creditService;
		}
		public void setCreditService(UserCreditService creditService) {
			this.creditService = creditService;
		}
		public PublishSpecialCatService getPublishSpecialCatService() {
			return publishSpecialCatService;
		}
		public void setPublishSpecialCatService(
				PublishSpecialCatService publishSpecialCatService) {
			this.publishSpecialCatService = publishSpecialCatService;
		}
		public UserCatService getUserCatService() {
			return userCatService;
		}
		public void setUserCatService(UserCatService userCatService) {
			this.userCatService = userCatService;
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
		public int getEndPage() {
			return endPage;
		}
		public void setEndPage(int endPage) {
			this.endPage = endPage;
		}
		public int getCatId() {
			return catId;
		}
		public void setCatId(int catId) {
			this.catId = catId;
		}
		public Blog getBlog() {
			return blog;
		}
		public void setBlog(Blog blog) {
			this.blog = blog;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		
	 
}