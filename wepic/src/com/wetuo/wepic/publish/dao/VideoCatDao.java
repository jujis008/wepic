package com.wetuo.wepic.publish.dao ;
 
import java.util.List;
import java.util.Map;
 

import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.publish.beans.VideoCat;
 
public interface VideoCatDao {
 	
 	List<VideoCat> findAll();
 	List<VideoCat> findPart(String strFields,String[] strArrValues);
 	
 	
	public Pager list(int pageSize, int pageNo)  ;
	public Pager list(String username, int pageSize, int pageNo) ;
	public Pager list(Map<String,Object>  mapSqlParam, int pageSize, int pageNo) ;
   	public VideoCat select(Integer id);
	public Integer insert(VideoCat record);
	public boolean update(VideoCat record);
   	public boolean delete(VideoCat record);
	public boolean delete(Integer id) ;
	
	public List<VideoCat> getVideoCatList() ;
	public List<VideoCat> getVideoCatListJustUnderProjectCat(int vid) ;
//	public Map<VideoCat,List<VideoCat>> getVideoCatMapUnderProjectCat(int vid) ;
	public List<List<VideoCat>>  getLevel2VideoCatMapUnderProjectCat(int vid) ;
//	public List<VideoCat>  getLevel2VideoCatsUnderProjectCat(int vid) ;
	
//	public List<VideoCat> getVideoCatListUnderProjectCat(int vid) ;
	public List<VideoCat> getVideoCatListchild(int vid);
//	public List<VideoCat> getVideoCatListUnderVid(int vid);
	
 
}//end class
