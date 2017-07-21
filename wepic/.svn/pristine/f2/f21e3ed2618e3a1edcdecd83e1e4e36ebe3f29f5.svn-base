package com.wetuo.wepic.deal.beans ;
 
import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.commons.lang.builder.ToStringBuilder;
import com.wetuo.wepic.core.beans.SiteConfig;
import com.wetuo.wepic.core.beans.Account;
 
public class BuyAccountOperationHistory  implements Serializable {
 
	private static final long serialVersionUID = 1L;
	private String id;
	protected SiteConfig siteConfig;
	protected Account account;
	private java.sql.Timestamp lockTime;
	private java.sql.Timestamp unlockTime;
	private java.sql.Timestamp deductionTime;
	private java.sql.Timestamp entryTime;
	private BigDecimal entryMoney;
	private String moneyUnit;
	private Integer ifSuccess;
 
	////start OneToMany
	private BuyHistory buyHistory;//
	public BuyHistory getBuyHistory() {
		return buyHistory;
	}//end get()
	public void setBuyHistory(BuyHistory buyHistory) {
		this.buyHistory = buyHistory;
	}//end set()
	/////////constructor//////////////////
	
	public BuyAccountOperationHistory(String id,SiteConfig siteConfig,Account account,java.sql.Timestamp lockTime,java.sql.Timestamp unlockTime,java.sql.Timestamp deductionTime,java.sql.Timestamp entryTime,BigDecimal entryMoney,String moneyUnit,Integer ifSuccess) {
		this.id = id;
		this.siteConfig = siteConfig;
		this.account = account;
		this.lockTime = lockTime;
		this.unlockTime = unlockTime;
		this.deductionTime = deductionTime;
		this.entryTime = entryTime;
		this.entryMoney = entryMoney;
		this.moneyUnit = moneyUnit;
		this.ifSuccess = ifSuccess;
	}//
	
	public BuyAccountOperationHistory(){
		super();
	}
 
	/////getter////setter//////
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public SiteConfig  getSiteConfig(){
		return this.siteConfig;
	}
	public void  setSiteConfig(SiteConfig siteConfig){
		this.siteConfig = siteConfig ;
	}
	public Account  getAccount(){
		return this.account;
	}
	public void  setAccount(Account account){
		this.account = account ;
	}
	public java.sql.Timestamp  getLockTime(){
		return this.lockTime;
	}
	public void  setLockTime(java.sql.Timestamp lockTime){
		this.lockTime = lockTime ;
	}
	public java.sql.Timestamp  getUnlockTime(){
		return this.unlockTime;
	}
	public void  setUnlockTime(java.sql.Timestamp unlockTime){
		this.unlockTime = unlockTime ;
	}
	public java.sql.Timestamp  getDeductionTime(){
		return this.deductionTime;
	}
	public void  setDeductionTime(java.sql.Timestamp deductionTime){
		this.deductionTime = deductionTime ;
	}
	public java.sql.Timestamp  getEntryTime(){
		return this.entryTime;
	}
	public void  setEntryTime(java.sql.Timestamp entryTime){
		this.entryTime = entryTime ;
	}
	
	
	
	public BigDecimal getEntryMoney() {
		return entryMoney;
	}
	public void setEntryMoney(BigDecimal entryMoney) {
		this.entryMoney = entryMoney;
	}
	public String  getMoneyUnit(){
		return this.moneyUnit;
	}
	public void  setMoneyUnit(String moneyUnit){
		this.moneyUnit = moneyUnit ;
	}
	public Integer  getIfSuccess(){
		return this.ifSuccess;
	}
	public void  setIfSuccess(Integer ifSuccess){
		this.ifSuccess = ifSuccess ;
	}
 
}//end class
