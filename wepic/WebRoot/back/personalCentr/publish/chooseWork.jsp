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
<title>选择作品</title>

<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/jquery.js"></script>
<script type="text/javascript" src='${pageContext.request.contextPath}/back/js/jquery.slider.js'></script>
<script type="text/javascript" src="<%=basePath %>back/chajian/jquery.ocupload-1.1.2.js"></script>
<script>
$(document).ready(function(){ 
	$("#picurls").val("");
	$("#picIds").val("");
	divLiBar("divCheckPic");				//查看头像

	achieveBelow2("divSelectPicValue","selectPicValue");		/*获取下拉框值并隐藏	图片作品*/

	achieveBelow("divSelectSpecialValue","selectSpecialValue");		/*获取下拉框值并隐藏	选择专辑*/
	
	divClickBar("divViewRe");
	
});

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
        	   crop();
				}
	});

    var pa=$("#fileipload").parent();
    var file=$(pa).find("input");
    $(file).css({"position":"absolute"});
     $(file).css({"z-index":"1000"});
     $(pa).css({"width":"230px"});
     $(pa).css({"height":"60px"});
     $(pa).css({"float":"right"});
     $(file).css({"float":"right"});

     
});
/*关闭弹出框*/
function cloosePopBox(){
	window.parent.closeOwnBox();
	//alert("s's's");
	var openPop = document.getElementById("hiddenv").value;
	window.parent.openPopUpBox(openPop);
	
}
/*关闭弹rr出框*/


/*提交信息并返回前一个页面*/
function submitPopBox(){
	
	window.parent.closeOwnBox();
	
	var openPop = document.getElementById("hiddenv").value;
	window.parent.openPopUpBox(openPop);
	window.parent.closeOwnBox();
	$("#opusIds", window.parent.document).val($("#picIds").val());
	$("#opusurls", window.parent.document).val($("#picurls").val());
	//window.location.reload();
	window.parent.chaifen();
	
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
				var id=$(this).attr("id");
				$("#"+id+"a").remove();
				delHiddenInput(id)
				
				}
			else{
				$(this).addClass("active");
				var id1=$(this).attr("id");
				//获得图片的url
				var tupurls=$(this).find('img').attr("src");
				//获得图片对应Id;
				var id=$(this).find('input').val()
			    var picurls=$("#picurls").val();
			    var picIds=$("#picIds").val();
			    
			    if(picurls==null||picurls==""){
			    	picurls=tupurls;
				    }
			    else{
			    	picurls+=" "+tupurls;
				    }
			    
			    if(picIds==null||picIds==""){
			    	picIds=id;
				    }
			    else{
			    	picIds+=" "+id;
				    }
			   
			    $("#picurls").val(picurls)
			    $("#picIds").val(picIds)
				$(".slider-move").append("<li id="+id1+"a>"+$(this).html()+"</li>");
				divLiBar("divCheckPic");
				var num=$(".slider-move li").length;
				$(".slider-move").css({"width":num*132});
				// alert(num);	
				//  addInit();
				 // 给新增的图片添加onclick事件
				 delPic();
				}
		};
		}
	}
	
	function delPic(){
     $(".slider-move a").each(function(){
    	    $(this).click(function(){
    	    	var orgId=$(this).parents("li").attr("id");
    	    	 delHiddenInput(orgId);
    	    	var ids=orgId.split("a");
    	    	$("#"+ids[0]).removeClass("active");
        	    $(this).parents("li").remove();
        	   
    	    });
     });
		}


	function delHiddenInput(orgId){
		// alert("死死死死死死");
   var id= $("#"+orgId).find('input').val();
   var pic= $("#"+orgId).find('img').attr('src');
   var picurls=$("#picurls").val().split(" ");
   var picIds=$("#picIds").val().split(" ");
   var newpicurls="";
   var newpicIds="";
   for(var i=0;i<picurls.length;i++){
   if(picurls[i]!=pic){
	   if(newpicurls==""){
		   newpicurls=picurls[i];
		   }else{
		newpicurls+=" "+picurls[i];
			   }

	   }
   }

   for(var i=0;i<picIds.length;i++){
	   if(picIds[i]!=id){
		   if(newpicIds==""){
			   newpicIds=picIds[i];
			   }else{
				   newpicIds+=" "+picIds[i];
				   }

		   }
	   }

   var picurls=$("#picurls").val(newpicurls);// .split(" ");
   var picIds=$("#picIds").val(newpicIds);// .split(" ");

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
	






$(function(){
	  var sp='<s:property value="specialName" escape="false" />';
	  if(sp==''){
      sp="默认专辑";
		  }
	 // alert($("#selectSpecialValue").html(sp));// selectSpecialValue
     $("#selectSpecialValue").html(sp);
   // alert("ssss");
	$.ajax({
	      type:"Post",
		  url: "specialcat_getpublishSpecialCats.do",
		  data:"",		
		  success : function(data) {  
	  	  var list=data.publishSpecialCats;
	  	  var html='';
	  	  for(var i=0;i<list.length;i++){
	  	  	  publishCat=list[i];
	  		  html+='<span class="selectValueIn" id='+publishCat.id+'>'+publishCat.name+'</span>';
	  	  	  } 
          // selectdespecialValue   divSelectSpecialValue
	  	     $("#divSelectSpecialValue").html(html);
	  	     achieveBelow("divSelectSpecialValue","selectSpecialValue");
	  		   
		  }
	});

   $("#divSelectSpecialValue").find("span").each(function(){
           $(this).click(function(){
              
        	 //  getCat($(this).attr("id"));
        	 $("#publishParentTypeId").val($(this).attr("id"));
        	 $("#publishParentTypeName").val(this.innerHTML);
        	 $("#publishTypeId").val("");
        	 $("#publishTypeName").val("");
        	//  alert(this.innerHTML);  
        	 // selectdeCategoryValue 
        	 $("#selectSpecialValue").html(this.innerHTML);
 			 $("#divSelectSpecialValue").hide();
 			  searchByterm();
 			// $("#divSelectdeCategoryValue").parent().parent().css("z-index","0");//rrrr
             });


       });
      //  searchByterm();

     $("#divSelectdeStateValue").find("span").each(function(){
      $(this).click(function(){
          $("#publishStaute").val($(this).attr("id"));
          $("#publishStauteName").val($(this).html());
          $("#selectdeStateValue").html($(this).html());
          $("#divSelectdeStateValue").hide();
          searchByterm();
          });
         });
        searchBack();
     


   
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
	           html+='<span class="selectValueIn" onclick="hideType(this)" id='+cat.id+'>'+cat.name+'</span>';
	             }
	          $("#divSelectPictureValue").html(html);
	          
	         // $("#divAddReTagPersonrr").html("");ssss
				// $("#hiddenReTassgs").val("");ee sss
				    
			  }
		});
}


