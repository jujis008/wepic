package com.wetuo.wepic.core.actions ;
 
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.io.File;
import java.util.*;
import java.text.SimpleDateFormat;

import javax.management.relation.Role;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.wetuo.wepic.core.beans.UserCat;
import com.wetuo.wepic.core.service.UserCatService;
import com.wetuo.wepic.core.beans.UserCat;
import com.wetuo.wepic.core.service.UserCatService;
 
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.struts.PageAction;
import com.wetuo.wepic.common.struts.Constants;
import com.wetuo.wepic.common.struts.RegExpression;
import com.wetuo.wepic.publish.beans.PublishCat;
 
@SuppressWarnings("unchecked")
public class UserCatAction extends PageAction {
  
	/////instantce variable//////
	private static final long serialVersionUID = 1L;
	protected String id = null ; 
//	protected String userCatId = null ; 
	protected String pid;
 	private UserCatService userCatService;
	protected String name = null ; 
	protected String type = null ; 
	protected String username = null; 
	protected String role="";
	protected List roleList;
	protected List roleName;
	protected List<UserCat> verifyCat;
	
	
	//protected PublishCat publishCat;
	protected String roleMenu;
	
	protected String enName;
	protected String discription;
	protected String title;
	protected String url;
	protected String target;
	
	protected String icon;
	protected String iconOpen;
	protected String checkboxId;
	
	private List<UserCat> userCatlist = new ArrayList<UserCat>();
	
	@JSON(serialize = false)
	public String getUserCatJsonList(){
		try {
			userCatlist = this.getUserCatService().findAll();
			//System.out.println("userCatlist size :" + userCatlist.size());
//			for(PublishCat pubCat:publishCatlist ){
//				System.out.println("pubCat name :" + pubCat.getName());
//				//System.out.println("pubCat parent name :" + pubCat.getPublishCat().getName());
//				System.out.println("pubCat pid :" + pubCat.getPid());
//			}
			return "getUserCatJsonList";
		} catch (Exception e) {
			e.printStackTrace();
		}
	 return null;
	}
	

	public void validate() {
		
		clearErrorsAndMessages();
		
		String queryString = getRequestPath();
		if (queryString.indexOf("userCatadd!insert") != -1 || queryString.indexOf("userCatedit!update") != -1) {
		
			if (pid == null || pid.equals("")) {
				addFieldError("userCatId", "userCatId must be inputed");
			}//end if null
			if (name == null || name.equals("")) {
				addFieldError("name", "name must be inputed");
			}//end if null
			if (type == null || type.equals("")) {
				addFieldError("type", "type must be inputed");
			}//end if null
		}//end if
	}//end validate()
	public String initAdmin() throws Exception {
		clearErrorsAndMessages();
		super.pageSize = Constants.pageSize;
		super.pageNo = Constants.pageNo;
		super.pager = this.getUserCatService().list(super.pageSize, super.pageNo);
		//setSession(Constants.PAGER_USERCAT, super.pager);
		return Constants.LIST_KEY;
	}//end init()
		
	public String init() throws Exception {
		clearErrorsAndMessages();
		super.pageSize = Constants.pageSize;
		super.pageNo = Constants.pageNo;
		super.pager = this.getUserCatService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		//setSession(Constants.PAGER_USERCAT, super.pager);
		return Constants.LIST_KEY;
	}
	
	public String list() throws Exception {
		clearErrorsAndMessages();
		super.pager = this.getUserCatService().list(super.getLoginUsername(), super.pageSize, super.pageNo);	
		//setSession(Constants.PAGER_USERCAT, super.pager);
		return Constants.LIST_KEY;
	}//end list()
	
