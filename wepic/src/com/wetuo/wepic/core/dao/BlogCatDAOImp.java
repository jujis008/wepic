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
import com.wetuo.wepic.core.beans.Blog;
import com.wetuo.wepic.core.beans.BlogCat;
import com.wetuo.wepic.core.beans.User;
import com.sun.org.apache.bcel.internal.generic.RETURN;

public class BlogCatDAOImp  extends XgHibernateCommonDao implements BlogCatDAO{
	private static final Log log = LogFactory.getLog(BlogCatDAOImp.class);
	private static int rowCount = 0;

	

	/* (non-Javadoc)
	 * @seecom.wetuo.wepic.core.dao.BlogCatDAO#save(com.qhkj.goodChance.core.beans.BlogCat)
	 */
	public boolean save(BlogCat transientInstance) {
		log.debug("saving BlogCat instance");
		try {
			getHibernateTemplate().save(transientInstance);
			
			log.debug("save successful");
			return true;
		} catch (RuntimeException re) {
			log.error("save failed", re);
			
		    re.printStackTrace();
		    return false;
			
		}
	}

	/* (non-Javadoc)
	 * @seecom.wetuo.wepic.core.dao.BlogCatDAO#delete(com.qhkj.goodChance.core.beans.BlogCat)
	 */
	public boolean delete(BlogCat persistentInstance) {
		log.debug("deleting BlogCat instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
			return true;
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			re.printStackTrace();
			return false;
		}
	}

	/* (non-Javadoc)
	 * @seecom.wetuo.wepic.core.dao.BlogCatDAO#findById(java.lang.Integer)
	 */
	public BlogCat findById(java.lang.Integer id) {
		log.debug("getting BlogCat instance with id: " + id);
		try {
			BlogCat instance = (BlogCat) getHibernateTemplate().get(
					"com.qhkj.goodChance.core.beans.BlogCat", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @seecom.wetuo.wepic.core.dao.BlogCatDAO#findByExample(com.qhkj.goodChance.core.beans.BlogCat)
	 */
	public List findByExample(BlogCat instance) {
		log.debug("finding BlogCat instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @seecom.wetuo.wepic.core.dao.BlogCatDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding BlogCat instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from BlogCat as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	

	/* (non-Javadoc)
	 * @seecom.wetuo.wepic.core.dao.BlogCatDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all BlogCat instances");
		try {
			String queryString = "from BlogCat";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @seecom.wetuo.wepic.core.dao.BlogCatDAO#merge(com.qhkj.goodChance.core.beans.BlogCat)
	 */
	public BlogCat merge(BlogCat detachedInstance) {
		log.debug("merging BlogCat instance");
		try {
			BlogCat result = (BlogCat) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @seecom.wetuo.wepic.core.dao.BlogCatDAO#attachDirty(com.qhkj.goodChance.core.beans.BlogCat)
	 */
	public boolean update(BlogCat instance) {
		log.debug("attaching dirty BlogCat instance");
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
	 * @seecom.wetuo.wepic.core.dao.BlogCatDAO#attachClean(com.qhkj.goodChance.core.beans.BlogCat)
	 */
	public void attachClean(BlogCat instance) {
		log.debug("attaching clean BlogCat instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static BlogCatDAO getFromApplicationContext(ApplicationContext ctx) {
		return (BlogCatDAO) ctx.getBean("BlogCatDAO");
	}

	public List<BlogCat> getblogCatsByDetaCritires(DetachedCriteria criteria) {
		
		return getHibernateTemplate().findByCriteria(criteria);
	}

	public Pager findByPagerBlogCat(final int nowPage, final int pageSize,final int userId) {
		Pager pager = null;	
		List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
		public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(BlogCat.class);
				User user=new User();
				user.setId(userId);
				
				criteria.add(Restrictions.eq("user", user));
				BlogCatDAOImp.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
				criteria.setProjection(null);
				criteria.setFirstResult(pageSize * (nowPage - 1));
				criteria.setMaxResults(pageSize);
				List<?> result = criteria.list();
				return result;
			}
		});
		pager = new Pager(pageSize, nowPage, BlogCatDAOImp.rowCount, list);
		return pager;
	}
}