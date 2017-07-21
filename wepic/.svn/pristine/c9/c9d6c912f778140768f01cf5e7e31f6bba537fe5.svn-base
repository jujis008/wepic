package com.wetuo.wepic.core.service ;
 
import java.util.List;
import java.util.Map;
 
import com.wetuo.wepic.core.beans.SiteConfig;
import com.wetuo.wepic.common.hibernate.Pager;
 
public interface SiteConfigService {
 
 	List<SiteConfig> findAll();
 	List<SiteConfig> findPart(String strFields,String[] strArrValues);
 	
	public Pager list(int pageSize, int pageNo)  ;
	public Pager list(String username, int pageSize, int pageNo) ;
	public Pager list(Map<String,Object>  mapSqlParam, int pageSize, int pageNo) ;
   	public SiteConfig select(String id);
	public String insert(SiteConfig record);
	public boolean update(SiteConfig record);
   	public boolean delete(SiteConfig record);
	public boolean delete(String id) ;
	public SiteConfig getCurrentSiteConfig();
}//end class
