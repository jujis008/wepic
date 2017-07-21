package com.wetuo.wepic.publish.dao ;
 
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.orm.hibernate3.HibernateCallback;

import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.hibernate.XgHibernateCommonDao;
import com.wetuo.wepic.publish.beans.PublishCat_Story;

import java.sql.SQLException;
 
public class PublishCat_StoryDaoImpl extends XgHibernateCommonDao implements PublishCat_StoryDao {
	private static Log log = LogFactory.getLog(PublishCat_StoryDaoImpl.class);
	private static int rowCount = 0;
	//////////////common crud//////////////////////////////////////////////
	@SuppressWarnings("unchecked")
	public List<PublishCat_Story> findAll(){ 
		return (List<PublishCat_Story>)getHibernateTemplate().find("from PublishCat_Story");
	}
	
	public List<PublishCat_Story> findPart(String strFields, String[] arrStrValues){ 
		return (List<PublishCat_Story>)getHibernateTemplate().find("from PublishCat_Story where "+strFields, arrStrValues);
	}
	
public Pager list(final int pageSize,final int pageNo)  {	
	Pager pager = null;	
	//??????HibernateCallback????4??��??
	List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
		//???HibernateCallback?????????????
		public Object doInHibernate(Session session) throws HibernateException, SQLException {
			//???Hibernate??????
			//List result = session.createQuery(hql).setParameter(0, value).setFirstResult(offset).setMaxResults(pageSize).list();
			Criteria criteria = session.createCriteria(PublishCat_Story.class);
			PublishCat_StoryDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
			criteria.setProjection(null);
			criteria.setFirstResult(pageSize * (pageNo - 1));
			criteria.setMaxResults(pageSize);
			List<?> result = criteria.list();
			return result;
		}
	});
	pager = new Pager(pageSize, pageNo, PublishCat_StoryDaoImpl.rowCount, list);
	return pager;
	
	}//end list()
public Pager list(final String username,final int pageSize,final int pageNo)  {	
	Pager pager = null;	
	//??????HibernateCallback????4??��??
	List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
		//???HibernateCallback?????????????
		public Object doInHibernate(Session session) throws HibernateException, SQLException {
			//???Hibernate??????
			//List result = session.createQuery(hql).setParameter(0, value).setFirstResult(offset).setMaxResults(pageSize).list();
			Criteria criteria = session.createCriteria(PublishCat_Story.class);
			PublishCat_StoryDaoImpl.rowCount = ((Integer) criteria.setProjection( Projections.rowCount()).uniqueResult()).intValue();
			criteria.setProjection(null);
			criteria.setFirstResult(pageSize * (pageNo - 1));
			criteria.setMaxResults(pageSize);
			List<?> result = criteria.list();
			return result;
		}
	});
	pager = new Pager(pageSize, pageNo, PublishCat_StoryDaoImpl.rowCount, list);
	return pager;
	
	}//end list()
public List list(final int storyId)  {	
	//Pager pager = null;	
	//??????HibernateCallback????4??��??
	//Hibernate.initialize(Publish.b);
	List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
		//???HibernateCallback?????????????
		public Object doInHibernate(Session session) throws HibernateException, SQLException {
			//???Hibernate??????
			//List result = session.createQuery(hql).setParameter(0, value).setFirstResult(offset).setMaxResults(pageSize).list();
			Query criteria = session.createQuery("  from PublishCat_Story as cat  where cat.story.id="+storyId);
		List<?> result = criteria.list();
		List result2=new ArrayList();
		
			return result;
		}
	});
	//pager = new Pager(list);
	return list;
	
	}//end list()

 




	public Pager list(final Map<String,Object> mapSqlParam,final int pageSize,final int pageNo)  {
		Pager pager = null;
		//??????HibernateCallback????4??��??
		List list = getHibernateTemplate().executeFind(new HibernateCallback()	{
		//???HibernateCallback?????????????
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Set setKeyOfMap = new HashSet();
				setKeyOfMap = mapSqlParam.keySet();
				//
				Iterator itKey = setKeyOfMap.iterator();
				String strWhereParam = "";
				int intIWhere = 0;
				while(itKey.hasNext()){
					String strKeyI = (String)itKey.next();
					if(intIWhere == 0){
					strWhereParam = strWhereParam + " a." + strKeyI + " = ? " ;
					}else strWhereParam = strWhereParam + " and a." + strKeyI + " = ? " ; 
					intIWhere++;
				}//end while
				//???Hibernate??????
				int intSerial = 0;
				Query q = session.createQuery("select count(*) from  PublishCat_Story  a where " + strWhereParam );
				Iterator itKey2 = setKeyOfMap.iterator();
				while(itKey2.hasNext()){
					String strKeyI2 = (String)itKey2.next();
					q.setParameter(intSerial,mapSqlParam.get(strKeyI2)); 
					intSerial++;
				}
				Object count = q.uniqueResult();
				PublishCat_StoryDaoImpl.rowCount = Integer.parseInt(count.toString());
				//
				intSerial = 0;
				q = session.createQuery("select a from PublishCat_Story a where " + strWhereParam );
				Iterator itKey3 = setKeyOfMap.iterator();
				while(itKey3.hasNext()){
					String strKeyI3 = (String)itKey3.next();
					q.setParameter(intSerial,mapSqlParam.get(strKeyI3)); 
					intSerial++;
				}
				q.setMaxResults(pageSize);
				q.setFirstResult((pageNo - 1) * pageSize);
				List<?> resultList = q.list();
				return resultList;
				}
		});
		pager = new Pager(pageSize, pageNo, PublishCat_StoryDaoImpl.rowCount, list);
		return pager;
		
	}//end list()
		
	/////insert///
	public Integer insert(PublishCat_Story record) {
		Integer integerRet = null; 
		return (Integer)getHibernateTemplate().save(record);
	}//end insert()
			
	/////get max(id)///
	public int getMaxShowIndex(final String strEntityName,final String strFieldName ) {  
		List list = null; 
		int maxShowIndex = 1;   
		HibernateCallback callback = new HibernateCallback() {
			public Object doInHibernate(Session session)  throws HibernateException { 
				Query q = session.createQuery("select max("+strFieldName+") from "+strEntityName+""); 
				return q.list(); 
			} 
		};
		list = (List) getHibernateTemplate().execute(callback); 
		if (list != null){ 
			if (list.size() == 1) {
				if (list.get(0)!=null) ///���û�����,����᷵��һ��null 
					maxShowIndex = ((Integer) list.get(0)).intValue(); 
			}//end if 
		}//end if 
		return maxShowIndex; 
	}//end  getMaxShowIndex() 
	
	/////delete///
	public boolean delete(PublishCat_Story record)  {
		getHibernateTemplate().delete(record);
		return true;
	}//end delete()
			
	public boolean delete(Integer id)  {
		Object obj = getHibernateTemplate().load(PublishCat_Story.class,new Integer(id));
		getHibernateTemplate().delete(obj);
		return true;
	}//end delete()
			
	/////update///
	public boolean update(PublishCat_Story record)  {
		getHibernateTemplate().update(record);
		return true;
		
	}//end update()
	/////select///
	public PublishCat_Story select(Integer id)  {
		return (PublishCat_Story) getHibernateTemplate().get(PublishCat_Story.class, new Integer(id));
		
		
	}//end select()
	
	/////main///
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
}//end class