function achieveBelow(bolewDiv,showValue){
	var bolewDiv=document.getElementById(bolewDiv);
	var bolewDivSpan=bolewDiv.getElementsByTagName("span");
	/*alert("11");*/
				
	for(var i=0;i<bolewDivSpan.length;i++){
		   bolewDivSpan[i].onclick=function (){
			

			 $("#specalCatId").val($(this).attr("id"));
        	 $("#specialName").val(this.innerHTML);
        	 searchByterm();
			//swfupload.addPostParam("publishSpecialCatIssd",$(this).attr("id"))ss
			
			$("#"+showValue).html(this.innerHTML);
			$(bolewDiv).hide();
			$(bolewDiv).parent().parent().css("z-index","0");
			};
		}
}

function achieveBelow2(bolewDiv,showValue){
	var bolewDiv=document.getElementById(bolewDiv);
	var bolewDivSpan=bolewDiv.getElementsByTagName("span");
	/*alert("11");*/
				
	for(var i=0;i<bolewDivSpan.length;i++){
		   bolewDivSpan[i].onclick=function (){
			

			 $("#publishParentTypeId").val($(this).attr("id"));
        	 $("#publishParentTypeName").val(this.innerHTML);
        	 searchByterm();
			//swfupload.addPostParam("publishSpecialCatIssd",$(this).attr("id"))ss
			
			$("#"+showValue).html(this.innerHTML);
			$(bolewDiv).hide();
			$(bolewDiv).parent().parent().css("z-index","0");
			};
		}
}
function hideType(obj){
$("#selectdeTypeValue").html($(obj).html());
$("#divSelectdeTypeValue").hide();
$("#publishTypeId").val($(obj).attr("id"));
$("#publishTypeName").val($(obj).html());
searchByterm();
} 
//提交查询
function searchByterm(){
    $("#searchByTermfromMylib").submit();
    }
function searchBack(){
 

 var type='<s:property value="publishParentTypeName"/>';
 if(type==''){
	 type="所有类型";
     }
 $("#selectPicValue").html(type);


	 }
//ddd


</script>


<style>
/*我的代表作弹出框*/

*{margin:0;padding:0;}
li{list-style: none;float:left;}
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
    background:url(${pageContext.request.contextPath}/public/images/closeBox.png) 0 0 no-repeat;
    height: 58px;
    position: absolute;
    right: 0;
    top: 0;
    width: 58px;
	}
.rework .top a:hover{
	background:url(${pageContext.request.contextPath}/public/images/closeBox.png) no-repeat 0 -58px;
	}
