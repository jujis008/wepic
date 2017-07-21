package com.wetuo.wepic.core.dao ;
 
import java.util.List;
import java.util.Map;
 
import com.wetuo.wepic.core.beans.ChatMsg;
import com.wetuo.wepic.common.hibernate.Pager;
 
public interface ChatMsgDao {
 	
 	List<ChatMsg> findAll();
 	List<ChatMsg> findPart(String strFields,String[] strArrValues);
 	
	public Pager list(int pageSize, int pageNo)  ;
	public Pager listByRand(int pageSize,int pageNo,String rand);
	public Pager list(String username, int pageSize, int pageNo) ;
	public Pager list(Map<String,Object>  mapSqlParam, int pageSize, int pageNo) ;
   	public ChatMsg select(Integer id);
	public Integer insert(ChatMsg record);
	public boolean update(ChatMsg record);
   	public boolean delete(ChatMsg record);
	public boolean delete(Integer id) ;
	public List<ChatMsg> listByRand(String rand);
 
}//end class
