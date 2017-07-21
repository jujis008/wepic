package com.wetuo.wepic.core.beans ;
 
import java.io.Serializable;
import java.math.BigDecimal;

import com.wetuo.wepic.core.beans.User;
 
import java.util.*;

import org.apache.struts2.json.annotations.JSON;
public class Account  implements Serializable {
 
	/////instantce variable//////
	private static final long serialVersionUID = 1L;
	private Integer id;
	protected User user;
	private int userId;
	private String accountID;
	private BigDecimal totalMoney;
	private BigDecimal remainingMoney;
	private String bankAccount;
	private String openingBank;
	private String belongBank;
	private MoneyInfo moneyInfo;
	
	private Set<AccountBankWithdraw> bankWithdrawSet  = new HashSet<AccountBankWithdraw>();//
	public Set<AccountBankWithdraw> getBankWithdrawSet() {
		return bankWithdrawSet;
	}
	public void setBankWithdrawSet(Set<AccountBankWithdraw> bankWithdrawSet) {
		this.bankWithdrawSet = bankWithdrawSet;
	}
	public MoneyInfo getMoneyInfo() {
		return moneyInfo;
	}
	public void setMoneyInfo(MoneyInfo moneyInfo) {
		this.moneyInfo = moneyInfo;
	}
	public String getBelongBank() {
		return belongBank;
	}
	public void setBelongBank(String belongBank) {
		this.belongBank = belongBank;
	}
	public int getUserId() {
		return userId;	
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	////start OneToMany
	private Set<AccountRecharge> accountRechargeSet  = new HashSet<AccountRecharge>();// 
	public Set<AccountRecharge> getAccountRechargeSet() {
		return this.accountRechargeSet;
	}//end get
	public void setAccountRechargeSet(Set<AccountRecharge> accountRechargeSet) {
		this.accountRechargeSet = accountRechargeSet ;
	}//end set
	////start OneToMany
	private Set<AccountWithdraw> accountWithdrawSet  = new HashSet<AccountWithdraw>();// 
	public Set<AccountWithdraw> getAccountWithdrawSet() {
		return this.accountWithdrawSet;
	}//end get
	public void setAccountWithdrawSet(Set<AccountWithdraw> accountWithdrawSet) {
		this.accountWithdrawSet = accountWithdrawSet ;
	}//end set
	/////////constructor//////////////////
	
	public Account(Integer id,User user,String accountID,BigDecimal totalMoney,BigDecimal remainingMoney,String bankAccount,String openingBank) {
		this.id = id;
		this.user = user;
		this.accountID = accountID;
		this.totalMoney = totalMoney;
		this.remainingMoney = remainingMoney;
		this.bankAccount = bankAccount;
		this.openingBank = openingBank;
	}//
	
	public Account(){
		super();
	}
 
	/////getter////setter//////
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public User  getUser(){
		return this.user;
	}
	public void  setUser(User user){
		this.user = user ;
	}
	public String  getAccountID(){
		return this.accountID;
	}
	public void  setAccountID(String accountID){
		this.accountID = accountID ;
	}
	
	public BigDecimal getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(BigDecimal integer) {
		this.totalMoney = integer;
	}
	public BigDecimal  getRemainingMoney(){
		return this.remainingMoney;
	}
	public void  setRemainingMoney(BigDecimal remainingMoney){
		this.remainingMoney = remainingMoney ;
	}
	public String  getBankAccount(){
		return this.bankAccount;
	}
	public void  setBankAccount(String bankAccount){
		this.bankAccount = bankAccount ;
	}
	public String  getOpeningBank(){
		return this.openingBank;
	}
	public void  setOpeningBank(String openingBank){
		this.openingBank = openingBank ;
	}
	
 
}//end class
