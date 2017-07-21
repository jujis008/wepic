package com.wetuo.wepic.deal.service ;
 
import java.util.*;

import com.wetuo.wepic.deal.beans.BuyAccountOperation;
import com.wetuo.wepic.deal.dao.BuyAccountOperationDao;
import com.wetuo.wepic.common.hibernate.Pager;
 
public class BuyAccountOperationServiceImpl implements BuyAccountOperationService {
	BuyAccountOperationDao domainDao;
	public BuyAccountOperationDao getBuyAccountOperationDao() {
		return domainDao;
	}//
	public void setBuyAccountOperationDao(BuyAccountOperationDao  domainDao) {
		this.domainDao = domainDao;
	}//
	
	//////////////common crud////////////////
	public List<BuyAccountOperation> findAll(){ 
		return domainDao.findAll();
	}
	
	public List<BuyAccountOperation> findPart(String strFields, String[] arrStrValues){ 
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
	public String insert(BuyAccountOperation record) {
		return domainDao.insert(record) ;
	}//end insert()
			
	/////delete///
	public boolean delete(BuyAccountOperation record)  {
		return domainDao.delete(record);
	}//end delete()
			
	public boolean delete(String id)  {
		return domainDao.delete(id);
	}//end delete()
	
	/////update///
	public boolean update(BuyAccountOperation record)  {
		return domainDao.update(record);
	}//end update()
			
	/////select///
	public BuyAccountOperation select(String id)  {
		return domainDao.select(id);
	}//end select()
	public List findById(int accountId) {
		// TODO Auto-generated method stub
		return domainDao.findById(accountId);
	}
	public List sellFindById(int accountId) {
		// TODO Auto-generated method stub
		return domainDao.sellFindById(accountId);
	}
	
}//end class
