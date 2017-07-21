package com.wetuo.wepic.deal.actions ;
 
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;
import java.io.File;
import java.util.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import com.wetuo.wepic.deal.beans.BidAimPerson;
import com.wetuo.wepic.deal.beans.BidReceiverConfirmChange;
import com.wetuo.wepic.deal.service.BidAimPersonService;
import com.wetuo.wepic.deal.service.BidReceiverConfirmChangeService;
import com.wetuo.wepic.deal.beans.BidResponseInvited;
import com.wetuo.wepic.deal.service.BidResponseInvitedService;
import com.wetuo.wepic.deal.beans.BidResponseInvited;
import com.wetuo.wepic.deal.service.BidResponseInvitedService;
import com.wetuo.wepic.core.beans.SiteConfig;
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.core.service.SiteConfigService;
import com.wetuo.wepic.core.service.UserService;
 
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.struts.PageAction;
import com.wetuo.wepic.common.struts.Constants;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.wetuo.wepic.deal.beans.Bid;
import com.wetuo.wepic.deal.service.BidService;
public class BidReceiverConfirmChangeAction extends PageAction {
		
	private BidService bidService;
	public BidService getBidService() {
		return bidService;
	}
	public void setBidService(BidService bidService) {
		this.bidService = bidService;
	}
    /////instantce variable//////
	private static final long serialVersionUID = 1L;
	protected String id = null ; 
 	private BidReceiverConfirmChangeService bidReceiverConfirmChangeService;
	protected String cancelWorker = null ;
	//private String name=null;
	//private String textarea1=null;
	public BidAimPersonService bidaimpersonService;
	private   BidResponseInvited bidResponseInvitedTo;
	private   BidResponseInvited bidResponseInvitedFrom;
	private String changeName;
	private SiteConfigService configService;
	
	
	public BidResponseInvited getBidResponseInvitedTo() {
		return bidResponseInvitedTo;
	}
	public SiteConfigService getConfigService() {
		return configService;
	}
	public void setConfigService(SiteConfigService configService) {
		this.configService = configService;
	}
	public void setBidResponseInvitedTo(BidResponseInvited bidResponseInvitedTo) {
		this.bidResponseInvitedTo = bidResponseInvitedTo;
	}
	public BidResponseInvited getBidResponseInvitedFrom() {
		return bidResponseInvitedFrom;
	}
	public void setBidResponseInvitedFrom(BidResponseInvited bidResponseInvitedFrom) {
		this.bidResponseInvitedFrom = bidResponseInvitedFrom;
	}
	public String getChangeName() {
		return changeName;
	}
	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}
	public BidAimPersonService getBidaimpersonService() {
		return bidaimpersonService;
	}
	public void setBidaimpersonService(BidAimPersonService bidaimpersonService) {
		this.bidaimpersonService = bidaimpersonService;
	}
	private String aimId;
	
	public String getAimId() {
		return aimId;
	}
	public void setAimId(String aimId) {
		this.aimId = aimId;
	}
	
	private UserService userService;
	
	public String getCancelWorker() {
		return cancelWorker;
	}
	public void setCancelWorker(String cancelWorker) {
		this.cancelWorker = cancelWorker;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	private BidResponseInvitedService bidResponseInvitedService;
	public BidResponseInvitedService getBidResponseInvitedService() {
		return bidResponseInvitedService;
	}
	public void setBidResponseInvitedService(BidResponseInvitedService bidResponseInvitedService) {
		this.bidResponseInvitedService = bidResponseInvitedService;
	}
	
	protected String siteConfigId = null ;
	private SiteConfigService siteConfigService;
	public SiteConfigService getSiteConfigService() {
		return siteConfigService;
	}
	public void setSiteConfigService(SiteConfigService siteConfigService) {
		this.siteConfigService = siteConfigService;
	}
	
	protected String changeTime = null ; 
	protected String changeReason = null ; 
	protected String changeeOpnion = null ; 
	protected String username = null; 
	//???????????��????
	public void validate() {
		
		// ?????????
		clearErrorsAndMessages();
		
		// ??????????
		String queryString = getRequestPath();
		if (queryString.indexOf("bidReceiverConfirmChangeadd!insert") != -1 || queryString.indexOf("bidReceiverConfirmChangeedit!update") != -1) {
		
			
			if (siteConfigId == null || siteConfigId.equals("")) {
				addFieldError("siteConfigId", "siteConfigId must be inputed");
			}//end if null
			if (changeTime == null || changeTime.equals("")) {
				addFieldError("changeTime", "changeTime must be inputed");
			}//end if null
			if (changeReason == null || changeReason.equals("")) {
				addFieldError("changeReason", "changeReason must be inputed");
			}//end if null
			if (changeeOpnion == null || changeeOpnion.equals("")) {
				addFieldError("changeeOpnion", "changeeOpnion must be inputed");
			}//end if null
				
		}//end if
	}//end validate()
	public String init() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// ??????????
		super.pageSize = Constants.pageSize;
		super.pageNo = Constants.pageNo;
		
		// ???????????
		super.pager = this.getBidReceiverConfirmChangeService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		
		// ?????????
		setSession(Constants.PAGER_BIDRECEIVERCONFIRMCHANGE, super.pager);
		
		return Constants.LIST_KEY;
		
	}//end init()
		
	public String list() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// ???????????
		super.pager = this.getBidReceiverConfirmChangeService().list(super.getLoginUsername(), super.pageSize, super.pageNo);	
		
		// ?????????
		setSession(Constants.PAGER_BIDRECEIVERCONFIRMCHANGE, super.pager);
		
		return Constants.LIST_KEY;
		
	}//end list()
		
	public String add() throws Exception {
		System.out.println("F2 add getParameter of oneId: "+ServletActionContext.getRequest().getParameter("oneId"));
		
		if(ServletActionContext.getRequest().getParameter("from") != null && ServletActionContext.getRequest().getParameter("from") != ""){
			if(ServletActionContext.getRequest().getParameter("from").indexOf("bidReceiverConfirmChange") > -1){
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
	
		setSiteConfigId(null);
		setChangeTime(null);
		setChangeReason(null);
		setChangeeOpnion(null);
	}//end reset()
		// ?????��??
	private void bean2Form(BidReceiverConfirmChange bidReceiverConfirmChange) {
		setId(bidReceiverConfirmChange.getId().toString());
		
		setSiteConfigId(bidReceiverConfirmChange.getSiteConfig().getId().toString());
		setChangeTime(bidReceiverConfirmChange.getChangeTime().toString()      );
		setChangeReason(bidReceiverConfirmChange.getChangeReason());
		setChangeeOpnion(bidReceiverConfirmChange.getChangeeOpnion());
	}//end bean2Form()
	public String edit() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// id???????????
		if (this.getId() == null) {
			saveActionError("bidReceiverConfirmChange.message.edit.notexist");
			return Constants.LIST_KEY;
		} else {
			// ???????
			BidReceiverConfirmChange bidReceiverConfirmChange = this.getBidReceiverConfirmChangeService().select(id); 
			
			// ??????????????
			if (bidReceiverConfirmChange == null) {
				saveActionError("bidReceiverConfirmChange.message.edit.notexist");
				return Constants.LIST_KEY;
			} else {
				// ?????��??
				bean2Form(bidReceiverConfirmChange);
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
		BidReceiverConfirmChange bidReceiverConfirmChange = new BidReceiverConfirmChange();
		
//		bidReceiverConfirmChange.setBidResponseInvitedFrom(this.getBidResponseInvitedService().select(this.getBidResponseInvitedFromId()));    
//		bidReceiverConfirmChange.setBidResponseInvitedTo(this.getBidResponseInvitedService().select(this.getBidResponseInvitedToId()));    
		bidReceiverConfirmChange.setSiteConfig(this.getSiteConfigService().select(this.getSiteConfigId())); 
			
		bidReceiverConfirmChange.setChangeTime(java.sql.Timestamp.valueOf(this.getChangeTime() ));
		bidReceiverConfirmChange.setChangeReason(this.getChangeReason());
		bidReceiverConfirmChange.setChangeeOpnion(this.getChangeeOpnion());
		String strOneId = ServletActionContext.getRequest().getParameter("oneId");
		System.out.println("F2 insert getParameter  of oneId:"+strOneId);
		Bid oneInstance = this.getBidService().select(strOneId);
		bidReceiverConfirmChange.setBid(oneInstance);
		
		nid = this.getBidReceiverConfirmChangeService().insert(bidReceiverConfirmChange);
		
		// ?????????????
		Pager pagerSession = (Pager) getSession(Constants.PAGER_BIDRECEIVERCONFIRMCHANGE);
		if(pagerSession == null){
			//??????????
			super.pageSize = Constants.pageSize;
			super.pageNo = Constants.pageNo;
		}else{
			super.pageSize = pagerSession.getPageSize();
			super.pageNo = pagerSession.getPageNo();
			
		}
		
		//????????????
		super.pager = this.getBidReceiverConfirmChangeService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		
		
		}catch(Exception e){
			saveActionError2(e.toString());
			saveActionMessage2(" Sorry ");
			return Constants.ERROR_KEY;
		}
		
		// ?????????
		if (nid != null) {
			saveActionMessage("bidReceiverConfirmChange.message.add.success");
			return Constants.LIST_KEY;
		} else {
			saveActionError("bidReceiverConfirmChange.message.add.failed");
			return Constants.ADD_KEY;
		}
	}//end insert()
	
	
	String changeMesg=null;
	
	public String getChangeMesg() {
		return changeMesg;
	}
	public void setChangeMesg(String changeMesg) {
		this.changeMesg = changeMesg;
	}
	//更换中标者
	//1代表成功
	//2代表失败
	//3代表换人次数
	@JSON(serialize=false)
	public String confirmChangePeople() throws Exception {
		// 
		clearErrorsAndMessages();
		String nid = null ;
		
		try{
			String strOneId = ServletActionContext.getRequest().getParameter("bid");
			Bid oneInstance = this.getBidService().select(strOneId);
			oneInstance.setNumChangeWorker(oneInstance.getNumChangeWorker()+1);
			
			
			 List<SiteConfig> list1=siteConfigService.findAll();
			  SiteConfig config=null;
			 
			  if(list1.size()>0){
				  config=list1.get(list1.size()-1);
			  }else{
				  changeMesg="2";
				  return "chage";
			  }
			  if(oneInstance.getNumChangeWorker()>=config.getLimitChangeWorker()){
				  changeMesg="3";
				  return "chage";
					
				}
			  System.out.println("sssssssssssssssssssss");
		//
		BidReceiverConfirmChange bidReceiverConfirmChange = new BidReceiverConfirmChange();
	    User from= userService.selectById(Integer.parseInt(username));
	   // BidAimPerson aimPerson=bidaimpersonService.select(aimId);
	   int nowpage=1;
	   int pagesize=1000;
	   List<BidResponseInvited> list= this.getBidResponseInvitedService().getConfrim(from,aimId,nowpage,pagesize);
	   for (BidResponseInvited bidResponseInvited : list) {
		   bidResponseInvited.setIsConfirmed(2);
		
		   this.getBidResponseInvitedService().update(bidResponseInvited);
	}
	   BidResponseInvited bidResponseInvitedFrom=null;
		if(list.size()>0){
			bidResponseInvitedFrom=list.get(0);
			
		}
		 User to= userService.selectById(Integer.parseInt(changeName));
		
		  List<BidResponseInvited> list2= this.getBidResponseInvitedService().getConfrim(to,aimId,nowpage,pagesize);
		   for (BidResponseInvited bidResponseInvited : list2) {
			   bidResponseInvited.setIsConfirmed(1);
			   bidResponseInvited.setConfirmedTime(new Timestamp(new Date().getTime()));
			   this.getBidResponseInvitedService().update(bidResponseInvited);
		}
		   BidResponseInvited bidResponseInvitedTo=null;
			if(list2.size()>0){
				bidResponseInvitedTo=list2.get(0);
				
			}
		 
		bidReceiverConfirmChange.setBidResponseInvitedTo(bidResponseInvitedTo); 
	//	bidReceiverConfirmChange.setC
	    bidReceiverConfirmChange.setBidResponseInvitedFrom(bidResponseInvitedFrom);    
		bidReceiverConfirmChange.setSiteConfig(this.getSiteConfigService().select(2+"".trim())); 
			
		bidReceiverConfirmChange.setChangeTime(new Timestamp(new Date().getTime()));
		bidReceiverConfirmChange.setChangeReason(this.getChangeReason());
		bidReceiverConfirmChange.setChangeeOpnion(this.getChangeeOpnion());
	
		
		bidReceiverConfirmChange.setBid(oneInstance);
		
		nid = this.getBidReceiverConfirmChangeService().insert(bidReceiverConfirmChange);
	
		changeMesg="1";
		}catch(Exception e){
			e.printStackTrace();
			changeMesg="2";
			
		}
		return "chage";
		
	}//end insert()
	
	
	public String update() throws Exception {
		// 
		clearErrorsAndMessages();
		
		try{
			// 
			BidReceiverConfirmChange bidReceiverConfirmChange = this.getBidReceiverConfirmChangeService().select(new String(id));
//			bidReceiverConfirmChange.setBidResponseInvited(bidResponseInvitedInstance);    
//			bidReceiverConfirmChange.setBidResponseInvited(bidResponseInvitedInstance);    
//			bidReceiverConfirmChange.setSiteConfig(siteConfigInstance);    
//			bidReceiverConfirmChange.setBidResponseInvitedFrom(this.getBidResponseInvitedService().select(this.getBidResponseInvitedFromId()));    
//			bidReceiverConfirmChange.setBidResponseInvitedTo(this.getBidResponseInvitedService().select(this.getBidResponseInvitedToId()));    
			bidReceiverConfirmChange.setSiteConfig(this.getSiteConfigService().select(this.getSiteConfigId())); 
			
			bidReceiverConfirmChange.setChangeTime(java.sql.Timestamp.valueOf(this.getChangeTime() ));
			bidReceiverConfirmChange.setChangeReason(this.getChangeReason());
			bidReceiverConfirmChange.setChangeeOpnion(this.getChangeeOpnion());
		this.getBidReceiverConfirmChangeService().update(bidReceiverConfirmChange);
		
		bean2Form(bidReceiverConfirmChange);	
		
		// ?????????????
		Pager pagerSession = (Pager) getSession(Constants.PAGER_BIDRECEIVERCONFIRMCHANGE);
		if(pagerSession == null){
			//??????????
			super.pageSize = Constants.pageSize;
			super.pageNo = Constants.pageNo;
		}else{
			super.pageSize = pagerSession.getPageSize();
			super.pageNo = pagerSession.getPageNo();
			
		}
		
			// ????????????
			super.pager = this.getBidReceiverConfirmChangeService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
			saveActionMessage("bidReceiverConfirmChange.message.edit.success");
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
				saveActionError("bidReceiverConfirmChange.message.edit.notexist");
			} else {
				// ??????
				this.getBidReceiverConfirmChangeService().delete(id);
				saveActionMessage("bidReceiverConfirmChange.message.delete.success");
			}
			
			// ???????????
			super.pager = this.getBidReceiverConfirmChangeService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
			
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
	 
	public BidReceiverConfirmChangeService getBidReceiverConfirmChangeService() {
		return bidReceiverConfirmChangeService;
	}
	public void setBidReceiverConfirmChangeService(BidReceiverConfirmChangeService bidReceiverConfirmChangeService) {
		this.bidReceiverConfirmChangeService = bidReceiverConfirmChangeService;
	}
	
	 
	public String getSiteConfigId(){
		return  siteConfigId;
	}
	public void  setSiteConfigId(String siteConfigId){
		this.siteConfigId = siteConfigId ;
	}
	 
	public String getChangeTime(){
		return  changeTime;
	}
	public void  setChangeTime(String changeTime){
		this.changeTime = changeTime ;
	}
	 
	public String getChangeReason(){
		return  changeReason;
	}
	public void  setChangeReason(String changeReason){
		this.changeReason = changeReason ;
	}
	 
	public String getChangeeOpnion(){
		return  changeeOpnion;
	}
	public void  setChangeeOpnion(String changeeOpnion){
		this.changeeOpnion = changeeOpnion ;
	}
	 
	 public String getUsername() {
	 	return username;
	 }
	 public void setUsername(String username) {
	 	this.username = username;
	 }
	
	
	 
}//end class
