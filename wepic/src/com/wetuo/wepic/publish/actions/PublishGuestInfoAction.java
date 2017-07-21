package com.wetuo.wepic.publish.actions ;
 
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.*;
import java.sql.Blob;
import java.text.SimpleDateFormat;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Hibernate;

import com.wetuo.wepic.publish.beans.PublishDetail;
import com.wetuo.wepic.publish.beans.PublishGuestInfo;
import com.wetuo.wepic.publish.service.PublishCatService;
import com.wetuo.wepic.publish.service.PublishDetailService;
import com.wetuo.wepic.publish.service.PublishGuestInfoService;
import com.wetuo.wepic.publish.beans.Publish;
import com.wetuo.wepic.publish.service.PublishService;
 
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.struts.PageAction;
import com.wetuo.wepic.common.struts.Constants;
import com.wetuo.wepic.common.struts.RegExpression;
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.core.service.UserService;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;
 
public class PublishGuestInfoAction extends PageAction {
	/////instantce variable//////
	private static final long serialVersionUID = 1L;
	protected String id = null ; 
 	private PublishGuestInfoService publishGuestInfoService;
	protected String publishId = null ;
	private PublishService publishService;
	private PublishDetailService publishDetailService;
	private UserService userService;
	private Publish  publish ;
	private User user;
	private List<PublishDetail> publishDetailList = new ArrayList<PublishDetail>() ;
	private Set<PublishDetail> publishDetailSet ;
	protected String name = null ; 
	protected String tel = null ; 
	protected String mobile = null ; 
	protected String address = null ; 
	protected String email = null ; 
	protected String postCode = null ; 
	protected String remark = null ; 
	protected String username = null; 
	private List idList;
    private List<Publish> resembleList;
	
	public List<Publish> getResembleList() {
		return resembleList;
	}
	public void setResembleList(List<Publish> resembleList) {
		this.resembleList = resembleList;
	}
	private String filename;
	public String getFilename() {
	  return filename;
	}
	public void setFilename(String filename){
	  this.filename = filename;
	}
	
	//private PublishDetailService publishDetailService;
	
	public String publishAndDetailAndCart() throws Exception {
		clearErrorsAndMessages();
		String strPublishId = ServletActionContext.getRequest().getParameter("publishId");
		if(strPublishId == null || strPublishId.length() == 0){
			strPublishId = this.getPublishId();
		}
		if(strPublishId == null || strPublishId.length() == 0){
			return "";
		}else{
			this.setPublishId(strPublishId);
		}
		ServletActionContext.getRequest().setAttribute("publishId", strPublishId);
		int publishId = Integer.parseInt(strPublishId);
		this.setPublishId(strPublishId);
		
		Publish tempPublish=this.getPublishService().select(publishId);
		
		Integer hit = this.getPublishService().select(publishId).getHit();
		if(hit == null){
			hit = 0;
		}
		tempPublish.setHit(hit+1);
		//tempPublish.get
		this.getPublishService().update(tempPublish);
		Publish newpublish=this.getPublishService().select(publishId);
		if(newpublish.getCopyright()!=1){
			String usep=newpublish.getUsagePeriod()+"";
			usep=usep.substring(0, usep.lastIndexOf("."));
			newpublish.setChinesusagePeriod(usep+" 年");
		}
		
		this.setPublish(newpublish);
		String tags=this.getPublish().getTags();
		
		if (tags.contains(" ")) {
			resembleList=new ArrayList<Publish>();
			String tag[]=tags.split(" ");
			int repeat = 0;
			for (int i = 0; i < tag.length; i++) {
				List<Publish> publishs=this.getPublishService().findResemble(tag[i]);
				
				for (int j = 0; j < publishs.size(); j++) {
					for (int j2 = 0; j2 < resembleList.size(); j2++) {
						if (resembleList.get(j2).getId().intValue()==publishs.get(j).getId().intValue()) {
							repeat++;
						}
					}
					if(repeat == 0){
						resembleList.add(publishs.get(j));	
					}
					repeat = 0;
				}
			}//end for
		}else {
			resembleList=this.getPublishService().findResemble(tags);
		}
		
		if (resembleList==null || resembleList.size()==0) {
			resembleList=null;
		}else {
			if (resembleList.size()>18) {
				secondLeveList=new ArrayList<Publish>();
				for (int i = 0; i < 18; i++) {
					secondLeveList.add(resembleList.get(i));
				}
			}else {
				secondLeveList=new ArrayList<Publish>();
				for(Publish publish:resembleList){
					secondLeveList.add(publish);
				}
			}
		}
		
		return "publishCart";
	}
	private List<Publish> secondLeveList;
	public List<Publish> getSecondLeveList() {
		return secondLeveList;
	}
	public void setSecondLeveList(List<Publish> secondLeveList) {
		this.secondLeveList = secondLeveList;
	}
	public static void main(String[] args) {
		Integer a=-100;
		Integer b=-100;
		
		int c=1000;
		int d=1000;
		System.out.println(c==d);
//		System.out.println(a==b);
	}
	
