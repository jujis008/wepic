package com.wetuo.wepic.core.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.core.beans.BlogCat;
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.core.dao.BlogCatDAO;

public class BlogCatServiceImp implements BlogCatService {
	private BlogCatDAO blogCatDao;
	

	public BlogCatDAO getBlogCatDao() {
		return blogCatDao;
	}

	public void setBlogCatDao(BlogCatDAO blogCatDao) {
		this.blogCatDao = blogCatDao;
	}

	public void attachClean(BlogCat instance) {
		// TODO Auto-generated method stub
		
	}

	public void attachDirty(BlogCat instance) {
		// TODO Auto-generated method stub
		
	}

	public boolean delete(BlogCat persistentInstance) {
		
		
		return blogCatDao.delete(persistentInstance);
		
	}

	public List findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List findByExample(BlogCat instance) {
		// TODO Auto-generated method stub
		return blogCatDao.findByExample(instance);
	}

	public BlogCat findById(Integer id) {
		// TODO Auto-generated method stub
		return blogCatDao.findById(id);
	}

	public List findByProperty(String propertyName, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<BlogCat> getblogCatsByDetaCritires(DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		return blogCatDao.getblogCatsByDetaCritires(criteria);
	}

	public BlogCat merge(BlogCat detachedInstance) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean  save(BlogCat transientInstance) {
		
		return blogCatDao.save(transientInstance);
	}

	public boolean update(BlogCat instance) {
	 return blogCatDao.update(instance);
	}

	public Pager findByPagerBlogCat(int nowPage, int pageSize,int userId) {
		Pager pager=blogCatDao.findByPagerBlogCat(nowPage, pageSize,userId);
		List<BlogCat> bList=new ArrayList<BlogCat>();
	
		if(pager.getResultList()!=null&&pager.getResultList().size()>0)
		{
			List<BlogCat>	oldlist=(List<BlogCat>) pager.getResultList();
			for (BlogCat blogCat : oldlist) {
				BlogCat newBlog=new BlogCat();
				newBlog.setId(blogCat.getId());
				newBlog.setBlogCat(blogCat.getBlogCat());
				User user=new User();
				user.setId(user.getId());
				newBlog.setUser(user);
				bList.add(newBlog);
				
			}
			
			pager.setResultList(bList);
			
		}		
		return pager;
	}

}
