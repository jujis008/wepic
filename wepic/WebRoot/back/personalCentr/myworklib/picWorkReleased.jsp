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

<title>wepic管理_个人中心_我的作品库_图片作品_已发布详情</title>


<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/imgsf.js"></script>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/back/personalCentr/myworklib/css/picWorkReleased.css" />

<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/jquery.js"></script>





<!--公共js-->
<script type="text/javascript" src="${pageContext.request.contextPath}/back/js/publicBack.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/back/js/jquery.jqia.dateFormat.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/public.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/topBar.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/header.js"></script>

<!--公共css-->
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/back/pubimg/css/backMainBar.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public/css/topBarMain.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public/css/header.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public/css/footer.css" />

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/pubimg/css/index.css" />

<script type="text/javascript" src="${pageContext.request.contextPath}/back/personalCentr/myworklib/js/picWorkReleased.js"></script>


</head>

<body>
<div id="container">
	<div id="topBar">
	<div id="topbar">
    	<div id="topcenterbar">
    		<div id="topbar-collect">
    			<a id="topcollect" href="javascript:addToFavorite('http://www.wepic.cn/','唯图网_商业拍摄 原创商业图片交易平台')">
                	<span>收藏唯图</span>			
        		</a>
       		</div>
        	<div id="topbar-toolbar">
    			
                <div id="divTopBarUesr">
                	<div id="topBarUser">
                    	<a href="javascript:"><span>你是WHO</span><i></i></a>
                    </div>
                    
                	<div id="topBarUserDetailed">
                    	<div id="topBarUserOne">
                        	<div id="topBarUserOneHead">
                            	<img src="${pageContext.request.contextPath}/public/images/pic/topUser.jpg" />
                                <div id="topBarUserOneHeadChange">
                                	<div><a href="javascript:">更改头像</a></div>
                                </div>
                            </div>
                            <div id="topBarUserOneDetailed">
                            	<div id="topBarUserOneDetailedOne">
                                	<img id="topBarUserOneDetailedimg" src="${pageContext.request.contextPath}/public/images/grade/uesrLogo.png"/>
                                    <img src="${pageContext.request.contextPath}/public/images/grade/diamond.png"/>
                                    <img src="${pageContext.request.contextPath}/public/images/grade/diamond.png"/>
                                    <img src="${pageContext.request.contextPath}/public/images/grade/star.png"/>
                                    <img src="${pageContext.request.contextPath}/public/images/grade/star.png"/>
                                    <img src="${pageContext.request.contextPath}/public/images/grade/star.png"/>
                                    <a href="javascript:" id="topBarUserOneComeZom">进入空间</a>
                                    <a href="javascript:" id="topBarUserOneExit">退出登录</a>
                                </div>
                                <div id="topBarUserOneDetailedTwo">
                                	<div id="topBarUserInfo">
                                    	<span>男</span>&nbsp;&nbsp;|<span>中国</span><span>上海</span><span>嘉定</span>
                                    </div>
                                    <div id="topBarUserAccount">
                                    	<span>余额：</span>&nbsp;&nbsp;
                                        <span is="topBarUserAccountYE">888888888</span>
                                        <a href="javascript:" id="topBarUserAccountcz">充值</a>
                                        <a href="javascript:" id="topBarUserAccounttx">提现</a>
                                    </div>
                                    <div id="topBarUserPart">
                                    	<span>用户</span>&nbsp;|
                                        <span>摄影师</span>&nbsp;|
                                        <span>模特</span>&nbsp;|
                                        <span>经纪人</span>
                                    </div>
                                </div>
                            </div>
                            
                            <div id="topBarUserTwo">
                            	<div class="topBarUserTwo" id="topBarUserFollowed">
                                	<p class="topBarUserTwoPOne">4546544</p>
                                    <p class="topBarUserTwoPTwo">已关注</p>
                                </div>
                                <div class="topBarUserTwo" id="topBarUserFollower">
                                	<p class="topBarUserTwoPOne">87987987</p>
                                    <p class="topBarUserTwoPTwo">粉丝</p>
                                </div>
                                <div class="topBarUserTwo" id="topBarUserGoodDiscuss">
                                	<p class="topBarUserTwoPOne">666666</p>
                                    <p class="topBarUserTwoPTwo">好评</p>
                                </div>
                                <div class="topBarUserTwo" id="topBarUserBadDiscuss">
                                	<p class="topBarUserTwoPOne">7777777</p>
                                    <p class="topBarUserTwoPTwo">差评</p>
                                </div>
                                
                                
                            </div>
                            
                            <div id="topBarUserThree">
                                	<div id="topBarUserThreeInOutCome">
                                    	<p><span class="topBarUserThreeInOutComeAtt">收入排名</span><span class="topBarUserThreeInOutComeNum">454545</span></p>
                                        <p><span class="topBarUserThreeInOutComeAtt">支出排名</span><span class="topBarUserThreeInOutComeNum">4545</span></p>
                                    </div>
                                    <div id="topBarUserThreePersonalManagement">
                                    	<input type="button" value="个人管理中心" />
                                    </div>
                                </div>
                        </div>
                    </div>
                </div>
            	<div id="divTopBarShopping">    
                    	<div id="topBarShopping">
                    		<a href="#" id="topshopping">购物车<span>888</span>件<i></i></a>
                    	</div>
                        
                        <div id="topBarShoppingDetailed">
                        	<ul>
                            <li>
                            	<div class="topBarShoppingDetailedHead">
                            		<img src="${pageContext.request.contextPath}/public/images/pic/topUser.jpg"/>
                           		</div>
                            
                            	<div class="topBarShoppingDetailedOpert">
                                	<p class="topBarShoppingDetailedOpertPOne">
                                    	<span>作品标题锦屏1</span>
                                        <b class="topBarShoppingDetailedOpertPOneExit" onclick="topBarShoppingDetailedOpertPOneExit(this)">×</b>
                                    </p>
                                    <p class="topBarShoppingDetailedOpertPTwo">编号：
                                    	<span>4445454464564</span>
                                        <span class="topBarShoppingDetailedOpertPTwoPice">21221</span>
                                    </p>
                                </div>
                            </li>
                            
                            <li>
                            	<div class="topBarShoppingDetailedHead">
                            		<img src="${pageContext.request.contextPath}/public/images/pic/topUser.jpg"/>
                           		</div>
                            
                            	<div class="topBarShoppingDetailedOpert">
                                	<p class="topBarShoppingDetailedOpertPOne">
                                    	<span>作品标题锦屏2</span>
                                        <b class="topBarShoppingDetailedOpertPOneExit" onclick="topBarShoppingDetailedOpertPOneExit(this)">×</b>
                                    </p>
                                    <p class="topBarShoppingDetailedOpertPTwo">编号：
                                    	<span>4445454464564</span>
                                        <span class="topBarShoppingDetailedOpertPTwoPice">21221</span>
                                    </p>
                                </div>
                            </li>
                            <li>
                            	<div class="topBarShoppingDetailedHead">
                            		<img src="${pageContext.request.contextPath}/public/images/pic/topUser.jpg"/>
                           		</div>
                            
                            	<div class="topBarShoppingDetailedOpert">
                                	<p class="topBarShoppingDetailedOpertPOne">
                                    	<span>作品标题锦屏3</span>
                                        <b class="topBarShoppingDetailedOpertPOneExit" onclick="topBarShoppingDetailedOpertPOneExit(this)">×</b>
                                    </p>
                                    <p class="topBarShoppingDetailedOpertPTwo">编号：
                                    	<span>4445454464564</span>
                                        <span class="topBarShoppingDetailedOpertPTwoPice">21221</span>
                                    </p>
                                </div>
                            </li>
                            <!--<li><img src="images/pic1/topUser.jpg"/></li>
                            <li><img src="images/pic1/topUser.jpg"/></li>-->
                            </ul>
                            
                            <div id="topBarShoppingDetailedFoot">
                            	<input type="button" value="查看购物车">
                            </div>
                        </div>     
                </div>
                
                <div id="divTopBarContainer"> 
                	<ul>
                    	<li>
                        	<div id="divTopBarWorks">
                            	<div id="topBarWorks" class="topBarContainer">
                                	<a href="javascript:"><span>我的作品</span></a>
                                </div>
                            	
                                <div id="divTopBarWorksDetailed" class="topBarDetailed">
                                	<p><a href="javascript:">我的作品库</a></p>
                                    <p><a href="javascript:">我买到的作品</a></p>
                                    <p><a href="javascript:">我出售的作品</a></p>                                   
                                </div>
                            </div> 
                        </li>
                        
                        
                        <li>
                        	<div id="divTopBarPats">
                            	<div id="topBarPats" class="topBarContainer">
                                	<a href="javascript:"><span>我的约拍</span></a>
                                </div>
                            	
                                <div id="divTopBarPatsDetailed" class="topBarDetailed">
                                	<p><a href="javascript:">新约拍项目</a></p>
                                    <p><a href="javascript:">我发布的约拍</a></p>
                                    <p><a href="javascript:">应约中的约拍</a></p>  
                                    <p><a href="javascript:">约拍日程</a></p>
                                    <p><a href="javascript:">约拍记录</a></p>                                 
                                </div>
                            </div> 
                        </li>
                        
                        <li>
                        	<div id="divTopBarInform">
                            	<div id="topBarInform" class="topBarContainer">
                                	<a href="javascript:"><span>消息中心</span>
                                    	<i></i>
                                    </a>
                                </div>
                            	
                                <div id="divTopBarInformDetailed" class="topBarDetailed">
                                	<p><a href="javascript:">查看粉丝</a></p>
                                    <p><a href="javascript:">查看评价</a></p>
                                    <p><a href="javascript:">交易提醒</a></p>  
                                    <p><a href="javascript:">日程提醒</a></p>
                                    <p><a href="javascript:">被邀提醒</a></p> 
                                    <p><a href="javascript:">有新应约者</a></p>  
                                    <p><a href="javascript:">经纪人申请</a></p>
                                    <p><a href="javascript:">系统通知</a></p>                                
                                </div>
                            </div> 
                        </li>
                        
                        
                        <li>
                        	<div id="divTopBarUpload">
                            	<div id="topBarUpload" class="topBarContainer">
                                	<a href="javascript:"><span>上传作品</span></a>
                                </div>
                            	
                                <div id="divTopBarUploadDetailed" class="topBarDetailed">
                                	<p><a href="javascript:">上传到作品库</a></p>
                                    <p><a href="javascript:">发布图片</a></p>
                                    <p><a href="javascript:">发布摄影故事</a></p>  
                                    <p><a href="javascript:">发布视频</a></p>                                
                                </div>
                            </div> 
                        </li>
                        
                        
                        <li>
                        	<div id="divTopBarPublish">
                            	<div id="topBarPublish" class="topBarContainer">
                                	<a href="javascript:"><span>发布约拍</span></a>
                                </div>
                            	
                                <div id="divTopBarPublishDetailed" class="topBarDetailed">
                                	<p><a href="javascript:">发布约拍的项目</a></p>
                                    <p><a href="javascript:">招募摄影师</a></p>
                                    <p><a href="javascript:">招募模特</a></p>  
                                    <p><a href="javascript:">发布征集作品项目</a></p>                                
                                </div>
                            </div> 
                        </li>
                    </ul>
                </div>
            	<!--<a href="#" id="topworks">我的作品</a>
            	<a href="#" id="toppats">我的约拍</a>
           	 	<a href="#" id="topinform">消息中心</a>
            	<a href="#" id="topupload">上传作品</a>
            	<a href="#" id="toppublish">发布约拍</a>-->
        	</div>
        </div>
    </div> 
	</div>
    
