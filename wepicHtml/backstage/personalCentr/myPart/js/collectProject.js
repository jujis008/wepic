$(function(){
	
	divLiBar2("mainbar","personalCenter");   //主导航背景底边框
	
	
	divLiBar("divTopBarContainer");   //展开头部右边详细
	
	userBuyCart();  				/*头部展开用户/购物车信息详细 */
	
	
	achieveBelow("divdropDownPartType","divdropDownViewPartType")					/*获取下拉框值并隐藏	拍摄类型*/
	
	achieveBelow("divdropDownCopyright","divdropDownViewCopyright")					/*获取下拉框值并隐藏	拍摄类型*/
	
	achieveBelow("divdropDownBidType","divdropDownViewBidType")					/*获取下拉框值并隐藏	招标方式*/
	
	createHour("divdropDownStartHour");		/*获取小时	00-23时*/
	
	achieveBelow("divdropDownStartHour","divdropDownViewStartHour")					/*获取下拉框值并隐藏	24小时1*/


	
	divLiBar("ULUpload");   //显示上传删除
	
	
	chooseRelType();
	//hideSelect();
});

function deleteFile(obj){
	if(confirm("确定删除吗?")){
		$(obj).parents("li").remove();
	}
}