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
		<link rel="shortcut icon"
			href="${pageContext.request.contextPath}/public/images/logoSmall.ico" />

		<title>wepic管理 个人中心  账户基本资料 头像 个人版</title>
		<link type="text/css" rel="stylesheet"
			href="${pageContext.request.contextPath}/back/personalCentr/user/css/accountHead.css" />


		<script type="text/javascript"
			src="${pageContext.request.contextPath}/public/js/jquery.js"></script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/back/personalCentr/user/js/accountHead.js"></script>
		<!--公共js-->
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/back/js/provinceCityDistrict.js"></script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/back/js/publicBack.js"></script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}//public/js/public.js"></script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/public/js/topBar.js"></script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}//public/js/header.js"></script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}//back/js/ajaxforUserInfo.js"></script>
		<!--公共css-->
		<link type="text/css" rel="stylesheet"
			href="${pageContext.request.contextPath}/public/css/backMainBar.css" />
		<link type="text/css" rel="stylesheet"
			href="${pageContext.request.contextPath}/public/css/topBarMain.css" />
		<link type="text/css" rel="stylesheet"
			href="${pageContext.request.contextPath}/public/css/header.css" />
		<link type="text/css" rel="stylesheet"
			href="${pageContext.request.contextPath}/public/css/footer.css" />
			
<script type="text/javascript"src="<%=basePath %>/back/chajian/Jcrop/js/jquery.Jcrop.js"></script>
<link rel="stylesheet" href="<%=basePath %>/back/chajian/Jcrop/css/jquery.Jcrop.css" type="text/css"/> 
<link rel="stylesheet" href="<%=basePath %>/back/chajian/Jcrop/css/demos.css" type="text/css"/> 
<link rel="stylesheet" href="<%=basePath %>/back/chajian/Jcrop/css/main.css" type="text/css"/> 
<script type="text/javascript"src="<%=basePath %>back/chajian/imgsf.js"></script>
<script type="text/javascript" src="<%=basePath %>back/chajian/jquery.ocupload-1.1.2.js"></script>
			
			
<script type="text/javascript">
var path="${pageContext.request.contextPath}";



$(function(){
    $("#fileipload").upload({
		name : 'portraitFile', // <input type="file" name="upload" />
		enctype : 'multipart/form-data',
		action : '${pageContext.request.contextPath}/frontlogin_autoUpload.do',
		autoSubmit : true,
		onSubmit: function (self, element) { 
			//$("#fileipload").attr({"disabled":"disabled"});
		    var wait='<div  id="uploadsuccess"><span>文件正在上传....</span><b></b> <a href="javascript:void()"><img src="${pageContext.request.contextPath}/back/pubimg/loader02.gif"/></a></div>';
		    //$("#addEvidence1").after(wait);
			$("#userImgCut").html(wait);  
        },  
        onComplete: function (data, self, element){  
        	var data = eval("(" +data +")");
        	$("#userImgCut").html("<img id='newuploadpic' src='"+data.message+"'/>");
        	$("#previewImg").attr("src",data.message);
        	$("#previewImg2").attr("src",data.message);

        	
        	   crop();
				}
	});

  $("#fileipload").parent().css({"width":"120px"});
	
});


var boundx;
var boundy;
function crop(){


	     $pcnt = $('#preview-pane .preview-container');
	     $pimg = $('#preview-pane .preview-container img');
	     xsize = $pcnt.width();
	     ysize = $pcnt.height();


	     $pcnt1 = $('#preview-pane .preview-container1');
	     $pimg1 = $('#preview-pane .preview-container1 img');
	     xsize1 = $pcnt1.width();
	     ysize1 = $pcnt1.height();

	     
	$('#newuploadpic').Jcrop({
	 minSize: [153,153],
	aspectRatio:1,
	onChange: updateCoords,
	onSelect: updateCoords,
	bgOpacity: .5,
	setSelect:[130,260,380,66] 
	});
	}

