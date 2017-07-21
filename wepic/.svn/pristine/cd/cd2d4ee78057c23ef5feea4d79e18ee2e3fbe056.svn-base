package com.wetuo.wepic.core.actions ;
 
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.wetuo.wepic.common.hibernate.PageSize;
import com.wetuo.wepic.common.struts.PageAction;
import com.wetuo.wepic.core.beans.Account;
import com.wetuo.wepic.core.beans.AccountBankWithdraw;
import com.wetuo.wepic.core.beans.AccountWithdraw;
import com.wetuo.wepic.core.beans.LoginHistory;
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.core.service.AccountBankWithdrawService;
import com.wetuo.wepic.core.service.AccountService;
import com.wetuo.wepic.core.service.AccountWithdrawService;
import com.wetuo.wepic.core.service.LoginHistoryService;
import com.wetuo.wepic.core.service.UserService;
import com.wetuo.wepic.publish.beans.Story;
public class AccountWithdrawAction extends PageAction {
		
	private AccountService accountService;
	private AccountWithdraw accountWithdraw;
	private AccountWithdrawService accountWithdrawService;
	private UserService userService;
	private AccountBankWithdrawService accountBankWithdrawService;
	private LoginHistoryService loginHistoryService;
	private LoginHistory loginHistory;
	private List<AccountBankWithdraw> accountBankWithdraws;
	private AccountBankWithdraw defaultAccountBankWithdraw;
	private User user;
	private Account useraccount;
    private BigDecimal frozenBigDecimal;
	private Integer accountId;
	private String userwithdrawMoney;
	private Integer tradeFlag;
	private String hiddenbank;
	private Integer totalWithdrawNumber;
	private BigDecimal totalMoney;
	private Map resMap=new HashMap();
	private String startTime;
	private String endTime;
	public Object getModel() {
		if (accountWithdraw == null) {
			accountWithdraw = new AccountWithdraw();
		}
		return accountWithdraw;
	}
	
	public String applywithdraw() {
		int id=super.getLonginUserId();
		user=this.getUserService().selectById(id);
		loginHistory=this.getUserService().recentHistory();
		useraccount=this.getAccountService().select(id,"");
		accountBankWithdraws=this.getAccountBankWithdrawService().findByAccount(useraccount.getId());
		defaultAccountBankWithdraw=this.getAccountBankWithdrawService().defaultAccountBankWithdraw(useraccount.getId());
		frozenBigDecimal=useraccount.getTotalMoney().subtract(useraccount.getRemainingMoney());
		return "applywithdraw";
	}
	public String adminwithdrawlist() {
		
		return "adminwithdrawlist";
	}
	
	/**
	 * 管理员审核提现成功列表
	 * @return
	 */
	public String adminchecksucwithdrawlist() {
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(AccountWithdraw.class,"accountWithdraw");
		detachedCriteria.add(Restrictions.eq("status",2));
		super.pager=this.getAccountWithdrawService().findbyDetachedCriteria(detachedCriteria, pageNo,PageSize.adminwithdrawSize);
		List tempList=this.getAccountWithdrawService().findres();
		totalMoney=(BigDecimal) tempList.get(1);
		return "adminchecksucwithdrawlist";
	}
	/**
	 * 管理员审核失败提现列表
	 * @return
	 */
	public String admincheckfailwithdrawlist() {
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(AccountWithdraw.class,"accountWithdraw");
		detachedCriteria.add(Restrictions.eq("status",3));
		super.pager=this.getAccountWithdrawService().findbyDetachedCriteria(detachedCriteria, pageNo,PageSize.adminwithdrawSize);
		List tempList=this.getAccountWithdrawService().findres();
		totalMoney=(BigDecimal) tempList.get(1);
		return "admincheckfailwithdrawlist";
	}
	/**
	 * 管理员待审核提现列表
	 * @return
	 */
	public String adminwaitingwithdrawlist() {
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(AccountWithdraw.class,"accountWithdraw");
		detachedCriteria.add(Restrictions.eq("status",1));
		super.pager=this.getAccountWithdrawService().findbyDetachedCriteria(detachedCriteria, pageNo,PageSize.adminwithdrawSize);
		List tempList=this.getAccountWithdrawService().findres();
		totalMoney=(BigDecimal) tempList.get(1);
		return "adminwaitingwithdrawlist";
	}
	public String userwithdrawlist() {
		int id=super.getLonginUserId();
		user=this.getUserService().selectById(id);
		loginHistory=this.getUserService().recentHistory();
		useraccount=this.getAccountService().select(id,"");
		DetachedCriteria criteria1=this.getAccountWithdrawService().detachedCriteria(useraccount.getId());
		super.pager=this.getAccountWithdrawService().findbyDetachedCriteria(criteria1, pageNo,PageSize.backuserwithdrawSize);
		List tempList=this.getAccountWithdrawService().findresofuser(useraccount.getId());
		totalWithdrawNumber=(Integer) tempList.get(0);
		totalMoney=(BigDecimal) tempList.get(1);
		accountId=useraccount.getId();
		return "userwithdrawlist";
	}
	
