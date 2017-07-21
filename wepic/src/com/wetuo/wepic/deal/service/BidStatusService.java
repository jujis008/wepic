package com.wetuo.wepic.deal.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.wetuo.wepic.deal.beans.BidStatus;

public interface BidStatusService {
	public void saveStatus(BidStatus bidStatus);
	public void deleteStatus(String id);
	public void updateStatus(BidStatus bidStatus);
	public BidStatus findById(String id);
    public List<BidStatus> listbidStatues(DetachedCriteria detachedCriteria);

}
