package com.wetuo.wepic.publish.beans ;
 
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.cxf.tools.corba.common.idltypes.IdlAnonArray;

import com.wetuo.wepic.core.beans.User;
 
import java.util.*;
	
public class VideoSpecialCat  implements Serializable {
 
	/////instantce variable//////
	private static final long serialVersionUID = 1L;
	private Integer id;
	protected User user;
	private Integer vid;
	private String name;
	private String enName;
	private String discription;
	private String type;
	private String title;
	private String url;
	private String target;
	private String icon;
	private String iconOpen;
	private String checkboxId;
	////start OneToMany
	private Set<Video> publishSet  = new HashSet<Video>();// 
	public Set<Video> getPublishSet() {
		return this.publishSet;
	}//end get
	public void setPublishSet(Set<Video> publishSet) {
		this.publishSet = publishSet ;
	}//end set
	/////////constructor//////////////////
	
	public VideoSpecialCat(Integer id,Integer vid,String name,String type){
		this.id=id;
		this.vid=vid;
		this.name=name;
		this.type=type;
	}
	public VideoSpecialCat(Integer id,User user,Integer vid,String name,String enName,String discription,String type,String title,String url,String target,String icon,String iconOpen,String checkboxId) {
		this.id = id;
		this.user = user;
		this.vid = vid;
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
	
	public VideoSpecialCat(){
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

	public Integer getVid() {
		return vid;
	}
	public void setVid(Integer vid) {
		this.vid = vid;
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
 
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		 String s =id+","+name;
		return s;
	}
}//end class
