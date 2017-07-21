package com.wetuo.wepic.core.service ;
 
import java.util.*;

import org.hibernate.criterion.DetachedCriteria;

import com.wetuo.wepic.core.beans.UserDetail;
import com.wetuo.wepic.core.dao.UserDetailDao;
import com.wetuo.wepic.common.hibernate.Pager;
 
public class UserDetailServiceImpl implements UserDetailService {
	UserDetailDao domainDao;
	public UserDetailDao getUserDetailDao() {
		return domainDao;
	}//
	public void setUserDetailDao(UserDetailDao  domainDao) {
		this.domainDao = domainDao;
	}//
	
	//////////////common crud////////////////
	public List<UserDetail> findAll(){ 
		return domainDao.findAll();
	}
	
	public List<UserDetail> findPart(String strFields, String[] arrStrValues){ 
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
	public Integer insert(UserDetail record) {
		return domainDao.insert(record) ;
	}//end insert()
			
	/////delete///
	public boolean delete(UserDetail record)  {
		return domainDao.delete(record);
	}//end delete()
			
	public boolean delete(Integer id)  {
		return domainDao.delete(id);
	}//end delete()
	
	/////update///
	public boolean update(UserDetail record)  {
		return domainDao.update(record);
	}//end update()
			
	/////select///
	public UserDetail select(Integer id)  {
		return domainDao.select(id);
	}//end select()
	public List<UserDetail> findAllUserPower(DetachedCriteria detachedCriteria) {
		// TODO Auto-generated method stub
		return domainDao.findAllUserPower(detachedCriteria);
	}
	
}//end class
