package com.wetuo.wepic.core.service ;
 
import java.util.*;

import com.wetuo.wepic.core.beans.ChatMsg;
import com.wetuo.wepic.core.dao.ChatMsgDao;
import com.wetuo.wepic.common.hibernate.Pager;
 
public class ChatMsgServiceImpl implements ChatMsgService {
	ChatMsgDao domainDao;
	public ChatMsgDao getChatMsgDao() {
		return domainDao;
	}//
	public void setChatMsgDao(ChatMsgDao  domainDao) {
		this.domainDao = domainDao;
	}//
	
	//////////////common crud////////////////
	public List<ChatMsg> findAll(){ 
		return domainDao.findAll();
	}
	
	public List<ChatMsg> findPart(String strFields, String[] arrStrValues){ 
		return domainDao.findPart(strFields,arrStrValues);
	}
	
	public Pager list(int pageSize, int pageNo)  {
		return domainDao.list(pageSize,pageNo);
	}//end list()
	
	public Pager list(String username, int pageSize, int pageNo)  {
		return domainDao.list(username,pageSize,pageNo);
	}//end list()
	
	public Pager list(Map<String,Object> mapSqlParam, int pageSize, int pageNo)  {
		return domainDao.list(mapSqlParam,pageSize,pageNo);
	}//end list()
	
	/////insert///
	public Integer insert(ChatMsg record) {
		return domainDao.insert(record) ;
	}//end insert()
			
	/////delete///
	public boolean delete(ChatMsg record)  {
		return domainDao.delete(record);
	}//end delete()
			
	public boolean delete(Integer id)  {
		return domainDao.delete(id);
	}//end delete()
	
	/////update///
	public boolean update(ChatMsg record)  {
		return domainDao.update(record);
	}//end update()
			
	/////select///
	public ChatMsg select(Integer id)  {
		return domainDao.select(id);
	}//end select()
	public Pager listByRand(int pageSize, int pageNo, String rand) {
		// TODO Auto-generated method stub
		return domainDao.listByRand(pageSize, pageNo, rand);
	}
	public List<ChatMsg> listByRand(String rand){
		return domainDao.listByRand(rand);
	}
	
}//end class
