package com.wetuo.wepic.deal.beans ;
 
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
import com.wetuo.wepic.core.beans.User;
 
import java.util.*;
	
import java.util.*;
	
public class BuyCartDeal  implements Serializable {
 
	/////instantce variable//////
	private static final long serialVersionUID = 1L;
	private String id;
	protected User user;
	private double totalMoney;
	private String dealCode;
	private Integer status;//状态：0-仅仅是购物车；1-确认订单 2-结算，还可以修改；3-作废；4-结算，不可修改；5-交易失败；6-交易成功
	private java.sql.Timestamp deliveryTime;
	private String invoiceHead;
	private Integer invoiceType;
	private String invoiceContent;
	private String buyerAssess;
	private Integer goodsNum;
 
	
	public Integer getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(Integer goodsNum) {
		this.goodsNum = goodsNum;
	}
	////start OneToMany
	private Set<BuyCommodities> buyCommoditiesSet  = new HashSet<BuyCommodities>();// 
	public Set<BuyCommodities> getBuyCommoditiesSet() {
		return this.buyCommoditiesSet;
	}//end get
	public void setBuyCommoditiesSet(Set<BuyCommodities> buyCommoditiesSet) {
		this.buyCommoditiesSet = buyCommoditiesSet ;
	}//end set
	////start OneToMany
	private Set<BuyAccountOperation> buyAccountOperationSet  = new HashSet<BuyAccountOperation>();// 
	public Set<BuyAccountOperation> getBuyAccountOperationSet() {
		return this.buyAccountOperationSet;
	}//end get
	public void setBuyAccountOperationSet(Set<BuyAccountOperation> buyAccountOperationSet) {
		this.buyAccountOperationSet = buyAccountOperationSet ;
	}//end set
	/////////constructor//////////////////
	
	public BuyCartDeal(String id,User user,double totalMoney,String dealCode,Integer status,java.sql.Timestamp deliveryTime,String invoiceHead,Integer invoiceType,String invoiceContent,String buyerAssess) {
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
	
	public BuyCartDeal(){
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
