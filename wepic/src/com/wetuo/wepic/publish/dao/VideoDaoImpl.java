package com.wetuo.wepic.publish.dao ;
 
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
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.cxf.service.invoker.SessionFactory;
import org.apache.fop.layout.Page;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


import com.wetuo.wepic.common.hibernate.HibernateSessionFactory;
import com.wetuo.wepic.common.hibernate.XgHibernateCommonDao;
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.util.UUIDGenerator;
import com.wetuo.wepic.core.beans.User;
//import com.wetuo.wepic.core.dao.UserDao;
import com.wetuo.wepic.publish.beans.Video;
import com.wetuo.wepic.publish.beans.VideoCat;
import com.wetuo.wepic.publish.beans.VideoSpecialCat;


import com.sun.istack.internal.FinalArrayList;
import com.sun.org.apache.xml.internal.security.encryption.Transforms;

import org.springframework.orm.hibernate3.HibernateCallback;
import java.sql.SQLException;
 
public class VideoDaoImpl extends XgHibernateCommonDao implements VideoDao {
	private static Log log = LogFactory.getLog(VideoDaoImpl.class);
	private static int rowCount = 0;
	private VideoCatDao videoCatDao ;
	private VideoCat_VideoDao videoCat_VideoDao ;
//	private UserDao userDao ;//= new UserDaoImpl();


	
	public VideoCatDao getVideoCatDao() {
		return videoCatDao;
	}

	public void setVideoCatDao(VideoCatDao videoCatDao) {
		this.videoCatDao = videoCatDao;
	}
	/**
	 * 根据当前用户的专辑名称查找专辑下的所有视频
	 * @param videoSpecialCat
	 * @param user
	 * @return
	 */
	public List findVideoListByVideoSpecialCat(VideoSpecialCat videoSpecialCat,User user){
/*		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		   
	    List<Video> videos=null;
	    Transaction tx = null;
	    try {
	    	tx = session.beginTransaction();
	    	Query queryObject = session.createQuery("from Video video where video.user.id="+user.getId());
	    	videos=queryObject.list();
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
		return videos;*/
		Session session=getHibernateTemplate().getSessionFactory().getCurrentSession();
		List<Video> videoList=null;
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			Query queryObject=session.createQuery("from Video video where video.videoSpecialCat=? and video.user=?");
			queryObject.setParameter(0, videoSpecialCat);
			queryObject.setParameter(1, user);
			videoList=queryObject.list();
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			if(tx!=null){
				tx.rollback();
			}
			e.printStackTrace();
		}finally{
			if(session.isOpen()){
				session.close();
			}
		}
		
		return videoList;
	}
	
	
	//////////////common crud//////////////////////////////////////////////
	public List<Video> findAll(){ 
		return (List<Video>)getHibernateTemplate().find("from Video");
	}
	
	@SuppressWarnings("unchecked")
	public List<Video> findPart(String strFields, String[] arrStrValues){ 
		return (List<Video>)getHibernateTemplate().find("from Video where "+strFields, arrStrValues);
	}
	
	public Pager findById(final int id,final int pageSize,final int pageNo){
		Pager pager = null;	
		List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(Video.class);
				VideoDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
				criteria.setProjection(null);
				
				//User user = userDao.select(username);
				criteria.add(Expression.eq("id",id));
				criteria.setFirstResult(pageSize * (pageNo - 1));
				criteria.setMaxResults(pageSize);
				List<?> result = criteria.list();
				return result;
			}
		});
		pager = new Pager(pageSize, pageNo, VideoDaoImpl.rowCount, list);
		return pager;
	}
	public List<Video> findVideoByUser1(User user)  {
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		   
	    List<Video> videos=null;
	    Transaction tx = null;
	    try {
	    	tx = session.beginTransaction();
	    	Query queryObject = session.createQuery("from Video video where video.user.id="+user.getId());
	    	videos=queryObject.list();
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
		return videos;
		}
	
	public Pager list(final int pageSize,final int pageNo)  {	
		Pager pager = null;	
		//HibernateCallback
		List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
			//HibernateCallback
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				//Hibernate
				//List result = session.createQuery(hql).setParameter(0, value).setFirstResult(offset).setMaxResults(pageSize).list();
				Criteria criteria = session.createCriteria(Video.class);
				VideoDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
				criteria.setProjection(null);
				criteria.setFirstResult(pageSize * (pageNo - 1));
				criteria.setMaxResults(pageSize);
				criteria.addOrder(Order.desc("publishTime"));  
				List<?> result = criteria.list();
				return result;
			}
		});
		pager = new Pager(pageSize, pageNo, VideoDaoImpl.rowCount, list);
		return pager;
	
	}//end list()
