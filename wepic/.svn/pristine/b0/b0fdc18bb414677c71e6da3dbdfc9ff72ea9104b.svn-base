package com.wetuo.wepic.common.util;

import java.net.URLEncoder;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.wetuo.wepic.core.beans.User;

public class MailSend {
	String host = "smtp.163.com";   //发件人使用发邮件的电子信箱服务器
	String from = "shsj365@163.com";    //发邮件的出发地（发件人的信箱）
	String to = "273204736@qq.com";;   //发邮件的目的地（收件人信箱）
	String password = "110663";

    public MailSend(String to) {
		this.to = to;
	}
    public MailSend() {
	}
	public void send(String codePwd) throws Exception {
		InternetAddress[] address = null;
		// request.setCharacterEncoding("utf8");
		String mailserver = "smtp.163.com";// 发出邮箱的服务器
		String From = "mylovehehaixia@163.com";// 发出的邮箱
		// String to = "";//发到的邮箱李文斌(1186101927);
		// String Subject = "嗨，亲爱的 ";//标题
		String type = "text/html";// 发送邮件格式为html
//		String messageText = new GetSource()
//				.getSource("http://localhost:8080/ClothShopping/foreground/mes.jsp");// 写入你要发送的页面连接，将此页面读为String
//		// messageText = URLEncoder.encode(messageText,"utf8");

		boolean sessionDebug = false;

		try {

			// 设定所要用的Mail 服务器和所使用的传输协议
			java.util.Properties props = new Properties();
			props.put("mail.host", mailserver);
			props.put("mail.transport.protocol", "smtp");
			props.put("mail.smtp.auth", "true");// 指定是否需要SMTP验证

			// 产生新的Session 服务
			Session mailSession = Session.getDefaultInstance(props, null);
			mailSession.setDebug(sessionDebug);
			Message msg = new MimeMessage(mailSession);

			// 设定发邮件的人
			msg.setFrom(new InternetAddress(From));

			// 设定收信人的信箱
			address = InternetAddress.parse("605950358@qq.com", false);
			msg.setRecipients(Message.RecipientType.TO, address);

			// 设定信中的主题
			msg.setSubject("注册验证链接");

			// 设定送信的时间
			// msg.setSentDate(new Date());

			Multipart mp = new MimeMultipart();
			MimeBodyPart mbp = new MimeBodyPart();
			 MD5Code des = new MD5Code("leemenz");
			 
			Object customer;
			// 设定邮件内容的类型为 text/plain 或 text/html
			mbp.setContent( codePwd  ,type);
			mp.addBodyPart(mbp);
			msg.setContent(mp);

			Transport transport = mailSession.getTransport("smtp");
			// //请填入你的邮箱用户名和密码,千万别用我的^_^
			transport.connect(mailserver, From, "hehaixia111420 ");// 设发出邮箱的用户名、密码
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();
			// Transport.send(msg);
			System.out.println("邮件已顺利发送");
			System.out.println("/////////////////////////////////////////////////////////////////////////////////////////");
			
		} catch (MessagingException mex) {
			mex.printStackTrace();
			// System.out.println(mex);
			
		}
    
	}
	public void sendDealCode(String codePwd,String email) throws Exception {
		InternetAddress[] address = null;
		// request.setCharacterEncoding("utf8");
		String mailserver = "smtp.qq.com";// 发出邮箱的服务器
		String From = "1412467907@qq.com";// 发出的邮箱
		// String to = "";//发到的邮箱李文斌(1186101927);
		// String Subject = "嗨，亲爱的 ";//标题
		String type = "text/html";// 发送邮件格式为html
//		String messageText = new GetSource()
//				.getSource("http://localhost:8080/ClothShopping/foreground/mes.jsp");// 写入你要发送的页面连接，将此页面读为String
//		// messageText = URLEncoder.encode(messageText,"utf8");

		boolean sessionDebug = false;

		try {

			// 设定所要用的Mail 服务器和所使用的传输协议
			java.util.Properties props = new Properties();
			props.put("mail.host", mailserver);
			props.put("mail.transport.protocol", "smtp");
			props.put("mail.smtp.auth", "false");// 指定是否需要SMTP验证

			// 产生新的Session 服务
			Session mailSession = Session.getDefaultInstance(props, null);
			mailSession.setDebug(sessionDebug);
			Message msg = new MimeMessage(mailSession);

			// 设定发邮件的人
			msg.setFrom(new InternetAddress(From));

			// 设定收信人的信箱
			address = InternetAddress.parse(email, false);
			msg.setRecipients(Message.RecipientType.TO, address);

			// 设定信中的主题
			msg.setSubject("交易验证码链接");

			// 设定送信的时间
			// msg.setSentDate(new Date());

			Multipart mp = new MimeMultipart();
			MimeBodyPart mbp = new MimeBodyPart();
			 MD5Code des = new MD5Code("leemenz");
			 
			Object customer;
			// 设定邮件内容的类型为 text/plain 或 text/html
			mbp.setContent( codePwd  ,type+";charset=utf8");
			
			
			
			mp.addBodyPart(mbp);
			msg.setContent(mp);

			Transport transport = mailSession.getTransport("smtp");
			// //请填入你的邮箱用户名和密码,千万别用我的^_^
			transport.connect(mailserver, From, "123456789");// 设发出邮箱的用户名、密码
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();
			// Transport.send(msg);
			System.out.println("邮件已顺利发送");
			System.out.println("/////////////////////////////////////////////////////////////////////////////////////////");
			
		} catch (MessagingException mex) {
			mex.printStackTrace();
			// System.out.println(mex);
			
		}
    
	}
	/**
	 * 激活邮箱
	 */
	public void activateEmail(String email,int uid) {
		
	}
	public void sendDynamicPwd(String codePwd,String email) throws Exception {
		InternetAddress[] address = null;
		// request.setCharacterEncoding("utf8");
		String mailserver = "smtp.qq.com";// 发出邮箱的服务器
		String From = "1412467907@qq.com";// 发出的邮箱
		// String to = "";//发到的邮箱李文斌(1186101927);
		// String Subject = "嗨，亲爱的 ";//标题
		String type = "text/html";// 发送邮件格式为html
//		String messageText = new GetSource()
//				.getSource("http://localhost:8080/ClothShopping/foreground/mes.jsp");// 写入你要发送的页面连接，将此页面读为String
//		// messageText = URLEncoder.encode(messageText,"utf8");

		boolean sessionDebug = false;

		try {

			// 设定所要用的Mail 服务器和所使用的传输协议
			java.util.Properties props = new Properties();
			props.put("mail.host", mailserver);
			props.put("mail.transport.protocol", "smtp");
			props.put("mail.smtp.auth", "true");// 指定是否需要SMTP验证

			// 产生新的Session 服务
			Session mailSession = Session.getDefaultInstance(props, null);
			mailSession.setDebug(sessionDebug);
			Message msg = new MimeMessage(mailSession);

			// 设定发邮件的人
			msg.setFrom(new InternetAddress(From));

			// 设定收信人的信箱
			address = InternetAddress.parse(email, false);
			msg.setRecipients(Message.RecipientType.TO, address);

			// 设定信中的主题
			msg.setSubject("维图---用户注册");

			// 设定送信的时间
			// msg.setSentDate(new Date());

			Multipart mp = new MimeMultipart();
			MimeBodyPart mbp = new MimeBodyPart();
			 MD5Code des = new MD5Code("leemenz");
			 
			Object customer;
			// 设定邮件内容的类型为 text/plain 或 text/html
			mbp.setContent( codePwd  ,type+";charset=utf8");
			
			
			
			mp.addBodyPart(mbp);
			msg.setContent(mp);

			Transport transport = mailSession.getTransport("smtp");
			// //请填入你的邮箱用户名和密码,千万别用我的^_^
			transport.connect(mailserver,From, "123456789 ");// 设发出邮箱的用户名、密码
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();
			// Transport.send(msg);
			System.out.println("邮件已顺利发送");
			System.out.println("/////////////////////////////////////////////////////////////////////////////////////////");
			
		} catch (MessagingException mex) {
			mex.printStackTrace();
			// System.out.println(mex);
			
		}
    
	}
	
