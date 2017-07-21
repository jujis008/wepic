package com.wetuo.wepic.deal.beans ;
 
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
import com.wetuo.wepic.publish.beans.Publish;
 
public class BuyCommoditiesHistory  implements Serializable {
 
	/////instantce variable//////
	private static final long serialVersionUID = 1L;
	private String id;
	protected Publish publish;
	private Integer copyrightOrUsage;
	private Integer amount;
	private java.sql.Timestamp startTime;
 
	////start OneToMany
	private BuyHistory buyHistory;//
	public BuyHistory getBuyHistory() {
		return buyHistory;
	}//end get()
	public void setBuyHistory(BuyHistory buyHistory) {
		this.buyHistory = buyHistory;
	}//end set()
	/////////constructor//////////////////
	
	public BuyCommoditiesHistory(String id,Publish publish,Integer copyrightOrUsage,Integer amount,java.sql.Timestamp startTime) {
		this.id = id;
		this.publish = publish;
		this.copyrightOrUsage = copyrightOrUsage;
		this.amount = amount;
		this.startTime = startTime;
	}//
	
	public BuyCommoditiesHistory(){
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
 
}//end class
