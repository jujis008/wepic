package com.wetuo.wepic.deal.actions ;
 
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.StringTokenizer;
import java.io.File;
import java.util.*;
import java.text.SimpleDateFormat;
import com.wetuo.wepic.deal.beans.BidDetail;
import com.wetuo.wepic.deal.service.BidDetailService;
 
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.struts.PageAction;
import com.wetuo.wepic.common.struts.Constants;
import com.wetuo.wepic.common.struts.RegExpression;
 
 
import org.apache.struts2.ServletActionContext;
	import com.wetuo.wepic.deal.beans.Bid;
	import com.wetuo.wepic.deal.service.BidService;
public class BidDetailAction extends PageAction {
		
	private BidService bidService;
	public BidService getBidService() {
		return bidService;
	}
	public void setBidService(BidService bidService) {
		this.bidService = bidService;
	}
		
 
 
	/////instantce variable//////
	private static final long serialVersionUID = 1L;
	protected String id = null ; 
 	private BidDetailService bidDetailService;
	protected String key = null ; 
	protected String value = null ; 
	protected String picUrl = null ; 
	protected String characteristic = null ; 
	protected String type = null ; 
	protected String username = null; 
	//???????????��????
	public void validate() {
		
		// ?????????
		clearErrorsAndMessages();
		
		// ??????????
		String queryString = getRequestPath();
		if (queryString.indexOf("bidDetailadd!insert") != -1 || queryString.indexOf("bidDetailedit!update") != -1) {
		
			if (key == null || key.equals("")) {
				addFieldError("key", "key must be inputed");
			}//end if null
			if (value == null || value.equals("")) {
				addFieldError("value", "value must be inputed");
			}//end if null
			if (picUrl == null || picUrl.equals("")) {
				addFieldError("picUrl", "picUrl must be inputed");
			}//end if null
			if (characteristic == null || characteristic.equals("")) {
				addFieldError("characteristic", "characteristic must be inputed");
			}//end if null
			if (type == null || type.equals("")) {
				addFieldError("type", "type must be inputed");
			}//end if null
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
		super.pager = this.getBidDetailService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		
		// ?????????
		setSession(Constants.PAGER_BIDDETAIL, super.pager);
		
		return Constants.LIST_KEY;
		
	}//end init()
		
	public String list() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// ???????????
		super.pager = this.getBidDetailService().list(super.getLoginUsername(), super.pageSize, super.pageNo);	
		
		// ?????????
		setSession(Constants.PAGER_BIDDETAIL, super.pager);
		
		return Constants.LIST_KEY;
		
	}//end list()
		
