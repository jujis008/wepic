package com.wetuo.wepic.publish.dao ;
 
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
 
import org.hibernate.Criteria;
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
import com.sun.istack.internal.FinalArrayList;
import com.sun.org.apache.xml.internal.security.encryption.Transforms;
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.hibernate.XgHibernateCommonDao;
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.core.dao.UserDao;
import com.wetuo.wepic.publish.beans.Publish;
import com.wetuo.wepic.publish.beans.PublishSpecialCat;
import com.wetuo.wepic.publish.beans.Story;

import org.springframework.orm.hibernate3.HibernateCallback;
import java.sql.SQLException;
 
public class StoryDaoImpl extends XgHibernateCommonDao implements StoryDao {
	private static Log log = LogFactory.getLog(StoryDaoImpl.class);
	private static int rowCount = 0;
	private UserDao userDao ;//= new UserDaoImpl();
	private PublishCatDao publishCatDao ;
	private PublishCat_StoryDao publishCat_storyDao ;
	private PublishSpecialCatDao publishSpecialCatDao;

	public PublishSpecialCatDao getPublishSpecialCatDao() {
		return publishSpecialCatDao;
	}

	public void setPublishSpecialCatDao(PublishSpecialCatDao publishSpecialCatDao) {
		this.publishSpecialCatDao = publishSpecialCatDao;
	}

	public PublishCat_StoryDao getPublishCat_storyDao() {
		return publishCat_storyDao;
	}

	public void setPublishCat_storyDao(PublishCat_StoryDao publishCatStoryDao) {
		publishCat_storyDao = publishCatStoryDao;
	}

	public PublishCatDao getPublishCatDao() {
		return publishCatDao;
	}

	public void setPublishCatDao(PublishCatDao publishCatDao) {
		this.publishCatDao = publishCatDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public boolean delete(Story record)  {
		getHibernateTemplate().delete(record);
		return true;
	}//end delete()
			
	public boolean delete(Integer id)  {
		try {
			Object obj = getHibernateTemplate().load(Story.class,new Integer(id));
			getHibernateTemplate().delete(obj);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}//end delete()

	public List<Story> findAll() {
		return (List<Story>)getHibernateTemplate().find("from Story");
	}

	public List<Story> findPart(String strFields, String[] strArrValues) {
		return (List<Story>)getHibernateTemplate().find("from Story where "+strFields, strArrValues);
	}
	public Integer total(Integer uId) {
		List<Story> stories=getHibernateTemplate().find("from Story story where story.user.id="+uId);
		return stories.size();
	}


	public Pager searchbyspecial(final User user, final PublishSpecialCat specialCat,final int pageSize,final int pageNo) {
		Pager pager = null;	
		List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(Story.class);
				StoryDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
				criteria.setProjection(null);
				
				criteria.add(Expression.eq("user",user));
				criteria.add(Expression.eq("publishSpecialCat",specialCat));
				criteria.setFirstResult(pageSize * (pageNo - 1));
				criteria.setMaxResults(pageSize);
				criteria.addOrder(Order.desc("id"));
				List<?> result = criteria.list();
				return result;
			}
		});
		pager = new Pager(pageSize, pageNo, StoryDaoImpl.rowCount, list);
		return pager;
	
	}//end list()
	
