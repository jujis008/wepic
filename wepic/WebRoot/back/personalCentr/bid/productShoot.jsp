<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="shortcut icon" href="../../../userView/public/images/logoSmall.ico"/>
<title>wepic管理_个人中心_我的约拍_商业拍摄_有人应约详情</title>



<link type="text/css" rel="stylesheet" href="css/productShoot.css" />

<script type="text/javascript" src="../../../userView/public/js/jquery.js"></script>
<script type="text/javascript" src="js/productShoot.js"></script>
<!--公共js-->

<script type="text/javascript" src="../../public/js/publicBack.js"></script>
<script type="text/javascript" src="../../../userView/public/js/public.js"></script>
<script type="text/javascript" src="../../../userView/public/js/topBar.js"></script>
<script type="text/javascript" src="../../../userView/public/js/header.js"></script>



<!--公共js-->
<script type="text/javascript" src="${pageContext.request.contextPath}/back/js/provinceCityDistrict.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/back/js/publicBack.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}//public/js/public.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/topBar.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}//public/js/header.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}//back/js/ajaxforUserInfo.js"></script>





<!--公共css-->
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public/css/backMainBar.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public/css/topBarMain.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public/css/header.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public/css/footer.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public/css/public.css" />


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
                            	<img src="../../../userView/public/images/pic/topUser.jpg" />
                                <div id="topBarUserOneHeadChange">
                                	<div><a href="javascript:">更改头像</a></div>
                                </div>
                            </div>
                            <div id="topBarUserOneDetailed">
                            	<div id="topBarUserOneDetailedOne">
                                	<img id="topBarUserOneDetailedimg" src="../../../userView/public/images/grade/uesrLogo.png"/>
                                    <img src="../../../userView/public/images/grade/diamond.png"/>
                                    <img src="../../../userView/public/images/grade/diamond.png"/>
                                    <img src="../../../userView/public/images/grade/star.png"/>
                                    <img src="../../../userView/public/images/grade/star.png"/>
                                    <img src="../../../userView/public/images/grade/star.png"/>
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
                            		<img src="../../../userView/public/images/pic/topUser.jpg"/>
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
                            		<img src="../../../userView/public/images/pic/topUser.jpg"/>
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
                            		<img src="../../../userView/public/images/pic/topUser.jpg"/>
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
    				<img src="../../../userView/public/images/wepic_logo.png" alt="唯图网"/>
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
            		<a href="javascript:void(0)">个人中心</a>
            	</li>
            	<li id="configureCenter">
            		<a href="javascript:void(0)">配置中心</a>
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
            
            <a href="javascript:"><div class='bar'><span>发布约拍</span><i></i></div></a>
        </div>
        </div>
    </div>
    <!-- 导航  end-->


	<!-- 标题部分-->
  	<div id="appointProjectTitle">
    	<div id="appointProjectTitleTop">
        	<table id="tableAppointProjectTitleTop">
            	<tr>
                	<td id="appointProjectTitleTopName"><span title="这里写我的标题" alt="这里写我的标题">我的标题我的标题</span></td>
                    <td id="appointProjectTitleTopAdd"><a title="该项目有附件"></a></td>
                    <td id="appointProjectTitleTopQuotedPrice"><a title="您可报价"></a></td>
                   	<td id=""><a class="screen">人员筛选阶段</a></td>
                    
                    
                </tr>
            </table>
            
            <div id="appointProjectTitleTopIco">
                    	<a id="appointProjectTitleTopIcoOne" title="浏览次数"><span>54545</span></a>
                    	<a id="appointProjectTitleTopIcoTwo" title="收藏次数"><span>3453</span></a>
                        <a id="appointProjectTitleTopIcoThree" title="好评次数"><span>35354</span></a>    
                    </div>
        </div>
        
        <div id="appointProjectTitleBottom">
            <a class="pstype" title="拍摄类型"><div class='bar active'><span>发布记录</span><i></i></div></a>
            <div class="time">
            	<span>发布时间：</span>
            	<span>35</span>
            	<span class="classTitleBottom">分钟</span>
            	<span>前</span>
            
            	<span id="spanProjectTitleBottomTime">应约时间：</span>
	            <span class="classTitleBottom">剩余</span>
    	        <form name="formnow" id="daojishi">
        		<input value="" name="dd" size="1" type="text" class="daojishi1" >
       				 <!--<span name="dd"></span>-->
        			天
        		<input value="" name="hh" size="1" type="text" class="daojishiT">
        			小时
       			<input value="" name="mm" size="1" type="text" class="daojishiT">
        			分
        		<input value="" name="ss" size="1" type="text" class="daojishiT">
        		秒 
  				</form>
            </div>
            
        </div>
        
        <div id="appointProjectTitleRight" title="该项目属于商业拍摄类型"></div>
        
        <div id="appointProjectTitleTime">
        </div>
        
   	</div>
    
    <!-- 标题部分-->
    
    <div id="appointProjectCon">
    <!--中间内容-->
    	<div id="appointProjectConInfo">
         	<!--阶段-->
        	<div id="appointProjectConInfoStage">
            	<div class="character">
                	<span>应约中</span>
                    <span>筛选中</span>
                    <span>进行中</span>
                    <span>已结束</span>
                </div>
                <div class="ico">
                	<div class="one"></div>
                    <div class="two"></div>
                    <div class="three"></div>
                    <div class="four"></div>
                    <div class="five"></div>
                    <div class="six"></div>
                    <div class="seven"></div>
                    <div class="eight"></div>
                </div>
            </div>
            <!--阶段-->
            
            <!--招标-->
            <div id="appointProjectConInfoInviteBids">
            	<table id="tableAppointProjectConInfoInviteBids">
                	<tr>
                    	<td rowspan="3" class="td1"><div id="appointProjectConInfoInviteBidsIco"></div></td>
                    	<td class="td2"><span>招标截止：</span></td>
                        <td class="td3"><span>2013/05/06</span></td>
                        <td class="td4"><span>拍摄数量：</span></td>
                        <td class="td5">
                        	<span>产品：</span>
                        	<span>45</span>
                            <span>件，没见需正片</span>
                        	<span>45</span>
                            <span>件</span>
                        </td>
                    </tr>
                    
                    <tr>
                    	
                    	<td class="td2"><span>拍摄时间：</span></td>
                        <td class="td3">
                        	<span id="appointProjectConInfoInviteBidsStartTime">2013/05/06</span>-
                            <span id="appointProjectConInfoInviteBidsEndTime">2013/08/06</span>
                            <span>4</span>d*
                            <span>8</span>h=
                            <span>32</span>小时
                            <a href="javascript:"></a>
                        </td>
                        <td class="td4"><span>拍摄场景：</span></td>
                        <td class="td5">
                        	<span>室内</span>，
                        	<span>摄影师摄影棚</span>
                        </td>
                    </tr>
                    
                    <tr>
                    	
                    	<td class="td2"><span>拍摄地点：</span></td>
                        <td class="td3"><span>上海市嘉定区</span></td>
                        <td class="td4"><span>模特需求：</span></td>
                        <td class="td5"><span>需摄影师提供</span></td>
                    </tr>
                </table>
            </div>
            <!--招标-->
            
            <!--中标-->
            <div id="appointProjectConInfoWinBids">
            	<table>
                	<tr class="tr1">
                    	<td rowspan="2" class="td1"><div class="icoWin"></div></td>
                    	<td class="td2">中标酬金</td>
                        <td class="td3"><a title="您可报价"></a></td>
                    </tr>
                    <tr>
                    	<td class="td2"><span class='tocj'>5454</span></td>
                    	<td class="td3">拍摄每件酬金：</td>
                        <td class="td4"><span class='percj'>679879</span></td>
                    </tr>
                
                </table>
            </div>
            <!--中标-->
            
            <!--项目描述-->
            <div id="appointProjectConInfoProjectDescribe">
            	<p class="appointProjectConInfoProjectDescribeTitle">项目描述</p>
                <p>1.自备相关摄影器材设备</p>
                <p>2.自备相关摄影器材设备</p>
                <p>3.自备相关摄影器材设备</p>
                
            </div>
            <!--项目描述-->
            
            <!--应约要求-->
            <div id="appointProjectConInfoAcceptReq">
            	<p class="appointProjectConInfoProjectDescribeTitle">应约要求</p>
                
                <p>1.自备相关摄影器材设备</p>
                <p>2.自备相关摄影器材设备</p>
                <p>3.自备相关摄影器材设备</p>
                <p>2.自备相关摄影器材设备</p>
                
            </div>
            <!--应约要求-->
            
            <!--附件-->
           
            <div id="appointProjectConInfoAppendix">
            	<table id="tableAppointProjectConInfoAppendix">
                	<tr>
                    	<td class="td1"><span>附件</span></td>
                        <td class="td2"><a href="javascript:"><i></i>附件fd.附件一.一.pdf(56.KB)</a></td>
                        <td class="td3"><a href="javascript:"><i></i>附件附件一.一.pdf(56.KB)</a></td>
                        <td class="td4"><a href="javascript:"><i></i>附件一.pdf(56.KB)</a></td>
                        <td class="td2"><a href="javascript:"><i></i>附件fd.附件一.一.pdf(56.KB)</a></td>
                        <td class="td3"><a href="javascript:"><i></i>附件附件一.一.pdf(56.KB)</a></td>
                        <td class="td4"><a href="javascript:"><i></i>附件一.pdf(56.KB)</a></td>
                        
                    </tr>
                </table>
            </div>
            <!--附件-->
            
            <!--提交-->
            <div id="appointProjectConInfoSubmit">
            	<div id="appointProjectConInfoSubmitLink">
                	<a id="appointProjectConInfoSubmitLinkShare" href="javascript:">分享</a>
                    <a id="appointProjectConInfoSubmitLinkJubao" href="javascript:">举报</a>
                </div>
                
                <div id="appointProjectConInfoSubmitBut">
                	<input type="button" id="appointProjectConInfoSubmitBut1" value="我要应约"/>
                    <input type="button" id="appointProjectConInfoSubmitBut2" value="我来报价" onclick="openOfferProductShoot('offerProductShootForm');"/>
                </div>
            </div>
            <!--提交-->
            
        </div>
        
        
        
        
        
        <div id="appointProjectTimelyState">
        	<div id="recruitCameristTimelyStateCard">
        		<ul>
                	<li class="recruitCameristTimelyStateCard1 active"><a href="javascript:">应约者列表</a></li>
                    <li class="recruitCameristTimelyStateCard2"><a href="javascript:">发布人邀请记录</a></li>
                    <li class="recruitCameristTimelyStateCard3"><a href="javascript:">中标者列表</a></li>
            	</ul>
            </div>
            
            <div id="recruitCameristTimelyStateCardCon">
            <div id="recruitCameristTimelyStateCardAT" class="recruitCameristTimelyStateCardConSon">
            	<ul>
                	<li class="">
                    	<a href="javascript:">
                    		<img src="../public/images/pic1/11.png"/>
                            <div class="recruitCameristTimelyStateCardATPriceBj">
                            </div>
                           	<div class="recruitCameristTimelyStateCardATPrice">
                            	<p class="bj">报价：</p>
                                <p class="bj2">￥<span>576675765</span></p>
                            </div>
                        </a>
                        
                    </li>
                    <li class="">
                    	<a href="javascript:">
                    		<img src="../public/images/pic1/22.png"/>
                            <div class="recruitCameristTimelyStateCardATPriceBj">
                            </div>
                           	<div class="recruitCameristTimelyStateCardATPrice">
                            	<p class="bj">报价：</p>
                                <p class="bj2">￥<span>576675765</span></p>
                            </div>
                        </a>
                        
                    </li>
                    
                    <li class="">
                    	<a href="javascript:">
                    		<img src="../public/images/pic1/55.png"/>
                            <div class="recruitCameristTimelyStateCardATPriceBj">
                            </div>
                           	<div class="recruitCameristTimelyStateCardATPrice">
                            	<p class="bj">报价：</p>
                                <p class="bj2">￥<span>576675765</span></p>
                            </div>
                        </a>
                        
                    </li>
                    <li class="">
                    	<a href="javascript:">
                    		<img src="../public/images/pic1/66.png"/>
                            <div class="recruitCameristTimelyStateCardATPriceBj">
                            </div>
                           	<div class="recruitCameristTimelyStateCardATPrice">
                            	<p class="bj">报价：</p>
                                <p class="bj2">￥<span>576675765</span></p>
                            </div>
                        </a>
                        
                    </li>
                    
                    <li class="">
                    	<a href="javascript:">
                    		<img src="../public/images/pic1/44.png"/>
                            <div class="recruitCameristTimelyStateCardATPriceBj">
                            </div>
                           	<div class="recruitCameristTimelyStateCardATPrice">
                            	<p class="bj">报价：</p>
                                <p class="bj2">￥<span>576675765</span></p>
                            </div>
                        </a>
                        
                    </li>
                    <li class="">
                    	<a href="javascript:">
                    		<img src="../public/images/pic1/33.png"/>
                            <div class="recruitCameristTimelyStateCardATPriceBj">
                            </div>
                           	<div class="recruitCameristTimelyStateCardATPrice">
                            	<p class="bj">报价：</p>
                                <p class="bj2">￥<span>576675765</span></p>
                            </div>
                        </a>
                        
                    </li>
                    
                    <li class="">
                    	<a href="javascript:">
                    		<img src="../public/images/pic1/22.png"/>
                            <div class="recruitCameristTimelyStateCardATPriceBj">
                            </div>
                           	<div class="recruitCameristTimelyStateCardATPrice">
                            	<p class="bj">报价：</p>
                                <p class="bj2">￥<span>576675765</span></p>
                            </div>
                        </a>
                        
                    </li>
                    <li class="">
                    	<a href="javascript:">
                    		<img src="../public/images/pic1/11.png"/>
                            <div class="recruitCameristTimelyStateCardATPriceBj">
                            </div>
                           	<div class="recruitCameristTimelyStateCardATPrice">
                            	<p class="bj">报价：</p>
                                <p class="bj2">￥<span>576675765</span></p>
                            </div>
                        </a>
                        
                    </li>
                    
                    <li class="">
                    	<a href="javascript:">
                    		<img src="../public/images/pic1/11.png"/>
                            <div class="recruitCameristTimelyStateCardATPriceBj">
                            </div>
                           	<div class="recruitCameristTimelyStateCardATPrice">
                            	<p class="bj">报价：</p>
                                <p class="bj2">￥<span>576675765</span></p>
                            </div>
                        </a>
                        
                    </li>
                    <li class="">
                    	<a href="javascript:">
                    		<img src="../public/images/pic1/11.png"/>
                            <div class="recruitCameristTimelyStateCardATPriceBj">
                            </div>
                           	<div class="recruitCameristTimelyStateCardATPrice">
                            	<p class="bj">报价：</p>
                                <p class="bj2">￥<span>576675765</span></p>
                            </div>
                        </a>
                        
                    </li>
                    
                    <li class="">
                    	<a href="javascript:">
                    		<img src="../public/images/pic1/11.png"/>
                            <div class="recruitCameristTimelyStateCardATPriceBj">
                            </div>
                           	<div class="recruitCameristTimelyStateCardATPrice">
                            	<p class="bj">报价：</p>
                                <p class="bj2">￥<span>576675765</span></p>
                            </div>
                        </a>
                        
                    </li>
                    <li class="">
                    	<a href="javascript:">
                    		<img src="../public/images/pic1/11.png"/>
                            <div class="recruitCameristTimelyStateCardATPriceBj">
                            </div>
                           	<div class="recruitCameristTimelyStateCardATPrice">
                            	<p class="bj">报价：</p>
                                <p class="bj2">￥<span>576675765</span></p>
                            </div>
                        </a>
                        
                    </li>
                    
                   <li class="">
                    	<a href="javascript:">
                    		<img src="../public/images/pic1/11.png"/>
                            <div class="recruitCameristTimelyStateCardATPriceBj">
                            </div>
                           	<div class="recruitCameristTimelyStateCardATPrice">
                            	<p class="bj">报价：</p>
                                <p class="bj2">￥<span>576675765</span></p>
                            </div>
                        </a>
                        
                    </li>
                    
                    <li class="">
                    	<a href="javascript:">
                    		<img src="../public/images/pic1/11.png"/>
                            <div class="recruitCameristTimelyStateCardATPriceBj">
                            </div>
                           	<div class="recruitCameristTimelyStateCardATPrice">
                            	<p class="bj">报价：</p>
                                <p class="bj2">￥<span>576675765</span></p>
                            </div>
                        </a>
                        
                    </li>
            	</ul>
                
        <!--翻页-->
        <div class="ppointPaging">            
            <table class="tablePpointPaging">
                	<tr>
                    	<td class="ppointPagingOne"><a href="javascript:"></td>
                        <td class="ppointPagingPre"><a href="javascript:"></td>
                    	<td class="ppointPagingN"><a href="javascript:">1</td>
                        <td class="ppointPagingN"><a href="javascript:">2</td>
                    	<td class="ppointPagingN"><a href="javascript:">3</td>
                        <td class="ppointPagingN"><a href="javascript:">4</td>
                    	<td class="ppointPagingN"><a href="javascript:">5</td>
                        <td class="ppointPagingN"><a href="javascript:">6</td>
                    	<td class="ppointPagingN"><a href="javascript:">7</td>
                        <td class="ppointPagingN"><a href="javascript:">8</td>
                    	<td class="ppointPagingN"><a href="javascript:">9</td>
                        <td class="ppointPagingN"><a href="javascript:">10</td>
                    	<td class="ppointPagingNext"><a href="javascript:"></td>
                        <td class="ppointPagingLast"><a href="javascript:"></td>
                    </tr>
                </table>
        </div>
        <!--翻页-->
            </div>
        
            <div id="recruitCameristTimelyStateCardCon2" class="recruitCameristTimelyStateCardConSon">
            	<ul>
            	</ul>
            </div>
            
            <div id="recruitCameristTimelyStateCardConWinBid" class="recruitCameristTimelyStateCardConSon">
            	<ul>
                	<li class="">
                			<div class="recruitCameristInfoTopHeadCard"><img src="../../public/pic/7.png" /></div>
                    		<div class="recruitCameristInfoTopInfoCard">
                    			<div id="recruitCameristInfoTopInfoOneCard">
                        			<span class="recruitCameristInfoTopInfoOneNameCard">李彦宏</span>
                            			<img src="../public/images/grade/uesrLogo.png"/>
                        		</div>
                        		<div class="recruitCameristInfoTopInfoTwoCard">
                        			<img src="../public/images/grade/diamond.png"/>
                            		<img src="../public/images/grade/diamond.png"/>
                            		<img src="../public/images/grade/star.png"/>
                           		 	<img src="../public/images/grade/star.png"/>
                            		<img src="../public/images/grade/star.png"/>
                        		</div>
                       		 	<div class="recruitCameristInfoTopInfoThreeCard">
                        			<span class="recruitCameristInfoTopInfoThreeProvinceCard">上海</span>
                            		<span class="recruitCameristInfoTopInfoThreeCityCard">徐汇区</span>
                            
                        		</div>
                        		<div class="recruitCameristInfoTopInfoFourCard">
                        			<span class="recruitCameristInfoTopInfoFourCard1">粉丝</span>
                            		<span class="recruitCameristInfoTopInfoFourCard2">454654</span>
                            		<span class="recruitCameristInfoTopInfoFourCard3">关注</span>
                            		<span class="recruitCameristInfoTopInfoFourCard4">46587</span>
                        		</div>
                    		</div>
                            <div class="recruitCameristInfoBottomCard">
                            	<p>成功约拍数：<span>545454</span></p>
                                <p>好评率：<span>54</span><span>%</span></p>
                            </div>
                    </li>
                    
                    <li class="">
                			<div class="recruitCameristInfoTopHeadCard"><img src="../../public/pic/9.png" /></div>
                    		<div class="recruitCameristInfoTopInfoCard">
                    			<div id="recruitCameristInfoTopInfoOneCard">
                        			<span class="recruitCameristInfoTopInfoOneNameCard">李彦宏</span>
                            			<img src="../public/images/grade/uesrLogo.png"/>
                        		</div>
                        		<div class="recruitCameristInfoTopInfoTwoCard">
                        			<img src="../public/images/grade/diamond.png"/>
                            		<img src="../public/images/grade/diamond.png"/>
                            		<img src="../public/images/grade/star.png"/>
                           		 	<img src="../public/images/grade/star.png"/>
                            		<img src="../public/images/grade/star.png"/>
                        		</div>
                       		 	<div class="recruitCameristInfoTopInfoThreeCard">
                        			<span class="recruitCameristInfoTopInfoThreeProvinceCard">上海</span>
                            		<span class="recruitCameristInfoTopInfoThreeCityCard">徐汇区</span>
                            
                        		</div>
                        		<div class="recruitCameristInfoTopInfoFourCard">
                        			<span class="recruitCameristInfoTopInfoFourCard1">粉丝</span>
                            		<span class="recruitCameristInfoTopInfoFourCard2">454654</span>
                            		<span class="recruitCameristInfoTopInfoFourCard3">关注</span>
                            		<span class="recruitCameristInfoTopInfoFourCard4">46587</span>
                        		</div>
                    		</div>
                            <div class="recruitCameristInfoBottomCard">
                            	<p>成功约拍数：<span>545454</span></p>
                                <p>好评率：<span>54</span><span>%</span></p>
                            </div>
                    </li>
                    <li class="">
                			<div class="recruitCameristInfoTopHeadCard"><img src="../../public/pic/9.png" /></div>
                    		<div class="recruitCameristInfoTopInfoCard">
                    			<div id="recruitCameristInfoTopInfoOneCard">
                        			<span class="recruitCameristInfoTopInfoOneNameCard">李彦宏</span>
                            			<img src="../public/images/grade/uesrLogo.png"/>
                        		</div>
                        		<div class="recruitCameristInfoTopInfoTwoCard">
                        			<img src="../public/images/grade/diamond.png"/>
                            		<img src="../public/images/grade/diamond.png"/>
                            		<img src="../public/images/grade/star.png"/>
                           		 	<img src="../public/images/grade/star.png"/>
                            		<img src="../public/images/grade/star.png"/>
                        		</div>
                       		 	<div class="recruitCameristInfoTopInfoThreeCard">
                        			<span class="recruitCameristInfoTopInfoThreeProvinceCard">上海</span>
                            		<span class="recruitCameristInfoTopInfoThreeCityCard">徐汇区</span>
                            
                        		</div>
                        		<div class="recruitCameristInfoTopInfoFourCard">
                        			<span class="recruitCameristInfoTopInfoFourCard1">粉丝</span>
                            		<span class="recruitCameristInfoTopInfoFourCard2">454654</span>
                            		<span class="recruitCameristInfoTopInfoFourCard3">关注</span>
                            		<span class="recruitCameristInfoTopInfoFourCard4">46587</span>
                        		</div>
                    		</div>
                            <div class="recruitCameristInfoBottomCard">
                            	<p>成功约拍数：<span>545454</span></p>
                                <p>好评率：<span>54</span><span>%</span></p>
                            </div>
                    </li>
                    <li class="">
                			<div class="recruitCameristInfoTopHeadCard"><img src="../../public/pic/9.png" /></div>
                    		<div class="recruitCameristInfoTopInfoCard">
                    			<div class="recruitCameristInfoTopInfoOneCard">
                        			<span class="recruitCameristInfoTopInfoOneNameCard">李彦宏</span>
                            			<img src="../public/images/grade/uesrLogo.png"/>
                        		</div>
                        		<div class="recruitCameristInfoTopInfoTwoCard">
                        			<img src="../public/images/grade/diamond.png"/>
                            		<img src="../public/images/grade/diamond.png"/>
                            		<img src="../public/images/grade/star.png"/>
                           		 	<img src="../public/images/grade/star.png"/>
                            		<img src="../public/images/grade/star.png"/>
                        		</div>
                       		 	<div class="recruitCameristInfoTopInfoThreeCard">
                        			<span class="recruitCameristInfoTopInfoThreeProvinceCard">上海</span>
                            		<span class="recruitCameristInfoTopInfoThreeCityCard">徐汇区</span>
                            		
                                    <input type="button" value="√已关注">
                        		</div>
                        		<div id="recruitCameristInfoTopInfoFourCard">
                        			<span class="recruitCameristInfoTopInfoFourCard1">粉丝</span>
                            		<span class="recruitCameristInfoTopInfoFourCard2">454654</span>
                            		<span class="recruitCameristInfoTopInfoFourCard3">关注</span>
                            		<span class="recruitCameristInfoTopInfoFourCard4">46587</span>
                        		</div>
                    		</div>
                            <div class="recruitCameristInfoBottomCard">
                            	<p>成功约拍数：<span>545454</span></p>
                                <p>好评率：<span>54</span><span>%</span></p>
                            </div>
                    </li>
                   <li class="">
                			<div class="recruitCameristInfoTopHeadCard"><img src="../../public/pic/9.png" /></div>
                    		<div class="recruitCameristInfoTopInfoCard">
                    			<div class="recruitCameristInfoTopInfoOneCard">
                        			<span class="recruitCameristInfoTopInfoOneNameCard">李彦宏</span>
                            			<img src="../public/images/grade/uesrLogo.png"/>
                        		</div>
                        		<div class="recruitCameristInfoTopInfoTwoCard">
                        			<img src="../public/images/grade/diamond.png"/>
                            		<img src="../public/images/grade/diamond.png"/>
                            		<img src="../public/images/grade/star.png"/>
                           		 	<img src="../public/images/grade/star.png"/>
                            		<img src="../public/images/grade/star.png"/>
                        		</div>
                       		 	<div class="recruitCameristInfoTopInfoThreeCard">
                        			<span class="recruitCameristInfoTopInfoThreeProvinceCard">上海</span>
                            		<span class="recruitCameristInfoTopInfoThreeCityCard">徐汇区</span>
                            		<input type="button" value="√已关注">
                        		</div>
                        		<div id="recruitCameristInfoTopInfoFourCard">
                        			<span class="recruitCameristInfoTopInfoFourCard1">粉丝</span>
                            		<span class="recruitCameristInfoTopInfoFourCard2">454654</span>
                            		<span class="recruitCameristInfoTopInfoFourCard3">关注</span>
                            		<span class="recruitCameristInfoTopInfoFourCard4">46587</span>
                        		</div>
                    		</div>
                            <div class="recruitCameristInfoBottomCard">
                            	<p>成功约拍数：<span>545454</span></p>
                                <p>好评率：<span>54</span><span>%</span></p>
                            </div>
                    </li>
                    <li class="">
                			<div class="recruitCameristInfoTopHeadCard"><img src="../../public/pic/9.png" /></div>
                    		<div class="recruitCameristInfoTopInfoCard">
                    			<div class="recruitCameristInfoTopInfoOneCard">
                        			<span class="recruitCameristInfoTopInfoOneNameCard">李彦宏</span>
                            			<img src="../public/images/grade/uesrLogo.png"/>
                        		</div>
                        		<div class="recruitCameristInfoTopInfoTwoCard">
                        			<img src="../public/images/grade/diamond.png"/>
                            		<img src="../public/images/grade/diamond.png"/>
                            		<img src="../public/images/grade/star.png"/>
                           		 	<img src="../public/images/grade/star.png"/>
                            		<img src="../public/images/grade/star.png"/>
                        		</div>
                       		 	<div class="recruitCameristInfoTopInfoThreeCard">
                        			<span class="recruitCameristInfoTopInfoThreeProvinceCard">上海</span>
                            		<span class="recruitCameristInfoTopInfoThreeCityCard">徐汇区</span>
                            		
                        		</div>
                        		<div id="recruitCameristInfoTopInfoFourCard">
                        			<span class="recruitCameristInfoTopInfoFourCard1">粉丝</span>
                            		<span class="recruitCameristInfoTopInfoFourCard2">454654</span>
                            		<span class="recruitCameristInfoTopInfoFourCard3">关注</span>
                            		<span class="recruitCameristInfoTopInfoFourCard4">46587</span>
                        		</div>
                    		</div>
                            <div class="recruitCameristInfoBottomCard">
                            	<p>成功约拍数：<span>545454</span></p>
                                <p>好评率：<span>54</span><span>%</span></p>
                            </div>
                    </li>
                    <li class="">
                			<div class="recruitCameristInfoTopHeadCard"><img src="../../public/pic/9.png" /></div>
                    		<div class="recruitCameristInfoTopInfoCard">
                    			<div class="recruitCameristInfoTopInfoOneCard">
                        			<span class="recruitCameristInfoTopInfoOneNameCard">李彦宏</span>
                            			<img src="../public/images/grade/uesrLogo.png"/>
                        		</div>
                        		<div class="recruitCameristInfoTopInfoTwoCard">
                        			<img src="../public/images/grade/diamond.png"/>
                            		<img src="../public/images/grade/diamond.png"/>
                            		<img src="../public/images/grade/star.png"/>
                           		 	<img src="../public/images/grade/star.png"/>
                            		<img src="../public/images/grade/star.png"/>
                        		</div>
                       		 	<div class="recruitCameristInfoTopInfoThreeCard">
                        			<span class="recruitCameristInfoTopInfoThreeProvinceCard">上海</span>
                            		<span class="recruitCameristInfoTopInfoThreeCityCard">徐汇区</span>
                            		
                        		</div>
                        		<div id="recruitCameristInfoTopInfoFourCard">
                        			<span class="recruitCameristInfoTopInfoFourCard1">粉丝</span>
                            		<span class="recruitCameristInfoTopInfoFourCard2">454654</span>
                            		<span class="recruitCameristInfoTopInfoFourCard3">关注</span>
                            		<span class="recruitCameristInfoTopInfoFourCard4">46587</span>
                        		</div>
                    		</div>
                            <div class="recruitCameristInfoBottomCard">
                            	<p>成功约拍数：<span>545454</span></p>
                                <p>好评率：<span>54</span><span>%</span></p>
                            </div>
                    </li>
                    <li class="">
                			<div class="recruitCameristInfoTopHeadCard"><img src="../../public/pic/9.png" /></div>
                    		<div class="recruitCameristInfoTopInfoCard">
                    			<div class="recruitCameristInfoTopInfoOneCard">
                        			<span class="recruitCameristInfoTopInfoOneNameCard">李彦宏</span>
                            			<img src="../public/images/grade/uesrLogo.png"/>
                        		</div>
                        		<div class="recruitCameristInfoTopInfoTwoCard">
                        			<img src="../public/images/grade/diamond.png"/>
                            		<img src="../public/images/grade/diamond.png"/>
                            		<img src="../public/images/grade/star.png"/>
                           		 	<img src="../public/images/grade/star.png"/>
                            		<img src="../public/images/grade/star.png"/>
                        		</div>
                       		 	<div class="recruitCameristInfoTopInfoThreeCard">
                        			<span class="recruitCameristInfoTopInfoThreeProvinceCard">上海</span>
                            		<span class="recruitCameristInfoTopInfoThreeCityCard">徐汇区</span>
                            		
                        		</div>
                        		<div id="recruitCameristInfoTopInfoFourCard">
                        			<span class="recruitCameristInfoTopInfoFourCard1">粉丝</span>
                            		<span class="recruitCameristInfoTopInfoFourCard2">454654</span>
                            		<span class="recruitCameristInfoTopInfoFourCard3">关注</span>
                            		<span class="recruitCameristInfoTopInfoFourCard4">46587</span>
                        		</div>
                    		</div>
                            <div class="recruitCameristInfoBottomCard">
                            	<p>成功约拍数：<span>545454</span></p>
                                <p>好评率：<span>54</span><span>%</span></p>
                            </div>
                    </li>
            	</ul>
        <!--翻页-->
        <div class="ppointPaging">            
            <table class="tablePpointPaging">
                	<tr>
                    	<td class="ppointPagingOne"><a href="javascript:"></td>
                        <td class="ppointPagingPre"><a href="javascript:"></td>
                    	<td class="ppointPagingN"><a href="javascript:">1</td>
                        <td class="ppointPagingN"><a href="javascript:">2</td>
                    	<td class="ppointPagingN"><a href="javascript:">3</td>
                        <td class="ppointPagingN"><a href="javascript:">4</td>
                    	<td class="ppointPagingN"><a href="javascript:">5</td>
                        <td class="ppointPagingN"><a href="javascript:">6</td>
                    	<td class="ppointPagingN"><a href="javascript:">7</td>
                        <td class="ppointPagingN"><a href="javascript:">8</td>
                    	<td class="ppointPagingN"><a href="javascript:">9</td>
                        <td class="ppointPagingN"><a href="javascript:">10</td>
                    	<td class="ppointPagingNext"><a href="javascript:"></td>
                        <td class="ppointPagingLast"><a href="javascript:"></td>
                    </tr>
                </table>
        </div>
        <!--翻页-->
            </div>
            </div>
        </div>
        
        <div id="divApointProjectRight">
        	<div id="appointProjectOperate">
            	<div id="appointProjectOperateOne">
                	<a href="javascript:">
                    	<div id="appointProjectOperateOneA"></div>
                        <p>返回上一页</p>
                    </a>
                </div>
                
                <div id="appointProjectOperateTwo">
                	<a href="javascript:">
                    	<div id="appointProjectOperateTwoA"></div>
                        <p>收藏项目</p>
                    </a>
                </div>
                
                <div id="appointProjectOperateThree">
                	<a href="javascript:">
                    	<div id="appointProjectOperateThreeA"></div>
                        <p>推荐项目</p>
                    </a>
                </div>
            </div>
        <!--发布人信息-->
        	<div id="appointProjectInfo">
            	<div id="appointProjectInfoTitle">
                	<p>发布人</p>
                </div>
        		<div id="appointProjectInfoTop">
                	<div id="appointProjectInfoTopHead"><img src="../../public/pic/9.png" /></div>
                    <div id="appointProjectInfoTopInfo">
                    	<div id="appointProjectInfoTopInfoOne">
                        	<span id="appointProjectInfoTopInfoOneName">李彦宏</span>
                            <img src="../public/images/grade/uesrLogo.png"/>
                        </div>
                        <div id="appointProjectInfoTopInfoTwo">
                        	<img src="../public/images/grade/diamond.png"/>
                            <img src="../public/images/grade/diamond.png"/>
                            <img src="../public/images/grade/star.png"/>
                            <img src="../public/images/grade/star.png"/>
                            <img src="../public/images/grade/star.png"/>
                        </div>
                        <div id="appointProjectInfoTopInfoThree">
                        	<span id="appointProjectInfoTopInfoThreeProvince">上海</span>
                            <span id="appointProjectInfoTopInfoThreeCity">徐汇区</span>
                            
                        </div>
                        <div id="appointProjectInfoTopInfoFour">
                        	<span id="appointProjectInfoTopInfoFour1">粉丝</span>
                            <span id="appointProjectInfoTopInfoFour2">454654</span>
                            <span id="appointProjectInfoTopInfoFour3">关注</span>
                            <span id="appointProjectInfoTopInfoFour4">46587</span>
                        </div>
                    </div>
          		</div>
          		<div id="appointProjectInfoBottom">
                	<div id="appointProjectInfoBottomBut">
                    	<input type="buttom" value="+&nbsp;关注"/>
                    </div>
                    <div id="appointProjectInfoBottomSpan">
                    	<div><span>发布约拍项目数：</span><a href="javascript:"><span>343</span></a></div>
                        <div><span>约拍累计支出额：</span><a href="javascript:"><span>342</span></a></div>
                    </div>
                </div>
          	</div>
            
            <!--发布人信息 end-->
            
           <!-- 类似项目start-->
            <div id="appointProjectSimilar">
            	<div class="appointProjectTop">
                	<p>类似项目</p>
                </div>
                <div class="appointProjectBottom">
                	<div class="appointProjectBottomCon">
                    	<table class="tableAppointProjectBottomCon">
                        	<tr>
                            	<td class="appointProjectBottomCon1"><a href="javascript:">约拍项目标题</a></td>
                                <td class="appointProjectBottomCon2">￥<span>54545</span>元</td>
                            </tr>
                            
                            <tr>
                            	<td class="appointProjectBottomCon1"><a href="javascript:">约拍项目标题</a></td>
                                <td class="appointProjectBottomCon2">￥<span>54545</span>元</td>
                            </tr>
                            
                            <tr>
                            	<td class="appointProjectBottomCon1"><a href="javascript:">约拍项目标题</a></td>
                                <td class="appointProjectBottomCon2">￥<span>54545</span>元</td>
                            </tr>
                            
                            <tr>
                            	<td class="appointProjectBottomCon1"><a href="javascript:">约拍项目标题</a></td>
                                <td class="appointProjectBottomCon2">￥<span>54545</span>元</td>
                            </tr>
                            
                            <tr>
                            	<td class="appointProjectBottomCon1"><a href="javascript:">约拍项目标题</a></td>
                                <td class="appointProjectBottomCon2">￥<span>54545</span>元</td>
                            </tr>
                        </table>
                    	
                       
                    </div>
                    
                </div>
        	</div>
            <!-- 类似项目end-->
          
          	<!-- 发布人的其他项目start-->
            <div id="appointProjectOther">
            	<div class="appointProjectTop">
                	<p>发布人的其他项目</p>
                </div>
                <div class="appointProjectBottom">
                	<div class="appointProjectBottomCon">
                    	<table class="tableAppointProjectBottomCon">
                        	<tr>
                            	<td class="appointProjectBottomCon1"><a href="javascript:">约拍项目标题</a></td>
                                <td class="appointProjectBottomCon2">￥<span>54545</span>元</td>
                            </tr>
                            
                            <tr>
                            	<td class="appointProjectBottomCon1"><a href="javascript:">约拍项目标题</a></td>
                                <td class="appointProjectBottomCon2">￥<span>54545</span>元</td>
                            </tr>
                            
                            <tr>
                            	<td class="appointProjectBottomCon1"><a href="javascript:">约拍项目标题</a></td>
                                <td class="appointProjectBottomCon2">￥<span>54545</span>元</td>
                            </tr>
                            
                            <tr>
                            	<td class="appointProjectBottomCon1"><a href="javascript:">约拍项目标题</a></td>
                                <td class="appointProjectBottomCon2">￥<span>54545</span>元</td>
                            </tr>
                            
                            <tr>
                            	<td class="appointProjectBottomCon1"><a href="javascript:">约拍项目标题</a></td>
                                <td class="appointProjectBottomCon2">￥<span>54545</span>元</td>
                            </tr>
                        </table>
                    	
                       
                    </div>
                    
                </div>
        	</div>
            <!-- 发布人的其他项目end-->
            
            
          </div>
          
          
    </div>
	
    
    <!--弹出我要报价-->
        <form action="javascript:" id="offerProductShootForm">
        <div id="offerProductShoot">
        	<div class="top">
            	<h2>我要报价</h2>
                <a href="javascript:cloosePopBox('offerProductShootForm');" class="closeProductShoot"></a>
            </div>
            
            <div class="title">
            	<h2>报价目标项目:<span>标题项目标题</span></h2>
                
            </div>
            
            <div class="view" id="viewmx">
            	<div class="view-a">
                	<a href="javascript:viewTotal('viewmx','viewto');">仅报总价</a>
                </div>
            	<div class="topHead">
                	<div class="th th-num">序号</div>
                    <div class="th th-info">计费项目</div>
                    <div class="th th-money">金额(￥)</div>
                    <div class="th th-op">操作</div>
                </div>
            	<table class="viewTable" id="viewTable">
                	
                </table>
                <div class="bottomHead">
                	<div class="tb tb-add"><a href="javascript:addViewTr();">添加计费项</a></div>
                    <div class="tb tb-total">总计</div>
                    <div class="tb tb-tmoney"><span>4234.00</span>元</div>
                </div>
            </div>
            
            <div class="view-t" id="viewto">
            	<div class="view-tv">
                	<span class="total">总价：</span><input type="text" /><span class="y">元</span><a href="javascript:viewTotal('viewmx','viewto');">使用明细报价</a>
                </div>
            </div>
            
            <div class="btn">
            	<input type="reset" class="reset" value="取消报价" onclick="cloosePopBox('offerProductShootForm');"/>
                <input type="submit" class="submit" value="提交报价" />
            </div>
            
            <div class="explain">
            	<div class="ep1">收入说明：</div>
                <div class="ep ep2">1.如果您是摄影师或模特：您的收入为出售作品或应约收入金额除去税费后的80%；</div>
                <div class="ep ep3">2.如果您是经纪人：您的收入为您所经纪的对象出售作品或应约收入金额除去税费后的2.5%；</div>
                <div class="ep ep4">注：税费为交易额的8%，其中包括：国家收取的税费与附加费、银行或第三方支付进出转账汇款手续费等。</div>
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
            	<img src="../../../userView/public/images/weixin.png"/>
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
<script src="../../../userView/public/js/DD_belatedPNG_0.0.8a.js" type="text/javascript"></script>
    <script type="text/javascript">
        DD_belatedPNG.fix('div, ul, img, li, input , a , i');
    </script>
<![endif]-->


</body>
</html>

