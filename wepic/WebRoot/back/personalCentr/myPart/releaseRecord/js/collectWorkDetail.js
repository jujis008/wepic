$(function(){
	
	
	
	judgeLi("divListOneUl",16);	//达到图片数显示分页
	judgeLi("divListTwoUl",16);	//达到图片数显示分页
	judgeLi("divListThreeUl",16);	//达到图片数显示分页
	judgeLi("divListFourUl",16);	//达到图片数显示分页
	
	
	xuan();				//选项卡
	
	clock();				//倒计时
	
	
	objscroll("divApointProjectRight",260);
	
	divLiBarClick("divsxOne");
	divLiBarClick("divsxTwo");
	divLiBarClick("divsxThree");
	});
	


var flag = 0;
function xuan(){
        var cardLi=$("#recruitCameristTimelyStateCard").find("li");
		var oDivSon =$(".divStateCardCon").find(".divList");
		
		
        for(var i=0;i<cardLi.length;i++){  
            cardLi[i].index=i; //input[0].index=0 index是自定义属性
            cardLi[i].onclick=function(){
               for(var i=0;i<cardLi.length;i++){  //循环历遍去掉button样式和把div隐藏
                  cardLi[i].className='';
                  oDivSon[i].style.display='none';
               };
			   
			 if(flag == 0){
				$("#divStageTop").slideUp();
				$("#divFold").slideUp();
				$("#rightDetail").hide();
				$("#rightFiltrate").show();
				flag = 1;
				 }
				 
               this.className='active';  //当前按钮添加样式
               oDivSon[this.index].style.display='block';  //div显示 this.index是当前div 即div[0]之类的
           };
         };
		 
       }
	
function showDetail(){
	$("#divStageTop").slideDown();
	$("#divFold").slideDown();
	$("#rightDetail").show();
	$("#rightFiltrate").hide();
	flag = 0;
	
	}
function hideDE(){
	$("#divStageTop").slideUp();
	$("#divFold").slideUp();
	$("#rightDetail").hide();
	$("#rightFiltrate").show();
	flag = 1;
	
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
