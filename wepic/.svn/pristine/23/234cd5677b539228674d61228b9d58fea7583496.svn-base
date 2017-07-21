package com.wetuo.wepic.core.dao ;
 
import java.util.List;
import java.util.Map;
 
import com.wetuo.wepic.core.beans.Contact;
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.common.hibernate.Pager;
 
public interface ContactDao {
 	
 	List<Contact> findAll();
 	List<Contact> findPart(String strFields,String[] strArrValues);
 	/**
 	 * 查找是否关注了某个用户
 	 * @param fromUser 
 	 * @param toUser
 	 * @return 
 	 */
 	public Object findIsAttention(User fromUser,User toUser);
 	/**
 	 * 通过用户Id,显示的最大条数和页号查找关注列表
 	 * @param userId 	用户Id
 	 * @param pageSize	显示的最大条数
 	 * @param pageNo	页号
 	 * @return
 	 */
 	public List<Object[]> findAttentionList(User user,int pageSize,int pageNo);
 	/**
	 * 根据用户Id查找所有的用户关注
	 */
 	public List findAllAttention(User user);
 	/**
 	 * 通过用户Id,显示的最大条数和页号查找粉丝列表
 	 * @param user
 	 * @param pageSize
 	 * @param pageNo
 	 * @return
 	 */
 	public List findFansList(User user,int pageSize,int pageNo);
 	/**
 	 * 查看所有粉丝
 	 * @param user
 	 * @return
 	 */
 	public List findAllFans(User user);
 	/**
 	 * 查看关注的的数量
 	 * @param toUser
 	 * @return
 	 */
 	public int findAttentionNumber(User toUser);
 	/**
 	 * 查看粉丝的数量
 	 * @param toUser
 	 * @return
 	 */
 	public int findFansNumber(User toUser);
 	/**
 	 * 通过用户,显示的最大条数和页号查找未被关注的用户
 	 * @param userId 	用户Id
 	 * @param pageSize	显示的最大条数
 	 * @param pageNo	页号
 	 * @return
 	 */
 	public List findInattentionList(User user,int pageSize,int pageNo);
 	/**
	 * 根据用户Id查找所有的未被关注的
	 */
 	public List findAllInattention(User user);
 	/**
	 * 查找到用户的好友
	 * @param fromUser
	 * @return
	 */
	public List findFriend(User user);
	/**
	 * 查找到用户的好友的分类列表
	 * @param fromUser
	 * @return
	 */
	public List findFriendList(User user, int pageSize, int pageNo);
	/**
	 * 查找所有未添加过的好友的分页
	 * @param fromUser
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public List findNotFriendList(User fromUser, int pageSize, int pageNo);
	/**
	 * 查找所有未添加过的好友
	 * @param fromUser
	 * @return
	 */
	public List findNotFriend(User fromUser);
	/**
	 * 查找用户申请的好友
	 * @param fromUser
	 * @return
	 */
	public List findApplyFriend(User fromUser);
	/**
	 * 查找用户申请的好友分页列表
	 * @param fromUser
	 * @return
	 */
	public List findApplyFriendList(User fromUser, int pageSize, int pageNo);
	/**
	 * 查找邀请用户的好友
	 * @param fromUser
	 * @return
	 */
	public List findBeApplyFriend(User fromUser);
	/**
	 * 查找邀请用户的好友分页列表
	 * @param fromUser
	 * @return
	 */
	public List findBeApplyFriendList(User fromUser, int pageSize, int pageNo);
	
	public Pager list(int pageSize, int pageNo)  ;
	public Pager list(String username, int pageSize, int pageNo) ;
	public Pager list(Map<String,Object>  mapSqlParam, int pageSize, int pageNo) ;
   	public Contact select(Integer id);
	public Integer insert(Contact record);
	public boolean update(Contact record);
   	public boolean delete(Contact record);
	public boolean delete(Integer id);
	
 
}//end class
