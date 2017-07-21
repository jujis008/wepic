package com.wetuo.wepic.core.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.core.beans.Blog;

public interface BlogDAO {

	public abstract boolean save(Blog transientInstance);

	public abstract boolean delete(Blog persistentInstance);

	public abstract Blog findById(java.lang.Integer id);

	public Pager findByPager( int nowPage, int pageSize,int userId);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract Blog merge(Blog detachedInstance);

	public abstract boolean update(Blog instance);

	public abstract void attachClean(Blog instance);
	
   	public List<Blog>  detaByCritieries(DetachedCriteria criteria);
   	public Pager findByCatPager( int nowPage, int pageSize,int id,int catId);
}