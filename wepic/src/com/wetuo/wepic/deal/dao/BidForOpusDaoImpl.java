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
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.Alias;
import org.hibernate.transform.Transformers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.wetuo.wepic.deal.beans.Bid;
import com.wetuo.wepic.deal.beans.BidForOpus;
import com.wetuo.wepic.deal.service.BidService;
import com.wetuo.wepic.common.hibernate.HibernateSessionFactory;
import com.wetuo.wepic.common.hibernate.XgHibernateCommonDao;
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.util.UUIDGenerator;
import com.wetuo.wepic.core.beans.User;

import org.springframework.orm.hibernate3.HibernateCallback;
import java.sql.SQLException;
 
public class BidForOpusDaoImpl extends XgHibernateCommonDao implements BidForOpusDao {
	private static Log log = LogFactory.getLog(BidForOpusDaoImpl.class);
	private static int rowCount = 0;
	private BidDao bidDao;
	
	

	public BidDao getBidDao() {
		return bidDao;
	}

	public void setBidDao(BidDao bidDao) {
		this.bidDao = bidDao;
	}

	//////////////common crud//////////////////////////////////////////////
	public List<BidForOpus> findAll(){ 
		return (List<BidForOpus>)getHibernateTemplate().find("from BidForOpus");
	}
	
	public List<BidForOpus> findPart(String strFields, String[] arrStrValues){ 
		return (List<BidForOpus>)getHibernateTemplate().find("from BidForOpus where "+strFields, arrStrValues);
	}
	
public Pager list(final int pageSize,final int pageNo)  {	
	Pager pager = null;	
	//??????HibernateCallback????4??��??
	List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
		//???HibernateCallback?????????????
		public Object doInHibernate(Session session) throws HibernateException, SQLException {
			//???Hibernate??????
			//List result = session.createQuery(hql).setParameter(0, value).setFirstResult(offset).setMaxResults(pageSize).list();
			Criteria criteria = session.createCriteria(BidForOpus.class);
			BidForOpusDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
			criteria.setProjection(null);
			criteria.setFirstResult(pageSize * (pageNo - 1));
			criteria.setMaxResults(pageSize);
			List<?> result = criteria.list();
			return result;
		}
	});
	pager = new Pager(pageSize, pageNo, BidForOpusDaoImpl.rowCount, list);
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
			Criteria criteria = session.createCriteria(BidForOpus.class);
			BidForOpusDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
			criteria.setProjection(null);
			criteria.setFirstResult(pageSize * (pageNo - 1));
			criteria.setMaxResults(pageSize);
			List<?> result = criteria.list();
			return result;
		}
	});
	pager = new Pager(pageSize, pageNo, BidForOpusDaoImpl.rowCount, list);
	return pager;
	
	}//end list()




//获得所有的图片
public Pager list(final Bid bid,final int pageSize,final int pageNo)  {	
	Pager pager = null;	
	//??????HibernateCallback????4??��??
	List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
		//???HibernateCallback?????????????
		public Object doInHibernate(Session session) throws HibernateException, SQLException {
			//???Hibernate??????
			//List result = session.createQuery(hql).setParameter(0, value).setFirstResult(offset).setMaxResults(pageSize).list();
			Criteria criteria = session.createCriteria(BidForOpus.class);
			BidForOpusDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
			criteria.setProjection(null);
			
			criteria.addOrder(Order.asc("status"));
			criteria.addOrder(Order.desc("sendTime"));
			criteria.add(Restrictions.not(Expression.eq("status",2)));
			criteria.add(Restrictions.eq("bid", bid));
			criteria.setFirstResult(pageSize * (pageNo - 1));
			criteria.setMaxResults(pageSize);
			List<?> result = criteria.list();
			return result;
		}
	});
	pager = new Pager(pageSize, pageNo, BidForOpusDaoImpl.rowCount, list);
	return pager;
	
	}//end list()


