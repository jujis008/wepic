package com.wetuo.wepic.deal.beans ;
 
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
import com.wetuo.wepic.core.beans.User;
 
import java.util.*;
	
import java.util.*;
	
public class BuyHistory  implements Serializable {
 
	/////instantce variable//////
	private static final long serialVersionUID = 1L;
	private String id;
	protected User user;
	private double totalMoney;
	private String dealCode;
	private Integer status;
	private java.sql.Timestamp deliveryTime;
	private String invoiceHead;
	private Integer invoiceType;
	private String invoiceContent;
	private String buyerAssess;
 
	////start OneToMany
	private Set<BuyAccountOperationHistory> buyAccountOperationHistorySet  = new HashSet<BuyAccountOperationHistory>();// 
	public Set<BuyAccountOperationHistory> getBuyAccountOperationHistorySet() {
		return this.buyAccountOperationHistorySet;
	}//end get
	public void setBuyAccountOperationHistorySet(Set<BuyAccountOperationHistory> buyAccountOperationHistorySet) {
		this.buyAccountOperationHistorySet = buyAccountOperationHistorySet ;
	}//end set
	////start OneToMany
	private Set<BuyCommoditiesHistory> buyCommoditiesHistorySet  = new HashSet<BuyCommoditiesHistory>();// 
	public Set<BuyCommoditiesHistory> getBuyCommoditiesHistorySet() {
		return this.buyCommoditiesHistorySet;
	}//end get
	public void setBuyCommoditiesHistorySet(Set<BuyCommoditiesHistory> buyCommoditiesHistorySet) {
		this.buyCommoditiesHistorySet = buyCommoditiesHistorySet ;
	}//end set
	/////////constructor//////////////////
	
	public BuyHistory(String id,User user,double totalMoney,String dealCode,Integer status,java.sql.Timestamp deliveryTime,String invoiceHead,Integer invoiceType,String invoiceContent,String buyerAssess) {
		this.id = id;
		this.user = user;
		this.totalMoney = totalMoney;
		this.dealCode = dealCode;
		this.status = status;
		this.deliveryTime = deliveryTime;
		this.invoiceHead = invoiceHead;
		this.invoiceType = invoiceType;
		this.invoiceContent = invoiceContent;
		this.buyerAssess = buyerAssess;
	}//
	
	public BuyHistory(){
		super();
	}
 
	/////getter////setter//////
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public User  getUser(){
		return this.user;
	}
	public void  setUser(User user){
		this.user = user ;
	}
	public double  getTotalMoney(){
		return this.totalMoney;
	}
	public void  setTotalMoney(double totalMoney){
		this.totalMoney = totalMoney ;
	}
	public String  getDealCode(){
		return this.dealCode;
	}
	public void  setDealCode(String dealCode){
		this.dealCode = dealCode ;
	}
	public Integer  getStatus(){
		return this.status;
	}
	public void  setStatus(Integer status){
		this.status = status ;
	}
	public java.sql.Timestamp  getDeliveryTime(){
		return this.deliveryTime;
	}
	public void  setDeliveryTime(java.sql.Timestamp deliveryTime){
		this.deliveryTime = deliveryTime ;
	}
	public String  getInvoiceHead(){
		return this.invoiceHead;
	}
	public void  setInvoiceHead(String invoiceHead){
		this.invoiceHead = invoiceHead ;
	}
	public Integer  getInvoiceType(){
		return this.invoiceType;
	}
	public void  setInvoiceType(Integer invoiceType){
		this.invoiceType = invoiceType ;
	}
	public String  getInvoiceContent(){
		return this.invoiceContent;
	}
	public void  setInvoiceContent(String invoiceContent){
		this.invoiceContent = invoiceContent ;
	}
	public String  getBuyerAssess(){
		return this.buyerAssess;
	}
	public void  setBuyerAssess(String buyerAssess){
		this.buyerAssess = buyerAssess ;
	}
 
}//end class
