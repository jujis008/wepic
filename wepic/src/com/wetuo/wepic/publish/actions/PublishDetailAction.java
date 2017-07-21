package com.wetuo.wepic.publish.actions ;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.swing.ImageIcon;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.struts.Constants;
import com.wetuo.wepic.common.struts.PageAction;
import com.wetuo.wepic.common.util.ConvertChinese;
import com.wetuo.wepic.common.util.ImgWaterMark;
import com.wetuo.wepic.common.util.JpegToolException;
import com.wetuo.wepic.common.util.PictureUtil;
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.core.service.UserService;
import com.wetuo.wepic.publish.beans.Publish;
import com.wetuo.wepic.publish.beans.PublishCat;
import com.wetuo.wepic.publish.beans.PublishDetail;
import com.wetuo.wepic.publish.beans.PublishSpecialCat;
import com.wetuo.wepic.publish.service.PublishCatService;
import com.wetuo.wepic.publish.service.PublishDetailService;
import com.wetuo.wepic.publish.service.PublishService;
public class PublishDetailAction extends PageAction {
		
	private UserService userService;
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	private PublishService publishService;
	public PublishService getPublishService() {
		return publishService;
	}
	public void setPublishService(PublishService publishService) {
		this.publishService = publishService;
	}
	private PublishCatAction publishCatAction;
	private PublishCatService publishCatService;
	/////instantce variable//////
	private static final long serialVersionUID = 1L;
	protected String id = null ; 
 	private PublishDetailService publishDetailService;
	protected String detailName = null ; 
	protected String value = null ; 
	protected String picUrl = null ; 
	protected String position = null ; 
	protected String order = null ; 
	protected String username = null; 
	private File picture;  
	private File publishPicture;
	private String publishPictureFileName;
	private String publishPictureContentType;
	private File myfile;
	private String myfileContentType;
	private String myfileFileName; 
	private String publishId;
	private List<PublishDetail> publishDetailList;
	private String inputError;
	private String marquee;
	private String layout;
	private Publish resPublish;
	private Integer width;
	private Integer height;
	
	public void validate() {
		
		clearErrorsAndMessages();
		
		String queryString = getRequestPath();
		if (queryString.indexOf("publishDetailadd!insert") != -1 || queryString.indexOf("publishDetailedit!update") != -1) {
		
//			if (name == null || name.equals("")) {
//				addFieldError("name", "name must be inputed");
//			}//end if null
//			if (value == null || value.equals("")) {
//				addFieldError("value", "value must be inputed");
//			}//end if null
//			if (picUrl == null || picUrl.equals("")) {
//				addFieldError("picUrl", "picUrl must be inputed");
//			}//end if null
//			if (position == null || position.equals("")) {
//				addFieldError("position", "position must be inputed");
//			}//end if null
//			if (order == null || order.equals("")) {
//				addFieldError("order", "order must be inputed");
//			}//end if null
//				// ??????? 
//				// ??????? 
//				// ??????? 
//			if (name == null || name.equals("")) {
//				addFieldError("name", getText("publishDetail.error.name"));
//			}
//			if(myfile == null || myfile.length() == 0){
//				addFieldError("myfile", "上传图片不能为空！");
//			}
				// ??????? 
				// ??????? 
				// ??????? 
				// ??????? 
		}//end if
	}//end validate()
	public String init() throws Exception {
		clearErrorsAndMessages();
		super.pageSize = Constants.pageSize;
		super.pageNo = Constants.pageNo;
		super.pager = this.getPublishDetailService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		super.pager.setRowCount(super.pager.getResultList().size());
		//setSession(Constants.PAGER_PUBLISHDETAIL, super.pager);
		return Constants.LIST_KEY;
	}//end init()
	
