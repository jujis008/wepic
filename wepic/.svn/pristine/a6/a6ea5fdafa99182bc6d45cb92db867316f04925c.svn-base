package com.wetuo.wepic.core.actions;

import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.components.If;

import com.alipay.util.AlipayNotify;
import com.unionpay.upop.sdk.QuickPayConf;
import com.unionpay.upop.sdk.QuickPayUtils;
import com.wetuo.wepic.core.beans.Account;
import com.wetuo.wepic.core.beans.AccountBankWithdraw;
import com.wetuo.wepic.core.beans.AccountRecharge;
import com.wetuo.wepic.core.beans.LoginHistory;
import com.wetuo.wepic.core.service.AccountBankWithdrawService;
import com.wetuo.wepic.core.service.AccountRechargeService;
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.core.service.UserService;
import com.wetuo.wepic.common.struts.PageAction;
import com.wetuo.wepic.core.service.AccountService;
import com.wetuo.wepic.publish.beans.Story;

public class AccountRechargeAction extends PageAction {
	/////instantce variable//////
	private static final long serialVersionUID = 1L;
 	private AccountRechargeService accountRechargeService;
 	private AccountService accountService;
	private UserService userService;
	private User user;
	private AccountRecharge accountRecharge;
	private LoginHistory loginHistory;
	private String myrechargeMoney;
	protected String userId = null ;
	int i=0;
	private String bankNumber="";//默认银行编号
	private String payType="";//默认支付方式
	private String yinlianbank="";
	private Integer rechargeId;
	
	public Object getModel() {
		if (accountRecharge == null) {
			accountRecharge = new AccountRecharge();
		}
		return accountRecharge;
	}
	public String getcurrent() {
		SimpleDateFormat df=new SimpleDateFormat("yyyyMMddHHmmsssss");
		String a=df.format(new Date());
		return a;
	}
	public String recharge() {
		int id=super.getLonginUserId();
		user=this.getUserService().selectById(id);
		loginHistory=this.getUserService().recentHistory();
		Account account=this.getAccountService().select(id,"");
		accountRecharge.setAccount(account);
		accountRecharge.setUser(user);
		accountRecharge.setOrderId(user.getUsername()+"_"+getcurrent());
		accountRecharge.setRechargetype(1);
		rechargeId=this.getAccountRechargeService().insert(accountRecharge);
		return "rechargeing";
	}
	public String rechargesuc() {
		int id=super.getLonginUserId();
		user=this.getUserService().selectById(id);
		loginHistory=this.getUserService().recentHistory();
		accountRecharge=this.getAccountRechargeService().select(rechargeId);
		return "rechargesuc";
	}
	public String transferrecharge() {
		int id=super.getLonginUserId();
		user=this.getUserService().selectById(id);
		loginHistory=this.getUserService().recentHistory();
		Account account=this.getAccountService().select(id,"");
		
		return "transferrecharge";
	}
	public String rechargeByChinaPay() {
		HttpServletRequest request = super.getRequest();
		HttpServletResponse response=super.getReponse();
		String orderId= super.getLoginUsername()+"_"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+(++i);
		//商户需要组装如下对象的数据
		if (yinlianbank == "" || yinlianbank == null) {
			payType ="CSPay";
		}else {
			payType ="";
		}
		String[] valueVo = new String[]{
				QuickPayConf.version,//协议版本
				QuickPayConf.charset,//字符编码
	            "01",//交易类型
	            "",//原始交易流水号
	            QuickPayConf.merCode,//商户代码
	            QuickPayConf.merName,//商户简称
	            "",//收单机构代码（仅收单机构接入需要填写）
	            "",//商户类别（收单机构接入需要填写）
	            "",//商品URL
	            "",//商品名称
	            "1",//商品单价 单位：分
	            "1",//商品数量
	            "0",//折扣 单位：分
	            "0",//运费 单位：分
	            orderId,//订单号（需要商户自己生成）
	            (Integer.parseInt(this.getMyrechargeMoney())*100)+"",//交易金额 单位：分
	            "156",//交易币种
	            new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()),//交易时间
	            "127.0.0.1",//用户IP
	            "张三",//用户真实姓名
	            payType,//默认支付方式
	            bankNumber,//默认银行编号
	            "300000",//交易超时时间
	            QuickPayConf.merFrontEndUrl,// 前台回调商户URL
				QuickPayConf.merBackEndUrl,// 后台回调商户URL
	            ""//商户保留域
		};
		
