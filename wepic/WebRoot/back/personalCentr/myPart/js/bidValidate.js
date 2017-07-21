function vlidateForm(){
	var name=$.trim($("input[name='name']").val());
	if(name==null||name==""||name.length>20){
		getpos($("input[name='name']"));
		return false;
	}
	
	var bidtype=$("#chooseProductType").find(".active").text();
	//alert(text==null||text==""||text.length<=0);
	if(bidtype==null||bidtype==""||bidtype.length<=0){
		$("#chooseProductType").parents(".productType").find(".top").find(".character"). append("<span style='color:red'>&nbsp;&nbsp;&nbsp;&nbsp;请选择产品类型</span>");
		getpos($("#chooseProductType"));
		return false;
	}
	var phototype=$("#chooseShootWay").find(".active").text();
	if(phototype==null||phototype==""||phototype.length<=0){
		$("#chooseShootWay").parent().prev(). append("<span style='color:red'>&nbsp;&nbsp;&nbsp;&nbsp;请选择拍摄方式</span>");
		getpos(getpos($("#chooseProductType")));
		return false;
	}
	
	var chooseShootEnv=$("#chooseShootEnv").find(".active").text();
	if(chooseShootEnv==null||chooseShootEnv==""||chooseShootEnv.length<=0){
		$("#chooseShootEnv").parent().prev().append("<span style='color:red'>&nbsp;请选择拍摄环境</span>");
		getpos($("#chooseShootEnv"));
		return false;
	}
	
	
	var chooseShootModel=$("#chooseShootModel").find(".active").text();
	if(chooseShootModel==null||chooseShootModel==""||chooseShootModel.length<=0){
		$("#chooseShootModel").parent().prev().append("<span style='color:red'>&nbsp;&nbsp;&nbsp;&nbsp;请选择拍摄产品模特需求</span>");
		getpos($("#chooseShootModel"));
		return false;
	}
	
	var chooseShootjijia=$("#chooseShootjijia").find(".active").text();
	if(chooseShootjijia==null||chooseShootjijia==""||chooseShootjijia.length<=0){
		$("#chooseShootjijia").parent().prev().append("<span style='color:red'>&nbsp;&nbsp;&nbsp;&nbsp;请选择计价方式</span>");
		getpos($("#chooseShootjijia"));
		return false;
	}
	var txtBeginDate=$("#txtBeginDate").val();
	if(txtBeginDate==null||txtBeginDate==""){
		$("#txtBeginDate").parent().prev().append("<span style='color:red'>&nbsp;&nbsp;&nbsp;&nbsp;请选择拍摄时间</span>");
		getpos($("#txtBeginDate"));
		return false;
	}
	
	var txtEndDate=$("#txtEndDate").val();
	if(txtEndDate==null||txtEndDate==""){
		$("#txtEndDate").parent().prev().append("<span style='color:red'>&nbsp;&nbsp;&nbsp;&nbsp;请选择交付日期</span>");
		getpos($("#txtEndDate"));
		return false;
	}
	var unitpriceProduct=$("input[name='unitpriceProduct']").val();
	
	if(unitpriceProduct==null||unitpriceProduct==""){
		$("input[name='unitpriceProduct']").parent().prev().append("<span style='color:red'>&nbsp;&nbsp;&nbsp;&nbsp;请选择拍摄单价</span>");
		getpos($("input[name='unitpriceProduct']"));
		return false;
	}
	
	var chooseShootzbfs=$("#chooseShootzbfs").find(".active").text();
	//alert(text==null||text==""||text.length<=0);
	if(chooseShootzbfs==null||chooseShootzbfs==""||chooseShootzbfs.length<=0){
		$("#chooseShootzbfs").parents(".productType").find(".top").find(".character"). append("<span style='color:red'>&nbsp;&nbsp;&nbsp;&nbsp;请选择招标方式</span>");
		getpos($("#chooseShootzbfs"));
		return false;
	}
	
	
	
	
	
	
	
	return true;
}



