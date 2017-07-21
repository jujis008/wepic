package com.wetuo.wepic.deal.service ;
 
import java.util.List;
import java.util.Map;
 
import com.wetuo.wepic.deal.beans.BuyAccountOperation;
import com.wetuo.wepic.common.hibernate.Pager;
 
public interface BuyAccountOperationService {
 
 	List<BuyAccountOperation> findAll();
 	List<BuyAccountOperation> findPart(String strFields,String[] strArrValues);
 	
	public Pager list(int pageSize, int pageNo)  ;
	public Pager list(String username, int pageSize, int pageNo) ;
	public Pager list(Map<String,Object>  mapSqlParam, int pageSize, int pageNo) ;
   	public BuyAccountOperation select(String id);
	public String insert(BuyAccountOperation record);
	public boolean update(BuyAccountOperation record);
   	public boolean delete(BuyAccountOperation record);
	public boolean delete(String id) ;
	List findById(int accountId);
	List sellFindById(int accountId);
 
}//end class
