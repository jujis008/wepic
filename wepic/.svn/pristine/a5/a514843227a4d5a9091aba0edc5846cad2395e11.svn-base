package com.wetuo.wepic.core.service ;
 
import java.util.*;

import com.wetuo.wepic.core.beans.ResLeftSideItem;
import com.wetuo.wepic.core.dao.ResLeftSideItemDao;
import com.wetuo.wepic.common.hibernate.Pager;
 
public class ResLeftSideItemServiceImpl implements ResLeftSideItemService {
	ResLeftSideItemDao domainDao;
	public ResLeftSideItemDao getResLeftSideItemDao() {
		return domainDao;
	}//
	public void setResLeftSideItemDao(ResLeftSideItemDao  domainDao) {
		this.domainDao = domainDao;
	}//
	
	//////////////common crud////////////////
	public List<ResLeftSideItem> findAll(){ 
		return domainDao.findAll();
	}
	
	public List<ResLeftSideItem> findPart(String strFields, String[] arrStrValues){ 
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
	public Integer insert(ResLeftSideItem record) {
		return domainDao.insert(record) ;
	}//end insert()
			
	/////delete///
	public boolean delete(ResLeftSideItem record)  {
		return domainDao.delete(record);
	}//end delete()
			
	public boolean delete(Integer id)  {
		return domainDao.delete(id);
	}//end delete()
	
	/////update///
	public boolean update(ResLeftSideItem record)  {
		return domainDao.update(record);
	}//end update()
			
	/////select///
	public ResLeftSideItem select(Integer id)  {
		return domainDao.select(id);
	}//end select()
	public List<ResLeftSideItem> findByMenu(int menuId) {
		// TODO Auto-generated method stub
		return domainDao.findByMenu(menuId); 
	}
	public Pager pagerByMenu(int menuId, int pageSize, int pageNo) {
		// TODO Auto-generated method stub
		return domainDao.pagerByMenu(menuId, pageSize, pageNo); 
	}
	public Pager listByMenu(int menuId, int pageSize, int pageNo) {
		// TODO Auto-generated method stub
		return domainDao.listByMenu(menuId, pageSize, pageNo); 
	}
	
}//end class
