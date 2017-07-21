package com.wetuo.wepic.core.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.wetuo.wepic.core.beans.Contact;
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.core.service.UserService;
import com.wetuo.wepic.common.hibernate.HibernateSessionFactory;
import com.wetuo.wepic.common.hibernate.XgHibernateCommonDao;
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.util.UUIDGenerator;
import org.springframework.orm.hibernate3.HibernateCallback;
import java.sql.SQLException;

public class ContactDaoImpl extends XgHibernateCommonDao implements ContactDao {
	private static Log log = LogFactory.getLog(ContactDaoImpl.class);
	private static int rowCount = 0;
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	// ////////////common crud//////////////////////////////////////////////
	public List<Contact> findAll() {
		return (List<Contact>) getHibernateTemplate().find("from Contact");
	}

	public List<Contact> findPart(String strFields, String[] arrStrValues) {
		return (List<Contact>) getHibernateTemplate().find(
				"from Contact where " + strFields, arrStrValues);
	}
	/**
 	 * 通过用户Id,显示的最大条数和页号查找粉丝列表
 	 * @param user
 	 * @param pageSize
 	 * @param pageNo
 	 * @return
 	 */
 	public List findFansList(User user,int pageSize,int pageNo){
 		List list = null;
		String sqlStr="select user.id ,contact.action,contact.eachAttention,contact.startTime," +
				"user.username,user.ifIdentityTrue,user.sex,user.personOrCompany,user.role,user.portrait,user.workPlace," +
				"usercredit.totalMark,usercredit.bidGoodRemarkNum,usercredit.bidBadRemarkNum from "+
				"Contact contact,user user,UserCredit usercredit " +
				"where contact.fromUser=user.id and usercredit.user_=user.id " +
				"and contact.toUser= ? and contact.action =  1 order by contact.startTime desc";
		try {
			Session session=getSession();
			Query q =session.createSQLQuery(sqlStr);
			q.setParameter(0, user.getId());
			q.setFirstResult(pageSize * (pageNo - 1));
			q.setMaxResults(pageSize);
		    list = q.list();
		    System.out.println(list.size()+"**************");
		    releaseSession(session);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
 	}
 	/**
 	 * 查看所有粉丝
 	 * @param user
 	 * @return
 	 */
 	public List findAllFans(User user){
 		List list=null;
 		try {
 			Session session=getSession();
			Query q = session.createQuery("from Contact c where c.toUser=? and action=1");
			q.setParameter(0, user);
		    list = q.list();
		    releaseSession(session);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		return list;
 	}
	/**
 	 * 查看关注的的数量
 	 * @param toUser
 	 * @return
 	 */
 	public int findAttentionNumber(User fromUser){
 		int attentionNumber=0;
 		try {
 			Session session=getSession();
			Query q=session.createQuery("select count(*) from Contact c where c.fromUser=? and c.action=1");
			q.setParameter(0, fromUser);
			Object number=q.uniqueResult();
			if(number!=null){
				attentionNumber=((Long)number).intValue();
			}
			releaseSession(session);
		} catch(Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		return attentionNumber;
 	}
 	/**
 	 * 查看粉丝的数量
 	 * @param toUser
 	 * @return
 	 */
 	//sessio
 	public int findFansNumber(User toUser){
 		int fansNumber=0;
 		try {
 			Session session=getSession();
			Query q=session.createQuery("select count(*) from Contact c where c.toUser=? and c.action=1");
			q.setParameter(0, toUser);
			Object number=q.uniqueResult();
			if(number!=null){
				fansNumber=((Long)number).intValue();
			}
			
			releaseSession(session);
			
			
 		} catch(Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		return fansNumber;
 	}
	/**
 	 * 查找是否关注了某个用户
 	 * @param fromUser 
 	 * @param toUser
 	 * @return 
 	 */
 	public Object findIsAttention(User fromUser,User toUser){
 		Object contact=null;
		try {
			Session session=getSession();
			Query q = session.createQuery("from Contact c where c.fromUser=? and c.toUser=?");
			System.out.println(fromUser.getId()+"&7777777777");
			System.out.println(toUser.getId()+"????????");
			q.setParameter(0, fromUser);
			q.setParameter(1, toUser);
		    contact =q.uniqueResult();
		    System.out.println("查看有是否关注");
		    releaseSession(session);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		return contact;
 	}
	public Pager list(final int pageSize, final int pageNo) {
		Pager pager = null;
		// ??????HibernateCallback????4??��??
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			// ???HibernateCallback?????????????
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				// ???Hibernate??????
				// List result = session.createQuery(hql).setParameter(0,
				// value).setFirstResult(offset).setMaxResults(pageSize).list();
				Criteria criteria = session.createCriteria(Contact.class);
				ContactDaoImpl.rowCount = ((Integer) criteria.setProjection(
						Projections.rowCount()).uniqueResult()).intValue();
				criteria.setProjection(null);
				criteria.setFirstResult(pageSize * (pageNo - 1));
				criteria.setMaxResults(pageSize);
				List<?> result = criteria.list();
				return result;
			}
		});
		pager = new Pager(pageSize, pageNo, ContactDaoImpl.rowCount, list);
		return pager;

	}// end list()

	public Pager list(final String username, final int pageSize,
			final int pageNo) {
		Pager pager = null;
		// ??????HibernateCallback????4??��??
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			// ???HibernateCallback?????????????
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				// ???Hibernate??????
				// List result = session.createQuery(hql).setParameter(0,
				// value).setFirstResult(offset).setMaxResults(pageSize).list();
				Criteria criteria = session.createCriteria(Contact.class);
				ContactDaoImpl.rowCount = ((Integer) criteria.setProjection(
						Projections.rowCount()).uniqueResult()).intValue();
				criteria.setProjection(null);
				criteria.setFirstResult(pageSize * (pageNo - 1));
				criteria.setMaxResults(pageSize);
				List<?> result = criteria.list();
				return result;
			}
		});
		pager = new Pager(pageSize, pageNo, ContactDaoImpl.rowCount, list);
		return pager;

	}// end list()

	public Pager list(final Map<String, Object> mapSqlParam,
			final int pageSize, final int pageNo) {
		Pager pager = null;
		// ??????HibernateCallback????4??��??
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			// ???HibernateCallback?????????????
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Set setKeyOfMap = new HashSet();
				setKeyOfMap = mapSqlParam.keySet();
				//
				Iterator itKey = setKeyOfMap.iterator();
				String strWhereParam = "";
				int intIWhere = 0;
				while (itKey.hasNext()) {
					String strKeyI = (String) itKey.next();
					if (intIWhere == 0) {
						strWhereParam = strWhereParam + " a." + strKeyI
								+ " = ? ";
					} else
						strWhereParam = strWhereParam + " and a." + strKeyI
								+ " = ? ";
					intIWhere++;
				}// end while
				// ???Hibernate??????
				int intSerial = 0;
				Query q = session
						.createQuery("select count(*) from  Contact  a where "
								+ strWhereParam);
				Iterator itKey2 = setKeyOfMap.iterator();
				while (itKey2.hasNext()) {
					String strKeyI2 = (String) itKey2.next();
					q.setParameter(intSerial, mapSqlParam.get(strKeyI2));
					intSerial++;
				}
				Object count = q.uniqueResult();
				ContactDaoImpl.rowCount = Integer.parseInt(count.toString());
				//
				intSerial = 0;
				q = session.createQuery("select a from Contact a where "
						+ strWhereParam);
				Iterator itKey3 = setKeyOfMap.iterator();
				while (itKey3.hasNext()) {
					String strKeyI3 = (String) itKey3.next();
					q.setParameter(intSerial, mapSqlParam.get(strKeyI3));
					intSerial++;
				}
				q.setMaxResults(pageSize);
				q.setFirstResult((pageNo - 1) * pageSize);
				List<?> resultList = q.list();
				return resultList;
			}
		});
		pager = new Pager(pageSize, pageNo, ContactDaoImpl.rowCount, list);
		return pager;

	}// end list()

	// ///insert///
	public Integer insert(Contact record) {
		/*
		 * Session session = null; Transaction tx = null; Integer id = null; try
		 * { session = HibernateSessionFactory.currentSession(); tx =
		 * session.beginTransaction(); session.save(record); id =
		 * record.getId(); tx.commit();
		 * 
		 * } catch (HibernateException e) { throw e; //return record.getId(); }
		 * finally { if (tx != null) { tx.rollback(); }
		 * HibernateSessionFactory.closeSession(); }
		 * 
		 * return id;
		 */
		Integer integerRet = null;
		
		return (Integer) getHibernateTemplate().save(record);
	}// end insert()

	// ///get max(id)///
	public int getMaxShowIndex(final String strEntityName,
			final String strFieldName) {
		List list = null;
		int maxShowIndex = 1;
		HibernateCallback callback = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				Query q = session.createQuery("select max(" + strFieldName
						+ ") from " + strEntityName + "");
				return q.list();
			}
		};
		list = (List) getHibernateTemplate().execute(callback);
		if (list != null) {
			if (list.size() == 1) {
				if (list.get(0) != null) // /���û�����,����᷵��һ��null
					maxShowIndex = ((Integer) list.get(0)).intValue();
			}// end if
		}// end if
		return maxShowIndex;
	}// end getMaxShowIndex()

	// ///delete///
	public boolean delete(Contact record) {
		/*
		 * Session session = null; Transaction tx = null; boolean b = true; try
		 * { session = HibernateSessionFactory.currentSession(); tx =
		 * session.beginTransaction(); session.delete(record); tx.commit(); }
		 * catch (HibernateException e) { b = false; throw e; } finally { if (tx
		 * != null) { tx.rollback(); } HibernateSessionFactory.closeSession(); }
		 * 
		 * return b;
		 */
		getHibernateTemplate().delete(record);
		return true;
	}// end delete()

	public boolean delete(Integer id) {
		/*
		 * Contact record = select(id); Session session = null; Transaction tx =
		 * null; boolean b = true; try { session =
		 * HibernateSessionFactory.currentSession(); tx =
		 * session.beginTransaction(); session.delete(record); tx.commit(); }
		 * catch (HibernateException e) { b = false; throw e; } finally { if (tx
		 * != null) { tx.rollback(); } HibernateSessionFactory.closeSession(); }
		 * 
		 * return b;
		 */
		Object obj = getHibernateTemplate()
				.load(Contact.class, new Integer(id));
		getHibernateTemplate().delete(obj);
		return true;
	}// end delete()

	// ///update///
	public boolean update(Contact record) {
		/*
		 * Session session = null; Transaction tx = null; boolean b = true; try
		 * { session = HibernateSessionFactory.currentSession(); tx =
		 * session.beginTransaction(); session.update(record); tx.commit(); }
		 * catch (HibernateException e) { b = false; throw e; } finally { if (tx
		 * != null) { tx.rollback(); } HibernateSessionFactory.closeSession(); }
		 * 
		 * return b;
		 */
		getHibernateTemplate().update(record);
		return true;

	}// end update()

	// ///select///
	public Contact select(Integer id) {
		/*
		 * Session session = null; Contact record = null; try { session =
		 * HibernateSessionFactory.currentSession(); Query query =
		 * session.createQuery("from Contact where id=?"); query.setInteger(0,
		 * id); record = (Contact) query.uniqueResult(); query = null;
		 * 
		 * } catch (HibernateException e) { throw e; } finally {
		 * HibernateSessionFactory.closeSession(); }
		 * 
		 * return record;
		 */

		return (Contact) getHibernateTemplate().get(Contact.class,
				new Integer(id));

	}// end select()

	// ///main///
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	/**
	 * 通过用户Id,显示的最大条数和页号查找关注列表
	 * 
	 * @param userId
	 *            用户Id
	 * @param pageSize
	 *            显示的最大条数
	 * @param pageNo
	 *            页号
	 * @return
	 */
	public List findAttentionList(User user, int pageSize, int pageNo) {
		// TODO Auto-generated method stub12		
		List list = null;
		String sqlStr="select user.id ,contact.action,contact.eachAttention,contact.startTime," +
				"user.username,user.ifIdentityTrue,user.sex,user.personOrCompany,user.role,user.portrait,user.workPlace," +
				"usercredit.totalMark,usercredit.bidGoodRemarkNum,usercredit.bidBadRemarkNum from "+
				"Contact contact,user user,UserCredit usercredit " +
				"where contact.toUser=user.id and usercredit.user_=user.id " +
				"and contact.fromUser= ? and contact.action =  1 order by contact.startTime desc";
		try {
			Session session=getSession();
			Query q =session.createSQLQuery(sqlStr);
			q.setParameter(0, user.getId());
			q.setFirstResult(pageSize * (pageNo - 1));
			q.setMaxResults(pageSize);
		    list = q.list();
		    releaseSession(session);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 根据用户Id查找所有的用户关注
	 */
	public List<Object[]> findAllAttention(User user) {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			Session session=getSession();
			Query q = session.createQuery("from Contact c where c.fromUser=? and action=1");
			q.setParameter(0, user);
		    list = q.list();
		    releaseSession(session);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 根据用户Id查找所有的未被关注的
	 */
	public List findAllInattention(User user) {
		List list = null;
		try {
			Session session=getSession();
			Query q =session.createQuery("from User u where u not in(select c.toUser from Contact c where c.fromUser=? and action=1) and u != ?");
			q.setParameter(0, user);
			q.setParameter(1, user);
		    list = q.list();
		    releaseSession(session);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	/**
 	 * 通过用户Id,未被关注的用户列表
 	 * @param userId 	用户Id
 	 * @param pageSize	显示的最大条数
 	 * @param pageNo	页号
 	 * @return
 	 */
	public List findInattentionList(User user, int pageSize, int pageNo) {
		List list = null;
		try {
			Session session=getSession();
			Query q = getSession().createQuery("from User u where u not in(select c.toUser from Contact c where c.fromUser=? and action=1) and u != ?");
			q.setParameter(0, user);
			q.setParameter(1, user);
			q.setFirstResult(pageSize * (pageNo - 1));
			q.setMaxResults(pageSize);
		    list = q.list();
		    releaseSession(session);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 查找到用户的好友
	 * @param fromUser
	 * @return
	 */
	public List findFriend(User user){
		List list=null;
		try {
			Session session=getSession();
			Query q = session.createQuery("from Contact where accept=1 and action=2 and id in(select id from Contact where fromUser=? or toUser=?)");			
			q.setParameter(0,user);
			q.setParameter(1,user);
		    list = q.list();
		    releaseSession(session);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 查找到用户的好友的分类列表
	 * @param fromUser
	 * @return
	 */
	public List findFriendList(User user,int pageSize, int pageNo){
		List list=null;
		try {
			Session session=getSession();
			Query q = session.createQuery("from Contact where accept=1 and action=2 and id in(select id from Contact where fromUser=? or toUser=?)");
			q.setParameter(0,user);
			q.setParameter(1,user);
			q.setFirstResult(pageSize * (pageNo - 1));
			q.setMaxResults(pageSize);
		    list = q.list();
		    releaseSession(session);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 查找用户正在申请的的好友
	 * @param fromUser
	 * @return
	 */
	public List findInApply(User fromUser){
		List list=null;	
		try {
			Session session=getSession();
			Query q = session.createQuery("from Contact c where c.fromUser=? and c.action=2 and c.accept=0");
			q.setParameter(0, fromUser);
		    list = q.list();
		    releaseSession(session);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return list;
	}
	/**
	 * 查找用户被申请的列表
	 * @param fromUser
	 * @return
	 */
	public List findBeApply(User toUser){
		List list=null;
		try {
			Session session=getSession();
			Query q = session.createQuery("from Contact c where c.toUser=? and c.action=2 and c.accept=0");
			q.setParameter(0, toUser);
		    list = q.list();
		  releaseSession(session);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return list;
	}
	/**
	 * 查找所有未添加过的好友
	 * @param fromUser
	 * @return
	 */
	public List findNotFriend(User fromUser){
		List list=null;
		try {
			Session session=getSession();
			Query q =session.createQuery("from User u where u not in(select c.toUser from Contact c where c.fromUser=? and action=2) and u != ? and u not in(select c.fromUser from Contact c where c.toUser=? and action=2) and u.ifIdentityTrue=1") ;
			q.setParameter(0, fromUser);
			q.setParameter(1, fromUser);
			q.setParameter(2, fromUser);
//			q.setFirstResult(pageSize * (pageNo - 1));
//			q.setMaxResults(pageSize);
		    list = q.list();
		    releaseSession(session);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 查找所有未添加过的好友的分页
	 * @param fromUser
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public List findNotFriendList(User fromUser, int pageSize, int pageNo){
		List list=null;
		try {
			Session session=getSession();
			Query q =session.createQuery("from User u where u not in(select c.toUser from Contact c where c.fromUser=? and action=2) and u != ? and u not in(select c.fromUser from Contact c where c.toUser=? and action=2)and u.ifIdentityTrue=1") ;
			q.setParameter(0, fromUser);
			q.setParameter(1, fromUser);
			q.setParameter(2, fromUser);
			q.setFirstResult(pageSize * (pageNo - 1));
			q.setMaxResults(pageSize);
		    list = q.list();
//		    System.out.println(list.size()+"^^^^^^^^^^^^^^^^^^^^^^^");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 查找用户申请的好友
	 * @param fromUser
	 * @return
	 */
	public List findApplyFriend(User fromUser){
		List list=null;
		try {
			Session session=getSession();
			Query q = session.createQuery("from Contact c where c.fromUser=? and c.action=2") ;
			q.setParameter(0, fromUser);
//			q.setFirstResult(pageSize * (pageNo - 1));
//			q.setMaxResults(pageSize);
		    list = q.list();
		    releaseSession(session);
//		    System.out.println(list.size()+"^^^^^^^^^^^^^^^^^^^^^^^");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 查找用户申请的好友分页列表
	 * @param fromUser
	 * @return
	 */
	public List findApplyFriendList(User fromUser, int pageSize, int pageNo){
		List list=null;
		try {
			Session session=getSession();
			Query q = session.createQuery("from Contact c where c.fromUser=? and c.action=2") ;			
			q.setParameter(0, fromUser);
			q.setFirstResult(pageSize * (pageNo - 1));
			q.setMaxResults(pageSize);
		    list = q.list();
		    releaseSession(session);
//		    System.out.println(list.size()+"^^^^^^^^^^^^^^^^^^^^^^^");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 查找邀请用户的好友
	 * @param fromUser
	 * @return
	 */
	public List findBeApplyFriend(User toUser){
		List list=null;
		try {
			Session session=getSession();
			Query q = session.createQuery("from Contact c where c.toUser=? and c.action=2") ;
			q.setParameter(0, toUser);
//			q.setFirstResult(pageSize * (pageNo - 1));
//			q.setMaxResults(pageSize);
		    list = q.list();
           releaseSession(session);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 查找邀请用户的好友分页列表
	 * @param fromUser
	 * @return
	 */
	public List findBeApplyFriendList(User toUser, int pageSize, int pageNo){
		List list=null;
		try {
			Session session=getSession();
			Query q = session.createQuery("from Contact c where c.toUser=? and c.action=2") ;			
			q.setParameter(0, toUser);
			q.setFirstResult(pageSize * (pageNo - 1));
			q.setMaxResults(pageSize);
		    list = q.list();
		   releaseSession(session);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}


}// end class
