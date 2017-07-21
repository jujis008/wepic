package com.wetuo.wepic.core.service ;
 
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
 
import com.wetuo.wepic.core.beans.LeaveWord;
import com.wetuo.wepic.common.hibernate.Pager;
 
public interface LeaveWordService {
 
 	List<LeaveWord> findAll();
 	List<LeaveWord> findPart(String strFields,String[] strArrValues);
 	
	public Pager list(int pageSize, int pageNo)  ;
	public Pager list(String username, int pageSize, int pageNo) ;
	public Pager Ylist(String username, int pageSize, int pageNo) ;
	public Pager Nlist(String username, int pageSize, int pageNo) ;
	public Pager list(Map<String,Object>  mapSqlParam, int pageSize, int pageNo) ;
   	public LeaveWord select(Integer id);
	public Integer insert(LeaveWord record);
	public boolean update(LeaveWord record);
   	public boolean delete(LeaveWord record);
	public boolean delete(Integer id) ;
	public Pager list( String username, String adtype , int pageSize, int pageNo);
	public Pager listbyDetachedCrities(DetachedCriteria detachedCriteria,int nowPage,int pageSize);
 
}//end class
