package com.wetuo.wepic.publish.actions ;
 
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.StringTokenizer;
import java.io.File;
import java.util.*;
import java.text.SimpleDateFormat;

import org.apache.struts2.ServletActionContext;

import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.struts.Constants;
import com.wetuo.wepic.common.struts.PageAction;
import com.wetuo.wepic.core.service.UserService;
import com.wetuo.wepic.publish.beans.AssessComplaint;
import com.wetuo.wepic.publish.beans.Publish;
import com.wetuo.wepic.publish.service.AssessComplaintService;
import com.wetuo.wepic.publish.service.PublishService;



public class AssessComplaintAction extends PageAction {
		
	private PublishService publishService;
	public PublishService getPublishService() {
		return publishService;
	}
	public void setPublishService(PublishService publishService) {
		this.publishService = publishService;
	}
		
 
 
	/////instantce variable//////
	private static final long serialVersionUID = 1L;
	protected String id = null ; 
 	
	protected String adminId = null ;
		
	protected String complainantAssessorId = null ;
	private AssessComplaintService assessComplaintService;
	private UserService userService;
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	protected String complaint = null ; 
	protected String complaintType = null ; 
	protected String assess = null ; 
	protected String assessType = null ; 
	protected String handleType = null ; 
	protected String handleOpinion = null ; 
	protected String username = null; 
	//???????????��????
	public void validate() {
		
		// ?????????
		clearErrorsAndMessages();
		
		// ??????????
		String queryString = getRequestPath();
		if (queryString.indexOf("assessComplaintadd!insert") != -1 || queryString.indexOf("assessComplaintedit!update") != -1) {
		
//			if (userId == null || userId.equals("")) {
//				addFieldError("userId", "userId must be inputed");
//			}//end if null
//			if (userId == null || userId.equals("")) {
//				addFieldError("userId", "userId must be inputed");
//			}//end if null
			if (complaint == null || complaint.equals("")) {
				addFieldError("complaint", "complaint must be inputed");
			}//end if null
			if (complaintType == null || complaintType.equals("")) {
				addFieldError("complaintType", "complaintType must be inputed");
			}//end if null
			if (assess == null || assess.equals("")) {
				addFieldError("assess", "assess must be inputed");
			}//end if null
			if (assessType == null || assessType.equals("")) {
				addFieldError("assessType", "assessType must be inputed");
			}//end if null
			if (handleType == null || handleType.equals("")) {
				addFieldError("handleType", "handleType must be inputed");
			}//end if null
			if (handleOpinion == null || handleOpinion.equals("")) {
				addFieldError("handleOpinion", "handleOpinion must be inputed");
			}//end if null
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
		super.pager = this.getAssessComplaintService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		
		// ?????????
		setSession(Constants.PAGER_ASSESSCOMPLAINT, super.pager);
		
		return Constants.LIST_KEY;
		
	}//end init()
		
	public String list() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// ???????????
		super.pager = this.getAssessComplaintService().list(super.getLoginUsername(), super.pageSize, super.pageNo);	
		
		// ?????????
		setSession(Constants.PAGER_ASSESSCOMPLAINT, super.pager);
		
		return Constants.LIST_KEY;
		
	}//end list()
		