//获得所有确定的图片
public Pager confirmlist(final Bid bid,final int pageSize,final int pageNo)  {	
	Pager pager = null;	
	//??????HibernateCallback????4??��??
	List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
		//???HibernateCallback?????????????
		public Object doInHibernate(Session session) throws HibernateException, SQLException {
			//???Hibernate??????
			//List result = session.createQuery(hql).setParameter(0, value).setFirstResult(offset).setMaxResults(pageSize).list();
			Criteria criteria = session.createCriteria(BidForOpus.class);
			BidForOpusDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
			criteria.setProjection(null);
			criteria.add(Restrictions.eq("status", 1));
			criteria.add(Restrictions.eq("bid", bid));
			criteria.setFirstResult(pageSize * (pageNo - 1));
			criteria.setMaxResults(pageSize);
			List<?> result = criteria.list();
			return result;
		}
	});
	pager = new Pager(pageSize, pageNo, BidForOpusDaoImpl.rowCount, list);
	return pager;
	
	}//end list()


//图片征集硬要记录
public Pager yingyaojilu(final User user,final int pageSize,final int pageNo)  {	
	Pager pager = null;	
	//??????HibernateCallback????4??��??
	List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
		//???HibernateCallback?????????????
		public Object doInHibernate(Session session) throws HibernateException, SQLException {
			//???Hibernate??????
			//List result = session.createQuery(hql).setParameter(0, value).setFirstResult(offset).setMaxResults(pageSize).list();
			Query criteria = session.createSQLQuery("select * from BidForOpus where user_='"+user.getId()+"' GROUP BY bidid");
			BidForOpusDaoImpl.rowCount = criteria.list().size();
			// criteria.setProjection(Projections.groupProperty("bidid"));
//			criteria.setProjection(null);
//			criteria.add(Restrictions.eq("user", user));
			criteria.setResultTransformer(Transformers.aliasToBean(BidForOpus.class));
			criteria.setFirstResult(pageSize * (pageNo - 1));
			criteria.setMaxResults(pageSize);
			List<?> result = criteria.list();
			return result;
		}
	});
	pager = new Pager(pageSize, pageNo, BidForOpusDaoImpl.rowCount, list);
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
				Query q = session.createQuery("select count(*) from  BidForOpus  a where " + strWhereParam );
				Iterator itKey2 = setKeyOfMap.iterator();
				while(itKey2.hasNext()){
					String strKeyI2 = (String)itKey2.next();
					q.setParameter(intSerial,mapSqlParam.get(strKeyI2)); 
					intSerial++;
				}
				Object count = q.uniqueResult();
				BidForOpusDaoImpl.rowCount = Integer.parseInt(count.toString());
				//
				intSerial = 0;
				q = session.createQuery("select a from BidForOpus a where " + strWhereParam );
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
		pager = new Pager(pageSize, pageNo, BidForOpusDaoImpl.rowCount, list);
		return pager;
		
	}//end list()
		
	/////insert///
	public String insert(BidForOpus record) {
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
		@SuppressWarnings("unused")
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
	public boolean delete(BidForOpus record)  {
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
		BidForOpus record = select(id);
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
		Object obj = getHibernateTemplate().load(BidForOpus.class,new String(id));
		getHibernateTemplate().delete(obj);
		return true;
	}//end delete()
			
	/////update///
	public boolean update(BidForOpus record)  {
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
	public BidForOpus select(String id)  {
		/*
		Session session = null;
		BidForOpus record = null;
		try {
			session = HibernateSessionFactory.currentSession();
			Query query = session.createQuery("from BidForOpus where id=?");
			query.setInteger(0, id);
			record = (BidForOpus) query.uniqueResult();
			query = null;
			
		} catch (HibernateException e) {
			throw e;
		} finally {
			HibernateSessionFactory.closeSession();
		}
		
		return record;
		*/
		
		return (BidForOpus) getHibernateTemplate().get(BidForOpus.class, new String(id));
		
		
	}//end select()
	
	
	@SuppressWarnings("unchecked")
	public BidForOpus selectById(final String id)  {
		
//		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
//
//			public Object doInHibernate(Session session)
//					throws HibernateException, SQLException {
//				
//			     	Query q = session.createSQLQuery("select bidforopus0_.id, bidforopus0_.user_ ," +
//			     			                         "bidforopus0_.sendTime,bidforopus0_.watermark ," +
//			     			                         "bidforopus0_.title,bidforopus0_.thumbNail_Image," +
//			     			                         "bidforopus0_.original_Drawing ,bidforopus0_.conetxt " +
//			     			                         ",bidforopus0_.confirmTime,bidforopus0_.status,bidforopus0_.bidid" +
//			     			                         " from  BidForOpus bidforopus0_  where bidforopus0_.id='"+id+"'")
//			     	.addEntity(BidForOpus.class); 
//				          
//			     	
//			     	
//			     	return q.list();
//			}
//		});
//		
		
		
		
		 return (BidForOpus) getHibernateTemplate().get(BidForOpus.class, new String(id));
		
		
	}//end select()
	
	
	
	
	@SuppressWarnings("unchecked")
	public List<BidForOpus> getConfirm(final String bidid)  {
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
		
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Criteria criteria = session.createCriteria(BidForOpus.class);
						BidForOpusDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
						criteria.setProjection(null);
						criteria.add(Restrictions.eq("status", 2));
						criteria.add(Restrictions.eq("bid", bidDao.select(bidid)));
						List<?> result = criteria.list();
						return result;
						
//					     	Query q = session.createSQLQuery("select bidforopus0_.id, bidforopus0_.user_ ," +
//					     			                         "bidforopus0_.sendTime,bidforopus0_.watermark ," +
//					     			                         "bidforopus0_.title,bidforopus0_.thumbNail_Image," +
//					     			                         "bidforopus0_.original_Drawing ,bidforopus0_.conetxt " +
//					     			                         ",bidforopus0_.confirmTime,bidforopus0_.status,bidforopus0_.bidid" +
//					     			                         " from  BidForOpus  bidforopus0_  where bidforopus0_.status=1 and  bidforopus0_.bidid='"+bidid+"'")
//					     	.addEntity(BidForOpus.class); 
//						          
//					     	
//					     	
//					     	return q.list();
					}
				});
				
		//Pager pager = new Pager(pageSize, pageNo, BidForOpusDaoImpl.rowCount, list);
		//return pager;
		
		 return list;
		
		
	}
	@SuppressWarnings("unchecked")
	public Pager getConfirmImgPager(final String bidid,final int pageNo,final int pageSize)  {
		Pager pager = null;	
		//??????HibernateCallback????4??��??
		List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
			//???HibernateCallback?????????????
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(BidForOpus.class);
				//criteria.setProjection(null);
			
				System.out.println("====================================");
				
				criteria.add(Restrictions.eq("status", 2));
				criteria.add(Restrictions.eq("bid", bidDao.select(bidid)));
			//	System.out.println(criteria.list().size());
				BidForOpusDaoImpl.rowCount = criteria.list().size();
				criteria.setFirstResult(pageSize * (pageNo - 1));
				//((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
				criteria.setMaxResults(pageSize);
				List<?> result = criteria.list();
				return result;
			}
		});
		pager = new Pager(pageSize, pageNo, BidForOpusDaoImpl.rowCount, list);
		return pager;
		
	}
	@SuppressWarnings("unchecked")
	public Pager getallBidForOpus(final Bid bid,final int pageNo,final int pageSize)  {
		Pager pager=null;
		List resultList = getHibernateTemplate().executeFind(new HibernateCallback() {
		
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {	
					     	Query q = session.createQuery("SELECT opus  FROM BidForOpus opus inner join opus.user WHERE  opus.bid=?");
					     	q.setEntity(0, bid);
					     	//.addEntity(BidForOpus.class); 
					     	rowCount=q.list().size();
					     	q.setMaxResults(pageSize);
							q.setFirstResult((pageNo - 1) * pageSize);
					     	return q.list();
					}
				});

		
		pager=new Pager(pageSize, pageNo, rowCount, resultList);
		 return pager;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
}//end class
