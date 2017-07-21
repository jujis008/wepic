package com.wetuo.wepic.deal.service ;
 
import java.util.*;

import com.wetuo.wepic.deal.beans.Bid;
import com.wetuo.wepic.deal.beans.BidForOpus;
import com.wetuo.wepic.deal.dao.BidForOpusDao;
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.core.beans.User;
 
public class BidForOpusServiceImpl implements BidForOpusService {
	BidForOpusDao domainDao;

	
	public BidForOpusDao getDomainDao() {
		return domainDao;
	}

	public void setDomainDao(BidForOpusDao domainDao) {
		this.domainDao = domainDao;
	}

	//////////////common crud////////////////
	public List<BidForOpus> findAll(){ 
		return domainDao.findAll();
	}
	
	public List<BidForOpus> findPart(String strFields, String[] arrStrValues){ 
		return domainDao.findPart(strFields,arrStrValues);
	}
	
	public Pager list(int pageSize, int pageNo)  {
		return domainDao.list(pageSize,pageNo);
	}//end list()
	
	public Pager list(String username, int pageSize, int pageNo)  {
		return domainDao.list(username,pageSize,pageNo);
	}//end list()
	public Pager list(Bid bid, int pageSize, int pageNo)  {
		return domainDao.list(bid,pageSize,pageNo);
	}//end list()
	
	public Pager list(Map<String,Object> mapSqlParam, int pageSize, int pageNo)  {
		return domainDao.list(mapSqlParam,pageSize,pageNo);
	}//end list()
	
	/////insert///
	public String insert(BidForOpus record) {
		return domainDao.insert(record) ;
	}//end insert()
			
	/////delete///
	public boolean delete(BidForOpus record)  {
		return domainDao.delete(record);
	}//end delete()
			
	public boolean delete(String id)  {
		return domainDao.delete(id);
	}//end delete()
	
	/////update///
	public boolean update(BidForOpus record)  {
		return domainDao.update(record);
	}//end update()
			
	/////select///
	public BidForOpus select(String id)  {
		return domainDao.select(id);
	}//end select()
	public BidForOpus selectById(String id){
		return domainDao.selectById(id);
	}

	public List getConfirm(String bidid) {
		// TODO Auto-generated method stub
		 return domainDao.getConfirm(bidid);
	}
	public Pager confirmlist( Bid bid, int pageSize, int pageNo){
		
		 return domainDao.confirmlist(bid, pageSize, pageNo);//(bidid);
		
	}

	public Pager getallBidForOpus(Bid bid, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return domainDao.getallBidForOpus(bid, pageNo, pageSize);
	}

	public Pager getConfirmImgPager(String bidid, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return domainDao.getConfirmImgPager( bidid,  pageNo,  pageSize);
	}

	public Pager yingyaojilu(User user, int pageSize, int pageNo) {
		// TODO Auto-generated method stub
		return domainDao.yingyaojilu(user, pageSize, pageNo);
	}
	
}//end class
