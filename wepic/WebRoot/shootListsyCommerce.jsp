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
<title>wepic唯图_商业拍摄,摄影师招募,模特招募,图片征集</title>
<meta name="keywords"  content="wepic,唯图,唯图网,商业拍摄,摄影师招募,模特招募,图片征集,产品拍摄,广告拍摄,宣传片拍摄,广告片拍摄,商业图片,图片素材,摄影图片,原创图片,摄影师,模特,平面模特,服装模特,车模,产品形象模特,少儿模特,商务模特"/>
<meta name="description" content="唯图网是商业拍摄与原创商业图片的交易平台，唯图为创意产业领域提供商业拍摄,模特与摄影师招募,原创商业图片素材,视频素材,音频素材,摄影故事,图片征集,创意设计等的交易与展示分享平台"/>

<link rel="shortcut icon" href="${pageContext.request.contextPath}/public/images/logoSmall.ico"/>


<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/jquery.js"></script>
<!--公共js-->
<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/public.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/topBar.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/header.js"></script>



<!--公共css-->
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public/css/topBarMain.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public/css/public.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public/css/header.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public/css/mainBar.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public/css/footer.css" />


<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public/frontPage/shoot/css/shootListsyCommerce.css" />
<script type="text/javascript">
var str='<s:property value="bid.workStartTime"/>';

var re = new RegExp("[-]", "g");

str  = str.replace(re, "/");


