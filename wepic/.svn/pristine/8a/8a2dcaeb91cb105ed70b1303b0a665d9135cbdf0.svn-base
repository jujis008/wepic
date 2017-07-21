package com.wetuo.wepic.publish.dao ;
 
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
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.wetuo.wepic.publish.beans.Publish;
import com.wetuo.wepic.publish.beans.PublishGuestInfo;
import com.wetuo.wepic.common.hibernate.HibernateSessionFactory;
import com.wetuo.wepic.common.hibernate.XgHibernateCommonDao;
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.util.UUIDGenerator;
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.core.dao.UserDao;

import org.springframework.orm.hibernate3.HibernateCallback;
import java.sql.SQLException;
 
public class PublishGuestInfoDaoImpl extends XgHibernateCommonDao implements PublishGuestInfoDao {
	private static Log log = LogFactory.getLog(PublishGuestInfoDaoImpl.class);
	private static int rowCount = 0;
	private PublishDao publishDao;
	private UserDao userDao;
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public PublishDao getPublishDao() {
		return publishDao;
	}

	public void setPublishDao(PublishDao publishDao) {
		this.publishDao = publishDao;
	}

	//////////////common crud//////////////////////////////////////////////
	public List<PublishGuestInfo> findAll(){ 
		return (List<PublishGuestInfo>)getHibernateTemplate().find("from PublishGuestInfo");
	}
	
	public List<PublishGuestInfo> findPart(String strFields, String[] arrStrValues){ 
		return (List<PublishGuestInfo>)getHibernateTemplate().find("from PublishGuestInfo where "+strFields, arrStrValues);
	}
	
public Pager list(final int pageSize,final int pageNo)  {	
	Pager pager = null;	
	//??????HibernateCallback????4??��??
	List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
		//???HibernateCallback?????????????
		public Object doInHibernate(Session session) throws HibernateException, SQLException {
			//???Hibernate??????
			//List result = session.createQuery(hql).setParameter(0, value).setFirstResult(offset).setMaxResults(pageSize).list();
			Criteria criteria = session.createCriteria(PublishGuestInfo.class);
			PublishGuestInfoDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
			criteria.setProjection(null);
			criteria.setFirstResult(pageSize * (pageNo - 1));
			criteria.setMaxResults(pageSize);
			List<?> result = criteria.list();
			return result;
		}
	});
	pager = new Pager(pageSize, pageNo, PublishGuestInfoDaoImpl.rowCount, list);
	return pager;
	
	}//end list()
public Pager listByUser(final String username,final int pageSize,final int pageNo)  {	
	Pager pager = null;	
	//??????HibernateCallback????4??��??
	List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
		//???HibernateCallback?????????????
		public Object doInHibernate(Session session) throws HibernateException, SQLException {
			//???Hibernate??????
			//List result = session.createQuery(hql).setParameter(0, value).setFirstResult(offset).setMaxResults(pageSize).list();
			Criteria criteria = session.createCriteria(PublishGuestInfo.class);
			PublishGuestInfoDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
			criteria.setProjection(null);
			criteria.setFirstResult(pageSize * (pageNo - 1));
			criteria.setMaxResults(pageSize);
			List<?> result = criteria.list();
			return result;
		}
	});
	pager = new Pager(pageSize, pageNo, PublishGuestInfoDaoImpl.rowCount, list);
	return pager;
	
	}
