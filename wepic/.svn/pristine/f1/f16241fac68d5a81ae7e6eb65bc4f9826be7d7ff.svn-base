package com.wetuo.wepic.deal.actions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.File;
import java.util.*;
import java.text.SimpleDateFormat;
import com.wetuo.wepic.deal.beans.BuyCommodities;
import com.wetuo.wepic.deal.beans.CountDeal;
import com.wetuo.wepic.deal.service.BuyCommoditiesService;
import com.wetuo.wepic.publish.beans.Publish;
import com.wetuo.wepic.publish.service.PublishService;

import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.struts.PageAction;
import com.wetuo.wepic.common.struts.Constants;
import com.wetuo.wepic.common.struts.RegExpression;
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.core.service.UserService;

import org.apache.struts2.ServletActionContext;
import com.wetuo.wepic.deal.beans.BuyCartDeal;
import com.wetuo.wepic.deal.service.BuyCartDealService;
import com.tools.Cleandar;

public class BuyCommoditiesAction extends PageAction {

	private BuyCartDealService buyCartDealService;

	public BuyCartDealService getBuyCartDealService() {
		return buyCartDealService;
	}

	public void setBuyCartDealService(BuyCartDealService buyCartDealService) {
		this.buyCartDealService = buyCartDealService;
	}

	// ///instantce variable//////
	private static final long serialVersionUID = 1L;
	protected String id = null;
	private BuyCommoditiesService buyCommoditiesService;
	protected String publishId = null;
	private PublishService publishService;
	private UserService userService;
	private User user;
	private int nowPage;
	
	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public PublishService getPublishService() {
		return publishService;
	}

	public void setPublishService(PublishService publishService) {
		this.publishService = publishService;
	}

	protected String copyrightOrUsage = null;
	protected String amount = null;
	protected String startTime = null;
	protected String username = null;

	// ???????????��????
	public void validate() {

		// ?????????
		clearErrorsAndMessages();

		// ??????????
		String queryString = getRequestPath();
		if (queryString.indexOf("buyCommoditiesadd!insert") != -1
				|| queryString.indexOf("buyCommoditiesedit!update") != -1) {

			if (publishId == null || publishId.equals("")) {
				addFieldError("publishId", "publishId must be inputed");
			}// end if null
			if (copyrightOrUsage == null || copyrightOrUsage.equals("")) {
				addFieldError("copyrightOrUsage",
						"copyrightOrUsage must be inputed");
			}// end if null
			if (amount == null || amount.equals("")) {
				addFieldError("amount", "amount must be inputed");
			}// end if null
			if (startTime == null || startTime.equals("")) {
				addFieldError("startTime", "startTime must be inputed");
			}// end if null
			// ???????
			// ???????
			// ???????
			// ???????
			// ???????
		}// end if
	}// end validate()

	public String init() throws Exception {
		// ?????????
		clearErrorsAndMessages();

		// ??????????
		super.pageSize = Constants.pageSize;
		super.pageNo = Constants.pageNo;

		// ???????????
		super.pager = this.getBuyCommoditiesService().list(
				super.getLoginUsername(), super.pageSize, super.pageNo);

		// ?????????
		setSession(Constants.PAGER_BUYCOMMODITIES, super.pager);

		return Constants.LIST_KEY;

	}// end init()

	public String list() throws Exception {
		// ?????????
		clearErrorsAndMessages();

		// ???????????
		super.pager = this.getBuyCommoditiesService().list(
				super.getLoginUsername(), super.pageSize, super.pageNo);

		// ?????????
		setSession(Constants.PAGER_BUYCOMMODITIES, super.pager);

		return Constants.LIST_KEY;

	}// end list()

	public String add() throws Exception {
		System.out.println("F2 add getParameter of oneId: "
				+ ServletActionContext.getRequest().getParameter("oneId"));

		if (ServletActionContext.getRequest().getParameter("from") != null
				&& ServletActionContext.getRequest().getParameter("from") != "") {
			if (ServletActionContext.getRequest().getParameter("from").indexOf(
					"buyCommodities") > -1) {
				ServletActionContext.getResponse().sendRedirect(
						"buyCartDeal!init.do");
			}
		}
		ServletActionContext.getRequest().setAttribute("oneId",
				ServletActionContext.getRequest().getParameter("oneId"));
		// ?????????
		clearErrorsAndMessages();

		// ?????????
		reset();
		return Constants.ADD_KEY;
	}// end add()

	private void reset() {
		setId(null);
		setPublishId(null);
		setCopyrightOrUsage(null);
		setAmount(null);
		setStartTime(null);
	}// end reset()

