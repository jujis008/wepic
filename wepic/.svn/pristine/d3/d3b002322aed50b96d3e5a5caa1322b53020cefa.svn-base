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
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.wetuo.wepic.core.beans.LeaveWord;
import com.wetuo.wepic.core.service.UserService;
import com.wetuo.wepic.common.hibernate.HibernateSessionFactory;
import com.wetuo.wepic.common.hibernate.XgHibernateCommonDao;
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.util.UUIDGenerator;
import org.springframework.orm.hibernate3.HibernateCallback;
import java.sql.SQLException;
 
public class LeaveWordDaoImpl extends XgHibernateCommonDao implements LeaveWordDao {
	private static Log log = LogFactory.getLog(LeaveWordDaoImpl.class);
	private static int rowCount = 0;
	private UserDao dao;
	
	public void setDao(UserDao dao) {
		this.dao = dao;
	}

	//////////////common crud//////////////////////////////////////////////
	public List<LeaveWord> findAll(){ 
		return (List<LeaveWord>)getHibernateTemplate().find("from LeaveWord");
	}
	
	public List<LeaveWord> findPart(String strFields, String[] arrStrValues){ 
		return (List<LeaveWord>)getHibernateTemplate().find("from LeaveWord where "+strFields, arrStrValues);
	}
	
public Pager list(final int pageSize,final int pageNo)  {	
	Pager pager = null;	
	//??????HibernateCallback????4??��??
	List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
		//???HibernateCallback?????????????
		public Object doInHibernate(Session session) throws HibernateException, SQLException {
			//???Hibernate??????
			//List result = session.createQuery(hql).setParameter(0, value).setFirstResult(offset).setMaxResults(pageSize).list();
			Criteria criteria = session.createCriteria(LeaveWord.class);
			LeaveWordDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
			criteria.setProjection(null);
			criteria.setFirstResult(pageSize * (pageNo - 1));
			criteria.setMaxResults(pageSize);
			List<?> result = criteria.list();
			return result;
		}
	});
	pager = new Pager(pageSize, pageNo, LeaveWordDaoImpl.rowCount, list);
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
			Criteria criteria = session.createCriteria(LeaveWord.class);
			LeaveWordDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
			criteria.setProjection(null);
			criteria.add(Restrictions.eq("member", dao.select(username)));
			criteria.setFirstResult(pageSize * (pageNo - 1));
			criteria.setMaxResults(pageSize);
			List<?> result = criteria.list();
			return result;
		}
	});
	pager = new Pager(pageSize, pageNo, LeaveWordDaoImpl.rowCount, list);
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
				Query q = session.createQuery("select count(*) from  LeaveWord  a where " + strWhereParam );
				Iterator itKey2 = setKeyOfMap.iterator();
				while(itKey2.hasNext()){
					String strKeyI2 = (String)itKey2.next();
					q.setParameter(intSerial,mapSqlParam.get(strKeyI2)); 
					intSerial++;
				}
				Integer count=1;
				try{
				 System.out.println(q.uniqueResult());
				}catch (Exception e) {
				e.printStackTrace();
				}
				LeaveWordDaoImpl.rowCount = Integer.parseInt(count.toString());
				//
				intSerial = 0;
				q = session.createQuery("select a from LeaveWord a where " + strWhereParam );
				Iterator itKey3 = setKeyOfMap.iterator();
				while(itKey3.hasNext()){
					String strKeyI3 = (String)itKey3.next();
					q.setParameter(intSerial,mapSqlParam.get(strKeyI3)); 
					intSerial++;
				}
				q.setMaxResults(pageSize);
				q.setFirstResult((pageNo - 1) * pageSize);
			 try{
				List<?> resultList = q.list();
				return resultList;
			 }catch (Exception e) {
				e.printStackTrace();
				return null;
			}
				}
		});
		pager = new Pager(pageSize, pageNo, LeaveWordDaoImpl.rowCount, list);
		return pager;
		
	}//end list()
		
	/////insert///
	public Integer insert(LeaveWord record) {
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
	
	
	
	public Pager list(final String username,final String adtype ,final int pageSize,final int pageNo){
		
		Pager pager = null;	
		//??????HibernateCallback????4??��??
		List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				//???Hibernate??????
				//List result = session.createQuery(hql).setParameter(0, value).setFirstResult(offset).setMaxResults(pageSize).list();
				Criteria criteria = session.createCriteria(LeaveWord.class);
				LeaveWordDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
				criteria.setProjection(null);
				criteria.add(Restrictions.eq("member", dao.select(username)));
				criteria.add(Restrictions.eq("adtype", adtype));
				criteria.setFirstResult(pageSize * (pageNo - 1));
				criteria.setMaxResults(pageSize);
				List<?> result = criteria.list();
				return result;
			}
		});
		pager = new Pager(pageSize, pageNo, LeaveWordDaoImpl.rowCount, list);
		return pager;
		
		
		
	}
	
	@SuppressWarnings("unchecked")
	public Pager listbyDetachedCrities(DetachedCriteria detachedCriteria,int nowPage,int pageSize){
		List<LeaveWord>  list=null;
		
		try{
			//LeaveWordDaoImpl.rowCount=getCount(detachedCriteria);
		list=getHibernateTemplate().findByCriteria(detachedCriteria,nowPage-1,pageSize);
		LeaveWordDaoImpl.rowCount=getCount(detachedCriteria);
		}catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println("===========================");
		
		
		return  new Pager(pageSize, nowPage, LeaveWordDaoImpl.rowCount, list);	
		
	}
	
	
	
	public int getCount(DetachedCriteria detachedCriteria){
		
		return ((Integer) this.getHibernateTemplate().
				findByCriteria(detachedCriteria.setProjection(Projections.rowCount())).get(0)).intValue(); 
		
		
	}
	public boolean delete(LeaveWord record)  {
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
		LeaveWord record = select(id);
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
		Object obj = getHibernateTemplate().load(LeaveWord.class,new Integer(id));
		getHibernateTemplate().delete(obj);
		return true;
	}//end delete()
			

	public boolean update(LeaveWord record)  {
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
	public LeaveWord select(Integer id)  {
		/*
		Session session = null;
		LeaveWord record = null;
		try {
			session = HibernateSessionFactory.currentSession();
			Query query = session.createQuery("from LeaveWord where id=?");
			query.setInteger(0, id);
			record = (LeaveWord) query.uniqueResult();
			query = null;
			
		} catch (HibernateException e) {
			throw e;
		} finally {
			HibernateSessionFactory.closeSession();
		}
		
		return record;
		*/
		
		return (LeaveWord) getHibernateTemplate().get(LeaveWord.class, new Integer(id));
		
		
	}//end select()
	
	/////main///
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	public Pager Ylist(final String Str, final int pageSize, final int pageNo) {
		Pager pager = null;	
		 final int rowCount=0;
		List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
			//
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				String sql="select p.id,p.content,p.whoseContent,p.time,p.title,p.messageReply from LeaveWord p where p.messageReply "+Str;
				return session.createSQLQuery(sql)
				.setMaxResults(pageSize)
				.setFirstResult((pageNo - 1) * pageSize).
				setResultTransformer(Transformers.aliasToBean(LeaveWord.class))
				.list();
			}
		});
//		LeaveWord word=(LeaveWord)list.get(0);
//		System.out.println(word.getContent());
//		System.out.println(word.getTitle());
		pager = new Pager(pageSize, pageNo, LeaveWordDaoImpl.rowCount, list);
		return pager;
		
	}
	
}//end class
