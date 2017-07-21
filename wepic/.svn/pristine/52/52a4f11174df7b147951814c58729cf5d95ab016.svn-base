$(function(){
	//divLiBar("divMainList");   //list内容显示收藏
	
	divLiBar2("mainbar","mainbarCenterLi2");   //主导航背景底边框
	
	divLiBar("divTopBarContainer");   //展开头部右边详细
	
	divLiBar("topBarShoppingDetailed");   //头部购物车展开列表背景
	
	userBuyCart();  				/*头部展开用户/购物车信息详细 */
	
	xuan();

	clock();
	
	priceButton('worksCollectTitleTopQuotedPrice','tableworksCollectConInfoInviteBidsWinPrice','worksCollectConInfoSubmitBut1','worksCollectConInfoSubmitBut2');
	});
	



function xuan(){
        var card=document.getElementById('worksCollectTimelyStateCard');
        var cardLi=card.getElementsByTagName('li');
		
		var div=document.getElementById('worksCollectTimelyStateCardCon');
        var oDiv=div.getElementsByTagName('div');

		
		var oDivSon = [];
		for(var i=0;i<oDiv.length;i++){
			if(oDiv[i].className == 'worksCollectTimelyStateCardConSon'){
				oDivSon[oDivSon.length] = oDiv[i];
				}
		}
		
        for(var i=0;i<cardLi.length;i++){  //循环历遍onclick事件
            cardLi[i].index=i; //input[0].index=0 index是自定义属性
            cardLi[i].onmouseover=function(){
               for(var i=0;i<cardLi.length;i++){  //循环历遍去掉button样式和把div隐藏
                  cardLi[i].className='';
                  oDivSon[i].style.display='none';
               };
               this.className='active';  //当前按钮添加样式
               oDivSon[this.index].style.display='block';  //div显示 this.index是当前div 即div[0]之类的
           };
         };
		 
       }
var DifferenceHour = -1
var DifferenceMinute = -1
var DifferenceSecond = -1
var Tday = new Date("2014/09/24 17:29:12")   //**截止时间-注意格式
var daysms = 24 * 60 * 60 * 1000
var hoursms = 60 * 60 * 1000
var Secondms = 60 * 1000
var microsecond = 1000 
var timeNum = 1380014898861;
function clock()
{
		<!-- hide script from old browser



var time = new Date()   //**开始时间-注意格式


//var time = new Date()
var hour = time.getHours()
var minute = time.getMinutes()
var second = time.getSeconds()
//alert(timeNum);
//alert(second);

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
// end hiding --> 


function priceButton(tag,price,ying,bao){
	var oTag = document.getElementById(tag);
	var oPrice = document.getElementById(price);
	var oYing = document.getElementById(ying);
	var oBao = document.getElementById(bao);
	
	var oTagDis = getStyle(oTag,"display");
		if(oTagDis == 'none'){
			oYing.style.display ='';
			oBao.style.display ='none';
			}
		else if(oTagDis != 'none'&&oPrice.innerHTML=="——"){
			oYing.style.display ='none';
			oBao.style.display ='';
			}
		else{
			oYing.style.display ='';
			oBao.style.display ='';
			}
	}