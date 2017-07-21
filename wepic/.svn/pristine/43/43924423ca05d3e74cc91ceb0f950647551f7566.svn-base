package com.wetuo.wepic.core.actions ;
 
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.StringTokenizer;
import java.io.File;
import java.util.*;
import java.text.SimpleDateFormat;
import com.wetuo.wepic.core.beans.ResMenu;
import com.wetuo.wepic.core.service.ResMenuService;
 
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.struts.PageAction;
import com.wetuo.wepic.common.struts.Constants;
import com.wetuo.wepic.common.struts.RegExpression;
 
 
import org.apache.struts2.ServletActionContext;
import com.wetuo.wepic.core.beans.UserCat;
import com.wetuo.wepic.core.service.UserCatService;
	
public class ResMenuAction extends PageAction {
		
	private UserCatService userCatService;
	public UserCatService getUserCatService() {
		return userCatService;
	}
	public void setUserCatService(UserCatService userCatService) {
		this.userCatService = userCatService;
	}
 
	/////instantce variable//////
	private static final long serialVersionUID = 1L;
	protected String id = null ; 
 	private ResMenuService resMenuService;
	protected String type = null ; 
	protected String name = null ; 
	protected String enName = null ; 
	protected String linkUrl = null ; 
	protected String discription = null ; 
	protected String target = null ; 
	protected String username = null; 

	public void validate() {
		clearErrorsAndMessages();
		String queryString = getRequestPath();
		if (queryString.indexOf("resMenuadd!insert") != -1 || queryString.indexOf("resMenuedit!update") != -1) {
			if (type == null || type.equals("")) {
				addFieldError("type", "type must be inputed");
			}//end if null
			if (name == null || name.equals("")) {
				addFieldError("name", "name must be inputed");
			}//end if null
			if (enName == null || enName.equals("")) {
				addFieldError("enName", "enName must be inputed");
			}//end if null
			if (linkUrl == null || linkUrl.equals("")) {
				addFieldError("linkUrl", "linkUrl must be inputed");
			}//end if null
			if (discription == null || discription.equals("")) {
				addFieldError("discription", "discription must be inputed");
			}//end if null
			if (target == null || target.equals("")) {
				addFieldError("target", "target must be inputed");
			}//end if null
			if (name == null || name.equals("")) {
				addFieldError("name", getText("resMenu.error.name"));
			}
		}//end if
	}//end validate()
	
	public String init() throws Exception {
		clearErrorsAndMessages();
		super.pageSize = Constants.pageSize;
		super.pageNo = Constants.pageNo;
		super.pager = this.getResMenuService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		setSession(Constants.PAGER_RESMENU, super.pager);
		return Constants.LIST_KEY;
	}//end init()
	
	public String initOfRole() throws Exception {
		clearErrorsAndMessages();
		//roleId
		String roleId = ServletActionContext.getRequest().getParameter("roleId");
		ServletActionContext.getRequest().setAttribute("roleId", roleId);
//		super.pageSize = Constants.pageSize;
//		super.pageNo = Constants.pageNo;
		super.pager = this.getResMenuService().list(Integer.parseInt(roleId), super.pageSize, super.pageNo); 
		//setSession(Constants.PAGER_RESMENU, super.pager);
		
		
		return Constants.LIST_KEY;
	}//end init()
		
		
	public String list() throws Exception {
		clearErrorsAndMessages();
		super.pager = this.getResMenuService().list(super.getLoginUsername(), super.pageSize, super.pageNo);	
		setSession(Constants.PAGER_RESMENU, super.pager);
		return Constants.LIST_KEY;
	}//end list()
		
	public String add() throws Exception {
	//	String roleId = ServletActionContext.getRequest().getParameter("roleId");
		System.out.println("F2 add getParameter of oneId: "+ServletActionContext.getRequest().getParameter("oneId"));
		if(ServletActionContext.getRequest().getParameter("from") != null && ServletActionContext.getRequest().getParameter("from") != ""){
			if(ServletActionContext.getRequest().getParameter("from").indexOf("resMenu") > -1){
				ServletActionContext.getResponse().sendRedirect("userCat!init.do");
			}
		}
		ServletActionContext.getRequest().setAttribute("oneId", ServletActionContext.getRequest().getParameter("oneId"));
		ServletActionContext.getRequest().setAttribute("roleId", ServletActionContext.getRequest().getParameter("roleId"));
		clearErrorsAndMessages();
		reset();
		//ServletActionContext.getRequest().setAttribute("roleId", roleId);
		return Constants.ADD_KEY;
	}//end add()
	
	public String addUnderRole() throws Exception {
		clearErrorsAndMessages();
		String roleId = ServletActionContext.getRequest().getParameter("roleId");
		ServletActionContext.getRequest().setAttribute("roleId", roleId);
		reset();
		return Constants.ADD_KEY;
	}//end add()
	
	private void reset() {
		setId(null);
		setType(null);
		setName(null);
		setEnName(null);
		setLinkUrl(null);
		setDiscription(null);
		setTarget(null);
	}//end reset()

	private void bean2Form(ResMenu resMenu) {
		setId(resMenu.getId().toString());
		setType(resMenu.getType().toString()      );
		setName(resMenu.getName());
		setEnName(resMenu.getEnName());
		setLinkUrl(resMenu.getLinkUrl());
		setDiscription(resMenu.getDiscription());
		setTarget(resMenu.getTarget());
	}//end bean2Form()
	
