package com.wetuo.wepic.core.beans ;
 
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
import com.wetuo.wepic.core.beans.UserCat;
 
import java.util.*;
	
import java.util.*;
	
public class UserCat  implements Serializable {
 
	/////instantce variable//////
	private static final long serialVersionUID = 1L;
	private Integer id;
//	protected UserCat userCat;
	private String name;
	private String type;
	
	//protected PublishCat publishCat;
	private Integer pid;
	private String enName;
	private String discription;
	private String title;
	private String url;
	private String target;
	private String icon;
	private String iconOpen;
	private String checkboxId;
	private String roleMenu;
	private Integer register;
	 
	
 
	////start OneToMany
//	private Set<User> userSet  = new HashSet<User>();// 
//	public Set<User> getUserSet() {
//		return this.userSet;
//	}//end get
//	public void setUserSet(Set<User> userSet) {
//		this.userSet = userSet ;
//	}//end set
	////start OneToMany
	private Set<ResMenu> resMenuSet  = new HashSet<ResMenu>();// 
	public Set<ResMenu> getResMenuSet() {
		return this.resMenuSet;
	}//end get
	public void setResMenuSet(Set<ResMenu> resMenuSet) {
		this.resMenuSet = resMenuSet ;
	}//end set
	/////////constructor//////////////////
	
	public UserCat(Integer id,Integer pid,String name,String enName,String discription,String type) {
		this.id = id;
		this.pid = pid;
		this.name = name;
		this.enName=enName;
		this.discription = discription;
		this.type = type;
	}//
	
	public UserCat(){
		super();
	}
 
	/////getter////setter//////
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
//	public UserCat  getUserCat(){
//		return this.userCat;
//	}
//	public void  setUserCat(UserCat userCat){
//		this.userCat = userCat ;
//	}
	public String  getName(){
		return this.name;
	}
	public void  setName(String name){
		this.name = name ;
	}
	public String  getType(){
		return this.type;
	}
	public void  setType(String type){
		this.type = type ;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
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

	public String getRoleMenu() {
		return roleMenu;
	}

	public void setRoleMenu(String roleMenu) {
		this.roleMenu = roleMenu;
	}
	public Integer getRegister() {
		return register;
	}
	public void setRegister(Integer register) {
		this.register = register;
	}
	
	
 
}//end class
