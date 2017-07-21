package com.wetuo.wepic.core.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.core.beans.Bill;
import com.wetuo.wepic.core.dao.BillDao;

public class BillServiceImp implements BillService {
	private BillDao dao;
	public void setDao(BillDao dao) {
		this.dao = dao;
	}
	public BillDao getDao() {
		return dao;
	}

	public Bill findByid(int id) {
		// TODO Auto-generated method stub
		return dao.findByid(id);
	}

	public List<Bill> findall(DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		return dao.findall(criteria);
	}

	public Pager listByPage(DetachedCriteria detachedCriteria, int nowPage,
			int pageSize) {
		// TODO Auto-generated method stub
		return dao.listByPage(detachedCriteria, nowPage, pageSize);
	}

	public boolean saveBill(Bill bill) {
		// TODO Auto-generated method stub
		return dao.saveBill(bill);
	}

	public boolean updateBill(Bill bill) {
		// TODO Auto-generated method stub
		return dao.updateBill(bill);
	}

}
