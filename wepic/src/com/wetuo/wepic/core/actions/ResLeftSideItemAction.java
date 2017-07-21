package com.wetuo.wepic.core.actions ;
 
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.StringTokenizer;
import java.io.File;
import java.util.*;
import java.text.SimpleDateFormat;
import com.wetuo.wepic.core.beans.ResLeftSideItem;
import com.wetuo.wepic.core.service.ResLeftSideItemService;
 
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.struts.PageAction;
import com.wetuo.wepic.common.struts.Constants;
import com.wetuo.wepic.common.struts.RegExpression;
 
 
import org.apache.struts2.ServletActionContext;
	import com.wetuo.wepic.core.beans.ResMenu;
	import com.wetuo.wepic.core.service.ResMenuService;
import org.apache.struts2.ServletActionContext;
	import com.wetuo.wepic.core.beans.ResMenuItem;
import com.wetuo.wepic.core.service.ResMenuItemService;
public class ResLeftSideItemAction extends PageAction {
		
	private ResMenuItemService resMenuItemService;
	public ResMenuItemService getResMenuItemService() {
		return resMenuItemService;
	}
	public void setResMenuItemService(ResMenuItemService resMenuItemService) {
		this.resMenuItemService = resMenuItemService;
	}
		
		
	private ResMenuService resMenuService;
	public ResMenuService getResMenuService() {
		return resMenuService;
	}
	public void setResMenuService(ResMenuService resMenuService) {
		this.resMenuService = resMenuService;
	}
		
 
	/////instantce variable//////
	private static final long serialVersionUID = 1L;
	protected String id = null ; 
 	private ResLeftSideItemService resLeftSideItemService;
	protected String type = null ; 
	protected String name = null ; 
	protected String enName = null ; 
	protected String linkUrl = null ; 
	protected String target = null ; 
	protected String discription = null ; 
	protected String username = null; 
	
	public void validate() {
		
		// ?
		clearErrorsAndMessages();
		
		// 
		String queryString = getRequestPath();
		if (queryString.indexOf("resLeftSideItemadd!insert") != -1 || queryString.indexOf("resLeftSideItemedit!update") != -1) {
		
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
				// ? 
				// ? 
				// ? 
				// ? 
			if (name == null || name.equals("")) {
				addFieldError("name", getText("resLeftSideItem.error.name"));
			}
				// ? 
				// ? 
				// ? 
				// ? 
		}//end if
	}//end validate()
	
	public String init() throws Exception {
		// ?
		clearErrorsAndMessages();
		
		// 
		super.pageSize = Constants.pageSize;
		super.pageNo = Constants.pageNo;
		
		// ?
		super.pager = this.getResLeftSideItemService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		
		// ?
		setSession(Constants.PAGER_RESLEFTSIDEITEM, super.pager);
		
		return Constants.LIST_KEY;
		
	}//end init()
		
	public String initOfMenu() throws Exception {
		int menuId = Integer.parseInt(  ServletActionContext.getRequest().getParameter("oneId")  );
		ServletActionContext.getRequest().setAttribute("oneId", ServletActionContext.getRequest().getParameter("oneId"));
		clearErrorsAndMessages();
		super.pageSize = Constants.pageSize;
		super.pageNo = Constants.pageNo;
		super.pager = this.getResLeftSideItemService().pagerByMenu(menuId, super.pageSize, super.pageNo);
//		setSession(Constants.PAGER_RESMENUITEM, super.pager);
		return Constants.LIST_KEY;
	}//end init()
	
	public String list() throws Exception {
		// ?
		clearErrorsAndMessages();
		
		// ?
		super.pager = this.getResLeftSideItemService().list(super.getLoginUsername(), super.pageSize, super.pageNo);	
		
		// ?
		setSession(Constants.PAGER_RESLEFTSIDEITEM, super.pager);
		
		return Constants.LIST_KEY;
		
	}//end list()
		
