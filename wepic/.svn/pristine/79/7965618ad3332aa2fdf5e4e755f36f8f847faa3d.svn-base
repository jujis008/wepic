package com.wetuo.wepic.core.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.HibernateCallback;
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.hibernate.XgHibernateCommonDao;
import com.wetuo.wepic.core.beans.Bill;

/**
 * 
 * @author sun
 *
 */
public class BillDaoImp extends XgHibernateCommonDao implements BillDao{

	public Bill findByid(int id) {
		
		return super.getHibernateTemplate().get(Bill.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Bill> findall(DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		return super.getHibernateTemplate().findByCriteria(criteria);
	}

	@SuppressWarnings("unchecked")
	public Pager listByPage(DetachedCriteria detachedCriteria, int nowPage,int pageSize) {
		
		Pager pager=null;
		
		List<Bill> bills=getHibernateTemplate().findByCriteria(detachedCriteria, (nowPage-1)*pageSize, pageSize);
		
		pager=new Pager(pageSize, nowPage, getCount(detachedCriteria), bills);
		
		return pager; 
	}

	public boolean saveBill(Bill bill) {
		Integer result=0;
		try{
		 result=(Integer)getHibernateTemplate().save(bill);
		 return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	
		
	}
	public boolean updateBill(Bill bill) {
		getHibernateTemplate().update(bill);

		return true;
	}
	@SuppressWarnings("unchecked")
	public int getCount(final DetachedCriteria detachedCriteria){
		
		 Integer count = (Integer) getHibernateTemplate().execute(new HibernateCallback() {   
	            public Object doInHibernate(Session session) throws HibernateException {   
	                Criteria criteria = detachedCriteria.getExecutableCriteria(session);   
	                return criteria.setProjection(Projections.rowCount()).uniqueResult();   
	            }   
	        });   
	        return count.intValue();   
		
		
	}

}
