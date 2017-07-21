package com.wetuo.wepic.deal.actions ;
 
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.StringTokenizer;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wetuo.wepic.deal.beans.BidForOpus;
import com.wetuo.wepic.deal.service.BidForOpusService;
import com.wetuo.wepic.deal.service.BidtransactionService;
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.core.service.UserService;
 
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.struts.PageAction;
import com.wetuo.wepic.common.struts.Constants;
import com.wetuo.wepic.common.struts.RegExpression;
import com.wetuo.wepic.common.util.FileUploadStatus;
 
 
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

	import com.wetuo.wepic.deal.beans.Bid;
import com.wetuo.wepic.deal.service.BidService;
public class BidForOpusAction extends PageAction {
		
	private BidService bidService;
	private String bidId;
	private int nowPage=1;
	private String meString;
	
	
	public String getMeString() {
		return meString;
	}
	public void setMeString(String meString) {
		this.meString = meString;
	}
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	public String getBidId() {
		return bidId;
	}
	public void setBidId(String bidId) {
		this.bidId = bidId;
	}
	public BidService getBidService() {
		return bidService;
	}
	public void setBidService(BidService bidService) {
		this.bidService = bidService;
	}
		
 private BidtransactionService bidtransactionService;
 
 
	public BidtransactionService getBidtransactionService() {
	return bidtransactionService;
}
     public void setBidtransactionService(BidtransactionService bidtransactionService) {
	this.bidtransactionService = bidtransactionService;
    }

	/////instantce variable//////
	private static final long serialVersionUID = 1L;
	protected String id = null ; 
 	private BidForOpusService bidForOpusService;
	protected String userId = null ;
	private UserService userService;
	private BidForOpus bidOpus;
	
