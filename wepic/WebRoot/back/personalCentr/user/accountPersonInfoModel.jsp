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
<link rel="shortcut icon" href="${pageContext.request.contextPath}//public/images/logoSmall.ico"/>

<title>wepic 个人中心 账户基本资料 用户版 模特</title>



<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/back/js/ajaxforUserInfo.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/back/personalCentr/user/js/accountPersonInfo.js"></script>

<!--公共js-->
<script type="text/javascript" src="${pageContext.request.contextPath}/back/js/provinceCityDistrict.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/back/js/publicBack.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/public.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/topBar.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/header.js"></script>


<!--公共css-->
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public/css/backMainBar.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public/css/topBarMain.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public/css/header.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public/css/footer.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/back/personalCentr/user/css/accountPersonInfo.css" />



<link type="text/css" rel="stylesheet" href="css/accountPersonInfo.css" />
<script type="text/javascript">
var  path="${pageContext.request.contextPath}";
function subform(){
	var birthyea=$("#selectBirthDayYearValue").html();
	var month=$("#selectBirthDayMonthValue").html();
	var days=$("#selectBirthDayMonthValue").html();
   $("#birthdayId").val($.trim(birthyea)+"-"+$.trim(month)+"-"+$.trim(days));
  var sex=$("#selectSexValue").html();
  $("#sexId").val($.trim(sex));
  $("#zodiacId").val($.trim($("#selectSxValue").html()));//生肖
  $("#ConstellationId").val($.trim($("#selectConstellationValue").html()));//星座
  $("#bloodtypeId").val($.trim($("#selectBltValue").html()));
  var homeP=$("#homeP").val();//故乡省
  var homeCity=$("#homeCity").val();//故乡市
  var homexian=$("#homexian").val();//故乡县
$("#homeTownId").val($.trim(homeP)+" "+$.trim(homeCity)+" "+$.trim(homexian));
  var workP=$("#workP").val();//工作地址乡省
  var workCity=$("#workCity").val();//工作地址市
  var workxian=$("#workxian").val();//工作地址县
  $("#workPlaceId").val($.trim(workP)+" "+$.trim(workCity)+" "+$.trim(workxian));

$("#formPersonInfo").submit();

	
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
                    	<a href="javascript:"><span><s:property value="#session.nickName"/></span><i></i></a>
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
  	 <div id="divTwoStage" class="twoStage">
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
        	<div id="personalInfo" class="active tag">个人资料</div></a>
        	
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
            
             <a href="${pageContext.request.contextPath}/user!getGradUserInfo.do"> <div id="userGrade" class="tag">个人等级</div></a>
        
        </div>
        </div>
    </div>
    <!-- 导航  end-->
    
    <!--内容-->
      <form  id="formPersonInfo" action="user!updetaUserBaseInfo.do" method="post">
    <div id="divtPersonInfoModel">
    <div id="divtPersonIn">
  
    	<div class="title">
        	<h2>基本信息</h2>
        </div>
        
        <div class="content">
        	<div class="userName">
        		<span class="left">用户名</span>
            	<span class="name"><s:property value="#session.username"/> </span>
            </div>
            
            <div class="abstract">
        		<span class="leftabstract">我的简介</span>
                <textarea name="context"><s:property value="user.context.trim()"/></textarea>
            </div>
            
            <div class="nickname">
        		<span class="left">昵称</span>
            	<input type="text"  class="inputNickname" name="nickName" value='<s:property value="user.nickName"/>'/>
            </div>
            
            <div class="birthDay">
        		<span class="left">出生日期 </span>
                  <input type="hidden" name="birthday" id="birthdayId" value=<s:property value="user.birthday"/> style="display: none" />
                <div class="editSelect" id="divSelectBirthDayYear">
                    <div class="viewBelow" onclick="showBelow('divSelectBirthDayYearValue')">
                        <div id="selectBirthDayYearValue"> 
                        <s:if test="#detalfor.yeas!=null&&#detalfor.yeas!=''">
                         <s:property value="#detalfor.yeas"/>
                        </s:if>
                        <s:else>
                                                                请选择
                        </s:else>
                        
                       
                        </div>
                       	<div class="viewBelowRight"><i></i></div>    
                    </div>
                    
                           
                    <div  class="belowValue" id="divSelectBirthDayYearValue" style="display:none;">
 					</div>
            	</div>
                
                <div class="editSelect" id="divSelectBirthDayMonth">
                    <div  class="viewBelow" onclick="showBelow('divSelectBirthDayMonthValue')">
                        <div id="selectBirthDayMonthValue"> <s:if test="#detalfor.month!=null&&#detalfor.month!=''">
                         <s:property value="#detalfor.month"/>
                        </s:if>
                        <s:else>
                                                                请选择
                        </s:else>
                        </div>
                       	<div class="viewBelowRight"><i></i></div>    
                    </div>
                           
                    <div  class="belowValue" id="divSelectBirthDayMonthValue" style="display:none;">
 					</div>
            	</div>
                
                <div class="editSelect" id="divSelectBirthDayDay">
                    <div  class="viewBelow" onclick="showBelow('divSelectBirthDayDayValue')">
                        <div id="selectBirthDayDayValue">
                        <s:if test="#detalfor.day!=null&&#detalfor.day!=''">
                         <s:property value="#detalfor.day"/>
                        </s:if>
                        <s:else>
                                                                请选择
                        </s:else>
                        </div>
                       	<div class="viewBelowRight"><i></i></div>    
                    </div>
                           
                    <div  class="belowValue" id="divSelectBirthDayDayValue" style="display:none;">
 					</div>
            	</div>
            </div>
            
            <div class="sexAgeSx">
        		<span class="left">性别</span>
                   <input type="text" name="sex" id="sexId" value='<s:property value="user.sex"/>' style="display: none"/>
                <div class="editSelect" id="divSelectSex">
                    <div class="viewBelow" onclick="showBelow('divSelectSexValue')">
                        <div id="selectSexValue">
                         <s:if test="user.sex!=null&&user.sex!=''">
                         <s:property value="user.sex"/>
                        </s:if>
                        <s:else>
                                                                请选择
                        </s:else>
                        
                        
                        </div>
                       	<div class="viewBelowRight"><i></i></div>    
                    </div>
                           
                    <div  class="belowValue" id="divSelectSexValue">
                    	<span class='selectValueIn'>不选</span>
                        <span class='selectValueIn'>男</span>
                        <span class='selectValueIn'>女</span>
 					</div>
            	</div>
                
                <span class="age">年龄</span>
                <input type="text"  class="inputAge" name="age"  value='<s:property value="user.age"/>'/>
                
                
                <span class="sx">生肖</span>
                  <input type="text" name="zodiac" id="zodiacId"  value='<s:property value="user.zodiac"/>' style="display: none"/>
                <div class="editSelect" id="divSelectSx">
                    <div class="viewBelow" onclick="showBelow('divSelectSxValue')">
                        <div id="selectSxValue"> 
                         <s:if test="user.zodiac!=null&&user.zodiac!=''">
                         <s:property value="user.zodiac"/>
                        </s:if>
                        <s:else>
                                                                请选择
                        </s:else></div>
                       	<div class="viewBelowRight"><i></i></div>    
                    </div>
                           
                    <div  class="belowValue" id="divSelectSxValue">
                    	<span class='selectValueIn'>不选</span>
                        <span class='selectValueIn'>鼠</span>
                        <span class='selectValueIn'>牛</span>
                    	<span class='selectValueIn'>虎</span>
                        <span class='selectValueIn'>兔</span>
                    	<span class='selectValueIn'>龙</span>
                        <span class='selectValueIn'>蛇</span>
                    	<span class='selectValueIn'>马</span>
                        <span class='selectValueIn'>羊</span>
                    	<span class='selectValueIn'>猴</span>
                        <span class='selectValueIn'>鸡</span>
                    	<span class='selectValueIn'>狗</span>
                        <span class='selectValueIn'>猪</span>
 					</div>
            	</div>
            </div>
            
            <div class="constellationBlt">
        		<span class="left">星座</span>
                  <input type="text" name="Constellation" id="ConstellationId"  value='<s:property value="user.Constellation"/>' style="display: none"/>
                <div class="editSelect" id="divSelectConstellation">
                    <div class="viewBelow" onclick="showBelow('divSelectConstellationValue')">
                        <div id="selectConstellationValue">  
                         <s:if test="user.Constellation!=null&&user.Constellation!=''">
                         <s:property value="user.Constellation"/>
                        </s:if>
                        <s:else>
                                                                请选择
                        </s:else>
                        </div>
                       	<div class="viewBelowRight"><i></i></div>    
                    </div>
                           
                    <div  class="belowValue" id="divSelectConstellationValue">
                    	<span class='selectValueIn'>不选</span>
                    	<span class='selectValueIn'>水瓶座</span>
                        <span class='selectValueIn'>双鱼座</span>
                    	<span class='selectValueIn'>白羊座</span>
                        <span class='selectValueIn'>金牛座</span>
                    	<span class='selectValueIn'>双子座</span>
                        <span class='selectValueIn'>巨蟹座</span>
                    	<span class='selectValueIn'>狮子座</span>
                        <span class='selectValueIn'>处女座</span>
                    	<span class='selectValueIn'>天秤座</span>
                        <span class='selectValueIn'>天蝎座</span>
                    	<span class='selectValueIn'>射手座</span>
                        <span class='selectValueIn'>魔羯座</span>
 					</div>
            	</div>
                
                <span class="blt">血型</span>
                <input type="text" name="bloodtype" id="bloodtypeId" value='<s:property value="user.bloodtype"/>' style="display: none"/>
                <div class="editSelect" id="divSelectBlt">
                    <div class="viewBelow" onclick="showBelow('divSelectBltValue')">
                        <div id="selectBltValue">
                        <s:if test="user.bloodtype!=null&&user.bloodtype!=''">
                         <s:property value="user.bloodtype"/>
                        </s:if>
                        <s:else>
                                                                请选择
                        </s:else>



</div>
                       	<div class="viewBelowRight"><i></i></div>    
                    </div>
                           
                    <div  class="belowValue" id="divSelectBltValue">
                    	<span class='selectValueIn'>不选</span>
                    	<span class='selectValueIn'>A型血</span>
                    	<span class='selectValueIn'>B型血</span>
                    	<span class='selectValueIn'>AB型血</span>
                    	<span class='selectValueIn'>O型血</span>
                    	<span class='selectValueIn'>其他型血</span>
 					</div>
            	</div>
                
            </div>
            
              
                
            <div class="address homeTown">
        		<span class="leftAddress">故乡</span>
        		<input type="text" name="homeTown" id="homeTownId" value='<s:property value="user.homeTown"/>' style="display: none" />
                <div class="adr" id="citySelectTag">
                    <dl class="dl1">
                        <dt>
                            <span class="arr"></span>
                            <div class="xl"><i></i></div> 
                            <input name="Area_province"   id="homeP" type="hidden" value='<s:property value="#detalfor.sheng" escape="false"/>' />
                        </dt><dd></dd>
                    </dl>
                    <dl class="dl2">
                        <dt>
                        	<span class="arr"></span>
                            <div class="xl"><i></i></div> 
                        	<input name="Area_city" type="hidden" value='<s:property value="#detalfor.city" escape="false" />' id="homeCity" />
                        </dt><dd></dd>
                    </dl>
                    <dl class="dl3">
                        <dt>
                           <span class="arr"></span>
                           <div class="xl"><i></i></div> 
                           <input name="Area_District" type="hidden" value="" id="homexian" />
                        </dt><dd></dd>
                    </dl>
              <script type="text/javascript">
              var sheng='<s:property value="#detalfor.sheng" escape="false" />';
              var shi='<s:property value="#detalfor.city" escape="false" />';
              var xian='<s:property value="#detalfor.xian" escape="false" />';
              if(sheng==null||$.trim(sheng)==""){
              	sheng='北京市';
              	shi='市辖区';
              	xian='东城区';
                  }
              
                        new locatArea(sheng,shi,xian,document.getElementById('citySelectTag'));
                </script>
                </div>			
            </div>
            
            
            <div class="address">
        		<span class="leftAddress">工作地</span>
        		<input type="text" name="workPlace" id="workPlaceId" value='<s:property value="user.workPlace"/>'   style="display: none"/>
                <div class="adr" id="citySelectTag2">
                    <dl class="dl4">
                        <dt>
                            <span class="arr"></span>
                            <div class="xl"><i></i></div> 
                            <input name="Area_province" type="hidden" value=""  id="workP"/>
                        </dt><dd></dd>
                    </dl>
                    <dl class="dl5">
                        <dt>
                        	<span class="arr"></span>
                            <div class="xl"><i></i></div> 
                        	<input name="Area_city" type="hidden" value="" id="workCity" />
                        </dt><dd></dd>
                    </dl>
                    <dl class="dl6">
                        <dt>
                           <span class="arr"></span>
                           <div class="xl"><i></i></div> 
                           <input name="Area_District" type="hidden" value="" id="workxian" />
                        </dt><dd></dd>
                    </dl>
                <script type="text/javascript">
                var sheng='<s:property value="#adress.sheng" escape="false" />';
                var shi='<s:property value="#adress.city" escape="false" />';
                var xian='<s:property value="#adress.xian" escape="false" />';
                if(sheng==null||$.trim(sheng)==""){
                	sheng='北京市';
                	shi='市辖区';
                	xian='东城区';
                    }
                    
                        new locatArea(sheng,shi,xian,document.getElementById('citySelectTag2'));
                
                
                
                </script>
                </div>
            </div>
            
        </div>
        
      
   
    </div>
    
    <div id="divtPersonInfoMo">
    	
        	<div class="title">
        		<h2>模特基本信息 </h2>
        	</div>
    		<div class="content" id="contentModelInf">
            	<div class="first">
                	<span>身高</span>
                    <input type="text" class="inputStature" name="height" value='<s:property value="user.height"/>'/>
                </div>
                
                <div class="first">
                	<span>体重</span>
                    <input type="text" class="inputWeight" name="weight" value='<s:property value="user.weight"/>'/>
                </div>
                
                <div class="first">
                	<span>发色</span>
                    <input type="text" class="inputHairColor" name="hairColor" value='<s:property value="user.hairColor"/>'/>
                </div>
                
                <div class="first">
                	<span>胸围</span>
                    <input type="text" class="inputChest" name="bust" value='<s:property value="user.bust"/>'/>
                </div>
                
                <div class="first">
                	<span>腰围</span>
                    <input type="text" class="inputWaist" name="waist" value='<s:property value="user.waist"/>'/>
                </div>
                
                <div class="first">
                	<span>臀围</span>
                    <input type="text" class="inputHip" name="newhip" value='<s:property value="user.newhip"/>'/>
                </div>
                
                <div class="first">
                	<span>鞋码</span>
                    <input type="text" class="inputShoeSize" name="shoeSize" value='<s:property value="user.shoeSize"/>'/>
                </div>
                
            </div>
            
            <div class="addP">
            	<span class="spanAddP">新项目名</span>
                <input type="text" class="inputAddP" id="inputAddProV" onkeyup="doit(this)" onafterpaste="doit(this)"/>
                <input type="button" value="添加" class="buttomAddP" onclick="addProModel('inputAddProV','contentModelInf');"/>
                <span class="spanAddTS">新增项目不超过2个，名称长度不超过5个汉字</span>
            </div>
        
        	<div class="preserve">
        		<input type="button" value="保存" onclick="subform()"/>
        	</div>
    	
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
<!--[if lte IE 6]>
<script src="${pageContext.request.contextPath}/public/js/DD_belatedPNG_0.0.8a.js" type="text/javascript"></script>
    <script type="text/javascript">
        DD_belatedPNG.fix('div, ul, img, li, input , a , i');
    </script>
<![endif]-->


</body>
</html>