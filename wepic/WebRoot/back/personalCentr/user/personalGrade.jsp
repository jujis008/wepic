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
<meta name="robots" content="index,follow" />

<title>wepic管理_个人中心_账户基本资料_个人等级</title>

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/back/personalCentr/user/css/personalGrade.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/back/personalCentr/user/js/personalGrade.js"></script>

<!--公共js-->
<script type="text/javascript" src="${pageContext.request.contextPath}/back/js/publicBack.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}//public/js/public.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/topBar.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/header.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}//back/js/ajaxforUserInfo.js"></script>

<!--公共css-->
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public/css/backMainBar.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public/css/topBarMain.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public/css/header.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public/css/footer.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public/css/public.css" />
<style  type="text/css">

.alt{
		background:#FAFAFA;
		}
		.over{
			background: #FFC;
			
			
			}


</style>
<script type="text/javascript">
var path="${pageContext.request.contextPath}";

$(document).ready(function(){  
	$("#tableR tr:odd").addClass("alt");
	$("#tableR tr").mouseover(function(){  
            //如果鼠标移到class为stripe的表格的tr上时，执行函数
    $(this).addClass("over");}).mouseout(function(){ 
                            //给这行添加class值为over，并且当鼠标一出该行时执行函数
    $(this).removeClass("over");})//点击变色,注意：因为有隔行变色，所以这里必须在触发toggleClass时,remove("alt").


     //给class为stripe的表格的偶数行添加class值为alt
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
                    	<a href="javascript:"><span>
                    	<s:property value="#session.nickName"/>
                    	</span><i></i></a>
                    </div>
                    
                	<div id="topBarUserDetailed">
                    	<div id="topBarUserOne">
                        	<div id="topBarUserOneHead">
                            	<img src="${pageContext.request.contextPath}/public/images/pic/topUser.jpg"  id="porperties"/>
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
        	<a href="${pageContext.request.contextPath}/user!getFistPageUserInfo.do"><div class="bar"><span>
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
            <div class='bar active'><span>账户基本资料</span><i></i></div></a>
            
            <!-- story!initdata.do -->
            <a href="<%= basePath%>story!storylist.do"><div class='bar'><span>我的作品库</span><i></i></div></a>
            
            <a href="${pageContext.request.contextPath}/catBid!findByrootType.do"><div class='bar'><span>我的约拍</span><i></i></div></a>
            
            <a href="javascript:"><div class='bar'><span>我买到的作品</span><i></i></div></a>
            
           <a href="javascript:"> <div class='bar'><span>收藏/订阅/推荐</span><i></i></div></a>
        </div>
    	
        <div id="divThreeStage">
        
        <div class="threeStage">
       <s:if test="#session.personOrCompany==2">
        <a href="${pageContext.request.contextPath}/user!baseUseInfo.do?message=enpr"><div id="enterpriseInfo" class="tag">企业信息</div></a>
        	</s:if>
        	<s:else>
        	<s:if test="#session.role=='model'">
        	<a href="${pageContext.request.contextPath}/user!baseUseInfo.do?message=model">
        	</s:if>
        	<s:else>
        	<a href="${pageContext.request.contextPath}/user!baseUseInfo.do?message=all">
        	</s:else>
        	<div id="personalInfo" class="tag">个人资料</div></a>
        	
        	</s:else>
        	
             <s:if test="#session.personOrCompany==2">
            <a href="${pageContext.request.contextPath}/back/personalCentr/user/accountEnterpriseHead.jsp"> 
            </s:if>
            <s:else>
             <a href="${pageContext.request.contextPath}/back/personalCentr/user/accountPic.jsp"> 
            </s:else>
            
            <div id="editHead" class="tag">修改头像</div></a>
            <s:if test="#session.personOrCompany!=2">
             <a href="${pageContext.request.contextPath}/user!getByEducation.do"><div id="education" class="tag">教育情况</div></a>
            </s:if>
             <a href="${pageContext.request.contextPath}/usperPower!getAllUserPowerInfo.do"> <div id="strength" class="tag">实力证明</div></a>
            
            <a href="${pageContext.request.contextPath}/user!findroleTagsbyrole.do"> <div id="myTag" class="tag">我的标签</div></a>
            
             <a href="${pageContext.request.contextPath}/user!getGradUserInfo.do"> <div id="userGrade" class="active tag">个人等级</div></a>
        
        </div>
        </div>
    </div>
    <!-- 导航  end-->
    
    <!--内容-->
    <div id="divPersonalGrade">
   		<div class="divhead">
        	<div class="headLeft">
        	<s:if test="userInfoBeans.portrait==null">
        	 <img src="${pageContext.request.contextPath}/back/pubimg/images/defaultHead_150.png" />
        	</s:if>
        	<s:else>
        	
        	
        	<img src="<s:property value="userInfoBeans.portrait"/>" />
        	</s:else>
               
            </div>
            <div class="headCon">
            	<div class="one">
                    <h2><s:property value="userInfoBeans.nickName"/></h2>
                    <div class="divIden">
                        <s:if test="#session.personOrCompany==2">
                            
                             <s:if test="userInfoBeans.ifIdentityTrue==2">
                             <a href="javascript:" class="idenq" title="企业身份已认证"></a>
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
                </div>
                <div class="two">
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
                            <span class="now">当前等级：</span>
                            <span><s:property value="userInfoBeans.degee"/></span>
                            <span class="next">距离下一等级：
                            </span>
                            <span><s:property value="userInfoBeans.nextDegeeMark"/></span></span>
                            <span>积分</span>
                        </div>  	
                </div>
                
                <div class="three">
                   <span class="tom">昨天收入积分：</span>
                   <span>3</span> 	
                </div>
                
                
                <div class="gradeBox">
                   <div class="nowGrade" style="width:<s:property value="userInfoBeans.baif"/>"></div> 	
                </div>
                
                <div class="five">
                	<font class="nowg">LV<s:property value="userInfoBeans.degee"/></font>
                   	<span class="ng">当前积分：</span>
                   	<span><s:property value="userInfoBeans.userMess.totalMark"/></span> 
                    <font class="nextg">LV<s:property value="userInfoBeans.degee+1"/></font>	
                </div>
            </div>
            
            <div class="headRight">
            	<div class="one"><a href="javascript:">查看等级规则</a></div>
                <div class="two"><span>等级排名</span></div>
                <div class="paim"><span>121212</span></div>
            </div>
        </div>
        
        <!--积分记录-->
        <div class="divGradeRecord">
        	<div class="divRecord">
            	<div class="character">最近一月积分获得记录:
            	<s:property value="pager.endPage"/>
            	</div>
                <div class="divTableR">
                	<table id="tableR" >
                    	<tr class="top">
                    	<td class="time td1">时间</td>
                    	<td class="scro td2">积分</td>
                    	<td class="conn td3">内容</td>
                    	<td class="remark td4">备注</td>
                    	</tr>                  
                      <s:iterator value="pager.resultList" var="cread">
                       <tr><td class="td1"><span>
                       
                       </span><span class="spanHo"><s:property value="#cread.endTime"/></span></td><td class="td2">+<span><s:property value="#cread.mark"/></span></td><td class="td3"><s:property value="#cread.addmarkreson"/></td><td class="td4">无</td></tr>
                      
                      </s:iterator>
                      
                      
                      
                      
                        
                        
                    </table>
                </div>
                
                 <!--翻页-->
        		<div class="ppointPaging" style="float:left">            
           			<table class="tablePpointPaging" style="float: left">
                		<tr>
                    		<td class="ppointPagingOne"><a href="javascript:"></a></td>
                       	 	<td class="ppointPagingPre"><a href="javascript:"></a></td>
                       	 	<s:iterator value="new int[pager.endPage]" status="numb">
                       	 	<s:if test="pager.pageNo==#numb.index+1">
                       	 	<td class="ppointPagingN page">
                       	 	<a href="user!getGradUserInfo.do?pageNo= <s:property value="#numb.index+1"/>">
                              <s:property value="#numb.index+1"/>
                             </a>
                             </td>
                             </s:if>
                             <s:else>
                            <td class="ppointPagingN">
                       	 	<a href="user!getGradUserInfo.do?pageNo= <s:property value="#numb.index+1"/>">
                              <s:property value="#numb.index+1"/>
                             </a>
                             </td>
                             </s:else>
                       	 	</s:iterator>
                       	 	
                       	 	
                       	 	
                    		
                        	
                    		<td class="ppointPagingNext"><a href="javascript:"></a></td>
                       	 	<td class="ppointPagingLast"><a href="javascript:"></a></td>
                    	</tr>
                	</table>
        		</div>
        		<!--翻页-->
            </div>
            <div class="divGoodFriend">
            	<div class="character">
                	<span class="good">互粉好友排名</span>
                    我在第<span class="me">221</span>名
                </div>
                
                <div class="allGoodFriend">
                	<ul>
                    	<li>
                        	<div class="divfriend">
                            	<div class="num"><a class="qt">1</a></div>
                                <div class="he"><img src="../../public/pic/3.png" /></div>
                            	<div class="co">
                                	<div class="one">
                    					<h2>张惠妹</h2>
                					</div>
                					<div class="two">
                        				<a href="javascript:" class="iden" title="个人身份已验证"></a>
                        				<a href="javascript:" class="collect" title="推荐摄影师"></a>
                					</div>
                
               						 <div class="three">
                                     	<div class="divGrade">
                                        	<span>当前等级</span>
                            				<span class="now">23</span>
                            				<img src="${pageContext.request.contextPath}/public/images/grade/diamond.png" />
											<img src="${pageContext.request.contextPath}/public/images/grade/diamond.png"/>
											<img src="${pageContext.request.contextPath}/public/images/grade/star.png"/>
											<img src="${pageContext.request.contextPath}/public/images/grade/star.png"/>
											<img src="${pageContext.request.contextPath}/public/images/grade/star.png"/>
                        				</div>
                   						<div>
                                        	<span class="tom">已获积分</span>
                   							<span>23432</span> 
                                        </div>	
                					</div>
                                </div>
                            
                            </div>
                        </li>
                        
                        <li>
                        	<div class="divfriend">
                            	<div class="num"><a class="qt">2</a></div>
                                <div class="he"><img src="../../public/pic/3.png" /></div>
                            	<div class="co">
                                	<div class="one">
                    					<h2>张惠妹</h2>
                					</div>
                					<div class="two">
                        				<a href="javascript:" class="iden" title="个人身份已验证"></a>
                        				<a href="javascript:" class="collect" title="推荐摄影师"></a>
                					</div>
                
               						 <div class="three">
                                     	<div class="divGrade">
                                        	<span>当前等级</span>
                            				<span class="now">23</span>
                            				<img src="${pageContext.request.contextPath}/public/images/grade/diamond.png" />
											<img src="${pageContext.request.contextPath}/public/images/grade/diamond.png"/>
											<img src="${pageContext.request.contextPath}/public/images/grade/star.png"/>
											<img src="${pageContext.request.contextPath}/public/images/grade/star.png"/>
											<img src="${pageContext.request.contextPath}/public/images/grade/star.png"/>
                        				</div>
                   						<div>
                                        	<span class="tom">已获积分</span>
                   							<span>23432</span> 
                                        </div>	
                					</div>
                                </div>
                            
                            </div>
                        </li>
                        
                        <li>
                        	<div class="divfriend">
                            	<div class="num"><a class="qt">3</a></div>
                                <div class="he"><img src="../../public/pic/3.png" /></div>
                            	<div class="co">
                                	<div class="one">
                    					<h2>张惠妹</h2>
                					</div>
                					<div class="two">
                        				<a href="javascript:" class="iden" title="个人身份已验证"></a>
                        				<a href="javascript:" class="collect" title="推荐摄影师"></a>
                					</div>
                
               						 <div class="three">
                                     	<div class="divGrade">
                                        	<span>当前等级</span>
                            				<span class="now">23</span>
                            				<img src="${pageContext.request.contextPath}/public/images/grade/diamond.png" />
											<img src="${pageContext.request.contextPath}/public/images/grade/diamond.png"/>
											<img src="${pageContext.request.contextPath}/public/images/grade/star.png"/>
											<img src="${pageContext.request.contextPath}/public/images/grade/star.png"/>
											<img src="${pageContext.request.contextPath}/public/images/grade/star.png"/>
                        				</div>
                   						<div>
                                        	<span class="tom">已获积分</span>
                   							<span>23432</span> 
                                        </div>	
                					</div>
                                </div>
                            
                            </div>
                        </li>
                        
                        <li>
                        	<div class="divfriend">
                            	<div class="num"><a class="hm">4</a></div>
                                <div class="he"><img src="../../public/pic/3.png" /></div>
                            	<div class="co">
                                	<div class="one">
                    					<h2>张惠妹</h2>
                					</div>
                					<div class="two">
                        				<a href="javascript:" class="iden" title="个人身份已验证"></a>
                        				<a href="javascript:" class="collect" title="推荐摄影师"></a>
                					</div>
                
               						 <div class="three">
                                     	<div class="divGrade">
                                        	<span>当前等级</span>
                            				<span class="now">23</span>
                            				<img src="${pageContext.request.contextPath}/public/images/grade/diamond.png" />
											<img src="${pageContext.request.contextPath}/public/images/grade/diamond.png"/>
											<img src="${pageContext.request.contextPath}/public/images/grade/star.png"/>
											<img src="${pageContext.request.contextPath}/public/images/grade/star.png"/>
											<img src="${pageContext.request.contextPath}/public/images/grade/star.png"/>
                        				</div>
                   						<div>
                                        	<span class="tom">已获积分</span>
                   							<span>23432</span> 
                                        </div>	
                					</div>
                                </div>
                            
                            </div>
                        </li>
                        
                        <li>
                        	<div class="divfriend">
                            	<div class="num"><a class="hm">5</a></div>
                                <div class="he"><img src="../../public/pic/3.png" /></div>
                            	<div class="co">
                                	<div class="one">
                    					<h2>张惠妹</h2>
                					</div>
                					<div class="two">
                        				<a href="javascript:" class="iden" title="个人身份已验证"></a>
                        				<a href="javascript:" class="collect" title="推荐摄影师"></a>
                					</div>
                
               						 <div class="three">
                                     	<div class="divGrade">
                                        	<span>当前等级</span>
                            				<span class="now">23</span>
                            				<img src="${pageContext.request.contextPath}/public/images/grade/diamond.png" />
											<img src="${pageContext.request.contextPath}/public/images/grade/diamond.png"/>
											<img src="${pageContext.request.contextPath}/public/images/grade/star.png"/>
											<img src="${pageContext.request.contextPath}/public/images/grade/star.png"/>
											<img src="${pageContext.request.contextPath}/public/images/grade/star.png"/>
                        				</div>
                   						<div>
                                        	<span class="tom">已获积分</span>
                   							<span>23432</span> 
                                        </div>	
                					</div>
                                </div>
                            
                            </div>
                        </li>
                        
                        <li>
                        	<div class="divfriend">
                            	<div class="num"><a class="hm">6</a></div>
                                <div class="he"><img src="../../public/pic/3.png" /></div>
                            	<div class="co">
                                	<div class="one">
                    					<h2>张惠妹</h2>
                					</div>
                					<div class="two">
                        				<a href="javascript:" class="iden" title="个人身份已验证"></a>
                        				<a href="javascript:" class="collect" title="推荐摄影师"></a>
                					</div>
                
               						 <div class="three">
                                     	<div class="divGrade">
                                        	<span>当前等级</span>
                            				<span class="now">23</span>
                            				<img src="${pageContext.request.contextPath}/public/images/grade/diamond.png" />
											<img src="${pageContext.request.contextPath}/public/images/grade/diamond.png"/>
											<img src="${pageContext.request.contextPath}/public/images/grade/star.png"/>
											<img src="${pageContext.request.contextPath}/public/images/grade/star.png"/>
											<img src="${pageContext.request.contextPath}/public/images/grade/star.png"/>
                        				</div>
                   						<div>
                                        	<span class="tom">已获积分</span>
                   							<span>23432</span> 
                                        </div>	
                					</div>
                                </div>
                            
                            </div>
                        </li>
                        
                        <li>
                        	<div class="divfriend">
                            	<div class="num"><a class="hm">7</a></div>
                                <div class="he"><img src="../../public/pic/3.png" /></div>
                            	<div class="co">
                                	<div class="one">
                    					<h2>张惠妹</h2>
                					</div>
                					<div class="two">
                        				<a href="javascript:" class="iden" title="个人身份已验证"></a>
                        				<a href="javascript:" class="collect" title="推荐摄影师"></a>
                					</div>
                
               						 <div class="three">
                                     	<div class="divGrade">
                                        	<span>当前等级</span>
                            				<span class="now">23</span>
                            				<img src="${pageContext.request.contextPath}/public/images/grade/diamond.png" />
											<img src="${pageContext.request.contextPath}/public/images/grade/diamond.png"/>
											<img src="${pageContext.request.contextPath}/public/images/grade/star.png"/>
											<img src="${pageContext.request.contextPath}/public/images/grade/star.png"/>
											<img src="${pageContext.request.contextPath}/public/images/grade/star.png"/>
                        				</div>
                   						<div>
                                        	<span class="tom">已获积分</span>
                   							<span>23432</span> 
                                        </div>	
                					</div>
                                </div>
                            
                            </div>
                        </li>
                        
                        <li>
                        	<div class="divfriend">
                            	<div class="num"><a class="hm">8</a></div>
                                <div class="he"><img src="../../public/pic/3.png" /></div>
                            	<div class="co">
                                	<div class="one">
                    					<h2>张惠妹</h2>
                					</div>
                					<div class="two">
                        				<a href="javascript:" class="iden" title="个人身份已验证"></a>
                        				<a href="javascript:" class="collect" title="推荐摄影师"></a>
                					</div>
                
               						 <div class="three">
                                     	<div class="divGrade">
                                        	<span>当前等级</span>
                            				<span class="now">23</span>
                            				<img src="${pageContext.request.contextPath}/public/images/grade/diamond.png" />
											<img src="${pageContext.request.contextPath}/public/images/grade/diamond.png"/>
											<img src="${pageContext.request.contextPath}/public/images/grade/star.png"/>
											<img src="${pageContext.request.contextPath}/public/images/grade/star.png"/>
											<img src="${pageContext.request.contextPath}/public/images/grade/star.png"/>
                        				</div>
                   						<div>
                                        	<span class="tom">已获积分</span>
                   							<span>23432</span> 
                                        </div>	
                					</div>
                                </div>
                            
                            </div>
                        </li>
                        
                        <li>
                        	<div class="divfriend">
                            	<div class="num"><a class="hm">9</a></div>
                                <div class="he"><img src="../../public/pic/3.png" /></div>
                            	<div class="co">
                                	<div class="one">
                    					<h2>张惠妹</h2>
                					</div>
                					<div class="two">
                        				<a href="javascript:" class="iden" title="个人身份已验证"></a>
                        				<a href="javascript:" class="collect" title="推荐摄影师"></a>
                					</div>
                
               						 <div class="three">
                                     	<div class="divGrade">
                                        	<span>当前等级</span>
                            				<span class="now">23</span>
                            				<img src="${pageContext.request.contextPath}/public/images/grade/diamond.png" />
											<img src="${pageContext.request.contextPath}/public/images/grade/diamond.png"/>
											<img src="${pageContext.request.contextPath}/public/images/grade/star.png"/>
											<img src="${pageContext.request.contextPath}/public/images/grade/star.png"/>
											<img src="${pageContext.request.contextPath}/public/images/grade/star.png"/>
                        				</div>
                   						<div>
                                        	<span class="tom">已获积分</span>
                   							<span>23432</span> 
                                        </div>	
                					</div>
                                </div>
                            
                            </div>
                        </li>
                        
                        <li>
                        	<div class="divfriend">
                            	<div class="num"><a class="hm">10</a></div>
                                <div class="he"><img src="../../public/pic/3.png" /></div>
                            	<div class="co">
                                	<div class="one">
                    					<h2>张惠妹</h2>
                					</div>
                					<div class="two">
                        				<a href="javascript:" class="iden" title="个人身份已验证"></a>
                        				<a href="javascript:" class="collect" title="推荐摄影师"></a>
                					</div>
                
               						 <div class="three">
                                     	<div class="divGrade">
                                        	<span>当前等级</span>
                            				<span class="now">23</span>
                            				<img src="${pageContext.request.contextPath}/public/images/grade/diamond.png" />
											<img src="${pageContext.request.contextPath}/public/images/grade/diamond.png"/>
											<img src="${pageContext.request.contextPath}/public/images/grade/star.png"/>
											<img src="${pageContext.request.contextPath}/public/images/grade/star.png"/>
											<img src="${pageContext.request.contextPath}/public/images/grade/star.png"/>
                        				</div>
                   						<div>
                                        	<span class="tom">已获积分</span>
                   							<span>23432</span> 
                                        </div>	
                					</div>
                                </div>
                            
                            </div>
                        </li>
                        
                        
                    </ul>
                </div>
                
            </div>
            
            <div style="clear:both;"></div>
        </div>
        
        <div class="intro">
        	<div class="gainGrade">
            	<div class="cha">获取积分方式：</div>
                <div class="charact">①您可以通过充值您可以通过充值您可以通过充值您可以通过充值您可以通过充值</div>
                <div class="charact">②您可以通过充值您可以通过充值您可以通过充值您可以通过充值</div>
                <div class="charact">③您可以通过充值您可以通过充值您可以通过充值您可以通过充值您可以通过充值</div>
            </div>
            
            <div class="privilegeLevel">
            	<div class="gainGrade">
            	<div class="cha">等级特权：</div>
                <div class="charact">①您可以通过充值您可以通过充值您可以通过充值您可以通过充值您可以通过充值您可以通过充值您可以通过充值</div>
                <div class="charact">②您可以通过您可以通过充值您可以通过充值您可以通过充值您可以通过充值充值</div>
                <div class="charact">③您可以通过充值您可以通过充值您可以通过充值您可以通过充值您可以通过充值您可以通过充值</div>
            </div>
            </div>
        </div>
        <!--积分记录-->
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
    
	<div id="goTopBtn" style="display:none;" title="回顶部"></div>
</div>
<!--[if lte IE 6]>
<script src="../../..//public/js/DD_belatedPNG_0.0.8a.js" type="text/javascript"></script>
    <script type="text/javascript">
        DD_belatedPNG.fix('div, ul, img, li, input , a , i');
    </script>
<![endif]-->


</body>
</html>
