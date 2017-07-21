package com.wetuo.wepic.publish.beans ;
 
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.wetuo.wepic.core.beans.User;

 
import java.util.*;
	
public class VideoCat  implements Serializable {
 
	/////instantce variable//////
	private static final long serialVersionUID = 1L;
	private Integer id;
	//protected PublishCat publishCat;
	private Integer vid;
	private String name;
	private String discription;
	private String type;
	private String title;
	private String url;
	private String target;
	private String icon;
	private String iconOpen;
	public Integer getVid() {
		return vid;
	}
	public void setVid(Integer vid) {
		this.vid = vid;
	}
	private String checkboxId;
	//private User user ;
	private Integer userId ;
	private String tags ;
	
	
	
	
 
	
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getIconOpen() {
		return iconOpen;
	}
	public void setIconOpen(String iconOpen) {
		this.iconOpen = iconOpen;
	}
	public String getCheckboxId() {
		return checkboxId;
	}
	public void setCheckboxId(String checkboxId) {
		this.checkboxId = checkboxId;
	}
	////start OneToMany
//	private Set<Publish> publishSet  = new HashSet<Publish>();// 
//	public Set<Publish> getPublishSet() {
//		return this.publishSet;
//	}//end get
//	public void setPublishSet(Set<Publish> publishSet) {
//		this.publishSet = publishSet ;
//	}//end set
	/////////constructor//////////////////
	
	public VideoCat(Integer id,Integer vid,String name,String discription,String type) {
		this.id = id;
		this.vid = vid;
		this.name = name;
		this.discription = discription;
		this.type = type;
	}//
	
	public VideoCat(){
		super();
	}
 
	/////getter////setter//////
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
//	public PublishCat  getPublishCat(){
//		return this.publishCat;
//	}
//	public void  setPublishCat(PublishCat publishCat){
//		this.publishCat = publishCat ;
//	}
	public String  getName(){
		return this.name;
	}
	public void  setName(String name){
		this.name = name ;
	}
	
	public String  getDiscription(){
		return this.discription;
	}
	public void  setDiscription(String discription){
		this.discription = discription ;
	}
	public String  getType(){
		return this.type;
	}
	public void  setType(String type){
		this.type = type ;
	}
	
//	public User getUser() {
//		return user;
//	}
//	public void setUser(User user) {
//		this.user = user;
//	}
	
	
 
}//end class