	public String initBase() throws Exception {
		clearErrorsAndMessages();
		super.pageSize = Constants.pageSize;
		super.pageNo = Constants.pageNo;
		String ps = ServletActionContext.getRequest().getParameter("pageSize");
		String pn = ServletActionContext.getRequest().getParameter("pageNo");
		if(ps != null){
			super.pageSize = Integer.parseInt(ps);
		}
		if(pn != null){
			super.pageNo = Integer.parseInt(pn);
		}
//		super.pager = this.getPublishDetailService().listForCommonUser(super.getLoginUsername(), super.pageSize, super.pageNo);
		super.pager = this.getPublishDetailService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		//super.pager.setRowCount(super.pager.getResultList().size());
		//setSession(Constants.PAGER_PUBLISHDETAIL, super.pager);
		return "initBase";
	}//end init()
	
	public String initAdmin() throws Exception {
		clearErrorsAndMessages();
		super.pageSize = Constants.pageSize;
		super.pageNo = Constants.pageNo;
		super.pager = this.getPublishDetailService().list(super.pageSize, super.pageNo);
		//setSession(Constants.PAGER_PUBLISHDETAIL, super.pager);
		return "listAdmin";
	}//end init()
	//
	
	
	
	public String initUnderPublish() throws Exception {
		clearErrorsAndMessages();
		super.pageSize = Constants.pageSize;
		super.pageNo = Constants.pageNo;
		String oneId = ServletActionContext.getRequest().getParameter("oneId");
		if(oneId == null || oneId.length() == 0){
			oneId = this.getPublishId();
		}
		if(oneId == null || oneId.length() == 0){
			return "index";
		}else{
			this.setPublishId(oneId);
		}
		String ps = ServletActionContext.getRequest().getParameter("pageSize");
		String pn = ServletActionContext.getRequest().getParameter("pageNo");
		if(ps != null){
			super.pageSize = Integer.parseInt(ps);
		}
		if(pn != null){
			super.pageNo = Integer.parseInt(pn);
		}
	
//		if(oneId != null || oneId.length() == 0){
//			this.setPublishId(oneId);
//		}
		//super.pager = this.getPublishDetailService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		super.pager = this.getPublishDetailService().listUnderPublish(Integer.parseInt(oneId), super.pageSize, super.pageNo); 
		//super.pager.setRowCount(super.pager.getResultList().size());
		//setSession(Constants.PAGER_PUBLISHDETAIL, super.pager);
		return "publishDetailUnderPublishAdmin";
	}//end init()
	
	public String initUnderPublishBase() throws Exception {
		clearErrorsAndMessages();
		super.pageSize = Constants.pageSize;
		super.pageNo = Constants.pageNo;
		String oneId = ServletActionContext.getRequest().getParameter("oneId");
		if(oneId == null || oneId.length() == 0){
			oneId = this.getPublishId();
		}
		if(oneId == null || oneId.length() == 0){
			return "index";
		}else{
			this.setPublishId(oneId);
		}
		String ps = ServletActionContext.getRequest().getParameter("pageSize");
		String pn = ServletActionContext.getRequest().getParameter("pageNo");
		if(ps != null){
			super.pageSize = Integer.parseInt(ps);
		}
		if(pn != null){
			super.pageNo = Integer.parseInt(pn);
		}
	
//		if(oneId != null || oneId.length() == 0){
//			this.setPublishId(oneId);
//		}
		//super.pager = this.getPublishDetailService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		super.pager = this.getPublishDetailService().listUnderPublish(Integer.parseInt(oneId), super.pageSize, super.pageNo); 
		//super.pager.setRowCount(super.pager.getResultList().size());
		//setSession(Constants.PAGER_PUBLISHDETAIL, super.pager);
		return Constants.LIST_KEY;
	}//end init()
	
	public String listFrontDetailsUnderPublish() throws Exception {
		clearErrorsAndMessages();
		super.pageSize = Constants.pageSize;
		super.pageNo = Constants.pageNo;
		String oneId = ServletActionContext.getRequest().getParameter("oneId");
		if(oneId == null || oneId.length() == 0){
			oneId = this.getPublishId();
		}else{
			this.setPublishId(oneId);
		}
		String ps = ServletActionContext.getRequest().getParameter("pageSize");
		String pn = ServletActionContext.getRequest().getParameter("pageNo");
		if(ps != null){
			super.pageSize = Integer.parseInt(ps);
		}
		if(pn != null){
			super.pageNo = Integer.parseInt(pn);
		}
		//super.pager = this.getPublishDetailService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		super.pager = this.getPublishDetailService().listUnderPublish(Integer.parseInt(oneId), super.pageSize, super.pageNo);
		//setSession(Constants.PAGER_PUBLISHDETAIL, super.pager);
		//return Constants.LIST_KEY;
		//return "listFrontDetailsUnderPublish";
		//return Constants.LIST_KEY;
		return "listFrontDetailsUnderPublish";
	}//end init()
		
