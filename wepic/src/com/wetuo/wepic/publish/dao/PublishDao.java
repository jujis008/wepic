package com.wetuo.wepic.publish.dao ;
 
import java.util.List;
import java.util.Map;

import org.apache.fop.layout.Page;
import org.hibernate.criterion.DetachedCriteria;
 
import com.wetuo.wepic.publish.beans.Publish;
import com.wetuo.wepic.publish.beans.PublishCat;
import com.wetuo.wepic.publish.beans.PublishSpecialCat;
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.core.beans.User;
 
public interface PublishDao {
	
	public String findbyCountBySpecialCat(DetachedCriteria criteria);
	public Pager findbyDetachedCriteria(DetachedCriteria detachedCriteria,int pageNo,int pageSize);
	
	
	///////////////////////////////////////////////////////////////////////2.0wepic//////////////////
	public List<Publish> findByPublishSpecialIdReadOnly( PublishSpecialCat publishSpecialCat);
	public List<Publish> findUserOfPublishReadOnly(User user);
	public List<Publish> findUserOfPublish(User user);
	public Publish homePageMainPic();
	public Pager newestUploadedPicUnderTopPublishCat(final List<PublishCat>  publishCats ,final int pageSize,final int pageNo)  ;
	public Publish getMainPicOfTopPublishCat(final List<PublishCat>  publishCats , final int commnendShould);
	public List<PublishCat> getPublishCatsUnderByType(final String publishCatType) ;
		
	public Pager searchUnderTopPublishCat(final String publishCatType ,final String[] searchKeys, final int pageSize,final int pageNo) ;
	public Publish getMainPicOfTopPublishCat(final String publishCatType) ;
	public Integer getPublishCatIdByType(final String publishCatType)  ;
	public List<Publish> findpublishByUser1(User user);
	public Pager newestUploadedPicUnderTopPublishCat(final String publishCatType ,final int pageSize,final int pageNo) ;
	public List<Publish> findAll();
	public List<Publish> findPart(String strFields,String[] strArrValues);
	public Pager findByName(final String searchText,final int pageSize,final int pageNo) ;
	public Pager findById(final int id,final int pageSize,final int pageNo);
	public Pager findByContent(final String searchText,final int pageSize,final int pageNo) ;
	public Pager findLikeName(final String searchText,final int pageSize,final int pageNo) ;
	public Pager findLikeContent(final String searchText,final int pageSize,final int pageNo) ;
	public Pager findpublishByUser(final User user,final int pageSize,final int pageNo);
	public Pager list(int pageSize, int pageNo)  ;
	public Pager list(String username, int pageSize, int pageNo) ;
	public Pager list(Map<String,Object>  mapSqlParam, int pageSize, int pageNo) ;
	public Pager listUnderCatCurrentUser( Integer catId, String username, int pageSize, int pageNo) ;
	public Pager listUnderCat(Integer catId, int pageSize, int pageNo) ;
	public Pager getPublishListBycatId(Integer catId, int pageSize, int pageNo) ;
   	public Publish select(Integer id);
	public Integer insert(Publish record);
	public boolean update(Publish record);
   	public boolean delete(Publish record);
	public boolean delete(Integer id) ;
	public List<Publish> publishBySecImage() ;
	public List<Publish> publishByFirImage();
	public List<Publish> publishByName() ;
	public List getPublishIdByUid(int name);
	public List<Publish> getPublishListBycatId(String catId);
	public List<Publish> getRecommendPublishUnderCat(String pubCatId);
	public List<Publish> NameByCat(int id);
	public List<Publish> ChangeImage();
	public Pager ImgChange(int pageSize,int pageNo);
	public Pager ImgChangeByCat(Integer catId,int pageSize,int pageNo);
	public List<Publish> findByPublishSpecialId(PublishSpecialCat publishSpecialCat);
	public List<Publish> selectByFrontPage(String type, int pageNo, int pageSize);
	//listUnderCat( Integer catId, int pageSize, int pageNo) 
	public List<?> selectSellerMsg( int userId);
	public List<?> selectBuyMsg( int userId);
	public List<Publish> findResemble(String tags);
	public PublishCat getPublishCatByPublish(Integer id);
	public List<Publish>  homePageMainPicNew();
	public List<Publish> publishByUser(User user);
	public Pager userAlbumnBySpecial(final PublishSpecialCat publishSpecialCat,final int pageSize,final int pageNo);
	public List<Publish>  modelPic();
	public List<Publish>  photographyPic();
	public Pager findpublishByStatu(int pageSize,int pageNo);
	public Pager workStatistics(final int pageSize,final int pageNo);
	public Pager waitcheck(User user,final int pageSize,final int pageNo);
	public Pager checknopass(User user,final int pageSize,final int pageNo);
	public List<Publish> findbydelpublish();
	public List<Publish> findpublishByUser2(User user);
}//end class
