<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="shortcut icon" href="${pageContext.request.contextPath}/public/images/logoSmall.ico"/>

<title>wepic管理员_作品_摄影故事_被下架列表</title>

<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/jquery.js"></script>




<!--公共js-->

<script type="text/javascript" src="${pageContext.request.contextPath}/administrator/publicAdministrator/js/publicAdministrator.js"></script>

<!--公共css-->
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/administrator/publicAdministrator/css/publicAdministrator.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public/css/public.css" />



<script type="text/javascript" src="${pageContext.request.contextPath}/administrator/production/js/picWorkSoldOutList.js"></script>

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/administrator/production/css/picWorkNoPassList.css" />
</head>

<body>
<div id="container">
	
    
<!-- 头部结束-->
	<!-- logo行-->
    <div id="divTop">
    	<div class="divtop">
        	<div class="divLogo">
                <a class="imgLogo" href="http://www.wepic.cn/" target="_self" title="唯图网_商业拍摄 原创商业图片交易平台">
                    <img src="${pageContext.request.contextPath}/public/images/wepic_logo.png" alt="唯图网"/>
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
            	<li id="production" class="active">
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
        	<a href="<%=basePath %>publish!adminCheckPhotoPic.do"><div class='bar active'><span>图片作品</span><i></i></div></a>
            
            <a href="<%=basePath %>story!waitcheck.do"><div class='bar'><span>摄影故事</span><i></i></div></a>
            
        </div>
    	
        <div id="divThreeStage">
        
        <div class="threeStage">
          <a href="publish!adminCheckPhotoPic.do"><div class='bar'><span>待审核作品</span><i></i></div></a>
                
                <a href="publish!adminPassPhotoPic.do"><div class='bar'><span>作品列表</span><i></i></div></a>
                
                <a href="publish!adminNoPassList.do"><div class='bar'><span>未通过审核作品</span><i></i></div></a>
                 <a href="publish!adminUndercarriageList.do"><div class='bar active'><span>已下架的作品</span><i></i></div></a>
                
        </div>
        </div>
    </div>
    <!-- 二级导航  end-->
    
    
    
    
    
    <!--内容-->
    <div id="divContent">
        
        <!--排序-->
        <div class="sort">
            <table>
                <tr>
                    <td class="td1">筛选：</td>
                    <td class="td2">
                        <div class="divdropDown">
                            <div class="dropDownBox" onclick="showBelow('divdropDownCategory')">
                                <span id="divdropDownViewCategory">所有类别</span>
                                <div class="dropDownBoxR"><i></i></div>
                            </div>
                
                            <div class="dropDownBoxValue" id="divdropDownCategory">
                                <span class='dropValue'>类别类别类别1</span>
                                <span class='dropValue'>类别类别类别2</span>
                                <span class='dropValue'>类别类别类别1</span>
                                <span class='dropValue'>类别类别2</span>
                                <span class='dropValue'>类别类别1</span>
                                <span class='dropValue'>类别2</span>
                            </div>
                        </div>
                    </td>
                    
                    <td>
                        <div class="divdropDown">
                            <div class="dropDownBox" onclick="showBelow('divdropDownType')">
                                <span id="divdropDownViewType">所有类型</span>
                                <div class="dropDownBoxR"><i></i></div>
                            </div>
                
                            <div class="dropDownBoxValue" id="divdropDownType">
                                <span class='dropValue'>类型类型类型1</span>
                                <span class='dropValue'>类型类型类型类型2</span>
                                <span class='dropValue'>类型类型类型1</span>
                                <span class='dropValue'>类型类类型2</span>
                                <span class='dropValue'>类类型类型型1</span>
                                <span class='dropValue'>类类型类型型2</span>
                            </div>
                        </div>
                    </td>
                </tr>
            </table>
            
        </div>
        <!--排序-->
    	
        
        
        
        <!--图片内容-->
        <div id="phoStroyContent">
        	<div class="phoStroyContentUl">
            	<ul>
            		<s:iterator value="pager.resultList">
                	<li>
                    	<div class="phoStroyContentLi">
                    	<!--默认显示-->
                       <div class="divDefault">
                                <div class="photographyStoryPic">                               
                                    <img src="<s:property value="thumbnailUrl"/>" />
                                    <input type="hidden"  id="picId" value="<s:property value="id"/>" />
                                </div>
                                
                                <div class="photographyStoryInfo">
                                    <div class="headImg">
                                      <div class="headImgCon">
                                         <s:if test="user.portrait!=null">                                  
                                          <img src="<s:property value="user.portrait"/>" class="head"/>
                                          </s:if>
                                          <s:else>
                                          <img src="${pageContext.request.contextPath}\back\personalCentr\publish\images\defaultHead_150.png" class="head"/>
                                          </s:else>
                                          <img src="${pageContext.request.contextPath}/back/pubimg/images/radHead.png" class="radius"/>
                                      </div>
                                    </div>
                                    <div class="info">
                                        <div class="name"> <s:property value="user.nickName"/></div>
                                        <div class="detail">
                                        <s:if test="user.sex=='男'">
                                            <a class="userPositionNameG" title="年龄"><span><s:property value="user.age"/></span>岁</a>
                                            </s:if>
                                            <s:else>
                                             <a class="userPositionName" title="年龄"><span><s:property value="user.age"/></span>岁</a>
                                            
                                            </s:else>
                                            <a class="userPositionAddress" title="地址"><span><s:property value="user.workPlace"/></span></a>
                                            <a class="pstype" title="职业"><div class='bar active'><span><s:property value="user.userCat.name"/></span><i></i></div></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        	
                        	<!--默认显示-->
                           
                            
                            <!--鼠标滑过显示-->
                            <div class="nowtop">
                        		<div class="bj"></div>
                        		<div class="bjc">
                                	<div class="viewBjCon" title="查看详情" onclick="window.location.href='${pageContext.request.contextPath}/publish!adminUndercarriageDetail.do?id=<s:property value="id"/>'">
                                        <div class="picName">图片数标题</div>
                                        
                                       <table class="tableOne">
                                        <tr>
                                            <td class="td1"><span>作品编号：</span></td>
                                            <td class="td2" colspan="3"><span><s:property value="picNumber"/></span></td>
                                        </tr>
                                        <tr>
                                            <td class="td1"><span>上传时间：</span></td>
                                            <td class="td2"><span><s:property value="upTime"/></span></td>
                                            <td class="td1"><span>提交审核：</span></td>
                                            <td class="td2"><span>
                                            <s:date name="publishTime" format="yyyy/MM/dd"/>
                                            </span></td>
                                        </tr>
                                        
                                    </table>
                                        <div class="photographyStoryLiConShare">
                                            <a class="photographyStoryLiConShareOne" title="浏览次数"><span>0</span></a>
                                            <a class="photographyStoryLiConShareTwo" title="收藏次数"><span>0</span></a>
                                            <a class="photographyStoryLiConShareThree" title="推荐次数"><span>0</span></a>
                                        </div>
                                        <div class="divNoPassReaXJ">
                                            <div>下架原因：</div>
                                           <s:iterator value="resons" id="reson">
                                            <div class="rea">①<s:property value="reson"/></div>
                                          
                                            </s:iterator>
                                        </div>
                                    </div>
                                    
                                    <div class="divDel">
                                    	 <a href="javascript:" class="directDel">恢复发布</a>
                                    	 <a href="javascript:" class="directHF">直接删除</a>
                                    </div>   
                                </div>
                        	</div>
                            <!--鼠标rrr滑过显示-->
                        </div>
                	</li>
                    </s:iterator>
                   
                   
                    
                    
                    <div style="clear:both;"></div>
                </ul>
            </div>
        
         
               
        
        
        </div>
        
        
        
        
        <!--图片内容-->
    </div>
    <!--翻页-->
                <div class="ppointPagingthis">
        <div class="ppointPaging">            
            <table class="tablePpointPaging">
                	<tr>
                    	<td class="ppointPagingOne"><a href="javascript:"></td>
                        <td class="ppointPagingPre"><a href="javascript:"></td>
                    	<td class="ppointPagingN"><a href="javascript:">1</td>
                        <td class="ppointPagingN"><a href="javascript:">2</td>
                    	<td class="ppointPagingN"><a href="javascript:">3</td>
                        <td class="ppointPagingN"><a href="javascript:">4</td>
                    	<td class="ppointPagingN"><a href="javascript:">5</td>
                        <td class="ppointPagingN"><a href="javascript:">6</td>
                    	<td class="ppointPagingN"><a href="javascript:">7</td>
                        <td class="ppointPagingN"><a href="javascript:">8</td>
                    	<td class="ppointPagingN"><a href="javascript:">9</td>
                        <td class="ppointPagingN"><a href="javascript:">10</td>
                    	<td class="ppointPagingNext"><a href="javascript:"></td>
                        <td class="ppointPagingLast"><a href="javascript:"></td>
                    </tr>
                </table>
        </div>
        		</div>
        <!--翻页-->
        
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
    
                 
                    
	<div id="goTopBtn" style="display:none;"></div>
</div>
<!--[if lte IE 6]>
<script src="${pageContext.request.contextPath}/public/js/DD_belatedPNG_0.0.8a.js" type="text/javascript"></script>
    <script type="text/javascript">
        DD_belatedPNG.fix('div, ul, img, li, input , a , i');
    </script>
<![endif]-->


</body>
</html>
