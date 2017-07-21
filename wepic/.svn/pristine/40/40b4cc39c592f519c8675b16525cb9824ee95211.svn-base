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
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.wetuo.wepic.core.beans.Account;
import com.wetuo.wepic.core.beans.MoneyInfo;
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.common.hibernate.HibernateSessionFactory;
import com.wetuo.wepic.common.hibernate.XgHibernateCommonDao;
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.util.UUIDGenerator;

import edu.emory.mathcs.backport.java.util.LinkedList;

import org.springframework.orm.hibernate3.HibernateCallback;

import java.math.BigDecimal;
import java.sql.SQLException;
 
public class AccountDaoImpl extends XgHibernateCommonDao implements AccountDao {
	private static Log log = LogFactory.getLog(AccountDaoImpl.class);
	private static int rowCount = 0;
	private UserDao userDao;
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	////////
	public void transferMoneyDetail(int fromUserId,int toUserId,int num) throws Exception {
		Account fromAccount = 	select(fromUserId, "");
		fromAccount.setTotalMoney(   fromAccount.getTotalMoney().subtract( new BigDecimal(num) )   );
		Account toAccount = 	select(toUserId, "");
		toAccount.setTotalMoney(   toAccount.getTotalMoney().add( new BigDecimal(num) )   );

		//toAccount.setUser(null);
		try{
			//update(fromAccount);
			//update(toAccount);
			if(fromAccount.getTotalMoney().intValue() >= num  && fromAccount.getRemainingMoney().intValue() >= num ){
				getHibernateTemplate().update(fromAccount);
				getHibernateTemplate().update(toAccount);
			}
			
		}catch(Exception e){
			System.out.println("-------------------big larry exception-------------------------");
			//throw new Exception();
			throw e;
		}
	}//end transferMoneyDetail()
	

	//////////////common crud//////////////////////////////////////////////
	public List<Account> findAll(){ 
		return (List<Account>)getHibernateTemplate().find("from Account");
	}
	
	public List<Account> findPart(String strFields, String[] arrStrValues){ 
		return (List<Account>)getHibernateTemplate().find("from Account where "+strFields, arrStrValues);
	}
	
