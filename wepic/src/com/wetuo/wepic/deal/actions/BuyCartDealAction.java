package com.wetuo.wepic.deal.actions ;
 
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.io.File;
import java.math.BigDecimal;
import java.util.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import com.tools.*;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;
import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;
import com.wetuo.wepic.deal.beans.Bid;
import com.wetuo.wepic.deal.beans.BuyCartDeal;
import com.wetuo.wepic.deal.beans.BuyCommodities;
import com.wetuo.wepic.deal.service.BuyCartDealService;
import com.wetuo.wepic.deal.service.BuyCommoditiesService;
import com.wetuo.wepic.publish.beans.Publish;
import com.wetuo.wepic.publish.service.PublishService;
import com.wetuo.wepic.core.beans.Account;
import com.wetuo.wepic.core.beans.Bill;
import com.wetuo.wepic.core.beans.SiteConfig;
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.core.service.AccountService;
import com.wetuo.wepic.core.service.BillService;
import com.wetuo.wepic.core.service.SiteConfigService;
import com.wetuo.wepic.core.service.UserService;
 
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.struts.PageAction;
import com.wetuo.wepic.common.struts.Constants;
import com.wetuo.wepic.common.struts.RegExpression;
import com.wetuo.wepic.common.util.BuyCart;
import com.wetuo.wepic.common.util.GengerateExchangeCode;
import com.wetuo.wepic.common.util.Goods;
import com.wetuo.wepic.common.util.MailSend;
import com.sun.org.apache.bcel.internal.generic.NEW;

import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;
 
 
public class BuyCartDealAction extends PageAction {
 
 
	/////instantce variable//////
	private static final long serialVersionUID = 1L;
	protected String id = null ; 
	protected String publishId=null;
 	private BuyCartDealService buyCartDealService;
	protected String userId = null ;
	private UserService userService;
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	protected String totalMoney = null ; 
	protected String dealCode = null ; 
	protected String status = null ; 
	protected String deliveryTime = null ; 
	protected String invoiceHead = null ; 
	protected String invoiceType = null ; 
	protected String invoiceContent = null ; 
	protected String buyerAssess = null ; 
	protected String username = null; 
	protected BuyCommodities buyCommodities;
	protected BuyCommoditiesService buyCommoditiesService;
	protected PublishService publishService;
	protected AccountService accountService;
	protected SiteConfigService siteConfigService;
	private String trademsg=null;
	private Integer flag=0;
	private Integer validateLogin=0;
	private Publish publish;
	private BuyCartDeal buyCartDeal;
	private Account account;
	 private String type; //发票类别
     private String billdType; //开具发票的项目类别 1是约拍2是图片买卖
 	private BuyCartDeal deal_; //发票对应的图片交易
	private String bidid; //发票对应的约拍
	private String billhead; //发票抬头
	private String billContext; //发票内容
	private String billreceiver;//发票收件人
	private String billaddress;  //发票寄送地址
	private String billTel; //联系电话
	private String detail1;  //公司名称
	private BillService billService;
	private String postCode;
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Publish getPublish() {
		return publish;
	}
	public void setPublish(Publish publish) {
		this.publish = publish;
	}
	
	
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	//???????????��????
	public void validate() {
		
		// ?????????
		clearErrorsAndMessages();
		
		// ??????????
		String queryString = getRequestPath();
		if (queryString.indexOf("buyCartDealadd!insert") != -1 || queryString.indexOf("buyCartDealedit!update") != -1) {
		
			if (userId == null || userId.equals("")) {
				addFieldError("userId", "userId must be inputed");
			}//end if null
			if (totalMoney == null || totalMoney.equals("")) {
				addFieldError("totalMoney", "totalMoney must be inputed");
			}//end if null
			if (dealCode == null || dealCode.equals("")) {
				addFieldError("dealCode", "dealCode must be inputed");
			}//end if null
			if (status == null || status.equals("")) {
				addFieldError("status", "status must be inputed");
			}//end if null
			if (deliveryTime == null || deliveryTime.equals("")) {
				addFieldError("deliveryTime", "deliveryTime must be inputed");
			}//end if null
			if (invoiceHead == null || invoiceHead.equals("")) {
				addFieldError("invoiceHead", "invoiceHead must be inputed");
			}//end if null
			if (invoiceType == null || invoiceType.equals("")) {
				addFieldError("invoiceType", "invoiceType must be inputed");
			}//end if null
			if (invoiceContent == null || invoiceContent.equals("")) {
				addFieldError("invoiceContent", "invoiceContent must be inputed");
			}//end if null
			if (buyerAssess == null || buyerAssess.equals("")) {
				addFieldError("buyerAssess", "buyerAssess must be inputed");
			}//end if null
				// ??????? 
				// ??????? 
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
		super.pager = this.getBuyCartDealService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		
		// ?????????
		setSession(Constants.PAGER_BUYCARTDEAL, super.pager);
		
		return Constants.LIST_KEY;
		
	}//end init()
		
	public String list() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// ???????????
		super.pager = this.getBuyCartDealService().list(super.getLoginUsername(), super.pageSize, super.pageNo);	
		
		// ?????????
		setSession(Constants.PAGER_BUYCARTDEAL, super.pager);
		
		return Constants.LIST_KEY;
		
	}//end list()
		