	// ?????��??
	private void bean2Form(BuyCommodities buyCommodities) {
		setId(buyCommodities.getId().toString());
		setPublishId(buyCommodities.getPublish().getId().toString());
		setCopyrightOrUsage(buyCommodities.getCopyrightOrUsage().toString());
		setAmount(buyCommodities.getAmount().toString());
		setStartTime(buyCommodities.getStartTime().toString());
	}// end bean2Form()

	public String edit() throws Exception {
		// ?????????
		clearErrorsAndMessages();

		// id???????????
		if (this.getId() == null) {
			saveActionError("buyCommodities.message.edit.notexist");
			return Constants.LIST_KEY;
		} else {
			// ???????
			BuyCommodities buyCommodities = this.getBuyCommoditiesService()
					.select(id);

			// ??????????????
			if (buyCommodities == null) {
				saveActionError("buyCommodities.message.edit.notexist");
				return Constants.LIST_KEY;
			} else {
				// ?????��??
				bean2Form(buyCommodities);
				return Constants.EDIT_KEY;
			}
		}// end if

	}// end edit()

	private String downId;

	public String getDownId() {
		return downId;
	}

	public void setDownId(String downId) {
		this.downId = downId;
	}

	private List<BuyCommodities> listBuyCommodities;

	public List<BuyCommodities> getListBuyCommodities() {
		return listBuyCommodities;
	}

	public void setListBuyCommodities(List<BuyCommodities> listBuyCommodities) {
		this.listBuyCommodities = listBuyCommodities;
	}
	public String downpublish() {
		ServletActionContext.getRequest().setAttribute("orderId",downId);
//		listBuyCommodities= this.getBuyCommoditiesService().findByCartDeal(downId);
//		ServletActionContext.getRequest().setAttribute("indexFlag", 6);// 上传文件
//		user=listBuyCommodities.get(0).getPublish().getUser();
		return "downpublish";
	}

	public String insert() throws Exception {
		// 
		clearErrorsAndMessages();
		String nid = null;

		try {

			//
			BuyCommodities buyCommodities = new BuyCommodities();
			buyCommodities.setPublish(this.getPublishService().select(
					Integer.parseInt(this.getPublishId())));

			buyCommodities.setCopyrightOrUsage(Integer.valueOf(this
					.getCopyrightOrUsage()));
			buyCommodities.setAmount(Integer.valueOf(this.getAmount()));
			buyCommodities.setStartTime(java.sql.Timestamp.valueOf(this
					.getStartTime()));
			String strOneId = ServletActionContext.getRequest().getParameter(
					"oneId");
			System.out.println("F2 insert getParameter  of oneId:" + strOneId);
			BuyCartDeal oneInstance = this.getBuyCartDealService().select(
					strOneId);
			buyCommodities.setBuyCartDeal(oneInstance);

			nid = this.getBuyCommoditiesService().insert(buyCommodities);

			// ?????????????
			Pager pagerSession = (Pager) getSession(Constants.PAGER_BUYCOMMODITIES);
			if (pagerSession == null) {
				// ??????????
				super.pageSize = Constants.pageSize;
				super.pageNo = Constants.pageNo;
			} else {
				super.pageSize = pagerSession.getPageSize();
				super.pageNo = pagerSession.getPageNo();

			}

			// ????????????
			super.pager = this.getBuyCommoditiesService().list(
					super.getLoginUsername(), super.pageSize, super.pageNo);

		} catch (Exception e) {
			saveActionError2(e.toString());
			saveActionMessage2(" Sorry ");
			return Constants.ERROR_KEY;
		}

		// ?????????
		if (nid != null) {
			saveActionMessage("buyCommodities.message.add.success");
			return Constants.LIST_KEY;
		} else {
			saveActionError("buyCommodities.message.add.failed");
			return Constants.ADD_KEY;
		}
	}// end insert()

	public String update() throws Exception {
		// 
		clearErrorsAndMessages();

		try {
			// 
			BuyCommodities buyCommodities = this.getBuyCommoditiesService()
					.select(new String(id));
			// buyCommodities.setPublish(publishInstance);
			buyCommodities.setPublish(this.getPublishService().select(
					Integer.parseInt(this.getPublishId())));

			buyCommodities.setCopyrightOrUsage(Integer.valueOf(this
					.getCopyrightOrUsage()));
			buyCommodities.setAmount(Integer.valueOf(this.getAmount()));
			buyCommodities.setStartTime(java.sql.Timestamp.valueOf(this
					.getStartTime()));
			this.getBuyCommoditiesService().update(buyCommodities);

			bean2Form(buyCommodities);

			// ?????????????
			Pager pagerSession = (Pager) getSession(Constants.PAGER_BUYCOMMODITIES);
			if (pagerSession == null) {
				// ??????????
				super.pageSize = Constants.pageSize;
				super.pageNo = Constants.pageNo;
			} else {
				super.pageSize = pagerSession.getPageSize();
				super.pageNo = pagerSession.getPageNo();

			}

			// ????????????
			super.pager = this.getBuyCommoditiesService().list(
					super.getLoginUsername(), super.pageSize, super.pageNo);
			saveActionMessage("buyCommodities.message.edit.success");
		} catch (Exception e) {
			saveActionError2(e.toString());
			saveActionMessage2(" Sorry ");
			return Constants.ERROR_KEY;
		}

		return Constants.LIST_KEY;
	}// end update()

