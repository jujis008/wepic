package com.wetuo.wepic.publish.service ;
 
import java.util.List;
import java.util.Map;
 
import com.wetuo.wepic.publish.beans.PublishCat;
import com.wetuo.wepic.common.hibernate.Pager;
 
public interface PublishCatService {
 
 	List<PublishCat> findAll();
 	List<PublishCat> findPart(String strFields,String[] strArrValues);
 	
	public Pager list(int pageSize, int pageNo)  ;
	public Pager list(String username, int pageSize, int pageNo) ;
	public Pager list(Map<String,Object>  mapSqlParam, int pageSize, int pageNo) ;
   	public PublishCat select(Integer id);
	public Integer insert(PublishCat record);
	public boolean update(PublishCat record);
   	public boolean delete(PublishCat record);
	public boolean delete(Integer id) ;
	
	public List<PublishCat> getPublishCatList() ;
	public List<PublishCat> getPublishCatListchild(int pid) ;
	public List<PublishCat> getPublishCatListJustUnderProjectCat(int pid) ;
	public Map<PublishCat,List<PublishCat>> getPublishCatMapUnderProjectCat(int pid) ;
	public List<List<PublishCat>>  getLevel2PublishCatMapUnderProjectCat(int pid) ;
	public List<PublishCat> getPublishCatListUnderProjectCat(int pid);
	public List<PublishCat> getPublishCatListUnderPid(int pid);
	public PublishCat selectByName(String type);
	public List<PublishCat> allstorycats();
	public PublishCat selectOfName(String name);
	public List<PublishCat> getPublishCatListUnderPid2(int pid);
}//end class
