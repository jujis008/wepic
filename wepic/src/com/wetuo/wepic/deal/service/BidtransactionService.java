package com.wetuo.wepic.deal.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;


import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.core.beans.Account;
import com.wetuo.wepic.core.beans.BrokerRelationship;
import com.wetuo.wepic.core.beans.SiteConfig;
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.core.beans.UserCredit;
import com.wetuo.wepic.core.service.AccountService;
import com.wetuo.wepic.core.service.BrokerRelationshipService;
import com.wetuo.wepic.core.service.SiteConfigService;
import com.wetuo.wepic.core.service.UserCreditService;
import com.wetuo.wepic.core.service.UserService;

import com.wetuo.wepic.deal.beans.Bid;
import com.wetuo.wepic.deal.beans.BidAccountOperation;
import com.wetuo.wepic.deal.beans.BidForOpus;
import com.wetuo.wepic.deal.beans.BidResponseInvited;
import com.tools.SendMsg;

public class BidtransactionService {
  private AccountService accountService;
  private BidService bidService;
  private UserService userService;
  private BidAccountOperationService accountOperationService;
  private SiteConfigService configService;
  private BrokerRelationshipService brokerRelationshipService;
  private BidForOpusService bidForOpusService;
	private UserCreditService creditService;
	
  
	
	public UserCreditService getCreditService() {
		return creditService;
	}


	public void setCreditService(UserCreditService creditService) {
		this.creditService = creditService;
	}


	public BidForOpusService getBidForOpusService() {
	return bidForOpusService;
}


public void setBidForOpusService(BidForOpusService bidForOpusService) {
	this.bidForOpusService = bidForOpusService;
}


	public BrokerRelationshipService getBrokerRelationshipService() {
	return brokerRelationshipService;
}


public void setBrokerRelationshipService(
		BrokerRelationshipService brokerRelationshipService) {
	this.brokerRelationshipService = brokerRelationshipService;
}


	public void setAccountService(AccountService accountService) {
	this.accountService = accountService;
         }


public void setBidService(BidService bidService) {
	this.bidService = bidService;
      }


public void setAimPersonService(BidAimPersonService aimPersonService) {
         }


public void setAccountOperationService(
		BidAccountOperationService accountOperationService) {
	  this.accountOperationService = accountOperationService;
         }


	public void setUserService(UserService userService) {
	this.userService = userService;
}

	

	public void setConfigService(SiteConfigService configService) {
		this.configService = configService;
	}
	
	
	
	
	//0是取消失败
	//2是取消成功
	
	/**
	 * 
	 * 取消约拍锁定一星期的金额
	 * 
	 * /
	 * 
	 * 
	 */
	
