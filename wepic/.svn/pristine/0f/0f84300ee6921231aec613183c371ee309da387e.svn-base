package com.wetuo.wepic.deal.service ;
 
import java.sql.Timestamp;
import java.util.*;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.wetuo.wepic.deal.beans.Bid;
import com.wetuo.wepic.deal.beans.BidAimPerson;
import com.wetuo.wepic.deal.beans.BidResponseInvited;
import com.wetuo.wepic.deal.beans.UserMess;
import com.wetuo.wepic.deal.dao.BidResponseInvitedDao;
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.core.beans.UserCredit;
import com.wetuo.wepic.core.beans.UserPower;
import com.wetuo.wepic.core.service.UserCreditService;
import com.wetuo.wepic.core.service.UserPowerService;
 
public class BidResponseInvitedServiceImpl implements BidResponseInvitedService {
	BidResponseInvitedDao domainDao;
	BidAimPersonService aimPersonService=null;
	private UserPowerService powerService;
	private UserCreditService userCreditService;
	public BidAimPersonService getAimPersonService() {
		return aimPersonService;
	}
	public void setAimPersonService(BidAimPersonService aimPersonService) {
		this.aimPersonService = aimPersonService;
	}
	public BidResponseInvitedDao getBidResponseInvitedDao() {
		return domainDao;
	}//
	public void setBidResponseInvitedDao(BidResponseInvitedDao  domainDao) {
		this.domainDao = domainDao;
	}//
	
	//////////////common crud////////////////
	public List<BidResponseInvited> findAll(DetachedCriteria detachedCriteria){ 
		return domainDao.findAll(detachedCriteria);
	}
	
	public List<BidResponseInvited> findPart(String strFields, String[] arrStrValues){ 
		return domainDao.findPart(strFields,arrStrValues);
	}
	
	public Pager list(int pageSize, int pageNo)  {
		return domainDao.list(pageSize,pageNo);
	}//end list()
	
	public Pager list(String username, int pageSize, int pageNo)  {
		return domainDao.list(username,pageSize,pageNo);
	}//end list()
	
	public Pager list(Map<String,Object> mapSqlParam, int pageSize, int pageNo)  {
		return domainDao.list(mapSqlParam,pageSize,pageNo);
	}//end list()
	
	/////insert///
	public String insert(BidResponseInvited record) {
		return domainDao.insert(record) ;
	}//end insert()
			
	/////delete///
	public boolean delete(BidResponseInvited record)  {
		return domainDao.delete(record);
	}//end delete()
			
	public boolean delete(String id)  {
		return domainDao.delete(id);
	}//end delete()
	
	/////update///
	public boolean update(BidResponseInvited record)  {
		return domainDao.update(record);
	}//end update()
			
	/////select///
	public BidResponseInvited select(String id)  {
		return domainDao.select(id);
	}//end select()
	public Pager getReplyPhoto(String aimPersonId, int pageSize, int pageNo,String tags,String username) {
		// TODO Auto-generated method stub
		return domainDao.getReplyPhoto( aimPersonId,pageSize,pageNo,tags, username);
	}
	public List listConfirm(User user, BidAimPerson aimPerson, int pageSize,
			int pageNo) {
		// TODO Auto-generated method stub
		return domainDao.listConfirm(user, aimPerson, pageSize, pageNo);
	}
	public Pager listInvited(Map<String, Object> mapSqlParam, int pageSize,
			int pageNo) {
		// TODO Auto-generated method stub
		return domainDao.listInvited(mapSqlParam, pageSize, pageNo);
	}
	public List<BidResponseInvited> getOrderConfirm( String aimPersonId){
		return domainDao.getOrderConfirm(aimPersonId);
		
	}
	public List getConfrim(User user, String aimPerson, int pageSize, int pageNo) {
		BidAimPerson person=aimPersonService.select(aimPerson);
		
		
		 return domainDao.listConfirm(user, person, pageSize, pageNo);
	}
	public List getAllConfrim(Bid bid, int pageSize, int pageNo) {
		// TODO Auto-generated method stub
		  return domainDao.listAllConfirm(bid,pageSize, pageNo);
	}
	public Pager getReplyPhotoFratend(String aimPersonId, int pageSize,
			int pageNo, String username) {
		// TODO Auto-generated method stub
		return domainDao.getReplyPhotoFratend(aimPersonId, pageSize, pageNo, username);
	}
	public Pager findtousuList(int pageSize, int pageNo) {
		// TODO Auto-generated method stub
		return domainDao.findtousuList(pageSize, pageNo);
	}
	
	
	
	
	
	
	
