<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'buypic.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  
    <table style="width: 200px;" >
    <tr>
    <td>id</td>
    <td>操作</td>
    </tr>
    <s:iterator value="imgChangeList" var="pic">
    <tr>
    <td><s:property value="#pic.id"/></td>
    <td><a href="buyCartDeal!addShopCart.do?buyid=<s:property value='#pic.id'/>&mychoice=1&buytype=1">购买</a></td>
    </tr>
    </s:iterator>
    </table>
  </body>
</html>
