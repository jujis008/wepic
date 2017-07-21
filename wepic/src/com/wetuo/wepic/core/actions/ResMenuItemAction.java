package com.wetuo.wepic.core.actions ;
 
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.StringTokenizer;
import java.io.File;
import java.util.*;
import java.text.SimpleDateFormat;
import com.wetuo.wepic.core.beans.ResMenuItem;
import com.wetuo.wepic.core.service.ResMenuItemService;
 
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.struts.PageAction;
import com.wetuo.wepic.common.struts.Constants;
import com.wetuo.wepic.common.struts.RegExpression;
 
 
import org.apache.struts2.ServletActionContext;
	import com.wetuo.wepic.core.beans.ResMenu;
	import com.wetuo.wepic.core.service.ResMenuService;
public class ResMenuItemAction extends PageAction {
		
	private ResMenuService resMenuService;
 
	/////instantce variable//////
	private static final long serialVersionUID = 1L;
	protected String id = null ; 
 	private ResMenuItemService resMenuItemService;
	protected String type = null ; 
	protected String name = null ; 
	protected String enName = null ; 
	protected String linkUrl = null ; 
	protected String target = null ; 
	protected String discription = null ; 
	protected String username = null; 
	//
	public void validate() {
		
		// ?????????
		clearErrorsAndMessages();
		
		// ??????????
		String queryString = getRequestPath();
		if (queryString.indexOf("resMenuItemadd!insert") != -1 || queryString.indexOf("resMenuItemedit!update") != -1) {
		
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
			if (target == null || target.equals("")) {
				addFieldError("target", "target must be inputed");
			}//end if null
			if (discription == null || discription.equals("")) {
				addFieldError("discription", "discription must be inputed");
			}//end if null
				// ??????? 
				// ??????? 
				// ??????? 
				// ??????? 
			if (name == null || name.equals("")) {
				addFieldError("name", getText("resMenuItem.error.name"));
			}
				// ??????? 
				// ??????? 
				// ??????? 
				// ??????? 
		}//end if
	}//end validate()
	public String init() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// ??????????
		super.pageSize = Constants.pageSize;
		super.pageNo = Constants.pageNo;
		
		// ???????????
		super.pager = this.getResMenuItemService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		
		// ?????????
		setSession(Constants.PAGER_RESMENUITEM, super.pager);
		