	public Pager list(final int pageSize,final int pageNo)  {	
	Pager pager = null;	
	List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
		public Object doInHibernate(Session session) throws HibernateException, SQLException {
			Criteria criteria = session.createCriteria(Account.class);
			AccountDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
			criteria.setProjection(null);
			
			criteria.setFirstResult(pageSize * (pageNo - 1));
			criteria.setMaxResults(pageSize);
			List<?> result = criteria.list();
			return result;
		}
	});
	pager = new Pager(pageSize, pageNo, AccountDaoImpl.rowCount, list);
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
			Criteria criteria = session.createCriteria(Account.class);
			User user = userDao.select(username);
			criteria.add(Expression.eq("user",user));
			AccountDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
			criteria.setProjection(null);
			criteria.setFirstResult(pageSize * (pageNo - 1));
			criteria.setMaxResults(pageSize);
			List<?> result = criteria.list();
			return result;
		}
	});
	pager = new Pager(pageSize, pageNo, AccountDaoImpl.rowCount, list);
	return pager;
	
	}
	
	
	
	@SuppressWarnings("unchecked")
	public Pager list(final int pageSize,final int pageNo,DetachedCriteria detachedCriteria)  {	
		
		//detachedCriteria.setProjection(null);
		
		//detachedCriteria.setProjection(null);
		List<Account> list=super.getHibernateTemplate().findByCriteria(detachedCriteria,(pageNo-1)*pageSize,pageSize);
		AccountDaoImpl.rowCount=countbydetacriteria(detachedCriteria);
		Pager pager = new Pager(pageSize, pageNo,AccountDaoImpl.rowCount , list);
		
		return pager;
		
		}
	
	
	
	@SuppressWarnings("unchecked")
	public int countbydetacriteria(DetachedCriteria detachedCriteria){
		
		
		detachedCriteria.setProjection(Projections.rowCount());
		List list=this.getHibernateTemplate().findByCriteria(detachedCriteria,0,1);
		return (Integer) list.get(0);
		
		
	}
	
	
	
	
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
				Query q = session.createQuery("select count(*) from  Account  a where " + strWhereParam );
				Iterator itKey2 = setKeyOfMap.iterator();
				while(itKey2.hasNext()){
					String strKeyI2 = (String)itKey2.next();
					q.setParameter(intSerial,mapSqlParam.get(strKeyI2)); 
					intSerial++;
				}
				Object count = q.uniqueResult();
				AccountDaoImpl.rowCount = Integer.parseInt(count.toString());
				//
				intSerial = 0;
				q = session.createQuery("select a from Account a where " + strWhereParam );
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
		pager = new Pager(pageSize, pageNo, AccountDaoImpl.rowCount, list);
		return pager;
		
	}//end list()
		
	/////insert///
	public Integer insert(Account record) {
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
	public boolean delete(Account record)  {
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
		Account record = select(id);
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
		Object obj = getHibernateTemplate().load(Account.class,new Integer(id));
		getHibernateTemplate().delete(obj);
		return true;
	}//end delete()
			
	/////update///
	
	public void updateTrans(Account record) throws Exception   {
		getHibernateTemplate().update(record);
		throw new Exception(); 
	}
		

	public boolean update(Account record)  {
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
	public Account select(Integer id)  {
		/*
		Session session = null;
		Account record = null;
		try {
			session = HibernateSessionFactory.currentSession();
			Query query = session.createQuery("from Account where id=?");
			query.setInteger(0, id);
			record = (Account) query.uniqueResult();
			query = null;
			
		} catch (HibernateException e) {
			throw e;
		} finally {
			HibernateSessionFactory.closeSession();
		}
		
		return record;
		*/
		
		return (Account) getHibernateTemplate().get(Account.class, new Integer(id));
		
		
	}
	
	/////main///
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}


	public Account select(Integer userId , String s){
		String hql=" from  Account where user_= " + userId;
		List list = getHibernateTemplate().find(hql);
		Account account=new Account();
		if(list.size()>0){
			account=(Account)list.get(0);			
		}
		return account;
		
		
	}

	
	
	
	
	
	
	
	@SuppressWarnings("unchecked")
	public MoneyInfo admincountselect(){
		//t++;
	
		
		
		
		MoneyInfo account=new MoneyInfo();
		String str0="SELECT SUM(totalMoney) FROM Account acount where acount.user.username!='super1' ";
		String str1="select sum(remainingMoney) FROM Account acount where acount.user.username!='super1'" ;
    	
//		String str4="SELECT SUM(money) FROM BuyAccountOperation WHERE operationType=4 and account.id="+accoundId;//减钱
//		String str5="SELECT SUM(rechargeMoney) FROM AccountRecharge where account.id="+accoundId;
		String str2="SELECT SUM(rechargeMoney) FROM AccountRecharge ";
		String str3="SELECT SUM(withdrawMoney) FROM AccountWithdraw as wra where  wra.status=6";
		String str4="select sum(entryMoney) FROM BidAccountOperation WHERE entryMoney IS NOT null";
		String str5="SELECT SUM(money) FROM BuyAccountOperation WHERE operationType=4";//加钱
		List list2=new java.util.LinkedList();
		list2.add(str0);
		list2.add(str1);
		list2.add(str2);
		list2.add(str3);
		list2.add(str4);
		list2.add(str5);
//		list2.add(str6);
//		list2.add(str7);
		
		List list=new LinkedList();
		
		
		for(int i=0;i<6;i++){
	    List list1 = getHibernateTemplate().find(list2.get(i)+"");
	    if(list1.get(0)!=null){
	    	list.add(list1.get(0));
	    	
	    }else{
	    	list.add(0);
	    	
	    }
	   
	    
	    
		}
		
		 account.setCountTotalMoney(list.get(0)+"");
		 account.setCountremainingMoney(list.get(1)+"");
		 account.setCountrechagerTotalmoney(list.get(2)+"");
		 account.setCountwithWraTotalMoney(list.get(3)+"");
		 double biddealmoney=0;
		 double buydealmoney=0;
		 if(list.get(4)!=null&&list.get(4).toString().trim().length()>0){
			 biddealmoney=Double.parseDouble(list.get(4).toString());
			 
		 }
		 if(list.get(5)!=null&&list.get(5).toString().trim().length()>0){
			 buydealmoney=Double.parseDouble(list.get(5).toString());
			 
		 }
		 account.setCountdealMoney((biddealmoney+buydealmoney)+"");
		return account;
		
		
	}
	
	@SuppressWarnings("unchecked")
	public MoneyInfo countselect(Integer accoundId){
		//t++;
	
		
		
		
		MoneyInfo account=new MoneyInfo();
		String str0="SELECT SUM(withdrawMoney) FROM AccountWithdraw as wra where account.id="+accoundId +"and wra.status=6";
		String str1="select sum(deductionMoney) FROM BidAccountOperation WHERE deductionMoney IS NOT null and account.id="+accoundId;
		String str2="select sum(entryMoney) FROM BidAccountOperation WHERE entryMoney IS NOT null and account.id="+accoundId;
		String str3="SELECT SUM(money) FROM BuyAccountOperation WHERE operationType=3 and account.id="+accoundId;//加钱
		String str4="SELECT SUM(money) FROM BuyAccountOperation WHERE operationType=4 and account.id="+accoundId;//减钱
		String str5="SELECT SUM(rechargeMoney) FROM AccountRecharge where account.id="+accoundId;
		String str6="SELECT SUM(withdrawMoney) FROM AccountWithdraw as wra where  wra.status=6";
		List list2=new java.util.LinkedList();
		list2.add(str0);
		list2.add(str1);
		list2.add(str2);
		list2.add(str3);
		list2.add(str4);
		list2.add(str5);
		list2.add(str6);
		
		List list=new LinkedList();
		
		
		for(int i=0;i<6;i++){
	    List list1 = getHibernateTemplate().find(list2.get(i)+"");
	    if(list1.get(0)!=null){
	    	list.add(list1.get(0));
	    	
	    }else{
	    	list.add(0);
	    	
	    }
	   
	    
	    
		}
		
		 account.setWithWraTotalMoney(list.get(0)+"");
		 account.setPayTotalMOney(new BigDecimal(list.get(1)+"").add(new BigDecimal(list.get(4)+""))+"");
		 account.setGetTotalMoney(new BigDecimal(list.get(2)+"").add(new BigDecimal(list.get(3)+""))+"");
		 account.setRechagerTotalmoney(list.get(5)+"");
		// account.setCountdealMoney(countdealMoney)
		return account;
		
		
	}
	
}//end class
