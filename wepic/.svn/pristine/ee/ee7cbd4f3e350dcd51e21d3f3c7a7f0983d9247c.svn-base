<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s" %>
 <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="shortcut icon" href="<%=basePath %>public/images/logoSmall.ico"/>

<title>wepic管理_个人中心_我的作品库_创建故事</title>
<script type="text/javascript" src="<%=basePath %>public/js/imgsf.js"></script>
<script type="text/javascript" src="<%=basePath %>public/js/jquery.js"></script>

<script type="text/javascript" src="<%=basePath %>back/personalCentr/myworklib/js/relWork.js"></script>
<!--公共js-->
<script type="text/javascript" src="<%=basePath %>back/js/publicBack.js"></script>
<script type="text/javascript" src="<%=basePath %>public/js/public.js"></script>
<script type="text/javascript" src="<%=basePath %>public/js/topBar.js"></script>
<script type="text/javascript" src="<%=basePath %>public/js/header.js"></script>

<!--公共css-->
<link type="text/css" rel="stylesheet" href="<%=basePath %>public/css/backMainBar.css" />
<link type="text/css" rel="stylesheet" href="<%=basePath %>public/css/topBarMain.css" />
<link type="text/css" rel="stylesheet" href="<%=basePath %>public/css/header.css" />
<link type="text/css" rel="stylesheet" href="<%=basePath %>public/css/footer.css" />
<link type="text/css" rel="stylesheet" href="<%=basePath %>back/personalCentr/myworklib/css/relWork2.css" />



<script type="text/javascript">

window.onload = function(){
	
	achieveBelow("divSelectHighestDegreeValue","selectHighestDegreeValue")					/*获取下拉框值并隐藏	最高学历*/
	
	//achieveBelow("divSelectMoneyValue","selectMoneyValue")					/*获取下拉框值并隐藏	最高学历*/
	}
function mysmt(){
verifyForm();
var storyId=document.getElementById("editsotryId").value;
storyform.action="story!preparepublishstory.do?storyId="+storyId;  
storyform.submit();   
}
function initdata(){

if('<s:property value="story.copyrightres"/>'==0){
$("#checkuesr1").attr("checked",true);
$("#inpcheckuesr").attr("disabled",false);
$("#inpcheckuesr").val('<s:property value="story.usagePrice"/>'); 
}else if('<s:property value="story.copyrightres"/>'==1){
$("#checkuesrcopyright").attr("checked",true);
$("#inpcheckuesr2").val('<s:property value="story.copyrightPrice"/>');
}else if('<s:property value="story.copyrightres"/>'==2){
$("#checkuesr1").attr("checked",true);
$("#inpcheckuesr").val('<s:property value="story.usagePrice"/>');
$("#checkuesrcopyright").attr("checked",true);
$("#inpcheckuesr2").val('<s:property value="story.copyrightPrice"/>');
}
}
</script>
</head>

