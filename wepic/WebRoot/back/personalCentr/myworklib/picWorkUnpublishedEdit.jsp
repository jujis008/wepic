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

<title>wepic管理_个人中心_我的作品库_编辑未发布的图片</title>

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/back/personalCentr/myworklib/css/picWorkUnpublishedEdit.css" />

<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/back/personalCentr/myworklib/js/picWorkUnpublishedEdit.js"></script>
<script type="text/javascript" src="<%=basePath %>back/chajian/jquery.ocupload-1.1.2.js"></script>
<!--公vb共js -->
<script type="text/javascript" src="${pageContext.request.contextPath}/back/js/publicBack.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/public.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/topBar.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/header.js"></script>

<!--公共css    -->
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/back/pubimg/css/backMainBar.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public/css/topBarMain.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public/css/header.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public/css/footer.css" />

	
	
<script type="text/javascript">

$(function(){
    $("#uploadSmallSimple").upload({
		name : 'upfile', // <input tsdss333ype=tt"file" name="upload" />
		enctype : 'multipart/form-data',
		action : '${pageContext.request.contextPath}/jsonpublish_uploadSimpleSamll.do?id=<s:property value="publish.id"/>',
		autoSubmit : true,
		onSubmit: function (self, element) { 
			//$("#fileiprloaddd").attr({"disabled":"disabled"});
		   // var wait='<div  id="uploadsuccess"><span>文件正在上传....</span><b></b> <a href="javascript:void()"><img src="${pageContext.request.contextPath}/back/pubimg/loader02.gif"/></a></div>';
		    //$("#addEvidence1").after(wait);
			//$("#divChangeHead").html(wait);  
        },  
        onComplete: function (data, self, element){
            window.location.reload();
        }  
        	
	});

$("#uploadSmallSimple").parent().css({"width":"260px","height":"20px"});
$("#uploadSmallSimple").next().next().find("input").css({"margin-left":"-25px","margin-top":"-20px"});
var tab='<s:property value="publish.logo"/>';
if(tab=='2'){
editeSimplePic();

}
	
});


function editeSimplePic(){
	//alert("sss")
     updateedite();
	 $("#cropHead").html('<iframe name="child2" style="border:0px;width:1200px;height:900px;overflow:hidden;z-index:100000000" src="publish!editeSamplePic.do?id=<s:property value="publish.id"/>"></iframe>');
	 openPopUpBox('cropHead');
	



}
function updateedite(){
	$.ajax({
	      type:"Post",
		  url: "${pageContext.request.contextPath}/jsonpublish_updateLogo.do",
		  data:'id=<s:property value="publish.id"/>',		
		  success : function(data) { 
       
			    
		  }
	});









	
}




$(function(){
	//alert("ssss");
    $("#divSelectHighestDegreeValue").find("span").each(function(){
    $(this).click(function(){
       getCat($(this).attr("id"));
       //alert("sssssfffffffffs");
        });
	  });
    addformInit();
    });

function getCat(id){

	$.ajax({
	      type:"Post",
		  url: "projectCat_getTypeCat.do",
		  data:"id="+id,		
		  success : function(data) { 
         var html="";
         for(var i=0;i<data.publishChiledCats.length;i++){
           var cat=data.publishChiledCats[i];
           html+='<div class="retag" id="'+cat.id+'"><span>'+
           cat.name+
		"</span><a title='增加' onclick=addreProfTagPic(this,'divAddEnTagpho');></a></div>";
             }
          $("#divAddReTag").html(html);
          $("#divAddReTagPerson").html("");
			$("#hiddenReTags").val("");  
			    
		  }
	});

	$("#divAddEnTagpho").find("div").each(function(){

               $(this).remove();

       
		});
}


