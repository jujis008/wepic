package com.wetuo.wepic.publish.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;

import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.publish.beans.Publish;
import com.wetuo.wepic.publish.beans.PublishCat;
import com.wetuo.wepic.publish.beans.PublishCat_Story;
import com.wetuo.wepic.publish.beans.PublishSpecialCat;
import com.wetuo.wepic.publish.beans.Story;
import com.wetuo.wepic.publish.beans.StoryDetail;

public interface StoryService {
	public List<Story> findAll();

	public List<Story> findPart(String strFields, String[] strArrValues);

	public Pager findStoryByUser(User user, int pageSize,
			int pageNo);

	public Pager list(int pageSize, int pageNo);

	public Pager list(String username, int pageSize, int pageNo);

	public Pager list(Map<String, Object> mapSqlParam, int pageSize, int pageNo);

	public Story select(Integer id);

	public Integer insert(Story record);

	public boolean update(Story record);

	public boolean delete(Story record);

	public boolean delete(Integer id);
	///////////////////////////wepic2.0////////////////////////
	public List<PublishCat> publishCats();
	public List<PublishSpecialCat> specialCats(Integer uid);
	public List uploadimg(Integer uid,File mycover,String filename,String filetype);
	public Pager storylist(Integer uid,Integer pageSize,Integer pageNo);
	public List cutcover(Integer publishId,Integer x1,Integer x2,Integer y1,Integer y2);
	public int savestory(Story story,Integer uid,Integer publishId,String mytags[],String special,String temppublishcat[],String publish[],String cxt[]);
	public int editunpublishedstory(Integer storyId,Story story2,Integer uid,Integer publishId,String mytags[],String special,String temppublishcat[],String publish[],String cxt[]);
	public int publishstorysuc(Integer storyId,Story story2,Integer uid,Integer publishId,String mytags[],String special,String temppublishcat[],String publish[],String cxt[]);
	public int publishstorysucofusecopyright(Integer storyId,Story story2,Integer uid,Integer publishId,String mytags[],String special,String temppublishcat[],String publish[],String cxt[],String copyrightuseprice);
	public int publishstorysucofcopyright(Integer storyId,Story story2,Integer uid,Integer publishId,String mytags[],String special,String temppublishcat[],String publish[],String cxt[],String copyrightuseprice);
	public int publishstorysucofboth(Integer storyId,Story story2,Integer uid,Integer publishId,String mytags[],String special,String temppublishcat[],String publish[],String cxt[],String copyrightpriceString,String copyrightuseprice);
	public int picNumber(Integer id);
	public int textNumber(Integer id);
	public Story findbyStory(Integer id);
	public List<StoryDetail> findDetailsById(Integer id);
	public List<PublishCat_Story> findStoryCat(Integer id);
	public void delstorydetailofstory(int id) ;
	public void delcatstory(int id);
	public void delstoryofcat(int catid,int storyId);
	public Publish selectPublish(Integer id);
	public Integer total(Integer uId);
	public Pager findbyDetachedCriteria(DetachedCriteria detachedCriteria,int pageNo,int pageSize);
	public List<Story> findbyDetached(DetachedCriteria detachedCriteria);
	public Pager searchbyspecial(Integer uid,Integer specialId,Integer pageSize,Integer pageNo);
	public String findbyCountBySpecialCat(DetachedCriteria detachedCriteria);
	public void storyoffsale(Integer storyid);
	public Pager findStoryByUserAndSpecial(Integer user,Integer publishSpecialCat,int pageNo,int pageSize);
	public List<Story> storybyuserandspecial(Integer uid,Integer specialId);
	public Pager listofstatu(final int pageSize,final int pageNo);
	public void admindelchecking(Integer storyid);
	public void adminchecksuc(Integer storyid);
	public void checknopass(Story storyId,Integer id);
	public List<Story> storychecksucbyspecial(Integer specialId);
	public void allnopass(Integer id);
	public void createstatic(Integer id)throws Exception, FileNotFoundException;
	public void adminrecover(Integer storyid);
	public List<Story> storyadminsoldoutbyspecial(Integer specialId);
	public void adminsoldout(Integer id,Story story);
	public void insert(String name);
	public PublishSpecialCat selectSpecialCat(Integer id);
	public List<Story> userdel();
	public List<Story> admindel();
	public void userdeloperate(Integer id);
	public void admindeloperate(Integer id);
	public List<Story> existsstory(Integer userid);
	public int releasenewstory(Story story,Integer uid,Integer publishId,String mytags[],String special,String temppublishcat[],String publish[],String cxt[]);
}// end class