	public void sendEndRes(String codePwd,String email) throws Exception {
		InternetAddress[] address = null;
		// request.setCharacterEncoding("utf8");
		String mailserver = "smtp.qq.com";// 发出邮箱的服务器
		String From = "1412467907@qq.com";// 发出的邮箱
		// String to = "";//发到的邮箱李文斌(1186101927);
		// String Subject = "嗨，亲爱的 ";//标题
		String type = "text/html";// 发送邮件格式为html
//		String messageText = new GetSource()
//				.getSource("http://localhost:8080/ClothShopping/foreground/mes.jsp");// 写入你要发送的页面连接，将此页面读为String
//		// messageText = URLEncoder.encode(messageText,"utf8");

		boolean sessionDebug = false;

		try {

			// 设定所要用的Mail 服务器和所使用的传输协议
			java.util.Properties props = new Properties();
			props.put("mail.host", mailserver);
			props.put("mail.transport.protocol", "smtp");
			props.put("mail.smtp.auth", "false");// 指定是否需要SMTP验证

			// 产生新的Session 服务
			Session mailSession = Session.getDefaultInstance(props, null);
			mailSession.setDebug(sessionDebug);
			Message msg = new MimeMessage(mailSession);

			// 设定发邮件的人
			msg.setFrom(new InternetAddress(From));

			// 设定收信人的信箱
			address = InternetAddress.parse(email, false);
			msg.setRecipients(Message.RecipientType.TO, address);

			// 设定信中的主题
			msg.setSubject("交易验证码链接");

			// 设定送信的时间
			// msg.setSentDate(new Date());

			Multipart mp = new MimeMultipart();
			MimeBodyPart mbp = new MimeBodyPart();
			 MD5Code des = new MD5Code("leemenz");
			 
			Object customer;
			// 设定邮件内容的类型为 text/plain 或 text/html
			mbp.setContent( codePwd  ,type+";charset=utf8");
			mp.addBodyPart(mbp);
			msg.setContent(mp);

			Transport transport = mailSession.getTransport("smtp");
			// //请填入你的邮箱用户名和密码,千万别用我的^_^
			transport.connect(mailserver, From, "123456789 ");// 设发出邮箱的用户名、密码
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();
			// Transport.send(msg);
			System.out.println("邮件已顺利发送");
			System.out.println("/////////////////////////////////////////////////////////////////////////////////////////");
			
		} catch (MessagingException mex) {
			mex.printStackTrace();
			// System.out.println(mex);
			
		}
    
	}
	/**
	 * 发送html页面
	 * @throws Exception 
	 */
	public void sendPage() throws Exception {
		InternetAddress[] address = null;
		// request.setCharacterEncoding("utf8");
		String mailserver = "smtp.qq.com";// 发出邮箱的服务器
		String From = "605950358@qq.com";// 发出的邮箱
		// String to = "";//发到的邮箱李文斌(1186101927);
		// String Subject = "嗨，亲爱的 ";//标题
		String type = "text/html";// 发送邮件格式为html
		String codePwd="<a href='http://localhost:8080/photography/wepic1.html'>xxxxxxxxxxxxxxx</a>";
//		String messageText ="http://localhost:8080/photography/wepic1.html";// 写入你要发送的页面连接，将此页面读为String
//        messageText = URLEncoder.encode(messageText,"utf8");

		boolean sessionDebug = false;

		try {

			// 设定所要用的Mail 服务器和所使用的传输协议
			java.util.Properties props = new Properties();
			props.put("mail.host", mailserver);
			props.put("mail.transport.protocol", "smtp");
			props.put("mail.smtp.auth", "false");// 指定是否需要SMTP验证

			// 产生新的Session 服务
			Session mailSession = Session.getDefaultInstance(props, null);
			mailSession.setDebug(sessionDebug);
			Message msg = new MimeMessage(mailSession);

			// 设定发邮件的人
			msg.setFrom(new InternetAddress(From));

			// 设定收信人的信箱
			address = InternetAddress.parse("2867545626@qq.com", false);
			msg.setRecipients(Message.RecipientType.TO, address);

			// 设定信中的主题
			msg.setSubject("提现失败原因：");

			// 设定送信的时间
			// msg.setSentDate(new Date());

			Multipart mp = new MimeMultipart();
			MimeBodyPart mbp = new MimeBodyPart();
			 MD5Code des = new MD5Code("leemenz");
			 
			Object customer;
			// 设定邮件内容的类型为 text/plain 或 text/html
			
			mbp.setContent( codePwd  ,type+";charset=utf8");
			
			
			
			mp.addBodyPart(mbp);
			msg.setContent(mp);

			Transport transport = mailSession.getTransport("smtp");
			// //请填入你的邮箱用户名和密码,千万别用我的^_^
			transport.connect(mailserver, From, "shuoHAOyongYUAN ");// 设发出邮箱的用户名、密码
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();
			// Transport.send(msg);
			System.out.println("邮件已顺利发送");
			System.out.println("/////////////////////////////////////////////////////////////////////////////////////////");
			
		} catch (MessagingException mex) {
			mex.printStackTrace();
			// System.out.println(mex);
			
		}
	}
	public static void main(String[] args) throws Exception {
		MailSend mailSend=new MailSend();
		mailSend.sendPage();
	}
	public void sendEndFailReason(String codePwd,String email) throws Exception {
		InternetAddress[] address = null;
		// request.setCharacterEncoding("utf8");
		String mailserver = "smtp.qq.com";// 发出邮箱的服务器
		String From = "1412467907@qq.com";// 发出的邮箱
		// String to = "";//发到的邮箱李文斌(1186101927);
		// String Subject = "嗨，亲爱的 ";//标题
		String type = "text/html";// 发送邮件格式为html
//		String messageText = new GetSource()
//				.getSource("http://localhost:8080/ClothShopping/foreground/mes.jsp");// 写入你要发送的页面连接，将此页面读为String
//		// messageText = URLEncoder.encode(messageText,"utf8");

		boolean sessionDebug = false;

		try {

			// 设定所要用的Mail 服务器和所使用的传输协议
			java.util.Properties props = new Properties();
			props.put("mail.host", mailserver);
			props.put("mail.transport.protocol", "smtp");
			props.put("mail.smtp.auth", "false");// 指定是否需要SMTP验证

			// 产生新的Session 服务
			Session mailSession = Session.getDefaultInstance(props, null);
			mailSession.setDebug(sessionDebug);
			Message msg = new MimeMessage(mailSession);

			// 设定发邮件的人
			msg.setFrom(new InternetAddress(From));

			// 设定收信人的信箱
			address = InternetAddress.parse(email, false);
			msg.setRecipients(Message.RecipientType.TO, address);

			// 设定信中的主题
			msg.setSubject("提现失败原因：");

			// 设定送信的时间
			// msg.setSentDate(new Date());

			Multipart mp = new MimeMultipart();
			MimeBodyPart mbp = new MimeBodyPart();
			 MD5Code des = new MD5Code("leemenz");
			 
			Object customer;
			// 设定邮件内容的类型为 text/plain 或 text/html
			mbp.setContent( codePwd  ,type+";charset=utf8");
			
			
			
			mp.addBodyPart(mbp);
			msg.setContent(mp);

			Transport transport = mailSession.getTransport("smtp");
			// //请填入你的邮箱用户名和密码,千万别用我的^_^
			transport.connect(mailserver, From, "123456789 ");// 设发出邮箱的用户名、密码
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();
			// Transport.send(msg);
			System.out.println("邮件已顺利发送");
			System.out.println("/////////////////////////////////////////////////////////////////////////////////////////");
			
		} catch (MessagingException mex) {
			mex.printStackTrace();
			// System.out.println(mex);
			
		}
    
	}
	
	
	public void sendEndMes(String text,String email) throws Exception {
		InternetAddress[] address = null;
		// request.setCharacterEncoding("utf8");
		String mailserver = "smtp.qq.com";// 发出邮箱的服务器
		String From = "273204736@qq.com";// 发出的邮箱
		// String to = "";//发到的邮箱李文斌(1186101927);
		// String Subject = "嗨，亲爱的 ";//标题
		String type = "text/html";// 发送邮件格式为html
//		String messageText = new GetSource()
//				.getSource("http://localhost:8080/ClothShopping/foreground/mes.jsp");// 写入你要发送的页面连接，将此页面读为String
//		// messageText = URLEncoder.encode(messageText,"utf8");

		boolean sessionDebug = false;

		try {

			// 设定所要用的Mail 服务器和所使用的传输协议
			java.util.Properties props = new Properties();
			props.put("mail.host", mailserver);
			props.put("mail.transport.protocol", "smtp");
			props.put("mail.smtp.auth", "false");// 指定是否需要SMTP验证

			// 产生新的Session 服务
			Session mailSession = Session.getDefaultInstance(props, null);
			mailSession.setDebug(sessionDebug);
			Message msg = new MimeMessage(mailSession);

			// 设定发邮件的人
			msg.setFrom(new InternetAddress(From));

			// 设定收信人的信箱
			address = InternetAddress.parse(email, false);
			msg.setRecipients(Message.RecipientType.TO, address);

			// 设定信中的主题
			msg.setSubject("交易验证码链接");

			

			Multipart mp = new MimeMultipart();
			MimeBodyPart mbp = new MimeBodyPart();
			
			// 设定邮件内容的类型为 text/plain 或 text/html
			mbp.setContent(text ,type+";charset=utf8");
			
			
			
			mp.addBodyPart(mbp);
			msg.setContent(mp);

			Transport transport = mailSession.getTransport("smtp");
			// //请填入你的邮箱用户名和密码,千万别用我的^_^
			transport.connect(mailserver, From, "fuck110059 ");// 设发出邮箱的用户名、密码
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();
			// Transport.send(msg);
			System.out.println("邮件已顺利发送");
			System.out.println("/////////////////////////////////////////////////////////////////////////////////////////");
			
		} catch (MessagingException mex) {
			mex.printStackTrace();
			// System.out.println(mex);
			
		}
    
	}
}
