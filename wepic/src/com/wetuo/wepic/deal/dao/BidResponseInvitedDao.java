package com.wetuo.wepic.deal.dao ;
 
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
 
import com.wetuo.wepic.deal.beans.Bid;
import com.wetuo.wepic.deal.beans.BidAimPerson;
import com.wetuo.wepic.deal.beans.BidResponseInvited;
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.core.beans.User;
 
public interface BidResponseInvitedDao {
 	
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
	public List   listConfirm(final User user,final BidAimPerson aimPerson,final int pageSize,final int pageNo);
	public List   listAllConfirm(final Bid bid,final int pageSize,final int pageNo);
	public Pager listInvited( Map<String,Object> mapSqlParam, int pageSize, int pageNo);
	public Pager getReplyPhotoFratend(final String aimPersonId, final int pageSize, final int pageNo,final String username);
    public Pager findtousuList(final int pageSize,final int pageNo);
    
    
    
    
    public Pager findByDetachedCriteria(DetachedCriteria detachedCriteria,int nowPage,int pageSize);
}//end class
