package com.wetuo.wepic.core.beans ;
 
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
 
public class LoginHistory  implements Serializable {
 
	/////instantce variable//////
	private static final long serialVersionUID = 1L;
	private Integer id;
	private java.sql.Timestamp loginTime;
	private java.sql.Timestamp loginOutTime;
 
	////start OneToMany
	private User user;//
	public User getUser() {
		return user;
	}//end get()
	public void setUser(User user) {
		this.user = user;
	}//end set()
	/////////constructor//////////////////
	
	public LoginHistory(Integer id,java.sql.Timestamp loginTime,java.sql.Timestamp loginOutTime) {
		this.id = id;
		this.loginTime = loginTime;
		this.loginOutTime = loginOutTime;
	}//
	
	public LoginHistory(){
		super();
	}
 
	/////getter////setter//////
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public java.sql.Timestamp  getLoginTime(){
		return this.loginTime;
	}
	public void  setLoginTime(java.sql.Timestamp loginTime){
		this.loginTime = loginTime ;
	}
	public java.sql.Timestamp  getLoginOutTime(){
		return this.loginOutTime;
	}
	public void  setLoginOutTime(java.sql.Timestamp loginOutTime){
		this.loginOutTime = loginOutTime ;
	}
 
}//end class
