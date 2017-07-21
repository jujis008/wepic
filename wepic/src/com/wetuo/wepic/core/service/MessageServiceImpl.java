package com.wetuo.wepic.core.service ;
 
import java.util.*;

import org.hibernate.criterion.DetachedCriteria;

import com.wetuo.wepic.core.beans.Message;
import com.wetuo.wepic.core.dao.MessageDao;
import com.wetuo.wepic.common.hibernate.Pager;
 
public class MessageServiceImpl implements MessageService {
	MessageDao domainDao;
	
	public MessageDao getMessageDao() {
		return domainDao;
	}

	public void setMessageDao(MessageDao domainDao) {
		this.domainDao = domainDao;
	}

	//////////////common crud////////////////
	public List<Message> findAll(){ 
		return domainDao.findAll();
	}
	
	public List<Message> findPart(String strFields, String[] arrStrValues){ 
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
	public Integer insert(Message record) {
		return domainDao.insert(record) ;
	}//end insert()
			
	/////delete///
	public boolean delete(Message record)  {
		return domainDao.delete(record);
	}//end delete()
			
	public boolean delete(Integer id)  {
		return domainDao.delete(id);
	}//end delete()
	
	/////update///
	public boolean update(Message record)  {
		return domainDao.update(record);
	}//end update()
			
	/////select///
	public Message select(Integer id)  {
		return domainDao.select(id);
	}//end select()
	public Message select(Integer userId, String s) {		
		return domainDao.select(userId, s);
	}
	public Pager listByStatu(String username, int pageSize, int pageNo) {
		// TODO Auto-generated method stub
		return domainDao.listByStatu(username, pageSize, pageNo);
	}

	public List<Message> allMessagesByUser(Integer userId) {
		// TODO Auto-generated method stub
		return domainDao.allMessagesByUser(userId);
	}
	public Message selectBySequence(Integer userId){
		return domainDao.selectBySequence(userId);
	}

	public Message selectBySequence2(Integer userId) {
		// TODO Auto-generated method stub
		return domainDao.selectBySequence2(userId);
	}

	public Message selectBySequence3(Integer userId) {
		// TODO Auto-generated method stub
		return domainDao.selectBySequence3(userId);
	}
	public Message selectBySequence4(Integer userId) {
		return domainDao.selectBySequence4(userId);
	}
	public Pager findbyDetachedCriteria(DetachedCriteria detachedCriteria,int pageNo,int pageSize){
		return domainDao.findbyDetachedCriteria(detachedCriteria, pageNo, pageSize);
	}
}//end class
