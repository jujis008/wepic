<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib  prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
  <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="shortcut icon" href="${pageContext.request.contextPath}/public/images/logoSmall.ico"/>

<title>wepic管理_个人中心_我的作品库_管理专辑</title>

<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/jquery.js"></script>

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/back/personalCentr/myworklib/css/manageSpecial.css" />
<!--公共js-->
<script type="text/javascript" src="${pageContext.request.contextPath}/back/js/publicBack.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/public.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/topBar.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/header.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/back/personalCentr/myworklib/js/manageSpecial.js"></script>
<!--公共css-->
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/back//pubimg/css/backMainBar.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public/css/topBarMain.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public/css/header.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public/css/footer.css" />

<script>
window.onload = function(){
	document.getElementById("formmanageSpecial").reset();
	}







</script>
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
            
            <a href="<%=basePath %>publish!findAllMyLib.do"><div class='bar'><span>图片作品</span><i></i></div></a>
            
            <a href="<%=basePath %>story!storylist.do"><div class='bar active'><span>摄影故事</span><i></i></div></a>
            
            <a href="javascript:"><div class='bar'><span>视频作品</span><i></i></div></a>
            
            <a href="${pageContext.request.contextPath}/back/personalCentr/myworklib/workUpload.jsp"><div class='bar'><span>上传作品</span><i></i></div></a>
            
            <a href="<%=basePath %>story!initdata.do"><div class='bar'><span>创建故事</span><i></i></div></a>
            
            <a href="${pageContext.request.contextPath}/back/personalCentr/myworklib/chooseRelWork.jsp"><div class='bar'><span>发布作品</span><i></i></div></a>
        </div>
        </div>
    </div>
    <!-- 导航  end-->
    
    <!--内容-->
    <form id="formmanageSpecial">
    
    <div id="manageSpecial">
    	<div class="head">
        	<div class="left">
            	<span class="glzj">管理专辑数</span>
            	当前专辑<span class="num" id="specialNum">23</span>个
            </div>
            
            <input class="inputup" type="button" value="返回上一页">
        </div>
    
    	<div class="editSpecial">
        	<div class="divAdd" id="diveditSpecial">
            <ul>
            	<li id="">
                	<div class="special">
                		<div class="tone tone1"></div>
                    	<div class="name">默认专辑</div>
                	</div>
                    <div class="edit"><a class="px">排序</a></div>
                </li>
                
               
                
                <s:iterator value="myUnderCatList">
                
                 
            	<li id="<s:property value="id"/>">
                	<div class="special">
                		<div class="tone tone2" style="background-color:<s:property value="icon"/>"></div>
                    	<div class="name"><s:property value="name"/> </div>
                    	
                	</div>
                    <div class="edit">
                    	<a href="javascript:" class="bj" onclick="editzj('divEditZj');">编辑</a>
                        <a class="px">排序</a>
                   	</div>
                </li>
                
                </s:iterator>
            	
            </ul>
            	
                
                
                <div class="divAddSpecial">
                	<!-- 
                	<a href="javascript:" onclick="editzj('divAddZj');">添加专辑</a>
                	 -->
                	 <a href="javascript:" onclick="addzj('divAddZj');">添加专辑</a>
                </div>
            </div>
            
            
            
            
            
            <!--默认显示-->
            <div class="diveddel" id="diveddelAll">
            <ul>
            	<li class="click">
                	<div class="divCon divCon1" id="displaySp">
                		<div class="divCont">
                			<h2 title="这里显示专辑名称" alt="这里显示专辑名称" id="displayDefault">默认专辑</h2>
                    		<div class="ms">默认专辑</div>
                			<div class="time"><span id="specialTime">2010-03-26</span></div>
                		</div>
                	</div>              	
                	<div class="divOpt" style="display: none" id="editeSp">
               			<input class="del" type="button" value="删除" onclick="deletePic(this)"/>
						<input class="edit" type="button" value="编辑" onclick="editzj('divEditZj');"/>
                	</div>
                	
                	
                </li>
                
                          </ul>
            	
                
            </div>
           <!--默认显示-->
           
           
           <!--新建专辑-->
            <div class="divEditZj" id="divAddZj">
            	<div class="divEditZjHead">新建专辑</div>
                <div class="zjname">
                	<span class="left">专辑名称</span>
                    <input class="inputname" type="text" id="textname2" name="name">
                </div>
                <div id="promptname2" class="promptInf">
                    
                </div>
                <div class="zjintro">
                	<span class="left">专辑说明</span>
                	<textarea id="textarezjsm2" name="discription"></textarea>
                	<input type="hidden" name="icon" id="icon" value="rgb(230, 82, 82)"/>
                	<input type="hidden" name="enName" id="enName" value="color1"/>
                </div>
                <div id="promptzjsm2" class="promptInf">                                                               
                </div>
                
                <div class="zjcolor">
                	<div>专辑颜色标识</div>
                    <div class="addColor" id="chooseColorb2">
                    	<ul>
                        	<li class="color1 active"><i></i></li><li class="color2"><i></i></li><li class="color3"><i></i></li><li class="color4"><i></i></li><li class="color5"><i></i></li><li class="color6"><i></i></li><li class="color7"><i></i></li>
                        	<li class="color8"><i></i></li><li class="color9"><i></i></li><li class="color10"><i></i></li><li class="color11"><i></i></li><li class="color12"><i></i></li><li class="color13"><i></i></li><li class="color14"><i></i></li>
                        	<li class="color15"><i></i></li><li class="color16"><i></i></li><li class="color17"><i></i></li><li class="color18"><i></i></li><li class="color19"><i></i></li><li class="color20"><i></i></li><li class="color21"><i></i></li>
                        	
                        
                        </ul>
                    
                    </div>
                    <div id="promptzjcolor2" class="promptInf">
                    
               	 	</div>
                </div>
                
                <div class="zjsubmit">
               		<input class="qx" type="button" value="取消"  onclick="resetzj(this);">
					<input class="bc" type="button" value="保存" onclick="saveSpecial();">
                
                </div>
            </div>
           <!--新建专辑-->
           
           <!--编辑专辑-->
            <div class="divAddZj" id="divEditZj">
            	<div class="divEditZjHead">编辑专辑</div>
                <div class="zjname">
                	<span class="left">专辑名称</span>
                    <input class="inputname" type="text" id="textnamespe">
                    <input class="inputname" type="hidden" id="spid">
                    <input class="inputname" type="hidden" id="enNameed">
                    <input class="inputname" type="hidden" id="iconed">
                </div>
                <div id="promptname" class="promptInf">
                    
                </div>
                <div class="zjintro">
                	<span class="left">专辑说明</span>
                	<textarea id="textarezjsmspe"></textarea>
                </div>
                <div id="promptzjsm" class="promptInf">
                    
                </div>
                <div class="zjcolor">
                	<div>专辑颜色标识</div>
                    <div class="addColor" id="chooseColorb">
                    	<ul>
                        	<li class="color1"><i></i></li><li class="color2"><i></i></li><li class="color3"><i></i></li><li class="color4"><i></i></li><li class="color5"><i></i></li><li class="color6"><i></i></li><li class="color7"><i></i></li>
                        	<li class="color8"><i></i></li><li class="color9"><i></i></li><li class="color10"><i></i></li><li class="color11"><i></i></li><li class="color12"><i></i></li><li class="color13"><i></i></li><li class="color14"><i></i></li>
                        	<li class="color15"><i></i></li><li class="color16"><i></i></li><li class="color17"><i></i></li><li class="color18"><i></i></li><li class="color19"><i></i></li><li class="color20"><i></i></li><li class="color21"><i></i></li>
                        	
                        
                        </ul>
                    
                    </div>
                    <div id="promptzjcolor" class="promptInf">
                    
               	 	</div>
                </div>
                
                <div class="zjsubmit">
               		<input class="qx" type="button" value="取消" onclick="resetzj(this);">
					<input class="bc" type="button" value="保存" onclick="editeSpecial();">
                
                </div>
            </div>
           <!--编辑专辑-->
           
        </div>
    
    </div>
    
    
    </form>
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
</div>
<!--[if lte IE 6]>
<script src="${pageContext.request.contextPath}/public/js/DD_belatedPNG_0.0.8a.js" type="text/javascript"></script>
    <script type="text/javascript">
        DD_belatedPNG.fix('div, ul, img, li, input , a , i');
    </script>
