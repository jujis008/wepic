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

<title>wepic管理员_用户_实名认证待审核_个人_未通过列表</title>

<script type="text/javascript" src="<%=basePath %>public/js/jquery.js"></script>




<!--公共js-->

<script type="text/javascript" src="<%=basePath %>administrator/publicAdministrator/js/publicAdministrator.js"></script>

<!--公共css-->
<link type="text/css" rel="stylesheet" href="<%=basePath %>administrator/publicAdministrator/css/publicAdministrator1.css" />
<link type="text/css" rel="stylesheet" href="<%=basePath %>public/css/public.css" />


<link type="text/css" rel="stylesheet" href="<%=basePath %>administrator/user/css/autonymAttestationCheckPresonalList.css" />



<script>
function checkpersondetail(id){
   var catid=$("#catId").val();
   location.href="configure!checkpersonnopassdetail.do?userId="+id+"&usercatId="+catid;
}
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
                <a href="<%=basePath %>configure!adminpersoncheck.do"><div class='bar'><span>个人待审核</span><i></i></div></a>
                
                <a href="<%=basePath %>configure!adminorganizationcheck.do"><div class='bar'><span>企业待审核</span><i></i></div></a>
                
                <a href="<%=basePath %>configure!adminpersonchecknopasslist.do"><div class='bar active'><span>个人未通过</span><i></i></div></a>
                
            	<a href="<%=basePath %>configure!adminorganizationnopasslist.do"><div class='bar'><span>企业未通过</span><i></i></div></a>
                
            </div>
        </div>
    </div>
    <!-- 二级导航  end-->
    
    
    
    
    
    <!--内容-->
    <div class="container_body">
    <input type="hidden" value="<s:property value="usercatId"/>" id="catId"/>
        <div class="div_job">
            <ul class="ul_job" id="jobUl">
            	<li onclick="adminpersonnopass()">全部职业</li>
            	
            	<s:iterator value="userCats" var="usercat">
            	<s:if test="usercatId == #usercat.id">            	
            	<li class="active" onclick="adminpersonnopassbytype(<s:property value="#usercat.id"/>)"><s:property value="#usercat.name"/></li>
            	</s:if>
            	<s:else>
            	<li onclick="adminpersonnopassbytype(<s:property value="#usercat.id"/>)"><s:property value="#usercat.name"/></li>
            	</s:else>
            	</s:iterator>
            
            </ul>
        </div>
        
        
      <div class="divStateCardCon">
          <div class="divList">
              <ul id="divListUL">
              <s:iterator value="pager.resultList" var="list">
              
                 <li onclick="checkpersondetail(<s:property value="#list.id"/>)">
                      <div class="divImg">
                      
                          <s:if test="#list.portrait =='' || #list.portrait ==null">
                    		<img src="<%=basePath %>public/images/defaultHead_80.png" class="headimg"/>
                    	</s:if>
                    	<s:else>
                    		<img src="<s:property value="#list.portrait"/>" class="headimg"/>
                    	</s:else>
                      </div>
                      
                      <div class="divUserInfo">
                          <div class="one">
                              <span class="name"><s:property value="#list.nickName"/></span>
                          </div>
                          <div class="two">
                          <s:if test='#list.sex == "男"'>
                               <!--男--><a class="ageMan" title="年龄"><s:property value="#list.age"/>岁</a>
                          </s:if>
                          <s:else>
                              <!--女--><a class="age" title="年龄"><s:property value="#list.age"/>岁</a>
                          </s:else>
                          
                          
                              <a class="address" title="工作地"><span>上海</span><span>嘉定</span></a>
                          </div>
                          <div class="three"><div class="job" title="职业"><span> <s:property value="#list.userCat.name"/> </span><a></a></div>
                          </div>
                          <div class="four"><span>申请时间：</span><span><s:property value="#list.validatetime"/></span></div>
                      </div>
                  </li>
              </s:iterator>
                  <div style="clear:both;"></div>
              </ul>
              
              
              <s:if test="pager.rowCount >= 24">
     <!--翻页-->
     <div class="ppointPagingthis">
        <div class="ppointPaging">            
            <table class="tablePpointPaging">
                	<tr>
                    	
                    	<s:bean name="org.apache.struts2.util.Counter" id="counter">  
                    	<td class="ppointPagingOne"><a href="configure!adminpersonchecknopasslistbytype.do?pageNo=1"></a></td>
                    	<s:if test="pager.pageCount ==1">
                        <td class="ppointPagingPre"><a href="configure!adminpersonchecknopasslistbytype.do?pageNo=1"></a></td>
                        </s:if>
                        <s:else>
                        <td class="ppointPagingPre"><a href="configure!adminpersonchecknopasslistbytype.do?pageNo=<s:property value='pager.prePageNo'/>"></a></td>
                        </s:else>
         <s:param name="first" value="1"/>  
          <s:param name="last" value="pager.pageCount"/>  
          <s:iterator>  
          <s:if test="pager.pageNo==current-1">
          <td class="ppointPagingN"><a href="configure!adminpersonchecknopasslistbytype.do?pageNo=<s:property />"><s:property /></a></td>
          </s:if>
          <s:else>
            <td class="ppointPagingN"><a href="configure!adminpersonchecknopasslistbytype.do?pageNo=<s:property />"><s:property /></a></td>
          </s:else>
           </s:iterator> 
           <s:if test="pager.pageCount ==1"> 
           <td class="ppointPagingNext"><a href="configure!adminpersonchecknopasslistbytype.do?pageNo=1"></a></td>
           </s:if>
           <s:else >
           <td class="ppointPagingNext"><a href="configure!adminpersonchecknopasslistbytype.do?pageNo=<s:property value='pager.nextPageNo'/>"></a></td>
           </s:else>
           <td class="ppointPagingLast"><a href="configure!adminpersonchecknopasslistbytype.do?pageNo=<s:property value='pager.pageCount'/>"></a></td>
            </s:bean>  
                    	
                    </tr>
                </table>
        </div>
        		</div>
        		</s:if>
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