	public String delete() throws Exception {
		// ?????????
		clearErrorsAndMessages();

		try {
			// id???????????
			if (this.getId() == null) {
				saveActionError("buyCommodities.message.edit.notexist");
			} else {
				// ??????
				this.getBuyCommoditiesService().delete(id);
				saveActionMessage("buyCommodities.message.delete.success");
			}

			// ???????????
			super.pager = this.getBuyCommoditiesService().list(
					super.getLoginUsername(), super.pageSize, super.pageNo);

		} catch (Exception e) {
			saveActionError2(e.toString());
			saveActionMessage2("Please delete child first");
			return Constants.ERROR_KEY;
		}
		return Constants.LIST_KEY;

	}// end delete()

	// ///getter////setter//////
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BuyCommoditiesService getBuyCommoditiesService() {
		return buyCommoditiesService;
	}

	public void setBuyCommoditiesService(
			BuyCommoditiesService buyCommoditiesService) {
		this.buyCommoditiesService = buyCommoditiesService;
	}

	public String getPublishId() {
		return publishId;
	}

	public void setPublishId(String publishId) {
		this.publishId = publishId;
	}

	public String getCopyrightOrUsage() {
		return copyrightOrUsage;
	}

	public void setCopyrightOrUsage(String copyrightOrUsage) {
		this.copyrightOrUsage = copyrightOrUsage;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	 
	
	 
	 public String buyPhoto(){
		 
	//	 publishService
		 
		 
		 
		 
		 
		 
		 return "buyPhoto";
	 }
	 
	 
	 

          public String buyRecordAdmin(){
        	  
        	 String username= super.getLoginUsername();
        	 if(username==null){
        		  return "login";
        		 
        	 }
        	  if(!username.equals("super1")){
        		  return "login";
        		  
        		  
        	  }
        	  
        	  
        	  
        	  Pager pager=  buyCommoditiesService.list(pageSize, nowPage);
        	  List<BuyCommodities> buyCommodities1=( List<BuyCommodities>)pager.getResultList();
        	  List<CountDeal> newlist= new ArrayList<CountDeal>();
        	 for (BuyCommodities buyCommodities :buyCommodities1) {
        		 BuyCartDeal buyCartDeal=buyCartDealService.select(buyCommodities.getBuyCartDeal().getId());
        		// System.out.println(buyCartDeal.getUser());
        		 User buyUser=userService.selectById(buyCartDeal.getUser().getId());		 
        		 CountDeal countDeal=new CountDeal();
        		 countDeal.setDeliveUser(buyCommodities.getPublish().getUser());
        		 countDeal.setDealTime(Cleandar.getTime(buyCommodities.getStartTime()));
        		 countDeal.setBuyUser(buyUser);
        		 Publish publish=new Publish();
        		 publish.setId(buyCommodities.getPublish().getId());
        		 String pictype=buyCommodities.getPublish().getPicNumber();
        		 publish.setPicNumber(pictype);
        		 
        		 
        		 
        		 
        		 if(pictype.contains("cg")){
        			 publish.setPicMode("创意图片");
        		 }else{
        			 publish.setPicMode("摄影图片"); 
        		 }
        		
        		 int buytype= buyCommodities.getCopyrightOrUsage();
        		 if(buytype==0){
        			 countDeal.setType("购买使用权");	
        			 countDeal.setMoney(buyCommodities.getUsgeTotalPrice());
        			 
        		 }else if(buytype==1){
        			 countDeal.setType("购买版权");
        			 countDeal.setMoney(buyCommodities.getCopyrighTotalPrice());
        			 
        		 }
        		 else if(buytype==2){
        			 countDeal.setType("购买使用权和版权");
        			 countDeal.setMoney(buyCommodities.getCopyAndUsePrice());
        			 
        		 }
        		 int count=buyCommoditiesService.getbuyCount(buyCommodities.getStartTime()+"".trim());
        		 
        		 countDeal.setBuyCount(count);
        			 //
        		 
        		 
        		 countDeal.setPublics(publish);
        		 newlist.add(countDeal);
			}
        	 pager.setResultList(newlist);
        	super.pager=pager;
        	return "buyRecordAdmin";
          }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}// end class

