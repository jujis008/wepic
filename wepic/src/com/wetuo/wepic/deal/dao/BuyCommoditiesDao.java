package com.wetuo.wepic.deal.dao ;
 
import java.util.List;
import java.util.Map;
 
import com.wetuo.wepic.deal.beans.BuyCommodities;
import com.wetuo.wepic.publish.beans.Publish;
import com.wetuo.wepic.common.hibernate.Pager;
 
public interface BuyCommoditiesDao {
 	
 	List<BuyCommodities> findAll();
 	List<BuyCommodities> findPart(String strFields,String[] strArrValues);
 	
	public Pager list(int pageSize, int pageNo)  ;
	public Pager list(String username, int pageSize, int pageNo) ;
	public Pager list(Map<String,Object>  mapSqlParam, int pageSize, int pageNo) ;
   	public BuyCommodities select(String id);
	public String insert(BuyCommodities record);
	public boolean update(BuyCommodities record);
   	public boolean delete(BuyCommodities record);
	public boolean delete(String id) ;
	public List<BuyCommodities> findByCartDeal(String cartdealId);
	public Pager PagerfindByCartDeal(String cartdealId,int nowPage,int pageSize);
	public List selectByCatBulish(String catId);
	public List<BuyCommodities> publishOfCommody(Publish publish);
	public int getbuyCount(String data);
}//end class