<body onload="initdata()">
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
            
            <a href="<%=basePath %>publish!findAllMyLib.do"><div class='bar'><span>图片作品</span><i></i></div></a>
            
            <a href="<%=basePath %>/story!storylist.do"><div class='bar'><span>摄影故事</span><i></i></div></a>
            
            <a href="javascript:"><div class='bar'><span>视频作品</span><i></i></div></a>
            
            <a href="<%=basePath %>back/personalCentr/myworklib/workUpload.jsp"><div class='bar'><span>上传作品</span><i></i></div></a>
            
            <a href="<%=basePath %>story!initdata.do"><div class='bar  active'><span>创建故事</span><i></i></div></a>
            
            <a href="<%=basePath %>back/personalCentr/myworklib/chooseRelWork.jsp"><div class='bar'><span>发布作品</span><i></i></div></a>
        </div>
        </div>
    </div>
    <!-- 导航  end-->
    
    <!--内容-->
    <form name="storyform"  method="post">
    <input type="hidden" id="editsotryId" value="<s:property value='story.id' />"/>
    <div id="divRelWork">
   		<div class="character">
        	<span class="upl">编辑故事</span>
        	<span class="more">故事内容至少需要一张以上图片</span>
            
            <input class="inputup" type="button" value="返回上一页">
        </div>
        
        <div class="content">
        	<div class="head">
            	<div class="left">
                	<div class="img" id="divChangeHead">
                	    <input type="hidden" name="coverId" id="coverId" value="<s:property value='story.publishid'/>" />
                    	<img src="<s:property value="story.cover"/>" onload="javascript:DrawImage(this,285,175)"/>
                        <div class="nowtop" id="divViewHead">
                        	<div class="bj"></div>
                        	<div class="bjc">
                        		<div class="sp1"><a onclick="changeHeadStory('cropHead');">更换故事封面</a></div>
                                <div class="sp2">故事封面仅供故事展示使用</div>
                            </div>
                        </div>
                    </div>
                	
                    <div class="inn">
                    	<div>作品编号：<span><s:property value="story.remark"/></span></div>
                    	<!--<div>创建时间：<span>2013</span>-<span>08</span>-<span>26</span></div>
                    	<div>作品状态：<span>未发布</span></div>-->
                    
                    </div>
                </div>
                
                <div class="right">
                	<div class="title">
                    	<span>故事标题</span>
                        <input class="texttitle" value="<s:property value="story.title"/>" type="text" name="title" id="texttitleinp" onblur="promptInfo('texttitleinp','titleprompt',40);"/>
                    	<span>所属专辑</span>
                        
                        
                    <div class="editSelect" id="divHighestDegree" >
                    	<div class="viewBelow" onclick="showBelow('divSelectHighestDegreeValue')" id="viewBelowHighestDegree">
                        	<div id="selectHighestDegreeValue"><s:property value="specialCat.name"/></div>
                       		<div class="viewBelowRight"><i></i></div>     
                    	</div>
                           
                    	<div class="belowValue" id="divSelectHighestDegreeValue" style="display:none;">
                        	<span class='selectValueIn'>请选择</span>
                        	<s:iterator value="specialCats" var="specialcat">
                        	<span class='selectValueIn'> <input type="hidden" name="special" id="special" value="<s:property value='#specialcat.id'/>"/><s:property value="#specialcat.name"/></span>
                        	</s:iterator>
 						</div>
            		</div>
                        
                        <a class="addzj" href="specialPublish!findSpecialOfStoryByUser.do">管理专辑</a>
                    
                    </div>
                	
                    <div id="titleprompt" class="promptInf">
                    	<!--<div><span>不能为空</span></div>-->
                    </div>
                    
                    <div class="storyDe">
                    	<span class="span">故事描述</span>
                        <textarea id="textareastorytt"  name="storydescription" onblur="promptInfo('textareastorytt','textareaStory',400);"><s:property value="story.storydescription" escape="false"/></textarea>
                    </div>
                    
                    <div id="textareaStory" class="promptInf">
                    	<!--<div><span>不能为空</span></div>-->
                    </div>
                    
                    <div class="divbottom">
                    	<div class="spanv">
                    		<span>故事正文</span>
                        </div>
                        <div class="picin">
                        	<span class="span">图片数</span>
                            <span class="picnum"><s:property value="picNum"/></span>张
                            <span class="zzs">总字数</span>
                            <span class="picnum"><s:property value="textNum"/></span>字
                        </div>
                    </div>
                    
                    
                </div>
            </div>
            
        </div>
        
        
        
        
        
        <div class="divAddPic">
        	<div class="right">
        	<div class="addcon" id="divallDe">
        	<s:iterator value="storyDetails" var="details">
        	<div class="addcon-de">
                	<a class="delcon" href="javascript:" onclick="delcon(this);">×</a>
                	<div class="head"><input name='temppublish' type='hidden' id='temppublish' value="<s:property value='#details.publishId'/>"></input><img src="<s:property value=" #details.thumbnailUrl"/>" /></div>
                    <div class="area"><textarea name='storycxt' id='storycxt'> <s:property value="#details.detailContext" /> </textarea></div>
                </div>
        	</s:iterator>
            </div>
            
            
            <div class="addPicBut">
                <div class="but"><input type="button" value="添加图片" onclick="addSubStory();"/></div>
                <div class="int">添加故事图片以编辑</div>
            </div>
            
            
            <div class="promptInf" id="chooseconn">请添加图片</div>
            
            <!--添加作品类型-->
        <div class="divkeyword">
        	<div class="typeCha">作品类型</div>
        	<div class="choosed">
            	<div class="con">
        			<div id="divAddEnTagpho">
            			<input type="hidden" id="hiddenReTags" />
            			<s:iterator value="publishCatStories" var="catstory">
            			<div class="retag"><span>
            			<input type="hidden" name="temppublishcat" value="<s:property value="#catstory.publishCat.name"/>" /><s:property value="#catstory.publishCat.name"/></span>
            			<a onclick="deleteProModel(this);" title="删除"></a></div>
            			</s:iterator>
            		</div>
            		<div style="clear:both;"></div>
        		</div>
            </div>
            
            
            <div class="chooseCon">
    			<div class="one">您可以选择以下类型：</div>
        		<div class="con">
        			<div id="divAddReTag">
        			    
        			    <s:iterator value="publishCats" var="publishcat">
        			    <div class="retag"><span>
        			     <s:property value="#publishcat.name"/></span><a title='增加' onclick="addreProfTag(this,'divAddEnTagpho');"></a></div>
        			    </s:iterator>        			
        			</div>
            		<div style="clear:both;"></div>
        		</div>
    		</div>
            
            <div class="promptInf" id="choosetypeCha">请选择作品类型</div>
        </div>
        
        <!--添加作品类型--> 
        
        
        	<div class="chooseTagM">
        	<div class="typeCha">关键词</div>
    		
            <div class="choosed">
        		<div class="con">
        			<div id="divAddPersonTag">
                    <input type="hidden" id="hiddenReTagsP" />
                    <input type="hidden" id="hiddenUserTagsP" />
                    <s:iterator value="storytags" var="mytag">
	                    <div class="tag">
						<span>
						<input type="hidden" value="<s:property value='#mytag' />" id="mytags" name="mytags"></input>
						<s:property value="#mytag" />
						</span>
						<a onclick="deleteProModel(this);" title="删除"></a>
						</div>
                    </s:iterator>
            		</div>
            		<div style="clear:both;"></div>
        		</div>
            </div>
            
            <div class="addProf">
    			<input class="inputaddProf" id="inputaddPerson" type="text" onkeyup="doit(this)" onafterpaste="doit(this)"
                onfocus="if(this.value=='自定义关键词') this.value='';this.style.color='#333'" onblur="if(this.value=='') {this.value='自定义关键词';this.style.color='#7f7f7f'}" value="自定义关键词" style="color: rgb(127, 127, 127);"/>
        		<input class="inputaddProfTag" type="button" value="添加" onclick="addProfTagPerson('inputaddPerson','divAddPersonTag');"/>
        		<span class="spanintro">自定义关键词建议不要超过5个汉字</span>
    		</div>	
            
        </div>		
        
        
        
        
        <!--图片售价-->
        <div class="priceInfo">
        <div class="priceInfoOne priceInfoOnem">
        	<span class="spansell">出售币种</span>
            <input type="hidden" value="人民币" name="moneyType"/>
            <span class="tsin">人民币</span>
        	<!--<div class="editSelect" id="divsaMoney">
                    	<div class="viewBelow" onclick="showBelow('divSelectMoneyValue')">
                        	<div id="selectMoneyValue">选择币种</div>
                       		<div class="viewBelowRight"><i></i></div>    
                    	</div>
                           
                    	<div class="belowValue" id="divSelectMoneyValue" style="display:none;">
                        	<span class='selectValueIn'>人民币</span>
 						</div>
            </div>-->
            <div class="divuserq">
            	<input type="checkbox" name="copyrightres" value="0" id="checkuesr1"  onchange="changeuse(this,'inpcheckuesr')"/>
            	<label for="checkuesr" >出售使用权</label>
            	<input id="inpcheckuesr" name="copyrightuseprice" class="inputuses" type="text" onfocus="if(this.value=='出售价格') this.value='';this.style.color='#333'" onblur="if(this.value=='') {this.value='出售价格';this.style.color='#e6e6e6'}" value="出售价格" onkeyup="value=value.replace(/[^\d\.]/g,'')"/>
                <span id="cssyq" class="proms">请填写出售使用权金额</span>
        	</div>
        </div>
        
         <div class="priceInfoOne">
        	<span class="spansell">授权区域</span>
            <input type="hidden" name="copyrightArea" value="中国大陆"/>
            <span class="tsin">中国大陆</span>
        	<!--<input class="inputuses" type="text">-->
            
            <div class="divuserq">
            	<input type="checkbox" name="copyrightres" value="1"  id="checkuesrcopyright" onchange="changeuse(this,'inpcheckuesr2')"/>
            	<label class="labeluser" for="checkuesr">出售版权</label>
            	<input class="inputuses"  name="copyrightcopyrightprice" id="inpcheckuesr2" type="text" onfocus="if(this.value=='出售价格') this.value='';this.style.color='#535353';" onblur="if(this.value=='') {this.value='出售价格';this.style.color='#e6e6e6'}" value="出售价格"  onkeyup="value=value.replace(/[^\d\.]/g,'')" />
                <span id="csbq" class="proms">请填写出售版权金额</span>
        	</div>
        </div>
        </div>
        <!--图片售价-->
        
        <div class="charcom">
        	<span class="span1">版权属性</span>
        	<input type="hidden" name="copyrightProperty" value="仅限用于传媒"/>
        	<span class="span2">仅限用于传媒</span>
        </div>
        
        
        </div>
        
        
        </div>
        
        
        
        
        
        <div class="submit">
               <div class="inp">
               		<input class="inputup" type="button" value="取消">
					<input class="finished" type="button" value="保存" onclick="mysmt();">
               </div>
        </div>
    </div>
    </form>
    
     <div id="chooseWork" style="width:1000px;height:800px; display:none;">
    	<iframe name='child' style="border:0px;width:1000px;height:800px" src="<%=basePath %>back/personalCentr/myworklib/chooseHead.jsp"></iframe>
    </div>
    
    <div id="cropHead" style="width:1130px;height:900px; z-index:100000000;display:none;overflow:hidden;">
    	<iframe name='child2' style="border:0px;width:1200px;height:900px;overflow:hidden;z-index:100000000" src="<%=basePath %>back/personalCentr/myworklib/cropHead.jsp"></iframe>
    </div>
    
    <div id="chooseworkdetail" style="width:1000px;height:800px; display:none;">
    	<iframe name='child1' style="border:0px;width:1000px;height:800px" src="<%=basePath %>back/personalCentr/myworklib/chooseworkdetail.jsp"></iframe>
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
</div>
<!--[if lte IE 6]>
<script src="../../../userView/public/js/DD_belatedPNG_0.0.8a.js" type="text/javascript"></script>
    <script type="text/javascript">
        DD_belatedPNG.fix('div, ul, img, li, input , a , i');
    </script>
<![endif]-->


</body>
</html>

