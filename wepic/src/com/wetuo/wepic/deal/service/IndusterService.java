package com.wetuo.wepic.deal.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.wetuo.wepic.deal.beans.Industry;

public interface IndusterService {
	public boolean save(Industry industry);
	public boolean update(Industry industry);
	public boolean delete(int id);
	public List<Industry> findByDetachriteri(DetachedCriteria detachedCriteria);
	public Industry getById(int id);

}
