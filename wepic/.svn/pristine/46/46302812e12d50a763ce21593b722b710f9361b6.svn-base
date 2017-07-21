package com.wetuo.wepic.publish.service ;
 
import java.util.*;

import com.wetuo.wepic.publish.beans.PublishDetail;
import com.wetuo.wepic.publish.dao.PublishDetailDao;
import com.wetuo.wepic.common.hibernate.Pager;
 
public class PublishDetailServiceImpl implements PublishDetailService {
	PublishDetailDao domainDao;
	public PublishDetailDao getPublishDetailDao() {
		return domainDao;
	}//
	public void setPublishDetailDao(PublishDetailDao  domainDao) {
		this.domainDao = domainDao;
	}//
	
	//////////////common crud////////////////
	public List<PublishDetail> findAll(){ 
		return domainDao.findAll();
	}
	
	public List<PublishDetail> findPart(String strFields, String[] arrStrValues){ 
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
	public Integer insert(PublishDetail record) {
		return domainDao.insert(record) ;
	}//end insert()
			
	/////delete///
	public boolean delete(PublishDetail record)  {
		return domainDao.delete(record);
	}//end delete()
			
	public boolean delete(Integer id)  {
		return domainDao.delete(id);
	}//end delete()
	
	/////update///
	public boolean update(PublishDetail record)  {
		return domainDao.update(record);
	}//end update()
			
	/////select///
	public PublishDetail select(Integer id)  {
		return domainDao.select(id);
	}//end select()
	public Pager listUnderPublish(Integer publishId, int pageSize, int pageNo) {
		// TODO Auto-generated method stub
		return domainDao.listUnderPublish(publishId, pageSize, pageNo); 
	}
	public Pager findAllPublishDetailsBypublish(int publishId,
			int pageSize, int pageNo) {
		return domainDao.findAllPublishDetailsBypublish(publishId,pageSize,pageNo);
	}
	public List<PublishDetail> showThePublishofdetais(int publishId) {
		// TODO Auto-generated method stub
		return this.domainDao.showThePublishofdetais(publishId);
	}
	public Pager listForCommonUser(String loginUsername, int pageSize, int pageNo) {
		// TODO Auto-generated method stub
		return this.domainDao.listForCommonUser(loginUsername,pageSize,pageNo);
	}
	
}//end class