		String signType = request.getParameter("sign");
		if (!QuickPayConf.signType_SHA1withRSA.equalsIgnoreCase(signType)) {
			signType = QuickPayConf.signType;
		}
		
		String html = new QuickPayUtils().createPayHtml(valueVo, signType);//跳转到银联页面支付
		
		response.setContentType("text/html;charset="+QuickPayConf.charset);   
		response.setCharacterEncoding(QuickPayConf.charset);
		try {
			response.getWriter().write(html);
		} catch (IOException e) {
			
		}
		response.setStatus(HttpServletResponse.SC_OK);
		
		return null;
	}
	
	/*
	   * 
	   * 银联支付通知
	   * 
	   * 
	   * */
	  
	  public String chinaPayReturn(){
		    HttpServletRequest request = super.getRequest();
			HttpServletResponse response=super.getReponse();
		  try {
				request.setCharacterEncoding(QuickPayConf.charset);
			} catch (UnsupportedEncodingException e) {
			}
			
			String[] resArr = new String[QuickPayConf.notifyVo.length]; 
			for(int i=0;i<QuickPayConf.notifyVo.length;i++){
				resArr[i] = request.getParameter(QuickPayConf.notifyVo[i]);
			}
			String signature = request.getParameter(QuickPayConf.signature);
			String signMethod = request.getParameter(QuickPayConf.signMethod);
			
			response.setContentType("text/html;chardset="+QuickPayConf.charset);   
			response.setCharacterEncoding(QuickPayConf.charset);
			
			try {
				Boolean signatureCheck = new QuickPayUtils().checkSign(resArr, signMethod, signature);
				if(signatureCheck&&"00".equals(resArr[10])){
					for(int i=0;i<resArr.length;i++ ){
						System.out.println(i+"="+resArr[i]);
						
						
					}
					
					String userName=resArr[8].split("_")[0];
					userId=userService.select(userName).getId()+"";
					//Account account=accountService.select(Integer.parseInt(userId),"");
					accountRechargeService.addMoney(Integer.parseInt(userId), new BigDecimal((float)Float.parseFloat(resArr[6])/100),accountService ,userService,resArr[8]);
					//tran
						//User user=userService.select(userName);
					    //Account account=accountService.s      
					
					
					
				}
				//.append("签名是否正确："+ signatureCheck)
				//.append("<br>交易是否成功："+"00".equals(resArr[10]));
				if(!"00".equals(resArr[10])){
					response.getWriter().append("<br>失败原因:"+resArr[11]);
				}
			} catch (IOException e) {
				
			}
		
			response.setStatus(HttpServletResponse.SC_OK);
		  return null;
	  }
	  public void updateAcount() throws IOException{
			 // log_result();
			  System.out.println("=========================================");
			 
			
			  HttpServletResponse response=super.getReponse();
			  response.setContentType("text/html;charset=utf-8");//解决中文乱码
		      PrintStream out = new PrintStream(response.getOutputStream());//获取out输出对象
			  
			  HttpServletRequest request=ServletActionContext.getRequest();
			  
			  Map<String,String> params = new HashMap<String,String>();
				Map requestParams = request.getParameterMap();
				for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
					String name = (String) iter.next();
					String[] values = (String[]) requestParams.get(name);
					String valueStr = "";
					for (int i = 0; i < values.length; i++) {
						valueStr = (i == values.length - 1) ? valueStr + values[i]
								: valueStr + values[i] + ",";
					}
					//乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
					//valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
					params.put(name, valueStr);
				}
				
				//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
				//商户订单号
				/*

				String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");

				//支付宝交易号
				System.out.println("=========================================");

				int accountuserId=Integer.parseInt(out_trade_no.split("_")[0]);
				//CheckURL.star("买家付款成功，等待卖家发货"+trade+":"+money+"=============="+id);
	           
				accountRechargeService.addMoney(accountuserId, new BigDecimal(1),accountService ,userService,out_trade_no);
				//交易状态
				 * 
				 */
				String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");
			

				//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//

				if(AlipayNotify.verify(params)){//验证成功
					//////////////////////////////////////////////////////////////////////////////////////////
					//请在这里加上商户的业务逻辑程序代码

					//——请根据您的业务逻辑来编写程序（以下代码仅作参考）——
					
					if(trade_status.equals("TRADE_FINISHED")){
						
						
						
						
						//判断该笔订单是否在商户网站中已经做过处理
							//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
							//如果有做过处理，不执行商户的业务程序
							
						//注意：
						//该种交易状态只在两种情况下出现
						//1、开通了普通即时到账，买家付款成功后。
						//2、开通了高级即时到账，从该笔交易成功时间算起，过了签约时的可退款时限（如：三个月以内可退款、一年以内可退款等）后。
					} else if (trade_status.equals("TRADE_SUCCESS")){
						//判断该笔订单是否在商户网站中已经做过处理
							//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
							//如果有做过处理，不执行商户的业务程序
							
						//注意：
						//该种交易状态只在一种情况下出现——开通了高级即时到账，买家付款成功后。
					}

					//——请根据您的业务逻辑来编写程序（以上代码仅作参考）——
					
					

					String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");

					//支付宝交易号
					System.out.println("=========================================");

					int accountuserId=Integer.parseInt(out_trade_no.split("_")[0]);
					//CheckURL.star("买家付款成功，等待卖家发货"+trade+":"+money+"=============="+id);
					String money=params.get("total_fee").toString();
					accountRechargeService.addMoney( accountuserId, new BigDecimal(money),accountService ,userService,out_trade_no);
					//交易状态
				//	String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");

	               
						
					out.println("success");	//请不要修改或删除

					//////////////////////////////////////////////////////////////////////////////////////////
				}else{//验证失败
					//out.println("fail");
				}
			  		  
			  //return "";
			  
		  }
	////////////////////getter setter/////////////////////////
	public AccountRechargeService getAccountRechargeService() {
		return accountRechargeService;
	}
	public void setAccountRechargeService(
			AccountRechargeService accountRechargeService) {
		this.accountRechargeService = accountRechargeService;
	}
	public AccountService getAccountService() {
		return accountService;
	}
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public LoginHistory getLoginHistory() {
		return loginHistory;
	}
	public void setLoginHistory(LoginHistory loginHistory) {
		this.loginHistory = loginHistory;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBankNumber() {
		return bankNumber;
	}

	public void setBankNumber(String bankNumber) {
		this.bankNumber = bankNumber;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getYinlianbank() {
		return yinlianbank;
	}

	public void setYinlianbank(String yinlianbank) {
		this.yinlianbank = yinlianbank;
	}
	public AccountRecharge getAccountRecharge() {
		return accountRecharge;
	}
	public void setAccountRecharge(AccountRecharge accountRecharge) {
		this.accountRecharge = accountRecharge;
	}
	public Integer getRechargeId() {
		return rechargeId;
	}
	public void setRechargeId(Integer rechargeId) {
		this.rechargeId = rechargeId;
	}
	public String getMyrechargeMoney() {
		return myrechargeMoney;
	}
	public void setMyrechargeMoney(String myrechargeMoney) {
		this.myrechargeMoney = myrechargeMoney;
	}
	
}//end class
