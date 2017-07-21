package com.wetuo.wepic.deal.actions ;
 
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.StringTokenizer;
import java.io.File;
import java.util.*;
import java.text.SimpleDateFormat;
import com.wetuo.wepic.deal.beans.BuyCommoditiesHistory;
import com.wetuo.wepic.deal.service.BuyCommoditiesHistoryService;
import com.wetuo.wepic.publish.beans.Publish;
import com.wetuo.wepic.publish.service.PublishService;
 
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.struts.PageAction;
import com.wetuo.wepic.common.struts.Constants;
import com.wetuo.wepic.common.struts.RegExpression;
 
 
import org.apache.struts2.ServletActionContext;
	import com.wetuo.wepic.deal.beans.BuyHistory;
	import com.wetuo.wepic.deal.service.BuyHistoryService;
public class BuyCommoditiesHistoryAction extends PageAction {
		
	private BuyHistoryService buyHistoryService;
	public BuyHistoryService getBuyHistoryService() {
		return buyHistoryService;
	}
	public void setBuyHistoryService(BuyHistoryService buyHistoryService) {
		this.buyHistoryService = buyHistoryService;
	}
		
 
 
	/////instantce variable//////
	private static final long serialVersionUID = 1L;
	protected String id = null ; 
 	private BuyCommoditiesHistoryService buyCommoditiesHistoryService;
	protected String publishId = null ;
	private PublishService publishService;
	public PublishService getPublishService() {
		return publishService;
	}
	public void setPublishService(PublishService publishService) {
		this.publishService = publishService;
	}
	
