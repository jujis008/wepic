
package com.wetuo.wepic.common.hibernate ;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
	
	private static String CONFIG_FILE_LOCATION = "/hibernate.cfg.xml";
	@SuppressWarnings("unchecked")
	private static final ThreadLocal threadLocal = new ThreadLocal();
	private static final Configuration cfg = new Configuration();
	private static org.hibernate.SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public static Session currentSession() throws HibernateException {
		Session session = (Session) threadLocal.get();
		if (session == null) {
			if (sessionFactory == null) {
				try {
					cfg.configure(CONFIG_FILE_LOCATION);
					sessionFactory = cfg.buildSessionFactory();
				}catch (Exception e) {
					System.err.println("%%%% Error Creating SessionFactory %%%%");
					e.printStackTrace();
				}//end catch
			}//end if
			session = sessionFactory.openSession();
			threadLocal.set(session);
		}//end if(session == null)
		return session;
	}//currentSession()
	
	@SuppressWarnings("unchecked")
	public static void closeSession() throws HibernateException {
		Session session = (Session) threadLocal.get();
		threadLocal.set(null);
		
		if (session != null) {
			session.close();
		}//end if
	}//end closeSession()
	
	 private HibernateSessionFactory() {
	 }
	
//<!-- @#$% -->
	
}//end class
