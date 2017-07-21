package com.wetuo.wepic.core.beans ;
 
import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.commons.lang.builder.ToStringBuilder;
import com.wetuo.wepic.core.beans.User;
 
public class AccountRecharge  implements Serializable {
 
	/////instantce variable//////
	private static final long serialVersionUID = 1L;
	private Integer id;
	protected User user;
	private int userId;
	//private Account account2
	private String accountID;//暂不使用
	private java.sql.Timestamp rechargeTime;
	private BigDecimal rechargeMoney;
	private Integer ifConfirmed;
	private java.sql.Timestamp confirmTime;
	private String orderId;
	private String transferaccount;//转账银行账号
	private String transferopenname;//转账银行开户名
	private Integer rechargetype; //1 转账 2 支付宝 3 银联
	
	
	
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	
	public AccountRecharge(Integer id,User user,String accountID,java.sql.Timestamp rechargeTime,BigDecimal rechargeMoney,Integer ifConfirmed,java.sql.Timestamp confirmTime) {
		this.id = id;
		this.user = user;
		this.accountID = accountID;
		this.rechargeTime = rechargeTime;
		this.rechargeMoney = rechargeMoney;
		this.ifConfirmed = ifConfirmed;
		this.confirmTime = confirmTime;
	}//
	
	public AccountRecharge(){
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
	public java.sql.Timestamp  getRechargeTime(){
		return this.rechargeTime;
	}
	public void  setRechargeTime(java.sql.Timestamp rechargeTime){
		this.rechargeTime = rechargeTime ;
	}
	
	public BigDecimal getRechargeMoney() {
		return rechargeMoney;
	}
	public void setRechargeMoney(BigDecimal rechargeMoney) {
		this.rechargeMoney = rechargeMoney;
	}
	public Integer  getIfConfirmed(){
		return this.ifConfirmed;
	}
	public void  setIfConfirmed(Integer ifConfirmed){
		this.ifConfirmed = ifConfirmed ;
	}
	public java.sql.Timestamp  getConfirmTime(){
		return this.confirmTime;
	}
	public void  setConfirmTime(java.sql.Timestamp confirmTime){
		this.confirmTime = confirmTime ;
	}
	public String getTransferaccount() {
		return transferaccount;
	}
	public void setTransferaccount(String transferaccount) {
		this.transferaccount = transferaccount;
	}
	public String getTransferopenname() {
		return transferopenname;
	}
	public void setTransferopenname(String transferopenname) {
		this.transferopenname = transferopenname;
	}
	public Integer getRechargetype() {
		return rechargetype;
	}
	public void setRechargetype(Integer rechargetype) {
		this.rechargetype = rechargetype;
	}
 
}//end class
