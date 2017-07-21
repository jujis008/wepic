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

<title>wepic管理员_作品_摄影故事_审核未通过列表</title>

<script type="text/javascript" src="<%=basePath %>public/js/jquery.js"></script>




<!--公共js-->

<script type="text/javascript" src="<%=basePath %>administrator/publicAdministrator/js/publicAdministrator.js"></script>

<!--公共css-->
<link type="text/css" rel="stylesheet" href="<%=basePath %>administrator/publicAdministrator/css/publicAdministrator.css" />
<link type="text/css" rel="stylesheet" href="<%=basePath %>public/css/public.css" />



<script type="text/javascript" src="<%=basePath %>administrator/production/js/shootStoryNoPassList.js"></script>

<link type="text/css" rel="stylesheet" href="<%=basePath %>administrator/production/css/shootStoryNoPassList.css" />
<script type="text/javascript">
function searchnopass(id){
location.href="story!searchnopass.do?storyId="+id;
}
</script>
</head>

<body>
<div id="container">
	
    
<!-- 头部结束1-->
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
            
            <a href="<%=basePath %>story!checksuclist.do"><div class='bar'><span>作品列表</span><i></i></div></a>
            
            <a href="<%=basePath %>story!checkfaillist.do"><div class='bar active'><span>未通过审核作品</span><i></i></div></a>
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
                    <td class="td1">摄影故事未通过审核列表</td>
                </tr>
            </table>
            
        </div>
        <!--排序-->
    	
        
        
        
        <!--图片内容-->
        <div id="phoStroyContent">
        	<div class="phoStroyContentUl">
            	<ul>
                	<!--专辑封面-->
                	<s:iterator value="pager.resultList" var="list">
                	<li class="stpryOne">
                    	<div class="phoStroyContentLi">
                        	<!--默认显示-->
                            <div class="divDefault">
                                <div class="photographyStoryLiHead">
                                    <img src="<s:property value='#list.cover'/>" />
                                </div>
                                <div class="photographyStoryLiCon">
                                    <div class="photographyStoryLiConTitle">
                                        <span><s:property value="#list.title"/></span>
                                    </div>
                                    <div class="photographyStoryLiConInfo">
                                        <span class="no">描述无敏感词</span>
                                    </div>
                                    <div class="photographyStoryLiConTime">
                                        <font><s:date name="#list.uploadTime" format="yyyy-MM-dd"/></font>
                                    </div>
                                </div>
                                
                                <div class="photographyStoryInfo">
                                    <div class="headImg">
                                      <div class="headImgCon">
                                          <img src="<s:property value='#list.user.portrait'/>" class="head"/>
                                          <img src="<%=basePath %>back/pubimg/images/radHead.png" class="radius"/>
                                      </div>
                                    </div>
                                    <div class="info">
                                        <div class="name"><s:property value='#list.user.nickName'/></div>
                                        <div class="detail">
                                            <!--<a class="userPositionName" title="年龄"><span>56</span>岁</a>-->
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
                        	<!--默认显示-->
                           
                            
                            <!--鼠标滑过显示-->
                            <div class="nowtop">
                        		<div class="bj"></div>
                        		<div class="bjc">
                                	<div class="viewBjCon" title="查看详情" onclick="searchnopass(<s:property value="#list.id"/>)">
                                        <div class="picInf">
                                             <div class="ifone">图片数<span class="picnum"><s:property value="#list.detailpicNum"/></span>张<span class="sp2">正文字数</span><span class="numw"><s:property value="#waitlist.detailtextNum"/></span>字</div>
                                            <div class="iftwo">作品编号：<span class="worknum"><s:property value="#list.remark"/></span></div>
                                        </div>
                                        
                                        <div class="divTime">
                                            <a class="time" title="上传时间"><span><s:date name="#list.uploadTime" format="yyyy-MM-dd"/></span></a>
                                            <a class="time2" title="发布时间"><span><s:date name="#list.publishTime" format="yyyy-MM-dd"/></span></a>
                                        </div>
                                        
                                        <div class="divNoPassRea">
                                            <div>未通过原因：</div>
                                            <s:if test="#list.nopasscause.contains(\"0\")">
                                            <s:generator separator="." val="#list.nopassration">
                                            <s:iterator status="statu">
                                            <s:if test="#statu.count == 1">
                                            <div class="rea">①<s:property/></div>
                                            </s:if>
                                            <s:if test="#statu.count == 2">
                                            <div class="rea">②<s:property/></div>
                                            </s:if>
                                            <s:if test="#statu.count == 3">
                                            <div class="rea">③<s:property/></div>
                                            </s:if>
											</s:iterator>  
											<div class="rea">④<s:property value="#list.writereason"/> </div>
                                </s:generator>
                                            </s:if>
                                            <s:else>
                                            <s:generator separator="." val="#list.nopassration">
                                            <s:iterator status="statu">
                                            <s:if test="#statu.count == 1">
                                            <div class="rea">①<s:property/></div>
                                            </s:if>
                                            <s:if test="#statu.count == 2">
                                            <div class="rea">②<s:property/></div>
                                            </s:if>
                                            <s:if test="#statu.count == 3">
                                            <div class="rea">③<s:property/></div>
                                            </s:if>
											</s:iterator>   
                                </s:generator>
                                            </s:else>
                                        </div>
                                    </div>
                                    
                                    <div class="divDel">
                                    	 <a href="story!admindelstoryofnopass.do?storyId=<s:property value="#list.id"/>" class="directDel">直接删除</a>
                                    </div>   
                                </div>
                        	</div>
                            <!--鼠标滑过显示11-->
                        </div>
                	</li>
                	
                	
                    <!--专辑封面-->
                    
                    
                    <!--专辑内容-->
                    <s:iterator value="#list.storyDetailSet" var="storyDetail">
                	<li class="stpryOne">
                    	<div class="phoStroyContentLi">
                        	<!--默认显示-->
                            <div class="divDefault">
                                <div class="photographyStoryPic">
                                    <img src="<s:property value='#storyDetail.thumbnailUrl'/>" />
                                </div>
                                
                                
                                <s:if test="#storyDetail.specialwords == null || #storyDetail.specialwords == ''">
                                	<div class="photographyStoryKeyWorkNo">
                                	没有敏感词
                                    </div>
                                	</s:if>
                                	
                                	
                                	<s:else>
                                	<div class="photographyStoryKeyWork"><dl>
                                	<s:generator separator="," val="#storyDetail.specialwords">  
									<s:iterator>  
									<dd><s:property/></dd>
									</s:iterator>  
									</s:generator>
									</dl></div>
									</s:else>
                            </div>
                        	<!--默认显示-->
                           
                            
                            <!--鼠标滑过显示-->
                            <div class="nowtop">
                        		<div class="bj"></div>
                        		<div class="bjc">
                                	<div class="viewBjCon" title="查看详情" onclick="searchnopass(<s:property value="#list.id"/>)">
                                        <div class="picInf">
                                            <div class="ifone">图片数<span class="picnum"><s:property value="#list.detailpicNum"/></span>张<span class="sp2">正文字数</span><span class="numw"><s:property value="#list.detailtextNum"/></span>字</div>
                                            <div class="iftwo">作品编号：<span class="worknum"><s:property value="#list.remark"/></span></div>
                                        </div>
                                        
                                        <div class="divTime">
                                            <a class="time" title="上传时间"><span><s:date name="#list.uploadTime" format="yyyy-MM-dd"/></span></a>
                                            <a class="time2" title="发布时间"><span><s:date name="#list.publishTime" format="yyyy-MM-dd"/></span></a>
                                        </div>
                                        
                                        <div class="divNoPassRea">
                                            <div>未通过原因：</div>
                                            <s:if test="#list.nopasscause.contains(\"0\")">
                                            <s:generator separator="." val="#list.nopassration">
                                            <s:iterator status="statu">
                                            <s:if test="#statu.count == 1">
                                            <div class="rea">①<s:property/></div>
                                            </s:if>
                                            <s:if test="#statu.count == 2">
                                            <div class="rea">②<s:property/></div>
                                            </s:if>
                                            <s:if test="#statu.count == 3">
                                            <div class="rea">③<s:property/></div>
                                            </s:if>
											</s:iterator>  
											<div class="rea">④<s:property value="#list.writereason"/> </div>
                                </s:generator>
                                            </s:if>
                                            <s:else>
                                            <s:generator separator="." val="#list.nopassration">
                                            <s:iterator status="statu">
                                            <s:if test="#statu.count == 1">
                                            <div class="rea">①<s:property/></div>
                                            </s:if>
                                            <s:if test="#statu.count == 2">
                                            <div class="rea">②<s:property/></div>
                                            </s:if>
                                            <s:if test="#statu.count == 3">
                                            <div class="rea">③<s:property/></div>
                                            </s:if>
											</s:iterator>   
                                </s:generator>
                                            </s:else>
                                        </div>
                                    </div>
                                    
                                    <div class="divDel">
                                    	 <a href="story!admindelstoryofnopass.do?storyId=<s:property value="#list.id"/>" class="directDel">直接删除</a>
                                    </div>   
                                </div>
                        	</div>
                            <!--鼠标滑过显示-->
                        </div>
                	</li>
                	</s:iterator>
                    </s:iterator>
                    <div style="clear:both;"></div>
                </ul>
            </div>
        
         
               
        
        
        </div>
        
        
        
        
        <!--图片内容-->
    </div>
    <!--翻页-->
                <s:if test="pager.rowCount >= 5">
     <!--翻页-->
     <div class="ppointPagingthis">
        <div class="ppointPaging">            
            <table class="tablePpointPaging">
                	<tr>
                    	
                    	<s:bean name="org.apache.struts2.util.Counter" id="counter">  
                    	<td class="ppointPagingOne"><a href="story!checkfaillist.do?pageNo=1"></a></td>
                    	<s:if test="pager.pageCount ==1">
                        <td class="ppointPagingPre"><a href="story!checkfaillist.do?pageNo=1"></a></td>
                        </s:if>
                        <s:else>
                        <td class="ppointPagingPre"><a href="story!checkfaillist.do?pageNo=<s:property value='pager.prePageNo'/>"></a></td>
                        </s:else>
         <s:param name="first" value="1"/>  
          <s:param name="last" value="pager.pageCount"/>  
          <s:iterator>  
          <s:if test="pager.pageNo==current-1">
          <td class="ppointPagingN"><a href="story!checkfaillist.do?pageNo=<s:property />"><s:property /></a></td>
          </s:if>
          <s:else>
            <td class="ppointPagingN"><a href="story!checkfaillist.do?pageNo=<s:property />"><s:property /></a></td>
          </s:else>
           </s:iterator> 
           <s:if test="pager.pageCount ==1"> 
           <td class="ppointPagingNext"><a href="story!checkfaillist.do?pageNo=1"></a></td>
           </s:if>
           <s:else >
           <td class="ppointPagingNext"><a href="story!checkfaillist.do?pageNo=<s:property value='pager.nextPageNo'/>"></a></td>
           </s:else>
           <td class="ppointPagingLast"><a href="story!checkfaillist.do?pageNo=<s:property value='pager.pageCount'/>"></a></td>
            </s:bean>  
                    	
                    </tr>
                </table>
        </div>
        		</div>
        		</s:if>
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
<script src="../../public/js/DD_belatedPNG_0.0.8a.js" type="text/javascript"></script>
    <script type="text/javascript">
        DD_belatedPNG.fix('div, ul, img, li, input , a , i');
    </script>
<![endif]-->


</body>
</html>