<!-- 头部结束-->
	
    <!-- logo行-->
	<div id="header">
    	<div id="headerCenter">
        	<div id="divlogo">
    			<a id="imgLogo" href="http://www.wepic.cn/" target="_self" title="唯图网_商业拍摄 原创商业图片交易平台">
    				<img src="${pageContext.request.contextPath}/public/images/wepic_logo.png" alt="唯图网"/>
        			<p><span id="spanLogo">商业拍摄</span><span>原创商业图片交易平台</p>
   				</a>
    		</div>
            <div id="divKeyWord">
                    	<input id="inputkeyword" type="text" value="搜索" 
                    		onfocus="searchonfocus();" onblur="searchonblur()"/>
            </div>
                   
            <div id="divSelect">
                    <input  type="text" value="选择类型"  onclick="hide('selectValue')" 
                    		id="inputselect" class="inputselect" readonly="value"/>
                           
                    <div id="selectValue" style="display:none;" class="selectValue" onmouseout="hidemouseout('selectValue')" onmouseover="hidemouseover('selectValue')">
  						<span id="a1" onclick="pick('测试一','inputselect','selectValue')" onmouseover="bgcolor('a1')" 
                        	onMouseOut="nocolor('a1')" class="cur">测试一</span> 
  						<span id="a2" onclick="pick('测试二','inputselect','selectValue')" onMouseOver="bgcolor('a2')" 
                        	onMouseOut="nocolor('a2')" class="cur">测试二</span> 
  						<span id="a3" onclick="pick('测试三','inputselect','selectValue')" onMouseOver="bgcolor('a3')" 
                        	onMouseOut="nocolor('a3')" class="cur">测试三</span> 
  						<span id="a4" onclick="pick('测试四','inputselect','selectValue')" onMouseOver="bgcolor('a4')" 
                       		onMouseOut="nocolor('a4')" class="cur">测试四</span> 
 						<span id="a5" onclick="pick('测试五','inputselect','selectValue')" onMouseOver="bgcolor('a5')" 
                        	onMouseOut="nocolor('a5')" class="cur">测试五</span> 
 	    				<span id="a6" onclick="pick('测试六','inputselect','selectValue')" onMouseOver="bgcolor('a6')" 
                        	onMouseOut="nocolor('a6')" class="cur">测试六</span>            
 					</div>
                    
            </div>
            
            <div id="divButtonSecrch">
            	<div id="buttonsearch"></div>
            </div>
            
            <div id="divSeniorSecrch">
            	<input type="button" value="高级搜索" id="higtsearch"/>
            </div>
       </div>
	</div>
    
    <!-- 分割线 	样式在	registerLogin.css-->
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
    
    <!-- logo行-->
    
    <div id="mainbar">
    	<div id="mainbarCenter">
    		<ul>
        		<li id="personalCenter" class="active">
            		<a href="<%=basePath %>user!getFistPageUserInfo.do">个人中心</a>
            	</li>
            	<li id="configureCenter">
            		<a href="<%=basePath %>configure!securityIndex.do">配置中心</a>
            	</li>
            	<li id="inforCenter">
            		<a href="javascript:void(0)">消息中心</a>
           	 	</li>
            	<li id="myRoom">
            		<a href="javascript:void(0)">我的空间</a>
            	</li>
        	</ul>
        </div>
	</div>
    
	<!-- logo行 end-->
	
     <!-- 导航 -->
  	<div id="assistantBar">
    <div class="twoStage" id="divTwoStage">
        	<a href="<%=basePath %>user!getFistPageUserInfo.do"><div class='bar'><span>首页</span><i></i></div></a>
            
            <a href="<%=basePath %>user!baseUseInfo.do?message=all"><div class='bar'><span>账户基本资料</span><i></i></div></a>
            
            <a href="<%=basePath %>publish!findAllMyLib.do"><div class='bar active'><span>我的作品库</span><i></i></div></a>
            
            <a href="<%= basePath%>catBid!findByrootType.do"><div class='bar'><span>我的约拍</span><i></i></div></a>
            
            <a href="javascript:"><div class='bar'><span>我买到的作品</span><i></i></div></a>
            
           <a href="javascript:"> <div class='bar'><span>收藏/订阅/推荐</span><i></i></div></a>
        </div>
    	
        <div id="divThreeStage">
        
         <div class="threeStage">
        	<a href="javascript:"><div class='bar'><span>作品库概况</span><i></i></div></a>
            
            <a href="<%=basePath %>publish!findAllMyLib.do"><div class='bar active'><span>图片作品</span><i></i></div></a>
            
            <a href="<%=basePath %>story!storylist.do"><div class='bar'><span>摄影故事</span><i></i></div></a>
            
            <a href="javascript:"><div class='bar'><span>视频作品</span><i></i></div></a>
            
            <a href="${pageContext.request.contextPath}/back/personalCentr/myworklib/workUpload.jsp"><div class='bar'><span>上传作品</span><i></i></div></a>
            
            <a href="<%=basePath %>story!initdata.do"><div class='bar'><span>创建故事</span><i></i></div></a>
            
            <a href="${pageContext.request.contextPath}/back/personalCentr/myworklib/chooseRelWork.jsp"><div class='bar'><span>发布作品</span><i></i></div></a>
        </div>
        </div>
    </div>
    <!-- 导航  end-->
    
    <!--内容-->
    <div id="divPhoStroyHead">
   		<div class="head">
              <table>
            	<tr>
                	<td class="td1">
                    	<div class="divdropDown">
                    		<div class="dropDownBox" id="dropDownBoxPartType" onclick="showBelow('divdropDownPartType')">
                    			<span id="divdropDownViewPartType"></span>
                        		<div class="dropDownBoxR"><i></i></div>
                    		</div>
                    
                    		<div class="dropDownBoxValue" id="divdropDownPartType">
                    			
                 			 </div>
                  		</div>
                    </td>
                	
                    <td class="td2"><a href="manageSpecial.html" class="glz">管理专辑</a></td>
                    <td class="td3">
                    	<span class="sp1">当前专辑作品数</span>
                    	<span class="num" id="totalPic">0</span>张
                    
                    	<span class="sp2">已发布</span>
                    	<span class="num" id="fabutotalPic">0</span>张
                    	
                    	<span class="sp2">显示顺序：</span>
                    	<span class="sp3">上传时间</span>
                    </td>
                </tr>
            
            </table>
            <div class="inp">
               	<input class="inputup" type="button" value="返回上一页"/>
            </div>
            
        </div>
            
    </div>
    
    <div id="previewPic">
    	<div class="scroll">
        	<a id="left_img_btn" class="s_pre" href="javascript:void(0)"></a>
      		<div class="current" id="current"></div>
      		<div class="outScroll_pic">
        		<ul class="scroll_pic cls" id="small_pic"></ul>
      		</div>
            <a id="right_img_btn" class="s_next" href="javascript:void(0)"></a> 
        </div>
    </div>   
        
        
        
        
        <!--摄影故事内容-->
        <div id="phoStroyDetail">
        
        
        	<div class="phoStroyDetailLeft"  id="phoStroyDetailLeft">
        		<div class="divPicimg">
       				
       				<ul class="imagebg" id="imagebg">
       					
       					
       			<li class="bannerbg" data-sPic="<s:property value="publish.thumbnail125"/>" id="<s:property value="publish.id"/>">
    					
      						<div class="bannerbg_main">
      							<img src="<s:property value="publish.smallPic"/>"  onload="javascript:DrawImage(this,800,800)" />
						    </div>
    					</li>
    					
    					
       				<s:iterator value="pager.resultList" var="publish">
       				
    					<li class="bannerbg" data-sPic="<s:property value="#publish.thumbnail125"/>" id="<s:property value="#publish.id"/>">
    					
      						<div class="bannerbg_main">
      							<img src="<s:property value="#publish.smallPic"/>"  onload="javascript:DrawImage(this,800,800)" />
						    </div>
    					</li>
    					</s:iterator>
    					
  					</ul>
        			
        		</div>
      
           <div class="edit" id="editzpgs">
                    	<div class="bj"></div>
                    	<div class="bjc">
                        	<div class="left">
                            	<div class="one">
                            		<a class="view" title="浏览次数"><span>64456</span></a>
                                	<a class="collect" title="收藏次数"><span>64456</span></a>
                            	</div>
                                <div class="two">
                            		<a class="good" title="推荐次数"><span>64456</span></a>
                            	</div>
                                <div class="three">
                            		<span class="sp1">￥</span>使用权已出售<span class="sp2">13</span>次
                            	</div>
                            </div>
                            <div class="right">
                            	<a href="publish!downloadPic.do?id=<s:property value="publish.id"/>" class="dowload" id="dowloadPic">
                            		<div class="backimg"></div>
									<p>下载原图</p>
                            	</a>
                            	<a href="javascript:" class="delete">
                            		<div class="backimg"></div>
									<p>显示到空间首页</p>
                           		</a>
                            </div>
                        	
                        </div>
                 </div>
                
                
            </div>
        
        <!--右部内容-->
         	<div class="phoStroyDetailRight">
        		               
                <div class="storyCon">
                	<div class="top" title="<s:property value="publish.name"/>" id="publishName"><s:property value="publish.name"/></div>
                	<div class="head">
                        <div class="storyInfo" id="table1">
                        	<table>
                            	<tr>
                                	<td><span>作品编号：</span></td>
                                    <td class="td2"><span><s:property value="publish.picNumber"/></span></td>
                                    <td><span>上传时间：</span></td>
                                    <td><span><s:property value="publish.upTime"/></span></td>
                                </tr>
                            	
                               <tr>
                                	<td><span>原始尺寸：</span></td>
                                	
                                    <td><s:if test="#publish.logo==0"><span>
                                    
                                    <s:property value="publish.width"/>
                                    </span>*<span><s:property value="publish.height"/></span>px<span class="s">|</s:if></span><span><s:property value="publish.size"/></span>M</td>
                                </tr>
                            </table>
                        		
                        	
                        </div>
                    </div>
                    <div class="typeone" id="picInfo">
                    		<table>
                            	<tr>
                                	<td class="td1">作品类别</td>
                                    <td class="td2">
                                    <s:if test="publish.type==null||publish.type==''">
                                                                                                  暂无
                                    </s:if>
                                 
                                   
                                   
                                    
                                    </td>
                                	<td class="td3">所属专辑</td>
                                    <td class="td4">  <s:property value="publish.publishSpecialCat.name"/> </td>
                                    <td class="td5"><a href="javascript:" onclick="openSpecial();">移动到</a></td>
                                </tr>
                            	
                                <tr>
                                	<td class="td1">作品状态</td>
                                    <td class="td2 tdDeal">
                                    
                                                                    <s:if test="publish.publishStatus.pass!=1&&publish.publishStatus.unreleased==1">
                                                                      <s:if test="publish.publishStatus.noPass==0&&publish.publishStatus.adminSoldout!=1">
                                                                      <span class="orange">审核中</span>
                                                                      </s:if>  
                                                                      <s:if test="publish.publishStatus.noPass==1">
                                                                      
                                                                      <div style="display: none" class="stateRemind" id="stateRemind"><div class="con">
                                                                      <div class="char">未通过的原因：</div>
                                                                         <s:iterator value="publish.resons" id="reson">
                                                                      <div class="rea"><s:property value="reson"/></div>
                                          
                                                                             </s:iterator>
                                                                      <div class="rea"></div></div><div class="time">2013-02-12</div>
                                                                      <div class="sanjiao"></div> 
                                                                      </div>
                                                                       
                                                                      
                                                                      <span class="red" onclick="getReson()">审核未通过</span>
                                                                       </s:if>  
                                                                      </s:if> 
                                                                      
                                                                      <s:elseif test="publish.publishStatus.adminSoldout==1">
                                                                        <div style="display: none" class="stateRemind" id="stateRemind"><div class="con">
                                                                      <div class="char">被管理员下架原因：</div>
                                                                         <s:iterator value="publish.resons" id="reson">
                                                                      <div class="rea"><s:property value="reson"/></div>
                                          
                                                                             </s:iterator>
                                                                      <div class="rea"></div></div><div class="time">2013-02-12</div>
                                                                      <div class="sanjiao"></div> 
                                                                      </div>
                                                                      
                                                                      <span class="red" onclick="getReson()">被管理员下架</span>
                                                                      </s:elseif>
                                                                      <s:elseif test="publish.publishStatus.copyrightBuyout==1">
                                                                      <span class="orange">被下架</span>
                                                                      </s:elseif>
                                                                       <s:elseif test="publish.publishStatus.userSoldout==1">
                                                                      <span class="grey">已下架</span> 
                                                                      </s:elseif>     
                                                                      <s:elseif test="publish.publishStatus.onOffer==1&&publish.publishStatus.pass==1">
                                                                      <span class="grey">已发布为可出售</span> 
                                                                      </s:elseif>
                                                                       <s:elseif test="publish.publishStatus.justShow==1&&publish.publishStatus.pass==1">
                                                                      <span class="grey">已发布为仅展示</span> 
                                                                      </s:elseif>
                                                                      <s:else>
                                                                                                                                                                                                     未发布
                                                                      </s:else>       
                                  
                                    </td>
                                    <td class="td3">发布时间</td>
                                    <td class="td4">
                                   
                                    <s:date name="publish.publishTime" format="yyyy-MM-dd"/>
                                    </td>
                                </tr>
                                
                                <tr>
                                	<td class="td1">作品说明</td>
                                </tr>
                                <tr>
                                	<td class="tds" colspan="5">
                                		<s:if test="publish.content!=null&&publish.content!=''">
                                	<s:property value="publish.content"/>
                                	</s:if><s:else>
                                	暂无
                                	
                                	</s:else>
                                	
                                	
                                	
                                	
                                	</td>
                                </tr>
                            </table>
                    </div>
                    
                    
                    <div class="gjctd"> 
                    	<div class="chaa">作品类型</div>
                        <div class="type" id="zuopinType">
                        <s:iterator value="publish.publishCats" var="cat">                                  
                        	<div class="retag">
								<span> <s:property value="#cat.name"/></span>
									<a></a>
								
							</div>
                            </s:iterator>
                          
                        </div>
                        <div style="clear:both;"></div>
                        
                    	<div class="chaa">关键词</div>
                        <div class="keyword"  id="zuopinKey">
                         <s:iterator value="publish.roleTags" var="roltag">
                                   
                                  
                                   <a href="javascript:"> <s:property value="#roltag.tag"/></a>
                                   
                                   </s:iterator> 
                        	
                        	
                       	</div>
                    </div>
                    
                    <!-- xxxxxxxxxxx -->
                    
                   
                    
                     <div class="property" id="propertysa" style=" <s:if test="publish.publishStatus.onOffer!=1">display: none</s:if>">
                    		<table>
                            	<tr>
                                	<td class="td1">版权属性</td>
                                    <td class="tda" colspan="3" id="banquan">
                                     <s:if test="publish.portraitprotocol!=null&&publish.portraitprotocol.trim()!=''||publish.productsprotocol!=null&&publish.productsprotocol.trim()!=''">
                                    <s:if test="publish.portraitprotocol!=null&&publish.portraitprotocol.trim()!=''">
                                    	<a>有肖像权许可</a>
                                    	</s:if>
                                    	  <s:if test="publish.productsprotocol!=null&&publish.productsprotocol.trim()!=''">
                                    	<a>有物权许可</a>
                                    	</s:if>
                                    	</s:if>
                                    	<s:else>
                                    	暂无
                                    	</s:else>
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
                                    <td class="td2">￥<span id="usagePrice"><s:property value="publish.usagePrice"/></span></td>
                                	<td class="td3">授权期限</td>
                                    <td class="td4"><span>1</span>年</td>
                                </tr>
                                <tr>
                                	<td class="td1">出售版权</td>
                                    <td class="td2">￥<span id="copyrightPrice"><s:property value="publish.copyrightPrice"/></span></td>
                                </tr>
                            </table>
                    </div>
                    
                    <div class="edt">
    <s:if test="publish.publishStatus.pass!=1&&publish.publishStatus.unreleased==1">
                                                                      <s:if test="publish.publishStatus.noPass==0&&publish.publishStatus.adminSoldout!=1">
                                                                       <input class="inputyq"   id="publishEditePage" type="button" value="编辑属性" onclick="location.href='publish!findEditeUnPublish.do?id=<s:property value="publish.id"/>';"/>
                                                                      </s:if>  
                                                                      <s:if test="publish.publishStatus.noPass==1">
                                                                      
                                                                  
                                                                       </s:if>  
                                                                      </s:if> 
                                                                      
                                                                      <s:elseif test="publish.publishStatus.adminSoldout==1">
                                                                      
                                                                      </s:elseif>
                                                                      <s:elseif test="publish.publishStatus.copyrightBuyout==1">
                                                                  
                                                                      </s:elseif>
                                                                       <s:elseif test="publish.publishStatus.userSoldout==1">
                                                                      
                                                                      </s:elseif>     
                                                                      <s:elseif test="publish.publishStatus.onOffer==1&&publish.publishStatus.pass==1">
                                                                     <input class="inputyq"   id="publishEditePage" type="button" value="编辑属性" onclick="location.href='publish!findEditeUnPublish.do?id=<s:property value="publish.id"/>';"/>
				                                                      <input class="inputyq" type="button" value="下架" id="userXiajia" />
                                                                      </s:elseif>
                                                                       <s:elseif test="publish.publishStatus.justShow==1&&publish.publishStatus.pass==1">
                                                                       <input class="inputyq"   id="publishEditePage" type="button" value="编辑属性" onclick="location.href='publish!findEditeUnPublish.do?id=<s:property value="publish.id"/>';"/>
				                                                       <input class="inputyq" type="button" value="下架" id="userXiajia" />
						
                                                                      </s:elseif>
                                                                      <s:else>
                                                                                                                                                                                                     <input class="inputyq"   id="publishEditePage" type="button" value="编辑属性" onclick="location.href='publish!findEditeUnPublish.do?id=<s:property value="publish.id"/>';"/>
                                                                      </s:else>       
                    
                    
                    
                    
                    
                    
                    <!-- 
                       <s:if test="publish.publishStatus.unreleased==1">
                    
						</s:if>
						<s:else>
                           <input class="inputyq"   id="publishEditePage" type="button" value="编辑属性" onclick="location.href='publish!findEditeUnPublish.do?id=<s:property value="publish.id"/>';"/>
				            <input class="inputyq" type="button" value="下架" id="userXiajia" />
						
						</s:else>
						 -->
                    </div>
                </div>
            </div>
       <!--右部内容-->
        
        
        </div>
        
        
        
        
        <!--摄影故事内容-->
    
    <!--内容-->
    
    <!--foot 开始-->
    <div id="footer">
    <div id="footCenter">
    	<div id="footServer">
        	<div id="aboutOur" class="footServerCon">
            	<div class="serverConStr"><a href="javascript:">关于我们</a></div>
                <p><a href="javascript:">服务内容</a></p>
                <p><a href="javascript:">身份注册</a></p>
                <p><a href="javascript:">积分等级</a></p>
                <p><a href="javascript:">交易流程</a></p>
            </div>
            <div id="rechargeDefray" class="footServerCon">
            	<div class="serverConStr"><a href="javascript:">充值支付</a></div>
                <p><a href="javascript:">账户管理</a></p>
                <p><a href="javascript:">充值方式</a></p>
                <p><a href="javascript:">交易记录</a></p>
                <p><a href="javascript:">充值</a></p>
                <p><a href="javascript:">提现</a></p>
            </div>
            <div id="personnelRecruitment" class="footServerCon">
            	<div class="serverConStr"><a href="javascript:">人才招聘</a></div>
                <p><a href="javascript:">人才计划</a></p>
                <p><a href="javascript:">招聘职位</a></p>
            </div>
            <div id="legalColumn" class="footServerCon">
            	<div class="serverConStr"><a href="javascript:">法律专栏</a></div>
                <p><a href="javascript:">使用条款</a></p>
                <p><a href="javascript:">相关协议</a></p>
                <p><a href="javascript:">版权声明</a></p>
                <p><a href="javascript:">隐私政策</a></p>
                <p><a href="javascript:">免责声明</a></p>
                <p><a href="javascript:">法律知识</a></p>
            </div>
            <div id="footProblem" class="footServerCon">
            	<div class="serverConStr"><a href="javascript:">疑难解答</a></div>
            	<div class="serverConStr"><a href="javascript:">投诉建议</a></div>
            	<div class="serverConStr"><a href="javascript:">广告服务</a></div>
            	<div class="serverConStr"><a href="javascript:">信息中心</a></div>
            </div>
        </div>
        
        <div id="footCopyright">
        	<div class="serverConStr" id="serverConStrid">版权声明</div>
            <div id="footCopyrightCon">
            	<p>所有图片及文件都受著作权保护，未经允许不得使用，</p>
                <p>不得转载编辑</p>
            	<p>Copyright&copy;2012-2013 wepic.cn</p>
                <p>上海维拓网络科技有限公司</p>
                <p>ICP备案/许可证：沪ICP备13010366号</p>
            </div>
        </div>
        
        <div id="footCustom">
        	<div id="twoDimensionCode">
            	<img src="${pageContext.request.contextPath}/public/images/weixin.png"/>
                <p>微信公众账号</p>
            </div>
            
            <div id="DimensionCodeServer">
            	<p class="serverConStr">客服电话</p>
                <p id="serverPhone">400-809-9060</p>
                <p>（周一至周五：9:00-18:00）</p>
                <div id="serverShare">
                	<ul>
                    	<li><a href="javascript:" id="shareSina" class="shareSina" title="分享到新浪微博"></a></li>
                        <li><a href="javascript:" id="shareQqzone" class="shareQqzone" title="分享到QQ空间"></a></li>
                        <li><a href="javascript:" id="shareQqblog" class="shareQqblog" title="分享到腾讯微博"></a></li>
                        <li><a href="javascript:" id="shareTwitter" class="shareTwitter" title="分享到twitter"></a></li>
                        <li><a href="javascript:" id="shareFacebook" class="shareFacebook" title="分享到facebook"></a></li>
                        <li><a href="javascript:" id="shareRenren" class="shareRenren" title="分享到人人网"></a></li>
                        <li><a href="javascript:" id="shareDouban" class="shareDouban" title="分享到豆瓣"></a></li>
                    </ul>
                    	
                </div>
            </div>
        </div>
    </div>
    </div>
    <!--foot 结束-->
    
	<div id="goTopBtn" style="display:none;"></div>
    
    
    <div id="moveTozj">
    	<div class="top">
    		<h2>选择专辑</h2>
			<a href="javascript:cloosePopBox('moveTozj');"></a>
    	</div>
        
    	<div class="zhuanji" id="zhuanjiadd">
        	<ul>
        	
                            
            </ul>
    		
            
            <div class="divAddSpecial">
				<a href="manageSpecial.html">管理专辑</a>
			</div>
    	</div>
        
        <div class="tijaio">
        <input type="hidden" id="publishIdforchange" value="<s:property value="publish.id"/>" />
        <input type="hidden" id="spcialChangeForPublish" value="<s:property value="publish.publishSpecialCat.id"/>" />
        	<input class="reset" type="button" value="取消"  onclick="cloosePopBox('moveTozj');"/>
			<input class="sub" type="button" value="确定" onclick="changeSpeicals()"/>
    	</div>
    </div>
    
    
    
