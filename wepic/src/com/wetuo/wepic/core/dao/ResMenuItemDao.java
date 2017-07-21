package com.wetuo.wepic.core.dao ;
 
import java.util.List;
import java.util.Map;
 
import com.wetuo.wepic.core.beans.ResMenuItem;
import com.wetuo.wepic.common.hibernate.Pager;
 
public interface ResMenuItemDao {
	public List<ResMenuItem> findByMenu(int menuId) ;
	public List<ResMenuItem> findAll();
	public List<ResMenuItem> findPart(String strFields,String[] strArrValues);
	public Pager pagerByMenu( final int menuId, final int pageSize, final int pageNo );
 	
	public Pager list(int pageSize, int pageNo)  ;
	public Pager list(String username, int pageSize, int pageNo) ;
	public Pager list(Map<String,Object>  mapSqlParam, int pageSize, int pageNo) ;
   	public ResMenuItem select(Integer id);
	public Integer insert(ResMenuItem record);
	public boolean update(ResMenuItem record);
   	public boolean delete(ResMenuItem record);
	public boolean delete(Integer id) ;
 
}//end class
