package com.wetuo.wepic.publish.actions ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.wetuo.wepic.action.cached.CacheOperation;
import com.wetuo.wepic.action.cached.FillCache;
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.struts.Constants;
import com.wetuo.wepic.common.struts.PageAction;
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.core.beans.UserCredit;
import com.wetuo.wepic.core.service.ContactService;
import com.wetuo.wepic.core.service.UserCreditService;
import com.wetuo.wepic.core.service.UserService;
import com.wetuo.wepic.deal.beans.Bid;
import com.wetuo.wepic.deal.beans.UserMess;
import com.wetuo.wepic.deal.service.BidService;
import com.wetuo.wepic.publish.beans.Publish;
import com.wetuo.wepic.publish.service.PublishService;
import com.tools.MemcachedUtil;


public class FrontendAction extends PageAction {
	private PublishService publishService;
	private BidService bidService;
	List<List<Publish>> publishlist=new ArrayList<List<Publish>>();
	List<List<User>> userlist=new ArrayList<List<User>>();
	private String typeId;
	List<Bid> listbid;
	private String province;
	private UserService userService;
	private String  flag=null;
    private String  type;
    private String  position;
	private Publish mainPublish ;
	private List<Publish> mainPublishs ;
	 private String  language_tm20083;//日期
	 private String language_tm20084;//金额
	 private String language_tm20085;//状态
	 private String searchUserNick="";
	 private String searchType;
	private String memCachedServerIp = "211.152.43.67";
	private int IpPort=11211;
	private CacheOperation cacheOperation;
	private FillCache fillCache; 
	private UserCreditService userCreditService;
	private ContactService  contactService;
	
	
	public UserCreditService getUserCreditService() {
		return userCreditService;
	}


	public void setUserCreditService(UserCreditService userCreditService) {
		this.userCreditService = userCreditService;
	}


	public ContactService getContactService() {
		return contactService;
	}


	public void setContactService(ContactService contactService) {
		this.contactService = contactService;
	}


	public FillCache getFillCache() {
		return fillCache;
	}


	public void setFillCache(FillCache fillCache) {
		this.fillCache = fillCache;
	}


	public CacheOperation getCacheOperation() {
		return cacheOperation;
	}


	public void setCacheOperation(CacheOperation cacheOperation) {
		this.cacheOperation = cacheOperation;
	}


