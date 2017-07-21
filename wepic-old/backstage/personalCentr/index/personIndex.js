$(function(){
	divLiBar2("mainbar","personalCenter");   //主导航背景底边框
	
	divLiBar("divTopBarContainer");   //展开头部右边详细
	
	userBuyCart();  				/*头部展开用户/购物车信息详细 */
	
	changeHead("divheadChange","headChange");
	
	openPopUpBox("divChoseUser");
	
	
	openPopUpBox('divMyRePop');
	});

function changeHead(div,viewDiv){
	$('#'+div).hover(
		function(){
			$('#'+viewDiv).stop().fadeTo('slow',1);
		},
		function(){
			$('#'+viewDiv).stop().fadeTo('slow',0);
		});
}


/*重新选择*/
function reChose(obj,opendiv){
	$(obj).parent().parent().hide();
	
	openPopUpBox(opendiv);
	}
/*重新选择*/


/*重新选择角色*/
function reChosePart(obj,opendiv){
	$(obj).parent().parent().parent().hide();
	
	openPopUpBox(opendiv);
	}
/*重新选择角色*/


/*选择跳转	个人标签选择	企业标签选择*/
function choosePopUpBox(obj,opendiv){
	$(obj).parent().parent().hide();
	
	openPopUpBox(opendiv);
	}
/*选择跳转	个人标签选择	企业标签选择*/


 /*字节不超过20	*/
function getByteCount(str){
	return str.replace(/[^\x00-\xff]/g, "**").length;
	}
	var value;
function doit(obj){
	if(getByteCount(obj.value)>20){
		obj.value=value;
	}
	value=obj.value
} 
/*字节不超过20	*/


	
