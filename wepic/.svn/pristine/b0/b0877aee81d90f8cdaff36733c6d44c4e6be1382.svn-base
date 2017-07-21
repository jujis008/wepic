<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>选择好友</title>
	
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->

<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/jquery.js"></script>


<script>
$(document).ready(function(){ 


	achieveBelow("divdropDownAttention","divdropDownViewAttention")					/*获取下拉框值并隐藏	拍摄类型*/

	achieveBelow("divdropDownJobType","divdropDownViewJobType")					/*获取下拉框值并隐藏	拍摄类型*/
	
	addClickzj('clickLeft');										//点击选中左边
	
	
	addClickzj('clickRight');										//点击选中右边
	
	
});

/*关闭弹出框*/
function cloosePopBox(){
	window.parent.closeOwnBox("iframeChooseFriend");
}
/*关闭弹出框*/

function submitPopBox(){
	var allLi = $("#clickRightUL").find("li");
	var length = allLi.length;
	if(length == 0){
		alert("您还没有选择好友！");
		return;
		}
	var userIds="";
	$(allLi).each(function(){
		if(userIds==""){
			userIds+=$(this).find(".userId").val();
			}else{
				userIds+=","+$(this).find(".userId").val();
				}
	 
		});
	
	window.parent.closeOwnBox("iframeChooseFriend");
	$('#userIds',parent.document).val(userIds);
	
	window.parent.acheiveNumFriend(length);
	}




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

	
var idI = 1;
function addClickzj(divName){
	var opt ="";
	var option = "";
	var allMainBarLi=$("#"+divName).find("li");
	
	var allRightLi=$("#clickRightUL").find("li");
	
	$(allMainBarLi).each(function(){
		$(this).attr("id","click"+(idI++));
		var cId = $(this).attr("id");
			$(this).click(function(){
				
					if($(this).attr("class") == "active"){
						$(this).removeClass("active");
						$(this).children().find(".check").remove();
						
						$("#clickRightUL").find("#"+cId).remove();
						
					}
					else{
						$(this).addClass("active");
						$(this).children().append('<div class="check"></div>');
							opt= $(this).html();
							option = "<li id='"+(cId)+"'>"+opt+"</li>";
						
						//alert();
						$("#clickRightUL").append(option);
						
					}
					deleteRight("clickRight");
			});
					
    });	
}


function deleteRight(divName){
	var allMainBarCheck=$("#"+divName).find(".check");
	
	$(allMainBarCheck).each(function(){
			$(this).click(function(){
				$(this).parents("li").remove();
				var lId = $(this).parents("li").attr("id");
				
				
				$("#clickLeft").find("#"+lId).removeClass("active");
				$("#clickLeft").find("#"+lId).children().find(".check").remove();
				});
	});
}


window.onload = function(){

	var htmlWidth = document.body.clientWidth;
	var htmlHeight = document.body.clientHeight;
	var borwerViewWidth =  document.documentElement.clientWidth;
	var borwerViewHeight =  document.documentElement.clientHeight;
	
	var getwidth = parseInt($("#divChooseFriend").css("width"));
	var getheight = parseInt($("#divChooseFriend").css("height"));
	
	var topWidth = (borwerViewWidth - getwidth)/2;
	var topHeight = (htmlHeight - getheight)/ 2;
	
	
	$("#divChooseFriend").css({ "position": "absolute","z-index":"10000","top":topHeight + "px" , "left": topWidth+"px"});
	
	
	keydown();
	  
	
	}
function keydown(){
	document.onkeydown = function (e) {
            var theEvent = window.event || e;
            var code = theEvent.keyCode || theEvent.which;
            if (code == 13) {
                enterclick();
            }
	}
}

function enterclick(){
	$("#leftsearch").show();
	}
</script>







<style>
/*我的代表作弹出框*/



/*美化下拉框 通用*/
	
.divdropDown{
	/*display:inline-block;*/
    position: relative;
	top:0;
	left:0;
	float:left;
	min-width: 137px;
	font-size:12px;
	}

.dropDownBox{
	background:#fcfcfc;
	border:1px solid #e8e8e8;
    cursor: pointer;
    font-family: "微软雅黑";
    font-size: 12px;
	color: #535353;
	min-width:90px;
	display:inline-block;
    height: 16px;
	padding:5px 40px 5px 5px;
    left: 0;
    position: relative;
    top: 0;
	}
.dropDownBox:hover{
	background:#fffdf1;
	border:1px solid #f09494;
	}

.dropDownBox .dropDownBoxR{
	border-left: 1px solid #E4E8EB;
    height: 16px;
    position: absolute;
    right: 0;
    top: 6px;
    width: 30px;
	}

