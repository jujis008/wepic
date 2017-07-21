package com.wetuo.wepic.publish.dao ;
 
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;

import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.publish.beans.PublishSpecialCat;
import com.wetuo.wepic.publish.beans.Story;
 
public interface StoryDao {
	public List<Story> findAll();
	public List<Story> findPart(String strFields,String[] strArrValues);
	public Pager findStoryByUser(final User user,final int pageSize,final int pageNo);
	public Pager list(int pageSize, int pageNo)  ;
	public Pager list(String username, int pageSize, int pageNo) ;
	public Pager list(Map<String,Object>  mapSqlParam, int pageSize, int pageNo) ;
	public Pager searchbyspecial(final User user, final PublishSpecialCat specialCat,final int pageSize,final int pageNo);
   	public Story select(Integer id);
	public Integer insert(Story record);
	public boolean update(Story record);
   	public boolean delete(Story record);
	public boolean delete(Integer id) ;
	public Integer total(Integer uId);
	////////////////////////////////////////////////wepic2.0//////////////////////////////////////
	public Pager findbyDetachedCriteria(DetachedCriteria detachedCriteria,int pageNo,int pageSize);
	public String findbyCountBySpecialCat(DetachedCriteria detachedCriteria);
	public Pager findStoryByUserAndSpecial(final User user,final PublishSpecialCat publishSpecialCat,int pageNo,int pageSize);
	public List<Story> storybyuserandspecial(Integer uid,Integer specialId);
	public Pager listofstatu(int pageSize, int pageNo)  ;
	public List<Story> storychecksucbyspecial(Integer specialId);
	public List<Story> storyadminsoldoutbyspecial(Integer specialId);
	public List<Story> userdel();
	public List<Story> admindel();
	
	public List<Story> findbyDetached(DetachedCriteria detachedCriteria);
}//end class
