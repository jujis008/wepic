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

<title>wepic管理员_作品_图片作品_单个查看</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/imgsf.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/jquery.js"></script>




<!--公共js-->

<script type="text/javascript" src="${pageContext.request.contextPath}/administrator/publicAdministrator/js/publicAdministrator.js"></script>

<!--公共css-->
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/administrator/publicAdministrator/css/publicAdministrator.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public/css/public.css" />



<script type="text/javascript" src="${pageContext.request.contextPath}/administrator/production/js/picWorkSingleCheck.js"></script>

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/administrator/production/css/picWorkNoPassView.css" />


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
                
                <a href="publish!adminNoPassList.do"><div class='bar active'><span>未通过审核作品</span><i></i></div></a>
                 <a href="publish!adminUndercarriageList.do"><div class='bar'><span>已下架的作品</span><i></i></div></a>
                
            </div>
        </div>
    </div>
    <!-- 二级导航  end-->
    
    
    
    
    
    <!--内容-->
    <div id="divContent">
        <!--排序-->
        <div class="sort">
            <div class="operation">
            	<input class="backToPrevious" type="button" value="返回上一页"/>
            
            </div>
        </div>
        <!--排序-->
    	
        <!--摄影故事内容-->
        <div id="phoStroyDetail">
        	<div class="phoStroyDetailLeft"  id="phoStroyDetailLeft">
        		
                
                <div class="divDescribe">
                	<div class="edit" id="editzpgs">
                    	<div class="bj"></div>
                    	<div class="bjc">
                        	
                            <div class="right">
                            	<a href="javascript:" class="dowload">
                            		<div class="backimg"></div>
									<p>下载故事</p>
                            	</a>
                            	<a href="javascript:" class="delete">
                            		<div class="backimg"></div>
									<p>删除作品</p>
                           		</a>
                            </div>
                        	
                        </div>
                    </div>
                    
                    <div class="divImgCen">
                    	<table>
                        	<tr><td><img src="<s:property value="publish.smallPic"/>"  onload="javascript:DrawImage(this,798,798)"/></td></tr>
                        </table>
                    </div>
                </div>
                
               	
             <div class="divImgInfo">
                    <div class="type">
                    <s:iterator value="publish.publishCats">
                    
                    
                        <div class="retag">
                            <span>
                            <s:property value="name"/>
                            
                            </span>
                            <a></a>
                        </div> 
                        </s:iterator>
                        <div style="clear:both;"></div>
                        
                    </div>
                    
                    
                    <div class="keyword">
                    	<span class="character">关键词</span>
                    	 <s:iterator value="publish.roleTags">
                        <a href="javascript:">
                        <s:property value="tag"/>
                        </a>
                        </s:iterator>
                    </div>
               	</div>
                
                <div class="divImgInfoTwo">
                	<div class="title">这里是描述</div>
                    <div class="info">
                    <s:property value="content"/>
                    </div>
                </div>
                
            </div>
                
               
        
        <!--右部内容-->
         	<div class="phoStroyDetailRight">
        		<form id="formPhoStroyDetail">
                
                       
                <div class="storyCon">
                	<div id="storyConScrollTop">
                        <div class="preNext">
                            <span class="name">不通过原因</span>
                        </div>
                         <!--不通过wedddrt原因-->
                        <div class="noPassReason">
                            <div class="editNoPass">
                                <table id="tablePass">
                                <s:iterator value="publish.resons" id="res">
                                <s:if test="#res==1">
                                  <tr>
                                        <td class="td1">
                                        <input id="checkzjwt" type="checkbox" disabled="disabled" checked="checked"/></td>
                                        <td><label for="checkzjwt">您上传的证件不清晰</label></td>
                                    </tr>
                                
                                </s:if>
                                
                                <s:elseif test="#res==2">
                                <tr>
                                        <td class="td1"><input id="checkzjgd" type="checkbox" disabled="disabled" checked="checked"/></td>
                                        <td><label for="checkzjgd">证件照片有改动</label></td>
                                    </tr>
                                
                                </s:elseif>
                                
                                   <s:elseif test="#res==3">
                                  <tr>
                                        <td class="td1"><input id="checksfz" type="checkbox" disabled="disabled" checked="checked"/></td>
                                        <td><label for="checksfz">您提交的身份信息不正确</label></td>
                                    </tr>
                                
                                </s:elseif>
                                <s:else>
                                 <tr class="other">
                                        <td class="td1" valign="top"><input id="checkqit" type="checkbox" disabled="disabled" checked="checked"/></td>
                                        <td class="otherCon"><label for="checkqit">其他</label><textarea disabled="disabled">
                                        <s:property value="res"/></textarea></td>
                                    </tr>
                                
                                </s:else>
                                
                                  
                                   
                                
                                
                                </s:iterator>
                                
                                
                                
                                  
                                
                                    
                                    
                                 
                                  
                                </table>
                            </div>
                        </div>
                        <!--不通过原因-->
                    </div>
                    
                    
                    
                    
                    <div id="showAll">
                           <div class="photographyStoryInfo">
                            <div class="divTop">作者：</div>
                            <div class="headImg">
                                <div class="headImgCon">
                                    <img src="<s:property value="publish.user.portrait"/>" class="headimg"/>
                                    <img src="${pageContext.request.contextPath}/back/pubimg/images/radHead.png" class="radius"/>
                                   
                                </div>
                             </div>
                             <div class="info">
                                <div class="name">
                                    <span>
                                    <s:property value="publish.user.nickName"/>
                                    </span>
                                    <s:if test="publish.user.ifIdentityTrue==2">
                                    <s:if test="publish.user.personOrCompany==2">
                                    <a class="approveQy" title="企业实名认证"></a>
                                    </s:if>
                                    <s:else>
                                     <a class="approveHave" title="个人实名认证"></a>
                                    </s:else>
                                    
                                    </s:if>
                                    <s:else>
                                    <a class="approveNo" title="未实名认证"></a>
                                    </s:else>
                                    <!---->
                                   
                                    <!-- dddd-->
                                    <a class="gradeFour"></a>
                                    <input type="button" value="看资料" class="viewInfo"/>
                                    
                                     
                                </div>
                                <div class="detail">
                                <s:if test='publish.user.sex=="男"'>
                                    <!--sssss男--><a class="userPositionNameG" title="年龄"><span><s:property value="publish.user.age"/></span>岁</a>
                                    </s:if>
                                    
                                    <s:else>                                    
                                    <a class="userPositionName" title="年龄"><span><s:property value="publish.user.age"/></span>岁</a>
                                    </s:else>
                                    
                                    <!--<a class="userPositionName" title="年龄"><span>56</span>岁</a>-->
                                    <a class="userPositionAddress" title="地址"><span><s:property value="publish.user.workPlace"/></span></a>
                                    <a class="pstype" title="职业"><div class='bar active'><span><s:property value="publish.user.userCat.name"/></span><i></i></div></a>
                                </div>
                            </div>
                        </div>
                                    
                            <div class="head">
                            <div class="char">
                            <s:property value="publish.name"/>
                            </div>
                            <div class="storyInfo">
                                <table>
                                    <tr>
                                        <td><span class="character">作品编号：</span></td>
                                        <td class="td2"><span><s:property value="publish.picNumber"/>   </span></td>
                                        <td><span class="character">上传时间：</span></td>
                                        <td><span><s:property value="publish.upTime"/></span></td>
                                    </tr>
                                    
                                    <tr>
                                        <td><span class="character">原始尺寸：</span></td>
                                        <td><span><s:property value="publish.width"/>*<s:property value="publish.height"/>px</span><span class="shu">|</span><span><s:property value="publish.size"/></span>M</td>
                                    </tr>
                                </table>
                                    
                                
                            </div>
                        </div>
                       <div class="typeone">
                                <table>
                                    <tr>
                                        <td class="td1 character">作品类别</td>
                                        <td class="td2">
                                        <s:if test="publish.type==1">
                                                                            摄影图片
                                        </s:if>
                                        <s:else>
                                                                                                         创意图片
                                        </s:else>
                                        </td>
                                        <td class="td3 character">所属专辑</td>
                                        <td class="td4">
                                        <s:property value="publish.publishSpecialCat.name"/>
                                        
                                        </td>
                                    </tr>
                                    
                                    <tr>
                                        <td class="td1 character">作品状态</td>
                                        <td class="td2">
                                        <s:if test='publish.publishStatus.justShow==1'>
                                                                                                  发布为仅展示
                                        </s:if>
                                        <s:else>
                                                                                                         发布为可销售
                                        </s:else>
                                        
                                        
                                        </td>
                                        <td class="td3 character">发布时间</td>
                                        <td class="td4">
                                        
                                        <s:date name="publish.publishTime" format="yyyy/MM/dd"/>
                                        </td>
                                    </tr>
                                </table>
                        </div>
                        
                        
                       <div class="property">
                                <table>
                                    <tr>
                                        <td class="td1">版权属性</td>
                                        <td class="tda" colspan="3">
                                            <a>有肖像权许可</a>
                                        </td>
                                    </tr>
                                    
                                    <tr>
                                        <td class="td1">商业用途</td>
                                        <td class="tdp" colspan="3">全用途</td>
                                    </tr>
                                    
                                    <tr>
                                        <td class="td1">授权区域</td>
                                        <td class="td2">中国大陆</td>
                                    </tr>
                                    <tr>
                                        <td class="td1">出售使用权</td>
                                        <td class="td2">￥<span> 
                                        <s:property value="publish.usagePrice"/>
                                        </span></td>
                                        <td class="td3">授权期限</td>
                                        <td class="td4"><span>1</span>年</td>
                                    </tr>
                                    <tr>
                                        <td class="td1">出售版权</td>
                                        <td class="td2">￥<span> <s:property value="publish.copyrightPrice"/></span></td>
                                    </tr>
                                </table>
                        </div>
                    	
                    </div>
                </div>
                
                
                </form>   
            </div>
       <!--右部内容-->
        </div>
        
        <!--摄影故事内容-->
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
<script src="${pageContext.request.contextPath}/public/js/DD_belatedPNG_0.0.8a.js" type="text/javascript"></script>
    <script type="text/javascript">
        DD_belatedPNG.fix('div, ul, img, li, input , a , i');
    </script>
<![endif]-->


</body>
</html>
