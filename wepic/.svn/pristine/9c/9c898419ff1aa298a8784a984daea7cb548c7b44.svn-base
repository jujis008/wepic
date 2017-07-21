package com.wetuo.wepic.core.dao ;
 
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
 
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wetuo.wepic.core.beans.Account;
import com.wetuo.wepic.core.beans.AccountBankWithdraw;
import com.wetuo.wepic.core.service.AccountService;
import com.wetuo.wepic.common.hibernate.XgHibernateCommonDao;
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.deal.beans.BuyAccountOperation;

import org.springframework.orm.hibernate3.HibernateCallback;
import java.sql.SQLException;
 
public class AccountBankWithdrawDaoImpl extends XgHibernateCommonDao implements AccountBankWithdrawDao {
	private static Log log = LogFactory.getLog(AccountBankWithdrawDaoImpl.class);
	private static int rowCount = 0;
	//////////////common crud//////////////////////////////////////////////
	private UserDao userDao;
    private AccountService accountService;
	
	public AccountService getAccountService() {
		return accountService;
	}


	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}


	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	

	public UserDao getUserDao() {
		return userDao;
	}


	public List<AccountBankWithdraw> findAll(){ 
		return (List<AccountBankWithdraw>)getHibernateTemplate().find("from AccountBankWithdraw");
	}
	
	public List<AccountBankWithdraw> findPart(String strFields, String[] arrStrValues){ 
		return (List<AccountBankWithdraw>)getHibernateTemplate().find("from AccountBankWithdraw where "+strFields, arrStrValues);
	}
	
public Pager list(final int pageSize,final int pageNo)  {	
	Pager pager = null;	
	//??????HibernateCallback????4??��??
	List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
		//???HibernateCallback?????????????
		public Object doInHibernate(Session session) throws HibernateException, SQLException {
			//???Hibernate??????
			//List result = session.createQuery(hql).setParameter(0, value).setFirstResult(offset).setMaxResults(pageSize).list();
			Criteria criteria = session.createCriteria(AccountBankWithdraw.class);
			AccountBankWithdrawDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
			criteria.setProjection(null);
			criteria.setFirstResult(pageSize * (pageNo - 1));
			criteria.setMaxResults(pageSize);
			List<?> result = criteria.list();
			return result;
		}
	});
	pager = new Pager(pageSize, pageNo, AccountBankWithdrawDaoImpl.rowCount, list);
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
				Query q = session.createQuery("select count(*) from  AccountBankWithdraw  a where " + strWhereParam );
				Iterator itKey2 = setKeyOfMap.iterator();
				while(itKey2.hasNext()){
					String strKeyI2 = (String)itKey2.next();
					q.setParameter(intSerial,mapSqlParam.get(strKeyI2)); 
					intSerial++;
				}
				Object count = q.uniqueResult();
				AccountBankWithdrawDaoImpl.rowCount = Integer.parseInt(count.toString());
				//
				intSerial = 0;
				q = session.createQuery("select a from AccountBankWithdraw a where " + strWhereParam );
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
		pager = new Pager(pageSize, pageNo, AccountBankWithdrawDaoImpl.rowCount, list);
		return pager;
		
	}//end list()
		
	/////insert///
	public Integer insert(AccountBankWithdraw record) {
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
	public boolean delete(AccountBankWithdraw record)  {
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
		AccountRecharge record = select(id);
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
		Object obj = getHibernateTemplate().load(AccountBankWithdraw.class,new Integer(id));
		getHibernateTemplate().delete(obj);
		return true;
	}//end delete()
			
	/////update///
	public boolean update(AccountBankWithdraw record)  {
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
	public AccountBankWithdraw select(Integer id)  {
		/*
		Session session = null;
		AccountRecharge record = null;
		try {
			session = HibernateSessionFactory.currentSession();
			Query query = session.createQuery("from AccountRecharge where id=?");
			query.setInteger(0, id);
			record = (AccountRecharge) query.uniqueResult();
			query = null;
			
		} catch (HibernateException e) {
			throw e;
		} finally {
			HibernateSessionFactory.closeSession();
		}
		
		return record;
		*/
		
		return (AccountBankWithdraw) getHibernateTemplate().get(AccountBankWithdraw.class, new Integer(id));
		
		
	}//end select()
	
	
	
	public AccountBankWithdraw selectEntity(String id)  {
		
		String sqlString="from AccountBankWithdraw where orderId='"+id+"'";
		List list=getHibernateTemplate().find(sqlString);
		AccountBankWithdraw recharge=null;
		if(list.size()>0){
			  recharge=(AccountBankWithdraw)getHibernateTemplate().find(sqlString).get(0);
			
		}
		return recharge;
		
		
	}//end select()


	@SuppressWarnings("unchecked")
	public List findByAccount(int id) {
		// TODO Auto-generated method stub
		Account account=this.getAccountService().select(id);
		DetachedCriteria dc = DetachedCriteria.forClass(AccountBankWithdraw.class,"bankwithdraw");
		dc.add(Restrictions.eq("bankwithdraw.account.id",account.getId()));
		List<AccountBankWithdraw> list=this.getHibernateTemplate().findByCriteria(dc);
		return list;
	}
	public List findByAccount2(int id) {
		// TODO Auto-generated method stub
		Account account=this.getAccountService().select(id);
		DetachedCriteria dc = DetachedCriteria.forClass(AccountBankWithdraw.class,"bankwithdraw");
		dc.add(Restrictions.eq("bankwithdraw.account.id",account.getId()));
		List<AccountBankWithdraw> list=this.getHibernateTemplate().findByCriteria(dc);
		for (AccountBankWithdraw accountBankWithdraw:list) {
			//Account account2=accountBankWithdraw.getAccount();
			accountBankWithdraw.setAccount(null);
			accountBankWithdraw.setAccountWithdraws(null);
			/*System.out.println(account2.getId());
			account2.setBankWithdrawSet(null);
			//this.getAccountService().update(account2);
			 * */
			 
		}
		return list;
	}
	public List<AccountBankWithdraw> findbyuserofisdefault(int id) {
		Account account=this.getAccountService().select(id);
		DetachedCriteria dc = DetachedCriteria.forClass(AccountBankWithdraw.class);
		dc.add(Restrictions.eq("account",account));
		dc.add(Restrictions.eq("isdefault", 1));
		List<AccountBankWithdraw> list=this.getHibernateTemplate().findByCriteria(dc);
		return list;
	}
	public AccountBankWithdraw defaultAccountBankWithdraw(int id){
		Account account=this.getAccountService().select(id);
		DetachedCriteria dc = DetachedCriteria.forClass(AccountBankWithdraw.class);
		dc.add(Restrictions.eq("account",account));
		dc.add(Restrictions.eq("isdefault", 1));
		List<AccountBankWithdraw> list=this.getHibernateTemplate().findByCriteria(dc);
		for (AccountBankWithdraw accountBankWithdraw:list) {
			accountBankWithdraw.setAccount(null);
			accountBankWithdraw.setAccountWithdraws(null);
		}
		return list.get(0);
	}
	
}//end class
