package com.wetuo.wepic.common.util;

import java.util.ArrayList;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
public class Test {
	public static void main(String[] args)throws Exception {  
		 String encoding="GBK";
         File file=new File("d:\\a.txt");
         if(file.isFile() && file.exists()){ //判断文件是否存在
             InputStreamReader read = new InputStreamReader(
             new FileInputStream(file),encoding);//考虑到编码格式
             BufferedReader bufferedReader = new BufferedReader(read);
             String lineTxt = null;
             while((lineTxt = bufferedReader.readLine()) != null){
            	 String content1 = "<p style='font-size:12px;line-height:20px;'>感谢您注册成为唯图网会员，为了维护您的权益及可追溯性，唯图网实行实名制。<br/>"+
         		"您只有进行实名认证后才能出售您的作品，才能进行商业拍摄与招募的应约。<br/>"+
         		"维图网将对您的实名信息进行严格保密，只有当您与客户达成约拍交易后被告知客户。<br/>"+
         		"唯图网温馨提醒您进行实名认证，以便让用户能浏览到您的空间，以增加您的传播机会。<br/>"+
         		"点击下面链接，进入唯图网实名认证：</p><br/><br/>";
         		        content1 += "<a href=http://www.wepic.cn/view/frontend/login.jsp>http://www.wepic.cn/view/frontend/login.jsp</a><br/><br/><br/>";
//         				content1 += "<img src=cid:a00000001\">keyyang<br/><br/>";
         				content1 += "唯图网客服经理<br/>";
         				content1 += "key@wepic.cn";
         				Map<String, String> map = new HashMap<String, String>();
                 //邮件服务器主机名(smtp服务器地址)  
                 //如：qq的smtp服务器地址：smtp.qq.com  
         				map.put("smtp", "smtp.qq.com");
         				// 邮件传输协议：如smtp
         				map.put("protocol", "smtp");
         				// 登录邮箱的用户名
         				map.put("username", "message@wepic.cn");
         				// 登录邮箱的密码
         				map.put("password", "wepic20070804");
         				// 发送人的帐号
         				map.put("from", "message@wepic.cn");
         				// 接收人的帐号，多个以","号隔开
         					map.put("to", lineTxt); 
                 //邮件内容  
         				map.put("subject","唯图网-实名认证提醒");
                 map.put("body", content1);  
                   
                 //内嵌了多少张图片，如果没有，则new一个不带值的Map  
                 Map<String,String> image=new HashMap<String,String>();  
//                 image.put("a00000001", "d://118.jpg");  
//                 
                 //附件的绝对路径,不发附件则new一个不带值的List  
                 List<String> list=new ArrayList<String>();  
                 //list.add("D:/hhx.js");  
                   
                 //创建实例  
                 SendEmail sm=new SendEmail(map,list,image);  
                 //执行发送  
                 sm.send();  
             }
             read.close();
         }
    }  
	public static void readTxtFile(String filePath){
        try {
                String encoding="GBK";
                File file=new File(filePath);
                if(file.isFile() && file.exists()){ //判断文件是否存在
                    InputStreamReader read = new InputStreamReader(
                    new FileInputStream(file),encoding);//考虑到编码格式
                    BufferedReader bufferedReader = new BufferedReader(read);
                    String lineTxt = null;
                    while((lineTxt = bufferedReader.readLine()) != null){
                        System.out.println(lineTxt);
                    }
                    read.close();
        }else{
            System.out.println("找不到指定的文件");
        }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
     
    }
     
//    public static void main(String argv[]){
//        String filePath = "L:\\Apache\\htdocs\\res\\20121012.txt";
////      "res/";
//        readTxtFile(filePath);
//    }
//	public String test() {
//        return this.getClass().getResource("/").toString();
//    }
//	public static void main(String[] args) {
//		String path=new mail().test();
//		System.out.println(path);
//		
//	}
}
