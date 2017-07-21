package com.wetuo.wepic.deal.actions ;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.apache.cxf.wsdl.http.UrlEncoded;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

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

public class BidResponseInvitedNewAction extends PageAction {
	
	
	public BidResponseInvitedNewAction(String className) {
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
		url=url.substring(url.lastIndexOf("/")+1,url.length());
			return "login";
		}
	  
	  User user=new User();
	  user.setId(id);
	  Bid bid=bidService.select(bidId);
	  if(bid.getUser().getId()==id){
		  msg="1";
		 return "customerApplayForBid"; 
	  }
	  msg=bidResponseInvitedService.customerApplayForBid(user, bidId);
	  return "customerApplayForBid";
	}
	
	//查看我的邀请记录
	
	public String isInvitedForMyBid(){
		int id=super.getLonginUserId();
		if(id==0){
		url=url.substring(url.lastIndexOf("/")+1,url.length());
			return "login";
		}
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(BidResponseInvited.class);
	    detachedCriteria.createAlias("bid", "bid");
	    detachedCriteria.add(Restrictions.eq("bid.id", ((BidResponseInvited)model).getId()));
	    detachedCriteria.add(Restrictions.eq("isInvited", 1));
	    bidId=((BidResponseInvited)model).getId();
	    if(flag.equals("2")){
	     detachedCriteria.add(Restrictions.eq("isResponse", 1));
	     url="responseInvitednew!isInvitedForMyBid.do?id="+bidId+"&flag=2";
	    }else if (flag.equals("3")){
	     detachedCriteria.add(Restrictions.eq("isResponse", 0));
	     url="responseInvitednew!isInvitedForMyBid.do?id="+bidId+"&flag=3";
		}
	    super.pager=bidResponseInvitedService.findByDetachedCriteria(detachedCriteria,nowPage,pageSize);
	    List<BidResponseInvited> bidResponseInviteds=( List<BidResponseInvited>)super.pager.getResultList();
	    
	
	    for (BidResponseInvited bidResponseInvited : bidResponseInviteds) {
	        User user=bidResponseInvited.getUser();
	    	if(user.getWorkPlace()!=null&&user.getWorkPlace()!=""){
	    	 String work=user.getWorkPlace();
	    	 String w=work.substring(0,work.lastIndexOf(" "));
	    	 user.setWorkPlace(w);
	    	// bidResponseInvited.setIsCheck(1);
	    	 //bidResponseInvitedService.update(bidResponseInvited);
	    	}
			
		}
		return "isInvitedForMyBid";
	}
	
	
	
	
	
	//查看我的约拍的应约记录findlistApplyBid
	public String findlistApplyBid(){
		int id=super.getLonginUserId();
		if(id==0){
		//url=url.substring(url.lastIndexOf("/")+1,url.length());
			return "login";
		}
		
		     DetachedCriteria detachedCriteria=DetachedCriteria.forClass(BidResponseInvited.class);
		     detachedCriteria.createAlias("bid", "bid");
		    // detachedCriteria.createAlias("user", "user");
		      detachedCriteria.add(Restrictions.eq("bid.id", ((BidResponseInvited)model).getId()));
		      bidId=((BidResponseInvited)model).getId();
		      if(flag.equals("1")){
		       url="responseInvitednew!findlistApplyBid.do?id="+bidId+"&flag=1";
		       detachedCriteria.add(Restrictions.eq("isResponse", 1));
		       detachedCriteria.add(Restrictions.eq("isCheck", 0));
		       super.pager=bidResponseInvitedService.findapplyBid(detachedCriteria,nowPage,pageSize);
		       List<BidResponseInvited> list=(List<BidResponseInvited>)pager.getResultList();
		       for (BidResponseInvited bidResponseInvited : list) {
		    	    bidResponseInvited.setIsCheck(1);
		    	    bidResponseInvitedService.update(bidResponseInvited);
		    	    User user=bidResponseInvited.getUser();
			    	if(user.getWorkPlace()!=null&&user.getWorkPlace()!=""){
			    	 String work=user.getWorkPlace();
			    	 String w=work.substring(0,work.lastIndexOf(" "));
			    	 user.setWorkPlace(w);
			    	 bidResponseInvited.setUser(user);
			    	}
			}
		       return "findlistApplyBid";
		   }
		  if(flag.equals("2")){
			  //detachedCriteria.add(Restrictions.eq("isCheck", 0));
			  detachedCriteria.add(Restrictions.eq("isResponse", 1));
			  detachedCriteria.add(Restrictions.eq("waitingPeople", "0"));
			  detachedCriteria.add(Restrictions.eq("isConfirmed", 0));
			   url="responseInvitednew!findlistApplyBid.do?id="+bidId+"&flag=2";
		  }
		  if(flag.equals("3")){
			   detachedCriteria.add(Restrictions.eq("waitingPeople", "1"));
			   url="responseInvitednew!findlistApplyBid.do?id="+bidId+"&flag=3";
		  }
	    super.pager=bidResponseInvitedService.findapplyBid(detachedCriteria,nowPage,5);	
	    
	    List<BidResponseInvited> list=(List<BidResponseInvited>)pager.getResultList();
	       for (BidResponseInvited bidResponseInvited : list) {
	    	    bidResponseInvited.setIsCheck(1);
	    	    bidResponseInvitedService.update(bidResponseInvited);
	    	    User user=bidResponseInvited.getUser();
		    	if(user.getWorkPlace()!=null&&user.getWorkPlace()!=""){
		    	 String work=user.getWorkPlace();
		    	 String w=work.substring(0,work.lastIndexOf(" "));
		    	 user.setWorkPlace(w);
		    	 bidResponseInvited.setUser(user);
		    	}
		    	
	       }
		return "findlistApplyBid";
	}
	
	//把某人设为不选
	public String setPeopleNO(){
		//()model
		BidResponseInvited bidResponseInvited=bidResponseInvitedService.select(((BidResponseInvited)model).getId());
		bidResponseInvited.setWaitingPeople("1");//(3);
		bidResponseInvitedService.update(bidResponseInvited);
		return "setPeopleNO";
	}
	//确定某人参加约拍
	public String confirmPerople(){
		
		BidResponseInvited bidResponseInvited=bidResponseInvitedService.select(((BidResponseInvited)model).getId());
		bidResponseInvited.setIsConfirmed(1);
	    bidResponseInvited.setConfirmedTime(new Timestamp(new Date().getTime()));
	    bidResponseInvitedService.update(bidResponseInvited);
		
		
		
		return "confirmPerople";
	}
	
	//把某人参加约拍设为待定
	public String waitingSetconfirmPerople(){
		
		BidResponseInvited bidResponseInvited=bidResponseInvitedService.select(((BidResponseInvited)model).getId());
		bidResponseInvited.setWaitingPeople("2");
		bidResponseInvitedService.update(bidResponseInvited);
	//bidResponseInvited.setConfirmedTime(new Timestamp(new Date().getTime()));
		
		return "waitingSetconfirmPerople";
	}
	//设为待定列表
	public String lisetSetPerople(){
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(BidResponseInvited.class);
	     detachedCriteria.createAlias("bid", "bid");
	     detachedCriteria.add(Restrictions.eq("bid.id", ((BidResponseInvited)model).getId()));
	     detachedCriteria.add(Restrictions.eq("waitingPeople", "2"));
	     bidId=((BidResponseInvited)model).getId();
		 super.pager=bidResponseInvitedService.findapplyBid(detachedCriteria,nowPage,pageSize);	
		    
		    List<BidResponseInvited> list=(List<BidResponseInvited>)pager.getResultList();
		       for (BidResponseInvited bidResponseInvited : list) {
		    	    User user=bidResponseInvited.getUser();
			    	if(user.getWorkPlace()!=null&&user.getWorkPlace()!=""){
			    	 String work=user.getWorkPlace();
			    	 String w=work.substring(0,work.lastIndexOf(" "));
			    	 user.setWorkPlace(w);
			    	 bidResponseInvited.setUser(user);
			    	}
		       }
		
		return "lisetSetPerople";
	}
	
	
	public String listConfirm(){
		
		int id=super.getLonginUserId();
		if(id==0){
		//url=url.substring(url.lastIndexOf("/")+1,url.length());
			return "login";
		}
		
		      DetachedCriteria detachedCriteria=DetachedCriteria.forClass(BidResponseInvited.class);
		       detachedCriteria.createAlias("bid", "bid");
		    // detachedCriteria.createAlias("user", "user");
		       detachedCriteria.add(Restrictions.eq("bid.id", ((BidResponseInvited)model).getId()));
		       bidId=((BidResponseInvited)model).getId();
		       detachedCriteria.add(Restrictions.eq("isConfirmed", 1));
		       super.pager=bidResponseInvitedService.findapplyBid(detachedCriteria,nowPage,pageSize);
		       List<BidResponseInvited> list=(List<BidResponseInvited>)pager.getResultList();
		       for (BidResponseInvited bidResponseInvited : list) {
		    	    bidResponseInvited.setIsCheck(1);
		    	    bidResponseInvitedService.update(bidResponseInvited);
		    	    User user=bidResponseInvited.getUser();
			    	if(user.getWorkPlace()!=null&&user.getWorkPlace()!=""){
			    	 String work=user.getWorkPlace();
			    	 String w=work.substring(0,work.lastIndexOf(" "));
			    	 user.setWorkPlace(w);
			    	 bidResponseInvited.setUser(user);
			    	}
			}
		return "listConfirm";
		
		
		
	}
	
	
	
	

	private BidService bidService;
	private BidForOpusService bidForOpusService;
	private MessageService messageService;
	
	private UserCreditService creditService;
	private ContactService contactService;
	private String bidId;
	private String msg;//发布和应约为同一人2//应约失败3//未登录4重复应约
	private BidtransactionService bidtransaction;	
 	private BidResponseInvitedService bidResponseInvitedService;
 	private UserService userService;
 	private String url="";
 	private int nowPage;
 	private String flag="";//1代表新应约2代表全部应约者3代表不选的人
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


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public int getNowPage() {
		return nowPage;
	}


	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}


	public String getFlag() {
		return flag;
	}


	public void setFlag(String flag) {
		this.flag = flag;
	}
 	
 	
 
	
	
}