	public UserCreditService getUserCreditService() {
		return userCreditService;
	}
	public void setUserCreditService(UserCreditService userCreditService) {
		this.userCreditService = userCreditService;
	}
	public String customerApplayForBid(User user,String bidId) {
		String msg="";
		  DetachedCriteria detachedCriteria=DetachedCriteria.forClass(BidResponseInvited.class,"bidResponseInvited");
			
			  detachedCriteria.add(Restrictions.eq("bidResponseInvited.user.id", user.getId()));
			  detachedCriteria.add(Restrictions.eq("bidResponseInvited.bid.id",bidId));
			  List<BidResponseInvited> list= domainDao.findAll(detachedCriteria);
			  if(list!=null&&list.size()>0){
				  
				      msg="4";
					 return msg; 
			  }
			  Bid bid=new Bid();
			  bid.setId(bidId);
			  BidResponseInvited bidResponseInvited=new BidResponseInvited();
			  bidResponseInvited.setBid(bid);
			  bidResponseInvited.setUser(user);
			  bidResponseInvited.setIsInvited(0);
			  bidResponseInvited.setReponseTime(new Timestamp(new Date().getTime()));
			  bidResponseInvited.setTaskFinished(0);
			  bidResponseInvited.setIsCheck(0);
			  bidResponseInvited.setWaitingPeople("0");
			  bidResponseInvited.setIsResponse(1);
			  bidResponseInvited.setIsConfirmed(0);
			  domainDao.insert(bidResponseInvited);
		
		       return msg;
	}
	
	
	
	
	
	
	
	
	public UserPowerService getPowerService() {
		return powerService;
	}
	public void setPowerService(UserPowerService powerService) {
		this.powerService = powerService;
	}
	public Pager findByDetachedCriteria(DetachedCriteria detachedCriteria,int nowPage,int pageSize){
		Pager pager=domainDao.findByDetachedCriteria(detachedCriteria,nowPage, pageSize);
		return pager;
	}
	
	public Pager findapplyBid(DetachedCriteria detachedCriteria,int nowPage,int pageSize){
		Pager pager=domainDao.findByDetachedCriteria(detachedCriteria,nowPage, pageSize);
		List<BidResponseInvited> bidResponseInviteds=(List<BidResponseInvited>)pager.getResultList();
		for (BidResponseInvited bidResponseInvited : bidResponseInviteds) {
			  User user=bidResponseInvited.getUser();
			  DetachedCriteria powerdetachedCriteria=DetachedCriteria.forClass(UserPower.class);
			    powerdetachedCriteria.createAlias("user", "user");
			    powerdetachedCriteria.add(Restrictions.eq("user.id", user.getId()));
			    powerdetachedCriteria.add(Restrictions.eq("zhengMingType","1"));
			    List<UserPower> userPowers=powerService.findUserPowers(powerdetachedCriteria);
				DetachedCriteria detachedCriteria1=DetachedCriteria.forClass(UserPower.class);
				detachedCriteria1.createAlias("user", "user");
				detachedCriteria1.add(Restrictions.eq("user", user));
				detachedCriteria1.add(Restrictions.eq("zhengMingType","2"));
				List<UserPower> projectuserPowers=powerService.findUserPowers(detachedCriteria1);
				UserCredit userCredit=userCreditService.selectByUser(user);
		     	DetachedCriteria detachedCriteria2=DetachedCriteria.forClass(UserPower.class);
				detachedCriteria2.createAlias("user", "user");
				detachedCriteria2.add(Restrictions.eq("user", user));
				detachedCriteria2.add(Restrictions.eq("zhengMingType","3"));
				List<UserPower> hornoList=powerService.findUserPowers(detachedCriteria2);
		     	UserMess userMess=new UserMess();
		     	userMess.setCredit(userCredit);
		     	userMess.setProjectuserPowers(projectuserPowers);
		     	userMess.setHornoList(hornoList);
		     	userMess.setUserPowers(userPowers);
		     	user.setUserMess(userMess);
		     	
			
		}
		
		
		return pager;
	}
	
	
}//end class
