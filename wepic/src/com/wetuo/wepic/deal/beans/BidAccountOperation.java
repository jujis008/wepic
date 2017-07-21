package com.wetuo.wepic.deal.beans ;
 
import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.commons.lang.builder.ToStringBuilder;
import com.wetuo.wepic.core.beans.Account;
import com.wetuo.wepic.core.beans.SiteConfig;
 
public class BidAccountOperation  implements Serializable {
 
	/////instantce variable//////
	private static final long serialVersionUID = 1L;
	private String id;
	protected Account account;
	protected SiteConfig siteConfig;
	private java.sql.Timestamp lockTime;
	private java.sql.Timestamp unlockTime;
	private java.sql.Timestamp deductionTime;
	private java.sql.Timestamp entryTime;
	private BigDecimal entryMoney;
	private String moneyUnit;
	private BigDecimal lockMoney;
	private BidForOpus bidForOpus;
	private Bid bid;
	private BigDecimal deductionMoney;
	private String type;//1应约2,出标3是推广
	
 
	public BigDecimal getDeductionMoney() {
		return deductionMoney;
	}

	public void setDeductionMoney(BigDecimal deductionMoney) {
		this.deductionMoney = deductionMoney;
	}

	public Bid getBid() {
		return bid;
	}

	public void setBid(Bid bid) {
		this.bid = bid;
	}

	public BidForOpus getBidForOpus() {
		return bidForOpus;
	}

	public void setBidForOpus(BidForOpus bidForOpus) {
		this.bidForOpus = bidForOpus;
	}
	////start OneToMany
	private BidResponseInvited bidResponseInvited;//
	
	/////////constructor//////////////////
	
	public BidResponseInvited getBidResponseInvited() {
		return bidResponseInvited;
	}

	public void setBidResponseInvited(BidResponseInvited bidResponseInvited) {
		this.bidResponseInvited = bidResponseInvited;
	}

	public BidAccountOperation(String id,Account account,SiteConfig siteConfig,java.sql.Timestamp lockTime,java.sql.Timestamp unlockTime,java.sql.Timestamp deductionTime,java.sql.Timestamp entryTime,BigDecimal entryMoney,String moneyUnit,BigDecimal lockMoney) {
		this.id = id;
		this.account = account;
		this.siteConfig = siteConfig;
		this.lockTime = lockTime;
		this.unlockTime = unlockTime;
		this.deductionTime = deductionTime;
		this.entryTime = entryTime;
		this.entryMoney = entryMoney;
		this.moneyUnit = moneyUnit;
		this.lockMoney = lockMoney;
	}//
	
	public BidAccountOperation(){
		super();
	}
 
	/////getter////setter//////
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Account  getAccount(){
		return this.account;
	}
	public void  setAccount(Account account){
		this.account = account ;
	}
	public SiteConfig  getSiteConfig(){
		return this.siteConfig;
	}
	public void  setSiteConfig(SiteConfig siteConfig){
		this.siteConfig = siteConfig ;
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
	
	public String  getMoneyUnit(){
		return this.moneyUnit;
	}
	public void  setMoneyUnit(String moneyUnit){
		this.moneyUnit = moneyUnit ;
	}
	public BigDecimal getEntryMoney() {
		return entryMoney;
	}
	public void setEntryMoney(BigDecimal entryMoney) {
		this.entryMoney = entryMoney;
	}
	public BigDecimal getLockMoney() {
		return lockMoney;
	}
	public void setLockMoney(BigDecimal lockMoney) {
		this.lockMoney = lockMoney;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
 
}//end class
