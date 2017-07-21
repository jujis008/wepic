<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="shortcut icon"
			href="${pageContext.request.contextPath}/public/images/logoSmall.ico" />
<meta name="robots" content="index,follow" />

<title>wepic管理 个人中心  首页</title>
<link type="text/css" rel="stylesheet"
			href="${pageContext.request.contextPath}/back/personalCentr/user/css/personIndex.css" />

<script type="text/javascript"
			src="${pageContext.request.contextPath}/public/js/jquery.js"></script>

<!--公共js-->
<script type="text/javascript" src="${pageContext.request.contextPath}/back/js/ajaxforUserInfo.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/back/js/publicBack.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/public.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/topBar.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/header.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/back/personalCentr/user/js/personIndex.js"></script>

<!--公共css-->
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public/css/backMainBar.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public/css/topBarMain.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public/css/header.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public/css/footer.css" />
<script type="text/javascript">
var nickName='<s:property value="#session.nickName"/>';
var path ="${pageContext.request.contextPath}";
function subRole(obj){
$("#updateUserRole").submit();
$(obj).parents(".chooseTag").hide();	
}


$(function(){
	var tag="<s:property value="userInfoBeans.personOrCompany"/>";
if(tag!="1"&&tag!="2"){
openPopUpBox("divChoseUser");	
	}
});



</script>
</head>

<body>
<div id="container">
	<div id="topBar">
	<script type="text/javascript" src="${pageContext.request.contextPath}/back/js/topbar.js"></script>
	
	<!-- --
	
	
		<div id="topbar">
    	<div id="topcenterbar">
    		<div id="topbar-collect">
    			<a id="topcollect" href="javascript:addToFavorite('http://www.wepic.cn/','唯图网_商业拍摄 原创商业图片交易平台')">
                	<span>收藏唯图</span>			
        		</a>
       		</div>
       		<
       	
        	<div id="topbar-toolbar">
    			
                <div id="divTopBarUesr">
                	<div id="topBarUser">
                    	<a href="javascript:"><span><s:property value="#session.nickName"/></span><i></i></a>
                    </div>
                    
                	<div id="topBarUserDetailed">
                    	<div id="topBarUserOne">
                        	<div id="topBarUserOneHead">
                            	<img src="${pageContext.request.contextPath}/public/images/pic/topUser.jpg"   id="porperties"/>
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
                            <li><img src="images/pic1/topUser.jpg"/></li>
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
                               <a href="${pageContext.request.contextPath}/bid!findAllMyBid.action"><span>我的约拍</span></a>
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
            	<a href="#" id="toppublish">发布约拍</a>
        	</div>
        </div>
    </div> 
	
	

	
	
	 -->

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
        	<a href="${pageContext.request.contextPath}/user!getFistPageUserInfo.do"><div class="bar active"><span>
        	首页</span><i></i></div></a>
        	
            <s:if test="userInfoBeans.personOrCompany==2">
            
            <a href="${pageContext.request.contextPath}/user!baseUseInfo.do?message=enpr">
            </s:if>
            <s:else>
            <s:if test="#session.role=='model'">
            <a href="${pageContext.request.contextPath}/user!baseUseInfo.do?message=model">
            </s:if>
            
            <s:else>
            <a href="${pageContext.request.contextPath}/user!baseUseInfo.do?message=all">
            </s:else>
            
            </s:else>
            <div class='bar'><span>账户基本资料</span><i></i></div></a>
            
            <!-- story!initdata.do -->
            <a href="<%= basePath%>story!storylist.do"><div class='bar'><span>我的作品库</span><i></i></div></a>
            
            <a href="${pageContext.request.contextPath}/catBid!findByrootType.do"><div class='bar'><span>我的约拍</span><i></i></div></a>
            
            <a href="javascript:"><div class='bar'><span>我买到的作品</span><i></i></div></a>
            
           <a href="javascript:"> <div class='bar'><span>收藏/订阅/推荐</span><i></i></div></a>
        </div>
    	
        
    </div>
    <!-- 导航  end-->
    
    <!--内容-->
    <div id="divPersonIndex">
   		<div class="personl-left">
        
        	<div class="divHead">
            	<div class="head" id="divheadChange">
            	 <s:if test="userInfoBeans.portrait==null">
                	<img src="${pageContext.request.contextPath}/back/pubimg/images/defaultHead_150.png" />
                	</s:if>
                	<s:else>
                	<img src="<s:property value="userInfoBeans.portrait"/>" />
                	</s:else>
                    <div class="change" id="headChange">
                    	<div class="bg"></div>
                        <a href="${pageContext.request.contextPath}/back/personalCentr/user/accountPic.jsp"><div class="bgc">更改头像</div></a>
                    </div>
                </div>
                <div class="headInf">
                	<div class="one">
                    	<h2>
                    	
                    	<s:property value="userInfoBeans.nickName"/>
                    	</h2>
                        <div class="divIden">
                            <s:if test="userInfoBeans.personOrCompany==2">
                            
                             <s:if test="userInfoBeans.ifIdentityTrue==2">
                             <a href="javascript:" class="iden" title="企业身份已认证"></a>
                             </s:if>
                             
                             <s:else>
                        	<a href="javascript:" class="idenw" title="企业身份未认证"></a>
                        	</s:else>
                            </s:if>
                            <s:else>
                             <s:if test="userInfoBeans.ifIdentityTrue==2">
                            <a href="javascript:" class="iden" title="个人身份已认证"></a>
                            </s:if>
                            <s:else>
                        	<a href="javascript:" class="idenw" title="个人身份未认证"></a>
                        	
                            </s:else>
                            
                        	
                        	</s:else>
                        	
                            <a href="javascript:" class="collect" title="推荐摄影师"></a>
                        </div>
                        
                        <div class="divGrade">
                          
                           <s:if test="userInfoBeans.jewel!=0">
                            <s:bean name="org.apache.struts2.util.Counter" id="counter">  
                            <s:param name="first" value="0" />  
                            <s:param name="last" value="userInfoBeans.jewel" />  
                            <s:iterator>  
                           <img src="${pageContext.request.contextPath}/public/images/grade/diamond.png"/>
                            </s:iterator>                     
                            </s:bean>  
                            </s:if>
                             <s:if test="userInfoBeans.star!=0">
                            <s:bean name="org.apache.struts2.util.Counter" id="counter">  
                            <s:param name="first" value="0" />  
                            <s:param name="last" value="userInfoBeans.star" />  
                            <s:iterator>  
                             <img src="${pageContext.request.contextPath}/public/images/grade/star.png"/>
                            </s:iterator>                     
                            </s:bean>  
                             </s:if>
                            <a href="javascript:" class="grade">等级:</a>
                            <span><s:property value="userInfoBeans.degee"/></span>
                            <span class="next">距离下一等级：
                            </span>
                            <span><s:property value="userInfoBeans.nextDegeeMark"/></span></span>
                            <span>积分</span>
                           
                            </div>
                    </div>
                    <div class="two">
                    	<span>
                    	
                    	<s:property value="userInfoBeans.context"/>
                    	</span>
                    </div>
                    <div class="three">
                    	<div class="left">
                        	<div class="is">
                            	<div><span>账户总额</span><span><s:property value="userInfoBeans.account.totalMoney"/></span>元</div>
                                <div><span>冻结金额</span><span><s:property value="userInfoBeans.account.totalMoney-userInfoBeans.account.remainingMoney"/></span>元</div>
                                <div><span>本月收益</span><span>2114</span>元</div>
                            </div>
                            
                            <div class="ye">
                            	<div class="ye1"><span>账户可用金额</span></div>
                                <div class="ye2"><span class="ye3"><s:property value="userInfoBeans.account.remainingMoney"/></span><span class="ye4">元</span></div>
                            </div>
                        </div>
                        
                        <div class="right">
                        	<div class="de"><a href="javascript:" class="detaily">查看详情</a></div>
                            <div class="op">
                            	<input type="button" class="pay" value="充值" />
                                <input type="button" class="wi" value="提现" />
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--头部结束-->
            
            <div class="divContent">
            	<div class="bar">
                	<a href="personIndex.html"><div class="active">我的动态</div></a>
                    <a href="personIndexY.html"><div>好友动态</div></a>
                </div>
                
                
                
                <div class="shareMyWord">
                	<div class="shareMyWordTop">
                    	<span class="name">王宝强</span><span>分享了我的图片作品</span>
                    </div>
                    
                	<div class="shareMyWordCon">
                    	<h2>图片标题</h2>
                        <div class="introduce">本书是一本改变你的工作与生活的实用性著作，它为我们揭示了成功人士社交的核心技巧，以及积极提升交际能力的高效法则——全书从怎样塑造交际形象，怎样培养良好的人缘，怎样调整交际心态以及怎样与恋人、爱人、家人相处，怎样与朋友、上司、下属、同事交往，使用哪些交际手段（幽默、应变、应酬、礼仪）等多方面入手，讲述了增强交际能力的方法和技巧。希望本书为你推开成功之门助一臂之力！</div>
                        
                        <div class="image">
                    		<img src="${pageContext.request.contextPath}/back/pubimg/pic/1.png" />
                    	</div>
                        
                        <div class="keyword">
							<span>关键词</span>
							<a href="javascript:">综合</a>
							<a href="javascript:">伤感</a>
							<a href="javascript:">动感</a>
							<a href="javascript:">抒情</a>
							<a href="javascript:">中国流行</a>
						</div>
                        
                    </div>
                    
                    
                    
                    <div class="shareMyWordBot">
                    	<p class="p1"><span>今天</span><span>15:32</span></p>
                        <p class="p2"><span>推荐</span>(<span>45</span>)<span class="span2">浏览</span>(<span>1212</span>)</p>
                    </div>
                </div>
                <!--分享节点-->
                
                <div class="collectMyProject">
                	<div class="collectMyProjectTop">
                    	<span class="name">王宝强</span><span>收藏了项目</span>
                    </div>
                    
                	<div class="collectMyProjectCon">
                    
                    	<div class="divMainListLogo divMainListLogo4"></div>
                        <div class="divMainListTitle">
                        	<h2>约拍项目标题</h2>
                            <div class="divMainListTitleIco">
                            	<a class="divMainListTitleIcoOne"><span>64456</span></a>
                                <a class="divMainListTitleIcoTwo"><span>64456</span></a>
                                <a class="divMainListTitleIcoThree"><span>64456</span></a>
                            </div>
                            <div class="divMainListTitleInfo">
                            	<table class="tableMainListTitleInfo">
                                	<tr>
                                    	<td><font class="">应约截止时间：</font></td>
                                        <td class="divMainListTitleInfoSpan1"><span>2013年7月20日</span></td>
                                        <td><font class="divMainListTitleInfoFont2">拍摄地点：</font></td>
                                        <td><span class="divMainListTitleInfoSpan2">上海市</span></td>
                                    </tr>
                                    <tr>
                                    	<td><font class="">已应约数：</font></td>
                                        <td> <span class="divMainListTitleInfoSpan1">465</span>人</td>
                                        <td><font class="divMainListTitleInfoFont2">拍摄时间：</font></td>
                                        <td><span class="divMainListTitleInfoSpan2">2013年3月8日</span></td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                        
                        <div class="divMainListPerson">
                        	<a href="javascript:">
                            	<div class="divMainListPersonA"></div>
                                <p>6</p>
                        	</a>
                        </div>
                        
                        <div class="divMainListPrice">
                        	<a href="javascript:">
                            	<div class="divMainListPriceA"></div>
                                <p>99</p>
                        	</a>
                        </div>
                        
                    </div>
                    
                    <div class="collectMyProjectBot">
                    	<p class="p1"><span>10</span>月<span>10日</span><span>15:32</span></p>
                        <p class="p2"><span>推荐</span>(<span>45</span>)<span class="span2">浏览</span>(<span>1212</span>)</p>
                    </div>
                </div>
                <!--收藏节点-->
                
                <div class="shareMyWord">
                	<div class="shareMyWordTop">
                    	<span class="name">王宝强</span><span>分享了我的图片作品</span>
                    </div>
                    
                	<div class="shareMyWordCon">
                    	<h2>图片标题</h2>
                        <div class="introduce">本书是一本改变你的工作与生活的实用性著作，它为我们揭示了成功人士社交的核心技巧，以及积极提升交际能力的高效法则——全书从怎样塑造交际形象，怎样培养良好的人缘，怎样调整交际心态以及怎样与恋人、爱人、家人相处，怎样与朋友、上司、下属、同事交往，使用哪些交际手段（幽默、应变、应酬、礼仪）等多方面入手，讲述了增强交际能力的方法和技巧。希望本书为你推开成功之门助一臂之力！</div>
                        
                        <div class="image">
                    		<img src="${pageContext.request.contextPath}/back/pubimg/pic/1.png" />
                    	</div>
                        
                        <div class="keyword">
							<span>关键词</span>
							<a href="javascript:">综合</a>
							<a href="javascript:">伤感</a>
							<a href="javascript:">动感</a>
							<a href="javascript:">抒情</a>
							<a href="javascript:">中国流行</a>
						</div>
                        
                    </div>
                    
                    
                    
                    <div class="shareMyWordBot">
                    	<p class="p1"><span>今天</span><span>15:32</span></p>
                        <p class="p2"><span>推荐</span>(<span>45</span>)<span class="span2">浏览</span>(<span>1212</span>)</p>
                    </div>
                </div>
                <!--分享节点-->
            </div>
            <!--内容节点-->
            
            
        </div>
        
        
        <div class="personl-right">
        	<div class="myWork">
            	<div class="head">
                	<span>我的作品</span>
                    <a href="javascript:">进入作品库</a>
                </div>
                <div class="info">
                	<div class="info1">
                    	<span class="span1">销售中作品</span>
                        <span class="spans">32</span>
                        
                        <span class="span3">已发布作品</span>
                        <span class="spans">32</span>
                    </div>
                    
                    <div class="info1">
                    	<span class="span1">作品库作品</span>
                        <span class="spans">32</span>
                        
                        <span class="span3">作品库占用</span>
                        <span class="spans">32%</span>
                    </div>
                </div>
                
                
                <div class="opt">
                	<a href="javascript:" class="uoload">上传作品</a>
                    <a href="javascript:" class="issue">发布作品</a>
                </div>
            </div>
            
            <div class="myProject">
            	<div class="head">
                	<span>我的项目</span>
                    <a href="javascript:">查看记录</a>
                </div>
                <div class="info">
                	<div class="info1">
                    	<span class="span1">应约中项目</span>
                        <span class="spans">32</span>
                        
                        <span class="span3">已发布项目</span>
                        <span class="spans">32</span>
                    </div>
                    
                    <div class="info1">
                    	<span class="span1">已中标项目</span>
                        <span class="spans">32</span>
                    </div>
                </div>
                
                
                <div class="opt">
                	<a href="javascript:" class="uoload">我去应约</a>
                    <a href="javascript:" class="issue">发布约拍</a>
                </div>
            </div>
            <div class="commission"></div>
        </div>
        <div class="personl-clear" style="clear:both"></div>
    </div>
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
                    	<li><a href="javascript:" id="shareSina" class="shareSina"></a></li>
                        <li><a href="javascript:" id="shareQqzone" class="shareQqzone"></a></li>
                        <li><a href="javascript:" id="shareQqblog" class="shareQqblog"></a></li>
                        <li><a href="javascript:" id="shareTwitter" class="shareTwitter"></a></li>
                        <li><a href="javascript:" id="shareFacebook" class="shareFacebook"></a></li>
                        <li><a href="javascript:" id="shareRenren" class="shareRenren"></a></li>
                        <li><a href="javascript:" id="shareDouban" class="shareDouban"></a></li>
                    </ul>
                    	
                </div>
            </div>
        </div>
    </div>
    </div>
    <!--foot 结束-->
    
	<div id="goTopBtn" style="display:none;"></div>
