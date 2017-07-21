package com.wetuo.wepic.core.actions;


import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import com.wetuo.wepic.common.struts.PageAction;
import com.wetuo.wepic.core.beans.Account;
import com.wetuo.wepic.core.beans.AccountBankWithdraw;
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.core.service.AccountBankWithdrawService;
import com.wetuo.wepic.core.service.AccountService;
import com.wetuo.wepic.core.service.UserService;

public class AccountBankWithdrawAction  extends PageAction {
	private AccountBankWithdrawService bankWithdrawService;
	private User user;
	private AccountBankWithdraw accountBankWithdraw;
	private AccountService accountService;
	private UserService userService;
	private String bankwithdrawopenaccount;
	private String state;
	private Integer bankId;
	private List<AccountBankWithdraw> accountBankWithdraws;
	public Object getModel() {
		if (accountBankWithdraw == null) {
			accountBankWithdraw = new AccountBankWithdraw();
		}
		return accountBankWithdraw;
	}
	@JSON(serialize=false)
	public String bankwithdrawadd() {
		int id=super.getLonginUserId();
		user=this.getUserService().selectById(id);
		Account account=this.getAccountService().select(user.getId(),"");
		accountBankWithdraw.setBankwithdrawopenaccount(user.getRealName());
		accountBankWithdraw.setAccount(account);
		accountBankWithdraw.setWithdrawnumber(0);
		int res=this.getBankWithdrawService().insert(accountBankWithdraw);
		if (res ==0) {
			state="0";
		}else {
			state="1";
		}
		return "bankwithdrawadd";
	}
	public String addwithdrawbank() {
		int id=super.getLonginUserId();
		user=this.getUserService().selectById(id);
		Account account=this.getAccountService().select(user.getId(),"");
		accountBankWithdraw.setAccount(account);
		accountBankWithdraw.setWithdrawnumber(0);
		int res=this.getBankWithdrawService().insert(accountBankWithdraw);
		accountBankWithdraw.setBankwithdrawopenaccount(user.getRealName());
		this.getBankWithdrawService().update(accountBankWithdraw);
		return "addwithdrawbank";
	}
	@JSON(serialize=false)
	public String changedefault() {
		
		AccountBankWithdraw accountBankWithdraw=this.getBankWithdrawService().select(bankId);
		Account account=accountBankWithdraw.getAccount();
		this.getBankWithdrawService().isdefaultstatu(account.getId());
		accountBankWithdraw.setIsdefault(1);
		if (bankWithdrawService.update(accountBankWithdraw)) {
			state="1";
		}else {
			state="0";
		}
		return "changedefault";
	}
	public String delbankwithdraw() {
		int id=accountBankWithdraw.getId();
		this.getBankWithdrawService().delete(id);
		return "delbankwithdraw";
	}
	
	public AccountBankWithdrawService getBankWithdrawService() {
		return bankWithdrawService;
	}
	public void setBankWithdrawService(
			AccountBankWithdrawService bankWithdrawService) {
		this.bankWithdrawService = bankWithdrawService;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public AccountBankWithdraw getAccountBankWithdraw() {
		return accountBankWithdraw;
	}
	public void setAccountBankWithdraw(AccountBankWithdraw accountBankWithdraw) {
		this.accountBankWithdraw = accountBankWithdraw;
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
	public String getBankwithdrawopenaccount() {
		return bankwithdrawopenaccount;
	}
	public void setBankwithdrawopenaccount(String bankwithdrawopenaccount) {
		this.bankwithdrawopenaccount = bankwithdrawopenaccount;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Integer getBankId() {
		return bankId;
	}
	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}
	public List<AccountBankWithdraw> getAccountBankWithdraws() {
		return accountBankWithdraws;
	}
	public void setAccountBankWithdraws(
			List<AccountBankWithdraw> accountBankWithdraws) {
		this.accountBankWithdraws = accountBankWithdraws;
	}

}
