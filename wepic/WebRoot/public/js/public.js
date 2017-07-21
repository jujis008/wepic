$(function(){
//document.getElementById("inputselect").value="选择类型";		//刷新默认为请选择类型

divLiBar("serverShare");   //分享背景

goTopEx();					/* 回顶部 */

lowBrowser();			/* ie6友情提示 */

});

/* active 动作*/
function divLiBar(divName){
	var mainDiv=document.getElementById(divName);
	var allMainBarLi=mainDiv.getElementsByTagName("li");
	
	for(var i=0;i<allMainBarLi.length;i++){
		allMainBarLi[i].onmouseover = function(){
			
			for(var j=0;j<allMainBarLi.length;j++){
				allMainBarLi[j].className = "";
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

/* active 动作	恢复默认样式*/
function divLiBar2(divName){
	var mainDiv=document.getElementById(divName);
	var allMainBarLi=mainDiv.getElementsByTagName("li");
	
	
	$(allMainBarLi).each(function(index, element) {
        if($(this).attr("class") == "active"){
			thisId = $(this).attr("id");
			}
    });
	
	
	var nowLi=document.getElementById(thisId);
	
	for(var i=0;i<allMainBarLi.length;i++){
		allMainBarLi[i].onmouseover = function(){
			for(var i=0;i<allMainBarLi.length;i++){
				allMainBarLi[i].className = "";
			}
			this.className="active";
		};
		allMainBarLi[i].onmouseout = function(){
			for(var i=0;i<allMainBarLi.length;i++){
				allMainBarLi[i].className = "";
			}
			nowLi.className="active";
		};
		
		
	}
}


/* active 动作	恢复默认样式*/



function userBuyCart(){
/*展开用户信息详细 */

	
	var topBarUser=document.getElementById("topBarUser");
	var topBarUserDetailed=document.getElementById("topBarUserDetailed");
		
		topBarUserDetailed.onmouseover=topBarUser.onmouseover = function(){
				topBarUserDetailed.style.display="block";
				topBarUser.className="active1";
					};
		
		topBarUserDetailed.onmouseout=topBarUser.onmouseout = function(){
			topBarUserDetailed.style.display="none";
			topBarUser.className="";
				};

	/* 展开用户信息详细 */

	
	/*展开购物车详细 */

	
	var topBarShopping=document.getElementById("topBarShopping");
	var topBarShoppingDetailed=document.getElementById("topBarShoppingDetailed");
		
		topBarShoppingDetailed.onmouseover=topBarShopping.onmouseover = function(){
				topBarShoppingDetailed.style.display="block";
				topBarShopping.className='active1';
					};
		
		topBarShoppingDetailed.onmouseout=topBarShopping.onmouseout = function(){
			topBarShoppingDetailed.style.display="none";
			topBarShopping.className='';
				};

	/* 展开购物车详细 */
}

/*弹出层*/
function openPopUpBox(divPopUpBox){
	var htmlWidth = document.body.clientWidth;
	var htmlHeight = document.body.clientHeight;
	var borwerViewWidth =  document.documentElement.clientWidth;
	var borwerViewHeight =  document.documentElement.clientHeight;
	
	var scrollTop = getScrollTop();
	
	
	var getw =$("#"+divPopUpBox).width();
	var geth = $("#"+divPopUpBox).height();
	
	if(getheight == '' || getheight == null){
		getheight = 0;
		}
		
	var getwidth = parseInt(getw);
	var getheight = parseInt(geth);
	
	var topWidth = (borwerViewWidth - getwidth)/2;
	var topHeight = (borwerViewHeight - getheight)/ 2;
	
	$("#greybackground").remove();
	$("body").prepend('<div id="greybackground" style="position:absolute; z-index:700000;background:black;display:none"></div>');
	//$("html,body").animate({ scrollTop:0},0);
	//$("html,body").css({ "overflow": "hidden"});
	$("#greybackground").css({ "opacity": "0.8", "height": htmlHeight+"px","display":"block","width": htmlWidth+"px","background":"black","top":"0px","left":"0px"});
	$("#greybackground").show();
	
	$("#"+divPopUpBox).show();
	$("#"+divPopUpBox).css({ "position": "absolute","z-index":"800000","top": scrollTop+10 + "px" , "left": topWidth+"px"});
	
	/*var qq = $("#greybackground").css("z-index");
	/*window.scrollTo(0,$(document).scrollTop());*/
	
}
function cloosePopBox(divPopUpBox){
	$("#greybackground").remove();
	$("#"+divPopUpBox).hide();
	document.body.style.overflow="auto";
}	
/*弹出层*/





/*弹出一个图片*/
function viewPic(){
	var allPic = $(".selected_work_img");
	$(allPic).each(function(index, element) {
        $(this).click(
			function(){
                
				$("#popOnlyPic").remove();
				var imgWidth = $(this).find("img").width();
				var imgHeight = $(this).find("img").height();
				
				var imgSrc = $(this).find("img").attr("src");
				var scrollTop = getScrollTop();
	
				
	
				$("body").prepend('<div id="popOnlyPic"><img id="cacheImg" src="'+imgSrc+'"></img></div>');
				
	
				var borwerViewWidth =  document.documentElement.clientWidth;
				var getwidth = parseInt($("#cacheImg").width());
				var topWidth = (borwerViewWidth - getwidth)/2;
				
				
				
				var borwerViewHeight =  document.documentElement.clientHeight;
				var getheight = parseInt($("#cacheImg").height());
				var topHeight = (borwerViewHeight - getheight)/ 2;
				
				$("#popOnlyPic").css({ "position": "absolute","z-index":"8000777","top": scrollTop+60 + "px" , "left": topWidth+"px" ,"width" : getwidth+"px","height" : getheight+"px",});
				
				
				
				var htmlWidth = document.body.clientWidth;
				var htmlHeight = document.body.clientHeight;
				$("#greybackground").remove();
				$("body").prepend('<div id="greybackground" style="position:absolute; z-index:700737;background:black;display:none"></div>');
				$("#greybackground").css({ "opacity": "0.8", "height": htmlHeight+"px","display":"block","width": htmlWidth+"px","background":"black","top":"0px","left":"0px"});
				$("#greybackground").show();
				}
		);
    });
}
	
/*弹出一个图片*/	



function getScrollTop(){
	if(document.documentElement.scrollTop)
		{return document.documentElement.scrollTop;}
	else	
		{return document.body.scrollTop}
}





/*倒计时*/
var DifferenceHour = -1
var DifferenceMinute = -1
var DifferenceSecond = -1
var Tday = new Date("2014/09/24 17:29:12")   //**截止时间-注意格式
var daysms = 24 * 60 * 60 * 1000
var hoursms = 60 * 60 * 1000
var Secondms = 60 * 1000
var microsecond = 1000 
var timeNum = 1380014898861;
function clock(){
		<!-- hide script from old browser
	var time = new Date()   //**开始时间-注意格式
	//var time = new Date()
	var hour = time.getHours()
	var minute = time.getMinutes()
	var second = time.getSeconds()

	var timevalue = ""+((hour > 12) ? hour-12:hour)
	timevalue +=((minute < 10) ? ":0":":")+minute
	timevalue +=((second < 10) ? ":0":":")+second
	timevalue +=((hour >12 ) ? " PM":" AM")

	// document.formnow.now.value = timevalue
	var convertHour = DifferenceHour
	var convertMinute = DifferenceMinute
	var convertSecond = DifferenceSecond

	var Diffms = Tday.getTime() - time.getTime()
	DifferenceHour = Math.floor(Diffms / daysms)

	Diffms -= DifferenceHour * daysms
	DifferenceMinute = Math.floor(Diffms / hoursms)

	Diffms -= DifferenceMinute * hoursms
	DifferenceSecond = Math.floor(Diffms / Secondms)

	Diffms -= DifferenceSecond * Secondms
	var dSecs = Math.floor(Diffms / microsecond)

	if(convertHour != DifferenceHour) document.formnow.dd.value=DifferenceHour
	if(convertMinute != DifferenceMinute) document.formnow.hh.value=DifferenceMinute
	if(convertSecond != DifferenceSecond) document.formnow.mm.value=DifferenceSecond
	document.formnow.ss.value=dSecs
	// document.formnow.Tnow.value= DifferenceHour DifferenceMinute + DifferenceSecond + dSecs
	setTimeout("clock()",1000)
} 

/*倒计时*/


/* 回顶部 */
function goTopEx(){
	
    var aHeight = window.screen.availHeight; //   获取客户端分辨率的高度
	
    var sHeight = document.body.scrollHeight; //    获取浏览器的高度
	//alert(sHeight);
        var obj=document.getElementById("goTopBtn");
		//要获取当前页面的滚动条纵坐标位置
        function getScrollTop(){
			if(document.documentElement.scrollTop)
            	{return document.documentElement.scrollTop;}
			else	
				{return document.body.scrollTop}
            }
		//判断
        window.onscroll = function(){
			getScrollTop() > 0 ? obj.style.display="" : obj.style.display="none";
			//$("#qqq").val(getScrollTop());
			//moveTips(obj);
			//getScrollTop() >= sHeight-aHeight-50 ?  $("#goTopBtn").css("bottom",getScrollTop()-aHeight+440+"px") :  $("#goTopBtn").css("bottom","80px");
			}
		
		//window.onscroll = function(){getScrollTop() > 0 ? obj.style.display="" : obj.style.display="none";}
		
        function setScrollTop(value){
			if(document.documentElement.scrollTop){
				//alert(value);
				document.documentElement.scrollTop = value;}
			else	
				{document.body.scrollTop = value;}
            }    
		
		
		
        obj.onclick = function(){
            var goTop=setInterval(scrollMove,10);
            function scrollMove(){
                    setScrollTop(getScrollTop()/1.1);
			
                    if(getScrollTop()<1)clearInterval(goTop);
                }
        }
    }
	
/* 回顶部 */



/////跟着滚动条的高度
//var tips; 
var theTop = 100; /*这是默认高度,越大越往下*/
var old = theTop;

function moveTips(tips) {
    var tt = 0;
    if (window.innerHeight) {
        pos = window.pageYOffset
    } else if (document.documentElement && document.documentElement.scrollTop) {
        pos = document.documentElement.scrollTop
    } else if (document.body) {
        pos = document.body.scrollTop;
    }

    pos = pos - tips.offsetTop + theTop;
    pos=tips.offsetTop+pos/10;
    if (pos < theTop) pos = theTop;
    if (pos != old) {
        tips.style.top = pos+"px";
        tt = 0;
    }
    old = pos;
    setTimeout(moveTips,tt);
}
/////跟着滚动条的高度





/* 获取非行间样式 */
function getStyle(obj,name){

if(obj.currentStyle){
        return obj.currentStyle[name]
            }
else{
    return getComputedStyle(obj,false)[name]
        }
}
/* 获取非行间样式 */

/*低版本浏览器提示*/
function lowBrowser(){
	
	
	if (window.ActiveXObject) {
 		var ua = navigator.userAgent.toLowerCase();
  		var ie=ua.match(/msie ([\d.]+)/)[1]
		if(ie==6.0){
			var remindIE="";
			remindIE='<div id="divRemindIE" style="width:100%;height:40px;line-height:40px;background:#FFFF9B;font-size:15px;color:#BA903A;position:relative;top:0px;left:0px;font-family:宋体;"><font>您的浏览器版本过低，为了您的财产安全，及获得更佳的浏览体验，建议您</font><a href="http://windows.microsoft.com/zh-cn/windows/upgrade-your-browser" target="_blank" style="text-decoration:underline;">立即升级</a>浏览器！</div>';
			$("#topbar").append(remindIE);	
			$("#topBar").css("height","80px");
			/*alert("您的浏览器版本过低，在本系统中不能达到良好的视觉效果，建议你升级到ie8以上！");
			window.close();*/
		}
	}
}

/*低版本浏览器提示*/

// 判断是否IE浏览器
function iehover(){
	
if(document.all){ 
	var obj=document.all;
	for(var i=0;i<obj.length;i++){
		obj[i].onmouseover=function(){
			this.className='hover';
		};
		obj[i].onmouseout=function(){
			this.className='';
		};
	}
	}
}

/*达到图片数显示分页*/
function judgeLi(obj,num){
	var allli = $("#"+obj).find("li");
	if(allli.length > num){
		$(".ppointPagingthis").show();
		}
	}
/*达到图片数显示分页*/

//验证是否为空和长度
function promptInfo(obj,addToDiv,length){
	
	$("#"+addToDiv).children().remove();			//先清空当前div里元素
	var option = "";
	var promptInfo = "";
	var len = length/2;
	
	
	var val = $("#"+obj).val();
	var byteCount = getByteCount(val);
	
	/*alert(length+byteCount);*/
		if(val == "" || val == null){
			promptInfo = "标题不能为空";
			addpromptInfo(promptInfo,addToDiv);			//增加div
			return;
			}
		
		else if(byteCount > length){
			promptInfo = "";
			promptInfo = "标题长度不能超过"+len+"字";
			
			addpromptInfo(promptInfo,addToDiv);			//增加div
			return;
			}	
}
//验证长度
function promptlength(obj,addToDiv,length){
	
	$("#"+addToDiv).children().remove();			//先清空当前div里元素
	var option = "";
	var promptInfo = "";
	var len = length/2;
	
	
	var val = $("#"+obj).val();
	var byteCount = getByteCount(val);
	
	if(byteCount > length){
			promptInfo = "";
			promptInfo = "长度不能超过"+len+"字";
			
			addpromptInfo(promptInfo,addToDiv);			//增加div
			return;
			}	
}
//验证长度

function addpromptInfo(promptInfo,addToDiv){
	option = "<div class='divprompt'><span>"+promptInfo+"</span></div>";
	$("#"+addToDiv).append(option);
	}	
 /*字节不超过	*/
function getByteCount(str){
	return str.replace(/[^\x00-\xff]/g, "**").length;
	}
 
/*字节不超过	*/


/* active 动作	---jquery*/
function hoverAddClass(divName){
	var allLi=$("#"+divName).find("li");
	$(allLi).each(function(){
			$(this).hover(
				function(){$(this).addClass("active");},
				function(){$(this).removeClass("active");}
			);
    });	
}
/* active 动作		---jquery*/



/* click 动作		jquery*/
function divLiBarClick(divName){
	var allMainBarLi=$("#"+divName).find("li");
	
	$(allMainBarLi).each(function(){
			$(this).click(function(){
				var allMainBarLi=$("#"+divName).find("li").each(function() {$(this).removeClass("active");});
				$(this).addClass("active");
			});	
    });	
}
/* click 动作		jquery*/


// 判断是否IE浏览器


/*function IE6BorwerPNG(){
	if (window.ActiveXObject) {
 		var ua = navigator.userAgent.toLowerCase();
  		var ie=ua.match(/msie ([\d.]+)/)[1]
		if(ie==6.0){
			document.write("<script src='DD_belatedPNG_0.0.8a.js'><\/script>");
			 DD_belatedPNG.fix('div, ul, img, li, input , a');
		}
	}
}*/


/*更换头像*/
function changeHead(div,viewDiv){
	$('#'+div).hover(
		function(){
			$('#'+viewDiv).stop().fadeTo('slow',1);
		},
		function(){
			$('#'+viewDiv).stop().fadeTo('slow',0);
		});
}
/*更换头像*/



/*选项卡*/
function tabControl(chooseDiv,viewDiv){
        var cardLi=$("#"+chooseDiv).find('li');
		
		var viewLi=$("#"+viewDiv).find('li');

		for(var i=0;i<cardLi.length;i++){  //循环历遍onclick事件
            cardLi[i].index=i; //input[0].index=0 index是自定义属性
            cardLi[i].onclick = function(){
               for(var i=0;i<cardLi.length;i++){  //循环历遍去掉button样式和把div隐藏
                  cardLi[i].className='';
                  viewLi[i].style.display='none';
               };
               this.className='active';  //当前按钮添加样式
               viewLi[this.index].style.display='block';  //div显示 this.index是当前div 即div[0]之类的
           };
         };
}
	

/*选项卡*/






/* click 动作		jquery*/
function addActiveByClass(divName,classname){
	var allMainBarLi=$("#"+divName).find("."+classname);
	
	$(allMainBarLi).each(function(){
			$(this).click(function(){
				var allMainBarLi=$("#"+divName).find("."+classname).each(function() {$(this).removeClass("active");
				});
				$(this).addClass("active");
			});	
    });	
}





/*倒计时*/






/*返回上一页*/
function backToPrevious(){
	$(".backToPrevious").click(function(){
			history.go(-1);
			});
}

/*返回上一页*/


/*验证字数限制 剩余字数*/
function checktext(text){
   	allValid = true;
   	for (i = 0; i < text.length; i++){
   		if (text.charAt(i) != " "){
     		allValid = false;
     		break;
    	}
   }
	return allValid;
}

function gbcount(message,total,used){
	var max;
	max = total.value;
	if (message.value.length > max) {
		message.value = message.value.substring(0,max);
		used.value = max;
		
	}
	else {
		used.value = message.value.length;
	}
}
/*验证字数限制 剩余字数*/




/*验证字数限制*/
function getByteCount(str){
	return str.replace(/[^\x00-\xff]/g, "**").length;
	}
	var value;

function checkwords(obj,length){
	if(getByteCount(obj.value)>length){
		obj.value=value;
	}
	value=obj.value
	}
/*验证字数限制*/


/*发布约拍页面位置*/
function weizhi(){
	var aWidth = window.screen.availWidth; //   获取客户端分辨率的宽度
    var aHeight = window.screen.availHeight; //   获取客户端分辨率的高度
    var sWidth = document.body.scrollWidth; //    获取浏览器的宽度
    var sHeight = document.body.scrollHeight; //    获取浏览器的高度
    var tWidth = sWidth - aWidth;
    var tHeight = sHeight - aHeight;
    window.scrollTo((tWidth / 2), (310));
	}
/*发布约拍页面位置*/




//判断字符长度
function characterLength(s) {
	var length = 0;
	var blank = s.split("");
	for (var i=0;i<blank.length;i++) {
		if (blank[i].charCodeAt(0)<299) {
			length++;
		}
		else {
			length+=2;
		}
	}
return length;
}





	

	//表格奇偶数行背景颜色
function tableOddEvenBackground(id){ 
    odd = {"background":"#F9F9F9"};				//奇数样式  
    even = {"background":"#FFFFFF"};			//偶数样式 
	
    hover = {"background":"#fff8eb"};			//滑过样式 
	
	
    $(id).find("tr").each(function(index,element){  
        if(index % 2 == 1)  
            $(this).css(odd);  
        else  
            $(this).css(even);  
			
		
    });
	
	
		
	$(id).find("tr").each(function(index,element){ 		
		$(this).hover(
			function(){
				$(this).css(hover);
				},
			function(){
				if(index % 2 == 1)  
					$(this).css(odd);  
				else  
					$(this).css(even); 
				}
		); 
	 }); 
} 



//去掉字符串头尾空格   
function trim(str) {   
    return str.replace(/(^\s*)|(\s*$)/g, "");   
} 



//只可输入数字
function onlyWriteNum(obj){
	if(obj.value.length==1){
		obj.value=obj.value.replace(/[^1-9]/g,'');
		}
	else{
		obj.value=obj.value.replace(/\D/g,'');
		}
}










function nextPrePage(ul,parent,firstURL,firstURLNormal,firstURLHover,lastURL,lastURLNormal,lastURLHover){
	var allLi = $(ul).children();		
	var liWidth = $(allLi).outerWidth();					//孩子的宽度
	
	var nowLeft;
	
	$(ul).css('width',allLi.length * liWidth +'px' );
	$(ul).parents(parent).prev().css("background",firstURL);
	$(ul).parents(parent).prev().attr("disabled","disabled");
	
	
	
	$(ul).parents(parent).prev().click(
		function(){
			if($(this).attr("disabled") !="disabled"){
				nowLeft = parseInt($(ul).css('left'));
			
				$(ul).parents(parent).next().css("background",lastURLNormal);
				$(ul).parents(parent).next().removeAttr("disabled");
			
			
				if(nowLeft == 0-liWidth){
					$(ul).parents(parent).prev().css("background",firstURL);
					$(ul).parents(parent).prev().attr("disabled","disabled");
					}
				else{
					$(ul).parents(parent).prev().css("background",firstURLNormal);
					$(ul).parents(parent).prev().removeAttr("disabled");
					}	
					
				
				
					$(ul).animate({left:nowLeft+liWidth+'px'},function(){
					});	
					
				}
			
		});
	
	
	$(ul).parents(parent).next().click(
		function(){
			if($(this).attr("disabled") !="disabled"){
				$(ul).parents(parent).prev().css("background",firstURLNormal);
				$(ul).parents(parent).prev().removeAttr("disabled");
				
				
				
				nowLeft = parseInt($(ul).css('left'));
				
				if(nowLeft == -(allLi.length-2) * liWidth){
					$(ul).parents(parent).next().css("background",lastURL);
					$(ul).parents(parent).next().attr("disabled","disabled");
					}
				else{
					$(ul).parents(parent).next().css("background",lastURLNormal);
					$(ul).parents(parent).next().removeAttr("disabled");
					}	
					
					
				$(ul).animate({left:nowLeft-liWidth+'px'},function(){
					
				});	
			}
		});
		
/*解决hover问题*/
$(ul).parents(parent).prev().hover(
	function(){
		if($(this).attr("disabled") !="disabled"){
			$(this).css("background",firstURLHover);
			}
		},
	function(){
		if($(this).attr("disabled") !="disabled"){
			$(this).css("background",firstURLNormal);
		}
		}
);


$(ul).parents(parent).next().hover(
	function(){
		if($(this).attr("disabled") !="disabled"){
			$(this).css("background",lastURLHover);
			}
		},
	function(){
		if($(this).attr("disabled") !="disabled"){
			$(this).css("background",lastURLNormal);
		}
		}
);



}	




/*显示下拉框列表*/
function showBelow(showDiv){
	$("#"+showDiv).show();
	$("#"+showDiv).parent().parent().css("z-index","200");
	}
	

/*获取下拉框值并隐藏*/
// bolewDiv		下拉框div列表
// showValue		显示值
function achieveBelow(bolewDiv,showValue){
	var bolewDivSpan=$("#"+bolewDiv).find("span");
	/*alert("11");*/
	
	$(bolewDivSpan).each(function() {
		$(this).click(
			function(){
				$("#"+showValue).html(this.innerHTML);
				$("#"+bolewDiv).hide();
				});
	
		});	
	$(".divdropDown").each(function() {
        $(this).hover(
		function(){
			//$(this).find(".belowValue").show();
		},
		function(){
			$(this).find(".dropDownBoxValue").hide();
			$(this).parent().css("z-index","0");
		});
    });
	
	$(".editSelect").each(function() {
        $(this).hover(
		function(){
			//$(this).find(".belowValue").show();
		},
		function(){
			$(this).find(".belowValue").hide();
			$(this).parent().css("z-index","0");
		});
    });
}
/*获取下拉框值并隐藏*/