</div>


<div class="userBox" id="divChoseUser">
 <form action="user!addUserRole.do" method="post" id="updateUserRole">
    <input type="hidden" value="" id="userType" name="personOrCompany" />
     <input type="hidden" value="" id="userRole" name="role" />
      <input type="hidden" value="" id="hiddenReTags"  name="userTag" />
    </form>
    
	<div class="top">
    	<h2>欢迎加入唯图网</h2>
<!--		<a class="closeUserBox" href="javascript:cloosePopBox('divChoseUser');"></a>-->
    </div>
    <div class="character">
    	<h2>这是您第一次来到个人中心，请选择您的身份类型：</h2>
    </div>
    <div class="ico">
    	<a class="user" onclick="choosePopUpBox(this,'divChosePart');"></a>
        <a class="enterprise" onclick="choosePopUpBox(this,'divChoseTrade');"></a>
    </div>
</div>

<div class="userBox" id="divChosePart">
	<div class="top">
    	<h2>欢迎加入唯图网</h2>
<!--		<a class="closeUserBox" href="javascript:cloosePopBox('divChosePart');"></a>-->
    </div>
    <div class="characterPart">
    	<h2>下面哪种职业与您的职业最相似？</h2>
    </div>
    <div class="ico">
    	<a class="icoPart photograph" onclick="choosePopUpBox(this,'formPersonTagpho');">摄影师</a>
        <a class="icoPart model" onclick="choosePopUpBox(this,'formPersonTagmodel');">模特</a>
        <a class="icoPart agent" onclick="choosePopUpBox(this,'formPersonTagdesigner');">设计师</a>
        <a class="icoPart inter" onclick="choosePopUpBox(this,'formPersonTagArt');">演艺人士</a>
        <a class="icoPart design" onclick="choosePopUpBox(this,'formPersonTagagent');">其他</a>
        
    </div>
    
    <div class="submit">
    	<input class="reChose" type="button" value="返回重选" onclick="reChose(this,'divChoseUser');"></input>
