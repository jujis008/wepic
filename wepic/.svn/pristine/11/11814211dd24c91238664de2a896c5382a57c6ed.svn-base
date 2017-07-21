package com.wetuo.wepic.publish.dao ;
 
import java.util.List;
import java.util.Map;
 
import com.wetuo.wepic.publish.beans.VideoSpecialCat;
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.core.beans.User;
 
public interface VideoSpecialCatDao {
 	
	/**
	 * 根据用户的视频专辑
	 * @param user
	 * @return
	 */
	public List findAllVideoSpecialCatByUser(User user);
 	List<VideoSpecialCat> findAll();
 	List<VideoSpecialCat> findPart(String strFields,String[] strArrValues);
 	
	public Pager list(int pageSize, int pageNo)  ;
	public Pager list(String username, int pageSize, int pageNo) ;
	public Pager list(Map<String,Object>  mapSqlParam, int pageSize, int pageNo) ;
   	public VideoSpecialCat select(Integer id);
	public Integer insert(VideoSpecialCat record);
	public boolean update(VideoSpecialCat record);
   	public boolean delete(VideoSpecialCat record);
	public boolean delete(Integer id) ;
	public List<VideoSpecialCat> getVideoSpecialCatList();
	public Pager allOfType(final String username,final int pageSize,final int pageNo);
//	public List AllSpecialIdByUserName(User user);
	public Pager videoPagerBySpecialId(final Integer catId,final int pageSize,final int pageNo);
	public VideoSpecialCat selectBySpecilChild(String str);
	public List selectBySpecilChild(Integer pid);
	public List selectBySpecilChild2(Integer pid,User user);
	public List AllSpecialByUser(User user);
	public VideoSpecialCat findByUser(User user);
	public VideoSpecialCat findAlbumn();
	public VideoSpecialCat findAlbumn2();
	public VideoSpecialCat findByUser2(User user);
	public VideoSpecialCat selectByName(String name);
	
}//end class
