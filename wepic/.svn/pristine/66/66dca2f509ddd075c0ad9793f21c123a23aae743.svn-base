package com.wetuo.wepic.core.service ;
 
import java.util.*;
import com.wetuo.wepic.core.beans.SiteConfig;
import com.wetuo.wepic.core.dao.SiteConfigDao;
import com.wetuo.wepic.common.hibernate.Pager;
 
public class SiteConfigServiceImpl implements SiteConfigService {
	SiteConfigDao domainDao;
	public SiteConfigDao getSiteConfigDao() {
		return domainDao;
	}//
	public void setSiteConfigDao(SiteConfigDao  domainDao) {
		this.domainDao = domainDao;
	}//
	
	//////////////common crud////////////////
	public List<SiteConfig> findAll(){ 
		return domainDao.findAll();
	}
	
	public List<SiteConfig> findPart(String strFields, String[] arrStrValues){ 
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
	public String insert(SiteConfig record) {
		return domainDao.insert(record) ;
	}//end insert()
			
	/////delete///
	public boolean delete(SiteConfig record)  {
		return domainDao.delete(record);
	}//end delete()
			
	public boolean delete(String id)  {
		return domainDao.delete(id);
	}//end delete()
	
	/////update///
	public boolean update(SiteConfig record)  {
		return domainDao.update(record);
	}//end update()
			
	/////select///
	public SiteConfig select(String id)  {
		return domainDao.select(id);
	}//end select()
	public SiteConfig getCurrentSiteConfig() {
		// TODO Auto-generated method stub
		return domainDao.getCurrentSiteConfig();
	}
	
}//end class
