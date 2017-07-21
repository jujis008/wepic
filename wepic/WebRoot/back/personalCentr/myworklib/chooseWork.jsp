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

<script type="text/javascript" src="../../userView/public/js/jquery.js"></script>
<script src='js/jquery.slider.js'></script>

<script>
$(document).ready(function(){ 

	divLiBar("divCheckPic");				//查看头像

	achieveBelow("divSelectPicValue","selectPicValue");		/*获取下拉框值并隐藏	图片作品*/

	achieveBelow("divSelectSpecialValue","selectSpecialValue");		/*获取下拉框值并隐藏	选择专辑*/
	
	divClickBar("divViewRe");
});

/*关闭弹出框*/
function cloosePopBox(){
	window.parent.closeOwnBox();
}
/*关闭弹出框*/


/*提交信息并返回前一个页面*/
function submitPopBox(){
	
	window.parent.closeOwnBox();
	
	var openPop = document.getElementById("hiddenv").value;
	window.parent.openPopUpBox(openPop);
	}
	
	
/*提交信息并返回前一个页面*/



/* click 动作*/
function divClickBar(divName){
	var mainDiv=document.getElementById(divName);
	var allMainBarLi=mainDiv.getElementsByTagName("li");
	for(var i=0;i<allMainBarLi.length;i++){
		allMainBarLi[i].onclick = function(){
			if($(this).attr("class") == "active"){
				$(this).removeClass("active");
				}
			else{
				$(this).addClass("active");
				}
		};
		}
	}
	
	
	
/* active 动作*/
function divLiBar(divName){
	var mainDiv=document.getElementById(divName);
	var allMainBarLi=mainDiv.getElementsByTagName("li");
	
	for(var i=0;i<allMainBarLi.length;i++){
		allMainBarLi[i].onmouseover = function(){
			
			for(var i=0;i<allMainBarLi.length;i++){
				allMainBarLi[i].className = "";
			}
			this.className="active";
		};
		allMainBarLi[i].onmouseout = function(){
			for(var i=0;i<allMainBarLi.length;i++){
				this.className="";
			}
		};
	}
}

/* active 动作*/

/*获取下拉框值并隐藏*/
function achieveBelow(bolewDiv,showValue){
	var bolewDiv=document.getElementById(bolewDiv);
	var bolewDivSpan=bolewDiv.getElementsByTagName("span");
	/*alert("11");*/
				
	for(var i=0;i<bolewDivSpan.length;i++){
		bolewDivSpan[i].onclick=function (){
			/*document.getElementById(showValue).innerHTML = this.innerHTML;*/
			$("#"+showValue).html(this.innerHTML);
			$(bolewDiv).hide();
			};
		}
}
/*获取下拉框值并隐藏*/


/*显示下拉框列表*/
function showBelow(showDiv){
	$("#"+showDiv).show();
	}
	
	
	
</script>


<style>
/*我的代表作弹出框*/

*{margin:0;padding:0;}
li{list-style: none;}
img{border:0;}
#divChooseWorkPop{
	width:950px;
	height:800px;
	}

.rework{
	background:#ffffff;
	/*padding-bottom:90px;*/
	}
.rework .top{
    background:#F6F6F6;
    border-bottom: 1px solid #E3E3E3;
    height: 57px;
    left: 0;
    position: relative;
    top: 0;
    width: 950px;
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
    background:url(../../userView/public/images/closeBox.png) 0 0 no-repeat;
    height: 58px;
    position: absolute;
    right: 0;
    top: 0;
    width: 58px;
	}
.rework .top a:hover{
	background:url(../../userView/public/images/closeBox.png) no-repeat 0 -58px;
	}
.rework .top a:active{
	background:url(../../userView/public/images/closeBox.png) no-repeat 0 -116px;
	}
	
	
	
	
.rework .workAbstractRe{
	border-bottom: 1px solid #E3E3E3;
    height: 65px;
    left: 0;
    position: relative;
    top: 0;
    width: 950px;
	text-align:left;
	z-index:10;
	}

#divWorkType {
    height: 27px;
    left: 88px;
    position: absolute;
    top: 20px;
    width: 85px;
	color: #696969;
	}
	
#divSpecialType {
    height: 27px;
    left: 250px;
    position: absolute;
    top: 20px;
    width: 85px;
	color: #696969;
	}
	
