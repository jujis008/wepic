package com.wetuo.wepic.core.service ;
 
import java.io.File;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;

import com.qq.connect.javabeans.qzone.UserInfoBean;
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.core.beans.LoginHistory;
import com.wetuo.wepic.core.beans.RoleTags;
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.core.beans.UserDetail;
import com.wetuo.wepic.core.beans.UserInfoBeans;
 
public interface UserService {
	
	
	public Integer insert(User record);
	public boolean update(User record);
   	public boolean delete(User record);
	public boolean delete(Integer id) ;
	public Pager list(Map<String,Object>  mapSqlParam, int pageSize, int pageNo) ;
	public boolean isExist(String username)  ;
	public boolean isEmailExist(String email)  ;
	public User selectById(Integer id);
	public boolean sendEmail(int id,String code);
	public String  initUserMustInfoForWepic(String username,String id);
	public String uploadPubimg(File file,String path,String basePath,String uploadPath);
	public String enterpeiceuploadPubimg(File file,String path,String basePath,String uploadPath);
	public UserInfoBeans getUserInfoBeans(int userId);
	public UserInfoBeans getFistPageUserInfoBeans(int userId);
	public String cutImgForUSer(Map<String, Object> map);
	public String saveTags();
	public List<RoleTags> selectTagByRole(String roles);
	public List<RoleTags> nextRadomTagByRole();
	public UserInfoBeans getgradUserInfoBeans(int userId);
	public Pager getUsergetMarkHistory(int id,int nowPage,int pageSize);
	public String CutImgPubimg(File file,String path,String basePath,String uploadPath);
	public Pager listDetaChedCriteri(DetachedCriteria detachedCriteria,int nowPage,int pageSize);
	
	
	//2.0方法以上
	//////////////////////////////////////////////////
	public Pager listUnderCat(final Integer catId,final int pageSize,final int pageNo) ;
 	List<User> findAll();
 	List<User> findPart(String strFields,String[] strArrValues);
 	public Pager userStatistics(final int pageSize,final int pageNo);
	public Pager list(int pageSize, int pageNo)  ;
	public Pager list(String username, int pageSize, int pageNo) ;
	public LoginHistory recentHistory();
	
	
	public Pager getListParamter(Integer parameter, int pageSize, int pageNo);
	public User select(String username);
	public Pager checkInvitedUser(String id);
	public Pager moelorPotolist(String	type, int pageSize, int pageNo,int userId,String aimId, String workPalce);
	public boolean login(String username, String password);
	public Integer register(User record);
	
	
	Pager  getAllPohtoOrModel(final String role ,final int pageNo,final int pageSize);
	public List getAllPohtoOrModelByShowLeft(final String role);
	public List<UserDetail> listUserDetails(Integer userId);
    public Pager addBrokerShip(int pageSize, int pageNo);
	public Pager addbrokerscustomer(int pageSize, int pageNo);
	
	public Pager searchPhotoOrModel(int pageSize, int pageNo,String position, String searchNick,String searchType);
	public List<User> findnoactiveuser();
	
	public int sendMsgofemail(String username, String code,String email) throws Exception;
	public int sendMsg(String username, String code) throws Exception;
	public String getRandomStr();
	public String validatemail(Integer userId,String inputmail) throws Exception;
	public String sendemail(Integer userId);
	public String validatepwd(Integer userId,String oldpwd) throws Exception;
	public Integer sendEmil(Integer id);
	public String sendmobilecodeofmodifyemail(Integer id);
	public String sendmobilecode(Integer id,String newmobile);
	public List uploadimg(File file,String name);
	public Integer validateuser(User user,Integer userId,String areaCode,String number,String pic) throws Exception;
	public Integer enterpricevalidate(User user,Integer userId,String code,String gudingtel);
	public Pager findbyDetachedCriteria(DetachedCriteria detachedCriteria,int pageNo,int pageSize);
	public List<User> userbyusercat(Integer usercatid,Integer personOrCompany,Integer ifIdentityTrue);
	public List<User> govermentbyusercat(Integer enterprisetype,Integer personOrCompany,Integer ifIdentityTrue);
}//end class
