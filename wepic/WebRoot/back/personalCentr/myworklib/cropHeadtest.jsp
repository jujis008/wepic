<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>选择作品</title>

<link rel="stylesheet" type="text/css" href="<%=basePath %>public/css/imgareaselect-animated.css" />

<script type="text/javascript" src="<%=basePath %>public/js/jquery.js"></script>

<script type="text/javascript" src="<%=basePath %>public/js/jquery.imgareaselect.pack.js"></script>
<script>


/*关闭弹出框*/
function cloosePopBox(){
	window.parent.closeOwnBox("cropHead");
}
/*关闭弹出框*/

/*重新选择*/
function changeImg(){
	window.parent.closeOwnBox("cropHead");
	window.parent.changeHeadStory("cropHead");
	}
/*重新选择*/

/*提交信息并返回前一个页面*/
function submitPopBox(){
	
	
	var url;
	url = $("#imghead").attr("src");
				
	
	
	
	window.parent.closeOwnBox("cropHead");
	
	window.parent.changehh(url);
	}
	
	
/*提交信息并返回前一个页面*/



/* click 动作*/
function divClickBar(divName){
	var mainDiv=document.getElementById(divName);
	var allMainBarLi=mainDiv.getElementsByTagName("li");
	for(var i=0;i<allMainBarLi.length;i++){
		allMainBarLi[i].onclick = function(){
			/*if($(this).attr("class") == "active"){
				$(this).removeClass("active");
				}
			else{
				$(this).addClass("active");
				}*/
				
			for(var i=0;i<allMainBarLi.length;i++){
				allMainBarLi[i].className = "";
				}
			this.className="active";
		};
		}
	}
	
	
</script>


<style>
table{border:0;border-collapse:0;}
*{margin:0;padding:0;}
li{list-style: none;}
.rework{
	background:#ffffff;
	/*padding-bottom:90px;*/
	width:1128px;
	height:890px;
	overflow:hidden;
	overflow-x:hidden;
	}
.rework .top{
    background:#F6F6F6;
    border-bottom: 1px solid #E3E3E3;
    height: 57px;
    left: 0;
    position: relative;
    top: 0;
    width: 1128px;
}
.rework .top h2 {
    color: #585858;
    font-family: "微软雅黑";
    font-size: 22px;
    font-weight: normal;
    height: 58px;
    line-height: 58px;
    padding-left: 30px;
	text-align:left;
	}

.rework .top a {
    background:url(<%=basePath %>public/images/closeBox.png) 0 0 no-repeat;
    height: 58px;
    position: absolute;
    right: 0;
    top: 0;
    width: 58px;
	}
.rework .top a:hover{
	background:url(<%=basePath %>public/images/closeBox.png) no-repeat 0 -58px;
	}
.rework .top a:active{
	background:url(<%=basePath %>public/images/closeBox.png) no-repeat 0 -116px;
	}
	




.rework .content{
	left: 0;
    position: relative;
    top: 0;
	width:1128px;
	height:890px;
	}
.rework .content .divbigimg{
	left: 18px;
    position: absolute;
    top: 16px;
	width:800px;
	height:800px;
	background:#f0f0f0;
	cursor:crosshair;
	}
.rework .content .divbigimg img{
	max-width:800px;
	max-height:800px;
	}
.rework .content .divsmallimg{
	top: 16px;
    position: absolute;
    right:10px;
	width:285px;
	height:800px;
	}
.rework .content .divsmallimg .coverpreview{
	font-family:"微软雅黑";
	font-size:13px;
	color:#757575;
	height:30px;
	}
.rework .content .divsmallimg .imgbj{
	width:285px;
	height:175px;
	background:#fcfcfc;
	overflow: hidden;
	background-image:url(<%=basePath %>public/images/thumbnail.png);
	background-repeat:no-repeat;
	background-position:center;
	}
.rework .content .divsmallimg .imgbj img{
	/*margin-top:63px;
	margin-left:113px;*/
	}
.rework .content .divsmallimg .coversize{
	font-family:"宋体";
	font-size:12px;
	color:#8d8d8d;
	margin-top:15px;
	}
.rework .content .divsmallimg .submit{
	
	margin-top:130px;
	}



.rework .content .divsmallimg .submit input {
	
    border: 0 none;
    cursor: pointer;
    font-family: "微软雅黑";
    font-size: 15px;
    height: 27px;
    margin-left: 30px;
    padding-bottom: 2px;
    padding-left: 0;
    width: 86px;
	letter-spacing: 10px;
	padding-left:15px;
	}
