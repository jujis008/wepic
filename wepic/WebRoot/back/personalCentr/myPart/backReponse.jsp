<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'backReponse.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/jquery.js"></script>
<script type="text/javascript">
$(function(){
	//ss1
 var msg='<s:property value="msg"/>';
 if($.trim(msg)!=''){ //发布和应约为同一人2//应约失败3//未登录4重复应约
	 if(msg==1){
		 alert("您不能应约自己发布的约拍");
		 }
	 else if(msg==4){
		 alert("此约拍您已应约");
		 }

    window.location.href='bid!findAllMyBidForFrontend.do';
	 }


	
})

function applay(id){


	 window.location.href="responseInvitednew!customerApplayForBid.do?bidId="+id+"&url="+window.location.href;
	
}


</script>
  </head>
 
  <body>
  <table style="width:50%; border: 1px solid gray;" border="1px">
  <tr>
  <td>约拍名称</td>
   <td>发布人</td>
    <td>发布时间</td>
     <td>操作</td>
  </tr>
  <s:iterator value="pager.resultList">
  <tr>
  <td>
  <s:property value="name"/>
  </td>
   <td> <s:property value="user.nickName"/></td>
    <td>
    <s:property value="content"/>
   
    <!--ddd  -->
    </td>
     <td><a href="javascript:applay('<s:property value="id"/>')">应约</a></td>
  </tr>
  </s:iterator>
  
  </table>
  
  
  
  
  
  
  
  
  
  
  
  </body>
</html>
