package com.wetuo.wepic.core.beans ;
 
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.core.beans.User;
 
public class Contact  implements Serializable {
 
	/////instantce variable//////
	private static final long serialVersionUID = 1L;
	private Integer id;
	protected User fromUser;
	protected User toUser;
	private Integer action;	//是否关注 0(未关注)1(已关注)
	private Integer accept;
	private Integer eachAttention;	//是否互相关注0(未互相关注)1(互相关注)
	private java.sql.Timestamp startTime;
	private java.sql.Timestamp acceptTime;
 
	/////////constructor//////////////////
	

	public Contact(Integer id,User fromUser,User toUser,Integer action,Integer accept,Integer eachAttention,java.sql.Timestamp startTime,java.sql.Timestamp acceptTime) {
		this.id = id;
		this.fromUser = fromUser;
		this.toUser = toUser;
		this.action = action;
		this.accept = accept;
		this.eachAttention=eachAttention;
		this.startTime = startTime;
		this.acceptTime = acceptTime;
	}//
	
	public Integer getEachAttention() {
		return eachAttention;
	}

	public void setEachAttention(Integer eachAttention) {
		this.eachAttention = eachAttention;
	}

	public Contact(){
		super();
	}
 
	/////getter////setter//////
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	public Integer  getAccept(){
		return this.accept;
	}
	public void  setAccept(Integer accept){
		this.accept = accept ;
	}
	public java.sql.Timestamp  getStartTime(){
		return this.startTime;
	}
	public void  setStartTime(java.sql.Timestamp startTime){
		this.startTime = startTime ;
	}
	public java.sql.Timestamp  getAcceptTime(){
		return this.acceptTime;
	}
	public void  setAcceptTime(java.sql.Timestamp acceptTime){
		this.acceptTime = acceptTime ;
	}

	public User getFromUser() {
		return fromUser;
	}

	public void setFromUser(User fromUser) {
		this.fromUser = fromUser;
	}

	public User getToUser() {
		return toUser;
	}

	public void setToUser(User toUser) {
		this.toUser = toUser;
	}

	public Integer getAction() {
		return action;
	}

	public void setAction(Integer action) {
		this.action = action;
	}
	
 
}//end class
