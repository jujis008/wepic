package com.wetuo.wepic.deal.service ;
 
import java.util.*;

import com.wetuo.wepic.deal.beans.Bid;
import com.wetuo.wepic.deal.beans.BidAccountOperation;
import com.wetuo.wepic.deal.dao.BidAccountOperationDao;
import com.wetuo.wepic.common.hibernate.Pager;
 
public class BidAccountOperationServiceImpl implements BidAccountOperationService {
	BidAccountOperationDao domainDao;
	public BidAccountOperationDao getBidAccountOperationDao() {
		return domainDao;
	}//
	public void setBidAccountOperationDao(BidAccountOperationDao  domainDao) {
		this.domainDao = domainDao;
	}//
	
	//////////////common crud////////////////
	public List<BidAccountOperation> findAll(){ 
		return domainDao.findAll();
	}
	
	public List<BidAccountOperation> findPart(String strFields, String[] arrStrValues){ 
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
	public String insert(BidAccountOperation record) {
		return domainDao.insert(record) ;
	}//end insert()
			
	/////delete///
	public boolean delete(BidAccountOperation record)  {
		return domainDao.delete(record);
	}//end delete()
			
	public boolean delete(String id)  {
		return domainDao.delete(id);
	}//end delete()
	
	/////update///
	public boolean update(BidAccountOperation record)  {
		return domainDao.update(record);
	}//end update()
			
	/////select///
	public BidAccountOperation select(String id)  {
		return domainDao.select(id);
	}//end select()
	public List<BidAccountOperation> findPart(String strFields,
			Bid strArrValues) {
		// TODO Auto-generated method stub
		return domainDao.findPart(strFields, strArrValues);
	}
	public Pager selectByAcoount(String flag, String accountId, int pageSize,
			int nowPage) {
		// TODO Auto-generated method stub
		return domainDao.selectByAcoount(flag, accountId, pageSize, nowPage);
	}
	public Pager getCountBidDeal(int pageSize, int pageNo) {
		// TODO Auto-generated method stub
		return domainDao.getCountBidDeal(pageSize, pageNo);
	}
	
}//end class
