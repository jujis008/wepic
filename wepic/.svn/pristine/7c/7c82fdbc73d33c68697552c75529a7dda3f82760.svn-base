package com.wetuo.wepic.deal.service ;
 
import java.util.*;

import com.wetuo.wepic.deal.beans.Bid;
import com.wetuo.wepic.deal.beans.BidAimPerson;
import com.wetuo.wepic.deal.dao.BidAimPersonDao;
import com.wetuo.wepic.common.hibernate.Pager;
 
public class BidAimPersonServiceImpl implements BidAimPersonService {
	BidAimPersonDao domainDao;
	public BidAimPersonDao getBidAimPersonDao() {
		return domainDao;
	}//
	public void setBidAimPersonDao(BidAimPersonDao  domainDao) {
		this.domainDao = domainDao;
	}//
	
	//////////////common crud////////////////
	public List<BidAimPerson> findAll(){ 
		return domainDao.findAll();
	}
	
	public List<BidAimPerson> findPart(String strFields, String[] arrStrValues){ 
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
	public String insert(BidAimPerson record) {
		return domainDao.insert(record) ;
	}//end insert()
			
	/////delete///
	public boolean delete(BidAimPerson record)  {
		return domainDao.delete(record);
	}//end delete()
			
	public boolean delete(String id)  {
		return domainDao.delete(id);
	}//end delete()
	
	/////update///
	public boolean update(BidAimPerson record)  {
		return domainDao.update(record);
	}//end update()
			
	/////select///
	public BidAimPerson select(String id)  {
		return domainDao.select(id);
	}
	public List<?> aimSelect( Bid bid, int pageSize, int pageNo){
		
		return domainDao.listBidAim(bid, pageSize, pageNo);
	}
	
	
	
}//end class
