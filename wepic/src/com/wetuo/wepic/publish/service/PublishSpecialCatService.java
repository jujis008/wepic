package com.wetuo.wepic.publish.service ;
 
import java.util.List;
import java.util.Map;
 
import com.wetuo.wepic.publish.beans.PublishSpecialCat;
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.core.beans.User;
 
public interface PublishSpecialCatService {
 
 	List<PublishSpecialCat> findAll();
 	List<PublishSpecialCat> findPart(String strFields,String[] strArrValues);
 	
	public Pager list(int pageSize, int pageNo)  ;
	public Pager list(String username, int pageSize, int pageNo) ;
	public Pager list(Map<String,Object>  mapSqlParam, int pageSize, int pageNo) ;
   	public PublishSpecialCat select(Integer id);
	public Integer insert(PublishSpecialCat record);
	public boolean update(PublishSpecialCat record);
   	public boolean delete(PublishSpecialCat record);
	public boolean delete(Integer id) ;
	public List<PublishSpecialCat> getPublishSpecialCatList();
	public Pager allOfType(final String username,final int pageSize,final int pageNo);
	public List AllSpecialIdByUserName(User user);
	public Pager publishPagerBySpecialId(final Integer catId,final int pageSize,final int pageNo);
	public PublishSpecialCat selectBySpecilChild(String str);
	public List selectBySpecilChild(Integer str);
	public List selectBySpecilChild2(Integer str,User user);
	public List AllSpecialByUser(User user);
	public PublishSpecialCat findByUser(User user);
	public PublishSpecialCat findAlbumn();
	public PublishSpecialCat findAlbumn2();
	public PublishSpecialCat findByUser2(User user);
	public PublishSpecialCat selectByName(String name);
	public List allWorkSpecial(User user);
	public int storyPid();
	public List<PublishSpecialCat> specialCatOfStory();
	public List storySpecialIdByUserName(User user);
	public PublishSpecialCat defaultOfSpecial();
	public List<PublishSpecialCat> specialCatuserOfStory(int uid);
}//end class
