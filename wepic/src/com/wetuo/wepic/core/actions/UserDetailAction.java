package com.wetuo.wepic.core.actions ;
 
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Date;
import java.util.StringTokenizer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import com.wetuo.wepic.core.beans.UserDetail;
import com.wetuo.wepic.core.service.UserDetailService;
 
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.struts.PageAction;
import com.wetuo.wepic.common.struts.Constants;
import com.wetuo.wepic.common.struts.RegExpression;
import com.wetuo.wepic.common.util.PictureUtil;
 
 
import org.apache.struts2.ServletActionContext;
	import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.core.service.UserService;
public class UserDetailAction extends PageAction {
		
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
 	private UserDetailService userDetailService;
	protected String key = null ; 
	protected String value = null ; 
	protected String picName = null ; 
	protected File  pic= null ; 
	protected String  picUrl= null ; 
	protected String picFileName = null ; 
	protected String picContentType = null ; 
	protected String username = null; 
	
	public void validate() {
		
		// ?????????
		clearErrorsAndMessages();
		
		// ??????????
		String queryString = getRequestPath();
		if (queryString.indexOf("userDetailadd!insert") != -1 || queryString.indexOf("userDetailedit!update") != -1) {
		
			if (key == null || key.equals("")) {
				addFieldError("key", "key must be inputed");
			}//end if null
			if (value == null || value.equals("")) {
				addFieldError("value", "value must be inputed");
			}//end if null
			if (picName == null || picName.equals("")) {
				addFieldError("picName", "picName must be inputed");
			}//end if null
			if (pic == null) {
				addFieldError("picUrl", "picUrl must be inputed");
			}//end if null
				// ??????? 
				// ??????? 
				// ??????? 
				// ??????? 
				// ??????? 
				// ??????? 
		}//end if
	}//end validate()
	
	public File getPic() {
		return pic;
	}
	public void setPic(File pic) {
		this.pic = pic;
	}
	public String getPicFileName() {
		return picFileName;
	}
	public void setPicFileName(String picFileName) {
		this.picFileName = picFileName;
	}
	public String getPicContentType() {
		return picContentType;
	}
	public void setPicContentType(String picContentType) {
		this.picContentType = picContentType;
	}
	public String init() throws Exception  {
		// ?????????
		clearErrorsAndMessages();
		
		// ??????????
		super.pageSize = Constants.pageSize;
		super.pageNo = Constants.pageNo;
		
		// ???????????
		super.pager = this.getUserDetailService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		//super.pager = this.getUserDetailService().list(super.pageSize, super.pageNo);
		
		// ?????????
		//setSession(Constants.PAGER_USERDETAIL, super.pager);
		
		return Constants.LIST_KEY;
	}
	public String initAdmin() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// ??????????
		super.pageSize = Constants.pageSize;
		super.pageNo = Constants.pageNo;
		
		super.pager = this.getUserDetailService().list(super.pageSize, super.pageNo);
		
		// ?????????
		//setSession(Constants.PAGER_USERDETAIL, super.pager);
		
