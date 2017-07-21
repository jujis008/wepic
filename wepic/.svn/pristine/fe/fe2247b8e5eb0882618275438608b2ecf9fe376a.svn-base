package com.wetuo.wepic.core.service ;
 
import java.util.List;
import java.util.Map;
 
import com.wetuo.wepic.core.beans.Contact;
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.common.hibernate.Pager;
 
public interface ContactService {
 
 	List<Contact> findAll();
 	List<Contact> findPart(String strFields,String[] strArrValues);
 	/**
 	 * 查看是否关注了某个用户
 	 * @param fromUser
 	 * @param toUser
 	 * @return
 	 */
 	public int findIsAttention(User fromUser,User toUser);
 	/**
 	 * 查看用户的关注数量
 	 * @param fromUser
 	 * @return
 	 */
 	public int findAttentionNumber(User fromUser);
 	/**
 	 * 查看用户的粉丝数量
 	 * @param toUser
 	 * @return
 	 */
 	public int findFansNumber(User toUser);
 	/**
 	 * 添加新的关注
 	 * @param fromUser
 	 * @param toUser
 	 * @return
 	 */
 	public Contact addNewAttention(User fromUser,User toUser);
 	/**
 	 * 取消的关注
 	 * @param fromUser
 	 * @param toUser
 	 * @return
 	 */
 	public boolean cancelAttention(User fromUser,User toUser);
 	/**
 	 * 查找用户的粉丝列表
 	 */
 	public List findFansList(User fromUser,int pageSize,int pageNo);
 	/**
 	 * 
 	 * @param userId 	用户Id
 	 * @param pageSize 	每页的大小
 	 * @param pageNo	页号
 	 * @return	返回查找到的分页
 	 */
 	
	public List findAttentionList(User user,int pageSize,int pageNo);
	/**
	 * 通过用户的Id、页数和每页显示最大数查找到该页的未被关注用户
	 */
	public Pager findInattentionList(User user,int pageSize,int pageNo);
	/**
	 * 查找未被邀请或申请的用户
	 * @return
	 */
	public Pager findNotFriendList(User fromUser,int pageSize,int pageNo);
	/**
	 * 查找用户申请好友的列表分页
	 * @param fromUser
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public Pager findFriendApplyList(User fromUser, int pageSize, int pageNo);
	/**
	 * 查找邀请好友的列表分页
	 * @param fromUser
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public Pager findBeApplyFriendList(User fromUser, int pageSize, int pageNo);
	/**
	 * 查找用户好友的分页列表
	 * @param user
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public Pager findFriendList(User user, int pageSize, int pageNo);
	public Pager list(int pageSize, int pageNo)  ;
	public Pager list(String username, int pageSize, int pageNo) ;
	public Pager list(Map<String,Object>  mapSqlParam, int pageSize, int pageNo) ;
   	public Contact select(Integer id);
	public Integer insert(Contact record);
	public boolean update(Contact record);
   	public boolean delete(Contact record);
	public boolean delete(Integer id) ;
 
}//end class
