$(function(){
	
	divLiBar2("mainbar","personalCenter");   //主导航背景底边框
	
	divLiBar("divTopBarContainer");   //展开头部右边详细
	
	userBuyCart();  				/*头部展开用户/购物车信息详细 */
	
	/*
	achieveBelow("divSelectdeCategoryValue","selectdeCategoryValue")					/*获取下拉框值并隐藏	所有类别*/
	/*
	achieveBelow("divSelectdeTypeValue","selectdeTypeValue")					/*获取下拉框值并隐藏	所有类型*/
	/*
	achieveBelow("divSelectdespecialValue","selectdespecialValue")					/*获取下拉框值并隐藏	默认专辑*/
	/*
	achieveBelow("divSelectdeStateValue","selectdeStateValue")					/*获取下拉框值并隐藏	所有作品状态*/

	
	divLiBar("picWorkContent");   //显示图片上隐藏信息rr
	
	
	
	divViewSpec();			//展开图片右上角
	
	judgeLi("picWorkContent",16);	
	
	delectWork();

});



/* 	div下找一个classname加view	展开图片右上角*/
function divViewSpec(){
	$("#picWorkContent div").each(function(){
		if($(this).attr("class") == "divOnlyView"){
			$(this).hover(
				function(){
					$(this).addClass("view");
				},
				function(){$(this).removeClass("view");}
			);
		}
    });	
}

/* 	删除作品*/
function delectWork(){
	$("#picWorkContent .picEdit").each(function(){
		$(this).children(".del").click(
		function(){
			if(confirm("确定删除吗")){
				$(this).parents("li").remove();
				}
			}
		);
    });	
}
