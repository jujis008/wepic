package com.wetuo.wepic.core.service ;
 
import java.util.List;
import java.util.Map;
 
import com.wetuo.wepic.core.beans.PublishFavorite;
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.publish.beans.Publish;
 
public interface PublishFavoriteService {
 
 	List<PublishFavorite> findAll();
 	List<PublishFavorite> findByUser(String username);
 	List<PublishFavorite> findPart(String strFields,String[] strArrValues);
 	
	public Pager list(int pageSize, int pageNo)  ;
	public Pager list(String username, int pageSize, int pageNo) ;
	public Pager list(Map<String,Object>  mapSqlParam, int pageSize, int pageNo) ;
   	public PublishFavorite select(Integer id);
	public Integer insert(PublishFavorite record);
	public boolean update(PublishFavorite record);
   	public boolean delete(PublishFavorite record);
	public boolean delete(Integer id) ;
	public List<PublishFavorite> findbyfavoritebypublish(final Publish publish);
 
}//end class
