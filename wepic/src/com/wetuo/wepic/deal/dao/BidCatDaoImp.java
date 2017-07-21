package com.wetuo.wepic.deal.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.wetuo.wepic.common.hibernate.XgHibernateCommonDao;
import com.wetuo.wepic.deal.beans.BidCat;

public class BidCatDaoImp extends XgHibernateCommonDao implements BidCatDao  {

	public boolean deleteBidCat(int id) {
		try{
		BidCat bidCat=new BidCat();
		bidCat.setId(id);
		super.getHibernateTemplate().delete(bidCat);
		return true;
		}catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	public List<BidCat> findDetaCheCriteria(DetachedCriteria detachedCriteria) {
		// TODO Auto-generated method stub
		
		return super.getHibernateTemplate().findByCriteria(detachedCriteria);
	}

	public boolean savebidCat(BidCat bidCat) {
		try{
			
			super.getHibernateTemplate().save(bidCat);
			return true;
			}catch (Exception e) {
				// TODO: handle exception
			}
			return false;
	}

	public boolean updateBidCat(BidCat bidCat) {
try{
			
			super.getHibernateTemplate().update(bidCat);
			return true;
			}catch (Exception e) {
				// TODO: handle exception
			}
			return false;
	}
	
	
	public BidCat findById(int id){
		
		
		
		
		return super.getHibernateTemplate().get(BidCat.class, id);
		
	}

}