<!--        <a href="javascript:" onclick="choosePopUpBox(this,'formPersonTagUser');">我只是普通用户</a>-->
    </div>
</div>

<form action="javascript:" class="formPersonEn" id="formPersonTagpho">
<div class="chooseTag">
	<div class="top">
    	<h2>欢迎加入唯图网</h2>
<!--		<a class="closeUserBox" href="javascript:cloosePopBox('formPersonTagpho');"></a>-->
    </div>
    
    <div class="character">
    	<h2>请选择您的个人职业标签：</h2>
    </div>
    
    <div class="choosed">
    	<div class="one">已添加标签：</div>
        <div class="con">
        	<div id="divAddEnTagpho">
            	<div class='tagDe'><span>摄影师</span><a></a></div>
            </div>
            <div style="clear:both;"></div>
        </div>
    </div>
    
    <div class="chooseCon">
    	<div class="one">推荐标签：</div>
        <div class="con">
        	<div class="tag"><span>时装摄影师</span><a onclick="addreProfTag(this,'divAddEnTagpho');"></a></div>
            <div class="tag"><span>广告摄影师</span><a onclick="addreProfTag(this,'divAddEnTagpho');"></a></div>
            <div class="tag"><span>人像摄影师</span><a onclick="addreProfTag(this,'divAddEnTagpho');"></a></div>
            <div class="tag"><span>产品摄影师</span><a onclick="addreProfTag(this,'divAddEnTagpho');"></a></div>
            <div class="tag"><span>建筑室内摄影师</span><a onclick="addreProfTag(this,'divAddEnTagpho');"></a></div>
            <div class="tag"><span>场景摄影师</span><a onclick="addreProfTag(this,'divAddEnTagpho');"></a></div>
            <div class="tag"><span>新闻摄影师</span><a onclick="addreProfTag(this,'divAddEnTagpho');"></a></div>
            <div class="tag"><span>广告摄影师</span><a onclick="addreProfTag(this,'divAddEnTagpho');"></a></div>
            <div class="tag"><span>时尚摄影师</span><a onclick="addreProfTag(this,'divAddEnTagpho');"></a></div>
            <div style="clear:both;"></div>
        </div>
    </div>
    
    <div class="addProf">
    	<input class="inputaddProf" id="inputaddProfVpho" type="text" onkeyup="doit(this)" onafterpaste="doit(this)"/>
        <input class="inputaddProfTag" type="button" value="添加职业标签" onclick="addProfTag('inputaddProfVpho','divAddEnTagpho');"/>
        <span class="spanintro">自定义标签最多添加两个</span>
    </div>
    
    <div class="submit">
    	<input class="reChose" type="button" value="返回重选" onclick="reChosePart(this,'divChosePart');">
        <input class="sure" type="button" value="确认" onclick="subRole(this)" />
    </div>
    
    <div class="introdut">
    	<span class="span1">说明：</span>
        <span class="span2">您的行业标签条件后，进入管理页面可继续编辑</span>
    </div>
</div>
</form>

<form action="javascript:" class="formPersonEn" id="formPersonTagmodel">
<div class="chooseTag">
	<div class="top">
    	<h2>欢迎加入唯图网</h2>
<!--		<a class="closeUserBox" href="javascript:cloosePopBox('formPersonTagmodel');"></a>-->
    </div>
    
    <div class="character">
    	<h2>请选择您的个人职业标签：</h2>
    </div>
    
    <div class="choosed">
    	<div class="one">已添加标签：</div>
        <div class="con">
        	<div id="divAddEnTagmodel">
            	<div class='tagDe'><span>模特</span><a></a></div>
            </div>
            <div style="clear:both;"></div>
        </div>
    </div>
    
    
   
    
    <div class="chooseCon">
    	<div class="one">推荐标签：</div>
        <div class="con">
        	<div class="tag"><span>平面影视模特</span><a onclick="addreProfTag(this,'divAddEnTagmodel');"></a></div>
            <div class="tag"><span>产品形象模特</span><a onclick="addreProfTag(this,'divAddEnTagmodel');"></a></div>
            <div class="tag"><span>T台走秀模特</span><a onclick="addreProfTag(this,'divAddEnTagmodel');"></a></div>
            <div class="tag"><span>礼仪模特</span><a onclick="addreProfTag(this,'divAddEnTagmodel');"></a></div>
            <div class="tag"><span>车模</span><a onclick="addreProfTag(this,'divAddEnTagmodel');"></a></div>
            <div class="tag"><span>服装试穿模特</span><a onclick="addreProfTag(this,'divAddEnTagmodel');"></a></div>
            <div class="tag"><span>内衣模特</span><a onclick="addreProfTag(this,'divAddEnTagmodel');"></a></div>
            <div class="tag"><span>表演模特</span><a onclick="addreProfTag(this,'divAddEnTagmodel');"></a></div>
            <div class="tag"><span>人体模特</span><a onclick="addreProfTag(this,'divAddEnTagmodel');"></a></div>
            <div class="tag"><span>局部模特（脸模）</span><a onclick="addreProfTag(this,'divAddEnTagmodel');"></a></div>
            <div class="tag"><span>局部模特（眼模）</span><a onclick="addreProfTag(this,'divAddEnTagmodel');"></a></div>
            <div class="tag"><span>局部模特（手模）</span><a onclick="addreProfTag(this,'divAddEnTagmodel');"></a></div>
            <div class="tag"><span>局部模特（耳模）</span><a onclick="addreProfTag(this,'divAddEnTagmodel');"></a></div>
            <div class="tag"><span>局部模特（腿模）</span><a onclick="addreProfTag(this,'divAddEnTagmodel');"></a></div>
            <div class="tag"><span>局部模特（脚模）</span><a onclick="addreProfTag(this,'divAddEnTagmodel');"></a></div>
            <div class="tag"><span>中老年模特</span><a onclick="addreProfTag(this,'divAddEnTagmodel');"></a></div>
            <div class="tag"><span>少儿模特（由监护人代理注册）</span><a onclick="addreProfTag(this,'divAddEnTagmodel');"></a></div>
            <div style="clear:both;"></div>
        </div>
    </div>
    
    <div class="addProf">
    	<input class="inputaddProf" id="inputaddProfVmodel" type="text" onkeyup="doit(this)" onafterpaste="doit(this)"/>
        <input class="inputaddProfTag" type="button" value="添加职业标签" onclick="addProfTag('inputaddProfVmodel','divAddEnTagmodel');"/>
        <span class="spanintro">自定义标签最多添加两个</span>
    </div>
    
    <div class="submit">
    	<input class="reChose" type="button" value="返回重选" onclick="reChosePart(this,'divChosePart');">
        <input class="sure" type="button" value="确认" onclick="subRole(this)" />
    </div>
    
    <div class="introdut">
    	<span class="span1">说明：</span>
        <span class="span2">您的行业标签条件后，进入管理页面可继续编辑</span>
    </div>
</div>
</form>

<!--经纪人-->
<form action="javascript:" class="formPersonEn" id="formPersonTagagent">
<div class="chooseTag">
	<div class="top">
    	<h2>欢迎加入唯图网</h2>
<!--		<a class="closeUserBox" href="javascript:cloosePopBox('formPersonTagagent');"></a>-->
    </div>
    
    <div class="character">
    	<h2>请选择您的个人职业标签：</h2>
    </div>
    
    <div class="choosed">
    	<div class="one">已添加标签：</div>
        <div class="con">
        	<div id="divAddEnTagagent">
            	<div class='tagDe'><span>经纪人</span><a></a></div>
            </div>
            <div style="clear:both;"></div>
        </div>
    </div>
    
    <div class="chooseCon">
    	<div class="one">推荐标签：</div>
        <div class="con">
        	<div class="tag"><span>模特经纪</span><a onclick="addreProfTag(this,'divAddEnTagagent');"></a></div>
            <div class="tag"><span>摄影师经纪</span><a onclick="addreProfTag(this,'divAddEnTagagent');"></a></div>
            <div class="tag"><span>用户经纪</span><a onclick="addreProfTag(this,'divAddEnTagagent');"></a></div>
            <div class="tag"><span>艺术经纪</span><a onclick="addreProfTag(this,'divAddEnTagagent');"></a></div>
            <div class="tag"><span>演艺经纪</span><a onclick="addreProfTag(this,'divAddEnTagagent');"></a></div>
       
            <div style="clear:both;"></div>
        </div>
    </div>
    
    <div class="addProf">
    	<input class="inputaddProf" id="inputaddProfVagent" type="text" onkeyup="doit(this)" onafterpaste="doit(this)"/>
        <input class="inputaddProfTag" type="button" value="添加职业标签" onclick="addProfTag('inputaddProfVagent','divAddEnTagagent');"/>
        <span class="spanintro">自定义标签最多添加两个</span>
    </div>
    
    <div class="submit">
    	<input class="reChose" type="button" value="返回重选" onclick="reChosePart(this,'divChosePart');">
        <input class="sure" type="button" value="确认" onclick="subRole(this)" />
    </div>
    
    <div class="introdut">
    	<span class="span1">说明：</span>
        <span class="span2">您的行业标签条件后，进入管理页面可继续编辑</span>
    </div>
