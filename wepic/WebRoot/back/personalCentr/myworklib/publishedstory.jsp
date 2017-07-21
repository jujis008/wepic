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

<title>wepic管理_个人中心_我的作品库_摄影故事_已发布详情</title>

<link type="text/css" rel="stylesheet" href="<%=basePath %>public/css/backMainBar.css" />
<link type="text/css" rel="stylesheet" href="<%=basePath %>back/personalCentr/myworklib/css/phoStoryReleased.css" />
<script type="text/javascript" src="<%=basePath %>public/js/imgsf.js"></script>
<script type="text/javascript" src="<%=basePath %>public/js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath %>back/personalCentr/myworklib/js/phoStoryReleased.js"></script>
<!--公共js1-->

<script type="text/javascript" src="<%=basePath %>public/js/publicBack.js"></script>
<script type="text/javascript" src="<%=basePath %>public/js/public.js"></script>
<script type="text/javascript" src="<%=basePath %>public/js/topBar.js"></script>
<script type="text/javascript" src="<%=basePath %>public/js/header.js"></script>

<!--公共css-->
<link type="text/css" rel="stylesheet" href="<%=basePath %>public/css/topBarMain.css" />
<link type="text/css" rel="stylesheet" href="<%=basePath %>public/css/header.css" />
<link type="text/css" rel="stylesheet" href="<%=basePath %>public/css/footer.css" />
<script type="text/javascript">
		$(function(){
		var sp='<s:property value="specialName"/>';
		var specialId='<s:property value="specalCatId"/>';
		if(sp == ''){
		var disspecialname='<s:property value="specialCat.name"/>';
		var a='<s:property value="specialCat.id"/>';
		var b=$("#specalCatId").val(a);
		$("#dropDownBoxPartType").html(disspecialname);
		}else{
		$("#dropDownBoxPartType").html(sp);
		$("#specalCatId").val(specialId);
		}		
		   //getImgSUnm(specialId,storystatu);
        
    	$.ajax({
  	      type:"Post",
  		  url: "specialcat_getpublishSpecialCats2.do",
  		  data:"",		
  		  success : function(data) {
  	  	  var list=data.publishSpecialCats;
  	  	  var html='<span class="dropValue" id=0>所有专辑</span>';
  	  	  for(var i=0;i<list.length;i++){
  	  	  	  publishCat=list[i];
  	  		html+='<span class="dropValue" id='+publishCat.id+'>'+publishCat.name+'</span>';
  	  	  	  } 
  	  	    $("#divdropDownPartType").html(html);
  	  	    achieveBelow2("divdropDownPartType","dropDownBoxPartType");
  		  }
    	});
        });
        
        function achieveBelow2(bolewDiv,showValue){
    	var bolewDiv=document.getElementById(bolewDiv);
    	var bolewDivSpan=bolewDiv.getElementsByTagName("span");
    	for(var i=0;i<bolewDivSpan.length;i++){
    		   bolewDivSpan[i].onclick=function (){
    		   var id=$(this).attr("id");
    			  $("#specalCatId").val($(this).attr("id"));
            	 $("#specialName").val(this.innerHTML);
            	 searchByterm();
    			$("#"+showValue).html(this.innerHTML);
    			$(bolewDiv).hide();
    			$(bolewDiv).parent().parent().css("z-index","0");
    			};
    		}
       }

    
    
     function getImgSUnm(id,storystatu){
    	$.ajax({
    	      type:"Post",
    		  url: "userstory_findstorybyCountBySpecialCat.do",
    		  data:"publishSpecialCatId="+id+"&storystatu="+storystatu,		
    		  success : function(data) {
              var c=data.count;
    	  	$("#albumnnum").html(c[0]);
    	  	$("#publishsucnum").html(c[1]);
    		  }
      	});
        }
        
        
        $(function(){
        var id='<s:property value="specialCat.id"/>';
        $.ajax({
  	      type:"Post",
  		  url: "userstory_storyprenext.do?specialId="+id,
  		  data:"",		
  		  success : function(data) {
  	  	  var list=data.stories;
  	  	  
  	  	  var cxt="";
  	  	  var currentStoryId='<s:property value="story.id"/>';
  	  	  var pre="";
  	  	  var next="";
  	  	  var myArray=new Array();
  	  	  for(var i=0;i<list.length;i++){
  	  	      myArray.push(list[i].id);	  
  	  	  }
  	  	  var fir=myArray[0];
  	  	  var last=myArray[myArray.length-1];
  	  	  if(myArray.length <= 1){
  	  	     pre=myArray[0];
  	  	     next=myArray[0];
  	  	  }else{
  	  	  for(var i=0; i<myArray.length;i++){
  	  	      if(myArray[i] == currentStoryId){
  	  	      pre=myArray[i-1];
	  	  	          next=myArray[i+1];
  	  	           if(myArray[i] == fir){
  	  	           pre=myArray[i];
	  	  	          next=myArray[i+1];
  	  	           }else if(myArray[i] == last){
	  	  	          pre=myArray[i-1];
	  	  	          next=myArray[i];
	  	  	  }
	  	  	          
	  	  	  }
  	  	  }
  	  	  }
  	  	  cxt+="<div class='pre'><a href='story!searchStorypublish.do?id="+pre+"'><i></i><span >上一篇</span></a></div><div class='next'>"+
               "<a href='story!searchStorypublish.do?id="+next+"'><span>下一篇</span><i></i></a></div>";
           $(".preNext").html(cxt);  	  	  
  		  }
    	});
        });
    //提交查询
    function searchByterm(){
        $("#unpublishstory").submit();
        }
        
        
        $(function(){
    $("#divdropDownViewPartType").html("请选择");
	$.ajax({
	      type:"Post",
		  url: "specialcat_getpublishSpecialCats.do",
		  data:"",		
		  success : function(data) {
	  		  
	  	  var list=data.publishSpecialCats;
	  	  var html='<span class="dropValue">请选择</span>';
	  	  var changeSp="";
	  	  for(var i=0;i<list.length;i++){
	  	  	  publishCat=list[i];
	  		html+='<span class="dropValue" id='+publishCat.id+'>'+publishCat.name+'</span>';
	  		changeSp+='<li id='+publishCat.id+'><div class="special"><div class="tone tone1"style="background:'+publishCat.icon+'"></div><div class="name">'+publishCat.name+'</div></div></li>';
	  	  	  } 
  	  	  $("#zhuanjiadd").find("ul").html(changeSp);

	  	    $("#divdropDownPartType").html(html);
	  	    achieveBelow("divdropDownPartType","divdropDownViewPartType");
	  		   
		  }
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
            
            <a href="story!storylist.do"><div class='bar active'><span>摄影故事</span><i></i></div></a>
            
            <a href="javascript:"><div class='bar'><span>视频作品</span><i></i></div></a>
            
            <a href="<%=basePath %>back/personalCentr/myworklib/workUpload.jsp"><div class='bar'><span>上传作品</span><i></i></div></a>
            
            <a href="<%=basePath %>story!initdata.do"><div class='bar'><span>创建故事</span><i></i></div></a>
            
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
            			        <span class='dropValue'>平面广2告拍摄</span>
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
                    	<span class="num"><s:property value="toolStory"/></span>张
                    
                    	<span class="sp2">已发布</span>
                    	<span class="num"><s:property value="publishedStory"/></span>张
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
                	<div class="name" title="<s:property value="story.title"/>"> <s:property value="story.title"/> </div>
                </div>
                
                <div class="divDescribe">
                	<div class="edit" id="editzpgs">
                    	<div class="bj"></div>
                    	<div class="bjc">
                        	<div class="left">
                            	<div class="one">
                            		<a class="view" title="浏览次数"><span><s:property value="story.hit"/></span></a>
                                	<a class="collect" title="收藏次数"><span>64456</span></a>
                            	</div>
                                <div class="two">
                            		<a class="good" title="推荐次数"><span>64456</span></a>
                            	</div>
                                <div class="three">
                                <s:if test="story.copyrightres == 0">
                                <span class="sp1">￥<s:property value="story.usagePrice"/></span>
                                 <s:if test="story.saleNum == null">
                                                                                             未出售
                                </s:if>
                                <s:else>
                                使用权已出售<span class="sp2"> <s:property value="story.saleNum"/></span>次
                                </s:else>
                                </s:if>
                            	</div>
                            </div>
                            <div class="right">
                            	<a href="story!downloadstory.do?storyId=<s:property value="story.id"/>" class="dowload">
                            		<div class="backimg"></div>
									<p>下载故事</p>
                            	</a>
                            	<a href="javascript:" class="delete">
                            		<div class="backimg"></div>
									<p>显示到空间首页</p>
                           		</a>
                            </div>
                        	
                        </div>
                    </div>
                	<div class="character">故事描述：</div>
                	
                    <div class="dec"><s:property value="story.storydescription"/></div>
                </div>
                
                <div class="storyzw">故事正文：</div>
                <s:iterator value="storyDetails" var="details">
                <div class="divContent">
                    <div class="picStory"><img src="<s:property value="#details.samllPic"/>" onload="javascript:DrawImage(this,750,750)"/></div>
                	<div class="char">原图尺寸：<span><s:property value="#details.width"/></span>*<span><s:property value="#details.height"/></span>px</div>
                    <div class="info"> <s:property value="#details.detailContext"/> </div>
                </div>
                </s:iterator>
            </div>
        
        <!--右部内容sfsf-->
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
                        <div class="storyInfo">
                        	<table>
                            	<tr>
                                	<td><span>作品编号：</span></td>
                                    <td class="td2"><span><s:property value="story.remark"/></span></td>
                                    <td><span>创建时间：</span></td>
                                    <td><span><s:date name="story.uploadTime" format="yyyy-MM-dd"/></span></td>
                                </tr>
                            	<tr>
                                	<td><span>图片张数：</span></td>
                                    <td><span><s:property value="story.detailpicNum"/></span>张</td>
                                    <td><span>字数：</span></td>
                                    <td><span><s:property value="story.detailtextNum"/></span>字</td>
                                </tr>
                            </table>
                        		
                        	
                        </div>
                    </div>
                    <div class="typeone">
                    		<table>
                            	<tr>
                                	<td class="td3">所属专辑</td>
                                	 <td class="td4"><s:property value="story.publishSpecialCat.name"/></td>
                                    <td class="td5"><a href="javascript:" onclick="openSpecial();">移动到</a></td>
                                </tr>
                            	 
                                	<!-- 
                                	private int unreleased;//未发布 0未发布1已发布
    private int awaitingReview;//1审核中0初始状态
    private int noPass;//0初始状态 1是不通过
    private int pass;// 0 初始状态 1 审核通过
    private int justShow;//0初始化状态1仅展示
    private int onOffer;//0是初始化状态1是销售中
    private int copyrightBuyout;//0初始化状态 1版权被买断
    private int userSoldout;//0初始化状态 1用户自己下架
    private int adminSoldout;//0 1,管理员给作品下架
    private int publishToStroy;//0 1发布到摄影故事
    private int userDelete;//0初始状态 1用户自己删除
    private int adminDelete;//0初始化状态1 管理员删除
    private int publishorstory;//0 初始化状态publish 1 story
    sfdsfsfd
                                	 -->
                                	 
                                	<s:if test="story.publishStatus.adminSoldout == 1">
                                	<tr>
                                	<td class="td1">作品状态</td>
                                    <td class="td2 tdDeal" colspan="3" id="redRemin">
                                    	<div class="stateRemind" id="stateRemind">
                                        	<div class="con">
                                            	<div class="char">被管理员下架原因：</div>
                                            	<s:if test="story.soldoutreason == null || story.soldoutreason == ''">
                                            	暂无原因
                                            	</s:if>
                                            	<s:else>
                                            	<div class="rea"><s:property value="story.soldoutreason"/></div>
                                            	</s:else>
                                            </div>
                                            <div class="time"> <s:date name="story.checkTime" format="yyyy-MM-dd"/> </div>
                                        	<div class="sanjiao"></div>
                                        </div>
                                    	<span class="red">被管理员下架</span>
                                    </td>
                                </tr>
                                </s:if>
                                <s:if test="story.publishStatus.userSoldout == 1 && story.publishStatus.noPass ==0">
                                	<tr>
                                	<td class="td1">作品状态</td>
                                    <td class="td2 tdDeal" colspan="3" id="redRemin">
                                    	<span class="red">已下架</span>
                                    </td>
                                </tr>
                                </s:if>
                                <s:if test="story.publishStatus.noPass == 1">
                                	<tr>
                                	<td class="td1">作品状态</td>
                                    <td class="td2 tdDeal" colspan="3" id="redRemin">
                                    <div class="stateRemind" id="stateRemind">
                                        	<div class="con">
                                            	<div class="char">管理员不通过原因：</div>
                                            	<s:if test="story.nopasscause.contains(\"0\")">
                                            <s:generator separator="." val="story.nopassration">
                                            <s:iterator status="statu">
                                            <s:if test="#statu.count == 1">
                                            <div class="rea">①<s:property/></div>
                                            </s:if>
                                            <s:if test="#statu.count == 2">
                                            <div class="rea">②<s:property/></div>
                                            </s:if>
                                            <s:if test="#statu.count == 3">
                                            <div class="rea">③<s:property/></div>
                                            </s:if>
											</s:iterator>  
											<div class="rea">④<s:property value="story.writereason"/> </div>
                                </s:generator>
                                            </s:if>
                                            <s:else>
                                            <s:generator separator="." val="story.nopassration">
                                            <s:iterator status="statu">
                                            <s:if test="#statu.count == 1">
                                            <div class="rea">①<s:property/></div>
                                            </s:if>
                                            <s:if test="#statu.count == 2">
                                            <div class="rea">②<s:property/></div>
                                            </s:if>
                                            <s:if test="#statu.count == 3">
                                            <div class="rea">③<s:property/></div>
                                            </s:if>
											</s:iterator>   
                                </s:generator>
                                            </s:else>
                                            </div>
                                            <div class="time"> <s:date name="story.checkTime" format="yyyy-MM-dd"/> </div>
                                        	<div class="sanjiao"></div>
                                        </div>
                                    	<span class="red">审核不通过</span>
                                    </td>
                                </tr>
                                </s:if>
                                 <s:if test="story.publishStatus.pass == 1 && story.publishStatus.userSoldout == 0 && story.publishStatus.adminSoldout == 0">
                                	<tr>
                                	<td class="td1">作品状态</td>
                                    <td class="td2 tdDeal" colspan="3" id="redRemin" && >
                                    	<span class="red">销售中</span>
                                    </td>
                                </tr>
                                </s:if>
                            </table>
                    </div>
                    
                    
                    <div class="gjctd"> 
                    	<div class="chaa">作品类型</div>
                        <div class="type">
                        
                        <s:iterator value="publishCatStories" var="cats">
                        <div class="retag">
								<span><s:property value="#cats.publishCat.name"/></span>
								<a></a>
							</div>
						</s:iterator> 
                        
                        	
                            
                        </div>
                        <div style="clear:both;"></div>
                        
                    	<div class="chaa">关键词</div>
                        <div class="keyword">
                        <s:generator separator=" " val="story.tags">  
								        <s:iterator>  
								          <a href="javascript:"><s:property/> </a>  
								        </s:iterator>  
								    </s:generator>  
                        	
                       	</div>
                    </div>
                    
                    
                     <div class="property">
                    		<table>
                            	<tr>
                                	<td class="td1">版权属性</td>
                                    <td class="tda" colspan="3" style="width: 220px;">
                                    	<a><s:property value="story.copyrightProperty"/></a> &nbsp;&nbsp;&nbsp;不可用于其他商业用途 
                                    </td>
                                </tr>
                                <s:if test="story.copyrightres ==0">
                                <tr>
                                    <td class="td1">出售使用权</td>
                                    <td class="td2">￥<span> <s:property value="story.usagePrice"/> </span></td>
                                    <td class="td3">授权期限</td>
                                    <td class="td4"><span>1</span>年</td>
                                    </tr>
                                </s:if>
                                <s:elseif test="story.copyrightres == 1">
                                <tr>
                                	<td class="td1">出售版权</td>
                                    <td class="td2">￥<span> <s:property value="story.copyrightPrice"/> </span></td>
                                </tr>
                                </s:elseif> 
                                <s:elseif test="story.copyrightres == 2">
                                <tr>
                                    <td class="td1">出售使用权</td>
                                    <td class="td2">￥<span> <s:property value="story.usagePrice"/> </span></td>
                                    <td class="td3">授权期限</td>
                                    <td class="td4"><span>1</span>年</td>
                                    </tr>
                                     <tr>
                                	<td class="td1">出售版权</td>
                                    <td class="td2">￥<span> <s:property value="story.copyrightPrice"/> </span></td>
                                </tr>
                                </s:elseif>
                                
                            </table>
                    </div>
                    
                    <div class="edt">
                    <s:if test="story.publishStatus.adminSoldout == 1 || story.publishStatus.noPass == 1">
					</s:if>
					<s:else>
						<input class="inputyq" type="button" value="编辑" onclick="location.href='story!editpublishedstory.do?storyId=<s:property value='story.id'/>';"/>
						<input class="inputyq" type="button" value="下架" onclick="location.href='story!offsale.do?storyId=<s:property value='story.id'/>'"/>
					</s:else>
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
        	
                            
            </ul>
    		
            
            <div class="divAddSpecial">
				<a href="<%=basePath %>specialPublish!findSpecialOfStoryByUser.do">管理专辑</a>
			</div>
    	</div>
        
        <div class="tijaio">
        <input type="hidden" id="publishIdforchange" value="<s:property value="story.id"/>" />
        <input type="hidden" id="spcialChangeForPublish" value="<s:property value="story.publishSpecialCat.id"/>" />
        <input type="hidden" id="spcialnameofstory" value="<s:property value="story.publishSpecialCat.name"/>" />
        	<input class="reset" type="button" value="取消"  onclick="cloosePopBox('moveTozj');"/>
			<input class="sub" type="button" value="确定" onclick="changeSpeicals()"/>
    	</div>
    </div>
    <!-- 
    <div id="chooseWork" style="width:952px;height:700px; z-index:100000000;display:none;overflow:hidden;">
    	<iframe name='child' style="border:0px;width:1000px;height:810px;overflow:hidden;z-index:100000000" src="../../public/chooseHead.html"></iframe>
    </div>
     -->
    
</div>
<!--[if lte IE 6]>
<script src="../../../userView/public/js/DD_belatedPNG_0.0.8a.js" type="text/javascript"></script>
    <script type="text/javascript">
        DD_belatedPNG.fix('div, ul, img, li, input , a , i');
    </script>
<![endif]-->


</body>
</html>

