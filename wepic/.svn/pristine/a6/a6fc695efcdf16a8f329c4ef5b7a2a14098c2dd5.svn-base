$(function(){
	
	liBarChangeStyle("mainbarCenter");   //主导航背景底边框
	
	
	
	achieveBelow("divdropDownCategory","divdropDownViewCategory")					/*获取下拉框值并隐藏	拍摄类别*/
	achieveBelow("divdropDownType","divdropDownViewType")					/*获取下拉框值并隐藏	拍摄类型*/
	achieveBelow("divdropDownRelState","divdropDownViewRelState")					/*获取下拉框值并隐藏	拍摄类别*/
	
	changeHead("phoStroyDetailLeft","editzpgs");			//显示编辑删除
	//addClickzj('zhuanjiadd');
	
	document.getElementById("formPhoStroyDetail").reset();
	backToPrevious();
	
});

//其他填写

function clickOther(obj){
	var check = $(obj).attr("checked");
	if(check == "checked"){
		$("#checkqitArea").removeAttr("disabled");
		}
	else{
		$("#checkqitArea").attr("disabled","disabled");
		$("#checkqitArea").val("");
		}
}


/*function saveInfo(hidden,table){
	
	
	var allInput = $("#"+table).find("input");
	var inpunCheck = [];
	var che = $(this).attr("checked");
	
	$(allInput).each(function() {
		if(che == "checked"){
			inpunCheck[inpunCheck.length] = $(this).attr("checked");
			}
       alert(che)
    });
	alert(inpunCheck.length);
	 if(inpunCheck.length == 0){
		alert("请填写不通过原因!");
		return;
		}
	
	
  	$("#"+hidden).fadeTo("slow",0);
	$("#"+hidden).remove();
	var allTextarea = $("#"+table).find("textarea").attr("disabled","disabled");
	$(allInput).each(function() {
        $(this).attr("disabled","disabled");
    });
}*/


function saveInfo(hidden,table){
	
	
  	$("#"+hidden).fadeTo("slow",0);
	$("#"+hidden).remove();	
	
	var allTextarea = $("#"+table).find("textarea").attr("disabled","disabled");
	$(allInput).each(function() {
        $(this).attr("disabled","disabled");
    });
}

function noPassReason(obj,parent,view){
  		$("#"+parent).slideUp();
		$("#"+view).slideDown();
	
}


function passOpertion(obj,parent,view){
		/*var option = '<div class="passedOperation" id="passedOperation"><div class="opeation"><input class="pass" type="button" id="" value="编辑属性"/><input class="pass" type="button" id="" value="下架"/><input class="pass" type="button" id="" value="添加到订阅"/><input class="pass" type="button" id="" value="推荐该作品"/></div></div>';
	
  		$("#"+parent).fadeTo("slow",0);
		$("#autonyMaudit").remove();
  		$("#"+view).slideUp();
		$("#"+view).apddddpend(option);
		$("#"+view).slideDown();*/
		history.go(-1);
	
}