	protected String copyrightOrUsage = null ; 
	protected String amount = null ; 
	protected String startTime = null ; 
	protected String username = null; 
	//???????????��????
	public void validate() {
		
		// ?????????
		clearErrorsAndMessages();
		
		// ??????????
		String queryString = getRequestPath();
		if (queryString.indexOf("buyCommoditiesHistoryadd!insert") != -1 || queryString.indexOf("buyCommoditiesHistoryedit!update") != -1) {
		
			if (publishId == null || publishId.equals("")) {
				addFieldError("publishId", "publishId must be inputed");
			}//end if null
			if (copyrightOrUsage == null || copyrightOrUsage.equals("")) {
				addFieldError("copyrightOrUsage", "copyrightOrUsage must be inputed");
			}//end if null
			if (amount == null || amount.equals("")) {
				addFieldError("amount", "amount must be inputed");
			}//end if null
			if (startTime == null || startTime.equals("")) {
				addFieldError("startTime", "startTime must be inputed");
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
		
		// ??????????
		super.pageSize = Constants.pageSize;
		super.pageNo = Constants.pageNo;
		
		// ???????????
		super.pager = this.getBuyCommoditiesHistoryService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		
		// ?????????
		setSession(Constants.PAGER_BUYCOMMODITIESHISTORY, super.pager);
		
		return Constants.LIST_KEY;
		
	}//end init()
		
	public String list() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// ???????????
		super.pager = this.getBuyCommoditiesHistoryService().list(super.getLoginUsername(), super.pageSize, super.pageNo);	
		
		// ?????????
		setSession(Constants.PAGER_BUYCOMMODITIESHISTORY, super.pager);
		
		return Constants.LIST_KEY;
		
	}//end list()
		
	public String add() throws Exception {
		System.out.println("F2 add getParameter of oneId: "+ServletActionContext.getRequest().getParameter("oneId"));
		
		if(ServletActionContext.getRequest().getParameter("from") != null && ServletActionContext.getRequest().getParameter("from") != ""){
			if(ServletActionContext.getRequest().getParameter("from").indexOf("buyCommoditiesHistory") > -1){
				ServletActionContext.getResponse().sendRedirect("buyHistory!init.do");
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
		setPublishId(null);
		setCopyrightOrUsage(null);
		setAmount(null);
		setStartTime(null);
	}//end reset()
		// ?????��??
	private void bean2Form(BuyCommoditiesHistory buyCommoditiesHistory) {
		setId(buyCommoditiesHistory.getId().toString());
		setPublishId(buyCommoditiesHistory.getPublish().getId().toString());
		setCopyrightOrUsage(buyCommoditiesHistory.getCopyrightOrUsage().toString()      );
		setAmount(buyCommoditiesHistory.getAmount().toString()      );
		setStartTime(buyCommoditiesHistory.getStartTime().toString()      );
	}//end bean2Form()
	public String edit() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// id???????????
		if (this.getId() == null) {
			saveActionError("buyCommoditiesHistory.message.edit.notexist");
			return Constants.LIST_KEY;
		} else {
			// ???????
			BuyCommoditiesHistory buyCommoditiesHistory = this.getBuyCommoditiesHistoryService().select(id); 
			
			// ??????????????
			if (buyCommoditiesHistory == null) {
				saveActionError("buyCommoditiesHistory.message.edit.notexist");
				return Constants.LIST_KEY;
			} else {
				// ?????��??
				bean2Form(buyCommoditiesHistory);
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
		BuyCommoditiesHistory buyCommoditiesHistory = new BuyCommoditiesHistory();
			buyCommoditiesHistory.setPublish(this.getPublishService().select(Integer.parseInt(this.getPublishId())));
			
			
		buyCommoditiesHistory.setCopyrightOrUsage(Integer.valueOf(this.getCopyrightOrUsage() ));
		buyCommoditiesHistory.setAmount(Integer.valueOf(this.getAmount() ));
		buyCommoditiesHistory.setStartTime(java.sql.Timestamp.valueOf(this.getStartTime() ));
		String strOneId = ServletActionContext.getRequest().getParameter("oneId");
		System.out.println("F2 insert getParameter  of oneId:"+strOneId);
		BuyHistory oneInstance = this.getBuyHistoryService().select(strOneId);
		buyCommoditiesHistory.setBuyHistory(oneInstance);
		
		nid = this.getBuyCommoditiesHistoryService().insert(buyCommoditiesHistory);
		
		// ?????????????
		Pager pagerSession = (Pager) getSession(Constants.PAGER_BUYCOMMODITIESHISTORY);
		if(pagerSession == null){
			//??????????
			super.pageSize = Constants.pageSize;
			super.pageNo = Constants.pageNo;
		}else{
			super.pageSize = pagerSession.getPageSize();
			super.pageNo = pagerSession.getPageNo();
			
		}
		
		//????????????
		super.pager = this.getBuyCommoditiesHistoryService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		
		
		}catch(Exception e){
			saveActionError2(e.toString());
			saveActionMessage2(" Sorry ");
			return Constants.ERROR_KEY;
		}
		
		// ?????????
		if (nid != null) {
			saveActionMessage("buyCommoditiesHistory.message.add.success");
			return Constants.LIST_KEY;
		} else {
			saveActionError("buyCommoditiesHistory.message.add.failed");
			return Constants.ADD_KEY;
		}
	}//end insert()
	public String update() throws Exception {
		// 
		clearErrorsAndMessages();
		
		try{
			// 
			BuyCommoditiesHistory buyCommoditiesHistory = this.getBuyCommoditiesHistoryService().select(new String(id));
//			buyCommoditiesHistory.setPublish(publishInstance);    
			buyCommoditiesHistory.setPublish(this.getPublishService().select(Integer.parseInt(this.getPublishId())));
			
			buyCommoditiesHistory.setCopyrightOrUsage(Integer.valueOf(this.getCopyrightOrUsage() ));
			buyCommoditiesHistory.setAmount(Integer.valueOf(this.getAmount() ));
			buyCommoditiesHistory.setStartTime(java.sql.Timestamp.valueOf(this.getStartTime() ));
		this.getBuyCommoditiesHistoryService().update(buyCommoditiesHistory);
		
		bean2Form(buyCommoditiesHistory);	
		
		// ?????????????
		Pager pagerSession = (Pager) getSession(Constants.PAGER_BUYCOMMODITIESHISTORY);
		if(pagerSession == null){
			//??????????
			super.pageSize = Constants.pageSize;
			super.pageNo = Constants.pageNo;
		}else{
			super.pageSize = pagerSession.getPageSize();
			super.pageNo = pagerSession.getPageNo();
			
		}
		
			// ????????????
			super.pager = this.getBuyCommoditiesHistoryService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
			saveActionMessage("buyCommoditiesHistory.message.edit.success");
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
				saveActionError("buyCommoditiesHistory.message.edit.notexist");
			} else {
				// ??????
				this.getBuyCommoditiesHistoryService().delete(id);
				saveActionMessage("buyCommoditiesHistory.message.delete.success");
			}
			
			// ???????????
			super.pager = this.getBuyCommoditiesHistoryService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
			
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
	 
	public BuyCommoditiesHistoryService getBuyCommoditiesHistoryService() {
		return buyCommoditiesHistoryService;
	}
	public void setBuyCommoditiesHistoryService(BuyCommoditiesHistoryService buyCommoditiesHistoryService) {
		this.buyCommoditiesHistoryService = buyCommoditiesHistoryService;
	}
	
	public String getPublishId(){
		return  publishId;
	}
	public void  setPublishId(String publishId){
		this.publishId = publishId ;
	}
	 
	public String getCopyrightOrUsage(){
		return  copyrightOrUsage;
	}
	public void  setCopyrightOrUsage(String copyrightOrUsage){
		this.copyrightOrUsage = copyrightOrUsage ;
	}
	 
	public String getAmount(){
		return  amount;
	}
	public void  setAmount(String amount){
		this.amount = amount ;
	}
	 
	public String getStartTime(){
		return  startTime;
	}
	public void  setStartTime(String startTime){
		this.startTime = startTime ;
	}
	 
	 public String getUsername() {
	 	return username;
	 }
	 public void setUsername(String username) {
	 	this.username = username;
	 }
	 
}//end class
