<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="com.alipay.util.AlipayNotify"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashMap"%>
    <%
    String path=request.getContextPath();
    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link href="<%=path%>/back/css/bakcWepic.css" rel="stylesheet"  type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>充值成功</title>
</head>

<body>
<%
	//获取支付宝GET过来反馈信息
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
		valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
		params.put(name, valueStr);
	}
	
	//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
	//商户订单号

	String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");

	//支付宝交易号

	String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
	String body = new String(request.getParameter("body").getBytes("ISO-8859-1"),"UTF-8");
	float money=Float.parseFloat(params.get("total_fee").toString());

	//交易状态
	String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");

	//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//
	
	//计算得出通知验证结果
	boolean verify_result = AlipayNotify.verify(params);
	
	if(verify_result){//验证成功
		//////////////////////////////////////////////////////////////////////////////////////////
		//请在这里加上商户的业务逻辑程序代码

		//——请根据您的业务逻辑来编写程序（以下代码仅作参考）——
		if(trade_status.equals("TRADE_FINISHED") || trade_status.equals("TRADE_SUCCESS")){
			//判断该笔订单是否在商户网站中已经做过处理
				//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
				//如果有做过处理，不执行商户的业务程序
		}
		
		//该页面可做页面美工编辑
		//out.println("验证成功<br />");
		//——请根据您的业务逻辑来编写程序（以上代码仅作参考）——

		//////////////////////////////////////////////////////////////////////////////////////////
	}else{
		//该页面可做页面美工编辑
		//out.println("验证失败");
	}
%>

<div class="topCss">
<div class="topdivcs">
<div class="logins">
<table height="100%">
<tr>
<td>
<img src="<%=path%>/back/imagess/logo.png" />


</td>
<td style="padding-top:7px; width:300px;padding-left:9px;">
<span>商业拍摄</span>
<span>原创商业图片交易平台</span>

</td>


</tr>

</table>

</div>


<div class="logins1" style="float:right">

</div>


</div>

</div>


<div style="width:1000px; height:330px; margin:auto; margin-top:50px;" align="center">
<table  width="900px" height="110px" style="border-bottom: 1px dashed #CCC">
<tr>

<td rowspan="4" align="center" valign="top"><img src="<%=request.getContextPath()%>/back/imagess/02_03.jpg" /></td>

<td><span style="font-size:14px; font-weight:bold">已充值成功,您可以在您的<span style=" color:#0EB3FF; text-decoration: underline">&nbsp;账户管理&nbsp;</span>里查看</span></td>

</tr>
<tr>
<td></td>

</tr>
<tr>
<td> 您的充值已成功,您可以去唯图网进行各种交易</td>

</tr>


<tr>
<td> 如果查询未到账,可能是运营商网络问题导致暂时未充值到账,请联系客服</td>

</tr>


</table>

<table  width="760px"  height="80px" >
<tr>

<td rowspan="3" align="center" valign="top">&nbsp;</td>

<td>充值编号:&nbsp;<%=out_trade_no %></td>

</tr>
<tr>
<td>充值账号:&nbsp;<%=body %></td>

</tr>
<tr>
<td>充值金额:&nbsp;<%=money%>&nbsp;元</td>

</tr>




</table>

</div>




<div  style="width:1000px; height:140px; margin:auto; margin-top:25px; border-top: 5px solid #909090;">
 <div style="width:100%; margin-top:18px; text-align:center">
 <span class="spandown"><b>服务热线:</b></span> <span class="spandown1"><b>400-809-9060</b></span>
   <span class="spandown1"  style="margin-left:20px">维拓网络旗下品牌:&nbsp;&nbsp;wepic.cn&nbsp;唯图</span> 
 </div> 
 
 <div style="width:100%; margin-top:10px; text-align:center">
  <span class="spandown1"><a href="javascript:enterHelpCenter('1')" style="text-decoration: none;color:#787878">关于唯图</a></span> <span class="spandown1">&nbsp;|&nbsp;</span>
  <span class="spandown1"><a href="javascript:enterHelpCenter('2')" style="text-decoration: none;color:#787878">充值支付</a></span> <span class="spandown1">&nbsp;|&nbsp;</span>
  <span class="spandown1"><a href="javascript:enterHelpCenter('3')" style="text-decoration: none;color:#787878">人才招聘</a></span> <span class="spandown1">&nbsp;|&nbsp;</span>
   <span class="spandown1"><a href="javascript:enterHelpCenter('4')"style="text-decoration: none;color:#787878">法律专栏</a></span> <span class="spandown1">&nbsp;|&nbsp;</span>
     <span class="spandown1"><a href="javascript:enterHelpCenter('5')" style="text-decoration: none;color:#787878">疑问解答</a></span> <span class="spandown1">&nbsp;|&nbsp;</span>
    <span class="spandown1"><a href="javascript:enterHelpCenter('6')" style="text-decoration: none;color:#787878">投诉建议</a></span> <span class="spandown1">&nbsp;|&nbsp;</span>
	  <span class="spandown1"><a href="javascript:enterHelpCenter('7')" style="text-decoration: none;color:#787878">广告服务</a></span> <span class="spandown1">&nbsp;|&nbsp;</span>
 <span class="spandown1"><a href="javascript:enterHelpCenter('8')" style="text-decoration: none;color:#787878">联系我们</a></span> <span class="spandown1">&nbsp;&nbsp;</span>
 
 
 </div> 
 
 
 <div style="width:100%; margin-top:10px; text-align:center">
<span class="spandown1" style="margin-top: 10px">
Copyright&copy; 2012-2013wepic.cn  上海维拓网络科技有限公司 版权所有。ICP备案/许可证编号：沪ICP备13010366号
</span>
 
 
 </div> 
 
 <div style="width:100%; margin-top:18px; text-align:center">

   <span class="spandown1">版权声明:&nbsp;&nbsp;所有图片及文件都受著作权保护未经许可不得使用,不得转载,摘编</span> 

   <span><script src="http://s95.cnzz.com/stat.php?id=5331846&web_id=5331846&show=pic1" language="JavaScript"></script></span>
   <span><script type="text/javascript">
var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3F714145f405cfbcb1596d76414f030a48' type='text/javascript'%3E%3C/script%3E"));
</script></span>
 </div> 
 

  
  

</div>


</body>
</html>