.rework .top a:active{
	background:url(${pageContext.request.contextPath}/public/images/closeBox.png) no-repeat 0 -116px;
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
.rework .submit .reset:hover{
	background: url(${pageContext.request.contextPath}/public/images/buttonGroup01.png) no-repeat 0 -872px;
	}
.rework .submit .reset:active{
	background: url(${pageContext.request.contextPath}/public/images/buttonGroup01.png) no-repeat 0 -908px;
	}
.rework .submit  .sub {
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
	letter-spacing: 15px;
    padding-left: 20px;
	}
.rework .submit  .sub:hover{
	background: url(${pageContext.request.contextPath}/public/images/buttonGroup01.png) no-repeat 0 -754px;
	}
.rework .submit  .sub:active{
	background: url(${pageContext.request.contextPath}/public/images/buttonGroup01.png) no-repeat 0 -790px;
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
	background:url(${pageContext.request.contextPath}/back/pubimg/images/select_bi.png) no-repeat 0 0px;
	_background:url(${pageContext.request.contextPath}/back/pubimg/images/select_bi.png) no-repeat 0 10px;
	}
.viewBelow:hover .viewBelowRight i{
	background:url(${pageContext.request.contextPath}/back/pubimg/images/select_bi.png) no-repeat 0 -10px;
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
	background:url(${pageContext.request.contextPath}/public/images/search.png) 0 -10px no-repeat;
	}
.workAbstractRe .divSearch .icosearch:hover{
	background:url(${pageContext.request.contextPath}/public/images/search.png) 0 -51px no-repeat;
	}
.workAbstractRe  .upload {
    background: url(${pageContext.request.contextPath}/public/images/buttonGroup01.png)scroll 0 -482px;
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
    background: url(${pageContext.request.contextPath}/public/images/buttonGroup01.png)scroll 0 -518px;
	}
.workAbstractRe  .upload:active {
    background: url(${pageContext.request.contextPath}/public/images/buttonGroup01.png)scroll 0 -554px;
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
	background:url(${pageContext.request.contextPath}/back/pubimg//images/editdel.png) 0 -66px no-repeat;
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
	background:url(${pageContext.request.contextPath}/back/pubimg/images/checked.png) 0 0 no-repeat;
    
    width: 55px;
    height: 55px;
    left:35px;
    position: absolute;
    top: 35px;
	}	
	
</style>


<script type="text/javascript">
		$(function(){
		
			$('.slider-box').mySlider({  //参数可选,以下为默认参数
					speed: 300,
					direction: 'left', //  运动方向 可选 left,top
					prevClass: 'slider-prev',			//左边
					nextClass: 'slider-next',			//右边
					wrapperClass: 'slider-wrapper',
					moveClass: 'slider-move'
			});
			// alert("sssssss")
		});
	</script>
	
	
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
    	 <form action="searchPublishPic!searchByTermfromMylibforUser.do" method="post" id="searchByTermfromMylib">
            	<input type="hidden" name="specalCatId"  id="specalCatId" value="<s:property value="specalCatId"/>"/>
            	<input type="hidden" name="specialName"  id="specialName" value="<s:property value="specialName"/>"/>
            	<input type="hidden" name="publishParentTypeId"  id="publishParentTypeId" value="<s:property value="publishParentTypeId"/>"/>
            	<input type="hidden" name="publishParentTypeName"  id="publishParentTypeName" value="<s:property value="publishParentTypeName"/>"/>
            	<input type="hidden" name="publishTypeId"  id="publishTypeId" value="<s:property value="publishTypeId"/>"/>
            	<input type="hidden" name="publishTypeName"  id="publishTypeName" value="<s:property value="publishTypeName"/>"/>
            	<input type="hidden" name="publishStaute"  id="publishStaute" value="<s:property value="publishStaute"/>"/>
            	<input type="hidden" name="publishStauteName"  id="publishStauteName" value="<s:property value="publishStauteName"/>"/>
            	</form>
            	
				<div class="editSelect" id="divWorkType" >
                    	<div class="viewBelow" onclick="showBelow('divSelectPicValue')">
                        	<div id="selectPicValue">请选择类别</div>
                       		<div class="viewBelowRight"><i></i></div>    
                    	</div>
                           
                    	<div  class="belowValue" id="divSelectPicValue" style="display:none;">
                    	   <span class='selectValueIn'>所有类别</span>
                        	<span class='selectValueIn' id="2">创意图片</span>
                            <span class='selectValueIn' id="3">摄影图片</span>
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
                
             <input class="upload" type="button" value="本地上传" id="fileipload3" onclick="top.location.href='${pageContext.request.contextPath}/back/personalCentr/myworklib/workUpload.jsp'"/>
    	</div>
    	<div class="chooseWork">
    		
            
            <div class="viewHead" id="divViewRe">
            	<ul>
                	
                
                    
                    
                  <s:iterator value="pager.resultList">
                  
                    <li id="<s:property value="id"/>l">
                    	<div class="img">
                    	<a href="javascript:;"><img src="<s:property value="thumbnail125"/>"/></a>
                    	<input type="hidden"  id="orgId" value="<s:property value="id"/>"/>
                    	
                    	
                    	</div>
                        <div class="nowtop">
                        	<div class="bj"></div>
                        	<div class="bjc">
                        	<a href="javascript:" class="check"></a></div>
                        </div>
                    </li>
                 </s:iterator>
             
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
            	<ul class='slider-move' style="width:auto;">
                	
                	
           
                </ul>
            </div>
            <a href='javascript:;' class="slider-next slider-btn" title="下一张"></a>
            </div>
        </div>    
            
        <div class="submit">
        <input type="hidden" id="picIds" value="" />
        <input type="hidden" id="picurls" value="" />
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
			background: url(${pageContext.request.contextPath}/back/pubimg/images/changePage.png) no-repeat;
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
   
    <!--代表作品弹出框-->
</body>
</html>
