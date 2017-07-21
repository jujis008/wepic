package com.wetuo.wepic.core.service ;
 
import java.util.List;
import java.util.Map;
 
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.core.beans.UserCredit;
import com.wetuo.wepic.common.hibernate.Pager;
 
public interface UserCreditService {
 
 	List<UserCredit> findAll();
 	List<UserCredit> findPart(String strFields,String[] strArrValues);
 	
	public Pager list(int pageSize, int pageNo)  ;
	public Pager list(String username, int pageSize, int pageNo) ;
	public Pager list(Map<String,Object>  mapSqlParam, int pageSize, int pageNo) ;
   	public UserCredit select(Integer id);
	public UserCredit selectByUser(User user);
	public Integer insert(UserCredit record);
	public boolean update(UserCredit record);
   	public boolean delete(UserCredit record);
	public boolean delete(Integer id) ;
 
}//end class
