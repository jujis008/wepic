$(function(){
	divLiBar("divMainList");   //list内容显示收藏
	
	divLiBar2("mainbar","mainbarCenterLi2");   //主导航背景底边框
	
	divLiBar("divTopBarContainer");   //展开头部右边详细
	
	divLiBar("topBarShoppingDetailed");   //头部购物车展开列表背景
	
	userBuyCart();  				/*头部展开用户/购物车信息详细 */

	divLiBarClick("filterWrapperSort");   //排序
	
	});
	
	