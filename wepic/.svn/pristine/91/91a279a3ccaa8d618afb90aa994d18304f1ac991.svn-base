package com.wetuo.wepic.core.actions ;
 
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;
import java.io.File;
import java.util.*;
import java.text.SimpleDateFormat;
import com.wetuo.wepic.core.beans.UserHistory;
import com.wetuo.wepic.core.service.UserHistoryService;
 
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.struts.PageAction;
import com.wetuo.wepic.common.struts.Constants;
import com.wetuo.wepic.common.struts.RegExpression;
 
 
import org.apache.struts2.ServletActionContext;
	import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.core.service.UserService;
import com.sms.util.SendSMS;
public class UserHistoryAction extends PageAction {
		
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
 	private UserHistoryService userHistoryService;
	protected String residenceAddress = null ; 
	protected String livingAddress = null ; 
	protected String job = null ; 
	protected String startTime = null ; 
	protected String endTime = null ; 
	protected String mobile = null ; 
	protected String phone = null ; 
	protected String deliveryPlace = null ; 
	protected String username = null; 
	//???????????��????
	public void validate() {
		
		// ?????????
		clearErrorsAndMessages();
		
		// ??????????
		String queryString = getRequestPath();
		if (queryString.indexOf("userHistoryadd!insert") != -1 || queryString.indexOf("userHistoryedit!update") != -1) {
		
			if (residenceAddress == null || residenceAddress.equals("")) {
				addFieldError("residenceAddress", "residenceAddress must be inputed");
			}//end if null
			if (livingAddress == null || livingAddress.equals("")) {
				addFieldError("livingAddress", "livingAddress must be inputed");
			}//end if null
			if (job == null || job.equals("")) {
				addFieldError("job", "job must be inputed");
			}//end if null
			if (startTime == null || startTime.equals("")) {
				addFieldError("startTime", "startTime must be inputed");
			}//end if null
			if (endTime == null || endTime.equals("")) {
				addFieldError("endTime", "endTime must be inputed");
			}//end if null
			if (mobile == null || mobile.equals("")) {
				addFieldError("mobile", "mobile must be inputed");
			}//end if null
			if (phone == null || phone.equals("")) {
				addFieldError("phone", "phone must be inputed");
			}//end if null
			if (deliveryPlace == null || deliveryPlace.equals("")) {
				addFieldError("deliveryPlace", "deliveryPlace must be inputed");
			}//end if null
				// ??????? 
				// ??????? 
				// ??????? 
				// ??????? 
				// ??????? 
				// ??????? 
				// ??????? 
				// ??????? 
			if (mobile != null && !mobile.equals("")) {
				Pattern p_mobile = Pattern.compile(RegExpression.REG_mobile);
				Matcher m_mobile = p_mobile.matcher(mobile);
				if (!m_mobile.find()) {
					addFieldError("mobile", getText("userHistory.error.mobile"));
				}
			}
				// ??????? 
				// ??????? 
		}//end if
	}//end validate()
	public String init() throws Exception {
		clearErrorsAndMessages();
		super.pageSize = Constants.pageSize;
		super.pageNo = Constants.pageNo;
		super.pager = this.getUserHistoryService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		//setSession(Constants.PAGER_USERHISTORY, super.pager);
		return Constants.LIST_KEY;
	}//end init()
		
	public String list() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// ???????????
		super.pager = this.getUserHistoryService().list(super.getLoginUsername(), super.pageSize, super.pageNo);	
		
		// ?????????
		setSession(Constants.PAGER_USERHISTORY, super.pager);
		