.dropDownBox .dropDownBoxR i {
    background:url(${pageContext.request.contextPath}/public/images/select_bi.png) 0 0 no-repeat;
    height: 10px;
    left: 11px;
    position: absolute;
    top: 6px;
    width: 10px;
	_top:-4px;
	_background:url(${pageContext.request.contextPath}/public/images/select_bi.png) no-repeat 0 10px;
	}
.dropDownBox:hover .dropDownBoxR i{
	background:url(${pageContext.request.contextPath}/public/images/select_bi.png) no-repeat 0 -10px;
	}	




.dropDownBoxValue{
    background:  #FFFFFF;
    border: 1px solid #E8E8E6;
	border-top:0;
    display: none;
    left: 0;
    position: absolute;
    top: 28px;
    width: 134px;
	max-height:300px;
	overflow-y:auto;
	overflow-x:hidden;
	}
.dropDownBoxValue .dropValue{
	cursor:pointer;
	display:block;
	color:#788F72;
	width:125px;
	height:25px;
	line-height:22px;
	padding-left:10px;
	overflow:hidden;
}	
.dropDownBoxValue .dropValue:hover{
	color:#000000;
	background:#F0F0F0;
	}






.dropDownBox:hover input{
	background:#fffdf1;
	}
.dropDownBox input{
	cursor:pointer;
	width: 90px;
	border:0;
	background:#fcfcfc;
	color: #696969;
	font-family: "微软雅黑";
	}
/*美化下拉框 通用*/
*{margin:0;padding:0;}
li{list-style: none;}
img{border:0;}
body{
	background:#000;
	}
.chooseFriend{
	background:#ffffff;
	width:875px;
	height:765px;
	font-size:12px;
	color:#8b8b8b;
	}
.chooseFriend .top{
    background:#F6F6F6;
    border-bottom: 1px solid #E3E3E3;
    height: 57px;
    left: 0;
    position: relative;
    top: 0;
    width: 875px;
	}
.chooseFriend .top h2 {
    color: #585858;
    font-family: "微软雅黑";
    font-size: 22px;
    font-weight: normal;
    height: 58px;
    line-height: 58px;
    padding-left: 30px;
	text-align:left;
	}

.chooseFriend .top a {
    background:url(${pageContext.request.contextPath}/public/images/closeBox.png) 0 0 no-repeat;
    height: 58px;
    position: absolute;
    right: 0;
    top: 0;
    width: 58px;
	}
.chooseFriend .top a:hover{
	background:url(${pageContext.request.contextPath}/public/images/closeBox.png) no-repeat 0 -58px;
	}
.chooseFriend .top a:active{
	background:url(${pageContext.request.contextPath}/public/images/closeBox.png) no-repeat 0 -116px;
	}
	
	
	
	
.chooseFriend .option{
	margin-top:27px;
    height: 40px;
    left: 0;
    position: relative;
    top: 0;
    width: 850px;
	padding-left:25px;
	text-align:left;
	z-index:100;
	}
.chooseFriend .option table .divdropDown{
	padding-right:15px;
	}
.option .divSearch{
	left: 0px;
    position: relative;
    top: 0px;
	height: 30px;
	width: 245px;
	}
.option .divSearch .search {
    background:#fcfcfc;
    border: 1px solid #e8e8e6;
    border-radius: 3px;
    color: #696969;
    font-family: "微软雅黑";
    font-size: 12px;
    /*height: 18px;*/
    padding: 5px 30px 5px 15px;
    width: 240px;
	}
.option .divSearch .icosearch{
	cursor:pointer;
	right: 10px;
    position: absolute;
    top: 5px;
	width: 20px;
	height: 20px;
	background:url(${pageContext.request.contextPath}/public/images/search.png) 0 -10px no-repeat;
	}
.option .divSearch .icosearch:hover{
	background:url(${pageContext.request.contextPath}/public/images/search.png) 0 -51px no-repeat;
	}



	
	
	
	
	
	



.chooseFriend .submit{
    height: 50px;
    left: 0;
    position: relative;
    top: 0;
    width: 875px;
	margin-top:40px;
	}