</div>
</form>
<!--经纪人-->

<!--演艺-->
<form action="javascript:" class="formPersonEn" id="formPersonTagArt">
<div class="chooseTag">
	<div class="top">
    	<h2>欢迎加入唯图网</h2>
<!--		<a class="closeUserBox" href="javascript:cloosePopBox('formPersonTagArt');"></a>-->
    </div>
    
    <div class="character">
    	<h2>请选择您的个人职业标签：</h2>
    </div>
    
    <div class="choosed">
    	<div class="one">已添加标签：</div>
        <div class="con">
        	<div id="divAddEnTagArt">
            	<div class='tagDe'><span>演艺人士</span><a></a></div>
            </div>
            <div style="clear:both;"></div>
        </div>
    </div>
    
    <div class="chooseCon">
    	<div class="one">推荐标签：</div>
        <div class="con">
        	<div class="tag"><span>主持人</span><a onclick="addreProfTag(this,'divAddEnTagArt');"></a></div>
            <div class="tag"><span>音乐人</span><a onclick="addreProfTag(this,'divAddEnTagArt');"></a></div>
            <div class="tag"><span>演员</span><a onclick="addreProfTag(this,'divAddEnTagArt');"></a></div>
            <div class="tag"><span>导演</span><a onclick="addreProfTag(this,'divAddEnTagArt');"></a></div>
            <div class="tag"><span>音效师</span><a onclick="addreProfTag(this,'divAddEnTagArt');"></a></div>
            <div class="tag"><span>化妆师</span><a onclick="addreProfTag(this,'divAddEnTagArt');"></a></div>
            <div class="tag"><span>后期制作</span><a onclick="addreProfTag(this,'divAddEnTagArt');"></a></div>
            <div style="clear:both;"></div>
        </div>
    </div>
    
    <div class="addProf">
    	<input class="inputaddProf" id="inputaddProfVArt" type="text" onkeyup="doit(this)" onafterpaste="doit(this)"/>
        <input class="inputaddProfTag" type="button" value="添加职业标签" onclick="addProfTag('inputaddProfVArt','divAddEnTagArt');"/>
        <span class="spanintro">自定义标签最多添加两个</span>
    </div>
    
    <div class="submit">
    	<input class="reChose" type="button" value="返回重选" onclick="reChosePart(this,'divChosePart');">
        <input class="sure" type="button" value="确认" onclick="subRole(this)" />
    </div>
    
    <div class="introdut">
    	<span class="span1">说明：</span>
        <span class="span2">您的行业标签条件后，进入管理页面可继续编辑</span>
    </div>
</div>
</form>
<!--演艺-->

<!--设计师-->
<form action="javascript:" class="formPersonEn" id="formPersonTagdesigner">
<div class="chooseTag">
	<div class="top">
    	<h2>欢迎加入唯图网</h2>
<!--		<a class="closeUserBox" href="javascript:cloosePopBox('formPersonTagdesigner');"></a>-->
    </div>
    
    <div class="character">
    	<h2>请选择您的个人职业标签：</h2>
    </div>
    
    <div class="choosed">
    	<div class="one">已添加标签：</div>
        <div class="con">
        	<div id="divAddEnTagdesigner">
            	<div class='tagDe'><span>设计师</span><a></a></div>
            </div>
            <div style="clear:both;"></div>
        </div>
    </div>
    
    <div class="chooseCon">
    	<div class="one">推荐标签：</div>
        <div class="con">
        	<div class="tag"><span>平面设计师</span><a onclick="addreProfTag(this,'divAddEnTagdesigner');"></a></div>
            <div class="tag"><span>服装设计师</span><a onclick="addreProfTag(this,'divAddEnTagdesigner');"></a></div>
            <div class="tag"><span>建筑设计师</span><a onclick="addreProfTag(this,'divAddEnTagdesigner');"></a></div>
            <div class="tag"><span>产品设计师</span><a onclick="addreProfTag(this,'divAddEnTagdesigner');"></a></div>
            <div class="tag"><span>室内设计师</span><a onclick="addreProfTag(this,'divAddEnTagdesigner');"></a></div>
            <div class="tag"><span>展览设计师</span><a onclick="addreProfTag(this,'divAddEnTagdesigner');"></a></div>
            <div class="tag"><span>造型设计师</span><a onclick="addreProfTag(this,'divAddEnTagdesigner');"></a></div>
            <div class="tag"><span>动画设计师</span><a onclick="addreProfTag(this,'divAddEnTagdesigner');"></a></div>
            <div class="tag"><span>游戏设计师</span><a onclick="addreProfTag(this,'divAddEnTagdesigner');"></a></div>
            <div style="clear:both;"></div>
        </div>
    </div>
    
    <div class="addProf">
    	<input class="inputaddProf" id="inputaddProfVdesigner" type="text" onkeyup="doit(this)" onafterpaste="doit(this)"/>
        <input class="inputaddProfTag" type="button" value="添加职业标签" onclick="addProfTag('inputaddProfVdesigner','divAddEnTagdesigner');"/>
        <span class="spanintro">自定义标签最多添加两个</span>
    </div>
    
    <div class="submit">
    	<input class="reChose" type="button" value="返回重选" onclick="reChosePart(this,'divChosePart');">
        <input class="sure" type="button" value="确认" onclick="subRole(this)" />
    </div>
    
    <div class="introdut">
    	<span class="span1">说明：</span>
        <span class="span2">您的行业标签条件后，进入管理页面可继续编辑</span>
    </div>
</div>
</form>
<!--设计师-->

<!--普通用户-->
<form action="javascript:" class="formPersonEn" id="formPersonTagUser">
<div class="chooseTag">
	<div class="top">
    	<h2>欢迎加入唯图网</h2>
<!--		<a class="closeUserBox" href="javascript:cloosePopBox('formPersonTagUser');"></a>-->
    </div>
    
    <div class="character">
    	<h2>请选择您的个人职业标签：</h2>
    </div>
    
    <div class="choosed">
    	<div class="one">已添加标签：</div>
        <div class="con">
        	<div id="divAddEnTagUser">
            </div>
            <div style="clear:both;"></div>
        </div>
    </div>
    
    <div class="chooseCon">
    	<div class="one">推荐标签：</div>
        <div class="con">
        	<div class="tag"><span>IT互联网</span><a onclick="addreProfTag(this,'divAddEnTagUser');"></a></div>
            <div class="tag"><span>服装</span><a onclick="addreProfTag(this,'divAddEnTagUser');"></a></div>
            <div class="tag"><span>网店店主</span><a onclick="addreProfTag(this,'divAddEnTagUser');"></a></div>
            <div class="tag"><span>广告/设计</span><a onclick="addreProfTag(this,'divAddEnTagUser');"></a></div>
            <div class="tag"><span>策划</span><a onclick="addreProfTag(this,'divAddEnTagUser');"></a></div>
            <div class="tag"><span>经纪</span><a onclick="addreProfTag(this,'divAddEnTagUser');"></a></div>
            <div class="tag"><span>产品品牌</span><a onclick="addreProfTag(this,'divAddEnTagUser');"></a></div>
            <div class="tag"><span>餐饮</span><a onclick="addreProfTag(this,'divAddEnTagUser');"></a></div>
            <div class="tag"><span>交通/运输</span><a onclick="addreProfTag(this,'divAddEnTagUser');"></a></div>
            <div class="tag"><span>美容/护理</span><a onclick="addreProfTag(this,'divAddEnTagUser');"></a></div>
            <div class="tag"><span>媒体/传媒</span><a onclick="addreProfTag(this,'divAddEnTagUser');"></a></div>
            <div class="tag"><span>教育/培训</span><a onclick="addreProfTag(this,'divAddEnTagUser');"></a></div>
            <div class="tag"><span>出版/印刷</span><a onclick="addreProfTag(this,'divAddEnTagUser');"></a></div>
            <div class="tag"><span>文化/艺术</span><a onclick="addreProfTag(this,'divAddEnTagUser');"></a></div>
            <div style="clear:both;"></div>
        </div>
    </div>
    
    <div class="addProf">
    	<input class="inputaddProf" id="inputaddProfVUser" type="text" onkeyup="doit(this)" onafterpaste="doit(this)"/>
        <input class="inputaddProfTag" type="button" value="添加职业标签" onclick="addProfTag('inputaddProfVUser','divAddEnTagUser');"/>
        <span class="spanintro">自定义标签最多添加两个</span>
    </div>
    
    <div class="submit">
    	<input class="reChose" type="button" value="返回重选" onclick="reChosePart(this,'divChosePart');">
        <input class="sure" type="button" value="确认" onclick="subRole(this)" />
    </div>
    
    <div class="introdut">
    	<span class="span1">说明：</span>
        <span class="span2">您的行业标签条件后，进入管理页面可继续编辑</span>
    </div>
