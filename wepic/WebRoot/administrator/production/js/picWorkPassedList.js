$(function(){
	liBarChangeStyle("mainbarCenter");   //主导航背景底边框
	
	
	achieveBelow("divdropDownCategory","divdropDownViewCategory")					/*获取下拉框值并隐藏	拍摄类别*/
	achieveBelow("divdropDownType","divdropDownViewType")					/*获取下拉框值并隐藏	拍摄类型*/
	achieveBelow("divdropDownRleState","divdropDownViewRleState")					/*获取下拉框值并隐藏	发布状态*/
	
	
	hoverAddClass("phoStroyContent");   //显示图片上隐藏信息
	
	
	judgeLi("phoStroyContent",16);	//达到图片数显示分页
	
	delectWork();			/* 	添加删除作品事件*/
	
	
	
	/*$(".viewBjCon").click(
			function(){
				window.location='picWorkPassedView.html'
				}
			);
	*/
	});	




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
function openReson(id){
	$("#noPassId").val(id);
	openPopUpBox("noPassReason");
}


function resetInfo(hidden){
  	cloosePopBox(hidden);
	
	var allLi = $("#phoStroyContent").find("li");
	$(allLi).each(function(){
		
		$(this).removeClass("noPassLi");
		});
}
