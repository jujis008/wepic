package com.wetuo.wepic.core.beans ;
 
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
 
import java.util.*;
	
public class ResMenuItem  implements Serializable {
 
	/////instantce variable//////
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer type;
	private String name;
	private String enName;
	private String linkUrl;
	private String target;
	private String discription;
 
	////start OneToMany
	private ResMenu resMenu;//
	public ResMenu getResMenu() {
		return resMenu;
	}//end get()
	public void setResMenu(ResMenu resMenu) {
		this.resMenu = resMenu;
	}//end set()
	////start OneToMany
	private Set<ResLeftSideItem> resLeftSideItemSet  = new HashSet<ResLeftSideItem>();// 
	public Set<ResLeftSideItem> getResLeftSideItemSet() {
		return this.resLeftSideItemSet;
	}//end get
	public void setResLeftSideItemSet(Set<ResLeftSideItem> resLeftSideItemSet) {
		this.resLeftSideItemSet = resLeftSideItemSet ;
	}//end set
	/////////constructor//////////////////
	
	public ResMenuItem(Integer id,Integer type,String name,String enName,String linkUrl,String target,String discription) {
		this.id = id;
		this.type = type;
		this.name = name;
		this.enName = enName;
		this.linkUrl = linkUrl;
		this.target = target;
		this.discription = discription;
	}//
	
	public ResMenuItem(){
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
	public String  getTarget(){
		return this.target;
	}
	public void  setTarget(String target){
		this.target = target ;
	}
	public String  getDiscription(){
		return this.discription;
	}
	public void  setDiscription(String discription){
		this.discription = discription ;
	}
 
}//end class
