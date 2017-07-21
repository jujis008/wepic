package com.wetuo.wepic.publish.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.wetuo.wepic.common.hibernate.XgHibernateCommonDao;
import com.wetuo.wepic.publish.beans.PublishStatus;

public class PublishStatusDaoImp extends XgHibernateCommonDao implements
		PublishStatusDao {

	public boolean deletePublishStatues(PublishStatus publishStatus) {
		try{
			
			super.getHibernateTemplate().delete(publishStatus);
		   return true;
		}catch (Exception e) {
			return false;
		}
		
	}

	public List<PublishStatus> findByDetacheCriteria(DetachedCriteria detachedCriteria) {
		
		return super.getHibernateTemplate().findByCriteria(detachedCriteria);
	}

	public PublishStatus findById(int id) {
		// TODO Auto-generated method stub
		return super.getHibernateTemplate().get(PublishStatus.class, id);
	}

	public boolean savePublishStatus(PublishStatus publishStatus) {
			try{
			super.getHibernateTemplate().save(publishStatus);
		    return true;
		   }catch (Exception e) {
			return false;
		  }
		//return false;
	}

	public boolean updatePublishStatus(PublishStatus publishStatus) {
		try{
			super.getHibernateTemplate().update(publishStatus);
		    return true;
		   }catch (Exception e) {
			return false;
		  }
	}

}