	public String add() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		
		// ?????????
		reset();
		return Constants.ADD_KEY;
	}//end add()
	private void reset() {
		setId(null);
		setUserId(null);
		setTotalMoney(null);
		setDealCode(null);
		setStatus(null);
		setDeliveryTime(null);
		setInvoiceHead(null);
		setInvoiceType(null);
		setInvoiceContent(null);
		setBuyerAssess(null);
	}//end reset()
		// ?????��??
	private void bean2Form(BuyCartDeal buyCartDeal) {
		setId(buyCartDeal.getId().toString());
		setUserId(buyCartDeal.getUser().getId().toString());
		setTotalMoney(new Double(buyCartDeal.getTotalMoney()).toString());
		setDealCode(buyCartDeal.getDealCode());
		setStatus(buyCartDeal.getStatus().toString()      );
		setDeliveryTime(buyCartDeal.getDeliveryTime().toString()      );
		setInvoiceHead(buyCartDeal.getInvoiceHead());
		setInvoiceType(buyCartDeal.getInvoiceType().toString()      );
		setInvoiceContent(buyCartDeal.getInvoiceContent());
		setBuyerAssess(buyCartDeal.getBuyerAssess());
	}//end bean2Form()
	public String edit() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// id???????????
		if (this.getId() == null) {
			saveActionError("buyCartDeal.message.edit.notexist");
			return Constants.LIST_KEY;
		} else {
			// ???????
			BuyCartDeal buyCartDeal = this.getBuyCartDealService().select(id); 
			
			// ??????????????
			if (buyCartDeal == null) {
				saveActionError("buyCartDeal.message.edit.notexist");
				return Constants.LIST_KEY;
			} else {
				// ?????��??
				bean2Form(buyCartDeal);
				return Constants.EDIT_KEY;
			}
		}//end if
		
	}//end edit()
	/**
	 * 添加到购物车
	 * @return
	 * @throws Exception
	 */
	public String addShopCart() throws Exception {
		int choice=Integer.valueOf(ServletActionContext.getRequest().getParameter("mychoice"));
		Publish publish=this.getPublishService().select(Integer.valueOf(getPublishId()));
		if (publish==null) {
			this.publish=null;
		}else {
			this.publish=publish;
		}
		BuyCart buyCart=(BuyCart)ActionContext.getContext().getSession().get("cart");
		if (buyCart==null) {
			buyCart=new BuyCart();
		}
		BuyCommodities buyCommodities=new BuyCommodities();
		buyCommodities.setAmount(1);
		buyCommodities.setPublish(publish);
		buyCommodities.setStartTime(getcurrent());
		if (publish.getCopyright()==0) {
			buyCommodities.setCopyrightOrUsage(0);
		}if(publish.getCopyright()==1){
			buyCommodities.setCopyrightOrUsage(1);
		}if (publish.getCopyright()==2) {
			buyCommodities.setCopyrightOrUsage(choice);
		}
		buyCart.add(buyCommodities);
		ActionContext.getContext().getSession().put("cart",buyCart);
		return "shopsuc";
		}
	/**
	 * 查看购物车
	 * @return
	 */
	public String checkCart() {
		BuyCart buyCart=(BuyCart)ActionContext.getContext().getSession().get("cart");
		ActionContext.getContext().getSession().put("cart",buyCart);
		return "shopsuc";
	}
	/**
	 * 删除购物车中的商品
	 * @return
	 * @throws Exception
	 */
	public String delCart()throws Exception {
		BuyCart buyCart=(BuyCart)ActionContext.getContext().getSession().get("cart");
		String id=this.getId();
		buyCart.del(id);
		return "shopsuc";
	}
	public String delconfrimorder()throws Exception {
		BuyCart buyCart=(BuyCart)ActionContext.getContext().getSession().get("cart");
		String id=this.getId();
		buyCart.del(id);
		return "confrimorder";
	}
	public String delconfirmmoney()throws Exception {
		BuyCart buyCart=(BuyCart)ActionContext.getContext().getSession().get("cart");
		String id=this.getId();
		buyCart.del(id);
		return "confirmmoney";
	}
	
	
	/**
	 * 查看购物车中是否存在此图片，如果存在，提示，已经存在，无须再次购买，否则，购买
	 * @return
	 * @throws Exception
	 */
	@JSON(serialize=false)
	public String myTradeExist()throws Exception {
		if (ActionContext.getContext().getSession().get("cart")==null) {
			flag=0;
		}else {
			BuyCart buyCart=(BuyCart)ActionContext.getContext().getSession().get("cart");
			if (buyCart.getShopCartMap().keySet().contains(getPublishId())) {
				this.flag=1;
			}else {
				flag=0;
			}
		}
		return "myTradeExist";
		}
	public String confirmorder() {
		String loginName = super.getLoginUsername();
		if(loginName == null || loginName.length()==0)
		{
			return "login";
		}else {
		User user=this.getUserService().select(loginName);
		this.username=user.getUsername();
		GengerateExchangeCode code=new GengerateExchangeCode();
		String dealCode=code.getExchangeCode().toString();
		BuyCart buyCart=(BuyCart)ActionContext.getContext().getSession().get("cart");
		BuyCartDeal buyCartDeal=new BuyCartDeal();
		buyCartDeal.setUser(user);
		buyCartDeal.setTotalMoney(buyCart.getTotalPrice());
		buyCartDeal.setStatus(1);
		buyCartDeal.setDealCode(dealCode);
		buyCartDeal.setDeliveryTime(getcurrent());
		buyCartDeal.setGoodsNum(buyCart.getTotal());
		String res=this.getBuyCartDealService().insert(buyCartDeal);
		this.buyCartDeal=this.getBuyCartDealService().select(res);
		Account account=this.getAccountService().select(user.getId(), "a");
		this.account=account;
		return "confirmorder";
		}
	}
	@SuppressWarnings("static-access")
	public Timestamp getcurrent() {
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String a=df.format(new Date());
		Timestamp ts = new Timestamp(System.currentTimeMillis());  
		ts.valueOf(a);
		return ts;
	}
	@JSON(serialize=false)
	public String updateStatu() throws Exception {
		
		
		
		
		
		
		String loginName = super.getLoginUsername();
		if(loginName == null || loginName.length()==0)
		{
			return "login";
		}else {
		User user=this.getUserService().select(loginName);
		BuyCart buyCart=(BuyCart)ActionContext.getContext().getSession().get("cart");
		String id=this.id;
		buyCartDeal=this.getBuyCartDealService().select(id);
		trademsg=this.getBuyCartDealService().dealBusiness(buyCart,user,buyCartDeal);
		id=buyCartDeal.getId();
		if(!trademsg.equals("not")){
		if(billaddress!=null&&billaddress.trim()!=""){
		 Bill bill=new Bill();
		 bill.setBilldType("2");
		 bill.setType("1");
		 bill.setDeal(buyCartDeal);
		 bill.setBilladdress(billaddress);
		 bill.setBillContext(billContext);
		 bill.setBillhead(billhead);
		 bill.setUser_(user);
		 bill.setDetail1(detail1);//单位
		 bill.setStauts("0");
		 String subTime=Cleandar.getTime(new Date());
		 bill.setBillSubTime(subTime);
		 bill.setBillreceiver(billreceiver);
		 bill.setBillTel(billTel);
		 bill.setMoney(buyCartDeal.getTotalMoney());
		 bill.setPostCode(postCode);
		 billService.saveBill(bill);
		}
		}
		}
		return "updateStatu";
	}
	
	public String tradesuc() throws Exception {
		String loginName = super.getLoginUsername();
		User user=this.getUserService().select(loginName);
		BuyCartDeal buyCartDeal1=this.getBuyCartDealService().currentDeal(user);
		buyCartDeal=buyCartDeal1;
		username=user.getUsername();
		return "tradesuc";
	}
	public String insert() throws Exception {
		// 
		clearErrorsAndMessages();
		String nid = null ;
		
		try{
			
		//
		BuyCartDeal buyCartDeal = new BuyCartDeal();
			buyCartDeal.setUser(this.getUserService().selectById(Integer.parseInt(this.getUserId()))); 
			
		buyCartDeal.setTotalMoney(Double.valueOf(this.getTotalMoney() ));
		buyCartDeal.setDealCode(this.getDealCode());
		buyCartDeal.setStatus(Integer.valueOf(this.getStatus() ));
		buyCartDeal.setDeliveryTime(java.sql.Timestamp.valueOf(this.getDeliveryTime() ));
		buyCartDeal.setInvoiceHead(this.getInvoiceHead());
		buyCartDeal.setInvoiceType(Integer.valueOf(this.getInvoiceType() ));
		buyCartDeal.setInvoiceContent(this.getInvoiceContent());
		buyCartDeal.setBuyerAssess(this.getBuyerAssess());
		nid = this.getBuyCartDealService().insert(buyCartDeal);
		
		// ?????????????
		Pager pagerSession = (Pager) getSession(Constants.PAGER_BUYCARTDEAL);
		if(pagerSession == null){
			//??????????
			super.pageSize = Constants.pageSize;
			super.pageNo = Constants.pageNo;
		}else{
			super.pageSize = pagerSession.getPageSize();
			super.pageNo = pagerSession.getPageNo();
			
		}
		
		//????????????
		super.pager = this.getBuyCartDealService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		
		
		}catch(Exception e){
			saveActionError2(e.toString());
			saveActionMessage2(" Sorry ");
			return Constants.ERROR_KEY;
		}
		
		// ?????????
		if (nid != null) {
			saveActionMessage("buyCartDeal.message.add.success");
			return Constants.LIST_KEY;
		} else {
			saveActionError("buyCartDeal.message.add.failed");
			return Constants.ADD_KEY;
		}
	}//end insert()
	public String update() throws Exception {
		// 
		clearErrorsAndMessages();
		
		try{
			// 
			BuyCartDeal buyCartDeal = this.getBuyCartDealService().select(new String(id));
//			buyCartDeal.setUser(userInstance);    
			buyCartDeal.setUser(this.getUserService().selectById(Integer.parseInt(this.getUserId()))); 
			
			buyCartDeal.setTotalMoney(Double.valueOf(this.getTotalMoney() ));
			buyCartDeal.setDealCode(this.getDealCode());
			buyCartDeal.setStatus(Integer.valueOf(this.getStatus() ));
			buyCartDeal.setDeliveryTime(java.sql.Timestamp.valueOf(this.getDeliveryTime() ));
			buyCartDeal.setInvoiceHead(this.getInvoiceHead());
			buyCartDeal.setInvoiceType(Integer.valueOf(this.getInvoiceType() ));
			buyCartDeal.setInvoiceContent(this.getInvoiceContent());
			buyCartDeal.setBuyerAssess(this.getBuyerAssess());
		this.getBuyCartDealService().update(buyCartDeal);
		
		bean2Form(buyCartDeal);	
		
		// ?????????????
		Pager pagerSession = (Pager) getSession(Constants.PAGER_BUYCARTDEAL);
		if(pagerSession == null){
			//??????????
			super.pageSize = Constants.pageSize;
			super.pageNo = Constants.pageNo;
		}else{
			super.pageSize = pagerSession.getPageSize();
			super.pageNo = pagerSession.getPageNo();
			
		}
		
			// ????????????
			super.pager = this.getBuyCartDealService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
			saveActionMessage("buyCartDeal.message.edit.success");
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
				saveActionError("buyCartDeal.message.edit.notexist");
			} else {
				// ??????
				this.getBuyCartDealService().delete(id);
				saveActionMessage("buyCartDeal.message.delete.success");
			}
			
			// ???????????
			super.pager = this.getBuyCartDealService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
			
		}catch(Exception e){
			saveActionError2(e.toString());
			saveActionMessage2("Please delete child first");
			return Constants.ERROR_KEY;
		}
		return Constants.LIST_KEY;
		
	}//end delete()
	//负责转发的确认订单页面	
 public String sendToJsp(){
	 
	 
	 
	return  "sendToJsp";
 }
	/////getter////setter//////
	public String getId(){
		return  id;
	}
	public void  setId(String id){
		this.id = id ;
	}
	 
	public String getPublishId() {
		return publishId;
	}
	public void setPublishId(String publishId) {
		this.publishId = publishId;
	}
	public BuyCartDealService getBuyCartDealService() {
		return buyCartDealService;
	}
	public void setBuyCartDealService(BuyCartDealService buyCartDealService) {
		this.buyCartDealService = buyCartDealService;
	}
	
	public String getUserId(){
		return  userId;
	}
	public void  setUserId(String userId){
		this.userId = userId ;
	}
	 
	public String getTotalMoney(){
		return  totalMoney;
	}
	public void  setTotalMoney(String totalMoney){
		this.totalMoney = totalMoney ;
	}
	 
	public String getDealCode(){
		return  dealCode;
	}
	public void  setDealCode(String dealCode){
		this.dealCode = dealCode ;
	}
	 
	public String getStatus(){
		return  status;
	}
	public void  setStatus(String status){
		this.status = status ;
	}
	 
	public String getDeliveryTime(){
		return  deliveryTime;
	}
	public void  setDeliveryTime(String deliveryTime){
		this.deliveryTime = deliveryTime ;
	}
	 
	public String getInvoiceHead(){
		return  invoiceHead;
	}
	public void  setInvoiceHead(String invoiceHead){
		this.invoiceHead = invoiceHead ;
	}
	 
	public String getInvoiceType(){
		return  invoiceType;
	}
	public void  setInvoiceType(String invoiceType){
		this.invoiceType = invoiceType ;
	}
	 
	public String getInvoiceContent(){
		return  invoiceContent;
	}
	public void  setInvoiceContent(String invoiceContent){
		this.invoiceContent = invoiceContent ;
	}
	 
	public String getBuyerAssess(){
		return  buyerAssess;
	}
	public void  setBuyerAssess(String buyerAssess){
		this.buyerAssess = buyerAssess ;
	}
	 
	 public String getUsername() {
	 	return username;
	 }
	 public void setUsername(String username) {
	 	this.username = username;
	 }
	public BuyCommodities getBuyCommodities() {
		return buyCommodities;
	}
	public void setBuyCommodities(BuyCommodities buyCommodities) {
		this.buyCommodities = buyCommodities;
	}
	public BuyCommoditiesService getBuyCommoditiesService() {
		return buyCommoditiesService;
	}
	public void setBuyCommoditiesService(BuyCommoditiesService buyCommoditiesService) {
		this.buyCommoditiesService = buyCommoditiesService;
	}
	public PublishService getPublishService() {
		return publishService;
	}
	public void setPublishService(PublishService publishService) {
		this.publishService = publishService;
	}
	public AccountService getAccountService() {
		return accountService;
	}
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}
	public String getTrademsg() {
		return trademsg;
	}
	public void setTrademsg(String trademsg) {
		this.trademsg = trademsg;
	}
	public SiteConfigService getSiteConfigService() {
		return siteConfigService;
	}
	public void setSiteConfigService(SiteConfigService siteConfigService) {
		this.siteConfigService = siteConfigService;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public Integer getValidateLogin() {
		return validateLogin;
	}
	public void setValidateLogin(Integer validateLogin) {
		this.validateLogin = validateLogin;
	}
	public BuyCartDeal getBuyCartDeal() {
		return buyCartDeal;
	}
	public void setBuyCartDeal(BuyCartDeal buyCartDeal) {
		this.buyCartDeal = buyCartDeal;
	}
	public static void main(String[] args) {
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBilldType() {
		return billdType;
	}
	public void setBilldType(String billdType) {
		this.billdType = billdType;
	}
	public BuyCartDeal getDeal_() {
		return deal_;
	}
	public void setDeal_(BuyCartDeal deal) {
		deal_ = deal;
	}
	public String getBidid() {
		return bidid;
	}
	public void setBidid(String bidid) {
		this.bidid = bidid;
	}
	public String getBillhead() {
		return billhead;
	}
	public void setBillhead(String billhead) {
		this.billhead = billhead;
	}
	public String getBillContext() {
		return billContext;
	}
	public void setBillContext(String billContext) {
		this.billContext = billContext;
	}
	public String getBillreceiver() {
		return billreceiver;
	}
	public void setBillreceiver(String billreceiver) {
		this.billreceiver = billreceiver;
	}
	public String getBilladdress() {
		return billaddress;
	}
	public void setBilladdress(String billaddress) {
		this.billaddress = billaddress;
	}
	public String getBillTel() {
		return billTel;
	}
	public void setBillTel(String billTel) {
		this.billTel = billTel;
	}
	public String getDetail1() {
		return detail1;
	}
	public void setDetail1(String detail1) {
		this.detail1 = detail1;
	}
	public BillService getBillService() {
		return billService;
	}
	public void setBillService(BillService billService) {
		this.billService = billService;
	}
	 
}//end class
