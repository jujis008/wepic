package com.wetuo.wepic.core.dao ;
 
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;

import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.core.beans.UserDetail;
 
public interface UserDao {
	public Pager listUnderCat(final Integer catId,final int pageSize,final int pageNo) ;
 	
 	List<User> findAll();
 	List<User> findPart(String strFields,String[] strArrValues);
 	Pager  getAllPohtoOrModel(final String role ,final int pageNo,final int pageSize);
	public Pager list(int pageSize, int pageNo)  ;
	public Pager list(String username, int pageSize, int pageNo) ;
	public Pager list(Map<String,Object>  mapSqlParam, int pageSize, int pageNo) ;
   	public User selectById(Integer id);
	public Integer insert(User record);
	public boolean update(User record);
   	public boolean delete(User record);
	public boolean delete(Integer id) ;
	
	public Pager getListByParameter(Integer paramter, int pageSize, int pageNo);
	public Pager moelorPotolist(String type, int pageSize, int pageNo,int userId, String aimId,String workPalce);
	public User select(String username);
	public Pager checkInvitedUser(String bidId);
	
	public Pager userStatistics(final int pageSize,final int pageNo);
	public List<UserDetail> findUserDetails(Integer userId);
 	public Pager addBrokerShip(int pageSize, int pageNo);
	public Pager addbrokerscustomer(int pageSize, int pageNo);
	public Pager searchPhotoOrModel(int pageSize, int pageNo, String position,
			String searchNick, String searchType);
	public List<User> findnoactiveuser();
	public List getAllPohtoOrModelByShowLeft(String role);
	public Pager listDetaChedCriteri(DetachedCriteria detachedCriteria,int nowPage,int pageSize);
	public Pager findbyDetachedCriteria(DetachedCriteria detachedCriteria,int pageNo,int pageSize);
	public List<User> userbyusercat(Integer usercatid,Integer personOrCompany,Integer ifIdentityTrue);
	public List<User> govermentbyusercat(Integer enterprisetype,Integer personOrCompany,Integer ifIdentityTrue);
}//end class
