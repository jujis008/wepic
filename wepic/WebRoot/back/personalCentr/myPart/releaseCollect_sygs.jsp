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

<title>wepic管理_个人中心_我的约拍_发布约拍_发布作品征集_摄影故事</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/jquery.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/back/js/goErrorPostion.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/back/personalCentr/myPart/js/bidCollectValidate.js"></script>



<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/back/personalCentr/myPart/css/releaseCollect.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/back/personalCentr/myPart/js/releaseCollect.js"></script>
<!--公共js-->

<script type="text/javascript" src="${pageContext.request.contextPath}/back/js/publicBack.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/public.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/topBar.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/header.js"></script>

<!--公共css-->
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/back/pubimg/css/backMainBar.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public/css/topBarMain.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public/css/header.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public/css/footer.css" />


    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/back//pubimg/css/lyz.calendar.css"  />
    <script src="${pageContext.request.contextPath}/public/js/lyz.calendar.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/personalCentr/myPart/js/addPersonBidType.js"></script>
<script>
        $(function () {
           
            
            $("#txtEndDate").calendar({
                controlId: "divDate2",                                       // 弹出的日期控件ID，默认: $(this).attr("id") + "Calendar"
                speed: 200,                                                 // 三种预定速度之一的字符串("slow", "normal", or "fast")或表示动画时长的毫秒数值(如：1000),默认：200
                complement: true,                                           // 是否显示日期或年空白处的前后月的补充,默认：true
                readonly: true,                                             // 目标对象是否设为只读，默认：true
               	addToDiv: "choseTime2"
                
            });
		});
</script>

<style>
#shootProduct .content .divChooseCon  .divInfo .shootTime .shootWayCon .numinput {
    background: none repeat scroll 0 0 #FCFCFC;
    border: 1px solid #E8E8E8;
    border-radius: 3px;
    color: #535353;
    font-family: "微软雅黑";
    font-size: 12px;
    height: 17px;
    padding: 5px 8px;
    width: 35px;
	}
</style>
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
    	
        <div id="divThreeStage">
        
        <div class="threeStage">
        	<a href="javascript:"><div class='bar'><span>应约记录</span><i></i></div></a>
            
            <a href="${pageContext.request.contextPath}//bid!findAllMyBid.do"><div class='bar active'><span>发布记录</span><i></i></div></a>
            
            <a href="javascript:"><div class='bar'><span>约拍日程</span><i></i></div></a>
            
            <a href="${pageContext.request.contextPath}/catBid!findByrootType.do"><div class='bar'><span>发布约拍</span><i></i></div></a>
   </div>
        </div>
    </div>
    <!-- 导航  end-->
    
    <!--内容-->
    <div id="shootProduct">
    	<div class="divHead">
    		<p class="title-name">发布商业拍摄</p>
        </div>
        
      <form action="bid!addBid.do" id="formshootProduct" method="post">
        <div class="content">
        	<div class="title">
            	<span class="na">征集主题</span>
                <input class="titleinput" type="text" name="name"
