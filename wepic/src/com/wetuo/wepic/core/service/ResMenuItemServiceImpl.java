package com.wetuo.wepic.core.service ;
 
import java.util.*;

import com.wetuo.wepic.core.beans.ResMenuItem;
import com.wetuo.wepic.core.dao.ResMenuItemDao;
import com.wetuo.wepic.common.hibernate.Pager;
 
public class ResMenuItemServiceImpl implements ResMenuItemService {
	ResMenuItemDao domainDao;
	public ResMenuItemDao getResMenuItemDao() {
		return domainDao;
	}//
	public void setResMenuItemDao(ResMenuItemDao  domainDao) {
		this.domainDao = domainDao;
	}//
	
	//////////////common crud////////////////
	public List<ResMenuItem> findAll(){ 
		return domainDao.findAll();
	}
	
	public List<ResMenuItem> findPart(String strFields, String[] arrStrValues){ 
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
	public Integer insert(ResMenuItem record) {
		return domainDao.insert(record) ;
	}//end insert()
			
	/////delete///
	public boolean delete(ResMenuItem record)  {
		return domainDao.delete(record);
	}//end delete()
			
	public boolean delete(Integer id)  {
		return domainDao.delete(id);
	}//end delete()
	
	/////update///
	public boolean update(ResMenuItem record)  {
		return domainDao.update(record);
	}//end update()
			
	/////select///
	public ResMenuItem select(Integer id)  {
		return domainDao.select(id);
	}//end select()
	public List<ResMenuItem> findByMenu(int menuId) {
		// TODO Auto-generated method stub
		return domainDao.findByMenu(menuId); 
	}
	public Pager pagerByMenu(int menuId, int pageSize, int pageNo) {
		// TODO Auto-generated method stub
		return domainDao.pagerByMenu(menuId, pageSize, pageNo);
	}
	
}//end class
