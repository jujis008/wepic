package com.wetuo.wepic.core.dao ;
 
import java.util.HashMap;
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

import com.wetuo.wepic.core.beans.ResMenu;
import com.wetuo.wepic.core.beans.UserCat;
import com.wetuo.wepic.common.hibernate.HibernateSessionFactory;
import com.wetuo.wepic.common.hibernate.XgHibernateCommonDao;
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.util.UUIDGenerator;
import com.wetuo.wepic.publish.beans.PublishCat;

import org.springframework.orm.hibernate3.HibernateCallback;
import java.sql.SQLException;
 
public class UserCatDaoImpl extends XgHibernateCommonDao implements UserCatDao {
	private static Log log = LogFactory.getLog(UserCatDaoImpl.class);
	private static int rowCount = 0;
	//////////////common crud//////////////////////////////////////////////
	public List<UserCat> findAll(){ 
		return (List<UserCat>)getHibernateTemplate().find("from UserCat");
	}
	
	public List<UserCat> findPart(String strFields, String[] arrStrValues){ 
		return (List<UserCat>)getHibernateTemplate().find("from UserCat where "+strFields, arrStrValues);
	}
	
	public UserCat findFather(final int id)  {
		return this.select(this.select(id).getPid());
	}//end list()

	@SuppressWarnings("null")
	public List<UserCat> findAllFathers(final int id)  {
		List<UserCat> result = new ArrayList<UserCat>();	
		int pid = 100;
		int currenId = id;
		while( pid > 0 ){
			UserCat uc = findFather(currenId);
			if( uc == null){
				break;
			}
			result.add(uc) ;
			pid = uc.getId();
			currenId = pid ;
		}
		
		return result;
	}//end list()
	
