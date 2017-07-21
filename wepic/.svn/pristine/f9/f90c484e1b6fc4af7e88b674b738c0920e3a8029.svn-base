package com.wetuo.wepic.core.actions ;
 
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionContext;
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.struts.Constants;
import com.wetuo.wepic.common.struts.PageAction;
import com.wetuo.wepic.common.util.MailSend;
import com.wetuo.wepic.core.beans.Account;
import com.wetuo.wepic.core.beans.AccountWithdraw;
import com.wetuo.wepic.core.beans.Message;
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.core.service.AccountService;
import com.wetuo.wepic.core.service.AccountWithdrawService;
import com.wetuo.wepic.core.service.MessageService;
import com.wetuo.wepic.core.service.UserService;
import com.sun.org.apache.bcel.internal.generic.NEW;
 
 
public class MessageAction extends PageAction {
 
 
	/////instantce variable//////
	private static final long serialVersionUID = 1L;
	protected String id = null ; 
 	private MessageService messageService;
	protected String userId = null ;
	private UserService userService;
	private String msgTxt;
	private int statu;
	private String time;
	private User user;
	private String username;
	//???????????��????
	public String init() throws Exception {
		clearErrorsAndMessages();
		super.pageSize = Constants.pageSize;
		super.pageNo = Constants.pageNo;
		int userId=(Integer)ActionContext.getContext().getSession().get("id");
		User user=userService.selectById(userId);

		super.pager = this.getMessageService().list(user.getUsername(), super.pageSize, super.pageNo);
		setSession(Constants.PAGER_ACCOUNT, super.pager);
		
		return Constants.LIST_KEY;
		
	}//end init()
	
	public String notComplete() throws Exception {
		clearErrorsAndMessages();
		super.pageSize = Constants.pageSize;
		super.pageNo = Constants.pageNo;
		int userId=(Integer)ActionContext.getContext().getSession().get("id");
		User user=userService.selectById(userId);

		super.pager = this.getMessageService().listByStatu(user.getUsername(), super.pageSize, super.pageNo);
		setSession(Constants.PAGER_ACCOUNT, super.pager);
		
		return Constants.LIST_KEY;
		
	}//end init()
	public String notcompletemsg() throws Exception {
		clearErrorsAndMessages();
		super.pageSize = Constants.pageSize;
		super.pageNo = Constants.pageNo;
		int userId=(Integer)ActionContext.getContext().getSession().get("id");
		User user=userService.selectById(userId);

		super.pager = this.getMessageService().listByStatu(user.getUsername(), super.pageSize, super.pageNo);
		setSession(Constants.PAGER_ACCOUNT, super.pager);
		
		return "notcompletemsg";
		
	}//end init()
	public String msgListByName() throws Exception {
		clearErrorsAndMessages();
		String uname=this.getUsername();
		super.pageSize = Constants.pageSize;
		super.pageNo = Constants.pageNo;
		User user=userService.select(uname);

		super.pager = this.getMessageService().list(user.getUsername(), super.pageSize, super.pageNo);
		setSession(Constants.PAGER_ACCOUNT, super.pager);
		
		return Constants.LIST_KEY;
		
	}//end init()
	public String initAdmin() throws Exception {
		clearErrorsAndMessages();
		super.pageSize = Constants.pageSize;
		super.pageNo = Constants.pageNo;
		int userId=(Integer)ActionContext.getContext().getSession().get("id");
		User user=userService.selectById(userId);

		super.pager = this.getMessageService().list(super.pageSize, super.pageNo);
		setSession(Constants.PAGER_ACCOUNT, super.pager);
		
		return Constants.ADMINLIST_KEY;
		
	}//end init()
		
	public String list() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// ???????????
		int userId=(Integer)ActionContext.getContext().getSession().get("id");
		User user=userService.selectById(userId);

		super.pager = this.getMessageService().list(user.getUsername(), super.pageSize, super.pageNo);	
		
		// ?????????
		setSession(Constants.PAGER_ACCOUNT, super.pager);
		
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
		setMsgTxt(null);
		setStatu(0);
		setTime(null);
	}//end reset()
		// ?????��??
	private void bean2Form(Message message) {
		setId(message.getId().toString());
		setUserId(message.getUser().getId().toString());
		
		
		
	}//end bean2Form()
	public String edit() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// id???????????
		if (this.getId() == null) {
			saveActionError("account.message.edit.notexist");
			return Constants.LIST_KEY;
		} else {
			// ???????
			Message message = this.getMessageService().select(Integer.valueOf(id));
			user=message.getUser();
			// ??????????????
			if (message == null) {
				saveActionError("account.message.edit.notexist");
				return Constants.LIST_KEY;
			} else {
				// ?????��??
				bean2Form(message);
				return Constants.EDIT_KEY;
			}
		}//end if
		
	}//end edit()
	public String AccountSave(){
		SimpleDateFormat format=new SimpleDateFormat("yyyyMMddHHmmssSS");
		return format.format(new Date());
	}	
	
	
