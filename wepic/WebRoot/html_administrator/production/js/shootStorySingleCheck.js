$(function(){
	
	liBarChangeStyle("mainbarCenter");   //主导航背景底边框
	
	
	changeHead("divChangeHead","divViewHead");			//更换头像
	
	
	changeHead("phoStroyDetailLeft","editzpgs");			//显示编辑删除
	addClickzj('zhuanjiadd');
	
	document.getElementById("formPhoStroyDetail").reset();
});


//function passToPage(){
//	history.go(-1);
//	}


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


function changeHeadStory(opendiv){
	openPopUpBox('chooseWork');
	
	window.frames['child'].document.getElementById('hiddenv').value = opendiv;			//传值给 iframe text
	}
	
function closeOwnBox(obj){
	$("#greybackground").remove();
	$("#"+obj).hide();
	}

//打开裁切
function fucropHead(url){	
				
	openPopUpBox('cropHead');
	var urlc = "../../public/" + url;
	
	
	var frobj = window.frames['child2'].document.getElementById('imghead');
	
	$(frobj).attr("src",url);
	}