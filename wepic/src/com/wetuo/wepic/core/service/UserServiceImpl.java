package com.wetuo.wepic.core.service ;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.ImageIcon;

import net.coobird.thumbnailator.Thumbnails;

import org.apache.struts2.ServletActionContext;

import org.hibernate.criterion.DetachedCriteria;

import org.hibernate.criterion.Restrictions;

import com.qq.connect.javabeans.qzone.UserInfoBean;
import com.sms.util.SendSMS;
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.util.MD5Code;
import com.wetuo.wepic.common.util.SendEmail;
import com.wetuo.wepic.core.beans.Account;
import com.wetuo.wepic.core.beans.BlogCat;
import com.wetuo.wepic.core.beans.LoginHistory;
import com.wetuo.wepic.core.beans.RoleTags;
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.core.beans.UserCredit;
import com.wetuo.wepic.core.beans.UserCreditHistory;
import com.wetuo.wepic.core.beans.UserDetail;
import com.wetuo.wepic.core.beans.UserInfoBeans;
import com.wetuo.wepic.core.dao.UserDao;
import com.wetuo.wepic.core.tools.Level;
import com.wetuo.wepic.deal.beans.UserMess;
 
public class UserServiceImpl implements UserService {
	UserDao domainDao;
	private AccountService accountService;
	private BlogCatService blogCatService;
	private UserCreditService creditService;
	private ContactService contactService;
	private RoleTagService roleTagsService;
	private UserCreditHistoryService userCreditHistoryService;
	private LoginHistoryService loginHistoryService;
	public String initUserMustInfoForWepic(String username, String id) {
		
		try{
			 MD5Code code = new MD5Code("leemenz");
			String usernamede=code.decrypt(username);
			String idde=code.decrypt(id);
			User user=domainDao.select(usernamede);
			if(user.getId()==null&&user.getId()==0){
				return "notfinduser";
			}
			if(!idde.trim().equals(user.getId()+"".trim())){
				return "error";
			}
			 if(user.getStatu()==1){
				 
				return user.getUsername();
			 }
			 if( user.getStatu()==0){
				 
				 List list= blogCatService.findByPagerBlogCat(1, 4, user.getId()).getResultList();
				 if(list.size()<=0){
					 BlogCat blogCat=new BlogCat();
					 blogCat.setBlogCat("我的博客");
					 blogCat.setUser(user);
					 blogCatService.save(blogCat);
				 }
			    
				Account account = new Account();
				account.setUser(user);
				account.setAccountID(user.getUsername() + "_"
						+ AccountSave());
				account.setTotalMoney(new BigDecimal(0));
				account.setRemainingMoney(new BigDecimal(0));
				//account.set
				UserCredit userCredit=new UserCredit();
		 		userCredit.setBidBadRemarkNum(0);
		 		userCredit.setBidConfirmedNum(0);
		 		userCredit.setBidGetMoney(0);
		 		userCredit.setBidGiveMoney(0);
		 		userCredit.setBidNum(0);
		 		userCredit.setBidGoodRemarkNum(0);
		 		userCredit.setBuyPicMoney(0);
		 		userCredit.setDealMoney(0);
		 		userCredit.setDiamond(0);
		 		userCredit.setProductsNum(0);
		 		userCredit.setSellPicMoney(0);
		 		userCredit.setStar(0);
		 		userCredit.setTotalMark(0);
		 		//userCredit.setSellPicMoney(sellPicMoney)
		 		userCredit.setTotalMark(0);
		 		userCredit.setUser(user);
		 		creditService.insert(userCredit);
				int nid = this.getAccountService().insert(account);
			 }
			
			 domainDao.update(user);
			 username=user.getUsername();
			 
			 return usernamede;
			
		}catch (Exception e) {
			e.printStackTrace();
			 return "fail";
		}	
		
	}
	
	
	public LoginHistoryService getLoginHistoryService() {
		return loginHistoryService;
	}


	public void setLoginHistoryService(LoginHistoryService loginHistoryService) {
		this.loginHistoryService = loginHistoryService;
	}


