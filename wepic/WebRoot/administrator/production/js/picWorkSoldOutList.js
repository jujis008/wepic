$(function(){
	liBarChangeStyle("mainbarCenter");   //主导航背景底边框
	
	
	achieveBelow("divdropDownCategory","divdropDownViewCategory")					/*获取下拉框值并隐藏	拍摄类别*/
	achieveBelow("divdropDownType","divdropDownViewType")					/*获取下拉框值并隐藏	拍摄类型*/
	
	
	hoverAddClass("phoStroyContent");   //显示图片上隐藏信息
	
	directDelete("directDel");					//直接删除
	
	directNoPass("noPass","noPassReason");
	
	judgeLi("phoStroyContent",16);	//达到图片数显示分页
	
	
//	$(".viewBjCon").click(
//	function(){
//		window.location='picWorkSoldOutView.html'
//		}
//	);
//	
	});	




/*直接删除*/
function directDelete(triggerdel){
	var alldel = $("#phoStroyContent").find("."+triggerdel);
	$(alldel).each(function(){
		$(this).click(
			function(){
				deleteLiFile(this);
			});
	});
}
/*直接删除*/

/*显示不通过原因*/
function directNoPass(triggerdel,viewDiv){
	var alldel = $("#phoStroyContent").find("."+triggerdel);
	$(alldel).each(function(){
		$(this).click(
			function(){
				var storyClass = $(this).parents("li").attr("class","noPassLi");
                 //$(this).parents("li").find("#picId").val();
                 ////$("#picId").val();
                 //alert();
				$("#noPassId").val($(this).parents("li").find("#picId").val());
				openPopUpBox(viewDiv);
				//$("#opeationPass").find("#hiddenSave").val(likeName);
			});
	});
}
/*显示不通过原因*/



