package com.wetuo.wepic.publish.service;

import java.util.List;
import java.util.Map;

import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.publish.beans.StoryDetail;

public interface StoryDetailService {
	List<StoryDetail> findAll();
 	List<StoryDetail> findPart(String strFields,String[] strArrValues);
 	
	public Pager list(int pageSize, int pageNo)  ;
	public Pager list(String username, int pageSize, int pageNo) ;
	public Pager list(Map<String,Object>  mapSqlParam, int pageSize, int pageNo) ;
	public Pager listUnderPublish( Integer publishId, int pageSize, int pageNo);
	
   	public StoryDetail select(Integer id);
	public Integer insert(StoryDetail record);
	public boolean update(StoryDetail record);
   	public boolean delete(StoryDetail record);
	public boolean delete(Integer id) ;
	public Pager findAllPublishDetailsBypublish(int publishId,int pageSize, int pageNo);
	public List<StoryDetail> showThePublishofdetais(int publishId);
	public Pager listForCommonUser(String loginUsername, int pageSize, int pageNo);
}
