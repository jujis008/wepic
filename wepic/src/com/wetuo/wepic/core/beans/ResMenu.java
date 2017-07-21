package com.wetuo.wepic.core.beans ;
 
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
 
import java.util.*;
	
import java.util.*;
	
public class ResMenu  implements Serializable {
 
	/////instantce variable//////
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer type;//menuType : 0  不清楚, 1 管理空间, 2 只读空间 ,3 管理and只读空间
	private String name;
	private String enName;
	private String linkUrl;
	private String discription;
	private String target;
 
	////start OneToMany
	private UserCat userCat;//
	public UserCat getUserCat() {
		return userCat;
	}//end get()
	public void setUserCat(UserCat userCat) {
		this.userCat = userCat;
	}//end set()
	////start OneToMany
	private Set<ResMenuItem> resMenuItemSet  = new HashSet<ResMenuItem>();// 
	public Set<ResMenuItem> getResMenuItemSet() {
		return this.resMenuItemSet;
	}//end get
	public void setResMenuItemSet(Set<ResMenuItem> resMenuItemSet) {
		this.resMenuItemSet = resMenuItemSet ;
	}//end set
	////start OneToMany
	private Set<ResLeftSideItem> resLeftSideItemSet  = new HashSet<ResLeftSideItem>();// 
	public Set<ResLeftSideItem> getResLeftSideItemSet() {
		return this.resLeftSideItemSet;
	}//end get
	public void setResLeftSideItemSet(Set<ResLeftSideItem> resLeftSideItemSet) {
		this.resLeftSideItemSet = resLeftSideItemSet ;
	}//end set
	/////////constructor//////////////////
	
	public ResMenu(Integer id,Integer type,String name,String enName,String linkUrl,String discription,String target) {
		this.id = id;
		this.type = type;
		this.name = name;
		this.enName = enName;
		this.linkUrl = linkUrl;
		this.discription = discription;
		this.target = target;
	}//
	
	public ResMenu(){
		super();
	}
 
	/////getter////setter//////
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer  getType(){
		return this.type;
	}
	public void  setType(Integer type){
		this.type = type ;
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
	public String  getLinkUrl(){
		return this.linkUrl;
	}
	public void  setLinkUrl(String linkUrl){
		this.linkUrl = linkUrl ;
	}
	public String  getDiscription(){
		return this.discription;
	}
	public void  setDiscription(String discription){
		this.discription = discription ;
	}
	public String  getTarget(){
		return this.target;
	}
	public void  setTarget(String target){
		this.target = target ;
	}
 
}//end class
