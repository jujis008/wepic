$(function(){
	
	
	
	judgeLi("divListOneUl",16);	//达到图片数显示分页
	judgeLi("divListTwoUl",16);	//达到图片数显示分页
	judgeLi("divListThreeUl",16);	//达到图片数显示分页
	judgeLi("divListFourUl",16);	//达到图片数显示分页
	
	
	/* 选列表*/
	xuan();
	
	clock();				//倒计时
	
	
	objscroll("divApointProjectRight",260);
	/* 切换荣誉 代表作品*/
	divLiBarClickCollect();
	
	
	allPrevNext();
	
	divLiBarClickSmall();
	});
	
	
	

/* click 动作		jquery*/
function divLiBarClickSmall(divName){
	var allMainBarLiOne=$(".recruitCameristSmall_one").children();
	var allMainBarLiTwo=$(".recruitCameristSmall_two").children();
	var allMainBarLiThree=$(".recruitCameristSmall_three").children();
	var allMainBarLiFour=$(".recruitCameristSmall_four").children();
	
	$(allMainBarLiOne).each(function(){
			$(this).click(function(){
				var allMainBarLi=$(".recruitCameristSmall_one").children().each(function() {$(this).removeClass("actives");});
				$(this).addClass("actives");
			});	
    });
	
	$(allMainBarLiTwo).each(function(){
			$(this).click(function(){
				var allMainBarLi=$(".recruitCameristSmall_two").children().each(function() {$(this).removeClass("actives");});
				$(this).addClass("actives");
			});	
    });
	$(allMainBarLiThree).each(function(){
			$(this).click(function(){
				var allMainBarLi=$(".recruitCameristSmall_three").children().each(function() {$(this).removeClass("actives");});
				$(this).addClass("actives");
			});	
    });
	$(allMainBarLiFour).each(function(){
			$(this).click(function(){
				var allMainBarLi=$(".recruitCameristSmall_four").children().each(function() {$(this).removeClass("actives");});
				$(this).addClass("actives");
			});	
    });
}



/* 切换荣誉 代表作品*/
function divLiBarClickCollect(divName){
	var allMainDB=$(".topdb");
	$(allMainDB).each(function(indexDB, elementDB){
		
		// alltopLi 选择选项卡top
		var alltopLi = $(elementDB).find("ul").children();
		var allConDiv = $(elementDB).next().children();
		
		
		$(alltopLi).each(function(indexTopLi, elementTopLi) {
			alltopLi[indexTopLi].index = indexTopLi; 
            $(alltopLi).click(function(){
				//加选中样式
					
				$(alltopLi).each(function( i , ele) {
					$(ele).removeClass("active");
					allConDiv[i].style.display = 'none';
				});
				
				$(this).addClass("active");
				allConDiv[this.index].style.display = 'block';
				
				
				
				
				});
        });
    });	
	
	
	
}


var flag = 0;			//
function xuan(){
	var scrollTop = getScrollTop();
        var cardLi=$("#recruitCameristTimelyStateCard").find("li");
		var oDivSon = $(".divStateCardCon").find(".divList");
		//var CameristSmall = $("#recruitCameristSmall").children();
		
        for(var i=0;i<cardLi.length;i++){  
            cardLi[i].index=i; //input[0].index=0 index是自定义属性
            cardLi[i].onclick=function(){
               for(var i=0;i<cardLi.length;i++){  //循环历遍去掉button样式和把div隐藏
                  cardLi[i].className='';
                  oDivSon[i].style.display='none';
                 
				 // CameristSmall[i].style.display='none';
               };
              // alert($.trim(($(this).text())));
               /*if($.trim(($(this).text()))=="邀请记录"){
            	   $("#invitedPerson").height("1407px");
               }
               if($.trim(($(this).text()))=="中标者列表"){
            	   $("#listsuccessfultenderer").height("1707px;");
            	   
               }
               */
               
               if($.trim(($(this).text()))=="待定列表"){
            	  chagePage();
            	 // $("#divListThree").html('<iframe frameborder="0" id="invitedPerson" scrolling="false" src="back/personalCentr/myPart/releaseRecord/bidPersons/listsubstitution.jsp"  height="1127px" width="863px"> </iframe>');
            	   
               }
               
               
			 if(flag == 0){
				$("#divStageTop").slideUp();
				$("#divFold").slideUp();
				$("#rightDetail").hide();
				$("#rightFiltrate").show();
				$("#stateCardBackDetail").show();
				
   				window.scrollTo((0), (90));
				flag = 1;
				 }
				 
               this.className='active';  //当前按钮添加样式
               oDivSon[this.index].style.display='block';  //div显示 this.index是当前div 即div[0]之类的
             //  CameristSmall[this.index].style.display='block';  //div显示 this.index是当前div 即div[0]之类的
           };
         };
		 
       }
	
