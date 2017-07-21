package com.wetuo.wepic.core.service ;
 
import java.sql.Timestamp;
import java.util.*;

import com.wetuo.wepic.core.beans.Contact;
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.core.dao.ContactDao;
import com.wetuo.wepic.core.dao.UserDao;
import com.wetuo.wepic.common.hibernate.Pager;
 
public class ContactServiceImpl implements ContactService {
	ContactDao domainDao;
	UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public ContactDao getContactDao() {
		return domainDao;
	}//
	public void setContactDao(ContactDao  domainDao) {
		this.domainDao = domainDao;
	}//
	
	//////////////common crud////////////////
	public List<Contact> findAll(){ 
		return domainDao.findAll();
	}
	
	public List<Contact> findPart(String strFields, String[] arrStrValues){ 
		return domainDao.findPart(strFields,arrStrValues);
	}
	
	public Pager list(int pageSize, int pageNo)  {
		return domainDao.list(pageSize,pageNo);
	}//end list()
	
	public Pager list(String username, int pageSize, int pageNo)  {
		return domainDao.list(username,pageSize,pageNo);
	}//end list()
	
	public Pager list(Map<String,Object> mapSqlParam, int pageSize, int pageNo)  {
		return domainDao.list(mapSqlParam,pageSize,pageNo);
	}//end list()
	
	/////insert///
	public Integer insert(Contact record) {
		return domainDao.insert(record) ;
	}//end insert()
			
	/////delete///
	public boolean delete(Contact record)  {
		return domainDao.delete(record);
	}//end delete()
			
	public boolean delete(Integer id)  {
		return domainDao.delete(id);
	}//end delete()
	
	/////update///
	public boolean update(Contact record)  {
		return domainDao.update(record);
	}//end update()
			