#divSelectWorkTypeValue {
    overflow-x: hidden;
    overflow-y: auto;
    width: 105px;
	}


#divSelectWorkTypeValue .selectValueIn {
    width: 90px;
	}


	



	
	
	
	
	
	



.rework .submit{
    height: 50px;
    left: 0;
    position: relative;
    top: 0;
    width: 950px;
	margin-top:25px;
	}

.rework .submit .reset {
	right: 240px;
    position: absolute;
    top: 0;
    background: url(../../userView/public/images/buttonGroup01.png) no-repeat 0 -836px;
    border: 0 none;
    color: #242424;
    cursor: pointer;
    font-family: "微软雅黑";
    font-size: 17px;
    height: 36px;
    padding-bottom: 2px;
    padding-left: 0;
    width: 143px;
	letter-spacing: 15px;
    padding-left: 20px;
	}	
.rework .submit .reset:hover{
	background: url(../../userView/public/images/buttonGroup01.png) no-repeat 0 -872px;
	}
.rework .submit .reset:active{
	background: url(../../userView/public/images/buttonGroup01.png) no-repeat 0 -908px;
	}
.rework .submit  .sub {
	right: 73px;
    position: absolute;
    top: 0;
    background: url(../../userView/public/images/buttonGroup01.png) no-repeat 0 -718px;
    border: 0 none;
    color: #FFFFFF;
    cursor: pointer;
    font-family: "微软雅黑";
    font-size: 17px;
    height: 36px;
    margin-left: 20px;
    padding-bottom: 2px;
    padding-left: 0;
    width: 143px;
	letter-spacing: 15px;
    padding-left: 20px;
	}
.rework .submit  .sub:hover{
	background: url(../../userView/public/images/buttonGroup01.png) no-repeat 0 -754px;
	}
.rework .submit  .sub:active{
	background: url(../../userView/public/images/buttonGroup01.png) no-repeat 0 -790px;
	color: #D6D6D6;
	text-shadow: 1px 1px 1px black;
	}
/*我的代表作弹出框*/

/*写出下拉框*/

.editSelect{
	position:absolute;
	}
.viewBelow{
	position:absolute;
	left:0px;
	top:0px;
	 width: 115px;
	height:22px;
	cursor:pointer;
	padding-top:5px;
	padding-left:10px;
	background:#fcfcfc;
	border:1px solid #e8e8e6;
	color: #696969;
    font-family: "微软雅黑";
    font-size: 13px;
	}
.viewBelow:hover{
	background:#fffdf1;
	border:1px solid #f09494;
	}
.viewBelowRight{
	position:absolute;
	right:0px;
	top:6px;
	width:30px;
	height:16px;
	border-left:1px solid #e4e8eb;
	}
.viewBelowRight i{
	position:absolute;
	left:11px;
	top:6px;
	_top:-4px;
	width:10px;
	height:10px;
	background:url(images/select_bi.png) no-repeat 0 0px;
	_background:url(images/select_bi.png) no-repeat 0 10px;
	}
.viewBelow:hover .viewBelowRight i{
	background:url(images/select_bi.png) no-repeat 0 -10px;
	}	
	




	
.belowValue{
	display:none;
	position:absolute;
	left:0px;
	top:28px;
	width:125px;
	cursor:pointer;
	background:#ffffff;
	border:1px solid #e8e8e6;
	}	
.belowValue .selectValueIn{
	cursor:pointer;
	display:block;
	color:#788F72;
	width:115px;
	height:25px;
	line-height:22px;
	padding-left:10px;
	font-size: 12px;
	/*
	border:1px solid red;*/
}	
.belowValue .selectValueIn:hover{
	color:#000000;
	background:#F0F0F0;
	}

/*写出下拉框*/

.workAbstractRe .divSearch{
	left: 400px;
    position: absolute;
    top: 20px;
	height: 30px;
	width: 290px;
	}
.workAbstractRe .divSearch .search {
    background:#fcfcfc;
    border: 1px solid #e8e8e6;
    border-radius: 3px;
    color: #696969;
    font-family: "微软雅黑";
    font-size: 12px;
    height: 18px;
    padding: 5px 30px 5px 15px;
    width: 240px;
	}
