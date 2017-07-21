package com.wetuo.wepic.publish.actions ;
 
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.StringTokenizer;
import java.io.File;
import java.util.*;
import java.text.SimpleDateFormat;
import com.wetuo.wepic.publish.beans.PublishCat_Publish;
import com.wetuo.wepic.publish.service.PublishCat_PublishService;
import com.wetuo.wepic.publish.beans.PublishCat;
import com.wetuo.wepic.publish.service.PublishCatService;
import com.wetuo.wepic.publish.beans.Publish;
import com.wetuo.wepic.publish.service.PublishService;
 
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.struts.PageAction;
import com.wetuo.wepic.common.struts.Constants;
import com.wetuo.wepic.common.struts.RegExpression;
 
 
public class PublishCat_PublishAction extends PageAction {
 
	/////instantce variable//////
	private static final long serialVersionUID = 1L;
 	private PublishCat_PublishService publishCat_PublishService;
	protected String username = null; 
	protected String id = null ;
	protected String relation = null ;
	protected String publishCatId = null ;
	private PublishCatService publishCatService;
	public PublishCatService getPublishCatService() {
		return publishCatService;
	}
	public void setPublishCatService(PublishCatService publishCatService) {
		this.publishCatService = publishCatService;
	}
	
	protected String publishId = null ;
	private PublishService publishService;
	public PublishService getPublishService() {
		return publishService;
	}
	public void setPublishService(PublishService publishService) {
		this.publishService = publishService;
	}
	
	public void validate() {
		
		clearErrorsAndMessages();
		
		String queryString = getRequestPath();
		if (queryString.indexOf("publishCat_Publishadd!insert") != -1 || queryString.indexOf("publishCat_Publishedit!update") != -1) {
		
			if (publishCatId == null || publishCatId.equals("")) {
				addFieldError("publishCatId", "publishCatId must be inputed");
			}//end if null
			if (publishId == null || publishId.equals("")) {
				addFieldError("publishId", "publishId must be inputed");
			}//end if null
		}//end if
	}//end validate()
	public String init() throws Exception {
		clearErrorsAndMessages();
		
		super.pageSize = Constants.pageSize;
		super.pageNo = Constants.pageNo;
		
		super.pager = this.getPublishCat_PublishService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		
		setSession(Constants.PAGER_PUBLISHCAT_PUBLISH, super.pager);
		
		return Constants.LIST_KEY;
		
	}//end init()
		
	public String list() throws Exception {
		clearErrorsAndMessages();
		
		super.pager = this.getPublishCat_PublishService().list(super.getLoginUsername(), super.pageSize, super.pageNo);	
		
		setSession(Constants.PAGER_PUBLISHCAT_PUBLISH, super.pager);
		
		return Constants.LIST_KEY;
		
	}//end list()
		
	public String add() throws Exception {
		clearErrorsAndMessages();
		reset();
		return Constants.ADD_KEY;
	}//end add()
	private void reset() {
		setPublishCatId(null);
		setPublishId(null);
		setId(null);
		setRelation(null);
	}//end reset()
	private void bean2Form(PublishCat_Publish publishCat_Publish) {
		setId(new Integer(publishCat_Publish.getId()).toString());
		setRelation(publishCat_Publish.getRelation());
		setPublishCatId(publishCat_Publish.getPublishCat().getId().toString());
		setPublishId(publishCat_Publish.getPublish().getId().toString());
	}//end bean2Form()
	public String edit() throws Exception {
		clearErrorsAndMessages();
		
		// id
		if (this.getId() == null) {
			saveActionError("publishCat_Publish.message.edit.notexist");
			return Constants.LIST_KEY;
		} else {
			PublishCat_Publish publishCat_Publish = this.getPublishCat_PublishService().select(Integer.valueOf(id));
			
			if (publishCat_Publish == null) {
				saveActionError("publishCat_Publish.message.edit.notexist");
				return Constants.LIST_KEY;
			} else {
				bean2Form(publishCat_Publish);
				return Constants.EDIT_KEY;
			}
		}//end if
		
	}//end edit()
		
