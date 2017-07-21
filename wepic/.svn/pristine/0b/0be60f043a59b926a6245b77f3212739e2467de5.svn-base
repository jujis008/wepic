package com.wetuo.wepic.core.service ;
 
import java.util.*;
import com.wetuo.wepic.core.beans.LoginHistory;
import com.wetuo.wepic.core.dao.LoginHistoryDao;
import com.wetuo.wepic.common.hibernate.Pager;
 
public class LoginHistoryServiceImpl implements LoginHistoryService {
	LoginHistoryDao domainDao;
	public LoginHistoryDao getLoginHistoryDao() {
		return domainDao;
	}//
	public void setLoginHistoryDao(LoginHistoryDao  domainDao) {
		this.domainDao = domainDao;
	}//
	
	//////////////common crud////////////////
	public List<LoginHistory> findAll(){ 
		return domainDao.findAll();
	}
	
	public List<LoginHistory> findPart(String strFields, String[] arrStrValues){ 
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
	public Integer insert(LoginHistory record) {
		return domainDao.insert(record) ;
	}//end insert()
			
	/////delete///
	public boolean delete(LoginHistory record)  {
		return domainDao.delete(record);
	}//end delete()
			
	public boolean delete(Integer id)  {
		return domainDao.delete(id);
	}//end delete()
	
	/////update///
	public boolean update(LoginHistory record)  {
		return domainDao.update(record);
	}//end update()
			
	/////select///
	public LoginHistory select(Integer id)  {
		return domainDao.select(id);
	}//end select()
	
	public LoginHistory recentlylogininfo(){
		return domainDao.recentlylogininfo();
	}
	
}//end class
