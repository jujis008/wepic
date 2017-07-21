package com.wetuo.wepic.core.beans ;
 
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
 
public class UserHistory  implements Serializable {
 
	/////instantce variable//////
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String residenceAddress;
	private String livingAddress;
	private String job;
	private java.sql.Date startTime;
	private java.sql.Date endTime;
	private Integer mobile;
	private Integer phone;
	private String deliveryPlace;
 
	////start OneToMany
	private User user;//
	public User getUser() {
		return user;
	}//end get()
	public void setUser(User user) {
		this.user = user;
	}//end set()
	/////////constructor//////////////////
	
	public UserHistory(Integer id,String residenceAddress,String livingAddress,String job,java.sql.Date startTime,java.sql.Date endTime,Integer mobile,Integer phone,String deliveryPlace) {
		this.id = id;
		this.residenceAddress = residenceAddress;
		this.livingAddress = livingAddress;
		this.job = job;
		this.startTime = startTime;
		this.endTime = endTime;
		this.mobile = mobile;
		this.phone = phone;
		this.deliveryPlace = deliveryPlace;
	}//
	
	public UserHistory(){
		super();
	}
 
	/////getter////setter//////
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String  getResidenceAddress(){
		return this.residenceAddress;
	}
	public void  setResidenceAddress(String residenceAddress){
		this.residenceAddress = residenceAddress ;
	}
	public String  getLivingAddress(){
		return this.livingAddress;
	}
	public void  setLivingAddress(String livingAddress){
		this.livingAddress = livingAddress ;
	}
	public String  getJob(){
		return this.job;
	}
	public void  setJob(String job){
		this.job = job ;
	}
	public java.sql.Date  getStartTime(){
		return this.startTime;
	}
	public void  setStartTime(java.sql.Date startTime){
		this.startTime = startTime ;
	}
	public java.sql.Date  getEndTime(){
		return this.endTime;
	}
	public void  setEndTime(java.sql.Date endTime){
		this.endTime = endTime ;
	}
	public Integer  getMobile(){
		return this.mobile;
	}
	public void  setMobile(Integer mobile){
		this.mobile = mobile ;
	}
	public Integer  getPhone(){
		return this.phone;
	}
	public void  setPhone(Integer phone){
		this.phone = phone ;
	}
	public String  getDeliveryPlace(){
		return this.deliveryPlace;
	}
	public void  setDeliveryPlace(String deliveryPlace){
		this.deliveryPlace = deliveryPlace ;
	}
 
}//end class
