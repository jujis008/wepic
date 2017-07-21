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

<title>wepic管理员_作品_摄影故事_已审核作品列表</title>

<script type="text/javascript" src="<%=basePath %>public/js/jquery.js"></script>




<!--公共js-->

<script type="text/javascript" src="<%=basePath %>administrator/publicAdministrator/js/publicAdministrator.js"></script>

<!--公共css-->
<link type="text/css" rel="stylesheet" href="<%=basePath %>administrator/publicAdministrator/css/publicAdministrator.css" />
<link type="text/css" rel="stylesheet" href="<%=basePath %>public/css/public.css" />



<script type="text/javascript" src="<%=basePath %>administrator/production/js/shootStoryPassedList.js"></script>

<link type="text/css" rel="stylesheet" href="<%=basePath %>administrator/production/css/shootStoryPassedList.css" />

<script type="text/javascript">
function adminchecksucsearch(id){
location.href="story!adminchecksucsearch.do?storyId="+id;
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
        	<a href="<%=basePath %>publish!adminCheckPhotoPic.do"><div class='bar'><span>图片作品</span><i></i></div></a>
            
            <a href="<%=basePath %>story!waitcheck.do"><div class='bar active'><span>摄影故事</span><i></i></div></a>
            
        </div>
    	
        <div id="divThreeStage">
        
        <div class="threeStage">
        	<a href="<%=basePath %>story!waitcheck.do"><div class='bar'><span>待审核作品</span><i></i></div></a>
            
            <a href="<%=basePath %>story!checksuclist.do"><div class='bar active'><span>作品列表</span><i></i></div></a>
            
            <a href="<%=basePath %>story!checkfaillist.do"><div class='bar'><span>未通过审核作品</span><i></i></div></a>
            
            <a href="<%=basePath %>story!adminSoldout.do"><div class='bar'><span>被下架列表</span><i></i></div></a>
            
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
                    <td class="td1">摄影故事列表</td>
                </tr>
            </table>
            
            
        </div>
        <!--排序-->
    	
        
        
        
        <!--图片内容-->
        <div id="phoStroyContent">
        	<div class="phoStroyContentUl">
            	<ul>
            	  <s:iterator value="pager.resultList" var="list">
                    <li id="conLiOne">
                    	
                    	<div class="phoStroyContentLi">
                        	<!--默认显示-->
                            <div class="defaultView">
                                <div class="photographyStoryLiHead">
                                    <img src="<s:property value="#list.cover"/>" />
                                    <input type="hidden" value="<s:property value='#list.id'/>" id="checkstoryid"/>
                                </div>
                              
                                <div class="photographyStoryLiCon">
                                    <div class="photographyStoryLiConTitle">
                                        <span><s:property value="#list.title"/></span>
                                    </div>
                                    <div class="photographyStoryLiConInfo">
                                        <span> <s:property value="#list.storydescription"/> </span>
                                    </div>
                                    <div class="photographyStoryLiConShare">
                                        <a class="photographyStoryLiConShareOne" title="浏览次数"><span><s:property value="#list.hit"/></span></a>
                                        <a class="photographyStoryLiConShareTwo" title="收藏次数"><span>64456</span></a>
                                        <a class="photographyStoryLiConShareThree" title="推荐次数"><span>64456</span></a>
                                        <font><s:date name="#list.uploadTime" format="yyyy-MM-dd"/></font>
                                    </div>
                                </div>
                                
                                <div class="photographyStoryInfo">
                                    <div class="headImg">
                                      <div class="headImgCon">
                                          <img src="<s:property value="#list.user.portrait"/>" class="head"/>
                                          <img src="<%=basePath %>back/pubimg/images/radHead.png" class="radius"/>
                                      </div>
                                    </div>
                                    <div class="info">
                                        <div class="name"><s:property value="#list.user.name"/></div>
                                        <div class="detail">
                                            <s:if test='#list.user.sex == "男"'>
                                            <a class="userPositionNameMan" title="年龄"><span><s:property value="#list.user.age"/></span>岁</a>
                                            </s:if>
                                            <s:else>
                                            <a class="userPositionName" title="年龄"><span><s:property value="#list.user.age"/></span>岁</a>
                                            </s:else>
                                            <a class="userPositionAddress" title="地址"><span>上海</span><span class="shi">嘉定</span></a>
                                            <a class="pstype" title="职业"><div class='bar active'><span> <s:property value="#list.user.userCat.name"/> </span><i></i></div></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        	<!--默认显示11-->
                            
                            
                            <!--鼠标滑过显示-->
                            <div class="nowtop">
                        		<div class="bj"></div>
                        		<div class="bjc">
                                	<div class="viewBjCon" title="查看详情" onclick="adminchecksucsearch(<s:property value="#list.id"/>)">
                                         <div class="picInf">
                                            <div class="ifone">图片数<span class="picnum"><s:property value="#list.detailpicNum"/></span>张<span class="sp2">正文字数</span><span class="numw"><s:property value="#list.detailtextNum"/></span>字</div>
                                            <div class="iftwo">作品编号：<span class="worknum"><s:property value="#list.remark"/></span></div>
                                        </div>
                                        
                                        <div class="picUser">
                                            <div class="usone">
                                                <a class="time" title="上传时间"><s:date name="#list.uploadTime" format="yyyy-MM-dd"/></a>
                                                <a class="time2" title="发布时间"><s:date name="#list.publishTime" format="yyyy-MM-dd"/></a>
                                            </div>
                                             <s:if test="#list.copyrightres == 0">
                                             <div class="usti">使用权<span class="syq"><s:property value="#list.usagePrice"/></span>元
                                             <s:if test="#list.saleNum == 0 || #list.saleNum == null">
                                             <span class="sp2">未出售</span>
                                             </s:if>
                                             <s:else>
                                             <span class="sp2">已出售</span><span class="syq"> <s:property value="#list.saleNum"/> </span>次
                                             </s:else>
                                             </div>
                                             </s:if>
                                             <s:if test="#list.copyrightres == 1">
                                            <div class="usti">版权<span class="syq"><s:property value="#list.copyrightPrice"/></span>元<span class="sp2">未出售</span></div> 
                                             </s:if>
                                             <s:if test="#list.copyrightres == 2">
                                            <div class="usti">使用权<span class="syq"><s:property value="#list.usagePrice"/></span>元
                                            <s:if test="#list.saleNum == 0 || #list.saleNum == null">
                                             <span class="sp2">未出售</span>
                                             </s:if>
                                             <s:else>
                                             <span class="sp2">已出售</span><span class="syq"> <s:property value="#list.saleNum"/> </span>次
                                             </s:else>
                                                                                                                        </div>
                                            <div class="usti">版权<span class="syq"><s:property value="#list.copyrightPrice"/></span>元<span class="sp2">未出售</span></div>
                                            </s:if>
                                        </div>
                                    
                                    </div>
                        			
                                    
                                    <div class="picEdit">
                                    <a class="xj" title="下架"></a>
                                        <a class="down" href="story!downloadstory.do?storyId=<s:property value="#list.id"/>" title="下载作品"></a>
                                         <a href="<%=basePath %>story!adminedit.do?storyId=<s:property value="#list.id"/>" target="_blank" class="edit" title="编辑作品"></a>
                                        <a href="<%=basePath %>story!adminchecksucsearch.do?storyId=<s:property value="#list.id"/>" class="view" title="查看作品"></a>
                                    </div>
                                </div>
                        	</div>
                            <!--鼠标滑过显示-->
                            
                        </div>
                	</li>
                    </s:iterator>
                    <div style="clear:both;"></div>
                </ul>
            </div>
        
         
               
        
        
        </div>
        
        
        
        
        <!--图片内容-->
    </div>
    <!--内容-->
    <s:if test="pager.rowCount >= 16">
     <!--翻页-->
     <div class="ppointPagingthis">
        <div class="ppointPaging">            
            <table class="tablePpointPaging">
                	<tr>
                    	
                    	<s:bean name="org.apache.struts2.util.Counter" id="counter">  
                    	<td class="ppointPagingOne"><a href="story!checksuclist.do?pageNo=1"></a></td>
                    	<s:if test="pager.pageCount ==1">
                        <td class="ppointPagingPre"><a href="story!checksuclist.do?pageNo=1"></a></td>
                        </s:if>
                        <s:else>
                        <td class="ppointPagingPre"><a href="story!checksuclist.do?pageNo=<s:property value='pager.prePageNo'/>"></a></td>
                        </s:else>
         <s:param name="first" value="1"/>  
          <s:param name="last" value="pager.pageCount"/>  
          <s:iterator>  
          <s:if test="pager.pageNo==current-1">
          <td class="ppointPagingN"><a href="story!checksuclist.do?pageNo=<s:property />"><s:property /></a></td>
          </s:if>
          <s:else>
            <td class="ppointPagingN"><a href="story!checksuclist.do?pageNo=<s:property />"><s:property /></a></td>
          </s:else>
           </s:iterator> 
           <s:if test="pager.pageCount ==1"> 
           <td class="ppointPagingNext"><a href="story!checksuclist.do?pageNo=1"></a></td>
           </s:if>
           <s:else >
           <td class="ppointPagingNext"><a href="story!checksuclist.do?pageNo=<s:property value='pager.nextPageNo'/>"></a></td>
           </s:else>
           <td class="ppointPagingLast"><a href="story!checksuclist.do?pageNo=<s:property value='pager.pageCount'/>"></a></td>
            </s:bean>  
                    	
                    </tr>
                </table>
        </div>
        		</div>
        		</s:if>
        
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
    
     <!--不通过原因-->
    <div class="noPassReason" id="noPassReason">
        <div class="top">下架原因</div>
        <form action="story!adminsinglesoldout.do" method="post">
         <input type="hidden" value="" name="storyId" id="storynoPassId"/>
        <div class="editNoPass">
            <table id="tablePass">
                <tr class="other">
                    <td class="otherCon"><textarea name="soldoutreason"></textarea></td>
                </tr>
            </table>
            <div class="opeation" id="opeationPass">
                <input class="pass" type="button" value="取消" onclick="cloosePopBox('noPassReason')"/>
                <input class="noPass" type="submit" value="保存" onclick="saveInfo('noPassReason')"/>
                <input type="hidden" id="hiddenSave"/>
            </div>
        </div>
        </form>
    </div>
    <!--不通过原因1111-->               
	<div id="goTopBtn" style="display:none;"></div>
</div>
<!--[if lte IE 6]>
<script src="../../public/js/DD_belatedPNG_0.0.8a.js" type="text/javascript"></script>
    <script type="text/javascript">
        DD_belatedPNG.fix('div, ul, img, li, input , a , i');
    </script>
<![endif]-->


</body>
</html>

