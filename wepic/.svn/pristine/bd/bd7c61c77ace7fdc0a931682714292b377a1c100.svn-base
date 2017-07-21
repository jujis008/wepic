package com.wetuo.wepic.publish.service ;
 
import java.util.*;

import org.hibernate.criterion.DetachedCriteria;

import com.wetuo.wepic.publish.beans.Publish;
import com.wetuo.wepic.publish.beans.PublishCat_Publish;
import com.wetuo.wepic.publish.dao.PublishCat_PublishDao;
import com.wetuo.wepic.common.hibernate.Pager;
 
public class PublishCat_PublishServiceImpl implements PublishCat_PublishService {
	PublishCat_PublishDao domainDao;
	public PublishCat_PublishDao getPublishCat_PublishDao() {
		return domainDao;
	}//
	public void setPublishCat_PublishDao(PublishCat_PublishDao  domainDao) {
		this.domainDao = domainDao;
	}//
	
	//////////////common crud////////////////
	public List<PublishCat_Publish> findAll(){ 
		return domainDao.findAll();
	}
	
	public List<PublishCat_Publish> findPart(String strFields, String[] arrStrValues){ 
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
	public Integer insert(PublishCat_Publish record) {
		return domainDao.insert(record) ;
	}//end insert()
			
	/////delete///
	public boolean delete(PublishCat_Publish record)  {
		return domainDao.delete(record);
	}//end delete()
			
	public boolean delete(Integer id)  {
		return domainDao.delete(id);
	}//end delete()
	
	/////update///
	public boolean update(PublishCat_Publish record)  {
		return domainDao.update(record);
	}//end update()
			
	/////select///
	public PublishCat_Publish select(Integer id)  {
		return domainDao.select(id);
	}//end select()
//	public PublishCat_Publish selectPublish(Integer id){
//		// TODO Auto-generated method stub
//		return domainDao.selectPublish(id);
//	}
//	
	public List list(int publicId) {
		// TODO Auto-generated method stub
		 return domainDao.list(publicId);
	}
	/**
	 * 
	 * wepic2.0方法
	 * 
	 * 
	 * 
	 */
	
	 public Pager findByDetachedCriteria(DetachedCriteria detachedCriteria,int pageNo,int pageSize){
		// List<Publish> publishlist=new ArrayList<Publish>();
		// List<Publish>  publishlist=(List<Publish>) domainDao.findByDetachedCriteria(detachedCriteria,pageSize,pageNo).getResultList();

		 
		 return domainDao.findByDetachedCriteria(detachedCriteria,pageSize,pageNo);
	 }
	
	
}//end class