</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/frontPage/shoot/js/shootListsyCommerce.js"></script>

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
    
    
    <!-- logo行-->
    
    
    <div id="mainbar">
    	<div id="mainbarCenter">
    		<ul>
        		<li id="liindex">
            		<a href="javascript:void(0)">首页</a>
            	</li>
            	<li class="active" id="mainbarCenterLi2">
            		<a href="javascript:void(0)">商业拍摄</a>
            	</li>
            	<li>
            		<a href="javascript:void(0)">摄影图片</a>
           	 	</li>
            	<li>
            		<a href="javascript:void(0)">创意图片</a>
            	</li>
            	<li>
            		<a href="javascript:void(0)">摄影故事</a>
            	</li>
            	<li>
            		<a href="javascript:void(0)">摄影师</a>
            	</li>
            	<li>
            		<a href="javascript:void(0)">模特</a>
            	</li>
        	</ul>
        </div>
	</div>
    
	<!-- logo行 end-->
	

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
                	<div class="character">发布人</div>
                	<div class="account_info_com">
                        <div class="headImg"><s:if test='bid.user.smallportrait==null||bid.user.smallportrait==""'>
                          <div class="headImgCon"><!--  -->
                              <!--默认头像--><img class="head" src="${pageContext.request.contextPath}/public/images/defaultHead_80.png" /><!--默认头像-->
                             </s:if>
                             <s:else>
                             <!--默认头像--><img class="head" src="<s:property value="bid.user.smallportrait"/>" /><!--默认头像-->
                             
                                                   </s:else>
                             <!-- <img src="../../back/pubimg/pic/3.png" class="head"/>-->
                              <img src="back/pubimg/images/radHead.png" class="radius"/>
                          </div>
                        </div>
                        <div class="info">
                            <div class="name">
                                <span><s:property value="bid.user.nickName"/></span>
                                <a class="gradeThree"></a>
                                <!-- <a class="approveNo" title="未实名认证"></a>
                                <a class="approveHave" title="个人实名认证"></a>-->
                                <!-- <a class="approveQy" title="企业实名认证"></a>-->
                                
                                
                                 <s:if test="bid.user.personOrCompany==2">
                            
                             <s:if test="bid.user.ifIdentityTrue==2">
                             <a href="javascript:" class="approveQy" title="企业身份已认证"></a>
                             </s:if>
                             
                             <s:else>
                        	<a href="javascript:" class="approveNo" title="企业身份未认证"></a>
                        	</s:else>
                            </s:if>
                            <s:else>
                             <s:if test="bid.user.ifIdentityTrue==2">
                            <a href="javascript:" class="approveHave" title="个人身份已认证"></a>
                            </s:if>
                            <s:else>
                        	<a href="javascript:" class="approveNo" title="个人身份未认证"></a>
                        	
                            </s:else>
                            
                        	
                        	</s:else>
                        	
                        	
                                
                            </div>
                            <div class="detail">
                                <a class="age" title="年龄"><span><s:property value="bid.user.age"/>   </span>岁</a>
                                <a class="address" title="地址"><span><s:property value="bid.user.workPlace"/></span></a>
                                <div class="job" title="职业"><span><s:property value="bid.user.userCat.name"/></span><a></a></div>
                                
                            </div>
                            
                        </div>
                        
                        <div class="time">
                        
                        </div>
                    </div>
                    
                    
                </div>
            </div>
            <!--招标状态-->
            </div>
            
            <!-- 标题部分-->
            <div class="divProjectTitle">
           	 	<div class="titleRightps" title="该项目属于商业拍摄类型"></div>
                <!--<div class="titleRightmt" title="该项目属于找模特类型"></div>-->
                <!--<div class="titleRightzj" title="该项目属于作品征集类型"></div>-->
                <!--<div class="titleRightwp" title="该项目属于外拍类型"></div>-->
                <div class="titleTop">
                	<div class="title" id="topBarUserAccountYE">
                    	<span class="topName" title="<s:property value="bid.name"/>" alt="<s:property value="bid.name"/>"><s:property value="bid.name"/></span>
                        <i class="privacyI"></i>
                    </div>
                        
                    <div class="topIco">
                        <a class="view" title="浏览次数"><span>0</span></a>
                        <a class="collect" title="收藏次数"><span>0</span></a>
                        <a class="good" title="好评次数"><span>0</span></a>    
                    </div>
                </div>
                
                <div class="titleBottom">
                    <!--寄拍		代码-->
                    <table>
                    	<tr>
                        	<td class="tdone">
                            	<!--<span class="in">项目酬金将在项目开始前托管</span>
                            	<span class="ined">项目资金已托管</span>
                            	-->
                            </td>
                        	<td class="tdtwo"><span class="bh">项目编号:</span><span class="num">
                        	<s:property value="bid.id"/>
                        	</span></td>
                            <td class="tdthree">应约时间：剩余</td>
                            <td class="tdfour">
                            	<form name="formnow" id="daojishi">
                                    <input value="" name="dd" size="1" type="text" class="daojishi1" >
                                        天
                                    <input value="" name="hh" size="1" type="text" class="daojishiT">
                                        小时
                                    <input value="" name="mm" size="1" type="text" class="daojishiT">
                                        分
                                    <input value="" name="ss" size="1" type="text" class="daojishiT">
                                    秒 
                                </form>
                            </td>
                        	<td class="tdfive">发布时间：<span class="tt">35</span><span>分钟</span>前</div></td>
                        </tr>
                    </table>
                    <!--寄拍		代码-->
                    
                </div>
            </div>
            <!-- 标题部分-->
            
            
            <!--拍摄内容-->
        	<div class="divShoot">
            	<table>
                	<tr>
                    	<td class="td1">拍摄内容：</td>
                    	  

                    	
                        <td><span class="shootC shootCP"><s:property value="bid.bidCat.name"/></span><span class="shootC productType"><s:property value="bid.tag"/></span></td>
                        
                    </tr>
                
                </table>
            </div>
            <!--拍摄内容-->
            
            
            <!--招标-->
            <!--跟拍		代码-->
            <div class="divInviteBids">
            	<table>
                	<tr>
                    	<td rowspan="3" class="icobid"><div></div></td>
                    	<td class="td2"><span>拍摄时间：</span></td>
                        <td class="td3"><span><s:property value="bid.workStartTime"/></span><a href="javascript:"></a></td>
                        <td class="td4"><span>   <s:if test="bid.photoType==2">
                                                                            拍摄方式：
                            </s:if>
                            <s:else>
                                                                       拍摄地点：
                           </s:else> </span></td>
                        <td class="td5"> 
                        <s:property value="bid.workPlace"/>
                        <span class="shootBg shootType"><s:if test="bid.shootingEnvironment==1">
                                                                                      内景拍摄</s:if>
                                                  <s:elseif test="bid.shootingEnvironment==2">
                                                                                                                                  外景拍摄
                                                  </s:elseif>    
                                                  <s:elseif test="bid.shootingEnvironment==0">
                                                                                                                                      拍摄环境不限
                                                  </s:elseif>   </span><span class="shootBg shootgp"> <s:if test="bid.photoType==0">拍摄方式不限</s:if>
                     <s:elseif test="bid.photoType==1">
                                                       跟拍
                     </s:elseif>
                    <s:elseif test="bid.photoType==2">
                                                       寄拍
                     </s:elseif>     
                     </span>
                        
                        
                        </td>
                    </tr>
                    
                    <tr>
                    	 <s:if test="bid.recruitNum!=null||bid.recruitNum.trim()!=''">
                    	<td class="td2"><span>
                    	 <s:if test="bid.unitpriceType==2">
                                                                 工作天数:</s:if>
                        <s:elseif test="bid.unitpriceType=3">工作时数:</s:elseif>
                    	
                    	
                    	</span></td>
                        <td class="td3"><span>
                        <s:property value="bid.recruitNum"/>
                        
                        </span>  
                        <s:if test="bid.unitpriceType==2">天</s:if>
                        <s:elseif test="bid.unitpriceType=3">小时</s:elseif>
                      
                        
                        <span class="shootBg shootjj">按<s:if test="bid.unitpriceType==2">天</s:if><s:elseif test="bid.unitpriceType=3">小时</s:elseif>计价</span></td>
                        </s:if>
                        
                        <td class="td4"><span>需拍<s:if test="bid.sumProductPhoto==1">片数:</s:if><s:elseif test="bid.sumProductPhoto==3">时长:</s:elseif><s:else>产品:</s:else></span></td>
                        <td class="td3"><span>
                         <s:property value="bid.sumProdct"/>
                           <s:if test="bid.sumProductPhoto==1">片</s:if>
                         <s:elseif test="bid.sumProductPhoto==2">件</s:elseif>
                          <s:elseif test="bid.sumProductPhoto==3">秒</s:elseif>
                          <s:elseif test="bid.sumProductPhoto==4">套</s:elseif>
                         </span>
                       
                           <s:if test="bid.recruitNum==null||bid.recruitNum.trim()==''">
                           <span class="shootBg shootjj">按<s:if test="bid.sumProductPhoto==1">片</s:if><s:elseif test="bid.sumProductPhoto==2">件</s:elseif><s:elseif test="bid.sumProductPhoto==3">秒</s:elseif><s:elseif test="bid.sumProductPhoto==4">套</s:elseif>计价</span>
                           </s:if>
                                    
                        </td>
                    </tr>
                    
                    <tr>
                    	<td class="td2"><span>交付日期：</span></td>
                        <td class="td3"><span><s:property value="bid.workEndTime"/></span></td>
                        
                        <td class="td4"><span>模特需求：</span></td>
                        <td class="td5">
                        
                          <s:if  test="bid.isHaveModel==1">
                                                                   我方提供
                        </s:if>
                        <s:elseif test="bid.isHaveModel==1">
                                                                摄影师提供
                        </s:elseif>
                         <s:else>否</s:else>
                        
                        </td>
                    </tr>
                </table>
            </div>
            <!--跟拍		代码-->
                    
                    
                    
            <!--寄拍	代码-->
            <!--<div class="divInviteBids">
            	<table>
                	<tr>
                    	<td rowspan="3" class="icobid"><div></div></td>
                    	<td class="td2"><span>拍摄时间：</span></td>
                        <td class="td3"><span>2013/05/06</span><a href="javascript:"></a></td>
                        <td class="td4"><span>拍摄地点：</span></td>
                        <td class="td5">上海市嘉定区<span class="shootBg shootgp">寄拍</span></td>
                    </tr>
                    
                    <tr>
                    	<td class="td2"><span>需拍产品：</span></td>
                        <td class="td3"><span>6</span>件</td>
                        <td class="td4"><span>交付日期：</span></td>
                        <td class="td5"><span>2013/05/06</span></td>
                    </tr>
                    
                    <tr>
                    	<td class="td2"><span>模特需求：</span></td>
                        <td class="td3">摄影师提供</td>
                        
                    </tr>
                </table>
            </div>-->
            <!--寄拍	代码-->
                    
            <!--招标-->
            
            <!--中标-->
            <div class="divWinBids">
            	<table>
                	<tr class="tr1">
                    	<td rowspan="2" class="td1"><div class="icoWin"></div></td>
                    	<td class="td2">中标酬金</td>
                        <td class="td3"><a title="您可报价"></a></td>
                    </tr>
                    <tr>
                    	<td class="td2"><span class='tocj'>	<s:property value="bid.totalMoney"/></span></td>
                    	<td class="td3">每天酬金：</td>
                        <td class="td4"><span class='percj'><s:property value="bid.unitpriceProduct"/></span></td>
                        <td><span>（此报价已包含模特费用）</span></td>
                        
                    </tr>
                
                </table>
            </div>
            <!--中标-->
            
            
            <!--报价应约操作-->
            <div class="divOption">
            	<div class="divOption_link">
                    <a class="report" href="javascript:">投诉</a>
                </div>
                
                <div class="option_submit">
                	<input type="button" class="white_but" value="我要应约" onclick="changePage('<s:property value="id"/>');"/>
                    <input type="button" class="red_but" value="我来报价" onclick="openPopUpBox('popupIQuoteForm');"/>
                    
                    <!--没有‘我来报价’的时候用-->
                    <!--<input type="button" class="red_but" value="我要应约"/>-->
                </div>
            </div>
            <!--报价应约操作-->
            
            <!--说明-->
            <div class="divExplain">
            	中标酬金可能为发布人支付给应约中标者的所有费用总额，包含但不仅限于人员差旅费、模特薪酬、设备耗损费、服装费模特肖像权费、场地费等，中标后请与发布人确认。
            </div>
            <!--说明-->
        </div>
        
        
        
        
        
        <div id="appointProjectTimelyState">
        	<div class="divStateCard">
        		<ul id="recruitCameristTimelyStateCard">
        		
                	<li class="active"><a href="javascript:">应约者列表</a></li>
                    <li><a href="javascript:">中标者列表</a></li>
            	</ul>
                
            </div>
            
            <div class="divStateCardCon">
            	<!--邀请记录-->
                   <div class="divList" id="divListOne">
                    <ul id="divListOneUl">
                    	<!--已报价-->
                    	<!-- 
                        <li class="lilist_one">
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
                                 <!--</div>
                            	<div class="two">
                                	<a class="age" title="年龄">20岁</a>
                                    <a class="address" title="工作地"><span>上海</span><span>嘉定</span></a>
                                </div>
                            	<div class="three"><div class="job" title="职业"><span>摄影师</span><a></a></div>
                                </div>
                                <div class="four"><a class="view" title="浏览次数">2045</a></div>
                            </div>
                        </li>
                         -->
                        <!--已报价-->
                            
                        <div style="clear:both;"></div>
                    </ul>
                    
                    
                    <!--翻页
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
                    <!--翻页
                </div> -->
                <!--邀请记录-->
                <!--邀请记录		无记录-->
                <div class="divList" id="divListOne">
                	<div class="nobody">
                    	<div class="ico"></div>
                        <div class="char">目前还没有人应约，来做个第一名吧！</div>
                    
                    </div>
                </div>
                
                <!--邀请记录		无记录-->
                
                <!--中标者列表-->
                <div class="divListTwo" id="divListTwo">
                    <ul>
                    	<li class="lilist_two">
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
                            
                            <div class="user_info">
                            	<div class="user_info_one">
                                	<span class="name">凤凰传奇</span>
                                </div>
                                
                                <div class="user_info_two">
                                    <a class="approveNo" title="未实名认证"></a>
                                   <a class="gradeThree"></a>
                                </div>
                                
                                <div class="user_info_three">
                                	<a class="age" title="年龄">20岁</a>
                                    <a class="address" title="工作地"><span>上海</span><span>嘉定</span></a>
                                </div>
                                
                                <div class="user_info_four">
                                	<span>粉丝</span>
                                    <span class="fans">2122121</span>
                                    <span>关注</span>
                                    <span class="attention">2323122</span>
                                </div>
                                <div class="user_info_five">
                                	<span>成功约拍数：</span>
                                    <span class="fans">2122121</span>
                                </div>
                                <div class="user_info_five">
                                	<span>有评率：</span>
                                    <span class="fans">90%</span>
                                </div>
                            </div>
                        </li>
                        <li class="lilist_two">
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
                            
                            <div class="user_info">
                            	<div class="user_info_one">
                                	<span class="name">凤凰传奇</span>
                                </div>
                                
                                <div class="user_info_two">
                                    <!--<a class="approveNo" title="未实名认证"></a>-->
                                    <a class="approveHave" title="个人实名认证"></a>
                                   <!-- <a class="approveQy" title="企业实名认证"></a>-->
                                   <a class="gradeThree"></a>
                                </div>
                                
                                <div class="user_info_three">
                                	<a class="age" title="年龄">20岁</a>
                                    <a class="address" title="工作地"><span>上海</span><span>嘉定</span></a>
                                </div>
                                
                                <div class="user_info_four">
                                	<span>粉丝</span>
                                    <span class="fans">2122121</span>
                                    <span>关注</span>
                                    <span class="attention">2323122</span>
                                </div>
                                <div class="user_info_five">
                                	<span>成功约拍数：</span>
                                    <span class="fans">2122121</span>
                                </div>
                                <div class="user_info_five">
                                	<span>有评率：</span>
                                    <span class="fans">90%</span>
                                </div>
                            </div>
                        </li>
                        
                        <li class="lilist_two">
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
                            
                            <div class="user_info">
                            	<div class="user_info_one">
                                	<span class="name">凤凰传奇</span>
                                </div>
                                
                                <div class="user_info_two">
                                    <a class="approveQy" title="企业实名认证"></a>
                                   <a class="gradeThree"></a>
                                </div>
                                
                                <div class="user_info_three">
                                    <a class="address" title="工作地"><span>上海</span><span>嘉定</span></a>
                                </div>
                                
                                <div class="user_info_four">
                                	<span>粉丝</span>
                                    <span class="fans">2122121</span>
                                    <span>关注</span>
                                    <span class="attention">2323122</span>
                                </div>
                                <div class="user_info_five">
                                	<span>成功约拍数：</span>
                                    <span class="fans">2122121</span>
                                </div>
                                <div class="user_info_five">
                                	<span>有评率：</span>
                                    <span class="fans">90%</span>
                                </div>
                            </div>
                        </li>
                        
                    	<li class="lilist_two">
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
                            
                            <div class="user_info">
                            	<div class="user_info_one">
                                	<span class="name">凤凰传奇</span>
                                </div>
                                
                                <div class="user_info_two">
                                    <a class="approveNo" title="未实名认证"></a>
                                   <a class="gradeThree"></a>
                                </div>
                                
                                <div class="user_info_three">
                                	<a class="age" title="年龄">20岁</a>
                                    <a class="address" title="工作地"><span>上海</span><span>嘉定</span></a>
                                </div>
                                
                                <div class="user_info_four">
                                	<span>粉丝</span>
                                    <span class="fans">2122121</span>
                                    <span>关注</span>
                                    <span class="attention">2323122</span>
                                </div>
                                <div class="user_info_five">
                                	<span>成功约拍数：</span>
                                    <span class="fans">2122121</span>
                                </div>
                                <div class="user_info_five">
                                	<span>有评率：</span>
                                    <span class="fans">90%</span>
                                </div>
                            </div>
                        </li>
                        <li class="lilist_two">
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
                            
                            <div class="user_info">
                            	<div class="user_info_one">
                                	<span class="name">凤凰传奇</span>
                                </div>
                                
                                <div class="user_info_two">
                                    <!--<a class="approveNo" title="未实名认证"></a>-->
                                    <a class="approveHave" title="个人实名认证"></a>
                                   <!-- <a class="approveQy" title="企业实名认证"></a>-->
                                   <a class="gradeThree"></a>
                                </div>
                                
                                <div class="user_info_three">
                                	<a class="age" title="年龄">20岁</a>
                                    <a class="address" title="工作地"><span>上海</span><span>嘉定</span></a>
                                </div>
                                
                                <div class="user_info_four">
                                	<span>粉丝</span>
                                    <span class="fans">2122121</span>
                                    <span>关注</span>
                                    <span class="attention">2323122</span>
                                </div>
                                <div class="user_info_five">
                                	<span>成功约拍数：</span>
                                    <span class="fans">2122121</span>
                                </div>
                                <div class="user_info_five">
                                	<span>有评率：</span>
                                    <span class="fans">90%</span>
                                </div>
                            </div>
                        </li>
                        
                        <li class="lilist_two">
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
                            
                            <div class="user_info">
                            	<div class="user_info_one">
                                	<span class="name">凤凰传奇</span>
                                </div>
                                
                                <div class="user_info_two">
                                    <a class="approveQy" title="企业实名认证"></a>
                                   <a class="gradeThree"></a>
                                </div>
                                
                                <div class="user_info_three">
                                    <a class="address" title="工作地"><span>上海</span><span>嘉定</span></a>
                                </div>
                                
                                <div class="user_info_four">
                                	<span>粉丝</span>
                                    <span class="fans">2122121</span>
                                    <span>关注</span>
                                    <span class="attention">2323122</span>
                                </div>
                                <div class="user_info_five">
                                	<span>成功约拍数：</span>
                                    <span class="fans">2122121</span>
                                </div>
                                <div class="user_info_five">
                                	<span>有评率：</span>
                                    <span class="fans">90%</span>
                                </div>
                            </div>
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
                <!--中标者列表-->
                <!--中标者列表		无记录-->
                <!--<div class="divList" id="divListTwo">
                	<div class="nobody">
                    	<div class="ico"></div>
                        <div class="char">目前还没有中标者，来做个第一名吧！</div>
                    
                    </div>
                </div>-->
                
                <!--中标者列表		无记录-->
                
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
                
                <div class="share" id="shareToTerrace">
                	<a href="../relProjectChoose.html">
                    	<div class="backimg"></div>
                        <p>分享项目</p>
                    </a>
                </div>
                <div class="shareTerrace" id="shareTerrace">
                	<ul class="shareTerraceUL" id="shareTerraceUL">
                    	<li><a href="javascript:" class="shareSina" title="分享到新浪微博"></a></li>
                        <li><a href="javascript:" class="shareQqzone" title="分享到QQ空间"></a></li>
                        <li><a href="javascript:" class="shareQqblog" title="分享到腾讯微博"></a></li>
                        
                        <li><a href="javascript:" class="shareDouban" title="分享到豆瓣"></a></li>
                        <li><a href="javascript:" class="shareRenren" title="分享到人人网"></a></li>
                        <li><a href="javascript:" class="shareKaiXin" title="分享到开心网"></a></li>
                        
                        <li><a href="javascript:" class="shareTwitter" title="分享到twitter"></a></li>
                        <li><a href="javascript:" class="shareFacebook" title="分享到facebook"></a></li>
                        <li><a href="javascript:" class="shareEmail" title="发送邮件给好友"></a></li>
                    </ul>
                </div>
                
            </div>
          <!-- 操作 -->
            
            
         <div class="preNext">
            <div class="pre">
                <a href="javascript:">
                    <i></i>
                    <span>上一篇</span>
                </a>
            </div>
            <div class="next">
                <a href="javascript:">
                    <i></i>
                    <span>下一篇</span>
                </a>
            </div>
        </div>
         
         
         <div class="appointProjectRecom">
            	<div class="appointProjectRecom_top">约拍项目推荐</div>
                
                <div class="appointProjectBottom">
                	<div class="appointProjectBottomCon">
                    	<table class="tableAppointProjectBottomCon">
                        	<tr>
                            	<td class="td_one"><a class="shoot">约拍项目标题</a></td>
                                <td class="td_two">￥<span>54545</span>元</td>
                            </tr>
                            
                            <tr>
                            	<td class="td_one"><a class="model">约拍项目标题</a></td>
                                <td class="td_two">￥<span>54545</span>元</td>
                            </tr>
                            
                            <tr>
                            	<td class="td_one"><a class="collect">约拍项目标题</a></td>
                                <td class="td_two">￥<span>54545</span>元</td>
                            </tr>
                            
                            <tr>
                            	<td class="td_one"><a class="outShoot">约拍项目标题</a></td>
                                <td class="td_two">￥<span>54545</span>元</td>
                            </tr>
                            
                            <tr>
                            	<td class="td_one"><a class="collect">约拍项目标题</a></td>
                                <td class="td_two">￥<span>54545</span>元</td>
                            </tr>
                            
                            <tr>
                            	<td class="td_one"><a class="outShoot">约拍项目标题</a></td>
                                <td class="td_two">￥<span>54545</span>元</td>
                            </tr>
                        </table>
                    </div>
                </div>
                
                
        	</div>
        
        <div class="appointProjectHumanQi">
            <div class="appointProjectRecom_top">人气约拍项目推荐</div>
            
            <div class="appointProjectBottom">
                <div class="appointProjectBottomCon">
                    <table class="tableAppointProjectBottomCon">
                        <tr>
                            <td class="td_one"><a class="shoot">约拍项目标题</a></td>
                            <td class="td_two">￥<span>54545</span>元</td>
                        </tr>
                        
                        <tr>
                            <td class="td_one"><a class="model">约拍项目标题</a></td>
                            <td class="td_two">￥<span>54545</span>元</td>
                        </tr>
                        
                        <tr>
                            <td class="td_one"><a class="collect">约拍项目标题</a></td>
                            <td class="td_two">￥<span>54545</span>元</td>
                        </tr>
                        
                        <tr>
                            <td class="td_one"><a class="outShoot">约拍项目标题</a></td>
                            <td class="td_two">￥<span>54545</span>元</td>
                        </tr>
                        
                    </table>
                </div>
            </div>
            
            
        </div>
            
            
        
        
        </div>
        
        
    </div>
	
  </div>  
    
    <!--弹出我要应约-->
        <form action="javascript:" id="popupIRespondForm">
        <div id="popupIRespond" class="popupBox">
            <div class="top">
                <h2>我要应约</h2>
                <a href="javascript:cloosePopBox('popupIRespondForm');" class="closeProductShoot"></a>
            </div>
            
            <div class="sure">
                <span>您即将应约</span>
                <span class="name">约拍项目标题约拍项目标题约拍项目标题</span>，是否确认？
            </div>
            
            
            <div class="btn">
                <input type="reset" class="reset" value="取消" onclick="cloosePopBox('popupIRespondForm');"/>
                <input type="submit" class="submit" value="确定" onclick="submitIRespond();"/>
            </div>
            
            <div class="explain">
                <div class="ep1">收入说明：</div>
                <div class="ep">您的收入为应约收入总额的90%；扣除部分包括：国家收取的税收与附加费、银行或第三方支付进出转账汇款手续费等。</div>
            </div>
        </div>
        </form>
    <!--弹出我要应约-->   
    <div id="popupIRespondSuccess">应约成功！</div> 
        
    
    
    
    <!--弹出我要报价-->
        <form action="javascript:" id="popupIQuoteForm">
        <div id="popupIQuote" class="popupBox">
            <div class="top">
                <h2>我要报价</h2>
                <a href="javascript:cloosePopBoxQuote('popupIQuoteForm');" class="closeProductShoot"></a>
            </div>
            
            <table width="500" class="table_quote_one">
                <tr>
                  <td class="td_one">报价目标项目：</td>
                  <td class="td_two"><span>约拍项目标题</span></td>
                </tr>
                <tr>
                  <td class="td_one">报价方式：</td>
                  <td class="td_two">
                  	<input type="radio" id="totalPrices" name="receiptContent" value="总价" checked="checked" onclick="changePrice(this);"/>
                    <label for="totalPrices" onclick="changePriceLabel(this);">总价</label>
                    
            		<input type="radio" id="unitPrices" name="receiptContent" value="单价" onclick="changePrice(this);"/>
                    <label for="unitPrices" onclick="changePriceLabel(this);">单价</label> 
                  </td>
                </tr>
                <tr>
                  <td class="td_one">计价方式：</td>
                  <td class="td_two">
                  	<ul>
                        <li class="active"><span>按天</span><i></i></li>
                    </ul>
                  </td>
                </tr>
                <tr id="priceTD">
                  <td class="td_one"><span>总价</span>:</td>
                  <td class="td_two"><input id="inputPrices" class="inputPrices" type="text"/><span class="yuan">元</span></td>
                </tr>
            </table>

            
            
            <div class="btn">
                <input type="reset" class="reset" value="取消报价" onclick="cloosePopBoxQuote('popupIQuoteForm');"/>
                <input type="submit" class="submit" value="提交报价" onclick="submitIQuote();"/>
            </div>
            
            <div class="explain">
                <div class="ep1">收入说明：</div>
                <div class="ep">您的收入为应约收入总额的90%；扣除部分包括：国家收取的税收与附加费、银行或第三方支付进出转账汇款手续费等。</div>
            </div>
        </div>
        </form>
    <!--弹出我要报价-->  
    
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


function changePage(id){
	$.ajax({
	      type:"Post",
		  url: "frontlogin_checkedUserVlidate.do",
		  data:"",		
		  success : function(data) {
			 var msg=data.message;
			 if(msg=="ok"){
				 openPopUpBox('popupIRespondForm');
				 }
			 else{
				 applay(id);
				 }
			  
		  }
	});

	

	
}



$(function(){
	//ss1
 var msg='<s:property value="msg"/>';
 if($.trim(msg)!=''){ //发布和应约为同一人2//应约失败3//未登录4重复应约
	 if(msg==1){
		 alert("您不能应约自己发布的约拍");
		 }
	 else if(msg==4){
		 alert("此约拍您已应约");
		 }

    window.location.reload();
	 }


	
})

function applay(id){


	 window.location.href="responseInvitednew!customerApplayForBid.do?bidId="+id+"&url="+window.location.href;
	
}



</script>
</html>