.workAbstractRe .divSearch .icosearch{
	cursor:pointer;
	right: 10px;
    position: absolute;
    top: 5px;
	width: 20px;
	height: 20px;
	background:url(../../userView/public/images/search.png) 0 -10px no-repeat;
	}
.workAbstractRe .divSearch .icosearch:hover{
	background:url(../../userView/public/images/search.png) 0 -51px no-repeat;
	}
.workAbstractRe  .upload {
    background: url(../../userView/public/images/buttonGroup01.png)scroll 0 -482px;
    border: 0;
    color: #242424;
    cursor: pointer;
    font-family: "微软雅黑";
    font-size: 17px;
    height: 36px;
    padding-bottom: 2px;
    position: absolute;
    right: 77px;
    top: 22px;
    width: 126px;
	}
.workAbstractRe  .upload:hover {
    background: url(../../userView/public/images/buttonGroup01.png)scroll 0 -518px;
	}
.workAbstractRe  .upload:active {
    background: url(../../userView/public/images/buttonGroup01.png)scroll 0 -554px;
	}
	




.rework .chooseWork{
	background:#f5f5f5;
    height: 410px;
    left: 0;
    position: relative;
    top: 0;
    width: 950px;
	text-align:left;
	z-index:9;
	}

	
.rework .chooseWork .viewHead {
    left: 0;
    padding-left: 80px;
    position: relative;
    top: 0;
    width: 870px;
	height:410px;
	overflow:auto;
	}

.rework .chooseWork .viewHead li {
    float: left;
	list-style:none;
    left: 0;
    margin-left: 7px;
	margin-top: 10px;
    position: relative;
    top: 0;
	}
	
	
	
	
	
.rework .checkPic{
	background:#f5f5f5;
    height: 164px;
    left: 0;
    position: relative;
    top: 0;
    width: 950px;
	text-align:left;
	margin-top:15px;
	}		

.rework .checkPic .checkCharacter {
    height: 20px;
    left: 0;
    position: relative;
    top: 0;
	}
.rework .checkPic .checkCharacter .spa1{
	margin-left:75px;
	color: #585858;
    font-family: "微软雅黑";
    font-size: 15px;
	line-height:24px;
	}	

.rework .checkPic .checkCharacter .spa2{
	margin-left:5px;
	color: #a1a1a1;
    font-size: 12px;
	line-height:24px;
	}
.rework .checkPic .checkCharacter .num{
	font-family: "黑体";
	margin-left:5px;
	color: #e83c38;
    font-size: 13px;
	line-height:24px;
	}

/*.rework .checkPic .checkCharacter .pre{
    background: url(images/changePage.png) no-repeat 0 -72px;
    height: 20px;
    position: absolute;
    right: 110px;
    top: 5px;
    width: 20px;
	}
.rework .checkPic .checkCharacter .pre:hover{
	background: url(images/changePage.png) no-repeat 0 -96px;
	}
.rework .checkPic .checkCharacter .next{
    background: url(images/changePage.png) no-repeat 0 0px;
    height: 20px;
    position: absolute;
    right: 78px;
    top: 5px;
    width: 20px;
	}
.rework .checkPic .checkCharacter .next:hover{
    background: url(images/changePage.png) no-repeat 0 -24px;
	}*/
/*.rework .checkPic .checkPicHead {
    height: 125px;
    left: 0;
    padding-left: 80px;
    position: relative;
    top: 0;
    width: 800px;
	overflow:hidden;
	}*/

/*.rework .checkPic .checkPicHead li {
    float: left;
	list-style:none;
    left: 0;
    margin-left: 7px;
	margin-top: 10px;
    position: relative;
    top: 0;
	}*/	

.rework .checkPic .checkPicHead .active .nowtop{
	display:block;
	}	
.rework .checkPic .checkPicHead .nowtop{
	display:none;
	position: absolute;
    bottom: 0;
	left:0;
	height: 32px;
    width: 125px;
	text-align:center;
	}	
.rework .checkPic .checkPicHead .nowtop .bj{
	position: absolute;
    top: 0;
	left:0;
	height: 32px;
    width: 125px;
	background:#000000;
	filter:alpha(opacity=70);    /* IE 4-7 */     
	opacity: 0.7;              /* Firefox, Safari(WebKit), Opera */
	}	
.rework .checkPic .checkPicHead .nowtop .bjc{
	position: absolute;
    top: 0;
	left:0;
	height: 32px;
    width: 125px;
	}	
