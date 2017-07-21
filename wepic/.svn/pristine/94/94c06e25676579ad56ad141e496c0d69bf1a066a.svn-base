package com.wetuo.wepic.core.dao ;
 
import java.util.List;
import java.util.Map;
 
import com.wetuo.wepic.core.beans.UserHistory;
import com.wetuo.wepic.common.hibernate.Pager;
 
public interface UserHistoryDao {
 	
 	List<UserHistory> findAll();
 	List<UserHistory> findPart(String strFields,String[] strArrValues);
 	
	public Pager list(int pageSize, int pageNo)  ;
	public Pager list(String username, int pageSize, int pageNo) ;
	public Pager list(Map<String,Object>  mapSqlParam, int pageSize, int pageNo) ;
   	public UserHistory select(Integer id);
	public Integer insert(UserHistory record);
	public boolean update(UserHistory record);
   	public boolean delete(UserHistory record);
	public boolean delete(Integer id) ;
 
}//end class
