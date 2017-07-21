$(function(){
	
	divLiBar2("mainbar","personalCenter");   //主导航背景底边框
	
	divLiBar("divTopBarContainer");   //展开头部右边详细
	
	userBuyCart();  				/*头部展开用户/购物车信息详细 */
	
	achieveBelow("divSelectdespecialValue","selectdespecialValue")					/*获取下拉框值并隐藏	默认专辑*/
	
	
	achieveBelow("divSelectdeTypeValue","selectdeTypeValue")					/*获取下拉框值并隐藏	所有类型*/
	
	achieveBelow("divSelectdeStateValue","selectdeStateValue")					/*获取下拉框值并隐藏	所有作品状态*/
	
	
	divLiBar("phoStroyContent");   //展开头部右边详细
	
	

});