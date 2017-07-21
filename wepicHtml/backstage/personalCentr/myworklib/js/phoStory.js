$(function(){
	
	divLiBar2("mainbar","personalCenter");   //主导航背景底边框
	
	divLiBar("divTopBarContainer");   //展开头部右边详细
	
	userBuyCart();  				/*头部展开用户/购物车信息详细 */
	
	achieveBelow("divSelectdespecialValue","selectdespecialValue")					/*获取下拉框值并隐藏	默认专辑*/
	
	
	achieveBelow("divSelectdeTypeValue","selectdeTypeValue")					/*获取下拉框值并隐藏	所有类型*/
	
	achieveBelow("divSelectdeStateValue","selectdeStateValue")					/*获取下拉框值并隐藏	所有作品状态*/
	
	
	divLiBar("phoStroyContent");   //显示图片上隐藏信息
	
	
	divViewSpec();			//展开图片右上角
	
	judgeLi("phoStroyContent",16);	//达到图片数显示分页
	
	delectWork();				/* 	删除作品*/
});





/* 	div下找一个classname加view	展开图片右上角*/
function divViewSpec(){
	$("#phoStroyContent .divOnlyView").each(function(){
			$(this).hover(
				function(){
					$(this).addClass("view");
					/*$(this).children(".divOnlyView");*/
				},
				function(){$(this).removeClass("view");}
			);
    });	
}


/* 	删除作品*/
function delectWork(){
	$("#phoStroyContent .picEdit").each(function(){
		$(this).children(".del").click(
		function(){
			if(confirm("确定删除吗")){
				$(this).parents("li").remove();
				}
			}
		);
    });	
}
