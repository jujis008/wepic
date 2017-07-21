$(function(){
	divLiBar2("mainbar","personalCenter");   //主导航背景底边框
	
	divLiBar("divTopBarContainer");   //展开头部右边详细
	
	divLiBar("topBarShoppingDetailed");   //头部购物车展开列表背景
	
	userBuyCart();  				/*头部展开用户/购物车信息详细 */
	
	document.getElementById("formPersonInfo").reset();		//form表单重置*/
	
	createYear("divSelectBirthDayYearValue");		/*获取年份		1914--2013*/
	
	createMonth("divSelectBirthDayMonthValue");		/*获取月份		1-12月*/
	
	createDay("divSelectBirthDayDayValue");		/*获取日		1-30日*/
	
	achieveBelow("divSelectBirthDayYearValue","selectBirthDayYearValue")					/*获取下拉框值并隐藏	年份*/
	
	achieveBelow("divSelectBirthDayMonthValue","selectBirthDayMonthValue")					/*获取下拉框值并隐藏	月份*/
	
	achieveBelow("divSelectBirthDayDayValue","selectBirthDayDayValue")					/*获取下拉框值并隐藏	月份*/
	
	achieveBelow("divSelectSexValue","selectSexValue")					/*获取下拉框值并隐藏	性别*/
	
	achieveBelow("divSelectSxValue","selectSxValue")					/*获取下拉框值并隐藏	生肖*/
	
	achieveBelow("divSelectConstellationValue","selectConstellationValue")					/*获取下拉框值并隐藏	生肖*/
	
	achieveBelow("divSelectBltValue","selectBltValue")					/*获取下拉框值并隐藏	星座*/
	
	
	
	
	});
	
		
/*字节不超过10	*/
function getByteCount(str){
	return str.replace(/[^\x00-\xff]/g, "**").length;
	}
	var value;
function doit(obj){
	if(getByteCount(obj.value)>10){
		obj.value=value;
	}
	value=obj.value
} 
/*字节不超过10	*/

function addProModel(value,addDiv){
	var option = "" ;
	var addvalue = $("#"+value).val();
	
	$("#"+value).val("");
	
	var addoDiv=document.getElementById(addDiv);
	
	var addDivCon=addoDiv.getElementsByTagName("div");
	
		var addObj = [];
		for(var i=0;i<addDivCon.length;i++){
			if(addDivCon[i].className == "custom"){
				addObj[addObj.length] = addDivCon[i];
				}
		}
	if(addObj.length < 2){
		option = "<div class='custom'><span>"  + addvalue + "</span><input type='text'/><a href='javascript:' onclick='deleteProModel(this);' title='删除'></a></div>";
		}
	else{
		alert("新增项目只可以有两个！");
		}
		
	$("#"+addDiv).append(option);
	}
	
function deleteProModel(obj){
	 if(confirm("确定删除吗?")){
		$(obj).parent().remove();
	}
}