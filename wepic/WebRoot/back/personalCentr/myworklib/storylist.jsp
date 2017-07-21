<%@ page language="java"  import="java.util.*" pageEncoding="UTF-8"%>
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

<title>wepic管理_个人中心_我的作品库_摄影故事</title>

<link type="text/css" rel="stylesheet" href="<%=basePath %>public/css/backMainBar.css" />
<link type="text/css" rel="stylesheet" href="<%=basePath %>back/personalCentr/myworklib/css/phoStory3.css" />

<script type="text/javascript" src="<%=basePath %>public/js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath %>back/personalCentr/myworklib/js/phoStory.js"></script>
<!--公共js-->
<script type="text/javascript" src="<%=basePath %>public/js/publicBack.js"></script>
<script type="text/javascript" src="<%=basePath %>public/js/public.js"></script>
<script type="text/javascript" src="<%=basePath %>public/js/topBar.js"></script>
<script type="text/javascript" src="<%=basePath %>public/js/header.js"></script>

<!--公共css-->
<link type="text/css" rel="stylesheet" href="<%=basePath %>public/css/topBarMain.css" />
<link type="text/css" rel="stylesheet" href="<%=basePath %>public/css/header.css" />
<link type="text/css" rel="stylesheet" href="<%=basePath %>public/css/footer.css" />
<link type="text/css" rel="stylesheet" href="<%=basePath %>public/css/public.css" />
<script type="text/javascript">
$(function(){
var sp='<s:property value="specialName"/>';
	  if(sp==''){
          sp="所有专辑";
		  }else{
		  var specialId='<s:property value="specalCatId"/>';
		   $("#specalCatId").val(specialId);
		   var storystatu='<s:property value="publishStaute"/>';
		   if(storystatu == "" || storystatu == null){
		      storystatu=0;
		   }
		   getImgSUnm(specialId,storystatu);
		  }
        $("#selectdespecialValue").html(sp);
    	$.ajax({
  	      type:"Post",
  		  url: "specialcat_getpublishSpecialCats2.do",
  		  data:"",		
  		  success : function(data) {
  	  		  
  	  	  var list=data.publishSpecialCats;
  	  	  var html='<span class="selectValueIn" id=0>所有专辑</span>';
  	  	  for(var i=0;i<list.length;i++){
  	  	  	  publishCat=list[i];
  	  		html+='<span class="selectValueIn" id='+publishCat.id+'>'+publishCat.name+'</span>';
  	  	  	  } 
  	  	    $("#divSelectdespecialValue").html(html);
  	  	    achieveBelow2("divSelectdespecialValue","selectdespecialValue");
  	  		   
  		  }
    	});
         $("#divSelectdeTypeValue").find("span").each(function(){
          $(this).click(function(){
              $("#publishStaute").val($(this).attr("id"));
              $("#publishStauteName").val($(this).html());
              $("#selectdeStateValue").html($(this).html());
              $("#divSelectdeTypeValue").hide();
              searchByterm();
              });
             });
          searchBack();
        });
        
        function searchBack(){
	     var statu='<s:property value="publishStauteName"/>';
	     if(statu==''){
	    	 statu="所有状态";
	         }
	     $("#selectdeStateValue").html(statu);
		 }

    function achieveBelow2(bolewDiv,showValue){
    	var bolewDiv=document.getElementById(bolewDiv);
    	var bolewDivSpan=bolewDiv.getElementsByTagName("span");
    	for(var i=0;i<bolewDivSpan.length;i++){
    		   bolewDivSpan[i].onclick=function (){
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
    //提交查询
    function searchByterm(){
        $("#searchByTermfromMylib2").submit();
        }  
function searchstorybyspecial(id){
location.href="story!searchbyspecial.do?specialId="+id;
}

function createstory(){
location.href="story!initdata.do";
}
function confirmdel(id){
if(confirm("确定要删除该摄影故事？"))
{
    location.href="story!userdelstory.do?storyId="+id;
}
}

  function uploadPic(){
	    location.href="${pageContext.request.contextPath}/back/personalCentr/myworklib/workUpload.jsp";




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
            
            <a href="<%=basePath %>story!storylist.do"><div class='bar active'><span>摄影故事</span><i></i></div></a>
            
            <a href="javascript:"><div class='bar'><span>视频作品</span><i></i></div></a>
            
            <a href="<%=basePath %>back/personalCentr/myworklib/workUpload.jsp"><div class='bar'><span>上传作品</span><i></i></div></a>
            
            <a href="<%=basePath %>story!initdata.do"><div class='bar'><span>创建故事</span><i></i></div></a>
            
            <a href="<%=basePath %>back/personalCentr/myworklib/chooseRelWork.jsp"><div class='bar'><span>发布作品</span><i></i></div></a>
        </div>
        </div>
    </div>
    <!-- 导航  end-->
    
    <!--内容-->
    <div id="divPhoStroyHead">
   		<div class="head">
        
        	<!--编辑-->
        	<div class="edit">
        	
        	        <form action="searchPublishPic!searchstoryByfrom.do" method="post" id="searchByTermfromMylib2">
	            	<input type="hidden" name="specalCatId"  id="specalCatId" value="<s:property value="specialId"/>"/>
	            	<input type="hidden" name="specialName"  id="specialName" value="<s:property value="specialName"/>"/>
	            	<input type="hidden" name="publishStauteName"  id="publishStauteName" value="<s:property value="publishStauteName"/>"/>
	            	<input type="hidden" name="publishStaute"  id="publishStaute" value="<s:property value="publishStaute"/>"/>
	            	</form>            	
            		<div class="editSelect" id="divdespecial">
                    	<div class="viewBelow" onclick="showBelow('divSelectdespecialValue')" id="viewBelowdespecial">
                        	<div id="selectdespecialValue">默认专辑</div>
                       		<div class="viewBelowRight"><i></i></div>    
                    	</div>
                           
                    	<div class="belowValue" id="divSelectdespecialValue" style="display:none;">
                        	<span class='selectValueIn'>请选择</span>
                        	<s:iterator value="specialCats" var="specialcat">
                        	<span class='selectValueIn'> <input id="albumnhidden" type="hidden" value=" <s:property value="#specialcat.id"/>"/>  <s:property value="#specialcat.name"/></span>
                        	</s:iterator>
 						</div>
            		</div>
               
               
              	<div class="char">
               		<a href="specialPublish!findSpecialOfStoryByUser.do" class="glz">管理专辑</a>
               		<span class="sp1">当前专辑作品数</span>
                    <span class="num" id="albumnnum"><s:property value="toolStory"/></span>张
                    
                    <span class="sp2">已发布</span>
                    <span class="num" id="publishsucnum"><s:property value="publishedStory"/></span>张
               	</div>
               
               	<div class="inp">
               		<input class="inputup" type="button" value="上传作品" onclick="uploadPic()">
               		<input class="inputup" type="button"  onclick="createstory()" value="创建故事">
					<input class="finished" type="button" value="发布作品">
               	</div>
        	</div>
            <!--编辑-->
            
            <!--排序-->
            
            <div class="sort">
            	<span class="sp1">筛选：</span>
                
                
                
                
                
                <div class="editSelect" id="divType">
                    	<div class="viewBelow" onclick="showBelow('divSelectdeTypeValue')" id="viewBelowdeType">
                        	<div id="selectdeStateValue">所有状态</div>
                       		<div class="viewBelowRight"><i></i></div>       
                    	</div>
                           
                    	<div class="belowValue" id="divSelectdeTypeValue" style="display:none;">
                        	<span class='selectValueIn' id="0">所有状态</span>
                        	<span class='selectValueIn' id="1">未发布</span>
                            <span class='selectValueIn' id="2">已出售</span>
                            <span class='selectValueIn' id="3">已下架</span>
 						</div>
            	</div>
                <span class="sp2">默认排序：创建时间</span>
                
            </div>
            
            <!--排序-->
        </div>
            
        </div>
        <!--图片内容-->
        <div id="phoStroyContent">
        	<div class="phoStroyContentUl">
        		<ul>
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
        		 -->
                	<s:iterator value="pager.resultList" var="list">
                	<s:if test="#list.publishStatus.unreleased ==1 && #list.publishStatus.awaitingReview == 0 && #list.publishStatus.noPass==0 && #list.publishStatus.pass == 0 && #list.publishStatus.userSoldout ==0 && #list.publishStatus.adminSoldout == 0">
                	<li>
                    	
                    	<div class="phoStroyContentLi">
                        	<!--默认显示-->
                            <div class="defaultView">
                                <div class="photographyStoryLiHead">
                                    <img src="<s:property value='#list.cover'/>" />
                                </div>
                                <div class="photographyStoryLiCon">
                                    <div class="photographyStoryLiConTitle">
                            		<span> <s:property value="#list.title"/> </span>
                            	</div>
                            	<div class="photographyStoryLiConInfo">
                            		<span><s:property value="#list.storydescription"/></span>
                            	</div>
                                    <div class="photographyStoryLiConShare">
                                        <a class="photographyStoryLiConShareOne" title="浏览次数"><span><s:property value="#list.hit"/></span></a>
                                        <a class="photographyStoryLiConShareTwo" title="收藏次数"><span>64456</span></a>
                                        <a class="photographyStoryLiConShareThree" title="推荐次数"><span>64456</span></a>
                                        <font><s:date name="#list.uploadTime" format="yyyy-MM-dd"/></font>
                                    </div>
                                </div>
                            </div>
                        	<!--默认显示-->
                            
                            <!--鼠标滑过显示-->
                            <div class="nowtop">
                        		<div class="bj"></div>
                        		<div class="bjc">
                        			<div class="picInf">
                                    	<div class="ifone">图片数<span class="picnum"> <s:property value="#list.detailpicNum"/></span>张<span class="sp2">字数</span><span class="numw"><s:property value="#list.detailtextNum"/></span>字</div>
                                        <div class="iftwo">作品编号：<span class="worknum"><s:property value="#list.remark"/></span></div>
                                    </div>
                                    
                                    <div class="picUser">
                                    	<div class="usone">
                                        	<a class="time" title="上传时间"> <s:date name="#list.uploadTime" format="yyyy-MM-dd"/> </a>
                                        </div>
                                        
                                        
                                    </div>
                                    
                                    <div class="picEdit">
                                    	<a class="del" title="删除作品" href="javascript:void(0)" onclick="confirmdel(<s:property value='#list.id' />)" ></a>
                                        <a class="down" title="下载作品" href="story!downloadstory.do?storyId=<s:property value='#list.id' />" ></a>
                                        <a class="edit" title="编辑作品" href="story!editunpublishedstory.do?storyId=<s:property value='#list.id' />"></a>
                                        <a class="view" title="查看作品" href="story!searchStoryunpublish.do?id=<s:property value='#list.id' />"></a>
                                    </div>
                                </div>
                        	</div>
                            <!--鼠标滑过显示-->
                            
                        </div>
                	</li>
                	</s:if>
                	<s:else>
                	<s:if test="#list.publishStatus.awaitingReview == 1 && #list.publishStatus.noPass==0 && #list.publishStatus.pass == 0 && #list.publishStatus.userSoldout ==0 && #list.publishStatus.adminSoldout == 0">
                	<li>
                    	
                    	<div class="phoStroyContentLi">
                        	<!--默认显示-->
                            <div class="defaultView">
                    		<div class="photographyStoryLiHead">
                        		<img src="<s:property value='#list.cover'/>" />
                       	 	</div>
                        	<div class="photographyStoryLiCon">
                        		<div class="photographyStoryLiConTitle">
                            		<span> <s:property value="#list.title"/> </span>
                            	</div>
                            	<div class="photographyStoryLiConInfo">
                            		<span><s:property value="#list.storydescription"/></span>
                            	</div>
                            	<div class="photographyStoryLiConShare">
                            		<a class="photographyStoryLiConShareOne" title="浏览次数"><span><s:property value="#list.hit"/></span></a>
                                	<a class="photographyStoryLiConShareTwo" title="收藏次数"><span>64456</span></a>
                                	<a class="photographyStoryLiConShareThree" title="推荐次数"><span>64456</span></a>
                                	<font><s:date name="#list.uploadTime" format="yyyy-MM-dd"/></font>
                            	</div>
                        	</div>
                            </div>
                        	<!--默认显示-->
                            
                            
                            <!--鼠标滑过显示-->
                            <div class="nowtop">
                        		<div class="bj"></div>
                        		<div class="bjc">
                        			<div class="picInf">
                                    	<div class="ifone">图片数<span class="picnum"><s:property value="#list.detailpicNum"/></span>张<span class="sp2">字数</span><span class="numw"><s:property value="#list.detailtextNum"/></span>字</div>
                                        <div class="iftwo">作品编号：<span class="worknum"><s:property value="#list.remark"/></span><span class="orange">审核中</span></div>
                                    </div>
                                    
                                    <div class="picUser">
                                    	<div class="usone">
                                        	<a class="time" title="上传时间"> <s:date name="#list.uploadTime" format="yyyy-MM-dd"/> </a>
                                        	<a class="time2" title="发布时间"><s:date name="#list.publishTime" format="yyyy-MM-dd"/> </a>
                                        </div>
                                        
                                    </div>
                                    
                                    <div class="picEdit">
                                    	<a class="del" title="删除作品" href="javascript:void(0)" onclick="confirmdel(<s:property value='#list.id' />)" ></a>
                                        <a class="down" title="下载作品" href="story!downloadstory.do?storyId=<s:property value='#list.id' />" ></a>
                                        <a class="edit" title="编辑作品" href="story!editpublishedstory.do?storyId=<s:property value='#list.id' />"></a>
                                        <a class="view" title="查看作品" href="story!searchStoryunpublish.do?id=<s:property value='#list.id' />"></a>
                                    </div>
                                </div>
                        	</div>
                            <!--鼠标滑过显示-->
                            
                        </div>
                	</li>
                	</s:if>
                	<s:else>
                	<s:if test="#list.publishStatus.awaitingReview == 1 && #list.publishStatus.noPass==1 && #list.publishStatus.pass == 0 && #list.publishStatus.userSoldout ==0 && #list.publishStatus.adminSoldout == 0">
                	<li>
                    	
                    	<div class="phoStroyContentLi">
                        	<!--默认显示-->
                            <div class="defaultView">
                    		<div class="photographyStoryLiHead">
                        		<img src="<s:property value='#list.cover'/>" />
                       	 	</div>
                        	<div class="photographyStoryLiCon">
                        		<div class="photographyStoryLiConTitle">
                            		<span> <s:property value="#list.title"/> </span>
                            	</div>
                            	<div class="photographyStoryLiConInfo">
                            		<span><s:property value="#list.storydescription"/></span>
                            	</div>
                            	<div class="photographyStoryLiConShare">
                            		<a class="photographyStoryLiConShareOne" title="浏览次数"><span><s:property value="#list.hit"/></span></a>
                                	<a class="photographyStoryLiConShareTwo" title="收藏次数"><span>64456</span></a>
                                	<a class="photographyStoryLiConShareThree" title="推荐次数"><span>64456</span></a>
                                	<font><s:date name="#list.uploadTime" format="yyyy-MM-dd"/></font>
                            	</div>
                        	</div>
                            </div>
                        	<!--默认显示-->
                            
                            
                            <!--鼠标滑过显示111-->
                            <div class="nowtop">
                        		<div class="bj"></div>
                        		<div class="bjc">
                        			<div class="picInf">
                                    	<div class="ifone">图片数<span class="picnum"><s:property value="#list.detailpicNum"/></span>张<span class="sp2">字数</span><span class="numw"><s:property value="#list.detailtextNum"/></span>字</div>
                                        <div class="iftwo">作品编号：<span class="worknum"> <s:property value="#list.remark"/></span><span class="red">审核未通过</span></div>
                                    </div>
                                    
                                    <div class="picUser">
                                    	<div class="usone">
                                        	<a class="time" title="上传时间"><span> <s:date name="#list.uploadTime" format="yyyy-MM-dd"/></span></a>
                                        </div>
                                        
                                        
                                    </div>
                                    
                                    <div class="divNoPassRea">
                                        <div>未通过原因：</div>
                                        <s:if test="#list.nopasscause.contains(\"0\")">
                                            <s:generator separator="." val="#list.nopassration">
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
											<div class="rea">④<s:property value="#list.writereason"/> </div>
                                </s:generator>
                                            </s:if>
                                            <s:else>
                                            <s:generator separator="." val="#list.nopassration">
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
                                    
                                    <div class="picEdit">
                                    	<a class="del" title="删除作品" href="javascript:void(0)" onclick="confirmdel(<s:property value='#list.id' />)" ></a>
                                        <a class="down" title="下载作品" href="story!downloadstory.do?storyId=<s:property value='#list.id' />" ></a>
                                        <a class="edit" title="编辑作品" href="story!editunpublishedstory.do?storyId=<s:property value='#list.id' />"></a>
                                        <a class="view" title="查看作品" href="story!searchStorypublish.do?id=<s:property value='#list.id' />"></a>
                                    </div>
                                </div>
                        	</div>
                            <!--鼠标滑过显示11-->
                            
                        </div>
                	</li>
                	</s:if>
                	<s:else>
                	<s:if test="#list.publishStatus.awaitingReview == 1 && #list.publishStatus.pass == 1 && #list.publishStatus.onOffer == 1 && #list.publishStatus.userSoldout ==0 && #list.publishStatus.adminSoldout == 0">
                	<li>
                    	
                    	<div class="phoStroyContentLi">
                        	<!--默认显示-->
                            <div class="defaultView">
                    		<div class="photographyStoryLiHead">
                        		<img src="<s:property value='#list.cover'/>" />
                       	 	</div>
                        	<div class="photographyStoryLiCon">
                        		<div class="photographyStoryLiConTitle">
                            		<span> <s:property value="#list.title"/> </span>
                            	</div>
                            	<div class="photographyStoryLiConInfo">
                            		<span><s:property value="#list.storydescription"/></span>
                            	</div>
                            	<div class="photographyStoryLiConShare">
                            		<a class="photographyStoryLiConShareOne" title="浏览次数"><span><s:property value="#list.hit"/></span></a>
                                	<a class="photographyStoryLiConShareTwo" title="收藏次数"><span>64456</span></a>
                                	<a class="photographyStoryLiConShareThree" title="推荐次数"><span>64456</span></a>
                                	<font><s:date name="#list.uploadTime" format="yyyy-MM-dd"/></font>
                            	</div>
                        	</div>
                            </div>
                        	<!--默认显示-->
                            
                            <!-- 图片右上角显示-->
                            <div class="divOnlyView">
                                <div class="onlyView">
                                	<div class="bj"></div>
                                    <div class="bjccs"></div>
                                </div>
                                
                                <div class="onlyViewChar">
                                	<div class="sanjiao"> </div>
                                	<div class="sp">已发布为可出售</div>
                                </div>
                                </div>
                            <!-- 图片右上角显示-->
                            
                            <!--鼠标滑过显示-->
                            <div class="nowtop">
                        		<div class="bj"></div>
                        		<div class="bjc">
                        			<div class="picInf">
                                    	<div class="ifone">图片数<span class="picnum"><s:property value="#list.detailpicNum"/></span>张<span class="sp2">字数</span><span class="numw"><s:property value="#list.detailtextNum"/></span>字</div>
                                        <div class="iftwo">作品编号：<span class="worknum"><s:property value="#list.remark"/></span></div>
                                    </div>
                                    
                                    <div class="picUser">
                                    	<div class="usone">
                                        	<a class="time" title="上传时间"><span> <s:date name="#list.uploadTime" format="yyyy-MM-dd"/> </span></a>
                                            <a class="time2" title="发布时间"><span><s:date name="#list.publishTime" format="yyyy-MM-dd"/></span></a>
                                        </div>
                                        
                                    	<s:if test="#list.copyrightres == 0">
                                       <div class="usti">使用权<span class="syq"> <s:property value="#list.usagePrice"/> </span>元
                                       <s:if test="#list.saleNum == null">
                                       <span class="sp2">未出售</span>
                                       </s:if>
                                       <s:else>
                                       <span class="sp2">已出售</span><span class="syq"> <s:property value="#list.saleNum"/> </span>次
                                       </s:else>
                                       </div>
                                       </s:if>
                                       <s:elseif test="#list.copyrightres == 1">
                                    	<div class="usti">版权<span class="syq"> <s:property value="#list.copyrightPrice"/> </span>元<span class="sp2">未出售</span></div>
                                       </s:elseif>
                                       <s:elseif test="#list.copyrightres == 2">
                                       <div class="usti">使用权<span class="syq"> <s:property value="#list.usagePrice"/> </span>元
                                       <s:if test="#list.saleNum == null">
                                       <span class="sp2">未出售</span>
                                       </s:if>
                                       <s:else>
                                       <span class="sp2">已出售</span><span class="syq"> <s:property value="#list.saleNum"/> </span>次
                                       </s:else>
                                       </div>
                                    	<div class="usti">版权<span class="syq"><s:property value="#list.copyrightPrice"/></span>元
                                    	<s:if test="#list.saleNum == null">
                                       <span class="sp2">未出售</span>
                                       </s:if>
                                       <s:else>
                                       <span class="sp2">已出售</span><span class="syq"> <s:property value="#list.saleNum"/> </span>次
                                       </s:else>
                                       </s:elseif>
                                        
                                    </div>
                                    
                                    <div class="picEdit">
                                    	<a class="xj" title="下架" href="story!offsale.do?storyId=<s:property value='#list.id' />"></a>
                                        <a class="down" title="下载作品" href="story!downloadstory.do?storyId=<s:property value='#list.id' />" ></a>
                                        <a class="edit" title="编辑作品" href="story!editpublishedstory.do?storyId=<s:property value='#list.id' />"></a>
                                        <a class="view" title="查看作品" href="story!searchStorypublish.do?id=<s:property value='#list.id' />"></a>
                                    </div>
                                </div>
                        	</div>
                            <!--鼠标滑过显示-->
                            
                        </div>
                	</li>
                	</s:if>
                	<s:else>
                	<s:if test="#list.publishStatus.awaitingReview == 1 && #list.publishStatus.pass == 1 && #list.publishStatus.onOffer == 1 && #list.publishStatus.userSoldout ==1 && #list.publishStatus.adminSoldout == 0">
                	<li>
                    	
                    	<div class="phoStroyContentLi">
                        	<!--默认显示-->
                            <div class="defaultView">
                    		<div class="photographyStoryLiHead">
                        		<img src="<s:property value='#list.cover'/>" />
                       	 	</div>
                        	<div class="photographyStoryLiCon">
                        		<div class="photographyStoryLiConTitle">
                            		<span> <s:property value="#list.title"/> </span>
                            	</div>
                            	<div class="photographyStoryLiConInfo">
                            		<span><s:property value="#list.storydescription"/></span>
                            	</div>
                            	<div class="photographyStoryLiConShare">
                            		<a class="photographyStoryLiConShareOne" title="浏览次数"><span><s:property value="#list.hit"/></span></a>
                                	<a class="photographyStoryLiConShareTwo" title="收藏次数"><span>64456</span></a>
                                	<a class="photographyStoryLiConShareThree" title="推荐次数"><span>64456</span></a>
                                	<font><s:date name="#list.uploadTime" format="yyyy-MM-dd"/></font>
                            	</div>
                        	</div>
                            </div>
                        	<!--默认显示-->
                            
                            
                            <!--鼠标滑过显示-->
                            <div class="nowtop">
                        		<div class="bj"></div>
                        		<div class="bjc">
                        			<div class="picInf">
                                    	<div class="ifone">图片数<span class="picnum"><s:property value="#list.detailpicNum"/></span>张<span class="sp2">字数</span><span class="numw"><s:property value="#list.detailtextNum"/></span>字</div>
                                        <div class="iftwo">作品编号：<span class="worknum"><s:property value="#list.remark"/></span><span class="grey">已下架</span></div>
                                    </div>
                                    
                                    <div class="picUser">
                                    	<div class="usone">
                                        	<a class="time" title="上传时间"><span> <s:date name="#list.uploadTime" format="yyyy-MM-dd"/></span></a>
                                        </div>
                                        
                                    </div>
                                    
                                    <div class="picEdit">
                                    	<a class="del" title="删除作品" href="javascript:void(0)" onclick="confirmdel(<s:property value='#list.id' />)" ></a>
                                        <a class="down" title="下载作品" href="story!downloadstory.do?storyId=<s:property value='#list.id' />" ></a>
                                        <a class="edit" title="编辑作品" href="story!editunpublishedstory.do?storyId=<s:property value='#list.id' />"></a>
                                        <a class="view" title="查看作品" href="story!searchStorypublish.do?id=<s:property value='#list.id' />"></a>
                                    </div>
                                    
                                </div>
                        	</div>
                            <!--鼠标滑过显示-->
                            
                        </div>
                	</li>
                	</s:if>
                	<s:else>
                	<s:if test="#list.publishStatus.awaitingReview == 1 && #list.publishStatus.pass == 1 && #list.publishStatus.onOffer == 1 && #list.publishStatus.adminSoldout == 1">
                	<li>
                    	
                    	<div class="phoStroyContentLi">
                        	<!--默认显示-->
                            <div class="defaultView">
                    		<div class="photographyStoryLiHead">
                        		<img src="<s:property value='#list.cover'/>" />
                       	 	</div>
                        	<div class="photographyStoryLiCon">
                        		<div class="photographyStoryLiConTitle">
                            		<span> <s:property value="#list.title"/> </span>
                            	</div>
                            	<div class="photographyStoryLiConInfo">
                            		<span><s:property value="#list.storydescription"/></span>
                            	</div>
                            	<div class="photographyStoryLiConShare">
                            		<a class="photographyStoryLiConShareOne" title="浏览次数"><span><s:property value="#list.hit"/></span></a>
                                	<a class="photographyStoryLiConShareTwo" title="收藏次数"><span>64456</span></a>
                                	<a class="photographyStoryLiConShareThree" title="推荐次数"><span>64456</span></a>
                                	<font><s:date name="#list.uploadTime" format="yyyy-MM-dd"/></font>
                            	</div>
                        	</div>
                            </div>
                        	<!--默认显示-->
                            
                            
                            <!--鼠标滑过显示-->
                            <div class="nowtop">
                        		<div class="bj"></div>
                        		<div class="bjc">
                        			<div class="picInf">
                                    	<div class="ifone">图片数<span class="picnum"> <s:property value="#list.detailpicNum"/></span>张<span class="sp2">字数</span><span class="numw"><s:property value="#list.detailtextNum"/></span>字</div>
                                        <div class="iftwo">作品编号：<span class="worknum"><s:property value="#list.remark"/></span><span class="red">被管理员下架</span></div>
                                    </div>
                                    
                                    <div class="picUser">
                                    	<div class="usone">
                                        	<a class="time" title="上传时间"><span><s:date name="#list.uploadTime" format="yyyy-MM-dd"/></span></a>
                                        </div>
                                        
                                    </div>
                                    <div class="divNoPassRea">
                                        <div>下架原因：</div>
                                        <s:if test="#list.soldoutreason == null || #list.soldoutreason == ''">
                                                                                                                         暂无原因
                                        </s:if>
                                        <s:else>
                                        <s:property value="#list.soldoutreason"/>
                                        </s:else>
                                    </div>
                                    <div class="picEdit">
                                    	<a class="del" title="删除作品" href="javascript:void(0)" onclick="confirmdel(<s:property value='#list.id' />)" ></a>
                                        <a class="down" title="下载作品" href="story!downloadstory.do?storyId=<s:property value='#list.id' />" ></a>
                                        <a class="edit" title="编辑作品" href="story!editunpublishedstory.do?storyId=<s:property value='#list.id' />"></a>
                                        <a class="view" title="查看作品" href="story!searchStorypublish.do?id=<s:property value='#list.id' />"></a>
                                    </div>
                                    
                                </div>
                        	</div>
                            <!--鼠标滑过显示-->
                            
                        </div>
                	</li>
                	</s:if>
                	</s:else>
                	</s:else>
                	</s:else>
                	</s:else>
                	</s:else>
                	</s:iterator>
                	
                    <div style="clear:both;"></div>
            	</ul>
            </div>
        
         
               
        
        
        </div>
        
        
        
        
        <!--图片内容-->
    
   <s:if test="pager.rowCount >= 16">
     <!--翻页-->
     <div class="ppointPagingthis">
        <div class="ppointPaging">            
            <table class="tablePpointPaging">
                	<tr>
                    	
                    	<s:bean name="org.apache.struts2.util.Counter" id="counter">  
                    	<td class="ppointPagingOne"><a href="story!storylist.do?pageNo=1"></a></td>
                    	<s:if test="pager.pageCount ==1">
                        <td class="ppointPagingPre"><a href="story!storylist.do?pageNo=1"></a></td>
                        </s:if>
                        <s:else>
                        <td class="ppointPagingPre"><a href="story!storylist.do?pageNo=<s:property value='pager.prePageNo'/>"></a></td>
                        </s:else>
         <s:param name="first" value="1"/>  
          <s:param name="last" value="pager.pageCount"/>  
          <s:iterator>  
          <s:if test="pager.pageNo==current-1">
          <td class="ppointPagingN"><a href="story!storylist.do?pageNo=<s:property />"><s:property /></a></td>
          </s:if>
          <s:else>
            <td class="ppointPagingN"><a href="story!storylist.do?pageNo=<s:property />"><s:property /></a></td>
          </s:else>
           </s:iterator> 
           <s:if test="pager.pageCount ==1"> 
           <td class="ppointPagingNext"><a href="story!storylist.do?pageNo=1"></a></td>
           </s:if>
           <s:else >
           <td class="ppointPagingNext"><a href="story!storylist.do?pageNo=<s:property value='pager.nextPageNo'/>"></a></td>
           </s:else>
           <td class="ppointPagingLast"><a href="story!storylist.do?pageNo=<s:property value='pager.pageCount'/>"></a></td>
            </s:bean>  
                    	
                    </tr>
                </table>
        </div>
        		</div>
        		</s:if>
        <!--翻页-->
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

