
$(function(){
document.getElementById("inputselect").value="选择类型";		//刷新默认为请选择类型

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

/* active 动作	恢复默认样式*/
function divLiBar2(divName,li){
	var mainDiv=document.getElementById(divName);
	var allMainBarLi=mainDiv.getElementsByTagName("li");
	
	var nowLi=document.getElementById(li);
	
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
	
	var popUpBox = document.getElementById(divPopUpBox);
	
	var getw =$(popUpBox).css("width")
	var geth = $(popUpBox).css("height");
	
	
	if(getheight == '' || getheight == null){
		getheight = 0;
		}
		
	var getwidth = parseInt(getw);
	var getheight = parseInt(geth);
	
	
		
	var topWidth = (borwerViewWidth - getwidth)/2;
	var topHeight = (borwerViewHeight - getheight)/ 2;
	
	
	
		
	if(topHeight <= 0){
		topHeight = 10;
		}
	/*else{
		document.body.style.overflow="hidden";
		}*/
	$("#greybackground").remove();
	$("body").prepend('<div id="greybackground" style="position:absolute; z-index:9999;background:black;display:none"></div>');
	$("html,body").animate({ scrollTop:0},0);
	//$("html,body").css({ "overflow": "hidden"});
	$("#greybackground").css({ "opacity": "0.8", "height": htmlHeight+"px","display":"block","width": htmlWidth+"px","background":"black","top":"0px","left":"0px"});
	$("#greybackground").show();
	
	$("#"+divPopUpBox).show();
	$("#"+divPopUpBox).css({ "position": "absolute","z-index":"10000","top":topHeight + "px" , "left": topWidth+"px"});
	
	/*var qq = $("#greybackground").css("z-index");
	alert(qq);*/
	/*window.scrollTo(0,$(document).scrollTop());*/
	
}
function cloosePopBox(divPopUpBox){
	$("#greybackground").remove();
	$("#"+divPopUpBox).hide();
	document.body.style.overflow="auto";
}	
/*弹出层*/

/* 回顶部 */
function goTopEx(){
        var obj=document.getElementById("goTopBtn");
		//要获取当前页面的滚动条纵坐标位置
        function getScrollTop(){
			if(document.documentElement.scrollTop)
            	{return document.documentElement.scrollTop;}
			else	
				{return document.body.scrollTop}
            }
		//判断
        window.onscroll = function(){getScrollTop() > 0 ? obj.style.display="" : obj.style.display="none";}
		
		window.onscroll = function(){getScrollTop() > 0 ? obj.style.display="" : obj.style.display="none";}
		
        function setScrollTop(value){
			if(document.documentElement.scrollTop)
            	{document.documentElement.scrollTop = value;}
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
// 判断是否IE浏览器




// 验证是否为空和长度
function promptInfo(obj,addToDiv,length){
	
	$("#"+addToDiv).children().remove();			//先清空当前div里元素
	var option = "";
	var promptInfo = "";
	var len = length/2;
	
	
	var val = $("#"+obj).val();
	var byteCount = getByteCount(val);
	
	/*alert(length+byteCount);*/
		if(val == "" || val == null){
			promptInfo = "不能为空";
			addpromptInfo(promptInfo,addToDiv);			//增加div
			return;
			}
		
		else if(byteCount > length){
			promptInfo = "";
			promptInfo = "长度不能超过"+len+"字";
			
			addpromptInfo(promptInfo,addToDiv);			//增加div
			return;
			}	
}
// 验证是否为空和长度



// 验证长度
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
// 验证长度


function addpromptInfo(promptInfo,addToDiv){
	option = "<div class='divprompt'><span>"+promptInfo+"</span></div>";
	$("#"+addToDiv).append(option);
	}	
 /*字节不超过	*/
function getByteCount(str){
	return str.replace(/[^\x00-\xff]/g, "**").length;
	}
 
/*字节不超过	*/

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




/*达到图片数显示分页*/
function judgeLi(obj,num){
	var allli = $("#"+obj).find("li");
	if(allli.length > num){
		$(".ppointPagingthis").show();
		}
	}
/*达到图片数显示分页*/



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
function divLiBarClick(divName){
	var allMainBarLi=$("#"+divName).find("li");
	
	$(allMainBarLi).each(function(){
			$(this).click(function(){
				var allMainBarLi=$("#"+divName).find("li").each(function() {
                    $(this).removeClass("active");
                });
					$(this).addClass("active");
					 });
					
    });	
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






/*返回上一页*/
function backToPrevious(){
	$(".backToPrevious").click(function(){
			history.go(-1);
			});
}

/*返回上一页*/