function showDetail(){
	 if(flag == 0){
		$("#divStageTop").slideUp();
		$("#divFold").slideUp();
		$("#rightDetail").hide();
		$("#rightFiltrate").show();
		$("#stateCardBackDetail").show();
		flag = 1;
   		window.scrollTo((0), (90));
		return;
	}
	
	
	if(flag == 1){
		$("#divStageTop").slideDown();
		$("#divFold").slideDown();
		$("#rightDetail").show();
		$("#rightFiltrate").hide();
		$("#stateCardBackDetail").hide();
		flag = 0;
		return;
	}		 
	
}




function allPrevNext(){
	var allPrev = $(".slider_next");				//下一张向左移动
	var allNext = $(".slider_prev");				//上一张向右移动
	
	/*var options = $.extend( defaults, opt );
	var dir = options.direction;
	
	var data1 = {}, data2 = {};
		data1[dir] = -$iSteep;
		data2[dir] = 0;*/
	
	$(allPrev).each(function(index, element) {
		var $item,$iSteep;
		var $sliderMove = $(this).next().children();		//获取所要对象
		
		$item = $sliderMove.children();					//所有孩子
		$iSteep = $item.outerWidth();					//孩子的宽度
		
		$sliderMove.css('width',$item.length * $iSteep +'px' );
						
    });
		
		//上一张向右移动
	$(allPrev).each(function(index, element) {
		
		var $sliderMove = $(this).next().children();		//获取所要对象
		
		var $item,$iSteep;
		var $sliderMove = $(this).next().children();		//获取所要对象
	
		$item = $sliderMove.children();					//所有孩子
		$iSteep = $item.outerWidth();					//孩子的宽度
		
        $(this).click(function(){
			
			
			//先把最后一个放第一个排序
			$sliderMove.css( "left", -$iSteep+'px').children().last().prependTo( $sliderMove );
			//向右移动
			$sliderMove.animate({left:"0px"});
			});
						//滚动
    });
	
	
	
	
	$(allNext).each(function(index, element) {
		var $sliderMove = $(this).prev().children();		//获取所要对象
		
		
		var $item,$iSteep;
		var $sliderMove = $(this).prev().children();		//获取所要对象
	
		$item = $sliderMove.children();					//所有孩子
		$iSteep = $item.outerWidth();					//孩子的宽度
        $(this).click(function(){
			$sliderMove.animate({left:-$iSteep+'px'},function(){
			
				$sliderMove.css( "left" , 0 ).children().first().appendTo( $sliderMove );
			});	
			
			});
		
    });
	
	
	
	}
	
	


function viewcontact(obj){
	$(obj).next().show();
	$(obj).remove();
	
	}







/*倒计时*///bbb
var DifferenceHour = -1
var DifferenceMinute = -1
var DifferenceSecond = -1


var Tday = new Date(str)   //**截止时间-注意格式
var daysms = 24 * 60 * 60 * 1000
var hoursms = 60 * 60 * 1000
var Secondms = 60 * 1000
var microsecond = 1000 
var timeNum = 1380014898861;
function clock(){
//alert();
	//<!-- hide script from old browser
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


