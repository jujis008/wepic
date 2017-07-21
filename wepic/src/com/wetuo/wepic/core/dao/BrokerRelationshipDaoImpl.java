package com.wetuo.wepic.core.dao ;
 
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ArrayList;
 
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.wetuo.wepic.core.beans.BrokerRelationship;
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.core.service.UserService;
import com.wetuo.wepic.common.hibernate.HibernateSessionFactory;
import com.wetuo.wepic.common.hibernate.XgHibernateCommonDao;
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.util.UUIDGenerator;
import com.sun.org.apache.xpath.internal.Expression;

import org.springframework.orm.hibernate3.HibernateCallback;
import java.sql.SQLException;
 
public class BrokerRelationshipDaoImpl extends XgHibernateCommonDao implements BrokerRelationshipDao {
	private static Log log = LogFactory.getLog(BrokerRelationshipDaoImpl.class);
	private static int rowCount = 0;
	private UserService userService;
	//////////////common crud//////////////////////////////////////////////
	public List<BrokerRelationship> findAll(){ 
		return (List<BrokerRelationship>)getHibernateTemplate().find("from BrokerRelationship");
	}
	
	public List<BrokerRelationship> findPart(String strFields, String[] arrStrValues){ 
		return (List<BrokerRelationship>)getHibernateTemplate().find("from BrokerRelationship where "+strFields, arrStrValues);
	}
	
public Pager list(final int pageSize,final int pageNo)  {	
	Pager pager = null;	
	//??????HibernateCallback????4??��??
	List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
		//???HibernateCallback?????????????
		public Object doInHibernate(Session session) throws HibernateException, SQLException {
			//???Hibernate??????
			//List result = session.createQuery(hql).setParameter(0, value).setFirstResult(offset).setMaxResults(pageSize).list();
			Criteria criteria = session.createCriteria(BrokerRelationship.class);
			BrokerRelationshipDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
			criteria.setProjection(null);
			criteria.setFirstResult(pageSize * (pageNo - 1));
			criteria.setMaxResults(pageSize);
			List<?> result = criteria.list();
			return result;
		}
	});
	pager = new Pager(pageSize, pageNo, BrokerRelationshipDaoImpl.rowCount, list);
	return pager;
	
	}//end list()