@SuppressWarnings("unchecked")
public Pager listByName(final String username,final int pageSize,final int pageNo){
	Pager pager = null;	
	//HibernateCallback
	List<Publish> listPublish = getHibernateTemplate().executeFind(new HibernateCallback()	{
		public Object doInHibernate(Session session) throws HibernateException, SQLException {
			Criteria criteria = session.createCriteria(Publish.class);
			PublishGuestInfoDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
			criteria.setProjection(null);
			User user = userDao.select(username);				
			criteria.add(Expression.eq("user",user));
//			criteria.add(Expression.eq("status",1 ));
//			criteria.add(Expression.eq("status",4 ));
			//用户能看到其项目的留言的时候，需要满足statu=1或者statu=4
			//criteria.add(Restrictions.or(Restrictions.eq("status", 1),Restrictions.eq("status", 4)));
			List<Publish> result = (List<Publish>)criteria.list();
			return result;
		}
	});
	List list = new ArrayList();
	for(final Publish publish : listPublish){
		List<PublishGuestInfo> list2 = getHibernateTemplate().executeFind(new HibernateCallback()	{
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				//List result = session.createQuery(hql).setParameter(0, value).setFirstResult(offset).setMaxResults(pageSize).list();
				Criteria criteria = session.createCriteria(PublishGuestInfo.class);
				PublishGuestInfoDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
				criteria.setProjection(null);
				criteria.add(Expression.eq("publish",publish));
				criteria.setFirstResult(pageSize * (pageNo - 1));
				criteria.setMaxResults(pageSize);
				List<PublishGuestInfo> result = criteria.list();
				return result;
			}
		});
		for(PublishGuestInfo publishGuestInfo : list2){
			list.add(publishGuestInfo);
		}
	}
	pager = new Pager(pageSize, pageNo, list.size(), list);
	return pager;
}

