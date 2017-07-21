package com.wetuo.wepic.core.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.core.beans.BlogCat;

public interface BlogCatDAO {

	public abstract boolean save(BlogCat transientInstance);

	public abstract boolean delete(BlogCat persistentInstance);

	public abstract BlogCat findById(java.lang.Integer id);

	public abstract List findByExample(BlogCat instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract BlogCat merge(BlogCat detachedInstance);

	public abstract boolean update(BlogCat instance);

	public abstract void attachClean(BlogCat instance);
	public List<BlogCat> getblogCatsByDetaCritires(DetachedCriteria criteria);
	public Pager findByPagerBlogCat(int nowPage,int pageSize,int userId);
}