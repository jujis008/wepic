package com.wetuo.wepic.deal.beans ;
 
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
 
public class BidAimPerson  implements Serializable {
 
	/////instantce variable//////
	private static final long serialVersionUID = 1L;
	private String id;
	private Integer type;
	private double money;
	private java.sql.Timestamp startTime;
	private Integer period;
	private Integer publicOrPrivate;
	private String demand;
	private  String bidid;
	private String workPlace;
    
	public String getWorkPlace() {
		return workPlace;
	}
	public void setWorkPlace(String workPlace) {
		this.workPlace = workPlace;
	}
	public String getBidid() {
		return bidid;
	}
	public void setBidid(String bidid) {
		this.bidid = bidid;
	}
	////start OneToMany
	private Bid bid;//
	public Bid getBid() {
		return bid;
	}//end get()
	public void setBid(Bid bid) {
		this.bid = bid;
	}//end set()
	/////////constructor//////////////////
	
	public BidAimPerson(String id,Integer type,double money,java.sql.Timestamp startTime,Integer period,Integer publicOrPrivate,String demand) {
		this.id = id;
		this.type = type;
		this.money = money;
		this.startTime = startTime;
		this.period = period;
		this.publicOrPrivate = publicOrPrivate;
		this.demand = demand;
	}//
	
	public BidAimPerson(){
		super();
	}
 
	/////getter////setter//////
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer  getType(){
		return this.type;
	}
	public void  setType(Integer type){
		this.type = type ;
	}
	public double  getMoney(){
		return this.money;
	}
	public void  setMoney(double money){
		this.money = money ;
	}
	public java.sql.Timestamp  getStartTime(){
		return this.startTime;
	}
	public void  setStartTime(java.sql.Timestamp startTime){
		this.startTime = startTime ;
	}
	public Integer  getPeriod(){
		return this.period;
	}
	public void  setPeriod(Integer period){
		this.period = period ;
	}
	public Integer  getPublicOrPrivate(){
		return this.publicOrPrivate;
	}
	public void  setPublicOrPrivate(Integer publicOrPrivate){
		this.publicOrPrivate = publicOrPrivate ;
	}
	public String  getDemand(){
		return this.demand;
	}
	public void  setDemand(String demand){
		this.demand = demand ;
	}
	@Override
	public String toString() {
		return "BidAimPerson [bid=" + bid + ", demand=" + demand + ", id=" + id
				+ ", money=" + money + ", period=" + period
				+ ", publicOrPrivate=" + publicOrPrivate + ", startTime="
				+ startTime + ", type=" + type + "]";
	}
 
	
	
}