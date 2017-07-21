$(function(){
	liBarChangeStyle("mainbarCenter");   //主导航背景底边框
	
	
	achieveBelow("divdropDownCategory","divdropDownViewCategory")					/*获取下拉框值并隐藏	拍摄类别*/
	achieveBelow("divdropDownType","divdropDownViewType")					/*获取下拉框值并隐藏	拍摄类型*/
	
	
	hoverAddClass("phoStroyContent");   //显示图片上隐藏信息
	
	
	judgeLi("phoStroyContent",16);	//达到图片数显示分页
	
	//delectWork();			/* 	添加删除作品事件*/
	
	
	
	/*$(".viewBjCon").click(
	function(){
		window.location='shootStorySingleView.html'
		}
	);
	*/
	
	$(".xj").click(
			function(){
				var tempid=$(this).parents("li").find("#checkstoryid").val();
				$("#storynoPassId").val(tempid);
				openPopUpBox("noPassReason");
				var storyClass = $(this).parents("li").attr("id");
				$("#opeationPass").find("#hiddenSave").val(storyClass);
			}
	
	);
	});	

function saveInfo(hidden){
  	cloosePopBox(hidden);
	
	var delVale = $("#opeationPass").find("#hiddenSave").val();
	deleteLiFile2(delVale);
	
}
/*保存后删除*/
function deleteLiFile2(obj){
		var alldel = $("#phoStroyContent").find("#"+obj);
		$(alldel).each(function(){
			$(this).remove();
		});
		
}

/* 	删除作品*/
function delectWork(){
	$("#phoStroyContent .picEdit").each(function(){
		$(this).children(".xj").click(
		function(){
			if(confirm("确定删除吗")){
				$(this).parents("li").remove();
				}
			}
		);
    });	
}