</div>
</form>
<!--普通用户-->



<!--企业-->
<div class="userBox" id="divChoseTrade">

	<div class="top">
    	<h2>欢迎加入唯图网</h2>
<!--		<a class="closeUserBox" href="javascript:cloosePopBox('divChoseTrade');"></a>-->
    </div>
    <div class="characterPart">
    	<h2>选择与您企业最相近的行业：</h2>
    </div>
    <div class="enterpriseico">
    	<a class="pho" onclick="choosePopUpBox(this,'formEnterpriseTagPho');"> <input type="hidden" id="formEnterpriseTagPho1" value="photoEnterprise" />  摄影</a>
        <a class="model" onclick="choosePopUpBox(this,'formEnterpriseTagAgent');"><input type="hidden" id="formEnterpriseTagAgent1" value="modelbrokeEnterprise" />模特经纪</a>
        <a class="cy" onclick="choosePopUpBox(this,'formEnterpriseTagDesign');"><input type="hidden" id="formEnterpriseTagDesign1" value="designEnterprise" />创意设计</a>
        <a class="ad" onclick="choosePopUpBox(this,'formEnterpriseTagAdm');"><input type="hidden" id="formEnterpriseTagAdm1" value="Planning" />广告/策划</a>
        <a class="ys" onclick="choosePopUpBox(this,'formEnterpriseTagPrint');"><input type="hidden" id="formEnterpriseTagPrint1" value="printing" />印刷/出版</a>
        <a class="wh" onclick="choosePopUpBox(this,'formEnterpriseTagCulture');"><input type="hidden" id="formEnterpriseTagCulture1" value="cultureandart" />文化艺术</a>
        <a class="dm" onclick="choosePopUpBox(this,'formEnterpriseTagComic');"><input type="hidden" id="formEnterpriseTagComic1" value="manga" />动漫</a>
        <a class="yy" onclick="choosePopUpBox(this,'formEnterpriseTagArt');"><input type="hidden" id="formEnterpriseTagArt1" value="performance" />演艺</a>
        <a class="it" onclick="choosePopUpBox(this,'formEnterpriseTagIT');"><input type="hidden" id="formEnterpriseTagIT1" value="it" />IT/互联网</a>
        <a class="cm" onclick="choosePopUpBox(this,'formEnterpriseTagMedia');"><input type="hidden" id="formEnterpriseTagMedia1" value="media" />传媒/媒体</a>
        <a class="edu" onclick="choosePopUpBox(this,'formEnterpriseTagEdu');"><input type="hidden" id="formEnterpriseTagEdu1" value="training" />教育/培训</a>
        <a class="fz" onclick="choosePopUpBox(this,'formEnterpriseTagFashion');"><input type="hidden" id="formEnterpriseTagFashion1" value="clothingbrand" />服装品牌</a>
    </div>
    
    <div class="submit">
   
    	<input class="reChose" type="button" value="返回重选" onclick="reChose(this,'divChoseUser');">
        <a href="javascript:" onclick="choosePopUpBox(this,'formEnterpriseTagFashion');"><input type="hidden" id="formEnterpriseTagPho1" value="other" />其他行业</a>
    </div>
</div>
<!--企业-->

<!--摄影-->
<form action="javascript:" id="formEnterpriseTagPho" class="formEnterpriseEn">
<div class="chooseTag">
	<div class="top">
    	<h2>欢迎加入唯图网</h2>
<!--		<a class="closeUserBox" href="javascript:cloosePopBox('formEnterpriseEn');"></a>-->
    </div>
    
    <div class="character">
    	<h2>请选择您企业行业标签：</h2>
    </div>
    
    <div class="choosed">
    	<div class="one">已添加标签：</div>
        <div class="con">
        	<div id="divAddEnTagEnterprisePho"></div>
            <div style="clear:both;"></div>
        </div>
    </div>
    
    <div class="chooseCon">
    	<div class="one">推荐标签：</div>
        <div class="con">
        	<div class="tag"><span>商业摄影</span><a onclick="addreProfTag(this,'divAddEnTagEnterprisePho');"></a></div>
            <div class="tag"><span>婚纱摄影</span><a onclick="addreProfTag(this,'divAddEnTagEnterprisePho');"></a></div>
            <div class="tag"><span>儿童摄影</span><a onclick="addreProfTag(this,'divAddEnTagEnterprisePho');"></a></div>
            <div class="tag"><span>摄影协会</span><a onclick="addreProfTag(this,'divAddEnTagEnterprisePho');"></a></div>
            <div style="clear:both;"></div>
        </div>
    </div>
    
    <div class="addProf">
    	<input class="inputaddProf" id="inputaddProfVEnterprisePho" type="text" onkeyup="doit(this)" onafterpaste="doit(this)"/>
        <input class="inputaddProfTag" type="button" value="添加职业标签" onclick="addProfTag('inputaddProfVEnterprisePho','divAddEnTagEnterprisePho');"/>
        <span class="spanintro">自定义标签最多添加两个</span>
    </div>
    
    <div class="submit">
    	<input class="reChose" type="button" value="返回重选" onclick="reChosePart(this,'divChoseTrade');">
        <input class="sure" type="button" value="确认" onclick="subRole(this)" />
    </div>
    
    <div class="introdut">
    	<span class="span1">说明：</span>
        <span class="span2">您的行业标签条件后，进入管理页面可继续编辑</span>
    </div>
</div>
</form>
<!--摄影-->

<!--模特经纪-->
<form action="javascript:" class="formEnterpriseEn" id="formEnterpriseTagAgent">
<div class="chooseTag">
	<div class="top">
    	<h2>欢迎加入唯图网</h2>
<!--		<a class="closeUserBox" href="javascript:cloosePopBox('formEnterpriseTagAgent');"></a>-->
    </div>
    
    <div class="character">
    	<h2>请选择您企业行业标签：</h2>
    </div>
    
    <div class="choosed">
    	<div class="one">已添加标签：</div>
        <div class="con">
        	<div id="divAddEnTagEnterpriseAgent"></div>
            <div style="clear:both;"></div>
        </div>
    </div>
    
    <div class="chooseCon">
    	<div class="one">推荐标签：</div>
        <div class="con">
            <div style="clear:both;"></div>
        </div>
    </div>
    
    <div class="addProf">
    	<input class="inputaddProf" id="inputaddProfVEnterpriseAgent" type="text" onkeyup="doit(this)" onafterpaste="doit(this)"/>
        <input class="inputaddProfTag" type="button" value="添加职业标签" onclick="addProfTag('inputaddProfVEnterpriseAgent','divAddEnTagEnterpriseAgent');"/>
        <span class="spanintro">自定义标签最多添加两个</span>
    </div>
    
    <div class="submit">
    	<input class="reChose" type="button" value="返回重选" onclick="reChosePart(this,'divChoseTrade');">
        <input class="sure" type="button" value="确认" onclick="subRole(this)" />
    </div>
    
    <div class="introdut">
    	<span class="span1">说明：</span>
        <span class="span2">您的行业标签条件后，进入管理页面可继续编辑</span>
    </div>
</div>
</form>
<!--模特经纪-->

<!--创意设计-->
<form action="javascript:" class="formEnterpriseEn" id="formEnterpriseTagDesign">
<div class="chooseTag">
	<div class="top">
    	<h2>欢迎加入唯图网</h2>