	public String allRole() throws Exception {
		clearErrorsAndMessages();
		//List<UserCat> userCats=userCatService.findAll();
		//common
		//List<UserCat> userCats=userCatService.getUserCatListJustUnderProjectCat(8);
		List<UserCat> userCats = userCatService.getUserCatListForRegister();
		
		verifyCat=new ArrayList<UserCat>();
		for(UserCat userCat:userCats){
			//if (userCat.getType().contains("photographer")||userCat.getType().contains("model")||userCat.getType().contains("broker")) {
				verifyCat.add(userCat);	
			//}
		}
		return "registerRole";
	}//end list()
		
	public String add() throws Exception {
		clearErrorsAndMessages();
		String loginName = super.getLoginUsername();
		if(loginName == null || loginName.length()==0)
		{
			return "login";
		}
		clearErrorsAndMessages();
		String pid = ServletActionContext.getRequest().getParameter("pid");
		ServletActionContext.getRequest().setAttribute("pid", pid);
		reset();
		return Constants.ADD_KEY;
	}//end add()
	private void reset() {
		setId(null);
		setPid(null);
		setName(null);
		setType(null);
		setRoleMenu(null);
		
		setEnName(null);
		setDiscription(null);
		setTitle(null);
		setUrl(null);
		setTarget(null);
	}//end reset()

	private void bean2Form(UserCat userCat) {
		setId(userCat.getId().toString());
		setPid(userCat.getPid().toString());
		setName(userCat.getName());
		setType(userCat.getType());
		setName(userCat.getName());
		setType(userCat.getType());
		setRoleMenu(userCat.getRoleMenu());
		setCheckboxId(userCat.getCheckboxId());
		setDiscription(userCat.getDiscription());
		setEnName(userCat.getEnName());
		setTarget(userCat.getTarget());
		setTitle(userCat.getTitle());
		setUrl(userCat.getUrl());
	}//end bean2Form()
	
	public String edit() throws Exception {
		clearErrorsAndMessages();
		if (this.getId() == null) {
			saveActionError("userCat.message.edit.notexist");
			return Constants.LIST_KEY;
		} else {
			UserCat userCat = this.getUserCatService().select(Integer.valueOf(id));
			if (userCat == null) {
				saveActionError("userCat.message.edit.notexist");
				return Constants.LIST_KEY;
			} else {
				bean2Form(userCat);
				return Constants.EDIT_KEY;
			}
		}//end if
		
	}//end edit()
		
