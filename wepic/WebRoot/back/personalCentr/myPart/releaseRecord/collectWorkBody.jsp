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

<title>wepic管理_个人中心_我的约拍_作品征集_有人应约详情</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/jquery.js"></script>





<!--公共js
<script type="text/javascript" src="${pageContext.request.contextPath}/back/js/publicBack.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/public.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/topBar.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/header.js"></script>
-->
<!--公共css-->
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public/css/public.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/back/pubimg/css/backMainBar.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public/css/topBarMain.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public/css/header.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public/css/footer.css" />


<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/back/personalCentr/myPart/releaseRecord/css/collectWorkDetail.css" />

<script type="text/javascript">
var str='<s:property value="bid.workEndTime"/>';

var re = new RegExp("{-}", "g");

str  = str.replace(re, "/");


</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/back/js/publicBack.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/public.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/topBar.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/header.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/back/personalCentr/myPart/releaseRecord/js/collectWorkDetail.js"></script>

</head>

<body>
<div id="container">
	<div id="topBar">
	<div id="topbar">
    	<div id="topcenterbar">
    		<div id="topbar-collect">
    	<!--<input type="text" id="qqq" value="11"/>-->
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
            		<a href="${pageContext.request.contextPath}/user!getFistPageUserInfo.do">个人中心</a>
            	</li>
            	<li id="configureCenter">
            		<a href="${pageContext.request.contextPath}/configure!securityIndex.do">配置中心</a>
            	</li>
            	
            	<li id="inforCenter">
            		<a href="javascript:void(0)">消息中心</a>
           	 	</li>
            	<li id="myRoom">
            		<a href="javascript:void(0)">我的空间</a>
            	</li>
        	</ul>
            
            <div class="time">
                注册时间：<span class="regedit">2013-05-06</span>
                上次登录时间：<span>2013-05-06</span>
            </div>
        </div>
        
        
	</div>
    
	<!-- logo行 end-->
	
     <!-- 导航 -->
  	<div id="assistantBar">
    	<div class="twoStage" id="divTwoStage">
        	<a href="javascript:"><div class='bar'><span>首页</span><i></i></div></a>
            
            <a href="javascript:"><div class='bar'><span>账户基本资料</span><i></i></div></a>
            
            <a href="javascript:"><div class='bar'><span>我的作品库</span><i></i></div></a>
            
            <a href="javascript:"><div class='bar active'><span>我的约拍</span><i></i></div></a>
            
            <a href="javascript:"><div class='bar'><span>我买到的作品</span><i></i></div></a>
            
           <a href="javascript:"> <div class='bar'><span>收藏/订阅/推荐</span><i></i></div></a>
        </div>
    	
        <div id="divThreeStage">
        
        <div class="threeStage">
        	<a href="javascript:"><div class='bar'><span>应约记录</span><i></i></div></a>
            
            <a href="javascript:"><div class='bar active'><span>发布记录</span><i></i></div></a>
            
            <a href="javascript:"><div class='bar'><span>约拍日程</span><i></i></div></a>
            
            <a href="relProjectChoose.html"><div class='bar'><span>发布约拍</span><i></i></div></a>
        </div>
        </div>
    </div>
    <!-- 导航  end-->


	
    
    
    <div id="appointProjectCon">
    <!--中间内容-->
    	<div id="appointProjectConInfo">
        	
            <div id="divStageTop">
         	<!--招标状态-->
        	<div class="divStage">
            	<div class="left">
                    <div class="character">
                        
                        <span  <s:if test="bid.bidStatus.publishBid==1">class="active" </s:if>>应约中</span>
                        
                        
                        <span <s:if test="bid.bidStatus.selectPerson==1">class="active" </s:if>>筛选中</span>
                        <span <s:if test="bid.bidStatus.working==1">class="active" </s:if>>进行中</span>
                        <span <s:if test="bid.bidStatus.endBid==1">class="active" </s:if>>已结束</span>
                    </div>
                    <div class="ico">
                        <div class="one" ></div>
                        <div class="two"></div>
                        <div class="three <s:if test="bid.bidStatus.selectPerson==1">redline</s:if>">  </div>
                        <div class="four <s:if test="bid.bidStatus.selectPerson==1">redDot</s:if>"></div>
                        <div class="five <s:if test="bid.bidStatus.working==1">redline</s:if>"></div>
                        <div class="<s:if test="bid.bidStatus.working==1">redDot</s:if> six "></div>
                        <div class="seven <s:if test="bid.bidStatus.endBid==1">redline</s:if>"></div>
                        <div class="eight  <s:if test="bid.bidStatus.endBid==1">redDot</s:if>"></div>
                    </div>
           	 	</div>
                <div class="right">
                	<div class="one"><span class="char">应约人数：</span><span>34</span>人</div>
                    <div class="two"><span class="char">邀请人数：</span><span>3344</span>人，回应<span>3344</span>人</div>
                </div>
            </div>
            <!--招标状态-->
            </div>
            
            <!-- 标题部分-->
            <div class="divProjectTitle">
                <div class="titleRightzj" title="该项目属于作品征集类型"></div>
                <div class="titleTop">
                	<div class="title">
                    	<span class="topName" title="这里写我的标题" alt="这里写我的标题">
                    	<s:property value="bid.name"/>
                    	</span>
                    </div>
                        
                    <div class="topIco">
                        <a class="view" title="浏览次数"><span> <s:property value="bid.bidView"/></span></a>
                        <a class="collect" title="收藏次数"><span> <s:property value="bid.saveFrarite"/></span></a>
                        <a class="good" title="推荐次数"><span> <s:property value="bid.bidGood"/></span></a>    
                    </div>
                    
                </div>
                
                <div class="titleBottom">
                	<table>
                    	<tr>
                        	<td class="td1"><span class="bh">项目编号:</span><span class="num"><s:property value="bid.id"/></span></td>
                            <td class="td2">应约时间：剩余</td>
                            <td class="td3">
                            	<form name="formnow" id="daojishi">
                                    <input value="" name="dd" size="1" type="text" class="daojishi1"/>
                                        天
                                    <input value="" name="hh" size="1" type="text" class="daojishiT"/>
                                        小时
                                    <input value="" name="mm" size="1" type="text" class="daojishiT"/>
                                        分
                                    <input value="" name="ss" size="1" type="text" class="daojishiT"/>
                                    秒 
                                </form>
                            </td>
                        	<td>发布时间：<span class="tt"><s:property value="bid.Content"/></span></div></td>
                        </tr>
                    </table>
                </div>
                
            </div>
            <!-- 标题部分-->
            
            <div id="divFold">
            <!--拍摄内容-->
        	<div class="divShoot">
            	<table>
                	<tr>
                    	<td class="td1">征集内容：</td>
                        <td>
                        	<span class="shootC shootCP">   <s:property value="bid.bidCat.name"/></span>
                            <span class="shootC productType"><s:property value="bid.tag"/></span>
                        </td>
                    </tr>
                	<s:if test="bid.appendix!=null&&bid.appendix.trim()!=''">
                	<tr>
                    	<td class="td1">应用行业：    </td>
                        <td><span>
                        <s:property value="bid.appendix"/>                  
                        </span></td>
                    </tr>
                    
                    </s:if>
                    
                    <s:if test="(bid.sjProjectVI!=null&&bid.sjProjectVI.trim().length()>0)||(bid.viApplication!=null&&bid.viApplication.trim().length()>0)">
                	<tr>
                    	<td class="td1">VI项目：</td>
                        <td>共<span>
                        <s:property value="bid.viCount"/>
                        
                        </span>项</td>
                    </tr>
                	<tr>
                    	<td class="td1"></td>
                        <td class="td_hy"><span>
                        <s:property value="bid.sjProjectVI"/>
                        <s:property value="bid.viApplication"/>
                        
                        </span></td>
                    </tr>
                    </s:if>
                    
                	<tr>
                    	<td class="td1">应约要求：</td>
                        <td><span>
                        
                        <s:property value="bid.contextHtml"/>  
               </span></td>
                    </tr>
                </table>
            </div>
            <!--拍摄内容-->
            
            <!--招标-->
            <div class="divInviteBids">
            	<table>
                	<tr>
                    	<td rowspan="3" class="icobid"><div></div></td>
                    	<s:if test="bid.workPrecisionWidth!=null&&bid.workPrecisionWidth.trim()!=''">
                    	<td class="td2"><span>作品规格：</span></td>
                        <td class="td3"><span>
                        <s:property value="bid.workPrecisionWidth"/>
                        x<s:property value="bid.workPrecisionHeight"/>
                        <s:if test="bid.workPrecision==1">px</s:if>
                        <s:elseif test="bid.workPrecision==2">cm</s:elseif>
                        <s:elseif test="bid.workPrecision==3">m</s:elseif>
                        
                        </span><a href="javascript:"></a></td>
                        </s:if>
                        
                        <s:if test="(bid.worksspecifications!=null&&bid.worksspecifications.trim()!='')||(bid.fileType!=null&&bid.fileType.trim()!='')">
                        <td class="td4"><span>格式要求：</span></td>
                        <td class="td5">
                          <s:if test="bid.worksspecifications!=null&&bid.worksspecifications.trim()!=''">
                        <span>
                        <s:property value="bid.worksspecifications"/>                        
                        dpi</span>
                        </s:if>
                        <s:if test="bid.fileType!=null&&bid.fileType.trim()!=''">
                        <span class="shootBg formatRequire">
                       
                        <s:if test="bid.fileType==1">位图</s:if>
                         <s:if test="bid.fileType==2">矢量图</s:if>
                          <s:if test="bid.fileType==3">3D格式</s:if>
                        </span>
                        </s:if>
                        </td>
                        </s:if>
                    </tr>
                    
                    <tr>
                    <s:if test="bid.sumProdct!=null&&bid.sumProdct>0">
                    	<td class="td2"><span>征集数量：</span></td>
                        <td class="td3"><span>
                          <s:property value="bid.sumProdct"/>
                    
                        </span>  <s:if test="bid.sumProductPhoto==1">片</s:if>
                         <s:elseif test="bid.sumProductPhoto==2">件</s:elseif>
                          <s:elseif test="bid.sumProductPhoto==3">秒</s:elseif>
                          <s:elseif test="bid.sumProductPhoto==4">套</s:elseif>
                            <s:elseif test="bid.sumProductPhoto==6">篇</s:elseif>
                             <s:elseif test="bid.sumProductPhoto==7">张</s:elseif>
                          <span class="shootBg shootjj">按<s:if test="bid.sumProductPhoto==1">片</s:if>
                         <s:elseif test="bid.sumProductPhoto==2">件</s:elseif>
                          <s:elseif test="bid.sumProductPhoto==3">秒</s:elseif>
                          <s:elseif test="bid.sumProductPhoto==4">套</s:elseif>
                            <s:elseif test="bid.sumProductPhoto==6">篇</s:elseif> <s:elseif test="bid.sumProductPhoto==7">张</s:elseif>计价</span></td>
                            </s:if>
                        <td class="td4"><span>版权需求：</span></td>
                        <td class="td5">
                        <s:if test="bid.isCopyright==1">征集作品使用权</s:if>
                          <s:if test="bid.isCopyright==2">征集作品版权</s:if>
                        
                        
                        <span>
                        
                        
                        
                        </span></td>
                    </tr>
                    
                    <tr>
                    	<td class="td2"><span>征集截止：</span></td>
                        <td class="td3"><span><s:property value="bid.workEndTime"/></span></td>
                       <s:if test="bid.numFont!=null&&bid.numFont!=''&&bid.numFont!=0">
                        <td class="td2"><span>字数：</span></td>
                        <td class="td3"><span>
                        <s:property value="bid.numFont"/>
                        
                        </span></td>
                       </s:if>
                        
                    </tr>
                </table>
            </div>
                    
            <!--中标-->
            <div class="divWinBids">
            	<table>
                	<tr class="tr1">
                    	<td rowspan="2" class="td1"><div class="icoWin"></div></td>
                    	<td class="td2">中标总酬金
                    	
                    	</td>
                        <td class="td3"><a title="您可报价"></a></td>
                    </tr>
                    <tr>
                    	<td class="td2"><span class='tocj'>
                    	<s:property value="bid.totalMoney"/>
                    	
                    	
                    	</span></td>
                    	<s:if test="bid.unitpriceProduct!=null&&bid.unitpriceProduct!=0">
                    	<td class="td3">每件酬金：</td>
                        <td class="td4"><span class='percj'>  <s:property value="bid.unitpriceProduct"/></span></td>
                        </s:if>
                    </tr>
                
                </table>
            </div>
            <!--中标-->
            </div>
        </div>
        
        
        
        
        
        <div id="appointProjectTimelyState">
        	<div class="divStateCard">
        		<ul id="recruitCameristTimelyStateCard">
                	<li class="active"><a href="javascript:">应约作品列表</a></li>
                    <li><a href="javascript:">我的邀请记录</a></li>
                    <li><a href="javascript:">待定列表</a></li>
                    <li><a href="javascript:">中标作品列表</a></li>
            	</ul>
            </div>
            
            <div class="divStateCardCon">
            
            	<!--应约者列表-->
                <div class="divList" id="divListOne">
                	<div class="divsx">
                    	<ul id="divsxOne">
                            <li class="active">新应约作品</li>
                            <li>全部应约作品</li>
                            <li>不选的作品</li>
                       	 	<div style="clear:both;"></div>
                        </ul>
                    </div>
                       	 	<div style="clear:both;"></div>
                    <ul id="divListOneUl">
                        <li class="lilistOnly">
                            <img src="${pageContext.request.contextPath}/public/pic/2.png"/>
                        </li>
                        <li class="lilistOnly">
                            <img src="${pageContext.request.contextPath}/public/pic/2.png"/>
                        </li>
                        <li class="lilistOnly">
                            <img src="${pageContext.request.contextPath}/public/pic/2.png"/>
                        </li>
                        <li class="lilistOnly">
                            <img src="${pageContext.request.contextPath}/public/pic/2.png"/>
                        </li>
                        <li class="lilistOnly">
                            <img src="${pageContext.request.contextPath}/public/pic/2.png"/>
                        </li>
                        <li class="lilistOnly">
                            <img src="${pageContext.request.contextPath}/public/pic/2.png"/>
                        </li>
                        <li class="lilistOnly">
                            <img src="${pageContext.request.contextPath}/public/pic/2.png"/>
                        </li>
                        <li class="lilistOnly">
                            <img src="${pageContext.request.contextPath}/public/pic/2.png"/>
                        </li>
                        <li class="lilistOnly">
                            <img src="${pageContext.request.contextPath}/public/pic/2.png"/>
                        </li>
                        <li class="lilistOnly">
                            <img src="${pageContext.request.contextPath}/public/pic/2.png"/>
                        </li>
                        <li class="lilistOnly">
                            <img src="${pageContext.request.contextPath}/public/pic/2.png"/>
                        </li>
                        
                        
                        
                        
                        
                        <div style="clear:both;"></div>
                    </ul>
                    
                    
                    <!--翻页-->
                    <div class="ppointPagingthis">
                        <div class="ppointPaging">            
                            <table class="tablePpointPaging">
                                    <tr>
                                        <td class="ppointPagingOne"><a href="javascript:"></a></td>
                                        <td class="ppointPagingPre"><a href="javascript:"></a></td>
                                        <td class="ppointPagingN"><a href="javascript:">1</a></td>
                                        <td class="ppointPagingN"><a href="javascript:">2</a></td>
                                        <td class="ppointPagingN"><a href="javascript:">3</a></td>
                                        <td class="ppointPagingN"><a href="javascript:">4</a></td>
                                        <td class="ppointPagingN"><a href="javascript:">5</a></td>
                                        <td class="ppointPagingN"><a href="javascript:">6</a></td>
                                        <td class="ppointPagingN"><a href="javascript:">7</a></td>
                                        <td class="ppointPagingN"><a href="javascript:">8</a></td>
                                        <td class="ppointPagingN"><a href="javascript:">9</a></td>
                                        <td class="ppointPagingN"><a href="javascript:">10</a></td>
                                        <td class="ppointPagingNext"><a href="javascript:"></a></td>
                                        <td class="ppointPagingLast"><a href="javascript:"></a></td>
                                    </tr>
                                </table>
                        </div>
                    </div>
                    <!--翻页-->
                </div>
        		<div class="divList" id="divListTwo">
                    <ul id="divListTwoUl">
                    	<!--已报价-->
                        <li class="lilist">
                        	<div class="divImg">
                                <img src="${pageContext.request.contextPath}/public/pic/head/1.png"/>
                                <div class="divBackGround">
                                    <div class="opacity"></div>
                                    <div class="info">
                                        <p class="one">报价：</p>
                                        <p class="two">￥<span>576675765</span></p>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="divUserInfo">
                            	<div class="one">
                                	<span class="name">凤凰传奇</span>
                                    <a class="approveNo" title="未实名认证"></a>
                                   <!-- <a class="approveHave" title="个人实名认证"></a>-->
                                   <!-- <a class="approveQy" title="企业实名认证"></a>-->
                                </div>
                            	<div class="two">
                                	<a class="age" title="年龄">20岁</a>
                                    <a class="address" title="工作地"><span>上海</span><span>嘉定</span></a>
                                </div>
                            	<div class="three"><div class="job" title="职业"><span>时装摄影师</span><a></a></div>
                                </div>
                                <div class="four"><a class="view" title="浏览次数">2045</a></div>
                            </div>
                        </li>
                        <!--已报价-->
                        
                        <!--已报价-->
                        <li class="lilist">
                        	<div class="divImg">
                                <img src="${pageContext.request.contextPath}/public/pic/head/1.png"/>
                                <div class="divBackGround">
                                    <div class="opacity"></div>
                                    <div class="info">
                                        <p class="one">报价：</p>
                                        <p class="two">￥<span>576675765</span></p>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="divUserInfo">
                            	<div class="one">
                                	<span class="name">凤凰传奇</span>
                                    <a class="approveNo" title="未实名认证"></a>
                                   <!-- <a class="approveHave" title="个人实名认证"></a>-->
                                   <!-- <a class="approveQy" title="企业实名认证"></a>-->
                                </div>
                            	<div class="two">
                                	<a class="age" title="年龄">20岁</a>
                                    <a class="address" title="工作地"><span>上海</span><span>嘉定</span></a>
                                </div>
                            	<div class="three"><div class="job" title="职业"><span>时装摄影师</span><a></a></div>
                                </div>
                                <div class="four"><a class="view" title="浏览次数">2045</a></div>
                            </div>
                        </li>
                        <!--已报价-->
                        <!--已报价-->
                        <li class="lilist">
                        	<div class="divImg">
                                <img src="${pageContext.request.contextPath}/public/pic/head/1.png"/>
                                <div class="divBackGround">
                                    <div class="opacity"></div>
                                    <div class="info">
                                        <p class="one">报价：</p>
                                        <p class="two">￥<span>576675765</span></p>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="divUserInfo">
                            	<div class="one">
                                	<span class="name">凤凰传奇</span>
                                    <a class="approveNo" title="未实名认证"></a>
                                   <!-- <a class="approveHave" title="个人实名认证"></a>-->
                                   <!-- <a class="approveQy" title="企业实名认证"></a>-->
                                </div>
                            	<div class="two">
                                	<a class="age" title="年龄">20岁</a>
                                    <a class="address" title="工作地"><span>上海</span><span>嘉定</span></a>
                                </div>
                            	<div class="three"><div class="job" title="职业"><span>时装摄影师</span><a></a></div>
                                </div>
                                <div class="four"><a class="view" title="浏览次数">2045</a></div>
                            </div>
                        </li>
                        <!--已报价-->
                        
                        
                        <!--已报价-->
                        <li class="lilist">
                        	<div class="divImg">
                                <img src="${pageContext.request.contextPath}/public/pic/head/1.png"/>
                                <div class="divBackGround">
                                    <div class="opacity"></div>
                                    <div class="info">
                                        <p class="one">报价：</p>
                                        <p class="two">￥<span>576675765</span></p>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="divUserInfo">
                            	<div class="one">
                                	<span class="name">凤凰传奇</span>
                                    <a class="approveNo" title="未实名认证"></a>
                                   <!-- <a class="approveHave" title="个人实名认证"></a>-->
                                   <!-- <a class="approveQy" title="企业实名认证"></a>-->
                                </div>
                            	<div class="two">
                                	<a class="age" title="年龄">20岁</a>
                                    <a class="address" title="工作地"><span>上海</span><span>嘉定</span></a>
                                </div>
                            	<div class="three"><div class="job" title="职业"><span>时装摄影师</span><a></a></div>
                                </div>
                                <div class="four"><a class="view" title="浏览次数">2045</a></div>
                            </div>
                        </li>
                        <!--已报价-->
                        <!--已报价-->
                        <li class="lilist">
                        	<div class="divImg">
                                <img src="${pageContext.request.contextPath}/public/pic/head/4.png"/>
                                <div class="divBackGround">
                                    <div class="opacity"></div>
                                    <div class="info">
                                        <p class="one">报价：</p>
                                        <p class="two">￥<span>576675765</span></p>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="divUserInfo">
                            	<div class="one">
                                	<span class="name">凤凰传奇</span>
                                    <!--<a class="approveNo" title="未实名认证"></a>-->
                                    <!--<a class="approveHave" title="个人实名认证"></a>-->
                                    <a class="approveQy" title="企业实名认证"></a>
                                </div>
                            	<div class="two">
                                	<a class="age" title="年龄">20岁</a>
                                    <a class="address" title="工作地"><span>上海</span><span>嘉定</span></a>
                                </div>
                            	<div class="three"><div class="job" title="职业"><span>时装摄影师</span><a></a></div>
                                </div>
                                <div class="four"><a class="view" title="浏览次数">2045</a></div>
                            </div>
                        </li>
                        <!--已报价-->
                        
                        <!--已报价-->
                        <li class="lilist">
                        	<div class="divImg">
                                <img src="${pageContext.request.contextPath}/public/pic/head/1.png"/>
                                <div class="divBackGround">
                                    <div class="opacity"></div>
                                    <div class="info">
                                        <p class="one">报价：</p>
                                        <p class="two">￥<span>576675765</span></p>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="divUserInfo">
                            	<div class="one">
                                	<span class="name">凤凰传奇</span>
                                    <a class="approveNo" title="未实名认证"></a>
                                   <!-- <a class="approveHave" title="个人实名认证"></a>-->
                                   <!-- <a class="approveQy" title="企业实名认证"></a>-->
                                </div>
                            	<div class="two">
                                	<a class="age" title="年龄">20岁</a>
                                    <a class="address" title="工作地"><span>上海</span><span>嘉定</span></a>
                                </div>
                            	<div class="three"><div class="job" title="职业"><span>时装摄影师</span><a></a></div>
                                </div>
                                <div class="four"><a class="view" title="浏览次数">2045</a></div>
                            </div>
                        </li>
                        <!--已报价-->
                        
                        
                        <!--已报价-->
                        <li class="lilist">
                        	<div class="divImg">
                                <img src="${pageContext.request.contextPath}/public/pic/head/1.png"/>
                                <div class="divBackGround">
                                    <div class="opacity"></div>
                                    <div class="info">
                                        <p class="one">报价：</p>
                                        <p class="two">￥<span>576675765</span></p>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="divUserInfo">
                            	<div class="one">
                                	<span class="name">凤凰传奇</span>
                                    <a class="approveNo" title="未实名认证"></a>
                                   <!-- <a class="approveHave" title="个人实名认证"></a>-->
                                   <!-- <a class="approveQy" title="企业实名认证"></a>-->
                                </div>
                            	<div class="two">
                                	<a class="age" title="年龄">20岁</a>
                                    <a class="address" title="工作地"><span>上海</span><span>嘉定</span></a>
                                </div>
                            	<div class="three"><div class="job" title="职业"><span>时装摄影师</span><a></a></div>
                                </div>
                                <div class="four"><a class="view" title="浏览次数">2045</a></div>
                            </div>
                        </li>
                        <!--已报价-->
                        
                        
                        <!--没报价-->
                        <li class="lilist">
                        	<div class="divImg">
                                <img src="${pageContext.request.contextPath}/public/pic/head/2.png"/>
                                
                            </div>
                            
                            <div class="divUserInfo">
                            	<div class="one">
                                	<span class="name">凤凰传奇</span>
                                    <a class="approveNo" title="未实名认证"></a>
                                   <!-- <a class="approveHave" title="个人实名认证"></a>-->
                                   <!-- <a class="approveQy" title="企业实名认证"></a>-->
                                </div>
                            	<div class="two">
                                	<a class="age" title="年龄">20岁</a>
                                    <a class="address" title="工作地"><span>上海</span><span>嘉定</span></a>
                                </div>
                            	<div class="three"><div class="job" title="职业"><span>时装摄影师</span><a></a></div>
                                </div>
                                <div class="four"><a class="view" title="浏览次数">2045</a></div>
                            </div>
                        </li>
                        <!--没报价-->
                        <!--已报价-->
                        <li class="lilist">
                        	<div class="divImg">
                                <img src="${pageContext.request.contextPath}/public/pic/head/3.png"/>
                                <div class="divBackGround">
                                    <div class="opacity"></div>
                                    <div class="info">
                                        <p class="one">报价：</p>
                                        <p class="two">￥<span>576675765</span></p>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="divUserInfo">
                            	<div class="one">
                                	<span class="name">凤凰传奇</span>
                                    <!--<a class="approveNo" title="未实名认证"></a>-->
                                    <a class="approveHave" title="个人实名认证"></a>
                                   <!-- <a class="approveQy" title="企业实名认证"></a>-->
                                </div>
                            	<div class="two">
                                	<a class="age" title="年龄">20岁</a>
                                    <a class="address" title="工作地"><span>上海</span><span>嘉定</span></a>
                                </div>
                            	<div class="three"><div class="job" title="职业"><span>时装摄影师</span><a></a></div>
                                </div>
                                <div class="four"><a class="view" title="浏览次数">2045</a></div>
                            </div>
                        </li>
                        <!--已报价-->
                        
                        <!--已报价-->
                        <li class="lilist">
                        	<div class="divImg">
                                <img src="${pageContext.request.contextPath}/public/pic/head/4.png"/>
                                <div class="divBackGround">
                                    <div class="opacity"></div>
                                    <div class="info">
                                        <p class="one">报价：</p>
                                        <p class="two">￥<span>576675765</span></p>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="divUserInfo">
                            	<div class="one">
                                	<span class="name">凤凰传奇</span>
                                    <!--<a class="approveNo" title="未实名认证"></a>-->
                                    <!--<a class="approveHave" title="个人实名认证"></a>-->
                                    <a class="approveQy" title="企业实名认证"></a>
                                </div>
                            	<div class="two">
                                	<a class="age" title="年龄">20岁</a>
                                    <a class="address" title="工作地"><span>上海</span><span>嘉定</span></a>
                                </div>
                            	<div class="three"><div class="job" title="职业"><span>时装摄影师</span><a></a></div>
                                </div>
                                <div class="four"><a class="view" title="浏览次数">2045</a></div>
                            </div>
                        </li>
                        <!--已报价-->
                        
                        <!--已报价-->
                        <li class="lilist">
                        	<div class="divImg">
                                <img src="${pageContext.request.contextPath}/public/pic/head/3.png"/>
                                <div class="divBackGround">
                                    <div class="opacity"></div>
                                    <div class="info">
                                        <p class="one">报价：</p>
                                        <p class="two">￥<span>576675765</span></p>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="divUserInfo">
                            	<div class="one">
                                	<span class="name">凤凰传奇</span>
                                    <!--<a class="approveNo" title="未实名认证"></a>-->
                                    <a class="approveHave" title="个人实名认证"></a>
                                   <!-- <a class="approveQy" title="企业实名认证"></a>-->
                                </div>
                            	<div class="two">
                                	<a class="age" title="年龄">20岁</a>
                                    <a class="address" title="工作地"><span>上海</span><span>嘉定</span></a>
                                </div>
                            	<div class="three"><div class="job" title="职业"><span>时装摄影师</span><a></a></div>
                                </div>
                                <div class="four"><a class="view" title="浏览次数">2045</a></div>
                            </div>
                        </li>
                        <!--已报价-->
                        
                        <!--已报价-->
                        <li class="lilist">
                        	<div class="divImg">
                                <img src="${pageContext.request.contextPath}/public/pic/head/1.png"/>
                                <div class="divBackGround">
                                    <div class="opacity"></div>
                                    <div class="info">
                                        <p class="one">报价：</p>
                                        <p class="two">￥<span>576675765</span></p>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="divUserInfo">
                            	<div class="one">
                                	<span class="name">凤凰传奇</span>
                                    <a class="approveNo" title="未实名认证"></a>
                                   <!-- <a class="approveHave" title="个人实名认证"></a>-->
                                   <!-- <a class="approveQy" title="企业实名认证"></a>-->
                                </div>
                            	<div class="two">
                                	<a class="age" title="年龄">20岁</a>
                                    <a class="address" title="工作地"><span>上海</span><span>嘉定</span></a>
                                </div>
                            	<div class="three"><div class="job" title="职业"><span>时装摄影师</span><a></a></div>
                                </div>
                                <div class="four"><a class="view" title="浏览次数">2045</a></div>
                            </div>
                        </li>
                        <!--已报价-->
                        
                        <!--没报价-->
                        <li class="lilist">
                        	<div class="divImg">
                                <img src="${pageContext.request.contextPath}/public/pic/head/2.png"/>
                                
                            </div>
                            
                            <div class="divUserInfo">
                            	<div class="one">
                                	<span class="name">凤凰传奇</span>
                                    <a class="approveNo" title="未实名认证"></a>
                                   <!-- <a class="approveHave" title="个人实名认证"></a>-->
                                   <!-- <a class="approveQy" title="企业实名认证"></a>-->
                                </div>
                            	<div class="two">
                                	<a class="age" title="年龄">20岁</a>
                                    <a class="address" title="工作地"><span>上海</span><span>嘉定</span></a>
                                </div>
                            	<div class="three"><div class="job" title="职业"><span>时装摄影师</span><a></a></div>
                                </div>
                                <div class="four"><a class="view" title="浏览次数">2045</a></div>
                            </div>
                        </li>
                        <!--没报价-->
                        <!--已报价-->
                        <li class="lilist">
                        	<div class="divImg">
                                <img src="${pageContext.request.contextPath}/public/pic/head/3.png"/>
                                <div class="divBackGround">
                                    <div class="opacity"></div>
                                    <div class="info">
                                        <p class="one">报价：</p>
                                        <p class="two">￥<span>576675765</span></p>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="divUserInfo">
                            	<div class="one">
                                	<span class="name">凤凰传奇</span>
                                    <!--<a class="approveNo" title="未实名认证"></a>-->
                                    <a class="approveHave" title="个人实名认证"></a>
                                   <!-- <a class="approveQy" title="企业实名认证"></a>-->
                                </div>
                            	<div class="two">
                                	<a class="age" title="年龄">20岁</a>
                                    <a class="address" title="工作地"><span>上海</span><span>嘉定</span></a>
                                </div>
                            	<div class="three"><div class="job" title="职业"><span>时装摄影师</span><a></a></div>
                                </div>
                                <div class="four"><a class="view" title="浏览次数">2045</a></div>
                            </div>
                        </li>
                        <!--已报价-->
                        
                        <!--已报价-->
                        <li class="lilist">
                        	<div class="divImg">
                                <img src="${pageContext.request.contextPath}/public/pic/head/6.png"/>
                                <div class="divBackGround">
                                    <div class="opacity"></div>
                                    <div class="info">
                                        <p class="one">报价：</p>
                                        <p class="two">￥<span>576675765</span></p>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="divUserInfo">
                            	<div class="one">
                                	<span class="name">凤凰传奇</span>
                                    <!--<a class="approveNo" title="未实名认证"></a>-->
                                    <!--<a class="approveHave" title="个人实名认证"></a>-->
                                    <a class="approveQy" title="企业实名认证"></a>
                                </div>
                            	<div class="two">
                                	<a class="age" title="年龄">20岁</a>
                                    <a class="address" title="工作地"><span>上海</span><span>嘉定</span></a>
                                </div>
                            	<div class="three"><div class="job" title="职业"><span>时装摄影师</span><a></a></div>
                                </div>
                                <div class="four"><a class="view" title="浏览次数">2045</a></div>
                            </div>
                        </li>
                        <!--已报价-->
                        
                        <!--已报价-->
                        <li class="lilist">
                        	<div class="divImg">
                                <img src="${pageContext.request.contextPath}/public/pic/head/5.png"/>
                                <div class="divBackGround">
                                    <div class="opacity"></div>
                                    <div class="info">
                                        <p class="one">报价：</p>
                                        <p class="two">￥<span>576675765</span></p>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="divUserInfo">
                            	<div class="one">
                                	<span class="name">凤凰传奇</span>
                                    <!--<a class="approveNo" title="未实名认证"></a>-->
                                    <a class="approveHave" title="个人实名认证"></a>
                                   <!-- <a class="approveQy" title="企业实名认证"></a>-->
                                </div>
                            	<div class="two">
                                	<a class="age" title="年龄">20岁</a>
                                    <a class="address" title="工作地"><span>上海</span><span>嘉定</span></a>
                                </div>
                            	<div class="three"><div class="job" title="职业"><span>时装摄影师</span><a></a></div>
                                </div>
                                <div class="four"><a class="view" title="浏览次数">2045</a></div>
                            </div>
                        </li>
                        <!--已报价-->
                        
                        
                        <div style="clear:both;"></div>
                    </ul>
                    
                    
                    <!--翻页-->
                    <div class="ppointPagingthis">
                        <div class="ppointPaging">            
                            <table class="tablePpointPaging">
                                    <tr>
                                        <td class="ppointPagingOne"><a href="javascript:"></a></td>
                                        <td class="ppointPagingPre"><a href="javascript:"></a></td>
                                        <td class="ppointPagingN"><a href="javascript:">1</a></td>
                                        <td class="ppointPagingN"><a href="javascript:">2</a></td>
                                        <td class="ppointPagingN"><a href="javascript:">3</a></td>
                                        <td class="ppointPagingN"><a href="javascript:">4</a></td>
                                        <td class="ppointPagingN"><a href="javascript:">5</a></td>
                                        <td class="ppointPagingN"><a href="javascript:">6</a></td>
                                        <td class="ppointPagingN"><a href="javascript:">7</a></td>
                                        <td class="ppointPagingN"><a href="javascript:">8</a></td>
                                        <td class="ppointPagingN"><a href="javascript:">9</a></td>
                                        <td class="ppointPagingN"><a href="javascript:">10</a></td>
                                        <td class="ppointPagingNext"><a href="javascript:"></a></td>
                                        <td class="ppointPagingLast"><a href="javascript:"></a></td>
                                    </tr>
                                </table>
                        </div>
                    </div>
                    <!--翻页-->
                </div>
                
                
                <div class="divList" id="divListThree">
                	<div class="divsx">
                    	<ul id="divsxTwo">
                            <li class="active">新应约作品</li>
                            <li>全部应约作品</li>
                            <li>不选的作品</li>
                       	 	<div style="clear:both;"></div>
                        </ul>
                    </div>
                    <ul id="divListOneUl">
                        <li class="lilistOnly">
                            <img src="${pageContext.request.contextPath}/public/pic/2.png"/>
                        </li>
                        <li class="lilistOnly">
                            <img src="${pageContext.request.contextPath}/public/pic/2.png"/>
                        </li>
                        <li class="lilistOnly">
                            <img src="${pageContext.request.contextPath}/public/pic/2.png"/>
                        </li>
                        <li class="lilistOnly">
                            <img src="${pageContext.request.contextPath}/public/pic/2.png"/>
                        </li>
                        <li class="lilistOnly">
                            <img src="${pageContext.request.contextPath}/public/pic/2.png"/>
                        </li>
                        <li class="lilistOnly">
                            <img src="${pageContext.request.contextPath}/public/pic/2.png"/>
                        </li>
                        <li class="lilistOnly">
                            <img src="${pageContext.request.contextPath}/public/pic/2.png"/>
                        </li>
                        <li class="lilistOnly">
                            <img src="${pageContext.request.contextPath}/public/pic/2.png"/>
                        </li>
                        <li class="lilistOnly">
                            <img src="${pageContext.request.contextPath}/public/pic/2.png"/>
                        </li>
                        <li class="lilistOnly">
                            <img src="${pageContext.request.contextPath}/public/pic/2.png"/>
                        </li>
                        <li class="lilistOnly">
                            <img src="${pageContext.request.contextPath}/public/pic/2.png"/>
                        </li>
                        
                        
                        
                        
                        
                        <div style="clear:both;"></div>
                    </ul>
                    
                    
                    <!--翻页-->
                    <div class="ppointPagingthis">
                        <div class="ppointPaging">            
                            <table class="tablePpointPaging">
                                    <tr>
                                        <td class="ppointPagingOne"><a href="javascript:"></a></td>
                                        <td class="ppointPagingPre"><a href="javascript:"></a></td>
                                        <td class="ppointPagingN"><a href="javascript:">1</a></td>
                                        <td class="ppointPagingN"><a href="javascript:">2</a></td>
                                        <td class="ppointPagingN"><a href="javascript:">3</a></td>
                                        <td class="ppointPagingN"><a href="javascript:">4</a></td>
                                        <td class="ppointPagingN"><a href="javascript:">5</a></td>
                                        <td class="ppointPagingN"><a href="javascript:">6</a></td>
                                        <td class="ppointPagingN"><a href="javascript:">7</a></td>
                                        <td class="ppointPagingN"><a href="javascript:">8</a></td>
                                        <td class="ppointPagingN"><a href="javascript:">9</a></td>
                                        <td class="ppointPagingN"><a href="javascript:">10</a></td>
                                        <td class="ppointPagingNext"><a href="javascript:"></a></td>
                                        <td class="ppointPagingLast"><a href="javascript:"></a></td>
                                    </tr>
                                </table>
                        </div>
                    </div>
                    <!--翻页-->
                </div>
                
                
                <div class="divList" id="divListFour">
                	<div class="divsx">
                    	<ul id="divsxThree">
                            <li class="active">新应约作品</li>
                            <li>全部应约作品</li>
                            <li>不选的作品</li>
                       	 	<div style="clear:both;"></div>
                        </ul>
                    </div>
                    <ul id="divListOneUl">
                        <li class="lilistOnly">
                            <img src="${pageContext.request.contextPath}/public/pic/2.png"/>
                        </li>
                        <li class="lilistOnly">
                            <img src="${pageContext.request.contextPath}/public/pic/2.png"/>
                        </li>
                        <li class="lilistOnly">
                            <img src="${pageContext.request.contextPath}/public/pic/2.png"/>
                        </li>
                        <li class="lilistOnly">
                            <img src="${pageContext.request.contextPath}/public/pic/2.png"/>
                        </li>
                        <li class="lilistOnly">
                            <img src="${pageContext.request.contextPath}/public/pic/2.png"/>
                        </li>
                        <li class="lilistOnly">
                            <img src="${pageContext.request.contextPath}/public/pic/2.png"/>
                        </li>
                        <li class="lilistOnly">
                            <img src="${pageContext.request.contextPath}/public/pic/2.png"/>
                        </li>
                        <li class="lilistOnly">
                            <img src="${pageContext.request.contextPath}/public/pic/2.png"/>
                        </li>
                        <li class="lilistOnly">
                            <img src="${pageContext.request.contextPath}/public/pic/2.png"/>
                        </li>
                        <li class="lilistOnly">
                            <img src="${pageContext.request.contextPath}/public/pic/2.png"/>
                        </li>
                        <li class="lilistOnly">
                            <img src="${pageContext.request.contextPath}/public/pic/2.png"/>
                        </li>
                        
                        
                        
                        
                        
                        <div style="clear:both;"></div>
                    </ul>
                    
                    
                    <!--翻页-->
                    <div class="ppointPagingthis">
                        <div class="ppointPaging">            
                            <table class="tablePpointPaging">
                                    <tr>
                                        <td class="ppointPagingOne"><a href="javascript:"></a></td>
                                        <td class="ppointPagingPre"><a href="javascript:"></a></td>
                                        <td class="ppointPagingN"><a href="javascript:">1</a></td>
                                        <td class="ppointPagingN"><a href="javascript:">2</a></td>
                                        <td class="ppointPagingN"><a href="javascript:">3</a></td>
                                        <td class="ppointPagingN"><a href="javascript:">4</a></td>
                                        <td class="ppointPagingN"><a href="javascript:">5</a></td>
                                        <td class="ppointPagingN"><a href="javascript:">6</a></td>
                                        <td class="ppointPagingN"><a href="javascript:">7</a></td>
                                        <td class="ppointPagingN"><a href="javascript:">8</a></td>
                                        <td class="ppointPagingN"><a href="javascript:">9</a></td>
                                        <td class="ppointPagingN"><a href="javascript:">10</a></td>
                                        <td class="ppointPagingNext"><a href="javascript:"></a></td>
                                        <td class="ppointPagingLast"><a href="javascript:"></a></td>
                                    </tr>
                                </table>
                        </div>
                    </div>
                    <!--翻页-->
                </div>
            </div>
        </div>
        
        <div id="divApointProjectRight">
        	<!-- 操作 -->
        	<div class="operate">
            	<div class="previousPage">
                	<a href="javascript:">
                    	<div class="backimg"></div>
                        <p>返回上一页</p>
                    </a>
                </div>
                
                <div class="release">
                	<a href="../relProjectChoose.html">
                    	<div class="backimg"></div>
                        <p>发布新约拍</p>
                    </a>
                </div>
                
                <div class="preNext">
                	<div class="pre"><a href="javascript:"><i></i><span>上一个</span></a></div>
                    <div class="next"><a href="javascript:"><i></i><span>下一个</span></a></div>
                </div>
            </div>
          <!-- 操作 -->
          
         <div id="rightDetail">
         <!--发布人信息 无人应约状态-->
        	<div class="projectInfo">
            	
            	<div class="filtrate">
               		<input class="white_button" type="button" value="邀请其他人"/>
                </div>
                
                <div class="option">
               		<a class="edit" href="javascript:">编辑约拍</a>
               		<a class="del" href="javascript:">删除约拍</a>
                </div>
            
          	</div>
       
        <!--发布人信息 无人应约状态-->      
        
        <!--发布人信息 有人应约状态-->
        	<div class="projectInfo">
            	<div class="choose_person">
                	<span class="">可选作品：</span>
                	<span class="">134人，</span>
                	<span class="">已选24件</span>
                </div>
                
            	<div class="filtrate">
               		<input class="white_button" type="button" value="邀请其他人"/>
					<input class="red_button" type="button" value="筛选应约作品" onclick="hideDE();"/>
                </div>
                
                <div class="option">
               		<a class="del" href="javascript:">删除约拍</a>
                </div>
            
          	</div>
       
        <!--发布人信息 有人应约状态-->  
          
          
        <!--交付日期已过 -->
        	<div class="projectInfo">
            	<div class="project_detailico">
                    <div class="ico"></div>
                    <div class="icov">征集已完成</div>
                    <div class="complaint"><a class="del" href="javascript:">删除约拍</a></div>
                </div>
            
                
          	</div>
        <!--交付日期已过-->  
        
        </div>  
        
        
        
        <div id="rightFiltrate" style="display:none;">
         <!--发布人信息 无人应约状态-->
        	<div class="projectInfo">
            	
            	<div class="filtrate">
               		<input class="white_button" type="button" value="邀请其他人"/>
                    
               		<a class="del" href="javascript:">删除约拍</a>
                </div>
                
            
          	</div>
       
        <!--发布人信息 无人应约状态-->      
        
        <div class="projectInfoDe" onclick="showDetail();">
            <div class="ico"></div>
            <div>项目详情</div>
                
        </div>
            
        
        <!--发布人信息 有人应约状态-->
        	<div class="projectInfo">
            	<div class="choose_person">
                	<span class="">可选作品：</span>
                	<span class="">134人，</span>
                	<span class="">已选24件</span>
                </div>
                
            	<div class="filtrate">
               		<input class="white_button" type="button" value="邀请其他人"/>
                </div>
                
                <div class="option">
               		<a class="del" href="javascript:">删除约拍</a>
                </div>
            
          	</div>
       
        <!--发布人信息 有人应约状态-->  
          
          
        <!--交付日期已过 -->
        	<div class="projectInfo">
            	<div class="project_detailico">
                    <div class="ico"></div>
                    <div class="icov">征集已完成</div>
                    <div class="complaint"><a class="answer" href="javascript:">我有问题</a></div>
                </div>
            
                <div class="project_detailt">
                    <div class="project_one">
                		<span class="spano">该项目总支出：</span>
                		<span>3324</span>元
                	</div>
                </div>
                
            	<div class="filtrate">
					<input class="white_button" type="button" value="查看中标者"/>
                </div>
          	</div>
        <!--交付日期已过-->  
        
        </div>
        
    </div>
	
  </div>  
    
        
        
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
</div>
<!--[if lte IE 6]>
<script src="${pageContext.request.contextPath}/public/js/DD_belatedPNG_0.0.8a.js" type="text/javascript"></script>
    <script type="text/javascript">
        DD_belatedPNG.fix('div, ul, img, li, input , a , i');
    </script>
<![endif]-->




</body>
</html>

