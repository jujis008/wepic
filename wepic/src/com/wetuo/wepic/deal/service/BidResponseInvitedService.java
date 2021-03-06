package com.wetuo.wepic.deal.service ;
 
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
 
import com.wetuo.wepic.deal.beans.Bid;
import com.wetuo.wepic.deal.beans.BidAimPerson;
import com.wetuo.wepic.deal.beans.BidResponseInvited;
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.core.beans.User;
 
public interface BidResponseInvitedService {
 
	public String customerApplayForBid(User user,String bidId);
	public Pager findByDetachedCriteria(DetachedCriteria detachedCriteria,int nowPage,int pageSize);
	public Pager findapplyBid(DetachedCriteria detachedCriteria,int nowPage,int pageSize);
	
	
	
	
	
	
	
	
	
	
//////////////////////////////////////////////wepic2.0/////////////////////
 	List<BidResponseInvited> findAll(DetachedCriteria detachedCriteria);
 	List<BidResponseInvited> findPart(String strFields,String[] strArrValues);
 	public List<BidResponseInvited> getOrderConfirm( String aimPersonId);
	public Pager list(int pageSize, int pageNo)  ;
	public Pager list(String username, int pageSize, int pageNo) ;
	public Pager list(Map<String,Object>  mapSqlParam, int pageSize, int pageNo) ;
   	public BidResponseInvited select(String id);
	public String insert(BidResponseInvited record);
	public boolean update(BidResponseInvited record);
   	public boolean delete(BidResponseInvited record);
	public boolean delete(String id) ;
	public Pager getReplyPhoto(String aimPersonId, int pageSize, int pageNo,String tags,String username);
	public List   listConfirm( User user, BidAimPerson aimPerson, int pageSize, int pageNo);
	public List   getConfrim( User user, String aimPerson, int pageSize, int pageNo);
	public List   getAllConfrim(Bid bid, int pageSize, int pageNo);
	public Pager getReplyPhotoFratend(final String aimPersonId, final int pageSize, final int pageNo,final String username);
	//(bid, 1000, 1)
	//public boolean checkIsExtist(Object object...);
	public Pager listInvited( Map<String,Object> mapSqlParam, int pageSize, int pageNo);
	  public Pager findtousuList(final int pageSize,final int pageNo);
}//end class
