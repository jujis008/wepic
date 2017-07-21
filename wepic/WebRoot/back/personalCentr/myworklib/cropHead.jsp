<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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


<script type="text/javascript">
function preview(img, selection) {
	if (!selection.width || !selection.height)
	return;
	
	var smallWidth = 285;									//缩略图的宽度
	var smallHeight = 175;									//缩略图的高度
	
	
	var bigWidth = parseInt($("#imghead").css("width"));									//大图的宽度
	var bigHeight = parseInt($("#imghead").css("height"));									//大图的高度
	
	var scaleX = smallWidth / selection.width;					

	var scaleY = smallHeight / selection.height;
	
	

	$('#preview img').css({
		width: Math.round(scaleX * bigWidth)+'px',
		height: Math.round(scaleY * bigHeight)+'px',
		marginLeft: -Math.round(scaleX * selection.x1)+'px',
		marginTop: -Math.round(scaleY * selection.y1)+'px'
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
		onSelectChange: preview 
		});
});
</script>
<script>


/*关闭弹出框*/
function cloosePopBox(){
	window.parent.closeOwnBox("cropHead");
}
/*关闭弹出框*/


/*提交信息并返回前一个页面*/
function submitPopBox(){
	var hidden=document.getElementById("hiddenId").value;
	var x=document.getElementById("x1").value;
	var y=document.getElementById("y1").value;
	var x1=document.getElementById("x2").value;
	var y1=document.getElementById("y2").value
	$.ajax({
							type : "POST",
							url : "userstory_cutcover.do",
							data : "publishId="+hidden+"&x1="+x+"&y1="+y+"&x2="+x1+"&y2="+y1,					
							success : function(data) {
							var url = data.msg;
							window.parent.closeOwnBox("cropHead");
							window.parent.changehh(url,hidden);
									}
							});
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
    background:url(<%=basePath %>/public/images/closeBox.png) 0 0 no-repeat;
    height: 58px;
    position: absolute;
    right: 0;
    top: 0;
    width: 58px;
	}
.rework .top a:hover{
	background:url(<%=basePath %>/public/images/closeBox.png) no-repeat 0 -58px;
	}
.rework .top a:active{
	background:url(<%=basePath %>/public/images/closeBox.png) no-repeat 0 -116px;
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
.rework .content .divsmallimg .imgB{
	margin:70px auto;
}
.rework .content .divsmallimg .imgbj{
	width:285px;
	height:175px;
	background:#fcfcfc;
	overflow: hidden;
	text-align:center;
	background-image:url(<%=basePath %>/public/images/thumbnail.png);
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
    background: url(<%=basePath %>/public/images/buttonGroup01.png) no-repeat 0 -273px;
	}
.rework .content .divsmallimg .submit  .sub:hover{
	background: url(<%=basePath %>/public/images/buttonGroup01.png) no-repeat 0 -300px;
	}
.rework .content .divsmallimg .submit  .sub:active{
	background: url(<%=basePath %>/public/images/buttonGroup01.png) no-repeat 0 -327px;
	color: #D6D6D6;
	text-shadow: 1px 1px 1px black;
	}
	
.rework .content .divsmallimg .submit  .reset{
    color: #000000;
    background: url(<%=basePath %>/public/images/buttonGroup01.png) no-repeat 0 -182px;
	}
.rework .content .divsmallimg .submit  .reset:hover{
	background: url(<%=basePath %>/public/images/buttonGroup01.png) no-repeat 0 -209px;
	}
.rework .content .divsmallimg .submit  .reset:active{
	background: url(<%=basePath %>/public/images/buttonGroup01.png) no-repeat 0 -236px;
	color: #D6D6D6;
	text-shadow: 1px 1px 1px black;
	
	}
</style>
</head>

<body>
<input type="hidden" id="x1" value=""/>
<input type="hidden" id="y1" value=""/>
<input type="hidden" id="x2" value=""/>
<input type="hidden" id="y2" value=""/>
 
 <!--代表作品弹出框-->
    <div class="rework" id="divChooseWorkPop">
    	<input type="hidden" id="hiddenv" />
    	<div class="top">
    		<h2>编辑封面图片</h2>
			<a href="javascript:cloosePopBox();"></a>
    	</div>    
    	
        
        <div class="content">
        	<div class="divbigimg">
            	<table style="width:100%;height:100%;"><tr><td align="center" valign="middle" id="divImg"><img  id="imghead" src="pic/1000.png"/></td></tr></table>
            	
            </div>
        
       		 <div class="divsmallimg">
             	<div class="coverpreview">封面预览</div>
             	
                <div class="imgbj" id="preview" ><input type="hidden" id="hiddenId"/><img src="" /></div>
                <div class="coversize">封面尺寸285px*175px</div>
                
                
                <div class="submit">
        			<input class="reset" type="button" value="取消"  onclick="cloosePopBox();"/>
					<input class="sub" type="button" value="提交" onclick="submitPopBox();"/>
    			</div>
             </div>
             
             
        </div>
        
    </div>

</body>
</html>
