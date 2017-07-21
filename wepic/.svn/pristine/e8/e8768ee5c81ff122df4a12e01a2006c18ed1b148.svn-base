package com.wetuo.wepic.deal.service ;
 
import java.util.List;
import java.util.Map;
 
import com.wetuo.wepic.deal.beans.Bid;
import com.wetuo.wepic.deal.beans.BidForOpus;
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.core.beans.User;
 
public interface BidForOpusService {
 
 	List<BidForOpus> findAll();
 	List<BidForOpus> findPart(String strFields,String[] strArrValues);
 	
	public Pager list(int pageSize, int pageNo)  ;
	public Pager list(String username, int pageSize, int pageNo) ;
	public Pager list(Bid bid, int pageSize, int pageNo) ;
	public Pager list(Map<String,Object>  mapSqlParam, int pageSize, int pageNo) ;
   	public BidForOpus select(String id);
	public BidForOpus selectById(String id);
	public List getConfirm(String bidid);
	public Pager confirmlist( Bid bid, int pageSize, int pageNo) ;
	public String insert(BidForOpus record);
	public boolean update(BidForOpus record);
   	public boolean delete(BidForOpus record);
	public boolean delete(String id) ;
	public Pager getConfirmImgPager( String bidid, int pageNo, int pageSize);
	public Pager getallBidForOpus(Bid bid,final int pageNo,final int pageSize);
	public Pager yingyaojilu(final User user,final int pageSize,final int pageNo) ;
	
 
}//end class
