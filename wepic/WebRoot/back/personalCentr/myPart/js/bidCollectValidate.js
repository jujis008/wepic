/*
 * 
 * 作品征集验证
 * 
 */
function bidValidateCollect(){
	var name=$.trim($("input[name='name']").val());
	if(name==null||name==""||name.length>20){
		getpos($("input[name='name']"));
		return false;
	}
	var bidtype=$("#chooseProductType").find(".active").text();
	//alert(text==null||text==""||text.length<=0);
	if(bidtype==null||bidtype==""||bidtype.length<=0){
		//$("#chooseProductType").parents(".productType").find(".top").find(".character"). append("<span style='color:red'>&nbsp;&nbsp;&nbsp;&nbsp;请选择产品类型</span>");
		getpos($("#chooseProductType"));
		return false;
	}
	var contextHtml=$.trim($("textarea[name='contextHtml']").val());
	
	if(contextHtml==null||contextHtml==""||contextHtml.length>300){
		getpos($("textarea[name='contextHtml']"));
		return false;
	}
	
   var txtEndDate=$("#txtEndDate").val();
   
   if(txtEndDate==null||txtEndDate==""){
		getpos($("#txtEndDate"));
		return false;
	}
	var chooseShootCopyright=$("#chooseShootCopyright").find(".active").text();
		
		//var bidtype=
	//alert(text==null||text==""||text.length<=0);
	if(chooseShootCopyright==null||chooseShootCopyright==""||chooseShootCopyright.length<=0){
		//$("#chooseProductType").parents(".productType").find(".top").find(".character"). append("<span style='color:red'>&nbsp;&nbsp;&nbsp;&nbsp;请选择产品类型</span>");
		getpos($("#chooseShootCopyright"));
		return false;
	}
	
	var unitpriceProduct=$.trim($("input[name='unitpriceProduct']").val());
	if(unitpriceProduct==null||unitpriceProduct==""||unitpriceProduct.length>20){
		getpos($("input[name='unitpriceProduct']"));
		return false;
	}
	
	
	
	
	return true;
	
}











/*
 * 
 * 作品征集设计,
 * 
 */
function bidValidateCollectSj(){
	var name=$.trim($("input[name='name']").val());
	if(name==null||name==""||name.length>20){
		getpos($("input[name='name']"));
		return false;
	}
	var bidtype=$("#chooseProductType").find(".active").text();
	//alert(text==null||text==""||text.length<=0);
	if(bidtype==null||bidtype==""||bidtype.length<=0){
		//$("#chooseProductType").parents(".productType").find(".top").find(".character"). append("<span style='color:red'>&nbsp;&nbsp;&nbsp;&nbsp;请选择产品类型</span>");
		getpos($("#chooseProductType"));
		return false;
	}
	var aboutIndustryOne=$("#aboutIndustryOne").is(":hidden");
	if(!aboutIndustryOne){
		var chooseedytext=$("#chooseedytext").val();
		if(chooseedytext==null||chooseedytext==""){
			getpos($("#aboutIndustryOne"));
			return false;
		}
		
		
	}
	
	
	var aboutIndustryTwo=$("#aboutIndustryTwo").is(":hidden");
	if(!aboutIndustryTwo){
		var applicationVis=$("#iframeChooseIndustryVI").find("iframe").contents().find("#applicationVis");
		if($("#applicationVis").find("div").length<=0){
			getpos($("#aboutIndustryTwo"));
			
			
		}
		
		
	}
	
	
	
	
	
	
	
	/*
	var contextHtml=$.trim($("textarea[name='contextHtml']").val());
	
	if(contextHtml==null||contextHtml==""||contextHtml.length>300){
		getpos($("textarea[name='contextHtml']"));
		return false;
	}
	*/
	
	
   var txtEndDate=$("#txtEndDate").val();
   if(txtEndDate==null||txtEndDate==""){
		getpos($("#txtEndDate"));
		return false;
	}
   
	var chooseShootCopyright=$("#chooseShootCopyright").find(".active").text();
		
	//var bidtype=
	//alert(text==null||text==""||text.length<=0);
	if(chooseShootCopyright==null||chooseShootCopyright==""||chooseShootCopyright.length<=0){
		//$("#chooseProductType").parents(".productType").find(".top").find(".character"). append("<span style='color:red'>&nbsp;&nbsp;&nbsp;&nbsp;请选择产品类型</span>");
		getpos($("#chooseShootCopyright"));
		return false;
	}
	
	
	var money=$.trim($("#totalMoney").val());
	if(money==null||money==""){
		getpos($("#totalMoney"));
		return false;
	}
	/*
	var unitpriceProduct=$.trim($("input[name='unitpriceProduct']").val());
	if(unitpriceProduct==null||unitpriceProduct==""||unitpriceProduct.length>20){
		getpos($("input[name='unitpriceProduct']"));
		return false;
	}
	*/
	
	
	
	return true;
	
}