.rework .checkPic .checkPicHead .nowtop .bjc a{
	background:url(images/editdel.png) 0 -66px no-repeat;
    height: 20px;
    left: 55px;
    position: absolute;
    top: 6px;
    width: 20px;
	}


.rework .viewHead .active .nowtop{
	display:block;
	}	
.rework .viewHead .nowtop{
	display:none;
	position: absolute;
    bottom: 0;
	left:0;
	height: 125px;
    width: 125px;
	text-align:center;
	}	
.rework .viewHead .nowtop .bj{
	position: absolute;
    top: 0;
	left:0;
	height: 125px;
    width: 125px;
	background:#000000;
	filter:alpha(opacity=70);    /* IE 4-7 */     
	opacity: 0.7;              /* Firefox, Safari(WebKit), Opera */
	}	
.rework .viewHead .nowtop .bjc{
	position: absolute;
    top: 0;
	left:0;
	height: 125px;
    width: 125px;
	}
	
		

.rework .viewHead .nowtop .bjc .check{
	background:url(images/checked.png) 0 0 no-repeat;
    
    width: 55px;
    height: 55px;
    left:35px;
    position: absolute;
    top: 35px;
	}	
	
</style>
</head>

<body>


 <!--代表作品弹出框-->
    <div class="rework" id="divChooseWorkPop">
    	<input type="hidden" id="hiddenv" />
    	<div class="top">
    		<h2>选择作品</h2>
			<a href="javascript:cloosePopBox();"></a>
    	</div>    
    	<div class="workAbstractRe">
				<div class="editSelect" id="divWorkType" >
                    	<div class="viewBelow" onclick="showBelow('divSelectPicValue')">
                        	<div id="selectPicValue">请选择类别</div>
                       		<div class="viewBelowRight"><i></i></div>    
                    	</div>
                           
                    	<div  class="belowValue" id="divSelectPicValue" style="display:none;">
                        	<span class='selectValueIn'>图片作品</span>
                            <span class='selectValueIn'>摄影故事</span>
 						</div>
            	</div>
                
                <div class="editSelect" id="divSpecialType" >
                    	<div class="viewBelow" onclick="showBelow('divSelectSpecialValue')">
                        	<div id="selectSpecialValue">请选择专辑</div>
                       		<div class="viewBelowRight"><i></i></div>    
                    	</div>
                           
                    	<div  class="belowValue" id="divSelectSpecialValue" style="display:none;">
                        	<span class='selectValueIn'>我的麦克风</span>
                            <span class='selectValueIn'>你的麦克风</span>
 						</div>
            	</div>
                
                <div class="divSearch">
                	<input class="search" type="text" onfocus="if(this.value=='关键词搜索（针对已有关键词作品）') this.value='';this.style.color='#333'" onblur="if(this.value=='') {this.value='关键词搜索（针对已有关键词作品）';this.style.color='#7f7f7f'}" value="关键词搜索（针对已有关键词作品）">
                    <i class="icosearch"></i>
                </div>
                
                <input class="upload" type="button" value="本地上传">
    	</div>
    	<div class="chooseWork">
    		
            
            <div class="viewHead" id="divViewRe">
            	<ul>
                	
                	<li>
                    	<div class="img"><a href="javascript:;"><img src="pic/4.png" /></a></div>
                        <div class="nowtop">
                        	<div class="bj"></div>
                        	<div class="bjc">
                        	<a href="javascript:" class="check"></a></div>
                        </div>
                    </li>
                    
                   <li>
                    	<div class="img"><a href="javascript:;"><img src="pic/4.png" /></a></div>
                        <div class="nowtop">
                        	<div class="bj"></div>
                        	<div class="bjc">
                        	<a href="javascript:" class="check"></a></div>
                        </div>
                    </li>
                    
                	<li>
                    	<div class="img"><a href="javascript:;"><img src="pic/4.png" /></a></div>
                        <div class="nowtop">
                        	<div class="bj"></div>
                        	<div class="bjc">
                        	<a href="javascript:" class="check"></a></div>
                        </div>
                    </li>
                    
                   <li>
                    	<div class="img"><a href="javascript:;"><img src="pic/4.png" /></a></div>
                        <div class="nowtop">
                        	<div class="bj"></div>
                        	<div class="bjc">
                        	<a href="javascript:" class="check"></a></div>
                        </div>
                    </li>
                	<li>
                    	<div class="img"><a href="javascript:;"><img src="pic/4.png" /></a></div>
                        <div class="nowtop">
                        	<div class="bj"></div>
                        	<div class="bjc">
                        	<a href="javascript:" class="check"></a></div>
                        </div>
                    </li>
                    
                   <li>
                    	<div class="img"><a href="javascript:;"><img src="pic/4.png" /></a></div>
                        <div class="nowtop">
                        	<div class="bj"></div>
                        	<div class="bjc">
                        	<a href="javascript:" class="check"></a></div>
                        </div>
                    </li>
                	<li>
                    	<div class="img"><a href="javascript:;"><img src="pic/4.png" /></a></div>
                        <div class="nowtop">
                        	<div class="bj"></div>
                        	<div class="bjc">
                        	<a href="javascript:" class="check"></a></div>
                        </div>
                    </li>
                    
                   <li>
                    	<div class="img"><a href="javascript:;"><img src="pic/4.png" /></a></div>
                        <div class="nowtop">
                        	<div class="bj"></div>
                        	<div class="bjc">
                        	<a href="javascript:" class="check"></a></div>
                        </div>
                    </li>
                	<li>
                    	<div class="img"><a href="javascript:;"><img src="pic/4.png" /></a></div>
                        <div class="nowtop">
                        	<div class="bj"></div>
                        	<div class="bjc">
                        	<a href="javascript:" class="check"></a></div>
                        </div>
                    </li>
                    
                   <li>
                    	<div class="img"><a href="javascript:;"><img src="pic/4.png" /></a></div>
                        <div class="nowtop">
                        	<div class="bj"></div>
                        	<div class="bjc">
                        	<a href="javascript:" class="check"></a></div>
                        </div>
                    </li>
                	<li>
                    	<div class="img"><a href="javascript:;"><img src="pic/4.png" /></a></div>
                        <div class="nowtop">
                        	<div class="bj"></div>
                        	<div class="bjc">
                        	<a href="javascript:" class="check"></a></div>
                        </div>
                    </li>
                    
                   <li>
                    	<div class="img"><a href="javascript:;"><img src="pic/4.png" /></a></div>
                        <div class="nowtop">
                        	<div class="bj"></div>
                        	<div class="bjc">
                        	<a href="javascript:" class="check"></a></div>
                        </div>
                    </li>
                	<li>
                    	<div class="img"><a href="javascript:;"><img src="pic/4.png" /></a></div>
                        <div class="nowtop">
                        	<div class="bj"></div>
                        	<div class="bjc">
                        	<a href="javascript:" class="check"></a></div>
                        </div>
                    </li>
                    
                   <li>
                    	<div class="img"><a href="javascript:;"><img src="pic/4.png" /></a></div>
                        <div class="nowtop">
                        	<div class="bj"></div>
                        	<div class="bjc">
                        	<a href="javascript:" class="check"></a></div>
                        </div>
                    </li>
                	<li>
                    	<div class="img"><a href="javascript:;"><img src="pic/4.png" /></a></div>
                        <div class="nowtop">
                        	<div class="bj"></div>
                        	<div class="bjc">
                        	<a href="javascript:" class="check"></a></div>
                        </div>
                    </li>
                    
                   <li>
                    	<div class="img"><a href="javascript:;"><img src="pic/4.png" /></a></div>
                        <div class="nowtop">
                        	<div class="bj"></div>
                        	<div class="bjc">
                        	<a href="javascript:" class="check"></a></div>
                        </div>
                    </li>
                	<li>
                    	<div class="img"><a href="javascript:;"><img src="pic/4.png" /></a></div>
                        <div class="nowtop">
                        	<div class="bj"></div>
                        	<div class="bjc">
                        	<a href="javascript:" class="check"></a></div>
                        </div>
                    </li>
                    
                   <li>
                    	<div class="img"><a href="javascript:;"><img src="pic/4.png" /></a></div>
                        <div class="nowtop">
                        	<div class="bj"></div>
                        	<div class="bjc">
                        	<a href="javascript:" class="check"></a></div>
                        </div>
                    </li>
                	<li>
                    	<div class="img"><a href="javascript:;"><img src="pic/4.png" /></a></div>
                        <div class="nowtop">
                        	<div class="bj"></div>
                        	<div class="bjc">
                        	<a href="javascript:" class="check"></a></div>
                        </div>
                    </li>
                    
                   <li>
                    	<div class="img"><a href="javascript:;"><img src="pic/4.png" /></a></div>
                        <div class="nowtop">
                        	<div class="bj"></div>
                        	<div class="bjc">
                        	<a href="javascript:" class="check"></a></div>
                        </div>
                    </li>
                	<li>
                    	<div class="img"><a href="javascript:;"><img src="pic/4.png" /></a></div>
                        <div class="nowtop">
                        	<div class="bj"></div>
                        	<div class="bjc">
                        	<a href="javascript:" class="check"></a></div>
                        </div>
                    </li>
                    
                   <li>
                    	<div class="img"><a href="javascript:;"><img src="pic/4.png" /></a></div>
                        <div class="nowtop">
                        	<div class="bj"></div>
                        	<div class="bjc">
                        	<a href="javascript:" class="check"></a></div>
                        </div>
                    </li>
                	<li>
                    	<div class="img"><a href="javascript:;"><img src="pic/4.png" /></a></div>
                        <div class="nowtop">
                        	<div class="bj"></div>
                        	<div class="bjc">
                        	<a href="javascript:" class="check"></a></div>
                        </div>
                    </li>
                    
                   <li>
                    	<div class="img"><a href="javascript:;"><img src="pic/4.png" /></a></div>
                        <div class="nowtop">
                        	<div class="bj"></div>
                        	<div class="bjc">
                        	<a href="javascript:" class="check"></a></div>
                        </div>
                    </li>
                	<li>
                    	<div class="img"><a href="javascript:;"><img src="pic/4.png" /></a></div>
                        <div class="nowtop">
                        	<div class="bj"></div>
                        	<div class="bjc">
                        	<a href="javascript:" class="check"></a></div>
                        </div>
                    </li>
                    
                   <li>
                    	<div class="img"><a href="javascript:;"><img src="pic/4.png" /></a></div>
                        <div class="nowtop">
                        	<div class="bj"></div>
                        	<div class="bjc">
                        	<a href="javascript:" class="check"></a></div>
                        </div>
                    </li>
                	<li>
                    	<div class="img"><a href="javascript:;"><img src="pic/4.png" /></a></div>
                        <div class="nowtop">
                        	<div class="bj"></div>
                        	<div class="bjc">
                        	<a href="javascript:" class="check"></a></div>
                        </div>
                    </li>
                    
                   <li>
                    	<div class="img"><a href="javascript:;"><img src="pic/4.png" /></a></div>
                        <div class="nowtop">
                        	<div class="bj"></div>
                        	<div class="bjc">
                        	<a href="javascript:" class="check"></a></div>
                        </div>
                    </li>
                	<li>
                    	<div class="img"><a href="javascript:;"><img src="pic/4.png" /></a></div>
                        <div class="nowtop">
                        	<div class="bj"></div>
                        	<div class="bjc">
                        	<a href="javascript:" class="check"></a></div>
                        </div>
                    </li>
                    
                   <li>
                    	<div class="img"><a href="javascript:;"><img src="pic/4.png" /></a></div>
                        <div class="nowtop">
                        	<div class="bj"></div>
                        	<div class="bjc">
                        	<a href="javascript:" class="check"></a></div>
                        </div>
                    </li>
                	<li>
                    	<div class="img"><a href="javascript:;"><img src="pic/4.png" /></a></div>
                        <div class="nowtop">
                        	<div class="bj"></div>
                        	<div class="bjc">
                        	<a href="javascript:" class="check"></a></div>
                        </div>
                    </li>
                    
                   <li>
                    	<div class="img"><a href="javascript:;"><img src="pic/4.png" /></a></div>
                        <div class="nowtop">
                        	<div class="bj"></div>
                        	<div class="bjc">
                        	<a href="javascript:" class="check"></a></div>
                        </div>
                    </li>
                </ul>
            </div>
    	</div>
        
        
        <div class="checkPic" id="divCheckPic">
        
        	<div class="checkCharacter">
            	<span class="spa1">您已选择作品</span>
            	<span class="spa2">已选应征作品数量为</span>
            	<span class="num">7</span>
            	
            </div>
            
            <div class="slider-box">
            <a href='javascript:;' class="slider-prev slider-btn" title="上一张"></a>
        	<div class="checkPicHead slider-wrapper">
            	<ul class='slider-move'>
                	
                	
                	<li>
                    	<div class="img"><img src="pic/4.png" /></div>
                        <div class="nowtop">
                        	<div class="bj"></div>
                        	<div class="bjc">
                        	<a href="javascript:" class="del"></a></div>
                        </div>
                    </li>
                	<li>
                    	<div class="img"><img src="pic/5.png" /></div>
                        <div class="nowtop">
                        	<div class="bj"></div>
                        	<div class="bjc">
                        	<a href="javascript:" class="del"></a></div>
                        </div>
                    </li>
                	<li>
                    	<div class="img"><img src="pic/6.png" /></div>
                        <div class="nowtop">
                        	<div class="bj"></div>
                        	<div class="bjc">
                        	<a href="javascript:" class="del"></a></div>
                        </div>
                    </li>
                	<li>
                    	<div class="img"><img src="pic/7.png" /></div>
                        <div class="nowtop">
                        	<div class="bj"></div>
                        	<div class="bjc">
                        	<a href="javascript:" class="del"></a></div>
                        </div>
                    </li>
                    <li>
                    	<div class="img"><img src="pic/8.png" /></div>
                        <div class="nowtop">
                        	<div class="bj"></div>
                        	<div class="bjc">
                        	<a href="javascript:" class="del"></a></div>
                        </div>
                    </li>
                    
                    <li>
                    	<div class="img"><img src="pic/9.png" /></div>
                        <div class="nowtop">
                        	<div class="bj"></div>
                        	<div class="bjc">
                        	<a href="javascript:" class="del"></a></div>
                        </div>
                    </li>
                	<li>
                    	<div class="img"><img src="pic/7.png" /></div>
                        <div class="nowtop">
                        	<div class="bj"></div>
                        	<div class="bjc">
                        	<a href="javascript:" class="del"></a></div>
                        </div>
                    </li>
                    <li>
                    	<div class="img"><img src="pic/5.png" /></div>
                        <div class="nowtop">
                        	<div class="bj"></div>
                        	<div class="bjc">
                        	<a href="javascript:" class="del"></a></div>
                        </div>
                    </li>
                </ul>
            </div>
            <a href='javascript:;' class="slider-next slider-btn" title="下一张"></a>
            </div>
        </div>    
            
        <div class="submit">
        	<input class="reset" type="button" value="取消"  onclick="submitPopBox();"/>
			<input class="sub" type="button" value="提交" onclick="submitPopBox();"/>
    	</div>
    </div>
    <style>
		

		/*水平滚动样式*/
		.slider-box{
			position: relative;
			top:0;
			left:0;
			height: 125px;
			width: 785px;
			margin: 0 auto;
			margin-top:10px;
			border: 1px solid #ccc
			}
		.slider-btn{
			position:absolute;
			top:-26px;
			height:20px;
			width: 20px;
			background: url(images/changePage.png) no-repeat;
			}
		.slider-next{
			right:30px;
			background-position:0 -72px;
			}
		.slider-next:hover{
			background-position:0 -96px;
			}
			
		.slider-prev{
			right:00px;
			background-position:0 0;
			}
			
		.slider-prev:hover{
			background-position:0 -24px;
			}
		.slider-wrapper{
			height: 100%;
			position: relative;
			top:0;
			left:0;
			width: 785px;
			overflow:hidden;
			}
		.slider-wrapper ul{
			position: absolute;
			top:0;
			left:0;
			height: 100%;
			width: 800px;}
		.slider-wrapper li{
			float: left;
			width:132px;
			position: relative; 
			top:0;
			left:0;
			}
		.slider-wrapper li img{
			width: 125px;
			height: 125px;
			border: none;
			float: left;
			}


	</style>
    <script>
		$(function(){
			$('.slider-box').mySlider({  //参数可选,以下为默认参数
					speed: 300,
					direction: 'left', //  运动方向 可选 left,top
					prevClass: 'slider-prev',			//左边
					nextClass: 'slider-next',			//右边
					wrapperClass: 'slider-wrapper',
					moveClass: 'slider-move'
			});
		});
	</script>
    <!--代表作品弹出框-->
</body>
</html>
