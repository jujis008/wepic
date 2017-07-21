package com.wetuo.wepic.publish.service;

import java.util.List;
import java.util.Map;

import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.publish.beans.StoryDetail;
import com.wetuo.wepic.publish.dao.StoryDetailDao;

public class StoryDetailServiceImpl implements StoryDetailService{

	private StoryDetailDao storyDetailDao;
	public StoryDetailDao getStoryDetailDao() {
		return storyDetailDao;
	}

	public void setStoryDetailDao(StoryDetailDao storyDetailDao) {
		this.storyDetailDao = storyDetailDao;
	}

	public boolean delete(StoryDetail record) {
		// TODO Auto-generated method stub
		return storyDetailDao.delete(record);
	}

	public boolean delete(Integer id) {
		// TODO Auto-generated method stub
		return storyDetailDao.delete(id);
	}

	public List<StoryDetail> findAll() {
		// TODO Auto-generated method stub
		return storyDetailDao.findAll();
	}

	public Pager findAllPublishDetailsBypublish(int publishId, int pageSize,
			int pageNo) {
		// TODO Auto-generated method stub
		return storyDetailDao.findAllPublishDetailsBypublish(publishId, pageSize, pageNo);
	}

	public List<StoryDetail> findPart(String strFields, String[] strArrValues) {
		// TODO Auto-generated method stub
		return storyDetailDao.findPart(strFields, strArrValues);
	}

	public Integer insert(StoryDetail record) {
		// TODO Auto-generated method stub
		return storyDetailDao.insert(record);
	}

	public Pager list(int pageSize, int pageNo) {
		// TODO Auto-generated method stub
		return storyDetailDao.list(pageSize, pageNo);
	}

	public Pager list(String username, int pageSize, int pageNo) {
		// TODO Auto-generated method stub
		return storyDetailDao.list(username, pageSize, pageNo);
	}

	public Pager list(Map<String, Object> mapSqlParam, int pageSize, int pageNo) {
		// TODO Auto-generated method stub
		return storyDetailDao.list(mapSqlParam, pageSize, pageNo);
	}

	public Pager listForCommonUser(String loginUsername, int pageSize,
			int pageNo) {
		// TODO Auto-generated method stub
		return storyDetailDao.listForCommonUser(loginUsername, pageSize, pageNo);
	}

	public Pager listUnderPublish(Integer publishId, int pageSize, int pageNo) {
		// TODO Auto-generated method stub
		return storyDetailDao.listUnderPublish(publishId, pageSize, pageNo);
	}

	public StoryDetail select(Integer id) {
		// TODO Auto-generated method stub
		return storyDetailDao.select(id);
	}

	public List<StoryDetail> showThePublishofdetais(int publishId) {
		// TODO Auto-generated method stub
		return storyDetailDao.showThePublishofdetais(publishId);
	}

	public boolean update(StoryDetail record) {
		// TODO Auto-generated method stub
		return storyDetailDao.update(record);
	}

}
