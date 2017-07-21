package com.wetuo.wepic.core.actions ;
 
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.StringTokenizer;
import java.io.File;
import java.util.*;
import java.text.SimpleDateFormat;
import com.wetuo.wepic.core.beans.UserCreditHistory;
import com.wetuo.wepic.core.service.UserCreditHistoryService;
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.core.service.UserService;
 
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.struts.PageAction;
import com.wetuo.wepic.common.struts.Constants;
import com.wetuo.wepic.common.struts.RegExpression;
 
 
import org.apache.struts2.ServletActionContext;
	import com.wetuo.wepic.core.beans.User;
	import com.wetuo.wepic.core.service.UserService;
import org.apache.struts2.ServletActionContext;
	import com.wetuo.wepic.core.beans.UserCredit;
	import com.wetuo.wepic.core.service.UserCreditService;
public class UserCreditHistoryAction extends PageAction {
		
	private UserCreditService userCreditService;
	public UserCreditService getUserCreditService() {
		return userCreditService;
	}
	public void setUserCreditService(UserCreditService userCreditService) {
		this.userCreditService = userCreditService;
	}
		
		
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
 	private UserCreditHistoryService userCreditHistoryService;
 	protected String userId = null ;
 	protected String adminId = null ;
	
//	private UserService userService;
//	public UserService getUserService() {
//		return userService;
//	}
//	public void setUserService(UserService userService) {
//		this.userService = userService;
//	}
	
	protected String startTime = null ; 
	protected String endTime = null ; 
	protected String punishReason = null ; 
	protected String punishType = null ; 
	protected String creditRatings = null ; 
	protected String totalCredits = null ; 
	protected String fineMoney = null ; 
	protected String isFineMoneyExecuted = null ; 
	protected String moneyUnit = null ; 
	protected String username = null; 
	//???????????��????
	public void validate() {
		
		// ?????????
		clearErrorsAndMessages();
		
		// ??????????
		String queryString = getRequestPath();
		if (queryString.indexOf("userCreditHistoryadd!insert") != -1 || queryString.indexOf("userCreditHistoryedit!update") != -1) {
		
			if (userId == null || userId.equals("")) {
				addFieldError("userId", "userId must be inputed");
			}//end if null
			if (startTime == null || startTime.equals("")) {
				addFieldError("startTime", "startTime must be inputed");
			}//end if null
			if (endTime == null || endTime.equals("")) {
				addFieldError("endTime", "endTime must be inputed");
			}//end if null
			if (punishReason == null || punishReason.equals("")) {
				addFieldError("punishReason", "punishReason must be inputed");
			}//end if null
			if (punishType == null || punishType.equals("")) {
				addFieldError("punishType", "punishType must be inputed");
			}//end if null
			if (creditRatings == null || creditRatings.equals("")) {
				addFieldError("creditRatings", "creditRatings must be inputed");
			}//end if null
			if (totalCredits == null || totalCredits.equals("")) {
				addFieldError("totalCredits", "totalCredits must be inputed");
			}//end if null
			if (fineMoney == null || fineMoney.equals("")) {
				addFieldError("fineMoney", "fineMoney must be inputed");
			}//end if null
			if (isFineMoneyExecuted == null || isFineMoneyExecuted.equals("")) {
				addFieldError("isFineMoneyExecuted", "isFineMoneyExecuted must be inputed");
			}//end if null
			if (moneyUnit == null || moneyUnit.equals("")) {
				addFieldError("moneyUnit", "moneyUnit must be inputed");
			}//end if null
				// ??????? 
				// ??????? 
				// ??????? 
				// ??????? 
				// ??????? 
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
		super.pager = this.getUserCreditHistoryService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		
		// ?????????
		setSession(Constants.PAGER_USERCREDITHISTORY, super.pager);
		
		return Constants.LIST_KEY;
		
	}//end init()
		
	public String list() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// ???????????
		super.pager = this.getUserCreditHistoryService().list(super.getLoginUsername(), super.pageSize, super.pageNo);	
		
		// ?????????
		setSession(Constants.PAGER_USERCREDITHISTORY, super.pager);
		
		return Constants.LIST_KEY;
		
	}//end list()
		