		return Constants.LIST_KEY;
		
	}//end list()
		
	public String add() throws Exception {
		System.out.println("F2 add getParameter of oneId: "+ServletActionContext.getRequest().getParameter("oneId"));
		
		if(ServletActionContext.getRequest().getParameter("from") != null && ServletActionContext.getRequest().getParameter("from") != ""){
			if(ServletActionContext.getRequest().getParameter("from").indexOf("userHistory") > -1){
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
		setResidenceAddress(null);
		setLivingAddress(null);
		setJob(null);
		setStartTime(null);
		setEndTime(null);
		setMobile(null);
		setPhone(null);
		setDeliveryPlace(null);
	}//end reset()
		// ?????��??
	private void bean2Form(UserHistory userHistory) {
		setId(userHistory.getId().toString());
		setResidenceAddress(userHistory.getResidenceAddress());
		setLivingAddress(userHistory.getLivingAddress());
		setJob(userHistory.getJob());
		setStartTime(userHistory.getStartTime().toString()      );
		setEndTime(userHistory.getEndTime().toString()      );
		setMobile(userHistory.getMobile().toString()      );
		setPhone(userHistory.getPhone().toString()      );
		setDeliveryPlace(userHistory.getDeliveryPlace());
	}//end bean2Form()
	public String edit() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// id???????????
		if (this.getId() == null) {
			saveActionError("userHistory.message.edit.notexist");
			return Constants.LIST_KEY;
		} else {
			// ???????
			UserHistory userHistory = this.getUserHistoryService().select(Integer.valueOf(id));
			
			// ??????????????
			if (userHistory == null) {
				saveActionError("userHistory.message.edit.notexist");
				return Constants.LIST_KEY;
			} else {
				// ?????��??
				bean2Form(userHistory);
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
		UserHistory userHistory = new UserHistory();
		userHistory.setResidenceAddress(this.getResidenceAddress());
		userHistory.setLivingAddress(this.getLivingAddress());
		userHistory.setJob(this.getJob());
		userHistory.setStartTime(java.sql.Date.valueOf(this.getStartTime() ));
		userHistory.setEndTime(java.sql.Date.valueOf(this.getEndTime() ));
		userHistory.setMobile(Integer.valueOf(this.getMobile() ));
		userHistory.setPhone(Integer.valueOf(this.getPhone() ));
		userHistory.setDeliveryPlace(this.getDeliveryPlace());
		String strOneId = ServletActionContext.getRequest().getParameter("oneId");
		System.out.println("F2 insert getParameter  of oneId:"+strOneId);
		User oneInstance = this.getUserService().selectById(Integer.parseInt(strOneId));
		userHistory.setUser(oneInstance);
		
		nid = this.getUserHistoryService().insert(userHistory);
		
		// ?????????????
		Pager pagerSession = (Pager) getSession(Constants.PAGER_USERHISTORY);
		if(pagerSession == null){
			//??????????
			super.pageSize = Constants.pageSize;
			super.pageNo = Constants.pageNo;
		}else{
			super.pageSize = pagerSession.getPageSize();
			super.pageNo = pagerSession.getPageNo();
			
		}
		
		//????????????
		super.pager = this.getUserHistoryService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		
		
		}catch(Exception e){
			saveActionError2(e.toString());
			saveActionMessage2(" Sorry ");
			return Constants.ERROR_KEY;
		}
		
		// ?????????
		if (nid != null) {
			saveActionMessage("userHistory.message.add.success");
			return Constants.LIST_KEY;
		} else {
			saveActionError("userHistory.message.add.failed");
			return Constants.ADD_KEY;
		}
	}//end insert()
	public String update() throws Exception {
		// 
		clearErrorsAndMessages();
		
		try{
			// 
			UserHistory userHistory = this.getUserHistoryService().select(new Integer(id));
			userHistory.setResidenceAddress(this.getResidenceAddress());
			userHistory.setLivingAddress(this.getLivingAddress());
			userHistory.setJob(this.getJob());
			userHistory.setStartTime(java.sql.Date.valueOf(this.getStartTime() ));
			userHistory.setEndTime(java.sql.Date.valueOf(this.getEndTime() ));
			userHistory.setMobile(Integer.valueOf(this.getMobile() ));
			userHistory.setPhone(Integer.valueOf(this.getPhone() ));
			userHistory.setDeliveryPlace(this.getDeliveryPlace());
		this.getUserHistoryService().update(userHistory);
		
		bean2Form(userHistory);	
		
		// ?????????????
		Pager pagerSession = (Pager) getSession(Constants.PAGER_USERHISTORY);
		if(pagerSession == null){
			//??????????
			super.pageSize = Constants.pageSize;
			super.pageNo = Constants.pageNo;
		}else{
			super.pageSize = pagerSession.getPageSize();
			super.pageNo = pagerSession.getPageNo();
			
		}
		
			// ????????????
			super.pager = this.getUserHistoryService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
			saveActionMessage("userHistory.message.edit.success");
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
				saveActionError("userHistory.message.edit.notexist");
			} else {
				// ??????
				this.getUserHistoryService().delete(Integer.valueOf(id));
				saveActionMessage("userHistory.message.delete.success");
			}
			
			// ???????????
			super.pager = this.getUserHistoryService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
			
		}catch(Exception e){
			saveActionError2(e.toString());
			saveActionMessage2("Please delete child first");
			return Constants.ERROR_KEY;
		}
		return Constants.LIST_KEY;
		
	}//end delete()
	private Integer flag;
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	private String telNumber;
	public String getTelNumber() {
		return telNumber;
	}
	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}
	public String mytest() {
		SendSMS ss = new SendSMS();
		ss.setUsername("639198");
		ss.setPassword("8df7ed01c3e41c43cbd9d9df75eb99c3");
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String current=simpleDateFormat.format(new Date());
		ss.setMessage(current);
		ss.setMobiles(telNumber);
		ss.setServicesRequestAddRess("http://sms.c8686.com/Api/BayouSmsApiEx.aspx");
		ss.setSmstype(0);
		ss.setTimerid("0");
		ss.setTimertype(0);
		Map<String, String> map = ss.sendSMS();
		flag=Integer.valueOf(map.get("errorcode").toString());
		return "hhxtest";
	}

	/////getter////setter//////
	public String getId(){
		return  id;
	}
	public void  setId(String id){
		this.id = id ;
	}
	 
	public UserHistoryService getUserHistoryService() {
		return userHistoryService;
	}
	public void setUserHistoryService(UserHistoryService userHistoryService) {
		this.userHistoryService = userHistoryService;
	}
	
	public String getResidenceAddress(){
		return  residenceAddress;
	}
	public void  setResidenceAddress(String residenceAddress){
		this.residenceAddress = residenceAddress ;
	}
	 
	public String getLivingAddress(){
		return  livingAddress;
	}
	public void  setLivingAddress(String livingAddress){
		this.livingAddress = livingAddress ;
	}
	 
	public String getJob(){
		return  job;
	}
	public void  setJob(String job){
		this.job = job ;
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
	 
	public String getMobile(){
		return  mobile;
	}
	public void  setMobile(String mobile){
		this.mobile = mobile ;
	}
	 
	public String getPhone(){
		return  phone;
	}
	public void  setPhone(String phone){
		this.phone = phone ;
	}
	 
	public String getDeliveryPlace(){
		return  deliveryPlace;
	}
	public void  setDeliveryPlace(String deliveryPlace){
		this.deliveryPlace = deliveryPlace ;
	}
	 
	 public String getUsername() {
	 	return username;
	 }
	 public void setUsername(String username) {
	 	this.username = username;
	 }
	 
}//end class
