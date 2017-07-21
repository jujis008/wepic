$(function(){
	divLiBar2("mainbar","mainbarCenterLi3");   //主导航背景底边框
	
	divLiBar("divTopBarContainer");   //展开头部右边详细
	
	divLiBar("topBarShoppingDetailed");   //头部购物车展开列表背景
	
	userBuyCart();  				/*头部展开用户/购物车信息详细 */
	
	
	
	/*move("cameristUL","cameristLiBjMan");*/
	move("cameristLi1","div1");
	divLiBar("humanCamerist");
	
	divLiBar("fashionableCamerist");
	
	divLiBar("originalityCamerist");
	
	});
	

function move(mouseDiv,moveDivClassName){
$("li").hover(
  function () {
	 
		$("#"+moveDivClassName).stop().fadeTo('slow',1);
		
},
  function () {
     $("#"+moveDivClassName).stop().fadeTo('slow',0);
  }
); 
}

/*function move(mouseDiv,moveDivClassName){
	var mouseDiv=document.getElementById(mouseDiv);
	var mouseDivLi=mouseDiv.getElementsByTagName("li");
	
	var mouseDivCon=mouseDiv.getElementsByTagName("div");
	
	
		var moveObj = [];
		for(var i=0;i<mouseDivCon.length;i++){
			if(mouseDivCon[i].className == moveDivClassName){
				moveObj[moveObj.length] = mouseDivCon[i];
				}
		}
				
	for(var i=0;i<mouseDivLi.length;i++){
		mouseDivLi[i].index = i;
		mouseDivLi[i].onmouseover=function (){
			startMove(230,moveObj[this.index]);
			};
			
		mouseDivLi[i].onmouseout=function (){
			
			startMove(360,moveObj[this.index]);
			};
		}
}*/

/*var timer=null;
function startMove(iTarget,mouseDivCon)
{
	var mouseDivCon=document.getElementById(mouseDivCon);
	clearInterval(timer);
	timer=setInterval(function (){
		var speed=0;
		if(mouseDivCon.offsetTop>iTarget)
		{
			speed=-10;
		}
		else
		{
			speed=10;
		}
		
		if(mouseDivCon.offsetTop==iTarget)
		{
			clearInterval(timer);
		}
		else
		{
			mouseDivCon.style.top = mouseDivCon.offsetTop+speed+'px';
		}
	}, 30);
}
*/