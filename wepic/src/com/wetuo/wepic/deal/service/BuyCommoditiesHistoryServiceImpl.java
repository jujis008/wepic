package com.wetuo.wepic.deal.service ;
 
import java.util.*;
import com.wetuo.wepic.deal.beans.BuyCommoditiesHistory;
import com.wetuo.wepic.deal.dao.BuyCommoditiesHistoryDao;
import com.wetuo.wepic.common.hibernate.Pager;
 
public class BuyCommoditiesHistoryServiceImpl implements BuyCommoditiesHistoryService {
	BuyCommoditiesHistoryDao domainDao;
	public BuyCommoditiesHistoryDao getBuyCommoditiesHistoryDao() {
		return domainDao;
	}//
	public void setBuyCommoditiesHistoryDao(BuyCommoditiesHistoryDao  domainDao) {
		this.domainDao = domainDao;
	}//
	
	//////////////common crud////////////////
	public List<BuyCommoditiesHistory> findAll(){ 
		return domainDao.findAll();
	}
	
	public List<BuyCommoditiesHistory> findPart(String strFields, String[] arrStrValues){ 
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
	public String insert(BuyCommoditiesHistory record) {
		return domainDao.insert(record) ;
	}//end insert()
			
	/////delete///
	public boolean delete(BuyCommoditiesHistory record)  {
		return domainDao.delete(record);
	}//end delete()
			
	public boolean delete(String id)  {
		return domainDao.delete(id);
	}//end delete()
	
	/////update///
	public boolean update(BuyCommoditiesHistory record)  {
		return domainDao.update(record);
	}//end update()
			
	/////select///
	public BuyCommoditiesHistory select(String id)  {
		return domainDao.select(id);
	}//end select()
	
}//end class