	@SuppressWarnings("unchecked")
	//再有确定应约者的情况下取消约拍金额锁定到结束拍摄的一周后返款
	@Transactional
	public int cancelBidReturnMoney(Bid bid,BidResponseInvitedService bidResponseInvitedService){
		  List<BidResponseInvited> cancelBids=bidResponseInvitedService.getAllConfrim(bid, 1000, 1);
		 Account account= accountService.select(bid.getUser().getId(), "");
		 int num=bid.getRecruitNum();
		 if(bid.getType()==2){
			 num=1;
		 }
		 double mean=bid.getTotalMoney()/num;
		 double returnmoney=0;
		  for (int i=0;i<cancelBids.size();i++) {
			  returnmoney+=mean;
		}
		 
		    BigDecimal result=account.getRemainingMoney().add(new BigDecimal(returnmoney));
		    account.setRemainingMoney(result);
		   // account.setTotalMoney(new BigDecimal(returnmoney));
		    accountService.update(account);
			return 2;
			
	}
	@Transactional
	public int cancelBid(String userName,String bidId,BidResponseInvitedService bidResponseInvitedService){
		
			Bid bid=bidService.select(bidId);
			bid.setStatus(2);
		    bidService.update(bid);
			return 2;
				
			/*
	  List<SiteConfig> list=configService.findAll();
	  SiteConfig config=null;
	 
	  if(list.size()>0){
		  config=list.get(list.size()-1);
	  }else{
		  
		  
		  return 0;
	  }
	  User user=userService.select(userName);
	 if(bid.getType()==3){
		return type3(bid, bidId, config);	
	 }else{
	  int sum=0;
	  sum=bid.getRecruitNum();
	  if(bid.getRecruitNum()==0){
		  sum=1;
	  }
	  List<BidResponseInvited> cancelBids=bidResponseInvitedService.getAllConfrim(bid, 1000, 1);
	  double mean=bid.getTotalMoney()/sum;//均价
	  double returnMoney=0;
	  double deduction=0;
	  double taxdeduction=0;
	  double siteProperty=0;
	  if(bid.getType()==2){
		  if(cancelBids.size()>0){
	    		 mean=bid.getTotalMoney()/cancelBids.size();		
	    	}
	  }/*else{
	    		return 2;
	    	}*/
	    
	    //}
	  
	  /*
	  Account account= accountService.select(user.getId(),"");
	  
	  for (BidResponseInvited bidResponseInvited : cancelBids){
		  double taxdeduction1=mean*(config.getManageTax()+config.getTax()+config.getThirdPayRate());//税金
		  taxdeduction=taxdeduction+taxdeduction1;
		  double remean=mean-taxdeduction1;//扣除税金只够的金额
		    List<BrokerRelationship> brokerRelationships=this.getBrokerRelationshipService().getRelationShips(userService.selectById(bidResponseInvited.getUser().getId()));
		    if(brokerRelationships!=null&&brokerRelationships.size()>0&&brokerRelationships.get(0).getIsValid()==1){
		    	BrokerRelationship brokerRelationship=brokerRelationships.get(0);
		    	
		        double brokerMoney=remean*config.getProportionBroker();
		    	Account brokerAccount=accountService.select(brokerRelationship.getBroker().getId(),"");
		    	brokerAccount.setTotalMoney(brokerAccount.getTotalMoney().add(new BigDecimal(brokerMoney)));
		    	brokerAccount.setRemainingMoney(brokerAccount.getRemainingMoney().add(new BigDecimal(brokerMoney)));
		    	accountService.update(brokerAccount);
		    	siteProperty+=remean*config.getProportionSite();
		    	deduction=remean*config.getProportionSite()+brokerMoney;
		    	   
			    BidAccountOperation accountOperation=new BidAccountOperation();
				accountOperation.setEntryMoney(new BigDecimal(brokerMoney));
			    accountOperation.setEntryTime(new Timestamp(new Date().getTime()));
			    accountOperation.setUnlockTime(new Timestamp(new Date().getTime()));
			    accountOperation.setAccount(brokerAccount);
				accountOperation.setBidResponseInvited(bidResponseInvited);
				accountOperation.setSiteConfig(config);
				accountOperation.setEntryTime(new Timestamp(new Date().getTime()));
				accountOperation.setBid(bid);
				accountOperationService.insert(accountOperation);
		       }else{
				//deduction+=mean*(config.getManageTax()+config.getTax()+config.getThirdPayRate()+config.getProportionSite());	
				siteProperty+=remean*(config.getProportionSite()+config.getProportionSite());
				deduction=remean*(config.getProportionSite()+config.getProportionSite());
				
				
				
				 
		    }
		   
		    returnMoney+=remean-siteProperty;
		    
		 
		}
	  //管理员账户
	    Account adminAccount=accountService.select(userService.select("super1").getId(),"");
		adminAccount.setRemainingMoney(adminAccount.getRemainingMoney().add(new BigDecimal(siteProperty+taxdeduction)));
		adminAccount.setTotalMoney(adminAccount.getTotalMoney().add(new BigDecimal(siteProperty+taxdeduction)));
		accountService.update(adminAccount);
		
        
        
	    //管理员的的账户bid记录
        BidAccountOperation accountOperation=new BidAccountOperation();
		accountOperation.setEntryMoney(new BigDecimal(siteProperty));
	    accountOperation.setEntryTime(new Timestamp(new Date().getTime()));
	    accountOperation.setUnlockTime(new Timestamp(new Date().getTime()));
	    accountOperation.setAccount(adminAccount);
	//	accountOperation.setBidResponseInvited();
		accountOperation.setSiteConfig(config);
		accountOperation.setEntryTime(new Timestamp(new Date().getTime()));
		accountOperation.setBid(bid);
		accountOperationService.insert(accountOperation);
         
         
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	    //发表者的的账户bid记录
        BidAccountOperation bidaccountOperation=new BidAccountOperation();
        bidaccountOperation.setEntryMoney(new BigDecimal(siteProperty));
        bidaccountOperation.setEntryTime(new Timestamp(new Date().getTime()));
        bidaccountOperation.setUnlockTime(new Timestamp(new Date().getTime()));
        bidaccountOperation.setAccount(account);
	//	accountOperation.setBidResponseInvited();
        bidaccountOperation.setSiteConfig(config);
        bidaccountOperation.setEntryTime(new Timestamp(new Date().getTime()));
        bidaccountOperation.setBid(bid);
		accountOperationService.insert(bidaccountOperation);
		
		
			BigDecimal result=account.getRemainingMoney().add(new BigDecimal(returnMoney));
		    account.setRemainingMoney(result);
		    account.setTotalMoney(account.getTotalMoney().subtract(new BigDecimal(deduction)).subtract(new BigDecimal(taxdeduction)));
		   UserCredit credit=creditService.selectByUser(user);
		   if(credit!=null){
			   credit.setBidGiveMoney(credit.getBidGiveMoney()+ new Float(bid.getTotalMoney()-returnMoney));
			   
		   }else{
			   credit.setBidGiveMoney(new Float(bid.getTotalMoney()-returnMoney)); 
		   }
		     creditService.update(credit);
		      accountService.update(account);
	    */
		   
	 
		
		
	
      }
      
		
		
	
		
		
		
	
	//当type==3是也就是作品征集的时候
	public int type3(Bid bid,String userName,SiteConfig config){
		
		
		double mean = bid.getTotalMoney() / bid.getImgSum();
		Pager pager = bidForOpusService.confirmlist(bid, 100, 1);
          List list2=pager.getResultList();
          int confirmCount=0;
          if(list2!=null){
        	  confirmCount= list2.size(); 
        	  
          }
		double retmoney = bid.getTotalMoney() - mean
				* confirmCount;
		Account account = accountService.select(userService.select(
				userName).getId(), "");
		account.setRemainingMoney(account.getRemainingMoney().add(
				new BigDecimal(retmoney)));

		BidAccountOperation accountOperation = new BidAccountOperation();
		accountOperation.setEntryMoney(new BigDecimal(retmoney));
		accountOperation.setEntryTime(new Timestamp(new Date()
				.getTime()));
		accountOperation.setUnlockTime(new Timestamp(new Date()
				.getTime()));
		accountOperation.setAccount(account);
		accountOperation.setSiteConfig(config);
		accountOperation.setBid(bid);
		accountOperation.setEntryTime(new Timestamp(new Date()
				.getTime()));

		bid.setStatus(2);
		accountOperationService.insert(accountOperation);
		bidService.update(bid);
		accountService.update(account);
		  UserCredit credit=creditService.selectByUser(userService.select(userName));
		   if(credit!=null){
			   credit.setBidGiveMoney(credit.getBidGiveMoney()+ new Float(bid.getTotalMoney()-retmoney));
			   
		   }else{
			   credit.setBidGiveMoney(new Float(bid.getTotalMoney()-retmoney)); 
		   }
		   creditService.update(credit);
		  

              return 2;
		
	}
	
	
	
		

