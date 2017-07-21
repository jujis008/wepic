package com.wetuo.wepic.core.service ;
 
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
 
import com.wetuo.wepic.core.beans.UserDetail;
import com.wetuo.wepic.common.hibernate.Pager;
 
public interface UserDetailService {
 
 	List<UserDetail> findAll();
 	List<UserDetail> findPart(String strFields,String[] strArrValues);
 	
	public Pager list(int pageSize, int pageNo)  ;
	public Pager list(String username, int pageSize, int pageNo) ;
	public Pager list(Map<String,Object>  mapSqlParam, int pageSize, int pageNo) ;
   	public UserDetail select(Integer id);
	public Integer insert(UserDetail record);
	public boolean update(UserDetail record);
   	public boolean delete(UserDetail record);
	public boolean delete(Integer id) ;
	public List<UserDetail> findAllUserPower(DetachedCriteria detachedCriteria);
 
}//end class
