package com.wetuo.wepic.core.dao ;
 
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
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.wetuo.wepic.core.beans.ResMenuItem;
import com.wetuo.wepic.common.hibernate.HibernateSessionFactory;
import com.wetuo.wepic.common.hibernate.XgHibernateCommonDao;
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.util.UUIDGenerator;
import org.springframework.orm.hibernate3.HibernateCallback;
import java.sql.SQLException;
 
public class ResMenuItemDaoImpl extends XgHibernateCommonDao implements ResMenuItemDao {
	private static Log log = LogFactory.getLog(ResMenuItemDaoImpl.class);
	private static int rowCount = 0;
	private ResMenuDao resMenuDao ;
	//////////////common crud//////////////////////////////////////////////
	public List<ResMenuItem> findAll(){ 
		return (List<ResMenuItem>)getHibernateTemplate().find("from ResMenuItem");
	}
	
	public List<ResMenuItem> findByMenu(int menuId){ 
		return (List<ResMenuItem>)getHibernateTemplate().find("from ResMenuItem as ResMenuItem where ResMenuItem.resMenu.id = " + menuId);
	}
	
	public Pager pagerByMenu( final int menuId, final int pageSize, final int pageNo ){
		Pager pager = null;	
		
		//List<ResMenuItem> list = (List<ResMenuItem>)getHibernateTemplate().find("from ResMenuItem as ResMenuItem where ResMenuItem.resMenu.id = " + menuId);
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		Query queryObject = session.createQuery("from ResMenuItem as ResMenuItem where ResMenuItem.resMenu.id = " + menuId);
	    queryObject.setFirstResult(pageSize * (pageNo - 1));
	    queryObject.setMaxResults(pageSize);
	    List<ResMenuItem> list = (List<ResMenuItem>)queryObject.list();
	    
	    Session session2 = getHibernateTemplate().getSessionFactory().getCurrentSession();
		String hql = "select count(*) from ResMenuItem as ResMenuItem where ResMenuItem.resMenu.id = " + menuId;
		ResMenuItemDaoImpl.rowCount = (Integer) session2.createQuery(hql).uniqueResult();
		
		pager = new Pager(pageSize, pageNo, ResMenuItemDaoImpl.rowCount, list);
		return pager;
	}
	
	public List<ResMenuItem> findPart(String strFields, String[] arrStrValues){ 
		return (List<ResMenuItem>)getHibernateTemplate().find("from ResMenuItem where "+strFields, arrStrValues);
	}
	
	public Pager list(final int pageSize,final int pageNo)  {	
		Pager pager = null;	
		//??????HibernateCallback????4??��??
		List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
			//???HibernateCallback?????????????
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				//???Hibernate??????
				//List result = session.createQuery(hql).setParameter(0, value).setFirstResult(offset).setMaxResults(pageSize).list();
				Criteria criteria = session.createCriteria(ResMenuItem.class);
				ResMenuItemDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
				criteria.setProjection(null);
				criteria.setFirstResult(pageSize * (pageNo - 1));
				criteria.setMaxResults(pageSize);
				List<?> result = criteria.list();
				return result;
			}
		});
		pager = new Pager(pageSize, pageNo, ResMenuItemDaoImpl.rowCount, list);
		return pager;
	
	}//end list()
	public Pager list(final String username,final int pageSize,final int pageNo)  {	
		Pager pager = null;	
		List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				//List result = session.createQuery(hql).setParameter(0, value).setFirstResult(offset).setMaxResults(pageSize).list();
				Criteria criteria = session.createCriteria(ResMenuItem.class);
				ResMenuItemDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
				criteria.setProjection(null);
				criteria.setFirstResult(pageSize * (pageNo - 1));
				criteria.setMaxResults(pageSize);
				List<?> result = criteria.list();
				return result;
			}
		});
		pager = new Pager(pageSize, pageNo, ResMenuItemDaoImpl.rowCount, list);
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
				Query q = session.createQuery("select count(*) from  ResMenuItem  a where " + strWhereParam );
				Iterator itKey2 = setKeyOfMap.iterator();
				while(itKey2.hasNext()){
					String strKeyI2 = (String)itKey2.next();
					q.setParameter(intSerial,mapSqlParam.get(strKeyI2)); 
					intSerial++;
				}
				Object count = q.uniqueResult();
				ResMenuItemDaoImpl.rowCount = Integer.parseInt(count.toString());
				//
				intSerial = 0;
				q = session.createQuery("select a from ResMenuItem a where " + strWhereParam );
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
		pager = new Pager(pageSize, pageNo, ResMenuItemDaoImpl.rowCount, list);
		return pager;
		
	}//end list()
		
	/////insert///
	public Integer insert(ResMenuItem record) {
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
	public boolean delete(ResMenuItem record)  {
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
		ResMenuItem record = select(id);
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
		Object obj = getHibernateTemplate().load(ResMenuItem.class,new Integer(id));
		getHibernateTemplate().delete(obj);
		return true;
	}//end delete()
			
	/////update///
	public boolean update(ResMenuItem record)  {
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
	public ResMenuItem select(Integer id)  {
		/*
		Session session = null;
		ResMenuItem record = null;
		try {
			session = HibernateSessionFactory.currentSession();
			Query query = session.createQuery("from ResMenuItem where id=?");
			query.setInteger(0, id);
			record = (ResMenuItem) query.uniqueResult();
			query = null;
			
		} catch (HibernateException e) {
			throw e;
		} finally {
			HibernateSessionFactory.closeSession();
		}
		
		return record;
		*/
		
		return (ResMenuItem) getHibernateTemplate().get(ResMenuItem.class, new Integer(id));
		
		
	}//end select()
	
	
	
	public ResMenuDao getResMenuDao() {
		return resMenuDao;
	}

	public void setResMenuDao(ResMenuDao resMenuDao) {
		this.resMenuDao = resMenuDao;
	}

	/////main///
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	
}//end class
