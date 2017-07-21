package com.wetuo.wepic.core.service ;
 
import java.util.*;

import com.wetuo.wepic.core.beans.PublishFavorite;
import com.wetuo.wepic.core.dao.PublishFavoriteDao;
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.publish.beans.Publish;
 
public class PublishFavoriteServiceImpl implements PublishFavoriteService {
	PublishFavoriteDao domainDao;
	public PublishFavoriteDao getPublishFavoriteDao() {
		return domainDao;
	}//
	public void setPublishFavoriteDao(PublishFavoriteDao  domainDao) {
		this.domainDao = domainDao;
	}//
	
	//////////////common crud////////////////
	public List<PublishFavorite> findAll(){ 
		return domainDao.findAll();
	}
	
	public List<PublishFavorite> findPart(String strFields, String[] arrStrValues){ 
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
	public Integer insert(PublishFavorite record) {
		return domainDao.insert(record) ;
	}//end insert()
			
	/////delete///
	public boolean delete(PublishFavorite record)  {
		return domainDao.delete(record);
	}//end delete()
			
	public boolean delete(Integer id)  {
		return domainDao.delete(id);
	}//end delete()
	
	/////update///
	public boolean update(PublishFavorite record)  {
		return domainDao.update(record);
	}//end update()
			
	/////select///
	public PublishFavorite select(Integer id)  {
		return domainDao.select(id);
	}//end select()
	public List<PublishFavorite> findByUser(String username) {
		// TODO Auto-generated method stub
		return domainDao.findByUser(username);
	}
	public List<PublishFavorite> findbyfavoritebypublish(final Publish publish){
		return domainDao.findbyfavoritebypublish(publish);
	}
}//end class
