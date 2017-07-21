package com.wetuo.wepic.core.service ;
 
import java.util.*;


import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.core.beans.UserCat;
import com.wetuo.wepic.core.dao.UserCatDao;
import com.wetuo.wepic.common.hibernate.Pager;
 
public class UserCatServiceImpl implements UserCatService {
	UserCatDao domainDao;
	public List<UserCat> find(String type) {
		// TODO Auto-generated method stub
		return domainDao.find(type);
	}
	
	
	/****************2.0****************************************************************************/
	public UserCatDao getUserCatDao() {
		return domainDao;
	}//
	public void setUserCatDao(UserCatDao  domainDao) {
		this.domainDao = domainDao;
	}//
	
	//////////////common crud////////////////
	public List<UserCat> findAll(){ 
		return domainDao.findAll();
	}
	
	public List<UserCat> findPart(String strFields, String[] arrStrValues){ 
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
	public Integer insert(UserCat record) {
		return domainDao.insert(record) ;
	}//end insert()
			
	/////delete///
	public boolean delete(UserCat record)  {
		return domainDao.delete(record);
	}//end delete()
			
	public boolean delete(Integer id)  {
		return domainDao.delete(id);
	}//end delete()
	
	/////update///
	public boolean update(UserCat record)  {
		return domainDao.update(record);
	}//end update()
			
	/////select///
	public UserCat select(Integer id)  {
		return domainDao.select(id);
	}//end select()
	public List<List<UserCat>> getLevel2UserCatMapUnderProjectCat(int pid) {
		// TODO Auto-generated method stub
		return domainDao.getLevel2UserCatMapUnderProjectCat(pid);
	}
	public List<UserCat> getNextLevelCatList(List<UserCat> list) {
		// TODO Auto-generated method stub
		return domainDao.getNextLevelCatList(list);
	}
	public List<UserCat> getUserCatListJustUnderProjectCat(int pid) {
		// TODO Auto-generated method stub
		return domainDao.getUserCatListJustUnderProjectCat(pid);
	}
	public List<UserCat> getUserCatListUnderPid(int pid) {
		// TODO Auto-generated method stub
		return domainDao.getUserCatListUnderPid(pid);
	}
	public List<UserCat> getUserCatListUnderProjectCat(int pid) {
		// TODO Auto-generated method stub
		return domainDao.getUserCatListUnderProjectCat(pid);
	}
	public Map<UserCat, List<UserCat>> getUserCatMapUnderProjectCat(int pid) {
		// TODO Auto-generated method stub
		return domainDao.getUserCatMapUnderProjectCat(pid);
	}
	
	public List<UserCat> findAllFathers(int id) {
		// TODO Auto-generated method stub
		return domainDao.findAllFathers(id);
	}
	public UserCat findFather(int id) {
		// TODO Auto-generated method stub
		return domainDao.findFather(id); 
	}
	public List<UserCat> getUserCatListUnderUserCat(int pid) {
		// TODO Auto-generated method stub
		return domainDao.getUserCatListUnderUserCat(pid);
	}
	public List<UserCat> getuserCatListJustUnderCat(int pid) {
		// TODO Auto-generated method stub
		return domainDao.getuserCatListJustUnderCat(pid);
	}
	public List<UserCat> getUserCatListForRegister() {
		// TODO Auto-generated method stub
		return domainDao.getUserCatListForRegister();
	}
	public UserCat findByPid(Integer id) {
		// TODO Auto-generated method stub
		return domainDao.findByPid(id);
	}
	

	
	
	
}//end class
