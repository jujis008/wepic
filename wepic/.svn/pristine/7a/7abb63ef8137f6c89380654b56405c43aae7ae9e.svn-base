/*
 * Created on 2011-6-23
 * filename: EnhanceMySQLDialect.java
 * Description: XXXXXXXX
 * Copyright: Copyright(c)2011
 * Company: WSN
 */
package com.wetuo.wepic.common.hibernate;

import java.sql.Types;

import org.hibernate.Hibernate;
import org.hibernate.dialect.MySQLDialect;

/**
 * Title: Class EnhanceMySQLDialect Description: XXXX Copyright: Copyright (c)
 * 2010 Company: WSN
 * 
 * @author houjiazi
 * @version 1.0
 */
public class EnhanceMySQLDialect extends MySQLDialect {
	public EnhanceMySQLDialect() {
		super();
		registerHibernateType(Types.LONGVARCHAR, Hibernate.STRING.getName());
	}
}
