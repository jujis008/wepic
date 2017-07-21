package com.sms.util;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class SendMes {

	/**
	 * @param args
	 */
	
	
	public static void sendSMS(String mobile,String message){
		
		
		
		
		
	} 
	public static void main(String[] args) {
		SendSMS ss = new SendSMS();
		ss.setUsername("639198");
		ss.setPassword("8df7ed01c3e41c43cbd9d9df75eb99c3");
		ss.setMessage("测试时间。。。。。。");
		ss.setMobiles("13013592332");
		ss.setServicesRequestAddRess("http://sms.c8686.com/Api/BayouSmsApiEx.aspx");
		ss.setSmstype(0);
		ss.setTimerid("0");
		ss.setTimertype(0);
		Map<String, String> map = ss.sendSMS();
		Iterator<Entry<String, String>> it = map.entrySet().iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		

	}

}