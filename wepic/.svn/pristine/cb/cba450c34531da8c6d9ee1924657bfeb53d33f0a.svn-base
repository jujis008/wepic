package com.wetuo.wepic.core.dao ;
 
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.HibernateCallback;

import sun.security.x509.CertAndKeyGen;

import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.hibernate.XgHibernateCommonDao;
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.core.beans.UserCat;
import com.wetuo.wepic.core.beans.UserDetail;
import com.wetuo.wepic.deal.dao.BidDaoImpl;
import com.wetuo.wepic.publish.dao.PublishDaoImpl;
import com.sun.org.apache.bcel.internal.generic.RET;
 
public class UserDaoImpl extends XgHibernateCommonDao implements UserDao {
	private static Log log = LogFactory.getLog(UserDaoImpl.class);
	private static int rowCount = 0;
	private UserCatDao userCatDao;
	//////////////common crud/////////////////////
	public Pager listUnderCat(final Integer catId,final int pageSize,final int pageNo)  {	
		Pager pager = null;	
		//??????HibernateCallback
		List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
			//???HibernateCallback
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				//???Hibernate
				//List result = session.createQuery(hql).setParameter(0, value).setFirstResult(offset).setMaxResults(pageSize).list();
				Criteria criteria = session.createCriteria(User.class);
//				PublishDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
//				criteria.setProjection(null);
				
				//User user = userDao.select(username);
				UserCat userCat = userCatDao.select(catId);
				criteria.add(Expression.eq("userCat",userCat));
				UserDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
				criteria.setProjection(null);
				criteria.setFirstResult(pageSize * (pageNo - 1));
				criteria.setMaxResults(pageSize);
				List<?> result = criteria.list();
				return result;
			}
		});
		pager = new Pager(pageSize, pageNo, UserDaoImpl.rowCount, list);
		return pager;
	
	}//end list()
	
	/////////////////////////
	public List<User> findAll(){ 
		return (List<User>)getHibernateTemplate().find("from User");
	}
	
	public List<User> findPart(String strFields, String[] arrStrValues){ 
		return (List<User>)getHibernateTemplate().find("from User where "+strFields, arrStrValues);
	}
	
	public Pager getAllPohtoOrModel(final String role ,final int pageNo,final int pageSize){ 
		//return (List<User>)getHibernateTemplate().find("from User where "+strFields, arrStrValues);
		
		Pager pager = null;
		List list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
//photographer_contributing
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				String sql="select user1_.id,user1_.userNo,user1_.username,user1_.password,user1_.email,"+
				"user1_.realName,user1_.homeTown,user1_.hip,user1_.specificUrl,user1_.address,user1_.nickName,user1_.portrait,user1_.occupation,user1_.workPlace "+
				"  from UserCredit usercredit0_  left outer join user user1_  on usercredit0_.user_=user1_.id  where user1_.statu=1 and ("+
                " user1_.role like '%"+role+"%') order by user1_.portrait  is NOT NULL DESC, usercredit0_.totalMark DESC";
				Query criteria = session.createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(User.class));
				UserDaoImpl.rowCount=criteria.list().size();
				//System.out.println(UserDaoImpl.rowCount+"============================================================");
				criteria.setResultTransformer(Transformers.aliasToBean(User.class));
				criteria.setFirstResult(pageSize*(pageNo-1));
				criteria.setMaxResults(pageSize);
				
				List<?> result = criteria.list();
				return result;
			}
		});
		pager = new Pager(pageSize,pageNo,UserDaoImpl.rowCount,list);
		return pager;
	}
	
	public List getAllPohtoOrModelByShowLeft(final String role){ 
		//return (List<User>)getHibernateTemplate().find("from User where "+strFields, arrStrValues);
		
		Pager pager = null;
		List list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				String sql="select user1_.id,user1_.userNo,user1_.username,user1_.password,user1_.email,"+
				"user1_.realName,user1_.homeTown,user1_.hip,user1_.address,user1_.nickName,user1_.portrait,user1_.occupation,user1_.workPlace "+
				"  from UserCredit usercredit0_  left outer join user user1_  on usercredit0_.user_=user1_.id  where user1_.portrait  is NOT NULL and user1_.statu=1 and ("+
                " user1_.role like '%"+role+"%') order by  user1_.regTime  DESC";
				Query criteria = session.createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(User.class));
				criteria.setFirstResult(0);
				criteria.setMaxResults(3);
				List<?> result = criteria.list();
				return result;
			}
		});
		//pager = new Pager(pageSize,pageNo,UserDaoImpl.rowCount,list);
		return list;
	}
	
	
	
	public Pager addbrokerscustomer(final int pageSize, final int pageNo) {
		Pager pager = null;
		List list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(User.class);
				criteria.add(Restrictions.or(Restrictions.like("role", "%photographer%"), Restrictions.like("role", "%model%")));
				UserDaoImpl.rowCount = ((Integer)criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
				criteria.setProjection(null);
				criteria.setFirstResult(pageSize*(pageNo-1));
				criteria.setMaxResults(pageSize);
				List<?> result = criteria.list();
				return result;
			}
		});
		pager = new Pager(pageSize,pageNo,UserDaoImpl.rowCount,list);
		return pager;
	}
	
	public Pager addBrokerShip(final int pageSize, final int pageNo) {
		Pager pager = null;
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException,SQLException {
				Criteria criteria = session.createCriteria(User.class);
				criteria.add(Restrictions.like("role", "%broker%"));
				UserDaoImpl.rowCount = ((Integer)criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
				criteria.setProjection(null);
				criteria.setFirstResult(pageSize*(pageNo-1));
				criteria.setMaxResults(pageSize);
				List<?> result = criteria.list();
				return result;
			}
			
		});
		pager = new Pager(pageSize,pageNo,UserDaoImpl.rowCount,list);
		return pager;
	}
	