	public String add() throws Exception {
		System.out.println("F2 add getParameter of oneId: "+ServletActionContext.getRequest().getParameter("oneId"));
		
		if(ServletActionContext.getRequest().getParameter("from") != null && ServletActionContext.getRequest().getParameter("from") != ""){
			if(ServletActionContext.getRequest().getParameter("from").indexOf("assessComplaint") > -1){
				ServletActionContext.getResponse().sendRedirect("publish!init.do");
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
		this.setComplainantAssessorId(complainantAssessorId);
		this.setAdminId(adminId);
		setComplaint(null);
		setComplaintType(null);
		setAssess(null);
		setAssessType(null);
		setHandleType(null);
		setHandleOpinion(null);
	}//end reset()
		// ?????��??
	private void bean2Form(AssessComplaint assessComplaint) {
		setId(assessComplaint.getId().toString());
		setComplainantAssessorId(assessComplaint.getComplainantAssessor().getId().toString());
		setAdminId(assessComplaint.getAdmin().getId().toString());
		setComplaint(assessComplaint.getComplaint());
		setComplaintType(assessComplaint.getComplaintType().toString()      );
		setAssess(assessComplaint.getAssess());
		setAssessType(assessComplaint.getAssessType());
		setHandleType(assessComplaint.getHandleType().toString()      );
		setHandleOpinion(assessComplaint.getHandleOpinion());
	}//end bean2Form()
	public String edit() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// id???????????
		if (this.getId() == null) {
			saveActionError("assessComplaint.message.edit.notexist");
			return Constants.LIST_KEY;
		} else {
			// ???????
			AssessComplaint assessComplaint = this.getAssessComplaintService().select(Integer.valueOf(id));
			
			// ??????????????
			if (assessComplaint == null) {
				saveActionError("assessComplaint.message.edit.notexist");
				return Constants.LIST_KEY;
			} else {
				// ?????��??
				bean2Form(assessComplaint);
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
		AssessComplaint assessComplaint = new AssessComplaint();
		assessComplaint.setComplainantAssessor(this.getUserService().selectById(Integer.parseInt(complainantAssessorId)));    
		assessComplaint.setAdmin(this.getUserService().selectById(Integer.parseInt(adminId)));    
		assessComplaint.setComplaint(this.getComplaint());
		assessComplaint.setComplaintType(Integer.valueOf(this.getComplaintType() ));
		assessComplaint.setAssess(this.getAssess());
		assessComplaint.setAssessType(this.getAssessType());
		assessComplaint.setHandleType(Integer.valueOf(this.getHandleType() ));
		assessComplaint.setHandleOpinion(this.getHandleOpinion());
		String strOneId = ServletActionContext.getRequest().getParameter("oneId");
		System.out.println("F2 insert getParameter  of oneId:"+strOneId);
		Publish oneInstance = this.getPublishService().select(Integer.parseInt(strOneId));
		assessComplaint.setPublish(oneInstance);
		
		nid = this.getAssessComplaintService().insert(assessComplaint);
		
		// ?????????????
		Pager pagerSession = (Pager) getSession(Constants.PAGER_ASSESSCOMPLAINT);
		if(pagerSession == null){
			//??????????
			super.pageSize = Constants.pageSize;
			super.pageNo = Constants.pageNo;
		}else{
			super.pageSize = pagerSession.getPageSize();
			super.pageNo = pagerSession.getPageNo();
			
		}
		
		//????????????
		super.pager = this.getAssessComplaintService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		
		
		}catch(Exception e){
			saveActionError2(e.toString());
			saveActionMessage2(" Sorry ");
			return Constants.ERROR_KEY;
		}
		
		// ?????????
		if (nid != null) {
			saveActionMessage("assessComplaint.message.add.success");
			return Constants.LIST_KEY;
		} else {
			saveActionError("assessComplaint.message.add.failed");
			return Constants.ADD_KEY;
		}
	}//end insert()
	public String update() throws Exception {
		// 
		clearErrorsAndMessages();
		
		try{
			// 
			AssessComplaint assessComplaint = this.getAssessComplaintService().select(new Integer(id));
			assessComplaint.setComplainantAssessor(this.getUserService().selectById(Integer.parseInt(complainantAssessorId)));    
			assessComplaint.setAdmin(this.getUserService().selectById(Integer.parseInt(adminId)));    
			
			assessComplaint.setComplaint(this.getComplaint());
			assessComplaint.setComplaintType(Integer.valueOf(this.getComplaintType() ));
			assessComplaint.setAssess(this.getAssess());
			assessComplaint.setAssessType(this.getAssessType());
			assessComplaint.setHandleType(Integer.valueOf(this.getHandleType() ));
			assessComplaint.setHandleOpinion(this.getHandleOpinion());
		this.getAssessComplaintService().update(assessComplaint);
		
		bean2Form(assessComplaint);	
		
		// ?????????????
		Pager pagerSession = (Pager) getSession(Constants.PAGER_ASSESSCOMPLAINT);
		if(pagerSession == null){
			//??????????
			super.pageSize = Constants.pageSize;
			super.pageNo = Constants.pageNo;
		}else{
			super.pageSize = pagerSession.getPageSize();
			super.pageNo = pagerSession.getPageNo();
			
		}
		
			// ????????????
			super.pager = this.getAssessComplaintService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
			saveActionMessage("assessComplaint.message.edit.success");
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
				saveActionError("assessComplaint.message.edit.notexist");
			} else {
				// ??????
				this.getAssessComplaintService().delete(Integer.valueOf(id));
				saveActionMessage("assessComplaint.message.delete.success");
			}
			
			// ???????????
			super.pager = this.getAssessComplaintService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
			
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
	 
	public AssessComplaintService getAssessComplaintService() {
		return assessComplaintService;
	}
	public void setAssessComplaintService(AssessComplaintService assessComplaintService) {
		this.assessComplaintService = assessComplaintService;
	}
	
	
	 
	public String getComplaint(){
		return  complaint;
	}
	public void  setComplaint(String complaint){
		this.complaint = complaint ;
	}
	 
	public String getComplaintType(){
		return  complaintType;
	}
	public void  setComplaintType(String complaintType){
		this.complaintType = complaintType ;
	}
	 
	public String getAssess(){
		return  assess;
	}
	public void  setAssess(String assess){
		this.assess = assess ;
	}
	 
	public String getAssessType(){
		return  assessType;
	}
	public void  setAssessType(String assessType){
		this.assessType = assessType ;
	}
	 
	public String getHandleType(){
		return  handleType;
	}
	public void  setHandleType(String handleType){
		this.handleType = handleType ;
	}
	 
	public String getHandleOpinion(){
		return  handleOpinion;
	}
	public void  setHandleOpinion(String handleOpinion){
		this.handleOpinion = handleOpinion ;
	}
	 
	 public String getUsername() {
	 	return username;
	 }
	 public void setUsername(String username) {
	 	this.username = username;
	 }
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getComplainantAssessorId() {
		return complainantAssessorId;
	}
	public void setComplainantAssessorId(String complainantAssessorId) {
		this.complainantAssessorId = complainantAssessorId;
	}
	 
	 
	 
}//end class
