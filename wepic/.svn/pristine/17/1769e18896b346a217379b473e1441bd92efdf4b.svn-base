package com.wetuo.wepic.core.dao ;
 
import java.util.List;
import java.util.Map;
 
import com.wetuo.wepic.core.beans.PublishFavorite;
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.publish.beans.Publish;
 
public interface PublishFavoriteDao {
 	
 	List<PublishFavorite> findAll();
 	List<PublishFavorite> findPart(String strFields,String[] strArrValues);
 	List<PublishFavorite> findByUser(String username);
	public Pager list(int pageSize, int pageNo)  ;
	public Pager list(String username, int pageSize, int pageNo) ;
	public Pager list(Map<String,Object>  mapSqlParam, int pageSize, int pageNo) ;
   	public PublishFavorite select(Integer id);
	public Integer insert(PublishFavorite record);
	public boolean update(PublishFavorite record);
   	public boolean delete(PublishFavorite record);
	public boolean delete(Integer id) ;
	public List<PublishFavorite> findbyfavoritebypublish(Publish publish);
 
}//end class