	public String publishAndDetailAndGuestWord() throws Exception {
		/*
		 * clearErrorsAndMessages();
		super.pageSize = Constants.pageSize;
		super.pageNo = Constants.pageNo;
		super.pager = this.getPublishCatService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		setSession(Constants.PAGER_PUBLISHCAT, super.pager);
		return Constants.LIST_KEY;
		 * */
		clearErrorsAndMessages();
		//reset();
//		super.pageSize = Constants.pageSize;
//		super.pageNo = Constants.pageNo;
		String strPublishId = ServletActionContext.getRequest().getParameter("publishId");
		if(strPublishId == null || strPublishId.length() == 0){
			strPublishId = this.getPublishId();
		}
		if(strPublishId == null || strPublishId.length() == 0){
			return "";
		}else{
			this.setPublishId(strPublishId);
		}
		ServletActionContext.getRequest().setAttribute("publishId", strPublishId);
		int publishId = Integer.parseInt(strPublishId);
		this.setPublishId(strPublishId);
		
		Publish tempPublish=this.getPublishService().select(publishId);
		
		Integer hit = this.getPublishService().select(publishId).getHit();
		if(hit == null){
			hit = 0;
		}
		tempPublish.setHit(hit+1);
		
		this.getPublishService().update(tempPublish);
		this.setPublish(this.getPublishService().select(publishId));
		this.getPublishService().select(publishId).setHit(this.getPublishService().select(publishId).getHit()+1);
		this.getPublishService().update(this.getPublishService().select(publishId));		
		this.setPublish(this.getPublishService().select(publishId));
//		publishDetailSet = this.getPublish().getPublishDetailSet();
		Set<PublishDetail> publishDetailSet = this.getPublish().getPublishDetailSet();		
//		publishDetailList.addAll(publishDetailSet);
		publishDetailList.clear();
//		System.out.println("----publishDetailSet size-----" + publishDetailSet.size());
		for(PublishDetail pd : publishDetailSet){
//			System.out.println("----PublishDetail---" + pd.getName());
			publishDetailList.add(pd);
		}
//		super.pageSize = 3;
//		super.pageNo = Constants.pageNo;
//		String ps = ServletActionContext.getRequest().getParameter("pageSize");
//		String pn = ServletActionContext.getRequest().getParameter("pageNo");
//		if(ps != null && ps.length() > 0 && !"".equals(ps)){
//			super.pageSize = Integer.parseInt(ps);
//		}
//		if(pn != null && pn.length() > 0 && !"".equals(pn)){
//			super.pageNo = Integer.parseInt(pn);
//		}
		super.pageSize = Constants.pageSize;
		super.pager = this.publishDetailService.findAllPublishDetailsBypublish(publishId, 5, super.pageNo);
		//super.pager = this.getPublishDetailService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
//		super.pager = this.getPublishDetailService().listUnderPublish(Integer.parseInt(oneId), super.pageSize, super.pageNo); 
//		setSession(Constants.PAGER_PUBLISHDETAIL, super.pager);
		return "second";
	}//end init()
	

