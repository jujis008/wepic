$(function(){
	
	liBarChangeStyle("mainbarCenter");   //主导航背景底边框
	
	
	changeHead("divChangeHead","divViewHead");			//更换头像
	
	
	
	achieveBelow("divdropDownCategory","divdropDownViewCategory")					/*获取下拉框值并隐藏	拍摄类别*/
	achieveBelow("divdropDownType","divdropDownViewType")					/*获取下拉框值并隐藏	拍摄类型*/
	
	
	changeHead("phoStroyDetailLeft","editzpgs");			//显示编辑删除
	addClickzj('zhuanjiadd');
	
	document.getElementById("formPhoStroyDetail").reset();
	
	objscroll("storyConScrollTop","phoStroyDetailRight",290);
	
	backToPrevious();
});


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