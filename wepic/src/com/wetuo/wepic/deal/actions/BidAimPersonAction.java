package com.wetuo.wepic.deal.actions ;
 
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletResponse;

import com.wetuo.wepic.deal.beans.BidAimPerson;
import com.wetuo.wepic.deal.beans.BidResponseInvited;
import com.wetuo.wepic.deal.service.BidAimPersonService;
import com.wetuo.wepic.deal.service.BidResponseInvitedService;
 
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.struts.PageAction;
import com.wetuo.wepic.common.struts.Constants;
import com.wetuo.wepic.common.struts.RegExpression;
import com.wetuo.wepic.core.beans.Message;
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.core.service.MessageService;
import com.wetuo.wepic.core.service.UserService;
 
 
import org.apache.commons.collections.map.HashedMap;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;
import org.json.JSONArray;
import org.json.JSONObject;

	import com.wetuo.wepic.deal.beans.Bid;
import com.wetuo.wepic.deal.service.BidService;
import com.sun.org.apache.bcel.internal.generic.NEW;
public class BidAimPersonAction extends PageAction {
		
	private BidService bidService;
	private UserService userService;
	private MessageService messageService;
	

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
	public BidService getBidService() {
		return bidService;
	}
	public void setBidService(BidService bidService) {
		this.bidService = bidService;
	}
		
 
 
	/////instantce variable//////
	private static final long serialVersionUID = 1L;
	protected String id = null ; 
	private String bidId;
 	private BidAimPersonService bidAimPersonService;
	protected String type = null ; 
	protected String money = null ; 
	protected String startTime = null ; 
	protected String period = null ; 
	protected String publicOrPrivate = null ; 
	protected String demand = null ; 
	protected String username = null; 
	private BidResponseInvitedService bidResponseInvitedService;

	
	
	



