package com.wetuo.wepic.deal.actions ;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.wetuo.wepic.deal.beans.BuyAccountOperation;
import com.wetuo.wepic.deal.service.BuyAccountOperationHistoryService;
import com.wetuo.wepic.deal.service.BuyAccountOperationService;
import com.wetuo.wepic.core.beans.Account;
import com.wetuo.wepic.core.beans.AccountWithdraw;
import com.wetuo.wepic.core.service.AccountService;
import com.wetuo.wepic.core.service.AccountWithdrawService;
import com.wetuo.wepic.core.service.SiteConfigService;
 
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.struts.PageAction;
import com.wetuo.wepic.common.struts.Constants;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.wetuo.wepic.deal.beans.BuyCartDeal;
import com.wetuo.wepic.deal.service.BuyCartDealService;
import com.sun.org.apache.bcel.internal.generic.NEW;
public class BuyAccountOperationAction extends PageAction {
		
	private BuyCartDealService buyCartDealService;
	public BuyCartDealService getBuyCartDealService() {
		return buyCartDealService;
	}
	public void setBuyCartDealService(BuyCartDealService buyCartDealService) {
		this.buyCartDealService = buyCartDealService;
	}
	/////instantce variable//////
	private static final long serialVersionUID = 1L;
	protected String id = null ; 
 	private BuyAccountOperationService buyAccountOperationService;
	protected String accountId = null ;
	private AccountWithdrawService accountWithdrawService;
	public AccountWithdrawService getAccountWithdrawService() {
		return accountWithdrawService;
	}
	public void setAccountWithdrawService(
			AccountWithdrawService accountWithdrawService) {
		this.accountWithdrawService = accountWithdrawService;
	}
	private AccountService accountService;
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
	protected String ifSuccess = null ; 
	protected String username = null; 
	private List sellTradeList;
	private List buyList;
	private Integer tradeId;
	private BigDecimal totalMoney;
	public BigDecimal getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(BigDecimal totalMoney) {
		this.totalMoney = totalMoney;
	}
	public Integer getTradeId() {
		return tradeId;
	}
	public void setTradeId(Integer tradeId) {
		this.tradeId = tradeId;
	}
	private BuyAccountOperationHistoryService buyAccountOperationHistoryService;
	//???????????��????
	public void validate() {
		
		// ?????????
		clearErrorsAndMessages();
		
		// ??????????
		String queryString = getRequestPath();
		if (queryString.indexOf("buyAccountOperationadd!insert") != -1 || queryString.indexOf("buyAccountOperationedit!update") != -1) {
		
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
		super.pager = this.getBuyAccountOperationService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		
		// ?????????
		setSession(Constants.PAGER_BUYACCOUNTOPERATION, super.pager);
		
		return Constants.LIST_KEY;
		
	}//end init()
		
	public String list() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// ???????????
		super.pager = this.getBuyAccountOperationService().list(super.getLoginUsername(), super.pageSize, super.pageNo);	
		
		// ?????????
		setSession(Constants.PAGER_BUYACCOUNTOPERATION, super.pager);
		
		return Constants.LIST_KEY;
		
	}//end list()
	/**
	 * 买图交易<支出>
	 * @return
	 */
	public String buyTrade() {
		clearErrorsAndMessages();
		int id=this.getTradeId();
		AccountWithdraw accountWithdraw=this.getAccountWithdrawService().select(id);
		Account account=this.getAccountService().select(accountWithdraw.getAccount().getId());
		int accountId=account.getId();
		List<BuyAccountOperation> buyaccountOpertionList=this.getBuyAccountOperationService().findById(accountId);
		buyList=new ArrayList();
		totalMoney=new BigDecimal(0);
		for (BuyAccountOperation buyAccountOperation:buyaccountOpertionList) {
			buyList.add(buyAccountOperation);
			totalMoney=totalMoney.add(buyAccountOperation.getMoney());
		}
		return "buyTrade";
	}
	/**
	 * 卖图交易<收入>
	 * @return
	 */
	@JSON(serialize=false)
	public String sellTrade() {
		clearErrorsAndMessages();
		int id=this.getTradeId();
		AccountWithdraw accountWithdraw=this.getAccountWithdrawService().select(id);
		Account account=this.getAccountService().select(accountWithdraw.getAccount().getId());
		int accountId=account.getId();
		List<BuyAccountOperation> buyaccountOpertionList=this.getBuyAccountOperationService().sellFindById(accountId);
		sellTradeList=new ArrayList();
		totalMoney=new BigDecimal(0);
		for (BuyAccountOperation buyAccountOperation:buyaccountOpertionList) {
			sellTradeList.add(buyAccountOperation);
			totalMoney=totalMoney.add(buyAccountOperation.getMoney());
		}
		return "sellTrade";
		
	}
	public String add() throws Exception {
		System.out.println("F2 add getParameter of oneId: "+ServletActionContext.getRequest().getParameter("oneId"));
		
		if(ServletActionContext.getRequest().getParameter("from") != null && ServletActionContext.getRequest().getParameter("from") != ""){
			if(ServletActionContext.getRequest().getParameter("from").indexOf("buyAccountOperation") > -1){
				ServletActionContext.getResponse().sendRedirect("buyCartDeal!init.do");
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
		setIfSuccess(null);
	}//end reset()
		// ?????��??
	private void bean2Form(BuyAccountOperation buyAccountOperation) {
		setId(buyAccountOperation.getId().toString());
		setAccountId(buyAccountOperation.getAccount().getId().toString());
		setSiteConfigId(buyAccountOperation.getSiteConfig().getId().toString());
		setMoneyUnit(buyAccountOperation.getMoneyUnit());
		setIfSuccess(buyAccountOperation.getIfSuccess().toString()      );
	}//end bean2Form()
	public String edit() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// id???????????
		if (this.getId() == null) {
			saveActionError("buyAccountOperation.message.edit.notexist");
			return Constants.LIST_KEY;
		} else {
			// ???????
			BuyAccountOperation buyAccountOperation = this.getBuyAccountOperationService().select(id); 
			
			// ??????????????
			if (buyAccountOperation == null) {
				saveActionError("buyAccountOperation.message.edit.notexist");
				return Constants.LIST_KEY;
			} else {
				// ?????��??
				bean2Form(buyAccountOperation);
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
		BuyAccountOperation buyAccountOperation = new BuyAccountOperation();
			buyAccountOperation.setAccount(this.getAccountService().select(Integer.parseInt(this.getAccountId())));    
			buyAccountOperation.setSiteConfig(this.getSiteConfigService().select(this.getSiteConfigId()));  
			
		buyAccountOperation.setMoneyUnit(this.getMoneyUnit());
		buyAccountOperation.setIfSuccess(Integer.valueOf(this.getIfSuccess() ));
		String strOneId = ServletActionContext.getRequest().getParameter("oneId");
		System.out.println("F2 insert getParameter  of oneId:"+strOneId);
		BuyCartDeal oneInstance = this.getBuyCartDealService().select(strOneId);
		buyAccountOperation.setBuyCartDeal(oneInstance);
		
		nid = this.getBuyAccountOperationService().insert(buyAccountOperation);
		
		// ?????????????
		Pager pagerSession = (Pager) getSession(Constants.PAGER_BUYACCOUNTOPERATION);
		if(pagerSession == null){
			//??????????
			super.pageSize = Constants.pageSize;
			super.pageNo = Constants.pageNo;
		}else{
			super.pageSize = pagerSession.getPageSize();
			super.pageNo = pagerSession.getPageNo();
			
		}
		
		//????????????
		super.pager = this.getBuyAccountOperationService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		
		
		}catch(Exception e){
			saveActionError2(e.toString());
			saveActionMessage2(" Sorry ");
			return Constants.ERROR_KEY;
		}
		
		// ?????????
		if (nid != null) {
			saveActionMessage("buyAccountOperation.message.add.success");
			return Constants.LIST_KEY;
		} else {
			saveActionError("buyAccountOperation.message.add.failed");
			return Constants.ADD_KEY;
		}
	}//end insert()
	public String update() throws Exception {
		// 
		clearErrorsAndMessages();
		
		try{
			// 
			BuyAccountOperation buyAccountOperation = this.getBuyAccountOperationService().select(new String(id));
//			buyAccountOperation.setAccount(accountInstance);    
//			buyAccountOperation.setSiteConfig(siteConfigInstance);    
			buyAccountOperation.setAccount(this.getAccountService().select(Integer.parseInt(this.getAccountId())));    
			buyAccountOperation.setSiteConfig(this.getSiteConfigService().select(this.getSiteConfigId()));  
			
			buyAccountOperation.setMoneyUnit(this.getMoneyUnit());
			buyAccountOperation.setIfSuccess(Integer.valueOf(this.getIfSuccess() ));
		this.getBuyAccountOperationService().update(buyAccountOperation);
		
		bean2Form(buyAccountOperation);	
		
		// ?????????????
		Pager pagerSession = (Pager) getSession(Constants.PAGER_BUYACCOUNTOPERATION);
		if(pagerSession == null){
			//??????????
			super.pageSize = Constants.pageSize;
			super.pageNo = Constants.pageNo;
		}else{
			super.pageSize = pagerSession.getPageSize();
			super.pageNo = pagerSession.getPageNo();
			
		}
		
			// ????????????
			super.pager = this.getBuyAccountOperationService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
			saveActionMessage("buyAccountOperation.message.edit.success");
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
				saveActionError("buyAccountOperation.message.edit.notexist");
			} else {
				// ??????
				this.getBuyAccountOperationService().delete(id);
				saveActionMessage("buyAccountOperation.message.delete.success");
			}
			
			// ???????????
			super.pager = this.getBuyAccountOperationService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
			
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
	 
	public BuyAccountOperationService getBuyAccountOperationService() {
		return buyAccountOperationService;
	}
	public void setBuyAccountOperationService(BuyAccountOperationService buyAccountOperationService) {
		this.buyAccountOperationService = buyAccountOperationService;
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
	 public List getBuyList() {
			return buyList;
		}
		public void setBuyList(List buyList) {
			this.buyList = buyList;
		}
		public List getSellTradeList() {
			return sellTradeList;
		}
		public void setSellTradeList(List sellTradeList) {
			this.sellTradeList = sellTradeList;
		}
		public BuyAccountOperationHistoryService getBuyAccountOperationHistoryService() {
			return buyAccountOperationHistoryService;
		}
		public void setBuyAccountOperationHistoryService(
				BuyAccountOperationHistoryService buyAccountOperationHistoryService) {
			this.buyAccountOperationHistoryService = buyAccountOperationHistoryService;
		}
	 
}//end class
