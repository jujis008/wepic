package com.wetuo.wepic.core.dao;

import java.sql.SQLException;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.hibernate.XgHibernateCommonDao;
import com.wetuo.wepic.core.beans.AccountRecharge;
import com.wetuo.wepic.core.beans.Blog;
import com.wetuo.wepic.core.beans.BlogCat;
import com.wetuo.wepic.core.beans.User;

public class BlogDAOImp extends XgHibernateCommonDao implements BlogDAO  {
	private static final Log log = LogFactory.getLog(BlogDAOImp.class);
	private static int rowCount = 0;
	// property constants


	/* (non-Javadoc)
	 * @seecom.wetuo.wepic.core.dao.BlogDAO#save(com.qhkj.goodChance.core.beans.Blog)
	 */
	public boolean save(Blog transientInstance) {
		log.debug("saving Blog instance");
		try {
			getHibernateTemplate().save(transientInstance);
		    return true;
		} catch (RuntimeException re) {
			log.error("save failed", re);
			return false;
		}
	}

	/* (non-Javadoc)
	 * @seecom.wetuo.wepic.core.dao.BlogDAO#delete(com.qhkj.goodChance.core.beans.Blog)
	 */
	public boolean delete(Blog persistentInstance) {
		log.debug("deleting Blog instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			return true;
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			return false;
		}
	}

	/* (non-Javadoc)
	 * @seecom.wetuo.wepic.core.dao.BlogDAO#findById(java.lang.Integer)
	 */
	public Blog findById(java.lang.Integer id) {
		log.debug("getting Blog instance with id: " + id);
		try {
			Blog instance = (Blog) getHibernateTemplate().get("com.qhkj.goodChance.core.beans.Blog",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @seecom.wetuo.wepic.core.dao.BlogDAO#findByExample(com.qhkj.goodChance.core.beans.Blog)
	 */
	public Pager findByPager(final int nowPage,final int pageSize,final int userId) {
		
		
		
		Pager pager = null;	
		List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
		public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(Blog.class);
			
				User user=new User();
				user.setId(userId);
				criteria.add(Restrictions.eq("user", user));
				BlogDAOImp.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
				criteria.setProjection(null);
				criteria.setFirstResult(pageSize * (nowPage - 1));
				criteria.setMaxResults(pageSize);
				List<?> result = criteria.list();
				return result;
			}
		});
		pager = new Pager(pageSize, nowPage, BlogDAOImp.rowCount, list);
		return pager;
		
	}

	/* (non-Javadoc)
	 * @seecom.wetuo.wepic.core.dao.BlogDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Blog instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Blog as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}



	/* (non-Javadoc)
	 * @seecom.wetuo.wepic.core.dao.BlogDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all Blog instances");
		try {
			String queryString = "from Blog";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @seecom.wetuo.wepic.core.dao.BlogDAO#merge(com.qhkj.goodChance.core.beans.Blog)
	 */
	public Blog merge(Blog detachedInstance) {
		log.debug("merging Blog instance");
		try {
			Blog result = (Blog) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @seecom.wetuo.wepic.core.dao.BlogDAO#attachDirty(com.qhkj.goodChance.core.beans.Blog)
	 */
	public boolean update(Blog instance) {
		log.debug("attaching dirty Blog instance");
		try {
			getHibernateTemplate().update(instance);
			return true;
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			re.printStackTrace();
			return false;
		}
	}

	/* (non-Javadoc)
	 * @seecom.wetuo.wepic.core.dao.BlogDAO#attachClean(com.qhkj.goodChance.core.beans.Blog)
	 */
	public void attachClean(Blog instance) {
		log.debug("attaching clean Blog instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static BlogDAO getFromApplicationContext(ApplicationContext ctx) {
		return (BlogDAO) ctx.getBean("BlogDAO");
	}

	public List<Blog> detaByCritieries(DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().findByCriteria(criteria);
	}

	public Pager findByCatPager(final int nowPage, final int pageSize, final int userId, final int catId) {
		Pager pager = null;	
		List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
		public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(Blog.class);
				
				User user=new User();
				user.setId(userId);
				BlogCat blogCat=new BlogCat();
				blogCat.setId(catId);
				criteria.add(Restrictions.eq("user", user));
				criteria.add(Restrictions.eq("blogCat", blogCat));
				BlogDAOImp.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
				criteria.setProjection(null);
				criteria.setFirstResult(pageSize * (nowPage - 1));
				criteria.setMaxResults(pageSize);
				List<?> result = criteria.list();
				return result;
			}
		});
		pager = new Pager(pageSize, nowPage, BlogDAOImp.rowCount, list);
		return pager;
		//return null;
	}
}