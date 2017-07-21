package com.wetuo.wepic.deal.dao ;
 
import java.util.List;
import java.util.Map;
 
import com.wetuo.wepic.deal.beans.Bid;
import com.wetuo.wepic.deal.beans.BidAccountOperation;
import com.wetuo.wepic.common.hibernate.Pager;
 
public interface BidAccountOperationDao {
 	
 	List<BidAccountOperation> findAll();
 	List<BidAccountOperation> findPart(String strFields,String[] strArrValues);
 	List<BidAccountOperation> findPart(String strFields,Bid strArrValues);
 	
	public Pager list(int pageSize, int pageNo)  ;
	public Pager list(String username, int pageSize, int pageNo) ;
	public Pager list(Map<String,Object>  mapSqlParam, int pageSize, int pageNo) ;
   	public BidAccountOperation select(String id);
	public String insert(BidAccountOperation record);
	public boolean update(BidAccountOperation record);
   	public boolean delete(BidAccountOperation record);
	public boolean delete(String id) ;
	public Pager selectByAcoount(String flag, String accountId, int pageSize, int nowPage);
	public Pager getCountBidDeal(int pageSize, int pageNo);
}//end class