	public String insert() throws Exception {
		// 
		clearErrorsAndMessages();
		Integer nid = null ;
		
		try{
//			UserCat userCatInstance = 	userCatService.select(Integer.parseInt(userCatId));
		    UserCat userCat = new UserCat();
//		    userCat.setUserCat(userCatInstance);   
			
		userCat.setRoleMenu(roleMenu);
		userCat.setPid(Integer.parseInt(pid));    
		userCat.setName(this.getName());
		userCat.setEnName(this.getEnName());
		userCat.setDiscription(this.getDiscription());
		userCat.setType(this.getType());
		userCat.setTitle(title);
		userCat.setCheckboxId(checkboxId);
		userCat.setIcon(icon);
		userCat.setIconOpen(iconOpen);
		userCat.setUrl(url);
		userCat.setTarget(target);
		nid = this.getUserCatService().insert(userCat);
		
		Pager pagerSession = (Pager) getSession(Constants.PAGER_USERCAT);
		if(pagerSession == null){
			super.pageSize = Constants.pageSize;
			super.pageNo = Constants.pageNo;
		}else{
			super.pageSize = pagerSession.getPageSize();
			super.pageNo = pagerSession.getPageNo();
			
		}
		
		//????????????
		super.pager = this.getUserCatService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		
		
		}catch(Exception e){
			saveActionError2(e.toString());
			saveActionMessage2(" Sorry ");
			return Constants.ERROR_KEY;
		}
		
		if (nid != null) {
			saveActionMessage("userCat.message.add.success");
			return Constants.LIST_KEY;
		} else {
			saveActionError("userCat.message.add.failed");
			return Constants.ADD_KEY;
		}
	}//end insert()
	public String update() throws Exception {
		clearErrorsAndMessages();
		try{
			UserCat userCat = this.getUserCatService().select(new Integer(id));
//			userCat.setRoleMenu(roleMenu);
			userCat.setPid(Integer.parseInt(pid));    
			userCat.setName(this.getName());
			userCat.setEnName(this.getEnName());
			userCat.setDiscription(this.getDiscription());
			userCat.setType(this.getType());
			userCat.setTitle(title);
			userCat.setCheckboxId(checkboxId);
			userCat.setIcon(icon);
			userCat.setIconOpen(iconOpen);
			userCat.setUrl(url);
			userCat.setTarget(target);
		this.getUserCatService().update(userCat);
		bean2Form(userCat);	
		Pager pagerSession = (Pager) getSession(Constants.PAGER_USERCAT);
		if(pagerSession == null){
			super.pageSize = Constants.pageSize;
			super.pageNo = Constants.pageNo;
		}else{
			super.pageSize = pagerSession.getPageSize();
			super.pageNo = pagerSession.getPageNo();
			
		}
			super.pager = this.getUserCatService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
			saveActionMessage("userCat.message.edit.success");
		}catch(Exception e){
			saveActionError2(e.toString());
			saveActionMessage2(" Sorry ");
			return Constants.ERROR_KEY;
		}
		
		return Constants.LIST_KEY;
	}//end update() 
	public String delete() throws Exception {
		clearErrorsAndMessages();
		try{
			if (this.getId() == null) {
				saveActionError("userCat.message.edit.notexist");
			} else {
				this.getUserCatService().delete(Integer.valueOf(id));
				saveActionMessage("userCat.message.delete.success");
			}
			super.pager = this.getUserCatService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		}catch(Exception e){
			saveActionError2(e.toString());
			saveActionMessage2("Please delete child first");
			return Constants.ERROR_KEY;
		}
		return Constants.LIST_KEY;
		
	}//end delete()
		
 
	/////getter////setter//////
	public String getId(){
		return  id;
	}
	public void  setId(String id){
		this.id = id ;
	}
	 
	public UserCatService getUserCatService() {
		return userCatService;
	}
	public void setUserCatService(UserCatService userCatService) {
		this.userCatService = userCatService;
	}
	
//	public String getUserCatId(){
//		return  userCatId;
//	}
//	public void  setUserCatId(String userCatId){
//		this.userCatId = userCatId ;
//	}
	 
	public String getName(){
		return  name;
	}
	public void  setName(String name){
		this.name = name ;
	}
	 
	public String getType(){
		return  type;
	}
	public void  setType(String type){
		this.type = type ;
	}
	 
	 public String getUsername() {
	 	return username;
	 }
	 public void setUsername(String username) {
	 	this.username = username;
	 }
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public List getRoleList() {
		return roleList;
	}
	public void setRoleList(List roleList) {
		this.roleList = roleList;
	}
	public List getRoleName() {
		return roleName;
	}
	public void setRoleName(List roleName) {
		this.roleName = roleName;
	}
	
	public List<UserCat> getUserCatlist() {
		return userCatlist;
	}
	public void setUserCatlist(List<UserCat> userCatlist) {
		this.userCatlist = userCatlist;
	}
	
	public List<UserCat> getVerifyCat() {
		return verifyCat;
	}
	public void setVerifyCat(List<UserCat> verifyCat) {
		this.verifyCat = verifyCat;
	}

	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
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


	////////////////////////////////////////////
	public static void main(String[] args) {
		List<String> a=new ArrayList<String>();
		a.add("xx");
		a.add("qq");
		a.add("ww");
		a.add("rr");
		a.add("tt");
		a.add("uu");
		System.out.println(a);
//		String t=a.toString().substring(1,a.toString().length()-1);
//		System.out.println(t);
//		String x[]=t.split(",");
//		for (int i = 0; i < x.length; i++) {
//			System.out.println(x[i]);
//		}
	}
	 
}//end class
