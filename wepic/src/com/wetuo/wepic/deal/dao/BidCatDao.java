package com.wetuo.wepic.deal.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.wetuo.wepic.deal.beans.BidCat;

public interface BidCatDao {
	public boolean savebidCat(BidCat bidCat);
	public boolean deleteBidCat(int id);
	public boolean updateBidCat(BidCat bidCat); 
	public List<BidCat> findDetaCheCriteria(DetachedCriteria detachedCriteria);
	public BidCat findById(int id);
}
