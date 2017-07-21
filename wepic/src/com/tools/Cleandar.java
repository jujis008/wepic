package com.tools;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.codehaus.jackson.map.deser.TimestampDeserializer;
public class Cleandar {
	public static int TimeDay(Map<String,Object> m)throws Exception{
		  SimpleDateFormat  dsf1 = new SimpleDateFormat("yyyy/MM/dd");
		  
		  Calendar d1 = Calendar.getInstance();
		  //开始时间
		  d1.setTime(dsf1.parse(m.get("START_DATE").toString()));
		  //结束时间
		  Calendar d2 = Calendar.getInstance();
		  d2.setTime(dsf1.parse(m.get("END_DATE").toString()));
		  //相差天数C
		  int days = d2.get(Calendar.DAY_OF_YEAR) - d1.get(Calendar.DAY_OF_YEAR);
		  d1 = (Calendar) d1.clone();
		  //不是同一年的情况下
		  while(d1.get(Calendar.YEAR) < d2.get(Calendar.YEAR)){
		   days = 365*(d2.get(Calendar.YEAR)-d1.get(Calendar.YEAR))+days-365;
		   
		   d1.add(Calendar.YEAR, d2.get(Calendar.YEAR)-d1.get(Calendar.YEAR));
		  }
		return days;
		}
	public static int TimeDay2(Map<String,Object> m)throws Exception{
		  SimpleDateFormat  dsf1 = new SimpleDateFormat("yyyy-MM-dd");
		  
		  Calendar d1 = Calendar.getInstance();
		  //开始时间
		  d1.setTime(dsf1.parse(m.get("START_DATE").toString()));
		  //结束时间
		  Calendar d2 = Calendar.getInstance();
		  d2.setTime(dsf1.parse(m.get("END_DATE").toString()));
		  //相差天数C
		  int days = d2.get(Calendar.DAY_OF_YEAR) - d1.get(Calendar.DAY_OF_YEAR);
		  d1 = (Calendar) d1.clone();
		  //不是同一年的情况下
		  while(d1.get(Calendar.YEAR) < d2.get(Calendar.YEAR)){
		   days = 365*(d2.get(Calendar.YEAR)-d1.get(Calendar.YEAR))+days-365;
		   
		   d1.add(Calendar.YEAR, d2.get(Calendar.YEAR)-d1.get(Calendar.YEAR));
		  }
		return days;
		}
	    // date 时间你要计算的时间
    	//day 为天数-day为在date的基础上减去day天day为在date的基础上加上day天
	   public static String getTime(int day,String date) {
		  try{
		  SimpleDateFormat  dsf1 = new SimpleDateFormat("yyyy/MM/dd");
		  Calendar d1 = Calendar.getInstance();
		  //开始时间
		   Date date2= dsf1.parse(date);
		   d1.setTime(date2);
		   d1.add(Calendar.DAY_OF_YEAR, day);
		    
		  
		   return dsf1.format(d1.getTime());
		  // System.out.println( dsf1.format( d1.getTime()));
		  }catch (Exception e) {
			e.printStackTrace();
		}
		  return "";
		  
	  }
	   public static String getTime(Date date) {
			  try{
			  SimpleDateFormat  dsf1 = new SimpleDateFormat("yyyy/MM/dd");
			  
			   return dsf1.format(date.getTime());
			  // System.out.println( dsf1.format( d1.getTime()));
			  }catch (Exception e) {
				e.printStackTrace();
			}
			  return "";
			  
		  }
	   
	   
	   public static String getTime() {
			  try{
			  SimpleDateFormat  dsf1 = new SimpleDateFormat("yyyyMMddHHmmssSSS");
			
			  
			   return dsf1.format(new Date());
			  // System.out.println( dsf1.format( d1.getTime()));
			  }catch (Exception e) {
				e.printStackTrace();
			}
			  return "";
			  
		  }
	  public static void main(String[] args) {
		  
		  getTime(1, "2013-8-22");
		
	}
	  public static String getTimer(Timestamp timestamp ){
		long mimus1=new Date().getTime()-timestamp.getTime();
		int cha=(int)mimus1/1000/60;
		String content="";
	  	int hourse=cha/60;
	       if(hourse>1&&hourse<24){
	    	   content=hourse+"小时以前";
	      }
	       else if(hourse<1){
	    	   content=cha+"分钟以前";
	    	   if(cha==0){
	    		   content="刚刚"; 
	    		   
	    	   }
	       }
	       else if(hourse>24&&hourse<48){
	    	   content="昨天";    
	       }else{  	   
	    	   content=new SimpleDateFormat("yyyy/MM/dd").format(timestamp);     
	       }
		
		return content;
		  
		  
		  
	  }
	
	

}
