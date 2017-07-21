package com.wetuo.wepic.core.actions ;
 
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Date;
import java.util.StringTokenizer;
import java.io.File;
import java.util.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.faces.application.Application;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.context.ApplicationContext;

import com.wetuo.wepic.core.beans.Contact;
import com.wetuo.wepic.core.service.ContactService;
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.core.service.UserService;
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.core.service.UserService;
 
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.struts.PageAction;
import com.wetuo.wepic.common.struts.Constants;
import com.wetuo.wepic.common.struts.RegExpression;
 
 
public class ContactAction extends PageAction {
	/////instantce variable//////
	private static final long serialVersionUID = 1L;
	private String id = null ; 
 	private ContactService contactService;
 	private String fromUserId = null ;
	private Contact contact=null;
	private List<List> resultList=null;
	private int pageSize;
	private int pageNo=1;
	private User currentUser;
	private String loginUser;
	
	
	public String getLoginUser() {
		return loginUser;
	}
	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}
	public User getCurrentUser() {
		return currentUser;
	}
	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public List<List> getResultList() {
		return resultList;
	}
	public void setResultList(List<List> resultList) {
		this.resultList = resultList;
	}
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}

	private UserService userService;
	private String res;
	
	public String getRes() {
		return res;
	}
	public void setRes(String res) {
		this.res = res;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	private String toUserId = null ;
	
	
	private String action = null ; 
	private String accept = null ; 
	private String startTime = null ; 
	private String acceptTime = null ; 
	private String each = null ; 
	public String getEach() {
		return each;
	}
	public void setEach(String each) {
		this.each = each;
	}

	private String username = null; 
	
	/**
	 * 查找所有已关注用户
	 * @return
	 */
	@JSON(serialize=false)
	public String attentionList(){
		loginUser=super.getLoginUsername();
		User user=this.getUserService().selectById(Integer.parseInt(fromUserId));
		username=user.getUsername();
		System.out.println(pageNo+"******");
		
		resultList=contactService.findAttentionList(user,pageSize, pageNo);
		this.pager=new Pager(pageSize,pageNo,resultList.get(0).size(),resultList.get(0));
		//System.out.println(this.pager.getPageNo()+"&&&&&&&&&&&&&&&&&");
//		System.out.println("out attentionList");
		
		return "attentionList";
	}
	/**
	 * 查找粉丝列表
	 * @return
	 */
	@JSON(serialize=false)
	public String fansList(){
		loginUser=super.getLoginUsername();
		//System.out.println("进入到了fansList中");
		User user=this.getUserService().selectById(Integer.parseInt(fromUserId));
		
		username=user.getUsername();
		resultList=contactService.findFansList(user,pageSize, pageNo);

		this.pager=new Pager(pageSize,pageNo,resultList.get(0).size(),resultList.get(0));
		return "fansList";
	}
	/**
	 * 查找未关注用户
	 * @return
	 */
	public String inattentionList(){
		System.out.println("in inattentionList()");
		User user=this.getUserService().select(super.getLoginUsername());
		super.pager=contactService.findInattentionList(user,super.pageSize,super.pageNo);
		System.out.println(pager.getResultList().size()+"**************");
		System.out.println("out inattentionList");
		return "inattentionList";
	}

	/**
	 * 添加新的关注
	 * @return
	 */
	@JSON(serialize=false)
	public String addNewAttention(){
		User fromUser=userService.select(super.getLoginUsername());
		if(fromUser==null){
			res="3";
		}else if(fromUser.getId().intValue()==Integer.parseInt(toUserId)){
			res="4";
		}else{
			User toUser=userService.selectById(Integer.parseInt(toUserId));
			contact=contactService.addNewAttention(fromUser,toUser);
			System.out.println(contact+"(((((((");
			if(contact.getEachAttention()==1){
				res="2";
			}else{
				res=contact.getAction().intValue()+"";
				System.out.println(res+"&&&&&********");
			}
		}
		return "addNewAttention";
	}
	/**
	 * 取消关注
	 * @return
	 */
	@JSON(serialize=false)
	public String cancelAttention(){
		System.out.println(toUserId+"}}}}}}}}}}");
		User fromUser=userService.select(super.getLoginUsername());
		if(fromUser==null){
			res="3";
		}else{
		User toUser=userService.selectById(Integer.parseInt(toUserId));
		contactService.cancelAttention(fromUser,toUser);
		res="0";
		}
		return "cancelAttention";
	}
	/**
	 * 添加关注
	 * @return
	 */
	public String addAttention(){
		User fromUser=userService.select(super.getLoginUsername());
		User toUser=userService.selectById(Integer.parseInt(toUserId));
		Contact contact=new Contact();
		contact.setFromUser(fromUser);
		contact.setToUser(toUser);
		contact.setAction(1);
		contact.setStartTime(getcurrent());
		contactService.insert(contact);
		return "addAttention";
	}
	/**
	 * 查找用户的好友列表
	 * @return
	 */
	public String findFriend(){
		username=super.getLoginUsername();
		User user=userService.select(username);
		pager=contactService.findFriendList(user, super.pageSize, super.pageNo);
		return "findFriend";
	}
	/**
	 * 查找好友申请
	 * @return
	 */
	public String findFriendApply(){
		System.out.println("进入 findFriendApply()");
		User fromUser=userService.select(super.getLoginUsername());
		System.out.println("^^^^^^^^^^^^^^^^^^^^");
		pager=contactService.findFriendApplyList(fromUser, super.pageSize, super.pageNo);
		return "findFriendApply";
	}
	/**
	 * 查找好友邀请
	 * @return
	 */
	public String findFriendBeApply(){
		User toUser=userService.select(super.getLoginUsername());
		pager=contactService.findBeApplyFriendList(toUser, super.pageSize, super.pageNo);
		return "findFriendBeApply";
	}
	/**
	 * 查找未被邀请或申请的用户
	 * @return
	 */
	public String findNotFriend(){
		User fromUser=userService.select(super.getLoginUsername());
		pager=contactService.findNotFriendList(fromUser, super.pageSize, super.pageNo);
		return "findNotFriend";
	}
	/**
	 * 申请好友
	 * @return
	 */
	public String applyFriend(){
		User fromUser=userService.select(super.getLoginUsername());
		User toUser=userService.selectById(Integer.parseInt(toUserId));
		System.out.print(toUser+"^^^^^^^^^^^^^^^^^^$$$$$$$$$$$$$$$$$$$$$$$$$");
		Contact contact=new Contact();
		contact.setFromUser(fromUser);
		contact.setToUser(toUser);
		contact.setAction(2);
		contact.setStartTime(getcurrent());
		contact.setAccept(0);
		contactService.insert(contact);
		return "applyFriend";
	}
	/**
	 * 是否接受邀请
	 * @return
	 */
	public String acceptApply(){
		Contact contact=contactService.select(Integer.parseInt(id));
		contact.setAcceptTime(getcurrent());
		contact.setAccept(Integer.parseInt(accept));
		contactService.update(contact);
		return "acceptApply";
	}
	//???????????��????
	public void validate() {
		
		// ?????????
		clearErrorsAndMessages();
		
		// ??????????
		String queryString = getRequestPath();
		if (queryString.indexOf("contactadd!insert") != -1 || queryString.indexOf("contactedit!update") != -1) {
		
//			if (userId == null || userId.equals("")) {
//				addFieldError("userId", "userId must be inputed");
//			}//end if null
//			if (userId == null || userId.equals("")) {
//				addFieldError("userId", "userId must be inputed");
//			}//end if null
//			if (user == null || user.equals("")) {
//				addFieldError("User", "User must be inputed");
//			}//end if null
			if (accept == null || accept.equals("")) {
				addFieldError("accept", "accept must be inputed");
			}//end if null
			if (startTime == null || startTime.equals("")) {
				addFieldError("startTime", "startTime must be inputed");
			}//end if null
			if (acceptTime == null || acceptTime.equals("")) {
				addFieldError("acceptTime", "acceptTime must be inputed");
			}//end if null
				// ??????? 
				// ??????? 
				// ??????? 
				// ??????? 
				// ??????? 
				// ??????? 
		}//end if
	}//end validate()
	public String init() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// ??????????
		super.pageSize = Constants.pageSize;
		super.pageNo = Constants.pageNo;
		
		// ???????????
		super.pager = this.getContactService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		
		// ?????????
		setSession(Constants.PAGER_CONTACT, super.pager);
		
		return Constants.LIST_KEY;
		
	}//end init()
	public String initAdmin() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// ??????????
		super.pageSize = Constants.pageSize;
		super.pageNo = Constants.pageNo;
		
		// ???????????
		super.pager = this.getContactService().list(super.pageSize, super.pageNo);
		
		// ?????????
		setSession(Constants.PAGER_CONTACT, super.pager);
		
		return Constants.ADMINLIST_KEY;
		
	}//end init()
		
	public String list() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// ???????????
		super.pager = this.getContactService().list(super.getLoginUsername(), super.pageSize, super.pageNo);	
		
		// ?????????
		setSession(Constants.PAGER_CONTACT, super.pager);
		
		return Constants.LIST_KEY;
		
	}//end list()
		
	public String add() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		
		// ?????????
		reset();
		return Constants.ADD_KEY;
	}//end add()
	private void reset() {
		setId(null);
		setFromUserId(null);
		setToUserId(null);
		setAction(null);
		setAccept(null);
		setStartTime(null);
		setAcceptTime(null);
	}//end reset()
		// ?????��??
	private void bean2Form(Contact contact) {
		setId(contact.getId().toString());
		setFromUserId(contact.getFromUser().getId().toString());
		setToUserId(contact.getToUser().getId().toString());
		setAction(contact.getAction().toString()      );
		setAccept(contact.getAccept().toString()      );
		setStartTime(contact.getStartTime().toString()      );
		setAcceptTime(contact.getAcceptTime().toString()      );
	}//end bean2Form()
	public String edit() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// id???????????
		if (this.getId() == null) {
			saveActionError("contact.message.edit.notexist");
			return Constants.LIST_KEY;
		} else {
			// ???????
			Contact contact = this.getContactService().select(Integer.valueOf(id));
			
			// ??????????????
			if (contact == null) {
				saveActionError("contact.message.edit.notexist");
				return Constants.LIST_KEY;
			} else {
				// ?????��??
				bean2Form(contact);
				return Constants.EDIT_KEY;
			}
		}//end if
		
	}//end edit()
		
	public String insert() throws Exception {
		// 
		clearErrorsAndMessages();
		Integer nid = null ;
		
		try{
			
		//
		Contact contact = new Contact();
			contact.setFromUser(this.getUserService().select(this.getFromUserId()));    
			contact.setToUser(this.getUserService().select(this.getToUserId()));    
			
		contact.setAction(Integer.valueOf(this.getAction() ));
		contact.setAccept(Integer.valueOf(this.getAccept() ));
		contact.setStartTime(java.sql.Timestamp.valueOf(this.getStartTime() ));
		contact.setAcceptTime(java.sql.Timestamp.valueOf(this.getAcceptTime() ));
		nid = this.getContactService().insert(contact);
		
		// ?????????????
		Pager pagerSession = (Pager) getSession(Constants.PAGER_CONTACT);
		if(pagerSession == null){
			//??????????
			super.pageSize = Constants.pageSize;
			super.pageNo = Constants.pageNo;
		}else{
			super.pageSize = pagerSession.getPageSize();
			super.pageNo = pagerSession.getPageNo();
			
		}
		
		//????????????
		super.pager = this.getContactService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		
		
		}catch(Exception e){
			saveActionError2(e.toString());
			saveActionMessage2(" Sorry ");
			return Constants.ERROR_KEY;
		}
		
		// ?????????
		if (nid != null) {
			saveActionMessage("contact.message.add.success");
			return Constants.LIST_KEY;
		} else {
			saveActionError("contact.message.add.failed");
			return Constants.ADD_KEY;
		}
	}//end insert()
	public String update() throws Exception {
		// 
		clearErrorsAndMessages();
		
		try{
			// 
			Contact contact = this.getContactService().select(new Integer(id));
//			contact.setUser(userInstance);    
//			contact.setUser(userInstance);
			contact.setFromUser(this.getUserService().select(this.getFromUserId()));    
			contact.setToUser(this.getUserService().select(this.getToUserId()));    
			
			contact.setAction(Integer.valueOf(this.getAction() ));
			contact.setAccept(Integer.valueOf(this.getAccept() ));
			contact.setStartTime(java.sql.Timestamp.valueOf(this.getStartTime() ));
			contact.setAcceptTime(java.sql.Timestamp.valueOf(this.getAcceptTime() ));
		this.getContactService().update(contact);
		
		bean2Form(contact);	
		
		// ?????????????
		Pager pagerSession = (Pager) getSession(Constants.PAGER_CONTACT);
		if(pagerSession == null){
			//??????????
			super.pageSize = Constants.pageSize;
			super.pageNo = Constants.pageNo;
		}else{
			super.pageSize = pagerSession.getPageSize();
			super.pageNo = pagerSession.getPageNo();
			
		}
		
			// ????????????
			super.pager = this.getContactService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
			saveActionMessage("contact.message.edit.success");
		}catch(Exception e){
			saveActionError2(e.toString());
			saveActionMessage2(" Sorry ");
			return Constants.ERROR_KEY;
		}
		
		return Constants.LIST_KEY;
	}//end update() 
	public String delete() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		try{
			// id???????????
			if (this.getId() == null) {
				saveActionError("contact.message.edit.notexist");
			} else {
				// ??????
				this.getContactService().delete(Integer.valueOf(id));
				saveActionMessage("contact.message.delete.success");
			}
			
			// ???????????
			super.pager = this.getContactService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
			
		}catch(Exception e){
			saveActionError2(e.toString());
			saveActionMessage2("Please delete child first");
			return Constants.ERROR_KEY;
		}
		return Constants.LIST_KEY;
		
	}//end delete()
		
 
	/////getter////setter//////
	public String getId(){
		return  id;
	}
	public void  setId(String id){
		this.id = id ;
	}
	 
	public ContactService getContactService() {
		return contactService;
	}
	public void setContactService(ContactService contactService) {
		this.contactService = contactService;
	}
	
	 
	public String getAccept(){
		return  accept;
	}
	public void  setAccept(String accept){
		this.accept = accept ;
	}
	 
	public String getStartTime(){
		return  startTime;
	}
	public void  setStartTime(String startTime){
		this.startTime = startTime ;
	}
	 
	public String getAcceptTime(){
		return  acceptTime;
	}
	public void  setAcceptTime(String acceptTime){
		this.acceptTime = acceptTime ;
	}
	 
	 public String getUsername() {
	 	return username;
	 }
	 public void setUsername(String username) {
	 	this.username = username;
	 }
	public String getFromUserId() {
		return fromUserId;
	}
	public void setFromUserId(String fromUserId) {
		this.fromUserId = fromUserId;
	}
	public String getToUserId() {
		return toUserId;
	}
	public void setToUserId(String toUserId) {
		this.toUserId = toUserId;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	/**
	 * 获得当前的系统时间
	 * @return
	 */
	public Timestamp getcurrent(){
		Timestamp timestamp=new Timestamp(new Date().getTime());
		return timestamp;
	}
	 
	 
}//end class