     //1代表金额不够
	//3代表招聘人数已满
	//0出现异常代表失败
	//2执行成功
	 //4表示换人次数已满
    @Transactional
	public int insert(String userName,Bid bid,List<BidResponseInvited> listbid,BidResponseInvitedService bidResponseInvitedService,int confirmSum){
		try{
			//if(bid.getRecruitNum()!=0){
			if(confirmSum-bid.getRecruitNum()>=0){
			return 3;	
			}
			
	
			
	  BidResponseInvited	bidResponseInvited=null;
	  List<SiteConfig> list=configService.findAll();
	  SiteConfig config=null;
	 
	  if(list.size()>0){
		  config=list.get(list.size()-1);
	  }
	  
	  if(bid.getNumChangeWorker()-config.getLimitChangeWorker()>=0){
			return 4;
			
		}
		BidAccountOperation accountOperation=new BidAccountOperation();
	
		 
		User user=userService.select(userName);
		Account account= accountService.select(user.getId(),"");
		
		
		
		
	   // userCredit.set
		  
		if(bid.getRecruitNum()!=0){
			accountOperation.setLockMoney(new BigDecimal(bid.getTotalMoney()/bid.getRecruitNum()));
		}else{
			accountOperation.setLockMoney(new BigDecimal(bid.getTotalMoney()));	
		}
		
       BigDecimal result=account.getRemainingMoney().subtract(accountOperation.getLockMoney());
	
		if( result.compareTo(new BigDecimal(0))<0){	
			return 1;
		}
		 //bid.setStatus();
		accountOperation.setAccount(account);
		User user2=null;
		
		for(BidResponseInvited invited:listbid){
			bidResponseInvited=invited;
	    	invited.setIsConfirmed(1);
	    	invited.setConfirmedTime(new Timestamp(new Date().getTime()));
	    	user2=invited.getUser();
	    	bidResponseInvitedService.update(invited);
	    	
	    }
		UserCredit userCredit=creditService.selectByUser(user2);
		userCredit.setTotalMark(userCredit.getTotalMark()+10);
		userCredit.setBidConfirmedNum(userCredit.getBidConfirmedNum()+1);
		creditService.update(userCredit);
		
		
		accountOperation.setSiteConfig(config);
		accountOperation.setBidResponseInvited(listbid.get(0));
	
		accountOperation.setLockTime(new Timestamp(new Date().getTime()));
		accountOperation.setBid(bid);
		bidService.update(bid);
		List<BidAccountOperation> bidaccountList=null;
		if(bid.getType()==2){
		bidaccountList=accountOperationService.findPart("bid", bid);
		if(bidaccountList.size()<1){
			account.setRemainingMoney(result);
			accountService.update(account);
			accountOperationService.insert(accountOperation);
			
			
		}
			 
		}else{
			account.setRemainingMoney(result);
			accountService.update(account);
			accountOperationService.insert(accountOperation);
		}
		 if(bidResponseInvited!=null){
			    user=bidResponseInvited.getUser();
			    bid=bidResponseInvited.getBid();
//				String txtString = "<p><span style=';font-size:14px;font-family:&#39;宋体&#39;'>尊敬的用户<span style='font-family:Times New Roman'>"+user.getUsername()+"</span><span style='font-family:宋体'></span></span></p>"
//				+ "<p><span style=';font-size:14px;font-family:&#39;宋体&#39;'>&nbsp;&nbsp; 您已被确定为&nbsp;&nbsp;<span style='font-family:Times New Roman'>"+bid.getName()+"</span><span style='font-family:宋体'>项目的中标者，请尽快与客户联系拍摄事宜。</span><br/></span></p>"
//				+ "<p><span style=';font-size:14px;font-family:&#39;宋体&#39;'>&nbsp;&nbsp;点击下面链接，进入项目操作。</span></p><p>"
//				+ "<span style=';font-size:14px;font-family:&#39;宋体&#39;'>&nbsp;&nbsp;</span><span style=';font-size:14px;font-family:&#39;宋体&#39;'><a href='http://www.wepic.cn/view/frontend/login.jsp?u=5567a947ace3b219&t=dbbdef987421e7ad572e6367a2ca2e08a38321f05e85acec'>登录唯图网</a></span>"
//				+ "</p><p><span style=';font-size:14px;font-family:&#39;宋体&#39;'>唯图网客服经理<br>" +
//						"key@wepic.cn</span>"
//				+ "</p><p><br/></p>";
				 // sendMsg.sendMsgByTel(user.getMobile(), "按项目计划，项目   "+bid.getName()+" 已经完成，请登录唯图网确认付款。。如有问题可以进入项目操作投诉。（唯图网）");		
					String content1="<span style='font-size:12px;'>尊敬的用户！"+user.getUsername()+"<br/>";
			        content1+="您好:<br/>";
			        content1+="您已被确定为"+bid.getName()+"项目，项目的中标者，请尽快与客户联系拍摄事宜。<br/>";
			        content1+="<a href='http://www.wepic.cn/view/frontend/login.jsp'>http://www.wepic.cn/view/frontend/login.jsp</a><br/>";
			        content1+="<span style='color:#CCC;font-size:12px;'>（如果以上链接无法点击，请将上面的地址复制到你的浏览器(如IE)的地址栏进入唯图网.）</span><br/></span>" +
			        		"<span style='font-size:12px;'>为了保障您的个人利益，请尽快登录唯图网进行项目操作！</span>";
			        content1+="<span style='font-size:12px;'><br/>唯图网客服团队<br/></span>";
			        content1+="key@wepic.cn";
			        
			        
			   SendMsg sendMsg=new SendMsg();
				sendMsg.sendMsgByEmail(bidResponseInvited.getUser().getEmail(), content1); 
				//sendMsg.sendMsgByEmail(user.getEmail(), content1);
				sendMsg.sendMsgByTel(user.getMobile(),"您已被确定为，项目   "+bid.getName()+" 的中标者，请尽快与客户联系拍摄事宜。（唯图网）");
			 
		 }
		
		return 2;
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	
      }
    
    public int lockAccount(double lockmoney,Bid bid,String userName){
    	try{
    	User user=userService.select(userName);
    	Account account=accountService.select(user.getId(), "");
    	if(account==null){
    	return 3;	
    		
    		
    	}
    	if(account.getRemainingMoney()==null){
    		return 1;
    		
    	}
    	BigDecimal result=account.getRemainingMoney().subtract(new BigDecimal(lockmoney));
    		
  		if( result.compareTo(new BigDecimal(0))<0){	
  			return 1;
  		}
  		account.setRemainingMoney(result);
  		bidService.insert(bid);
  		accountService.update(account);
  		//accountOperationService.insert(record);
  		return 2;
    	}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
    	
    	
    	
    	
    	
    }
    
    //1成功
    //2失败
    //3图片已经搜集完
    //4此作品已被确认不能二次确认
    @Transactional
    public int confirmImag(String id,String userName){
    	
    	
    	
    	try{
    	
    	  List<SiteConfig> siteConfigs=configService.findAll();
    	  SiteConfig config=null;
    	 
    	  if(siteConfigs.size()>0){
    		  config=siteConfigs.get(siteConfigs.size()-1);
    	  }
    	BidForOpus bidForOpus= bidForOpusService.selectById(id);
    	if(bidForOpus.getStatus()==2){
    		return 4;
    	}
    	Bid bid=bidForOpus.getBid();
    	List<BidForOpus> list=bidForOpusService.getConfirm(bidForOpus.getBid().getId());
    	if(list.size()<bid.getImgSum()){
    		if(bid.getImgSum()-list.size()==1){
    			bid.setStatus(4);
    			
    		}
    	bidForOpus.setConfirmTime(new Timestamp(new Date().getTime() ));
    	bidForOpus.setStatus(2);
    	
        Account sendaccount=accountService.select(bidForOpus.getUser().getId(), "");
        Account buyAccount=accountService.select(userService.select(userName).getId(),"");
        Account superAccount=accountService.select(userService.select("super1").getId(),"");
        double mean=bid.getTotalMoney()/bid.getImgSum();
        double deduction=0;//扣除的金额
        double tax=0;//税;
        
        double tax1=config.getTax()+config.getThirdPayRate();//+config.getProportionSite();//
	    double siteRate=config.getProportionBroker()+config.getProportionSite();
	    double requsrrate=tax1+siteRate;
	    
        
        
        
        
        
        
        //招标人
	    BidAccountOperation accountOperation=new BidAccountOperation();
	    
	  //发标者积分情况
		UserCredit userCredit =creditService.selectByUser(userService.select(userName));
		float num=userCredit.getTotalMark();
		DecimalFormat format=new DecimalFormat("###.0");
		float mark=(float)mean/50;
		num=num+mark;
	    num=Float.parseFloat(format.format(num));
	    userCredit.setTotalMark(num);
	    userCredit.setBidGiveMoney(userCredit.getBidGiveMoney()+(float)mean);
	   // userCredit.setDealMoney(userCredit.getDealMoney()+(float)money);
	    creditService.update(userCredit);
	    
	    
	    accountOperation.setDeductionMoney(new BigDecimal(mean));
        buyAccount.setTotalMoney(buyAccount.getTotalMoney().subtract(new BigDecimal(mean)));
	   // buyAccount.setRemainingMoney(buyAccount.getRemainingMoney().subtract(new BigDecimal(mean)));
    	List<BrokerRelationship> brokerRelationships=this.getBrokerRelationshipService().getRelationShips(userService.selectById(bidForOpus.getUser().getId()));
    	//tax=mean*(config.getTax()+config.getManageTax()+config.getThirdPayRate());
    	//mean=mean-tax;
    	
    	if(brokerRelationships!=null&&brokerRelationships.size()>0&&brokerRelationships.get(0).getIsValid()==1){
	    	BrokerRelationship brokerRelationship=brokerRelationships.get(0);	
	        double brokerMoney=mean*requsrrate*config.getBrokerMonth();
	    	Account brokerAccount=accountService.select(brokerRelationship.getBroker().getId(),"");
	    	brokerAccount.setTotalMoney(brokerAccount.getTotalMoney().add(new BigDecimal(brokerMoney)));
	    	brokerAccount.setRemainingMoney(brokerAccount.getRemainingMoney().add(new BigDecimal(brokerMoney)));
	    	accountService.update(brokerAccount);
	    	//deduction+=mean*config.getProportionSite();
	    	requsrrate=requsrrate-config.getBrokerMonth();
	       }
    	
	    superAccount.setTotalMoney(superAccount.getTotalMoney().add(new BigDecimal(mean*requsrrate)));
	    superAccount.setRemainingMoney(superAccount.getRemainingMoney().add(new BigDecimal(mean*requsrrate)));
	    
	    sendaccount.setTotalMoney(sendaccount.getTotalMoney().add(new BigDecimal(mean*(1-requsrrate))));
	    sendaccount.setRemainingMoney(sendaccount.getRemainingMoney().add(new BigDecimal(mean*(1-requsrrate))));
	  
   	    accountOperation.setAccount(buyAccount);
   	    accountOperation.setDeductionTime(new Timestamp(new Date().getTime()));
   	    accountOperation.setMoneyUnit("元");
   	    accountOperation.setBidForOpus(bidForOpus);
   	    accountOperation.setUnlockTime(new Timestamp(new Date().getTime()));
   	    accountOperation.setSiteConfig(config);
   	    accountOperation.setDeductionMoney(new BigDecimal(mean));
   	    accountOperation.setBid(bid);
	    accountOperationService.insert(accountOperation);
	    
	    
	    //应标者
	    BidAccountOperation accountOperation1=new BidAccountOperation();
	    
	    //应标者积分
	    UserCredit userCredityingbiao =creditService.selectByUser(userService.selectById(bidForOpus.getUser().getId()));
		float numying=userCredit.getTotalMark();
		//DecimalFormat format=new DecimalFormat("###.0");
		float markying=(float)mean/50;
		numying=numying+markying;
		numying=Float.parseFloat(format.format(numying));
		userCredityingbiao.setTotalMark(numying);
		userCredityingbiao.setBidGetMoney(userCredityingbiao.getBidGetMoney()+(float)mean);
	  //  userCredityingbiao.setDealMoney(userCredityingbiao.getDealMoney()+(float)money);
	    creditService.update(userCredityingbiao);
	    
	    
	    
	    
   	    accountOperation1.setAccount(sendaccount);
   	    //accountOperation.setDeductionTime(new Timestamp(new Date().getTime()));
   	    accountOperation1.setMoneyUnit("元");
   	    accountOperation1.setBidForOpus(bidForOpus);
   	    accountOperation1.setEntryMoney(new BigDecimal(mean*(1-requsrrate)));
   	    accountOperation1.setEntryTime(new Timestamp(new Date().getTime()));
   	    accountOperation1.setSiteConfig(config);
   	    System.out.println(bid.getName());
     	accountOperation1.setBid(bid);
   	   accountOperationService.insert(accountOperation1);
   	    
   	 //管理员
	    BidAccountOperation accountOperation2=new BidAccountOperation();
   	    accountOperation2.setAccount(superAccount);
   	    accountOperation2.setDeductionTime(new Timestamp(new Date().getTime()));
   	    accountOperation2.setMoneyUnit("元");
   	    accountOperation2.setBidForOpus(bidForOpus);
	    accountOperation2.setEntryMoney(new BigDecimal(mean*requsrrate));
	    accountOperation2.setEntryTime(new Timestamp(new Date().getTime()));
	    accountOperation2.setSiteConfig(config);
	    accountOperation2.setBid(bid);
	    accountOperationService.insert(accountOperation2);
   	    
   	    
	    
	    accountService.update(superAccount);
	    accountService.update(buyAccount);
	    accountService.update(sendaccount);
	    bidForOpusService.update(bidForOpus);
	    
	    UserCredit credit=creditService.selectByUser(userService.select(userName));
		   if(credit!=null){
			   credit.setBidGiveMoney(credit.getBidGiveMoney()+new Float(mean));
			   
		   }else{
			   credit.setBidGiveMoney(new Float(mean)); 
		   }
		   creditService.update(credit);
		   
    	
    	}else{
    		
    		
    		return 3;
    	}
    	 
    	
    	}catch (Exception e) {
			e.printStackTrace();
			return 2;
		}
    	
    	
    	
    	return 1;
    }
    //付款
    @Transactional
    public String payMoney(BidResponseInvited bidResponseInvited){
		try {
            List<SiteConfig> configs=configService.findAll();
            SiteConfig config=configs.get(configs.size()-1);
            bidResponseInvited.setTaskFinished(2);
			Bid bid = bidResponseInvited.getBid();
		    double money = bid.getTotalMoney() / bid.getRecruitNum();
		    double tax=config.getTax()+config.getThirdPayRate();//+config.getProportionSite();//
		    double siteRate=config.getProportionBroker()+config.getProportionSite();
		    double requsrrate=tax+siteRate;
		    	//config.getProportionBroker()+config.getThirdPayRate();//应标着获得钱的比例
		    
			//发标人
			User sendBidUser = bid.getUser();
			//应标人
			User useryingbiao = bidResponseInvited.getUser();
			//应标人
	//		User useryingbiao = bidResponseInvited.getUser();
			  List<BrokerRelationship> brokerRelationships=this.getBrokerRelationshipService().getRelationShips(userService.selectById(useryingbiao.getId()));
			  if(brokerRelationships!=null&&brokerRelationships.size()>0&&brokerRelationships.get(0).getIsValid()==1){
		    	BrokerRelationship brokerRelationship=brokerRelationships.get(0);	
		    	double brokerMoney=money*requsrrate*config.getProportionBroker();
		    	//经纪人账户
		    	 Account brokerAccount=accountService.select(brokerRelationship.getBroker().getId(),"");
		    	 brokerAccount.setTotalMoney(brokerAccount.getTotalMoney().add(new BigDecimal(brokerMoney)));
		    	 brokerAccount.setRemainingMoney(brokerAccount.getRemainingMoney().add(new BigDecimal(brokerMoney)));
				 accountService.update(brokerAccount);
				 BidAccountOperation accountOperation4=new BidAccountOperation();
				 accountOperation4.setBidResponseInvited(bidResponseInvited);
			   	 accountOperation4.setAccount(brokerAccount);
			   	 accountOperation4.setDeductionTime(new Timestamp(new Date().getTime()));
			   	 accountOperation4.setMoneyUnit("元");
			   	 accountOperation4.setBid(bid);
			   	 accountOperation4.setUnlockTime(new Timestamp(new Date().getTime()));
			   	 accountOperation4.setSiteConfig(config);
			   	 accountOperation4.setEntryTime(new Timestamp(new Date().getTime()));
			   	 accountOperation4.setEntryMoney(new BigDecimal(brokerMoney));
				 accountOperationService.insert(accountOperation4);
				 siteRate=requsrrate-config.getProportionBroker();
				
				
			}
			//发标者的账户
			Account sendBidaccount = accountService.select(sendBidUser.getId(), "");
			
			if (bid.getRecruitNum() == 0) {
				bid.setRecruitNum(1);

			}
			//发标者积分情况
			UserCredit userCredit =creditService.selectByUser(sendBidUser);
			float num=userCredit.getTotalMark();
			DecimalFormat format=new DecimalFormat("###.0");
			float mark=(float)money/50;
			num=num+mark;
		    num=Float.parseFloat(format.format(num));
		    userCredit.setTotalMark(num);
		    userCredit.setBidGiveMoney(userCredit.getBidGiveMoney()+(float)money);
		   // userCredit.setDealMoney(userCredit.getDealMoney()+(float)money);
		    creditService.update(userCredit);
			
			    sendBidaccount.setTotalMoney(sendBidaccount.getTotalMoney().subtract(
					new BigDecimal(money)));
//			    sendBidaccount.setRemainingMoney(sendBidaccount.getRemainingMoney().subtract(
//					new BigDecimal(money)));
			    accountService.update(sendBidaccount);
			    BidAccountOperation accountOperation=new BidAccountOperation();
		   	    accountOperation.setAccount(sendBidaccount);
		   	    accountOperation.setDeductionTime(new Timestamp(new Date().getTime()));
		   	    accountOperation.setMoneyUnit("元");
		   	    accountOperation.setBid(bid);
		   	    accountOperation.setUnlockTime(new Timestamp(new Date().getTime()));
		   	    accountOperation.setSiteConfig(config);
		   	    accountOperation.setDeductionTime(new Timestamp(new Date().getTime()));
		   	    accountOperation.setDeductionMoney(new BigDecimal(money));
		   	    accountOperation.setBidResponseInvited(bidResponseInvited);
			    accountOperationService.insert(accountOperation);
			
			//应标者账户
			Account requestBidaccount = accountService.select(useryingbiao.getId(), "");
			//应标者积分状况
			UserCredit userCredityingbiao =creditService.selectByUser(useryingbiao);
			float numying=userCredit.getTotalMark();
			//DecimalFormat format=new DecimalFormat("###.0");
			float markying=(float)money/50;
			numying=numying+markying;
			numying=Float.parseFloat(format.format(numying));
			userCredityingbiao.setTotalMark(numying);
			userCredityingbiao.setBidGetMoney(userCredityingbiao.getBidGetMoney()+(float)money);
		  //  userCredityingbiao.setDealMoney(userCredityingbiao.getDealMoney()+(float)money);
		    creditService.update(userCredityingbiao);
			
			
			double requestBidmoney=(money*(1-requsrrate));
			//requestBidmoney=requestBidmoney*(1-siteRate);
			requestBidaccount.setTotalMoney(requestBidaccount.getTotalMoney().add(new BigDecimal(requestBidmoney)));
			requestBidaccount.setRemainingMoney(requestBidaccount.getRemainingMoney().add(new BigDecimal(requestBidmoney)));
			    //应标着账户操作中间表
			    BidAccountOperation accountOperation1=new BidAccountOperation();
		   	    accountOperation1.setAccount(requestBidaccount);
		   	    accountOperation1.setDeductionTime(new Timestamp(new Date().getTime()));
		   	    accountOperation1.setMoneyUnit("元");
		   	    accountOperation1.setBid(bid);
		   	    accountOperation1.setUnlockTime(new Timestamp(new Date().getTime()));
		   	    accountOperation1.setSiteConfig(config);
		   	    accountOperation1.setEntryTime(new Timestamp(new Date().getTime()));
		   	    accountOperation1.setEntryMoney(new BigDecimal(requestBidmoney));
		   	    accountOperation1.setBidResponseInvited(bidResponseInvited);
			    accountOperationService.insert(accountOperation1);
			    
			   accountService.update(requestBidaccount);
			// 管理员账户
			Account superAccount = accountService.select(userService.select("super1").getId(), "");
			double superMOney = money*siteRate;
			double taxmoney=money*tax;
			superAccount.setTotalMoney(superAccount.getTotalMoney().add(
					new BigDecimal(superMOney)).add(new BigDecimal(taxmoney)));
			superAccount.setRemainingMoney(superAccount.getRemainingMoney()
					.add(new BigDecimal(superMOney)).add(new BigDecimal(taxmoney)));
			accountService.update(superAccount);
			//管理员账户操作
			BidAccountOperation accountOperation2 = new BidAccountOperation();
			accountOperation2.setAccount(superAccount);
			accountOperation2.setDeductionTime(new Timestamp(new Date()
					.getTime()));
			accountOperation2.setMoneyUnit("元");
			accountOperation2.setBid(bid);
			accountOperation2
					.setUnlockTime(new Timestamp(new Date().getTime()));
			accountOperation2.setSiteConfig(config);
			accountOperation2.setEntryTime(new Timestamp(new Date().getTime()));
			accountOperation2.setEntryMoney(new BigDecimal(superMOney).add(new BigDecimal(taxmoney)));
			accountOperation2.setBidResponseInvited(bidResponseInvited);
			accountOperationService.insert(accountOperation2);
			

			return "ok";

		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
    
    
}
