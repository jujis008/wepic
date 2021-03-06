package com.wetuo.wepic.core.dao ;
 
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.hibernate.XgHibernateCommonDao;
import com.wetuo.wepic.core.beans.Account;
import com.wetuo.wepic.core.beans.AccountBankWithdraw;
import com.wetuo.wepic.core.beans.AccountRecharge;
import com.wetuo.wepic.core.beans.AccountWithdraw;
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.core.service.AccountBankWithdrawService;
import com.wetuo.wepic.core.service.AccountService;
import com.wetuo.wepic.deal.beans.BuyAccountOperation;
import com.wetuo.wepic.publish.beans.Story;
 
public class AccountWithdrawDaoImpl extends XgHibernateCommonDao implements AccountWithdrawDao {
	private static Log log = LogFactory.getLog(AccountWithdrawDaoImpl.class);
	private static int rowCount = 0;
	private AccountService accountService;
	private AccountBankWithdrawService accountBankWithdrawService;
	public AccountService getAccountService() {
		return accountService;
	}

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	//////////////common crud//////////////////////////////////////////////
	public List<AccountWithdraw> findAll(){ 
		return (List<AccountWithdraw>)getHibernateTemplate().find("from AccountWithdraw");
	}
	
	public List<AccountWithdraw> findPart(String strFields, String[] arrStrValues){ 
		return (List<AccountWithdraw>)getHibernateTemplate().find("from AccountWithdraw where "+strFields, arrStrValues);
	}
	
public Pager list(final int pageSize,final int pageNo)  {	
	Pager pager = null;	
	//??????HibernateCallback????4??��??
	List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
		//???HibernateCallback?????????????
		public Object doInHibernate(Session session) throws HibernateException, SQLException {
			//???Hibernate??????
			//List result = session.createQuery(hql).setParameter(0, value).setFirstResult(offset).setMaxResults(pageSize).list();
			Criteria criteria = session.createCriteria(AccountWithdraw.class);
			AccountWithdrawDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
			criteria.setProjection(null);
			criteria.setFirstResult(pageSize * (pageNo - 1));
			criteria.setMaxResults(pageSize);
			List<?> result = criteria.list();
			for (int i = 0; i < result.size(); i++) {
				AccountWithdraw accountWithdraw=(AccountWithdraw)result.get(i);
				Account account=accountWithdraw.getAccount();
				System.out.println(account.getUser().getUsername());
			}
			return result;
		}
	});
	pager = new Pager(pageSize, pageNo, AccountWithdrawDaoImpl.rowCount, list);
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
			Criteria criteria = session.createCriteria(AccountWithdraw.class);
			AccountWithdrawDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
			criteria.setProjection(null);
			criteria.setFirstResult(pageSize * (pageNo - 1));
			criteria.setMaxResults(pageSize);
			List<?> result = criteria.list();
			return result;
		}
	});
	pager = new Pager(pageSize, pageNo, AccountWithdrawDaoImpl.rowCount, list);
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
				Query q = session.createQuery("select count(*) from  AccountWithdraw  a where " + strWhereParam );
				Iterator itKey2 = setKeyOfMap.iterator();
				while(itKey2.hasNext()){
					String strKeyI2 = (String)itKey2.next();
					q.setParameter(intSerial,mapSqlParam.get(strKeyI2)); 
					intSerial++;
				}
				Object count = q.uniqueResult();
				AccountWithdrawDaoImpl.rowCount = Integer.parseInt(count.toString());
				//
				intSerial = 0;
				q = session.createQuery("select a from AccountWithdraw a where " + strWhereParam );
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
		pager = new Pager(pageSize, pageNo, AccountWithdrawDaoImpl.rowCount, list);
		return pager;
		
	}//end list()
		
	/////insert///
	public Integer insert(AccountWithdraw record) {
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
	public boolean delete(AccountWithdraw record)  {
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
		AccountWithdraw record = select(id);
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
		Object obj = getHibernateTemplate().load(AccountWithdraw.class,new Integer(id));
		getHibernateTemplate().delete(obj);
		return true;
	}//end delete()
			
	/////update///
	public boolean update(AccountWithdraw record)  {
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
	public AccountWithdraw select(Integer id)  {
		/*
		Session session = null;
		AccountWithdraw record = null;
		try {
			session = HibernateSessionFactory.currentSession();
			Query query = session.createQuery("from AccountWithdraw where id=?");
			query.setInteger(0, id);
			record = (AccountWithdraw) query.uniqueResult();
			query = null;
			
		} catch (HibernateException e) {
			throw e;
		} finally {
			HibernateSessionFactory.closeSession();
		}
		
		return record;
		*/
		
		return (AccountWithdraw) getHibernateTemplate().get(AccountWithdraw.class, new Integer(id));
		
		
	}//end select()
	
	/////main///
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	public Pager List(final Integer userId, final int pageSize, final int pageNo) {
		Pager pager = null;	
		List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				String hql = "from AccountWithdraw t where t.account.user.id=? order by t.demandWithdrawTime desc";
				Query query = session.createQuery(hql);
				query.setParameter(0, userId);
				query.setFirstResult((pageNo - 1) * pageSize).setMaxResults(pageSize);
				List<?> result = query.list();
				if(result!=null&&result.size()>0){
					AccountWithdrawDaoImpl.rowCount = result.size();
				}
				
				Iterator iter =  result.iterator();
				while(iter.hasNext()){
					AccountWithdraw aw = (AccountWithdraw) iter.next();
					if(aw.getAdmin()!=null)
						Hibernate.initialize(aw.getAdmin().getUsername());
				}
				return result;
			}
		});
		pager = new Pager(pageSize, pageNo, AccountWithdrawDaoImpl.rowCount, list);
		return pager;
	}

	public Pager applayList(final int pageSize, final int pageNo,final int flag) {
		Pager pager = null;	
		List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				String hql = "from AccountWithdraw t where t.ifDemandWithdraw=? order by t.demandWithdrawTime desc";
				Query query = session.createQuery(hql);
				query.setParameter(0, flag);
				query.setFirstResult((pageNo - 1) * pageSize).setMaxResults(pageSize);
				List<?> result = query.list();
				if(result!=null&&result.size()>0){
					AccountWithdrawDaoImpl.rowCount = result.size();
				}
				Iterator iter =  result.iterator();
				while(iter.hasNext()){
					AccountWithdraw aw = (AccountWithdraw) iter.next();
					if(aw.getAdmin()!=null)
						Hibernate.initialize(aw.getAccount().getUser().getUsername());
				}
				return result;
			}
		});
		pager = new Pager(pageSize, pageNo, AccountWithdrawDaoImpl.rowCount, list);
		return pager;
	}

	public List<AccountWithdraw> findByAccount(int id) {
		// TODO Auto-generated method stub
//		AccountWithdraw accountWithdraw=select(id);
		Account account=accountService.select(id);
		DetachedCriteria dc = DetachedCriteria.forClass(AccountWithdraw.class);
		dc.add(Restrictions.eq("account",account));
		List<AccountWithdraw> list=this.getHibernateTemplate().findByCriteria(dc);
		return list;
	}
    ///////////////////////////////wepic2.0//////////////////////////////
	public List find(DetachedCriteria detachedCriteria){
		List<AccountWithdraw> list=super.getHibernateTemplate().findByCriteria(detachedCriteria);
		return list;
	}
	public Pager findbyDetachedCriteria(DetachedCriteria detachedCriteria,int pageNo,int pageSize){
			
			List<AccountWithdraw> list=super.getHibernateTemplate().findByCriteria(detachedCriteria,(pageNo-1)*pageSize,pageSize);
			for (AccountWithdraw accountWithdraw:list) {
//				accountWithdraw.setAccount(null);
				
				AccountBankWithdraw accountBankWithdraw=accountBankWithdrawService.select(accountWithdraw.getAccountBankWithdraw().getId());
				accountBankWithdraw.setAccountWithdraws(null);
				accountBankWithdraw.setAccount(null);
				accountWithdraw.setAccountBankWithdraw(accountBankWithdraw);
			}
			detachedCriteria.setProjection(null);
			int totalCount=((Integer) this.getHibernateTemplate().findByCriteria(detachedCriteria.setProjection(Projections.rowCount()),0,1).get(0)).intValue();
			
			return new Pager(pageSize, pageNo, totalCount, list);
		}

	public AccountBankWithdrawService getAccountBankWithdrawService() {
		return accountBankWithdrawService;
	}

	public void setAccountBankWithdrawService(
			AccountBankWithdrawService accountBankWithdrawService) {
		this.accountBankWithdrawService = accountBankWithdrawService;
	}
}//end class
