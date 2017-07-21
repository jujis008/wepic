package com.wetuo.wepic.core.service ;
 
import java.util.List;
import java.util.Map;
 
import com.wetuo.wepic.core.beans.ResMenu;
import com.wetuo.wepic.core.beans.UserCat;
import com.wetuo.wepic.common.hibernate.Pager;
 
public interface ResMenuService {
	public List<ResMenu> find(final int userCatId)  ;
 	List<ResMenu> findAll();
 	List<ResMenu> findPart(String strFields,String[] strArrValues);
 	public List<ResMenu> findReadOnly(final int userCatId)  ;
 	
	public Pager list(int pageSize, int pageNo)  ;
	public Pager list(String username, int pageSize, int pageNo) ;
	public Pager list(Map<String,Object>  mapSqlParam, int pageSize, int pageNo) ;
   	public ResMenu select(Integer id);
	public Integer insert(ResMenu record);
	public boolean update(ResMenu record);
   	public boolean delete(ResMenu record);
	public boolean delete(Integer id) ;
	
	public Pager list(final UserCat userCat ,final int pageSize,final int pageNo) ;
	public Pager list(final int userCatId ,final int pageSize,final int pageNo)  ;
	 
 
}//end class
