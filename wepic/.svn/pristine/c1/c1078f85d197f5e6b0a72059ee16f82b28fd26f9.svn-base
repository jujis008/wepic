package com.wetuo.wepic.core.actions ;
 
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.sms.util.SendSMS;
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.struts.Constants;
import com.wetuo.wepic.common.struts.PageAction;
import com.wetuo.wepic.common.util.MailSend;
import com.wetuo.wepic.core.beans.Account;
import com.wetuo.wepic.core.beans.AccountBankWithdraw;
import com.wetuo.wepic.core.beans.AccountWithdraw;
import com.wetuo.wepic.core.beans.LoginHistory;
import com.wetuo.wepic.core.beans.MoneyInfo;
import com.wetuo.wepic.core.beans.MoneyRecharge;
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.core.service.AccountBankWithdrawService;
import com.wetuo.wepic.core.service.AccountRechargeService;
import com.wetuo.wepic.core.service.AccountService;
import com.wetuo.wepic.core.service.AccountWithdrawService;
import com.wetuo.wepic.core.service.UserService;
import com.wetuo.wepic.deal.beans.BidAccountOperation;
import com.wetuo.wepic.deal.beans.BuyAccountOperation;
import com.wetuo.wepic.deal.service.BidAccountOperationService;
import com.wetuo.wepic.deal.service.BuyAccountOperationService;

 
 
 
public class AccountAction extends PageAction {
 
 
	/////instantce variable//////
	private static final long serialVersionUID = 1L;
	protected String id = null ; 
 	private AccountService accountService;
	private UserService userService;
	private User user;
	private Account account;
	private LoginHistory loginHistory;
	private AccountBankWithdrawService accountBankWithdrawService;
	private List<AccountBankWithdraw> accountBankWithdraws;
	private AccountBankWithdraw defaultAccountBankWithdraw;
	/**
	 * 资金概况
	 * @return
	 */
	public String cashoverview() {
		int id=super.getLonginUserId();
		user=this.getUserService().selectById(id);
		loginHistory=this.getUserService().recentHistory();
		Account account2=this.getAccountService().select(user.getId(),"");
		accountBankWithdraws=this.getAccountBankWithdrawService().findByAccount(account2.getId());
		return "cashoverview";
	}
	@JSON(serialize=false)
	public String defaultandrefresh() {
		int id=super.getLonginUserId();
		Account account=this.getAccountService().select(id,"");
		accountBankWithdraws=this.getAccountBankWithdrawService().findByAccount2(account.getId());
		defaultAccountBankWithdraw=this.getAccountBankWithdrawService().defaultAccountBankWithdraw(account.getId());
		return "defaultandrefresh";
	}
	@JSON(serialize=false)
	public String refresh() {
		int id=super.getLonginUserId();
		Account account=this.getAccountService().select(id,"");
		accountBankWithdraws=this.getAccountBankWithdrawService().findByAccount2(account.getId());
		return "refresh";
	}
	public String transfer() {
		int id=super.getLonginUserId();
		user=this.getUserService().selectById(id);
		loginHistory=this.getUserService().recentHistory();
		return "transfer";
	}
	public String confirmtransfer() {
		int id=super.getLonginUserId();
		user=this.getUserService().selectById(id);
		loginHistory=this.getUserService().recentHistory();
		return "confirmtransfer";
	}
	public String userrecharge() {
		int id=super.getLonginUserId();
		user=this.getUserService().selectById(id);
		loginHistory=this.getUserService().recentHistory();
		if (id==0) {
			return "login";
		}
		Account account=accountService.select(id);
		account.setTotalMoney(account.getTotalMoney().setScale(0, BigDecimal.ROUND_DOWN));
		account.setRemainingMoney(account.getRemainingMoney().setScale(0,BigDecimal.ROUND_DOWN));
		ActionContext.getContext().put("account", account);
		return "userrecharge";
	}
	//////////////////getter      setter////////////////////
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public AccountService getAccountService() {
		return accountService;
	}
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public LoginHistory getLoginHistory() {
		return loginHistory;
	}
	public void setLoginHistory(LoginHistory loginHistory) {
		this.loginHistory = loginHistory;
	}
	public AccountBankWithdrawService getAccountBankWithdrawService() {
		return accountBankWithdrawService;
	}
	public void setAccountBankWithdrawService(
			AccountBankWithdrawService accountBankWithdrawService) {
		this.accountBankWithdrawService = accountBankWithdrawService;
	}
	public List<AccountBankWithdraw> getAccountBankWithdraws() {
		return accountBankWithdraws;
	}
	public void setAccountBankWithdraws(
			List<AccountBankWithdraw> accountBankWithdraws) {
		this.accountBankWithdraws = accountBankWithdraws;
	}
	public AccountBankWithdraw getDefaultAccountBankWithdraw() {
		return defaultAccountBankWithdraw;
	}
	public void setDefaultAccountBankWithdraw(
			AccountBankWithdraw defaultAccountBankWithdraw) {
		this.defaultAccountBankWithdraw = defaultAccountBankWithdraw;
	}
}//end class
