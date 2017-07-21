package com.wetuo.wepic.core.service ;
 
import java.util.*;

import org.hibernate.criterion.DetachedCriteria;

import com.wetuo.wepic.core.beans.LeaveWord;
import com.wetuo.wepic.core.dao.LeaveWordDao;
import com.wetuo.wepic.common.hibernate.Pager;
 
public class LeaveWordServiceImpl implements LeaveWordService {
	LeaveWordDao domainDao;
	public LeaveWordDao getLeaveWordDao() {
		return domainDao;
	}//
	public void setLeaveWordDao(LeaveWordDao  domainDao) {
		this.domainDao = domainDao;
	}//
	
	//////////////common crud////////////////
	public List<LeaveWord> findAll(){ 
		return domainDao.findAll();
	}
	
	public List<LeaveWord> findPart(String strFields, String[] arrStrValues){ 
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
	public Integer insert(LeaveWord record) {
		return domainDao.insert(record) ;
	}//end insert()
			
	/////delete///
	public boolean delete(LeaveWord record)  {
		return domainDao.delete(record);
	}//end delete()
			
	public boolean delete(Integer id)  {
		return domainDao.delete(id);
	}//end delete()
	
	/////update///
	public boolean update(LeaveWord record)  {
		return domainDao.update(record);
	}//end update()
			
	/////select///
	public LeaveWord select(Integer id)  {
		return domainDao.select(id);
	}//end select()
	public Pager Ylist(String username, int pageSize, int pageNo) {
		
		return domainDao.Ylist(" is not null", pageSize, pageNo);
	}
	public Pager Nlist(String username, int pageSize, int pageNo) {
		
		return domainDao.Ylist(" is  null", pageSize, pageNo);
	}
	public Pager list(String username, String adtype, int pageSize, int pageNo) {
		// TODO Auto-generated method stub
		return domainDao.list(username, adtype, pageSize, pageNo);
	}
	public Pager listbyDetachedCrities(DetachedCriteria detachedCriteria,int nowPage,int pageSize){
		
		
		
		return domainDao.listbyDetachedCrities(detachedCriteria, nowPage, pageSize);
		
	}
	
}//end class