	public String insert() throws Exception {
		clearErrorsAndMessages();
		Integer nid = null ;
		
		try{
			
			PublishCat_Publish publishCat_Publish = new PublishCat_Publish();
			publishCat_Publish.setRelation(this.getRelation());
			
			//publishCat_Publish.setPublishCat(publishCatInstance);   
			publishCat_Publish.setPublishCat(this.getPublishCatService().select(Integer.parseInt(this.getPublishCatId())));    
			
			//publishCat_Publish.setPublish(publishInstance); 
			publishCat_Publish.setPublish(this.getPublishService().select(Integer.parseInt(this.getPublishId())));    
			
			
			nid = this.getPublishCat_PublishService().insert(publishCat_Publish);
			
			Pager pagerSession = (Pager) getSession(Constants.PAGER_PUBLISHCAT_PUBLISH);
			if(pagerSession == null){
				super.pageSize = Constants.pageSize;
				super.pageNo = Constants.pageNo;
			}else{
				super.pageSize = pagerSession.getPageSize();
				super.pageNo = pagerSession.getPageNo();
				
			}
			
			super.pager = this.getPublishCat_PublishService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
			
			
		}catch(Exception e){
				saveActionError2(e.toString());
				saveActionMessage2(" Sorry ");
				return Constants.ERROR_KEY;
		}
		
		if (nid != null) {
			saveActionMessage("publishCat_Publish.message.add.success");
			return Constants.LIST_KEY;
		} else {
			saveActionError("publishCat_Publish.message.add.failed");
			return Constants.ADD_KEY;
		}
	}//end insert()
	public String update() throws Exception {
		clearErrorsAndMessages();
		
		try{
			PublishCat_Publish publishCat_Publish = this.getPublishCat_PublishService().select(new Integer(id));
			publishCat_Publish.setRelation(this.getRelation());
//			publishCat_Publish.setPublishCat(publishCatInstance);    
//			publishCat_Publish.setPublishCat(publishCatInstance); 
			publishCat_Publish.setPublishCat(this.getPublishCatService().select(Integer.parseInt(this.getPublishCatId())));    
			publishCat_Publish.setPublish(this.getPublishService().select(Integer.parseInt(this.getPublishId())));    
			
			
		this.getPublishCat_PublishService().update(publishCat_Publish);
		
		bean2Form(publishCat_Publish);	
		
		Pager pagerSession = (Pager) getSession(Constants.PAGER_PUBLISHCAT_PUBLISH);
		if(pagerSession == null){
			super.pageSize = Constants.pageSize;
			super.pageNo = Constants.pageNo;
		}else{
			super.pageSize = pagerSession.getPageSize();
			super.pageNo = pagerSession.getPageNo();
			
		}
		
			super.pager = this.getPublishCat_PublishService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
			saveActionMessage("publishCat_Publish.message.edit.success");
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
				saveActionError("publishCat_Publish.message.edit.notexist");
			} else {
				this.getPublishCat_PublishService().delete(Integer.valueOf(id));
				saveActionMessage("publishCat_Publish.message.delete.success");
			}
			
			super.pager = this.getPublishCat_PublishService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
			
		}catch(Exception e){
			saveActionError2(e.toString());
			saveActionMessage2("Please delete child first");
			return Constants.ERROR_KEY;
		}
		return Constants.LIST_KEY;
		
	}//end delete()
		
 
	/////getter////setter//////
	public PublishCat_PublishService getPublishCat_PublishService() {
		return publishCat_PublishService;
	}
	public void setPublishCat_PublishService(PublishCat_PublishService publishCat_PublishService) {
		this.publishCat_PublishService = publishCat_PublishService;
	}
	
	public String getPublishCatId(){
		return  publishCatId;
	}
	public void  setPublishCatId(String publishCatId){
		this.publishCatId = publishCatId ;
	}
	 
	public String getPublishId(){
		return  publishId;
	}
	public void  setPublishId(String publishId){
		this.publishId = publishId ;
	}
	 
	public String getId(){
		return  id;
	}
	public void  setId(String id){
		this.id = id ;
	}
	 
	public String getRelation(){
		return  relation;
	}
	public void  setRelation(String relation){
		this.relation = relation ;
	}
	 
	public String getUsername(){
		return  username;
	}
	public void  setUsername(String username){
		this.username = username ;
	}
	 
}//end class
