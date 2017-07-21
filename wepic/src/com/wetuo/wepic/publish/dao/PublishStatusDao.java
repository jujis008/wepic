package com.wetuo.wepic.publish.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.wetuo.wepic.publish.beans.PublishStatus;

public interface PublishStatusDao {
	public boolean savePublishStatus(PublishStatus publishStatus);
	public boolean updatePublishStatus(PublishStatus publishStatus);
	public PublishStatus findById(int id);
	public List<PublishStatus> findByDetacheCriteria(DetachedCriteria detachedCriteria);
	public boolean deletePublishStatues(PublishStatus publishStatus);

}