	/////select///
	public Contact select(Integer id)  {
		return domainDao.select(id);
	}//end select()
	/**
 	 * 添加新的关注
 	 * @param fromUser
 	 * @param toUser
 	 * @return
 	 */
 	public Contact addNewAttention(User fromUser,User toUser){
 		
 		Object fromObject=domainDao.findIsAttention(fromUser, toUser);
 		Object toObject=domainDao.findIsAttention(toUser, fromUser);
 		Contact fromContact=null;
 		Contact toContact=null;
 		int each=0;	//标志对方是否关注了自己 0(未关注)1(已关注)
 		//先判断对方是否关注了自己
 		if (toObject!=null){
 			toContact=(Contact)toObject;
 			if(toContact.getAction()==1){
 				each=1;
 				toContact.setEachAttention(1);
 				domainDao.update(toContact);
 			}
 		}
 		if(fromObject!=null){
 			fromContact=(Contact)fromObject;
 			fromContact.setAction(1);
 			fromContact.setEachAttention(each);
 			domainDao.update(fromContact);
 		}else{
 			fromContact=new Contact();
 			fromContact.setFromUser(fromUser);
 			fromContact.setToUser(toUser);
 			fromContact.setAction(1);
 			fromContact.setAccept(0);
 			fromContact.setEachAttention(each);
 			System.out.println(each+"&&&&&&&&&&&&&&&");
 			fromContact.setStartTime(new Timestamp(new Date().getTime()));
 			fromContact.setAcceptTime(new Timestamp(new Date().getTime()));
 			System.out.println(fromObject+"$$$$$$$$$$$$$");
 			domainDao.insert(fromContact);
 		}
 		return fromContact;
 	}
 	/**
 	 * 取消的关注
 	 * @param fromUser
 	 * @param toUser
 	 * @return
 	 */
 	public boolean cancelAttention(User fromUser,User toUser){
 		Object fromObject=domainDao.findIsAttention(fromUser, toUser);
 		Object toObject=domainDao.findIsAttention(toUser, fromUser);
 		Contact fromContact=(Contact)fromObject;
 		Contact toContact=null;
 		if(toObject!=null){
 			toContact=(Contact)toObject;
 			if(toContact.getEachAttention()==1){
 				toContact.setEachAttention(0);
 				domainDao.update(toContact);
 			}
 			
 		}
 		fromContact.setAction(0);
 		fromContact.setEachAttention(0);
 		domainDao.update(fromContact);
 		return true;
 	}
	/**
	 * 通过用户的Id、页数和每页显示最大数查找到该页的关注用户
	 */
	public List findAttentionList(User user,int pageSize,int pageNo) {
		// TODO Auto-generated method stub
		List<List> resultList=new LinkedList<List>();
		List<Object[]> userList=new LinkedList<Object[]>();
		List<Integer> attentionList=new LinkedList<Integer>();
		List<Integer> fansList=new LinkedList<Integer>();
		//System.out.println("进入findAttentionList");
		userList=domainDao.findAttentionList(user,pageSize,pageNo);
		for(int i=0;i<userList.size();i++){
			System.out.println(userList.get(0)+"*********");
			System.out.println(userList.size()+"%%^^^^^^^^");
			System.out.println((Integer)(((Object[])userList.get(i))[i])+"$$$$$$$$$$");
			User fromUser=userDao.selectById((Integer)((userList.get(i))[0]));
			attentionList.add(domainDao.findAttentionNumber(fromUser));
			fansList.add(domainDao.findFansNumber(fromUser));
		}
		resultList.add(userList);
		resultList.add(attentionList);
		resultList.add(fansList);
		System.out.println(resultList.size()+"*********");
		Integer rowCount=new Integer(domainDao.findAllAttention(user).size());
		/*pager=new Pager(pageSize,pageNo,rowCount,resultList);*/
		return resultList;
	}
	/**
	 * 通过用户的Id、页数和每页显示最大数查找到该页的粉丝用户
	 */
	public List findFansList(User toUser,int pageSize,int pageNo){
		List<List> resultList=new LinkedList<List>();
		List<Object[]> userList=new LinkedList<Object[]>();
		List<Integer> attentionList=new LinkedList<Integer>();
		List<Integer> fansList=new LinkedList<Integer>();
		System.out.println("进入findFansList");
		userList=domainDao.findFansList(toUser,pageSize,pageNo);
		for(int i=0;i<userList.size();i++){
			System.out.println(userList.get(0)+"*********");
			System.out.println(userList.size()+"%%^^^^^^^^");
			System.out.println((Integer)(((Object[])userList.get(i))[i])+"$$$$$$$$$$");
			User fromUser=userDao.selectById((Integer)((userList.get(i))[0]));
			attentionList.add(domainDao.findAttentionNumber(fromUser));
			fansList.add(domainDao.findFansNumber(fromUser));
		}
		resultList.add(userList);
		resultList.add(attentionList);
		resultList.add(fansList);
		System.out.println(resultList.size()+"*********");
		Integer rowCount=new Integer(domainDao.findAllFans(toUser).size());
		/*pager=new Pager(pageSize,pageNo,rowCount,resultList);*/
		return resultList;
	}
 	/**
 	 * 查看用户的关注数量
 	 * @param fromUser
 	 * @return
 	 */
 	public int findAttentionNumber(User fromUser){
 		int  attentionNumber=0;
 		attentionNumber=domainDao.findAttentionNumber(fromUser);
 		return attentionNumber;
 	}
 	/**
 	 * 查看用户的粉丝数量
 	 * @param toUser
 	 * @return
 	 */
 	public int findFansNumber(User toUser){
 		int fansNumber=0;
 		fansNumber=domainDao.findFansNumber(toUser);
 		return fansNumber;
 	}
 	/**
 	 * 查看是否关注了某个用户
 	 * @param fromUser
 	 * @param toUser
 	 * @return
 	 */
 	public int findIsAttention(User fromUser,User toUser){
 		//action 0(未关注)1(已关注)2(互相关注)
 		int action=0;
 		Object object=domainDao.findIsAttention(fromUser, toUser);
 		if(object!=null){
 			Contact contact=(Contact)object;
 			if(contact.getAction()==1){
 				if(contact.getEachAttention()==1){
 					action=2;
 				}else{
 					action=1;
 				}
 			}
 		}
 		return action;
 	}
	/**
	 * 通过用户的Id、页数和每页显示最大数查找到该页的未被关注用户
	 */
	public Pager findInattentionList(User user,int pageSize,int pageNo) {
		// TODO Auto-generated method stub
		Pager pager=null;
		System.out.println("进入findInattentionList");
		List list=domainDao.findInattentionList(user,pageSize,pageNo);
		System.out.println(list.size()+"*********");
		Integer rowCount=new Integer(domainDao.findAllInattention(user).size());
		pager=new Pager(pageSize,pageNo,rowCount,list);
		return pager;
	}
	/**
	 * 查找未被邀请或申请的用户
	 * @return
	 */
	public Pager findNotFriendList(User fromUser, int pageSize, int pageNo) {
		// TODO Auto-generated method stub
		Pager pager=null;
		List list=domainDao.findNotFriendList(fromUser,pageSize,pageNo);
		System.out.println(list.size()+"*********");
		Integer rowCount=new Integer(domainDao.findNotFriend(fromUser).size());
		pager=new Pager(pageSize,pageNo,rowCount,list);
		return pager;
	}
	/**
	 * 查找用户申请好友的列表分页
	 * @param fromUser
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public Pager findFriendApplyList(User fromUser, int pageSize, int pageNo){
		Pager pager=null;
		List list=domainDao.findApplyFriendList(fromUser,pageSize,pageNo);
		System.out.println("&&&&&&&&&&&&&");
		Integer rowCount=new Integer(domainDao.findApplyFriend(fromUser).size());
		pager=new Pager(pageSize,pageNo,rowCount,list);
		return pager;
	}
	/**
	 * 查找邀请好友的列表分页
	 * @param fromUser
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public Pager findBeApplyFriendList(User toUser, int pageSize, int pageNo) {
		Pager pager=null;
		List list=domainDao.findBeApplyFriendList(toUser,pageSize,pageNo);
		Integer rowCount=new Integer(domainDao.findBeApplyFriend(toUser).size());
		pager=new Pager(pageSize,pageNo,rowCount,list);
		return pager;
	}
	/**
	 * 查找用户好友的分页列表
	 * @param user
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public Pager findFriendList(User user, int pageSize, int pageNo){
		Pager pager=null;
		List list=domainDao.findFriendList(user, pageSize, pageNo);
		Integer rowCount=new Integer(domainDao.findFriend(user).size());
		pager=new Pager(pageSize,pageNo,rowCount,list);
		return pager;
	}

}//end class
