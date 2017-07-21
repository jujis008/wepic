package com.wetuo.wepic.core.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.core.beans.Blog;
import com.wetuo.wepic.core.beans.BlogCat;

public interface BlogService {

	public abstract boolean save(Blog transientInstance);

	public abstract boolean delete(Blog persistentInstance);

	public abstract Blog findById(java.lang.Integer id);
    public boolean update(Blog blog);
	public abstract List findAll();
	public List<Blog> getblogCatsByDetaCritires(DetachedCriteria criteria);
	public void updateBich(List<Blog> blogs);
	public Pager findByPager( int nowPage, int pageSize,int id);
	public Pager findByCatPager( int nowPage, int pageSize,int id,int catId);

	public abstract List<Blog> detaByCritieries(DetachedCriteria criteria);


}