function vlidateFormCp(){
	var name=$.trim($("input[name='name']").val());
	if(name==null||name==""||name.length>20){
		getpos($("input[name='name']"));
		return false;
	}
	
	var bidtype=$("#chooseProductType").find(".active").text();
	//alert(text==null||text==""||text.length<=0);
	if(bidtype==null||bidtype==""||bidtype.length<=0){
		$("#chooseProductType").parents(".productType").find(".top").find(".character"). append("<span style='color:red'>&nbsp;&nbsp;&nbsp;&nbsp;请选择产品类型</span>");
		getpos($("#chooseProductType"));
		return false;
	}
	var phototype=$("#chooseShootWay").find(".active").text();
	if(phototype==null||phototype==""||phototype.length<=0){
		$("#chooseShootWay").parent().prev(). append("<span style='color:red'>&nbsp;&nbsp;&nbsp;&nbsp;请选择拍摄方式</span>");
		getpos(getpos($("#chooseProductType")));
		return false;
	}
	
	var chooseShootEnv=$("#chooseShootEnv").find(".active").text();
	if(chooseShootEnv==null||chooseShootEnv==""||chooseShootEnv.length<=0){
		$("#chooseShootEnv").parent().prev().append("<span style='color:red'>&nbsp;请选择拍摄环境</span>");
		getpos($("#chooseShootEnv"));
		return false;
	}
	
	
//	var chooseShootModel=$("#chooseShootModel").find(".active").text();
//	if(chooseShootModel==null||chooseShootModel==""||chooseShootModel.length<=0){
//		$("#chooseShootModel").parent().prev().append("<span style='color:red'>&nbsp;&nbsp;&nbsp;&nbsp;请选择拍摄产品模特需求</span>");
//		getpos($("#chooseShootModel"));
//		return false;
//	}
	
	var chooseShootjijia=$("#chooseShootjijia").find(".active").text();
	if(chooseShootjijia==null||chooseShootjijia==""||chooseShootjijia.length<=0){
		$("#chooseShootjijia").parent().prev().append("<span style='color:red'>&nbsp;&nbsp;&nbsp;&nbsp;请选择计价方式</span>");
		getpos($("#chooseShootjijia"));
		return false;
	}
	var txtBeginDate=$("#txtBeginDate").val();
	if(txtBeginDate==null||txtBeginDate==""){
		$("#txtBeginDate").parent().prev().append("<span style='color:red'>&nbsp;&nbsp;&nbsp;&nbsp;请选择拍摄时间</span>");
		getpos($("#txtBeginDate"));
		return false;
	}
	
	var txtEndDate=$("#txtEndDate").val();
	if(txtEndDate==null||txtEndDate==""){
		$("#txtEndDate").parent().prev().append("<span style='color:red'>&nbsp;&nbsp;&nbsp;&nbsp;请选择交付日期</span>");
		getpos($("#txtEndDate"));
		return false;
	}
	var unitpriceProduct=$("input[name='unitpriceProduct']").val();
	
	if(unitpriceProduct==null||unitpriceProduct==""){
		$("input[name='unitpriceProduct']").parent().prev().append("<span style='color:red'>&nbsp;&nbsp;&nbsp;&nbsp;请选择拍摄单价</span>");
		getpos($("input[name='unitpriceProduct']"));
		return false;
	}
	
	var chooseShootzbfs=$("#chooseShootzbfs").find(".active").text();
	//alert(text==null||text==""||text.length<=0);
	if(chooseShootzbfs==null||chooseShootzbfs==""||chooseShootzbfs.length<=0){
		$("#chooseShootzbfs").parents(".productType").find(".top").find(".character"). append("<span style='color:red'>&nbsp;&nbsp;&nbsp;&nbsp;请选择招标方式</span>");
		getpos($("#chooseShootzbfs"));
		return false;
	}
	
	
	
	
	
	
	
	return true;
}