		return Constants.LIST_KEY;
		
	}//end init()
		
	
	public String initOfMenu() throws Exception {
		int menuId = Integer.parseInt(  ServletActionContext.getRequest().getParameter("oneId")  );
		clearErrorsAndMessages();
		super.pageSize = Constants.pageSize;
		super.pageNo = Constants.pageNo;
		super.pager = this.getResMenuItemService().pagerByMenu(menuId, super.pageSize, super.pageNo);
		setSession(Constants.PAGER_RESMENUITEM, super.pager);
		return Constants.LIST_KEY;
	}//end init()
	
	
	public String list() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// ???????????
		super.pager = this.getResMenuItemService().list(super.getLoginUsername(), super.pageSize, super.pageNo);	
		
		// ?????????
		setSession(Constants.PAGER_RESMENUITEM, super.pager);
		
		return Constants.LIST_KEY;
		
	}//end list()
		
	public String add() throws Exception {
		System.out.println("F2 add getParameter of oneId: "+ServletActionContext.getRequest().getParameter("oneId"));
		
		if(ServletActionContext.getRequest().getParameter("from") != null && ServletActionContext.getRequest().getParameter("from") != ""){
			if(ServletActionContext.getRequest().getParameter("from").indexOf("resMenuItem") > -1){
				ServletActionContext.getResponse().sendRedirect("resMenu!init.do");
			}
		}
		ServletActionContext.getRequest().setAttribute("oneId", ServletActionContext.getRequest().getParameter("oneId"));
		// ?????????
		clearErrorsAndMessages();
		
		
		// ?????????
		reset();
		return Constants.ADD_KEY;
	}//end add()
	private void reset() {
		setId(null);
		setType(null);
		setName(null);
		setEnName(null);
		setLinkUrl(null);
		setTarget(null);
		setDiscription(null);
	}//end reset()
		// ?????��??
	private void bean2Form(ResMenuItem resMenuItem) {
		setId(resMenuItem.getId().toString());
		setType(resMenuItem.getType().toString()      );
		setName(resMenuItem.getName());
		setEnName(resMenuItem.getEnName());
		setLinkUrl(resMenuItem.getLinkUrl());
		setTarget(resMenuItem.getTarget());
		setDiscription(resMenuItem.getDiscription());
	}//end bean2Form()
	public String edit() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// id???????????
		if (this.getId() == null) {
			saveActionError("resMenuItem.message.edit.notexist");
			return Constants.LIST_KEY;
		} else {
			// ???????
			ResMenuItem resMenuItem = this.getResMenuItemService().select(Integer.valueOf(id));
			
			// ??????????????
			if (resMenuItem == null) {
				saveActionError("resMenuItem.message.edit.notexist");
				return Constants.LIST_KEY;
			} else {
				// ?????��??
				bean2Form(resMenuItem);
				return Constants.EDIT_KEY;
			}
		}//end if
		
	}//end edit()
		
	public String insert() throws Exception {
		// 
		clearErrorsAndMessages();
		Integer nid = null ;
		
		try{
			
		//
		ResMenuItem resMenuItem = new ResMenuItem();
		resMenuItem.setType(Integer.valueOf(this.getType() ));
		resMenuItem.setName(this.getName());
		resMenuItem.setEnName(this.getEnName());
		resMenuItem.setLinkUrl(this.getLinkUrl());
		resMenuItem.setTarget(this.getTarget());
		resMenuItem.setDiscription(this.getDiscription());
		String strOneId = ServletActionContext.getRequest().getParameter("oneId");
		System.out.println("F2 insert getParameter  of oneId:"+strOneId);
		ResMenu oneInstance = this.getResMenuService().select(Integer.parseInt(strOneId));
		resMenuItem.setResMenu(oneInstance);
		
		nid = this.getResMenuItemService().insert(resMenuItem);
		
		// ?????????????
		Pager pagerSession = (Pager) getSession(Constants.PAGER_RESMENUITEM);
		if(pagerSession == null){
			//??????????
			super.pageSize = Constants.pageSize;
			super.pageNo = Constants.pageNo;
		}else{
			super.pageSize = pagerSession.getPageSize();
			super.pageNo = pagerSession.getPageNo();
			
		}
		
		//????????????
		super.pager = this.getResMenuItemService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		
		
		}catch(Exception e){
			saveActionError2(e.toString());
			saveActionMessage2(" Sorry ");
			return Constants.ERROR_KEY;
		}
		
		// ?????????
		if (nid != null) {
			saveActionMessage("resMenuItem.message.add.success");
			return Constants.LIST_KEY;
		} else {
			saveActionError("resMenuItem.message.add.failed");
			return Constants.ADD_KEY;
		}
	}//end insert()
	public String update() throws Exception {
		// 
		clearErrorsAndMessages();
		
		try{
			// 
			ResMenuItem resMenuItem = this.getResMenuItemService().select(new Integer(id));
			resMenuItem.setType(Integer.valueOf(this.getType() ));
			resMenuItem.setName(this.getName());
			resMenuItem.setEnName(this.getEnName());
			resMenuItem.setLinkUrl(this.getLinkUrl());
			resMenuItem.setTarget(this.getTarget());
			resMenuItem.setDiscription(this.getDiscription());
		this.getResMenuItemService().update(resMenuItem);
		
		bean2Form(resMenuItem);	
		
		// ?????????????
		Pager pagerSession = (Pager) getSession(Constants.PAGER_RESMENUITEM);
		if(pagerSession == null){
			//??????????
			super.pageSize = Constants.pageSize;
			super.pageNo = Constants.pageNo;
		}else{
			super.pageSize = pagerSession.getPageSize();
			super.pageNo = pagerSession.getPageNo();
			
		}
		
			// ????????????
			super.pager = this.getResMenuItemService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
			saveActionMessage("resMenuItem.message.edit.success");
		}catch(Exception e){
			saveActionError2(e.toString());
			saveActionMessage2(" Sorry ");
			return Constants.ERROR_KEY;
		}
		
		return Constants.LIST_KEY;
	}//end update() 
	public String delete() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		try{
			// id???????????
			if (this.getId() == null) {
				saveActionError("resMenuItem.message.edit.notexist");
			} else {
				// ??????
				this.getResMenuItemService().delete(Integer.valueOf(id));
				saveActionMessage("resMenuItem.message.delete.success");
			}
			
			// ???????????
			super.pager = this.getResMenuItemService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
			
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
	 
	public ResMenuItemService getResMenuItemService() {
		return resMenuItemService;
	}
	public void setResMenuItemService(ResMenuItemService resMenuItemService) {
		this.resMenuItemService = resMenuItemService;
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
	 
	public String getTarget(){
		return  target;
	}
	public void  setTarget(String target){
		this.target = target ;
	}
	 
	public String getDiscription(){
		return  discription;
	}
	public void  setDiscription(String discription){
		this.discription = discription ;
	}
	 
	public String getUsername() {
	 	return username;
	}
	public void setUsername(String username) {
	 	this.username = username;
	}
	public ResMenuService getResMenuService() {
			return resMenuService;
	}
	public void setResMenuService(ResMenuService resMenuService) {
			this.resMenuService = resMenuService;
	}
}//end class