	public String add() throws Exception {
		System.out.println("F2 add getParameter of oneId: "+ServletActionContext.getRequest().getParameter("oneId"));
		
		if(ServletActionContext.getRequest().getParameter("from") != null && ServletActionContext.getRequest().getParameter("from") != ""){
			if(ServletActionContext.getRequest().getParameter("from").indexOf("resLeftSideItem") > -1){
				ServletActionContext.getResponse().sendRedirect("resMenuItem!init.do");
			}
		}
		ServletActionContext.getRequest().setAttribute("oneId", ServletActionContext.getRequest().getParameter("oneId"));
		System.out.println("F2 add getParameter of oneId: "+ServletActionContext.getRequest().getParameter("oneId"));
		
		if(ServletActionContext.getRequest().getParameter("from") != null && ServletActionContext.getRequest().getParameter("from") != ""){
			if(ServletActionContext.getRequest().getParameter("from").indexOf("resLeftSideItem") > -1){
				ServletActionContext.getResponse().sendRedirect("resMenu!init.do");
			}
		}
		ServletActionContext.getRequest().setAttribute("oneId", ServletActionContext.getRequest().getParameter("oneId"));
		// ?
		clearErrorsAndMessages();
		
		
		// ?
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

	private void bean2Form(ResLeftSideItem resLeftSideItem) {
		setId(resLeftSideItem.getId().toString());
		setType(resLeftSideItem.getType().toString()      );
		setName(resLeftSideItem.getName());
		setEnName(resLeftSideItem.getEnName());
		setLinkUrl(resLeftSideItem.getLinkUrl());
		setTarget(resLeftSideItem.getTarget());
		setDiscription(resLeftSideItem.getDiscription());
	}//end bean2Form()
	
	public String edit() throws Exception {
		clearErrorsAndMessages();
		int menuId = Integer.parseInt(  ServletActionContext.getRequest().getParameter("oneId")  );
		ServletActionContext.getRequest().setAttribute("oneId", ServletActionContext.getRequest().getParameter("oneId"));
		// id?
		if (this.getId() == null) {
			saveActionError("resLeftSideItem.message.edit.notexist");
			return Constants.LIST_KEY;
		} else {
			// ?
			ResLeftSideItem resLeftSideItem = this.getResLeftSideItemService().select(Integer.valueOf(id));
			
			// 
			if (resLeftSideItem == null) {
				saveActionError("resLeftSideItem.message.edit.notexist");
				return Constants.LIST_KEY;
			} else {
				// ?��
				bean2Form(resLeftSideItem);
				return Constants.EDIT_KEY;
			}
		}//end if
		
	}//end edit()
		
	public String insert() throws Exception {
		clearErrorsAndMessages();
		Integer nid = null ;
		try{
			ResLeftSideItem resLeftSideItem = new ResLeftSideItem();
			resLeftSideItem.setType(Integer.valueOf(this.getType() ));
			resLeftSideItem.setName(this.getName());
			resLeftSideItem.setEnName(this.getEnName());
			resLeftSideItem.setLinkUrl(this.getLinkUrl());
			resLeftSideItem.setTarget(this.getTarget());
			resLeftSideItem.setDiscription(this.getDiscription());
			
			String strOneId = ServletActionContext.getRequest().getParameter("oneId");
			ServletActionContext.getRequest().setAttribute("oneId", strOneId);
			System.out.println("F2 insert getParameter  of oneId:"+strOneId);
			ResMenu oneInstance = this.getResMenuService().select(Integer.parseInt(strOneId));
			resLeftSideItem.setResMenu(oneInstance);
			
	//		String strOneId2 = ServletActionContext.getRequest().getParameter("oneId");
	//		System.out.println("F2 insert getParameter  of oneId:"+strOneId2);
	//		ResMenuItem oneInstance2 = this.getResMenuItemService().select(Integer.parseInt(strOneId));
	//		resLeftSideItem.setResMenuItem(oneInstance2);
			
			nid = this.getResLeftSideItemService().insert(resLeftSideItem);
			
			Pager pagerSession = (Pager) getSession(Constants.PAGER_RESLEFTSIDEITEM);
			if(pagerSession == null){
				super.pageSize = Constants.pageSize;
				super.pageNo = Constants.pageNo;
			}else{
				super.pageSize = pagerSession.getPageSize();
				super.pageNo = pagerSession.getPageNo();
			}
			
			//super.pager = this.getResLeftSideItemService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
//			super.pager = this.getResLeftSideItemService().listByMenu( Integer.parseInt(strOneId),  super.pageSize, super.pageNo ); 
//			super.pageSize = Constants.pageSize;
//			super.pageNo = Constants.pageNo;
			super.pager = this.getResLeftSideItemService().pagerByMenu(Integer.parseInt(strOneId), super.pageSize, super.pageNo);
		
		}catch(Exception e){
			saveActionError2(e.toString());
			saveActionMessage2(" Sorry ");
			return Constants.ERROR_KEY;
		}
		
		if (nid != null) {
			saveActionMessage("resLeftSideItem.message.add.success");
			return Constants.LIST_KEY;
		} else {
			saveActionError("resLeftSideItem.message.add.failed");
			return Constants.ADD_KEY;
		}
	}//end insert()
	
	public String update() throws Exception {
		clearErrorsAndMessages();
		int menuId = Integer.parseInt(  ServletActionContext.getRequest().getParameter("oneId")  );
		ServletActionContext.getRequest().setAttribute("oneId", ServletActionContext.getRequest().getParameter("oneId"));
		try{
			ResLeftSideItem resLeftSideItem = this.getResLeftSideItemService().select(new Integer(id));
			resLeftSideItem.setType(Integer.valueOf(this.getType() ));
			resLeftSideItem.setName(this.getName());
			resLeftSideItem.setEnName(this.getEnName());
			resLeftSideItem.setLinkUrl(this.getLinkUrl());
			resLeftSideItem.setTarget(this.getTarget());
			resLeftSideItem.setDiscription(this.getDiscription());
		this.getResLeftSideItemService().update(resLeftSideItem);
		
		bean2Form(resLeftSideItem);	
		
		// ?
		Pager pagerSession = (Pager) getSession(Constants.PAGER_RESLEFTSIDEITEM);
		if(pagerSession == null){
			//
			super.pageSize = Constants.pageSize;
			super.pageNo = Constants.pageNo;
		}else{
			super.pageSize = pagerSession.getPageSize();
			super.pageNo = pagerSession.getPageNo();
			
		}
			//super.pager = this.getResLeftSideItemService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
			super.pager = this.getResLeftSideItemService().pagerByMenu(menuId, super.pageSize, super.pageNo);
			
			saveActionMessage("resLeftSideItem.message.edit.success");
		}catch(Exception e){
			saveActionError2(e.toString());
			saveActionMessage2(" Sorry ");
			return Constants.ERROR_KEY;
		}
		
		return Constants.LIST_KEY;
	}//end update() 
	
	public String delete() throws Exception {
		clearErrorsAndMessages();
		
		String oneId = ServletActionContext.getRequest().getParameter("oneId");
		ServletActionContext.getRequest().setAttribute("oneId", oneId);
		try{
			if (this.getId() == null) {
				saveActionError("resLeftSideItem.message.edit.notexist");
			} else {
				this.getResLeftSideItemService().delete(Integer.valueOf(id));
				saveActionMessage("resLeftSideItem.message.delete.success");
			}
			//super.pager = this.getResLeftSideItemService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
			super.pager = this.getResLeftSideItemService().pagerByMenu(Integer.parseInt(oneId), super.pageSize, super.pageNo);
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
	 
	public ResLeftSideItemService getResLeftSideItemService() {
		return resLeftSideItemService;
	}
	public void setResLeftSideItemService(ResLeftSideItemService resLeftSideItemService) {
		this.resLeftSideItemService = resLeftSideItemService;
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
	 
}//end class
