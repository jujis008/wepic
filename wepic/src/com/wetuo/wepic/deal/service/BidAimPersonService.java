package com.wetuo.wepic.deal.service ;
 
import java.util.List;
import java.util.Map;
 
import com.wetuo.wepic.deal.beans.Bid;
import com.wetuo.wepic.deal.beans.BidAimPerson;
import com.wetuo.wepic.common.hibernate.Pager;
 
public interface BidAimPersonService {
 
 	List<BidAimPerson> findAll();
 	List<BidAimPerson> findPart(String strFields,String[] strArrValues);
 	
	public Pager list(int pageSize, int pageNo)  ;
	public Pager list(String username, int pageSize, int pageNo) ;
	public Pager list(Map<String,Object>  mapSqlParam, int pageSize, int pageNo) ;
   	public BidAimPerson select(String id);
	public String insert(BidAimPerson record);
	public boolean update(BidAimPerson record);
   	public boolean delete(BidAimPerson record);
	public boolean delete(String id) ;
	public List<?> aimSelect(Bid bid, int pageSize, int pageNo);
}