.chooseFriend .submit .reset {
	right: 240px;
    position: absolute;
    top: 0;
    background: url(${pageContext.request.contextPath}/public/images/buttonGroup01.png) no-repeat 0 -836px;
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
.chooseFriend .submit .reset:hover{
	background: url(${pageContext.request.contextPath}/public/images/buttonGroup01.png) no-repeat 0 -872px;
	}
.chooseFriend .submit .reset:active{
	background: url(${pageContext.request.contextPath}/public/images/buttonGroup01.png) no-repeat 0 -908px;
	}
.chooseFriend .submit  .sub {
	right: 73px;
    position: absolute;
    top: 0;
    background: url(${pageContext.request.contextPath}/public/images/buttonGroup01.png) no-repeat 0 -718px;
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
	}
.chooseFriend .submit  .sub:hover{
	background: url(${pageContext.request.contextPath}/public/images/buttonGroup01.png) no-repeat 0 -754px;
	}
.chooseFriend .submit  .sub:active{
	background: url(${pageContext.request.contextPath}/public/images/buttonGroup01.png) no-repeat 0 -790px;
	color: #D6D6D6;
	text-shadow: 1px 1px 1px black;
	}




	

.divContent{ 
	height: 494px;
    left: 0;
    position: relative;
    top: 0;
    width: 850px;
	padding-left:25px;
	/*margin-top:10px;*/
	}
.divContent .left{
	width: 390px;
	height: 494px;
	overflow-y:auto;
	overflow-x:hidden;
    left: 0;
    position: relative;
    top: 0;
	border:1px solid #e3e3e3;
	}

.divContent  li{
	width: 390px;
	height: 54px;
    left: 0;
    position: relative;
    top: 0;
	border-bottom:1px solid #e3e3e3;
	}
.divContent  li:hover,
.divContent  .active{
	background:#f3f3f3;
	}
.divContent  li .headImg{
	width: 60px;
	height: 54px;
    left: 0;
    position: absolute;
    top: 0;
	}
.divContent  li .headImg .headImgCon{
	width: 40px;
	height: 40px;
    left: 9px;
    position: absolute;
    top: 7px;
	}
.divContent  li .headImg .head{
	width: 40px;
	height: 40px;
	left: 0;
    position: absolute;
    top: 0;
	}
.divContent  li .headImg .radius{
	width: 40px;
	height: 40px;
	left: 0;
    position: absolute;
    top: 0;
	}	
.divContent  li .info{
	width: 270px;
	height: 54px;
    left: 60px;
    position: absolute;
    top: 0;
	}
.divContent  li .info .name{
	height: 30px;
	line-height: 30px;
	color:#000;
	font-family:"微软雅黑";
	font-size:14px;
	}
.divContent  li .info .detail{
    left: 0;
    position: relative;
    top: 0;
	}
.divContent  li .info .detail a {
    color: #A0A0A0;
	text-decoration:none;
	}
.divContent  li .info .detail .userPositionName{
    background:url(${pageContext.request.contextPath}/public/images/11.png) no-repeat 0 -95px;
    padding-left: 20px;
	padding-top:2px;
	padding-bottom:2px;
	}
.divContent  li .info .detail .userPositionAddress{
    background:url(${pageContext.request.contextPath}/public/images/11.png) no-repeat 0 -114px;
	margin-left: 10px;
    padding-left: 18px;
	padding-top:2px;
	padding-bottom:2px;
	}
.divContent  li .info .detail .userPositionAddress .shi{
	margin-left:8px;
	}	
.divContent  li .info .detail .pstype{
    left: 170px;
    position: absolute;
    top: 0;
	}
.divContent  li .info .detail .pstype .bar {
    color: #b09d7c;
    float: left;
    font-size: 12px;
    height: 18px;
    left: 0;
    margin-right: 15px;
    padding-left: 10px;
    position: relative;
    top: 0;
	background:url(${pageContext.request.contextPath}/back/pubimg/images/background.png) 0 0px no-repeat;
	}
.divContent  li .info .detail .pstype .bar i {
    position: absolute;
    right: -11px;
    top: 0;
	width:12px;
	height:18px;
	background: url(${pageContext.request.contextPath}/back/pubimg/images/background.png) no-repeat 0px -89px;
	}	
.divContent  li .check {
    background:url(${pageContext.request.contextPath}/back/pubimg/images/background.png) no-repeat scroll -144px -106px rgba(0, 0, 0, 0);
    height: 20px;
    position: absolute;
    right: 26px;
    top: 16px;
    width: 20px;
	}



.divContent .right{
	width: 390px;
	height: 494px;
	overflow-y:auto;
	overflow-x:hidden;
    right: 30px;
    position: absolute;
    top: 0;
	border:1px solid #e3e3e3;
	}
.divContent .right li .check {
	display:none;
	cursor:pointer;
    background:url(${pageContext.request.contextPath}/back/pubimg/images/background.png) no-repeat scroll -119px -106px rgba(0, 0, 0, 0);
    height: 20px;
    position: absolute;
    right: 16px;
    top: 16px;
    width: 20px;
	}
.divContent .right li:hover .check{
	display:block;
	}
.chooseFriend .divHaveFriend{
	height:30px;
	padding-left:26px;
	}
.chooseFriend .divHaveFriend .left{
	width:433px;
	height:30px;
	float:left;
	}
.chooseFriend .divHaveFriend .left .search{
	width:370px;
	height:30px;
	padding-left:20px;
	line-height:30px;
	background:#f3f3f3;
	color:#af9c7e;
	display:none;
	}
.chooseFriend .divHaveFriend .right .havechoose{
	color:#000;
	font-size:16px;
	font-family:"微软雅黑";
	margin-right:170px;
	}
</style>
  </head>
  
  <body>
   

 <!--代表作品弹出框-->
    <div class="chooseFriend" id="divChooseFriend">
    	<input type="hidden" id="hiddenv" />
    	<div class="top">
    		<h2>选择邀请好友</h2>
			<a href="javascript:cloosePopBox();"></a>
    	</div>    
    	<div class="option">
				<table>
                	<tr>
                        <td>
                        	<div class="divdropDown">
                    			<div class="dropDownBox" onclick="showBelow('divdropDownAttention')">
                    				<span id="divdropDownViewAttention">我的关注列表</span>
                        			<div class="dropDownBoxR"><i></i></div>
                    			</div>
                    
                    			<div class="dropDownBoxValue" id="divdropDownAttention">
                    				<span class='dropValue'>我的关注列表我的关注列表</span>
                        			<span class='dropValue'>我的关注列表</span>
                    			</div>
                  			</div>
                        </td>
                        
                        <td>
                        	<div class="divdropDown">
                    			<div class="dropDownBox" onclick="showBelow('divdropDownJobType')">
                    				<span id="divdropDownViewJobType">职业类型</span>
                        			<div class="dropDownBoxR"><i></i></div>
                    			</div>
                    
                    			<div class="dropDownBoxValue" id="divdropDownJobType">
                    				<span class='dropValue'>职业类型</span>
                        			<span class='dropValue'>职业类型</span>
                    			</div>
                  			</div>
                        </td>
                        <td>
                        	<div class="divSearch">
                				<input class="search" type="text" onfocus="if(this.value=='查找好友') this.value='';this.style.color='#333'" onblur="if(this.value=='') {this.value='查找好友';this.style.color='#7f7f7f'}" value="查找好友">
                    			<i class="icosearch" onclick="enterclick();"></i>
                			</div>
                        </td>
                        
                    </tr>
                </table>
    	</div>
    	
        <div class="divHaveFriend">
        	<div class="left" id="divHaveFriendLeft">
            	<div class="search" id="leftsearch">
                	以下是”<span></span>“的<span>8</span>条搜索结果
                </div>
            </div>
        	<div class="right">
            	<span class="havechoose">已邀请好友列表</span>
                <span>已选择</span><span>45</span>人
            </div>
        </div>
        <div class="divContent">
        	<div class="left" id="clickLeft">
            	<ul>
            	<s:iterator value="pager.resultList">
                	<li>
                    	<div>
                        	<div class="headImg">
                            	<div class="headImgCon">
                            	
                            		<img src="<s:property value="portrait"/>" class="head"/>
                                	<img src="${pageContext.request.contextPath}/back/pubimg/images/radHead.png" class="radius"/>
                                </div>
                            </div>
                        	<div class="info">
                            	<div class="name">
                            	<s:property value="nickName"/>
                            	</div>
                            	<input type="hidden" value='<s:property value="id"/>' class="userId">
                                <div class="detail">
                            		<a class="userPositionName" title="年龄"><span><s:property value="age"/></span>岁</a>
                                	<a class="userPositionAddress" title="地址"><span>
                                	<s:property value="workPlace"/>
                                	</span></a>
            						<a class="pstype" title="职业"><div class='bar active'><span><s:property value="userCat.name"/></span><i></i></div></a>
                                </div>
                            </div>
                            
                        </div>
                        
                    </li>
                    	</s:iterator>

                </ul>
            </div>
        
        	<div class="right" id="clickRight">
            	<ul id="clickRightUL">
                	
                </ul>
            </div>
        
        </div>
        
            
                
            
        <div class="submit">
        	<input class="reset" type="button" value="取消"  onclick="cloosePopBox();"/>
			<input class="sub" type="button" value="确认选择" onclick="submitPopBox();"/>
    	</div>
    </div>
  </body>
</html>
