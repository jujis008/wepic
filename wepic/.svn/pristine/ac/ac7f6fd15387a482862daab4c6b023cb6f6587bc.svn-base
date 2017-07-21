package com.wetuo.wepic.common.util;

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

public class Toolg {
	public static boolean sendEmail(User user) throws Exception {
		InternetAddress[] address = null;
		// request.setCharacterEncoding("utf8");
		String mailserver = "smtp.163.com";// 发出邮箱的服务器
		String From = "shsj365@163.com";// 发出的邮箱
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
			address = InternetAddress.parse(user.getEmail(), false);
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
			mbp.setContent("！<br/><br/>尊敬的用户"+user.getUsername()+"您好"
									+ "您已经进行了注册的操作，请点击以下链接(或者复制到您的浏览器):"
									+ "<br/><a href='http://localhost:8080/photography/user!check_mail.do?userName="+des.encrypt(user.getUsername())+"&uid=39608&code=e9c876137f621c4816844375ebb6c925'>"
									+ "http://localhost:8080/photography/user!check_mail.do?userName="+des.encrypt(user.getUsername())+"&uid=39608&code="+System.currentTimeMillis()
									+"<br/><br/>进行验证操作置！"
									+ "<br/><br/><br>", type + ";charset=utf8");
			mp.addBodyPart(mbp);
			msg.setContent(mp);

			Transport transport = mailSession.getTransport("smtp");
			// //请填入你的邮箱用户名和密码,千万别用我的^_^
			transport.connect(mailserver, "shsj365@163.com", "110663");// 设发出邮箱的用户名、密码
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();
			// Transport.send(msg);
			System.out.println("邮件已顺利发送");
			System.out.println("/////////////////////////////////////////////////////////////////////////////////////////");
			return true;

		} catch (MessagingException mex) {
			mex.printStackTrace();
			// System.out.println(mex);
			return false;
		}
    
	}
 public static void main(String[] args) {
	 System.out.println("==========================================");
	 User user=new User();
	 user.setUsername("qqqqqqqqqqqqqqqqqqqqqq");
	 
	try {
		sendEmail(user);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

}
