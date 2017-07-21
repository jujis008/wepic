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

import com.wetuo.wepic.core.beans.ResLeftSideItem;
import com.wetuo.wepic.core.beans.ResMenu;
import com.wetuo.wepic.core.beans.UserCat;
import com.wetuo.wepic.common.hibernate.HibernateSessionFactory;
import com.wetuo.wepic.common.hibernate.XgHibernateCommonDao;
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.util.UUIDGenerator;
import org.springframework.orm.hibernate3.HibernateCallback;
import java.sql.SQLException;
 
public class ResMenuDaoImpl extends XgHibernateCommonDao implements ResMenuDao {
	private static Log log = LogFactory.getLog(ResMenuDaoImpl.class);
	private static int rowCount = 0;
	//////////////common crud///////////////////////////
	@SuppressWarnings("unchecked")
	public List<ResMenu> find(final int userCatId)  {
		List<ResMenu> result = null;	
		result = getHibernateTemplate().find("From ResMenu as ResMenu where  ResMenu.type=1 and ResMenu.userCat.id = "+ userCatId + "  order by id desc");
//		List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
//			public Object doInHibernate(Session session) throws HibernateException, SQLException {
//				String hql = "from UserCat as userCat where userCat.type = ?"; 
//				
//				Query q = session.createQuery(hql);
//				q.setString(0,type);
//				List<UserCat>  result = (List<UserCat>)(q.list());
//				return result;
//			}
//		});
		
		return result;
	}//end list()
	
	@SuppressWarnings("unchecked")
	public List<ResMenu> findReadOnly(final int userCatId)  {
		return getHibernateTemplate().find("From ResMenu as ResMenu where  ResMenu.type=2 and ResMenu.userCat.id = "+ userCatId + "  order by id asc");
	}//end list()
	
	///////////////////
	public List<ResMenu> findAll(){ 
		return (List<ResMenu>)getHibernateTemplate().find("from ResMenu");
	}
	
	public List<ResMenu> findPart(String strFields, String[] arrStrValues){ 
		return (List<ResMenu>)getHibernateTemplate().find("from ResMenu where "+strFields, arrStrValues);
	}
	
