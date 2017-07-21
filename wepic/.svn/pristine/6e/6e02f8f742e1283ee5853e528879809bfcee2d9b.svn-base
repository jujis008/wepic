package com.wetuo.wepic.deal.dao ;
 
import java.util.List;
import java.util.Map;
 
import com.wetuo.wepic.deal.beans.BuyCommoditiesHistory;
import com.wetuo.wepic.common.hibernate.Pager;
 
public interface BuyCommoditiesHistoryDao {
 	
 	List<BuyCommoditiesHistory> findAll();
 	List<BuyCommoditiesHistory> findPart(String strFields,String[] strArrValues);
 	
	public Pager list(int pageSize, int pageNo)  ;
	public Pager list(String username, int pageSize, int pageNo) ;
	public Pager list(Map<String,Object>  mapSqlParam, int pageSize, int pageNo) ;
   	public BuyCommoditiesHistory select(String id);
	public String insert(BuyCommoditiesHistory record);
	public boolean update(BuyCommoditiesHistory record);
   	public boolean delete(BuyCommoditiesHistory record);
	public boolean delete(String id) ;
 
}//end class
