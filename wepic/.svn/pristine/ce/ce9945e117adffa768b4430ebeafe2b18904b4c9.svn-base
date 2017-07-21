package com.wetuo.wepic.deal.actions ;
 
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.StringTokenizer;
import java.io.File;
import java.util.*;
import java.text.SimpleDateFormat;
import com.wetuo.wepic.deal.beans.BuyHistory;
import com.wetuo.wepic.deal.service.BuyHistoryService;
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.core.service.UserService;
 
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.struts.PageAction;
import com.wetuo.wepic.common.struts.Constants;
import com.wetuo.wepic.common.struts.RegExpression;
 
 
public class BuyHistoryAction extends PageAction {
 
 
	/////instantce variable//////
	private static final long serialVersionUID = 1L;
	protected String id = null ; 
 	private BuyHistoryService buyHistoryService;
	protected String userId = null ;
	private UserService userService;
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	protected String totalMoney = null ; 
	protected String dealCode = null ; 
	protected String status = null ; 
	protected String deliveryTime = null ; 
	protected String invoiceHead = null ; 
	protected String invoiceType = null ; 
	protected String invoiceContent = null ; 
	protected String buyerAssess = null ; 
	protected String username = null; 
	//???????????��????
	public void validate() {
		
		// ?????????
		clearErrorsAndMessages();
		
		// ??????????
		String queryString = getRequestPath();
		if (queryString.indexOf("buyHistoryadd!insert") != -1 || queryString.indexOf("buyHistoryedit!update") != -1) {
		
			if (userId == null || userId.equals("")) {
				addFieldError("userId", "userId must be inputed");
			}//end if null
			if (totalMoney == null || totalMoney.equals("")) {
				addFieldError("totalMoney", "totalMoney must be inputed");
			}//end if null
			if (dealCode == null || dealCode.equals("")) {
				addFieldError("dealCode", "dealCode must be inputed");
			}//end if null
			if (status == null || status.equals("")) {
				addFieldError("status", "status must be inputed");
			}//end if null
			if (deliveryTime == null || deliveryTime.equals("")) {
				addFieldError("deliveryTime", "deliveryTime must be inputed");
			}//end if null
			if (invoiceHead == null || invoiceHead.equals("")) {
				addFieldError("invoiceHead", "invoiceHead must be inputed");
			}//end if null
			if (invoiceType == null || invoiceType.equals("")) {
				addFieldError("invoiceType", "invoiceType must be inputed");
			}//end if null
			if (invoiceContent == null || invoiceContent.equals("")) {
				addFieldError("invoiceContent", "invoiceContent must be inputed");
			}//end if null
			if (buyerAssess == null || buyerAssess.equals("")) {
				addFieldError("buyerAssess", "buyerAssess must be inputed");
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
		}//end if
	}//end validate()
	public String init() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// ??????????
		super.pageSize = Constants.pageSize;
		super.pageNo = Constants.pageNo;
		
		// ???????????
		super.pager = this.getBuyHistoryService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		
		// ?????????
		setSession(Constants.PAGER_BUYHISTORY, super.pager);
		
		return Constants.LIST_KEY;
		
	}//end init()
		
	public String list() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// ???????????
		super.pager = this.getBuyHistoryService().list(super.getLoginUsername(), super.pageSize, super.pageNo);	
		
