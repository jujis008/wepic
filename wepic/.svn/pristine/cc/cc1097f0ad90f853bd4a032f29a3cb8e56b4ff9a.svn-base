package com.wetuo.wepic.core.actions ;
 
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.StringTokenizer;
import java.io.File;
import java.util.*;
import java.text.SimpleDateFormat;
import com.wetuo.wepic.core.beans.LoginHistory;
import com.wetuo.wepic.core.service.LoginHistoryService;
 
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.struts.PageAction;
import com.wetuo.wepic.common.struts.Constants;
import com.wetuo.wepic.common.struts.RegExpression;
 
 
import org.apache.struts2.ServletActionContext;
	import com.wetuo.wepic.core.beans.User;
	import com.wetuo.wepic.core.service.UserService;
public class LoginHistoryAction extends PageAction {
		
	private UserService userService;
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
		
 
 
	/////instantce variable//////
	private static final long serialVersionUID = 1L;
	protected String id = null ; 
 	private LoginHistoryService loginHistoryService;
	protected String loginTime = null ; 
	protected String loginOutTime = null ; 
	protected String username = null; 
	//???????????��????
	public void validate() {
		
		// ?????????
		clearErrorsAndMessages();
		
		// ??????????
		String queryString = getRequestPath();
		if (queryString.indexOf("loginHistoryadd!insert") != -1 || queryString.indexOf("loginHistoryedit!update") != -1) {
		
			if (loginTime == null || loginTime.equals("")) {
				addFieldError("loginTime", "loginTime must be inputed");
			}//end if null
			if (loginOutTime == null || loginOutTime.equals("")) {
				addFieldError("loginOutTime", "loginOutTime must be inputed");
			}//end if null
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
		super.pager = this.getLoginHistoryService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		
		// ?????????
		setSession(Constants.PAGER_LOGINHISTORY, super.pager);
		
		return Constants.LIST_KEY;
		
	}//end init()
	
	
	
	
	public String init_notverify() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// ??????????
		super.pageSize = Constants.pageSize;
		super.pageNo = Constants.pageNo;
		// ???????????
		super.pager = this.getLoginHistoryService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		
		// ?????????
		setSession(Constants.PAGER_LOGINHISTORY, super.pager);
		
		return Constants.LIST_KEY_NOTVERIFY;
		
	}//end init()
		
	public String list() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// ???????????
		super.pager = this.getLoginHistoryService().list(super.getLoginUsername(), super.pageSize, super.pageNo);	
		
		// ?????????
		setSession(Constants.PAGER_LOGINHISTORY, super.pager);
		
