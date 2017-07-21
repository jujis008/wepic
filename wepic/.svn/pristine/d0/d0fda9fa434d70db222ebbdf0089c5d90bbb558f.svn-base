package com.wetuo.wepic.core.service ;
 
import java.util.*;

import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.core.beans.UserCredit;
import com.wetuo.wepic.core.dao.UserCreditDao;
import com.wetuo.wepic.common.hibernate.Pager;
 
public class UserCreditServiceImpl implements UserCreditService {
	UserCreditDao domainDao;
	public UserCreditDao getUserCreditDao() {
		return domainDao;
	}//
	public void setUserCreditDao(UserCreditDao  domainDao) {
		this.domainDao = domainDao;
	}//
	
	//////////////common crud////////////////
	public List<UserCredit> findAll(){ 
		return domainDao.findAll();
	}
	
	public List<UserCredit> findPart(String strFields, String[] arrStrValues){ 
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
	public Integer insert(UserCredit record) {
		return domainDao.insert(record) ;
	}//end insert()
			
	/////delete///
	public boolean delete(UserCredit record)  {
		return domainDao.delete(record);
	}//end delete()
			
	public boolean delete(Integer id)  {
		return domainDao.delete(id);
	}//end delete()
	
	/////update///
	public boolean update(UserCredit record)  {
		return domainDao.update(record);
	}//end update()
			
	/////select///
	public UserCredit select(Integer id)  {
		return domainDao.select(id);
	}//end select()
	public UserCredit selectByUser(User user) {
		// TODO Auto-generated method stub
		return domainDao.selectByUser(user);
	}
	
}//end class
