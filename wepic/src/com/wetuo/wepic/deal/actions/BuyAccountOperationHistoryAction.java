package com.wetuo.wepic.deal.actions ;
 
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.StringTokenizer;
import java.io.File;
import java.math.BigDecimal;
import java.util.*;
import java.text.SimpleDateFormat;
import com.wetuo.wepic.deal.beans.BuyAccountOperationHistory;
import com.wetuo.wepic.deal.service.BuyAccountOperationHistoryService;
import com.wetuo.wepic.core.beans.SiteConfig;
import com.wetuo.wepic.core.service.SiteConfigService;
import com.wetuo.wepic.core.beans.Account;
import com.wetuo.wepic.core.service.AccountService;
 
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.struts.PageAction;
import com.wetuo.wepic.common.struts.Constants;
import com.wetuo.wepic.common.struts.RegExpression;
 
 
import org.apache.struts2.ServletActionContext;
	import com.wetuo.wepic.deal.beans.BuyHistory;
import com.wetuo.wepic.deal.service.BuyHistoryService;
public class BuyAccountOperationHistoryAction extends PageAction {
		
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
 	private BuyAccountOperationHistoryService buyAccountOperationHistoryService;
	protected String siteConfigId = null ;
	private SiteConfigService siteConfigService;
	public SiteConfigService getSiteConfigService() {
		return siteConfigService;
	}
	public void setSiteConfigService(SiteConfigService siteConfigService) {
		this.siteConfigService = siteConfigService;
	}
	