	public Pager list(final int pageSize,final int pageNo)  {	
		Pager pager = null;	
		//??????HibernateCallback????4??��??
		List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
			//???HibernateCallback?????????????
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				//???Hibernate??????
				//List result = session.createQuery(hql).setParameter(0, value).setFirstResult(offset).setMaxResults(pageSize).list();
				Criteria criteria = session.createCriteria(ResMenu.class);
				ResMenuDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
				criteria.setProjection(null);
				criteria.setFirstResult(pageSize * (pageNo - 1));
				criteria.setMaxResults(pageSize);
				List<?> result = criteria.list();
				return result;
			}
		});
		pager = new Pager(pageSize, pageNo, ResMenuDaoImpl.rowCount, list);
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
			Criteria criteria = session.createCriteria(ResMenu.class);
			ResMenuDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
			criteria.setProjection(null);
			criteria.setFirstResult(pageSize * (pageNo - 1));
			criteria.setMaxResults(pageSize);
			List<?> result = criteria.list();
			return result;
		}
	});
	pager = new Pager(pageSize, pageNo, ResMenuDaoImpl.rowCount, list);
	return pager;
	
	}//end list()
	
	public Pager list(final UserCat userCat ,final int pageSize,final int pageNo)  {	
		Pager pager = null;	
		//??????HibernateCallback????4??��??
		List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
			//???HibernateCallback?????????????
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				//???Hibernate??????
				//List result = session.createQuery(hql).setParameter(0, value).setFirstResult(offset).setMaxResults(pageSize).list();
//				session.createSQLQuery("select * from user");
				
//				criteria.add( Restrictions.like("name", "Fritz%") )
//			    criteria.add( Restrictions.between("weight", minWeight, maxWeight) )
//				crit.add(Expression.ge("age", new Integer(25)));
//				crit.add(Expression.between("weight", new Integer(60)，new Integer(80)));
//				crit.add(Expression.or(
//						Expression.eq("age", new Integer(20)),
//						Expression.isNull("age")
//						));
//				criteria.add( Restrictions.or(
//				        Restrictions.eq( "age", new Integer(0) ),
//				        Restrictions.isNull("age")
//				    ) )
//				criteria.add( Restrictions.in( "name", new String[] { "Fritz", "Izi", "Pk" } ) );
//				criteria.add( Restrictions.disjunction()
//				        .add( Restrictions.isNull("age") )
//				        .add( Restrictions.eq("age", new Integer(0) ) )
//				        .add( Restrictions.eq("age", new Integer(1) ) )
//				        .add( Restrictions.eq("age", new Integer(2) ) )
//				    ) );
//				Property age = Property.forName("age");
//				List cats = sess.createCriteria(Cat.class)
//				    .add( Restrictions.disjunction()
//				        .add( age.isNull() )
//				        .add( age.eq( new Integer(0) ) )
//				        .add( age.eq( new Integer(1) ) )
//				        .add( age.eq( new Integer(2) ) )
//				    ) )
//				    .add( Property.forName("name").in( new String[] { "Fritz", "Izi", "Pk" } ) )
//				    .list();
//				Hibernate提供了相当多的内置criterion类型(Restrictions 子类), 但是尤其有用的是可以允许
//
//				你直接使用SQL。
//				 
//				List cats = sess.createCriteria(Cat.class)
//				    .add( Restrictions.sql("lower({alias}.name) like lower(?)", "Fritz%",
//
//				Hibernate.STRING) )
//				    .list();
//				 
//				{alias}占位符应当被替换为被查询实体的列别名。 
//				.addOrder( Order.asc("name") )
//			    .addOrder( Order.desc("age") )
//				List cats = sess.createCriteria(Cat.class)
//			    .add( Property.forName("name").like("F%") )
//			    .addOrder( Property.forName("name").asc() )
//			    .addOrder( Property.forName("age").desc() )
//			    .setMaxResults(50)
//			    .list();
//				 .setFetchMode("mate", FetchMode.EAGER)//用setFetchMode()在运行时定义动态关联抓取的语义。 
//				你可以使用createCriteria()非常容易的在互相关联的实体间建立 约束。
//				List cats = sess.createCriteria(Cat.class)
//				    .add( Restrictions.like("name", "F%")
//				    .createCriteria("kittens")
//				        .add( Restrictions.like("name", "F%")
//				    .list();
//				List cats = sess.createCriteria(Cat.class)
//			    .createAlias("kittens", "kt")
//			    .createAlias("mate", "mt")
//			    .add( Restrictions.eqProperty("kt.name", "mt.name") )
//			    .list();
//			(createAlias()并不创建一个新的 Criteria实例。) 
//				Cat实例所保存的之前两次查询所返回的kittens集合是 没有被条件预过滤的。如果你希望只获得
//				符合条件的kittens， 你必须使用returnMaps()。
//				List cats = sess.createCriteria(Cat.class)
//				    .createCriteria("kittens", "kt")
//				    .add( Restrictions.eq("name", "F%") )
//				    .returnMaps()
//				    .list();
//				Iterator iter = cats.iterator();
//				while ( iter.hasNext() ) {
//				    Map map = (Map) iter.next();
//				    Cat cat = (Cat) map.get(Criteria.ROOT_ALIAS);
//				    Cat kitten = (Cat) map.get("kt");
//				}
//				Example example = Example.create(cat)
//			    .excludeZeroes()           //exclude zero valued properties
//			    .excludeProperty("color")  //exclude the property named "color"
//			    .ignoreCase()              //perform case insensitive string comparisons
//			    .enableLike();             //use like for string comparisons
//			List results = session.createCriteria(Cat.class)
//			    .add(example)
//			    .list();
//				甚至可以使用examples在关联对象上放置条件。
//				List results = session.createCriteria(Cat.class)
//				    .add( Example.create(cat) )
//				    .createCriteria("mate")
//				        .add( Example.create( cat.getMate() ) )
//				    .list();
//				List results = session.createCriteria(Cat.class)
//			    .setProjection( Projections.rowCount() )
//			    .add( Restrictions.eq("color", Color.BLACK) )
//			    .list();
//			 
//			List results = session.createCriteria(Cat.class)
//			    .setProjection( Projections.projectionList()
//			        .add( Projections.rowCount() )
//			        .add( Projections.avg("weight") )
//			        .add( Projections.max("weight") )
//			        .add( Projections.groupProperty("color") )
//			    )
//			    .list();
				
				Criteria criteria = session.createCriteria(ResMenu.class);
				ResMenuDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
				criteria.add( Example.create(userCat) );
				criteria.setProjection(null);
				criteria.setFirstResult(pageSize * (pageNo - 1));
				criteria.setMaxResults(pageSize);
				List<?> result = criteria.list();
				return result;
			}
		});
		pager = new Pager(pageSize, pageNo, ResMenuDaoImpl.rowCount, list);
		return pager;
		
		}//end list()
	
	public Pager list(final int userCatId ,final int pageSize,final int pageNo)  {
//		Pager pager = null;	
//		List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
//			public Object doInHibernate(Session session) throws HibernateException, SQLException {
//				Criteria criteria = session.createCriteria(ResMenu.class);
//				ResMenuDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
//				//List result = session.createQuery(hql).setParameter(0, value).setFirstResult(offset).setMaxResults(pageSize).list();
//				String hql = "from ResMenu as resMenu where resMenu.userCat.id = ?"; 
//				Query q = session.createQuery(hql);
//				q.setInteger(0,userCatId);
//				q.setFirstResult(pageSize * (pageNo - 1));
//				q.setMaxResults(pageSize);
//				List<ResMenu> result = q.list();
//				ResMenuDaoImpl.rowCount = result.size();
//				return result;
//			}
//		});
//		pager = new Pager(pageSize, pageNo, ResMenuDaoImpl.rowCount, list);
//		return pager;
		
		Pager pager = null;	
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			//List<ResLeftSideItem> list = (List<ResLeftSideItem>)getHibernateTemplate().find("from ResLeftSideItem as ResLeftSideItem where ResLeftSideItem.resMenu.id = " + menuId);
			String hql = "select count(*) from ResMenu as ResMenu where ResMenu.userCat.id = " + userCatId;
			Long countLong = (java.lang.Long) session.createQuery(hql).uniqueResult();
			int countInt = countLong.intValue();
			Query queryObject = session.createQuery("from ResMenu as ResMenu where ResMenu.userCat.id = " + userCatId );
		    queryObject.setFirstResult(pageSize * (pageNo - 1));
		    queryObject.setMaxResults(pageSize);
		    List<ResMenu> list = (List<ResMenu>)queryObject.list();
		    pager = new Pager(pageSize, pageNo, countInt, list);
		    
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
				Query q = session.createQuery("select count(*) from  ResMenu  a where " + strWhereParam );
				Iterator itKey2 = setKeyOfMap.iterator();
				while(itKey2.hasNext()){
					String strKeyI2 = (String)itKey2.next();
					q.setParameter(intSerial,mapSqlParam.get(strKeyI2)); 
					intSerial++;
				}
				Object count = q.uniqueResult();
				ResMenuDaoImpl.rowCount = Integer.parseInt(count.toString());
				//
				intSerial = 0;
				q = session.createQuery("select a from ResMenu a where " + strWhereParam );
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
		pager = new Pager(pageSize, pageNo, ResMenuDaoImpl.rowCount, list);
		return pager;
		
	}//end list()
		
	/////insert///
	public Integer insert(ResMenu record) {
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
	public boolean delete(ResMenu record)  {
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
		ResMenu record = select(id);
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
		Object obj = getHibernateTemplate().load(ResMenu.class,new Integer(id));
		getHibernateTemplate().delete(obj);
		return true;
	}//end delete()
			
	/////update///
	public boolean update(ResMenu record)  {
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
	public ResMenu select(Integer id)  {
		/*
		Session session = null;
		ResMenu record = null;
		try {
			session = HibernateSessionFactory.currentSession();
			Query query = session.createQuery("from ResMenu where id=?");
			query.setInteger(0, id);
			record = (ResMenu) query.uniqueResult();
			query = null;
			
		} catch (HibernateException e) {
			throw e;
		} finally {
			HibernateSessionFactory.closeSession();
		}
		
		return record;
		*/
		
		return (ResMenu) getHibernateTemplate().get(ResMenu.class, new Integer(id));
		
		
	}//end select()
	
	/////main///
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
}//end class