	public String list() throws Exception {
		clearErrorsAndMessages();
		
		super.pager = this.getPublishDetailService().list(super.getLoginUsername(), super.pageSize, super.pageNo);	
		
		//setSession(Constants.PAGER_PUBLISHDETAIL, super.pager);
		
		return Constants.LIST_KEY;
		
	}//end list()
	
	public String listEachOneDeatals(){
		clearErrorsAndMessages();
		String oneId = ServletActionContext.getRequest().getParameter("oneId");
		if(oneId == null || oneId.length() == 0){
			oneId = this.getPublishId();
		}
		if(oneId == null || oneId.length() == 0){
			return "index";
		}
		super.pager = this.getPublishDetailService().listUnderPublish(Integer.parseInt(oneId), super.pageSize, super.pageNo); 
		return Constants.LIST_KEY;
	}
	
	public String listAdmin() throws Exception {
		clearErrorsAndMessages();
		
		//super.pager = this.getPublishDetailService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		super.pager = this.getPublishDetailService().list(super.pageSize, super.pageNo);
		
		//setSession(Constants.PAGER_PUBLISHDETAIL, super.pager);
		
		return "listAdmin";
		
	}//end list()
	
	public String addNotVerify() throws Exception {
		System.out.println("F2 add getParameter of oneId: "+ServletActionContext.getRequest().getParameter("oneId"));
		
		if(ServletActionContext.getRequest().getParameter("from") != null && ServletActionContext.getRequest().getParameter("from") != ""){
			if(ServletActionContext.getRequest().getParameter("from").indexOf("publishDetail") > -1){
				ServletActionContext.getResponse().sendRedirect("publish!init.do");
			}
		}
		ServletActionContext.getRequest().setAttribute("oneId", ServletActionContext.getRequest().getParameter("oneId"));
		showThePublishofdetais(Integer.parseInt(ServletActionContext.getRequest().getParameter("oneId")));
		// ?????????
		clearErrorsAndMessages();
		
		
		// ?????????
		reset();
		return Constants.ADDNOTVERIFY_KEY;
	}//end add()
	public String add() throws Exception {
		int oneId=Integer.valueOf(ServletActionContext.getRequest().getParameter("oneId").toString());
		System.out.println("F2 add getParameter of oneId: "+ServletActionContext.getRequest().getParameter("oneId"));
		
		if(ServletActionContext.getRequest().getParameter("from") != null && ServletActionContext.getRequest().getParameter("from") != ""){
			if(ServletActionContext.getRequest().getParameter("from").indexOf("publishDetail") > -1){
				ServletActionContext.getResponse().sendRedirect("publish!init.do");
			}
		}
		ServletActionContext.getRequest().setAttribute("oneId", ServletActionContext.getRequest().getParameter("oneId"));
		showThePublishofdetais(Integer.parseInt(ServletActionContext.getRequest().getParameter("oneId")));
		// ?????????
		clearErrorsAndMessages();
		Publish publish=this.getPublishService().select(oneId);
		ActionContext.getContext().put("mypublish",publish);
		ActionContext.getContext().put("oneId",oneId);
		
		// ?????????
		reset();
		return "storyAlbumn";
	}//end add()
	
