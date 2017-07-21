package com.wetuo.wepic.publish.dao ;
 
import java.util.List;
import java.util.Map;

import org.apache.fop.layout.Page;
 

import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.publish.beans.Video;
import com.wetuo.wepic.publish.beans.VideoCat;
import com.wetuo.wepic.publish.beans.VideoSpecialCat;
 
public interface VideoDao {
	/**
	 * 根据当前用户的专辑名称查找专辑下的所有视频
	 * @param videoSpecialCat
	 * @param user
	 * @return
	 */
	public List findVideoListByVideoSpecialCat(VideoSpecialCat videoSpecialCat,User user);
	
	/**
	 * 查找某个用户正在被审核中的视频
	 */
	public Pager findWaitApprovalByUser(final User user,final int pageSize,final int pageNo);
	/**
	 * 查找某个用户未审核通过的视频
	 * @param user
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public Pager findNotApprovalByUser(final User user,final int pageSize,final int pageNo);
	/**
	 * 查找某个用户审核通过的视频
	 * @param user
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public Pager findApprovalPassByUser(final User user,final int pageSize,final int pageNo);
	/**
	 * 查找所有未审核的视频
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public Pager findAllApprovalPassByUse(final int pageSize,final int pageNo);
	//public Video homePageMainPic();
	//public Pager newestUploadedPicUnderTopVideoCat(final List<VideoCat>  VideoCats ,final int pageSize,final int pageNo)  ;
	//public Video getMainPicOfTopVideoCat(final List<VideoCat>  VideoCats , final int commnendShould);
	//public List<VideoCat> getVideoCatsUnderByType(final String videoCatType) ;
		
	//public Pager searchUnderTopVideoCat(final String videoCatType ,final String[] searchKeys, final int pageSize,final int pageNo) ;
	//public Video getMainPicOfTopVideoCat(final String videoCatType) ;
	//public Integer getVideoCatIdByType(final String videoCatType)  ;
	//public List<Video> findVideoByUser1(User user);
	//public Pager newestUploadedPicUnderTopVideoCat(final String videoCatType ,final int pageSize,final int pageNo) ;
	public List<Video> findAll();
	public List<Video> findPart(String strFields,String[] strArrValues);
	//public Pager findByName(final String searchText,final int pageSize,final int pageNo) ;
	public Pager findById(final int id,final int pageSize,final int pageNo);
	//public Pager findByContent(final String searchText,final int pageSize,final int pageNo) ;
	//public Pager findLikeName(final String searchText,final int pageSize,final int pageNo) ;
	//public Pager findLikeContent(final String searchText,final int pageSize,final int pageNo) ;
	public Pager findVideoByUser(final User user,final int pageSize,final int pageNo);
	public Pager list(int pageSize, int pageNo)  ;
	//public Pager list(String username, int pageSize, int pageNo) ;
	//public Pager list(Map<String,Object>  mapSqlParam, int pageSize, int pageNo) ;
	//public Pager listUnderCatCurrentUser( Integer catId, String username, int pageSize, int pageNo) ;
	//public Pager listUnderCat(Integer catId, int pageSize, int pageNo) ;
	//public Pager getVideoListBycatId(Integer catId, int pageSize, int pageNo) ;
   	public Video select(Integer id);
	public Integer insert(Video record);
	public boolean update(Video record);
   	public boolean delete(Video record);
	public boolean delete(Integer id) ;
	//public List<Video> videoBySecImage() ;
	//public List<Video> videoByFirImage();
	//public List<Video> videoByName() ;
	public List getVideoIdByUid(int name);
	//public List<Video> getVideoListBycatId(String catId);
	//public List<Video> getRecommendVideoUnderCat(String pubCatId);
	//public List<Video> NameByCat(int id);
	//public List<Video> ChangeImage();
	//public Pager ImgChange(int pageSize,int pageNo);
	//public Pager ImgChangeByCat(Integer catId,int pageSize,int pageNo);
	//public List<Video> selectByFrontPage(String type, int pageNo, int pageSize);
	//listUnderCat( Integer catId, int pageSize, int pageNo) 
	//public List<?> selectSellerMsg( int userId);
	//public List<?> selectBuyMsg( int userId);
	//public List<Video> findResemble(String tags);
	//public VideoCat getVideoCatByVideo(Integer id);
	//public List<Video>  homePageMainPicNew();
	//public List<Video> VideoByUser(User user);
	//public List<Video>  modelPic();
	//public List<Video>  photographyPic();
}//end class
