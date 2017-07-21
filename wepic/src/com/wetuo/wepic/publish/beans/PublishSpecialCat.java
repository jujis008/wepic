package com.wetuo.wepic.publish.beans ;
 
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.cxf.tools.corba.common.idltypes.IdlAnonArray;
import org.apache.struts2.json.annotations.JSON;

import com.wetuo.wepic.core.beans.User;
 
import java.sql.Timestamp;
import java.util.*;
	
public class PublishSpecialCat  implements Serializable {
 
	/////instantce variable//////
	private static final long serialVersionUID = 1L;
	private Integer id;
	protected User user;
	private Integer pid;
	private String name;
	private String enName;
	private String discription;
	private String type;
	private String title;
	private String url;
	private String target;//专辑位置
	private String icon;//专辑颜色
	private String iconOpen;
	private String checkboxId;//0为被删除1已删除
	private Timestamp uploadTime;
	////start OneToMany
	
	private Set<Story> storySet  = new HashSet<Story>();// 
	public Set<Story> getStorySet() {
		return storySet;
	}
	public void setStorySet(Set<Story> storySet) {
		this.storySet = storySet;
	}

	private Set<Publish> publishSet  = new HashSet<Publish>();// 
	@JSON(serialize=false)
	public Set<Publish> getPublishSet() {
		return this.publishSet;
	}//end get
	public void setPublishSet(Set<Publish> publishSet) {
		this.publishSet = publishSet ;
	}//end set
	/////////constructor//////////////////
	
	public PublishSpecialCat(Integer id,Integer pid,String name,String type){
		this.id=id;
		this.pid=pid;
		this.name=name;
		this.type=type;
	}
	public PublishSpecialCat(Integer id,User user,Integer pid,String name,String enName,String discription,String type,String title,String url,String target,String icon,String iconOpen,String checkboxId) {
		this.id = id;
		this.user = user;
		this.pid = pid;
		this.name = name;
		this.enName = enName;
		this.discription = discription;
		this.type = type;
		this.title = title;
		this.url = url;
		this.target = target;
		this.icon = icon;
		this.iconOpen = iconOpen;
		this.checkboxId = checkboxId;
	}//
	
	public PublishSpecialCat(){
		super();
	}
 
	/////getter////setter//////
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@JSON(serialize=false)
	public User  getUser(){
		return this.user;
	}
	public void  setUser(User user){
		this.user = user ;
	}
	public Integer  getPid(){
		return this.pid;
	}
	public void  setPid(Integer pid){
		this.pid = pid ;
	}
	public String  getName(){
		return this.name;
	}
	public void  setName(String name){
		this.name = name ;
	}
	public String  getEnName(){
		return this.enName;
	}
	public void  setEnName(String enName){
		this.enName = enName ;
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
	public String  getTitle(){
		return this.title;
	}
	public void  setTitle(String title){
		this.title = title ;
	}
	public String  getUrl(){
		return this.url;
	}
	public void  setUrl(String url){
		this.url = url ;
	}
	public String  getTarget(){
		return this.target;
	}
	public void  setTarget(String target){
		this.target = target ;
	}
	public String  getIcon(){
		return this.icon;
	}
	public void  setIcon(String icon){
		this.icon = icon ;
	}
	public String  getIconOpen(){
		return this.iconOpen;
	}
	public void  setIconOpen(String iconOpen){
		this.iconOpen = iconOpen ;
	}
	public String  getCheckboxId(){
		return this.checkboxId;
	}
	public void  setCheckboxId(String checkboxId){
		this.checkboxId = checkboxId ;
	}
	public Timestamp getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(Timestamp uploadTime) {
		this.uploadTime = uploadTime;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		 String s =id+","+name;
		return s;
	}
}//end class