		// ?????????
		setSession(Constants.PAGER_BUYHISTORY, super.pager);
		
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
		setTotalMoney(null);
		setDealCode(null);
		setStatus(null);
		setDeliveryTime(null);
		setInvoiceHead(null);
		setInvoiceType(null);
		setInvoiceContent(null);
		setBuyerAssess(null);
	}//end reset()
		// ?????��??
	private void bean2Form(BuyHistory buyHistory) {
		setId(buyHistory.getId().toString());
		setUserId(buyHistory.getUser().getId().toString());
		setTotalMoney(new Double(buyHistory.getTotalMoney()).toString());
		setDealCode(buyHistory.getDealCode());
		setStatus(buyHistory.getStatus().toString()      );
		setDeliveryTime(buyHistory.getDeliveryTime().toString()      );
		setInvoiceHead(buyHistory.getInvoiceHead());
		setInvoiceType(buyHistory.getInvoiceType().toString()      );
		setInvoiceContent(buyHistory.getInvoiceContent());
		setBuyerAssess(buyHistory.getBuyerAssess());
	}//end bean2Form()
	public String edit() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// id???????????
		if (this.getId() == null) {
			saveActionError("buyHistory.message.edit.notexist");
			return Constants.LIST_KEY;
		} else {
			// ???????
			BuyHistory buyHistory = this.getBuyHistoryService().select(id); 
			
			// ??????????????
			if (buyHistory == null) {
				saveActionError("buyHistory.message.edit.notexist");
				return Constants.LIST_KEY;
			} else {
				// ?????��??
				bean2Form(buyHistory);
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
		BuyHistory buyHistory = new BuyHistory();
			buyHistory.setUser(this.getUserService().selectById(Integer.parseInt(this.getUserId())));    
			
		buyHistory.setTotalMoney(Double.valueOf(this.getTotalMoney() ));
		buyHistory.setDealCode(this.getDealCode());
		buyHistory.setStatus(Integer.valueOf(this.getStatus() ));
		buyHistory.setDeliveryTime(java.sql.Timestamp.valueOf(this.getDeliveryTime() ));
		buyHistory.setInvoiceHead(this.getInvoiceHead());
		buyHistory.setInvoiceType(Integer.valueOf(this.getInvoiceType() ));
		buyHistory.setInvoiceContent(this.getInvoiceContent());
		buyHistory.setBuyerAssess(this.getBuyerAssess());
		nid = this.getBuyHistoryService().insert(buyHistory);
		
		// ?????????????
		Pager pagerSession = (Pager) getSession(Constants.PAGER_BUYHISTORY);
		if(pagerSession == null){
			//??????????
			super.pageSize = Constants.pageSize;
			super.pageNo = Constants.pageNo;
		}else{
			super.pageSize = pagerSession.getPageSize();
			super.pageNo = pagerSession.getPageNo();
			
		}
		
		//????????????
		super.pager = this.getBuyHistoryService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		
		
		}catch(Exception e){
			saveActionError2(e.toString());
			saveActionMessage2(" Sorry ");
			return Constants.ERROR_KEY;
		}
		
		// ?????????
		if (nid != null) {
			saveActionMessage("buyHistory.message.add.success");
			return Constants.LIST_KEY;
		} else {
			saveActionError("buyHistory.message.add.failed");
			return Constants.ADD_KEY;
		}
	}//end insert()
	public String update() throws Exception {
		// 
		clearErrorsAndMessages();
		
		try{
			// 
			BuyHistory buyHistory = this.getBuyHistoryService().select(new String(id));
//			buyHistory.setUser(userInstance);    
			buyHistory.setUser(this.getUserService().selectById(Integer.parseInt(this.getUserId())));    
			
			buyHistory.setTotalMoney(Double.valueOf(this.getTotalMoney() ));
			buyHistory.setDealCode(this.getDealCode());
			buyHistory.setStatus(Integer.valueOf(this.getStatus() ));
			buyHistory.setDeliveryTime(java.sql.Timestamp.valueOf(this.getDeliveryTime() ));
			buyHistory.setInvoiceHead(this.getInvoiceHead());
			buyHistory.setInvoiceType(Integer.valueOf(this.getInvoiceType() ));
			buyHistory.setInvoiceContent(this.getInvoiceContent());
			buyHistory.setBuyerAssess(this.getBuyerAssess());
		this.getBuyHistoryService().update(buyHistory);
		
		bean2Form(buyHistory);	
		
		// ?????????????
		Pager pagerSession = (Pager) getSession(Constants.PAGER_BUYHISTORY);
		if(pagerSession == null){
			//??????????
			super.pageSize = Constants.pageSize;
			super.pageNo = Constants.pageNo;
		}else{
			super.pageSize = pagerSession.getPageSize();
			super.pageNo = pagerSession.getPageNo();
			
		}
		
			// ????????????
			super.pager = this.getBuyHistoryService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
			saveActionMessage("buyHistory.message.edit.success");
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
				saveActionError("buyHistory.message.edit.notexist");
			} else {
				// ??????
				this.getBuyHistoryService().delete(id);
				saveActionMessage("buyHistory.message.delete.success");
			}
			
			// ???????????
			super.pager = this.getBuyHistoryService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
			
		}catch(Exception e){
			saveActionError2(e.toString());
			saveActionMessage2("Please delete child first");
			return Constants.ERROR_KEY;
		}
		return Constants.LIST_KEY;
		
	}//end delete()
	public String tradeTransport() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		boolean res=false;
		try {
			res=this.getBuyHistoryService().tradeTransport();
			if (res) {
				return Constants.MOVESUCCESS;
			}
		} catch (Exception e) {
			// TODO: handle exception
			
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
	 
	public BuyHistoryService getBuyHistoryService() {
		return buyHistoryService;
	}
	public void setBuyHistoryService(BuyHistoryService buyHistoryService) {
		this.buyHistoryService = buyHistoryService;
	}
	
	public String getUserId(){
		return  userId;
	}
	public void  setUserId(String userId){
		this.userId = userId ;
	}
	 
	public String getTotalMoney(){
		return  totalMoney;
	}
	public void  setTotalMoney(String totalMoney){
		this.totalMoney = totalMoney ;
	}
	 
	public String getDealCode(){
		return  dealCode;
	}
	public void  setDealCode(String dealCode){
		this.dealCode = dealCode ;
	}
	 
	public String getStatus(){
		return  status;
	}
	public void  setStatus(String status){
		this.status = status ;
	}
	 
	public String getDeliveryTime(){
		return  deliveryTime;
	}
	public void  setDeliveryTime(String deliveryTime){
		this.deliveryTime = deliveryTime ;
	}
	 
	public String getInvoiceHead(){
		return  invoiceHead;
	}
	public void  setInvoiceHead(String invoiceHead){
		this.invoiceHead = invoiceHead ;
	}
	 
	public String getInvoiceType(){
		return  invoiceType;
	}
	public void  setInvoiceType(String invoiceType){
		this.invoiceType = invoiceType ;
	}
	 
	public String getInvoiceContent(){
		return  invoiceContent;
	}
	public void  setInvoiceContent(String invoiceContent){
		this.invoiceContent = invoiceContent ;
	}
	 
	public String getBuyerAssess(){
		return  buyerAssess;
	}
	public void  setBuyerAssess(String buyerAssess){
		this.buyerAssess = buyerAssess ;
	}
	 
	 public String getUsername() {
	 	return username;
	 }
	 public void setUsername(String username) {
	 	this.username = username;
	 }
	 
}//end class