<!--		<a class="closeUserBox" href="javascript:cloosePopBox('formEnterpriseTagDesign');"></a>-->
    </div>
    
    <div class="character">
    	<h2>请选择您企业行业标签：</h2>
    </div>
    
    <div class="choosed">
    	<div class="one">已添加标签：</div>
        <div class="con">
        	<div id="divAddEnTagEnterpriseDesign"></div>
            <div style="clear:both;"></div>
        </div>
    </div>
    
    <div class="chooseCon">
    	<div class="one">推荐标签：</div>
        <div class="con">
        	<div class="tag"><span>广告设计</span><a onclick="addreProfTag(this,'divAddEnTagEnterpriseDesign');"></a></div>
            <div class="tag"><span>平面设计</span><a onclick="addreProfTag(this,'divAddEnTagEnterpriseDesign');"></a></div>
            <div class="tag"><span>室内设计</span><a onclick="addreProfTag(this,'divAddEnTagEnterpriseDesign');"></a></div>
            <div class="tag"><span>展览设计</span><a onclick="addreProfTag(this,'divAddEnTagEnterpriseDesign');"></a></div>
            <div class="tag"><span>建筑设计</span><a onclick="addreProfTag(this,'divAddEnTagEnterpriseDesign');"></a></div>
            <div class="tag"><span>工业设计</span><a onclick="addreProfTag(this,'divAddEnTagEnterpriseDesign');"></a></div>
            <div class="tag"><span>服装设计</span><a onclick="addreProfTag(this,'divAddEnTagEnterpriseDesign');"></a></div>
            <div class="tag"><span>网站设计</span><a onclick="addreProfTag(this,'divAddEnTagEnterpriseDesign');"></a></div>
            <div class="tag"><span>包装设计</span><a onclick="addreProfTag(this,'divAddEnTagEnterpriseDesign');"></a></div>
            <div class="tag"><span>园林设计</span><a onclick="addreProfTag(this,'divAddEnTagEnterpriseDesign');"></a></div>
            <div class="tag"><span>道具设计</span><a onclick="addreProfTag(this,'divAddEnTagEnterpriseDesign');"></a></div>
            <div class="tag"><span>饰品设计</span><a onclick="addreProfTag(this,'divAddEnTagEnterpriseDesign');"></a></div>
            <div style="clear:both;"></div>
        </div>
    </div>
    
    <div class="addProf">
    	<input class="inputaddProf" id="inputaddProfVEnterpriseDesign" type="text" onkeyup="doit(this)" onafterpaste="doit(this)"/>
        <input class="inputaddProfTag" type="button" value="添加职业标签" onclick="addProfTag('inputaddProfVEnterpriseDesign','divAddEnTagEnterpriseDesign');"/>
        <span class="spanintro">自定义标签最多添加两个</span>
    </div>
    
    <div class="submit">
    	<input class="reChose" type="button" value="返回重选" onclick="reChosePart(this,'divChoseTrade');">
        <input class="sure" type="button" value="确认" onclick="subRole(this)" />
    </div>
    
    <div class="introdut">
    	<span class="span1">说明：</span>
        <span class="span2">您的行业标签条件后，进入管理页面可继续编辑</span>
    </div>
</div>
</form>
<!--创意设计-->

<!--广告/策划-->
<form action="javascript:" class="formEnterpriseEn" id="formEnterpriseTagAdm">
<div class="chooseTag">
	<div class="top">
    	<h2>欢迎加入唯图网</h2>
<!--		<a class="closeUserBox" href="javascript:cloosePopBox('formEnterpriseTagAdm');"></a>-->
    </div>
    
    <div class="character">
    	<h2>请选择您企业行业标签：</h2>
    </div>
    
    <div class="choosed">
    	<div class="one">已添加标签：</div>
        <div class="con">
        	<div id="divAddEnTagEnterpriseAdm"></div>
            <div style="clear:both;"></div>
        </div>
    </div>
    
    <div class="chooseCon">
    	<div class="one">推荐标签：</div>
        <div class="con">
        	<div class="tag"><span>媒体广告</span><a onclick="addreProfTag(this,'divAddEnTagEnterpriseAdm');"></a></div>
            <div class="tag"><span>平面广告</span><a onclick="addreProfTag(this,'divAddEnTagEnterpriseAdm');"></a></div>
            <div class="tag"><span>影视广告</span><a onclick="addreProfTag(this,'divAddEnTagEnterpriseAdm');"></a></div>
            <div class="tag"><span>互联网广告</span><a onclick="addreProfTag(this,'divAddEnTagEnterpriseAdm');"></a></div>
            <div class="tag"><span>会议策划</span><a onclick="addreProfTag(this,'divAddEnTagEnterpriseAdm');"></a></div>
            <div class="tag"><span>活动策划</span><a onclick="addreProfTag(this,'divAddEnTagEnterpriseAdm');"></a></div>
            <div class="tag"><span>路演策划</span><a onclick="addreProfTag(this,'divAddEnTagEnterpriseAdm');"></a></div>
            <div class="tag"><span>新品发布</span><a onclick="addreProfTag(this,'divAddEnTagEnterpriseAdm');"></a></div>
            <div class="tag"><span>品牌策划</span><a onclick="addreProfTag(this,'divAddEnTagEnterpriseAdm');"></a></div>
            <div class="tag"><span>市场营销</span><a onclick="addreProfTag(this,'divAddEnTagEnterpriseAdm');"></a></div>
            <div style="clear:both;"></div>
        </div>
    </div>
    
    <div class="addProf">
    	<input class="inputaddProf" id="inputaddProfVEnterpriseAdm" type="text" onkeyup="doit(this)" onafterpaste="doit(this)"/>
        <input class="inputaddProfTag" type="button" value="添加职业标签" onclick="addProfTag('inputaddProfVEnterpriseAdm','divAddEnTagEnterpriseAdm');"/>
        <span class="spanintro">自定义标签最多添加两个</span>
    </div>
    
    <div class="submit">
    	<input class="reChose" type="button" value="返回重选" onclick="reChosePart(this,'divChoseTrade');">
        <input class="sure" type="button" value="确认" onclick="subRole(this)" />
    </div>
    
    <div class="introdut">
    	<span class="span1">说明：</span>
        <span class="span2">您的行业标签条件后，进入管理页面可继续编辑</span>
    </div>
</div>
</form>
<!--广告/策划-->

<!--印刷/出版-->
<form action="javascript:" class="formEnterpriseEn" id="formEnterpriseTagPrint">
<div class="chooseTag">
	<div class="top">
    	<h2>欢迎加入唯图网</h2>
<!--		<a class="closeUserBox" href="javascript:cloosePopBox('formEnterpriseTagPrint');"></a>-->
    </div>
    
    <div class="character">
    	<h2>请选择您企业行业标签：</h2>
    </div>
    
    <div class="choosed">
    	<div class="one">已添加标签：</div>
        <div class="con">
        	<div id="divAddEnTagEnterprisePrint"></div>
            <div style="clear:both;"></div>
        </div>
    </div>
    
    <div class="chooseCon">
    	<div class="one">推荐标签：</div>
        <div class="con">
        	<div class="tag"><span>出版社</span><a onclick="addreProfTag(this,'divAddEnTagEnterprisePrint');"></a></div>
            <div class="tag"><span>网络文学</span><a onclick="addreProfTag(this,'divAddEnTagEnterprisePrint');"></a></div>
            <div class="tag"><span>编辑</span><a onclick="addreProfTag(this,'divAddEnTagEnterprisePrint');"></a></div>
            <div class="tag"><span>书城</span><a onclick="addreProfTag(this,'divAddEnTagEnterprisePrint');"></a></div>
            <div style="clear:both;"></div>
        </div>
    </div>
    
    <div class="addProf">
    	<input class="inputaddProf" id="inputaddProfVEnterprisePrint" type="text" onkeyup="doit(this)" onafterpaste="doit(this)"/>
        <input class="inputaddProfTag" type="button" value="添加职业标签" onclick="addProfTag('inputaddProfVEnterprisePrint','divAddEnTagEnterprisePrint');"/>
        <span class="spanintro">自定义标签最多添加两个</span>
    </div>
    
    <div class="submit">
    	<input class="reChose" type="button" value="返回重选" onclick="reChosePart(this,'divChoseTrade');">
        <input class="sure" type="button" value="确认" onclick="subRole(this)" />
    </div>
    
    <div class="introdut">
    	<span class="span1">说明：</span>
        <span class="span2">您的行业标签条件后，进入管理页面可继续编辑</span>
    </div>
</div>
</form>
<!--印刷/出版-->

<!--文化艺术-->
<form action="javascript:" class="formEnterpriseEn" id="formEnterpriseTagCulture">
<div class="chooseTag">
	<div class="top">
    	<h2>欢迎加入唯图网</h2>
<!--		<a class="closeUserBox" href="javascript:cloosePopBox('formEnterpriseTagCulture');"></a>-->
    </div>
    
    <div class="character">
    	<h2>请选择您企业行业标签：</h2>
    </div>
    
    <div class="choosed">
    	<div class="one">已添加标签：</div>
        <div class="con">
        	<div id="divAddEnTagEnterpriseCulture"></div>
            <div style="clear:both;"></div>
        </div>
    </div>
    
    <div class="chooseCon">
    	<div class="one">推荐标签：</div>
        <div class="con">
        	<div class="tag"><span>文学</span><a onclick="addreProfTag(this,'divAddEnTagEnterpriseCulture');"></a></div>
            <div class="tag"><span>艺术</span><a onclick="addreProfTag(this,'divAddEnTagEnterpriseCulture');"></a></div>
            <div style="clear:both;"></div>
        </div>
    </div>
    
    <div class="addProf">
    	<input class="inputaddProf" id="inputaddProfVEnterpriseCulture" type="text" onkeyup="doit(this)" onafterpaste="doit(this)"/>
        <input class="inputaddProfTag" type="button" value="添加职业标签" onclick="addProfTag('inputaddProfVEnterpriseCulture','divAddEnTagEnterpriseCulture');"/>
        <span class="spanintro">自定义标签最多添加两个</span>
    </div>
    
    <div class="submit">
    	<input class="reChose" type="button" value="返回重选" onclick="reChosePart(this,'divChoseTrade');">
        <input class="sure" type="button" value="确认" onclick="subRole(this)" />
    </div>
    
    <div class="introdut">
    	<span class="span1">说明：</span>
        <span class="span2">您的行业标签条件后，进入管理页面可继续编辑</span>
    </div>
