package com.wetuo.wepic.publish.service;

import java.util.List;
import java.util.Map;

import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.publish.beans.PublishCat_Story;

public interface PublishCat_StorySevice {
	List<PublishCat_Story> findAll();
 	List<PublishCat_Story> findPart(String strFields,String[] strArrValues);
 	
	public Pager list(int pageSize, int pageNo)  ;
	public Pager list(String username, int pageSize, int pageNo) ;
	public Pager list(Map<String,Object>  mapSqlParam, int pageSize, int pageNo) ;
   	public PublishCat_Story select(Integer id);
	public Integer insert(PublishCat_Story record);
	public boolean update(PublishCat_Story record);
   	public boolean delete(PublishCat_Story record);
	public boolean delete(Integer id) ;
	public List list(int publicId);
}
