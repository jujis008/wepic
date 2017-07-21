package com.wetuo.wepic.deal.dao;

import com.wetuo.wepic.common.hibernate.XgHibernateCommonDao;
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.deal.beans.BidMarkCount;

public class BidMarkCountDaoImp extends XgHibernateCommonDao implements BidMarkCountDao {

	public BidMarkCount getBidMarkCount(User user) {
		
		return (BidMarkCount)getHibernateTemplate().find("from BidMarkCount where user.id="+user.getId()).get(0);
	}

	public boolean saveBidMarkCount(BidMarkCount bidMarkCount) {
	try{
		getHibernateTemplate().save(bidMarkCount);
		return true;
	}catch (Exception e) {
		// TODO: handle exception
	}
		return false;
	}

	public boolean updateBidMarkCount(BidMarkCount bidMarkCount) {
		try{
			getHibernateTemplate().update(bidMarkCount);
			return true;
		}catch (Exception e) {
			// TODO: handle exception
		}
			return false;
	}

}