public Pager list(final int pageSize,final int pageNo)  {	
	Pager pager = null;	
	//??????HibernateCallback????4??��??
	List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
		//???HibernateCallback?????????????
		public Object doInHibernate(Session session) throws HibernateException, SQLException {
			Criteria criteria = session.createCriteria(User.class);
			criteria.setProjection(null);
			criteria.setFirstResult(pageSize * (pageNo - 1));
			criteria.setMaxResults(pageSize);
			criteria.addOrder(Order.desc("id"));
			criteria.add(Expression.eq( "ifIdentityTrue", new Integer(1) ));
			List<?> result = criteria.list();
			UserDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
			return result;
		}
	});
	pager = new Pager(pageSize, pageNo, UserDaoImpl.rowCount, list);
	return pager;
	
	}
    public int tempcount() {
    	//getHibernateTemplate().find("from User u where u.username = ?", username) ; 
		this.getHibernateTemplate().find("fro  ");
	    return 0;
	}

    /**
     * BidDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
			criteria.setProjection(null);
			criteria.setFirstResult(pageSize * (pageNo - 1));
			criteria.setMaxResults(pageSize);
			List<?> result = criteria.list();
			return result;
     */
public Pager userStatistics(final int pageSize,final int pageNo)  {	
	Pager pager = null;	
	//??????HibernateCallback????4??��??
	List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
		//???HibernateCallback?????????????
		public Object doInHibernate(Session session) throws HibernateException, SQLException {
			List tempList=new LinkedList();
			Criteria criteria = session.createCriteria(User.class);
			
			criteria.addOrder(Order.asc("ifIdentityTrue"));
			criteria.addOrder(Order.desc("id"));
			criteria.add(Expression.ne("ifIdentityTrue",new Integer(1)));
			criteria.add(Expression.eq( "statu", new Integer(1) ));
			UserDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
			criteria.setProjection(null);
			criteria.setFirstResult(pageSize * (pageNo - 1));
			criteria.setMaxResults(pageSize);
			List<?> result = criteria.list();
			
			return result;
		}
	});
	pager = new Pager(pageSize, pageNo, UserDaoImpl.rowCount, list);
	return pager;
	
	}



          public Pager getListByParameter(final Integer paramter,final int pageSize,final int pageNo){
            		Pager pager = null;	
            		
            		//HibernateCallback
            		List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
            			//HibernateCallback
            			public Object doInHibernate(Session session) throws HibernateException, SQLException {
            				//Hibernate111
            				//List result = session.createQuery(hql).setParameter(0, value).setFirstResult(offset).setMaxResults(pageSize).list();
            				Criteria criteria = session.createCriteria(User.class);
            				criteria.add(Restrictions.eq("isContributingPhotographer",paramter));
            				UserDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
            				criteria.setProjection(null);
            				criteria.setFirstResult(pageSize * (pageNo - 1));
            				criteria.setMaxResults(pageSize);
            				List<?> result = criteria.list();
            				return result;
            			}
            		});
            		pager = new Pager(pageSize, pageNo, UserDaoImpl.rowCount, list);
            		return pager;
                       }


