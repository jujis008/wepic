package com.wetuo.wepic.publish.actions ;
 
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.StringTokenizer;
import java.io.File;
import java.util.*;
import java.text.SimpleDateFormat;
import com.wetuo.wepic.publish.beans.Publish;
import com.wetuo.wepic.publish.service.PublishService;
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.core.service.UserService;
 
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.struts.PageAction;
import com.wetuo.wepic.common.struts.Constants;
import com.wetuo.wepic.common.struts.RegExpression;
 
 
import org.apache.struts2.ServletActionContext;
	import com.wetuo.wepic.publish.beans.PublishCat;
	import com.wetuo.wepic.publish.service.PublishCatService;
public class PublishAction0 extends PageAction {
		
	private PublishCatService publishCatService;
	public PublishCatService getPublishCatService() {
		return publishCatService;
	}
	public void setPublishCatService(PublishCatService publishCatService) {
		this.publishCatService = publishCatService;
	}
		
 
 
	/////instantce variable//////
	private static final long serialVersionUID = 1L;
	protected String id = null ; 
 	private PublishService publishService;
	protected String userId = null ;
	private UserService userService;
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	protected String name = null ; 
	protected String content = null ; 
	protected String logo = null ; 
	protected String publishTime = null ; 
	protected String period = null ; 
	protected String position = null ; 
	protected String order = null ; 
	protected String moneyExpect = null ; 
	protected String hit = null ; 
	protected String username = null; 
	//???????????��????
	public void validate() {
		
		// ?????????
		clearErrorsAndMessages();
		
		// ??????????
		String queryString = getRequestPath();
		if (queryString.indexOf("publishadd!insert") != -1 || queryString.indexOf("publishedit!update") != -1) {
		
			if (userId == null || userId.equals("")) {
				addFieldError("userId", "userId must be inputed");
			}//end if null
			if (name == null || name.equals("")) {
				addFieldError("name", "name must be inputed");
			}//end if null
			if (content == null || content.equals("")) {
				addFieldError("content", "content must be inputed");
			}//end if null
			if (logo == null || logo.equals("")) {
				addFieldError("logo", "logo must be inputed");
			}//end if null
			if (publishTime == null || publishTime.equals("")) {
				addFieldError("publishTime", "publishTime must be inputed");
			}//end if null
			if (period == null || period.equals("")) {
				addFieldError("period", "period must be inputed");
			}//end if null
			if (position == null || position.equals("")) {
				addFieldError("position", "position must be inputed");
			}//end if null
			if (order == null || order.equals("")) {
				addFieldError("order", "order must be inputed");
			}//end if null
			if (moneyExpect == null || moneyExpect.equals("")) {
				addFieldError("moneyExpect", "moneyExpect must be inputed");
			}//end if null
			if (hit == null || hit.equals("")) {
				addFieldError("hit", "hit must be inputed");
			}//end if null
				// ??????? 
				// ??????? 
				// ??????? 
			if (name == null || name.equals("")) {
				addFieldError("name", getText("publish.error.name"));
			}
				// ??????? 
				// ??????? 
				// ??????? 
				// ??????? 
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
		super.pager = this.getPublishService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		
		// ?????????
		//setSession(Constants.PAGER_PUBLISH, super.pager);
		
		return Constants.LIST_KEY;
		
	}//end init()
		
	public String list() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// ???????????
		super.pager = this.getPublishService().list(super.getLoginUsername(), super.pageSize, super.pageNo);	
		
		// ?????????
		//setSession(Constants.PAGER_PUBLISH, super.pager);
		
		return Constants.LIST_KEY;
		
	}//end list()
		
