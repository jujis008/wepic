package com.wetuo.wepic.core.beans ;
 
import java.io.Serializable;
import java.math.BigDecimal;
 
public class AccountWithdraw  implements Serializable {
 
	/////instantce variable//////
	private static final long serialVersionUID = 1L;
	private Integer id;
	protected User admin;
	private BigDecimal withdrawMoney;
	private BigDecimal totalwithdrawMoney;
	private java.sql.Timestamp withdrawTime;
	private String withdrawCode; 
	//private Integer status ; ////0 状态不定，1申请提交通过，2管理员允许提现， 3管理员不许提现，4密码三次错误，提现失败，5密码输入成功，6管理员已经打过款 , 7提现失败(付款失败)
	private Integer status;//0申请提现失败(网络不通或 账户余额不够) 1 申请提现成功  2 管理员提现通过 3 管理员提现不通过 4体现通过之后打款失败  5管理员打款成功
	private Integer ifDemandWithdraw;
	private java.sql.Timestamp demandWithdrawTime;
	private String failreason;
	private Integer printflag;
	private String serialnumber;//提现记录流水号
	private String withdrawbankaccount;
	private AccountBankWithdraw accountBankWithdraw;
	public Integer getPrintflag() {
		return printflag;
	}
	public void setPrintflag(Integer printflag) {
		this.printflag = printflag;
	}
	public String getFailreason() {
		return failreason;
	}
	public void setFailreason(String failreason) {
		this.failreason = failreason;
	}
	////start OneToMany
	private Account account;//
	public Account getAccount() {
		return account;
	}//end get()
	public void setAccount(Account account) {
		this.account = account;
	}//end set()
	/////////constructor//////////////////
	
	public AccountWithdraw(Integer id,User admin,BigDecimal withdrawMoney,java.sql.Timestamp withdrawTime,String withdrawCode,Integer ifDemandWithdraw,java.sql.Timestamp demandWithdrawTime) {
		this.id = id;
		this.admin = admin;
		this.withdrawMoney = withdrawMoney;
		this.withdrawTime = withdrawTime;
		this.withdrawCode = withdrawCode;
		this.ifDemandWithdraw = ifDemandWithdraw;
		this.demandWithdrawTime = demandWithdrawTime;
	}//
	
	public AccountWithdraw(){
		super();
	}
 
	/////getter////setter//////
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public User getAdmin() {
		return admin;
	}
	public void setAdmin(User admin) {
		this.admin = admin;
	}
	public java.sql.Timestamp  getWithdrawTime(){
		return this.withdrawTime;
	}
	public void  setWithdrawTime(java.sql.Timestamp withdrawTime){
		this.withdrawTime = withdrawTime ;
	}
	public String  getWithdrawCode(){
		return this.withdrawCode;
	}
	public void  setWithdrawCode(String withdrawCode){
		this.withdrawCode = withdrawCode ;
	}
	public BigDecimal getWithdrawMoney() {
		return withdrawMoney;
	}
	public void setWithdrawMoney(BigDecimal withdrawMoney) {
		this.withdrawMoney = withdrawMoney;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer  getIfDemandWithdraw(){
		return this.ifDemandWithdraw;
	}
	public void  setIfDemandWithdraw(Integer ifDemandWithdraw){
		this.ifDemandWithdraw = ifDemandWithdraw ;
	}
	
	public java.sql.Timestamp getDemandWithdrawTime() {
		return demandWithdrawTime;
	}
	public void setDemandWithdrawTime(java.sql.Timestamp demandWithdrawTime) {
		this.demandWithdrawTime = demandWithdrawTime;
	}
	public String getSerialnumber() {
		return serialnumber;
	}
	public void setSerialnumber(String serialnumber) {
		this.serialnumber = serialnumber;
	}
	public String getWithdrawbankaccount() {
		return withdrawbankaccount;
	}
	public void setWithdrawbankaccount(String withdrawbankaccount) {
		this.withdrawbankaccount = withdrawbankaccount;
	}
	public AccountBankWithdraw getAccountBankWithdraw() {
		return accountBankWithdraw;
	}
	public void setAccountBankWithdraw(AccountBankWithdraw accountBankWithdraw) {
		this.accountBankWithdraw = accountBankWithdraw;
	}
	public BigDecimal getTotalwithdrawMoney() {
		return totalwithdrawMoney;
	}
	public void setTotalwithdrawMoney(BigDecimal totalwithdrawMoney) {
		this.totalwithdrawMoney = totalwithdrawMoney;
	}
	
}//end class