<![endif]-->


</body>

<script type="text/javascript">
$(function(){
   $("#specialNum").html($("#diveditSpecial").find("li").length);
});


//rrr
  function saveSpecial(){

	if($("#textname2").val()==null||$.trim($("#textname2").val())==""){
		$("#promptname2").html("<span style='color:red'>专辑名称不能为空</span>")
		return;
	}
	if($.trim($("#textname2")).length<=0||$.trim($("#textname2")).length>16){
		$("#promptname2").html("<span style='color:red'>专辑名称1-8个汉字</span>")
		return;
	}
	  $.ajax({
	      type:"Post",
		  url: "specialcat_savestoryspecial.do",
		  data:"name="+$("#textname2").val()+"&discription="+$("#textarezjsm2").val()+"&icon="+$("#icon").val()+"&enName="+$("#enName").val(),		
		  success : function(data) {
			  var cat=data.specialCat;
			  if(cat.title=='suc'){
				  window.location.reload();	
				  var html='<li class=""><div class="special active"><div class="tone tone2" style="background-color:'+cat.icon+'"></div><div class="name">'+cat.name+' </div></div><div class="edit">'+
	              	'<a onclick=editzj("divEditZj"); class="bj" href="javascript:">编辑</a><a class="px">排序</a></div></li>';
	               $("#diveditSpecial ul").append(html);
	              // tabControl2("diveditSpecial","diveddelAll");
		              

				  }
			  else if(cat.title=='error'){
				  alert('添加专辑失败');
				  }
			  else if(cat.title=='login'){
				  alert("您的登录时效已过请重新登录");
                  window.location.href="${pageCOntext.request.contextPath}/back/loginRegister/login.jsp";

				  }
			

			  
		  }
	});




	
 }

  function editeSpecial(){
	  $("#promptname").html("");
	  if($("#textnamespe").val()==null||$.trim($("#textnamespe").val())==""){
			$("#promptname").html("<span style='color:red'>专辑名称不能为空</span>")
			return;
		}
		if($.trim($("#textnamespe").val()).length<=0||$.trim($("#textnamespe").val()).length>8){
			$("#promptname").html("<span style='color:red'>专辑名称不能超过8个汉字</span>")
			return;
			}
	  $.ajax({
	      type:"Post",
		  url: "specialcat_editeSpecial.do",
		  data:"id="+$("#spid").val()+"&name="+$("#textnamespe").val()+"&discription="+$("#textarezjsmspe").val()+"&icon="+$("#iconed").val()+"&enName="+$("#enNameed").val(),		
		  success : function(data) {
			  var cat=data.specialCat;
			  if(cat.title=='suc'){
				  window.location.reload();	
				  }
			  else if(cat.title=='error'){
				  alert('修改专辑失败');
				  }
			  else if(cat.title=='login'){
				  alert("您的登录时效已过请重新登录");
                  window.location.href="${pageCOntext.request.contextPath}/back/loginRegister/login.jsp";

				  }
			

			  
		  }
	});
  }
function deletePic(obj){
	if(!confirm("您确定要删除此张专辑")){
      return;
		}
	// alert($(obj).parents("li").attr("id"));
$.ajax({
    type:"Post",
	  url: "specialcat_deleteSpPic.do",
	  data:"id="+$(obj).parents("li").attr("id"),
	  success : function(data) {
		  var cat=data.specialCat;
		  if(cat.title=='suc'){
			  window.location.reload();	
			  }
		  else if(cat.title=='hasPic'){
			  alert('请先清除作品,在删除专辑');
			  }
		  else if(cat.title=='error'){
			  alert('删除专辑失败');
			  }
		  else if(cat.title=='login'){
			  alert("您的登录时效已过请重新登录");
            window.location.href="${pageCOntext.request.contextPath}/back/loginRegister/login.jsp";

			  }
		

		 //  window.location.href="${pageContext.request.contextPath}/specialPublish!deleteSpPic.do"
	  }
});



	
}

</script>


</html>
