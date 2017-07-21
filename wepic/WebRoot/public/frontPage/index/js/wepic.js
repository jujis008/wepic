$(function(){
	
	
	hoverAddClass("#demandAndProblem");   //问题部分
	
	
	hoverAddClass("#interlinkage");   //友情链接换色
	hoverAddClass("#recommendePhotographerCon");   //淡入淡出摄影师图片详情
	});
	
function move(mouseDiv,moveDivClassName){
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
			for(var i=0;i<mouseDivLi.length;i++){
				mouseDivLi[i].className = "";
			}
			this.className="active";
			startMove(100,moveObj[this.index]);
			
			};
			
		mouseDivLi[i].onmouseout=function (){
			
			
			for(var i=0;i<mouseDivLi.length;i++){
				mouseDivLi[i].className = "";
			}
			
			startMove(0,moveObj[this.index]);
			};
		}
}

	
var alpha=0;
var timer1=null;
var timer2=null;

function startMove(iTarget,mouseDivCon)
{
	
	clearInterval(timer1);
	timer1=setInterval(function (){
		var speed=0;
		
		if(alpha<iTarget)
		{
			speed=10;
		}
		else
		{
			speed=-10;
		}
		
		if(alpha==iTarget)
		{
			clearInterval(timer1);
		}
		else
		{
			alpha+=speed;
			
			mouseDivCon.style.filter='alpha(opacity:'+alpha+')';
			mouseDivCon.style.opacity=alpha/100;
		}
	}, 30);
}
