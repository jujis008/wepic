$(function(){	
	
	divLiBar("divListUL");   //list背景变化
	
	
	
	achieveBelow("divdropDownPartType","divdropDownViewPartType")					/*获取下拉框值并隐藏	约拍类型*/
	achieveBelow("divdropDownState","divdropDownViewState")					/*获取下拉框值并隐藏	约拍状态*/
	achieveBelow("divdropDownTime","divdropDownViewTime")					/*获取下拉框值并隐藏	时间*/
	
});

/*获取下拉框值并隐藏*/
function achieveBelow(bolewDiv,showValue){
	var bolewDiv=document.getElementById(bolewDiv);
	var bolewDivSpan=bolewDiv.getElementsByTagName("span");
	/*alert("11");*/
				
	for(var i=0;i<bolewDivSpan.length;i++){
		bolewDivSpan[i].onclick=function (){
			/*document.getElementById(showValue).innerHTML = this.innerHTML;*/
			$("#"+showValue).val(this.innerHTML);
			$(bolewDiv).hide();
			$(bolewDiv).parent().parent().css("z-index","0");
			};
		}
}
/*获取下拉框值并隐藏*/
