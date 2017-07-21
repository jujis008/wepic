package com.wetuo.wepic.deal.service ;
 
import java.util.*;
import com.wetuo.wepic.deal.beans.BuyAccountOperationHistory;
import com.wetuo.wepic.deal.dao.BuyAccountOperationHistoryDao;
import com.wetuo.wepic.common.hibernate.Pager;
 
public class BuyAccountOperationHistoryServiceImpl implements BuyAccountOperationHistoryService {
	BuyAccountOperationHistoryDao domainDao;
	public BuyAccountOperationHistoryDao getBuyAccountOperationHistoryDao() {
		return domainDao;
	}//
	public void setBuyAccountOperationHistoryDao(BuyAccountOperationHistoryDao  domainDao) {
		this.domainDao = domainDao;
	}//
	
	//////////////common crud////////////////
	public List<BuyAccountOperationHistory> findAll(){ 
		return domainDao.findAll();
	}
	
	public List<BuyAccountOperationHistory> findPart(String strFields, String[] arrStrValues){ 
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
	public String insert(BuyAccountOperationHistory record) {
		return domainDao.insert(record) ;
	}//end insert()
			
	/////delete///
	public boolean delete(BuyAccountOperationHistory record)  {
		return domainDao.delete(record);
	}//end delete()
			
	public boolean delete(String id)  {
		return domainDao.delete(id);
	}//end delete()
	
	/////update///
	public boolean update(BuyAccountOperationHistory record)  {
		return domainDao.update(record);
	}//end update()
			
	/////select///
	public BuyAccountOperationHistory select(String id)  {
		return domainDao.select(id);
	}//end select()
	
}//end class
