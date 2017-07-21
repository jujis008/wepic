package com.wetuo.wepic.publish.dao;

import java.util.List;

import com.wetuo.wepic.common.hibernate.XgHibernateCommonDao;
import com.wetuo.wepic.publish.beans.StorySystemFilterWords;

public class StoryFilterWordsDaoImpl extends XgHibernateCommonDao implements StoryFilterWordsDao {

	@SuppressWarnings("unchecked")
	public List<StorySystemFilterWords> findAll() {
		// TODO Auto-generated method stub
		return (List<StorySystemFilterWords>)getHibernateTemplate().find("from StorySystemFilterWords");
	}
	public Integer insert(StorySystemFilterWords record) {
		Integer integerRet = null; 
		return (Integer)getHibernateTemplate().save(record);
	}
}
