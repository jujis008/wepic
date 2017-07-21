package com.wetuo.wepic.deal.actions ;

import java.sql.Timestamp;
import java.util.Date;

import com.wetuo.wepic.common.struts.PageAction;
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.core.service.ContactService;
import com.wetuo.wepic.core.service.MessageService;
import com.wetuo.wepic.core.service.UserCreditService;
import com.wetuo.wepic.core.service.UserService;
import com.wetuo.wepic.deal.beans.Bid;
import com.wetuo.wepic.deal.beans.BidResponseInvited;
import com.wetuo.wepic.deal.service.BidForOpusService;
import com.wetuo.wepic.deal.service.BidResponseInvitedService;
import com.wetuo.wepic.deal.service.BidService;
import com.wetuo.wepic.deal.service.BidtransactionService;

public class BidResponseInvitedAction extends PageAction {
	
	
	public BidResponseInvitedAction(String className) {
		try {
			model=Class.forName(className).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	//向发布人申请参加约拍
	public String customerApplayForBid(){
		int id=super.getLonginUserId();
		if(id==0){
			return "login";
		}
	  
	  User user=new User();
	  user.setId(id);
	  Bid bid=bidService.select(bidId);
	  if(bid.getUser().getId()==id){
		  msg="1";
		 return "customerApplayForBid"; 
	  }
	 // bid.setId(bidId);
	  BidResponseInvited bidResponseInvited=new BidResponseInvited();
	  bidResponseInvited.setBid(bid);
	  bidResponseInvited.setUser(user);
	  bidResponseInvited.setIsInvited(0);
	  bidResponseInvited.setReponseTime(new Timestamp(new Date().getTime()));
	  bidResponseInvited.setTaskFinished(0);
	  bidResponseInvitedService.insert(bidResponseInvited);
	  return "customerApplayForBid";
	}
	
	public String toSTSring(){
		
		
		
		
		
		return "abc";
	}
	
	public String mytest() {
		return "abc";
	}
	
	
	
	
	
	
	
	
	
	
	
	

	private BidService bidService;
	private BidForOpusService bidForOpusService;
	private MessageService messageService;
	
	private UserCreditService creditService;
	private ContactService contactService;
	private String bidId;
	private String msg;//发布和应约为同一人2//应约失败3//未登录4
	private BidtransactionService bidtransaction;	
 	private BidResponseInvitedService bidResponseInvitedService;
 	private UserService userService;
	public BidService getBidService() {
		return bidService;
	}
	public void setBidService(BidService bidService) {
		this.bidService = bidService;
	}
	public BidForOpusService getBidForOpusService() {
		return bidForOpusService;
	}
	public void setBidForOpusService(BidForOpusService bidForOpusService) {
		this.bidForOpusService = bidForOpusService;
	}
	public MessageService getMessageService() {
		return messageService;
	}
	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}
	public UserCreditService getCreditService() {
		return creditService;
	}
	public void setCreditService(UserCreditService creditService) {
		this.creditService = creditService;
	}
	public ContactService getContactService() {
		return contactService;
	}
	public void setContactService(ContactService contactService) {
		this.contactService = contactService;
	}
	public BidtransactionService getBidtransaction() {
		return bidtransaction;
	}
	public void setBidtransaction(BidtransactionService bidtransaction) {
		this.bidtransaction = bidtransaction;
	}
	public BidResponseInvitedService getBidResponseInvitedService() {
		return bidResponseInvitedService;
	}
	public void setBidResponseInvitedService(
			BidResponseInvitedService bidResponseInvitedService) {
		this.bidResponseInvitedService = bidResponseInvitedService;
	}


	public String getBidId() {
		return bidId;
	}


	public void setBidId(String bidId) {
		this.bidId = bidId;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public UserService getUserService() {
		return userService;
	}


	public void setUserService(UserService userService) {
		this.userService = userService;
	}
 	
 	
 
	
	
}
