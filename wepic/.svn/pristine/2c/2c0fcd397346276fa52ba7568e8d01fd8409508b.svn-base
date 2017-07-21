package com.wetuo.wepic.core.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.core.beans.Blog;
import com.wetuo.wepic.core.beans.BlogCat;
import com.wetuo.wepic.core.dao.BlogDAO;

public class BlogServiceImp implements BlogService {
	private BlogDAO dao;
	

	public BlogDAO getDao() {
		return dao;
	}

	public void setDao(BlogDAO dao) {
		this.dao = dao;
	}

	public boolean  delete(Blog persistentInstance) {
		
	return dao.delete(persistentInstance);
		
	}

	public List findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	public Blog findById(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	public List<Blog> getblogCatsByDetaCritires(DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		return dao.detaByCritieries(criteria);
	}

	public boolean save(Blog transientInstance) {
	
	return dao.save(transientInstance);	
	}

	public void updateBich(List<Blog> blogs) {
		for (Blog blog : blogs) {
		   int count=blog.getShare()+1;
		   blog.setShare(count);
		   dao.update(blog);
		}
		
		
		
		
		
		
	}

	public boolean update(Blog blog) {
		
		return dao.update(blog);
	}

	public Pager findByPager(int nowPage, int pageSize,int userId) {
		
		return dao.findByPager(nowPage, pageSize,userId);
	}

	public List<Blog> detaByCritieries(DetachedCriteria criteria) {
		
	return dao.detaByCritieries(criteria);
		
	}

	public Pager findByCatPager(int nowPage, int pageSize, int id, int catId) {
		// TODO Auto-generated method stub
		return dao.findByCatPager(nowPage, pageSize, id, catId);
	}

}
