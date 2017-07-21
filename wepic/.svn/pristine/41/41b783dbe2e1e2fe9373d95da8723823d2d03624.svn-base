package com.wetuo.wepic.deal.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.wetuo.wepic.deal.beans.BidStatus;
import com.wetuo.wepic.deal.dao.BidStatusDao;

public class BidStatusServiceImp implements BidStatusService {
	private BidStatusDao bidStatusDao;

	public void deleteStatus(String id) {
		// TODO Auto-generated method stub
		bidStatusDao.deleteStatus(id);
	}

	public BidStatus findById(String id) {
		// TODO Auto-generated method stub
		return bidStatusDao.findById(id);
	}

	public List<BidStatus> listbidStatues(DetachedCriteria detachedCriteria) {
		// TODO Auto-generated method stub
		return bidStatusDao.listbidStatues(detachedCriteria);
	}

	public void saveStatus(BidStatus bidStatus) {
		// TODO Auto-generated method stub
		bidStatusDao.saveStatus(bidStatus);
		
	}

	public void updateStatus(BidStatus bidStatus) {
		bidStatusDao.updateStatus(bidStatus);
		
	}

	public BidStatusDao getBidStatusDao() {
		return bidStatusDao;
	}

	public void setBidStatusDao(BidStatusDao bidStatusDao) {
		this.bidStatusDao = bidStatusDao;
	}
	
	
	

}