function addformInit(){
  //   alert("sss");
$("#divAddEnTagpho").find("a").each(function(){
	//alert($(this).parent().attr("id"));
	addreProfTagPic(this,'divAddEnTagpho');
});

$("#divAddPersonTag").find("a").each(function(){
	//alert($(this).parent().attr("id"));
	addreProfTag(this,'divAddPersonTag');
});



	
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
                            	<input type="button" value="查看购物车"/>
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
                    		id="inputselect" class="inputselect" readonly="value1"/>
                           
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
            
            <a href="<%=basePath %>publish!findAllMyLib.do"><div class='bar active'><span>图片作品</span><i></i></div></a>
            
            <a href="<%=basePath %>story!storylist.do"><div class='bar'><span>摄影故事</span><i></i></div></a>
            
            <a href="javascript:"><div class='bar'><span>视频作品</span><i></i></div></a>
            
            <a href="${pageContext.request.contextPath}/back/personalCentr/myworklib/workUpload.jsp"><div class='bar'><span>上传作品</span><i></i></div></a>
            
            <a href="<%=basePath %>story!initdata.do"><div class='bar'><span>创建故事</span><i></i></div></a>
            
            <a href="${pageContext.request.contextPath}/back/personalCentr/myworklib/chooseRelWork.jsp"><div class='bar'><span>发布作品</span><i></i></div></a>
        </div>
        </div>
    </div>
    <!-- 导航  ssend-->
    
    <!--内sseee容-->
   
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
                    		
                 			 </div>
                  		</div>
                    </td>
                	
                    <td class="td2"><a href="manageSpecial.html" class="glz">管理专辑</a></td>
                    <td class="td3">
                    	<span class="sp1">当前专辑作品数</span>
                    	<span class="num" id="totalPic">0</span>张
                    
                    	<span class="sp2">已发布</span>
                    	<span class="num" id="fabutotalPic">0</span>张
                    	
                    	<span class="sp2">显示顺序：</span>
                    	<span class="sp3">上传时间</span>
                    </td>
                </tr>
            
            </table>
            <div class="inp">
               	<input class="inputup" type="button" value="返回上一页"/>
            </div>
            
        </div>
            
    </div>
    <form id="formrelwork" action="publish!updatePublish.do" method="post">
    <div id="divRelWork">
        <div class="divAddPic">
        	<div class="leftpic">
                	<div class="img" id="divChangeHead">
                    	<img src="<s:property value="publish.thumbnailUrl"/>" />
                        <div class="nowtop" id="divViewHead">
                        	<div class="bj"></div>
                        	<div class="bjc">
                        	<s:if test="publish.logo!=1">
                        		<div class="sp1"><a onclick="editeSimplePic();">编辑缩略图</a></div>
                        	</s:if>
                        	<s:else>
                        	
                        	<div class="sp1" id="uploadSmallSimple" ><a >上传预览图</a></div>
                        	<div class="sp1"><a id="" style="font-size: 12px;color:8c8c8c;font-family: '宋体'">尺寸不小于1000*1000px</a></div>
                        	
                        	</s:else>
                            </div>
                        </div>
                    </div>
                	
                    <div class="inn">
                    	<div>作品编号：<span>
                    	<s:property value="publish.picNumber"/>
                    	
                    	</span></div>
                    	<div>上传时间：<span><s:property value="publish.upTime"/></span></div>
                    	
                    	<div>原始尺寸：
                    	<s:if test="publish.logo==0">
                    	<span><s:property value="publish.width"/></span>*<span>
                    	<s:property value="publish.height"/></span>
                    	</s:if>
                    	
                    	<span class="shu">|</span><span><s:property value="publish.size"/></span>M</div>
                    
                    </div>
                </div>
        
        
        	<div class="right">
            	<div class="title">
                    <span>图片标题</span>
                    <input class="texttitle" type="text" id="texttitleinp" name="name" value="<s:property value="publish.name"/>" onblur="promptInfo('texttitleinp','titleprompt',40);"/>
                    <span>作品类别</span>
                     <input name="type" type="hidden" id="typePublish" />
                       <input name="id"  value="<s:property value="publish.id"/>" type="hidden" />   
                        
                    <div class="editSelect" id="divHighestDegree" >
                    	<div class="viewBelow" onclick="showBelow('divSelectHighestDegreeValue')" id="viewBelowHighestDegree">
                        	<div id="selectHighestDegreeValue">
                        	<s:property value="publish.typeName"/>
                        	</div>
                       		<div class="viewBelowRight"><i></i></div>    
                    	</div>
                           
                    	<div class="belowValue" id="divSelectHighestDegreeValue" style="display:none;">
                        	<span class='selectValueIn' id="3">摄影图片</span>
                            <span class='selectValueIn' id="2">创意图片</span>  
                        
 						</div>
            		</div>
                          
                    <div id="titleprompt" class="promptInf"></div>                 
                </div>
                	
                    
                    
                <div class="storyDe">
                    <span class="span">作品说明</span>
                    <textarea id="textareastorytt" name="content"  onblur="promptlength('textareastorytt','textareaStory',400);">
                    <s:property value="publish.content"/>
                    
                    </textarea>
                    <div class="zpzt">
                    	<span class="zt">作品状态</span>
                        <span class="ztv">未发布</span>
                    </div>
                    <div id="textareaStory" class="promptInf"></div>
                    
                </div>
                    
            
            <!--添加作s品类型-->
       	 <div class="divkeyword">
        	<div class="typeCha">作品类型</div>
        	<input type="hidden" id="hiddenReTags" name="publishCatId" />
        	
        	<div class="choosed">
            	<div class="con">
        			<div id="divAddEnTagpho">
            			
            			<s:iterator value="publish.publishCats" var="cat">
            			
            			<div id="<s:property value="#cat.id"/>" class="retag"><span>
        				<s:property value="#cat.name"/>
        				</span><a onclick="deleteProModelPic(this);" title="增加"></a></div>
            			</s:iterator>
            			
            			
            			
            			
            			
            			
            		</div>
            		<div style="clear:both;"></div>
        		</div>
            </div>
            
            
            <div class="chooseCon">
    			<div class="one">您可以选择以下类型：</div>
        		<div class="con">
        		
        		
        		
        			<div id="divAddReTag">
        				<s:iterator value="publishChiledCats">
        				<div class="retag" id="<s:property value="id"/>"><span>
        				<s:property value="name"/>
        				</span><a title='增加' onclick="addreProfTagPic(this,'divAddEnTagpho');"></a></div>
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
                     <input type="hidden" name="tags" id="tagsPublish" />
                     <s:iterator value="publish.roleTags" var="pubtags">
                     
                     <div class="retag"><span>
                     <s:property value="#pubtags.tag"/>
                     </span><a onclick="deleteProModel(this);" title="增加"></a></div>
                     
                     
                     </s:iterator>
                     
                     
                     
                     
            		</div>
            		<div style="clear:both;"></div>
        		</div>
            </div>
            
            
            
            <div class="chooseCon">
    			<div class="one">您可以选择以下关键词：</div>
        		<div class="con">
        		
        		
        		
                <div id="divAddReTagPerson">
        			
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
            <div class="promptInf" id="choosegjc">请选择关键词</div>
        </div>		
        
        
        
        
        </div>
        
        </div>
        
        
        
        
        
        <div class="submit">
        	<input class="inputfb" type="button"  value="发布作品"/>
               <div class="inp">
               		<input class="inputup" type="button" value="取消"/>
					<input class="finished" type="button" value="保存" onclick="verifyForm();"/>
               </div>
        </div>
    </div>
    </form>
    
    
    
    
    
    
    <!--裁切缩略图-->
    <div id="cropHead" style="width:1130px;height:900px; z-index:100000000;display:none;overflow:hidden;">
    </div>
    <!--裁切缩略图-->
    
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
<script src="${pageContext.request.contextPath}/userView/public/js/DD_belatedPNG_0.0.8a.js" type="text/javascript"></script>
    <script type="text/javascript">
        DD_belatedPNG.fix('div, ul,eee img, li, input , a , i');
    </script>
<![endif]-->


</body>
</html>