public Pager list(final String username,final int pageSize,final int pageNo)  {	
	Pager pager = null;	
	//??????HibernateCallback????4??��??
	List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
		//???HibernateCallback?????????????
		public Object doInHibernate(Session session) throws HibernateException, SQLException {
			//???Hibernate??????
			//List result = session.createQuery(hql).setParameter(0, value).setFirstResult(offset).setMaxResults(pageSize).list();
			Criteria criteria = session.createCriteria(PublishGuestInfo.class);
			PublishGuestInfoDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
			criteria.setProjection(null);
			criteria.setFirstResult(pageSize * (pageNo - 1));
			criteria.setMaxResults(pageSize);
			List<?> result = criteria.list();
			return result;
		}
	});
	pager = new Pager(pageSize, pageNo, PublishGuestInfoDaoImpl.rowCount, list);
	return pager;
	
	}//end list()
	public Pager list(final Map<String,Object> mapSqlParam,final int pageSize,final int pageNo)  {
		Pager pager = null;
		//??????HibernateCallback????4??��??
		List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
		//???HibernateCallback?????????????
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Set setKeyOfMap = new HashSet();
				setKeyOfMap = mapSqlParam.keySet();
				//
				Iterator itKey = setKeyOfMap.iterator();
				String strWhereParam = "";
				int intIWhere = 0;
				while(itKey.hasNext()){
					String strKeyI = (String)itKey.next();
					if(intIWhere == 0){
					strWhereParam = strWhereParam + " a." + strKeyI + " = ? " ;
					}else strWhereParam = strWhereParam + " and a." + strKeyI + " = ? " ; 
					intIWhere++;
				}//end while
				//???Hibernate??????
				int intSerial = 0;
				Query q = session.createQuery("select count(*) from  PublishGuestInfo  a where " + strWhereParam );
				Iterator itKey2 = setKeyOfMap.iterator();
				while(itKey2.hasNext()){
					String strKeyI2 = (String)itKey2.next();
					q.setParameter(intSerial,mapSqlParam.get(strKeyI2)); 
					intSerial++;
				}
				Object count = q.uniqueResult();
				PublishGuestInfoDaoImpl.rowCount = Integer.parseInt(count.toString());
				//
				intSerial = 0;
				q = session.createQuery("select a from PublishGuestInfo a where " + strWhereParam );
				Iterator itKey3 = setKeyOfMap.iterator();
				while(itKey3.hasNext()){
					String strKeyI3 = (String)itKey3.next();
					q.setParameter(intSerial,mapSqlParam.get(strKeyI3)); 
					intSerial++;
				}
				q.setMaxResults(pageSize);
				q.setFirstResult((pageNo - 1) * pageSize);
				List<?> resultList = q.list();
				return resultList;
				}
		});
		pager = new Pager(pageSize, pageNo, PublishGuestInfoDaoImpl.rowCount, list);
		return pager;
		
	}//end list()
		
	/////insert///
	public Integer insert(PublishGuestInfo record) {
		/*
		Session session = null;
		Transaction tx = null;
		Integer id = null;
		try {
			session = HibernateSessionFactory.currentSession();
			tx = session.beginTransaction();
			session.save(record);
			id = record.getId();
			tx.commit();
			
		} catch (HibernateException e) {
			throw e;
			//return record.getId();
		} finally {
			if (tx != null) {
				tx.rollback();
			}
			HibernateSessionFactory.closeSession();
		}
			
		return id;
		*/
		Integer integerRet = null; 
		return (Integer)getHibernateTemplate().save(record);
	}//end insert()
			
	/////get max(id)///
	public int getMaxShowIndex(final String strEntityName,final String strFieldName ) {  
		List list = null; 
		int maxShowIndex = 1;   
		HibernateCallback callback = new HibernateCallback() {
			public Object doInHibernate(Session session)  throws HibernateException { 
				Query q = session.createQuery("select max("+strFieldName+") from "+strEntityName+""); 
				return q.list(); 
			} 
		};
		list = (List) getHibernateTemplate().execute(callback); 
		if (list != null){ 
			if (list.size() == 1) {
				if (list.get(0)!=null) ///���û�����,����᷵��һ��null 
					maxShowIndex = ((Integer) list.get(0)).intValue(); 
			}//end if 
		}//end if 
		return maxShowIndex; 
	}//end  getMaxShowIndex() 
	
	/////delete///
	public boolean delete(PublishGuestInfo record)  {
		/*
		Session session = null;
		Transaction tx = null;
		boolean b = true;
		try {
			session = HibernateSessionFactory.currentSession();
			tx = session.beginTransaction();
			session.delete(record);
			tx.commit();
		} catch (HibernateException e) {
			b = false;
			throw e;
		} finally {
			if (tx != null) {
				tx.rollback();
			}
			HibernateSessionFactory.closeSession();
		}
			
		return b;
		*/
		getHibernateTemplate().delete(record);
		return true;
	}//end delete()
			
	public boolean delete(Integer id)  {
		/*
		PublishGuestInfo record = select(id);
		Session session = null;
		Transaction tx = null;
		boolean b = true;
		try {
			session = HibernateSessionFactory.currentSession();
			tx = session.beginTransaction();
			session.delete(record);
			tx.commit();
		} catch (HibernateException e) {
			b = false;
			throw e;
		} finally {
			if (tx != null) {
				tx.rollback();
			}
			HibernateSessionFactory.closeSession();
		}
			
		return b;
		*/
		Object obj = getHibernateTemplate().load(PublishGuestInfo.class,new Integer(id));
		getHibernateTemplate().delete(obj);
		return true;
	}//end delete()
			
	/////update///
	public boolean update(PublishGuestInfo record)  {
		/*
		Session session = null;
		Transaction tx = null;
		boolean b = true;
		try {
			session = HibernateSessionFactory.currentSession();
			tx = session.beginTransaction();
			session.update(record);
			tx.commit();
		} catch (HibernateException e) {
			b = false;
			throw e;
		} finally {
			if (tx != null) {
				tx.rollback();
			}
			HibernateSessionFactory.closeSession();
		}
			
		return b;
		*/
		getHibernateTemplate().update(record);
		return true;
		
	}//end update()
			
	/////select///
	public PublishGuestInfo select(Integer id)  {
		/*
		Session session = null;
		PublishGuestInfo record = null;
		try {
			session = HibernateSessionFactory.currentSession();
			Query query = session.createQuery("from PublishGuestInfo where id=?");
			query.setInteger(0, id);
			record = (PublishGuestInfo) query.uniqueResult();
			query = null;
			
		} catch (HibernateException e) {
			throw e;
		} finally {
			HibernateSessionFactory.closeSession();
		}
		
		return record;
		*/
		
		return (PublishGuestInfo) getHibernateTemplate().get(PublishGuestInfo.class, new Integer(id));
		
		
	}//end select()
	
	/////main///
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
}//end class