	public BidForOpus getBidOpus() {
		return bidOpus;
	}
	public void setBidOpus(BidForOpus bidOpus) {
		this.bidOpus = bidOpus;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	protected String sendTime = null ; 
	protected String thumbNail_Image = null ; 
	protected String original_Drawing = null ; 
	protected String conetxt = null ; 
	protected String confirmTime = null ; 
	protected String status = null ; 
	protected String username = null; 
	//???????????��????
	public void validate() {
		
		// ?????????
		clearErrorsAndMessages();
		
		// ??????????
		String queryString = getRequestPath();
		if (queryString.indexOf("bidForOpusadd!insert") != -1 || queryString.indexOf("bidForOpusedit!update") != -1) {
		
			if (userId == null || userId.equals("")) {
				addFieldError("userId", "userId must be inputed");
			}//end if null
			if (sendTime == null || sendTime.equals("")) {
				addFieldError("sendTime", "sendTime must be inputed");
			}//end if null
			if (thumbNail_Image == null || thumbNail_Image.equals("")) {
				addFieldError("thumbNail_Image", "thumbNail_Image must be inputed");
			}//end if null
			if (original_Drawing == null || original_Drawing.equals("")) {
				addFieldError("original_Drawing", "original_Drawing must be inputed");
			}//end if null
			if (conetxt == null || conetxt.equals("")) {
				addFieldError("conetxt", "conetxt must be inputed");
			}//end if null
			if (confirmTime == null || confirmTime.equals("")) {
				addFieldError("confirmTime", "confirmTime must be inputed");
			}//end if null
			if (status == null || status.equals("")) {
				addFieldError("status", "status must be inputed");
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
		super.pager = this.getBidForOpusService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		
		// ?????????
		setSession(Constants.PAGER_BIDFOROPUS, super.pager);
		
		return Constants.LIST_KEY;
		
	}//end init()
		
	public String list() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// ???????????
		super.pager = this.getBidForOpusService().list(super.getLoginUsername(), super.pageSize, super.pageNo);	
		
		// ?????????
		setSession(Constants.PAGER_BIDFOROPUS, super.pager);
		
		return Constants.LIST_KEY;
		
	}//end list()
		
	public String add() throws Exception {
		System.out.println("F2 add getParameter of oneId: "+ServletActionContext.getRequest().getParameter("oneId"));
		
		if(ServletActionContext.getRequest().getParameter("from") != null && ServletActionContext.getRequest().getParameter("from") != ""){
			if(ServletActionContext.getRequest().getParameter("from").indexOf("bidForOpus") > -1){
				ServletActionContext.getResponse().sendRedirect("bid!init.do");
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
		setSendTime(null);
		setThumbNail_Image(null);
		setOriginal_Drawing(null);
		setConetxt(null);
		setConfirmTime(null);
		setStatus(null);
	}//end reset()
		// ?????��??
	private void bean2Form(BidForOpus bidForOpus) {
		setId(bidForOpus.getId().toString());
		setUserId(bidForOpus.getUser().getId().toString());
		setSendTime(bidForOpus.getSendTime().toString()      );
		setThumbNail_Image(bidForOpus.getThumbNail_Image());
		setOriginal_Drawing(bidForOpus.getOriginal_Drawing());
		setConetxt(bidForOpus.getConetxt());
		setConfirmTime(bidForOpus.getConfirmTime().toString()      );
		setStatus(bidForOpus.getStatus().toString()      );
	}//end bean2Form()
	public String edit() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// id???????????
		if (this.getId() == null) {
			saveActionError("bidForOpus.message.edit.notexist");
			return Constants.LIST_KEY;
		} else {
			// ???????
			BidForOpus bidForOpus = this.getBidForOpusService().select(id); 
			
			// ??????????????
			if (bidForOpus == null) {
				saveActionError("bidForOpus.message.edit.notexist");
				return Constants.LIST_KEY;
			} else {
				// ?????��??
				bean2Form(bidForOpus);
				return Constants.EDIT_KEY;
			}
		}//end if
		
	}//end edit()
		
	
	
	
	
	
	
	
	//获得所有的应标图片
	@JSON(serialize=false)
	public String getbidImg(){
		
		
		Bid bid=bidService.select(bidId);
		super.pager=bidForOpusService.list(bid,16,nowPage);
		
		
		
		return "getbidImg";
	}
	
	//待定图片
	@JSON(serialize=false)
	public String daiding(){
		bidOpus=bidForOpusService.select(id);
		bidOpus.setStatus(1);
		bidForOpusService.update(bidOpus);
		meString=1+"";
		
		
		return "daiding";
	}
	//应标图片信息单张
	@JSON(serialize=false)
	public String getbidPic(){
		
		
		bidOpus=bidForOpusService.select(id);
		bidOpus.setStatus(3);
		bidForOpusService.update(bidOpus);
		
		
		
		return "getbidPic";
	}
	public String insert() throws Exception {
		// 
		clearErrorsAndMessages();
		String nid = null ;
		
		try{
			
		//
		BidForOpus bidForOpus = new BidForOpus();
		//bidForOpus.setUser(userInstance);    
		bidForOpus.setUser(this.getUserService().select(userId));    
		
		bidForOpus.setSendTime(java.sql.Timestamp.valueOf(this.getSendTime() ));
		bidForOpus.setThumbNail_Image(this.getThumbNail_Image());
		bidForOpus.setOriginal_Drawing(this.getOriginal_Drawing());
		bidForOpus.setConetxt(this.getConetxt());
		bidForOpus.setConfirmTime(java.sql.Timestamp.valueOf(this.getConfirmTime() ));
		bidForOpus.setStatus(Integer.valueOf(this.getStatus() ));
		String strOneId = ServletActionContext.getRequest().getParameter("oneId");
		System.out.println("F2 insert getParameter  of oneId:"+strOneId);
		Bid oneInstance = this.getBidService().select( strOneId );
		bidForOpus.setBid(oneInstance);
		
		nid = this.getBidForOpusService().insert(bidForOpus);
		
		// ?????????????
		Pager pagerSession = (Pager) getSession(Constants.PAGER_BIDFOROPUS);
		if(pagerSession == null){
			//??????????
			super.pageSize = Constants.pageSize;
			super.pageNo = Constants.pageNo;
		}else{
			super.pageSize = pagerSession.getPageSize();
			super.pageNo = pagerSession.getPageNo();
			
		}
		
		//????????????
		super.pager = this.getBidForOpusService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		
		
		}catch(Exception e){
			saveActionError2(e.toString());
			saveActionMessage2(" Sorry ");
			return Constants.ERROR_KEY;
		}
		
		// ?????????
		if (nid != null) {
			saveActionMessage("bidForOpus.message.add.success");
			return Constants.LIST_KEY;
		} else {
			saveActionError("bidForOpus.message.add.failed");
			return Constants.ADD_KEY;
		}
	}//end insert()
	public String update() throws Exception {
		// 
		clearErrorsAndMessages();
		
		try{
			// 
			BidForOpus bidForOpus = this.getBidForOpusService().select(new String(id));
			//bidForOpus.setUser(userInstance);   
			bidForOpus.setUser(this.getUserService().select(userId));    
			
			bidForOpus.setSendTime(java.sql.Timestamp.valueOf(this.getSendTime() ));
			bidForOpus.setThumbNail_Image(this.getThumbNail_Image());
			bidForOpus.setOriginal_Drawing(this.getOriginal_Drawing());
			bidForOpus.setConetxt(this.getConetxt());
			bidForOpus.setConfirmTime(java.sql.Timestamp.valueOf(this.getConfirmTime() ));
			bidForOpus.setStatus(Integer.valueOf(this.getStatus() ));
		this.getBidForOpusService().update(bidForOpus);
		
		bean2Form(bidForOpus);	
		
		// ?????????????
		Pager pagerSession = (Pager) getSession(Constants.PAGER_BIDFOROPUS);
		if(pagerSession == null){
			//??????????
			super.pageSize = Constants.pageSize;
			super.pageNo = Constants.pageNo;
		}else{
			super.pageSize = pagerSession.getPageSize();
			super.pageNo = pagerSession.getPageNo();
			
		}
		
			// ????????????
			super.pager = this.getBidForOpusService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
			saveActionMessage("bidForOpus.message.edit.success");
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
				saveActionError("bidForOpus.message.edit.notexist");
			} else {
				// ??????
				this.getBidForOpusService().delete(id);
				saveActionMessage("bidForOpus.message.delete.success");
			}
			
			// ???????????
			super.pager = this.getBidForOpusService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
			
		}catch(Exception e){
			saveActionError2(e.toString());
			saveActionMessage2("Please delete child first");
			return Constants.ERROR_KEY;
		}
		return Constants.LIST_KEY;
		
	}//end delete()
		
	
	
	
	
	
	//确定招标作品
	
	
	
	
	
	
	
	
	
 
	/////getter////setter//////
	public String getId(){
		return  id;
	}
	public void  setId(String id){
		this.id = id ;
	}
	 
	public BidForOpusService getBidForOpusService() {
		return bidForOpusService;
	}
	public void setBidForOpusService(BidForOpusService bidForOpusService) {
		this.bidForOpusService = bidForOpusService;
	}
	
	public String getUserId(){
		return  userId;
	}
	public void  setUserId(String userId){
		this.userId = userId ;
	}
	 
	public String getSendTime(){
		return  sendTime;
	}
	public void  setSendTime(String sendTime){
		this.sendTime = sendTime ;
	}
	 
	public String getThumbNail_Image(){
		return  thumbNail_Image;
	}
	public void  setThumbNail_Image(String thumbNail_Image){
		this.thumbNail_Image = thumbNail_Image ;
	}
	 
	public String getOriginal_Drawing(){
		return  original_Drawing;
	}
	public void  setOriginal_Drawing(String original_Drawing){
		this.original_Drawing = original_Drawing ;
	}
	 
	public String getConetxt(){
		return  conetxt;
	}
	public void  setConetxt(String conetxt){
		this.conetxt = conetxt ;
	}
	 
	public String getConfirmTime(){
		return  confirmTime;
	}
	public void  setConfirmTime(String confirmTime){
		this.confirmTime = confirmTime ;
	}
	 
	public String getStatus(){
		return  status;
	}
	public void  setStatus(String status){
		this.status = status ;
	}
	 
	 public String getUsername() {
	 	return username;
	 }
	 public void setUsername(String username) {
	 	this.username = username;
	 }
	 
		public void getprograss(){
			HttpServletRequest request=super.getRequest();
			HttpServletResponse response=super.getReponse();
			
			HttpSession session = request.getSession();
			FileUploadStatus status = (FileUploadStatus) session.getAttribute("status");
			try {
				response.reset();
				response.getWriter().write("{\"pBytesRead\":"
						+status.getPBytesRead()+",\"pContentLength\":"+status.getPContentLength()+",\"pItem\":"+status.getPItems()+"}");
			System.out.println("{\"pBytesRead\":"
					+status.getPBytesRead()+",\"pContentLength\":"+status.getPContentLength()+"}");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
		}
		
}//end class
