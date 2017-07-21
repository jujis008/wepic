package com.wetuo.wepic.publish.service ;
 
import java.util.*;
import com.wetuo.wepic.publish.beans.PublishGuestInfo;
import com.wetuo.wepic.publish.dao.PublishGuestInfoDao;
import com.wetuo.wepic.common.hibernate.Pager;
 
public class PublishGuestInfoServiceImpl implements PublishGuestInfoService {
	PublishGuestInfoDao domainDao;
	public PublishGuestInfoDao getPublishGuestInfoDao() {
		return domainDao;
	}//
	public void setPublishGuestInfoDao(PublishGuestInfoDao  domainDao) {
		this.domainDao = domainDao;
	}//
	
	//////////////common crud////////////////
	public List<PublishGuestInfo> findAll(){ 
		return domainDao.findAll();
	}
	
	public List<PublishGuestInfo> findPart(String strFields, String[] arrStrValues){ 
		return domainDao.findPart(strFields,arrStrValues);
	}
	
	public Pager list(int pageSize, int pageNo)  {
		return domainDao.list(pageSize,pageNo);
	}//end list()
	
	public Pager list(String username, int pageSize, int pageNo)  {
		return domainDao.list(username,pageSize,pageNo);
	}//end list()
	public Pager listByName(String username, int pageSize, int pageNo){
		return domainDao.listByName(username, pageSize, pageNo);
	}
	public Pager list(Map<String,Object> mapSqlParam, int pageSize, int pageNo)  {
		return domainDao.list(mapSqlParam,pageSize,pageNo);
	}//end list()
	
	/////insert///
	public Integer insert(PublishGuestInfo record) {
		return domainDao.insert(record) ;
	}//end insert()
			
	/////delete///
	public boolean delete(PublishGuestInfo record)  {
		return domainDao.delete(record);
	}//end delete()
			
	public boolean delete(Integer id)  {
		return domainDao.delete(id);
	}//end delete()
	
	/////update///
	public boolean update(PublishGuestInfo record)  {
		return domainDao.update(record);
	}//end update()
			
	/////select///
	public PublishGuestInfo select(Integer id)  {
		return domainDao.select(id);
	}//end select()
	
}//end class
