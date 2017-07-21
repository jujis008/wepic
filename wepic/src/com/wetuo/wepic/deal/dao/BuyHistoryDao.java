package com.wetuo.wepic.deal.dao ;
 
import java.util.List;
import java.util.Map;
 
import com.wetuo.wepic.deal.beans.BuyHistory;
import com.wetuo.wepic.common.hibernate.Pager;
 
public interface BuyHistoryDao {
 	
 	List<BuyHistory> findAll();
 	List<BuyHistory> findPart(String strFields,String[] strArrValues);
 	
	public Pager list(int pageSize, int pageNo)  ;
	public Pager list(String username, int pageSize, int pageNo) ;
	public Pager list(Map<String,Object>  mapSqlParam, int pageSize, int pageNo) ;
   	public BuyHistory select(String id);
	public String insert(BuyHistory record);
	public boolean update(BuyHistory record);
   	public boolean delete(BuyHistory record);
	public boolean delete(String id) ;
 
}//end class