public Pager list(final String username,final int pageSize,final int pageNo)  {	
	Pager pager = null;	
	//??????HibernateCallback????4??��??
	List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
		//???HibernateCallback?????????????
		public Object doInHibernate(Session session) throws HibernateException, SQLException {
			//???Hibernate??????
			//List result = session.createQuery(hql).setParameter(0, value).setFirstResult(offset).setMaxResults(pageSize).list();
			Criteria criteria = session.createCriteria(BrokerRelationship.class);
			
			User user=getUserService().select(username);
			String role = user.getRole();//用户角色，根据角色来判断到底是经纪人在查询还是模特或摄影师在查询
			String[] roles = role.split("_");
			boolean isBroker = false;
			for(int i=0;i<roles.length;i++){
				if("broker".equals(roles[i])){
					isBroker = true;
					break;
				}
			}
			if(isBroker == true){//经纪人
				criteria.add(Restrictions.eq("broker", user));
			}else if(isBroker == false){
				criteria.add(Restrictions.eq("author", user));
			}
			BrokerRelationshipDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
			criteria.setProjection(null);
			criteria.setFirstResult(pageSize * (pageNo - 1));
			criteria.setMaxResults(pageSize);
			List<BrokerRelationship> result = criteria.list();
			return result;
		}
	});
	pager = new Pager(pageSize, pageNo, BrokerRelationshipDaoImpl.rowCount, list);
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
				Query q = session.createQuery("select count(*) from  BrokerRelationship  a where " + strWhereParam );
				Iterator itKey2 = setKeyOfMap.iterator();
				while(itKey2.hasNext()){
					String strKeyI2 = (String)itKey2.next();
					q.setParameter(intSerial,mapSqlParam.get(strKeyI2)); 
					intSerial++;
				}
				Object count = q.uniqueResult();
				BrokerRelationshipDaoImpl.rowCount = Integer.parseInt(count.toString());
				//
				intSerial = 0;
				q = session.createQuery("select a from BrokerRelationship a where " + strWhereParam );
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
		pager = new Pager(pageSize, pageNo, BrokerRelationshipDaoImpl.rowCount, list);
		return pager;
		
	}//end list()
		
	/////insert///
	public Integer insert(BrokerRelationship record) {
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
	public boolean delete(BrokerRelationship record)  {
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
		BrokerRelationship record = select(id);
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
		Object obj = getHibernateTemplate().load(BrokerRelationship.class,new Integer(id));
		getHibernateTemplate().delete(obj);
		return true;
	}//end delete()
			
	/////update///
	public boolean update(BrokerRelationship record)  {
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
	public BrokerRelationship select(Integer id)  {
		/*
		Session session = null;
		BrokerRelationship record = null;
		try {
			session = HibernateSessionFactory.currentSession();
			Query query = session.createQuery("from BrokerRelationship where id=?");
			query.setInteger(0, id);
			record = (BrokerRelationship) query.uniqueResult();
			query = null;
			
		} catch (HibernateException e) {
			throw e;
		} finally {
			HibernateSessionFactory.closeSession();
		}
		
		return record;
		*/
		
		return (BrokerRelationship) getHibernateTemplate().get(BrokerRelationship.class, new Integer(id));
		
		
	}//end select()
	
	/////main///
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	
	
	public Pager List(Integer id,Integer flag, int pageSize, int pageNo) {
		String hql = "from BrokerRelationship t where t.broker.id=? and t.ifAccept=? order by t.creationTime desc";
		Session session=getSession();
		Query query = session.createQuery(hql);
		BrokerRelationshipDaoImpl.rowCount = query.list().size();
		query.setParameter(0, id).setParameter(1, flag).setFirstResult(pageSize * (pageNo - 1)).setMaxResults(pageSize);
		List result = query.list();
		if(result!=null && result.size()>0){
			BrokerRelationshipDaoImpl.rowCount = result.size();
			Iterator iter = result.iterator();
			while(iter.hasNext()){
				BrokerRelationship bs = (BrokerRelationship) iter.next();
				if(bs!=null && bs.getAuthor()!=null && bs.getAuthor().getUserCat()!=null)
					Hibernate.initialize(bs.getAuthor().getUserCat().getName());
			}
		}

		releaseSession(getSession());    

		return new Pager(pageSize, pageNo, BrokerRelationshipDaoImpl.rowCount, result);
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

//	public List<BrokerRelationship> getRelationShips(final User user) {
//		List<BrokerRelationship> list = (List<BrokerRelationship>) getHibernateTemplate().execute(new HibernateCallback() {
//			public Object doInHibernate(Session session)
//					throws HibernateException, SQLException {
//				String sql = "select * from brokerrelationship where author = "+user.getId();
//				Query query = session.createSQLQuery(sql);
//				return (List<BrokerRelationship>)query.list();
//			}
//			
//		});
//		return list;
//	}
	
	@SuppressWarnings("unchecked")
	public List<BrokerRelationship> getRelationShips(final User user)  {	
		Pager pager = null;	
		List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(BrokerRelationship.class);
				criteria.add(Restrictions.eq("author", user));
				criteria.add(Restrictions.eq("isValid", 1));
				criteria.add(Restrictions.eq("ifAccept", 2));
				List<?> result = criteria.list();
				return result;
			}
		});
		return list;
		
		}

	public void modifyValid(List<BrokerRelationship> strList) {
		if(strList != null && strList.size() > 0){
			for(int i=0;i<strList.size();i++){
				BrokerRelationship b = (BrokerRelationship)strList.get(i);
			    b.setIsValid(0);
			    this.getHibernateTemplate().saveOrUpdate(b);
			}
		}
	}

	public void modifyBrokerStatus(BrokerRelationship broker) {
		if(broker != null){
			broker.setIfAccept(0);
			this.getHibernateTemplate().saveOrUpdate(broker);
		}
	}
	
	@SuppressWarnings("unchecked")
	public Pager list(final DetachedCriteria detachedCriteria,final int pageSize,final int pageNo)  {
		List list =  getHibernateTemplate().executeFind(new HibernateCallback(){
			public List doInHibernate(Session session){
				Criteria criteria = detachedCriteria.getExecutableCriteria(session);
				BrokerRelationshipDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
				criteria.setProjection(null);
				criteria.setFirstResult(pageSize * (pageNo - 1));
				criteria.setMaxResults(pageSize);
				List<?> result = criteria.list();
				
				
				
				
				return result;
			}
		});
	  
	 //List<BrokerRelationship> list=getHibernateTemplate().findByCriteria(detachedCriteria, pageNo, pageSize);
		Pager pager = new Pager(pageSize, pageNo,BrokerRelationshipDaoImpl.rowCount, list);
		return pager;
		
		}//end list()
	@SuppressWarnings("unchecked")
	public int getCountByCriteria(final DetachedCriteria detachedCriteria) {
		Object count = (Object) getHibernateTemplate().executeFind(new HibernateCallback(){
					public Object doInHibernate(Session session){
						try{
						Criteria criteria = detachedCriteria
								.getExecutableCriteria(session);
						return criteria.setProjection(Projections.rowCount())
								.uniqueResult();
						}catch (Exception e) {
							e.printStackTrace();
							return 0;
						}
					}
				});
		if(count==null){
			count=0;
			
		}
		return Integer.parseInt(count.toString());
	}
	
}//end class