	public String edit() throws Exception {
		clearErrorsAndMessages();
		String roleId = ServletActionContext.getRequest().getParameter("roleId");
		ServletActionContext.getRequest().setAttribute("roleId", roleId);
		if (this.getId() == null) {
			saveActionError("resMenu.message.edit.notexist");
			return Constants.LIST_KEY;
		} else {
			ResMenu resMenu = this.getResMenuService().select(Integer.valueOf(id));
			if (resMenu == null) {
				saveActionError("resMenu.message.edit.notexist");
				return Constants.LIST_KEY;
			} else {
				bean2Form(resMenu);
				return Constants.EDIT_KEY;
			}
		}//end if
	}//end edit()
		
	public String insert() throws Exception {
		String roleId = ServletActionContext.getRequest().getParameter("roleId");
		ServletActionContext.getRequest().setAttribute("roleId", roleId) ; 
		clearErrorsAndMessages();
		Integer nid = null ;
		try{
		//
		ResMenu resMenu = new ResMenu();
		resMenu.setType(Integer.valueOf(this.getType() ));
		resMenu.setName(this.getName());
		resMenu.setEnName(this.getEnName());
		resMenu.setLinkUrl(this.getLinkUrl());
		resMenu.setDiscription(this.getDiscription());
		resMenu.setTarget(this.getTarget());
		//String strOneId = ServletActionContext.getRequest().getParameter("roleId");
		System.out.println("F2 insert getParameter  of oneId:"+roleId);
		UserCat oneInstance = this.getUserCatService().select(Integer.parseInt(roleId));
		resMenu.setUserCat(oneInstance);
		
		nid = this.getResMenuService().insert(resMenu);
		
		Pager pagerSession = (Pager) getSession(Constants.PAGER_RESMENU);
		if(pagerSession == null){
			super.pageSize = Constants.pageSize;
			super.pageNo = Constants.pageNo;
		}else{
			super.pageSize = pagerSession.getPageSize();
			super.pageNo = pagerSession.getPageNo();
			
		}
		//super.pager = this.getResMenuService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		super.pager = this.getResMenuService().list(Integer.parseInt(roleId), super.pageSize, super.pageNo); 
		}catch(Exception e){
			saveActionError2(e.toString());
			saveActionMessage2(" Sorry ");
			e.printStackTrace();
			return Constants.ERROR_KEY;
		}
		
		// ?????????
		if (nid != null) {
			saveActionMessage("resMenu.message.add.success");
			return Constants.LIST_KEY;
		} else {
			saveActionError("resMenu.message.add.failed");
			return Constants.ADD_KEY;
		}
	}//end insert()
	
	public String update() throws Exception {
		clearErrorsAndMessages();
		String roleId = ServletActionContext.getRequest().getParameter("roleId");
		ServletActionContext.getRequest().setAttribute("roleId", roleId);
		try{
			// 
			ResMenu resMenu = this.getResMenuService().select(new Integer(id));
			resMenu.setType(Integer.valueOf(this.getType() ));
			resMenu.setName(this.getName());
			resMenu.setEnName(this.getEnName());
			resMenu.setLinkUrl(this.getLinkUrl());
			resMenu.setDiscription(this.getDiscription());
			resMenu.setTarget(this.getTarget());
		this.getResMenuService().update(resMenu);
		
		bean2Form(resMenu);	
		
//		Pager pagerSession = (Pager) getSession(Constants.PAGER_RESMENU);
//		if(pagerSession == null){
//			super.pageSize = Constants.pageSize;
//			super.pageNo = Constants.pageNo;
//		}else{
//			super.pageSize = pagerSession.getPageSize();
//			super.pageNo = pagerSession.getPageNo();
//			
//		}
		
			//super.pager = this.getResMenuService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
			super.pager = this.getResMenuService().list(Integer.parseInt(roleId), super.pageSize, super.pageNo); 
		
			saveActionMessage("resMenu.message.edit.success");
		}catch(Exception e){
			saveActionError2(e.toString());
			saveActionMessage2(" Sorry ");
			return Constants.ERROR_KEY;
		}
		
		return Constants.LIST_KEY;
	}//end update() 
	
	public String delete() throws Exception {
		clearErrorsAndMessages();
		String id = this.getId() ;
		if (this.getId() == null) {
			id = (String) ServletActionContext.getRequest().getAttribute("id");
		} 
		try{
			if (id == null) {
				saveActionError("resMenu.message.edit.notexist");
			} else {
				this.getResMenuService().delete(Integer.valueOf(id));
				saveActionMessage("resMenu.message.delete.success");
			}
			//super.pager = this.getResMenuService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
			String roleId = ServletActionContext.getRequest().getParameter("roleId");
			super.pageSize = Constants.pageSize;
			super.pageNo = Constants.pageNo;
			super.pager = this.getResMenuService().list(Integer.parseInt(roleId), super.pageSize, super.pageNo);
			ServletActionContext.getRequest().setAttribute("roleId", roleId);
			
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
	 
	public ResMenuService getResMenuService() {
		return resMenuService;
	}
	public void setResMenuService(ResMenuService resMenuService) {
		this.resMenuService = resMenuService;
	}
	
	public String getType(){
		return  type;
	}
	public void  setType(String type){
		this.type = type ;
	}
	 
	public String getName(){
		return  name;
	}
	public void  setName(String name){
		this.name = name ;
	}
	 
	public String getEnName(){
		return  enName;
	}
	public void  setEnName(String enName){
		this.enName = enName ;
	}
	 
	public String getLinkUrl(){
		return  linkUrl;
	}
	public void  setLinkUrl(String linkUrl){
		this.linkUrl = linkUrl ;
	}
	 
	public String getDiscription(){
		return  discription;
	}
	public void  setDiscription(String discription){
		this.discription = discription ;
	}
	 
	public String getTarget(){
		return  target;
	}
	public void  setTarget(String target){
		this.target = target ;
	}
	 
	 public String getUsername() {
	 	return username;
	 }
	 public void setUsername(String username) {
	 	this.username = username;
	 }
	 
}//end class
