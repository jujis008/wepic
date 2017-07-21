package com.wetuo.wepic.deal.beans ;
 
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
 
public class BidDetail  implements Serializable {
 
	/////instantce variable//////
	private static final long serialVersionUID = 1L;
	private String id;
	private String bidkey;
	private String value;
	private String picUrl;
	private String characteristic;
	private Integer type;
 
	////start OneToMany
	private Bid bid;//
	public Bid getBid() {
		return bid;
	}//end get()
	public void setBid(Bid bid) {
		this.bid = bid;
	}//end set()
	/////////constructor//////////////////
	
	public BidDetail(String id,String key,String value,String picUrl,String characteristic,Integer type) {
		this.id = id;
		this.bidkey = key;
		this.value = value;
		this.picUrl = picUrl;
		this.characteristic = characteristic;
		this.type = type;
	}//
	
	public BidDetail(){
		super();
	}
 
	/////getter////setter//////
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBidkey() {
		return bidkey;
	}
	public void setBidkey(String bidkey) {
		this.bidkey = bidkey;
	}
	public String  getValue(){
		return this.value;
	}
	public void  setValue(String value){
		this.value = value ;
	}
	public String  getPicUrl(){
		return this.picUrl;
	}
	public void  setPicUrl(String picUrl){
		this.picUrl = picUrl ;
	}
	public String  getCharacteristic(){
		return this.characteristic;
	}
	public void  setCharacteristic(String characteristic){
		this.characteristic = characteristic ;
	}
	public Integer  getType(){
		return this.type;
	}
	public void  setType(Integer type){
		this.type = type ;
	}
 
}//end class
