package com.wetuo.wepic.deal.beans ;
 
import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.commons.lang.builder.ToStringBuilder;
import com.wetuo.wepic.core.beans.Account;
import com.wetuo.wepic.core.beans.SiteConfig;
 
public class BuyAccountOperation  implements Serializable {
 
	/////instantce variable//////
	private static final long serialVersionUID = 1L;
	private String id;
	
	private BuyCartDeal buyCartDeal;//
	protected Account account;
	protected SiteConfig siteConfig;
	//0  , 1 lock, 2 unlock, 3 entry, 4 deduction
	private Integer operationType;
	private java.sql.Timestamp operationTime;
//	private java.sql.Timestamp unlockTime;
//	private java.sql.Timestamp deductionTime;
//	private java.sql.Timestamp entryTime;
	private BigDecimal money;
	private String moneyUnit;
	private Integer ifSuccess;
 
	////start OneToMany
	
	public BuyCartDeal getBuyCartDeal() {
		return buyCartDeal;
	}//end get()
	public void setBuyCartDeal(BuyCartDeal buyCartDeal) {
		this.buyCartDeal = buyCartDeal;
	}//end set()
	/////////constructor//////////////////
	
	public BuyAccountOperation(String id,Account account,SiteConfig siteConfig,Integer operationType,java.sql.Timestamp operationTime,BigDecimal money,String moneyUnit,Integer ifSuccess) {
		this.id = id;
		this.account = account;
		this.siteConfig = siteConfig;
//		this.lockTime = lockTime;
//		this.unlockTime = unlockTime;
//		this.deductionTime = deductionTime;
//		this.entryTime = entryTime;
//		this.entryMoney = entryMoney;
		this.operationType=operationType;
		this.operationTime=operationTime;
		this.money=money;
		this.moneyUnit = moneyUnit;
		this.ifSuccess = ifSuccess;
	}//
	
	public BuyAccountOperation(){
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
	public Integer getOperationType() {
		return operationType;
	}
	public void setOperationType(Integer operationType) {
		this.operationType = operationType;
	}
	public java.sql.Timestamp getOperationTime() {
		return operationTime;
	}
	public void setOperationTime(java.sql.Timestamp operationTime) {
		this.operationTime = operationTime;
	}
	public BigDecimal getMoney() {
		return money;
	}
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
 
}//end class
