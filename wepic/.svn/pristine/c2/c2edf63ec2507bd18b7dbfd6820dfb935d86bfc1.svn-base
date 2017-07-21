package com.wetuo.wepic.common.hibernate ;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.HibernateException;
import java.sql.SQLException;
import java.util.List;

public class XgHibernateCommonDao extends HibernateDaoSupport {
	
	public List findByPage(final String hql, final int offset, final int pageSize){
		//??????HibernateCallback????4??��??
		List list = getHibernateTemplate().executeFind(new HibernateCallback(){
			//???HibernateCallback?????????????
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				//???Hibernate??????
				List result = session.createQuery(hql).setFirstResult(offset).setMaxResults(pageSize).list();
				return result;
			}
		});
		return list;
	}
	
	public List findByPage(final String hql , final Object value ,final int offset, final int pageSize)	{
		//??????HibernateCallback????4??��??
		List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
		//???HibernateCallback?????????????
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				//???Hibernate??????
				List result = session.createQuery(hql).setParameter(0, value).setFirstResult(offset).setMaxResults(pageSize).list();
				return result;
			}
		});
		return list;
	}
	
	public List findByPage(final String hql, final Object[] values,	final int offset, final int pageSize){
		//??????HibernateCallback????4??��??
		List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
		//???HibernateCallback?????????????
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				//???Hibernate??????
				Query query = session.createQuery(hql);
				//?hql????????
				for (int i = 0 ; i < values.length ; i++){
					query.setParameter( i, values[i]);
				}
				List result = query.setFirstResult(offset).setMaxResults(pageSize).list();
				
				return result;
			}
		});
		return list;
	}
	
}//end class
