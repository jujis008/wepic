package com.wetuo.wepic.publish.dao ;
 
import java.util.List;
import java.util.Map;
 
import com.wetuo.wepic.publish.beans.AssessComplaint;
import com.wetuo.wepic.common.hibernate.Pager;
 
public interface AssessComplaintDao {
 	
 	List<AssessComplaint> findAll();
 	List<AssessComplaint> findPart(String strFields,String[] strArrValues);
 	
	public Pager list(int pageSize, int pageNo)  ;
	public Pager list(String username, int pageSize, int pageNo) ;
	public Pager list(Map<String,Object>  mapSqlParam, int pageSize, int pageNo) ;
   	public AssessComplaint select(Integer id);
	public Integer insert(AssessComplaint record);
	public boolean update(AssessComplaint record);
   	public boolean delete(AssessComplaint record);
	public boolean delete(Integer id) ;
 
}//end class
