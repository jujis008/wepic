package com.wetuo.wepic.deal.dao ;
 
import java.util.List;
import java.util.Map;
 
import com.wetuo.wepic.deal.beans.BuyAccountOperationHistory;
import com.wetuo.wepic.common.hibernate.Pager;
 
public interface BuyAccountOperationHistoryDao {
 	
 	List<BuyAccountOperationHistory> findAll();
 	List<BuyAccountOperationHistory> findPart(String strFields,String[] strArrValues);
 	
	public Pager list(int pageSize, int pageNo)  ;
	public Pager list(String username, int pageSize, int pageNo) ;
	public Pager list(Map<String,Object>  mapSqlParam, int pageSize, int pageNo) ;
   	public BuyAccountOperationHistory select(String id);
	public String insert(BuyAccountOperationHistory record);
	public boolean update(BuyAccountOperationHistory record);
   	public boolean delete(BuyAccountOperationHistory record);
	public boolean delete(String id) ;
 
}//end class
