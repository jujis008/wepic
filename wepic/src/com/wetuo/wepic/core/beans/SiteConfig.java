package com.wetuo.wepic.core.beans ;
 
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
 
public class SiteConfig  implements Serializable {
 
	/////instantce variable//////
	private static final long serialVersionUID = 1L;
	private String id;
	private double tax=0.0;
	private double thirdPayRate=0.0;
	private double proportionBroker=0.0;
	private double proportionSite=0.0;
	private Integer limitChangeWorker;
	private java.sql.Timestamp configTime;
	private double timeLimit;
	private double manageTax;
	private Integer brokerMonth ;
	
	
 
	/////////constructor//////////////////
	
	public Integer getBrokerMonth() {
		return brokerMonth;
	}

	public void setBrokerMonth(Integer brokerMonth) {
		this.brokerMonth = brokerMonth;
	}

	public double getTimeLimit() {
		return timeLimit;
	}

	public void setTimeLimit(double timeLimit) {
		this.timeLimit = timeLimit;
	}

	public SiteConfig(String id,double tax,double thirdPayRate,double proportionBroker,double proportionSite,Integer limitChangeWorker,java.sql.Timestamp configTime,double timeLimit,Integer brokerMonth,double manageTax) {
		this.id = id;
		this.tax = tax;
		this.thirdPayRate = thirdPayRate;
		this.proportionBroker = proportionBroker;
		this.proportionSite = proportionSite;
		this.limitChangeWorker = limitChangeWorker;
		this.configTime = configTime;
		this.timeLimit=timeLimit;
		this.brokerMonth=brokerMonth;
		this.manageTax=manageTax;
	}//
	
	public SiteConfig(){
		super();
	}
 
	/////getter////setter//////
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public double  getThirdPayRate(){
		return this.thirdPayRate;
	}
	public void  setThirdPayRate(double thirdPayRate){
		this.thirdPayRate = thirdPayRate ;
	}
	
	public double getProportionBroker() {
		return proportionBroker;
	}

	public void setProportionBroker(double proportionBroker) {
		this.proportionBroker = proportionBroker;
	}

	public double getProportionSite() {
		return proportionSite;
	}

	public void setProportionSite(double proportionSite) {
		this.proportionSite = proportionSite;
	}

	public void  setProportionSite(Integer proportionSite){
		this.proportionSite = proportionSite ;
	}
	public Integer  getLimitChangeWorker(){
		return this.limitChangeWorker;
	}
	public void  setLimitChangeWorker(Integer limitChangeWorker){
		this.limitChangeWorker = limitChangeWorker ;
	}
	public java.sql.Timestamp  getConfigTime(){
		return this.configTime;
	}
	public void  setConfigTime(java.sql.Timestamp configTime){
		this.configTime = configTime ;
	}

	public double getManageTax() {
		return manageTax;
	}

	public void setManageTax(double manageTax) {
		this.manageTax = manageTax;
	}

 
}//end class
