package com.wetuo.wepic.deal.dao ;
 
import java.util.List;
import java.util.Map;
 
import com.wetuo.wepic.deal.beans.Bid;
import com.wetuo.wepic.deal.beans.BidAimPerson;
import com.wetuo.wepic.common.hibernate.Pager;
 
public interface BidAimPersonDao {
 	
 	List<BidAimPerson> findAll();
 	List<BidAimPerson> findPart(String strFields,String[] strArrValues);
 	
	public Pager list(int pageSize, int pageNo)  ;
	public Pager list(String username, int pageSize, int pageNo) ;
	public Pager list(Map<String,Object>  mapSqlParam, int pageSize, int pageNo) ;
   	public BidAimPerson select(String id);
   	
   	public List<?> listBidAim(Bid bid, int pageSize, int pageNo);
	public String insert(BidAimPerson record);
	public boolean update(BidAimPerson record);
   	public boolean delete(BidAimPerson record);
	public boolean delete(String id) ;
 
}//end class
