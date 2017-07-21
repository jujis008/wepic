$(function(){
	
	divLiBar2("mainbar","personalCenter");   //主导航背景底边框
	
	
	divLiBar("divTopBarContainer");   //展开头部右边详细
	
	userBuyCart();  				/*头部展开用户/购物车信息详细 */
	
	
	achieveBelow1("divdropDownInviteType","divdropDownViewInviteType")					/*获取下拉框值并隐藏	拍摄类型*/
	achieveBelow("divdropDownPartEnv","divdropDownViewPartEnv")					/*获取下拉框值并隐藏	拍摄环境*/
	
	achieveBelow("divdropDownBidType","divdropDownViewBidType")					/*获取下拉框值并隐藏	招标方式*/
	
	
	createHour("divdropDownStartHour");		/*获取小时	00-23时*/
	createHour("divdropDownStartHour2");		/*获取小时	00-23时*/
	createHour("divdropDownStartHour3");		/*获取小时	00-23时*/
	
	achieveBelow("divdropDownStartHour","divdropDownViewStartHour")					/*获取下拉框值并隐藏	24小时1*/
	achieveBelow("divdropDownStartHour2","divdropDownViewStartHour2")					/*获取下拉框值并隐藏	24小时1*/
	achieveBelow("divdropDownStartHour3","divdropDownViewStartHour3")					/*获取下拉框值并隐藏	24小时1*/



	
	divLiBar("ULUpload");   //显示上传删除
	
	
	
	//hideSelect();
});

function deleteFile(obj){
	if(confirm("确定删除吗?")){
		$(obj).parents("li").remove();
	}
}


function achieveBelow1(bolewDiv,showValue){
	var bolewDiv=document.getElementById(bolewDiv);
	var bolewDivSpan=bolewDiv.getElementsByTagName("span");
	/*alert("11");*/
				
	for(var i=0;i<bolewDivSpan.length;i++){
		bolewDivSpan[i].onclick=function (){
			/*document.getElementById(showValue).innerHTML = this.innerHTML;*/
			$("#"+showValue).html(this.innerHTML);
			
			$(bolewDiv).hide();
			$(bolewDiv).parent().parent().css("z-index","0");
			
			for(var i= 0;i<bolewDivSpan.length;i++){
				$(bolewDivSpan[i]).removeClass("active");
				}
				$(this).addClass("active");
			};
		}
}