	public String publishAndDetailAndGuestWord2() throws Exception {
		
		super.pager = this.publishDetailService.findAllPublishDetailsBypublish(Integer.parseInt(this.getPublishId()), 5, super.pageNo); 
		//super.pager = this.getPublishDetailService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
//		super.pager = this.getPublishDetailService().listUnderPublish(Integer.parseInt(oneId), super.pageSize, super.pageNo); 
//		setSession(Constants.PAGER_PUBLISHDETAIL, super.pager);
		return "second";
	}//end init()
	
	
	public String execute() throws Exception
	{
	  // TODO Auto-generated method stub
	  return "imageSuccess";
	}
	
	public byte[] getPhoto(){	 
		//return this.getPublish().getPicture();
		byte[] b = null;
		Blob blob = this.getPublish().getPicture();
		if(this.getPublish()==null || blob==null){
			  return null;
		}else{
			   try{
				   System.out.println("Image_Lenghth:"+blob.length());
				   InputStream inputStream = blob.getBinaryStream();// IO��
				   int length = (int) blob.length();
		           b = new byte[length];
		           inputStream.read(b, 0, length);
			       return b;
			   } catch (Exception e){
			       e.printStackTrace();
			       return null;
			   }
		   
		}//end else
	}//end getPhoto()
	
	 public InputStream getInputStream(){	  
//	  Photo photo=new Photo();
//	  try {
//	     photo=pdi.getPhoto(filename);	   
//	  } catch (RuntimeException e){
//	     e.printStackTrace();
//	  }
	  Blob blob = this.getPublish().getPicture();
	  if(this.getPublish()==null || blob==null){
		  return null;
	  }else{
		   System.out.println(this.getPublish().getName());
		   System.out.println(this.getPublish().getPicture());
		   
		   ByteArrayInputStream bais;
		   try{
			   System.out.println("Image_Lenghth:"+blob.length());
			   InputStream inputStream = blob.getBinaryStream();// IO��
			   int length = (int) blob.length();
	           byte[] b = new byte[length];
	           inputStream.read(b, 0, length);
	           bais = new ByteArrayInputStream(b);
		      return bais;
		   } catch (Exception e){
		       e.printStackTrace();
		    return null;
		   }
	   
	  }//end else
	 }//end getInputStream()
	
	
	
