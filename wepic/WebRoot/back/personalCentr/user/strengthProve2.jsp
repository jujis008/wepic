<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="shortcut icon" href="${pageContext.request.contextPath}//public/images/logoSmall.ico"/>
<meta name="robots" content="index,follow" />

<title>wepic管理 个人中心 账户基本资料 实力证明</title>

<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/back/personalCentr/user/js/strengthProve.js"></script>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/back/personalCentr/user/css/strengthProve.css" />
<!--公共js-->
<script type="text/javascript" src="${pageContext.request.contextPath}/back/js/publicBack.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/public.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/topBar.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/header.js"></script>
<script type="text/javascript" src='${pageContext.request.contextPath}/back/js/jquery.slider.js'></script>
<!--公共css-->
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public/css/backMainBar.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public/css/topBarMain.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}//public/css/public.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public/css/header.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public/css/footer.css" />

<script>



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
        </div>
	</div>
    
	<!-- logo行 end-->
	
     <!-- 导航 -->
  	<div id="assistantBar">
    	<div class="twoStage" id="divTwoStage">
        	<a href="javascript:"><div class='bar'><span>首页</span><i></i></div></a>
            
            <a href="javascript:"><div class='bar active'><span>账户基本资料</span><i></i></div></a>
            
            <a href="javascript:"><div class='bar'><span>我的作品库</span><i></i></div></a>
            
            <a href="javascript:"><div class='bar'><span>我的约拍</span><i></i></div></a>
            
            <a href="javascript:"><div class='bar'><span>我买到的作品</span><i></i></div></a>
            
           <a href="javascript:"> <div class='bar'><span>收藏/订阅/推荐</span><i></i></div></a>
        </div>
    	
        <div id="divThreeStage">
        
        <div class="threeStage">
        	<a href="javascript:"><div class='bar'><span>个人资料</span><i></i></div></a>
            
            <a href="javascript:"><div class='bar'><span>修改头像</span><i></i></div></a>
            
            <a href="javascript:"><div class='bar'><span>教育情况</span><i></i></div></a>
            
            <a href="javascript:"><div class='bar active'><span>实力证明</span><i></i></div></a>
            
            <a href="javascript:"><div class='bar'><span>我的标签</span><i></i></div></a>
            
            <a href="javascript:"><div class='bar'><span>个人等级</span><i></i></div></a>
            
        </div>
        </div>
    </div>
    <!-- 导航  end-->
    
    <!--内容-->
    
    <!--代表作品-->
    <div id="divMyRepresentative">
   		<div class="head">
        	<h2>我的代表品作</h2>
        </div>
        
        <div class="cont">
        	<div class="pic" id="divMyReHead">
            	<ul>
                	<!--摄影故事-->
                	<li>
                    	<div class="img"><a href="javascript:"><img src="${pageContext.request.contextPath}/back/pubimg/pic/2.png" /></a></div>
                        <div class="story">
                        	<p class="p1" title="标题全称">摄影故事名称摄影故事名称摄影故事名称</p>
                            <p class="p2"  title="标题内容">摄影故事内容摄影故事内容摄影故事内容摄影故事内容</p>
                        </div>
                    </li>
                    <!--摄影故事-->
                    
                    <!--项目-->
                    <li>
                    	<div class="img"><img src="${pageContext.request.contextPath}/back/pubimg/pic/2.png" /></div>
                        <div class="pro">
                        	<div class="bj"></div>
                       	 	
                        	<div class="bjc">
                            	<div class="view"><i class="ed"></i></div>
                                <div class="edit">
                                	<a href="javascript:" class="del">删除</a>
                					<a href="javascript:" class="edi">编辑</a>
                                </div>
                            </div>
                        </div>
                    </li>
                    <!--项目-->
                    
                    <!--摄影故事-->
                	<li>
                    	<div class="img"><a href="javascript:"><img src="${pageContext.request.contextPath}/back/pubimg/pic/2.png" /></a></div>
                        <div class="story">
                        	<p class="p1" title="标题全称">摄影故事名称摄影故事名称摄影故事名称</p>
                            <p class="p2"  title="标题内容">摄影故事内容摄影故事内容摄影故事内容摄影故事内容</p>
                        </div>
                    </li>
                    <!--摄影故事-->
                    
                    <!--项目-->
                    <li>
                    	<div class="img"><img src="${pageContext.request.contextPath}/back/pubimg/pic/2.png" /></div>
                        <div class="pro">
                        	<div class="bj"></div>
                       	 	
                        	<div class="bjc">
                            	<div class="view"><i class="ed"></i></div>
                                <div class="edit">
                                	<a href="javascript:" class="del">删除</a>
                					<a href="javascript:" class="edi">编辑</a>
                                </div>
                            </div>
                        </div>
                    </li>
                    <!--项目-->
                    
                    <!--摄影故事-->
                	<li>
                    	<div class="img"><a href="javascript:"><img src="${pageContext.request.contextPath}/back/pubimg/pic/2.png" /></a></div>
                        <div class="story">
                        	<p class="p1" title="标题全称">摄影故事名称摄影故事名称摄影故事名称</p>
                            <p class="p2"  title="标题内容">摄影故事内容摄影故事内容摄影故事内容摄影故事内容</p>
                        </div>
                    </li>
                    <!--摄影故事-->
                    
                    <!--项目-->
                    <li>
                    	<div class="img"><img src="${pageContext.request.contextPath}/back/pubimg/pic/2.png" /></div>
                        <div class="pro">
                        	<div class="bj"></div>
                       	 	
                        	<div class="bjc">
                            	<div class="view"><i class="ed"></i></div>
                                <div class="edit">
                                	<a href="javascript:" class="del">删除</a>
                					<a href="javascript:" class="edi">编辑</a>
                                </div>
                            </div>
                        </div>
                    </li>
                    <!--项目-->
                    
                    <!--摄影故事-->
                	<li>
                    	<div class="img"><a href="javascript:"><img src="${pageContext.request.contextPath}/back/pubimg/pic/2.png" /></a></div>
                        <div class="story">
                        	<p class="p1" title="标题全称">摄影故事名称摄影故事名称摄影故事名称</p>
                            <p class="p2"  title="标题内容">摄影故事内容摄影故事内容摄影故事内容摄影故事内容</p>
                        </div>
                    </li>
                    <!--摄影故事-->
                    
                    <!--项目-->
                    <li>
                    	<div class="img"><img src="${pageContext.request.contextPath}/back/pubimg/pic/2.png" /></div>
                        <div class="pro">
                        	<div class="bj"></div>
                       	 	
                        	<div class="bjc">
                            	<div class="view"><i class="ed"></i></div>
                                <div class="edit">
                                	<a href="javascript:" class="del">删除</a>
                					<a href="javascript:" class="edi">编辑</a>
                                </div>
                            </div>
                        </div>
                    </li>
                    <!--项目-->
                    
                    <!--摄影故事-->
                	<li>
                    	<div class="img"><a href="javascript:"><img src="${pageContext.request.contextPath}/back/pubimg/pic/2.png" /></a></div>
                        <div class="story">
                        	<p class="p1" title="标题全称">摄影故事名称摄影故事名称摄影故事名称</p>
                            <p class="p2"  title="标题内容">摄影故事内容摄影故事内容摄影故事内容摄影故事内容</p>
                        </div>
                    </li>
                    <!--摄影故事-->
                    
                    <!--项目-->
                    <li>
                    	<div class="img"><img src="${pageContext.request.contextPath}/back/pubimg/pic/2.png" /></div>
                        <div class="pro">
                        	<div class="bj"></div>
                       	 	
                        	<div class="bjc">
                            	<div class="view"><i class="ed"></i></div>
                                <div class="edit">
                                	<a href="javascript:" class="del">删除</a>
                					<a href="javascript:" class="edi">编辑</a>
                                </div>
                            </div>
                        </div>
                    </li>
                    <!--项目-->
                    
                    <!--摄影故事-->
                	<li>
                    	<div class="img"><a href="javascript:"><img src="${pageContext.request.contextPath}/back/pubimg/pic/2.png" /></a></div>
                        <div class="story">
                        	<p class="p1" title="标题全称">摄影故事名称摄影故事名称摄影故事名称</p>
                            <p class="p2"  title="标题内容">摄影故事内容摄影故事内容摄影故事内容摄影故事内容</p>
                        </div>
                    </li>
                    <!--摄影故事-->
                    
                    <!--项目-->
                    <li>
                    	<div class="img"><img src="${pageContext.request.contextPath}/back/pubimg/pic/2.png" /></div>
                        <div class="pro">
                        	<div class="bj"></div>
                       	 	
                        	<div class="bjc">
                            	<div class="view"><i class="ed"></i></div>
                                <div class="edit">
                                	<a href="javascript:" class="del">删除</a>
                					<a href="javascript:" class="edi">编辑</a>
                                </div>
                            </div>
                        </div>
                    </li>
                    <!--项目-->
                	
                    <div style="clear:both;"></div>
                </ul>
            </div>
        </div>
        
        <div class="worksInfo">
        	<div class="one">
            	<span class="cha">作&nbsp;品&nbsp;名：</span>
                <span class="name">这里写作品的名称</span>
                <span class="cha">创作年份：</span>
                <span class="year"><span>2006</span><font>年</font></span>
                <span class="cha">作品类型：</span>
                <span class="type">图片</span>
            </div>
            <div class="two">
            	<span class="cha">作品说明：</span>
                <span class="intt">这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写</span>
            </div>
            
            
            
            <input type="button" value="添加作品代表" class="add" onclick="openPopUpBox('divMyRePop');"/>
        </div>
        
        <div class="divbotton"><span>如需修改作品缩略图，请进入到<a href="javascript:">我的作品库</a>进行编辑</span></div>
    </div>
    <!--代表作品-->
    
    <!--代表作品弹出框-->
    <div class="rework" id="divMyRePop">
    	<div class="top">
    		<h2>添加代表作品</h2>
			<a href="javascript:cloosePopBox('divMyRePop');"></a>
    	</div>    
    	<div class="workAbstractRe">
    		<div class="name">
				<span class="leftname wname">作品名：</span>
				<input class="inputworkname" type="text">
			</div>
            <div class="type">
				<span class="leftname">作品类型：</span>
				<div class="editSelect" id="divWorkType" >
                    	<div class="viewBelow" onclick="showBelow('divSelectWorkTypeValue')" id="viewBelowWorkType">
                        	<div id="selectWorkTypeValue"></div>
                       		<div class="viewBelowRight" id="viewBelowRightWorkType"><i></i></div>    
                    	</div>
                           
                    	<div  class="belowValue" id="divSelectWorkTypeValue" style="display:none;">
                        	<span class='selectValueIn'>请选择</span>
                        	<span class='selectValueIn'>图片作品</span>
                            <span class='selectValueIn'>摄影故事</span>
 						</div>
            	</div>
                
                <span class="creYear">创作年份：</span>
				<div class="editSelect" id="divCreYear" >
                    	<div class="viewBelow" onclick="showBelow('divSelectCreYearValue')" id="viewBelowCreYear">
                        	<div id="selectCreYearValue"></div>
                       		<div class="viewBelowRight" id="viewBelowRightCreYear"><i></i></div>    
                    	</div>
                           
                    	<div class="belowValue" id="divSelectCreYearValue" style="display:none;">
                        	<span class='selectValueIn'>请选择</span>
 						</div>
            	</div>
                
			</div>
    	</div>
    	<div class="chooseWork">
    		<div class="butcho">
            	<input class="inpchoose" type="button" value="选择作品" onclick="changeBox('divMyRePop');"/>
                <!--<a href="javascript:" class="pre"></a>
                <a href="javascript:" class="next"></a>-->
            </div>
            
            <!--代表作品-->
            <div class="slider-box slider-box1">
            	<a href='javascript:;' class="slider-prev slider-btn" title="上一张"></a>
        		<div class="checkPicHead slider-wrapper" id="divMyReWork">
            		<ul class='slider-move'>
                	
                	
                	<li>
                    	<div class="img"><img src="${pageContext.request.contextPath}/back/pubimg/pic/4.png" /></div>
                        <div class="nowtop">
                        	<div class="bj"></div>
                        	<div class="bjc">
                        	<a href="javascript:" class="del"></a></div>
                        </div>
                    </li>
                	<li>
                    	<div class="img"><img src="${pageContext.request.contextPath}/back/pubimg/pic/5.png" /></div>
                        <div class="nowtop">
                        	<div class="bj"></div>
                        	<div class="bjc">
                        	<a href="javascript:" class="del"></a></div>
                        </div>
                    </li>
                	<li>
                    	<div class="img"><img src="${pageContext.request.contextPath}/back/pubimg/pic/6.png" /></div>
                        <div class="nowtop">
                        	<div class="bj"></div>
                        	<div class="bjc">
                        	<a href="javascript:" class="del"></a></div>
                        </div>
                    </li>
                	<li>
                    	<div class="img"><img src="${pageContext.request.contextPath}/back/pubimg/pic/7.png" /></div>
                        <div class="nowtop">
                        	<div class="bj"></div>
                        	<div class="bjc">
                        	<a href="javascript:" class="del"></a></div>
                        </div>
                    </li>
                    <li>
                    	<div class="img"><img src="${pageContext.request.contextPath}/back/pubimg/pic/8.png" /></div>
                        <div class="nowtop">
                        	<div class="bj"></div>
                        	<div class="bjc">
                        	<a href="javascript:" class="del"></a></div>
                        </div>
                    </li>
                    
                    <li>
                    	<div class="img"><img src="${pageContext.request.contextPath}/back/pubimg/pic/9.png" /></div>
                        <div class="nowtop">
                        	<div class="bj"></div>
                        	<div class="bjc">
                        	<a href="javascript:" class="del"></a></div>
                        </div>
                    </li>
                	<li>
                    	<div class="img"><img src="${pageContext.request.contextPath}/back/pubimg/pic/7.png" /></div>
                        <div class="nowtop">
                        	<div class="bj"></div>
                        	<div class="bjc">
                        	<a href="javascript:" class="del"></a></div>
                        </div>
                    </li>
                    <li>
                    	<div class="img"><img src="${pageContext.request.contextPath}/back/pubimg/pic/5.png" /></div>
                        <div class="nowtop">
                        	<div class="bj"></div>
                        	<div class="bjc">
                        	<a href="javascript:" class="del"></a></div>
                        </div>
                    </li>
                	</ul>
            	</div>
            	<a href='javascript:;' class="slider-next slider-btn" title="下一张"></a>
            </div>
            <script>
		$(function(){
			$('.slider-box1').mySlider({  //参数可选,以下为默认参数
					speed: 300,
					direction: 'left', //  运动方向 可选 left,top
					prevClass: 'slider-prev',			//左边
					nextClass: 'slider-next',			//右边
					wrapperClass: 'slider-wrapper',
					moveClass: 'slider-move'
			});
		});
	</script>
        </div>    
        
        
        <div class="workIntro">
    		<span class="leftabstract">作品说明：</span>
            <textarea></textarea>
    	</div>
        
        <div class="submit">
        	<input class="reset" type="button" value="取消" onclick="cloosePopBox('divMyRePop');"/>
			<input class="sub" type="button" value="提交"/>
    	</div>
    </div>
    
    <div id="chooseWork" style="width:1000px;height:800px; display:none;">
    	<iframe name='child' style="border:0px;width:1000px;height:800px" src="${pageContext.request.contextPath}/back/personalCentr/publish/chooseWork.jsp"></iframe>
    </div>
    <!--代表作品弹出框-->
    
    
    <!--承接的代表性项目弹出框-->
    <div class="rework" id="divProjectPop">
    	<div class="top">
    		<h2>添加代表性项目</h2>
			<a href="javascript:cloosePopBox('divProjectPop');"></a>
    	</div>    
    	<div class="workAbstractRe workProAbstr">
    		<div class="name">
				<span class="leftname">项目名称：</span>
				<input class="inputworkname" type="text">
			</div>
            <div class="type">
				<span class="leftname">项目时间：</span>
                
				<input class="proYear" type="text">
                <span>年</span>
                <input class="proMonth" type="text">
                <span>月&nbsp;&nbsp;&nbsp;—</span>
                
                
                <input class="proYear ney" type="text">
                <span>年</span>
                <input class="proMonth nem" type="text">
                <span>月</span>
                
                
                <span class="sadd">地点</span>
                <input class="address" type="text">
                
			</div>
            
            <div class="workIntro">
    			<span class="leftabstract">项目介绍：</span>
            	<textarea></textarea>
    		</div>
            
            <div class="workIntro">
    			<span class="leftabstract">个人职责：</span>
            	<textarea></textarea>
    		</div>
            
            <div class="picPro">
    			<span class="spanp">项目图片/视频：</span>
    		</div>
    	</div>
    	<div class="chooseWork">
    		<div class="butcho">
            	<input class="inpchoose" type="button" value="选择作品" onclick="changeBox('divProjectPop');"/>
                <a href="javascript:" class="pre"></a>
                <a href="javascript:" class="next"></a>
            </div>
            
            <!--承接的代表性项目-->
            <div class="slider-box slider-box2">
            	<a href='javascript:;' class="slider-prev slider-btn" title="上一张"></a>
        		<div class="checkPicHead slider-wrapper" id="divReProject">
            		<ul class='slider-move'>
                	
                	
                	<li>
                    	<div class="img"><img src="${pageContext.request.contextPath}/back/pubimg/pic/4.png" /></div>
                        <div class="nowtop">
                        	<div class="bj"></div>
                        	<div class="bjc">
                        	<a href="javascript:" class="del"></a></div>
                        </div>
                    </li>
                	<li>
                    	<div class="img"><img src="${pageContext.request.contextPath}/back/pubimg/pic/5.png" /></div>
                        <div class="nowtop">
                        	<div class="bj"></div>
                        	<div class="bjc">
                        	<a href="javascript:" class="del"></a></div>
                        </div>
                    </li>
                	<li>
                    	<div class="img"><img src="${pageContext.request.contextPath}/back/pubimg/pic/6.png" /></div>
                        <div class="nowtop">
                        	<div class="bj"></div>
                        	<div class="bjc">
                        	<a href="javascript:" class="del"></a></div>
                        </div>
                    </li>
                	<li>
                    	<div class="img"><img src="${pageContext.request.contextPath}/back/pubimg/pic/7.png" /></div>
                        <div class="nowtop">
                        	<div class="bj"></div>
                        	<div class="bjc">
                        	<a href="javascript:" class="del"></a></div>
                        </div>
                    </li>
                    <li>
                    	<div class="img"><img src="${pageContext.request.contextPath}/back/pubimg/pic/8.png" /></div>
                        <div class="nowtop">
                        	<div class="bj"></div>
                        	<div class="bjc">
                        	<a href="javascript:" class="del"></a></div>
                        </div>
                    </li>
                    
                    <li>
                    	<div class="img"><img src="${pageContext.request.contextPath}/back/pubimg/pic/9.png" /></div>
                        <div class="nowtop">
                        	<div class="bj"></div>
                        	<div class="bjc">
                        	<a href="javascript:" class="del"></a></div>
                        </div>
                    </li>
                	<li>
                    	<div class="img"><img src="${pageContext.request.contextPath}/back/pubimg/pic/7.png" /></div>
                        <div class="nowtop">
                        	<div class="bj"></div>
                        	<div class="bjc">
                        	<a href="javascript:" class="del"></a></div>
                        </div>
                    </li>
                    <li>
                    	<div class="img"><img src="${pageContext.request.contextPath}/back/pubimg/pic/5.png" /></div>
                        <div class="nowtop">
                        	<div class="bj"></div>
                        	<div class="bjc">
                        	<a href="javascript:" class="del"></a></div>
                        </div>
                    </li>
                	</ul>
            	</div>
            	<a href='javascript:;' class="slider-next slider-btn" title="下一张"></a>
            </div>
            <script>
		$(function(){
			$('.slider-box2').mySlider({  //参数可选,以下为默认参数
					speed: 300,
					direction: 'left', //  运动方向 可选 left,top
					prevClass: 'slider-prev',			//左边
					nextClass: 'slider-next',			//右边
					wrapperClass: 'slider-wrapper',
					moveClass: 'slider-move'
			});
		});
	</script>
    	</div>
              
        <div class="submit">
        	<input class="reset" type="button" value="取消" onclick="cloosePopBox('divProjectPop');"/>
			<input class="sub" type="button" value="提交"/>
    	</div>
    </div>
    
    
    <!--承接的代表性项目弹出框-->
	
    <!--我的荣誉弹出框-->
    <div class="rework" id="divHonorPop">
    	<div class="top">
    		<h2>添加我的荣誉</h2>
			<a href="javascript:cloosePopBox('divHonorPop');"></a>
    	</div>    
    	<div class="workAbstractRe workHonorAbstr">
    		<div class="name">
				<span class="leftname">获奖作品名：</span>
				<input class="inputworkname" type="text">
			</div>
            <div class="awards">
				<span class="leftname">项目奖项：</span>
                
				<input class="inputawards ibputry" type="text">
                
                <span class="twospan">颁发组织：</span>
                
				<input class="inputissue ibputry" type="text">
                
			</div>
            
            <div class="awards">
				<span class="leftname">颁发时间：</span>
                
				<input class="inputtime ibputry" type="text">
                
                <span class="twospan">颁发地点：</span>
                
				<input class="inputadd ibputry" type="text">
                
			</div>
            
            <div class="awards">
				<span class="leftname">选择获奖作品：</span>
                
                <input type="checkbox" name="chooseCover" id="checkcov" class="chooseCover" value="chooseCover">
                <label for="chooseCover" class="labelcover">套图</label>
				
			</div>
            
    	</div>
    	<div class="chooseWork">
    		<div class="butcho">
            	<input class="inpchoose" type="button" value="选择作品" onclick="changeBox('divHonorPop');"/>
                <a href="javascript:" class="pre"></a>
                <a href="javascript:" class="next"></a>
            </div>
            
            <!--我的荣誉-->
            <div class="slider-box slider-box3">
            	<a href='javascript:;' class="slider-prev slider-btn" title="上一张"></a>
        		<div class="checkPicHead slider-wrapper" id="divMyReHonor">
            		<ul class='slider-move'>
                	
                	
                	<li>
                    	<div class="img"><img src="${pageContext.request.contextPath}/back/pubimg/pic/4.png" /></div>
                        <div class="nowtop">
                        	<div class="bj"></div>
                        	<div class="bjc">
                        	<a href="javascript:" class="del"></a></div>
                        </div>
                    </li>
                	<li>
                    	<div class="img"><img src="${pageContext.request.contextPath}/back/pubimg/pic/5.png" /></div>
                        <div class="nowtop">
                        	<div class="bj"></div>
                        	<div class="bjc">
                        	<a href="javascript:" class="del"></a></div>
                        </div>
                    </li>
                	<li>
                    	<div class="img"><img src="${pageContext.request.contextPath}/back/pubimg/pic/6.png" /></div>
                        <div class="nowtop">
                        	<div class="bj"></div>
                        	<div class="bjc">
                        	<a href="javascript:" class="del"></a></div>
                        </div>
                    </li>
                	<li>
                    	<div class="img"><img src="${pageContext.request.contextPath}/back/pubimg/pic/7.png" /></div>
                        <div class="nowtop">
                        	<div class="bj"></div>
                        	<div class="bjc">
                        	<a href="javascript:" class="del"></a></div>
                        </div>
                    </li>
                    <li>
                    	<div class="img"><img src="${pageContext.request.contextPath}/back/pubimg/pic/8.png" /></div>
                        <div class="nowtop">
                        	<div class="bj"></div>
                        	<div class="bjc">
                        	<a href="javascript:" class="del"></a></div>
                        </div>
                    </li>
                    
                    <li>
                    	<div class="img"><img src="${pageContext.request.contextPath}/back/pubimg/pic/9.png" /></div>
                        <div class="nowtop">
                        	<div class="bj"></div>
                        	<div class="bjc">
                        	<a href="javascript:" class="del"></a></div>
                        </div>
                    </li>
                	<li>
                    	<div class="img"><img src="${pageContext.request.contextPath}/back/pubimg/pic/7.png" /></div>
                        <div class="nowtop">
                        	<div class="bj"></div>
                        	<div class="bjc">
                        	<a href="javascript:" class="del"></a></div>
                        </div>
                    </li>
                    <li>
                    	<div class="img"><img src="${pageContext.request.contextPath}/back/pubimg/pic/5.png" /></div>
                        <div class="nowtop">
                        	<div class="bj"></div>
                        	<div class="bjc">
                        	<a href="javascript:" class="del"></a></div>
                        </div>
                    </li>
                	</ul>
            	</div>
            	<a href='javascript:;' class="slider-next slider-btn" title="下一张"></a>
            </div>
            <script>
		$(function(){
			$('.slider-box3').mySlider({  //参数可选,以下为默认参数
					speed: 300,
					direction: 'left', //  运动方向 可选 left,top
					prevClass: 'slider-prev',			//左边
					nextClass: 'slider-next',			//右边
					wrapperClass: 'slider-wrapper',
					moveClass: 'slider-move'
			});
		});
	</script>
    	</div>
        
        <div class="workIntro">
    			<span class="leftabstract">奖项说明：</span>
            	<textarea></textarea>
    	</div>
                
        <div class="submit">
        	<input class="reset" type="button" value="取消" onclick="cloosePopBox('divHonorPop');"/>
			<input class="sub" type="button" value="提交"/>
    	</div>
    </div>
    
    
    <!--我的荣誉弹出框-->
    
        
    <!--承接的代表性项目-->
    <div id="divContinue">
   		<div class="head">
        	<h2>承接的代表性项目</h2>
        </div>
        
        <!--有图片-->
        <div class="cont">
        	<div class="edit">
            	<div class="bj"></div>
                <div class="ed">
                	<a href="javascript:" class="del">删除</a>
                	<a href="javascript:" class="edi">编辑</a>
                </div>
            </div>
            
        	<div class="one">
            	<span class="year"><span>2004</span>年</span>|
                <span class="address">国际商务礼仪师范拍摄</span>|
                <span class="country">德国</span>
                <span>柏林</span>
            </div>
            
            <div class="two">
            	<span class="cha">作品说明：</span>
                <span class="intt">这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写</span>
            </div>
            
            <div class="two">
            	<span class="cha">项目职责：</span>
                <span class="intt">这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写</span>
            </div>
            
            <div class="picProject" id="divContinueHead">
            	<ul>
                	<li>
                    	<div class="img"><img src="${pageContext.request.contextPath}/back/pubimg/pic/2.png" /></div>
                        <div class="bg"><i class="bj"></i><i class="ed"></i></div>
                    </li>
                    
                    <li>
                    	<div class="img"><img src="${pageContext.request.contextPath}/back/pubimg/pic/3.png" /></div>
                        <div class="bg"><i class="bj"></i><i class="ed"></i></div>
                    </li>
                    
                    <li>
                    	<div class="img"><img src="${pageContext.request.contextPath}/back/pubimg/pic/4.png" /></div>
                        <div class="bg"><i class="bj"></i><i class="ed"></i></div>
                    </li>
                    
                    <li>
                    	<div class="img"><img src="${pageContext.request.contextPath}/back/pubimg/pic/5.png" /></div>
                        <div class="bg"><i class="bj"></i><i class="ed"></i></div>
                    </li>
                
                </ul>
            </div>
        </div>
        <!--有图片-->
        
        <!--没有图片-->
        <div class="cont conno">
        	<div class="edit">
            	<div class="bj"></div>
                <div class="ed">
                	<a href="javascript:" class="del">删除</a>
                	<a href="javascript:" class="edi">编辑</a>
                </div>
            </div>
        	<div class="one">
            	<span class="year"><span>2004</span>年</span>|
                <span class="address">国际商务礼仪师范拍摄</span>|
                <span class="country">德国</span>
                <span>柏林</span>
            </div>
            
            <div class="two">
            	<span class="cha">作品说明：</span>
                <span class="intt">这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写</span>
            </div>
            
            <div class="two">
            	<span class="cha">项目职责：</span>
                <span class="intt">这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写</span>
            </div>
        </div>
        <!--没有图片-->
        
        
        <!--有图片-->
        <div class="cont">
        	<div class="edit">
            	<div class="bj"></div>
                <div class="ed">
                	<a href="javascript:" class="del">删除</a>
                	<a href="javascript:" class="edi">编辑</a>
                </div>
            </div>
        	<div class="one">
            	<span class="year"><span>2004</span>年</span>|
                <span class="address">国际商务礼仪师范拍摄</span>|
                <span class="country">德国</span>
                <span>柏林</span>
            </div>
            
            <div class="two">
            	<span class="cha">作品说明：</span>
                <span class="intt">这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写</span>
            </div>
            
            <div class="two">
            	<span class="cha">项目职责：</span>
                <span class="intt">这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写</span>
            </div>
            
            <div class="picProject" id="divContinueHead">
            	<ul>
                	<li>
                    	<div class="img"><img src="${pageContext.request.contextPath}/back/pubimg/pic/2.png" /></div>
                        <div class="bg"><i class="bj"></i><i class="ed"></i></div>
                    </li>
                    
                    <li>
                    	<div class="img"><img src="${pageContext.request.contextPath}/back/pubimg/pic/2.png" /></div>
                        <div class="bg"><i class="bj"></i><i class="ed"></i></div>
                    </li>
                    
                    <li>
                    	<div class="img"><img src="${pageContext.request.contextPath}/back/pubimg/pic/2.png" /></div>
                        <div class="bg"><i class="bj"></i><i class="ed"></i></div>
                    </li>
                    
                    <li>
                    	<div class="img"><img src="${pageContext.request.contextPath}/back/pubimg/pic/2.png" /></div>
                        <div class="bg"><i class="bj"></i><i class="ed"></i></div>
                    </li>
                
                </ul>
            </div>
        </div>
        <!--有图片-->
        
        <!--没有图片-->
        <div class="cont conno">
        	<div class="edit">
            	<div class="bj"></div>
                <div class="ed">
                	<a href="javascript:" class="del">删除</a>
                	<a href="javascript:" class="edi">编辑</a>
                </div>
            </div>
        	<div class="one">
            	<span class="year"><span>2004</span>年</span>|
                <span class="address">国际商务礼仪师范拍摄</span>|
                <span class="country">德国</span>
                <span>柏林</span>
            </div>
            
            <div class="two">
            	<span class="cha">作品说明：</span>
                <span class="intt">这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写</span>
            </div>
            
            <div class="two">
            	<span class="cha">项目职责：</span>
                <span class="intt">这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写作品的详细介绍这里写</span>
            </div>
        </div>
        <!--没有图片-->
        
        
        <div class="divBottom">
        	<input type="button" value="添加代表性项目" class="addReP" onclick="openPopUpBox('divProjectPop');"/>
        </div>
    </div>
    <!--承接的代表性项目-->
    
    <!--我的荣誉-->
    <div id="divMyHonor">
    	<div class="head">
        	<h2>我的荣誉</h2>
        </div>
        
        <div class="cont">
        	<div class="headPortrait">
            	<img src="${pageContext.request.contextPath}/back/pubimg/pic/2.png" />
            </div>
            
            <div class="divTableHonor">
            	<table>
                	<tr class="tr1">
                    	<td class="sp">奖项：</td><td class="td1">奖项名称</td>
                        <td class="sp">颁发时间：</td><td class="td2"><span>2006</span>年<span>08</span>月</td>
                        <td class="sp">颁发地点：</td><td class="td3"><span>中国</span><span>北京</span></td>
                    </tr>
                    
                    <tr class="tr2">
                    	<td class="sp">颁发组织：</td><td class="td1">国家级别</td>
                        <td class="sp">获奖作品：</td><td class="td2" colspan="2">我爱中国</td>
                    </tr>
                    
                    <tr class="tr3">
                    	<td class="sp jx">奖项介绍：</td><td  class="jxc" colspan="5">国家级别我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国00000000000000000000000000000我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国00000000000000000000000000000我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国00000000000000000000000000000</td>
                    </tr>
                
                </table>
            </div>
        </div>
        
        <div class="cont">
        	<div class="headPortrait">
            	<img src="${pageContext.request.contextPath}/back/pubimg/pic/2.png" />
            </div>
            
            <div class="divTableHonor">
            	<table>
                	<tr class="tr1">
                    	<td class="sp">奖项：</td><td class="td1">奖项名称</td>
                        <td class="sp">颁发时间：</td><td class="td2"><span>2006</span>年<span>08</span>月</td>
                        <td class="sp">颁发地点：</td><td class="td3"><span>中国</span><span>北京</span></td>
                    </tr>
                    
                    <tr class="tr2">
                    	<td class="sp">颁发组织：</td><td class="td1">国家级别</td>
                        <td class="sp">获奖作品：</td><td class="td2" colspan="2">我爱中国</td>
                    </tr>
                    
                    <tr class="tr3">
                    	<td class="sp jx">奖项介绍：</td><td colspan="5" class="jxc">国家级别我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国</td>
                    </tr>
                
                </table>
            </div>
        </div>
        
        <div class="cont">
        	<div class="headPortrait">
            	<img src="${pageContext.request.contextPath}/back/pubimg/pic/2.png" />
            </div>
            
            <div class="divTableHonor">
            	<table>
                	<tr class="tr1">
                    	<td class="sp">奖项：</td><td class="td1">奖项名称</td>
                        <td class="sp">颁发时间：</td><td class="td2"><span>2006</span>年<span>08</span>月</td>
                        <td class="sp">颁发地点：</td><td class="td3"><span>中国</span><span>北京</span></td>
                    </tr>
                    
                    <tr class="tr2">
                    	<td class="sp">颁发组织：</td><td class="td1">国家级别</td>
                        <td class="sp">获奖作品：</td><td class="td2" colspan="2">我爱中国</td>
                    </tr>
                    
                    <tr class="tr3">
                    	<td class="sp jx">奖项介绍：</td><td colspan="5" class="jxc">国家级别我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱爱中国我爱中国我爱中国我爱中国我爱中国我爱中国中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国我爱中国00000000000000000000000000000</td>
                    </tr>
                
                </table>
            </div>
        </div>
        
        <div class="divBottom">
        	<input type="button" value="添加我的荣誉" class="addReP" onclick="openPopUpBox('divHonorPop');"/>
        </div>
    </div>
    
    <!--我的荣誉-->
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
    
	<div id="goTopBtn" style="display:none;" title="回顶部"></div>
</div>
<!--[if lte IE 6]>
<script src="${pageContext.request.contextPath}/public/js/DD_belatedPNG_0.0.8a.js" type="text/javascript"></script>
    <script type="text/javascript">
        DD_belatedPNG.fix('div, ul, img, li, input , a , i');
    </script>
<![endif]-->

 
    <!--代表作品弹出框-->
</body>
</html>
