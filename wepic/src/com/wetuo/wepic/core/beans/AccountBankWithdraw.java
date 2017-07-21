package com.wetuo.wepic.core.beans;

import java.util.HashSet;
import java.util.Set;

import org.apache.struts2.json.annotations.JSON;

public class AccountBankWithdraw {
	private static final long serialVersionUID = 1L;
	private Integer id;
	
	private Account account;
	private String bankwithdrawopenaccount;//开户名
	private String bankwithdrawbelongbank;//所属银行
	private String bankwithdrawopenbankname;//开户行名称
	private String bankwithdrawaccountNumber;//银行卡号
	private String bankwithdrawremark;//备注
	private Integer withdrawnumber;//提现次数
	private Integer isdefault;//默认取现银行卡
	
	private Set<AccountWithdraw> accountWithdraws  = new HashSet<AccountWithdraw>();//
	
	
	public AccountBankWithdraw(Integer id,Account account,String bankwithdrawopenaccount,String bankwithdrawbelongbank,String bankwithdrawopenbankname,String bankwithdrawaccountNumber,String remark) {
		this.id = id;
		this.account=account;
		this.bankwithdrawopenaccount=bankwithdrawopenaccount;
		this.bankwithdrawbelongbank=bankwithdrawbelongbank;
		this.bankwithdrawopenbankname=bankwithdrawopenbankname;
		this.bankwithdrawaccountNumber=bankwithdrawaccountNumber;
		this.bankwithdrawremark=remark;
	}//
	
	public AccountBankWithdraw(){
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public String getBankwithdrawopenaccount() {
		return bankwithdrawopenaccount;
	}
	public void setBankwithdrawopenaccount(String bankwithdrawopenaccount) {
		this.bankwithdrawopenaccount = bankwithdrawopenaccount;
	}
	public String getBankwithdrawbelongbank() {
		return bankwithdrawbelongbank;
	}
	public void setBankwithdrawbelongbank(String bankwithdrawbelongbank) {
		this.bankwithdrawbelongbank = bankwithdrawbelongbank;
	}
	public String getBankwithdrawopenbankname() {
		return bankwithdrawopenbankname;
	}
	public void setBankwithdrawopenbankname(String bankwithdrawopenbankname) {
		this.bankwithdrawopenbankname = bankwithdrawopenbankname;
	}
	public String getBankwithdrawaccountNumber() {
		return bankwithdrawaccountNumber;
	}
	public void setBankwithdrawaccountNumber(String bankwithdrawaccountNumber) {
		this.bankwithdrawaccountNumber = bankwithdrawaccountNumber;
	}
	public String getBankwithdrawremark() {
		return bankwithdrawremark;
	}
	public void setBankwithdrawremark(String bankwithdrawremark) {
		this.bankwithdrawremark = bankwithdrawremark;
	}

	public Integer getWithdrawnumber() {
		return withdrawnumber;
	}

	public void setWithdrawnumber(Integer withdrawnumber) {
		this.withdrawnumber = withdrawnumber;
	}

	public Integer getIsdefault() {
		return isdefault;
	}

	public void setIsdefault(Integer isdefault) {
		this.isdefault = isdefault;
	}

	public Set<AccountWithdraw> getAccountWithdraws() {
		return accountWithdraws;
	}

	public void setAccountWithdraws(Set<AccountWithdraw> accountWithdraws) {
		this.accountWithdraws = accountWithdraws;
	}
	
	
	

}
