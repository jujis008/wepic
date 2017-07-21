package com.wetuo.wepic.publish.service ;
 
import java.util.List;
import java.util.Map;
 
import com.wetuo.wepic.publish.beans.PublishDetail;
import com.wetuo.wepic.common.hibernate.Pager;
 
public interface PublishDetailService {
 
 	List<PublishDetail> findAll();
 	List<PublishDetail> findPart(String strFields,String[] strArrValues);
 	
	public Pager list(int pageSize, int pageNo)  ;
	public Pager list(String username, int pageSize, int pageNo) ;
	public Pager list(Map<String,Object>  mapSqlParam, int pageSize, int pageNo) ;
	public Pager listUnderPublish( Integer publishId, int pageSize, int pageNo);
	
	
   	public PublishDetail select(Integer id);
	public Integer insert(PublishDetail record);
	public boolean update(PublishDetail record);
   	public boolean delete(PublishDetail record);
	public boolean delete(Integer id) ;
	public Pager findAllPublishDetailsBypublish(int publishId,int pageSize,int pageNo);
	public List<PublishDetail> showThePublishofdetais(int publishId);
	public Pager listForCommonUser(String loginUsername, int i, int j);
 
}//end class