//	public String insert(){
//		clearErrorsAndMessages();
//		Integer nid = null ;
//		
//		try{
//
//		Message message = new Message();
//		int userId=(Integer)ActionContext.getContext().getSession().get("id");
//		User user=this.getUserService().selectById(userId);
//		message.setUser(user);  
//			
//		account.setAccountID(user.getUsername()+"_"+AccountSave());
//		account.setTotalMoney(new BigDecimal(0));
//		account.setRemainingMoney(new BigDecimal(0));
//		account.setBankAccount(this.getBankAccount());
//		account.setOpeningBank(this.getOpeningBank());
//		nid = this.getAccountService().insert(account);
//		
//		// ?????????????
//		Pager pagerSession = (Pager) getSession(Constants.PAGER_ACCOUNT);
//		if(pagerSession == null){
//			//??????????
//			super.pageSize = Constants.pageSize;
//			super.pageNo = Constants.pageNo;
//		}else{
//			super.pageSize = pagerSession.getPageSize();
//			super.pageNo = pagerSession.getPageNo();
//			
//		}
//		
//		//????????????
//		super.pager = this.getAccountService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
//		
//		
//		}catch(Exception e){
//			saveActionError2(e.toString());
//			saveActionMessage2(" Sorry ");
//			return Constants.ERROR_KEY;
//		}
//		
//		// ?????????
//		if (nid != null) {
//			saveActionMessage("account.message.add.success");
//			return Constants.LIST_KEY;
//		} else {
//			saveActionError("account.message.add.failed");
//		return Constants.ADD_KEY;
//		}
//		
//	}//end insert()
	
	
	
	
//	public String update() throws Exception {
//		// 
//		clearErrorsAndMessages();
//		
//		try{
//			// 
//			Account account = this.getAccountService().select(new Integer(id));  
//			account.setBankAccount(this.getBankAccount());
//			account.setOpeningBank(this.getOpeningBank());
//			account.setBelongBank(this.getBelongBank());
//		this.getAccountService().update(account);
//		
//		bean2Form(account);	
//		
//		// ?????????????
//		Pager pagerSession = (Pager) getSession(Constants.PAGER_ACCOUNT);
//		if(pagerSession == null){
//			//??????????
//			super.pageSize = Constants.pageSize;
//			super.pageNo = Constants.pageNo;
//		}else{
//			super.pageSize = pagerSession.getPageSize();
//			super.pageNo = pagerSession.getPageNo();
//			
//		}
//		
//			// ????????????
//			super.pager = this.getAccountService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
//			saveActionMessage("account.message.edit.success");
//		}catch(Exception e){
//			saveActionError2(e.toString());
//			saveActionMessage2(" Sorry ");
//			return Constants.ERROR_KEY;
//		}
//		
//		return Constants.LIST_KEY;
//	}//end update() 
//	public String delete() throws Exception {
//		// ?????????
//		clearErrorsAndMessages();
//		
//		try{
//			// id???????????
//			if (this.getId() == null) {
//				saveActionError("account.message.edit.notexist");
//			} else {
//				// ??????
//				this.getAccountService().delete(Integer.valueOf(id));
//				saveActionMessage("account.message.delete.success");
//			}
//			
//			// ???????????
//			super.pager = this.getAccountService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
//			
//		}catch(Exception e){
//			saveActionError2(e.toString());
//			saveActionMessage2("Please delete child first");
//			return Constants.ERROR_KEY;
//		}
//		return Constants.LIST_KEY;
//		
//	}//end delete()
	
	/***随机产生数字****/
	public String validateCode(){
		Random random = new Random();
		String result = "";
		for(int i=0;i<6;i++){
			result += String.valueOf(random.nextInt(10));
		}
		return result;
	}
	
	
	
	

	/////getter////setter//////
	public String getId(){
		return  id;
	}
	public void  setId(String id){
		this.id = id ;
	}
	public String getUserId(){
		return  userId;
	}
	public void  setUserId(String userId){
		this.userId = userId ;
	}
	public MessageService getMessageService() {
		return messageService;
	}
	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public String getMsgTxt() {
		return msgTxt;
	}
	public void setMsgTxt(String msgTxt) {
		this.msgTxt = msgTxt;
	}
	public int getStatu() {
		return statu;
	}
	public void setStatu(int statu) {
		this.statu = statu;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
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
	 
	 
}//end class