	protected String accountId = null ;
	private AccountService accountService;
	public AccountService getAccountService() {
		return accountService;
	}
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}
	
	protected String lockTime = null ; 
	protected String unlockTime = null ; 
	protected String deductionTime = null ; 
	protected String entryTime = null ; 
	protected String entryMoney = null ; 
	protected String moneyUnit = null ; 
	protected String ifSuccess = null ; 
	protected String username = null; 
	//???????????��????
	public void validate() {
		
		// ?????????
		clearErrorsAndMessages();
		
		// ??????????
		String queryString = getRequestPath();
		if (queryString.indexOf("buyAccountOperationHistoryadd!insert") != -1 || queryString.indexOf("buyAccountOperationHistoryedit!update") != -1) {
		
			if (siteConfigId == null || siteConfigId.equals("")) {
				addFieldError("siteConfigId", "siteConfigId must be inputed");
			}//end if null
			if (accountId == null || accountId.equals("")) {
				addFieldError("accountId", "accountId must be inputed");
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
			if (ifSuccess == null || ifSuccess.equals("")) {
				addFieldError("ifSuccess", "ifSuccess must be inputed");
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
		super.pager = this.getBuyAccountOperationHistoryService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		
		// ?????????
		setSession(Constants.PAGER_BUYACCOUNTOPERATIONHISTORY, super.pager);
		
		return Constants.LIST_KEY;
		
	}//end init()
		
	public String list() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// ???????????
		super.pager = this.getBuyAccountOperationHistoryService().list(super.getLoginUsername(), super.pageSize, super.pageNo);	
		
		// ?????????
		setSession(Constants.PAGER_BUYACCOUNTOPERATIONHISTORY, super.pager);
		
		return Constants.LIST_KEY;
		
	}//end list()
		
	public String add() throws Exception {
		System.out.println("F2 add getParameter of oneId: "+ServletActionContext.getRequest().getParameter("oneId"));
		
		if(ServletActionContext.getRequest().getParameter("from") != null && ServletActionContext.getRequest().getParameter("from") != ""){
			if(ServletActionContext.getRequest().getParameter("from").indexOf("buyAccountOperationHistory") > -1){
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
		setSiteConfigId(null);
		setAccountId(null);
		setLockTime(null);
		setUnlockTime(null);
		setDeductionTime(null);
		setEntryTime(null);
		setEntryMoney(null);
		setMoneyUnit(null);
		setIfSuccess(null);
	}//end reset()
		// ?????��??
	private void bean2Form(BuyAccountOperationHistory buyAccountOperationHistory) {
		setId(buyAccountOperationHistory.getId().toString());
		setSiteConfigId(buyAccountOperationHistory.getSiteConfig().getId().toString());
		setAccountId(buyAccountOperationHistory.getAccount().getId().toString());
		setLockTime(buyAccountOperationHistory.getLockTime().toString()      );
		setUnlockTime(buyAccountOperationHistory.getUnlockTime().toString()      );
		setDeductionTime(buyAccountOperationHistory.getDeductionTime().toString()      );
		setEntryTime(buyAccountOperationHistory.getEntryTime().toString()      );
		setEntryMoney(buyAccountOperationHistory.getEntryMoney().toString());
		setMoneyUnit(buyAccountOperationHistory.getMoneyUnit());
		setIfSuccess(buyAccountOperationHistory.getIfSuccess().toString()      );
	}//end bean2Form()
	public String edit() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// id???????????
		if (this.getId() == null) {
			saveActionError("buyAccountOperationHistory.message.edit.notexist");
			return Constants.LIST_KEY;
		} else {
			// ???????
			BuyAccountOperationHistory buyAccountOperationHistory = this.getBuyAccountOperationHistoryService().select(id); 
			
			// ??????????????
			if (buyAccountOperationHistory == null) {
				saveActionError("buyAccountOperationHistory.message.edit.notexist");
				return Constants.LIST_KEY;
			} else {
				// ?????��??
				bean2Form(buyAccountOperationHistory);
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
		BuyAccountOperationHistory buyAccountOperationHistory = new BuyAccountOperationHistory();
//			buyAccountOperationHistory.setSiteConfig(siteConfigInstance);    
//			buyAccountOperationHistory.setAccount(accountInstance);    
			buyAccountOperationHistory.setAccount(this.getAccountService().select(Integer.parseInt(this.getAccountId())));    
			buyAccountOperationHistory.setSiteConfig(this.getSiteConfigService().select(this.getSiteConfigId()));  
			
		buyAccountOperationHistory.setLockTime(java.sql.Timestamp.valueOf(this.getLockTime() ));
		buyAccountOperationHistory.setUnlockTime(java.sql.Timestamp.valueOf(this.getUnlockTime() ));
		buyAccountOperationHistory.setDeductionTime(java.sql.Timestamp.valueOf(this.getDeductionTime() ));
		buyAccountOperationHistory.setEntryTime(java.sql.Timestamp.valueOf(this.getEntryTime() ));
		buyAccountOperationHistory.setEntryMoney(new BigDecimal(this.getEntryMoney() ));
		buyAccountOperationHistory.setMoneyUnit(this.getMoneyUnit());
		buyAccountOperationHistory.setIfSuccess(Integer.valueOf(this.getIfSuccess() ));
		String strOneId = ServletActionContext.getRequest().getParameter("oneId");
		System.out.println("F2 insert getParameter  of oneId:"+strOneId);
		BuyHistory oneInstance = this.getBuyHistoryService().select(strOneId);
		buyAccountOperationHistory.setBuyHistory(oneInstance);
		
		nid = this.getBuyAccountOperationHistoryService().insert(buyAccountOperationHistory);
		
		// ?????????????
		Pager pagerSession = (Pager) getSession(Constants.PAGER_BUYACCOUNTOPERATIONHISTORY);
		if(pagerSession == null){
			//??????????
			super.pageSize = Constants.pageSize;
			super.pageNo = Constants.pageNo;
		}else{
			super.pageSize = pagerSession.getPageSize();
			super.pageNo = pagerSession.getPageNo();
			
		}
		
		//????????????
		super.pager = this.getBuyAccountOperationHistoryService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		
		
		}catch(Exception e){
			saveActionError2(e.toString());
			saveActionMessage2(" Sorry ");
			return Constants.ERROR_KEY;
		}
		
		// ?????????
		if (nid != null) {
			saveActionMessage("buyAccountOperationHistory.message.add.success");
			return Constants.LIST_KEY;
		} else {
			saveActionError("buyAccountOperationHistory.message.add.failed");
			return Constants.ADD_KEY;
		}
	}//end insert()
	public String update() throws Exception {
		// 
		clearErrorsAndMessages();
		
		try{
			// 
			BuyAccountOperationHistory buyAccountOperationHistory = this.getBuyAccountOperationHistoryService().select(new String(id));
//			buyAccountOperationHistory.setSiteConfig(siteConfigInstance);    
//			buyAccountOperationHistory.setAccount(accountInstance);    
			buyAccountOperationHistory.setAccount(this.getAccountService().select(Integer.parseInt(this.getAccountId())));    
			buyAccountOperationHistory.setSiteConfig(this.getSiteConfigService().select(this.getSiteConfigId()));  
			
			buyAccountOperationHistory.setLockTime(java.sql.Timestamp.valueOf(this.getLockTime() ));
			buyAccountOperationHistory.setUnlockTime(java.sql.Timestamp.valueOf(this.getUnlockTime() ));
			buyAccountOperationHistory.setDeductionTime(java.sql.Timestamp.valueOf(this.getDeductionTime() ));
			buyAccountOperationHistory.setEntryTime(java.sql.Timestamp.valueOf(this.getEntryTime() ));
			buyAccountOperationHistory.setEntryMoney(new BigDecimal(this.getEntryMoney() ));
			buyAccountOperationHistory.setMoneyUnit(this.getMoneyUnit());
			buyAccountOperationHistory.setIfSuccess(Integer.valueOf(this.getIfSuccess() ));
		this.getBuyAccountOperationHistoryService().update(buyAccountOperationHistory);
		
		bean2Form(buyAccountOperationHistory);	
		
		// ?????????????
		Pager pagerSession = (Pager) getSession(Constants.PAGER_BUYACCOUNTOPERATIONHISTORY);
		if(pagerSession == null){
			//??????????
			super.pageSize = Constants.pageSize;
			super.pageNo = Constants.pageNo;
		}else{
			super.pageSize = pagerSession.getPageSize();
			super.pageNo = pagerSession.getPageNo();
			
		}
		
			// ????????????
			super.pager = this.getBuyAccountOperationHistoryService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
			saveActionMessage("buyAccountOperationHistory.message.edit.success");
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
				saveActionError("buyAccountOperationHistory.message.edit.notexist");
			} else {
				// ??????
				this.getBuyAccountOperationHistoryService().delete(id);
				saveActionMessage("buyAccountOperationHistory.message.delete.success");
			}
			
			// ???????????
			super.pager = this.getBuyAccountOperationHistoryService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
			
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
	 
	public BuyAccountOperationHistoryService getBuyAccountOperationHistoryService() {
		return buyAccountOperationHistoryService;
	}
	public void setBuyAccountOperationHistoryService(BuyAccountOperationHistoryService buyAccountOperationHistoryService) {
		this.buyAccountOperationHistoryService = buyAccountOperationHistoryService;
	}
	
	public String getSiteConfigId(){
		return  siteConfigId;
	}
	public void  setSiteConfigId(String siteConfigId){
		this.siteConfigId = siteConfigId ;
	}
	 
	public String getAccountId(){
		return  accountId;
	}
	public void  setAccountId(String accountId){
		this.accountId = accountId ;
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
	 
	public String getIfSuccess(){
		return  ifSuccess;
	}
	public void  setIfSuccess(String ifSuccess){
		this.ifSuccess = ifSuccess ;
	}
	 
	 public String getUsername() {
	 	return username;
	 }
	 public void setUsername(String username) {
	 	this.username = username;
	 }
	 
}//end class
