package com.wetuo.wepic.core.service ;
 
import java.util.List;
import java.util.Map;
 
import com.wetuo.wepic.core.beans.UserCat;
import com.wetuo.wepic.common.hibernate.Pager;
 
public interface UserCatService {
	public List<UserCat> find(final String type);
	
	
	
	
	
	
	
	
	/******************2.0以上的版本*****************************************************************/
 	List<UserCat> findAll();
 	List<UserCat> findPart(String strFields,String[] strArrValues);
 	
	public Pager list(int pageSize, int pageNo)  ;
	public Pager list(String username, int pageSize, int pageNo) ;
	public Pager list(Map<String,Object>  mapSqlParam, int pageSize, int pageNo) ;
   	public UserCat select(Integer id);
   	public UserCat findByPid(Integer id);
	public Integer insert(UserCat record);
	public boolean update(UserCat record);
   	public boolean delete(UserCat record);
	public boolean delete(Integer id) ;
	
	public Map<UserCat,List<UserCat>> getUserCatMapUnderProjectCat(int pid);
	public List<List<UserCat>>  getLevel2UserCatMapUnderProjectCat(int pid);
	public List<UserCat> getUserCatListJustUnderProjectCat(int pid);
	public List<UserCat> getUserCatListUnderProjectCat(int pid);
	public List<UserCat> getNextLevelCatList(List<UserCat> list);
	public List<UserCat> getUserCatListUnderPid(int pid);
	public List<UserCat> getUserCatListForRegister() ;
	
	
	public UserCat findFather(final int id)  ;
	public List<UserCat> findAllFathers(final int id)  ;
	public List<UserCat> getuserCatListJustUnderCat(int pid);
	public List<UserCat> getUserCatListUnderUserCat(int pid);
}//end class