	public String add() throws Exception {
		System.out.println("F2 add getParameter of oneId: "+ServletActionContext.getRequest().getParameter("oneId"));
		
		if(ServletActionContext.getRequest().getParameter("from") != null && ServletActionContext.getRequest().getParameter("from") != ""){
			if(ServletActionContext.getRequest().getParameter("from").indexOf("bidDetail") > -1){
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
		setKey(null);
		setValue(null);
		setPicUrl(null);
		setCharacteristic(null);
		setType(null);
	}//end reset()
		// ?????��??
	private void bean2Form(BidDetail bidDetail) {
		setId(bidDetail.getId().toString());
		setKey(bidDetail.getBidkey());
		setValue(bidDetail.getValue());
		setPicUrl(bidDetail.getPicUrl());
		setCharacteristic(bidDetail.getCharacteristic());
		setType(bidDetail.getType().toString()      );
	}//end bean2Form()
	public String edit() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// id???????????
		if (this.getId() == null) {
			saveActionError("bidDetail.message.edit.notexist");
			return Constants.LIST_KEY;
		} else {
			// ???????
			BidDetail bidDetail = this.getBidDetailService().select(id); 
			
			// ??????????????
			if (bidDetail == null) {
				saveActionError("bidDetail.message.edit.notexist");
				return Constants.LIST_KEY;
			} else {
				// ?????��??
				bean2Form(bidDetail);
				return Constants.EDIT_KEY;
			}
		}//end if
		
	}//end edit()
		
	public String insert() throws Exception {
		// 
		clearErrorsAndMessages();
		String nid = null ;
		
		try{
			
		//
		BidDetail bidDetail = new BidDetail();
		bidDetail.setBidkey(this.getKey());
		bidDetail.setValue(this.getValue());
		bidDetail.setPicUrl(this.getPicUrl());
		bidDetail.setCharacteristic(this.getCharacteristic());
		bidDetail.setType(Integer.valueOf(this.getType() ));
		String strOneId = ServletActionContext.getRequest().getParameter("oneId");
		System.out.println("F2 insert getParameter  of oneId:"+strOneId);
		Bid oneInstance = this.getBidService().select(strOneId);
		bidDetail.setBid(oneInstance);
		
		nid = this.getBidDetailService().insert(bidDetail);
		
		// ?????????????
		Pager pagerSession = (Pager) getSession(Constants.PAGER_BIDDETAIL);
		if(pagerSession == null){
			//??????????
			super.pageSize = Constants.pageSize;
			super.pageNo = Constants.pageNo;
		}else{
			super.pageSize = pagerSession.getPageSize();
			super.pageNo = pagerSession.getPageNo();
			
		}
		
		//????????????
		super.pager = this.getBidDetailService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		
		
		}catch(Exception e){
			saveActionError2(e.toString());
			saveActionMessage2(" Sorry ");
			return Constants.ERROR_KEY;
		}
		
		// ?????????
		if (nid != null) {
			saveActionMessage("bidDetail.message.add.success");
			return Constants.LIST_KEY;
		} else {
			saveActionError("bidDetail.message.add.failed");
			return Constants.ADD_KEY;
		}
	}//end insert()
	public String update() throws Exception {
		// 
		clearErrorsAndMessages();
		
		try{
			// 
			BidDetail bidDetail = this.getBidDetailService().select(new String(id));
			bidDetail.setBidkey(this.getKey());
			bidDetail.setValue(this.getValue());
			bidDetail.setPicUrl(this.getPicUrl());
			bidDetail.setCharacteristic(this.getCharacteristic());
			bidDetail.setType(Integer.valueOf(this.getType() ));
		this.getBidDetailService().update(bidDetail);
		
		bean2Form(bidDetail);	
		
		// ?????????????
		Pager pagerSession = (Pager) getSession(Constants.PAGER_BIDDETAIL);
		if(pagerSession == null){
			//??????????
			super.pageSize = Constants.pageSize;
			super.pageNo = Constants.pageNo;
		}else{
			super.pageSize = pagerSession.getPageSize();
			super.pageNo = pagerSession.getPageNo();
			
		}
		
			// ????????????
			super.pager = this.getBidDetailService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
			saveActionMessage("bidDetail.message.edit.success");
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
				saveActionError("bidDetail.message.edit.notexist");
			} else {
				// ??????
				this.getBidDetailService().delete(id);
				saveActionMessage("bidDetail.message.delete.success");
			}
			
			// ???????????
			super.pager = this.getBidDetailService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
			
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
	 
	public BidDetailService getBidDetailService() {
		return bidDetailService;
	}
	public void setBidDetailService(BidDetailService bidDetailService) {
		this.bidDetailService = bidDetailService;
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
	 
	public String getPicUrl(){
		return  picUrl;
	}
	public void  setPicUrl(String picUrl){
		this.picUrl = picUrl ;
	}
	 
	public String getCharacteristic(){
		return  characteristic;
	}
	public void  setCharacteristic(String characteristic){
		this.characteristic = characteristic ;
	}
	 
	public String getType(){
		return  type;
	}
	public void  setType(String type){
		this.type = type ;
	}
	 
	 public String getUsername() {
	 	return username;
	 }
	 public void setUsername(String username) {
	 	this.username = username;
	 }
	 
}//end class
