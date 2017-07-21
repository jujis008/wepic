package com.wetuo.wepic.publish.dao ;
 
import java.util.List;
import java.util.Map;
 
import com.wetuo.wepic.publish.beans.PublishGuestInfo;
import com.wetuo.wepic.common.hibernate.Pager;
 
public interface PublishGuestInfoDao {
 	
 	List<PublishGuestInfo> findAll();
 	List<PublishGuestInfo> findPart(String strFields,String[] strArrValues);
 	
	public Pager list(int pageSize, int pageNo)  ;
	public Pager list(String username, int pageSize, int pageNo) ;
	public Pager listByName(String username, int pageSize, int pageNo);
	public Pager list(Map<String,Object>  mapSqlParam, int pageSize, int pageNo) ;
   	public PublishGuestInfo select(Integer id);
	public Integer insert(PublishGuestInfo record);
	public boolean update(PublishGuestInfo record);
   	public boolean delete(PublishGuestInfo record);
	public boolean delete(Integer id) ;
 
}//end class
