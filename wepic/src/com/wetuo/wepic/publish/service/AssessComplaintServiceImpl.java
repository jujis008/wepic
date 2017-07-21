package com.wetuo.wepic.publish.service ;
 
import java.util.*;
import com.wetuo.wepic.publish.beans.AssessComplaint;
import com.wetuo.wepic.publish.dao.AssessComplaintDao;
import com.wetuo.wepic.common.hibernate.Pager;
 
public class AssessComplaintServiceImpl implements AssessComplaintService {
	AssessComplaintDao domainDao;
	public AssessComplaintDao getAssessComplaintDao() {
		return domainDao;
	}//
	public void setAssessComplaintDao(AssessComplaintDao  domainDao) {
		this.domainDao = domainDao;
	}//
	
	//////////////common crud////////////////
	public List<AssessComplaint> findAll(){ 
		return domainDao.findAll();
	}
	
	public List<AssessComplaint> findPart(String strFields, String[] arrStrValues){ 
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
	public Integer insert(AssessComplaint record) {
		return domainDao.insert(record) ;
	}//end insert()
			
	/////delete///
	public boolean delete(AssessComplaint record)  {
		return domainDao.delete(record);
	}//end delete()
			
	public boolean delete(Integer id)  {
		return domainDao.delete(id);
	}//end delete()
	
	/////update///
	public boolean update(AssessComplaint record)  {
		return domainDao.update(record);
	}//end update()
			
	/////select///
	public AssessComplaint select(Integer id)  {
		return domainDao.select(id);
	}//end select()
	
}//end class