	public String add() throws Exception {
		System.out.println("F2 add getParameter of oneId: "+ServletActionContext.getRequest().getParameter("oneId"));
		
		if(ServletActionContext.getRequest().getParameter("from") != null && ServletActionContext.getRequest().getParameter("from") != ""){
			if(ServletActionContext.getRequest().getParameter("from").indexOf("userCreditHistory") > -1){
				ServletActionContext.getResponse().sendRedirect("userCredit!init.do");
			}
		}
		ServletActionContext.getRequest().setAttribute("oneId", ServletActionContext.getRequest().getParameter("oneId"));
		System.out.println("F2 add getParameter of oneId: "+ServletActionContext.getRequest().getParameter("oneId"));
		
		if(ServletActionContext.getRequest().getParameter("from") != null && ServletActionContext.getRequest().getParameter("from") != ""){
			if(ServletActionContext.getRequest().getParameter("from").indexOf("userCreditHistory") > -1){
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
		setUserId(null);
		setStartTime(null);
		setEndTime(null);
		setPunishReason(null);
		setPunishType(null);
		setCreditRatings(null);
		setTotalCredits(null);
		setFineMoney(null);
		setIsFineMoneyExecuted(null);
		setMoneyUnit(null);
	}//end reset()
		// ?????��??
	private void bean2Form(UserCreditHistory userCreditHistory) {
		setId(userCreditHistory.getId().toString());
		setUserId(userCreditHistory.getUser().getId().toString());
		setAdminId(userCreditHistory.getAdmin().getId().toString());
		setStartTime(userCreditHistory.getStartTime().toString()      );
		setEndTime(userCreditHistory.getEndTime().toString()      );
		setPunishReason(userCreditHistory.getPunishReason());
		setPunishType(userCreditHistory.getPunishType().toString()      );
//		setCreditRatings(userCreditHistory.getCreditRatings().toString()      );
//		setTotalCredits(userCreditHistory.getTotalCredits().toString()      );
		setFineMoney(userCreditHistory.getFineMoney().toString()      );
		setIsFineMoneyExecuted(userCreditHistory.getIsFineMoneyExecuted().toString()      );
		setMoneyUnit(userCreditHistory.getMoneyUnit());
	}//end bean2Form()
	public String edit() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// id???????????
		if (this.getId() == null) {
			saveActionError("userCreditHistory.message.edit.notexist");
			return Constants.LIST_KEY;
		} else {
			// ???????
			UserCreditHistory userCreditHistory = this.getUserCreditHistoryService().select(Integer.valueOf(id));
			
			// ??????????????
			if (userCreditHistory == null) {
				saveActionError("userCreditHistory.message.edit.notexist");
				return Constants.LIST_KEY;
			} else {
				// ?????��??
				bean2Form(userCreditHistory);
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
		UserCreditHistory userCreditHistory = new UserCreditHistory();
		userCreditHistory.setUser(this.getUserService().select(this.getUserId()));  
		userCreditHistory.setAdmin(this.getUserService().select(this.getAdminId()));  
		
		userCreditHistory.setStartTime(java.sql.Timestamp.valueOf(this.getStartTime() ));
		userCreditHistory.setEndTime(java.sql.Timestamp.valueOf(this.getEndTime() ));
		userCreditHistory.setPunishReason(this.getPunishReason());
		userCreditHistory.setPunishType(Integer.valueOf(this.getPunishType() ));
//		userCreditHistory.setCreditRatings(Integer.valueOf(this.getCreditRatings() ));
//		userCreditHistory.setTotalCredits(Integer.valueOf(this.getTotalCredits() ));
		userCreditHistory.setFineMoney(Integer.valueOf(this.getFineMoney() ));
		userCreditHistory.setIsFineMoneyExecuted(Integer.valueOf(this.getIsFineMoneyExecuted() ));
		userCreditHistory.setMoneyUnit(this.getMoneyUnit());
		String strOneId = ServletActionContext.getRequest().getParameter("oneId");
		System.out.println("F2 insert getParameter  of oneId:"+strOneId);
		User oneInstance = this.getUserService().selectById(Integer.parseInt(strOneId));
		userCreditHistory.setUser(oneInstance);
		
//		String strOneId = ServletActionContext.getRequest().getParameter("oneId");
//		System.out.println("F2 insert getParameter  of oneId:"+strOneId);
//		UserCredit oneInstance = this.getUserCreditService().select(Integer.parseInt(strOneId));
//		userCreditHistory.setUserCredit(oneInstance);
		
		nid = this.getUserCreditHistoryService().insert(userCreditHistory);
		
		Pager pagerSession = (Pager) getSession(Constants.PAGER_USERCREDITHISTORY);
		if(pagerSession == null){
			super.pageSize = Constants.pageSize;
			super.pageNo = Constants.pageNo;
		}else{
			super.pageSize = pagerSession.getPageSize();
			super.pageNo = pagerSession.getPageNo();
			
		}
		
		super.pager = this.getUserCreditHistoryService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		
		
		}catch(Exception e){
			saveActionError2(e.toString());
			saveActionMessage2(" Sorry ");
			return Constants.ERROR_KEY;
		}
		
		if (nid != null) {
			saveActionMessage("userCreditHistory.message.add.success");
			return Constants.LIST_KEY;
		} else {
			saveActionError("userCreditHistory.message.add.failed");
			return Constants.ADD_KEY;
		}
	}//end insert()
	public String update() throws Exception {
		// 
		clearErrorsAndMessages();
		
		try{
			// 
			UserCreditHistory userCreditHistory = this.getUserCreditHistoryService().select(new Integer(id));
			//userCreditHistory.setUser(userInstance);    
			userCreditHistory.setUser(this.getUserService().select(this.getUserId()));  
			userCreditHistory.setAdmin(this.getUserService().select(this.getAdminId()));  
			
			userCreditHistory.setStartTime(java.sql.Timestamp.valueOf(this.getStartTime() ));
			userCreditHistory.setEndTime(java.sql.Timestamp.valueOf(this.getEndTime() ));
			userCreditHistory.setPunishReason(this.getPunishReason());
			userCreditHistory.setPunishType(Integer.valueOf(this.getPunishType() ));
//			userCreditHistory.setCreditRatings(Integer.valueOf(this.getCreditRatings() ));
//			userCreditHistory.setTotalCredits(Integer.valueOf(this.getTotalCredits() ));
			userCreditHistory.setFineMoney(Integer.valueOf(this.getFineMoney() ));
			userCreditHistory.setIsFineMoneyExecuted(Integer.valueOf(this.getIsFineMoneyExecuted() ));
			userCreditHistory.setMoneyUnit(this.getMoneyUnit());
		this.getUserCreditHistoryService().update(userCreditHistory);
		
		bean2Form(userCreditHistory);	
		
		// ?????????????
		Pager pagerSession = (Pager) getSession(Constants.PAGER_USERCREDITHISTORY);
		if(pagerSession == null){
			//??????????
			super.pageSize = Constants.pageSize;
			super.pageNo = Constants.pageNo;
		}else{
			super.pageSize = pagerSession.getPageSize();
			super.pageNo = pagerSession.getPageNo();
			
		}
		
			// ????????????
			super.pager = this.getUserCreditHistoryService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
			saveActionMessage("userCreditHistory.message.edit.success");
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
				saveActionError("userCreditHistory.message.edit.notexist");
			} else {
				// ??????
				this.getUserCreditHistoryService().delete(Integer.valueOf(id));
				saveActionMessage("userCreditHistory.message.delete.success");
			}
			
			// ???????????
			super.pager = this.getUserCreditHistoryService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
			
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
	 
	public UserCreditHistoryService getUserCreditHistoryService() {
		return userCreditHistoryService;
	}
	public void setUserCreditHistoryService(UserCreditHistoryService userCreditHistoryService) {
		this.userCreditHistoryService = userCreditHistoryService;
	}
	
	public String getUserId(){
		return  userId;
	}
	public void  setUserId(String userId){
		this.userId = userId ;
	}
	 
	public String getStartTime(){
		return  startTime;
	}
	public void  setStartTime(String startTime){
		this.startTime = startTime ;
	}
	 
	public String getEndTime(){
		return  endTime;
	}
	public void  setEndTime(String endTime){
		this.endTime = endTime ;
	}
	 
	public String getPunishReason(){
		return  punishReason;
	}
	public void  setPunishReason(String punishReason){
		this.punishReason = punishReason ;
	}
	 
	public String getPunishType(){
		return  punishType;
	}
	public void  setPunishType(String punishType){
		this.punishType = punishType ;
	}
	 
	public String getCreditRatings(){
		return  creditRatings;
	}
	public void  setCreditRatings(String creditRatings){
		this.creditRatings = creditRatings ;
	}
	 
	public String getTotalCredits(){
		return  totalCredits;
	}
	public void  setTotalCredits(String totalCredits){
		this.totalCredits = totalCredits ;
	}
	 
	public String getFineMoney(){
		return  fineMoney;
	}
	public void  setFineMoney(String fineMoney){
		this.fineMoney = fineMoney ;
	}
	 
	public String getIsFineMoneyExecuted(){
		return  isFineMoneyExecuted;
	}
	public void  setIsFineMoneyExecuted(String isFineMoneyExecuted){
		this.isFineMoneyExecuted = isFineMoneyExecuted ;
	}
	 
	public String getMoneyUnit(){
		return  moneyUnit;
	}
	public void  setMoneyUnit(String moneyUnit){
		this.moneyUnit = moneyUnit ;
	}
	 
	 public String getUsername() {
	 	return username;
	 }
	 public void setUsername(String username) {
	 	this.username = username;
	 }
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	 
	 
	 
}//end class