	public void validate() {
		
		clearErrorsAndMessages();
		
		String queryString = getRequestPath();
		if (queryString.indexOf("publishGuestInfoadd!insert") != -1 || queryString.indexOf("publishGuestInfoedit!update") != -1) {
		
			if (publishId == null || publishId.equals("")) {
				addFieldError("publishId", "publishId must be inputed");
			}//end if null
			if (name == null || name.equals("")) {
				addFieldError("name", "name must be inputed");
			}//end if null
			if (tel == null || tel.equals("")) {
				addFieldError("tel", "tel must be inputed");
			}//end if null
			if (mobile == null || mobile.equals("")) {
				addFieldError("mobile", "mobile must be inputed");
			}//end if null
			if (address == null || address.equals("")) {
				addFieldError("address", "address must be inputed");
			}//end if null
			if (email == null || email.equals("")) {
				addFieldError("email", "email must be inputed");
			}//end if null
			if (postCode == null || postCode.equals("")) {
				addFieldError("postCode", "postCode must be inputed");
			}//end if null
			if (remark == null || remark.equals("")) {
				addFieldError("remark", "remark must be inputed");
			}//end if null
				// ??????? 
				// ??????? 
				// ??????? 
			if (name == null || name.equals("")) {
				addFieldError("name", getText("publishGuestInfo.error.name"));
			}
				// ??????? 
				// ??????? 
			if (mobile != null && !mobile.equals("")) {
				Pattern p_mobile = Pattern.compile(RegExpression.REG_mobile);
				Matcher m_mobile = p_mobile.matcher(mobile);
				if (!m_mobile.find()) {
					addFieldError("mobile", getText("publishGuestInfo.error.mobile"));
				}
			}
				// ??????? 
				// ??????? 
			if (email != null && !email.equals("")) {
				Pattern p_email = Pattern.compile(RegExpression.REG_email);
				Matcher m_email = p_email.matcher(email);
				if (!m_email.find()) {
					addFieldError("email", getText("publishGuestInfo.error.email"));
				}
			}
				// ??????? 
			if (postCode != null && !postCode.equals("")) {
				Pattern p_postcode = Pattern.compile(RegExpression.REG_postcode);
				Matcher m_postcode = p_postcode.matcher(postCode);
				if (!m_postcode.find()) {
					addFieldError("postcode", getText("publishGuestInfo.error.postcode"));
				}
			}
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
		super.pager = this.getPublishGuestInfoService().listByName(super.getLoginUsername(), super.pageSize, super.pageNo);
		
		// ?????????
		//setSession(Constants.PAGER_PUBLISHGUESTINFO, super.pager);
		
		return Constants.LIST_KEY;
		
	}//end init()
	public String initAdmin() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// ??????????
		super.pageSize = Constants.pageSize;
		super.pageNo = Constants.pageNo;
		
		// ???????????
		super.pager = this.getPublishGuestInfoService().list(super.pageSize, super.pageNo);
		
		// ?????????
		//setSession(Constants.PAGER_PUBLISHGUESTINFO, super.pager);
		
		return Constants.LISTGUESTADMIN_KEY;
		
	}
	
	public String userInfo() throws Exception {
		clearErrorsAndMessages();
		
		// ??????????
		super.pageSize = Constants.pageSize;
		super.pageNo = Constants.pageNo;
		super.pager=this.getPublishGuestInfoService().listByName(super.getLoginUsername(),super.pageSize,super.pageNo);
		
		//setSession(Constants.PAGER_PUBLISHGUESTINFO, super.pager);
		
		return Constants.USERLIST_KEY;
		
	}//end init()
	public String userList() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// ???????????
		super.pager = this.getPublishGuestInfoService().listByName(super.getLoginUsername(), super.pageSize, super.pageNo);	
		
		// ?????????
		//setSession(Constants.PAGER_PUBLISHGUESTINFO, super.pager);
		