.rework .content .divsmallimg .submit  .sub{
    color: #FFFFFF;
    background: url(<%=basePath %>public/images/buttonGroup01.png) no-repeat 0 -273px;
	}
.rework .content .divsmallimg .submit  .sub:hover{
	background: url(<%=basePath %>public/images/buttonGroup01.png) no-repeat 0 -300px;
	}
.rework .content .divsmallimg .submit  .sub:active{
	background: url(<%=basePath %>public/images/buttonGroup01.png) no-repeat 0 -327px;
	color: #D6D6D6;
	text-shadow: 1px 1px 1px black;
	}
	
.rework .content .divsmallimg .submit  .reset{
    color: #000000;
    background: url(<%=basePath %>public/images/buttonGroup01.png) no-repeat 0 -182px;
	}
.rework .content .divsmallimg .submit  .reset:hover{
	background: url(<%=basePath %>public/images/buttonGroup01.png) no-repeat 0 -209px;
	}
.rework .content .divsmallimg .submit  .reset:active{
	background: url(<%=basePath %>public/images/buttonGroup01.png) no-repeat 0 -236px;
	color: #D6D6D6;
	text-shadow: 1px 1px 1px black;
	
	}
	
	
.rework .content .divsmallimg .edit{
	margin-top:20px;
	}
.rework .content .divsmallimg .edit .change{
	border: 0 none;
    cursor: pointer;
    font-family: "微软雅黑";
    font-size: 15px;
    height: 27px;
    margin-left: 30px;
    padding-bottom: 2px;
    width: 86px;
	background: url(<%=basePath %>public/images/buttonGroup01.png) no-repeat 0 -182px;
    color: #000000;
	}
.rework .content .divsmallimg .edit .change:hover{
	background: url(<%=basePath %>public/images/buttonGroup01.png) no-repeat 0 -209px;
	}
.rework .content .divsmallimg .edit .change:active{
	background: url(<%=basePath %>public/images/buttonGroup01.png) no-repeat 0 -236px;
	}
</style>
</head>

<body>


 <!--代表作品弹出框-->
    <div class="rework" id="divChooseWorkPop">
    	<input type="hidden" id="hiddenv" />
    	<div class="top">
    		<h2>编辑封面图片</h2>
			<a href="javascript:cloosePopBox();"></a>
    	</div>    
    	
        
        <div class="content">
        	<div class="divbigimg">
            	<table style="width:100%;height:100%;"><tr><td align="center" valign="middle"><img  id="imghead" src="<%=basePath %>public/pic/1000.png" /></td></tr></table>
            	
            </div>
        
       		 <div class="divsmallimg">
             	<div class="coverpreview">封面预览</div>
                <div class="imgbj" id="preview" ><img src="<%=basePath %>public/pic/1000.png" /></div>
                <div class="coversize">封面尺寸285px*175px</div>
                
                <div class="edit"><input class="change" type="button" value="更换图片" onclick="changeImg();"/></div>
                
                <div class="submit">
        			<input class="reset" type="button" value="取消"  onclick="cloosePopBox();"/>
					<input class="sub" type="button" value="提交" onclick="submitPopBox();"/>
    			</div>
             </div>
             
             
        </div>
        
    </div>
   <script type="text/javascript">
function preview(img, selection) {
	if (!selection.width || !selection.height)
	return;

	var scaleX = 285 / selection.width;
	var scaleY = 175 / selection.height;

	$('#preview img').css({
		width: Math.round(scaleX * 800),
		height: Math.round(scaleY * 800),
		marginLeft: -Math.round(scaleX * selection.x1),
		marginTop: -Math.round(scaleY * selection.y1)
	});

	$('#x1').val(selection.x1);
	$('#y1').val(selection.y1);
	$('#x2').val(selection.x2);
	$('#y2').val(selection.y2);
	$('#w').val(selection.width);
	$('#h').val(selection.height);    
}

$(function () {
$('#imghead').imgAreaSelect({ 
	aspectRatio: '285:175', 
	handles: true,
	fadeSpeed: 200, 
	onSelectChange: preview ,
	minHeight:175,
	minWidth:285,
	x1:0,y1:0, x2:285,y2:175
	});
});
</script>
</body>
</html>