	public String add() throws Exception {
		System.out.println("F2 add getParameter of oneId: "+ServletActionContext.getRequest().getParameter("oneId"));
		
		if(ServletActionContext.getRequest().getParameter("from") != null && ServletActionContext.getRequest().getParameter("from") != ""){
			if(ServletActionContext.getRequest().getParameter("from").indexOf("publish") > -1){
				ServletActionContext.getResponse().sendRedirect("publishCat!init.do");
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
		setUserId(null);
		setName(null);
		setContent(null);
		setLogo(null);
		setPublishTime(null);
		setPeriod(null);
		setPosition(null);
		setOrder(null);
		setMoneyExpect(null);
		setHit(null);
	}//end reset()
		// ?????��??
	private void bean2Form(Publish publish) {
		setId(publish.getId().toString());
		setUserId(publish.getUser().getId().toString());
		setName(publish.getName());
		setContent(publish.getContent());
		setLogo(publish.getLogo());
		setPublishTime(publish.getPublishTime().toString()      );
		setPeriod(publish.getPeriod().toString()      );
		setPosition(publish.getPosition());
		setOrder(publish.getSequence().toString());
		setMoneyExpect(publish.getMoneyExpect().toString());
		setHit(publish.getHit().toString());
	}//end bean2Form()
	public String edit() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// id???????????
		if (this.getId() == null) {
			saveActionError("publish.message.edit.notexist");
			return Constants.LIST_KEY;
		} else {
			// ???????
			Publish publish = this.getPublishService().select(Integer.valueOf(id));
			
			// ??????????????
			if (publish == null) {
				saveActionError("publish.message.edit.notexist");
				return Constants.LIST_KEY;
			} else {
				// ?????��??
				bean2Form(publish);
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
		Publish publish = new Publish();
			publish.setUser(this.getUserService().select(userId));  //userInstance  
		publish.setName(this.getName());
		publish.setContent(this.getContent());
		publish.setLogo(this.getLogo());
		//publish.setPublishTime(java.sql.Time.valueOf(this.getPublishTime() ));
		publish.setPeriod(Integer.valueOf(this.getPeriod() ));
		publish.setPosition(this.getPosition());
		publish.setSequence(Integer.parseInt(this.getOrder()));
		publish.setMoneyExpect(Integer.parseInt(this.getMoneyExpect()));
		publish.setHit(Integer.parseInt(this.getHit()));
		String strOneId = ServletActionContext.getRequest().getParameter("oneId");
		System.out.println("F2 insert getParameter  of oneId:"+strOneId);
		PublishCat oneInstance = this.getPublishCatService().select(Integer.parseInt(strOneId));
		publish.setPublishCat(oneInstance);
		
		nid = this.getPublishService().insert(publish);
		
		// ?????????????
		Pager pagerSession = (Pager) getSession(Constants.PAGER_PUBLISH);
		if(pagerSession == null){
			//??????????
			super.pageSize = Constants.pageSize;
			super.pageNo = Constants.pageNo;
		}else{
			super.pageSize = pagerSession.getPageSize();
			super.pageNo = pagerSession.getPageNo();
			
		}
		
		//????????????
		super.pager = this.getPublishService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		
		
		}catch(Exception e){
			saveActionError2(e.toString());
			saveActionMessage2(" Sorry ");
			return Constants.ERROR_KEY;
		}
		
		// ?????????
		if (nid != null) {
			saveActionMessage("publish.message.add.success");
			return Constants.LIST_KEY;
		} else {
			saveActionError("publish.message.add.failed");
			return Constants.ADD_KEY;
		}
	}//end insert()
	public String update() throws Exception {
		// 
		clearErrorsAndMessages();
		
		try{
			// 
			Publish publish = this.getPublishService().select(new Integer(id));
			//publish.setUser(userInstance);  
			publish.setUser(this.getUserService().select(userId));  //userInstance
			publish.setName(this.getName());
			publish.setContent(this.getContent());
			publish.setLogo(this.getLogo());
			//publish.setPublishTime(java.sql.Time.valueOf(this.getPublishTime() ));
			publish.setPeriod(Integer.valueOf(this.getPeriod() ));
			publish.setPosition(this.getPosition());
			publish.setSequence(Integer.parseInt(this.getOrder()));
			publish.setMoneyExpect(Integer.parseInt(this.getMoneyExpect()));
			publish.setHit(Integer.parseInt(this.getHit()));
		this.getPublishService().update(publish);
		
		bean2Form(publish);	
		
		// ?????????????
		Pager pagerSession = (Pager) getSession(Constants.PAGER_PUBLISH);
		if(pagerSession == null){
			//??????????
			super.pageSize = Constants.pageSize;
			super.pageNo = Constants.pageNo;
		}else{
			super.pageSize = pagerSession.getPageSize();
			super.pageNo = pagerSession.getPageNo();
			
		}
		
			// ????????????
			super.pager = this.getPublishService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
			saveActionMessage("publish.message.edit.success");
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
				saveActionError("publish.message.edit.notexist");
			} else {
				// ??????
				this.getPublishService().delete(Integer.valueOf(id));
				saveActionMessage("publish.message.delete.success");
			}
			
			// ???????????
			super.pager = this.getPublishService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
			
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
	 
	public PublishService getPublishService() {
		return publishService;
	}
	public void setPublishService(PublishService publishService) {
		this.publishService = publishService;
	}
	
	public String getUserId(){
		return  userId;
	}
	public void  setUserId(String userId){
		this.userId = userId ;
	}
	 
	public String getName(){
		return  name;
	}
	public void  setName(String name){
		this.name = name ;
	}
	 
	public String getContent(){
		return  content;
	}
	public void  setContent(String content){
		this.content = content ;
	}
	 
	public String getLogo(){
		return  logo;
	}
	public void  setLogo(String logo){
		this.logo = logo ;
	}
	 
	public String getPublishTime(){
		return  publishTime;
	}
	public void  setPublishTime(String publishTime){
		this.publishTime = publishTime ;
	}
	 
	public String getPeriod(){
		return  period;
	}
	public void  setPeriod(String period){
		this.period = period ;
	}
	 
	public String getPosition(){
		return  position;
	}
	public void  setPosition(String position){
		this.position = position ;
	}
	 
	public String getOrder(){
		return  order;
	}
	public void  setOrder(String order){
		this.order = order ;
	}
	 
	public String getMoneyExpect(){
		return  moneyExpect;
	}
	public void  setMoneyExpect(String moneyExpect){
		this.moneyExpect = moneyExpect ;
	}
	 
	public String getHit(){
		return  hit;
	}
	public void  setHit(String hit){
		this.hit = hit ;
	}
	 
	 public String getUsername() {
	 	return username;
	 }
	 public void setUsername(String username) {
	 	this.username = username;
	 }
	 
}//end class
