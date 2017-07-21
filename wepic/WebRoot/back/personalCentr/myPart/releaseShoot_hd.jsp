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

<title>wepic管理_个人中心_我的约拍_发布约拍_活动现场拍摄</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/jquery.js"></script>


<script type="text/javascript" src="${pageContext.request.contextPath}/back/js/goErrorPostion.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/back/personalCentr/myPart/js/bidValidate.js"></script>


<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/back/personalCentr/myPart/css/releaseShoot_cp.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/back/personalCentr/myPart/js/releaseShoot_pm.js"></script>
<!--公共js-->
<script type="text/javascript" src="${pageContext.request.contextPath}/back/js/provinceCityDistrict.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/back/js/publicBack.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/public.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/topBar.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/header.js"></script>

<!--公共css-->
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/back/pubimg/css/backMainBar.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public/css/topBarMain.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public/css/header.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public/css/footer.css" />


    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/back/pubimg/css/lyz.calendar.css"  />
    <script src="${pageContext.request.contextPath}/public/js/lyz.calendar.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/personalCentr/myPart/js/addPersonBidType.js"></script>
<script>
        $(function () {
            $("#txtBeginDate").calendar({
                controlId: "divDate",                                       // 弹出的日期控件ID，默认: $(this).attr("id") + "Calendar"
                speed: 200,                                                 // 三种预定速度之一的字符串("slow", "normal", or "fast")或表示动画时长的毫秒数值(如：1000),默认：200
                complement: true,                                           // 是否显示日期或年空白处的前后月的补充,默认：true
                readonly: true,                                             // 目标对象是否设为只读，默认：true
               	addToDiv: "choseTime"
                
            });
            
            $("#txtEndDate").calendar({
                controlId: "divDate2",                                       // 弹出的日期控件ID，默认: $(this).attr("id") + "Calendar"
                speed: 200,                                                 // 三种预定速度之一的字符串("slow", "normal", or "fast")或表示动画时长的毫秒数值(如：1000),默认：200
                complement: true,                                           // 是否显示日期或年空白处的前后月的补充,默认：true
                readonly: true,                                             // 目标对象是否设为只读，默认：true
               	addToDiv: "choseTime2"
                
            });
		});
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
        
        <form action="bid!addBid.do" id="formshootProduct" method="post" >
        <div class="content">
        	<div class="title">
            	<span class="na">项目标题</span>
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
                	</ul>
                </div>
            	
                
                <div class="divInfo">
                	<div class="productType">
                    	<div class="top">
                        	<div class="character">产品类型</div>
                            <input type="hidden" id="hiddenChooseProductType" />
                            <div class="proType">
                            	<ul id="chooseProductType">
                					<s:iterator value="bidcats" status="index">
                            	<s:if test="#index.index==0">
                            		<li class="active"><span>
                            		<s:property value="name"/>
                            		</span><i></i>
                            		</li>
                            		</s:if>
                            		<s:else>
                            		<s:if test="user.id!=null">
                            		<li class="customli"><span>
                            		<s:property value="name"/>
                            		</span><i></i>
                            		<a onclick="deletePersonCat(this,'<s:property value="id"/>');"></a>
                            		</li>
                            		</s:if>
                            		<s:else>
                            		<li><span>
                            		<s:property value="name"/>
                            		</span><i></i></li>
                            		
                            		</s:else>
                            		</s:else>
                            	</s:iterator>
              				      	                                   
              				      	<!--<li class="customli"><span>自定义</span><i></i><a onclick="deleteLiFile(this);"></a></li>-->
                				</ul>
                            </div>
                        </div>
                    	<div class="custom">
                        	<div class="character">自定义类型：（5个汉字以内）</div>
                            <div class="addCustom">
                            	<input class="addinput" type="text" id="addCustomInput" onkeyup="checkwords(this,10)" onafterpaste="checkwords(this,10)"/>
                                <input class="surebut" type="button" value="确定"  onclick="addperson()"/>
                            </div>
                       	</div>
                    </div>
                    
                	<div class="shootWay">
                    	<div class="character">拍摄方式</div>
                        <div class="shootWayCon">
                            	<ul id="chooseShootWay">
                					<li class="active"><span>跟拍</span><i></i></li>
                				</ul>
                        </div>
                        
                        <div class="character">拍摄环境</div>
                        <div class="shootWayCon shootWayEnv">
                            	<ul id="chooseShootEnv">
                					<li class="active"><span>不限</span><i></i></li>
                    				<li><span>内景</span><i></i></li>
 				                   	<li><span>外景</span><i></i></li>
                				</ul>
                        </div>
                        
                        
                    </div>
                	<div class="shootTime">
                    	<div class="character">拍摄时间</div>
                        <div class="time" id="choseTime"><input class="timeInputStr" name="workStartTime" id="txtBeginDate" type="text"/></div>
                        
                        
                    	<div class="character">交付日期</div>
                        <div class="time" id="choseTime2">
                        <input class="timeInputStr" name="workEndTime" id="txtEndDate" type="text"/>
                        </div>
                        
                        <div id="shootAddress">
                            <div class="character">拍摄地点</div>
                              <input type="hidden" value="" name="workPlace" />
                            <div class="address" id="citySelectTag">
                                <dl class="sheng">
                                    <dt>
                                        <span class="arr"></span>
                                        <div class="xl"><i></i></div> 
                                        <input name="Area_province" type="hidden" value="" />
                                    </dt><dd></dd>
                                </dl>
                                <dl class="shi">
                                    <dt>
                                        <span class="arr"></span>
                                        <div class="xl"><i></i></div> 
                                        <input name="Area_city" type="hidden" value="" />
                                    </dt><dd></dd>
                                </dl>
                                <dl class="qu">
                                    <dt>
                                        <span class="arr"></span>
                                        <div class="xl"><i></i></div> 
                                        <input name="Area_District" type="hidden" value="" />
                                    </dt><dd></dd>
                                </dl>
                                <script type="text/javascript">
                                        new locatArea("北京市","市辖区","东城区",document.getElementById('citySelectTag'));
                                </script>
                            </div>
                    	
                    	</div>
                    </div>
                	<div class="productNum">
                        <div class="character">产品数量</div>
                    	
                        <div class="divNum">
                        	<input class="subtract" type="button" onclick="subtractProductNum('inputproductNum');"/>
                        	<input class="numinput" type="text"  id="inputproductNum" value="1" name="sumProdct"
                            		onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}"  
                                    onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'0')}else{this.value=this.value.replace(/\D/g,'')}"/>
                        	<input class="plus" type="button" onclick="plusProductNum('inputproductNum');"/>
                            <span class="nums">片</span>
                        </div>
                        
                        
                        <div class="character">计价方式</div>
                        
                        <div class="shootWayCon shootWayjijia">
                            	<ul id="chooseShootjijia">
                					<li class="active"><span>按片</span><i></i></li>
                    				<li><span>按天</span><i></i></li>
 				                   	<li><span>按时</span><i></i></li>
                				</ul>
                        </div>
                        
                        <!--按天-->
                        <div id="divantian">
                        <div class="character">天数</div>
                        <div class="divNum">
                        	<input class="subtract" type="button"  onclick="subtractProductNum('inputproductDay');"/>
                        	<input class="numinput" type="text"  id="inputproductDay" value="1"/>
                        	<input class="plus" type="button" onclick="plusProductNum('inputproductDay');"/>
                            <span class="nums">天</span>
                        </div>
                        </div>
                        <!--按天-->
                        
                        <!--按小时-->
                        <div id="divanxiaoshi">
                        <div class="character">小时数</div>
                        <div class="divNum">
                        	<input class="subtract" type="button"  onclick="subtractProductNum('inputproductHour');"/>
                        	<input class="numinput" type="text"  id="inputproductHour" value="1"/>
                        	<input class="plus" type="button" onclick="plusProductNum('inputproductHour');"/>
                            <span class="nums">小时</span>
                        </div>
                        </div>
                        <!--按小时-->
                    </div>
                	<div class="shootUnitPrice">
                    	
                        <div class="character">拍摄单价</div>
                        
                        <div class="divPrice">
                        	<input class="priceinput" type="text" name="unitpriceProduct"
                            		onkeyup="countTotalMoeyEvent(this)"  
                                    onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'0')}else{this.value=this.value.replace(/\D/g,'')}"/>
                            <span class="pricesp" id="yuanAndPer">元/片</span>
                        </div>
                        
                        <div class="divTotalPrice">总价：<span>0</span>元
                        </div>
                        
                        <div class="checkBox">
                        	<div class="one">
                        		<input id="checkjsbj" type="checkbox" name="ifAskPrice" value="1"/>
                            	<label for="checkjsbj">接受应约者报价</label>
                        	</div>
                            
                        	
                        </div>
                        
                        <div class="character">招标方式</div>
                        <input type="hidden" id="publicOrPrivate" name="publicOrPrivate"/>
                        <div class="shootWayCon">
                            	<ul id="chooseShootzbfs">
                					<li class="active"><span>公开</span><i></i></li>
                    				<li><span>私密</span><i></i></li>
                				</ul>
                                
                                <div id="shootWayConSpanYQ" class="yqhy">私密招标需要邀请好友</div>
                        </div>
                        
                        
                        <div class="invitation">
                        	<div class="one">
                            	<input class="inputinvit" type="button" value="邀请好友/粉丝" onclick="yyyyyyyy();"/>
                            	<span>已邀请</span><a href="javascript:" id="invitationNum">0</a>人
                            </div>
                        </div>
                    </div>
                </div>
                
                <div class="submit">
                
                      <input  type="hidden" name="photoType" id="photoType"/>
                <input  type="hidden" name="bidType" id="bidType" value="1"/>
                 <input  type="hidden" name="type" id="type" value="<s:property value="bidCat.id"/>"/>
                 <input  type="hidden" name="tag" id="tag" value=""/>
                 <input  type="hidden" name="shootingEnvironment" id="shootingEnvironment" value=""/>
                 <input  type="hidden" name="unitpriceType" id="unitpriceType" value=""/>
                  <input  type="hidden" name="sumProductPhoto" id="sumProductPhoto" value="1"/>
                
                
                
                
            		<input class="finished" id="finished" type="button" onclick="verifyFormHd();" value="发布"/>
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
