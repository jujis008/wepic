$(function(){
	liBarChangeStyle("mainbarCenter");   //主导航背景底边框
	
	
	achieveBelow("divdropDownCategory","divdropDownViewCategory")					/*获取下拉框值并隐藏	拍摄类别*/
	achieveBelow("divdropDownType","divdropDownViewType")					/*获取下拉框值并隐藏	拍摄类型*/
	
	
	hoverAddClass("phoStroyContent");   //显示图片上隐藏信息
	
	//directDelete("directDel");					//直接删除
	
	//directDelete("pass");					//通过
	
	directNoPass("noPass","noPassReason");					//不通过
	
	
	
	judgeLiS("phoStroyContent");	//达到图片数显示分页
	
	
	/*$(".viewBjCon").click(
	function(){
		window.location='shootStorySingleCheck.html'
		}
	);
	*/
	
	});	

/*保存不通过原因*/
function saveInfo(hidden){
  	cloosePopBox(hidden);
	
	var delVale = $("#opeationPass").find("#hiddenSave").val();
	deleteLiFile2(delVale);
	
}
/*保存不通过原因*/


/*显示不通过原因*/
function directNoPass(triggerdel,viewDiv){
	var alldel = $("#phoStroyContent").find("."+triggerdel);
	$(alldel).each(function(){
		$(this).click(
			function(){
				var storyClass = $(this).parents("li").attr("class");
				var result=storyClass.split(" ");
				var likeName = result[0];
				var tempid=$(this).parents("li").find("#checkstoryid").val();
				$("#storynoPassId").val(tempid);
				openPopUpBox(viewDiv);
				$("#opeationPass").find("#hiddenSave").val(likeName);
			});
	});
}
/*显示不通过原因*/


/*直接删除*/
function directDelete(triggerdel){
	var alldel = $("#phoStroyContent").find("."+triggerdel);
	$(alldel).each(function(){
		$(this).click(
			function(){
				var storyClass = $(this).parents("li").attr("class");
				var result=storyClass.split(" ");
				var likeName = result[0];
				//alert(likeName);
				deleteLiFile1(likeName);
			});
	});
}
/*直接删除*/



function deleteLiFile1(obj){
	if(confirm("确定删除吗?")){
		var alldel = $("#phoStroyContent").find("."+obj);
		$(alldel).each(function(){
			$(this).remove();
		});
		
	}
}

/*保存后删除*/
function deleteLiFile2(obj){
		var alldel = $("#phoStroyContent").find("."+obj);
		$(alldel).each(function(){
			$(this).remove();
		});
		
}
/*保存后删除*/


/*达到图片数显示分页*/
function judgeLiS(obj){
	var allLiName = [];
	var allLi = $("#"+obj).find("li");
	$(allLi).each(function() {
        allLiName[allLiName.length] = $(this).attr("class");
	
    });
	var storyLength = allLiName.deleteEleDis().length;
	
	//alert(storyLength); 
	if(storyLength > 5){
		$(".ppointPagingthis").show();
	}
}




/*达到图片数显示分页*/
