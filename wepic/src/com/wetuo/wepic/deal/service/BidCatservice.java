package com.wetuo.wepic.deal.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.wetuo.wepic.deal.beans.BidCat;

public interface BidCatservice {
	public boolean savebidCat(BidCat bidCat);
	public boolean deleteBidCat(int id);
	public boolean updateBidCat(BidCat bidCat); 
	public  List<BidCat> findDetaCheCriteria(DetachedCriteria detachedCriteria);
	public BidCat findById(int id);
}
