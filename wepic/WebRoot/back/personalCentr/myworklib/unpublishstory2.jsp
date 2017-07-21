<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

 <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="shortcut icon" href="<%=basePath %>public/images/logoSmall.ico"/>

<title>wepic管理_个人中心_我的作品库_摄影故事_未发布详情</title>

<link type="text/css" rel="stylesheet" href="<%=basePath %>public/css/backMainBar.css" />
<link type="text/css" rel="stylesheet" href="<%=basePath %>back/personalCentr/myworklib/css/phoStoryUnpublished2.css" />

<script type="text/javascript" src="<%=basePath %>public/js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath %>back/personalCentr/myworklib/js/phoStoryUnpublished2.js"></script>
<!--公共js-->
<script type="text/javascript" src="<%=basePath %>public/js/publicBack.js"></script>
<script type="text/javascript" src="<%=basePath %>public/js/public.js"></script>
<script type="text/javascript" src="<%=basePath %>public/js/topBar.js"></script>
<script type="text/javascript" src="<%=basePath %>public/js/header.js"></script>

<!--公共css-->
<link type="text/css" rel="stylesheet" href="<%=basePath %>public/css/topBarMain.css" />
<link type="text/css" rel="stylesheet" href="<%=basePath %>public/css/header.css" />
<link type="text/css" rel="stylesheet" href="<%=basePath %>public/css/footer.css" />
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
                            	<img src="<%=basePath %>public/images/pic/topUser.jpg" />
                                <div id="topBarUserOneHeadChange">
                                	<div><a href="javascript:">更改头像</a></div>
                                </div>
                            </div>
                            <div id="topBarUserOneDetailed">
                            	<div id="topBarUserOneDetailedOne">
                                	<img id="topBarUserOneDetailedimg" src="<%=basePath %>public/images/grade/uesrLogo.png"/>
                                    <img src="<%=basePath %>public/images/grade/diamond.png"/>
                                    <img src="<%=basePath %>public/images/grade/diamond.png"/>
                                    <img src="<%=basePath %>public/images/grade/star.png"/>
                                    <img src="<%=basePath %>public/images/grade/star.png"/>
                                    <img src="<%=basePath %>public/images/grade/star.png"/>
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
                            		<img src="<%=basePath %>public/images/pic/topUser.jpg"/>
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
                            		<img src="<%=basePath %>public/images/pic/topUser.jpg"/>
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
                            		<img src="<%=basePath %>public/images/pic/topUser.jpg"/>
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
    				<img src="<%=basePath %>public/images/wepic_logo.png" alt="唯图网"/>
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
            
            <a href="javascript:"><div class='bar'><span>图片作品</span><i></i></div></a>
            
            <a href="javascript:"><div class='bar active'><span>摄影故事</span><i></i></div></a>
            
            <a href="javascript:"><div class='bar'><span>视频作品</span><i></i></div></a>
            
            <a href="javascript:"><div class='bar'><span>上传作品</span><i></i></div></a>
            
            <a href="javascript:"><div class='bar'><span>创建故事</span><i></i></div></a>
            
            <a href="javascript:"><div class='bar'><span>发布作品</span><i></i></div></a>
        </div>
        </div>
    </div>
    <!-- 导航  end-->
    
    <!--内容-->
    <div id="divPhoStroyHead">
   		<div class="head">
            <table>
            	<tr>
                	<td class="td1">
                    	<div class="divdropDown">
                    		<div class="dropDownBox" id="dropDownBoxPartType" onclick="showBelow('divdropDownPartType')">
                    			<span id="divdropDownViewPartType"></span>
                        		<div class="dropDownBoxR"><i></i></div>
                    		</div>
                    
                    		<div class="dropDownBoxValue" id="divdropDownPartType">
                    			<span class='dropValue'>建筑内外景拍摄</span>
                       			<span class='dropValue'>平面广告拍摄</span>
                    			<span class='dropValue'>建筑内外景拍摄</span>
                       			<span class='dropValue'>平面广告拍摄</span>
                    			<span class='dropValue'>建筑内外景拍摄</span>
                       			<span class='dropValue'>平面广告拍摄</span>
   			            	    <span class='dropValue'>建筑内外景拍摄</span>
            			        <span class='dropValue'>平面广2告444444444拍摄</span>
                    			<span class='dropValue'>建筑内外景拍摄</span>
			                    <span class='dropValue'>平面广告拍摄</span>
            			        <span class='dropValue'>建筑内外景拍摄</span>
                       			<span class='dropValue'>平面广告拍摄</span>
                 			 </div>
                  		</div>
                    </td>
                	
                    <td class="td2"><a href="manageSpecial.html" class="glz">管理专辑</a></td>
                    <td class="td3">
                    	<span class="sp1">当前专辑作品数</span>
                    	<span class="num">232424</span>张
                    
                    	<span class="sp2">已发布</span>
                    	<span class="num">32</span>张
                    </td>
                </tr>
            
            </table>
            <div class="inp">
               	<input class="inputup" type="button" value="返回上一页">
            </div>
            
        </div>
            
   </div>
        
        
        
        
        
        <!--摄影故事内容-->
        <div id="phoStroyDetail">
        	<div class="phoStroyDetailLeft"  id="phoStroyDetailLeft">
        		<div class="divHead">
                	<div class="name" title="这里是标题全称">摄影故事标题摄影故事标题摄影故事标题摄影故事标题摄影故事标题摄影故事标题摄影故事标题摄影故事标题摄影故事标题摄影故事标题摄影故事标题摄影故事标题摄影故事标题</div>
                </div>
                
                <div class="divDescribe">
                	<div class="edit" id="editzpgs">
                    	<div class="bj"></div>
                    	<div class="bjc">
                        	<a href="javascript:" class="dowload">
                            	<div class="backimg"></div>
								<p>下载故事</p>
                            </a>
                            <a href="javascript:" class="delete">
                            	<div class="backimg"></div>
								<p>删除作品</p>
                            </a>
                        </div>
                    </div>
                	<div class="character">故事描述：</div>
                    <div class="dec">父母从小就要注意培养孩子良好的行为习惯，使其终身受益。良好的习惯是一个人做人、做事、求知、共处的根本。若想要孩子养成良好的习惯就要让孩子有良好的教育。人的教育是一项系统的教育工程，包含着家庭教育、社会教育、集体教育，三者相互影响、相互作用、相互制约，在这项系统工程之中，家庭教育是一切教育的基础。父母的力量决定孩子的一切。因此，父母从小就要注意培养孩子良好的行为习惯，使其终身受益。良好的习惯是一个人做人、做事、求知、共处的根本。若想要孩子养成良好的习惯就要让孩子有良好的教育。人的教育是一项系统的教育工程，包含着家庭教育、社会教育、集体教育，三者相互影响、相互作用、相互制约，在这项系统工程之中，家庭教育是一切教育的基础。父母的力量决定孩子的一切。因此，父母从小就要注意培养孩子良好的行为习惯，使其终身受益。良好的习惯是一个人做人、做事、求知、共处的根本。若想要孩子养成良好的习惯就要让孩子有良好的教育。人的教育是一项系统的教育工程，包含着家庭教育、社会教育、集体教育，三者相互影响、相互作用、相互制约，在这项系统工程之中，家庭教育是一切教育的基础。父母的力量决定孩子的一切。因此，父母从小就要注意培养孩子良好的行为习惯，使其终身受益。良好的习惯是一个人做人、做事、求知、共处的根本。若想要孩子养成良好的习惯就要让孩子有良好的教育。人的教育是一项系统的教育工程，包含着家庭教育、社会教育、集体教育，三者相互影响、相互作用、相互制约，在这项系统工程之中，家庭教育是一切教育的基础。父母的力量决定孩子的一切。因此，父母从小就要注意培养孩子良好的行为习惯，使其终身受益。良好的习惯是一个人做人、做事、求知、共处的根本。若想要孩子养成良好的习惯就要让孩子有良好的教育。人的教育是一项系统的教育工程，包含着家庭教育、社会教育、集体教育，三者相互影响、相互作</div>
                </div>
                
                <div class="storyzw">故事正文：</div>
                <div class="divContent">
                    <div class="picStory"><img src="<%=basePath %>public/pic/pho.png" /></div>
                	<div class="char">图片尺寸：<span>1221</span>*<span>2321</span>px</div>
                    <div class="info">良好的习惯是一个人做人、做事、求知、共处的根本。若想要孩子养成良好的习惯就要让孩子有良好的教育。人的教育是一项系统的教育工程，包含着家庭教育、社会教育、集体教育，三者相互影响、相互作用、相互制约，在这项系统工程之中，家庭教育是一切教育的基础。父母的力量决定孩子的一切。因此，父母从小就要注意培养孩子良好的行为习惯，使其终身受益。良好的习惯是一个人做人、做事、求知、共处的根本。若想要孩子养成良好的习惯就要让孩子有良好的教育。人的、相互作用、相互制约，在这项系统工程之中，家庭教育是一切教育的基础。父母的力量决定孩子的一切。因此，父母从小就要注意培养孩子良好的行为习惯，使其终身受益。</div>
                </div>
                
                <div class="divContent">
                    <div class="picStory"><img src="<%=basePath %>public/pic/pho.png" /></div>
                	<div class="char">图片尺寸：<span>1221</span>*<span>2321</span>px</div>
                    <div class="info">良好的习惯是一个人做人、做事、求知、共处的根本。若想要孩子养成良好的习惯就要让孩子有良好的教育。人的教育是一项系统的教育工程，包含着家庭教育、社会教育、集体教育，三者相互影响、相互作用、相互制约，在这项系统工程之中，家庭教育是一切教育的基础。父母的力量决此，父母从小就要注意培养孩子良好的行为习惯，使其终身受益。良好的习惯是一个人做人、做事、求知、共处的根本。若想要孩子养成良好的习惯就要让孩子有良好的教育。人的教育是一项系统的教育工程，包含着家庭教育、社会教育、集体教育，三者相互影响、相互作用、相互制约，在这项系统工程之中，家庭教育是一切教育的基础。父母的力量决定孩子的一切。因此，父母从小就要注意培养孩子良好的行为习惯，使其终身受益。</div>
                </div>
            </div>
        
        <!--右部内容-->
         	<div class="phoStroyDetailRight">
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
                
                <div class="storyCon">
                	<div class="head">
                    	<div class="char">故事封面</div>
                        <div class="pic" id="divChangeHead">
                        	<img src="<%=basePath %>public/pic/10.png" />
                        	<div class="nowtop" id="divViewHead">
                        		<div class="bj"></div>
                        		<div class="bjc">
                        			<div class="sp1"><a onclick="changeHeadStory('cropHead');">更换故事封面</a></div>
                                	<div class="sp2">故事封面仅供故事展示使用</div>
                            	</div>
                        	</div>
                        </div>
                        
                        <div class="storyInfo">
                        	<table>
                            	<tr>
                                	<td><span>作品编号：</span></td>
                                    <td class="td2"><span>4542121454521</span></td>
                                    <td><span>创建时间：</span></td>
                                    <td><span>2012-12-23</span></td>
                                </tr>
                            	
                                <tr>
                                	<td><span>图片张数：</span></td>
                                    <td><span>3</span>张</td>
                                    <td><span>字数：</span></td>
                                    <td><span>3431</span>字</td>
                                </tr>
                            </table>
                        		
                        	
                        </div>
                    </div>
                    <div class="typeone">
                    		<table>
                            	<tr>
                                	<td class="td1">所属专辑</td>
                                    <td class="td2">默认专辑</td>
                                    <td class="td3"><a href="javascript:" onclick="openPopUpBox('moveTozj');">移动到</a></td>
                                </tr>
                            	
                                <tr>
                                	<td class="td1">作品状态</td>
                                    <td class="td2 tdDeal" colspan="3" id="redRemin">
                                    	<div class="stateRemind" id="stateRemind">
                                        	<div class="con">
                                            	<div class="char">被管理员下架原因：</div>
                                            	<div class="rea">① 图片大小图片大小图片大小图片大小图片大小图片大小图片大小图片大小</div>
                                            	<div class="rea">② 图片大小图片大小图片大小</div>
                                            	<div class="rea">③ 图片大小图片大小</div>
                                            	<div class="rea">③ 图片大小图片大小</div>
                                            </div>
                                            <div class="time">2013-02-12</div>
                                        	<div class="sanjiao"></div>
                                        </div>
                                    	<span class="red">被管理员下架</span>
                                    </td>
                                </tr>
                                
                                <tr>
                                	<td class="td1">作品说明</td>
                                    <td class="td2">暂无</td>
                                </tr>
                            </table>
                    </div>
                    <div class="gjctd"> 
                    	<div class="chaa">作品类型</div>
                        <div class="type">
                        	<div class="retag">
								<span>时装摄影师</span>
								<a></a>
							</div>
                            
                            <div class="retag">
								<span>时装摄影师</span>
								<a></a>
							</div>
                            
                            <div class="retag">
								<span>时装摄影师</span>
								<a></a>
							</div>
                            
                            <div class="retag">
								<span>时装摄影师</span>
								<a></a>
							</div>
                            
                            <div class="retag">
								<span>时装摄影师</span>
								<a></a>
							</div>
                            
                            <div class="retag">
								<span>时装摄影师</span>
								<a></a>
							</div>
                            
                            <div class="retag">
								<span>时装摄影师</span>
								<a></a>
							</div>
                            
                            <div class="retag">
								<span>时装摄影师</span>
								<a></a>
							</div>
                            
                        </div>
                        <div style="clear:both;"></div>
                        
                    	<div class="chaa">关键词</div>
                        <div class="keyword">
                        	<a href="javascript:">焦点</a>
                        	<a href="javascript:">焦点</a>
                        	<a href="javascript:">焦点</a>
                        	<a href="javascript:">焦点</a>
                        	<a href="javascript:">焦点</a>
                        	<a href="javascript:">焦点</a>
                       	</div>
                    </div>
                    <div class="edt">
                    	<input class="inputyq" type="button" value="编辑" onclick="location.href='creatStoryedit.html';"/>
						<input class="inputsx" type="button" value="发布该作品" onclick="location.href='relWorkedit.html';"/>
                    </div>
                </div>
            </div>
       <!--右部内容-->
        
        
        </div>
        
        
        
        
        <!--摄影故事内容-->
    
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
            	<img src="<%=basePath %>public/images/weixin.png"/>
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
    
    
    <div id="moveTozj">
    	<div class="top">
    		<h2>选择专辑</h2>
			<a href="javascript:cloosePopBox('moveTozj');"></a>
    	</div>
        
    	<div class="zhuanji" id="zhuanjiadd">
        	<ul>
            	<li>
                	<div class="special">
						<div class="tone tone1"></div>
						<div class="name">最炫名族风</div>
					</div>
                </li>
                
                <li>
                	<div class="special">
						<div class="tone tone2"></div>
						<div class="name">最炫名族风</div>
					</div>
                </li>
                
                <li>
                	<div class="special">
						<div class="tone tone3"></div>
						<div class="name">最炫名族风</div>
                        
					</div>
                </li>
                
                <li>
                	<div class="special">
						<div class="tone tone4"></div>
						<div class="name">最炫名族风</div>
					</div>
                </li>
                <li>
                	<div class="special">
						<div class="tone tone2"></div>
						<div class="name">最炫名族风</div>
					</div>
                </li>
                
                <li>
                	<div class="special">
						<div class="tone tone3"></div>
						<div class="name">最炫名族风</div>
                        
					</div>
                </li>
                
                <li>
                	<div class="special">
						<div class="tone tone4"></div>
						<div class="name">最炫名族风</div>
					</div>
                </li>
                <li>
                	<div class="special">
						<div class="tone tone2"></div>
						<div class="name">最炫名族风</div>
					</div>
                </li>
                
                <li>
                	<div class="special">
						<div class="tone tone3"></div>
						<div class="name">最炫名族风</div>
                        
					</div>
                </li>
                
                <li>
                	<div class="special">
						<div class="tone tone4"></div>
						<div class="name">最炫名族风</div>
					</div>
                </li>
                
            </ul>
    		
            
            <div class="divAddSpecial">
				<a href="manageSpecial.html">管理专辑</a>
			</div>
    	</div>
        
        <div class="tijaio">
        	<input class="reset" type="button" value="取消"  onclick="cloosePopBox('moveTozj');"/>
			<input class="sub" type="button" value="确定" onclick="cloosePopBox('moveTozj');"/>
    	</div>
    </div>
    
    <div id="chooseWork" style="width:952px;height:700px; z-index:100000000;display:none;overflow:hidden;">
    	<iframe name='child' style="border:0px;width:1000px;height:810px;overflow:hidden;z-index:100000000" src="<%=basePath %>public/chooseHead.html"></iframe>
    </div>
    
    
</div>
<!--[if lte IE 6]>
<script src="../../../userView/public/js/DD_belatedPNG_0.0.8a.js" type="text/javascript"></script>
    <script type="text/javascript">
        DD_belatedPNG.fix('div, ul, img, li, input , a , i');
    </script>
<![endif]-->


</body>
</html>

