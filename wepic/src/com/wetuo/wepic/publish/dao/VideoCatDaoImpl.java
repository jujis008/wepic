package com.wetuo.wepic.publish.dao ;
 
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


import com.wetuo.wepic.common.hibernate.HibernateSessionFactory;
import com.wetuo.wepic.common.hibernate.XgHibernateCommonDao;
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.util.UUIDGenerator;
import com.wetuo.wepic.publish.beans.VideoCat;

import org.springframework.orm.hibernate3.HibernateCallback;


import java.sql.SQLException;
 
public class VideoCatDaoImpl extends XgHibernateCommonDao implements VideoCatDao {
	private static Log log = LogFactory.getLog(VideoCatDaoImpl.class);
	private static int rowCount = 0;
	//////////////common crud//////////////////////////////////////////////
	public List<VideoCat> findAll(){ 
		return (List<VideoCat>)getHibernateTemplate().find("from VideoCat");
	}
	
	public List<VideoCat> findPart(String strFields, String[] arrStrValues){ 
		return (List<VideoCat>)getHibernateTemplate().find("from VideoCat where "+strFields, arrStrValues);
	}
	
	public Pager list(final int pageSize,final int pageNo)  {	
		Pager pager = null;	
		//??????HibernateCallback????4??��??
		List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
			//???HibernateCallback?????????????
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				//???Hibernate??????
				//List result = session.createQuery(hql).setParameter(0, value).setFirstResult(offset).setMaxResults(pageSize).list();
				Criteria criteria = session.createCriteria(VideoCat.class);
				VideoCatDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
				criteria.setProjection(null);
				criteria.setFirstResult(pageSize * (pageNo - 1));
				criteria.setMaxResults(pageSize);
				List<?> result = criteria.list();
				return result;
			}
		});
		pager = new Pager(pageSize, pageNo, VideoCatDaoImpl.rowCount, list);
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
			Criteria criteria = session.createCriteria(VideoCat.class);
			VideoCatDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
			criteria.setProjection(null);
			criteria.setFirstResult(pageSize * (pageNo - 1));
			criteria.setMaxResults(pageSize);
			List<?> result = criteria.list();
			return result;
		}
	});
	pager = new Pager(pageSize, pageNo, VideoCatDaoImpl.rowCount, list);
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
				Query q = session.createQuery("select count(*) from  VideoCat  a where " + strWhereParam );
				Iterator itKey2 = setKeyOfMap.iterator();
				while(itKey2.hasNext()){
					String strKeyI2 = (String)itKey2.next();
					q.setParameter(intSerial,mapSqlParam.get(strKeyI2)); 
					intSerial++;
				}
				Object count = q.uniqueResult();
				VideoCatDaoImpl.rowCount = Integer.parseInt(count.toString());
				//
				intSerial = 0;
				q = session.createQuery("select a from VideoCat a where " + strWhereParam );
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
		pager = new Pager(pageSize, pageNo, VideoCatDaoImpl.rowCount, list);
		return pager;
		
	}//end list()
		
	/////insert///
	public Integer insert(VideoCat record) {
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
	public boolean delete(VideoCat record)  {
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
		PublishCat record = select(id);
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
		Object obj = getHibernateTemplate().load(VideoCat.class,new Integer(id));
		getHibernateTemplate().delete(obj);
		return true;
	}//end delete()
			
	/////update///
	public boolean update(VideoCat record)  {
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
	public VideoCat select(Integer id)  {
		/*
		Session session = null;
		PublishCat record = null;
		try {
			session = HibernateSessionFactory.currentSession();
			Query query = session.createQuery("from PublishCat where id=?");
			query.setInteger(0, id);
			record = (PublishCat) query.uniqueResult();
			query = null;
			
		} catch (HibernateException e) {
			throw e;
		} finally {
			HibernateSessionFactory.closeSession();
		}
		
		return record;
		*/
		
		return (VideoCat) getHibernateTemplate().get(VideoCat.class, new Integer(id));
		
		
	}//end select()
	
	@SuppressWarnings("unchecked")
	public List<VideoCat> getVideoCatList() {
//		List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
//			//???HibernateCallback?????????????
//			public Object doInHibernate(Session session) throws HibernateException, SQLException {
//				//???Hibernate??????
//				//List result = session.createQuery(hql).setParameter(0, value).setFirstResult(offset).setMaxResults(pageSize).list();
//				Query criteria = session.createSQLQuery("select * from publishcat where pid=(select id from publishcat where type='picture')  or pid in (select id from publishcat where pid=(select id from publishcat where type='picture'))ORDER BY id DESC").addEntity(PublishCat.class);
//               // criteria
//				
//				
//				//PublishCatDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
////				criteria.setProjection(null);
////				criteria.setFirstResult(pageSize * (pageNo - 1));
////				criteria.setMaxResults(pageSize);
//				List<?> result = criteria.list();
//				return result;
//			}
//		});
		
		
		
		
		
		
		
		
		List<VideoCat> list=getHibernateTemplate().find("From VideoCat");
		return list;
	}
	
	//public List<PublishCat> getPublishCatListJustUnderProjectCat(int pid) ;
	//public Map<PublishCat,List<PublishCat>> getPublishCatMapUnderProjectCat(int pid) ;
	
	
/*	@SuppressWarnings("unchecked")
	public Map<VideoCat,List<VideoCat>> getVideoCatMapUnderProjectCat(int vid) {
		Map<VideoCat,List<VideoCat>> map = new HashMap<VideoCat,List<VideoCat>>();
		//List<PublishCat> list=getHibernateTemplate().find("From PublishCat as publishCat where  publishCat.type = 'project'  order by id desc");
		List<VideoCat> list=getHibernateTemplate().find("From VideoCat as VideoCat where  VideoCat = "+ vid +"  order by id desc");
		for(VideoCat videoCat  : list){
			List<VideoCat> list1=getHibernateTemplate()
				.find("From VideoCat as videoCat where  videoCat.vid = "+ videoCat.getId().toString() +"  order by id desc");
			map.put(videoCat, list1);			
		}
		return map;
	}*/
	
	@SuppressWarnings("unchecked")
	public List<List<VideoCat>>  getLevel2VideoCatMapUnderProjectCat(int vid) {
		List<List<VideoCat>>  list0 = new ArrayList<List<VideoCat>>();
		//List<PublishCat> list=getHibernateTemplate().find("From PublishCat as publishCat where  publishCat.type = 'project'  order by id desc");
		List<VideoCat> list=getHibernateTemplate().find("From VideoCat as videoCat where  videoCat.vid = "+ vid +"  order by id desc");
		for(VideoCat videoCat  : list){
			List<VideoCat> list1=getHibernateTemplate()
				.find("From VideoCat as videoCat where  videoCat.vid = "+ videoCat.getId().toString() +"  order by id desc");
			list1.add(videoCat) ;
			list0.add( list1);			
		}
		return list0;
	}
/*	@SuppressWarnings("unchecked")*/
/*	public List<VideoCat>  getLevel2VideoCatsUnderProjectCat(int vid) {
		List<VideoCat>  listAll = new ArrayList<VideoCat>();
		//List<VideoCat> list=getHibernateTemplate().find("From VideoCat as videoCat where  videoCat.type = 'project'  order by id desc");
		List<VideoCat> list=getHibernateTemplate().find("From VideoCat as videoCat where  videoCat.vid = "+ vid +"  order by id desc");
		listAll.addAll(list);
		for(VideoCat videoCat  : list){
			List<VideoCat> list1=getHibernateTemplate()
				.find("From VideoCat as videoCat where  videoCat.vid = "+ videoCat.getId().toString() +"  order by id desc");
			listAll.addAll( list1);			
		}
		return listAll;
	}*/
	
	@SuppressWarnings("unchecked")
	public List<VideoCat> getVideoCatListJustUnderProjectCat(int vid) {
		//List<PublishCat> list=getHibernateTemplate().find("From PublishCat as publishCat where  publishCat.type = 'project'  order by id desc");
		List<VideoCat> list=getHibernateTemplate().find("From VideoCat as videoCat where  videoCat.vid = "+ vid +"  order by id desc");
		return list;
	}

/*	public List<VideoCat> getPublishCatListUnderProjectCat(int pid) {
		// TODO Auto-generated method stub		
		List<VideoCat> list0 = getPublishCatListJustUnderProjectCat( pid);//all
		List<VideoCat> list = list0;//each cycle
		List<VideoCat> list1 = null; //temp
		do{
			if(list1 != null){
				list1.clear();
			}
			if(list==null || list.size()==0 ){
				return list0;
			}else{
				for(VideoCat publishCat : list){
					List<VideoCat> list2 = getPublishCatListJustUnderProjectCat( publishCat.getId());
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
//			for(PublishCat publishCat : list){
//				List<PublishCat> list1 = getPublishCatListJustUnderProjectCat( publishCat.getId());
//				list.addAll(list1);				
//			}
//		}
		
	   
	}
	*/
/*	public List<VideoCat> getNextLevelCatList(List<VideoCat> list){
		List<VideoCat> list0 = list;
		
		if(list0==null || list0.size()==0 ){
			return list0;
		}else{
			for(VideoCat publishCat : list0){
				List<VideoCat> list1 = getPublishCatListJustUnderProjectCat( publishCat.getId());
				list0.addAll(list1);
				
			}
			return list0;
		}
	}*/
	
/*	public List<VideoCat> getPublishCatListUnderVid(int vid) {
		// TODO Auto-generated method stub
		List<VideoCat> list=getHibernateTemplate().find("From VideoCat as videoCat where  videoCat.vid = "+ vid +" and videoCat.type <> 'story'  order by id desc");
		return list;
	}*/
	
	public List<VideoCat> getVideoCatListchild(int vid) {
		// TODO Auto-generated method stub
		List<VideoCat> list=getHibernateTemplate().find("From VideoCat as videoCat where  videoCat.vid="+vid+" OR videoCat.vid IN(SELECT id FROM VideoCat WHERE vid="+vid);
		return list;
	}







/////main///
/*	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VideoCatDaoImpl pcdImpl = new VideoCatDaoImpl();
		List<VideoCat>  list11 = pcdImpl.getPublishCatListUnderProjectCat(2);
		for(VideoCat pCat :list11){
			System.out.println("pCat : " + pCat.getName());
			
		}
	}*/

	
}//end class
