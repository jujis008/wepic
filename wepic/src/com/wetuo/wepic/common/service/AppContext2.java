package com.wetuo.wepic.common.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.wetuo.wepic.core.dao.UserCatDao;

public class AppContext2 extends ApplicationObjectSupport{
	//说明：抽象类ApplicationObjectSupport提供getApplicationContext()方法，可以方便的获取到ApplicationContext。
	//Spring初始化时，会通过该抽象类的setApplicationContext(ApplicationContext context)方法将ApplicationContext 对象注入。

	//
	/*
	 * 方法四：继承自抽象类WebApplicationObjectSupport
说明：类似上面方法，调用getWebApplicationContext()获取WebApplicationContext
方法五：实现接口ApplicationContextAware
说明：实现该接口的setApplicationContext(ApplicationContext context)方法，并保存ApplicationContext 对象。
Spring初始化时，会通过该方法将ApplicationContext对象注入。

	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AppContext2 appContext2 = new AppContext2();
		//ApplicationContext ac = new FileSystemXmlApplicationContext("/com/qhkj/config/service/applicationContext.xml");
		ApplicationContext ac = appContext2.getApplicationContext();//("/com/qhkj/config/service/applicationContext.xml");
		
		UserCatDao userCatDao = (UserCatDao)ac.getBean("userCatDao") ;
		//this.appContext = new ClassPathXmlApplicationContext("/com/qhkj/config/service/applicationContext.xml");
	    
		String userCatName = userCatDao.select(8).getName();
		System.out.println("userCatName : " + userCatName);		
	}

}//end class