	public String getSearchType() {
		return searchType;
	}


	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}


	




	public String getSearchUserNick() {
		return searchUserNick;
	}


	public void setSearchUserNick(String searchUserNick) {
		this.searchUserNick = searchUserNick;
	}


	public String getFlag() {
		return flag;
	}
      

	public String getLanguage_tm20084() {
		return language_tm20084;
	}


	public void setLanguage_tm20084(String languageTm20084) {
		language_tm20084 = languageTm20084;
	}


	public String getLanguage_tm20085() {
		return language_tm20085;
	}


	public void setLanguage_tm20085(String languageTm20085) {
		language_tm20085 = languageTm20085;
	}


	public String getLanguage_tm20083() {
		return language_tm20083;
	}


	public void setLanguage_tm20083(String languageTm20083) {
		language_tm20083 = languageTm20083;
	}


	public void setFlag(String flag) {
		this.flag = flag;
	}


	 public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	


	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}


	public String frontlogin() throws Exception {
		 //原始验证码
		 String id = getSession("id")+"";
//		 ActionContext.getContext().getSession().put("id",id);
//		 ActionContext.getContext().getSession().put(Constants.USERNAME_KEY,username);
		if (id != null && id.length()>=0) {
			try{
				User userLogin = this.getUserService().selectById(Integer.parseInt(id));
				String userCat = userLogin.getUserCat().getType() ;
				String role=userLogin.getRole();
				int validate=0;
				if (userLogin.getIfIdentityTrue()==null) {
					validate=0;
				}else {
					validate=userLogin.getIfIdentityTrue();
				}
				ActionContext.getContext().getSession().put("cat",  userCat );
				ActionContext.getContext().getSession().put("id",id);
				ActionContext.getContext().getSession().put("role", role);
				ActionContext.getContext().getSession().put("validate",validate);
				
//				LoginHistory history=new LoginHistory();
//				history.setUser(userLogin);
//				history.setLoginTime(new Timestamp(new Date().getTime()));
				return "mainManage" ;
			}catch(Exception e){
				e.printStackTrace();
				ActionContext.getContext().getSession().put("cat","common");
				return Action.SUCCESS;
			}
	 		//
	 		
	 		
	 	} else {
	 		super.addActionError(super.getText("login.message.failed"));
	 		return Action.SUCCESS;
			
	 	}		
			
	 }
	 

	public String init() throws Exception {
		clearErrorsAndMessages();
		super.pageSize = Constants.pageSize;
		super.pageNo = Constants.pageNo;
		
		return Constants.LIST_KEY;
		
	}//end init()


	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public List<Bid> getListbid() {
		return listbid;
	}

	public void setListbid(List<Bid> listbid) {
		this.listbid = listbid;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public BidService getBidService() {
		return bidService;
	}

	public void setBidService(BidService bidService) {
		this.bidService = bidService;
	}

	public PublishService getPublishService() {
		return publishService;
	}

	public void setPublishService(PublishService publishService) {
		this.publishService = publishService;
	}

	public String frontCatTree() throws Exception {
		clearErrorsAndMessages();
		return "frontCatTree";
	}//end init()
	
	public String leftFrontCatTree() throws Exception {
		clearErrorsAndMessages();
		return "leftFrontCatTree";
	}//end init()
	
	
	public String listFrontPublish() throws Exception {
		clearErrorsAndMessages();
		return "listFrontPublish";
	}//end init()
	
	
	
	
	
	

	public List<List<Publish>> getPublishlist() {
		return publishlist;
	}

	public void setPublishlist(List<List<Publish>> publishlist) {
		this.publishlist = publishlist;
	}

	public String initFrontFistPage(){
		
//		String type="sheyingtuypian";
//		int pageNO=1;
//		int pageSize=3;
//		publishlist=null;
//		boolean b=MemcachedUtil.checkedMemcachedOpennew(memCachedServerIp, IpPort);
//		if(b){
//			publishlist=(List<List<Publish>>) MemcachedUtil.getCache(memCachedServerIp, IpPort, "sheyingtupian");	
//		}
//		
//		if(publishlist==null){
//			publishlist=new ArrayList<List<Publish>>();
//			List<Publish> list=publishService.selectByFrontPage(type,pageNO,pageSize);
//			publishlist.add(list);
//			 type="chuangyitupian";
//			 pageNO=1;
//			 pageSize=3;
//			
//			 List<Publish> list1=publishService.selectByFrontPage(type,pageNO,pageSize);
//			publishlist.add(list1);
//			if(b){
//				MemcachedUtil.setCache(memCachedServerIp, IpPort,60*60*24*7, "sheyingtupian",publishlist);
//			}
//			
//		}
		publishlist=(List<List<Publish>>) cacheOperation.getCache("sheyingtupian", fillCache);
		
		
		
		return "initFrontFistPage";
	}
	
	
	public List<List<User>> getUserlist() {
		return userlist;
	}


	public void setUserlist(List<List<User>> userlist) {
		this.userlist = userlist;
	}

	@SuppressWarnings("unchecked")
	@JSON(serialize=false)
	public String initUserInfo(){
		Pager pager= userService.getAllPohtoOrModel("model", 1, 3);
		Pager pager1= userService.getAllPohtoOrModel("photographer_contributing", 1, 3);
		userlist.add((List<User>) pager.getResultList());
		userlist.add((List<User>) pager1.getResultList());
		
		return "initUserInfo";
	}
	private List<Publish> modelWorkList;
	private List<Publish> photographyList;
	public List<Publish> getModelWorkList() {
		return modelWorkList;
	}
	public void setModelWorkList(List<Publish> modelWorkList) {
		this.modelWorkList = modelWorkList;
	}
	public List<Publish> getPhotographyList() {
		return photographyList;
	}
	public void setPhotographyList(List<Publish> photographyList) {
		this.photographyList = photographyList;
	}
	/**
	 * 管理员推荐到首页的特约模特（command=2）
	 * @return
	 */
	@JSON(serialize=false)
	public String initModelWork() {
		
//		boolean b=MemcachedUtil.checkedMemcachedOpennew(memCachedServerIp, IpPort);
//		if(b){
//			
//			modelWorkList= (List<Publish>) MemcachedUtil.getCache(memCachedServerIp, IpPort, "modelWorkList");
//		}
//		if(modelWorkList==null){
//			modelWorkList=new ArrayList<Publish>();
//			modelWorkList= publishService.modelPic();
//			MemcachedUtil.setCache(memCachedServerIp, IpPort, 60*60*24*7, "modelWorkList", modelWorkList);
//			
//		}
		modelWorkList=(List<Publish>) cacheOperation.getCache("modelWorkList", fillCache);
		
		
	//	modelWorkList= publishService.modelPic();
		return "initModelWork";
	}
	/**
	 * 管理员推荐到首页的特约摄影师（command=3）
	 * @return
	 */
	@JSON(serialize=false)
	public String initPhotographyWork() {
//		boolean b=MemcachedUtil.checkedMemcachedOpennew(memCachedServerIp, IpPort);
//	       if(b){
//			
//	    	   photographyList=(List<Publish>) MemcachedUtil.getCache(memCachedServerIp, IpPort, "photographyList");
//			}
//	       if(photographyList==null){
//	    	   photographyList=new ArrayList<Publish>();
//	    	   photographyList=publishService.photographyPic();
//				MemcachedUtil.setCache(memCachedServerIp, IpPort, 60*60*24*7, "photographyList", photographyList);
//				
//			}
		
	       photographyList=(List<Publish>) cacheOperation.getCache("photographyList",fillCache);
		   return "initPhotographyWork";
	}
	
	/**
	 * 首页摄影图片
	 * @return
	 * @throws IOException
	 */
	
	public void photographyFrontPage() throws IOException {
		String type="sheyingtuypian";
		 int pageNO=1;
		 int pageSize=6;
		 List<Publish> list=publishService.selectByFrontPage(type,pageNO,pageSize);
		 String path=ServletActionContext.getRequest().getRealPath("static/homePage");
		 PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path+"\\photography.js"),"UTF-8")));
		 if (list.size()<1) {
			 writer.write("document.writeln(\"<div id='gallery1' style='width:1024px;height:170px; float:left; margin-top:45px;'>" +
				 		"<div class='group1'><a href='#' target='_blank' style='color:#FF0000; " +
				 		"text-decoration:none;'>摄影图片</a></div>" +
				 		"<div style='width:100%; height:160px; float:left; margin-top:7px; margin-left:-6px;' id='sheying' class='contentdiv'>\");");
						 writer.write("document.writeln(\"</div></div>\");");
		 }else {
		    writer.write("document.writeln(\"<div id='gallery1' style='width:1024px;height:170px; float:left; margin-top:45px;'>" +
			 		"<div class='group1'><a href='#' target='_blank' style='color:#FF0000; " +
			 		"text-decoration:none;'>摄影图片</a></div>" +
			 		"<div style='width:100%; height:160px; float:left; margin-top:7px; margin-left:-6px;' id='sheying' class='contentdiv'>" +
			 		"<table width=987px;  height=90% style='float:left;'><tr>\");");
					for(Publish list3:list){ 
						writer.write("document.writeln(\"<td  align='center' style='height:100%;vertical-align: bottom;width:165px;'>" +
								"<a target='_blank' href='publishGuestInfo!publishAndDetailAndCart.do?publishId="+list3.getId()+"'>" +
										"<img src='"+list3.getSmallPic()+"' class='group_img' " +
												"onload=DrawImage(this,151,150) alt='"+list3.getName()+"' /></a></td>\");");
				       }
					 writer.write("document.writeln(\"</tr></table>\");");
					 writer.write("document.writeln(\"</div></div>\");");
		 }
		 writer.close();
	}
	/**
	 * 首页每日推荐
	 * @return
	 * @throws Exception
	 */
	public void recommendFrontPage() throws Exception{
		 String type="meirituijian";
		 int pageNO=1;
		 int pageSize=6;
		 List<Publish> list1=publishService.selectByFrontPage(type,pageNO,pageSize);
		 publishlist.add(list1);
		 String path=ServletActionContext.getRequest().getRealPath("static/homePage");
		 //BufferedWriter writer = new BufferedWriter(new FileWriter(new File(path+"\\recommend.js")));
		 //防止出乱码
		 PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path+"\\srecommend.js"),"UTF-8")));
		 for(List<Publish> publishs:publishlist){
			 if (publishs.size()<1) {
				 writer.write("document.writeln(\"<div style='width:977px; height:150px; float:left; border-top:1px solid #B4B4B4;'>" +
					 		"<div class='group1' style='margin-top: 5px;'><a href='#' target='_blank' style='color:#FF0000; " +
					 		"text-decoration:none; font-weight: normal'>每日推荐</a></div>" +
					 		"<div style='width:100%; height:160px; float:left; margin-top:7px; margin-left:-6px;' id='sheying2' class='contentdiv'>\");");
					 writer.write("document.writeln(\"</div></div>\");");
			}else {
				writer.write("document.writeln(\"<div style='width:977px; height:150px; float:left; border-top:1px solid #B4B4B4;'>" +
				 		"<div class='group1' style='margin-top: 5px;'><a href='#' target='_blank' style='color:#FF0000; " +
				 		"text-decoration:none; font-weight: normal'>每日推荐</a></div>" +
				 		"<div style='width:100%; height:160px; float:left; margin-top:7px; margin-left:-6px;' id='sheying2' class='contentdiv'>" +
				 		"<table width=987px;  height=90% style='float:left;'><tr>\");");
				 for (List<Publish> list2:publishlist) {
						for(Publish list3:list2){
							writer.write("document.writeln(\"<td  align='center' style='height:100%;vertical-align: bottom;width:165px;'>" +
									"<a target='_blank' href='publishGuestInfo!publishAndDetailAndCart.do?publishId="+list3.getId()+"'>" +
											"<img src='"+list3.getSmallPic()+"' class='group_img' " +
													"onload=DrawImage(this,151,150) alt='"+list3.getName()+"' /></a></td>\");");
					 }
				 }
				 writer.write("document.writeln(\"</tr></table>\");");
				 writer.write("document.writeln(\"</div></div>\");");
			}
		 }
		 writer.close();
	}
	/**
	 * 首页大图静态
	 * @throws IOException 
	 */
	public void homePageBigPic() throws IOException {
		Publish publish=publishService.homePageMainPic();
		String path=ServletActionContext.getRequest().getRealPath("static/homePage");
		PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path+"\\homePageBigPic.js"),"UTF-8")));
		if (publish!=null) {
			writer.write("document.writeln(\"<div style='width:65%;height:313px;float:left;'><ul><li id='homePageMainPic' style='display: list-item;'" +
					"><a target='_blank' href='publishGuestInfo!publishAndDetailAndCart.do?publishId="+publish.getId()+"'><img " +
							"src='"+publish.getIndexImgUrl()+"' onload='javascript:DrawImage(this,666,313)' style='width:100%; height:313px;' " +
									"alt='"+publish.getName()+"'/></a></li></ul></div>\");");
		}else {
			writer.write("document.writeln(\"<div style='width:65%;height:313px;float:left;'><ul><li id='homePageMainPic' style='display: list-item;'" +
					"><a target='_blank' href='#'><img " +
							"src='wepic/image/011.jpg' style='width:100%; height:313px;' " +
									"alt='意式风情料理'/></a></li></ul></div>\");");
		}
		writer.close();
	}
	/**
	 * 首页主要内容(找摄影师/模特，特约拍摄，图片征集)
	 */
	public void tabContent()throws Exception{
		String path=ServletActionContext.getRequest().getRealPath("static/homePage");

		
		PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path+"\\tabContent.js"),"UTF-8")));
		int pageON=1;
		int pageSize=3;
		writer.write("document.writeln(\"<div id='tabs1'><div class='menu1box'><ul id='menu1'>" +
				"<li class='hover' onMouseOver='setTab(1,0)'>特约拍摄</li><li onMouseOver='setTab(1,1)' style='margin-left:10px;'>" +
				"找摄影师/模特</li><li onMouseOver='setTab(1,2)'  style='margin-left:10px;'>图片征集</li></ul><div " +
				"style='background:#EA1F3C; width:100px; height:100px; margin-left:870px; text-align:center; " +
				"line-height:30px; color: #FFFFFF '><b>我要发布</b></div></div><div class='main1box'><div " +
				"style='width:3px;float:right;height:411px;float:left; margin-left:0px; background:#E3E3E3'></div><div  id='main1'>\");");
		for (int i = 1; i <= 3; i++) {
			String j=i+"";
			listbid=(List<Bid>)bidService.selectByFrontPage2(j, pageON, pageSize);
			if (j.equals("2")) {
				writer.write("document.writeln(\"<div  id='div2' style='height:300px; width:98%; float:left;' >\");");
				for (Bid bid:listbid) {
					writer.write("document.writeln(\"<div class='divclasd' ><div style=' width:120px; height:90px; float:left;margin-left:12px;'>"+
						  " <img src='"+bid.getUser().getPortrait()+"' style='width:120px; height:90px;'/></div><div style=' width:570px; height:90px; float:left; margin-left:12px;'>"+
							 "<table  width='100%' height='100%'><tr>"+
			                "<td style='text-align:left; width:60px'>"+
			               	"<span  style='color:#545454'><b>拍摄名称:</b></span></td>"+
			                    "<td style=' text-align:left;'>"+
			               		"<span  style='color:#545454'><b>"+bid.getName()+"</b></span></td></tr>"+
			               	 "<tr><td style=' text-align:left;'><span  style='color:#545454'><b>	拍摄地点:</b></span></td>"+
				                " <td style=' text-align:left;'><span  style='color:#545454'><b>"+bid.getWorkPlace()+"</b></span>"+
				                  "</td></tr>"+	
				                  "<tr><td style=' text-align:left;'><span  style='color:#545454'><b>	拍摄时间:</b></span></td>"+
					                " <td style=' text-align:left;'><span  style='color:#545454'>"+bid.getWorkStartTime()+"&nbsp;&nbsp;|&nbsp;&nbsp;发布人:"+bid.getUser().getUsername()+"</span></td></tr>"+	
					                  
			                   " <tr><td style=' text-align:left;'><span  style='color:#545454'><b>悬赏金额:</b></span></td> <td style=' text-align:left;'>"+
			               		"<span  style='color:#545454'><b>"+bid.getTotalMoney()+"元</b></span>"+
			                "<span style='color:#7A7A7A'>&nbsp;&nbsp;|&nbsp;&nbsp;应约截止时间:"+bid.getPeriod()+"&nbsp;|&nbsp;&nbsp;共招聘:"+bid.getNumChangeWorker()+"人&nbsp;|&nbsp;任务状态:发布中&nbsp;....<a target='_blank' href='bid!findbyBidId.do?id="+bid.getId()+"&aimId='>详情</a></span>"+
			               	"</td>	</tr></table></div>"+
			               	"<div style=' width:110px; height:90px; float:right;margin-right:30px;'>	<DIV class='divty'><span> 我要应约</span></DIV></div></div>\");");	
				}
				writer.write("document.writeln(\"</div>\");");
			}else if(j.equals("1")) {
				writer.write("document.writeln(\"<div  id='div1' style='height:403px; width:98%;  display:none;float:left'>\");");
				for (Bid bid:listbid) {
					writer.write("document.writeln(\"<div class='divclasd' ><div style=' width:120px; height:90px; float:left;margin-left:12px;'>"+
						  " <img src='"+bid.getUser().getPortrait()+"' style='width:120px; height:90px;'/></div><div style=' width:570px; height:90px; float:left; margin-left:12px;'>"+
							 "<table  width='100%' height='100%'><tr>"+
			                "<td style='text-align:left; width:60px'>"+
			               	"<span  style='color:#545454'><b>拍摄名称:</b></span></td>"+
			                    "<td style=' text-align:left;'>"+
			               		"<span  style='color:#545454'><b>"+bid.getName()+"</b></span></td></tr>"+
			               	 "<tr><td style=' text-align:left;'><span  style='color:#545454'><b>	拍摄地点:</b></span></td>"+
				                " <td style=' text-align:left;'><span  style='color:#545454'><b>"+bid.getWorkPlace()+"</b></span>"+
				                  "</td></tr>"+	
				                  "<tr><td style=' text-align:left;'><span  style='color:#545454'><b>	拍摄时间:</b></span></td>"+
					                " <td style=' text-align:left;'><span  style='color:#545454'>"+bid.getWorkStartTime()+"&nbsp;&nbsp;|&nbsp;&nbsp;发布人:"+bid.getUser().getUsername()+"</span></td></tr>"+	
					                  
			                   " <tr><td style=' text-align:left;'><span  style='color:#545454'><b>悬赏金额:</b></span></td> <td style=' text-align:left;'>"+
			               		"<span  style='color:#545454'><b>"+bid.getTotalMoney()+"元</b></span>"+
			                "<span style='color:#7A7A7A'>&nbsp;&nbsp;|&nbsp;&nbsp;应约截止时间:"+bid.getWorkEndTime()+"&nbsp;|&nbsp;&nbsp;共招聘:"+bid.getNumChangeWorker()+"人&nbsp;|&nbsp;任务状态:发布中&nbsp;....<a target='_blank' href='bid!findbyBidId.do?id="+bid.getId()+"&aimId='>详情</a></span>"+
			               	"</td>	</tr></table></div>"+
			               	"<div style=' width:110px; height:90px; float:right;margin-right:30px;'>	<DIV class='divty'><span> 我要应约</span></DIV></div></div>\");");	
				}
				writer.write("document.writeln(\"</div>\");");
			}else if (j.equals("3")) {
				writer.write("document.writeln(\"<div class='block'  id='div3' style='height:403px; width:99%; display:none;float:left'>\");");
				for (Bid bid:listbid) {
					writer.write("document.writeln(\"<div class='divclasd' ><div style=' width:120px; height:90px; float:left;margin-left:12px;'>"+
						  " <img src='"+bid.getUser().getPortrait()+"' style='width:120px; height:90px;'/></div><div style=' width:570px; height:90px; float:left; margin-left:12px;'>"+
							 "<table  width='100%' height='100%'><tr>"+
			                "<td style='text-align:left; width:60px'>"+
			               	"<span  style='color:#545454'><b>拍摄名称:</b></span></td>"+
			                    "<td style=' text-align:left;'>"+
			               		"<span  style='color:#545454'><b>"+bid.getName()+"</b></span></td></tr>"+
			               	 "<tr><td style=' text-align:left;'><span  style='color:#545454'><b>	拍摄地点:</b></span></td>"+
				                " <td style=' text-align:left;'><span  style='color:#545454'><b>"+bid.getWorkPlace()+"</b></span>"+
				                  "</td></tr>"+	
				                  "<tr><td style=' text-align:left;'><span  style='color:#545454'><b>	拍摄时间:</b></span></td>"+
					                " <td style=' text-align:left;'><span  style='color:#545454'>"+bid.getWorkStartTime()+"&nbsp;&nbsp;|&nbsp;&nbsp;发布人:"+bid.getUser().getUsername()+"</span></td></tr>"+	
					                  
			                   " <tr><td style=' text-align:left;'><span  style='color:#545454'><b>悬赏金额:</b></span></td> <td style=' text-align:left;'>"+
			               		"<span  style='color:#545454'><b>"+bid.getTotalMoney()+"元</b></span>"+
			                "<span style='color:#7A7A7A'>&nbsp;&nbsp;|&nbsp;&nbsp;应约截止时间:"+bid.getWorkEndTime()+"&nbsp;|&nbsp;&nbsp;共招聘:"+bid.getNumChangeWorker()+"人&nbsp;|&nbsp;任务状态:发布中&nbsp;....<a target='_blank' href='bid!findbyBidId.do?id="+bid.getId()+"&aimId='>详情</a></span>"+
			               	"</td>	</tr></table></div>"+
			               	"<div style=' width:110px; height:90px; float:right;margin-right:30px;'>	<DIV class='divty'><span> 我要应约</span></DIV></div></div>\");");	
				}
				writer.write("document.writeln(\"</div>\");");
			}
		}
		writer.write("document.writeln(\" <div style='width:3px;float:right;height:411px;   background:#E3E3E3'></div></div></div></div>\");");
		writer.close();
	}
	/**
	 * 生成静态页面
	 * @return
	 * @throws Exception
	 */
	public String frontIndexPic() throws Exception {
		recommendFrontPage();
		photographyFrontPage();
		homePageBigPic();
		tabContent();
		return "createResult";
	}
	@JSON(serialize=false)
	public String homePageMainPic(){
		
//		boolean b=MemcachedUtil.checkedMemcachedOpennew(memCachedServerIp, IpPort);
//		if(b){
//			mainPublishs=(List<Publish>) MemcachedUtil.getCache(memCachedServerIp, IpPort, "mainPublishs");
//			
//		}
//		if(mainPublishs==null){
//			mainPublishs=new ArrayList<Publish>();
//			mainPublishs = publishService.homePageMainPicNew();
//			if(b){
//		    MemcachedUtil.setCache(memCachedServerIp, IpPort,60*60*24*7, "mainPublishs",mainPublishs);
//			}
//		}
		
		mainPublishs=(List<Publish>)cacheOperation.getCache("mainPublishs", fillCache);
		
		
		return "homePageMainPics";
	}
	
	
	public String initBidFrontPage(){
		try{
		int pageON=1;
		int pageSize=3;
		listbid=bidService.selectByFrontPage(typeId,pageON,pageSize);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "initBidFrontPage";
	}
	public String initPaishePage(){
	List<Bid> list= bidService.selectByFrontPage("4", 1, 8);
	 ActionContext.getContext().put("list1", list);
	 Pager list2=userService.getAllPohtoOrModel("photographer_contributing", 1, 8);
	 Pager list3=userService.getAllPohtoOrModel("model", 1, 8);
	 ActionContext.getContext().put("list3", list3);
	 ActionContext.getContext().put("list2", list2);
	this.pager=bidService.selectByteyuePage("1", 1, 5);
	
	return "initPaishePage";
	}
	@JSON(serialize=false)
	public String nextBidFrontPage(){
		
		this.pager=bidService.selectByteyuePage(typeId,this.pageNo,6);
		
		return "nextBidFrontPage";
	}
	
	@SuppressWarnings("unchecked")
	public String initPhotoPage(){
		 boolean b=MemcachedUtil.checkedMemcachedOpen(memCachedServerIp, 11211);
		 
	
        if(flag!=null){
		if(flag.equals("1")){
			super.pageNo=1;	
			flag="0";
		}}
           if(super.pageNo!=1){
        	  b=false; 
        	   
           }
           super.pager= userService.getAllPohtoOrModel("photographer",  super.pageNo,18);
           List<User> users=new LinkedList<User>();
           if(b){
           super.pager=(Pager) MemcachedUtil.getCache(memCachedServerIp, 11211, "photoPager");
           }
         //  System.out.println(super.pager);
           if( super.pager==null){
        	   super.pager= userService.getAllPohtoOrModel("photographer",  super.pageNo,18);
        	   if(b){
        		   MemcachedUtil.setCache(memCachedServerIp, 11211,60*60*24*7, "photoPager",super.pager); 
        	   }
           }
           List<User> list= userService.getAllPohtoOrModelByShowLeft("photographer");
           LinkedList<User> listLeftUser=new LinkedList<User>(); 
           for (User brokeuser : list) {
        	   
        		//brokeuser = userService.selectById(brokerRelationship.getBroker().getId());
				UserCredit userCredit = userCreditService.selectByUser(brokeuser);
				UserMess userMess = new UserMess();
				int attentionNumber = this.getContactService().findAttentionNumber(brokeuser);
				int fansNumber = this.getContactService().findFansNumber(brokeuser);
			//	userMess.setBadRemark(userCredit.getBidBadRemarkNum());
				userMess.setFansNumber(fansNumber);
				userMess.setAttentionNumber(attentionNumber);
				//userMess.setGoodRemark(userCredit.getBidGoodRemarkNum());
			//	userMess.setIdString(brokerRelationship.getId()+"");
			   //userCredit=userCreditService.selectByUser(brokeuser);
			   UserCredit credit=new UserCredit();
			    int total=(int) userCredit.getTotalMark();
			    int star=total/200;
			    credit.setStar(star);
			    userMess.setCredit(credit);
			   
				brokeuser.setUserMess(userMess);
				listLeftUser.add(brokeuser);
		}
           ActionContext.getContext().put("listLeftUser", listLeftUser);
           
           
           
           
           
          

		
		ActionContext.getContext().put("url", "initPhotoPage.do");
		return "initPhotoPage";
		}
	@SuppressWarnings("unchecked")
	public String initModelPage(){
		 boolean b=MemcachedUtil.checkedMemcachedOpen(memCachedServerIp, 11211);
		super.pager=null;
		if(flag!=null){
		if(flag.equals("1")){
			this.pageNo=1;	
			flag="0";
			}
		}
		if(super.pageNo!=1){
      	  b=false; 
      	   
         }
		
		   if(b){
	           super.pager=(Pager) MemcachedUtil.getCache(memCachedServerIp, 11211, "modelPager");
	           }
	          // System.out.println(super.pager);
	           if( super.pager==null){
	        	   super.pager =userService.getAllPohtoOrModel("model", this.pageNo, 18);
	        	   if(b){
	        		   MemcachedUtil.setCache(memCachedServerIp, 11211,60*60*24*7, "modelPager",super.pager);
	        		   
	        	   }
	        	   
	        	   
	           }
	           List<User> list= userService.getAllPohtoOrModelByShowLeft("model");
	           LinkedList<User> listLeftUser=new LinkedList<User>(); 
	           for (User brokeuser : list) {
	        	   
	        		//brokeuser = userService.selectById(brokerRelationship.getBroker().getId());
					UserCredit userCredit = userCreditService.selectByUser(brokeuser);
					UserMess userMess = new UserMess();
					int attentionNumber = this.getContactService().findAttentionNumber(brokeuser);
					int fansNumber = this.getContactService().findFansNumber(brokeuser);
				//	userMess.setBadRemark(userCredit.getBidBadRemarkNum());
					userMess.setFansNumber(fansNumber);
					userMess.setAttentionNumber(attentionNumber);
					//userMess.setGoodRemark(userCredit.getBidGoodRemarkNum());
				//	userMess.setIdString(brokerRelationship.getId()+"");
				   //userCredit=userCreditService.selectByUser(brokeuser);
				    UserCredit credit=new UserCredit();
				   int total=(int) userCredit.getTotalMark();
				   int star=total/200;
				   credit.setStar(star);
				   userMess.setCredit(credit);
				   
					brokeuser.setUserMess(userMess);
					listLeftUser.add(brokeuser);
			}
	           ActionContext.getContext().put("listLeftUser", listLeftUser);
		
			ActionContext.getContext().put("url", "initModelPage.do");
		return "initModelPage";
		}


	public Publish getMainPublish() {
		return mainPublish;
	}
	public void setMainPublish(Publish mainPublish) {
		this.mainPublish = mainPublish;
	}
	List<String> citylist=new ArrayList<String>();
	
	public List<String> getCitylist() {
		return citylist;
	}


	public void setCitylist(List<String> citylist) {
		this.citylist = citylist;
	}

  
 
	public List<Publish> getMainPublishs() {
		return mainPublishs;
	}


	public void setMainPublishs(List<Publish> mainPublishs) {
		this.mainPublishs = mainPublishs;
	}


	public String getProvince() {
	return province;
}


public void setProvince(String province) {
	this.province = province;
}


	@SuppressWarnings("unchecked")
	@JSON(serialize=false)
	public String domXML(){
		HttpServletRequest request=ServletActionContext.getRequest();
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		 SAXBuilder builder=new SAXBuilder();	//解析器
			try {		
				Document docment=builder.build(basePath+"/city.xml");//xml文本对象
				Element root=docment.getRootElement();	//根节点	
				List<Element> names=root.getChildren("province");//得到txtbook节点列表
				for(Element element:names){	
					String province1=element.getAttributeValue("name");
					
					if(province1.equals(province.trim())){
						List<Element> cityElement=element.getChildren("city");
						for (Element element2 : cityElement) {
							String city=element2.getAttributeValue("name");
							citylist.add(city);
							//System.out.println(city);
						}
					}					
				}
			} catch (Exception  e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return "citylist";
	}
	public String initsearch() throws UnsupportedEncodingException{
		if("特约拍摄".equals(type)){
			type="2";
		}else if ("找摄影师/模特".equals(type)) {
			type="1";
		}else if("图片征集".equals(type)){
			type="3";
			
			
		}
		
	super.pager=bidService.selectFindSerarch(position,type,language_tm20083,language_tm20084,language_tm20085,5,1);
	List<Bid> list= bidService.selectByFrontPage("4", 1, 8);
	 ActionContext.getContext().put("list1", list);
	 Pager list2=userService.getAllPohtoOrModel("photographer_contributing", 1, 8);
	 Pager list3=userService.getAllPohtoOrModel("model", 1, 8);
	 ActionContext.getContext().put("list3", list3);
	 ActionContext.getContext().put("list2", list2);
		return  "initsearch";
	}
	
	public String searchbid() throws UnsupportedEncodingException{
		super.pager=bidService.selectFindSerarch(position,type,language_tm20083,language_tm20084,language_tm20085,5,this.pageNo);
		List<Bid> list= bidService.selectByFrontPage("4", 1, 8);
		 ActionContext.getContext().put("list1", list);
		 Pager list2=userService.getAllPohtoOrModel("photographer_contributing", 1, 8);
		 Pager list3=userService.getAllPohtoOrModel("model", 1, 8);
		 ActionContext.getContext().put("list3", list3);
		 ActionContext.getContext().put("list2", list2);
			return  "searchbid";
		}
	
	
	public String initSearchPhotoOrModel(){
		super.pager=userService.searchPhotoOrModel(8, pageNo, position,searchUserNick, searchType);
		String searString="searchModel";
		if("photographer_contributing".equals(searchType.trim())){
			 searString="searchphotographer";
		}
		return searString;
	}
	public String SearchPhotoOrModel(){
		super.pager=userService.searchPhotoOrModel(8, pageNo, position,searchUserNick, searchType);
		String searString="searchModel";
		if("photographer_contributing".equals(searchType.trim())){
			 searString="searchphotographer";
		}
		return searString;
	}
	String userName=null;
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

    
	public String getUserName() {
		return userName;
	}

    @JSON(serialize=false)
	public String getUserLoginName(){
		 userName=super.getLoginUsername();
		 System.out.println(userName);
		return "getUserLoginName";
		
		
		
	}
	

	
	
	
	//&amp;#34920;&amp;#28436;&amp;#27169;&amp;#29305;
	//&#34920;&#28436;&#27169;&#29305;
}
