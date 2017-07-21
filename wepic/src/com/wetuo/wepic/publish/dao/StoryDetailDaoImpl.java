package com.wetuo.wepic.publish.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.weibo.login.weibo4j.model.User;
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.hibernate.XgHibernateCommonDao;
import com.wetuo.wepic.core.dao.UserDao;
import com.wetuo.wepic.publish.beans.Story;
import com.wetuo.wepic.publish.beans.StoryDetail;

public class StoryDetailDaoImpl  extends XgHibernateCommonDao implements StoryDetailDao {
	private static Log log = LogFactory.getLog(StoryDetailDaoImpl.class);
	private static int rowCount = 0;
	private StoryDao storyDao;
	private UserDao userDao;
	
	public StoryDao getStoryDao() {
		return storyDao;
	}

	public void setStoryDao(StoryDao storyDao) {
		this.storyDao = storyDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	
	
	
	public List<StoryDetail> findAll(){ 
		return (List<StoryDetail>)getHibernateTemplate().find("from StoryDetail");
	}
	
	public List<StoryDetail> findPart(String strFields, String[] arrStrValues){ 
		return (List<StoryDetail>)getHibernateTemplate().find("from StoryDetail where "+strFields, arrStrValues);
	}
public Pager list(final int pageSize,final int pageNo)  {	
	Pager pager = null;	
	//??????HibernateCallback????4??��??
	List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
		//???HibernateCallback?????????????
		public Object doInHibernate(Session session) throws HibernateException, SQLException {
			//???Hibernate??????
			//List result = session.createQuery(hql).setParameter(0, value).setFirstResult(offset).setMaxResults(pageSize).list();
			Criteria criteria = session.createCriteria(StoryDetail.class);
			StoryDetailDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
			criteria.setProjection(null);
			criteria.setFirstResult(pageSize * (pageNo - 1));
			criteria.setMaxResults(pageSize);
			List<?> result = criteria.list();
			return result;
		}
	});
	pager = new Pager(pageSize, pageNo, StoryDetailDaoImpl.rowCount, list);
	return pager;
	
	}//end list()
	@SuppressWarnings("unchecked")
	public Pager list(final String username,final int pageSize,final int pageNo)  {	
		Pager pager = null;	
		//HibernateCallback
		List<Story> listPublish = getHibernateTemplate().executeFind(new HibernateCallback()	{
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(Story.class);
				StoryDetailDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
				criteria.setProjection(null);
				User user = null;				
				criteria.add(Expression.eq("user",user));
				List<Story> result = (List<Story>)criteria.list();
				return result;
			}
		});
		
		List list = new ArrayList();
		for(final Story story : listPublish){
			List<StoryDetail> list2 = getHibernateTemplate().executeFind(new HibernateCallback()	{
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					//List result = session.createQuery(hql).setParameter(0, value).setFirstResult(offset).setMaxResults(pageSize).list();
					Criteria criteria = session.createCriteria(StoryDetail.class);
					StoryDetailDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
					criteria.setProjection(null);
					criteria.add(Expression.eq("story",story));
					criteria.setFirstResult(pageSize * (pageNo - 1));
					criteria.setMaxResults(pageSize);
					List<StoryDetail> result = criteria.list();
					return result;
				}
			});
			for(StoryDetail publishDetail : list2){
				list.add(publishDetail);
			}
		}//end for
		
		pager = new Pager(pageSize, pageNo, StoryDetailDaoImpl.rowCount, list);
		return pager;
		
	}//end list()
	
	public Pager listForCommonUser(final String username,final int pageSize,final int pageNo){
		Pager pager = null;	
		final List<Story> listPublish = getHibernateTemplate().executeFind(new HibernateCallback()	{
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(Story.class);
//				PublishDetailDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
//				criteria.setProjection(null);
				User user = null;				
				criteria.add(Expression.eq("user",user));
				List<Story> result = (List<Story>)criteria.list();
				return result;
			}
		});
		
		List<StoryDetail> list2 = getHibernateTemplate().executeFind(new HibernateCallback() {

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(StoryDetail.class);
				criteria.add(Expression.in("story", listPublish));
				StoryDetailDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
				criteria.setProjection(null);
				criteria.setFirstResult(pageSize * (pageNo - 1));
				criteria.setMaxResults(pageSize);
				List<StoryDetail> result = criteria.list();
				return result;
				//return null;
			}
		});
		pager = new Pager(pageSize, pageNo, StoryDetailDaoImpl.rowCount, list2);
		return pager;
	}

	
	public Pager listUnderPublish(final Integer publishId,final int pageSize,final int pageNo)  {	
		Pager pager = null;	
		//HibernateCallback
		List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
			//???HibernateCallback?????????????
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				//???Hibernate??????
				//List result = session.createQuery(hql).setParameter(0, value).setFirstResult(offset).setMaxResults(pageSize).list();
				Criteria criteria = session.createCriteria(StoryDetail.class);
//				PublishDetailDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
				Story publish = storyDao.select(publishId);
				criteria.add(Expression.eq("story",publish));
				StoryDetailDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
				criteria.setProjection(null);
				criteria.setFirstResult(pageSize * (pageNo - 1));
				criteria.setMaxResults(pageSize);
				List<?> result = criteria.list();
				return result;
			}
		});
		pager = new Pager(pageSize, pageNo, StoryDetailDaoImpl.rowCount, list);
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
				Query q = session.createQuery("select count(*) from  PublishDetail  a where " + strWhereParam );
				Iterator itKey2 = setKeyOfMap.iterator();
				while(itKey2.hasNext()){
					String strKeyI2 = (String)itKey2.next();
					q.setParameter(intSerial,mapSqlParam.get(strKeyI2)); 
					intSerial++;
				}
				Object count = q.uniqueResult();
				StoryDetailDaoImpl.rowCount = Integer.parseInt(count.toString());
				//
				intSerial = 0;
				q = session.createQuery("select a from PublishDetail a where " + strWhereParam );
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
		pager = new Pager(pageSize, pageNo, StoryDetailDaoImpl.rowCount, list);
		return pager;
		
	}//end list()
		
	/////insert///
	public Integer insert(StoryDetail record) {
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
	public boolean delete(StoryDetail record)  {
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
		PublishDetail record = select(id);
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
		Object obj = getHibernateTemplate().load(StoryDetail.class,new Integer(id));
		getHibernateTemplate().delete(obj);
		return true;
	}//end delete()
			
	/////update///
	public boolean update(StoryDetail record)  {
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
	public StoryDetail select(Integer id)  {
		/*
		Session session = null;
		PublishDetail record = null;
		try {
			session = HibernateSessionFactory.currentSession();
			Query query = session.createQuery("from PublishDetail where id=?");
			query.setInteger(0, id);
			record = (PublishDetail) query.uniqueResult();
			query = null;
			
		} catch (HibernateException e) {
			throw e;
		} finally {
			HibernateSessionFactory.closeSession();
		}
		
		return record;
		*/
		
		return (StoryDetail) getHibernateTemplate().get(StoryDetail.class, new Integer(id));
		
		
	}//end select()
	
	/////main///
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	public Pager findAllPublishDetailsBypublish(final int publishId, final int pageSize, final int pageNo) {
		Pager pager = null;
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(StoryDetail.class);
				StoryDetailDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
				criteria.setProjection(null);
				Story story = storyDao.select(publishId);
				criteria.add(Expression.eq("story", story));
				criteria.setFirstResult(pageSize*(pageNo-1));
				criteria.setMaxResults(pageSize);
				List<?> result = criteria.list();
				return result;
			}
		});
		pager = new Pager(pageSize,pageNo,StoryDetailDaoImpl.rowCount,list);
		return pager;
	}

	
	public List<StoryDetail> showThePublishofdetais(final int publishId) {
		List list = getHibernateTemplate().executeFind(new HibernateCallback(){

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(StoryDetail.class);
				Story story = storyDao.select(publishId);
				criteria.add(Expression.eq("story", story));
				List result = criteria.list();
				return result;
			}});
		return list;
	}

}
