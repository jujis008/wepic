package com.wetuo.wepic.core.dao;

import java.util.List;

import javax.print.attribute.standard.PageRanges;

import org.hibernate.criterion.DetachedCriteria;

import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.core.beans.Bill;


/**
 * 开具发票dao接口
 * @author sun
 *
 */
public interface BillDao {
	public boolean saveBill(Bill bill);
	public boolean updateBill(Bill bill);
	public Bill  findByid(int id);
	public List<Bill> findall(DetachedCriteria criteria);
	public Pager listByPage(DetachedCriteria detachedCriteria,int nowPage,int pageSize);

}
