package com.wetuo.wepic.core.beans ;
 
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
 
public class UserDetail  implements Serializable {
 
	/////instantce variable//////
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String type;//1图片 2摄影故事
	private String picName;
	private String picUrl;
   // private String type;
    private UserPower userPower;
	////start OneToMany
	private User user;//
	public User getUser() {
		return user;
	}//end get()
	public void setUser(User user) {
		this.user = user;
	}//end set()
	/////////constructor//////////////////
	
	public UserDetail(Integer id,String name,String value,String picName,String picUrl) {
		this.id = id;
		this.name = name;
		this.picName = picName;
		this.picUrl = picUrl;
	}//
	
	public UserDetail(){
		super();
	}
 
	/////getter////setter//////
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String  getPicName(){
		return this.picName;
	}
	public void  setPicName(String picName){
		this.picName = picName ;
	}
	public String  getPicUrl(){
		return this.picUrl;
	}
	public void  setPicUrl(String picUrl){
		this.picUrl = picUrl ;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public UserPower getUserPower() {
		return userPower;
	}
	public void setUserPower(UserPower userPower) {
		this.userPower = userPower;
	}
	
	
 
}//end class
