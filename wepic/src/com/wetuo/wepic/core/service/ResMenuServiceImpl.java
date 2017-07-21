package com.wetuo.wepic.core.service ;
 
import java.util.*;

import com.wetuo.wepic.core.beans.ResMenu;
import com.wetuo.wepic.core.beans.UserCat;
import com.wetuo.wepic.core.dao.ResMenuDao;
import com.wetuo.wepic.common.hibernate.Pager;
 
public class ResMenuServiceImpl implements ResMenuService {
	ResMenuDao domainDao;
	public ResMenuDao getResMenuDao() {
		return domainDao;
	}//
	public void setResMenuDao(ResMenuDao  domainDao) {
		this.domainDao = domainDao;
	}//
	
	//////////////common crud////////////////
	public List<ResMenu> findAll(){ 
		return domainDao.findAll();
	}
	
	public List<ResMenu> findPart(String strFields, String[] arrStrValues){ 
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
	public Integer insert(ResMenu record) {
		return domainDao.insert(record) ;
	}//end insert()
			
	/////delete///
	public boolean delete(ResMenu record)  {
		return domainDao.delete(record);
	}//end delete()
			
	public boolean delete(Integer id)  {
		return domainDao.delete(id);
	}//end delete()
	
	/////update///
	public boolean update(ResMenu record)  {
		return domainDao.update(record);
	}//end update()
			
	/////select///
	public ResMenu select(Integer id)  {
		return domainDao.select(id);
	}//end select()
	public Pager list(UserCat userCat, int pageSize, int pageNo) {
		// TODO Auto-generated method stub
		return domainDao.list(userCat, pageSize, pageNo);
	}
	public Pager list(int userCatId, int pageSize, int pageNo) {
		// TODO Auto-generated method stub
		return domainDao.list(userCatId, pageSize, pageNo);
	}
	public List<ResMenu> find(int userCatId) {
		// TODO Auto-generated method stub
		return domainDao.find(userCatId); 
	}
	public List<ResMenu> findReadOnly(int userCatId) {
		// TODO Auto-generated method stub
		return domainDao.findReadOnly(userCatId);
	}
	
}//end class
