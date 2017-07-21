<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s" %>
 <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="shortcut icon" href="<%=basePath %>public/images/logoSmall.ico"/>

<title>wepic管理员_用户_实名认证待审核_个人_单个审核</title>
<script type="text/javascript" src="<%=basePath %>public/js/imgsf.js"></script>
<script type="text/javascript" src="<%=basePath %>public/js/jquery.js"></script>




<!--公共js11-->

<script type="text/javascript" src="<%=basePath %>administrator/publicAdministrator/js/publicAdministrator.js"></script>

<!--公共css-->
<link type="text/css" rel="stylesheet" href="<%=basePath %>administrator/publicAdministrator/css/publicAdministrator1.css" />
<link type="text/css" rel="stylesheet" href="<%=basePath %>public/css/public.css" />
<link type="text/css" rel="stylesheet" href="<%=basePath %>administrator/user/css/autonymAttestationCheckPresonal.css" />
<script type="text/javascript" src="<%=basePath %>administrator/user/js/autonymAttestationCheckPresonal.js"></script>
<script type="text/javascript">
   function pass(id){
   location.href="configure!checkpersonpass.do?userId="+id;
   }
   $(function(){
        var id=$("#usercatid").val();
        $.ajax({
  	      type:"Post",
  		  url: "configurajson_userprenext.do?usercatId="+id+"&userpersonOrCompany=1&userifIdentityTrue=1",
  		  data:"",		
  		  success : function(data) {
  	  	  var list=data.users;
  	  	  
  	  	  var cxt="";
  	  	  var currentId='<s:property value="user.id"/>';
  	  	  var pre="";
  	  	  var next="";
  	  	  var myArray=new Array();
  	  	  for(var i=0;i<list.length;i++){
  	  	      myArray.push(list[i].id);	  
  	  	  }
  	  	  var fir=myArray[0];
  	  	  var last=myArray[myArray.length-1];
  	  	  if(myArray.length <= 1){
  	  	     pre=myArray[0];
  	  	     next=myArray[0];
  	  	  }else{
  	  	  for(var i=0; i<myArray.length;i++){
  	  	      if(myArray[i] == currentStoryId){
  	  	      pre=myArray[i-1];
	  	  	          next=myArray[i+1];
  	  	           if(myArray[i] == fir){
  	  	           pre=myArray[i];
	  	  	          next=myArray[i+1];
  	  	           }else if(myArray[i] == last){
	  	  	          pre=myArray[i-1];
	  	  	          next=myArray[i];
	  	  	  }
	  	  	          
	  	  	  }
  	  	  }
  	  	  }
  	  	  cxt+="<div class='pre'><a href='configure!checkpersonnopassdetail.do?userId="+pre+"'><i></i><span >上一位</span></a></div><div class='next'>"+
               "<a href='configure!checkpersonnopassdetail.do?userId="+next+"'><span>下一位</span><i></i></a></div>";
           $(".preNext").html(cxt);  	  	  
  		  }
    	});
        });
</script>
</head>

