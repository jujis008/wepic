package com.wetuo.wepic.deal.service ;
 
import java.util.*;
import com.wetuo.wepic.deal.beans.BidDetail;
import com.wetuo.wepic.deal.dao.BidDetailDao;
import com.wetuo.wepic.common.hibernate.Pager;
 
public class BidDetailServiceImpl implements BidDetailService {
	BidDetailDao domainDao;
	public BidDetailDao getBidDetailDao() {
		return domainDao;
	}//
	public void setBidDetailDao(BidDetailDao  domainDao) {
		this.domainDao = domainDao;
	}//
	
	//////////////common crud////////////////
	public List<BidDetail> findAll(){ 
		return domainDao.findAll();
	}
	
	public List<BidDetail> findPart(String strFields, String[] arrStrValues){ 
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
	public String insert(BidDetail record) {
		return domainDao.insert(record) ;
	}//end insert()
			
	/////delete///
	public boolean delete(BidDetail record)  {
		return domainDao.delete(record);
	}//end delete()
			
	public boolean delete(String id)  {
		return domainDao.delete(id);
	}//end delete()
	
	/////update///
	public boolean update(BidDetail record)  {
		return domainDao.update(record);
	}//end update()
			
	/////select///
	public BidDetail select(String id)  {
		return domainDao.select(id);
	}//end select()
	
}//end class
