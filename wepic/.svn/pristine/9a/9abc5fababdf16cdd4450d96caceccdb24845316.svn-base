package com.tools;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.sms.util.SendSMS;
import com.wetuo.wepic.common.util.SendEmail;

public class SendMsg {
	public void sendMsgByTel(String tel,String tex){
		SendSMS ss = new SendSMS();
		//User user=bidResponseInvited.getUser();
		ss.setUsername("639198");
		ss.setPassword("8df7ed01c3e41c43cbd9d9df75eb99c3");
		ss.setMessage(tex);
		ss.setMobiles(tel);
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
	
	
	public void sendMsgByEmail(String email,String tex){
		
		
		
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-mm-dd HH:MM:ss");
		String date=dateFormat.format(new Date());
		
//			String content1="<span style='font-size:12px;'>亲爱的用户！<br/>";
//	        content1+="您好:<br/>";
//	        content1+="您在&nbsp;"+date+"&nbsp;提交了邮箱找回密码请求，请点击下面的链接修改密码。<br/>";
//	        content1+="<a href='#'>登录文图</a><br/>";
//	        content1+="<span style='color:#CCC;font-size:12px;'>（如果以上链接无法点击，请将上面的地址复制到你的浏览器(如IE)的地址栏进入唯图网.）</span><br/></span>" +
//	        		"<span style='font-size:12px;'>为了保证您帐号的安全，该链接有效期为30分钟！</span>";
//	       // content1+="<img src=\"cid:a00000001\">keyyang<br/><br/>";
//	        content1+="<span style='font-size:12px;'><br/>唯图网账号团队<br/></span>";
//	        content1+="key@wepic.cn";
	        Map<String,String> map=new HashMap<String,String>();  
	          
	        //邮件服务器主机名(smtp服务器地址)  
	        //如：qq的smtp服务器地址：smtp.qq.com  
	        map.put("smtp", "smtp.qq.com");  
	        //邮件传输协议：如smtp  
	        map.put("protocol", "smtp");  
	        //登录邮箱的用户名  
	        map.put("username", "message@wepic.cn");  
	        //登录邮箱的密码  
	        map.put("password", "wepic20070804");  
	        //发送人的帐号  
	        map.put("from", "message@wepic.cn");  
	        //接收人的帐号，多个以","号隔开  
	        map.put("to", email);  
	        //邮件主题  
	        map.put("subject", "唯图网！约拍商业拍摄提醒");  
	        //邮件内容  
	        map.put("body", tex);  
	          
	        //内嵌了多少张图片，如果没有，则new一个不带值的Map  
	        Map<String,String> image=new HashMap<String,String>();  
	        //image.put("a00000001", "D:/a1.png");  
	          
	        //附件的绝对路径,不发附件则new一个不带值的List  
	        List<String> list=new ArrayList<String>();  
	        //list.add("D:/hhx.js");  
	          
	        //创建实例  
	        SendEmail sm=new SendEmail(map,list,image);  
			//SendEmail send=new SendEmail();
			try {
				sm.activeMail(email);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		
		
	}

}