</div>
<!--[if lte IE 6]>
<script src="${pageContext.request.contextPath}/public/js/DD_belatedPNG_0.0.8a.js" type="text/javascript"></script>
    <script type="text/javascript">
        DD_belatedPNG.fix('div, ul, img, li, input , a , i');
    </script>
<![endif]-->

<!--焦点ss图结束-->
<script type="text/javascript" src="${pageContext.request.contextPath}/back/js/jquery.imgSlider.js"></script>
<script type="text/javascript">
img.init();
img.play(0);
//阻止事件冒泡
function estop(e){
	var e=arguments.callee.caller.arguments[0]||event;
	if (e && e.stopPropagation){
	//因此它支持W3C的stopPropagation()方法
	   e.stopPropagation();
	}else{
	//否则，我们需要使用IE的方式来取消事件冒泡
	   window.event.cancelBubble = true;
	   return false;
	}
}



function changePicInfo(id){
    if(isNaN(id)){
      return ;
        }
//sss
	$.ajax({
		type : "POST",
		url : "jsonpublish_getPicInfo.do",
		data : "id="+id,				
		success : function(data) {			
			var publish=data.publishTest;

			
          $("#dowloadPic").attr("href","publish!downloadPic.do?id="+publish.id);



			
			$("#publishName").html(publish.name);
			$("#picNamechn").html(publish.name);
			var type='暂无';
			if(publish.type==2){
				type="创意图片";
				}
			else if(publish.type==3){
            type="摄影图片";
				}
			var spcat=publish.publishSpecialCat.name;
			var content=publish.content;
			if(content==''||content==null){
                content='暂无';
				}

             var seler="";





             /*
             
              <s:if test="#publish.publishStatus.pass!=1">
                                                                      <s:if test="publish.publishStatus.noPass==0&&publish.publishStatus.adminSoldout!=1">
                                                                      <span class="orange">审核中</span>
                                                                      </s:if>  
                                                                      <s:if test="publish.publishStatus.noPass==1">
                                                                      <span class="red">审核未通过</span>
                                                                       </s:if>  
                                                                      </s:if> 
                                                                      
                                                                      <s:if test="publish.publishStatus.adminSoldout==1">
                                                                      
                                                                      </s:if>
                                                                      <s:elseif test="publish.publishStatus.copyrightBuyout==1">
                                                                      <span class="orange">被下架</span>
                                                                      </s:elseif>
                                                                       <s:elseif test="publish.publishStatus.userSoldout==1">
                                                                      <span class="grey">已下架</span> 
                                                                      </s:elseif>     
                                                                      <s:elseif test="publish.publishStatus.onOffer==1">
                                                                      <span class="grey">已发布为可出售</span> 
                                                                      </s:elseif>
                                                                       <s:elseif test="publish.publishStatus.justShow==1">
                                                                      <span class="grey">已发布为仅展示</span> 
                                                                      </s:elseif>
                                                                      <s:else>
                                                                                                                                                                                                     未发布
                                                                      </s:else>       
             
             
             
             */
             
             var valser='';
             if(publish.publishStatus.pass!=1&&publish.publishStatus.unreleased==1){
                 //alert("ssssss");
                 if(publish.publishStatus.noPass==0&&publish.publishStatus.adminSoldout!=1){
                   valser='<span class="orange">审核中</span>';
                   $("#publishEditePage").parents(".edt").hide();
                     }
                if(publish.publishStatus.noPass==1){


                	  var htsl='<div id="stateRemind" class="stateRemind" style="display: none;"><div class="con"><div class="char">被管理员下架原因：</div>';
                      var strs=publish.notPassedCause;
                      if(strs!==null&&strs!=''){
                          var res=strs.split(",");
                          for(var i=0;i<res.length;i++){
                              if(res[i]==1){
                            	  htsl+='<div class="rea">您上传的证件不清晰</div>';
                                  }
                              else if(res[i]==2){
                            	  htsl+='<div class="rea">证件照片有改动</div>';
                                  }
                              else if(res[i]==3){
                            	  htsl+='<div class="rea">您提交的身份信息不正确</div>';
                                  }
                              else{
                            	  htsl+='<div class="rea">'+res[i]+'</div>';
                                  }


                              }


                          }
                      
                      htsl+='</div><div class="time">2013-02-12</div><div class="sanjiao"></div> </div>';
                  	
                  



                    
                	 valser=htsl+'<span class="red" onclick="getReson()">审核未通过</span>';
                	// valser='<span class="red" onclick="getReson('+publish.id+')"></span>';
                	 $("#publishEditePage").parents(".edt").hide();
                    }
                 

                 }
            // alert(valaaaser);
            else if(publish.publishStatus.adminSoldout==1){
                  var htsl='<div id="stateRemind" class="stateRemind" style="display: none;"><div class="con"><div class="char">被管理员下架原因：</div>';
                  var strs=publish.notPassedCause;
                  if(strs!==null&&strs!=''){
                      var res=strs.split(",");
                      for(var i=0;i<res.length;i++){
                          if(res[i]==1){
                        	  htsl+='<div class="rea">您上传的证件不清晰</div>';
                              }
                          else if(res[i]==2){
                        	  htsl+='<div class="rea">证件照片有改动</div>';
                              }
                          else if(res[i]==3){
                        	  htsl+='<div class="rea">您提交的身份信息不正确</div>';
                              }
                          else{
                        	  htsl+='<div class="rea">'+res[i]+'</div>';
                              }


                          }


                      }
                  
                  htsl+='</div><div class="time">2013-02-12</div><div class="sanjiao"></div> </div>';
              	
              



                
            	 valser=htsl+'<span class="red" onclick="getReson()">被管理员下架</span>';
            	 $("#publishEditePage").parents(".edt").hide();
                 }
             else if(publish.publishStatus.copyrightBuyout==1){
            	 valser='<span class="orange">被下架</span>';
            	 $("#publishEditePage").parents(".edt").hide();
                 }
             else if(publish.publishStatus.userSoldout==1){
            	 valser='<span class="grey">已下架</span>';
            	 $("#publishEditePage").parents(".edt").hide();

                 }
             else if(publish.publishStatus.onOffer==1&&publish.publishStatus.pass==1&&publish.publishStatus.copyrightBuyout==0){
            	 valser='<span class="grey">已发布为可出售</span>';
            	 $("#publishEditePage").parents(".edt").show();
	              $("#copyrightPrice").html(publish.copyrightPrice);
	            //   $("#userXiajia").show();
	              $("#usagePrice").html(publish.usagePrice);
	              seler="已发布为可出售";
	             //  $("#publishEditePage").attr("onclick","location.href='publish!findEditereleasPublish.do?id="+publish.id);
	              $("#publishEditePage").click(function(){
                    window.location.href="publish!findEditereleasPublish.do?id="+publish.id;
		              });
	              $("#userXiajia").show();

	            	 
                 }
             else if(publish.publishStatus.justShow==1&&publish.publishStatus.pass==1){
            	 valser='<span class="grey">已发布为仅展示</span>';
            	 $("#publishEditePage").parents(".edt").show();
            	 $("#userXiajia").show();
           	 // seler="已发布为仅展示";
           	  // $("#publishEditePage").attr("onclick","location.href='publish!findEditereleasPublish.do?id="+publish.id);
           	  $("#publishEditePage").click(function(){
                     window.location.href="publish!findEditereleasPublish.do?id="+publish.id;
 		              });

                 }else{
                	 valser='未发布';
                	  $("#propertysa").hide();
                	  $("#publishEditePage").next().hide();
                	  $("#publishEditePage").parents(".edt").show();
	            	//  seler="未发布";
	            	  // $("#publishEditePage").attr("onclick","location.href='publish!findEditeUnPublish.do?id="+publish.id);
	            	  $("#publishEditePage").click(function(){
	                      window.location.href="publish!findEditeUnPublish.do?id="+publish.id;
	  		              });

                     }
             /*
			  if(publish.publishStatus.onOffer==1){
	              $("#propertysa").show();
	              $("#copyrightPrice").html(publish.copyrightPrice);
	              $("#usagePrice").html(publish.usagePrice);
	              seler="已发布为可出售";
	             //  $("#publishEditePage").attr("onclick","location.href='publish!findEditereleasPublish.do?id="+publish.id);
	              $("#publishEditePage").click(function(){
                    window.location.href="publish!findEditereleasPublish.do?id="+publish.id;
		              });









	              
	              
	              }else  if(publish.publishStatus.justShow==1){
	            	  $("#propertysa").hide();
	            	  seler="已发布为仅展示";
	            	  // $("#publishEditePage").attr("onclick","location.href='publish!findEditereleasPublish.do?id="+publish.id);
	            	  $("#publishEditePage").click(function(){
	                      window.location.href="publish!findEditereleasPublish.do?id="+publish.id;
	  		              });
		                 }
	              else{
	            	  $("#propertysa").hide();
	            	  seler="未发布";
	            	  // $("#publishEditePage").attr("onclick","location.href='publish!findEditeUnPublish.do?id="+publish.id);
	            	  $("#publishEditePage").click(function(){
	                      window.location.href="publish!findEditeUnPublish.do?id="+publish.id;
	  		              });

		              }

*/
			  var Ndate="";
	  if(publish.publishTime!=null&&publish.publishTime!=""){	
		var dat=new Date(Date.parse(publish.publishTime));
		  Ndate=$.formatDate(dat,'yyyy-M-d');
			  }
	  else{
		  Ndate="未发布"
		  }
         var html='<table><tbody><tr>'+
          	'<td class="td1">作品类别</td>'+
            '<td class="td2">'+type+'</td>'+
        	'<td class="td3">所属专辑</td>'+
            '<td class="td4"> '+spcat+'   </td>'+
            '<td class="td5"><a onclick=openSpecial(); href="javascript:">移动到</a></td></tr>'+
            '<tr><td class="td1">作品状态</td><td class="td2 tdDeal">'+valser+'</td><td class="td3">发布时间</td><td class="td4">'+Ndate+'</td>'+
            '</tr> <tr><td class="td1">作品说明</td></tr><tr><td class="tds" colspan="5">'+content+'</td></tr>'+
            '</tbody></table>';
            $("#publishIdforchange").val(publish.id);
            $("#spcialChangeForPublish").val(publish.publishSpecialCat.id);
            
            var tags=publish.roleTags;
            var tag="";
            if(tags!=null){
            for(var i=0;i<tags.length;i++){
            	 tag+='<a href="javascript:"> '+ tags[i].tag+'</a>'
                	
                }
            }
				if(tag==""){
					tag="暂无"
					}
		//ggg
	
          var cat=data.publishTest.publishCats;
          var catHtml="";
          if(cat!=null){
          for(var i=0;i<cat.length;i++){
        	  catHtml+='<div class="retag"><span>'+cat[i].name+'</span><a></a></div>'
            	  
              }
          }
         if(catHtml==""){
        	 catHtml="暂无";
             }
         $("#zuopinKey").html(tag);
        $("#zuopinType").html(catHtml);	
            // var table2='';
             var sizeInfo="";
            if(publish.logo==0){
              sizeInfo='<span>'+publish.width+
              '</span>*<span>'+publish.height+'</span>px<span class="s">|'
              '</span><span>';
                }
            var table1='<table><tr><td><span>作品编号：</span></td><td class="td2"><span>'+publish.picNumber+
                '</span></td><td><span>上传时间：</span></td>'+
            '<td><span>'+publish.upTime+'</span></td></tr><tr>'+
        	'<td><span>原始尺寸：</span></td><td><span <span>'+sizeInfo+publish.size+'</span>M</td> </tr> </table>';

           var hts="";
           var portraitprotocol=publish.portraitprotocol;
           var productsprotocol=publish.productsprotocol;
           //alert(portraitprotocol+"="+productsprotocol)
           if($.trim(portraitprotocol)!=''||$.trim(productsprotocol)!=''){
               if($.trim(portraitprotocol)!=''){
            	   hts="<a>有肖像权许可<a>";
                }
                if($.trim(productsprotocol)!=''){
                	 hts+="<a>有物权许可<a>";
                    }

               }else{
            	   hts="暂无"

                   }

              $("#banquan").html(hts);
              $("#downLoadPic").attr("href","publish!downloadPic.do?id="+publish.id)
        	  $("#table1").html(table1);
              $("#picInfo").html(html);

              $("#userXiajia").click(function(){
            	  window.location.href='publish!userSoldout.do?id='+publish.id;
            	  });
              // $("#catpicInfo").html(table2);44
              
            
			}
		});





	
}