/*	public Pager list(final String username,final int pageSize,final int pageNo)  {	
		Pager pager = null;	
		//??????HibernateCallback
		List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
			//???HibernateCallback
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				//???Hibernate
				//List result = session.createQuery(hql).setParameter(0, value).setFirstResult(offset).setMaxResults(pageSize).list();
				Criteria criteria = session.createCriteria(Video.class);
				VideoDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
				criteria.setProjection(null);
				
				User user = userDao.select(username);
				criteria.add(Expression.eq("user",user));
				criteria.setFirstResult(pageSize * (pageNo - 1));
				criteria.setMaxResults(pageSize);
				criteria.addOrder(Order.desc("id"));
				List<?> result = criteria.list();
				return result;
			}
		});
		pager = new Pager(pageSize, pageNo, VideoDaoImpl.rowCount, list);
		return pager;
	
	}//end list()
*/	
	
	public Video select(Integer id)  {
		/*
		Session session = null;
		Publish record = null;
		try {
			session = HibernateSessionFactory.currentSession();
			Query query = session.createQuery("from Publish where id=?");
			query.setInteger(0, id);
			record = (Publish) query.uniqueResult();
			query = null;
			
		} catch (HibernateException e) {
			throw e;
		} finally {
			HibernateSessionFactory.closeSession();
		}
		
		return record;
		*/
		
		return (Video) getHibernateTemplate().get(Video.class, new Integer(id));
		
		
	}//end select()
	
	public Integer insert(Video record) {
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
	/////update///
	public boolean update(Video record)  {
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
	
	public boolean delete(Video record)  {
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
		try {
			Object obj = getHibernateTemplate().load(Video.class,new Integer(id));
			getHibernateTemplate().delete(obj);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}//end delete()
	
	public List getVideoIdByUid(int id) {
		// TODO Auto-generated method stub
		List list=getHibernateTemplate().find("select id from Video as video where video.user="+id);
		return list;
	}
	
	public Pager findVideoByUser(final User user,final int pageSize,final int pageNo)  {	
		Pager pager = null;	
		List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(Video.class);
				VideoDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
				criteria.setProjection(null);
				
				criteria.add(Expression.eq("user",user));
				//criteria.add(Expression.ilike("content", searchText));
				
				criteria.setFirstResult(pageSize * (pageNo - 1));
				criteria.setMaxResults(pageSize);
				List<?> result = criteria.list();
				return result;
			}
		});
		pager = new Pager(pageSize, pageNo, VideoDaoImpl.rowCount, list);
		return pager;
	
	}//end list()
	
	
	/**
	 * 查找某个用户正在被审核中的视频
	 */
	public Pager findWaitApprovalByUser(final User user,final int pageSize,final int pageNo){
		Pager pager = null;	
		List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(Video.class);
				VideoDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
				criteria.setProjection(null);
				
				criteria.add(Restrictions.eq("user",user));
				//criteria.add(Expression.ilike("content", searchText));
				criteria.add(Restrictions.eq("status", 0));
				criteria.setFirstResult(pageSize * (pageNo - 1));
				criteria.setMaxResults(pageSize);
				List<?> result = criteria.list();
				return result;
			}
		});
		pager = new Pager(pageSize, pageNo, VideoDaoImpl.rowCount, list);
		return pager;
	}
	/**
	 * 未审核通过的视频
	 * @param user
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public Pager findNotApprovalByUser(final User user,final int pageSize,final int pageNo){
		Pager pager = null;	
		List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(Video.class);
				VideoDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
				criteria.setProjection(null);
				
				criteria.add(Restrictions.eq("user",user));
				//criteria.add(Expression.ilike("content", searchText));
				criteria.add(Restrictions.eq("status", 1));
				criteria.setFirstResult(pageSize * (pageNo - 1));
				criteria.setMaxResults(pageSize);
				List<?> result = criteria.list();
				return result;
			}
		});
		pager = new Pager(pageSize, pageNo, VideoDaoImpl.rowCount, list);
		return pager;
	}
	/**
	 * 审核通过的视频
	 * @param user
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public Pager findApprovalPassByUser(final User user,final int pageSize,final int pageNo){
		Pager pager = null;	
		List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(Video.class);
				VideoDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
				criteria.setProjection(null);
				
				criteria.add(Restrictions.eq("user",user));
				//criteria.add(Expression.ilike("content", searchText));
				criteria.add(Restrictions.eq("status", 2));
				criteria.setFirstResult(pageSize * (pageNo - 1));
				criteria.setMaxResults(pageSize);
				List<?> result = criteria.list();
				return result;
			}
		});
		pager = new Pager(pageSize, pageNo, VideoDaoImpl.rowCount, list);
		return pager;
	}
	/**
	 * 查找所有未审核的视频
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public Pager findAllApprovalPassByUse(final int pageSize,final int pageNo){
		Pager pager = null;	
		List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(Video.class);
				VideoDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
				criteria.setProjection(null);
				
				//criteria.add(Expression.ilike("content", searchText));
				criteria.add(Restrictions.eq("status", 0));
				criteria.setFirstResult(pageSize * (pageNo - 1));
				criteria.setMaxResults(pageSize);
				List<?> result = criteria.list();
				return result;
			}
		});
		pager = new Pager(pageSize, pageNo, VideoDaoImpl.rowCount, list);
		return pager;
	}
	
	
	
//&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

	
/*	public Pager findByName(final String searchText,final int pageSize,final int pageNo)  {	
		Pager pager = null;	
		List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(Video.class);
				VideoDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
				criteria.setProjection(null);
				
				criteria.add(Expression.eq("name",searchText));
				//criteria.add(Expression.ilike("name", searchText));
				criteria.setFirstResult(pageSize * (pageNo - 1));
				criteria.setMaxResults(pageSize);
				List<?> result = criteria.list();
				return result;
			}
		});
		pager = new Pager(pageSize, pageNo, VideoDaoImpl.rowCount, list);
		return pager;
	
	}//end list()
	
	
	
	public Pager findLikeName(final String searchText,final int pageSize,final int pageNo)  {	
		Pager pager = null;	
		List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(Video.class);
				VideoDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
				criteria.setProjection(null);
				
				//criteria.add(Expression.eq("name",searchText));
				criteria.add(Expression.ilike("name", searchText));
				criteria.setFirstResult(pageSize * (pageNo - 1));
				criteria.setMaxResults(pageSize);
				List<?> result = criteria.list();
				return result;
			}
		});
		pager = new Pager(pageSize, pageNo, VideoDaoImpl.rowCount, list);
		return pager;
	
	}//end list()
	
	public Pager findByContent(final String searchText,final int pageSize,final int pageNo)  {	
		Pager pager = null;	
		List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(Video.class);
				VideoDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
				criteria.setProjection(null);
				
				criteria.add(Expression.eq("content",searchText));
				//criteria.add(Expression.ilike("content", searchText));
				
				criteria.setFirstResult(pageSize * (pageNo - 1));
				criteria.setMaxResults(pageSize);
				List<?> result = criteria.list();
				return result;
			}
		});
		pager = new Pager(pageSize, pageNo, VideoDaoImpl.rowCount, list);
		return pager;
	
	}//end list()
	
	@SuppressWarnings("unchecked")
	public Pager findLikeContent1(final String searchText,final int pageSize,final int pageNo)  {	
		Pager pager = null;	
		
		List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(Publish.class);
				PublishDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
				criteria.setProjection(null);
				
				//criteria.add(Expression.eq("content",searchText));
				criteria.add(Expression.ilike("content", searchText));
				
				criteria.setFirstResult(pageSize * (pageNo - 1));
				criteria.setMaxResults(pageSize);
				List<?> result = criteria.list();
				return result;
			}
		});
		
		int count = 0;
		String queryString = "from Publish s where s.content like '%" + searchText + "%'"; 
//		try{
//			count = ((Integer) getHibernateTemplate().iterate(queryString).next()).intValue();
//		}catch(Exception e){
//			count = 0;
//			e.printStackTrace();
//		}
		 
		
		
		List<Video> listPublish = (List<Video>)getHibernateTemplate().find(queryString);
		if(listPublish != null && listPublish.size() > 0){
			count = listPublish.size();
		}else{
			count = 0;
		}
		
		
		//pager = new Pager(pageSize, pageNo, PublishDaoImpl.rowCount, list);
		pager = new Pager(pageSize, pageNo, count, listPublish);
		return pager;
	
	}//end list()
	
	public Pager findLikeContent(final String searchText,final int pageSize,final int pageNo)  {	
		Pager pager = null;	
		//??????HibernateCallback????4??��??
		List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
			//???HibernateCallback?????????????
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				//???Hibernate??????
				//List result = session.createQuery(hql).setParameter(0, value).setFirstResult(offset).setMaxResults(pageSize).list();
				Criteria criteria = session.createCriteria(Video.class);
				criteria.add(Expression.ilike("content", "%"+searchText+"%"));
				VideoDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
				criteria.setProjection(null);
				criteria.setFirstResult(pageSize * (pageNo - 1));
				criteria.setMaxResults(pageSize);
				List<?> result = criteria.list();
				return result;
			}
		});
		pager = new Pager(pageSize,pageNo,VideoDaoImpl.rowCount,list);
		return pager;
	}
	
	



	public Pager listUnderCat(final Integer catId,final int pageSize,final int pageNo)  {	
		Pager pager = null;	
		//??????HibernateCallback
		List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
			//???HibernateCallback
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				//???Hibernate
				//List result = session.createQuery(hql).setParameter(0, value).setFirstResult(offset).setMaxResults(pageSize).list();
				Criteria criteria = session.createCriteria(Video.class);
//				PublishDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
//				criteria.setProjection(null);
				
				//User user = userDao.select(username);
				VideoCat publishCat = publishCatDao.select(catId);
				criteria.add(Expression.eq("publishCat",publishCat));
				VideoDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
				criteria.setProjection(null);
				criteria.setFirstResult(pageSize * (pageNo - 1));
				criteria.setMaxResults(pageSize);
				List<?> result = criteria.list();
				return result;
			}
		});
		pager = new Pager(pageSize, pageNo, VideoDaoImpl.rowCount, list);
		return pager;
	
	}//end list()
	
	public Pager listUnderCatCurrentUser(final Integer catId,final String username,final int pageSize,final int pageNo)  {	
		Pager pager = null;	
		//HibernateCallback
		List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
			//HibernateCallback
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				//Hibernate
				//List result = session.createQuery(hql).setParameter(0, value).setFirstResult(offset).setMaxResults(pageSize).list();
				Criteria criteria = session.createCriteria(Video.class);
//				PublishDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
//				criteria.setProjection(null);
				
				//User user = userDao.select(username);
				VideoCat publishCat = publishCatDao.select(catId);
				criteria.add(Expression.eq("publishCat",publishCat));
				User user = userDao.select(username);
				criteria.add(Expression.eq("user",user));
				VideoDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
				criteria.setProjection(null);
				criteria.setFirstResult(pageSize * (pageNo - 1));
				criteria.setMaxResults(pageSize);
				List<?> result = criteria.list();
				return result;
			}
		});
		pager = new Pager(pageSize, pageNo, VideoDaoImpl.rowCount, list);
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
				Query q = session.createQuery("select count(*) from  Publish  a where " + strWhereParam );
				Iterator itKey2 = setKeyOfMap.iterator();
				while(itKey2.hasNext()){
					String strKeyI2 = (String)itKey2.next();
					q.setParameter(intSerial,mapSqlParam.get(strKeyI2)); 
					intSerial++;
				}
				Object count = q.uniqueResult();
				VideoDaoImpl.rowCount = Integer.parseInt(count.toString());
				//
				intSerial = 0;
				q = session.createQuery("select a from Publish a where " + strWhereParam );
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
		pager = new Pager(pageSize, pageNo, VideoDaoImpl.rowCount, list);
		return pager;
		
	}//end list()
		
	/////insert///

			
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

			

			
	/////select///

	
	@SuppressWarnings("unchecked")
	public Integer getPublishCatIdByType(final String publishCatType)  {
		Integer publishCatId = null;
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();//publishTime
			
			Query queryObject = session.createQuery("select id from PublishCat as PublishCat where PublishCat.type = '"+publishCatType+"'  " );
//			PublishCat publishCat = (PublishCat) queryObject.list().get(0);
//			publishCatId = publishCat.getId();
			publishCatId = (Integer) queryObject.list().get(0);
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
		return publishCatId;
		
		
		
	}//end list()
	
	public List<PublishCat> getPublishCatsUnderByType(final String publishCatType){
		Integer publishCatId = this.getPublishCatIdByType(publishCatType);
		List<PublishCat>  publisCats = publishCatDao.getLevel2PublishCatsUnderProjectCat(publishCatId);
		return publisCats ;
	}
	public PublishCat getPublishCatByPublish(Integer id) {
		PublishCat publishCat=null;
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();//publishTime

			StringBuffer totalHql = new StringBuffer() ;
			totalHql.append("select distinct publishCat from PublishCat_Publish as cat where cat.publish.id="+id);
			Query queryObjectCount = session.createQuery( totalHql.toString());
			List<PublishCat> listPublishCount   = (List<PublishCat>)queryObjectCount.list();		    
			publishCat = listPublishCount.get(0);
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
		return publishCat;
	}
	
	@SuppressWarnings("unchecked")
	public Publish getMainPicOfTopPublishCat(final String publishCatType){
		Publish publish = null;
		
		Integer publishCatId = this.getPublishCatIdByType(publishCatType);
		List<PublishCat>  publisCats = publishCatDao.getLevel2PublishCatsUnderProjectCat(publishCatId);
		int commnendShould = 0;
//		<option value="0">不推荐</option>
//	   	  <option value="1">首页大图</option>
//	      <option value="2">首页特约模特</option>
//	      <option value="3">首页特约摄影师</option>
//	      <option value="4">首页摄影图片</option>
//	      <option value="5">首页创意图片</option>
//	      <option value="6">摄影图片页面大图</option>
//	      <option value="7">创意图片页面大图</option>
//	      <option value="8">商业约拍页面大图</option>
//	      <option value="9">摄影故事页面大图</option>
//	      <option value="10">特约摄影页面师大图</option>
//	      <option value="11">特约模特页面大图</option>
	      if(publishCatType.contentEquals("originality")){
	    	  commnendShould = 7;
	      }else if(publishCatType.contentEquals("photography")){
	    	  commnendShould = 6;
	      }else if(publishCatType.contentEquals("story")){
	    	  commnendShould = 9;
	      }
		
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();//publishTime

			StringBuffer totalHql = new StringBuffer() ;
			totalHql.append("select distinct publish from PublishCat_Publish as PublishCat_Publish where ");
			int start = 0;
			
			totalHql.append(" ( ") ;
			for(PublishCat publishcat : publisCats ){
				if(start == 0){
					totalHql.append(" PublishCat_Publish.publishCat.id = "
							  + publishcat.getId());
					start++;
				}else{
					totalHql.append(" or PublishCat_Publish.publishCat.id = "
							  + publishcat.getId());
				}
				
			}
			totalHql.append(" ) ") ;
			
			totalHql.append(" and PublishCat_Publish.publish.commend = " + commnendShould) ;
			totalHql.append(" order by PublishCat_Publish.publish.id desc ") ;
			
			Query queryObjectCount = session.createQuery( totalHql.toString());
			List<Publish> listPublishCount   = (List<Publish>)queryObjectCount.list();		    
			publish = listPublishCount.get(0);
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

		
		return publish ;		
	}
	
	@SuppressWarnings("unchecked")
	public Publish homePageMainPic(){
		Publish publish = null;
//	   	  <option value="1">首页大图</option>
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();//publishTime

			StringBuffer totalHql = new StringBuffer() ;
			totalHql.append("select distinct new Publish(p.id,p.name,p.biggerPic) from Publish as p where commend = 1  order by publishTime desc  LIMIT 0,6");
			
			Query queryObjectCount = session.createQuery( totalHql.toString());
			List<Publish> listPublishCount   = (List<Publish>)queryObjectCount.list();		   
			if (listPublishCount.size() < 1) {
				publish =null;
			}else {
				publish = listPublishCount.get(0);
			}
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
		return publish ;		
	}

    
	public List<Publish>  homePageMainPicNew(){
		List<Publish> listPublishCount  = null;
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
	}
	public List<Publish>  modelPic(){
		List<Publish> listPublishCount  = null;
//	   	  <option value="1">首页大图</option>
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();//publishTime

			StringBuffer totalHql = new StringBuffer() ;
			totalHql.append("select distinct new Publish(p.id,p.user,p.thumbnailUrl) from Publish as p where commend = 2  order by publishTime desc  LIMIT 0,2");
			
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
	}
	public List<Publish>  photographyPic(){
		List<Publish> listPublishCount  = null;
//	   	  <option value="1">首页大图</option>
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();//publishTime

			StringBuffer totalHql = new StringBuffer() ;
			totalHql.append("select distinct new Publish(p.id,p.user,p.thumbnailUrl) from Publish as p where commend = 3  order by publishTime desc  LIMIT 0,2");
			
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
	}


	@SuppressWarnings("unchecked")
	public Publish getMainPicOfTopPublishCat(final List<PublishCat>  publishCats , final int commnendShould){
		Publish publish = null;
		
//		Integer publishCatId = this.getPublishCatIdByType(publishCatType);
//		List<PublishCat>  publishCats = publishCatDao.getLevel2PublishCatsUnderProjectCat(publishCatId);
//		int commnendShould = 0;
//		<option value="0">不推荐</option>
//	   	  <option value="1">首页大图</option>
//	      <option value="2">首页特约模特</option>
//	      <option value="3">首页特约摄影师</option>
//	      <option value="4">首页摄影图片</option>
//	      <option value="5">首页创意图片</option>
//	      <option value="6">摄影图片页面大图</option>
//	      <option value="7">创意图片页面大图</option>
//	      <option value="8">商业约拍页面大图</option>
//	      <option value="9">摄影故事页面大图</option>
//	      <option value="10">特约摄影页面师大图</option>
//	      <option value="11">特约模特页面大图</option>
//	      if(publishCatType.contentEquals("originality")){
//	    	  commnendShould = 7;
//	      }else if(publishCatType.contentEquals("photography")){
//	    	  commnendShould = 6;
//	      }else if(publishCatType.contentEquals("story")){
//	    	  commnendShould = 9;
//	      }
		
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();//publishTime

			StringBuffer totalHql = new StringBuffer() ;
			totalHql.append("select distinct publish from PublishCat_Publish as PublishCat_Publish where ");
			int start = 0;
			
			totalHql.append(" ( ") ;
			for(PublishCat publishcat : publishCats ){
				if(start == 0){
					totalHql.append(" PublishCat_Publish.publishCat.id = "
							  + publishcat.getId());
					start++;
				}else{
					totalHql.append(" or PublishCat_Publish.publishCat.id = "
							  + publishcat.getId());
				}
				
			}
			totalHql.append(" ) ") ;
			
			
			totalHql.append(" and PublishCat_Publish.publish.commend = " + commnendShould) ;
			totalHql.append(" order by PublishCat_Publish.publish.id desc ") ;
			
			Query queryObjectCount = session.createQuery( totalHql.toString());
			List<Publish> listPublishCount   = (List<Publish>)queryObjectCount.list();		    
			publish = listPublishCount.get(0);
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

		
		return publish ;		
	}



	@SuppressWarnings("unchecked")
	public Pager newestUploadedPicUnderTopPublishCat(final String publishCatType ,final int pageSize,final int pageNo)  {
		Integer publishCatId = this.getPublishCatIdByType(publishCatType);
//		List<PublishCat>  publisCats = publishCatDao.getPublishCatListUnderProjectCat(publishCatId);
		List<PublishCat>  publisCats = publishCatDao.getLevel2PublishCatsUnderProjectCat(publishCatId);
		Pager pager = null;	
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();//publishTime

			StringBuffer totalHql = new StringBuffer() ;
			totalHql.append("select distinct publish from PublishCat_Publish as PublishCat_Publish where ");
			int start = 0;
			
			for(PublishCat publishcat : publisCats ){
				if(start == 0){
					totalHql.append(" PublishCat_Publish.publishCat.id = "
							  + publishcat.getId());
					start++;
				}else{
					totalHql.append(" or PublishCat_Publish.publishCat.id = "
							  + publishcat.getId());
				}
				
			}
			totalHql.append(" order by PublishCat_Publish.publish.id desc ") ;
			
			int countInt = 0;
//			for(PublishCat publishcat : publisCats ){
//				String hql = "select distinct count(publish) from PublishCat_Publish as PublishCat_Publish where PublishCat_Publish.publishCat.id = "+ publishcat.getId();
//				Long countLong = (java.lang.Long) session.createQuery(hql).uniqueResult();
//				int c = countLong.intValue();
//				countInt = countInt + c ;
//			}
			Query queryObjectCount = session.createQuery( totalHql.toString());
			List<Publish> listPublishCount   = (List<Publish>)queryObjectCount.list();		    
			countInt = VideoDaoImpl.rowCount = listPublishCount.size() ;
			
			
			
			
			
			
			Query queryObject = session.createQuery( totalHql.toString());
			    
			queryObject.setFirstResult(pageSize * (pageNo - 1));
			queryObject.setMaxResults(pageSize);
//			List<PublishCat_Publish> list  = (List<PublishCat_Publish>)queryObject.list();		    
//		    List<Publish> listPublish = new ArrayList<Publish>();
//			for(PublishCat_Publish publishCat_Publish : list){
//		    	listPublish.add(this.select(publishCat_Publish.getPublish().getId()));
//		    }
			List<Publish> listPublish   = (List<Publish>)queryObject.list();		    
		    
		    
		    pager = new Pager(pageSize, pageNo, VideoDaoImpl.rowCount, listPublish);
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
	

	@SuppressWarnings("unchecked")
	public Pager newestUploadedPicUnderTopPublishCat(final List<PublishCat>  publishCats ,final int pageSize,final int pageNo)  {
//		Integer publishCatId = this.getPublishCatIdByType(publishCatType);
////		List<PublishCat>  publisCats = publishCatDao.getPublishCatListUnderProjectCat(publishCatId);
//		List<PublishCat>  publishCats = publishCatDao.getLevel2PublishCatsUnderProjectCat(publishCatId);
		Pager pager = null;	
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();//publishTime

			StringBuffer totalHql = new StringBuffer() ;
			totalHql.append("select distinct publish from PublishCat_Publish as PublishCat_Publish where ");
			int start = 0;
			
			for(PublishCat publishcat : publishCats ){
				if(start == 0){
					totalHql.append(" PublishCat_Publish.publishCat.id = "
							  + publishcat.getId());
					start++;
				}else{
					totalHql.append(" or PublishCat_Publish.publishCat.id = "
							  + publishcat.getId());
				}
				
			}
			totalHql.append(" order by PublishCat_Publish.publish.id desc ") ;
			
			int countInt = 0;
//			for(PublishCat publishcat : publisCats ){
//				String hql = "select distinct count(publish) from PublishCat_Publish as PublishCat_Publish where PublishCat_Publish.publishCat.id = "+ publishcat.getId();
//				Long countLong = (java.lang.Long) session.createQuery(hql).uniqueResult();
//				int c = countLong.intValue();
//				countInt = countInt + c ;
//			}
			Query queryObjectCount = session.createQuery( totalHql.toString());
			List<Publish> listPublishCount   = (List<Publish>)queryObjectCount.list();		    
			countInt = VideoDaoImpl.rowCount = listPublishCount.size() ;
			
			
			
			
			
			
			Query queryObject = session.createQuery( totalHql.toString());
			    
			queryObject.setFirstResult(pageSize * (pageNo - 1));
			queryObject.setMaxResults(pageSize);
//			List<PublishCat_Publish> list  = (List<PublishCat_Publish>)queryObject.list();		    
//		    List<Publish> listPublish = new ArrayList<Publish>();
//			for(PublishCat_Publish publishCat_Publish : list){
//		    	listPublish.add(this.select(publishCat_Publish.getPublish().getId()));
//		    }
			List<Publish> listPublish   = (List<Publish>)queryObject.list();		    
		    
		    
		    pager = new Pager(pageSize, pageNo, VideoDaoImpl.rowCount, listPublish);
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
	
	
	
	@SuppressWarnings("unchecked")
	public Pager searchUnderTopPublishCat(final String publishCatType ,final String[] searchKeys, final int pageSize,final int pageNo)  {
		Pager pager = null;	
		
		Integer publishCatId = this.getPublishCatIdByType(publishCatType);
		List<PublishCat>  publisCats = publishCatDao.getLevel2PublishCatsUnderProjectCat(publishCatId);
		
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();//publishTime
			
			StringBuffer totalHql = new StringBuffer() ;
			//totalHql.append("select distinct Publish.smallPic,Publish.biggerPic,Publish.id,Publish.tags " +
			totalHql.append("select distinct publish " +
									"from PublishCat_Publish as PublishCat_Publish where  ");
			
			totalHql.append(" ( ") ;
			int start = 0;		
			for(PublishCat publishcat : publisCats ){
				if(start == 0){
					totalHql.append(" PublishCat_Publish.publishCat.id = "
							  + publishcat.getId());
					start++;
				}else{
					totalHql.append(" or PublishCat_Publish.publishCat.id = "
							  + publishcat.getId());
				}
				
			}
			totalHql.append(" ) ") ;
			
			
//			totalHql.append(" ( ");			
//			int start = 0;			
//			for(PublishCat publishcat : publisCats ){
//				if(start == 0){
//					totalHql.append(" Publish.publishCat.id = " + publishcat.getId());
//					start++;
//				}else{
//					totalHql.append(" or Publish.publishCat.id = "  + publishcat.getId());
//				}
//			}			
//			totalHql.append(" ) and  ");
//			
			
			totalHql.append("  and  ( ");			
			int startKey = 0;
			for(String key : searchKeys){
				if(startKey == 0){
					totalHql.append("    PublishCat_Publish.publish.name like '%" + key +  "%'"  ) ;
					totalHql.append(" or PublishCat_Publish.publish.content like '%" + key +  "%'"  ) ;
					totalHql.append(" or PublishCat_Publish.publish.tags like '%" + key +  "%'"  ) ;
					startKey++;
				}else{
					totalHql.append(" or PublishCat_Publish.publish.name like '%" + key +  "%'"  ) ;
					totalHql.append(" or PublishCat_Publish.publish.content like '%" + key +  "%'"  ) ;
					totalHql.append(" or PublishCat_Publish.publish.tags like '%" + key +  "%'"  ) ;
				}
			}
			
			totalHql.append(" ) ");
			
			totalHql.append(" order by PublishCat_Publish.publish.id desc ") ;
			
			Query queryObjectCount = session.createQuery( totalHql.toString());
			List<Publish> listPublishCount   = (List<Publish>)queryObjectCount.list();		    
			VideoDaoImpl.rowCount = listPublishCount.size() ;
			
			Query queryObject = session.createQuery( totalHql.toString());
			    
			queryObject.setFirstResult(pageSize * (pageNo - 1));
			queryObject.setMaxResults(pageSize);
			List<Publish> listPublish   = (List<Publish>)queryObject.list();		    
		    
		    pager = new Pager(pageSize, pageNo, VideoDaoImpl.rowCount, listPublish);
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
	
	@SuppressWarnings("unchecked")
	public List<Publish> publishByFirImage() {
		// TODO Auto-generated method stub
		List<Publish> list=getHibernateTemplate().find("select publish.picture,publish.id,publish.picUrl From Publish as publish where " +
				"(publish.positionShould =1 and publish.status=1) or (publish.positionShould =2 and publish.status=1) or " +
				"(publish.positionShould =3 and publish.status=1) or (publish.positionShould =4 and publish.status=1) or " +
				"(publish.positionShould =5 and publish.status=1) or (publish.positionShould =1 and publish.status=4) or " +
				"(publish.positionShould =2 and publish.status=4) or (publish.positionShould =3 and publish.status=4) or " +
				"(publish.positionShould =4 and publish.status=4) or (publish.positionShould =5 and publish.status=4)");
		return list;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Publish> publishBySecImage() {
		// TODO Auto-generated method stub
		List<Publish> list=getHibernateTemplate().find
		("select publish.picture,publish.id,publish.picUrl From Publish as publish where " +
				"(publish.positionShould =6 and publish.status=1) or (publish.positionShould =7 and publish.status=1) or " +
				"(publish.positionShould =8 and publish.status=1) or (publish.positionShould =9 and publish.status=1) or " +
				"(publish.positionShould =10 and publish.status=1) or (publish.positionShould =6 and publish.status=4) or " +
				"(publish.positionShould =7 and publish.status=4) or (publish.positionShould =8 and publish.status=4) or " +
				"(publish.positionShould =9 and publish.status=4) or (publish.positionShould =10 and publish.status=4)");
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<Publish> publishByName() {
		// TODO Auto-generated method stub
		List<Publish> list=getHibernateTemplate().find("select publish.name,publish.id From Publish as publish where  publish.status =4 order by id desc");
		List tempList=new ArrayList();
		tempList.add(0,null);
		for (int i = 0; i < list.size(); i++) {
			tempList.add(list.get(i));
		}
		return tempList;
	}
	
	
	
	
	public List<Publish> publishByUser(User user) {
		// TODO Auto-generated method stub

		List list=getHibernateTemplate().find("select id,fixwidthUrl from Publish as publish where publish.status!=6 and publish.user="+user.getId());
		return list;
	}
	

	@SuppressWarnings("unchecked")
	public List<Publish> getPublishListBycatId(String catId) {
		 List<PublishCat> publishCatList = getHibernateTemplate().find("from PublishCat where id = " +catId);
		 PublishCat publishCat = null;
		 List<Publish> list = null;
		 if(publishCatList != null && publishCatList.size() > 0){
			 publishCat = publishCatList.get(0);
			 DetachedCriteria criteria = DetachedCriteria.forClass(Publish.class);
			 criteria.add(Expression.eq("publishCat", publishCat));
			 criteria.addOrder(Order.desc("hit"));
			 list = this.getHibernateTemplate().findByCriteria(criteria);
		 }
		return list;
	}
	
	
	public Pager getPublishListBycatId(final Integer  catId, final int pageSize, final int pageNo) {
		
		List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
			//HibernateCallback
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
			
				Criteria criteria = session.createCriteria(Publish.class);
				PublishCat publishCat = publishCatDao.select(catId);
				criteria.add(Expression.eq("publishCat",publishCat));
				VideoDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
				criteria.setProjection(null);
				criteria.setFirstResult(pageSize * (pageNo - 1));
				criteria.setMaxResults(pageSize);
				List<?> result = criteria.list();
				
				return result;
			}
		});
		
		Pager pager = new Pager(pageSize, pageNo, VideoDaoImpl.rowCount, list);
		return pager;
	   
	}
	
	
    //推荐项目
	public List<Publish> getRecommendPublishUnderCat(String pubCatId) {
		// TODO Auto-generated method stub
		PublishCat publishCat = (PublishCat)getHibernateTemplate().find("from PublishCat where id = " + pubCatId).get(0);
		DetachedCriteria criteria = DetachedCriteria.forClass(Publish.class);
		criteria.add(Expression.eq("publishCat", publishCat));
		criteria.add(Expression.eq("status", 4));
		criteria.addOrder(Order.desc("hit"));
		List<Publish> list = this.getHibernateTemplate().findByCriteria(criteria);
		return list;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Publish> NameByCat(int id) {
		// TODO Auto-generated method stub
		PublishCat publishCat = (PublishCat)getHibernateTemplate().find("from PublishCat where id = " +id).get(0);
		DetachedCriteria criteria = DetachedCriteria.forClass(Publish.class);
		criteria.add(Expression.eq("publishCat", publishCat));
		List<Publish> list=this.getHibernateTemplate().findByCriteria(criteria);
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<Publish> ChangeImage() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Publish.class);
		criteria.addOrder(Order.desc("hit"));
		List<Publish> list = this.getHibernateTemplate().findByCriteria(criteria, 0, 6);
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<Publish> ChangeImages() {
		String alias="publish";
		DetachedCriteria dc=DetachedCriteria.forClass(Publish.class, alias);
		dc.addOrder(Order.desc("hit"));
		ProjectionList projectionList=Projections.projectionList();
		projectionList.add(Projections.property(alias+"."+"id").as("id"));
		projectionList.add(Projections.property(alias+"."+"name").as("name"));
		projectionList.add(Projections.property(alias+"."+"smallPic").as("smallPic"));
		projectionList.add(Projections.property(alias+"."+"biggerPic").as("biggerPic"));
		dc.setProjection(projectionList);
		dc.setResultTransformer(Transformers.aliasToBean(Publish.class));
		List<Publish> list = this.getHibernateTemplate().findByCriteria(dc,0,6);
		
//		Session session=SessionFactory.
//		Query query=session.createQuery("select new Publish(id,name,smallPic,biggerPic) from Publish order by hit desc");
//		query.setFirstResult(0);
//		query.setMaxResults(6);
//		List<Publish> list = query.list();
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<Publish> test() {
		// TODO Auto-generated method stub
		List<Publish> list=getHibernateTemplate().find
		("select publish.id,publish.picUrl From Publish as publish order by publish.hit desc");
		
		return list;
	}
	public static void main(String[] args) {
		List<Publish> publishs=new VideoDaoImpl().test();
		for (int i = 0; i < publishs.size(); i++) {
			System.out.println(publishs.get(i).getName());
		}
	}
	
	public Pager ImgChange(final int pageSize,final int pageNo)  {	
		Pager pager = null;	
		//??????HibernateCallback
		List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
			//???HibernateCallback
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				//???Hibernate
				//List result = session.createQuery(hql).setParameter(0, value).setFirstResult(offset).setMaxResults(pageSize).list();
				Query query=session.createQuery("select new Publish(id,name,smallPic,biggerPic) from Publish order by hit desc");  
				query.setMaxResults(pageSize);
				query.setFirstResult((pageNo - 1) * pageSize);
				return query.list();
			}
		});
		pager = new Pager(pageSize, pageNo, VideoDaoImpl.rowCount, list);
		return pager;
	
	}

	public Pager ImgChangeByCat3(final Integer catId,final int pageSize,final int pageNo) {
		Pager pager = null;	
		//??????HibernateCallback
		List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
			//???HibernateCallback
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				//???Hibernate
				//List result = session.createQuery(hql).setParameter(0, value).setFirstResult(offset).setMaxResults(pageSize).list();
				Criteria criteria = session.createCriteria(Publish.class);
				VideoDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
				criteria.setProjection(null);
				PublishCat publishCat = publishCatDao.select(catId);
				criteria.add(Expression.eq("publishCat",publishCat));
				criteria.setMaxResults(pageSize);
				criteria.setFirstResult((pageNo - 1) * pageSize);
				return criteria.list();
				
			}
		});
		pager = new Pager(pageSize, pageNo, VideoDaoImpl.rowCount, list);
		//问题：rowCount没有解决
		return pager;
	}
	
	public Pager ImgChangeByCat(final Integer catId,final int pageSize,final int pageNo) {
		Pager pager = null;	
		//??????HibernateCallback
		List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
			//???HibernateCallback
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				String sql="select p.id,p.name,p.smallPic,p.biggerPic from Publish p where p.publishCatid="+catId+" order by p.hit desc";
				return session.createSQLQuery(sql)
				.setMaxResults(pageSize)
				.setFirstResult((pageNo - 1) * pageSize)
				.setResultTransformer(Transformers.aliasToBean(Publish.class)).list();
			}
		});
		pager = new Pager(pageSize, pageNo, VideoDaoImpl.rowCount, list);
		return pager;
	}

	
	public Pager userAlbumnBySpecial(final PublishSpecialCat publishSpecialCat1,final int pageSize,final int pageNo) {
		Pager pager = null;	
		//??????HibernateCallback
		List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
			//???HibernateCallback
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				*//**
				 * Criteria criteria = session.createCriteria(Bid.class);
			User user=userService.select(username);
			criteria.add(Restrictions.eq("user", user));
			criteria.add(Restrictions.not(Restrictions.eq("status", 2)));
			BidDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
			criteria.setProjection(null);
			criteria.setFirstResult(pageSize * (pageNo - 1));
			criteria.setMaxResults(pageSize);
			List<?> result = criteria.list();
				 *//*
				Criteria criteria=session.createCriteria(Publish.class);
				PublishSpecialCat publishSpecialCat =publishSpecialCatDao.select(publishSpecialCat1.getId());
				criteria.add(Restrictions.eq("publishSpecialCat",publishSpecialCat));
				criteria.add(Restrictions.not(Restrictions.eq("status", 6)));
				VideoDaoImpl.rowCount=((Integer)criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
				criteria.setProjection(null);
				criteria.setFirstResult(pageSize * (pageNo - 1));
				criteria.setMaxResults(pageSize);
				List<?> result = criteria.list();
				return result;
			}
		});
		pager = new Pager(pageSize, pageNo, VideoDaoImpl.rowCount, list);
		return pager;
	}
	
	public List<Publish> findByPublishSpecialId( PublishSpecialCat publishSpecialCat) {
		// TODO Auto-generated method stub
		String queryString = "from Publish as publish where publish.publishSpecialCat.id = " + publishSpecialCat.getId()+" and publish.status !=6 order by id desc";
		try {
			List<Publish> list=this.getHibernateTemplate().find(queryString);
			if (list.size()==0) {
				return null;
			}else {
				return list;	
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
		
	}


	

	public VideoCat_VideoDao getPublishCat_PublishDao() {
		return publishCat_PublishDao;
	}

	public void setPublishCat_PublishDao(VideoCat_VideoDao publishCatPublishDao) {
		publishCat_PublishDao = publishCatPublishDao;
	}
	
	
	

	@SuppressWarnings("unchecked")
	public List<Publish> selectByFrontPage(final String type,final int pageNo,final int pageSize ) {
		try{
		List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
			//???HibernateCallback
			public Object doInHibernate(Session session) throws HibernateException, SQLException {


				String queryString = " from Publish as publish where "; 
				//publish.commend=1 and publish.status>=2   order by  publish.id desc";
				if ("meirituijian".equals(type)) {
					queryString=queryString+"publish.commend=1 and publish.status>=2   order by  publish.id desc";
				}
				if("chuangyitupian".equals(type)){
					queryString=queryString + " publish.commend=5";
					
					
				}
				if("sheyingtuypian".equals(type)){
					queryString=queryString + " publish.commend=4";
				}
				queryString=queryString+" and publish.status>=2   order by  publish.id desc";
				return session.createQuery(queryString)
				.setMaxResults(pageSize)
				.setFirstResult((pageNo - 1) * pageSize).list();
			}
		});
		
		return 	list;//
		}catch (Exception e) {
		e.printStackTrace();
		return 	null;//
		}
		//this.getHibernateTemplate().find(queryString);
	}
	
	
	@SuppressWarnings("unchecked")
	public List<?> selectSellerMsg(final int userId) {
		try{
		List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
			//???HibernateCallback
			public Object doInHibernate(Session session) throws HibernateException, SQLException {


   	              String queryString="SELECT u.username,p.name, buyc.startTime FROM BuyCommodities  buyc,BuyCartDeal  buyh ,Publish p ,user u WHERE buyc.buyCartDealid=buyh.id and p.id= buyc.publish_ AND u.id=buyh.user_ AND buyc.publish_ IN(SELECT id FROM  Publish WHERE user_="+userId+") ORDER BY buyc.startTime DESC";		
	 			return session.createSQLQuery(queryString)
				.setMaxResults(10)
				.setFirstResult(0).list();
			}
		});
		
		return 	list;//
		}catch (Exception e) {
		e.printStackTrace();
		return 	null;//
		}
		//this.getHibernateTemplate().find(queryString);
	}
	
	
	@SuppressWarnings("unchecked")
	public List<?> selectBuyMsg(final int userId) {
		try{
		List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
			//???HibernateCallback
			public Object doInHibernate(Session session) throws HibernateException, SQLException {


   	              String queryString="SELECT u.username,p.name,  buyc.startTime FROM " +
   	              		"BuyCommodities  buyc LEFT JOIN BuyCartDeal  buyh ON buyc.buyCartDealid=buyh.id "+
                        "LEFT JOIN Publish p on p.id= buyc.publish_ LEFT JOIN user u ON u.id=buyh.user_ WHERE buyh.user_=" +userId+
                        " ORDER BY buyc.startTime DESC";		
	 			return session.createSQLQuery(queryString)
				.setMaxResults(10)
				.setFirstResult(0).list();
			}
		});
		
		return 	list;//
		}catch (Exception e) {
		e.printStackTrace();
		return 	null;//
		}
		//this.getHibernateTemplate().find(queryString);
	}

	public List<Publish> findResemble(String tags) {
		String queryString = "from Publish as publish where publish.tags like '%" + tags+"%' order by id desc";
		try {
			List<Publish> list=this.getHibernateTemplate().find(queryString);
			if (list.size()==0) {
				return null;
			}else {
				return list;	
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	*/
}//end class