</div>
</form>
<!--文化艺术-->

<!--动漫-->
<form action="javascript:" class="formEnterpriseEn" id="formEnterpriseTagComic">
<div class="chooseTag">
	<div class="top">
    	<h2>欢迎加入唯图网</h2>
<!--		<a class="closeUserBox" href="javascript:cloosePopBox('formEnterpriseTagComic');"></a>-->
    </div>
    
    <div class="character">
    	<h2>请选择您企业行业标签：</h2>
    </div>
    
    <div class="choosed">
    	<div class="one">已添加标签：</div>
        <div class="con">
        	<div id="divAddEnTagEnterpriseComic"></div>
            <div style="clear:both;"></div>
        </div>
    </div>
    
    <div class="chooseCon">
    	<div class="one">推荐标签：</div>
        <div class="con">
        	<div class="tag"><span>影视动画</span><a onclick="addreProfTag(this,'divAddEnTagEnterpriseComic');"></a></div>
            <div class="tag"><span>游戏</span><a onclick="addreProfTag(this,'divAddEnTagEnterpriseComic');"></a></div>
            <div class="tag"><span>卡通</span><a onclick="addreProfTag(this,'divAddEnTagEnterpriseComic');"></a></div>
            <div class="tag"><span>动漫产品</span><a onclick="addreProfTag(this,'divAddEnTagEnterpriseComic');"></a></div>
            <div style="clear:both;"></div>
        </div>
    </div>
    
    <div class="addProf">
    	<input class="inputaddProf" id="inputaddProfVEnterpriseComic" type="text" onkeyup="doit(this)" onafterpaste="doit(this)"/>
        <input class="inputaddProfTag" type="button" value="添加职业标签" onclick="addProfTag('inputaddProfVEnterpriseComic','divAddEnTagEnterpriseComic');"/>
        <span class="spanintro">自定义标签最多添加两个</span>
    </div>
    
    <div class="submit">
    	<input class="reChose" type="button" value="返回重选" onclick="reChosePart(this,'divChoseTrade');">
        <input class="sure" type="button" value="确认" onclick="subRole(this)" />
    </div>
    
    <div class="introdut">
    	<span class="span1">说明：</span>
        <span class="span2">您的行业标签条件后，进入管理页面可继续编辑</span>
    </div>
</div>
</form>
<!--动漫-->

<!--演艺-->
<form action="javascript:" class="formEnterpriseEn" id="formEnterpriseTagArt">
<div class="chooseTag">
	<div class="top">
    	<h2>欢迎加入唯图网</h2>
<!--		<a class="closeUserBox" href="javascript:cloosePopBox('formEnterpriseTagArt');"></a>-->
    </div>
    
    <div class="character">
    	<h2>请选择您企业行业标签：</h2>
    </div>
    
    <div class="choosed">
    	<div class="one">已添加标签：</div>
        <div class="con">
        	<div id="divAddEnTagEnterpriseArt"></div>
            <div style="clear:both;"></div>
        </div>
    </div>
    
    <div class="chooseCon">
    	<div class="one">推荐标签：</div>
        <div class="con">
        	<div class="tag"><span>音乐</span><a onclick="addreProfTag(this,'divAddEnTagEnterpriseArt');"></a></div>
            <div class="tag"><span>影视</span><a onclick="addreProfTag(this,'divAddEnTagEnterpriseArt');"></a></div>
            <div class="tag"><span>娱乐</span><a onclick="addreProfTag(this,'divAddEnTagEnterpriseArt');"></a></div>
            <div class="tag"><span>表演</span><a onclick="addreProfTag(this,'divAddEnTagEnterpriseArt');"></a></div>
            <div class="tag"><span>公关活动</span><a onclick="addreProfTag(this,'divAddEnTagEnterpriseArt');"></a></div>
            <div style="clear:both;"></div>
        </div>
    </div>
    
    <div class="addProf">
    	<input class="inputaddProf" id="inputaddProfVEnterpriseArt" type="text" onkeyup="doit(this)" onafterpaste="doit(this)"/>
        <input class="inputaddProfTag" type="button" value="添加职业标签" onclick="addProfTag('inputaddProfVEnterpriseArt','divAddEnTagEnterpriseArt');"/>
        <span class="spanintro">自定义标签最多添加两个</span>
    </div>
    
    <div class="submit">
    	<input class="reChose" type="button" value="返回重选" onclick="reChosePart(this,'divChoseTrade');">
        <input class="sure" type="button" value="确认" onclick="subRole(this)" />
    </div>
    
    <div class="introdut">
    	<span class="span1">说明：</span>
        <span class="span2">您的行业标签条件后，进入管理页面可继续编辑</span>
    </div>
</div>
</form>
<!--演艺-->

<!--IT/互联网-->
<form action="javascript:" class="formEnterpriseEn" id="formEnterpriseTagIT">
<div class="chooseTag">
	<div class="top">
    	<h2>欢迎加入唯图网</h2>
<!--		<a class="closeUserBox" href="javascript:cloosePopBox('formEnterpriseTagIT');"></a>-->
    </div>
    
    <div class="character">
    	<h2>请选择您企业行业标签：</h2>
    </div>
    
    <div class="choosed">
    	<div class="one">已添加标签：</div>
        <div class="con">
        	<div id="divAddEnTagEnterpriseIT"></div>
            <div style="clear:both;"></div>
        </div>
    </div>
    
    <div class="chooseCon">
    	<div class="one">推荐标签：</div>
        <div class="con">
        	<div class="tag"><span>互联网</span><a onclick="addreProfTag(this,'divAddEnTagEnterpriseIT');"></a></div>
            <div class="tag"><span>淘宝</span><a onclick="addreProfTag(this,'divAddEnTagEnterpriseIT');"></a></div>
            <div class="tag"><span>天猫</span><a onclick="addreProfTag(this,'divAddEnTagEnterpriseIT');"></a></div>
            <div class="tag"><span>电商平台</span><a onclick="addreProfTag(this,'divAddEnTagEnterpriseIT');"></a></div>
            <div class="tag"><span>网络店铺</span><a onclick="addreProfTag(this,'divAddEnTagEnterpriseIT');"></a></div>
            <div style="clear:both;"></div>
        </div>
    </div>
    
    <div class="addProf">
    	<input class="inputaddProf" id="inputaddProfVEnterpriseIT" type="text" onkeyup="doit(this)" onafterpaste="doit(this)"/>
        <input class="inputaddProfTag" type="button" value="添加职业标签" onclick="addProfTag('inputaddProfVEnterpriseIT','divAddEnTagEnterpriseIT');"/>
        <span class="spanintro">自定义标签最多添加两个</span>
    </div>
    
    <div class="submit">
    	<input class="reChose" type="button" value="返回重选" onclick="reChosePart(this,'divChoseTrade');">
        <input class="sure" type="button" value="确认" onclick="subRole(this)" />
    </div>
    
    <div class="introdut">
    	<span class="span1">说明：</span>
        <span class="span2">您的行业标签条件后，进入管理页面可继续编辑</span>
    </div>
</div>
</form>
<!--IT/互联网-->

<!--传媒/媒体-->
<form action="javascript:" class="formEnterpriseEn" id="formEnterpriseTagMedia">
<div class="chooseTag">
	<div class="top">
    	<h2>欢迎加入唯图网</h2>
<!--		<a class="closeUserBox" href="javascript:cloosePopBox('formEnterpriseTagMedia');"></a>-->
    </div>
    
    <div class="character">
    	<h2>请选择您企业行业标签：</h2>
    </div>
    
    <div class="choosed">
    	<div class="one">已添加标签：</div>
        <div class="con">
        	<div id="divAddEnTagEnterpriseMedia"></div>
            <div style="clear:both;"></div>
        </div>
    </div>
    
    <div class="chooseCon">
    	<div class="one">推荐标签：</div>
        <div class="con">
        	<div class="tag"><span>杂志</span><a onclick="addreProfTag(this,'divAddEnTagEnterpriseMedia');"></a></div>
            <div class="tag"><span>报刊</span><a onclick="addreProfTag(this,'divAddEnTagEnterpriseMedia');"></a></div>
            <div class="tag"><span>互联网</span><a onclick="addreProfTag(this,'divAddEnTagEnterpriseMedia');"></a></div>
            <div class="tag"><span>电台</span><a onclick="addreProfTag(this,'divAddEnTagEnterpriseMedia');"></a></div>
            <div class="tag"><span>电视媒体</span><a onclick="addreProfTag(this,'divAddEnTagEnterpriseMedia');"></a></div>
            <div class="tag"><span>新媒体</span><a onclick="addreProfTag(this,'divAddEnTagEnterpriseMedia');"></a></div>
            <div style="clear:both;"></div>
        </div>
    </div>
    
    <div class="addProf">
    	<input class="inputaddProf" id="inputaddProfVEnterpriseMedia" type="text" onkeyup="doit(this)" onafterpaste="doit(this)"/>
        <input class="inputaddProfTag" type="button" value="添加职业标签" onclick="addProfTag('inputaddProfVEnterpriseMedia','divAddEnTagEnterpriseMedia');"/>
        <span class="spanintro">自定义标签最多添加两个</span>
    </div>
    
    <div class="submit">
    	<input class="reChose" type="button" value="返回重选" onclick="reChosePart(this,'divChoseTrade');">
        <input class="sure" type="button" value="确认" onclick="subRole(this)" />
    </div>
    
    <div class="introdut">
    	<span class="span1">说明：</span>
        <span class="span2">您的行业标签条件后，进入管理页面可继续编辑</span>
    </div>