		return Constants.USERLIST_KEY;
		
	}
		
	public String list() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// ???????????
		super.pager = this.getPublishGuestInfoService().list(super.getLoginUsername(), super.pageSize, super.pageNo);	
		
		// ?????????
		//setSession(Constants.PAGER_PUBLISHGUESTINFO, super.pager);
		
		return Constants.LIST_KEY;
		
	}//end list()
		
	public String add() throws Exception {
		clearErrorsAndMessages();
		reset();
		return Constants.ADD_KEY;
	}//end add()
	private void reset() {
		setId(null);
		setPublishId(null);
		setName(null);
		setTel(null);
		setMobile(null);
		setAddress(null);
		setEmail(null);
		setPostCode(null);
		setRemark(null);
	}//end reset()
		// ?????��??
	private void bean2Form(PublishGuestInfo publishGuestInfo) {
		setId(publishGuestInfo.getId().toString());
		setPublishId(publishGuestInfo.getPublish().getId().toString());
		setName(publishGuestInfo.getName());
		setTel(publishGuestInfo.getTel().toString()      );
		setMobile(publishGuestInfo.getMobile().toString()      );
		setAddress(publishGuestInfo.getAddress());
		setEmail(publishGuestInfo.getEmail());
		setPostCode(publishGuestInfo.getPostCode().toString()      );
		setRemark(publishGuestInfo.getRemark());
	}//end bean2Form()
	public String edit() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// id???????????
		if (this.getId() == null) {
			saveActionError("publishGuestInfo.message.edit.notexist");
			return Constants.LIST_KEY;
		} else {
			// ???????
			PublishGuestInfo publishGuestInfo = this.getPublishGuestInfoService().select(Integer.valueOf(id));
			
			// ??????????????
			if (publishGuestInfo == null) {
				saveActionError("publishGuestInfo.message.edit.notexist");
				return Constants.LIST_KEY;
			} else {
				// ?????��??
				bean2Form(publishGuestInfo);
				return Constants.EDIT_KEY;
			}
		}//end if
		
	}//end edit()
		
	public String insert() throws Exception {
		clearErrorsAndMessages();
		Integer nid = null ;
		try{
		//
		String strPublishId = ServletActionContext.getRequest().getParameter("republish");
		PublishGuestInfo publishGuestInfo = new PublishGuestInfo();
//		publishGuestInfo.setPublish(this.getPublishService().select(Integer.parseInt(publishId)));    //publishInstance
		publishGuestInfo.setPublish(this.getPublishService().select(Integer.parseInt(strPublishId))); 
		publishGuestInfo.setName(this.getName());
//		publishGuestInfo.setTel(Integer.valueOf(this.getTel() ));
//		publishGuestInfo.setMobile(Integer.valueOf(this.getMobile() ));
		publishGuestInfo.setTel(this.getTel() );
		publishGuestInfo.setMobile(this.getMobile() );
		publishGuestInfo.setAddress(this.getAddress());
		publishGuestInfo.setEmail(this.getEmail());
		publishGuestInfo.setPostCode(Integer.valueOf(this.getPostCode() ));
		publishGuestInfo.setRemark(this.getRemark());
		nid = this.getPublishGuestInfoService().insert(publishGuestInfo);
		
		Pager pagerSession = (Pager) getSession(Constants.PAGER_PUBLISHGUESTINFO);
		if(pagerSession == null){
			super.pageSize = Constants.pageSize;
			super.pageNo = Constants.pageNo;
		}else{
			super.pageSize = pagerSession.getPageSize();
			super.pageNo = pagerSession.getPageNo();
			
		}
		
		super.pager = this.getPublishGuestInfoService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		
		
		}catch(Exception e){
			saveActionError2(e.toString());
			saveActionMessage2(" Sorry ");
			return "insertFail";
		}
		
		// ?????????
		if (nid != null) {
			saveActionMessage("publishGuestInfo.message.add.success");
			return "insertSuccess";
		} else {
			saveActionError("publishGuestInfo.message.add.failed");
			//return "insertFail";
			return Constants.ADD_KEY;
		}
	}//end insert()
	
	public String update() throws Exception {
		// 
		clearErrorsAndMessages();
		
		try{
			// 
			PublishGuestInfo publishGuestInfo = this.getPublishGuestInfoService().select(new Integer(id));
			//publishGuestInfo.setPublish(publishInstance);
			publishGuestInfo.setPublish(this.getPublishService().select(Integer.parseInt(publishId)));    //publishInstance
			publishGuestInfo.setName(this.getName());
//			publishGuestInfo.setTel(Integer.valueOf(this.getTel() ));
//			publishGuestInfo.setMobile(Integer.valueOf(this.getMobile() ));
			publishGuestInfo.setTel(this.getTel() );
			publishGuestInfo.setMobile(this.getMobile() );
			publishGuestInfo.setAddress(this.getAddress());
			publishGuestInfo.setEmail(this.getEmail());
			publishGuestInfo.setPostCode(Integer.valueOf(this.getPostCode() ));
			publishGuestInfo.setRemark(this.getRemark());
		this.getPublishGuestInfoService().update(publishGuestInfo);
		
		bean2Form(publishGuestInfo);	
		
		// ?????????????
		Pager pagerSession = (Pager) getSession(Constants.PAGER_PUBLISHGUESTINFO);
		if(pagerSession == null){
			//??????????
			super.pageSize = Constants.pageSize;
			super.pageNo = Constants.pageNo;
		}else{
			super.pageSize = pagerSession.getPageSize();
			super.pageNo = pagerSession.getPageNo();
			
		}
		
			// ????????????
			super.pager = this.getPublishGuestInfoService().list(super.pageSize, super.pageNo);
			saveActionMessage("publishGuestInfo.message.edit.success");
		}catch(Exception e){
			saveActionError2(e.toString());
			saveActionMessage2(" Sorry ");
			return Constants.ERROR_KEY;
		}
		
		return Constants.LISTGUESTADMIN_KEY;
	}//end update() 
	public String delete() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		try{
			// id???????????
			if (this.getId() == null) {
				saveActionError("publishGuestInfo.message.edit.notexist");
			} else {
				// ??????
				this.getPublishGuestInfoService().delete(Integer.valueOf(id));
				saveActionMessage("publishGuestInfo.message.delete.success");
			}
			
			// ???????????
			super.pager = this.getPublishGuestInfoService().list(super.pageSize, super.pageNo);
			
		}catch(Exception e){
			saveActionError2(e.toString());
			saveActionMessage2("Please delete child first");
			return Constants.ERROR_KEY;
		}
		return Constants.LISTGUESTADMIN_KEY;
		
	}//end delete()
