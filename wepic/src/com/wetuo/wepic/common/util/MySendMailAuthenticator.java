package com.wetuo.wepic.common.util;


import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MySendMailAuthenticator  extends Authenticator {
	String username="";  
    String password="";  
    public MySendMailAuthenticator(String user,String pass){  
        this.username=user;  
        this.password=pass;  
    }  
    protected PasswordAuthentication getPasswordAuthentication() {  
        return new PasswordAuthentication(username,password);  
    }  
}
