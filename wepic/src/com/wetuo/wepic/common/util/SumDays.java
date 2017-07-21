package com.wetuo.wepic.common.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;

import sun.java2d.pipe.SpanShapeRenderer.Simple;

public class SumDays {
	public  static String getId(String ziduan) {
		Random r = new Random();
        int t = r.nextInt(999999)+100000;
		Calendar  calendar  =  Calendar.getInstance();
		 
		 Calendar c = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"));    //获取东八区时间
		  int day = c.get(Calendar.DAY_OF_MONTH);    //获取当前天数
		  int dayst=0;
		 int month=c.get(Calendar.MONTH)+1;
		 int year = c.get(Calendar.YEAR); 
		 int days=0;
		 SimpleDateFormat format=new SimpleDateFormat("yy");
		 String yearId=format.format(new Date());
		  for(int i=1;i<month;i++){
			   
			  calendar.set(year,i-1,1);
			  dayst =calendar.getActualMaximum(calendar.DAY_OF_MONTH);
			  System.out.println(dayst);
			  days+=dayst;
		 }
		    
		 String orderId=yearId;
		 String  len=days+"";//.length();
		 System.out.println(len);
		 if(len.length()==1){
			 orderId=orderId+"00"+ziduan+len+t; 
		 }
		 else if(len.length()==2){
			 String str=len.substring(0,1);
			 String str2=len.substring(1,2);
			 orderId=orderId+"0"+str+ziduan+str2+t; 
		 }
		 else {
			 
			 String str=len.substring(0,2);
			 String str2=len.substring(2,3);
			 orderId=orderId+str+ziduan+str2+t; 
		}
           
		 return orderId;
	    
	}
	
}
