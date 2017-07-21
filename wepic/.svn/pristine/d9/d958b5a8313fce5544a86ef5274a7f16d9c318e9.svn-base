package com.wetuo.wepic.common.service;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.wetuo.wepic.core.dao.UserCatDao;


//在web应用中一般用ContextLoaderListener加载webapplication,
//如果需要在action之外或者control类之外获取webapplication思路之一是，单独写个类放在static变量中，

public class AppContext {
	private static AppContext instance;
	private AbstractApplicationContext appContext;
	
	public synchronized static AppContext getInstance() {
	    if (instance == null) {
	      instance = new AppContext();
	    }
	    return instance;
	}
	
	private AppContext() {
		//this.appContext = new ClassPathXmlApplicationContext("/applicationContext.xml");
		this.appContext = new ClassPathXmlApplicationContext("/com/qhkj/config/service/applicationContext.xml");
	    
	}
	
	public  AppContext(String appContextGetMode , String acXmlPath) {
		//ClassPathXmlApplicationContext[只能读放在web-info/classes目录下的配置文件]和FileSystemXmlApplicationContext的区别
		//this.appContext = new ClassPathXmlApplicationContext("/applicationContext.xml");
		//ApplicationContext ac = null ;
		if(appContextGetMode.toLowerCase().contains("classpath")){
		//if(appContextGetMode.indexOf("class") > -1){
			System.out.println("classpath");
					//如果要使用classpath路径,需要前缀classpath:
			//classpath:前缀是不需要的,默认就是指项目的classpath路径下面;			
			//ac = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml","dao.xml"});
			//appContext = new ClassPathXmlApplicationContext("classpath:" + acXmlPath +  "applicationContext.xml");
			
			//0k
			appContext = new ClassPathXmlApplicationContext("/com/qhkj/config/service/applicationContext.xml");
			//appContext = new ClassPathXmlApplicationContext(acXmlPath + "applicationContext.xml");
			
		}else if(appContextGetMode.contains("files")){//在获取失败时抛出异常
			//如果要使用绝对路径,需要加上file:前缀表示这是绝对路径;
			//对于FileSystemXmlApplicationContext:	默认表示的是两种:
			//1.没有盘符的是项目工作路径,即项目的根目录;			2.有盘符表示的是文件绝对路径.

			appContext = new FileSystemXmlApplicationContext(acXmlPath + "applicationContext.xml");			
		}else if(appContextGetMode.contains("servlet")){//在获取失败时返回null
//			ac = WebApplicationContextUtils.getRequiredWebApplicationContext(ServletContext sc);
//			ApplicationContext ac2 = WebApplicationContextUtils.getWebApplicationContext(ServletContext sc);
//			ac1.getBean("beanId");
//			ac2.getBean("beanId");
			//说明：这种方式适合于采用Spring框架的B/S系统，通过ServletContext对象获取ApplicationContext对象，然后在通过它获取需要的类实例。
			//其中 servletContext sc 可以具体 换成 servlet.getServletContext()或者this.getServletContext() 或者 request.getSession().getServletContext(); 
			//另外，由于spring是注入的对象放在ServletContext中的，所以可以直接在ServletContext取出 WebApplicationContext 对象： 
//			WebApplicationContext webApplicationContext = 
//				(WebApplicationContext) servletContext.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
						
		}
		
		//return ac ;
	}
	
	public AbstractApplicationContext getAppContext() {
	    return appContext;
	}
	

	public static ApplicationContext getAppContext(String appContextGetMode , String acXmlPath) {
		//ClassPathXmlApplicationContext[只能读放在web-info/classes目录下的配置文件]和FileSystemXmlApplicationContext的区别
		//this.appContext = new ClassPathXmlApplicationContext("/applicationContext.xml");
		ApplicationContext ac = null ;
		if(appContextGetMode.toLowerCase().contains("classpath")){
			//如果要使用classpath路径,需要前缀classpath:
			//classpath:前缀是不需要的,默认就是指项目的classpath路径下面;			
			//ac = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml","dao.xml"});
			//0k
			//ac = new ClassPathXmlApplicationContext("/com/qhkj/config/service/applicationContext.xml");
			//ac = new ClassPathXmlApplicationContext(acXmlPath + "applicationContext.xml");
			ac = new ClassPathXmlApplicationContext("classpath:" + acXmlPath +  "applicationContext.xml");
			
		}else if(appContextGetMode.contains("files")){//在获取失败时抛出异常
			//如果要使用绝对路径,需要加上file:前缀表示这是绝对路径;
			//对于FileSystemXmlApplicationContext:	默认表示的是两种:
			//1.没有盘符的是项目工作路径,即项目的根目录;			2.有盘符表示的是文件绝对路径.

			ac = new FileSystemXmlApplicationContext(acXmlPath + "applicationContext.xml");			
		}else if(appContextGetMode.contains("servlet")){//在获取失败时返回null
//			ac = WebApplicationContextUtils.getRequiredWebApplicationContext(ServletContext sc);
//			ApplicationContext ac2 = WebApplicationContextUtils.getWebApplicationContext(ServletContext sc);
//			ac1.getBean("beanId");
//			ac2.getBean("beanId");
			//说明：这种方式适合于采用Spring框架的B/S系统，通过ServletContext对象获取ApplicationContext对象，然后在通过它获取需要的类实例。
			//其中 servletContext sc 可以具体 换成 servlet.getServletContext()或者this.getServletContext() 或者 request.getSession().getServletContext(); 
			//另外，由于spring是注入的对象放在ServletContext中的，所以可以直接在ServletContext取出 WebApplicationContext 对象： 
//			WebApplicationContext webApplicationContext = 
//				(WebApplicationContext) servletContext.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
						
		}
		
		return ac ;
	}
	

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//AppContext appContext = new AppContext();
		//AppContext appContext = new AppContext("classpath","/com/qhkj/config/service/");
		//ok
		//UserCatDao userCatDao = (UserCatDao)appContext.getAppContext().getBean("userCatDao") ;
		//
		UserCatDao userCatDao = (UserCatDao)AppContext.getAppContext("classpath","/com/qhkj/config/service/").getBean("userCatDao") ;
		//
		
		String userCatName = userCatDao.select(8).getName();
		System.out.println("userCatName : " + userCatName);
	}

}//end class