	@SuppressWarnings("unchecked")
	public List<UserCat> find(final String type)  {
		List<UserCat> result = null;	
		result = getHibernateTemplate().find("From UserCat as UserCat where  UserCat.type = '"+ type + "'  order by id desc");
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
	
	public Pager list(final int pageSize,final int pageNo)  {	
	Pager pager = null;	
	//??????HibernateCallback????4??��??
	List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
		//???HibernateCallback?????????????
		public Object doInHibernate(Session session) throws HibernateException, SQLException {
			//???Hibernate??????
			//List result = session.createQuery(hql).setParameter(0, value).setFirstResult(offset).setMaxResults(pageSize).list();
			Criteria criteria = session.createCriteria(UserCat.class);
			UserCatDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
			criteria.setProjection(null);
			criteria.setFirstResult(pageSize * (pageNo - 1));
			criteria.setMaxResults(pageSize);
			List<?> result = criteria.list();
			return result;
		}
	});
	pager = new Pager(pageSize, pageNo, UserCatDaoImpl.rowCount, list);
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
				Criteria criteria = session.createCriteria(UserCat.class);
				UserCatDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
				criteria.setProjection(null);
				criteria.setFirstResult(pageSize * (pageNo - 1));
				criteria.setMaxResults(pageSize);
				List<?> result = criteria.list();
				return result;
			}
		});
		pager = new Pager(pageSize, pageNo, UserCatDaoImpl.rowCount, list);
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
				Query q = session.createQuery("select count(*) from  UserCat  a where " + strWhereParam );
				Iterator itKey2 = setKeyOfMap.iterator();
				while(itKey2.hasNext()){
					String strKeyI2 = (String)itKey2.next();
					q.setParameter(intSerial,mapSqlParam.get(strKeyI2)); 
					intSerial++;
				}
				Object count = q.uniqueResult();
				UserCatDaoImpl.rowCount = Integer.parseInt(count.toString());
				//
				intSerial = 0;
				q = session.createQuery("select a from UserCat a where " + strWhereParam );
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
		pager = new Pager(pageSize, pageNo, UserCatDaoImpl.rowCount, list);
		return pager;
		
	}//end list()
		
	/////insert///
	public Integer insert(UserCat record) {
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
	public boolean delete(UserCat record)  {
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
		UserCat record = select(id);
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
		Object obj = getHibernateTemplate().load(UserCat.class,new Integer(id));
		getHibernateTemplate().delete(obj);
		return true;
	}//end delete()
			
	/////update///
	public boolean update(UserCat record)  {
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
		//getHibernateTemplate().getSessionFactory().openSession().flush();
		return true;
//      Session session = getHibernateTemplate().getSessionFactory().openSession();   
		//      org.hibernate.Transaction ts = session.beginTransaction();   
		//      try {   
		//      session.flush();   
		//      ts.begin();   
		//      session.saveOrUpdate(user);   
		//      ts.commit();   
		//      } catch (Exception e) {   
		//      ts.rollback();   
		//      } finally {   
		//      session.close();}   
		
	}//end update()
			
	/////select///
	public UserCat select(Integer id)  {
		/*
		Session session = null;
		UserCat record = null;
		try {
			session = HibernateSessionFactory.currentSession();
			Query query = session.createQuery("from UserCat where id=?");
			query.setInteger(0, id);
			record = (UserCat) query.uniqueResult();
			query = null;
			
		} catch (HibernateException e) {
			throw e;
		} finally {
			HibernateSessionFactory.closeSession();
		}
		
		return record;
		*/
		
		return (UserCat) getHibernateTemplate().get(UserCat.class, new Integer(id));
		
		
	}//end select()

	@SuppressWarnings("unchecked")
	public Map<UserCat,List<UserCat>> getUserCatMapUnderProjectCat(int pid) {
		Map<UserCat,List<UserCat>> map = new HashMap<UserCat,List<UserCat>>();
		//List<UserCat> list=getHibernateTemplate().find("From UserCat as UserCat where  UserCat.type = 'project'  order by id desc");
		List<UserCat> list=getHibernateTemplate().find("From UserCat as UserCat where  UserCat.pid = "+ pid +"  order by id desc");
		for(UserCat UserCat  : list){
			List<UserCat> list1=getHibernateTemplate()
				.find("From UserCat as UserCat where  UserCat.pid = "+ UserCat.getId().toString() +"  order by id desc");
			map.put(UserCat, list1);			
		}
		return map;
	}
	
	@SuppressWarnings("unchecked")
	public List<List<UserCat>>  getLevel2UserCatMapUnderProjectCat(int pid) {
		List<List<UserCat>>  list0 = new ArrayList<List<UserCat>>();
		//List<UserCat> list=getHibernateTemplate().find("From UserCat as UserCat where  UserCat.type = 'project'  order by id desc");
		List<UserCat> list=getHibernateTemplate().find("From UserCat as UserCat where  UserCat.pid = "+ pid +"  order by id desc");
		for(UserCat UserCat  : list){
			List<UserCat> list1=getHibernateTemplate()
				.find("From UserCat as UserCat where  UserCat.pid = "+ UserCat.getId().toString() +"  order by id desc");
			list1.add(UserCat) ;
			list0.add( list1);			
		}
		return list0;
	}
	
	@SuppressWarnings("unchecked")
	public List<UserCat> getUserCatListJustUnderProjectCat(int pid) {
		//List<UserCat> list=getHibernateTemplate().find("From UserCat as UserCat where  UserCat.type = 'project'  order by id desc");
		List<UserCat> list=getHibernateTemplate().find("From UserCat as UserCat where  UserCat.pid = "+ pid +"  order by id desc");
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<UserCat> getUserCatListForRegister() {
		//List<UserCat> list=getHibernateTemplate().find("From UserCat as UserCat where  UserCat.type = 'project'  order by id desc");
		List<UserCat> list=getHibernateTemplate().find("From UserCat as userCat where  userCat.register = 1  order by id desc");
		return list;
	}

	public List<UserCat> getUserCatListUnderProjectCat(int pid) {
		// TODO Auto-generated method stub		
		List<UserCat> list0 = getUserCatListJustUnderProjectCat( pid);//all
		List<UserCat> list = list0;//each cycle
		List<UserCat> list1 = null; //temp
		do{
			if(list1 != null){
				list1.clear();
			}
			if(list==null || list.size()==0 ){
				return list0;
			}else{
				for(UserCat UserCat : list){
					List<UserCat> list2 = getUserCatListJustUnderProjectCat( UserCat.getId());
					list1.addAll(list2);
					list0.addAll(list2);		
					
				}
				list.clear();
				list.addAll(list1);
		     }//else
		}while(list != null && list.size()>0);
		return list0 ;
		
//		if(list==null || list.size()==0 ){
//			return list;
//		}else{
//			for(UserCat UserCat : list){
//				List<UserCat> list1 = getUserCatListJustUnderProjectCat( UserCat.getId());
//				list.addAll(list1);				
//			}
//		}
		
	   
	}
	
	public List<UserCat> getNextLevelCatList(List<UserCat> list){
		List<UserCat> list0 = list;
		
		if(list0==null || list0.size()==0 ){
			return list0;
		}else{
			for(UserCat UserCat : list0){
				List<UserCat> list1 = getUserCatListJustUnderProjectCat( UserCat.getId());
				list0.addAll(list1);
				
			}
			return list0;
		}
	}
	
	public List<UserCat> getUserCatListUnderPid(int pid) {
		// TODO Auto-generated method stub
		List<UserCat> list=getHibernateTemplate().find("From UserCat as UserCat where  UserCat.pid = "+ pid +"  order by id desc");
		return list;
	}
	
	/////main///
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	@SuppressWarnings("unchecked")
	public List<UserCat> getuserCatListJustUnderCat(int pid) {
		//List<PublishCat> list=getHibernateTemplate().find("From PublishCat as publishCat where  publishCat.type = 'project'  order by id desc");
		List<UserCat> list=getHibernateTemplate().find("From UserCat as userCat where  userCat.pid = "+ pid +"  order by id desc");
		return list;
	}
	public List<UserCat> getUserCatListUnderUserCat(int pid) {
		List<UserCat> list0 = getuserCatListJustUnderCat( pid);//all
		List<UserCat> list = list0;//each cycle
		List<UserCat> list1 = null;
		do {
			if(list1 != null){
				list1.clear();
			}
			if(list==null || list.size()==0 ){
				return list0;
			}else{
				for(UserCat userCat : list){
					List<UserCat> list2 = getuserCatListJustUnderCat( userCat.getId());
					list1.addAll(list2);
					list0.addAll(list2);		
					
				}
				list.clear();
				list.addAll(list1);
		     }//else
		} while (list != null && list.size()>0);
		return list0;
	}
	public UserCat findByPid(Integer id) {
		// TODO Auto-generated method stub
		List<UserCat> list=getHibernateTemplate().find("From UserCat as UserCat where  UserCat.pid = "+ id +"  order by id desc");
		if (list!=null && list.size()>0) {
			return list.get(0);
		}else {
			return null;
		}
	}
	
}//end class
