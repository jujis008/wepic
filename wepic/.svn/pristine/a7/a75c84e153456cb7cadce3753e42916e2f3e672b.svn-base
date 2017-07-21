package com.wetuo.wepic.deal.dao ;
 
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
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.wetuo.wepic.deal.beans.BuyCommodities;
import com.wetuo.wepic.publish.beans.Publish;
import com.wetuo.wepic.common.hibernate.HibernateSessionFactory;
import com.wetuo.wepic.common.hibernate.XgHibernateCommonDao;
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.util.UUIDGenerator;
import org.springframework.orm.hibernate3.HibernateCallback;
import java.sql.SQLException;
 
public class BuyCommoditiesDaoImpl extends XgHibernateCommonDao implements BuyCommoditiesDao {
	private static Log log = LogFactory.getLog(BuyCommoditiesDaoImpl.class);
	private static int rowCount = 0;
	//////////////common crud//////////////////////////////////////////////
	public List<BuyCommodities> findAll(){ 
		return (List<BuyCommodities>)getHibernateTemplate().find("from BuyCommodities");
	}
	
	public List<BuyCommodities> findPart(String strFields, String[] arrStrValues){ 
		return (List<BuyCommodities>)getHibernateTemplate().find("from BuyCommodities where "+strFields, arrStrValues);
	}
	
public Pager list(final int pageSize,final int pageNo)  {	
	Pager pager = null;	
	//??????HibernateCallback????4??��??
	List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
		//???HibernateCallback?????????????
		public Object doInHibernate(Session session) throws HibernateException, SQLException {
			//???Hibernate??????
			//List result = session.createQuery(hql).setParameter(0, value).setFirstResult(offset).setMaxResults(pageSize).list();
			Criteria criteria = session.createCriteria(BuyCommodities.class);
			BuyCommoditiesDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
			criteria.setProjection(null);
			criteria.setFirstResult(pageSize * (pageNo - 1));
			criteria.setMaxResults(pageSize);
			List<?> result = criteria.list();
			return result;
		}
	});
	pager = new Pager(pageSize, pageNo, BuyCommoditiesDaoImpl.rowCount, list);
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
			Criteria criteria = session.createCriteria(BuyCommodities.class);
			BuyCommoditiesDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
			criteria.setProjection(null);
			criteria.setFirstResult(pageSize * (pageNo - 1));
			criteria.setMaxResults(pageSize);
			List<?> result = criteria.list();
			return result;
		}
	});
	pager = new Pager(pageSize, pageNo, BuyCommoditiesDaoImpl.rowCount, list);
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
				Query q = session.createQuery("select count(*) from  BuyCommodities  a where " + strWhereParam );
				Iterator itKey2 = setKeyOfMap.iterator();
				while(itKey2.hasNext()){
					String strKeyI2 = (String)itKey2.next();
					q.setParameter(intSerial,mapSqlParam.get(strKeyI2)); 
					intSerial++;
				}
				Object count = q.uniqueResult();
				BuyCommoditiesDaoImpl.rowCount = Integer.parseInt(count.toString());
				//
				intSerial = 0;
				q = session.createQuery("select a from BuyCommodities a where " + strWhereParam );
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
		pager = new Pager(pageSize, pageNo, BuyCommoditiesDaoImpl.rowCount, list);
		return pager;
		
	}//end list()
	/////insert///
	public String insert(BuyCommodities record) {
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
		String integerRet = null; 
		return (String)getHibernateTemplate().save(record);
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
	public boolean delete(BuyCommodities record)  {
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
			
	public boolean delete(String id)  {
		/*
		BuyCommodities record = select(id);
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
		Object obj = getHibernateTemplate().load(BuyCommodities.class,new String(id));
		getHibernateTemplate().delete(obj);
		return true;
	}//end delete()
			
	/////update///
	public boolean update(BuyCommodities record)  {
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
	public BuyCommodities select(String id)  {
		/*
		Session session = null;
		BuyCommodities record = null;
		try {
			session = HibernateSessionFactory.currentSession();
			Query query = session.createQuery("from BuyCommodities where id=?");
			query.setInteger(0, id);
			record = (BuyCommodities) query.uniqueResult();
			query = null;
			
		} catch (HibernateException e) {
			throw e;
		} finally {
			HibernateSessionFactory.closeSession();
		}
		
		return record;
		*/
		
		return (BuyCommodities) getHibernateTemplate().get(BuyCommodities.class, new String(id));
		
		
	}//end select()
	
	/////main///
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
    /**
     * List<Publish> listPublishCount  = null;
//	   	  <option value="1">首页大图</option>
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();//publishTime

			StringBuffer totalHql = new StringBuffer() ;
			totalHql.append("select distinct new Publish(p.id,p.name,p.indexImgUrl) from Publish as p where commend = 1  order by publishTime desc  LIMIT 0,5");
			
			Query queryObjectCount = session.createQuery( totalHql.toString());
			 listPublishCount   = (List<Publish>)queryObjectCount.list();		   
			
			tx.commit();
		}catch(RuntimeException e){
			if(tx != null){
				tx.rollback();
			}
			e.printStackTrace();
		}finally{
			if(session.isOpen()){ 
				   session.close(); 
			} 
		}
		return listPublishCount ;	
     */
	public List<BuyCommodities> findByCartDeal(String cartdealId) {
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		Transaction tx = null;
		List<BuyCommodities> listCommodities=null;
		try {
			tx = session.beginTransaction();//publishTime
			Query query = session.createQuery("from BuyCommodities where buyCartDealid=?");
			query.setString(0, cartdealId);
			
			listCommodities = query.list();
			tx.commit();
		}catch(RuntimeException e){
			if(tx != null){
				tx.rollback();
			}
			e.printStackTrace();
		}finally{
			if(session.isOpen()){ 
				   session.close(); 
			} 
		}
		
		return listCommodities;
	}
	
	
	
	
	public Pager PagerfindByCartDeal(String cartdealId,int nowPage,int pageSize) {
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		Transaction tx = null;
		List<?> listCommodities=null;
		try {
			tx = session.beginTransaction();//publishTime
			Query query = session.createQuery("from BuyCommodities where buyCartDealid=?");
			rowCount= query.list().size();
			query.setString(0, cartdealId);
			query.setMaxResults(pageSize);
			query.setFirstResult((nowPage - 1) * pageSize);
			listCommodities = query.list();
			tx.commit();
		}catch(RuntimeException e){
			if(tx != null){
				tx.rollback();
			}
			e.printStackTrace();
		}finally{
			if(session.isOpen()){ 
				   session.close(); 
			} 
		}
		
		Pager pager=new Pager(pageSize, nowPage, rowCount, listCommodities);
		return pager;
	}

	public List selectByCatBulish(final String cat) {
		List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
			//???HibernateCallback?????????????
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				
				String sql="select distinct buycomm from BuyCommodities as buycomm where buycomm.publish.picNumber like '%"+cat+"%' order by startTime desc";
				Query criteria = session.createQuery(sql);//(BuyCommodities.class);
			//	BuyCommoditiesDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
				//criteria.setProjection(null);
				criteria.setFirstResult(0);
				criteria.setMaxResults(4);
				List<?> result = criteria.list();
				return result;
			}
		});
		
		//String sql="select distinct buycomm,buycomm.publish from BuyCommodities as buycomm where buycomm.publish.picNumber like '%pg%'";
		//List<BuyCommodities> list=getHibernateTemplate().find(sql);
		
		
		
		
		
		
		return list;
	}
	public List<BuyCommodities> publishOfCommody(Publish publish) {
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		   
	    List<BuyCommodities> commodities=null;
	    Transaction tx = null;
	    try {
	    	tx = session.beginTransaction();
	    	Query queryObject = session.createQuery("from BuyCommodities commdy where commdy.publish.id="+publish.getId());
	    	commodities=queryObject.list();
	    	tx.commit();
		}catch(RuntimeException e){
			if(tx != null){
				tx.rollback();
			}
			e.printStackTrace();
		}finally{
			if(session.isOpen()){ 
				releaseSession(session);
			} 
		}
		return commodities;
	}

	public int getbuyCount(String data) {
		
		List list=getHibernateTemplate().find("select COUNT( buyc.publish ) FROM BuyCommodities buyc where  buyc.startTime >='"+data+"'");
		if(list!=null){
			
			
			return Integer.parseInt(list.get(0)+"");
		}
		
		
		return 0;
	}
	
}//end class
