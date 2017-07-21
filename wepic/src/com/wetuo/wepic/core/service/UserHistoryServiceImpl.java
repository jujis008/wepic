package com.wetuo.wepic.core.service ;
 
import java.util.*;
import com.wetuo.wepic.core.beans.UserHistory;
import com.wetuo.wepic.core.dao.UserHistoryDao;
import com.wetuo.wepic.common.hibernate.Pager;
 
public class UserHistoryServiceImpl implements UserHistoryService {
	UserHistoryDao domainDao;
	public UserHistoryDao getUserHistoryDao() {
		return domainDao;
	}//
	public void setUserHistoryDao(UserHistoryDao  domainDao) {
		this.domainDao = domainDao;
	}//
	
	//////////////common crud////////////////
	public List<UserHistory> findAll(){ 
		return domainDao.findAll();
	}
	
	public List<UserHistory> findPart(String strFields, String[] arrStrValues){ 
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
	public Integer insert(UserHistory record) {
		return domainDao.insert(record) ;
	}//end insert()
			
	/////delete///
	public boolean delete(UserHistory record)  {
		return domainDao.delete(record);
	}//end delete()
			
	public boolean delete(Integer id)  {
		return domainDao.delete(id);
	}//end delete()
	
	/////update///
	public boolean update(UserHistory record)  {
		return domainDao.update(record);
	}//end update()
			
	/////select///
	public UserHistory select(Integer id)  {
		return domainDao.select(id);
	}//end select()
	
}//end class