//	public Pager findStoryByUser(final User user, final int pageSize,final int pageNo) {
//		Integer publishCatId = this.getPublishCatIdByType(publishCatType);
//		List<PublishCat>  publisCats = publishCatDao.getLevel2PublishCatsUnderProjectCat(publishCatId);
//		Pager pager = null;	
//		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
//		Transaction tx = null;
//		try{
//			tx = session.beginTransaction();//publishTime
//
//			StringBuffer totalHql = new StringBuffer() ;
//			totalHql.append("select distinct publish from PublishCat_Publish as PublishCat_Publish where ");
//			int start = 0;
//			
//			for(PublishCat publishcat : publisCats ){
//				if(start == 0){
//					totalHql.append(" PublishCat_Publish.publishCat.id = "
//							  + publishcat.getId());
//					start++;
//				}else{
//					totalHql.append(" or PublishCat_Publish.publishCat.id = "
//							  + publishcat.getId());
//				}
//				
//			}
//			totalHql.append(" order by PublishCat_Publish.publish.id desc ") ;
//			
//			int countInt = 0;
//			Query queryObjectCount = session.createQuery( totalHql.toString());
//			List<Publish> listPublishCount   = (List<Publish>)queryObjectCount.list();		    
//			countInt = PublishDaoImpl.rowCount = listPublishCount.size() ;
//			
//			
//			
//			
//			
//			
//			Query queryObject = session.createQuery( totalHql.toString());
//			    
//			queryObject.setFirstResult(pageSize * (pageNo - 1));
//			queryObject.setMaxResults(pageSize);
//			List<Publish> listPublish   = (List<Publish>)queryObject.list();		    
//		    
//		    
//		    pager = new Pager(pageSize, pageNo, PublishDaoImpl.rowCount, listPublish);
//		    tx.commit();
//		}catch(RuntimeException e){
//			if(tx != null){
//				tx.rollback();
//			}
//			e.printStackTrace();
//		}finally{
//			if(session.isOpen()){ 
//				releaseSession(session);  
//			} 
//		}
//		return pager;
//	}
	
	
	
	public Pager findStoryByUser(final User user, final int pageSize,final int pageNo) {
		Pager pager = null;	
		List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				//未发布,审核中,审核通过,审核不通过,自己下架,管理员下架,版权被买断
				/**
				 * private int unreleased;//未发布 0未发布1已发布
    private int awaitingReview;//1审核中0初始状态
    private int noPass;//0初始状态 1是不通过
    private int pass;// 0 初始状态 1 审核通过
    private int justShow;//0初始化状态1仅展示
    private int onOffer;//0是初始化状态1是销售中
    private int copyrightBuyout;//0初始化状态 1版权被买断
    private int userSoldout;//0初始化状态 1用户自己下架
    private int adminSoldout;//0 1,管理员给作品下架
    private int publishToStroy;//0 1发布到摄影故事
    private int userDelete;//0初始状态 1用户自己删除
    private int adminDelete;//0初始化状态1 管理员删除
    private int publishorstory;//0 初始化状态publish 1 story
    
    Criteria criteria = session.createCriteria(Story.class);
				StoryDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
				criteria.setProjection(null);
				criteria.createAlias("publishStatus","publishStatus");
				
				criteria.add(Restrictions.or(Restrictions.ne("publishStatus.unreleased",0), Restrictions.ne("publishStatus.awaitingReview",0)));
				criteria.setFirstResult(pageSize * (pageNo - 1));
				criteria.setMaxResults(pageSize);
				List<?> result = criteria.list();
				 */
				Criteria criteria = session.createCriteria(Story.class);
				StoryDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
				criteria.setProjection(null);
				//criteria.createAlias("publishStatus","publishStatus");
				criteria.add(Expression.eq("user",user));
				criteria.add(Restrictions.eq("publishStatus.unreleased", 1));
				
//						Restrictions.or(Restrictions.eq("publishStatus.awaitingReview", 1),Restrictions.or(Restrictions.eq("publishStatus.noPass",1),
//					    Restrictions.or(Restrictions.eq("publishStatus.pass", 1), Restrictions.or(Restrictions.eq("publishStatus.copyrightBuyout", 1),
//					    Restrictions.or(Restrictions.eq("publishStatus.userSoldout",1),Restrictions.eq("publishStatus.adminSoldout", 1))))))));
				criteria.setFirstResult(pageSize * (pageNo - 1));
				criteria.setMaxResults(pageSize);
				criteria.addOrder(Order.desc("id"));
				List<?> result = criteria.list();
				return result;
			}
		});
		pager = new Pager(pageSize, pageNo, StoryDaoImpl.rowCount, list);
		return pager;
	
	}//end list()

	public Pager findStoryByUserAndSpecial(final User user,final PublishSpecialCat publishSpecialCat, final int pageSize,final int pageNo) {
		Pager pager = null;	
		List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(Story.class);
				StoryDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
				criteria.setProjection(null);
				
				criteria.add(Expression.eq("user",user));
				criteria.add(Expression.eq("publishSpecialCat",publishSpecialCat));
				criteria.setFirstResult(pageSize * (pageNo - 1));
				criteria.setMaxResults(pageSize);
				criteria.addOrder(Order.desc("id"));
				List<?> result = criteria.list();
				return result;
			}
		});
		pager = new Pager(pageSize, pageNo, StoryDaoImpl.rowCount, list);
		return pager;
	
	}//end list()
	public Integer insert(Story record) {
		Integer integerRet = null; 
		return (Integer)getHibernateTemplate().save(record);
	}

	public List<Story> storybyuserandspecial(Integer uid,Integer specialId){
		DetachedCriteria dc = DetachedCriteria.forClass(Story.class,"story");
		   dc.add(Restrictions.eq("story.user.id", uid));// 其中username 为User class里面的属性
		   dc.add(Restrictions.eq("story.publishSpecialCat.id", specialId));   
		   List list=this.getHibernateTemplate().findByCriteria(dc);
		   return list;

	}
	
	public List<Story> storychecksucbyspecial(Integer specialId){
		DetachedCriteria dc = DetachedCriteria.forClass(Story.class,"story");
		dc.createAlias("story.publishStatus", "publishStatus");
		   dc.add(Restrictions.eq("story.publishSpecialCat.id", specialId));
		   dc.add(Restrictions.eq("publishStatus.onOffer", 1));
		   dc.add(Restrictions.eq("publishStatus.pass", 1));
		   List list=this.getHibernateTemplate().findByCriteria(dc);
		   return list;

	}
	public List<Story> storyadminsoldoutbyspecial(Integer specialId){
		DetachedCriteria dc = DetachedCriteria.forClass(Story.class,"story");
		dc.createAlias("story.publishStatus", "publishStatus");
		   dc.add(Restrictions.eq("story.publishSpecialCat.id", specialId));
		   dc.add(Restrictions.eq("publishStatus.adminSoldout", 1));
		   List list=this.getHibernateTemplate().findByCriteria(dc);
		   return list;

	}
	
	public List<Story> userdel(){
		DetachedCriteria dc = DetachedCriteria.forClass(Story.class,"story");
		dc.createAlias("story.publishStatus", "publishStatus");
		dc.add(Restrictions.eq("publishStatus.userDelete", 1));
		dc.add(Restrictions.eq("publishStatus.publishorstory", 1));
		List list=this.getHibernateTemplate().findByCriteria(dc);
		return list;
	}
	public List<Story> admindel(){
		DetachedCriteria dc = DetachedCriteria.forClass(Story.class,"story");
		dc.createAlias("story.publishStatus", "publishStatus");
		dc.add(Restrictions.eq("publishStatus.adminDelete", 1));
		dc.add(Restrictions.eq("publishStatus.publishorstory", 1));
		List list=this.getHibernateTemplate().findByCriteria(dc);
		return list;
	}
	public Pager list(final int pageSize,final int pageNo)  {	
		Pager pager = null;	
		//HibernateCallback
		List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
			//HibernateCallback
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				//Hibernate
				//List result = session.createQuery(hql).setParameter(0, value).setFirstResult(offset).setMaxResults(pageSize).list();
				Criteria criteria = session.createCriteria(Story.class);
				StoryDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
				criteria.setProjection(null);
				criteria.setFirstResult(pageSize * (pageNo - 1));
				criteria.setMaxResults(pageSize);
				List<?> result = criteria.list();
				return result;
			}
		});
		pager = new Pager(pageSize, pageNo, StoryDaoImpl.rowCount, list);
		return pager;
	
	}//end list()

	public Pager list(final String username,final int pageSize,final int pageNo)  {	
		Pager pager = null;	
		//??????HibernateCallback
		List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
			//???HibernateCallback
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				//???Hibernate
				//List result = session.createQuery(hql).setParameter(0, value).setFirstResult(offset).setMaxResults(pageSize).list();
				Criteria criteria = session.createCriteria(Story.class);
				StoryDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
				criteria.setProjection(null);
				
				//User user = userDao.select(username);
				User user = null;
				criteria.add(Expression.eq("user",user));
				criteria.setFirstResult(pageSize * (pageNo - 1));
				criteria.setMaxResults(pageSize);
				criteria.addOrder(Order.desc("id"));
				List<?> result = criteria.list();
				return result;
			}
		});
		pager = new Pager(pageSize, pageNo, StoryDaoImpl.rowCount, list);
		return pager;
	
	}//end list()

	public Pager list(final Map<String,Object> mapSqlParam,final int pageSize,final int pageNo) {
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
				Query q = session.createQuery("select count(*) from  Story  a where " + strWhereParam );
				Iterator itKey2 = setKeyOfMap.iterator();
				while(itKey2.hasNext()){
					String strKeyI2 = (String)itKey2.next();
					q.setParameter(intSerial,mapSqlParam.get(strKeyI2)); 
					intSerial++;
				}
				Object count = q.uniqueResult();
				StoryDaoImpl.rowCount = Integer.parseInt(count.toString());
				//
				intSerial = 0;
				q = session.createQuery("select a from Story a where " + strWhereParam );
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
		pager = new Pager(pageSize, pageNo, StoryDaoImpl.rowCount, list);
		return pager;
		
	}//end list()

	public Story select(Integer id) {
		// TODO Auto-generated method stub
		return (Story) getHibernateTemplate().get(Story.class, new Integer(id));
	}

	public boolean update(Story record) {
		getHibernateTemplate().update(record);
		return true;
	}//end update()

	/////////////////////////////////////////////////wepic2.0//////////////////////////////////////////////
	
	public Pager findbyDetachedCriteria(DetachedCriteria detachedCriteria,int pageNo,int pageSize){
		
		List<Story> list=super.getHibernateTemplate().findByCriteria(detachedCriteria,(pageNo-1)*pageSize,pageSize);
		detachedCriteria.setProjection(null);
		int totalCount=((Integer) this.getHibernateTemplate().findByCriteria(detachedCriteria.setProjection(Projections.rowCount()),0,1).get(0)).intValue();
		
		return new Pager(pageSize, pageNo, totalCount, list);
	}
	
	public String findbyCountBySpecialCat(DetachedCriteria detachedCriteria){
		
		
		int totalCount=((Integer) this.getHibernateTemplate().findByCriteria(detachedCriteria.setProjection(Projections.rowCount())).get(0)).intValue();
		
		return totalCount+"";
	}
	public Pager listofstatu(final int pageSize,final int pageNo){
		Pager pager = null;	
		//HibernateCallback
		List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
			//HibernateCallback
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				//Hibernate
				//List result = session.createQuery(hql).setParameter(0, value).setFirstResult(offset).setMaxResults(pageSize).list();
				Criteria criteria = session.createCriteria(Story.class);
				StoryDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
				criteria.setProjection(null);
				criteria.createAlias("publishStatus","publishStatus");
				
				criteria.add(Restrictions.or(Restrictions.ne("publishStatus.unreleased",0), Restrictions.ne("publishStatus.awaitingReview",0)));
				criteria.setFirstResult(pageSize * (pageNo - 1));
				criteria.setMaxResults(pageSize);
				List<?> result = criteria.list();
				return result;
			}
		});
		pager = new Pager(pageSize, pageNo, StoryDaoImpl.rowCount, list);
		return pager;
	}
	public List<Story> findbyDetached(DetachedCriteria criteria){
		return this.getHibernateTemplate().findByCriteria(criteria);
	}
}