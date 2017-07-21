$(function(){
	
	
	divLiBar2("mainbar","personalCenter");   //主导航背景底边框
	
	divLiBar("divTopBarContainer");   //展开头部右边详细
	
	userBuyCart();  				/*头部展开用户/购物车信息详细 */
	
	document.getElementById("formAccountEducation").reset();		//form表单重置*/
	
	
	createYear("divSelectGraduationDateYearValue");		/*获取年份		1914--2013*/
	
	createMonth("divSelectGraduationDateMonthValue");		/*获取月份		1-12月*/
	
	createDay("divSelectGraduationDateDayValue");		/*获取日		1-30日*/
	
	
	
	achieveBelow("divSelectGraduationDateYearValue","selectGraduationDateYearValue")				/*获取下拉框值并隐藏	年份*/
	
	achieveBelow("divSelectGraduationDateMonthValue","selectGraduationDateMonthValue")				/*获取下拉框值并隐藏	月份*/
	
	achieveBelow("divSelectGraduationDateDayValue","selectGraduationDateDayValue")					/*获取下拉框值并隐藏	月份*/
	
	achieveBelow("divSelectHighestDegreeValue","selectHighestDegreeValue")					/*获取下拉框值并隐藏	最高学历*/
	
	
	/*document.onclick = function(){
		$("#divSelectGraduationDateYearValue").hide();
		}*/
	});





	