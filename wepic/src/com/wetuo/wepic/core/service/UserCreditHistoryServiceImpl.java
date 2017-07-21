package com.wetuo.wepic.core.service ;
 
import java.util.*;
import com.wetuo.wepic.core.beans.UserCreditHistory;
import com.wetuo.wepic.core.dao.UserCreditHistoryDao;
import com.wetuo.wepic.common.hibernate.Pager;
 
public class UserCreditHistoryServiceImpl implements UserCreditHistoryService {
	UserCreditHistoryDao domainDao;
	public UserCreditHistoryDao getUserCreditHistoryDao() {
		return domainDao;
	}//
	public void setUserCreditHistoryDao(UserCreditHistoryDao  domainDao) {
		this.domainDao = domainDao;
	}//
	
	//////////////common crud////////////////
	public List<UserCreditHistory> findAll(){ 
		return domainDao.findAll();
	}
	
	public List<UserCreditHistory> findPart(String strFields, String[] arrStrValues){ 
		return domainDao.findPart(strFields,arrStrValues);
	}
	
	public Pager list(int pageSize, int pageNo)  {
		return domainDao.list(pageSize,pageNo);
	}//end list()
	
	public Pager list(String username, int pageSize, int pageNo)  {
		return domainDao.list(username,pageSize,pageNo);
	}//end list()
	
	public Pager list(Map<String,Object> mapSqlParam, int pageSize, int pageNo)  {
		return domainDao.list(mapSqlParam,pageSize,pageNo);
	}//end list()
	
	/////insert///
	public Integer insert(UserCreditHistory record) {
		return domainDao.insert(record) ;
	}//end insert()
			
	/////delete///
	public boolean delete(UserCreditHistory record)  {
		return domainDao.delete(record);
	}//end delete()
			
	public boolean delete(Integer id)  {
		return domainDao.delete(id);
	}//end delete()
	
	/////update///
	public boolean update(UserCreditHistory record)  {
		return domainDao.update(record);
	}//end update()
			
	/////select///
	public UserCreditHistory select(Integer id)  {
		return domainDao.select(id);
	}//end select()
	
}//end class