	public boolean login(String username, String password) {
		User record = domainDao.select(username);
		if (record == null) {
				return false;
		} else {
				String pwd = record.getPassword();
				String md5pwd = null;
    		   
				 try {
					 MD5Code code = new MD5Code("leemenz");
					md5pwd = code.encrypt(password);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if ( pwd != null && pwd.equals(md5pwd) ) {
					return true;
				} else {
					return false;
				}//end else
		}//end else
	}//end login() 
	
	
	
	
	
	 public String AccountSave(){
			SimpleDateFormat format=new SimpleDateFormat("yyyyMMddHHmmssSS");
			return format.format(new Date());
	 }	
	 
	
	
	public List<User> findAll(){ 
		return domainDao.findAll();
	}
	
	
	
	public Pager list(Map<String,Object> mapSqlParam, int pageSize, int pageNo)  {
		return domainDao.list(mapSqlParam,pageSize,pageNo);
	}//end list()
	
	
	////////////////////////////////////wepic2.0/////////////////////////////////
	public int sendMsgofemail(String username, String code,String email) throws Exception {
		User userMsg = this.domainDao.select(username);
		String content1 = "尊敬的"+userMsg.getNickName()+",您好<br/><br/><br/>";
		content1 += "&nbsp;&nbsp;&nbsp;&nbsp;您在唯图网账户中修改的新邮箱为：" + email + "。<br/>";
		content1 += "&nbsp;&nbsp;请输入下面验证码用以通过系统验证："+code+"<br/><br/>";
	    content1 += "唯图网客服团队<br/>";
		content1 += "serve@wepic.cn";
		Map<String, String> map = new HashMap<String, String>();

		// 邮件服务器主机名(smtp服务器地址)
		// 如：qq的smtp服务器地址：smtp.qq.com
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
		map.put("to", email);
		// 邮件主题
		map.put("subject", "用户绑定邮箱验证");
		// 邮件内容
		map.put("body", content1);

		// 内嵌了多少张图片，如果没有，则new一个不带值的Map
		Map<String, String> image = new HashMap<String, String>();
//		String path = ServletActionContext.getRequest().getRealPath(
//				"public/images/118.jpg");
//		image.put("a00000001", path);

		// 附件的绝对路径,不发附件则new一个不带值的List
		List<String> list = new ArrayList<String>();
		SendEmail sendEmail = new SendEmail(map, list, image);
		int res=sendEmail.send();
		return res;
	}
	public int sendMsg(String username, String code) throws Exception {
		User userMsg = this.domainDao.select(username);
		String content1 = "尊敬的"+userMsg.getNickName()+",您好<br/><br/><br/>";
		content1 += "&nbsp;&nbsp;&nbsp;&nbsp;您在唯图网账户中修改的新邮箱为：" + userMsg.getEmail() + "。<br/>";
		content1 += "&nbsp;&nbsp;请输入下面验证码用以通过系统验证："+code+"<br/><br/>";
	    content1 += "唯图网客服团队<br/>";
		content1 += "serve@wepic.cn";
		Map<String, String> map = new HashMap<String, String>();

		// 邮件服务器主机名(smtp服务器地址)
		// 如：qq的smtp服务器地址：smtp.qq.com
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
		map.put("to", userMsg.getEmail());
		// 邮件主题
		map.put("subject", "用户绑定邮箱验证");
		// 邮件内容
		map.put("body", content1);

		// 内嵌了多少张图片，如果没有，则new一个不带值的Map
		Map<String, String> image = new HashMap<String, String>();
//		String path = ServletActionContext.getRequest().getRealPath(
//				"public/images/118.jpg");
//		image.put("a00000001", path);

		// 附件的绝对路径,不发附件则new一个不带值的List
		List<String> list = new ArrayList<String>();
		SendEmail sendEmail = new SendEmail(map, list, image);
		int res=sendEmail.send();
		return res;
	}
	
	public String getRandomStr(){
		Random random = new Random();
		String baseStr = "0123456789";
		StringBuffer buffer = new StringBuffer();
		for(int i=0;i<4;i++){
		int num = random.nextInt(baseStr.length());
		buffer.append(baseStr.charAt(num));
		}
		return buffer.toString();
		}
	
	
	public String validatemail(Integer userId,String inputmail) throws Exception{
		String state="0";
		List<User> users=this.domainDao.findAll();
		int repeat = 0;
		User user=this.domainDao.selectById(userId);
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getEmail().equalsIgnoreCase(inputmail)) {
				state="1";
				repeat++;
			}
		}
		if (repeat == 0) {
			String rs="";
			String rn="";
			Random random = new Random();
			for(int i=0;i<4;i++){
				rn = String.valueOf(random.nextInt(10));
				rs+=rn;
				}
			int res=this.sendMsgofemail(user.getUsername(),rs,inputmail);
			if (res==0) {
				state="2";
			}else {
				user.setEmail(inputmail);
				this.domainDao.update(user);
				state="0";
				HttpSession session=ServletActionContext.getRequest().getSession();
				session.setAttribute("loginValidateCode", rs);
			}
		}
		return state;
	}
	
	public String sendemail(Integer userId){
		String state="0";
		try {
			User user=this.domainDao.selectById(userId);
			state="1";
			Random random = new Random();
			String rs="";
			String rn="";
			for(int i=0;i<4;i++){
				rn = String.valueOf(random.nextInt(10));
				rs+=rn;
				}
			HttpSession session=ServletActionContext.getRequest().getSession();
			session.setAttribute("loginValidateCode", rs);
			int res=this.sendMsg(user.getNickName(), rs);
			if (res==0) {
				state="2";
			}else {
				state="1";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			state="0";
		}
		return state;
	}
	
	public String validatepwd(Integer userId,String oldpwd) throws Exception{
		String state="0";
		User user=this.domainDao.selectById(userId);
		String useroldpwd=user.getPassword();
		
		MD5Code des = new MD5Code("leemenz");
		String jiemi=des.decrypt(useroldpwd);
		if (jiemi.equalsIgnoreCase(oldpwd)) {
			state="1";
		}else {
			state="0";
		}
		return state;
	}
	public List<User> userbyusercat(Integer usercatid,Integer personOrCompany,Integer ifIdentityTrue){
		return domainDao.userbyusercat(usercatid, personOrCompany, ifIdentityTrue);
	}
	public List<User> govermentbyusercat(Integer enterprisetype,Integer personOrCompany,Integer ifIdentityTrue){
		return domainDao.govermentbyusercat(enterprisetype, personOrCompany, ifIdentityTrue);
	}
	public Integer sendEmil(Integer id){
		int msgFlag=0;
		try {
			User user=this.domainDao.selectById(id);
			msgFlag=1;
			Random random = new Random();
			String rs="";
			String rn="";
			for(int i=0;i<4;i++){
				rn = String.valueOf(random.nextInt(10));
				rs+=rn;
				}
			HttpSession session=ServletActionContext.getRequest().getSession();
			session.setAttribute("loginValidateCode", rs);
			this.sendMsg(user.getNickName(), rs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msgFlag=0;
		}
		return msgFlag;
	}
	
	public String sendmobilecodeofmodifyemail(Integer id){
		String state="0";
		User user=this.domainDao.selectById(id);
		String code=this.getRandomStr();
		System.out.println(code);
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.setAttribute("msgcode", code);
		state="1";
		SendSMS sendSMS=new SendSMS();
		sendSMS.setUsername("639198");
		sendSMS.setPassword("8df7ed01c3e41c43cbd9d9df75eb99c3");
		sendSMS.setMessage("您正在进行邮箱修改操作,请输入验证码："+code+"（唯图网）");
		sendSMS.setMobiles(user.getMobile());
		sendSMS.setServicesRequestAddRess("http://sms.c8686.com/Api/BayouSmsApiEx.aspx");
		sendSMS.setSmstype(0);
		sendSMS.setTimerid("0");
		sendSMS.setTimertype(0);
		Map<String, String> map = sendSMS.sendSMS();
		int sendflag=Integer.valueOf(map.get("errorcode").toString());
		HttpSession ses =ServletActionContext.getRequest().getSession();
		if (sendflag == 0) {
			ses.setAttribute("msgcode",code);
			ses.setMaxInactiveInterval(10*60);
		}
		return state;
	}
	
	
	public String sendmobilecode(Integer id,String newmobile){
		String state="0";
		List<User> users=this.domainDao.findAll();
		int repeat = 0;
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getMobile() == null ||users.get(i).getMobile().equals("")) {
				continue;
			}
			if (users.get(i).getMobile().equalsIgnoreCase(newmobile)) {
				state="0";
				repeat++;
			}
		}
		if (repeat == 0) {
			state="1";
//			User user=this.domainDao.selectById(id);
			String code=this.getRandomStr();
			System.out.println(code);
			HttpSession session=ServletActionContext.getRequest().getSession();
			session.setAttribute("msgcode", code);
			SendSMS sendSMS=new SendSMS();
			sendSMS.setUsername("639198");
			sendSMS.setPassword("8df7ed01c3e41c43cbd9d9df75eb99c3");
			sendSMS.setMessage("您在唯图网账户修改的新手机为："+newmobile+"。请输入验证码："+code+"【唯图网】");
			sendSMS.setMobiles(newmobile);
			sendSMS.setServicesRequestAddRess("http://sms.c8686.com/Api/BayouSmsApiEx.aspx");
			sendSMS.setSmstype(0);
			sendSMS.setTimerid("0");
			sendSMS.setTimertype(0);
			Map<String, String> map = sendSMS.sendSMS();
			int sendflag=Integer.valueOf(map.get("errorcode").toString());
			HttpSession ses =ServletActionContext.getRequest().getSession();
			if (sendflag == 0) {
				ses.setAttribute("msgcode",code);
				ses.setMaxInactiveInterval(10*60);
			}
		}
		return state;
	}
	
	
	@SuppressWarnings("unchecked")
	public List uploadimg(File file,String myfilename) {
		List list=new LinkedList();
		String resPath = "";
	    int picWidth= 0;
		int picHeight= 0;
		int uploadres=0;
		String param="";
		try{
			//uploadPubimg(idCardFrontPic,  "_"+super.getLoginUsername()+"idCardFrontPic", idCardFrontPicContentType);
			
			
			InputStream is = null;
			if(file!=null){
				is= new FileInputStream(file);
			}
			String uploadPath = ServletActionContext.getServletContext().getRealPath("/userInfoImg");
			
			HttpServletRequest request = ServletActionContext.getRequest();
			String path = request.getContextPath();
			String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
			
			Date date = new Date();
			DateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
			String name1 = format.format(date);
			
//			String baseName = file.getName();
			String picType = myfilename.substring(myfilename.lastIndexOf(".")+1);
			String picName = name1+"."+picType;
			
			File toFile = new File(uploadPath,picName);
			System.out.println("-------------uploadPath---------- : "+uploadPath);
			OutputStream os = new FileOutputStream(toFile);
			byte[] b = new byte[1024];
			int len = 0;
			while((len = is.read(b)) != -1){
				os.write(b, 0, len);
			}
			is.close();
			os.close();
			ImageIcon img= new ImageIcon(uploadPath+"/"+picName);
			picWidth= img.getIconWidth();
			picHeight= img.getIconHeight();
			if ((picWidth>800 || picHeight>800)||(picWidth>800 && picHeight>800)) {
				Thumbnails.of(uploadPath+"/"+picName)
		        .size(800,800)
			        .keepAspectRatio(true) //默认是true,按比例缩小
			        .outputFormat(picType)
			        .toFile(uploadPath+"/"+picName);//如果为宽图片，生成的宽度为指定的宽度，高度自适应
			}
			resPath = basePath+"userInfoImg/"+picName;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		if (picWidth >800 || picHeight >800) {
			uploadres=1;
			param=resPath;	
		}else {
			uploadres=0;
			param=resPath;
		}
		list.add(uploadres);
		list.add(param);
		return list;
	}
	
	
	
	
	
	
	/////insert///
	public Integer insert(User user) {
		MD5Code des;
		try {
			des = new MD5Code("leemenz");
		
		user.setNickName(user.getUsername());
		//user.setChineseRole(chinaRole);
		user.setIfIdentityTrue(0);//没有经过实名认证
		user.setRegTime(new Date());
		user.setStatu(0);//账户未激活
		user.setPassword(des.encrypt(user.getPassword()));
		user.setNewhip("0");
		
		return domainDao.insert(user) ;
		} catch (Exception e) {
			
			e.printStackTrace();
			return 0;
		}
	}//end insert()
			
	/////delete///
	public boolean delete(User record)  {
		return domainDao.delete(record);
	}//end delete()
			
	public boolean delete(Integer id)  {
		return domainDao.delete(id);
	}//end delete()
	
	/////update///
	public boolean update(User record)  {
		return domainDao.update(record);
	}//end update()
			
	/////select///
	public User selectById(Integer id)  {
		return domainDao.selectById(id);
	}
	
	public boolean sendEmail(int id,String url) {
		try {
		MD5Code des =new MD5Code("leemenz");
		User userMsg = domainDao.selectById(id);
		String username=des.encrypt(userMsg.getUsername());
		String codes=des.encrypt(id+"");
		String content1 = "您好！<br/><br/><br/>";
		content1 += "感谢你注册唯图网。<br/><br/>";
		content1 += "你的注册邮箱为：" +userMsg.getEmail() + "。请点击以下链接激活帐号<br/>";
		content1 += "<a href="+url+"/user!initUserMustInfoForWepic.do?registerId="
				+ username
				+ "&imgcode="
				+ codes
				+ ">"+url+"/user!initUserMustInfoForWepic.do?registerId="
				+ username + "&imgcode=" + codes + "</a><br/>";
		content1 += "如果以上链接无法点击，请将上面的地址复制到你的浏览器(如IE)的地址栏进入唯图网。（该链接在48小时内有效，48小时后需要重新注册）<br/><br/>";
		content1 += "<img src=\"cid:a00000001\">keyyang<br/><br/>";
		content1 += "唯图网客服经理<br/>";
		content1 += "key@wepic.cn";
		Map<String, String> map = new HashMap<String, String>();

		// 邮件服务器主机名(smtp服务器地址)
		// 如：qq的smtp服务器地址：smtp.qq.com
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
		map.put("to", userMsg.getEmail());
		// 邮件主题
		map.put("subject", "恭喜您！注册唯图网成功");
		// 邮件内容
		map.put("body", content1);

		// 内嵌了多少张图片，如果没有，则new一个不带值的Map
		Map<String, String> image = new HashMap<String, String>();
		String path = ServletActionContext.getRequest().getRealPath(
				"/back/pubimg/118.jpg");
		image.put("a00000001", path);

		// 附件的绝对路径,不发附件则new一个不带值的List
		List<String> list = new ArrayList<String>();
		SendEmail sendEmail = new SendEmail(map, list, image);
	
			sendEmail.send();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
		
		
	}
	
	public Integer enterpricevalidate(User user,Integer userId,String code,String gudingtel){
		User user2=domainDao.selectById(userId);
		user2.setEnterpriceType(user.getEnterpriceType());
		int flag=0;
		
		if (user.getEnterpriceType() ==1) {
			user2.setGovermentenrollment(user.getGovermentenrollment());
			user2.setLicenseagreement(user.getLicenseagreement());
			user2.setIdCardFrontPic(user.getIdCardFrontPic());
			user2.setMarkerName(user.getMarkerName());
			user2.setMarkerIDCard(user.getMarkerIDCard());
			user2.setMarkerduty(user.getMarkerduty());
			user2.setMobile(user.getMobile());
			user2.setWorktel(gudingtel);
			user2.setResidence(user.getResidence());
			user2.setQq(user.getQq());
			user2.setIfIdentityTrue(1);
			user2.setEnterpriceType(user.getEnterpriceType());
		}if (user.getEnterpriceType() ==2) {
			user2.setMediaenrollment(user.getMediaenrollment());
			user2.setLicenseagreement(user.getLicenseagreement());
			user2.setIdCardFrontPic(user.getIdCardFrontPic());
			user2.setMarkerName(user.getMarkerName());
			user2.setMarkerIDCard(user.getMarkerIDCard());
			user2.setMarkerduty(user.getMarkerduty());
			user2.setMobile(user.getMobile());
			user2.setWorktel(gudingtel);
			user2.setResidence(user.getResidence());
			user2.setQq(user.getQq());
			user2.setIfIdentityTrue(1);
			user2.setEnterpriceType(user.getEnterpriceType());
		}if (user.getEnterpriceType() ==3) {
			user2.setLicenseagreement(user.getLicenseagreement());
			user2.setCertificatePic(user.getCertificatePic());
			user2.setIdCardFrontPic(user.getIdCardFrontPic());
			user2.setCompanyName(user.getCompanyName());
			user2.setCompanyBuildDate(user.getCompanyBuildDate());
			user2.setCompanyEmail(user.getCompanyEmail());
			user2.setBusnissAllowedTime(user.getBusnissAllowedTime());
			user2.setCompanyAddr(user.getCompanyAddr());
			user2.setCompanyRegMoney(user.getCompanyRegMoney());
			user2.setCertificateNo(user.getCertificateNo());
			user2.setCompanyorgcode(user.getCompanyorgcode());
			user2.setCompanyRegAddr(code);
			user2.setBusinessScope(user.getBusinessScope());
			user2.setMarkerName(user.getMarkerName());
			user2.setMarkerIDCard(user.getMarkerIDCard());
			user2.setMarkerduty(user.getMarkerduty());
			user2.setMobile(user.getMobile());
			user2.setWorktel(gudingtel);
			user2.setResidence(user.getResidence());
			user2.setQq(user.getQq());
			user2.setIfIdentityTrue(1);
			user2.setEnterpriceType(user.getEnterpriceType());
		}if (user.getEnterpriceType() ==4) {
			user2.setCompanyName(user.getCompanyName());
			user2.setCompanyorgcode(user.getCompanyorgcode());
			user2.setCompanyEmail(user.getCompanyEmail());
			user2.setCompanyAddr(user.getCompanyAddr());
			user2.setCertificateNo(user.getCertificateNo());
			user2.setBusinessScope(user.getBusinessScope());
			user2.setMarkerName(user.getMarkerName());
			user2.setMarkerIDCard(user.getMarkerIDCard());
			user2.setMarkerduty(user.getMarkerduty());
			user2.setMobile(user.getMobile());
			user2.setWorktel(gudingtel);
			user2.setResidence(user.getResidence());
			user2.setQq(user.getQq());
			user2.setIfIdentityTrue(1);
			user2.setEnterpriceType(user.getEnterpriceType());
			user2.setCompanyorgcode(user.getCompanyorgcode());
			
			
			user2.setLicenseagreement(user.getLicenseagreement());
			user2.setCertificatePic(user.getCertificatePic());
			user2.setIdCardFrontPic(user.getIdCardFrontPic());
			user2.setCompanyRegAddr(code);
			
			
		}
		user2.setValidatetime(getcurrent2());
		if (domainDao.update(user2)) {
			flag=1;
		}else {
			flag=0;
		}
		return flag;
	}
	

	
	@SuppressWarnings("unchecked")
	public Pager listDetaChedCriteri(DetachedCriteria detachedCriteria,int nowPage,int pageSize) {
		Pager pager=domainDao.listDetaChedCriteri( detachedCriteria, nowPage, pageSize);
		List<User> list=(List<User>)pager.getResultList();
		for (User user : list) {
			String workpPlace=user.getWorkPlace();
			if(workpPlace!=null&&workpPlace.trim().length()>0){
			//	System.out.println(workpPlace.trim().lastIndexOf(" "));
				String news=workpPlace.substring(0,workpPlace.trim().lastIndexOf(" "));
			//	System.out.println(news);
				user.setWorkPlace(news);
			}else{
				user.setWorkPlace("暂无工作地址");
			}
			System.out.println(user.getWorkPlace());
		}
		
		
		return pager;
	}
	
	
	
	
	
	
	

	public Pager findbyDetachedCriteria(DetachedCriteria detachedCriteria,int pageNo,int pageSize){
		return domainDao.findbyDetachedCriteria(detachedCriteria, pageNo, pageSize);
	}
	public Integer validateuser(User user,Integer userId,String areaCode,String number,String pic) throws Exception {
		User user2=domainDao.selectById(userId);
		String familyphone=areaCode+number;
		user.setWorktel(familyphone);
		user.setRealName(new String(user.getRealName().getBytes("ISO-8859-1"),"utf-8"));
		user.setResidence(new String(user.getResidence().getBytes("ISO-8859-1"),"utf-8"));
		user.setIdCardBackPic(pic);
		user.setNickName(user2.getNickName());
		user.setUsername(user2.getUsername());
		user.setPassword(user2.getPassword());
		user.setUserNo(user2.getUserNo());
		user.setEmail(user2.getEmail());
		user.setPortrait(user2.getPortrait());
		user.setSmallportrait(user2.getSmallportrait());
		user.setOccupation(user2.getOccupation());
		user.setWorkPlace(user2.getWorkPlace());
		/**
	
	//联系信息(约拍确定后可见)
	private Integer personOrCompany;//注册方式（1、个人注册 2、公司注册）
		 */
		user.setCreditRatings(user2.getCreditRatings());
		user.setTotalCredits(user2.getTotalCredits());
		user.setAge(user2.getAge());
		user.setSex(user2.getSex());
		user.setBirthday(user2.getBirthday());
		user.setRegTime(user2.getRegTime());
		user.setHeight(user2.getHeight());
		user.setWeight(user2.getWeight());
		user.setWaist(user2.getWaist());
		user.setBust(user2.getBust());
		user.setHip(user2.getHip());
		user.setNewhip(user2.getNewhip());
		user.setShoeSize(user2.getShoeSize());
		user.setHairColor(user2.getHairColor());
		user.setHighestDegree(user2.getHighestDegree());
		user.setHighestDegreeDate(user2.getHighestDegreeDate());
		user.setHighestDegreeSchool(user2.getHighestDegreeSchool());
		user.setBachelorDate(user2.getBachelorDate());
		user.setBachelorSchool(user2.getBachelorSchool());
		user.setZodiac(user2.getZodiac());
		user.setBloodtype(user2.getBloodtype());
		user.setMajor(user2.getMajor());
		user.setTraining(user2.getTraining());
		user.setSelfIntroduction(user2.getSelfIntroduction());
		user.setProjects(user2.getProjects());
		user.setContext(user2.getContext());
		user.setWorks(user2.getWorks());
		user.setPrize(user2.getPrize());
		user.setFavorate(user2.getFavorate());
		user.setPersonOrCompany(user2.getPersonOrCompany());
		user.setUserCat(user2.getUserCat());
		user.setIfIdentityTrue(1);
		user.setRole(user2.getRole());
		user.setStatu(user2.getStatu());
		
		user.setDetail1(user2.getDetail1());
		user.setDetail2(user2.getDetail2());
		user.setIsediteuserInfo(user2.getIsediteuserInfo());
		user.setUserTag(user2.getUserTag());
		user.setPersonTag(user2.getPersonTag());
		user.setValidatetime(getcurrent2());
		user.setId(userId);
		domainDao.update(user);
		int flag=0;
		if (domainDao.update(user)) {
			flag=1;
		}else {
			flag=0;
		}
		return flag;
	}

	public boolean isExist(String username)  {
		User record = domainDao.select(username);
		if (record == null) {
				return true;
		} else {
				return false;
		}
	}//end function
	
	public boolean isEmailExist(String email)  {
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("email", email);
		List list = domainDao.list(map, 1, 1).getResultList();
		if (list.size()>0) {
				return false;
		} else {
				return true;
		}
	}//end fu
	

	
	public User select(String username) {
		// TODO Auto-generated method stub
		return domainDao.select(username);
	}
	public UserInfoBeans getUserInfoBeans(int userId){
		User user=domainDao.selectById(userId);
		UserInfoBeans bean=new UserInfoBeans();
		bean.setNickName(user.getNickName());
		bean.setPortrait(user.getPortrait());
		bean.setWorkPlace(user.getWorkPlace());
		bean.setOccupation(user.getChineseRole());
		Account account=accountService.select(user.getId(),"");
		bean.setMoeny(account.getRemainingMoney()+"");
		bean.setSex(user.getSex());
		UserCredit userCredit=this.getCreditService().selectByUser(user);
	    int totalMark=(int)userCredit.getTotalMark();
	       int[] leavel=Level.levelforUser(totalMark);
	       bean.setStar(leavel[1]);
	       bean.setJewel(leavel[1]);
	       int goodRemark=userCredit.getBidGoodRemarkNum();
	       int badRemark=userCredit.getBidBadRemarkNum();
	       int attentionNumber=this.getContactService().findAttentionNumber(user);
	      // int System.out.println(attentionNumber+"******************");
	       int fansNumber=this.getContactService().findFansNumber(user);
	        UserMess userMess=new UserMess();
		    userMess.setBadRemark(badRemark);
		    userMess.setGoodRemark(goodRemark);
		    userMess.setFansNumber(fansNumber);
		    userMess.setAttentionNumber(attentionNumber);
		    userMess.setTotalMark(totalMark);
		    bean.setUserMess(userMess);
		
		return bean;
	}
	
	
	
	public UserInfoBeans getFistPageUserInfoBeans(int userId){
		User user=domainDao.selectById(userId);
		UserInfoBeans bean=new UserInfoBeans();
		bean.setNickName(user.getNickName());
		bean.setPortrait(user.getPortrait());
		bean.setWorkPlace(user.getWorkPlace());
		bean.setOccupation(user.getChineseRole());
		bean.setPersonOrCompany(user.getPersonOrCompany()+"");
		Account account=accountService.select(user.getId(),"");
		//bean.setMoeny(account.getRemainingMoney()+"");
		bean.setAccount(account);
		bean.setChinerole(user.getUserTag());
		bean.setContext(user.getContext());
		bean.setSex(user.getSex());
		bean.setIfIdentityTrue(user.getIfIdentityTrue());
		bean.setPersonOrCompany(user.getPersonOrCompany()+"");
		UserCredit userCredit=this.getCreditService().selectByUser(user);
	    int totalMark=(int)userCredit.getTotalMark();
	       int[] leavel=Level.levelforUser(totalMark);
	       bean.setStar(leavel[1]);
	       bean.setJewel(leavel[1]);
	       int allmark=(bean.getJewel()*1000)+(bean.getStar()*200)+200;
	       int degee=bean.getJewel()*5+bean.getStar();
	       bean.setDegee(degee);//等级
	       int getallmark=(int)userCredit.getTotalMark();
	       bean.setNextDegeeMark(allmark-getallmark);//升到下一集所需要的积分
	       
	       int goodRemark=userCredit.getBidGoodRemarkNum();
	       int badRemark=userCredit.getBidBadRemarkNum();
	       int attentionNumber=this.getContactService().findAttentionNumber(user);
	      // int System.out.println(attentionNumber+"******************");
	       int fansNumber=this.getContactService().findFansNumber(user);
	        UserMess userMess=new UserMess();
		    userMess.setBadRemark(badRemark);
		    userMess.setGoodRemark(goodRemark);
		    userMess.setFansNumber(fansNumber);
		    userMess.setAttentionNumber(attentionNumber);
		    userMess.setTotalMark(totalMark);
		    bean.setUserMess(userMess);
		    LoginHistory loginHistory=new LoginHistory();
		    loginHistory.setLoginTime(getcurrent());
		    loginHistory.setUser(user);
		    this.getLoginHistoryService().insert(loginHistory);
		return bean;
	}
	
	public Timestamp getcurrent() {
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String a=df.format(new Date());
		Timestamp ts = new Timestamp(System.currentTimeMillis());  
		ts.valueOf(a);
		return ts;
	}
	public String getcurrent2() {
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		String a=df.format(new Date());
		return a;
	}
	public LoginHistory recentHistory() {
		return this.getLoginHistoryService().recentlylogininfo();
	}
	public UserInfoBeans getgradUserInfoBeans(int userId){
		User user=domainDao.selectById(userId);
		UserInfoBeans bean=new UserInfoBeans();
		bean.setNickName(user.getNickName());
		bean.setPortrait(user.getPortrait());
		
		bean.setIfIdentityTrue(user.getIfIdentityTrue());
		UserCredit userCredit=this.getCreditService().selectByUser(user);
	    int totalMark=(int)userCredit.getTotalMark();
	     int[] leavel=Level.levelforUser(totalMark);
	       bean.setStar(leavel[1]);
	       bean.setJewel(leavel[1]);
	       int yu=0;
	       String baif="";
	       if(totalMark%200==0){
	    	   baif="100%";
	    	   if(totalMark==0){
	    		   
	    		   baif="0%";
	    	   }
	    	   
	       }else{
	    	 float i=totalMark%200;
	    	 baif=(i/200)*100+"%";   
	       }
	       bean.setBaif(baif);
	       int allmark=(bean.getJewel()*1000)+(bean.getStar()*200)+200;
	       int degee=bean.getJewel()*5+bean.getStar();
	       bean.setDegee(degee);//等级
	       int getallmark=(int)userCredit.getTotalMark();
	        bean.setNextDegeeMark(allmark-getallmark);//升到下一集所需要的积分
	        UserMess userMess=new UserMess();
		    userMess.setTotalMark(totalMark);
		    bean.setUserMess(userMess);
		   return bean;
	}
	
	
	public Pager getUsergetMarkHistory(int id,int nowPage,int pageSize){
		
		Map<String, Object> map=new HashMap<String, Object>();
		User user=new User();
		user.setId(id);
		map.put("admin", user);
		return userCreditHistoryService.list(map, pageSize, nowPage);
	}
	
	public String uploadPubimg(File file,String path,String basePath,String uploadPath){
		 String resPath = "";
			try{
				InputStream is = new FileInputStream(file);
				//String uploadPath = ServletActionContext.getServletContext().getRealPath("/userInfoImg");
				
				HttpServletRequest request = ServletActionContext.getRequest();
				
				Date date = new Date();
				DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
				String name1 = format.format(date);
				
				//String baseName =    //getRandomStr();
				//String picType = fileName.substring(fileName.lastIndexOf(".")+1);
				String picName = name1+".jpg";
				
				File toFile = new File(uploadPath,picName);
				System.out.println("-------------uploadPath---------- : "+uploadPath);
				OutputStream os = new FileOutputStream(toFile);
				byte[] b = new byte[1024];
				int len = 0;
				while((len = is.read(b)) != -1){
					os.write(b, 0, len);
				}
				is.close();
				os.close();
				ImageIcon img= new ImageIcon(uploadPath+"/"+picName);
				int picWidth= img.getIconWidth();
				int picHeight= img.getIconHeight();
				if ((picWidth>500 || picHeight>500)||(picWidth>500 && picHeight>500)) {
					Thumbnails.of(uploadPath+"/"+picName)
			        .size(470,500)
				        .keepAspectRatio(true) //默认是true,按比例缩小
				        .outputFormat("JPEG")
				        .toFile(uploadPath+"/"+picName);//如果为宽图片，生成的宽度为指定的宽度，高度自适应
				}
				resPath = basePath+"userInfoImg/"+picName;
			}catch(Exception ex){
				ex.printStackTrace();
			}
			return resPath;
	}
	
	
	
	
	
	
	
	//在作品库里面选图片
	public String CutImgPubimg(File file,String path,String basePath,String uploadPath){
		 String resPath = "";
			try{
				/*InputStream is = new FileInputStream(file);
				//String uploadPath = ServletActionContext.getServletContext().getRealPath("/userInfoImg");
				
				HttpServletRequest request = ServletActionContext.getRequest();
				
				Date date = new Date();
				DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
				String name1 = format.format(date);
				
				//String baseName =    //getRandomStr();
				//String picType = fileName.substring(fileName.lastIndexOf(".")+1);
				String picName = name1+".jpg";
				
				File toFile = new File(uploadPath,picName);
				System.out.println("-------------uploadPath---------- : "+uploadPath);
				OutputStream os = new FileOutputStream(toFile);
				byte[] b = new byte[1024];
				int len = 0;
				while((len = is.read(b)) != -1){
					os.write(b, 0, len);
				}
				is.close();
				os.close();
				*/
				
				ImageIcon img= new ImageIcon(file.getAbsolutePath());
				int picWidth= img.getIconWidth();
				int picHeight= img.getIconHeight();
				if ((picWidth>500 || picHeight>500)||(picWidth>500 && picHeight>500)) {
					Thumbnails.of(file.getAbsolutePath())
			        .size(470,500)
				        .keepAspectRatio(true) //默认是true,按比例缩小
				        .outputFormat("JPEG")
				        .toFile(uploadPath+"/"+file.getName());//如果为宽图片，生成的宽度为指定的宽度，高度自适应
				}
				resPath = basePath+"userInfoImg/"+file.getName();
			}catch(Exception ex){
				ex.printStackTrace();
			}
			return resPath;
	}
	
	
	
	
	
	
	
	
	//企业头像上传
	public String enterpeiceuploadPubimg(File file,String path,String basePath,String uploadPath){
		 String resPath = "";
		 String resPath80 = "";
			try{
				InputStream is = new FileInputStream(file);
				//String uploadPath = ServletActionContext.getServletContext().getRealPath("/userInfoImg");
				
				HttpServletRequest request = ServletActionContext.getRequest();
				
				Date date = new Date();
				DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
				String name1 = format.format(date);
				
				//String baseName =    //getRandomStr();
				//String picType = fileName.substring(fileName.lastIndexOf(".")+1);
				String picName = name1+".jpg";
				
				File toFile = new File(uploadPath,picName);
				System.out.println("-------------uploadPath---------- : "+uploadPath);
				OutputStream os = new FileOutputStream(toFile);
				byte[] b = new byte[1024];
				int len = 0;
				while((len = is.read(b)) != -1){
					os.write(b, 0, len);
				}
				is.close();
				os.close();
				ImageIcon img= new ImageIcon(uploadPath+"/"+picName);
				int picWidth= img.getIconWidth();
				int picHeight= img.getIconHeight();
				if(picWidth!=150&&picHeight!=150){
				File file2=new File(uploadPath+"/"+picName);
				if(file2.exists()){
					file2.delete();
					return "errorSize";
					
					
				}
					
				}
					Thumbnails.of(uploadPath+"/"+picName)
			        .size(150,150)
				        .keepAspectRatio(true) //默认是true,按比例缩小
				        .outputFormat("JPEG")
				        .toFile(uploadPath+"/"+picName);//如果为宽图片，生成的宽度为指定的宽度，高度自适应
					
					Thumbnails.of(uploadPath+"/"+picName)
			        .size(80,80)
				        .keepAspectRatio(true) //默认是true,按比例缩小
				        .outputFormat("JPEG")
				        .toFile(uploadPath+"/80x"+picName);//如果为宽图片，生成的宽度为指定的宽度，高度自适应
					
					
				
				resPath = basePath+"userInfoImg/"+picName;
				resPath80 = basePath+"userInfoImg/80x"+picName;
			}catch(Exception ex){
				ex.printStackTrace();
			}
			String res=resPath+","+resPath80;
			return res;
	}
	
	
	public String  cutImgForUSer(Map<String, Object> map){
		String tempPicName=(String) map.get("tempPicName");
	    User user2=domainDao.selectById(Integer.parseInt(map.get("userId")+""));
	    if(user2.getPortrait()==null||user2.getPortrait()==""){
	    	UserCredit userCredit= creditService.selectByUser(user2);
	    	userCredit.setTotalMark(userCredit.getTotalMark()+50);
	    	creditService.update(userCredit);
	        UserCreditHistory creditHistory=new UserCreditHistory();
	        creditHistory.setUser(user2);
	        creditHistory.setAddmarkreson("第一次上传头像");
	        creditHistory.setAddmarkType("1");
	        creditHistory.setMark(50);
	        creditHistory.setStartTime(new Timestamp(new Date().getTime()));
	        creditHistory.setEndTime(new Timestamp(new Date().getTime()));
	        userCreditHistoryService.insert(creditHistory);
	    }
		String path=(String) map.get("path");
		int x=Integer.parseInt(map.get("x")+"");
		int y=Integer.parseInt(map.get("y")+"");
		int w=Integer.parseInt(map.get("w")+"");
		int h=Integer.parseInt(map.get("h")+"");
        int index=tempPicName.indexOf("userInfoImg");
        
        String newName=tempPicName.substring(index,tempPicName.length());
        int a=newName.indexOf("/");
        
        String b=newName.substring(a+1,newName.length());//文件名称
        
        int position=b.lastIndexOf(".");
        
        String type = b.substring(b.lastIndexOf(".")+1);
        String endPath=b.substring(0,position)+"."+type;
        String c=path+"/"+b;	   //原来图片路径
        String currentPath=path+"/"+endPath;
        try {
			Thumbnails.of(c)
			.sourceRegion(x,y,w, h)
			.size(w,h)
			.keepAspectRatio(true) //默认是true,按比例缩小
			    .outputFormat("JPEG")
			    .toFile(c);
			
			Thumbnails.of(c)
			.size(150,150)
			.keepAspectRatio(true) //默认是true,按比例缩小
			    .outputFormat("JPEG")
			    .toFile(c);
			Thumbnails.of(c)
			.size(80,80)
			.keepAspectRatio(true) //默认是true,按比例缩小
			    .outputFormat("JPEG")
			    .toFile(c+"80x80");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        user2.setPortrait(tempPicName);
        domainDao.update(user2);   
        return "createPicSucess";
	}
	
	/*
	public String saveTags(){
	     //  String str[]={"时装摄影师","广告摄影师 ","人像摄影师" ,"产品摄影师" ,"建筑室内摄影师","场景摄","影师" ,"新闻摄影师","广告片摄像师","时尚摄影师 ","摄像师"};
	       
		//String str[]={"平面影视模特","产品形象模特","T台走秀模特","礼仪模特","车模","服装试穿模特","内衣模特" ,"表演模特","人体模特","局部模特（脸模 眼模  手模  耳模  腿模  脚模）","中老年模特", "少儿模特（由监护人代理注册）"};
		//String  str[]={"模特经纪","摄影师经纪","用户经纪" ,"艺术经纪", "演艺经纪"};
		//String  str[]={"IT互联网","服装","网店店主","广告/设计","策划","经纪","产品品牌","餐饮","交通/运输","美容/护理" ,"媒体/传媒","教育/培训","出版/印刷","文化/艺术"};
		//String  str[]={"主持人","音乐人 ","演员","导演","音效师","化妆师","后期制作"};
		//String str[]={"平面设计师","服装设计师","建筑设计师","产品设计师","网页设计师","室内设计师 ","展览设计师","造型设计师","动画设计师","游戏设计师"};
		//String str[]={"商业摄影","婚纱摄影","儿童摄影","摄影协会 "};
		//String str[]={ "广告设计","平面设计","室内设计","展览设计","建筑设计","工业设计","服装设计","网站设计","包装设计","园林设计","道具设计","饰品设计"};
		//String str[]={"媒体广告","平面广告","影视广告","互联网广告","会议策划","活动策划","路演策划","新品发布","品牌策划","市场营销"};
		//String str[]={"影视动画","游戏","卡通","动漫产品"};
		//String str[]={"互联网","淘宝","天猫","电商平台","网络店铺"};
		String str[]={"出版社","网络文学","编辑","书城"};
		for (String string : str) {
			
		
	       RoleTags tags=new RoleTags();
	       tags.setRole("printing");
	       tags.setTag(string.trim());
	       roleTagsService.insert(tags);
	       }
	       return "" ;
	}
	*/
	public List<RoleTags> selectTagByRole(String role){
		
		
		
		return roleTagsService.findByRole(role);
		
	}
	
public List<RoleTags> nextRadomTagByRole(){
	int siz=12;
	List<Integer> listradom=new ArrayList<Integer>();
	for (int i = 0; i <siz; i++) {
		int ra=new Random().nextInt(100);
		if(listradom.contains(ra)){
			siz++;
		}else{
		listradom.add(ra);
		}
	}
	List<RoleTags> roleTagses=new ArrayList<RoleTags>();
	for (int i = 0; i < listradom.size(); i++) {
		RoleTags roleTags=roleTagsService.findByRoleId(listradom.get(i));
		if(roleTags!=null){
			roleTagses.add(roleTags);
			
		}
	}
      return roleTagses;		
	}
	
	
	public ContactService getContactService() {
		return contactService;
	}
	public void setContactService(ContactService contactService) {
		this.contactService = contactService;
	}
	public UserDao getUserDao() {
		return domainDao;
	}//
	public void setUserDao(UserDao  domainDao) {
		this.domainDao = domainDao;
	}
	
	
	
	
	
	public UserCreditHistoryService getUserCreditHistoryService() {
		return userCreditHistoryService;
	}


	public void setUserCreditHistoryService(
			UserCreditHistoryService userCreditHistoryService) {
		this.userCreditHistoryService = userCreditHistoryService;
	}


	public AccountService getAccountService() {
		return accountService;
	}
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}
	public BlogCatService getBlogCatService() {
		return blogCatService;
	}
	public void setBlogCatService(BlogCatService blogCatService) {
		this.blogCatService = blogCatService;
	}
	public UserCreditService getCreditService() {
		return creditService;
	}
	public void setCreditService(UserCreditService creditService) {
		this.creditService = creditService;
	}
	
	
	
	
	public RoleTagService getRoleTagsService() {
		return roleTagsService;
	}


	public void setRoleTagsService(RoleTagService roleTagsService) {
		this.roleTagsService = roleTagsService;
	}


	////2.0方法//////////////////////////////////////////////////////////////////////////////////////////////////////
	public Integer register(User record)  {
		User user = domainDao.select(record.getUsername());
		if (user != null) {
			return null;
		} else {
			return domainDao.insert(record);
		}
	}//end register()
	
	public Pager moelorPotolist(String type, int pageSize, int pageNo,int userId,String aimId, String workPalce) {
		
		return domainDao.moelorPotolist(type, pageSize, pageNo,userId,aimId,workPalce);
	}
	public Pager checkInvitedUser(String id) {
		
		return domainDao.checkInvitedUser(id);
	}
	
	public List<UserDetail> listUserDetails(Integer userId) {
		
		return domainDao.findUserDetails(userId);
	}
	public Pager addBrokerShip(int pageSize, int pageNo) {
		// TODO Auto-generated method stub
		return domainDao.addBrokerShip(pageSize,pageNo);
	}
	public Pager addbrokerscustomer(int pageSize, int pageNo) {
		// TODO Auto-generated method stub
		return domainDao.addbrokerscustomer(pageSize,pageNo);
	}
	public Pager listUnderCat(Integer catId, int pageSize, int pageNo) {
		// TODO Auto-generated method stub
		return domainDao.listUnderCat(catId, pageSize, pageNo);
	}
	public Pager getAllPohtoOrModel(String role, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return domainDao.getAllPohtoOrModel(role, pageNo, pageSize);
	}
	public Pager searchPhotoOrModel(int pageSize, int pageNo, String position,
			String searchNick, String searchType) {
		// TODO Auto-generated method stub
		return domainDao.searchPhotoOrModel(pageSize, pageNo, position, searchNick, searchType);
	}
	public Pager userStatistics(final int pageSize,final int pageNo){
		return domainDao.userStatistics(pageSize, pageNo);
	}
	public List getAllPohtoOrModelByShowLeft(String role) {
		// TODO Auto-generated method stub
		return domainDao.getAllPohtoOrModelByShowLeft(role);
	}
		
	public List<User> findnoactiveuser(){
		return domainDao.findnoactiveuser();
	}
	public List<User> findPart(String strFields, String[] arrStrValues){ 
		return domainDao.findPart(strFields,arrStrValues);
	}
	
	public Pager list(int pageSize, int pageNo)  {
		return domainDao.list(pageSize,pageNo);
	}//end list()
	public Pager getListParamter(Integer paramter, int pageSize, int pageNo)  {
		return domainDao.getListByParameter(paramter, pageSize, pageNo);
	}//end list()
	
	public Pager list(String username, int pageSize, int pageNo)  {
		return domainDao.list(username,pageSize,pageNo);
	}//end list()


	public String saveTags() {
		// TODO Auto-generated method stub
		return null;
	}


	
	
}//end class