<body>
<div id="container">
	
    
<!-- 头部结束-->
	<!-- logo行-->
    <div id="divTop">
    	<div class="divtop">
        	<div class="divLogo">
                <a class="imgLogo" href="http://www.wepic.cn/" target="_self" title="唯图网_商业拍摄 原创商业图片交易平台">
                    <img src="<%=basePath %>public/images/wepic_logo.png" alt="唯图网"/>
                    <p><span class="spanLogo">商业拍摄</span><span>原创商业图片交易平台</p>
                </a>
            </div>
            
            <div class="divAdminSpan">
                <span class="center">管理员中心</span>
                <span>V.2.0.0</span>
            </div>
            
            <div class="divTopPperation">
                <div class="left">
                	<div class="one">SuperAdmin</div>
                	<div class="two">超级管理员</div>
                </div>
                <div class="configuration">
                	<a href="javascript:">
                    	<div class="config"></div>
						<p>配置中心</p>
                    </a>
                </div>
                <div class="divExit">
                	<a href="javascript:">
                    	<div class="exit"></div>
						<p>安全退出</p>
                    </a>
                </div>
            </div>
    	</div>
    
                    
   	</div>
    <!-- logo行-->
    
    
    
    
    <!-- 分割线-->
    <div id="divSeparation">
    	<div id="divSeparation2">
        	<div id="divSeparation3">
            	<div id="divSeparation4">
                	<div id="divSeparation5">
                    </div>
                </div>
        	</div>
        </div>
    </div>
    <!-- 分割线over -->
    
	
    <!-- 导航 -->
  	<div id="mainbar">
    	<div id="mainbarCenter">
    		<ul>
        		<li id="index">
            		<a href="javascript:">首页</a>
            	</li>
            	<li id="user">
            		<a href="<%=basePath %>administrator/user/adminCheckPersonalList.jsp">用户</a>
            	</li>
            	<li id="production">
            		<a href="<%=basePath %>administrator/production/story/shootStoryAuthstrList.jsp">作品</a>
           	 	</li>
            	<li id="project">
            		<a href="javascript:">项目</a>
            	</li>
                <li id="capital">
            		<a href="<%=basePath %>administrator/capital/captialadminlist.jsp">资金</a>
            	</li>
            	<li id="transaction">
            		<a href="javascript:">交易</a>
           	 	</li>
            	<li id="complaint">
            		<a href="javascript:">投诉</a>
            	</li>
                <li id="subscription">
            		<a href="javascript:">订阅</a>
            	</li>
                <li id="message">
            		<a href="javascript:">消息</a>
            	</li>
        	</ul>
            
            <div class="onLine">
                <span>当前在线：</span>
                <span>423432</span>人
            </div>
        </div>
        
        
	</div>
    <!-- 导航  end-->
    
     <!-- 二级导航 -->
  	<div id="assistantBar">
    	<div class="twoStage" id="divTwoStage">
        	<a href="userSituationIndex.html"><div class='bar'><span>用户概况</span><i></i></div></a>
            
        	<a href="<%=basePath %>configure!adminpersonlist.do"><div class='bar'><span>用户列表</span><i></i></div></a>
            
            <a href="<%=basePath %>configure!adminpersoncheck.do"><div class='bar active'><span>实名认证</span><i></i></div></a>
            
            <a href="userDateIndex.html"><div class='bar'><span>用户数据</span><i></i></div></a>
            
        </div>
    	
        <div id="divThreeStage">
        
            <div class="threeStage">
                <a href="<%=basePath %>configure!adminpersoncheck.do"><div class='bar active'><span>个人待审核</span><i></i></div></a>
                
                <a href="<%=basePath %>configure!adminorganizationcheck.do"><div class='bar'><span>企业待审核</span><i></i></div></a>
                
                <a href="<%=basePath %>configure!adminpersonchecknopasslist.do"><div class='bar'><span>个人未通过</span><i></i></div></a>
                
            	<a href="<%=basePath %>configure!adminorganizationnopasslist.do"><div class='bar'><span>企业未通过</span><i></i></div></a>
                
            </div>
        </div>
    </div>
    <!-- 二级导航  end-->
    
    
    
    
    
    <!--内容-->
    <div class="container_body">
    <input type="hidden" id="usercatid" value="<s:property value="usercatId"/>"/>
        <div class="div_job">
            <ul class="ul_job">
                <s:if test="usercatId ==0">
            	<li onclick="adminpersoncheckall()" class="active">全部职业</li>
            	</s:if>
            	<s:else>
            	<li onclick="adminpersoncheckall()">全部职业</li>
            	</s:else>
            	<s:iterator value="userCats" var="usercat">
            	<s:if test="usercatId == #usercat.id">            	
            	<li class="active" onclick="adminpersoncheckbytype(<s:property value="#usercat.id"/>)"><s:property value="#usercat.name"/></li>
            	</s:if>
            	<s:else>
            	<li onclick="adminpersoncheckbytype(<s:property value="#usercat.id"/>)"><s:property value="#usercat.name"/></li>
            	</s:else>
            	</s:iterator>
            
            </ul>
            <div class="operation">
            	<input class="backToPrevious" type="button" value="返回列表" onclick="window.location='autonymAttestationCheckPresonalList.html'"/>
            
            </div>
        </div>
        
        
        <div class="div_container">
        	<div class="left_Con">
        	
            	<img src="<s:property value="user.idCardBackPic"/>" onclick="openPopUpBox('viewBigPic');" title="查看大图"/>
            </div>
        	<div class="middle_Con">
            	<table>
                	<tr><td class="td_one">真实姓名</td><td class="td_two"> <s:property value="user.realName"/> </td></tr>
                	<tr><td class="td_one">身份证号</td><td class="td_two"> <s:property value="user.idCardNo"/> </td></tr>
                	<tr><td class="td_one">手机号码</td><td class="td_two"><s:property value="user.mobile"/></td></tr>
                	<tr><td class="td_one">固定电话</td><td class="td_two"><s:property value="user.worktel"/></td></tr>
                	<tr><td class="td_one">联系地址</td><td class="td_two"><s:property value="user.residence"/></td></tr>
                	<tr><td class="td_one">QQ</td><td class="td_two"><s:property value="user.qq"/></td></tr>
                </table>
            </div>
        	<div class="right_Con">
                <!--上一张下一张-->
                    
                	<div class="preNext">
                        <div class="pre">
                            <a href="javascript:">
                                <i></i>
                                <span>上一位</span>
                            </a>
                        </div>
                        <div class="next">
                            <a href="javascript:">
                                <i></i>
                                <span>下一位</span>
                            </a>
                        </div>
                    </div>
                    
                    <!--上一张下一张-->
                
                <!--操作是否通过-->
                
                <div class="autonyMaudit" id="autonyMaudit">
                    <div class="top">作品审核</div>
                    <div class="opeation">
                        <input class="pass" type="button" id="noPassId" value="不通过" onclick="noPassReason(this,'autonyMaudit','noPassReason')"/>
                        <input class="noPass" type="button" value="通过" onclick="pass(<s:property value="user.id"/>)"/>
                    </div>
                </div>
                <!--操作是否通过-->
                
            	<!--不通过原因-->
            	<form action="configure!checkpersonnopass.do" method="post">
            	<input type="hidden" name="userId" value="<s:property value="user.id"/>"/>
                <div class="noPassReason" id="noPassReason">
                    <div class="top">不通过原因</div>
                    <div class="editNoPass">
                        <table id="tablePass">
                            <tr>
                                <td class="td1"><input id="checkzjwt" type="checkbox" name="nopasscause" value="1"/></td>
                                <td><label for="checkzjwt">您上传的证件不清晰</label></td>
                            </tr>
                        
                            <tr>
                                <td class="td1"><input id="checkzjgd" type="checkbox" name="nopasscause" value="2"/></td>
                                <td><label for="checkzjgd">证件照片有改动</label></td>
                            </tr>
                            
                            <tr>
                                <td class="td1"><input id="checksfz" type="checkbox" name="nopasscause" value="3"/></td>
                                <td><label for="checksfz">您提交的身份信息不正确</label></td>
                            </tr>
                            
                            <tr class="other">
                                <td class="td1" valign="top"><input id="checkqit" type="checkbox" name="nopasscause" value="0"/></td>
                                <td class="otherCon"><label for="checkqit">其他</label><textarea id="checkqitArea" name="otherreason"></textarea></td>
                            </tr>
                        </table>
                        <div class="opeation" id="opeationPass">
                            <input class="pass" type="button" value="取消" onclick="noPassReason(this,'noPassReason','autonyMaudit')"/>
                            <input class="noPass" type="submit" value="保存"/>
                        </div>
                    </div>
                </div>
                <!--不通过原因-->
                </form>
            </div>
        
        </div>
        
    </div>
        
    <!--内容-->
    
    
        
    <!--foot 开始-->
    <div id="divFooter">
    	<div class="divfooter">
        	<a href="http://www.wepic.cn"  target="_blank" class="toIndex">网站首页</a>|
        	<a href="http://www.cnzz.com"  target="_blank" class="toStation">站长统计</a>|
            <a href="http://tongji.baidu.com/web/welcome/login"  target="_blank" class="toBaiduStation">百度站长工具</a>|
            <a href="http://e.baidu.com" target="_blank" class="toBaiduGeneralize">百度推广</a>
        </div>
    </div>
    
    <!--foot 结束-->
    
    
    
    <div id="viewBigPic">
    	<img src="<s:property value="user.idCardBackPic"/>"/>
        <a onclick="cloosePopBox('viewBigPic');"></a>
    </div>
	<div id="goTopBtn" style="display:none;"></div>
</div>
<!--[if lte IE 6]>
<script src="<%=basePath %>public/js/DD_belatedPNG_0.0.8a.js" type="text/javascript"></script>
    <script type="text/javascript">
        DD_belatedPNG.fix('div, ul, img, li, input , a , i');
    </script>
<![endif]-->


</body>
</html>

