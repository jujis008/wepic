package com.wetuo.wepic.deal.service ;
 
import java.util.*;
import com.wetuo.wepic.deal.beans.BidReceiverConfirmChange;
import com.wetuo.wepic.deal.dao.BidReceiverConfirmChangeDao;
import com.wetuo.wepic.common.hibernate.Pager;
 
public class BidReceiverConfirmChangeServiceImpl implements BidReceiverConfirmChangeService {
	BidReceiverConfirmChangeDao domainDao;
	public BidReceiverConfirmChangeDao getBidReceiverConfirmChangeDao() {
		return domainDao;
	}//
	public void setBidReceiverConfirmChangeDao(BidReceiverConfirmChangeDao  domainDao) {
		this.domainDao = domainDao;
	}//
	
	//////////////common crud////////////////
	public List<BidReceiverConfirmChange> findAll(){ 
		return domainDao.findAll();
	}
	
	public List<BidReceiverConfirmChange> findPart(String strFields, String[] arrStrValues){ 
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
	public String insert(BidReceiverConfirmChange record) {
		return domainDao.insert(record) ;
	}//end insert()
			
	/////delete///
	public boolean delete(BidReceiverConfirmChange record)  {
		return domainDao.delete(record);
	}//end delete()
			
	public boolean delete(String id)  {
		return domainDao.delete(id);
	}//end delete()
	
	/////update///
	public boolean update(BidReceiverConfirmChange record)  {
		return domainDao.update(record);
	}//end update()
			
	/////select///
	public BidReceiverConfirmChange select(String id)  {
		return domainDao.select(id);
	}//end select()
	
}//end class