	public String validateInputCash() throws Exception{
		int id=super.getLonginUserId();
		useraccount=this.getAccountService().select(id,"");
		String loginName = super.getLoginUsername();
		if(loginName == null || loginName.length()==0)
		{
			return "login";
		}
		List templList=new LinkedList();
		resMap=this.getAccountWithdrawService().applywithdraw(useraccount.getId(),userwithdrawMoney,hiddenbank);
		return "validateInputCash";		
	}
	///////////////////getter setter////////////////////
	public AccountService getAccountService() {
		return accountService;
	}
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}
	public AccountWithdraw getAccountWithdraw() {
		return accountWithdraw;
	}
	public void setAccountWithdraw(AccountWithdraw accountWithdraw) {
		this.accountWithdraw = accountWithdraw;
	}
	public AccountWithdrawService getAccountWithdrawService() {
		return accountWithdrawService;
	}
	public void setAccountWithdrawService(
			AccountWithdrawService accountWithdrawService) {
		this.accountWithdrawService = accountWithdrawService;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public AccountBankWithdrawService getAccountBankWithdrawService() {
		return accountBankWithdrawService;
	}

	public void setAccountBankWithdrawService(
			AccountBankWithdrawService accountBankWithdrawService) {
		this.accountBankWithdrawService = accountBankWithdrawService;
	}

	public LoginHistoryService getLoginHistoryService() {
		return loginHistoryService;
	}

	public void setLoginHistoryService(LoginHistoryService loginHistoryService) {
		this.loginHistoryService = loginHistoryService;
	}

	public LoginHistory getLoginHistory() {
		return loginHistory;
	}

	public void setLoginHistory(LoginHistory loginHistory) {
		this.loginHistory = loginHistory;
	}

	public List<AccountBankWithdraw> getAccountBankWithdraws() {
		return accountBankWithdraws;
	}

	public void setAccountBankWithdraws(
			List<AccountBankWithdraw> accountBankWithdraws) {
		this.accountBankWithdraws = accountBankWithdraws;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public AccountBankWithdraw getDefaultAccountBankWithdraw() {
		return defaultAccountBankWithdraw;
	}

	public void setDefaultAccountBankWithdraw(
			AccountBankWithdraw defaultAccountBankWithdraw) {
		this.defaultAccountBankWithdraw = defaultAccountBankWithdraw;
	}

	public Account getUseraccount() {
		return useraccount;
	}

	public void setUseraccount(Account useraccount) {
		this.useraccount = useraccount;
	}
	public BigDecimal getFrozenBigDecimal() {
		return frozenBigDecimal;
	}
	public void setFrozenBigDecimal(BigDecimal frozenBigDecimal) {
		this.frozenBigDecimal = frozenBigDecimal;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getUserwithdrawMoney() {
		return userwithdrawMoney;
	}

	public void setUserwithdrawMoney(String userwithdrawMoney) {
		this.userwithdrawMoney = userwithdrawMoney;
	}

	public Integer getTradeFlag() {
		return tradeFlag;
	}

	public void setTradeFlag(Integer tradeFlag) {
		this.tradeFlag = tradeFlag;
	}

	public Map getResMap() {
		return resMap;
	}

	public void setResMap(Map resMap) {
		this.resMap = resMap;
	}

	public String getHiddenbank() {
		return hiddenbank;
	}

	public void setHiddenbank(String hiddenbank) {
		this.hiddenbank = hiddenbank;
	}

	public Integer getTotalWithdrawNumber() {
		return totalWithdrawNumber;
	}

	public void setTotalWithdrawNumber(Integer totalWithdrawNumber) {
		this.totalWithdrawNumber = totalWithdrawNumber;
	}

	public BigDecimal getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(BigDecimal totalMoney) {
		this.totalMoney = totalMoney;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
}//end class
