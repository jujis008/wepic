package com.wetuo.wepic.publish.service ;
 
import java.util.*;

import com.wetuo.wepic.publish.beans.PublishSpecialCat;
import com.wetuo.wepic.publish.dao.PublishSpecialCatDao;
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.core.beans.User;
 
public class PublishSpecialCatServiceImpl implements PublishSpecialCatService {
	PublishSpecialCatDao domainDao;
	public PublishSpecialCatDao getPublishSpecialCatDao() {
		return domainDao;
	}//
	public void setPublishSpecialCatDao(PublishSpecialCatDao  domainDao) {
		this.domainDao = domainDao;
	}//
	
	//////////////common crud////////////////
	public List<PublishSpecialCat> findAll(){ 
		return domainDao.findAll();
	}
	
	public List<PublishSpecialCat> findPart(String strFields, String[] arrStrValues){ 
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
	public Integer insert(PublishSpecialCat record) {
		return domainDao.insert(record) ;
	}//end insert()
			
	/////delete///
	public boolean delete(PublishSpecialCat record)  {
		return domainDao.delete(record);
	}//end delete()
			
	public boolean delete(Integer id)  {
		return domainDao.delete(id);
	}//end delete()
	
	/////update///
	public boolean update(PublishSpecialCat record)  {
		return domainDao.update(record);
	}//end update()
			
	/////select///
	public PublishSpecialCat select(Integer id)  {
		return domainDao.select(id);
	}//end select()
	public List<PublishSpecialCat> getPublishSpecialCatList() {
		// TODO Auto-generated method stub
		return domainDao.getPublishSpecialCatList();
	}
	public Pager allOfType(final String username,final int pageSize,final int pageNo){
		return domainDao.allOfType(username, pageSize, pageNo);
	}
	
	public Pager publishPagerBySpecialId(final Integer catId,final int pageSize,final int pageNo){
		return domainDao.publishPagerBySpecialId(catId, pageSize, pageNo);
	}
	public PublishSpecialCat selectBySpecilChild(String str) {
		// TODO Auto-generated method stub
		return domainDao.selectBySpecilChild(str);
	}
	public List selectBySpecilChild(Integer str) {
		// TODO Auto-generated method stub
		return domainDao.selectBySpecilChild(str);
	}
	public List AllSpecialByUser(User user){
		return domainDao.AllSpecialByUser(user);
	}
	public PublishSpecialCat findByUser(User user){
		return domainDao.findByUser(user);
	}
	public PublishSpecialCat findAlbumn(){
		return domainDao.findAlbumn();
	}
	public PublishSpecialCat findAlbumn2(){
		return domainDao.findAlbumn2();
	}
	public List selectBySpecilChild2(Integer str,User user) {
		// TODO Auto-generated method stub
		return domainDao.selectBySpecilChild2(str,user);
	}
	public PublishSpecialCat findByUser2(User user){
		return domainDao.findByUser2(user);
	}
	public PublishSpecialCat selectByName(String name) {
		// TODO Auto-generated method stub
		return domainDao.selectByName(name);
	}
	public List allWorkSpecial(User user) {
		// TODO Auto-generated method stub
		return domainDao.allWorkSpecial(user);
	}
	public List<PublishSpecialCat> specialCatOfStory() {
		// TODO Auto-generated method stub
		return domainDao.specialCatOfStory();
	}
	public int storyPid() {
		// TODO Auto-generated method stub
		return domainDao.storyPid();
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////2.0wepic////////////////////
	public List AllSpecialIdByUserName(User user){
		return domainDao.AllSpecialIdByUserName(user);
	}
	
	public List storySpecialIdByUserName(User user){
		return domainDao.storySpecialIdByUserName(user);
		
	}
	
	public PublishSpecialCat defaultOfSpecial(){
		return domainDao.defaultOfSpecial();
	}
	public List<PublishSpecialCat> specialCatuserOfStory(int uid) {
		// TODO Auto-generated method stub
		return domainDao.specialCatuserOfStory(uid);
	}
}//end class
