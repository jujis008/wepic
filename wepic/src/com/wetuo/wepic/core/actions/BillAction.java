package com.wetuo.wepic.core.actions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.components.ActionError;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.struts.PageAction;
import com.wetuo.wepic.core.beans.Bill;
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.core.service.BillService;
import com.wetuo.wepic.core.service.UserService;
import com.wetuo.wepic.deal.beans.Bid;
import com.wetuo.wepic.deal.beans.BuyCartDeal;
import com.wetuo.wepic.deal.service.BidService;
import com.wetuo.wepic.deal.service.BuyCartDealService;
import com.tools.Cleandar;
public class BillAction extends PageAction {
	private static final long serialVersionUID = 1L;
	private UserService userService;
    private BidService bidService;
    private BillService billService;
    private BuyCartDealService buyCartDealService;
    private int id;
    private String type; //发票类别
	private String billdType; //开具发票的项目类别 1是约拍2是图片买卖
	private User user_; //开具发票的用户
	private BuyCartDeal deal_; //发票对应的图片交易
	private String bidid; //发票对应的约拍
	private String billhead; //发票抬头
	private String billContext; //发票内容
	private String billreceiver;//发票收件人
	private String billaddress;  //发票寄送地址
	private String billTel; //联系电话
	private String stauts; //0新发票1是以查看2是以打印
	private String detail1; //发票保留字段
	private String detail2;//发票保留字段
	private String billSubTime; //发票提交时间
	private String billKaipiao; //开票时间
	private User billWho;//开具发票的管理员
	private Bill bill;
	private int nowPage;
	private int pageSize=15;
	private List<Bill> bills ;
	private String postCode;
	

	 public String saveBillByBid(){
		 if(billreceiver==null||billreceiver.trim().length()<=0){
			
			 super.addActionError("发票收件人不能为空");
			 return "input";
			 
		 }
		  if(billaddress==null||billaddress.trim().length()<=0){
			  super.addActionError("发票收件人地址不能为空");
			 return "input";
			 
			 
		 }
		  if(billTel==null||billTel.trim().length()<=0){
			  super.addActionError("发票收件人联系方式不能为空");
			 return "input";
			 
			 
		 }
		  
		  if(postCode==null||postCode.trim().length()<=0){
			  super.addActionError("发票收件人邮编不能为空");
				 return "input";
				 
				 
			 }
		 
		 Bill bill=new Bill();
		 bill.setBilldType("1");
		 bill.setType("1");
		 bill.setBilladdress(billaddress);
		 Bid bid=bidService.select(bidid);
		 bill.setBid(bid);
		 bill.setPostCode(postCode);
		 bill.setBillContext(billContext);
		 bill.setBillhead(billhead);
		 User user=userService.select(super.getLoginUsername());
		 bill.setUser_(user);
		 bill.setStauts("0");
		 bill.setMoney(bid.getTotalMoney());
		 bill.setBillreceiver(billreceiver);
		 bill.setBillTel(billTel);
		 bill.setBillSubTime(Cleandar.getTime(new Date()));
		 bill.setDetail1(detail1);
		 if(!billService.saveBill(bill)){
			 
			return "error"; 
		 }
		 
		 bid.setStatus(6);
		 bidService.update(bid);
		 
		 
		 
		return "saveBillByBid";
	 }
		
	public String findbyId(){
	 bill=billService.findByid(id);
		return "findbyId";
	}

	public String billShowbybidId(){
		
		 DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Bill.class);
		 detachedCriteria.createAlias("bid", "bid0");
		 detachedCriteria.add(Restrictions.eq("bid0.id", bidid));
		 bills=billService.findall(detachedCriteria); 
		 return "billShowbyId";
		}
	
	public String billShowbydealId(){
		
		 DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Bill.class);
		 detachedCriteria.createAlias("deal", "deal0");
		 detachedCriteria.add(Restrictions.eq("deal0.id", bidid));
		 
		 List<Bill> bills1=billService.findall(detachedCriteria); 
		 bills=new ArrayList<Bill>();
		 for (Bill bill : bills1) {
			 BuyCartDeal buyCartDeal=new BuyCartDeal();
			 buyCartDeal.setId(bill.getDeal().getId());
			 bill.setDeal(buyCartDeal);
			 bills.add(bill);
			
		}
		
		
		return "billShowbyId";
	}
	
	public String findByPage(){
		
	 DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Bill.class);
	
	 super.pager=billService.listByPage(detachedCriteria, nowPage, pageSize);
	
     return "findByPage";
	}
	
	public String dealBill(){
		Bill bill= billService.findByid(id);
		bill.setStauts("2");
		billService.updateBill(bill);
		return findByPage();
		
		
		
		
	}
	
	
	
	
	
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public BidService getBidService() {
		return bidService;
	}

	public void setBidService(BidService bidService) {
		this.bidService = bidService;
	}

	public BuyCartDealService getBuyCartDealService() {
		return buyCartDealService;
	}

	public void setBuyCartDealService(BuyCartDealService buyCartDealService) {
		this.buyCartDealService = buyCartDealService;
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

	public User getUser_() {
		return user_;
	}

	public void setUser_(User user) {
		user_ = user;
	}

	public BuyCartDeal getDeal_() {
		return deal_;
	}

	public void setDeal_(BuyCartDeal deal) {
		deal_ = deal;
	}

	

	public BillService getBillService() {
		return billService;
	}

	public void setBillService(BillService billService) {
		this.billService = billService;
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

	public String getStauts() {
		return stauts;
	}

	public void setStauts(String stauts) {
		this.stauts = stauts;
	}

	public String getDetail1() {
		return detail1;
	}

	public void setDetail1(String detail1) {
		this.detail1 = detail1;
	}

	public String getDetail2() {
		return detail2;
	}

	public void setDetail2(String detail2) {
		this.detail2 = detail2;
	}

	public String getBillSubTime() {
		return billSubTime;
	}

	public void setBillSubTime(String billSubTime) {
		this.billSubTime = billSubTime;
	}

	public String getBillKaipiao() {
		return billKaipiao;
	}

	public void setBillKaipiao(String billKaipiao) {
		this.billKaipiao = billKaipiao;
	}

	public User getBillWho() {
		return billWho;
	}

	public void setBillWho(User billWho) {
		this.billWho = billWho;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public List<Bill> getBills() {
		return bills;
	}

	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	
	
	
	
	
}
