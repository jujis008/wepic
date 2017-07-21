package com.wetuo.wepic.publish.dao ;
 
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
 
import com.wetuo.wepic.publish.beans.Publish;
import com.wetuo.wepic.publish.beans.PublishCat_Publish;
import com.wetuo.wepic.common.hibernate.Pager;
 
public interface PublishCat_PublishDao {
 	
 	List<PublishCat_Publish> findAll();
 	List<PublishCat_Publish> findPart(String strFields,String[] strArrValues);
 	
	public Pager list(int pageSize, int pageNo)  ;
	public Pager list(String username, int pageSize, int pageNo) ;
	public Pager list(Map<String,Object>  mapSqlParam, int pageSize, int pageNo) ;
   	public PublishCat_Publish select(Integer id);
	public Integer insert(PublishCat_Publish record);
	public boolean update(PublishCat_Publish record);
   	public boolean delete(PublishCat_Publish record);
	public boolean delete(Integer id) ;
	public List list(int publicId);
	/**
	 * 
	 * wepic2.0
	 * 
	 * 
	 * 
	 */
	public Pager findByDetachedCriteria(DetachedCriteria detachedCriteriaint ,int pageSize, int pageNo);
 
}//end class
