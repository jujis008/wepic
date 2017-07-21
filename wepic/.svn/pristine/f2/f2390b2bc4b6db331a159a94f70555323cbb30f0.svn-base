<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.wetuo.wepic.core.actions.PageNumber"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'wen.jsp' starting page</title>
    
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
    
    
    <%        int max=8;    //自己定义 
              int pagecount=18;    //你总有办法获取的 
              int showpage= 1;   //难不到你 
                PageNumber number=new PageNumber();      //getRount()方法所在的类 
              int[] inter=number.getRount(max,pagecount,showpage);
              for(int i=inter[0];i<=inter[1];i++){%>
                <a href="#?page=<%=i %>"><%=i %></a>
                <%}%>
    
    
    
  </body>
</html>