		return Constants.LIST_KEY;
		
	}//end list()
	public String list_notverify() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// ???????????
		super.pager = this.getLoginHistoryService().list(super.getLoginUsername(), super.pageSize, super.pageNo);	
		
		// ?????????
		setSession(Constants.PAGER_LOGINHISTORY, super.pager);
		
		return Constants.LIST_KEY_NOTVERIFY;
		
	}//end list()
		
	public String add() throws Exception {
		System.out.println("F2 add getParameter of oneId: "+ServletActionContext.getRequest().getParameter("oneId"));
		
		if(ServletActionContext.getRequest().getParameter("from") != null && ServletActionContext.getRequest().getParameter("from") != ""){
			if(ServletActionContext.getRequest().getParameter("from").indexOf("loginHistory") > -1){
				ServletActionContext.getResponse().sendRedirect("user!init.do");
			}
		}
		ServletActionContext.getRequest().setAttribute("oneId", ServletActionContext.getRequest().getParameter("oneId"));
		// ?????????
		clearErrorsAndMessages();
		
		
		// ?????????
		reset();
		return Constants.ADD_KEY;
	}//end add()
	private void reset() {
		setId(null);
		setLoginTime(null);
		setLoginOutTime(null);
	}//end reset()
		// ?????��??
	private void bean2Form(LoginHistory loginHistory) {
		setId(loginHistory.getId().toString());
		setLoginTime(loginHistory.getLoginTime().toString()      );
		setLoginOutTime(loginHistory.getLoginOutTime().toString()      );
	}//end bean2Form()
	public String edit() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// id???????????
		if (this.getId() == null) {
			saveActionError("loginHistory.message.edit.notexist");
			return Constants.LIST_KEY;
		} else {
			// ???????
			LoginHistory loginHistory = this.getLoginHistoryService().select(Integer.valueOf(id));
			
			// ??????????????
			if (loginHistory == null) {
				saveActionError("loginHistory.message.edit.notexist");
				return Constants.LIST_KEY;
			} else {
				// ?????��??
				bean2Form(loginHistory);
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
		LoginHistory loginHistory = new LoginHistory();
		loginHistory.setLoginTime(java.sql.Timestamp.valueOf(this.getLoginTime() ));
		loginHistory.setLoginOutTime(java.sql.Timestamp.valueOf(this.getLoginOutTime() ));
		String strOneId = ServletActionContext.getRequest().getParameter("oneId");
		System.out.println("F2 insert getParameter  of oneId:"+strOneId);
		User oneInstance = this.getUserService().selectById(Integer.parseInt(strOneId));
		loginHistory.setUser(oneInstance);
		
		nid = this.getLoginHistoryService().insert(loginHistory);
		
		// ?????????????
		Pager pagerSession = (Pager) getSession(Constants.PAGER_LOGINHISTORY);
		if(pagerSession == null){
			//??????????
			super.pageSize = Constants.pageSize;
			super.pageNo = Constants.pageNo;
		}else{
			super.pageSize = pagerSession.getPageSize();
			super.pageNo = pagerSession.getPageNo();
			
		}
		
		//????????????
		super.pager = this.getLoginHistoryService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		
		
		}catch(Exception e){
			saveActionError2(e.toString());
			saveActionMessage2(" Sorry ");
			return Constants.ERROR_KEY;
		}
		
		// ?????????
		if (nid != null) {
			saveActionMessage("loginHistory.message.add.success");
			return Constants.LIST_KEY;
		} else {
			saveActionError("loginHistory.message.add.failed");
			return Constants.ADD_KEY;
		}
	}//end insert()
	public String update() throws Exception {
		// 
		clearErrorsAndMessages();
		
		try{
			// 
			LoginHistory loginHistory = this.getLoginHistoryService().select(new Integer(id));
			loginHistory.setLoginTime(java.sql.Timestamp.valueOf(this.getLoginTime() ));
			loginHistory.setLoginOutTime(java.sql.Timestamp.valueOf(this.getLoginOutTime() ));
		this.getLoginHistoryService().update(loginHistory);
		
		bean2Form(loginHistory);	
		
		// ?????????????
		Pager pagerSession = (Pager) getSession(Constants.PAGER_LOGINHISTORY);
		if(pagerSession == null){
			//??????????
			super.pageSize = Constants.pageSize;
			super.pageNo = Constants.pageNo;
		}else{
			super.pageSize = pagerSession.getPageSize();
			super.pageNo = pagerSession.getPageNo();
			
		}
		
			// ????????????
			super.pager = this.getLoginHistoryService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
			saveActionMessage("loginHistory.message.edit.success");
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
				saveActionError("loginHistory.message.edit.notexist");
			} else {
				// ??????
				this.getLoginHistoryService().delete(Integer.valueOf(id));
				saveActionMessage("loginHistory.message.delete.success");
			}
			
			// ???????????
			super.pager = this.getLoginHistoryService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
			
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
	 
	public LoginHistoryService getLoginHistoryService() {
		return loginHistoryService;
	}
	public void setLoginHistoryService(LoginHistoryService loginHistoryService) {
		this.loginHistoryService = loginHistoryService;
	}
	
	public String getLoginTime(){
		return  loginTime;
	}
	public void  setLoginTime(String loginTime){
		this.loginTime = loginTime ;
	}
	 
	public String getLoginOutTime(){
		return  loginOutTime;
	}
	public void  setLoginOutTime(String loginOutTime){
		this.loginOutTime = loginOutTime ;
	}
	 
	 public String getUsername() {
	 	return username;
	 }
	 public void setUsername(String username) {
	 	this.username = username;
	 }
	 
}//end class
