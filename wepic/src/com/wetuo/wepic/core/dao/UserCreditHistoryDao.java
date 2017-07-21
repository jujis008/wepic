package com.wetuo.wepic.core.dao ;
 
import java.util.List;
import java.util.Map;
 
import com.wetuo.wepic.core.beans.UserCreditHistory;
import com.wetuo.wepic.common.hibernate.Pager;
 
public interface UserCreditHistoryDao {
 	
 	List<UserCreditHistory> findAll();
 	List<UserCreditHistory> findPart(String strFields,String[] strArrValues);
 	
	public Pager list(int pageSize, int pageNo)  ;
	public Pager list(String username, int pageSize, int pageNo) ;
	public Pager list(Map<String,Object>  mapSqlParam, int pageSize, int pageNo) ;
   	public UserCreditHistory select(Integer id);
	public Integer insert(UserCreditHistory record);
	public boolean update(UserCreditHistory record);
   	public boolean delete(UserCreditHistory record);
	public boolean delete(Integer id) ;
 
}//end class