function updateCoords(c){
	$('#x').val(c.x);
	$('#y').val(c.y);
	$('#x2').val(c.x2);
	$('#y2').val(c.y2);
	$('#w').val(c.w);
	$('#h').val(c.h);
	updatePreview(c);
	updatePreview2(c);
	}; 
	function commit(){
	var name=document.getElementById("newuploadpic").src;
	if(name==null||name==""){
     return ;

		}
	var x=document.getElementById("x").value;
	var y=document.getElementById("y").value;
	var x2=document.getElementById("x2").value;
	var y2=document.getElementById("y2").value;
	var w=document.getElementById("w").value;
	var h=document.getElementById("h").value;
	window.top.location="user!reloadCreatePic.do?tempPicName="+name+"&x="+x+"&y="+y+"&w="+w+"&h="+h;

	
	}

	 function updatePreview(c)
	    {
		 //  var bounds = c.gerrtBounds();
	      boundx = $("#newuploadpic").width();
	      boundy = $("#newuploadpic").height();;
	      if (parseInt(c.w) > 0)
	      {//ddd
	        var rx = xsize / c.w;
	        var ry = ysize / c.h;
	       // alert("sssssssss1"+gggggg(rx * boundx));
	        //alert("sssssssss2"+boundx);
	        //alert("sssssssss3ddddd"+rx);dddd
	        $pimg.css({
	          width: Math.round(rx * boundx) + 'px',
	          height: Math.round(ry * boundy) + 'px',
	          marginLeft: '-' + Math.round(rx * c.x) + 'px',
	          marginTop: '-' + Math.round(ry * c.y) + 'px'
	        });
	      }
	    }

	 function updatePreview2(c)
	    {
		 //  var bounds = c.gerrtBounds();
	      boundx1 = $("#newuploadpic").width();
	      boundy1 = $("#newuploadpic").height();;
	      if (parseInt(c.w) > 0)
	      {//ddd
	        var rx = xsize1 / c.w;
	        var ry = ysize1 / c.h;
	       // alert("sssssssss1"+gggggg(rx * boundx));
	        //alert("sssssssss2"+boundx);
	        //alert("sssssssss3ddddd"+rx);dddd
	        $pimg1.css({
	          width: Math.round(rx * boundx1) + 'px',
	          height: Math.round(ry * boundy1) + 'px',
	          marginLeft: '-' + Math.round(rx * c.x) + 'px',
	          marginTop: '-' + Math.round(ry * c.y) + 'px'
	        });
	      }
	    }
		
function yongyu(){
	
		
		
		cloosePopBox('divHonorPop');		//隐藏二级div
		
		openPopUpBox('chooseWork2');		//显示iframe div
		
		window.frames['child2'].document.getElementById('hiddenv').value ="divHonorPop";		
	//	changeBox('divHonorPop')
		
	}

function changePicfromMylib(id){
	 $("#chooseWork2").hide();
	 $("#greybackground").remove();
	   var wait='<div  id="uploadsuccess"><span>文件正在加载....</span><b></b> <a href="javascript:void()"><img src="${pageContext.request.contextPath}/back/pubimg/loader02.gif"/></a></div>';
	    //$("#addEvidence1").after(wait);
		$("#userImgCut").html(wait);  
	// 	alert(id);
	$.ajax({
	      type:"Post",
		  url: "frontlogin_autoCutImg.do?publishId="+id,
		  data:"",		
		  success : function(data) {
		// var data = eval("(" +data +")");
    	$("#userImgCut").html("<img id='newuploadpic' src='"+data.message+"'/>");
    	$("#previewImg").attr("src",data.message);
    	$("#previewImg2").attr("src",data.message);
    	   crop();
			}   
	});


	
}

/*


jQuery(function($){

    // Create variables (in this scope) to hold the API and image size
    var jcrop_api,
        boundx,
        boundy,

        // Grab some information about the preview pane
        $preview = $('#preview-pane'),
        $pcnt = $('#preview-pane .preview-container'),
        $pimg = $('#preview-pane .preview-container img'),

        xsize = $pcnt.width(),
        ysize = $pcnt.height();
    
    console.log('init',[xsize,ysize]);
    $('#target').Jcrop({
      onChange: updatePreview,
      onSelect: updatePreview,
      aspectRatio: xsize / ysize
    },function(){
      // Use the API to get the real image size
      var bounds = this.getBounds();
      boundx = bounds[0];
      boundy = bounds[1];
      // Store the API in the jcrop_api variable
      jcrop_api = this;

      // Move the preview into the jcrop container for css positioning
      $preview.appendTo(jcrop_api.ui.holder);
    });

    function updatePreview(c)
    {
      if (parseInt(c.w) > 0)
      {
        var rx = xsize / c.w;
        var ry = ysize / c.h;

        $pimg.css({
          width: Math.round(rx * boundx) + 'px',
          height: Math.round(ry * boundy) + 'px',
          marginLeft: '-' + Math.round(rx * c.x) + 'px',
          marginTop: '-' + Math.round(ry * c.y) + 'px'
        });
      }
    };

  });
*/

