$(function(){
	
	divLiBar2("mainbar","personalCenter");   //主导航背景底边框
	
	
	divLiBar("divTopBarContainer");   //展开头部右边详细
	
	userBuyCart();  				/*头部展开用户/购物车信息详细 */
	
	
	
	divLiBar("divListUL");   //list背景变化
	
	
	
	achieveBelowInput("divdropDownPartType","divdropDownViewPartType")					/*获取下拉框值并隐藏	约拍类型*/
	achieveBelowInput("divdropDownState","divdropDownViewState")					/*获取下拉框值并隐藏	约拍状态*/
	achieveBelowInput("divdropDownTime","divdropDownViewTime")					/*获取下拉框值并隐藏	时间*/
	
});

