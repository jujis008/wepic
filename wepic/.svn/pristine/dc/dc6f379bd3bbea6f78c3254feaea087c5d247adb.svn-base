package com.wetuo.wepic.deal.service ;
 
import java.util.List;
import java.util.Map;
 
import com.wetuo.wepic.deal.beans.BidReceiverConfirmChange;
import com.wetuo.wepic.common.hibernate.Pager;
 
public interface BidReceiverConfirmChangeService {
 
 	List<BidReceiverConfirmChange> findAll();
 	List<BidReceiverConfirmChange> findPart(String strFields,String[] strArrValues);
 	
	public Pager list(int pageSize, int pageNo)  ;
	public Pager list(String username, int pageSize, int pageNo) ;
	public Pager list(Map<String,Object>  mapSqlParam, int pageSize, int pageNo) ;
   	public BidReceiverConfirmChange select(String id);
	public String insert(BidReceiverConfirmChange record);
	public boolean update(BidReceiverConfirmChange record);
   	public boolean delete(BidReceiverConfirmChange record);
	public boolean delete(String id) ;
 
}//end class
