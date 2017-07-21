package com.wetuo.wepic.deal.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.wetuo.wepic.common.hibernate.XgHibernateCommonDao;
import com.wetuo.wepic.deal.beans.BidStatus;

public class BidStatusDaoImp extends XgHibernateCommonDao implements BidStatusDao  {

	public void deleteStatus(String id) {
		BidStatus entity=new BidStatus();
		entity.setStatuId(id);
		super.getHibernateTemplate().delete(entity);
		
		//return null;
	}

	public BidStatus findById(String id) {
		
		return super.getHibernateTemplate().get(BidStatus.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<BidStatus> listbidStatues(DetachedCriteria detachedCriteria) {
		// TODO Auto-generated method stub
		return (List<BidStatus>)super.getHibernateTemplate().findByCriteria(detachedCriteria);
	}

	public void saveStatus(BidStatus bidStatus) {
		// TODO Auto-generated method stub
		 super.getHibernateTemplate().save(bidStatus);
	}

	public void updateStatus(BidStatus bidStatus) {
		// TODO Auto-generated method stub
		super.getHibernateTemplate().update(bidStatus);
	}

}
