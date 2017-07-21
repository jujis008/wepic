package com.wetuo.wepic.core.service ;
 
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
 
import com.wetuo.wepic.core.beans.BrokerRelationship;
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.common.hibernate.Pager;
 
public interface BrokerRelationshipService {
 
 	List<BrokerRelationship> findAll();
 	List<BrokerRelationship> findPart(String strFields,String[] strArrValues);
 	
	public Pager list(int pageSize, int pageNo)  ;
	public Pager list(String username, int pageSize, int pageNo) ;
	public Pager list(Map<String,Object>  mapSqlParam, int pageSize, int pageNo) ;
   	public BrokerRelationship select(Integer id);
	public Integer insert(BrokerRelationship record);
	public boolean update(BrokerRelationship record);
   	public boolean delete(BrokerRelationship record);
	public boolean delete(Integer id) ;
	
	public Pager list(int id,int flag, int pageSize, int pageNo);
	public boolean chooseRelationship(int id,int userId,int flag);
	public List<BrokerRelationship> getRelationShips(User user);
	public void modifyValid(List<BrokerRelationship> strList);
	public void modifyBrokerStatus(BrokerRelationship broker);
	public Pager list(DetachedCriteria criteria, int pageSize, int pageNo);
 
}//end class