onkeydown="gbcount(this.form.name,this.form.total,this.form.used);" 
  onkeyup="gbcount(this.form.name,this.form.total,this.form.used);"/>

				<input disabled name="used" size="1" value="0" class="inputtext"/>/
				<input disabled name="total" size="1" value="20" class="inputtext"/>
            </div>
        	
        	<div class="divChooseCon">
            	<div class="shootBar">
                	<ul>
                		<s:iterator value="parentBid">
                	<s:if test="id==bidCat.id">
                		<a href="catBid!publishBid.do?id=<s:property value="id"/>"><li class="active"><s:property value="name"/></li></a>
                		</s:if>
                		<s:else>
                		<a href="catBid!publishBid.do?id=<s:property value="id"/>"><li><s:property value="name"/></li></a>
                		
                		</s:else>
                		</s:iterator>
                	
                	
                	<!--  
                    	<a href="releaseCollect_sytp.html"><li>摄影图片</li></a>
                        <a href="releaseCollect_cytp.html"><li>创意图片</li></a>
                        <a href="releaseCollect_cysj.html"><li>创意设计</li></a>
                        <a href="releaseCollect_sygs.html"><li class="active">摄影故事</li></a>
                        -->
                	</ul>
                </div>
            	
                <!--第一行-->
                <div class="divInfo">
                	<div class="productType">
                        	<span class="characterl">活动主题</span>
                            <div class="proType">
                            	<ul id="chooseProductType">
                            	
                            	 <s:iterator value="bidcats" status="index">
                            	<s:if test="#index.index==0">
                            		<li class="active"><span>
                            		<s:property value="name.trim()"/>
                            		</span><i></i>
                            		</li>
                            		</s:if>
                            		<s:else>
                            		<s:if test="user.id!=null">
                            		<li class="customli"><span>
                            		<s:property value="name.trim()"/>
                            		</span><i></i>
                            		<a onclick="deletePersonCat(this,'<s:property value="id"/>');"></a>
                            		</li>
                            		</s:if>
                            		<s:else>
                            		<li><span>
                            		<s:property value="name.trim()"/>
                            		</span><i></i></li>
                            		
                            		</s:else>
                            		</s:else>
                            	</s:iterator>
                            	
                            	
                            	<!-- 
                					<li class="active"><span>新闻热点</span><i></i></li>
                    				<li><span>人文旅游</span><i></i></li>
 				                   	<li><span>科技</span><i></i></li>
                			    	<li><span>社会舆论</span><i></i></li>
              				      	<li><span>审美</span><i></i></li>
     				               	<li><span>感情</span><i></i></li>
              				      	<li><span>体育</span><i></i></li>
                			    	<li><span>社会舆论</span><i></i></li>
              				      	<li><span>时尚</span><i></i></li>
     				               	<li><span>人物</span><i></i></li>
              				      	<li><span>历史</span><i></i></li>
                                     -->
              				      	<!--添加自定义-->
              				      	<div class="addCustomLi">
                                    
                                    	<div class="addF" onclick="viewCustom();">+ 添加</div>
                                    
                                        <div class="custom" id="customDiv">
                                            <div class="character">自定义类型：（5个汉字以内）</div>
                                            <div class="addCustom">
                                                <input class="addinput" type="text" id="addCustomInput" onkeyup="checkwords(this,10)" onafterpaste="checkwords(this,10)"/>
                                                <input class="surebut" type="button" value="确定"  onclick="addperson();"/>
                                            </div>
                                            
                                            <div class="sanjiao"></div>
                                        </div>
                                        
                                    </div>
                                    <!--添加自定义-->
                                    
                                    <div class="divClear" style="clear:both;"></div>
                				</ul>
                        	</div>
                            <div style="clear:both;"></div>
                    </div>
                    <!--第一行-->
                    
                    <!--第二行-->
                	<div class="shootWay">
                    	<div class="left">
                        	<div class="character">作品要求</div>
                            
                        </div>
                        <div class="num">
                            <input disabled name="used2" size="1" value="0" class="inputtext"/>/
                            <input disabled name="total2" size="1" value="300" class="inputtext"/>
                        </div>
                        <div class="divAextarea">
                        	<textarea name="contextHtml" 
                            onkeydown="gbcount(this.form.contextHtml,this.form.total2,this.form.used2);" 
  							onkeyup="gbcount(this.form.contextHtml,this.form.total2,this.form.used2);"></textarea>
                        </div>
                    </div>
                    <!--第二行-->
                    
                    
                    
                    <!--第三行-->
                	<div class="shootTime">
                    	<table>
                        	<tr>
                            	<td class="td1">文字数量</td>
                            	<td class="workStandard">
                                	<input class="numinput" type="text" value="" name="numFont" 
                                            onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}"  
                                            onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'0')}else{this.value=this.value.replace(/\D/g,'')}"/>
                                    <span>字</span>
                                </td>
                                
                            	<td class="td1">图片最小尺寸</td>
                                
                                <td class="shootWayCon shootSourceFileFormat">
                                	<input class="numinput" type="text" value=""   name="workPrecisionWidth"
                                            onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}"  
                                            onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'0')}else{this.value=this.value.replace(/\D/g,'')}"/>
                                    <span>×</span>
                                    <input class="numinput" type="text" value="" name="workPrecisionHeight"
                                            onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}"  
                                            onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'0')}else{this.value=this.value.replace(/\D/g,'')}"/>
                                    <span>px</span>
                                </td>
                                
                                

                                <td class="td3">图片分辨率</td>
                                
                                <td class="workStandard workStandardcytp">
                                	<input class="numinput" type="text" value=""  name="worksspecifications"
                                            onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}"  
                                            onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'0')}else{this.value=this.value.replace(/\D/g,'')}"/>
                                    <span>dpi</span>
                                </td>
                            </tr>
                        
                        	<tr>
                            	<td class="td1">征集数量</td>
                            	<td class="divNum">
                                	<input class="subtract" type="button" onclick="subtractProductNum('inputproductNum');"/>
                                    <input class="numinput" type="text" name="sumProdct"  id="inputproductNum" value="1" 
                                            onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}"  
                                            onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'0')}else{this.value=this.value.replace(/\D/g,'')}"/>
                                    <input class="plus" type="button" onclick="plusProductNum('inputproductNum');"/>
                                    <span class="nums">篇</span>
                                </td>
                                <td class="td3">征集截止日期</td>
                                
                                <td class="time" id="choseTime2">
                                	<input class="timeInputStr" id="txtEndDate"  name="workEndTime"  type="text" readonly="true"/>
                                </td>
                            </tr>
                            
                        </table>
                    	
                        
                    </div>
                    <!--第三行-->
                    
                    
                    <!--第四行-->
                	<div class="productNum">
                        <table>
                        	<tr>
                            	<td class="td1">版权需求</td>
                            
                            	<td class="shootWayCon shootCopyright">
                                	<ul id="chooseShootCopyright">
                                        <li class="active"><span>买断版权</span><i></i></li>
                                        <li><span>仅使用权</span><i></i></li>
                                    </ul>
                                </td>
                                
                            </tr>
                        
                        	
                            <tr>
                            	<td class="td1">征集单价</td>
                            
                            	<td>
                                	<input class="priceinput" type="text" 
                                            onkeyup="countTotalMoeyEvent(this)" name="unitpriceProduct"
                                            onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'0')}else{this.value=this.value.replace(/\D/g,'')}"/>
                                    <span class="pricesp">元/篇</span>
                                </td>
                                
                                <td>
                                	<input id="checkjsbj" type="checkbox" name="ifAskPrice" value="1"/>
                            		<label for="checkjsbj">接受应约者报价</label>
                                </td>
                            </tr><!-- dddd -->
                            <tr>
                            	<td class="tdone"></td>
                            	<td>总价：<span id="totalCount">0</span>元</td>
                            </tr>
                            <tr>
                            	<td class="td1">招标方式</td>
                             <input type="hidden" id="publicOrPrivate" name="publicOrPrivate"/>
                            	<td class="shootWayCon invitationType">
                                	<ul id="chooseShootzbfs">
                                        <li class="active"><span>公开</span><i></i></li>
                                        <li><span>私密</span><i></i></li>
                                    </ul>
                                </td>
                                <td class="invitation">
                                	<input class="inputinvit" type="button" value="邀请好友/粉丝" onclick="yyyyyyyy();"/>
                            		<span>已邀请</span><a href="javascript:" id="invitationNum">0</a>人
                                </td>
                            </tr>
                            
                            <tr id="shootWayConSpanYQ" class="yqhy"><td class="tdone"></td><td>私密招标需要邀请好友</td></tr>
                        </table>
                        
                    </div>
                    
                    <!--第四行-->
                    
                </div>
                <div class="submit">
                
                
                 <input type="hidden" value="3" name="bidType" />
                  <input  type="hidden" name="type" id="type" value="<s:property value="bidCat.id"/>"/>
                  <input  type="hidden" name="tag" id="tag" value=""/>
                  <input  type="hidden" name="workPrecision" id="workPrecision" value="1"/> 
                  <input type="hidden" name="isCopyright" id="isCopyright" /> 
                  <input type="hidden" name="unitpriceType" id="unitpriceType"  value="1"/> 
                   <input  type="hidden"  name="attachmentUrl" id="attachmentUrl"/>
                  <input type="hidden" value="6" name="sumProductPhoto" />
                    <input type="hidden" name="fileType" value="" id="fileType"/>
            			<input class="finished" id="finished" type="button" onclick="submit_Cytp();" onclick="verifyForm();" value="发布"/>
           			</div>
                
            </div>
            
            
        </div>
        </form>
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


<div id="iframeChooseFriend" style="border:0px;width:875px;height:765px;position:absolute;top:0;left:0;display:none;"></div>
</body>
</html>
