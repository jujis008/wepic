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


<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public/frontPage/shoot/css/shootList.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/public/frontPage/shoot/js/shootList.js"></script>

<script type="text/javascript">
function changePager(pa){
	$("#nowPage").val(pa);
     $("#tagBidreSearAction").submit();
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
          <!--    <div id="divButSearch">
                    	
                  		
            </div>-->

       <!-- <div style="clear:both;"></div>-->
       </div>
	</div>
    
    <div id="mainbar">
    	<div id="mainbarCenter">
    		<ul>
        		<li id="liindex">
            		<a href="javascript:void(0)">首页</a>
            	</li>
            	<li class="active" id="mainbarCenterLi2">
            		<a href="${pageContext.request.contextPath}/bid!fpageList.do">商业拍摄</a>
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

  	<div id="appointContent">
    
        
    	<div class="divMainList">
            <div class="filterWrapperSort" id="filterWrapperSort">
                <ul>
               <s:if test='paramName=="newbid"'>
                    <li class="active">
                    </s:if>
                    <s:else>
                    <li>
                    </s:else>
                    <i></i>
                    
                    <span>最新发布</span>
                    
                    </li>
               
                     <s:if test='paramName=="willStartBid"'>
                    <li class="active">
                    </s:if>
                    <s:else>
                    <li>
                    </s:else>
                    <i></i><span>即将开始</span></li>
                    <li><i></i><span>应约人数</span></li>
                    
                    
                     <s:if test='paramName=="hightTotalMoney"'>
                    <li class="active">
                    </s:if>
                    <s:else>
                    <li>
                    </s:else>
                    <i></i><span>薪酬</span></li>
                </ul>
                
               
                
               
                 <form action="tagBidreSearAction!seacrch.do" method="post" id="tagBidreSearAction">
                 <input value="<s:property value="paramName"/>" name="<s:property value="paramName"/>"  type="hidden" id="searTag"/>
                 <input  type="hidden" value="<s:property  value="nowPage"/>" name="nowPage"  id="nowPage"/>
                  <div class="filterWrapperSortRR" id="filterWrapperSortRR">
                	<span calss="yuan">￥</span>
                    <input id="minMoney" class="textMoney" type="text" onafterpaste="onlyWriteNum(this);" onkeyup="onlyWriteNum(this);" name="lowerMoney"/>
                    <span calss="ge">-</span>
                    <input id="mzxMoney" class="textMoney" type="text" onafterpaste="onlyWriteNum(this);" onkeyup="onlyWriteNum(this);" name="hightMoney"/>
                    <input class="textsure" id="sureMoneySubmit" type="button" value="确定" onclick="suerSubmit('minMoney','mzxMoney');"/>
                </div>
                </form>
            </div>
        
        
        	<div class="div_allShoot">
            	<ul id="divMainListUL">
            	<s:iterator value="pager.resultList">
            	<a href="">
                    <li>
                    	<div class="option">
                        	<a class="opt_good" href="javascript:">推荐项目</a>
							<a class="opt_collect" href="javascript:">收藏项目</a>
							<a class="opt_share" href="javascript:">分享项目</a>
                        </div>
                        
                        <div class="divMainListCon">
                        	<div class="divMainListCon_ico">
                        	  <s:if test='bidCat.icon=="photogrphy"'>
                        	  <div class="picCollect"></div>
                        	  </s:if>
                        	  <s:elseif test='bidCat.icon=="bid"'>
                        	  <div class="shoot"></div>
                        	  </s:elseif>
                        	  <s:elseif test='bidCat.icon=="model"'>
                        	  <div class="model"></div>
                        	  </s:elseif>
                        	
                        	
                            	
                            </div>
                            
                            <div class="divMainListCon_info">
                            	<div class="divMainListCon_info_top">
                            	<a href="${pageContext.request.contextPath}/bid!showBidF.do?id=<s:property value="id"/>">
                            		<span class="title"><s:property value="name"/></span>
                            		</a>
                            		
                            		  <s:if test='bidCat.icon=="photogrphy"'>
                        	<span class="spanBG spanCollectBG">
                        	  </s:if>
                        	  <s:elseif test='bidCat.icon=="bid"'>
                        	<span class="spanBG spanshootBG">
                        	  </s:elseif>
                        	  <s:elseif test='bidCat.icon=="model"'>
                        	 <span class="spanBG spanmodelBG">
                        	  </s:elseif>
                            		
                            		
                            		
                                  
                                    <s:property value="bidCat.name"/></span>
                                    <div class="divMainListCon_info_top_ico">
                                        <a class="view" title="浏览次数"><span>64456</span></a>
                                        <a class="collect" title="收藏次数"><span>64456</span></a>
                                        <a class="good" title="推荐次数"><span>64456</span></a>
                                    </div>
                            	</div>
                                
                                <div class="divMainListCon_info_bottom">
                            		<span>拍摄时间：</span>
                                    <span class="time">
                                    <s:if test='bidCat.icon!="photogrphy"'>
                                    <s:property value="workStartTime"/>
                                    </s:if>
                                    <s:else>
                                     <s:property value="workEndTime"/>
                                    
                                    </s:else>
                                    </span>
                                     <s:if test='bidCat.icon!="photogrphy"'>
                        	        
                                    <span>拍摄方式：</span>
                                    <span class="type">
                                     <s:if test="photoType==0">拍摄方式不限</s:if>
                                      <s:elseif test="photoType==1">
                                                                                                             跟拍
                                         </s:elseif>
                                           <s:elseif test="photoType==2">
                                                                                                               寄拍
                                         </s:elseif>                    
                                          </span>
                                     </s:if>
                                    <span>产品数量：</span>
                                    <span class="number">
                                    <s:property value="sumProdct"/>
                                    
                                    
                                    </span> 
                                    <s:if test="sumProductPhoto==1">片</s:if>
                             <s:elseif test="sumProductPhoto==2">件</s:elseif>
                          <s:elseif test="sumProductPhoto==3">秒</s:elseif>
                          <s:elseif test="sumProductPhoto==4">套</s:elseif>
                            <s:elseif test="sumProductPhoto==6">篇</s:elseif>
                             <s:elseif test="sumProductPhoto==7">张</s:elseif>
                        
                                    
                                    
                                    <div class="divMainListCon_info_bottom_r">
                                   <span> <s:property value="content"/>发布</span>
                                    </div>
                            	</div>
                            </div>
                            
                            <div class="divMainListCon_money">
                            	<div class="divMainListCon_money_ico"></div>
                            	<s:if test="ifAskPrice==1"><div class="divMainListCon_money_bj">求报价</div></s:if>
                            	
                                <p>
                                <s:property value="chagetotalMoney"/>
                                </p>
                            </div>
                        </div>
                    </li>
                    </a>
                    </s:iterator>
                    
                    
                    
                    
                    
                    
                    
                    <!-- 
                    <li>
                    	<div class="option">
                        	<a class="opt_good" href="javascript:">推荐项目</a>
							<a class="opt_collect" href="javascript:">收藏项目</a>
							<a class="opt_share" href="javascript:">分享项目</a>
                        </div>
                        
                        <div class="divMainListCon">
                        	<div class="divMainListCon_ico">
                            	<div class="picCollect"></div>
                            </div>
                            
                            <div class="divMainListCon_info">
                            	<div class="divMainListCon_info_top">
                            		<span class="title">产品拍摄标题产品拍摄标题</span>
                                    <span class="spanBG spanCollectBG">摄影图片</span>
                                    <div class="divMainListCon_info_top_ico">
                                        <a class="view" title="浏览次数"><span>64456</span></a>
                                        <a class="collect" title="收藏次数"><span>64456</span></a>
                                        <a class="good" title="推荐次数"><span>64456</span></a>
                                    </div>
                            	</div>
                                
                                <div class="divMainListCon_info_bottom">
                            		<span>拍摄时间：</span>
                                    <span class="time">2013-12-20</span>
                                    
                                    <span>拍摄方式：</span>
                                    <span class="type">寄拍</span>
                                    
                                    <span>产品数量：</span>
                                    <span class="number">43</span>件
                                    
                                    
                                    <div class="divMainListCon_info_bottom_r">
                                        <span>43</span>
                                        <span>分钟前</span>
                                        <span>发布</span>
                                    </div>
                            	</div>
                            </div>
                            
                            <div class="divMainListCon_money">
                            	<div class="divMainListCon_money_ico"></div>
                            	<div class="divMainListCon_money_bj">求报价</div>
                                <p>——</p>
                            </div>
                        </div>
                    </li>
                    <li>
                    	<div class="option">
                        	<a class="opt_good" href="javascript:">推荐项目</a>
							<a class="opt_collect" href="javascript:">收藏项目</a>
							<a class="opt_share" href="javascript:">分享项目</a>
                        </div>
                        
                        <div class="divMainListCon">
                        	<div class="divMainListCon_ico">
                            	<div class="model"></div>
                            </div>
                            
                            <div class="divMainListCon_info">
                            	<div class="divMainListCon_info_top">
                            		<span class="title">产品拍摄标题产品拍摄标题</span>
                                    <span class="spanBG spanmodelBG">产品模特</span>
                                    <div class="divMainListCon_info_top_ico">
                                        <a class="view" title="浏览次数"><span>64456</span></a>
                                        <a class="collect" title="收藏次数"><span>64456</span></a>
                                        <a class="good" title="推荐次数"><span>64456</span></a>
                                    </div>
                            	</div>
                                
                                <div class="divMainListCon_info_bottom">
                            		<span>拍摄时间：</span>
                                    <span class="time">2013-12-20</span>
                                    
                                    <span>拍摄方式：</span>
                                    <span class="type">寄拍</span>
                                    
                                    <span>产品数量：</span>
                                    <span class="number">43</span>件
                                    
                                    
                                    <div class="divMainListCon_info_bottom_r">
                                        <span>43</span>
                                        <span>分钟前</span>
                                        <span>发布</span>
                                    </div>
                            	</div>
                            </div>
                            
                            <div class="divMainListCon_money">
                            	<div class="divMainListCon_money_ico"></div>
                                <p>949</p>
                            </div>
                        </div>
                    </li>
                    <li>
                    	<div class="option">
                        	<a class="opt_good" href="javascript:">推荐项目</a>
							<a class="opt_collect" href="javascript:">收藏项目</a>
							<a class="opt_share" href="javascript:">分享项目</a>
                        </div>
                        
                        <div class="divMainListCon">
                        	<div class="divMainListCon_ico">
                            	<div class="outShoot"></div>
                            </div>
                            
                            <div class="divMainListCon_info">
                            	<div class="divMainListCon_info_top">
                            		<span class="title">产品拍摄标题产品拍摄标题</span>
                                    <span class="spanBG spanoutShootBG">外拍活动</span>
                                    <div class="divMainListCon_info_top_ico">
                                        <a class="view" title="浏览次数"><span>64456</span></a>
                                        <a class="collect" title="收藏次数"><span>64456</span></a>
                                        <a class="good" title="推荐次数"><span>64456</span></a>
                                    </div>
                            	</div>
                                
                                <div class="divMainListCon_info_bottom">
                            		<span>拍摄时间：</span>
                                    <span class="time">2013-12-20</span>
                                    
                                    <span>拍摄方式：</span>
                                    <span class="type">寄拍</span>
                                    
                                    <span>产品数量：</span>
                                    <span class="number">43</span>件
                                    
                                    
                                    <div class="divMainListCon_info_bottom_r">
                                        <span>43</span>
                                        <span>分钟前</span>
                                        <span>发布</span>
                                    </div>
                            	</div>
                            </div>
                            
                            <div class="divMainListCon_money">
                            	<div class="divMainListCon_money_ico"></div>
                                <p>949</p>
                            </div>
                        </div>
                    </li>
                    
                    <li>
                    	<div class="option">
                        	<a class="opt_good" href="javascript:">推荐项目</a>
							<a class="opt_collect" href="javascript:">收藏项目</a>
							<a class="opt_share" href="javascript:">分享项目</a>
                        </div>
                        
                        <div class="divMainListCon">
                        	<div class="divMainListCon_ico">
                            	<div class="outShoot"></div>
                            </div>
                            
                            <div class="divMainListCon_info">
                            	<div class="divMainListCon_info_top">
                            		<span class="title">产品拍摄标题产品拍摄标题</span>
                                    <span class="spanBG spanoutShootBG">外拍活动</span>
                                    <div class="divMainListCon_info_top_ico">
                                        <a class="view" title="浏览次数"><span>64456</span></a>
                                        <a class="collect" title="收藏次数"><span>64456</span></a>
                                        <a class="good" title="推荐次数"><span>64456</span></a>
                                    </div>
                            	</div>
                                
                                <div class="divMainListCon_info_bottom">
                            		<span>拍摄时间：</span>
                                    <span class="time">2013-12-20</span>
                                    
                                    <span>拍摄方式：</span>
                                    <span class="type">寄拍</span>
                                    
                                    <span>产品数量：</span>
                                    <span class="number">43</span>件
                                    
                                    
                                    <div class="divMainListCon_info_bottom_r">
                                        <span>43</span>
                                        <span>分钟前</span>
                                        <span>发布</span>
                                    </div>
                            	</div>
                            </div>
                            
                            <div class="divMainListCon_money">
                            	<div class="divMainListCon_money_ico"></div>
                                <p>949</p>
                            </div>
                        </div>
                    </li>
                    <li>
                    	<div class="option">
                        	<a class="opt_good" href="javascript:">推荐项目</a>
							<a class="opt_collect" href="javascript:">收藏项目</a>
							<a class="opt_share" href="javascript:">分享项目</a>
                        </div>
                        
                        <div class="divMainListCon">
                        	<div class="divMainListCon_ico">
                            	<div class="outShoot"></div>
                            </div>
                            
                            <div class="divMainListCon_info">
                            	<div class="divMainListCon_info_top">
                            		<span class="title">产品拍摄标题产品拍摄标题</span>
                                    <span class="spanBG spanoutShootBG">外拍活动</span>
                                    <div class="divMainListCon_info_top_ico">
                                        <a class="view" title="浏览次数"><span>64456</span></a>
                                        <a class="collect" title="收藏次数"><span>64456</span></a>
                                        <a class="good" title="推荐次数"><span>64456</span></a>
                                    </div>
                            	</div>
                                
                                <div class="divMainListCon_info_bottom">
                            		<span>拍摄时间：</span>
                                    <span class="time">2013-12-20</span>
                                    
                                    <span>拍摄方式：</span>
                                    <span class="type">寄拍</span>
                                    
                                    <span>产品数量：</span>
                                    <span class="number">43</span>件
                                    
                                    
                                    <div class="divMainListCon_info_bottom_r">
                                        <span>43</span>
                                        <span>分钟前</span>
                                        <span>发布</span>
                                    </div>
                            	</div>
                            </div>
                            
                            <div class="divMainListCon_money">
                            	<div class="divMainListCon_money_ico"></div>
                                <p>949</p>
                            </div>
                        </div>
                    </li>
                    <li>
                    	<div class="option">
                        	<a class="opt_good" href="javascript:">推荐项目</a>
							<a class="opt_collect" href="javascript:">收藏项目</a>
							<a class="opt_share" href="javascript:">分享项目</a>
                        </div>
                        
                        <div class="divMainListCon">
                        	<div class="divMainListCon_ico">
                            	<div class="outShoot"></div>
                            </div>
                            
                            <div class="divMainListCon_info">
                            	<div class="divMainListCon_info_top">
                            		<span class="title">产品拍摄标题产品拍摄标题</span>
                                    <span class="spanBG spanoutShootBG">外拍活动</span>
                                    <div class="divMainListCon_info_top_ico">
                                        <a class="view" title="浏览次数"><span>64456</span></a>
                                        <a class="collect" title="收藏次数"><span>64456</span></a>
                                        <a class="good" title="推荐次数"><span>64456</span></a>
                                    </div>
                            	</div>
                                
                                <div class="divMainListCon_info_bottom">
                            		<span>拍摄时间：</span>
                                    <span class="time">2013-12-20</span>
                                    
                                    <span>拍摄方式：</span>
                                    <span class="type">寄拍</span>
                                    
                                    <span>产品数量：</span>
                                    <span class="number">43</span>件
                                    
                                    
                                    <div class="divMainListCon_info_bottom_r">
                                        <span>43</span>
                                        <span>分钟前</span>
                                        <span>发布</span>
                                    </div>
                            	</div>
                            </div>
                            
                            <div class="divMainListCon_money">
                            	<div class="divMainListCon_money_ico"></div>
                                <p>949</p>
                            </div>
                        </div>
                    </li>
                     -->
                </ul>
            </div>
        	
         
        
           <!--翻页-->
           <s:if test="pager.lastPageNo>1">
                <div class="ppointPagingthis">
                    <div class="ppointPaging">            
                    	<table class="tablePpointPaging">
                            <tr>
                                <td class="ppointPagingOne"><a href="javascript:changePager(1)"></a></td>
                                <s:if test="nowPage-1>0">
                                <td class="ppointPagingPre"><a href="javascript:changePager(<s:property value="nowPage-1"/>)"></a></td>
                                </s:if>
                                <s:else>
                                 <td class="ppointPagingPre"><a href="javascript:changePager(<s:property value="nowPage"/>)"></a></td>
                                </s:else>
                                
                                
                                   <s:bean name="org.apache.struts2.util.Counter" id="counter">  
                                   <s:param name="first" value="1"/>  
                                    <s:param name="last" value="pager.lastPageNo"/>  
                                     <s:iterator> <!-- bid!findAllMyBid.do?nowPage=<s:property/> -->
                                    <td class="ppointPagingN"><a href="javascript:changePager(<s:property/>)">
                                    <s:property/>
                                  </a></td> 
                    
                                 </s:iterator>  
                                 </s:bean>  
                       
                       
                                <!-- 
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
                                
                                 -->
                                 
                                 
                                    <s:if test="nowPage>=pager.lastPageNo">
                                     <td class="ppointPagingLast"><a href="changePager(<s:property value="nowPage"/>)"></a></td>
                                     
                                
                                </s:if>
                                <s:else>
                                <td class="ppointPagingNext"><a href="javascript:changePager(<s:property value="nowPage+1"/>)"></a></td>
                                </s:else>
                                <td class="ppointPagingLast"><a href="javascript:changePager(<s:property value="pager.lastPageNo"/>)"></a></td>
                            </tr>
                    	</table>
                    </div>
        		</div>
        		</s:if>
        <!--翻页-->
        
        </div>
        
        
        
        <div class="divMainListRight">
        	<div class="divMainListRight_rel">
            	<input class="red_button" type="button" value="发布需求" onclick="location.href='${pageContext.request.contextPath}/catBid!findByrootType.do'"/>
            </div>
            
            
        	<div class="appointUserProgramme"></div>
        	
        
        
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
    
</div>
<div id="goTopBtn" style="display:none;" title="回顶部"></div>
<!--[if lte IE 6]>
<script src="${pageContext.request.contextPath}/public/js/DD_belatedPNG_0.0.8a.js" type="text/javascript"></script>
    <script type="text/javascript">
        DD_belatedPNG.fix('div, ul, img, li, input , a , i');
    </script>
<![endif]-->
</body>
</html>