	public String publishAndDetail() {
		int oneId=Integer.valueOf(ServletActionContext.getRequest().getParameter("oneId").toString());
		Publish publish=this.getPublishService().select(oneId);
		ActionContext.getContext().put("mypublish",publish);
		showThePublishofdetais(oneId);
		return "publishAndDetail";
	}
	//检索publish对应的publishDetail
	public void showThePublishofdetais(int publishId){
		List<PublishDetail> publishDetailList = this.publishDetailService.showThePublishofdetais(publishId);
		this.setPublishDetailList(publishDetailList);
	}
	public String publishAndDetailEdit() {
		int oneId=Integer.valueOf(ServletActionContext.getRequest().getParameter("oneId").toString());
		Publish publish=this.getPublishService().select(oneId);
		this.resPublish=publish;
		showThePublishofdetais(oneId);
		return "publishAndDetailEdit";
	}
	private void reset() {
		setId(null);
		setDetailName(null);
		setValue(null);
		setPicUrl(null);
		setPosition(null);
		setOrder(null);
		this.setPicture(null);
	}//end reset()
		// ?????��??
	private void bean2Form(PublishDetail publishDetail) {
		setId(publishDetail.getId().toString());
		setDetailName(publishDetail.getName());
		setValue(publishDetail.getValue());
		setPicUrl(publishDetail.getPicUrl());
		setPosition(publishDetail.getPosition());
		if(publishDetail.getOrder2() != null){
			setOrder(publishDetail.getOrder2().toString()      );
		}
		setMarquee(publishDetail.getMarquee().toString());
		setLayout(publishDetail.getLayout().toString());
		//this.setPicture(picture);
	}//end bean2Form()
	public String edit() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// id???????????
		if (this.getId() == null) {
			saveActionError("publishDetail.message.edit.notexist");
			return Constants.LIST_KEY;
		} else {
			// ???????
			PublishDetail publishDetail = this.getPublishDetailService().select(Integer.valueOf(id));
			
			// ??????????????
			if (publishDetail == null) {
				saveActionError("publishDetail.message.edit.notexist");
				return Constants.LIST_KEY;
			} else {
				// ?????��??
				bean2Form(publishDetail);
				return Constants.EDIT_KEY;
			}
		}//end if
		
	}//end edit()
		
	public String insert() throws Exception {
		// 
		clearErrorsAndMessages();
		Integer nid = null ;
		String imageUrl = "";
		String strOneId = ServletActionContext.getRequest().getParameter("oneId");
		Publish publish=this.getPublishService().select(Integer.valueOf(strOneId));
		//String catId=publish.getPublishCat().getId().toString();
		//System.out.println(catId+"***************");
		try{
			
		//
		PublishDetail publishDetail = new PublishDetail();
		publishDetail.setName(this.getDetailName());
		publishDetail.setValue(this.getValue());
		if(this.myfile != null){
			imageUrl = uploadFile();
		}
		//publishDetail.setPicUrl(this.getPicUrl());
		publishDetail.setPicUrl(imageUrl);
		publishDetail.setPosition(this.getPosition());
//		publishDetail.setOrder2(Integer.valueOf(this.getOrder() ));
//		if(this.getOrder().length() > 0){
//			publishDetail.setOrder2(Integer.valueOf(this.getOrder() ));
//		}
		if (this.getMarquee()==null) {
			publishDetail.setMarquee(0);
		}else{
			publishDetail.setMarquee(Integer.valueOf(this.getMarquee()));	
		}
		if (this.getLayout()==null) {
			publishDetail.setLayout(0);
		}else {
		publishDetail.setLayout(Integer.valueOf(this.getLayout()));
		}
		//System.out.println("F2 insert getParameter  of oneId:"+strOneId);
		Publish oneInstance = this.getPublishService().select(Integer.parseInt(strOneId));
		publishDetail.setPublish(oneInstance);
		
		//1 ����������    
		//Blob blobFile1 = null;
		//FileInputStream fis1 = new FileInputStream(smooksMappingFile);    
		//FileInputStream fis1 = new FileInputStream(picture);    
		//ת��Blob����    
		//blobFile1 = Hibernate.createBlob(fis1);    
		//publishDetail.setPicture(blobFile1);
		
		nid = this.getPublishDetailService().insert(publishDetail);
		
		// ?????????????
		Pager pagerSession = (Pager) getSession(Constants.PAGER_PUBLISHDETAIL);
		if(pagerSession == null){
			//??????????
			super.pageSize = Constants.pageSize;
			super.pageNo = Constants.pageNo;
		}else{
			super.pageSize = pagerSession.getPageSize();
			super.pageNo = pagerSession.getPageNo();
			
		}
		
		//????????????
		super.pager = this.getPublishDetailService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		
		
		}catch(Exception e){
			//删除上传的文件
			String path = ServletActionContext.getRequest().getRealPath("/uploadImag");
			String fileName = imageUrl.substring(imageUrl.lastIndexOf("/"));
			String filePath = path+"/"+fileName;
			System.out.println("要删除的文件是："+filePath+"+===============================");
			removeFile(filePath);
			saveActionError2(e.toString());
			saveActionMessage2(" Sorry ");
			return Constants.ERROR_KEY;
		}
		
		// ?????????
		if (nid != null) {
			saveActionMessage("publishDetail.message.add.success");
			return add();
			//return Constants.LIST_KEY;
		} else {
			saveActionError("publishDetail.message.add.failed");
			return Constants.ADD_KEY;
		}
	}//end insert()
	
	//删除文件
	public void removeFile(String filePath){
		File file = new File(filePath);
		if(file.exists()){
			file.delete();
		}
	}
	public String uploadFile() throws Exception{
		//clearErrorsAndMessages();
		InputStream is = new FileInputStream(myfile);
		//设置文件上传的位置
		String uploadPath = ServletActionContext.getServletContext().getRealPath("/uploadImag");
		System.out.println("文件位置："+uploadPath);
		System.out.println("服务器路径："+ServletActionContext.getRequest().getRealPath("/uploadImag"));
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		System.out.println("path:"+path);
		System.out.println("basePath:"+basePath);
		//设置目标文件
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String picType = this.getMyfileFileName().substring(this.getMyfileFileName().lastIndexOf(".")+1);
		String randomStr = getRandomStr();
		String picName = format.format(date)+randomStr+"."+picType;
		File toFile = new File(uploadPath,picName);
		//创建一个输出流
		OutputStream os = new FileOutputStream(toFile);
		byte[] buffer = new byte[1024];
		int length = 0;
		while((length = is.read(buffer)) >0){
			os.write(buffer, 0, length);
		}
		is.close();
		os.close();
		String resPath = basePath+"uploadImag/"+picName;
		System.out.println("--------------"+resPath+"------------------");
		return resPath;
	}
	
	//随机生成一个字符串
	public String getRandomStr(){
		Random random = new Random();
		String baseStr = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuffer buffer = new StringBuffer();
		for(int i=0;i<10;i++){
			int num = random.nextInt(baseStr.length());
			buffer.append(baseStr.charAt(num));
		}
		return buffer.toString();
	}
	public String updatePublishDetail()throws Exception {
		try{ 
			// 
			
			int publishId=this.getResPublish().getId();
			Publish publish=this.getPublishService().select(publishId);
			resPublish=publish;
			PublishDetail publishDetail = this.getPublishDetailService().select(new Integer(id));
			publishDetail.setName(this.getDetailName());
			publishDetail.setValue(this.getValue());
			String imageUrl="";
			if(this.myfile != null){
				imageUrl = uploadFile();
				publishDetail.setPicUrl(imageUrl);
			}else {
				publishDetail.setPicUrl(publishDetail.getPicUrl());
			}
			publishDetail.setPosition(this.getPosition());
			//publishDetail.setOrder2(Integer.valueOf(this.getOrder() ));
			if(this.getOrder() != null && this.getOrder().length() > 0){
				publishDetail.setOrder2(Integer.valueOf(this.getOrder() ));
			}
			if (this.getMarquee()==null) {
				publishDetail.setMarquee(0);
			}else {
				publishDetail.setMarquee(Integer.valueOf(this.getMarquee()));
			}
			if (this.getLayout()==null) {
				publishDetail.setLayout(0);
			}else {
				publishDetail.setLayout(Integer.valueOf(this.getLayout()));
			}
			if (this.getPublishDetailService().update(publishDetail)) {
				showThePublishofdetais(publish.getId());
				resPublish=publish;
				return "updatePublishSuc";
			}
		}catch(Exception e){
			saveActionError2(e.toString());
			saveActionMessage2(" Sorry ");
			return Constants.ERROR_KEY;
		}
		
		return "";
	}
	public String update() throws Exception {
		// 
		clearErrorsAndMessages();
		
		try{ 
			// 
			PublishDetail publishDetail = this.getPublishDetailService().select(new Integer(id));
			publishDetail.setName(this.getDetailName());
			publishDetail.setValue(this.getValue());
			publishDetail.setPicUrl(this.getPicUrl());
			publishDetail.setPosition(this.getPosition());
			//publishDetail.setOrder2(Integer.valueOf(this.getOrder() ));
			if(this.getOrder() != null && this.getOrder().length() > 0){
				publishDetail.setOrder2(Integer.valueOf(this.getOrder() ));
			}
			if (this.getMarquee()==null) {
				publishDetail.setMarquee(0);
			}else {
				publishDetail.setMarquee(Integer.valueOf(this.getMarquee()));
			}
			if (this.getLayout()==null) {
				publishDetail.setLayout(0);
			}else {
				publishDetail.setLayout(Integer.valueOf(this.getLayout()));
			}
		this.getPublishDetailService().update(publishDetail);
		
		bean2Form(publishDetail);	
		
		// ?????????????
		Pager pagerSession = (Pager) getSession(Constants.PAGER_PUBLISHDETAIL);
		if(pagerSession == null){
			//??????????
			super.pageSize = Constants.pageSize;
			super.pageNo = Constants.pageNo;
		}else{
			super.pageSize = pagerSession.getPageSize();
			super.pageNo = pagerSession.getPageNo();
			
		}
		
			// ????????????
			super.pager = this.getPublishDetailService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
			saveActionMessage("publishDetail.message.edit.success");
		}catch(Exception e){
			saveActionError2(e.toString());
			saveActionMessage2(" Sorry ");
			return Constants.ERROR_KEY;
		}
		
		return Constants.LIST_KEY;
	}//end update() 
	public String  updatePublish(){
		try {
			String loginName = super.getLoginUsername();
			User user=this.getUserService().select(loginName);
			int id=this.getResPublish().getId();
			Publish publish=this.getPublishService().select(id);
			Publish publish1=this.getResPublish();
			PublishSpecialCat publishSpecialCat=publish.getPublishSpecialCat();
			if (publishPicture==null) {
				publish1.setPicUrl(publish.getPicUrl());
				publish1.setSamplePic(publish.getSamplePic());
				publish1.setBiggerPic(publish.getBiggerPic());
				publish1.setOriginalPic(publish.getOriginalPic());
				publish1.setSmallPic(publish.getSmallPic());
			}else {
				String picPath=uploadPubimg();
				publish1.setPicUrl(picPath);
				String picType = picPath.substring(picPath.lastIndexOf(".")+1);
				String picName = picPath.substring(0,picPath.lastIndexOf("."));
				String targetPath=picName+"_simple."+picType;
				String biggerPath=picName+"_bigger."+picType;
				String smallPath=picName+"_small."+picType;
				publish1.setSamplePic(targetPath);
				publish1.setBiggerPic(biggerPath);
				publish1.setSmallPic(smallPath);
			}
			publish1.setPublishSpecialCat(publishSpecialCat);
			publish1.setUser(user);
			if (this.getPublishService().update(publish1)) {
				System.out.println("修改成功！！！！");
				resPublish=publish1;
				showThePublishofdetais(id);
				return "updatePublishSuc";
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return "";
	}
	/**
	 * 上传图片
	 * @return
	 */
	public String uploadPubimg(){
		 String resPath = "";
			try{
				InputStream is = new FileInputStream(publishPicture);
				String uploadPath = ServletActionContext.getServletContext().getRealPath("/uploadImag");
				System.out.println(uploadPath);
				HttpServletRequest request = ServletActionContext.getRequest();
				String path = request.getContextPath();
				String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
				
				Date date = new Date();
				DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
				String name1 = format.format(date);
				
				String baseName = getRandomStr();
				String picType = this.getPublishPictureFileName().substring(this.getPublishPictureFileName().lastIndexOf(".")+1);
				String picName = name1+baseName+"."+picType;
				
				File toFile = new File(uploadPath,picName);
				System.out.println("-------------uploadPath---------- : "+uploadPath);
				OutputStream os = new FileOutputStream(toFile);
				byte[] b = new byte[1024];
				int len = 0;
				while((len = is.read(b)) != -1){
					os.write(b, 0, len);
				}
				
				String simplePicName = name1 + baseName + "_simple" + "."+picType;		
				String biggerPicName = name1 + baseName + "_bigger" + "."+picType;		
				String srcImgPath=uploadPath+"\\"+picName;
				ImageIcon img= new ImageIcon(srcImgPath);
				width= img.getIconWidth();
				height= img.getIconHeight();
				String logoText="摄影平台";
				String targetPath=uploadPath+"\\"+simplePicName;
				try{
				ImgWaterMark.markByText(logoText, srcImgPath, targetPath);
				}catch (Exception e) {
				e.printStackTrace();
				}
				is.close();
				os.close();
				PictureUtil j = new PictureUtil();  
		        try {  
		            j.SetScale(5.7);  
		            j.SetSmallHeight(700);  
		            j.doFinal(uploadPath+"/"+picName,uploadPath+"/"+biggerPicName);  
		        } catch (JpegToolException e) {  
		            // TODO Auto-generated catch block 
		            e.printStackTrace();  
		        }
				resPath = basePath+"uploadImag/"+picName;
			}catch(Exception ex){
				ex.printStackTrace();
			}
			return resPath;
	}
	public String delPublishDetailUnderPublish() throws Exception{
		// ?????????
		clearErrorsAndMessages();
		
		try{
			// id???????????
			if (this.getId() == null) {
				saveActionError("publishDetail.message.edit.notexist");
			} else {
				// ??????
				PublishDetail detail = this.getPublishDetailService().select(Integer.valueOf(id));
				String path = ServletActionContext.getRequest().getRealPath("/uploadImag");
				String imageUrl = detail.getPicUrl();
				String fileName = imageUrl.substring(imageUrl.lastIndexOf("/"));
				String filePath = path+"/"+fileName;
				System.out.println("要删除的文件是："+filePath+"+===============================");
				removeFile(filePath);
				this.getPublishDetailService().delete(Integer.valueOf(id));				
				saveActionMessage("publishDetail.message.delete.success");
			}
			
			// ???????????
			super.pager = this.getPublishDetailService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
			
		}catch(Exception e){
			saveActionError2(e.toString());
			saveActionMessage2("Please delete child first");
			return Constants.ERROR_KEY;
		}
		//return Constants.LIST_KEY;
		//return initUnderPublishBase();
		return initUnderPublish();
	}
	
	public String delPublishDetailUnderPublishCommon() throws Exception{
		// ?????????
		clearErrorsAndMessages();
		
		try{
			// id???????????
			if (this.getId() == null) {
				saveActionError("publishDetail.message.edit.notexist");
			} else {
				// ??????
				PublishDetail detail = this.getPublishDetailService().select(Integer.valueOf(id));
				String path = ServletActionContext.getRequest().getRealPath("/uploadImag");
				String imageUrl = detail.getPicUrl();
				String fileName = imageUrl.substring(imageUrl.lastIndexOf("/"));
				String filePath = path+"/"+fileName;
				System.out.println("要删除的文件是："+filePath+"+===============================");
				removeFile(filePath);
				this.getPublishDetailService().delete(Integer.valueOf(id));				
				saveActionMessage("publishDetail.message.delete.success");
			}
			
			// ???????????
			super.pager = this.getPublishDetailService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
			
		}catch(Exception e){
			saveActionError2(e.toString());
			saveActionMessage2("Please delete child first");
			return Constants.ERROR_KEY;
		}
		//return Constants.LIST_KEY;
		//return initUnderPublishBase();
		//return initUnderPublish();
		return initUnderPublishBase();
	}
	public String delete() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		try{
			// id???????????
			if (this.getId() == null) {
				saveActionError("publishDetail.message.edit.notexist");
			} else {
				// ??????
				PublishDetail detail = this.getPublishDetailService().select(Integer.valueOf(id));
				String path = ServletActionContext.getRequest().getRealPath("/uploadImag");
				String imageUrl = detail.getPicUrl();
				String fileName = imageUrl.substring(imageUrl.lastIndexOf("/"));
				String filePath = path+"/"+fileName;
				System.out.println("要删除的文件是："+filePath+"+===============================");
				removeFile(filePath);
				this.getPublishDetailService().delete(Integer.valueOf(id));				
				saveActionMessage("publishDetail.message.delete.success");
			}
			
			// ???????????
			super.pager = this.getPublishDetailService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
			
		}catch(Exception e){
			saveActionError2(e.toString());
			saveActionMessage2("Please delete child first");
			return Constants.ERROR_KEY;
		}
		//return Constants.LIST_KEY;
		return initAdmin();
		
	}//end delete()
		
 
	/////getter////setter//////
	public String getId(){
		return  id;
	}
	public void  setId(String id){
		this.id = id ;
	}
	 
	public PublishCatAction getPublishCatAction() {
		return publishCatAction;
	}
	public void setPublishCatAction(PublishCatAction publishCatAction) {
		this.publishCatAction = publishCatAction;
	}
	public PublishCatService getPublishCatService() {
		return publishCatService;
	}
	public void setPublishCatService(PublishCatService publishCatService) {
		this.publishCatService = publishCatService;
	}
	public PublishDetailService getPublishDetailService() {
		return publishDetailService;
	}
	public void setPublishDetailService(PublishDetailService publishDetailService) {
		this.publishDetailService = publishDetailService;
	}
	public String getValue(){
		return  value;
	}
	public void  setValue(String value){
		this.value = value ;
	}
	 
	public String getPicUrl(){
		return  picUrl;
	}
	public void  setPicUrl(String picUrl){
		this.picUrl = picUrl ;
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
	 
	 public String getUsername() {
	 	return username;
	 }
	 public void setUsername(String username) {
	 	this.username = username;
	 }
	public File getPicture() {
		return picture;
	}
	public void setPicture(File picture) {
		this.picture = picture;
	}
	public File getMyfile() {
		return myfile;
	}
	public void setMyfile(File myfile) {
		this.myfile = myfile;
	}
	public String getMyfileContentType() {
		return myfileContentType;
	}
	public void setMyfileContentType(String myfileContentType) {
		this.myfileContentType = myfileContentType;
	}
	public String getMyfileFileName() {
		return myfileFileName;
	}
	public void setMyfileFileName(String myfileFileName) {
		this.myfileFileName = myfileFileName;
	}
	public String getPublishId() {
		return publishId;
	}
	public void setPublishId(String publishId) {
		this.publishId = publishId;
	}
	public List<PublishDetail> getPublishDetailList() {
		return publishDetailList;
	}
	public void setPublishDetailList(List<PublishDetail> publishDetailList) {
		this.publishDetailList = publishDetailList;
	}
	public String getMarquee() {
		return marquee;
	}
	public void setMarquee(String marquee) {
		this.marquee = marquee;
	}
	public String getLayout() {
		return layout;
	}
	public void setLayout(String layout) {
		this.layout = layout;
	}
	public Publish getResPublish() {
		return resPublish;
	}
	public void setResPublish(Publish resPublish) {
		this.resPublish = resPublish;
	}
	public File getPublishPicture() {
		return publishPicture;
	}
	public void setPublishPicture(File publishPicture) {
		this.publishPicture = publishPicture;
	}
	public String getPublishPictureFileName() {
		return publishPictureFileName;
	}
	public void setPublishPictureFileName(String publishPictureFileName) {
		this.publishPictureFileName = publishPictureFileName;
	}
	public String getPublishPictureContentType() {
		return publishPictureContentType;
	}
	public void setPublishPictureContentType(String publishPictureContentType) {
		this.publishPictureContentType = publishPictureContentType;
	}
	public Integer getWidth() {
		return width;
	}
	public void setWidth(Integer width) {
		this.width = width;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public String getDetailName() {
		return detailName;
	}
	public void setDetailName(String detailName) {
		this.detailName = detailName;
	}
	 
	 
	 
}//end class