</div>
</form>
<!--传媒/媒体-->

<!--教育/培训-->
<form action="javascript:" class="formEnterpriseEn" id="formEnterpriseTagEdu">
<div class="chooseTag">
	<div class="top">
    	<h2>欢迎加入唯图网</h2>
<!--		<a class="closeUserBox" href="javascript:cloosePopBox('formEnterpriseTagEdu');"></a>-->
    </div>
    
    <div class="character">
    	<h2>请选择您企业行业标签：</h2>
    </div>
    
    <div class="choosed">
    	<div class="one">已添加标签：</div>
        <div class="con">
        	<div id="divAddEnTagEnterpriseEdu"></div>
            <div style="clear:both;"></div>
        </div>
    </div>
    
    <div class="chooseCon">
    	<div class="one">推荐标签：</div>
        <div class="con">
        	<div class="tag"><span>学校</span><a onclick="addreProfTag(this,'divAddEnTagEnterpriseEdu');"></a></div>
            <div class="tag"><span>学院</span><a onclick="addreProfTag(this,'divAddEnTagEnterpriseEdu');"></a></div>
            <div class="tag"><span>大学</span><a onclick="addreProfTag(this,'divAddEnTagEnterpriseEdu');"></a></div>
            <div class="tag"><span>培训机构</span><a onclick="addreProfTag(this,'divAddEnTagEnterpriseEdu');"></a></div>
            <div class="tag"><span>教育机构</span><a onclick="addreProfTag(this,'divAddEnTagEnterpriseEdu');"></a></div>
            <div style="clear:both;"></div>
        </div>
    </div>
    
    <div class="addProf">
    	<input class="inputaddProf" id="inputaddProfVEnterpriseEdu" type="text" onkeyup="doit(this)" onafterpaste="doit(this)"/>
        <input class="inputaddProfTag" type="button" value="添加职业标签" onclick="addProfTag('inputaddProfVEnterpriseEdu','divAddEnTagEnterpriseEdu');"/>
        <span class="spanintro">自定义标签最多添加两个</span>
    </div>
    
    <div class="submit">
    	<input class="reChose" type="button" value="返回重选" onclick="reChosePart(this,'divChoseTrade');">
        <input class="sure" type="button" value="确认" onclick="subRole(this)" />
    </div>
    
    <div class="introdut">
    	<span class="span1">说明：</span>
        <span class="span2">您的行业标签条件后，进入管理页面可继续编辑</span>
    </div>
</div>
</form>
<!--教育/培训-->

<!--服装品牌-->
<form action="javascript:" class="formEnterpriseEn" id="formEnterpriseTagFashion">
<div class="chooseTag">
	<div class="top">
    	<h2>欢迎加入唯图网</h2>
<!--		<a class="closeUserBox" href="javascript:cloosePopBox('formEnterpriseTagFashion');"></a>-->
    </div>
    
    <div class="character">
    	<h2>请选择您企业行业标签：</h2>
    </div>
    
    <div class="choosed">
    	<div class="one">已添加标签：</div>
        <div class="con">
        	<div id="divAddEnTagEnterpriseFashion"></div>
            <div style="clear:both;"></div>
        </div>
    </div>
    
    <div class="chooseCon">
    	<div class="one">推荐标签：</div>
        <div class="con">
        	<div class="tag"><span>少儿服装</span><a onclick="addreProfTag(this,'divAddEnTagEnterpriseFashion');"></a></div>
            <div class="tag"><span>女装</span><a onclick="addreProfTag(this,'divAddEnTagEnterpriseFashion');"></a></div>
            <div class="tag"><span>男装</span><a onclick="addreProfTag(this,'divAddEnTagEnterpriseFashion');"></a></div>
            <div class="tag"><span>鞋帽</span><a onclick="addreProfTag(this,'divAddEnTagEnterpriseFashion');"></a></div>
            <div class="tag"><span>饰品</span><a onclick="addreProfTag(this,'divAddEnTagEnterpriseFashion');"></a></div>
            <div style="clear:both;"></div>
        </div>
    </div>
    
    <div class="addProf">
    	<input class="inputaddProf" id="inputaddProfVEnterpriseFashion" type="text" onkeyup="doit(this)" onafterpaste="doit(this)"/>
        <input class="inputaddProfTag" type="button" value="添加职业标签" onclick="addProfTag('inputaddProfVEnterpriseFashion','divAddEnTagEnterpriseFashion');"/>
        <span class="spanintro">自定义标签最多添加两个</span>
    </div>
    
    <div class="submit">
    	<input class="reChose" type="button" value="返回重选" onclick="reChosePart(this,'divChoseTrade');">
        <input class="sure" type="button" value="确认" onclick="subRole(this)" />
    </div>
    
    <div class="introdut">
    	<span class="span1">说明：</span>
        <span class="span2">您的行业标签条件后，进入管理页面可继续编辑</span>
    </div>
</div>
</form>
<!--服装品牌-->


<!--其他-->
<form action="javascript:" class="formEnterpriseEn" id="formEnterpriseTagOther">
<div class="chooseTag">
	<div class="top">
    	<h2>欢迎加入唯图网</h2>
<!--		<a class="closeUserBox" href="javascript:cloosePopBox('formEnterpriseTagOther');"></a>-->
    </div>
    
    <div class="character">
    	<h2>请选择您企业行业标签：</h2>
    </div>
    
    <div class="choosed">
    	<div class="one">已添加标签：</div>
        <div class="con">
        	<div id="divAddEnTagEnterpriseOther"></div>
            <div style="clear:both;"></div>
        </div>
    </div>
    
    <div class="chooseCon">
    	<div class="one">推荐标签：</div>
        <div class="con">
        	
        	<div class="tag"><span>日化</span><a onclick="addreProfTag(this,'divAddEnTagEnterpriseOther');"></a></div>
            <div class="tag"><span>日用品</span><a onclick="addreProfTag(this,'divAddEnTagEnterpriseOther');"></a></div>
            <div class="tag"><span>服装</span><a onclick="addreProfTag(this,'divAddEnTagEnterpriseOther');"></a></div>
            <div class="tag"><span>交通</span><a onclick="addreProfTag(this,'divAddEnTagEnterpriseOther');"></a></div>
            <div class="tag"><span>电子</span><a onclick="addreProfTag(this,'divAddEnTagEnterpriseOther');"></a></div>
            <div class="tag"><span>家居</span><a onclick="addreProfTag(this,'divAddEnTagEnterpriseOther');"></a></div>
            <div class="tag"><span>建材</span><a onclick="addreProfTag(this,'divAddEnTagEnterpriseOther');"></a></div>
            <div style="clear:both;"></div>
        </div>
    </div>
    
    <div class="addProf">
    	<input class="inputaddProf" id="inputaddProfVEnterpriseOther" type="text" onkeyup="doit(this)" onafterpaste="doit(this)"/>
        <input class="inputaddProfTag" type="button" value="添加职业标签" onclick="addProfTag('inputaddProfVEnterpriseOther','divAddEnTagEnterpriseOther');"/>
        <span class="spanintro">自定义标签最多添加两个</span>
    </div>
    
    <div class="submit">
    	<input class="reChose" type="button" value="返回重选" onclick="reChosePart(this,'divChoseTrade');">
        <input class="sure" type="button" value="确认" onclick="subRole(this)" />
    </div>
    
    <div class="introdut">
    	<span class="span1">说明：</span>
        <span class="span2">您的行业标签条件后，进入管理页面可继续编辑</span>
    </div>
</div>
</form>
<!--其他-->


</body>
</html>
<!--[if lte IE 6]>
<script src="${pageContext.request.contextPath}/public/js/DD_belatedPNG_0.0.8a.js" type="text/javascript"></script>
    <script type="text/javascript">
        DD_belatedPNG.fix('div, ul, img, li, input , a , i');
    </script>
<![endif]-->