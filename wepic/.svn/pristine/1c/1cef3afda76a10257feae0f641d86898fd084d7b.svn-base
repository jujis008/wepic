package com.wetuo.wepic.core.beans ;
 
import java.io.Serializable;
import java.sql.Time;

import org.apache.commons.lang.builder.ToStringBuilder;
import com.wetuo.wepic.core.beans.User;
 
public class ChatMsg  implements Serializable {
 
	/////instantce variable//////
	private static final long serialVersionUID = 1L;
	private Integer id;
	protected User user;
	private String content;
	private Time chatTime;
	private String travler;
 
	/////////constructor//////////////////
	
	public ChatMsg(Integer id,User user,String content,Time chatTime,String travler) {
		this.id = id;
		this.user = user;
		this.content = content;
		this.chatTime = chatTime;
		this.travler = travler;
	}//
	
	public ChatMsg(){
		super();
	}
 
	/////getter////setter//////
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public User  getUser(){
		return this.user;
	}
	public void  setUser(User user){
		this.user = user ;
	}
	public String  getContent(){
		return this.content;
	}
	public void  setContent(String content){
		this.content = content ;
	}
	public Time getChatTime() {
		return chatTime;
	}
	public void setChatTime(Time chatTime) {
		this.chatTime = chatTime;
	}
	public String  getTravler(){
		return this.travler;
	}
	public void  setTravler(String travler){
		this.travler = travler ;
	}
 
}//end class
