<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.weibo.login.weibo4j.Oauth"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'sendWeibo.jsp' starting page</title>
    
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
   <%
   
   response.setContentType("text/html;charset=utf-8");
   try {
       response.sendRedirect(new Oauth().authorize("code","1","2"));
   } catch (Exception e) {
       e.printStackTrace();
   }
   
   
   
   %>
  </body>
</html>