</script>

<style type="text/css" >


.jcrop-holder #preview-pane {
  display: block;
  position: absolute;
  z-index: 2000;
  top: 10px;
  right: -280px;
  padding: 6px;
  border: 1px rgba(0,0,0,.4) solid;
  background-color: white;

  -webkit-border-radius: 6px;
  -moz-border-radius: 6px;
  border-radius: 6px;

  -webkit-box-shadow: 1px 1px 5px 2px rgba(0, 0, 0, 0.2);
  -moz-box-shadow: 1px 1px 5px 2px rgba(0, 0, 0, 0.2);
  box-shadow: 1px 1px 5px 2px rgba(0, 0, 0, 0.2);
}

/* The Javascript code will set the aspect ratio of the crop
   area based on the size of the thumbnail preview,
   specified here */
#preview-pane .preview-container {
  width: 150px;
  height: 150px;
  overflow: hidden;
}

#preview-pane .preview-container1 {
  width: 80px;
  height: 80px;
  overflow: hidden;
}



</style>




	</head>

	<body>
		<div id="container">
			<div id="topBar">
				<div id="topbar">
					<div id="topcenterbar">
						<div id="topbar-collect">
							<a id="topcollect"
								href="javascript:addToFavorite('http://www.wepic.cn/','唯图网_商业拍摄 原创商业图片交易平台')">
								<span>收藏唯图</span> </a>
						</div>
						<div id="topbar-toolbar">

							<div id="divTopBarUesr">
								<div id="topBarUser">
									<a href="javascript:"><span>
									<s:property value="#session.nickName"/>
									
									</span><i></i>
									</a>
								</div>

								<div id="topBarUserDetailed">
									<div id="topBarUserOne">
										<div id="topBarUserOneHead">
											<img src="${pageContext.request.contextPath}/public/images/pic/topUser.jpg" id="porperties" />
											<div id="topBarUserOneHeadChange">
												<div>
													<a href="javascript:">更改头像</a>
												</div>
											</div>
										</div>
										<div id="topBarUserOneDetailed">
											<div id="topBarUserOneDetailedOne">
												<img id="topBarUserOneDetailedimg"
													src="${pageContext.request.contextPath}/public/images/grade/uesrLogo.png" />
												<img src="${pageContext.request.contextPath}/public/images/grade/diamond.png" />
												<img src="${pageContext.request.contextPath}/public/images/grade/diamond.png" />
												<img src="${pageContext.request.contextPath}/public/images/grade/star.png" />
												<img src="${pageContext.request.contextPath}/public/images/grade/star.png" />
												<img src="${pageContext.request.contextPath}/public/images/grade/star.png" />
												<a href="javascript:" id="topBarUserOneComeZom">进入空间</a>
												<a href="javascript:" id="topBarUserOneExit">退出登录</a>
											</div>
											<div id="topBarUserOneDetailedTwo">
												<div id="topBarUserInfo">
													<span>男</span>&nbsp;&nbsp;|
													<span>中国</span><span>上海</span><span>嘉定</span>
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
												<p class="topBarUserTwoPOne">
													4546544
												</p>
												<p class="topBarUserTwoPTwo">
													已关注
												</p>
											</div>
											<div class="topBarUserTwo" id="topBarUserFollower">
												<p class="topBarUserTwoPOne">
													87987987
												</p>
												<p class="topBarUserTwoPTwo">
													粉丝
												</p>
											</div>
											<div class="topBarUserTwo" id="topBarUserGoodDiscuss">
												<p class="topBarUserTwoPOne">
													666666
												</p>
												<p class="topBarUserTwoPTwo">
													好评
												</p>
											</div>
											<div class="topBarUserTwo" id="topBarUserBadDiscuss">
												<p class="topBarUserTwoPOne">
													7777777
												</p>
												<p class="topBarUserTwoPTwo">
													差评
												</p>
											</div>


										</div>

										<div id="topBarUserThree">
											<div id="topBarUserThreeInOutCome">
												<p>
													<span class="topBarUserThreeInOutComeAtt">收入排名</span><span
														class="topBarUserThreeInOutComeNum">454545</span>
												</p>
												<p>
													<span class="topBarUserThreeInOutComeAtt">支出排名</span><span
														class="topBarUserThreeInOutComeNum">4545</span>
												</p>
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
									<a href="#" id="topshopping">购物车<span>888</span>件<i></i>
									</a>
								</div>

								<div id="topBarShoppingDetailed">
									<ul>
										<li>
											<div class="topBarShoppingDetailedHead">
												<img src="${pageContext.request.contextPath}/public/images/pic/topUser.jpg" />
											</div>

											<div class="topBarShoppingDetailedOpert">
												<p class="topBarShoppingDetailedOpertPOne">
													<span>作品标题锦屏1</span>
													<b class="topBarShoppingDetailedOpertPOneExit"
														onclick="topBarShoppingDetailedOpertPOneExit(this)">×</b>
												</p>
												<p class="topBarShoppingDetailedOpertPTwo">
													编号：
													<span>4445454464564</span>
													<span class="topBarShoppingDetailedOpertPTwoPice">21221</span>
												</p>
											</div>
										</li>

										<li>
											<div class="topBarShoppingDetailedHead">
												<img src="${pageContext.request.contextPath}/public/images/pic/topUser.jpg" />
											</div>

											<div class="topBarShoppingDetailedOpert">
												<p class="topBarShoppingDetailedOpertPOne">
													<span>作品标题锦屏2</span>
													<b class="topBarShoppingDetailedOpertPOneExit"
														onclick="topBarShoppingDetailedOpertPOneExit(this)">×</b>
												</p>
												<p class="topBarShoppingDetailedOpertPTwo">
													编号：
													<span>4445454464564</span>
													<span class="topBarShoppingDetailedOpertPTwoPice">21221</span>
												</p>
											</div>
										</li>
										<li>
											<div class="topBarShoppingDetailedHead">
												<img src="${pageContext.request.contextPath}/public/images/pic/topUser.jpg" />
											</div>

											<div class="topBarShoppingDetailedOpert">
												<p class="topBarShoppingDetailedOpertPOne">
													<span>作品标题锦屏3</span>
													<b class="topBarShoppingDetailedOpertPOneExit"
														onclick="topBarShoppingDetailedOpertPOneExit(this)">×</b>
												</p>
												<p class="topBarShoppingDetailedOpertPTwo">
													编号：
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
												<a href="javascript:"><span>我的作品</span>
												</a>
											</div>

											<div id="divTopBarWorksDetailed" class="topBarDetailed">
												<p>
													<a href="javascript:">我的作品库</a>
												</p>
												<p>
													<a href="javascript:">我买到的作品</a>
												</p>
												<p>
													<a href="javascript:">我出售的作品</a>
												</p>
											</div>
										</div>
									</li>


									<li>
										<div id="divTopBarPats">
											<div id="topBarPats" class="topBarContainer">
												<a href="javascript:"><span>我的约拍</span>
												</a>
											</div>

											<div id="divTopBarPatsDetailed" class="topBarDetailed">
												<p>
													<a href="javascript:">新约拍项目</a>
												</p>
												<p>
													<a href="javascript:">我发布的约拍</a>
												</p>
												<p>
													<a href="javascript:">应约中的约拍</a>
												</p>
												<p>
													<a href="javascript:">约拍日程</a>
												</p>
												<p>
													<a href="javascript:">约拍记录</a>
												</p>
											</div>
										</div>
									</li>

									<li>
										<div id="divTopBarInform">
											<div id="topBarInform" class="topBarContainer">
												<a href="javascript:"><span>消息中心</span> <i></i> </a>
											</div>

											<div id="divTopBarInformDetailed" class="topBarDetailed">
												<p>
													<a href="javascript:">查看粉丝</a>
												</p>
												<p>
													<a href="javascript:">查看评价</a>
												</p>
												<p>
													<a href="javascript:">交易提醒</a>
												</p>
												<p>
													<a href="javascript:">日程提醒</a>
												</p>
												<p>
													<a href="javascript:">被邀提醒</a>
												</p>
												<p>
													<a href="javascript:">有新应约者</a>
												</p>
												<p>
													<a href="javascript:">经纪人申请</a>
												</p>
												<p>
													<a href="javascript:">系统通知</a>
												</p>
											</div>
										</div>
									</li>


									<li>
										<div id="divTopBarUpload">
											<div id="topBarUpload" class="topBarContainer">
												<a href="javascript:"><span>上传作品</span>
												</a>
											</div>

											<div id="divTopBarUploadDetailed" class="topBarDetailed">
												<p>
													<a href="javascript:">上传到作品库</a>
												</p>
												<p>
													<a href="javascript:">发布图片</a>
												</p>
												<p>
													<a href="javascript:">发布摄影故事</a>
												</p>
												<p>
													<a href="javascript:">发布视频</a>
												</p>
											</div>
										</div>
									</li>


									<li>
										<div id="divTopBarPublish">
											<div id="topBarPublish" class="topBarContainer">
												<a href="javascript:"><span>发布约拍</span>
												</a>
											</div>

											<div id="divTopBarPublishDetailed" class="topBarDetailed">
												<p>
													<a href="javascript:">发布约拍的项目</a>
												</p>
												<p>
													<a href="javascript:">招募摄影师</a>
												</p>
												<p>
													<a href="javascript:">招募模特</a>
												</p>
												<p>
													<a href="javascript:">发布征集作品项目</a>
												</p>
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
						<a id="imgLogo" href="http://www.wepic.cn/" target="_self"
							title="唯图网_商业拍摄 原创商业图片交易平台"> <img
								src="${pageContext.request.contextPath}/public/images/wepic_logo.png" alt="唯图网" />
							<p>
								<span id="spanLogo">商业拍摄</span><span>原创商业图片交易平台
							</p> </a>
					</div>
					<div id="divKeyWord">
						<input id="inputkeyword" type="text" value="搜索"
							onfocus="searchonfocus();" onblur="searchonblur()" />
					</div>

					<div id="divSelect">
						<input type="text" value="选择类型" onclick="hide('selectValue')"
							id="inputselect" class="inputselect" readonly="value" />

						<div id="selectValue" style="display: none;" class="selectValue"
							onmouseout="hidemouseout('selectValue')"
							onmouseover="hidemouseover('selectValue')">
							<span id="a1" onclick="pick('测试一','inputselect','selectValue')"
								onmouseover="bgcolor('a1')" onMouseOut="nocolor('a1')"
								class="cur">测试一</span>
							<span id="a2" onclick="pick('测试二','inputselect','selectValue')"
								onMouseOver="bgcolor('a2')" onMouseOut="nocolor('a2')"
								class="cur">测试二</span>
							<span id="a3" onclick="pick('测试三','inputselect','selectValue')"
								onMouseOver="bgcolor('a3')" onMouseOut="nocolor('a3')"
								class="cur">测试三</span>
							<span id="a4" onclick="pick('测试四','inputselect','selectValue')"
								onMouseOver="bgcolor('a4')" onMouseOut="nocolor('a4')"
								class="cur">测试四</span>
							<span id="a5" onclick="pick('测试五','inputselect','selectValue')"
								onMouseOver="bgcolor('a5')" onMouseOut="nocolor('a5')"
								class="cur">测试五</span>
							<span id="a6" onclick="pick('测试六','inputselect','selectValue')"
								onMouseOver="bgcolor('a6')" onMouseOut="nocolor('a6')"
								class="cur">测试六</span>
						</div>

					</div>

					<div id="divButtonSecrch">
						<div id="buttonsearch"></div>
					</div>

					<div id="divSeniorSecrch">
						<input type="button" value="高级搜索" id="higtsearch" />
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
        	<a href="${pageContext.request.contextPath}/user!getFistPageUserInfo.do"><div class="bar active"><span>
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
            <div class='bar'><span>账户基本资料</span><i></i></div></a>
            
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
            
            <div id="editHead" class="active tag">修改头像</div></a>
            <s:if test="#session.personOrCompany!=2">
             <a href="${pageContext.request.contextPath}/user!getByEducation.do"><div id="education" class="tag">教育情况</div></a>
            </s:if>
          <a href="${pageContext.request.contextPath}/usperPower!getAllUserPowerInfo.do"> <div id="strength" class="tag">实力证明</div></a>
            <!-- 
            <a href="${pageContext.request.contextPath}/usperPower!getAllUserPowerInfo.do"> <div id="strength" class="tag">实力证明</div></a>
             -->
             <a href="${pageContext.request.contextPath}/user!getGradUserInfo.do"> <div id="userGrade" class="tag">个人等级</div></a>
        
        </div>
				</div>
			</div>
			<!-- 导航  end-->

			<!--内容-->
			<div id="divAccountHead">
				<form id="formAccountHead" action="javascript:">
					<div class="title" >
						<h2>
							修改头像
							
						</h2>
					</div>

					<div class="conennt">
						<div class="option">
						
						
						<div style="width:15%;height:32px; float: left; margin-top: 22px">
							<input type="button" class="localPhoto" id="fileipload"    value="      本地照片                 " />
							</div>
							<div style="width:40%;height:32px; float: left;margin-top: 22px">
							<input type="button"  class="choosePhoto" style="width:116px" value="作品库选图"  onclick="yongyu()"/>
							</div>
							
							
						</div>

						<div class="head">
							<div class="choose">
								<div class="explain">
								
									<table   style="width: 100%; height: 100%;" width="100%" height="100%">
									<tr>
									<td style="text-align: center;width:99%; height: 98%;" id="userImgCut">									
									您可以选择一张本地照片上传裁剪后作为自己的头像，也可以从您的作品库里选择一件作品来制作头像。
									</td>
									
									
									</tr>
									
									
									</table>
								</div>
							</div>
							<div class="preview">
								<div class="explain">
									头像预览
								</div>
								<div class="small">
								 <div id="preview-pane">
									<div class="preview-container1">
                                  <img src="${pageContext.request.contextPath}/back/pubimg/images/defaultHead_80.png" class="jcrop-preview" alt="Preview" id="previewImg2" />
                                       </div>
                                       </div>
                                       
								<!--  
									<img src="${pageContext.request.contextPath}/back/pubimg/defaultHead_80.png" />
									-->
									<div class="smalle">
										80&nbsp;×&nbsp;80
									</div>
								</div>

								<div class="big">
								 <div id="preview-pane">
									<div class="preview-container">
                                  <img src="${pageContext.request.contextPath}/back/pubimg/images/defaultHead_150.png" class="jcrop-preview" alt="Preview" id="previewImg" />
                                       </div>
                                       </div>
									<div class="bige">
										150&nbsp;×&nbsp;150
									</div>
								</div>
							</div>
						</div>
					</div>
    <input type='hidden' name='x' id='x'/>
    <input type='hidden' name='y' id='y'/>
    <input type='hidden' name='x2' id='x2'/>
    <input type='hidden' name='y2' id='y2'/>
    <input type='hidden' name='w' id='w'/>
    <input type='hidden' name='h' id='h'/>
    
					<div class="submit">
						<div class="input">
							<input type="reset" value="取消" class="reset" />
							<input type="button" value="提交" class="submit" onclick="commit()" />
						</div>
					</div>
				</form>
			</div>
			<!--内容-->
			<!--foot 开始-->
			<div id="footer">
				<div id="footCenter">
					<div id="footServer">
						<div id="aboutOur" class="footServerCon">
							<div class="serverConStr">
								<a href="javascript:">关于我们</a>
							</div>
							<p>
								<a href="javascript:">服务内容</a>
							</p>
							<p>
								<a href="javascript:">身份注册</a>
							</p>
							<p>
								<a href="javascript:">积分等级</a>
							</p>
							<p>
								<a href="javascript:">交易流程</a>
							</p>
						</div>
						<div id="rechargeDefray" class="footServerCon">
							<div class="serverConStr">
								<a href="javascript:">充值支付</a>
							</div>
							<p>
								<a href="javascript:">账户管理</a>
							</p>
							<p>
								<a href="javascript:">充值方式</a>
							</p>
							<p>
								<a href="javascript:">交易记录</a>
							</p>
							<p>
								<a href="javascript:">充值</a>
							</p>
							<p>
								<a href="javascript:">提现</a>
							</p>
						</div>
						<div id="personnelRecruitment" class="footServerCon">
							<div class="serverConStr">
								<a href="javascript:">人才招聘</a>
							</div>
							<p>
								<a href="javascript:">人才计划</a>
							</p>
							<p>
								<a href="javascript:">招聘职位</a>
							</p>
						</div>
						<div id="legalColumn" class="footServerCon">
							<div class="serverConStr">
								<a href="javascript:">法律专栏</a>
							</div>
							<p>
								<a href="javascript:">使用条款</a>
							</p>
							<p>
								<a href="javascript:">相关协议</a>
							</p>
							<p>
								<a href="javascript:">版权声明</a>
							</p>
							<p>
								<a href="javascript:">隐私政策</a>
							</p>
							<p>
								<a href="javascript:">免责声明</a>
							</p>
							<p>
								<a href="javascript:">法律知识</a>
							</p>
						</div>
						<div id="footProblem" class="footServerCon">
							<div class="serverConStr">
								<a href="javascript:">疑难解答</a>
							</div>
							<div class="serverConStr">
								<a href="javascript:">投诉建议</a>
							</div>
							<div class="serverConStr">
								<a href="javascript:">广告服务</a>
							</div>
							<div class="serverConStr">
								<a href="javascript:">信息中心</a>
							</div>
						</div>
					</div>

					<div id="footCopyright">
						<div class="serverConStr" id="serverConStrid">
							版权声明
						</div>
						<div id="footCopyrightCon">
							<p>
								所有图片及文件都受著作权保护，未经允许不得使用，
							</p>
							<p>
								不得转载编辑
							</p>
							<p>
								Copyright&copy;2012-2013 wepic.cn
							</p>
							<p>
								上海维拓网络科技有限公司
							</p>
							<p>
								ICP备案/许可证：沪ICP备13010366号
							</p>
						</div>
					</div>

					<div id="footCustom">
						<div id="twoDimensionCode">
							<img src="${pageContext.request.contextPath}/public/images/weixin.png" />
							<p>
								微信公众账号
							</p>
						</div>

						<div id="DimensionCodeServer">
							<p class="serverConStr">
								客服电话
							</p>
							<p id="serverPhone">
								400-809-9060
							</p>
							<p>
								（周一至周五：9:00-18:00）
							</p>
							<div id="serverShare">
								<ul>
									<li>
										<a href="javascript:" id="shareSina" class="shareSina"></a>
									</li>
									<li>
										<a href="javascript:" id="shareQqzone" class="shareQqzone"></a>
									</li>
									<li>
										<a href="javascript:" id="shareQqblog" class="shareQqblog"></a>
									</li>
									<li>
										<a href="javascript:" id="shareTwitter" class="shareTwitter"></a>
									</li>
									<li>
										<a href="javascript:" id="shareFacebook" class="shareFacebook"></a>
									</li>
									<li>
										<a href="javascript:" id="shareRenren" class="shareRenren"></a>
									</li>
									<li>
										<a href="javascript:" id="shareDouban" class="shareDouban"></a>
									</li>
								</ul>

							</div>
						</div>
					</div>
				</div>
			</div>
			<!--foot 结束-->
 <div id="chooseWork2" style="width:1000px;height:800px; display:none;">
    	<iframe name='child2' style="border:0px;width:1000px;height:800px" src="${pageContext.request.contextPath}/searchPublishPic!searchByTermfromMylibforUserPic.do"></iframe>
    </div>
			<div id="goTopBtn" style="display: none;"></div>
		</div>
		<!--[if lte IE 6]>
<script src="${pageContext.request.contextPath}/public/js/DD_belatedPNG_0.0.8a.js" type="text/javascript"></script>
    <script type="text/javascript">
        DD_belatedPNG.fix('div, ul, img, li, input , a , i');
    </script>
<![endif]-->


	</body>
</html>
