package com.wetuo.wepic.core.dao ;
 
import java.util.List;
import java.util.Map;
 
import com.wetuo.wepic.core.beans.LoginHistory;
import com.wetuo.wepic.common.hibernate.Pager;
 
public interface LoginHistoryDao {
 	
 	List<LoginHistory> findAll();
 	List<LoginHistory> findPart(String strFields,String[] strArrValues);
 	
	public Pager list(int pageSize, int pageNo)  ;
	public Pager list(String username, int pageSize, int pageNo) ;
	public Pager list(Map<String,Object>  mapSqlParam, int pageSize, int pageNo) ;
   	public LoginHistory select(Integer id);
	public Integer insert(LoginHistory record);
	public boolean update(LoginHistory record);
   	public boolean delete(LoginHistory record);
	public boolean delete(Integer id) ;
	public LoginHistory recentlylogininfo();
}//end class
