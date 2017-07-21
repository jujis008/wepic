package com.wetuo.wepic.core.actions ;
 
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Date;
import java.util.StringTokenizer;
import java.io.File;
import java.util.*;
import java.text.SimpleDateFormat;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wetuo.wepic.core.beans.ChatMsg;
import com.wetuo.wepic.core.beans.UserCat;
import com.wetuo.wepic.core.service.ChatMsgService;
import com.wetuo.wepic.core.service.UserCatService;
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.core.service.UserService;
 
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.struts.PageAction;
import com.wetuo.wepic.common.struts.Constants;
import com.wetuo.wepic.common.struts.RegExpression;
 
 
public class ChatMsgAction extends PageAction {
 
 
	/////instantce variable//////
	private static final long serialVersionUID = 1L;
	protected String id = null ; 
 	private ChatMsgService chatMsgService;
	protected String userId = null ;
	private UserService userService;
	
	
	protected String content = null ; 
	protected String chatTime = null ; 
	protected String travler = null ; 
	protected String username = null;
	protected String rand=null;
	protected User user;
	protected UserCat userCat;
	protected UserCatService userCatService;
	protected List<ChatMsg> serverList;
	protected List<ChatMsg> vistorList;
	//???????????��????
	public void validate() {
		// ?????????
		clearErrorsAndMessages();
		
		// ??????????
		String queryString = getRequestPath();
		if (queryString.indexOf("chatMsgadd!insert") != -1 || queryString.indexOf("chatMsgedit!update") != -1) {
		
			if (userId == null || userId.equals("")) {
				addFieldError("userId", "userId must be inputed");
			}//end if null
			if (content == null || content.equals("")) {
				addFieldError("content", "content must be inputed");
			}//end if null
			if (chatTime == null || chatTime.equals("")) {
				addFieldError("chatTime", "chatTime must be inputed");
			}//end if null
			if (travler == null || travler.equals("")) {
				addFieldError("travler", "travler must be inputed");
			}//end if null
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
		//int rand=ActionContext.getContext()
		System.out.println(rand+"********");
		return Constants.INIT_KEY;
//		// ??????????
//		super.pageSize = Constants.pageSize;
//		super.pageNo = Constants.pageNo;
//		
//		// ???????????
//		super.pager = this.getChatMsgService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
//		
//		// ?????????
//		setSession(Constants.PAGER_CHATMSG, super.pager);
//		
//		return Constants.LIST_KEY;
		
	}//end init()
	
    public String server() {
    	Integer nid = null ;
		ChatMsg chatMsg=new ChatMsg();
		chatMsg.setContent(this.getContent().trim());
		rand=ServletActionContext.getRequest().getParameter("rand");
		chatMsg.setTravler(rand);
		user=userService.selectById(28);
		userCat=userService.selectById(28).getUserCat();
		chatMsg.setUser(user);
		chatMsg.setChatTime(java.sql.Time.valueOf(this.getChatTime()));
		nid = this.getChatMsgService().insert(chatMsg);
    	serverList=this.getChatMsgService().listByRand(rand);
		return Constants.CUSTOMER_KEY;
	}
    
    public String vistor() {
    	Integer nid = null ;
		ChatMsg chatMsg=new ChatMsg();
		chatMsg.setContent(this.getContent().trim());
		rand=ServletActionContext.getRequest().getParameter("rand");
		chatMsg.setTravler(rand);
		user=userService.select(rand);
		if (user==null) {
			chatMsg.setUser(null);	
		}else {
			chatMsg.setUser(user);
		}
		chatMsg.setChatTime(java.sql.Time.valueOf(this.getChatTime()));
		nid = this.getChatMsgService().insert(chatMsg);
    	serverList=this.getChatMsgService().listByRand(rand);
		return Constants.TRAVLER_KEY;
	}
	public String CustomerMsg() throws Exception{
		Integer nid = null ;
		ChatMsg chatMsg=new ChatMsg();
		chatMsg.setContent(this.getContent().trim());
		rand=ServletActionContext.getRequest().getParameter("rand");
		chatMsg.setTravler(rand);
		user=userService.selectById(28);
		userCat=userService.selectById(28).getUserCat();
		chatMsg.setUser(user);
		ActionContext.getContext().getSession().put("User",user);
		chatMsg.setChatTime(java.sql.Time.valueOf(this.getChatTime()));
		nid = this.getChatMsgService().insert(chatMsg);
		Pager pagerSession = (Pager) getSession(Constants.PAGER_CHATMSG);
		if(pagerSession == null){
			//??????????
			super.pageSize = Constants.pageSize;
			super.pageNo = Constants.pageNo;
		}else{
			super.pageSize = pagerSession.getPageSize();
			super.pageNo = pagerSession.getPageNo();
		}
		//????????????
		super.pager = this.getChatMsgService().listByRand(super.pageSize, super.pageNo,rand);
		if (nid==null) {
			return ActionSupport.INPUT;
		}else {
			return Constants.CUSTOMER_KEY;	
		}	
	}
	public String TravlerMsg() throws Exception{
		Integer nid = null ;
		ChatMsg chatMsg=new ChatMsg();
		chatMsg.setContent(this.getContent().trim());
		rand=ServletActionContext.getRequest().getParameter("rand");
		chatMsg.setTravler(rand);
		user=userService.select(rand);
		if (user==null) {
			chatMsg.setUser(null);
		}else {
			chatMsg.setUser(user);	
		}
		ActionContext.getContext().getSession().put("User", user);
		chatMsg.setChatTime(java.sql.Time.valueOf(this.getChatTime()));
		nid = this.getChatMsgService().insert(chatMsg);
		Pager pagerSession = (Pager) getSession(Constants.PAGER_CHATMSG);
		if(pagerSession == null){
			//??????????
			super.pageSize = Constants.pageSize;
			super.pageNo = Constants.pageNo;
		}else{
			super.pageSize = pagerSession.getPageSize();
			super.pageNo = pagerSession.getPageNo();
		}
		//????????????
		super.pager = this.getChatMsgService().listByRand(super.pageSize,super.pageNo,rand);
		if (nid==null) {
			return ActionSupport.INPUT;
		}else {
			return Constants.TRAVLER_KEY;	
		}	
	}
	
	public String list() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// ???????????
		super.pager = this.getChatMsgService().list(super.getLoginUsername(), super.pageSize, super.pageNo);	
		
		// ?????????
		setSession(Constants.PAGER_CHATMSG, super.pager);
		
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
		setUserId(null);
		setContent(null);
		setChatTime(null);
		setTravler(null);
	}//end reset()
		// ?????��??
	private void bean2Form(ChatMsg chatMsg) {
		setId(chatMsg.getId().toString());
		setUserId(chatMsg.getUser().getId().toString());
		setContent(chatMsg.getContent());
		setChatTime(chatMsg.getChatTime().toString()      );
		setTravler(chatMsg.getTravler());
	}//end bean2Form()
	public String edit() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// id???????????
		if (this.getId() == null) {
			saveActionError("chatMsg.message.edit.notexist");
			return Constants.LIST_KEY;
		} else {
			// ???????
			ChatMsg chatMsg = this.getChatMsgService().select(Integer.valueOf(id));
			
			// ??????????????
			if (chatMsg == null) {
				saveActionError("chatMsg.message.edit.notexist");
				return Constants.LIST_KEY;
			} else {
				// ?????��??
				bean2Form(chatMsg);
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
	    
		ChatMsg chatMsg = new ChatMsg();
		chatMsg.setUser(this.getUserService().select( this.getUserId()) );    
		chatMsg.setContent(this.getContent());
		chatMsg.setChatTime(java.sql.Time.valueOf(this.getChatTime() ));
		chatMsg.setTravler(this.getTravler());
		nid = this.getChatMsgService().insert(chatMsg);
		Pager pagerSession = (Pager) getSession(Constants.PAGER_CHATMSG);
		if(pagerSession == null){
			//??????????
			super.pageSize = Constants.pageSize;
			super.pageNo = Constants.pageNo;
		}else{
			super.pageSize = pagerSession.getPageSize();
			super.pageNo = pagerSession.getPageNo();
			
		}
		
		//????????????
		super.pager = this.getChatMsgService().list(super.pageSize, super.pageNo);
		
		
		}catch(Exception e){
			saveActionError2(e.toString());
			saveActionMessage2(" Sorry ");
			return Constants.ERROR_KEY;
		}
		
		// ?????????
		if (nid != null) {
			saveActionMessage("chatMsg.message.add.success");
			return Constants.LIST_KEY;
		} else {
			saveActionError("chatMsg.message.add.failed");
			return Constants.ADD_KEY;
		}
	}//end insert()
	public String update() throws Exception {
		// 
		clearErrorsAndMessages();
		
		try{
			// 
			ChatMsg chatMsg = this.getChatMsgService().select(new Integer(id));
			chatMsg.setUser(this.getUserService().select( this.getUserId()) );     
			chatMsg.setContent(this.getContent());
			chatMsg.setChatTime(java.sql.Time.valueOf(this.getChatTime() ));
			chatMsg.setTravler(this.getTravler());
		this.getChatMsgService().update(chatMsg);
		
		bean2Form(chatMsg);	
		
		// ?????????????
		Pager pagerSession = (Pager) getSession(Constants.PAGER_CHATMSG);
		if(pagerSession == null){
			//??????????
			super.pageSize = Constants.pageSize;
			super.pageNo = Constants.pageNo;
		}else{
			super.pageSize = pagerSession.getPageSize();
			super.pageNo = pagerSession.getPageNo();
			
		}
		
			// ????????????
			super.pager = this.getChatMsgService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
			saveActionMessage("chatMsg.message.edit.success");
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
				saveActionError("chatMsg.message.edit.notexist");
			} else {
				// ??????
				this.getChatMsgService().delete(Integer.valueOf(id));
				saveActionMessage("chatMsg.message.delete.success");
			}
			
			// ???????????
			super.pager = this.getChatMsgService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
			
		}catch(Exception e){
			saveActionError2(e.toString());
			saveActionMessage2("Please delete child first");
			return Constants.ERROR_KEY;
		}
		return Constants.LIST_KEY;
		
	}//end delete()
		
 
	/////getter////setter//////
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public String getId(){
		return  id;
	}
	public void  setId(String id){
		this.id = id ;
	}
	 
	public ChatMsgService getChatMsgService() {
		return chatMsgService;
	}
	public void setChatMsgService(ChatMsgService chatMsgService) {
		this.chatMsgService = chatMsgService;
	}
	
	public String getUserId(){
		return  userId;
	}
	public void  setUserId(String userId){
		this.userId = userId ;
	}
	 
	public String getContent(){
		return  content;
	}
	public void  setContent(String content){
		this.content = content ;
	}
	 
	public String getChatTime(){
		SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");//设置日期格式
		chatTime = df.format(new Date()).toString();
		return  chatTime;
	}
	public void  setChatTime(String chatTime){
		this.chatTime = chatTime ;
	}
	 
	public String getTravler(){
		return  travler;
	}
	public void  setTravler(String travler){
		this.travler = travler ;
	}
	 
	 public String getUsername() {
		if (username==null) {
			username=userService.selectById(28).getUsername();
		}
	 	return username;
	 }
	 public void setUsername(String username) {
	 	this.username = username;
	 }
	public String getRand() {
		return rand;
	}
	public void setRand(String rand) {
		this.rand = rand;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public UserCat getUserCat() {
		return userCat;
	}
	public void setUserCat(UserCat userCat) {
		this.userCat = userCat;
	}
	public UserCatService getUserCatService() {
		return userCatService;
	}
	public void setUserCatService(UserCatService userCatService) {
		this.userCatService = userCatService;
	}

	public List<ChatMsg> getServerList() {
		return serverList;
	}

	public void setServerList(List<ChatMsg> serverList) {
		this.serverList = serverList;
	}

	public List<ChatMsg> getVistorList() {
		return vistorList;
	}

	public void setVistorList(List<ChatMsg> vistorList) {
		this.vistorList = vistorList;
	}
}//end class