	public BidResponseInvitedService getBidResponseInvitedService() {
		return bidResponseInvitedService;
	}
	public void setBidResponseInvitedService(
			BidResponseInvitedService bidResponseInvitedService) {
		this.bidResponseInvitedService = bidResponseInvitedService;
	}



	



	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}



	private int userId;
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getBidId() {
		return bidId;
	}
	public void setBidId(String bidId) {
		this.bidId = bidId;
	}
	public void validate() {
		
		// ?????????
		clearErrorsAndMessages();
		
		// ??????????
		String queryString = getRequestPath();
		if (queryString.indexOf("bidAimPersonadd!insert") != -1 || queryString.indexOf("bidAimPersonedit!update") != -1) {
		
			if (type == null || type.equals("")) {
				addFieldError("type", "type must be inputed");
			}//end if null
			if (money == null || money.equals("")) {
				addFieldError("money", "money must be inputed");
			}//end if null
			if (startTime == null || startTime.equals("")) {
				addFieldError("startTime", "startTime must be inputed");
			}//end if null
			if (period == null || period.equals("")) {
				addFieldError("period", "period must be inputed");
			}//end if null
			if (publicOrPrivate == null || publicOrPrivate.equals("")) {
				addFieldError("publicOrPrivate", "publicOrPrivate must be inputed");
			}//end if null
			if (demand == null || demand.equals("")) {
				addFieldError("demand", "demand must be inputed");
			}//end if null
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
		super.pager = this.getBidAimPersonService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		
		// ?????????
		setSession(Constants.PAGER_BIDAIMPERSON, super.pager);
		
		return Constants.LIST_KEY;
		
	}//end init()
		
	public String list() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// ???????????
		super.pager = this.getBidAimPersonService().list(super.getLoginUsername(), super.pageSize, super.pageNo);	
		
		// ?????????
		setSession(Constants.PAGER_BIDAIMPERSON, super.pager);
		
		return Constants.LIST_KEY;
		
	}//end list()
		
	public String add() throws Exception {
		System.out.println("F2 add getParameter of oneId: "+ServletActionContext.getRequest().getParameter("oneId"));
		
		if(ServletActionContext.getRequest().getParameter("from") != null && ServletActionContext.getRequest().getParameter("from") != ""){
			if(ServletActionContext.getRequest().getParameter("from").indexOf("bidAimPerson") > -1){
				ServletActionContext.getResponse().sendRedirect("bid!init.do");
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
		setType(null);
		setMoney(null);
		setStartTime(null);
		setPeriod(null);
		setPublicOrPrivate(null);
		setDemand(null);
	}//end reset()
		// ?????��??
	private void bean2Form(BidAimPerson bidAimPerson) {
		setId(bidAimPerson.getId().toString());
		setType(bidAimPerson.getType().toString()      );
		setMoney(new Double(bidAimPerson.getMoney()).toString());
		setStartTime(bidAimPerson.getStartTime().toString()      );
		setPeriod(bidAimPerson.getPeriod().toString()      );
		setPublicOrPrivate(bidAimPerson.getPublicOrPrivate().toString()      );
		setDemand(bidAimPerson.getDemand());
	}//end bean2Form()
	public String edit() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// id???????????
		if (this.getId() == null) {
			saveActionError("bidAimPerson.message.edit.notexist");
			return Constants.LIST_KEY;
		} else {
			// ???????
			BidAimPerson bidAimPerson = this.getBidAimPersonService().select(id); 
			
			// ??????????????
			if (bidAimPerson == null) {
				saveActionError("bidAimPerson.message.edit.notexist");
				return Constants.LIST_KEY;
			} else {
				// ?????��??
				bean2Form(bidAimPerson);
				return Constants.EDIT_KEY;
			}
		}//end if
		
	}//end edit()
		
	public String insert() throws Exception {
		// 
		clearErrorsAndMessages();
		String nid = null ;
		
		try{
			
		//
		BidAimPerson bidAimPerson = new BidAimPerson();
		bidAimPerson.setType(Integer.valueOf(this.getType() ));
		bidAimPerson.setMoney(Double.valueOf(this.getMoney() ));
		bidAimPerson.setStartTime(java.sql.Timestamp.valueOf(this.getStartTime() ));
		bidAimPerson.setPeriod(Integer.valueOf(this.getPeriod() ));
		bidAimPerson.setPublicOrPrivate(Integer.valueOf(this.getPublicOrPrivate() ));
		bidAimPerson.setDemand(this.getDemand());
		String strOneId = ServletActionContext.getRequest().getParameter("oneId");
		System.out.println("F2 insert getParameter  of oneId:"+strOneId);
		Bid oneInstance = this.getBidService().select(strOneId);
		bidAimPerson.setBid(oneInstance);
		
		nid = this.getBidAimPersonService().insert(bidAimPerson);
		
		// ?????????????
		Pager pagerSession = (Pager) getSession(Constants.PAGER_BIDAIMPERSON);
		if(pagerSession == null){
			//??????????
			super.pageSize = Constants.pageSize;
			super.pageNo = Constants.pageNo;
		}else{
			super.pageSize = pagerSession.getPageSize();
			super.pageNo = pagerSession.getPageNo();
			
		}
		
		//????????????
		super.pager = this.getBidAimPersonService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		
		
		}catch(Exception e){
			saveActionError2(e.toString());
			saveActionMessage2(" Sorry ");
			return Constants.ERROR_KEY;
		}
		
		// ?????????
		if (nid != null) {
			saveActionMessage("bidAimPerson.message.add.success");
			return Constants.LIST_KEY;
		} else {
			saveActionError("bidAimPerson.message.add.failed");
			return Constants.ADD_KEY;
		}
	}//end insert()
	public String update() throws Exception {
		// 
		clearErrorsAndMessages();
		
		try{
			// 
			BidAimPerson bidAimPerson = this.getBidAimPersonService().select(new String(id));
			bidAimPerson.setType(Integer.valueOf(this.getType() ));
			bidAimPerson.setMoney(Double.valueOf(this.getMoney() ));
			bidAimPerson.setStartTime(java.sql.Timestamp.valueOf(this.getStartTime() ));
			bidAimPerson.setPeriod(Integer.valueOf(this.getPeriod() ));
			bidAimPerson.setPublicOrPrivate(Integer.valueOf(this.getPublicOrPrivate() ));
			bidAimPerson.setDemand(this.getDemand());
		this.getBidAimPersonService().update(bidAimPerson);
		
		bean2Form(bidAimPerson);	
		
		// ?????????????
		Pager pagerSession = (Pager) getSession(Constants.PAGER_BIDAIMPERSON);
		if(pagerSession == null){
			//??????????
			super.pageSize = Constants.pageSize;
			super.pageNo = Constants.pageNo;
		}else{
			super.pageSize = pagerSession.getPageSize();
			super.pageNo = pagerSession.getPageNo();
			
		}
		
			// ????????????
			super.pager = this.getBidAimPersonService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
			saveActionMessage("bidAimPerson.message.edit.success");
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
				saveActionError("bidAimPerson.message.edit.notexist");
			} else {
				// ??????
				this.getBidAimPersonService().delete(id);
				saveActionMessage("bidAimPerson.message.delete.success");
			}
			
			// ???????????
			super.pager = this.getBidAimPersonService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
			
		}catch(Exception e){
			saveActionError2(e.toString());
			saveActionMessage2("Please delete child first");
			return Constants.ERROR_KEY;
		}
		return Constants.LIST_KEY;
		
	}
	@JSON(serialize=false)
	public String inviteBidPerson() throws Exception {
	   
		//String type=super.getRequest().getParameter("type");
		
		clearErrorsAndMessages();
		
		//super.pager = this.getUserService().moelorPotolist(type,  1, super.pageNo,(Integer)super.getSession("id"),id);	
		
	//System.out.println(super.pageNo+"==================================================================");
	//  	setSession(Constants.PAGER_BIDAIMPERSON, super.pager);
		
		return "inviteBidPerson";
		
	}
	private List bidAimList;
	public List getBidAimList() {
		return bidAimList;
	}
	public void setBidAimList(List bidAimList) {
		this.bidAimList = bidAimList;
	}
	@JSON(serialize=false)
	public String allBid() {
		try {
			Bid bid=this.getBidService().select(this.getBidId());
			bidAimList =this.getBidAimPersonService().aimSelect(bid, 300, 1);
			return "allBid";
		} catch (Exception e) {
			e.printStackTrace();
		}
	 return null;
	}
	
	
	
	
