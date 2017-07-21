package com.wetuo.wepic.core.dao ;
 
import java.util.List;
import java.util.Map;
 
import com.wetuo.wepic.core.beans.ResLeftSideItem;
import com.wetuo.wepic.common.hibernate.Pager;
 
public interface ResLeftSideItemDao {
 	
 	List<ResLeftSideItem> findAll();
 	List<ResLeftSideItem> findPart(String strFields,String[] strArrValues);
 	public List<ResLeftSideItem> findByMenu(int menuId);
 	public Pager pagerByMenu( final int menuId, final int pageSize, final int pageNo ) ;
 	
	public Pager list(int pageSize, int pageNo)  ;
	public Pager list(String username, int pageSize, int pageNo) ;
	public Pager list(Map<String,Object>  mapSqlParam, int pageSize, int pageNo) ;
   	public ResLeftSideItem select(Integer id);
	public Integer insert(ResLeftSideItem record);
	public boolean update(ResLeftSideItem record);
   	public boolean delete(ResLeftSideItem record);
	public boolean delete(Integer id) ;
	
	public Pager listByMenu(final int menuId, final int pageSize,final int pageNo) ;
 
}//end class
