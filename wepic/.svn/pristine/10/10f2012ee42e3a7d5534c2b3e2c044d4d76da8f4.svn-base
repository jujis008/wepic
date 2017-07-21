package com.wetuo.wepic.deal.service ;
 
import java.util.*;

import com.wetuo.wepic.deal.beans.BuyCommodities;
import com.wetuo.wepic.deal.dao.BuyCommoditiesDao;
import com.wetuo.wepic.publish.beans.Publish;
import com.wetuo.wepic.common.hibernate.Pager;
 
public class BuyCommoditiesServiceImpl implements BuyCommoditiesService {
	BuyCommoditiesDao domainDao;
	public BuyCommoditiesDao getBuyCommoditiesDao() {
		return domainDao;
	}//
	public void setBuyCommoditiesDao(BuyCommoditiesDao  domainDao) {
		this.domainDao = domainDao;
	}//
	
	//////////////common crud////////////////
	public List<BuyCommodities> findAll(){ 
		return domainDao.findAll();
	}
	
	public List<BuyCommodities> findPart(String strFields, String[] arrStrValues){ 
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
	public String insert(BuyCommodities record) {
		return domainDao.insert(record) ;
	}//end insert()
			
	/////delete///
	public boolean delete(BuyCommodities record)  {
		return domainDao.delete(record);
	}//end delete()
			
	public boolean delete(String id)  {
		return domainDao.delete(id);
	}//end delete()
	
	/////update///
	public boolean update(BuyCommodities record)  {
		return domainDao.update(record);
	}//end update()
			
	/////select///
	public BuyCommodities select(String id)  {
		return domainDao.select(id);
	}//end select()
	public List<BuyCommodities> findByCartDeal(String cartdealId) {
		// TODO Auto-generated method stub
		return domainDao.findByCartDeal(cartdealId);
	}
	public List selectByCatBulish(String catId) {
		// TODO Auto-generated method stub
		return domainDao.selectByCatBulish(catId);
	}
	public List<BuyCommodities> publishOfCommody(Publish publish){
		return domainDao.publishOfCommody(publish);
	}
	public int getbuyCount(String data) {
		// TODO Auto-generated method stub
		return domainDao.getbuyCount(data);
	}
}//end class
