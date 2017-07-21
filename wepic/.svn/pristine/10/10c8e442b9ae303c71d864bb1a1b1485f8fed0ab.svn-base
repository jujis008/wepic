package com.wetuo.wepic.deal.service ;
 
import java.util.List;
import java.util.Map;
 
import com.wetuo.wepic.deal.beans.BidDetail;
import com.wetuo.wepic.common.hibernate.Pager;
 
public interface BidDetailService {
 
 	List<BidDetail> findAll();
 	List<BidDetail> findPart(String strFields,String[] strArrValues);
 	
	public Pager list(int pageSize, int pageNo)  ;
	public Pager list(String username, int pageSize, int pageNo) ;
	public Pager list(Map<String,Object>  mapSqlParam, int pageSize, int pageNo) ;
   	public BidDetail select(String id);
	public String insert(BidDetail record);
	public boolean update(BidDetail record);
   	public boolean delete(BidDetail record);
	public boolean delete(String id) ;
 
}//end class