		return Constants.USERDETIALLIST_KEY;
		
	}//end init()
		
	public String list() throws Exception {
		clearErrorsAndMessages();
		super.pager = this.getUserDetailService().list(super.getLoginUsername(), super.pageSize, super.pageNo);	
		//setSession(Constants.PAGER_USERDETAIL, super.pager);
		return Constants.LIST_KEY;
	}//end list()
	
	public String listAdmin() throws Exception {
		clearErrorsAndMessages();
		String userId = ServletActionContext.getRequest().getParameter("oneId");
		
		// ???????????
		super.pager = this.getUserDetailService().list(this.getUserService().selectById(Integer.parseInt(userId)).getUsername(), super.pageSize, super.pageNo);	
		
		// ?????????
		//setSession(Constants.PAGER_USERDETAIL, super.pager);
		
		return "listAdmin";
		
	}//end list()
	
	
	
	
	public String adminList() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// ???????????
		super.pager = this.getUserDetailService().list(super.pageSize, super.pageNo);	
		
		// ?????????
		//setSession(Constants.PAGER_USERDETAIL, super.pager);
		
		return Constants.USERDETIALLIST_KEY;
		
	}	
	public String adminAdd() throws Exception {
		System.out.println("F2 add getParameter of oneId: "+ServletActionContext.getRequest().getParameter("oneId"));
		
		if(ServletActionContext.getRequest().getParameter("from") != null && ServletActionContext.getRequest().getParameter("from") != ""){
			if(ServletActionContext.getRequest().getParameter("from").indexOf("userDetail") > -1){
				ServletActionContext.getResponse().sendRedirect("user!init.do");
			}
		}
		ServletActionContext.getRequest().setAttribute("oneId", ServletActionContext.getRequest().getParameter("oneId"));
		// ?????????
		clearErrorsAndMessages();
		
		
		// ?????????
		reset();
		return Constants.ADD_KEY;
	}
	public String add() throws Exception {
		System.out.println("F2 add getParameter of oneId: "+ServletActionContext.getRequest().getParameter("oneId"));
		
		if(ServletActionContext.getRequest().getParameter("from") != null && ServletActionContext.getRequest().getParameter("from") != ""){
			if(ServletActionContext.getRequest().getParameter("from").indexOf("userDetail") > -1){
				ServletActionContext.getResponse().sendRedirect("user!init_notverify.do");
			}
		}
		ServletActionContext.getRequest().setAttribute("oneId", ServletActionContext.getRequest().getParameter("oneId"));
		// ?????????
		clearErrorsAndMessages();
		
		
		// ?????????
		reset();
		return Constants.ADD_KEY;
	}//end add()
	
	
	public String add_notverify() throws Exception {
		System.out.println("F2 add getParameter of oneId: "+ServletActionContext.getRequest().getParameter("oneId"));
		
		if(ServletActionContext.getRequest().getParameter("from") != null && ServletActionContext.getRequest().getParameter("from") != ""){
			if(ServletActionContext.getRequest().getParameter("from").indexOf("userDetail") > -1){
				ServletActionContext.getResponse().sendRedirect("user!init.do");
			}
		}
		ServletActionContext.getRequest().setAttribute("oneId", ServletActionContext.getRequest().getParameter("oneId"));
		// ?????????
		clearErrorsAndMessages();
		
		
		// ?????????
		reset();
		return Constants.ADD_KEY_NOTVERIFY;
	}//end add()
	
	private void reset() {
		setId(null);
		setKey(null);
		setValue(null);
		setPicName(null);
		//setPicUrl(null);
	}//end reset()
		// ?????��??
	private void bean2Form(UserDetail userDetail) {
		setId(userDetail.getId().toString());
		setKey(userDetail.getName());
		setValue(userDetail.getType());
		setPicName(userDetail.getPicName());
		setPicUrl(userDetail.getPicUrl());
	}//end bean2Form()
	public String adminEdit() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// id???????????
		if (this.getId() == null) {
			saveActionError("userDetail.message.edit.notexist");
			return Constants.LIST_KEY;
		} else {
			// ???????
			UserDetail userDetail = this.getUserDetailService().select(Integer.valueOf(id));
			
			// ??????????????
			if (userDetail == null) {
				saveActionError("userDetail.message.edit.notexist");
				return Constants.LIST_KEY;
			} else {
				// ?????��??
				bean2Form(userDetail);
				return Constants.ADMINDETAILEDIT_KEY;
			}
		}//end if
		
	}
	public String edit() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// id???????????
		if (this.getId() == null) {
			saveActionError("userDetail.message.edit.notexist");
			return Constants.LIST_KEY;
		} else {
			// ???????
			UserDetail userDetail = this.getUserDetailService().select(Integer.valueOf(id));
			
			// ??????????????
			if (userDetail == null) {
				saveActionError("userDetail.message.edit.notexist");
				return Constants.LIST_KEY;
			} else {
				// ?????��??
				bean2Form(userDetail);
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
		UserDetail userDetail = new UserDetail();
		userDetail.setName(this.getKey());
		userDetail.setType(this.getValue());
		userDetail.setPicName(this.getPicName());
		userDetail.setPicUrl(this.getPicUrl());
		String strOneId = ServletActionContext.getRequest().getParameter("oneId");
		System.out.println("F2 insert getParameter  of oneId:"+strOneId);
		User oneInstance = this.getUserService().selectById(Integer.parseInt(strOneId));
		userDetail.setUser(oneInstance);
		
		nid = this.getUserDetailService().insert(userDetail);
		
		// ?????????????
		Pager pagerSession = (Pager) getSession(Constants.PAGER_USERDETAIL);
		if(pagerSession == null){
			//??????????
			super.pageSize = Constants.pageSize;
			super.pageNo = Constants.pageNo;
		}else{
			super.pageSize = pagerSession.getPageSize();
			super.pageNo = pagerSession.getPageNo();
			
		}
		
		//????????????
		super.pager = this.getUserDetailService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		
		
		}catch(Exception e){
			saveActionError2(e.toString());
			saveActionMessage2(" Sorry ");
			return Constants.ERROR_KEY;
		}
		
		// ?????????
		if (nid != null) {
			saveActionMessage("userDetail.message.add.success");
			return Constants.LIST_KEY;
		} else {
			saveActionError("userDetail.message.add.failed");
			return Constants.ADD_KEY;
		}
	}//end insert()
	
	
	
	public String insert_notverify() throws Exception {
		// 
		clearErrorsAndMessages();
		Integer nid = null ;
		
		try{
			
		//
		UserDetail userDetail = new UserDetail();
		userDetail.setName(this.getKey());
		userDetail.setType(this.getValue());
		userDetail.setPicName(this.getPicName());
		
		String strOneId = ServletActionContext.getRequest().getParameter("oneId");
		System.out.println("F2 insert getParameter  of oneId:"+strOneId);
		User oneInstance = this.getUserService().selectById(Integer.parseInt(strOneId));
		userDetail.setUser(oneInstance);
		String path=uploadPubimg(pic, super.getLoginUsername(), picContentType);
		userDetail.setPicUrl(path);
		nid = this.getUserDetailService().insert(userDetail);
		
		
		// ?????????????
		Pager pagerSession = (Pager) getSession(Constants.PAGER_USERDETAIL);
		if(pagerSession == null){
			//??????????
			super.pageSize = Constants.pageSize;
			super.pageNo = Constants.pageNo;
		}else{
			super.pageSize = pagerSession.getPageSize();
			super.pageNo = pagerSession.getPageNo();
			
		}
		
		//????????????
		super.pager = this.getUserDetailService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		
		
		}catch(Exception e){
			saveActionError2(e.toString());
			saveActionMessage2(" Sorry ");
			return Constants.ERROR_KEY;
		}
		
		// ?????????
		if (nid != null) {
			saveActionMessage("userDetail.message.add.success");
			return Constants.LIST_KEY;
		} else {
			saveActionError("userDetail.message.add.failed");
			return Constants.ADD_KEY;
		}
	}//end insert()
	
	
	
	public String adminUpdate() throws Exception {
		// 
		clearErrorsAndMessages();
		
		try{
			// 
			UserDetail userDetail = this.getUserDetailService().select(new Integer(id));
			userDetail.setName(this.getKey());
			userDetail.setType(this.getValue());
			userDetail.setPicName(this.getPicName());
			userDetail.setPicUrl(this.getPicUrl());
		this.getUserDetailService().update(userDetail);
		
		bean2Form(userDetail);	
		
		// ?????????????
		Pager pagerSession = (Pager) getSession(Constants.PAGER_USERDETAIL);
		if(pagerSession == null){
			//??????????
			super.pageSize = Constants.pageSize;
			super.pageNo = Constants.pageNo;
		}else{
			super.pageSize = pagerSession.getPageSize();
			super.pageNo = pagerSession.getPageNo();
			
		}
		
			// ????????????
			super.pager = this.getUserDetailService().list(super.pageSize, super.pageNo);
			saveActionMessage("userDetail.message.edit.success");
		}catch(Exception e){
			saveActionError2(e.toString());
			saveActionMessage2(" Sorry ");
			return Constants.ERROR_KEY;
		}
		
		return Constants.USERDETIALLIST_KEY;
	}
	public String update() throws Exception {
		// 
		clearErrorsAndMessages();
		
		try{
			// 
			UserDetail userDetail = this.getUserDetailService().select(new Integer(id));
			userDetail.setName(this.getKey());
			userDetail.setType(this.getValue());
			userDetail.setPicName(this.getPicName());
			userDetail.setPicUrl(this.getPicUrl());
		this.getUserDetailService().update(userDetail);
		
		bean2Form(userDetail);	
		
		// ?????????????
		Pager pagerSession = (Pager) getSession(Constants.PAGER_USERDETAIL);
		if(pagerSession == null){
			//??????????
			super.pageSize = Constants.pageSize;
			super.pageNo = Constants.pageNo;
		}else{
			super.pageSize = pagerSession.getPageSize();
			super.pageNo = pagerSession.getPageNo();
			
		}
		
			// ????????????
			super.pager = this.getUserDetailService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
			saveActionMessage("userDetail.message.edit.success");
		}catch(Exception e){
			saveActionError2(e.toString());
			saveActionMessage2(" Sorry ");
			return Constants.ERROR_KEY;
		}
		
		return Constants.LIST_KEY;
	}//end update() 
	
	
	
	public String update_notverify() throws Exception {
		// 
		clearErrorsAndMessages();
		
		try{
			// 
			UserDetail userDetail = this.getUserDetailService().select(new Integer(id));
			userDetail.setName(this.getKey());
			userDetail.setType(this.getValue());
			userDetail.setPicName(this.getPicName());
			if (this.getPic()==null) {
				userDetail.setPicUrl(userDetail.getPicUrl());
			}else {
				String paString=uploadPubimg(pic, super.getLoginUsername(), picContentType);
				userDetail.setPicUrl(paString);		
			}		
		
		this.getUserDetailService().update(userDetail);
		
		bean2Form(userDetail);	
		
		// ?????????????
		Pager pagerSession = (Pager) getSession(Constants.PAGER_USERDETAIL);
		if(pagerSession == null){
			//??????????
			super.pageSize = Constants.pageSize;
			super.pageNo = Constants.pageNo;
		}else{
			super.pageSize = pagerSession.getPageSize();
			super.pageNo = pagerSession.getPageNo();
			
		}
		
			// ????????????
			super.pager = this.getUserDetailService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
			saveActionMessage("userDetail.message.edit.success");
		}catch(Exception e){
			saveActionError2(e.toString());
			saveActionMessage2(" Sorry ");
			return Constants.ERROR_KEY;
		}
		
		return Constants.LIST_KEY;
	}//end update() 
	
	public String adminDelete() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		try{
			// id???????????
			if (this.getId() == null) {
				saveActionError("userDetail.message.edit.notexist");
			} else {
				// ??????
				this.getUserDetailService().delete(Integer.valueOf(id));
				saveActionMessage("userDetail.message.delete.success");
			}
			
			// ???????????
			super.pager = this.getUserDetailService().list(super.pageSize, super.pageNo);
			
		}catch(Exception e){
			saveActionError2(e.toString());
			saveActionMessage2("Please delete child first");
			return Constants.ERROR_KEY;
		}
		return Constants.USERDETIALLIST_KEY;
		
	}
	public String delete() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		try{
			// id???????????
			if (this.getId() == null) {
				saveActionError("userDetail.message.edit.notexist");
			} else {
				// ??????
				this.getUserDetailService().delete(Integer.valueOf(id));
				saveActionMessage("userDetail.message.delete.success");
			}
			
			// ???????????
			super.pager = this.getUserDetailService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
			
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
	 
	public UserDetailService getUserDetailService() {
		return userDetailService;
	}
	public void setUserDetailService(UserDetailService userDetailService) {
		this.userDetailService = userDetailService;
	}
	
	public String getKey(){
		return  key;
	}
	public void  setKey(String key){
		this.key = key ;
	}
	 
	public String getValue(){
		return  value;
	}
	public void  setValue(String value){
		this.value = value ;
	}
	 
	public String getPicName(){
		return  picName;
	}
	public void  setPicName(String picName){
		this.picName = picName ;
	}
	 
	public String getPicUrl(){
		return  picUrl;
	}
	public void  setPicUrl(String picUrl){
		this.picUrl = picUrl ;
	}
	 
	 public String getUsername() {
	 	return username;
	 }
	 public void setUsername(String username) {
	 	this.username = username;
	 }
	 
//end class
//上传项目图片
public String uploadPubimg(File file,String fileName,String filetype){
	 String resPath = "";
		try{
			String uploadPath = ServletActionContext.getServletContext().getRealPath("/userDetileImg");
			InputStream is = new FileInputStream(file);
			File file2=new File(uploadPath);
			
			//String p=Ac
			System.out.println("========");
			if(!file2.exists()){
				file2.mkdir();
				
			}
			
			
			HttpServletRequest request = ServletActionContext.getRequest();
			String path = request.getContextPath();
			String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
			
			Date date = new Date();
			DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
			String name1 = format.format(date);
			
			//String baseName =    //getRandomStr();
			//String picType = fileName.substring(fileName.lastIndexOf(".")+1);
			String picName = name1+fileName+".jpg";
			
			File toFile = new File(uploadPath,picName);
			System.out.println("-------------uploadPath---------- : "+uploadPath);
			OutputStream os = new FileOutputStream(toFile);
			byte[] b = new byte[1024];
			int len = 0;
			while((len = is.read(b)) != -1){
				os.write(b, 0, len);
			}
			
//			String simplePicName = name1 + baseName + "_simple" + "."+picType;		
//			String biggerPicName = name1 + baseName + "_bigger" + "."+picType;		
//			String srcImgPath=uploadPath+"\\"+picName;
//			String logoText="奇行科技";
//			String targetPath=uploadPath+"\\"+simplePicName;
			//ImgWaterMark.markByText(logoText, srcImgPath, targetPath);
			is.close();
			os.close();
			PictureUtil j = new PictureUtil();  
	       
			resPath = basePath+"userDetileImg/"+picName;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return resPath;
}


}//end class