/*	
	public String guessLeaveMessageSuccess()  throws Exception {
		if (ad==a) {
			return zhuye;
		} else if() {
			return liulanye;
		}
		
	}catch(Exception e){
		return e.printStackTrace();
	}
*/		
 
	/////getter////setter//////
	public String getId(){
		return  id;
	}
	public void  setId(String id){
		this.id = id ;
	}
	 
	public PublishGuestInfoService getPublishGuestInfoService() {
		return publishGuestInfoService;
	}
	public void setPublishGuestInfoService(PublishGuestInfoService publishGuestInfoService) {
		this.publishGuestInfoService = publishGuestInfoService;
	}
	
	public String getPublishId(){
		return  publishId;
	}
	public void  setPublishId(String publishId){
		this.publishId = publishId ;
	}
	 
	public String getName(){
		return  name;
	}
	public void  setName(String name){
		this.name = name ;
	}
	 
	public String getTel(){
		return  tel;
	}
	public void  setTel(String tel){
		this.tel = tel ;
	}
	 
	public String getMobile(){
		return  mobile;
	}
	public void  setMobile(String mobile){
		this.mobile = mobile ;
	}
	 
	public String getAddress(){
		return  address;
	}
	public void  setAddress(String address){
		this.address = address ;
	}
	 
	public String getEmail(){
		return  email;
	}
	public void  setEmail(String email){
		this.email = email ;
	}
	 
	public String getPostCode(){
		return  postCode;
	}
	public void  setPostCode(String postCode){
		this.postCode = postCode ;
	}
	 
	public String getRemark(){
		return  remark;
	}
	public void  setRemark(String remark){
		this.remark = remark ;
	}
	 
	 public String getUsername() {
	 	return username;
	 }
	 public void setUsername(String username) {
	 	this.username = username;
	 }
	
	public List getIdList() {
		return idList;
	}
	public void setIdList(List idList) {
		this.idList = idList;
	}
	public PublishDetailService getPublishDetailService() {
		return publishDetailService;
	}
	public void setPublishDetailService(PublishDetailService publishDetailService) {
		this.publishDetailService = publishDetailService;
	}
	public PublishService getPublishService() {
		return publishService;
	}
	public void setPublishService(PublishService publishService) {
		this.publishService = publishService;
	}

	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public Publish getPublish() {
		return publish;
	}
	public void setPublish(Publish publish) {
		this.publish = publish;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<PublishDetail> getPublishDetailList() {
		return publishDetailList;
	}

	public void setPublishDetailList(List<PublishDetail> publishDetailList) {
		this.publishDetailList = publishDetailList;
	}

	public Set<PublishDetail> getPublishDetailSet() {
		return publishDetailSet;
	}

	public void setPublishDetailSet(Set<PublishDetail> publishDetailSet) {
		this.publishDetailSet = publishDetailSet;
	} 
	
	
	 
}//end class
