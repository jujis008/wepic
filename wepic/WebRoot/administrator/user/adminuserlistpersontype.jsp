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

<title>wepic管理员_用户_个人列表</title>

<script type="text/javascript" src="<%=basePath %>public/js/jquery.js"></script>




<!--公共js-->

<script type="text/javascript" src="<%=basePath %>administrator/publicAdministrator/js/publicAdministrator.js"></script>

<!--公共css-->
<link type="text/css" rel="stylesheet" href="<%=basePath %>administrator/publicAdministrator/css/publicAdministrator1.css" />
<link type="text/css" rel="stylesheet" href="<%=basePath %>public/css/public.css" />


<link type="text/css" rel="stylesheet" href="<%=basePath %>administrator/user/css/userPersonalList.css" />
<script type="text/javascript" src="<%=basePath %>administrator/user/js/userPersonalList.js"></script>

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
            
        	<a href="<%=basePath %>configure!adminpersonlist.do"><div class='bar active'><span>用户列表</span><i></i></div></a>
            
            <a href="<%=basePath %>configure!adminpersoncheck.do"><div class='bar active'><span>实名认证</span><i></i></div></a>
            
            <a href="userDateIndex.html"><div class='bar'><span>用户数据</span><i></i></div></a>
            
        </div>
    	
        <div id="divThreeStage">
            
            <div class="threeStage">
                <a href="<%=basePath %>configure!adminpersonlist.do"><div class='bar active'><span>个人</span><i></i></div></a>
                
                <a href="<%=basePath %>configure!adminorganizationlist.do"><div class='bar'><span>机构</span><i></i></div></a>
                
                <a href="<%=basePath %>configure!adminusernochooselist.do"><div class='bar'><span>无身份类型</span><i></i></div></a>
                
            	<a href="userlListFreeze.html"><div class='bar'><span>冻结账户</span><i></i></div></a>
                
            	<a href="userlListBlacklist.html"><div class='bar'><span>黑名单</span><i></i></div></a>
                
            </div>
            
        </div>
    </div>
    <!-- 二级导航  end-->
    
    
    
    
    
    <!--内容-->
    <div class="container_body">
        <div class="div_job">
           <div class="div_left">个人用户列表</div>
            
           <div class="all_job" id="allJobFiltrate">
           <s:if test="usercatId ==0">
           <div class='bar active' onclick="allzhiye()"><span>全部职业</span><i></i></div>
           </s:if>
           <s:else>
           <div class='bar' onclick="allzhiye()"><span>全部职业</span><i></i></div>
           </s:else>
              <s:iterator value="userCats" var="usercat">
            	<s:if test="usercatId == #usercat.id">
            	<s:if test="#usercat.name == '演艺人士'">
            	
            	<div class='bar active' onclick="adminpersontype(<s:property value="#usercat.id"/>)"><span>艺人</span><i></i></div>
            	</s:if>
            	<s:else>
            	<div class='bar active' onclick="adminpersontype(<s:property value="#usercat.id"/>)"><span><s:property value="#usercat.name"/></span><i></i></div>
            	</s:else>            	
            	</s:if>
            	<s:else>
            	<s:if test="#usercat.name == '演艺人士'">
            	<div class='bar' onclick="adminpersontype(<s:property value="#usercat.id"/>)"><span>艺人</span><i></i></div>
            	</s:if>
            	<s:else>
            	<div class='bar' onclick="adminpersontype(<s:property value="#usercat.id"/>)"><span><s:property value="#usercat.name"/></span><i></i></div>
            	</s:else>
            	</s:else>
            	</s:iterator>
              
          </div>
          
        	<div class="div_search">
                <input class="text" type="text"/>
                <i class="i_name"></i>
            </div>
            
            
        </div>
        
        
        <div class="div_container">
        	<table id="tablePersonList">
        	<s:iterator value="pager.resultList" var="list">
            	<tr>
                	<td class="td_one">
                    	<div class="headImg">
                    	
                        	<s:if test="#list.portrait =='' || #list.portrait ==null">
                    		<img src="<%=basePath %>public/images/defaultHead_80.png" class="headimg"/>
                    	</s:if>
                    	<s:else>
                    		<img src="<s:property value="#list.portrait"/>" class="headimg"/>
                    	</s:else>
                        </div>
                         <div class="info">
                            <div class="name">
                                <span class="namechar" title="名字全称"><s:property value="#list.nickName"/></span>
                                <a class="approveNo" title="未实名认证"></a>
                               <!-- <a class="approveHave" title="个人实名认证"></a>-->
                                <a class="gradeFour"></a>
                            </div>
                            <div class="detail">
                                <span>注册时间：</span>
                                <span><s:date name="#list.regTime" format="yyyy-MM-dd"/></span>
                            </div>
                        </div>
                    </td>
                    
                    <td class="td_laterOne">
                    	<div class="td_div_one">
                        	<span>用户名:</span>
                            <span><s:property value="#list.username"/></span>
                        </div>
                        <div class="td_div_two">
                            <s:if test='#list.sex == "男"'>
                            <a class="userPositionNameG" title="年龄"><span><s:property value="#list.age"/></span>岁</a>
                            </s:if>
                            <s:else>
                            <a class="userPositionName" title="年龄"><span><s:property value="#list.age"/></span>岁</a>
                            </s:else>
                            
                            <a class="userPositionAddress" title="地址"><span>上海</span><span class="shi">嘉定</span></a>
                        </div>
                    </td>
                    
                    <td class="td_laterTwo">
                    <s:if test="#list.ifIdentityTrue ==0">
                    <div class="td_div_one">
                        	<span>真实姓名:</span>
                            <span>未认证</span>
                        </div>
                        <div class="td_div_two">
                        	<span>手机:</span>
                            <span>
                            <s:if test="#list.mobile == null">
                                                                          暂无
                            </s:if>
                            <s:else>
                            <s:property value="#list.mobile"/>
                            </s:else>
                            </span>
                        </div>
                    </s:if>
                    <s:if test="#list.ifIdentityTrue ==2">
                    <div class="td_div_one">
                        	<span>真实姓名:</span>
                            <span><s:property value="#list.realName"/></span>
                        </div>
                        <div class="td_div_two">
                        	<span>手机:</span>
                            <span><s:property value="#list.mobile"/></span>
                        </div>
                    </s:if>
                    </td>
                    
                    <td class="td_laterThree">
                    	<div class="td_div_one">
                        	<span>用户类型:</span>
                            <span> <s:property value="#list.userCat.name"/> </span>
                        </div>
                        <div class="td_div_two">
                        	<span>职业:</span>
                            <a class="pstype" title="职业"><div class='bar active'><span><s:property value="#list.userCat.name"/></span><i></i></div></a>
                        </div>
                    </td>
                    
                    <td class="td_laterFour">
                    	<div class="td_div_one">
                        	<span>账户总额:</span>
                            <span>23123</span>元
                        </div>
                        <div class="td_div_two">
                        	<span>冻结金额:</span>
                            <span>2312</span>元
                        </div>
                    </td>
                    
                    <td class="td_laterView">
                    	<div class="td_div_one">
                        	<span>查看详情</span>
                        </div>
                    </td>
                </tr>
            	</s:iterator>
                
            </table>
        
        </div>
        
        
        
        
         <s:if test="pager.rowCount >= 10">
     <!--翻页-->
     <div class="ppointPagingthis">
        <div class="ppointPaging">            
            <table class="tablePpointPaging">
                	<tr>
                    	
                    	<s:bean name="org.apache.struts2.util.Counter" id="counter">  
                    	<td class="ppointPagingOne"><a href="configure!adminpersoncheck.do?pageNo=1"></a></td>
                    	<s:if test="pager.pageCount ==1">
                        <td class="ppointPagingPre"><a href="configure!adminpersoncheck.do?pageNo=1"></a></td>
                        </s:if>
                        <s:else>
                        <td class="ppointPagingPre"><a href="configure!adminpersoncheck.do?pageNo=<s:property value='pager.prePageNo'/>"></a></td>
                        </s:else>
         <s:param name="first" value="1"/>  
          <s:param name="last" value="pager.pageCount"/>  
          <s:iterator>  
          <s:if test="pager.pageNo==current-1">
          <td class="ppointPagingN"><a href="configure!adminpersoncheck.do?pageNo=<s:property />"><s:property /></a></td>
          </s:if>
          <s:else>
            <td class="ppointPagingN"><a href="configure!adminpersoncheck.do?pageNo=<s:property />"><s:property /></a></td>
          </s:else>
           </s:iterator> 
           <s:if test="pager.pageCount ==1"> 
           <td class="ppointPagingNext"><a href="configure!adminpersoncheck.do?pageNo=1"></a></td>
           </s:if>
           <s:else >
           <td class="ppointPagingNext"><a href="configure!adminpersoncheck.do?pageNo=<s:property value='pager.nextPageNo'/>"></a></td>
           </s:else>
           <td class="ppointPagingLast"><a href="configure!adminpersoncheck.do?pageNo=<s:property value='pager.pageCount'/>"></a></td>
            </s:bean>  
                    	
                    </tr>
                </table>
        </div>
        		</div>
        		</s:if>
        <!--翻页-->
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

