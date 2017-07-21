package com.wetuo.wepic.publish.dao ;
 
import java.util.List;
import java.util.Map;
 
import com.wetuo.wepic.publish.beans.Video;
import com.wetuo.wepic.publish.beans.VideoCat_Video;
import com.wetuo.wepic.common.hibernate.Pager;
 
public interface VideoCat_VideoDao {
 	
 	List<VideoCat_Video> findAll();
 	List<VideoCat_Video> findPart(String strFields,String[] strArrValues);
 	
	public Pager list(int pageSize, int pageNo)  ;
	public Pager list(String username, int pageSize, int pageNo) ;
	public Pager list(Map<String,Object>  mapSqlParam, int pageSize, int pageNo) ;
   	public VideoCat_Video select(Integer id);
	public Integer insert(VideoCat_Video record);
	public boolean update(VideoCat_Video record);
   	public boolean delete(VideoCat_Video record);
	public boolean delete(Integer id) ;
 
}//end class
