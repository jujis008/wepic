package com.wetuo.wepic.core.actions ;
 
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.File;
import java.util.*;
import java.text.SimpleDateFormat;

import com.opensymphony.xwork2.ActionContext;
import com.wetuo.wepic.core.beans.PublishFavorite;
import com.wetuo.wepic.core.service.PublishFavoriteService;
import com.wetuo.wepic.publish.beans.Publish;
import com.wetuo.wepic.publish.service.PublishService;
 
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.struts.PageAction;
import com.wetuo.wepic.common.struts.Constants;
import com.wetuo.wepic.common.struts.RegExpression;
 
 
import org.apache.cxf.binding.corba.wsdl.Array;
import org.apache.poi.hssf.record.PageBreakRecord.Break;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

	import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.core.service.UserService;
public class PublishFavoriteAction extends PageAction {
		
	private UserService userService;
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
 
 
	/////instantce variable//////
	private static final long serialVersionUID = 1L;
	protected String id = null ; 
 	private PublishFavoriteService publishFavoriteService;
	protected String publishId = null ;
	protected String uid=null;
	protected String msg=null;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}



	private PublishService publishService;
	public PublishService getPublishService() {
		return publishService;
	}
	public void setPublishService(PublishService publishService) {
		this.publishService = publishService;
	}
	
	protected String description = null ; 
	protected String username = null; 
	//???????????��????
	public void validate() {
		
		// ?????????
		clearErrorsAndMessages();
		
		// ??????????
		String queryString = getRequestPath();
		if (queryString.indexOf("publishFavoriteadd!insert") != -1 || queryString.indexOf("publishFavoriteedit!update") != -1) {
		
			if (publishId == null || publishId.equals("")) {
				addFieldError("publishId", "publishId must be inputed");
			}//end if null
			if (description == null || description.equals("")) {
				addFieldError("description", "description must be inputed");
			}//end if null
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
		super.pager = this.getPublishFavoriteService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		
		// ?????????
		setSession(Constants.PAGER_PUBLISHFAVORITE, super.pager);
		
		return Constants.LIST_KEY;
		
	}//end init()
	public String initNotVerify() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// ??????????
		super.pageSize = Constants.pageSize;
		super.pageNo = Constants.pageNo;
		
		// ???????????
		super.pager = this.getPublishFavoriteService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		
		// ?????????
		setSession(Constants.PAGER_PUBLISHFAVORITE, super.pager);
		
		return Constants.NOTVERIFYLIST_KEY;
		
	}//end init()
	public String initAdmin() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// ??????????
		super.pageSize = Constants.pageSize;
		super.pageNo = Constants.pageNo;
		
		// ???????????
		super.pager = this.getPublishFavoriteService().list(super.pageSize, super.pageNo);
		
		// ?????????
		setSession(Constants.PAGER_PUBLISHFAVORITE, super.pager);
		
		return Constants.ADMINLIST_KEY;
		
	}//end init()
		
	
	
	public String list() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// ???????????
		super.pager = this.getPublishFavoriteService().list(super.getLoginUsername(), super.pageSize, super.pageNo);	
		
		// ?????????
		setSession(Constants.PAGER_PUBLISHFAVORITE, super.pager);
		
		return Constants.LIST_KEY;
		
	}//end list()
		
	public String add() throws Exception {
		System.out.println("F2 add getParameter of oneId: "+ServletActionContext.getRequest().getParameter("oneId"));
		
		if(ServletActionContext.getRequest().getParameter("from") != null && ServletActionContext.getRequest().getParameter("from") != ""){
			if(ServletActionContext.getRequest().getParameter("from").indexOf("publishFavorite") > -1){
				ServletActionContext.getResponse().sendRedirect("user!init.do");
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
		setPublishId(null);
		setDescription(null);
	}//end reset()
		// ?????��??
	private void bean2Form(PublishFavorite publishFavorite) {
		setId(publishFavorite.getId().toString());
		setPublishId(publishFavorite.getPublish().getId().toString());
		setDescription(publishFavorite.getDescription());
	}//end bean2Form()
	public String edit() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// id???????????
		if (this.getId() == null) {
			saveActionError("publishFavorite.message.edit.notexist");
			return Constants.LIST_KEY;
		} else {
			// ???????
			PublishFavorite publishFavorite = this.getPublishFavoriteService().select(Integer.valueOf(id));
			
			// ??????????????
			if (publishFavorite == null) {
				saveActionError("publishFavorite.message.edit.notexist");
				return Constants.LIST_KEY;
			} else {
				// ?????��??
				bean2Form(publishFavorite);
				return Constants.EDIT_KEY;
			}
		}//end if
		
	}//end edit()
	@JSON(serialize=false)
	public String myfavorite() throws Exception {
		// 
		clearErrorsAndMessages();
		Integer nid = null ;
		
		try{
		PublishFavorite publishFavorite = new PublishFavorite();
		publishFavorite.setPublish(this.getPublishService().select(Integer.parseInt(this.getPublishId())));    
		publishFavorite.setDescription(this.getDescription());
		this.uid=ActionContext.getContext().getSession().get("id").toString();
		User oneInstance = this.getUserService().selectById(Integer.parseInt(this.getUid()));
		publishFavorite.setUser(oneInstance);
		List<PublishFavorite> favorites=publishFavoriteService.findByUser(oneInstance.getUsername());
		List<Publish> list=new ArrayList<Publish>();
		if (favorites.size()>0) {
			for(PublishFavorite favorite:favorites){
				if (favorite.getPublish().getName().contains(publishFavorite.getPublish().getName())) {
					this.msg="该收藏已存在！！";
					return "myfavorite";
				}else {
					nid = this.getPublishFavoriteService().insert(publishFavorite);
					this.msg="收藏该图片成功！！";
					return "myfavorite";
				}
			}
		}else {
			nid = this.getPublishFavoriteService().insert(publishFavorite);
			this.msg="收藏该图片成功！！";
			return "myfavorite";
		}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	public String insert() throws Exception {
		// 
		clearErrorsAndMessages();
		Integer nid = null ;
		
		try{
			
		//
		PublishFavorite publishFavorite = new PublishFavorite();
			//publishFavorite.setPublish(publishInstance);    
			publishFavorite.setPublish(this.getPublishService().select(Integer.parseInt(this.getPublishId())));    
			
		publishFavorite.setDescription(this.getDescription());
//		String strOneId = ServletActionContext.getRequest().getParameter("oneId");
//		System.out.println("F2 insert getParameter  of oneId:"+strOneId);
		User oneInstance = this.getUserService().selectById(Integer.parseInt(this.getUid()));
		publishFavorite.setUser(oneInstance);
		
		nid = this.getPublishFavoriteService().insert(publishFavorite);
		
		// ?????????????
		Pager pagerSession = (Pager) getSession(Constants.PAGER_PUBLISHFAVORITE);
		if(pagerSession == null){
			//??????????
			super.pageSize = Constants.pageSize;
			super.pageNo = Constants.pageNo;
		}else{
			super.pageSize = pagerSession.getPageSize();
			super.pageNo = pagerSession.getPageNo();
			
		}
		
		//????????????
		super.pager = this.getPublishFavoriteService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		
		
		}catch(Exception e){
			saveActionError2(e.toString());
			saveActionMessage2(" Sorry ");
			return Constants.ERROR_KEY;
		}
		
		// ?????????
		if (nid != null) {
			saveActionMessage("publishFavorite.message.add.success");
			return Constants.LIST_KEY;
		} else {
			saveActionError("publishFavorite.message.add.failed");
			return Constants.ADD_KEY;
		}
	}//end insert()
	public String update() throws Exception {
		// 
		clearErrorsAndMessages();
		
		try{
			// 
			PublishFavorite publishFavorite = this.getPublishFavoriteService().select(new Integer(id));
			publishFavorite.setPublish(this.getPublishService().select(Integer.parseInt(this.getPublishId())));    
			publishFavorite.setDescription(this.getDescription());
		this.getPublishFavoriteService().update(publishFavorite);
		
		bean2Form(publishFavorite);	
		
		// ?????????????
		Pager pagerSession = (Pager) getSession(Constants.PAGER_PUBLISHFAVORITE);
		if(pagerSession == null){
			//??????????
			super.pageSize = Constants.pageSize;
			super.pageNo = Constants.pageNo;
		}else{
			super.pageSize = pagerSession.getPageSize();
			super.pageNo = pagerSession.getPageNo();
			
		}
		
			// ????????????
			super.pager = this.getPublishFavoriteService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
			saveActionMessage("publishFavorite.message.edit.success");
		}catch(Exception e){
			saveActionError2(e.toString());
			saveActionMessage2(" Sorry ");
			return Constants.ERROR_KEY;
		}
		
		return Constants.LIST_KEY;
	}//end update() 
	
	public String deleteNotVerify() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		try{
			// id???????????
			if (this.getId() == null) {
				saveActionError("publishFavorite.message.edit.notexist");
			} else {
				// ??????
				this.getPublishFavoriteService().delete(Integer.valueOf(id));
				saveActionMessage("publishFavorite.message.delete.success");
			}
			
			// ???????????
			super.pager = this.getPublishFavoriteService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
			
		}catch(Exception e){
			saveActionError2(e.toString());
			saveActionMessage2("Please delete child first");
			return Constants.ERROR_KEY;
		}
		return Constants.NOTVERIFYLIST_KEY;
		
	}//end delete()
	public String delete() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		try{
			// id???????????
			if (this.getId() == null) {
				saveActionError("publishFavorite.message.edit.notexist");
			} else {
				// ??????
				this.getPublishFavoriteService().delete(Integer.valueOf(id));
				saveActionMessage("publishFavorite.message.delete.success");
			}
			
			// ???????????
			super.pager = this.getPublishFavoriteService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
			
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
	 
	public PublishFavoriteService getPublishFavoriteService() {
		return publishFavoriteService;
	}
	public void setPublishFavoriteService(PublishFavoriteService publishFavoriteService) {
		this.publishFavoriteService = publishFavoriteService;
	}
	
	public String getPublishId(){
		return  publishId;
	}
	public void  setPublishId(String publishId){
		this.publishId = publishId ;
	}
	 
	public String getDescription(){
		return  description;
	}
	public void  setDescription(String description){
		this.description = description ;
	}
	 
	 public String getUsername() {
	 	return username;
	 }
	 public void setUsername(String username) {
	 	this.username = username;
	 }
	 
}//end class