public Pager list(final String username,final int pageSize,final int pageNo)  {	
	Pager pager = null;	
	//HibernateCallback
	List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
		//HibernateCallback
		public Object doInHibernate(Session session) throws HibernateException, SQLException {
			//Hibernate
			//List result = session.createQuery(hql).setParameter(0, value).setFirstResult(offset).setMaxResults(pageSize).list();
			Criteria criteria = session.createCriteria(User.class);
			criteria.add(Restrictions.eq("username", username));
			UserDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
			criteria.setProjection(null);
			criteria.setFirstResult(pageSize * (pageNo - 1));
			criteria.setMaxResults(pageSize);
			List<?> result = criteria.list();
			return result;
		}
	});
	pager = new Pager(pageSize, pageNo, UserDaoImpl.rowCount, list);
	return pager;
	
	}

     public Pager moelorPotolist(final String type,final int pageSize,final int pageNo,final int userId,final String aimId,final String workPalce)  {	
	Pager pager = null;	
	//HibernateCallback
	List<?> list = getHibernateTemplate().executeFind(new HibernateCallback()	{
		//HibernateCallback
		public Object doInHibernate(Session session) throws HibernateException, SQLException {
			
		
			String wheresql="";
			String sql="select id, username ,realName,address,pic ,sex ,role ,nickName , portrait from user where";
		if("0".equals(type)){
			sql="select id,username , realName,address,pic ,sex ,role, nickName , portrait from  (select *, case when address" +
			" like '%"+workPalce+"%' then 1 when address is not null" +
			" then 2 end as rn from user where address like  '%"+workPalce+"%' or address is not null  ) " +
			" user  where   id NOT IN(SELECT user_ FROM BidResponseInvited  WHERE bidAimPerson_='"+aimId+"' ) AND id  <>"+userId+" and ifIdentityTrue=2  and role like '%photographer%' order by rn";
			
		  // sql=sql+"isContributingPhotographer='2' and  address like '%"+workPalce+"%'";
			
		}	
		 
			//}
			if("1".equals(type)){
				sql="select id,username , realName,address,pic ,sex ,role ,nickName , portrait from  (select *, case when address" +
				" like '%"+workPalce+"%' then 1 when  address is not null" +
				" then 2 end as rn from user where address like  '%"+workPalce+"%' or address is not null  ) " +
				" user  where   id NOT IN(SELECT user_ FROM BidResponseInvited  WHERE bidAimPerson_='"+aimId+"' ) AND id  <>"+userId+"  and ifIdentityTrue=2  and  role like '%model%' order by rn";
	  
				
			//	 sql=sql+" role like '%model%'";
			//	criteria.add(Restrictions.like("role", "%model%"));
				
			}
			if("2".equals(type)){
				sql="select id,username , realName,address,pic ,sex ,role , nickName , portrait from  (select *, case when address" +
				" like '%"+workPalce+"%' then 1 when  address is not null" +
				" then 2 end as rn from user where address like  '%"+workPalce+"%' or address is not null  ) " +
				" user  where   id NOT IN(SELECT user_ FROM BidResponseInvited  WHERE bidAimPerson_='"+aimId+"' ) AND id  <>"+userId+"   and ifIdentityTrue=2  and (role like '%photographer%' or role like '%model%') order by rn";
				// sql=sql+" ";
				//criteria.add(Restrictions.or(Restrictions.like("role", "%model%"), Restrictions.eq("isContributingPhotographer", 2)));
				
			}
			if("3".equals(type)){
				 sql=sql+"  role like '%photographer%' ";
				 wheresql="SELECT user_ FROM BidResponseInvited  WHERE bidid='"+aimId+"' ";	
				 sql=sql+" and ifIdentityTrue=2 AND  id NOT IN (  " +wheresql+ " ) AND id  <>"+userId;
			}
			

			UserDaoImpl.rowCount = session.createSQLQuery(sql).list().size();
			Query q= session.createSQLQuery(sql)
			.setResultTransformer(Transformers.aliasToBean(User.class))
            .setFirstResult(pageSize * (pageNo - 1))
            .setMaxResults(pageSize);
            List result=q.list();
			return result;
		}
	});
	pager = new Pager(pageSize, pageNo, UserDaoImpl.rowCount, list);
	return pager;
	
	}
	public Pager list(final Map<String,Object> mapSqlParam,final int pageSize,final int pageNo)  {
		Pager pager = null;
		//HibernateCallback
		List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
		//HibernateCallback
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
				Query q = session.createQuery("select count(*) from  User  a where " + strWhereParam );
				Iterator itKey2 = setKeyOfMap.iterator();
				while(itKey2.hasNext()){
					String strKeyI2 = (String)itKey2.next();
					q.setParameter(intSerial,mapSqlParam.get(strKeyI2)); 
					intSerial++;
				}
				Object count = q.uniqueResult();
				UserDaoImpl.rowCount = Integer.parseInt(count.toString());
				//
				intSerial = 0;
				q = session.createQuery("select a from User a where " + strWhereParam );
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
		pager = new Pager(pageSize, pageNo, UserDaoImpl.rowCount, list);
		return pager;
		
	}//end list()
		
	/////insert///
	public Integer insert(User record) {
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
	public boolean delete(User record)  {
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
		User record = select(id);
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
		Object obj = getHibernateTemplate().load(User.class,new Integer(id));
		getHibernateTemplate().delete(obj);
		return true;
	}//end delete()
			
	/////update///
	public boolean update(User record)  {
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
	public User selectById(Integer id)  {
		/*
		Session session = null;
		User record = null;
		try {
			session = HibernateSessionFactory.currentSession();
			Query query = session.createQuery("from User where id=?");
			query.setInteger(0, id);
			record = (User) query.uniqueResult();
			query = null;
			
		} catch (HibernateException e) {
			throw e;
		} finally {
			HibernateSessionFactory.closeSession();
		}
		
		return record;
		*/
		
		return (User) getHibernateTemplate().get(User.class, new Integer(id));
		
		
	}//end select()
	
	/////main///
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	/////////////

	public User select(String username) {
		//Session session = null;
		User record = null;
		
		
		List<User> result = getHibernateTemplate().find("from User u where u.username = ?", username) ; 
		if(result != null && result.size()>0){
			record = result.get(0);
		}
		
		return record;
	}//end select()

	public Pager checkInvitedUser(String bidId) {
	User record = null;
		
		
		List<User> result = getHibernateTemplate().find("") ; 
		if(result != null && result.size()>0){
			record = result.get(0);
		}
		
		return null;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<UserDetail> findUserDetails(Integer userId) {
		List<UserDetail> list = null;
		
		list = this.getHibernateTemplate().find("from UserDetail u where u.user.id=?", userId);
		return list;
	}

	public UserCatDao getUserCatDao() {
		return userCatDao;
	}

	public void setUserCatDao(UserCatDao userCatDao) {
		this.userCatDao = userCatDao;
	}

	public Pager searchPhotoOrModel(final int pageSize, final int pageNo, final String position,
			final String searchNick, final String searchType) {
		Pager pager = null;
		List list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
//photographer_contributing
			public Object doInHibernate(Session session) {
				try{
				String sql="SELECT u  FROM UserCredit c left join c.user  u  WHERE  u.role LIKE '%"+searchType+"%'";
				if(searchNick!=null&&position.length()>0&&position!=""){
					sql+=" and u.workPlace like '%"+position+"%'";
				}
				if(searchNick!=null&&searchNick.length()>0){
					sql+=" and u.nickName like '%"+searchNick+"%'";
				}
				//sql+="  ORDER BY c.totalMark DESC";
				Query criteria = session.createQuery(sql);
				rowCount=criteria.list().size();
			//	criteria.setResultTransformer(Transformers.aliasToBean(User.class));
				criteria.setFirstResult(pageSize*(pageNo-1));
				criteria.setMaxResults(pageSize);
				List<?> result = criteria.list();
				return result;
				}catch (Exception e) {
					e.printStackTrace();
				}
				return null;
			}
		});
		pager = new Pager(pageSize,pageNo,UserDaoImpl.rowCount,list);
		return pager;
		
		
		
		
	}
	@SuppressWarnings("unchecked")
	public List<User> findnoactiveuser(){
		List<User> users=this.getHibernateTemplate().find("from User u where u.statu = 0");
		return users;
	}

	
	public Pager listDetaChedCriteri(DetachedCriteria detachedCriteria,int nowPage,int pageSize){
		
		List<User> list=super.getHibernateTemplate().findByCriteria(detachedCriteria, (nowPage-1)*pageSize, pageSize);
		rowCount=countrecodre(detachedCriteria);
		Pager pager=new Pager(pageSize, nowPage, rowCount, list);
		return pager;
	}
	
	
	
	
	public int countrecodre(DetachedCriteria criteria){
		
		
		
		
	   int totalCount=((Integer)super.getHibernateTemplate().findByCriteria(criteria.setProjection(Projections.rowCount()),0,1).get(0));
		
		return totalCount;
		
		//return 
	}
	
	
	
	
	

	
	
	
	////////////////////wepic2.0//////////////////
    @SuppressWarnings("unchecked")
	public Pager findbyDetachedCriteria(DetachedCriteria detachedCriteria,int pageNo,int pageSize){
		
		List<User> list=super.getHibernateTemplate().findByCriteria(detachedCriteria,(pageNo-1)*pageSize,pageSize);
		detachedCriteria.setProjection(null);
		int totalCount=((Integer) this.getHibernateTemplate().findByCriteria(detachedCriteria.setProjection(Projections.rowCount()),0,1).get(0)).intValue();
		
		return new Pager(pageSize, pageNo, totalCount, list);
	}
    public List<User> userbyusercat(Integer usercatid,Integer personOrCompany,Integer ifIdentityTrue) {
    	DetachedCriteria dc=DetachedCriteria.forClass(User.class);
    	if (usercatid ==0) {
		}else {
			dc.createAlias("userCat","cats");
			dc.add(Restrictions.eq("cats.id", usercatid));
		}
		dc.add(Restrictions.eq("personOrCompany", personOrCompany));
		dc.add(Restrictions.eq("ifIdentityTrue", ifIdentityTrue));
		List<User> list=this.getHibernateTemplate().findByCriteria(dc);
		return list;
	}
    public List<User> govermentbyusercat(Integer enterprisetype,Integer personOrCompany,Integer ifIdentityTrue) {
    	DetachedCriteria dc=DetachedCriteria.forClass(User.class);
    	if (enterprisetype ==0) {
		}else {
			dc.add(Restrictions.eq("enterpriceType",enterprisetype));
		}
    	dc.add(Restrictions.eq("personOrCompany", personOrCompany));
		dc.add(Restrictions.eq("ifIdentityTrue", ifIdentityTrue));
		List<User> list=this.getHibernateTemplate().findByCriteria(dc);
		return list;
	}

}
	
	
//	public Pager ImgChangeByCat(final Integer catId,final int pageSize,final int pageNo) {
//		Pager pager = null;	
//		//??????HibernateCallback
//		List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
//			//???HibernateCallback
//			public Object doInHibernate(Session session) throws HibernateException, SQLException {
//				
//			}
//		}
//		}
//	Query query=session.createQuery("select new Publish(id,name,smallPic,biggerPic) from Publish order by hit desc");
////	query.setParameter("userCat",userCat);
////	query.setMaxResults(pageSize);
////	query.setFirstResult((pageNo - 1) * pageSize);
////	return query.list();
	
//end class
