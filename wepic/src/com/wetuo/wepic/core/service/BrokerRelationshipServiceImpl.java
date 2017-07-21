package com.wetuo.wepic.core.service ;
 
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.dao.support.DaoSupport;

import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.core.beans.BrokerRelationship;
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.core.dao.BrokerRelationshipDao;
import com.wetuo.wepic.core.dao.UserDao;
 
public class BrokerRelationshipServiceImpl implements BrokerRelationshipService {
	BrokerRelationshipDao domainDao;
	UserDao userDao;
	public BrokerRelationshipDao getBrokerRelationshipDao() {
		return domainDao;
	}//
	public void setBrokerRelationshipDao(BrokerRelationshipDao  domainDao) {
		this.domainDao = domainDao;
	}//
	
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	//////////////common crud////////////////
	public List<BrokerRelationship> findAll(){ 
		return domainDao.findAll();
	}
	
	public List<BrokerRelationship> findPart(String strFields, String[] arrStrValues){ 
		return domainDao.findPart(strFields,arrStrValues);
	}
	
	public Pager list(int pageSize, int pageNo)  {
		return domainDao.list(pageSize,pageNo);
	}//end list()
	
	public Pager list(DetachedCriteria criteria, int pageSize, int pageNo)  {
		return domainDao.list(criteria,pageSize,pageNo);
	}//end list()
	
	public Pager list(String username, int pageSize, int pageNo)  {
		return domainDao.list(username,pageSize,pageNo);
	}//end list()
	
	public Pager list(Map<String,Object> mapSqlParam, int pageSize, int pageNo)  {
		return domainDao.list(mapSqlParam,pageSize,pageNo);
	}//end list()
	
	/////insert///
	public Integer insert(BrokerRelationship record) {
		return domainDao.insert(record) ;
	}//end insert()
			
	/////delete///
	public boolean delete(BrokerRelationship record)  {
		return domainDao.delete(record);
	}//end delete()
			
	public boolean delete(Integer id)  {
		return domainDao.delete(id);
	}//end delete()
	
	/////update///
	public boolean update(BrokerRelationship record)  {
		return domainDao.update(record);
	}//end update()
			
	/////select///
	public BrokerRelationship select(Integer id)  {
		return domainDao.select(id);
	}//end select()
	
	
	/******查找所有选择了我的User******/
	public Pager list(int id,int flag, int pageSize, int pageNo) {
		return domainDao.List(id,flag, pageSize, pageNo);
	}
	
	/*****选择建立经济关系或不同意建立经济关系（取消经济关系）******/
	public boolean chooseRelationship(int id, int userId, int flag) {
	//	User user = userDao.selectById(userId);
		BrokerRelationship brs = domainDao.select(id);
		if(brs!=null && (brs.getIfAccept()==0)){
			brs.setCreationTime(new Timestamp(new Date().getTime()));
			brs.setIfAccept(flag);
			brs.setIsValid(2);
			if(flag==2){
				brs.setIsValid(1);
				
			}
			//brs.setWhoIsActive(user);
			
			return domainDao.update(brs);
			
		}
		return false;
	}
	public List<BrokerRelationship> getRelationShips(User user) {
		
		return domainDao.getRelationShips(user);
	}
	public void modifyValid(List<BrokerRelationship> strList) {
		domainDao.modifyValid(strList);
	}
	public void modifyBrokerStatus(BrokerRelationship broker) {
		domainDao.modifyBrokerStatus(broker);
	}
	
}//end class