//        public String getAimlist() throws IOException{
//        	
//        	   Bid bid=bidService.select(bidId);
//        	
//        	
//        	List<?> list=bidAimPersonService.aimSelect(bid, pageSize, pageNo);
//        	//List<?> list=pager.getResultList();
//        	System.out.println(list.size()+"=====================");
//        	JSONObject root = new JSONObject();
//        	JSONArray jsonArray=new JSONArray();
//        	
//        	for (Object object : list) { 
//            BidAimPerson aimPerson=(BidAimPerson)object;	
//			JSONObject jsonObject=new JSONObject();
//			jsonObject.put("demand", aimPerson.getDemand());
//			jsonObject.put("bidId", aimPerson.getBid());
//			jsonObject.put("id", aimPerson.getId());
//			jsonArray.put(jsonObject);
//			}
//        	root.put("json", jsonArray);
//
//    		HttpServletResponse response = ServletActionContext.getResponse();
//    		response.setCharacterEncoding("GBK");
//    		response.setContentType("text/html");
//    		PrintWriter writer = response.getWriter();
//    		writer.print("sssssssssssssss");
//    		writer.close();
//    		return null;
//        	
//        	
//        } 
//        
//        
	//邀请摄影师
	String result=null;
	@JSON(serialize=false)
	public String resultList(){
		String queryString = getRequestPath();
		System.out.println("queryString :" + queryString);
		User user=userService.selectById(userId);
		Bid bid=bidService.select(bidId);
		BidResponseInvited invited=new BidResponseInvited();
		invited.setBid(bid);
		BidAimPerson bidAimPerson=null;
		if(bid.getType()!=3){
		List bidAimPerson1=bidAimPersonService.aimSelect(bid, 1, 1);
		bidAimPerson=(BidAimPerson)bidAimPerson1.get(0);
		//invited.setBidAimPerson(bidAimPerson);
		}
		invited.setBid(bid);
	//	invited.setReponseMoney(bidAimPerson.getMoney());
		
		invited.setUser(user);
		invited.setInviteTime(new Timestamp(new Date().getTime()));
		invited.setIsInvited(1);
		invited.setIsConfirmed(0);
		invited.setIsResponse(0);
		Message message=new Message();
		//message.setDate(new Date());
		message.setUser(user);
		message.setUserId(userId);
		message.setMsgTxt("您已经被   "+super.getLoginUsername()+"邀请投标  "+bid.getName()+"您可以进入<a style='color:red' target='_blank' href='bid!findbyBidId.do?id="+bid.getId()+"'>受邀信息<a>进行处理");
	    messageService.insert(message);
		if(bid.getType()!=3){
		List<BidResponseInvited> list=this.getBidResponseInvitedService().listConfirm(user, bidAimPerson,200,1);
		if(list.size()>0){
			for (BidResponseInvited bidResponseInvited1 : list) {
				bidResponseInvited1.setInviteTime(new Timestamp(new Date().getTime()));
				this.getBidResponseInvitedService().update(bidResponseInvited1);
			}
			result="exits";
			return "resultList";
			}
	    }
			String uuString=this.getBidResponseInvitedService().insert(invited);
			if(uuString!=null){
				result="ok";
			}
			return "resultList";
		
		
		
		
       }
        
	
	
	
	
	
	public String getId(){
		return  id;
	}
	public void  setId(String id){
		this.id = id ;
	}
	 
	public BidAimPersonService getBidAimPersonService() {
		return bidAimPersonService;
	}
	public void setBidAimPersonService(BidAimPersonService bidAimPersonService) {
		this.bidAimPersonService = bidAimPersonService;
	}
	
	public String getType(){
		return  type;
	}
	public void  setType(String type){
		this.type = type ;
	}
	 
	public String getMoney(){
		return  money;
	}
	public void  setMoney(String money){
		this.money = money ;
	}
	 
	public String getStartTime(){
		return  startTime;
	}
	public void  setStartTime(String startTime){
		this.startTime = startTime ;
	}
	 
	public String getPeriod(){
		return  period;
	}
	public void  setPeriod(String period){
		this.period = period ;
	}
	 
	public String getPublicOrPrivate(){
		return  publicOrPrivate;
	}
	public void  setPublicOrPrivate(String publicOrPrivate){
		this.publicOrPrivate = publicOrPrivate ;
	}
	 
	public String getDemand(){
		return  demand;
	}
	public void  setDemand(String demand){
		this.demand = demand ;
	}
	 
	 public String getUsername() {
	 	return username;
	 }
	 public void setUsername(String username) {
	 	this.username = username;
	 }
	 
}//end class