function achieveBelow(bolewDiv,showValue){
	var bolewDiv=document.getElementById(bolewDiv);
	var bolewDivSpan=bolewDiv.getElementsByTagName("span");
	/*alert("11");*/
				
	for(var i=0;i<bolewDivSpan.length;i++){
		   bolewDivSpan[i].onclick=function (){
			/*document.getElementById(showValue).innerHTML = this.innerHTML;*/
			getImgSUnm($(this).attr("id"));
			//swfupload.addPostParam("publishSpecialCatId",$(this).attr("id"))
			
			$("#"+showValue).html(this.innerHTML);
			$(bolewDiv).hide();
			$(bolewDiv).parent().parent().css("z-index","0");
			};
		}
}


$(function(){
    $("#divdropDownViewPartType").html('<s:property value="publish.publishSpecialCat.name"/>');
    getImgSUnm('<s:property value="publish.publishSpecialCat.id"/>')
	$.ajax({
	      type:"Post",
		  url: "specialcat_getpublishSpecialCats.do",
		  data:"",		
		  success : function(data) {
	  		  
	  	  var list=data.publishSpecialCats;
	  	  var html='';
	  	  var changeSp="";
	  	  for(var i=0;i<list.length;i++){
	  	  	   publishCat=list[i];
	  		   html+='<span class="dropValue" id='+publishCat.id+'>'+publishCat.name+'</span>';
	  		changeSp+='<li id='+publishCat.id+'><div class="special"><div class="tone tone1"style="background:'+publishCat.icon+'"></div><div class="name">'+publishCat.name+'</div></div></li>';
	  	  	  } 
  	  	  $("#zhuanjiadd").find("ul").html(changeSp);

	  	    $("#divdropDownPartType").html(html);
	  	    achieveBelow("divdropDownPartType","divdropDownViewPartType");
	  		   
		  }
	});  
  $("#userXiajia").click(function(){
	  window.location.href='publish!userSoldout.do?id=<s:property value="publish.id"/>';
	  });


		
    });


function getImgSUnm(id){

	$.ajax({
	      type:"Post",
		  url: "jsonpublish_findbyCountBySpecialCat.do",
		  data:"publishSpecialCatId="+id,		
		  success : function(data) {
          var c=data.count;
	  	$("#totalPic").html(c[0]);
	  	$("#fabutotalPic").html(c[1]);  
	  	
	  		   
		  }
  	});




    }



function getReson(){

	var sta=$("#stateRemind").css("display");
	if(sta=="block"){
		  $("#stateRemind").hide();
		}
	else{
		 $("#stateRemind").show();
	

		}

		



  

	
}

</script>




</body>
</html>
