package com.wetuo.wepic.deal.actions ;
 
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.io.File;
import java.math.BigDecimal;
import java.util.*;
import java.text.SimpleDateFormat;
import com.wetuo.wepic.deal.beans.BidAccountOperation;
import com.wetuo.wepic.deal.beans.BidResponseInvited;
import com.wetuo.wepic.deal.beans.CountDeal;
import com.wetuo.wepic.deal.service.BidAccountOperationService;
import com.wetuo.wepic.deal.service.BidResponseInvitedService;
import com.wetuo.wepic.core.beans.Account;
import com.wetuo.wepic.core.service.AccountService;
import com.wetuo.wepic.core.beans.SiteConfig;
import com.wetuo.wepic.core.service.SiteConfigService;
 
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.struts.PageAction;
import com.wetuo.wepic.common.struts.Constants;
import com.wetuo.wepic.common.struts.RegExpression;
 
 
import org.apache.struts2.ServletActionContext;
	import com.wetuo.wepic.deal.beans.Bid;
import com.wetuo.wepic.deal.service.BidService;
import com.tools.Cleandar;
public class BidAccountOperationAction extends PageAction {
		
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
 	private BidAccountOperationService bidAccountOperationService;
	protected String accountId = null ;
	private AccountService accountService;
	private BidResponseInvitedService bidResponseInvitedService;
	public AccountService getAccountService() {
		return accountService;
	}
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}
	
	protected String siteConfigId = null ;
	private SiteConfigService siteConfigService;
	public SiteConfigService getSiteConfigService() {
		return siteConfigService;
	}
	public void setSiteConfigService(SiteConfigService siteConfigService) {
		this.siteConfigService = siteConfigService;
	}
	
	protected String lockTime = null ; 
	protected String unlockTime = null ; 
	protected String deductionTime = null ; 
	protected String entryTime = null ; 
	protected String entryMoney = null ; 
	protected String moneyUnit = null ; 
	protected String lockMoney = null ; 
	protected String username = null; 
	//???????????��????
	public void validate() {
		
		// ?????????
		clearErrorsAndMessages();
		
		// ??????????
		String queryString = getRequestPath();
		if (queryString.indexOf("bidAccountOperationadd!insert") != -1 || queryString.indexOf("bidAccountOperationedit!update") != -1) {
		
			if (accountId == null || accountId.equals("")) {
				addFieldError("accountId", "accountId must be inputed");
			}//end if null
			if (siteConfigId == null || siteConfigId.equals("")) {
				addFieldError("siteConfigId", "siteConfigId must be inputed");
			}//end if null
			if (lockTime == null || lockTime.equals("")) {
				addFieldError("lockTime", "lockTime must be inputed");
			}//end if null
			if (unlockTime == null || unlockTime.equals("")) {
				addFieldError("unlockTime", "unlockTime must be inputed");
			}//end if null
			if (deductionTime == null || deductionTime.equals("")) {
				addFieldError("deductionTime", "deductionTime must be inputed");
			}//end if null
			if (entryTime == null || entryTime.equals("")) {
				addFieldError("entryTime", "entryTime must be inputed");
			}//end if null
			if (entryMoney == null || entryMoney.equals("")) {
				addFieldError("entryMoney", "entryMoney must be inputed");
			}//end if null
			if (moneyUnit == null || moneyUnit.equals("")) {
				addFieldError("moneyUnit", "moneyUnit must be inputed");
			}//end if null
			if (lockMoney == null || lockMoney.equals("")) {
				addFieldError("lockMoney", "lockMoney must be inputed");
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
		}//end if
	}//end validate()
	public String init() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// ??????????
		super.pageSize = Constants.pageSize;
		super.pageNo = Constants.pageNo;
		
		// ???????????
		super.pager = this.getBidAccountOperationService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		
		// ?????????
		setSession(Constants.PAGER_BIDACCOUNTOPERATION, super.pager);
		
		return Constants.LIST_KEY;
		
	}//end init()
		
	public String list() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// ???????????
		super.pager = this.getBidAccountOperationService().list(super.getLoginUsername(), super.pageSize, super.pageNo);	
		
		// ?????????
		setSession(Constants.PAGER_BIDACCOUNTOPERATION, super.pager);
		
		return Constants.LIST_KEY;
		
	}//end list()
		
	public String add() throws Exception {
		System.out.println("F2 add getParameter of oneId: "+ServletActionContext.getRequest().getParameter("oneId"));
		
		if(ServletActionContext.getRequest().getParameter("from") != null && ServletActionContext.getRequest().getParameter("from") != ""){
			if(ServletActionContext.getRequest().getParameter("from").indexOf("bidAccountOperation") > -1){
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
		setAccountId(null);
		setSiteConfigId(null);
		setLockTime(null);
		setUnlockTime(null);
		setDeductionTime(null);
		setEntryTime(null);
		setEntryMoney(null);
		setMoneyUnit(null);
		setLockMoney(null);
	}//end reset()
		// ?????��??
	private void bean2Form(BidAccountOperation bidAccountOperation) {
		setId(bidAccountOperation.getId().toString());
		setAccountId(bidAccountOperation.getAccount().getId().toString());
		setSiteConfigId(bidAccountOperation.getSiteConfig().getId().toString());
		setLockTime(bidAccountOperation.getLockTime().toString()      );
		setUnlockTime(bidAccountOperation.getUnlockTime().toString()      );
		setDeductionTime(bidAccountOperation.getDeductionTime().toString()      );
		setEntryTime(bidAccountOperation.getEntryTime().toString()      );
		setEntryMoney(bidAccountOperation.getEntryMoney().toString());
		
	
		setMoneyUnit(bidAccountOperation.getMoneyUnit());
		setLockMoney(bidAccountOperation.getLockMoney().toString());
	}//end bean2Form()
	public String edit() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// id???????????
		if (this.getId() == null) {
			saveActionError("bidAccountOperation.message.edit.notexist");
			return Constants.LIST_KEY;
		} else {
			// ???????
			BidAccountOperation bidAccountOperation = this.getBidAccountOperationService().select(id); 
			
			// ??????????????
			if (bidAccountOperation == null) {
				saveActionError("bidAccountOperation.message.edit.notexist");
				return Constants.LIST_KEY;
			} else {
				// ?????��??
				bean2Form(bidAccountOperation);
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
		BidAccountOperation bidAccountOperation = new BidAccountOperation();
			bidAccountOperation.setAccount(this.getAccountService().select(Integer.parseInt(this.getAccountId())));    
			bidAccountOperation.setSiteConfig(this.getSiteConfigService().select(this.getSiteConfigId()));	
		bidAccountOperation.setLockTime(java.sql.Timestamp.valueOf(this.getLockTime() ));
		bidAccountOperation.setUnlockTime(java.sql.Timestamp.valueOf(this.getUnlockTime() ));
		bidAccountOperation.setDeductionTime(java.sql.Timestamp.valueOf(this.getDeductionTime() ));
		bidAccountOperation.setEntryTime(java.sql.Timestamp.valueOf(this.getEntryTime() ));
		bidAccountOperation.setEntryMoney(new BigDecimal(this.getEntryMoney()));
		bidAccountOperation.setMoneyUnit(this.getMoneyUnit());
		bidAccountOperation.setLockMoney(new BigDecimal(this.getEntryMoney()));
		String strOneId = ServletActionContext.getRequest().getParameter("oneId");
		System.out.println("F2 insert getParameter  of oneId:"+strOneId);
		Bid oneInstance = this.getBidService().select(strOneId);
		//bidAccountOperation.setBid(oneInstance);
		
		nid = this.getBidAccountOperationService().insert(bidAccountOperation);
		
		// ?????????????
		Pager pagerSession = (Pager) getSession(Constants.PAGER_BIDACCOUNTOPERATION);
		if(pagerSession == null){
			//??????????
			super.pageSize = Constants.pageSize;
			super.pageNo = Constants.pageNo;
		}else{
			super.pageSize = pagerSession.getPageSize();
			super.pageNo = pagerSession.getPageNo();
			
		}
		
		//????????????
		super.pager = this.getBidAccountOperationService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		
		
		}catch(Exception e){
			saveActionError2(e.toString());
			saveActionMessage2(" Sorry ");
			return Constants.ERROR_KEY;
		}
		
		// ?????????
		if (nid != null) {
			saveActionMessage("bidAccountOperation.message.add.success");
			return Constants.LIST_KEY;
		} else {
			saveActionError("bidAccountOperation.message.add.failed");
			return Constants.ADD_KEY;
		}
	}//end insert()
	public String update() throws Exception {
		// 
		clearErrorsAndMessages();
		
		try{
			// 
			BidAccountOperation bidAccountOperation = this.getBidAccountOperationService().select(new String(id));
//			bidAccountOperation.setAccount(accountInstance);    
//			bidAccountOperation.setSiteConfig(siteConfigInstance);    
			bidAccountOperation.setAccount(this.getAccountService().select(Integer.parseInt(this.getAccountId())));    
			bidAccountOperation.setSiteConfig(this.getSiteConfigService().select(this.getSiteConfigId()));
			
			bidAccountOperation.setLockTime(java.sql.Timestamp.valueOf(this.getLockTime() ));
			bidAccountOperation.setUnlockTime(java.sql.Timestamp.valueOf(this.getUnlockTime() ));
			bidAccountOperation.setDeductionTime(java.sql.Timestamp.valueOf(this.getDeductionTime() ));
			bidAccountOperation.setEntryTime(java.sql.Timestamp.valueOf(this.getEntryTime() ));
			bidAccountOperation.setEntryMoney(new BigDecimal(this.getEntryMoney()));
			bidAccountOperation.setMoneyUnit(this.getMoneyUnit());
			bidAccountOperation.setLockMoney(new BigDecimal(this.getLockMoney()));
		this.getBidAccountOperationService().update(bidAccountOperation);
		
		bean2Form(bidAccountOperation);	
		
		// ?????????????
		Pager pagerSession = (Pager) getSession(Constants.PAGER_BIDACCOUNTOPERATION);
		if(pagerSession == null){
			//??????????
			super.pageSize = Constants.pageSize;
			super.pageNo = Constants.pageNo;
		}else{
			super.pageSize = pagerSession.getPageSize();
			super.pageNo = pagerSession.getPageNo();
			
		}
		
			// ????????????
			super.pager = this.getBidAccountOperationService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
			saveActionMessage("bidAccountOperation.message.edit.success");
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
				saveActionError("bidAccountOperation.message.edit.notexist");
			} else {
				// ??????
				this.getBidAccountOperationService().delete(id);
				saveActionMessage("bidAccountOperation.message.delete.success");
			}
			
			// ???????????
			super.pager = this.getBidAccountOperationService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
			
		}catch(Exception e){
			saveActionError2(e.toString());
			saveActionMessage2("Please delete child first");
			return Constants.ERROR_KEY;
		}
		return Constants.LIST_KEY;
		
	}//end delete()
		
	
	@SuppressWarnings("unchecked")
	public String getCountBidDeal(){
		
		Pager pager=bidAccountOperationService.getCountBidDeal(pageSize, pageNo);
		List<BidAccountOperation> accountOperations=(List<BidAccountOperation>) pager.getResultList();
		List<CountDeal> deals=new ArrayList<CountDeal>();
		for (BidAccountOperation bidAccountOperation : accountOperations) {
			CountDeal countDeal=new CountDeal();
			//System.out.println(bidAccountOperation.getBidResponseInvited());
			BidResponseInvited bidResponseInvited= bidResponseInvitedService.select(bidAccountOperation.getBidResponseInvited().getId());
			if(bidResponseInvited==null){
				continue;
				
			}
			
			countDeal.setId(bidResponseInvited.getBid().getId());
			countDeal.setBuyUser(bidResponseInvited.getUser());
			countDeal.setDeliveUser(bidResponseInvited.getBid().getUser());
			countDeal.setNmae(bidResponseInvited.getBid().getName());
			double money=bidResponseInvited.getBid().getTotalMoney()/bidResponseInvited.getBid().getRecruitNum();
			countDeal.setMoney(money);
			
			String type="";
			int types=bidResponseInvited.getBid().getType();
			if(types==1){
				type="找模特/摄影师";
				
			}
			else if(types==2){
				type="特约拍摄";
				
			}
			else if(types==3){
				type="作品征集";
				
			}
			countDeal.setType(type+" "+bidResponseInvited.getBid().getTag());
			countDeal.setDealTime(Cleandar.getTime(bidAccountOperation.getEntryTime()));
			deals.add(countDeal);
		}
		pager.setResultList(deals);
		super.pager=pager;
		
		return "getCountBidDeal";
	}
 
	/////getter////setter//////
	public String getId(){
		return  id;
	}
	public void  setId(String id){
		this.id = id ;
	}
	 
	public BidAccountOperationService getBidAccountOperationService() {
		return bidAccountOperationService;
	}
	public void setBidAccountOperationService(BidAccountOperationService bidAccountOperationService) {
		this.bidAccountOperationService = bidAccountOperationService;
	}
	
	public String getAccountId(){
		return  accountId;
	}
	public void  setAccountId(String accountId){
		this.accountId = accountId ;
	}
	 
	public String getSiteConfigId(){
		return  siteConfigId;
	}
	public void  setSiteConfigId(String siteConfigId){
		this.siteConfigId = siteConfigId ;
	}
	 
	public String getLockTime(){
		return  lockTime;
	}
	public void  setLockTime(String lockTime){
		this.lockTime = lockTime ;
	}
	 
	public String getUnlockTime(){
		return  unlockTime;
	}
	public void  setUnlockTime(String unlockTime){
		this.unlockTime = unlockTime ;
	}
	 
	public String getDeductionTime(){
		return  deductionTime;
	}
	public void  setDeductionTime(String deductionTime){
		this.deductionTime = deductionTime ;
	}
	 
	public String getEntryTime(){
		return  entryTime;
	}
	public void  setEntryTime(String entryTime){
		this.entryTime = entryTime ;
	}
	 
	public String getEntryMoney(){
		return  entryMoney;
	}
	public void  setEntryMoney(String entryMoney){
		this.entryMoney = entryMoney ;
	}
	 
	public String getMoneyUnit(){
		return  moneyUnit;
	}
	public void  setMoneyUnit(String moneyUnit){
		this.moneyUnit = moneyUnit ;
	}
	 
	public String getLockMoney(){
		return  lockMoney;
	}
	public void  setLockMoney(String lockMoney){
		this.lockMoney = lockMoney ;
	}
	 
	 public String getUsername() {
	 	return username;
	 }
	 public void setUsername(String username) {
	 	this.username = username;
	 }
	public BidResponseInvitedService getBidResponseInvitedService() {
		return bidResponseInvitedService;
	}
	public void setBidResponseInvitedService(
			BidResponseInvitedService bidResponseInvitedService) {
		this.bidResponseInvitedService = bidResponseInvitedService;
	}
	 
	 
}//end class
