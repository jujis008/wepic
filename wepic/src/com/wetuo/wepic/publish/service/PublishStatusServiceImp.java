package com.wetuo.wepic.publish.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.wetuo.wepic.publish.beans.PublishStatus;
import com.wetuo.wepic.publish.dao.PublishStatusDao;

public class PublishStatusServiceImp implements PublishStatusService {
	private PublishStatusDao publishStatusDao;

	public boolean deletePublishStatues(PublishStatus publishStatus) {
		// TODO Auto-generated method stub
		return publishStatusDao.deletePublishStatues(publishStatus);
	}

	public List<PublishStatus> findByDetacheCriteria(
			DetachedCriteria detachedCriteria) {
		// TODO Auto-generated method stub
		return publishStatusDao.findByDetacheCriteria(detachedCriteria);
	}

	public PublishStatus findById(int id) {
		// TODO Auto-generated method stub
		return publishStatusDao.findById(id);
	}

	public boolean savePublishStatus(PublishStatus publishStatus) {
		// TODO Auto-generated method stub
		return publishStatusDao.savePublishStatus(publishStatus);
	}

	public boolean updatePublishStatus(PublishStatus publishStatus) {
		// TODO Auto-generated method stub
		return publishStatusDao.updatePublishStatus(publishStatus);
	}

	public PublishStatusDao getPublishStatusDao() {
		return publishStatusDao;
	}

	public void setPublishStatusDao(PublishStatusDao publishStatusDao) {
		this.publishStatusDao = publishStatusDao;
	}
	

}
