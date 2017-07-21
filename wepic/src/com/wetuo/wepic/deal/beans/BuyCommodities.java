package com.wetuo.wepic.deal.beans ;
 
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;

import com.wetuo.wepic.publish.beans.Publish;
 
public class BuyCommodities  implements Serializable {
 
	/////instantce variable//////
	private static final long serialVersionUID = 1L;
	private String id;
	protected Publish publish;
	private Integer copyrightOrUsage;
	private Integer amount;
	private java.sql.Timestamp startTime;
	private Integer copyrighTotalPrice;
	private Integer usgeTotalPrice;
	private Integer copyAndUsePrice;
	private String userName;
	private String nickName;
	private String buyTime;
	//private CountDeal countDeal;
	
	
	public String getBuyTime() {
		return buyTime;
	}
	public void setBuyTime(String buyTime) {
		this.buyTime = buyTime;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public Integer getCopyrighTotalPrice() {
		return copyrighTotalPrice;
	}
	public void setCopyrighTotalPrice(Integer copyrighTotalPrice) {
		this.copyrighTotalPrice = copyrighTotalPrice;
	}
	public Integer getUsgeTotalPrice() {
		return usgeTotalPrice;
	}
	public void setUsgeTotalPrice(Integer usgeTotalPrice) {
		this.usgeTotalPrice = usgeTotalPrice;
	}
	
 
	////start OneToMany
	private BuyCartDeal buyCartDeal;//
	public BuyCartDeal getBuyCartDeal() {
		return buyCartDeal;
	}//end get()
	public void setBuyCartDeal(BuyCartDeal buyCartDeal) {
		this.buyCartDeal = buyCartDeal;
	}//end set()
	/////////constructor//////////////////
	
	public BuyCommodities(String id,Publish publish,Integer copyrightOrUsage,Integer amount,java.sql.Timestamp startTime,Integer copyTotal,Integer usageTotal,Integer copyAndUsePrice) {
		this.id = id;
		this.publish = publish;
		this.copyrightOrUsage = copyrightOrUsage;
		this.amount = amount;
		this.startTime = startTime;
		this.copyrighTotalPrice=copyTotal;
		this.usgeTotalPrice=usageTotal;
		this.copyAndUsePrice=copyAndUsePrice;
	}//
	
	public BuyCommodities(){
		super();
	}
 
	/////getter////setter//////
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Publish  getPublish(){
		return this.publish;
	}
	public void  setPublish(Publish publish){
		this.publish = publish ;
	}
	public Integer  getCopyrightOrUsage(){
		return this.copyrightOrUsage;
	}
	public void  setCopyrightOrUsage(Integer copyrightOrUsage){
		this.copyrightOrUsage = copyrightOrUsage ;
	}
	public Integer  getAmount(){
		return this.amount;
	}
	public void  setAmount(Integer amount){
		this.amount = amount ;
	}
	public java.sql.Timestamp  getStartTime(){
		return this.startTime;
	}
	public void  setStartTime(java.sql.Timestamp startTime){
		this.startTime = startTime ;
	}
	public Integer getCopyAndUsePrice() {
		return copyAndUsePrice;
	}
	public void setCopyAndUsePrice(Integer copyAndUsePrice) {
		this.copyAndUsePrice = copyAndUsePrice;
	}
 
}//end class
