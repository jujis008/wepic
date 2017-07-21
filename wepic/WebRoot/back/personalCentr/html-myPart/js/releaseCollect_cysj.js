$(function(){


divLiBarClickProduct("chooseProductType");			//作品类型


divLiBarClick("chooseShootCopyright");			//版权需求


divLiBarClickBid("chooseShootzbfs");			//招标方式

document.getElementById("formshootProduct").reset();


weizhi();


divLiBarClickFileFormat("chooseShootSourceFileFormat");			//源文件格式


	divLiBar("ULUpload");   //显示上传删除
});

function deleteFile(obj){
	if(confirm("确定删除吗?")){
		$(obj).parents("li").remove();
	}
}


//作品类型
function divLiBarClickProduct(divName){
	var allMainBarLi=$("#"+divName).find("li");
	
	var allCustomli=$("#"+divName).find(".customli");
	
	
	$(allMainBarLi).each(function(){
			$(this).click(function(){
				
				$("#uploadAccessory").hide();				//隐藏上传附件
				
				
				$("#aboutIndustryOne").show();				//所属行业
				
				$("#divWorkDemand").show();					//作品要求
				$("#aboutIndustryTwo").hide();					//选择行业2
				
				
				var allMainBarLi=$("#"+divName).find("li").each(function() {$(this).removeClass("active");});
				$(this).addClass("active");
				
				var value = $(this).find("span").html();
				
				switch(value){
					case "logo设计":
					  $("#divThreeCon").html(                        
                        '<div class="shootWayCon shootSourceFileFormat">'+
                            '<span class="spanChar">源文件格式</span>'+
                            '<ul id="chooseShootSourceFileFormat">'+
                                '<li class="active"><span>矢量</span><i></i></li>'+
                            '</ul>'+
                        '</div>'+
                    
                        '<div class="divNum">'+
                           '<span class="spanChar">征集数量</span>'+
                           '<input class="subtract" type="button" onclick="subtractProductNum(' + 'inputproductNum'  +  ');"/>'+
                           '<input class="numinput" type="text" id="inputproductNum" value="1" onkeyup="onlyWriteNum(this);" onafterpaste="onlyWriteNum(this);"/>'+
                           '<input class="plus" type="button" onclick="plusProductNum(' + 'inputproductNum'  +  ');"/>'+
                           '<span class="nums">件</span>'+
                        '</div>'+
                        
                        
                        '<div class="time" id="choseTime2">'+
                            '<span class="spanChar">征集截止日期</span>'+
                            '<input class="timeInputStr" id="txtEndDate" type="text" readonly="true"/>'+
                        '</div>');
						timInit();
						
						$("#pricespSpan").html('元/件');
					  break;
					  
					  
					case "VI设计":
					  $("#divThreeCon").html(                    
                        '<div class="divNum">'+
                           '<span class="spanChar">征集数量</span>'+
                           '<input class="subtract" type="button" onclick="subtractProductNum(' + 'inputproductNum'  +  ');"/>'+
                           '<input class="numinput" type="text" id="inputproductNum" value="1" onkeyup="onlyWriteNum(this);" onafterpaste="onlyWriteNum(this);"/>'+
                           '<input class="plus" type="button" onclick="plusProductNum(' + 'inputproductNum'  +  ');"/>'+
                           '<span class="nums">件</span>'+
                        '</div>'+
                        
                        '<div class="time" id="choseTime2">'+
                            '<span class="spanChar">征集截止日期</span>'+
                            '<input class="timeInputStr" id="txtEndDate" type="text" readonly="true"/>'+
                        '</div>');
						timInit();
						$("#uploadAccessory").show();				//显示上传附件
						
						$("#pricespSpan").html('元/件');
						
						$("#divWorkDemand").hide();					//作品要求
						$("#aboutIndustryTwo").show();					//选择行业2
					  break;
					  
					case "名片设计":
					  $("#divThreeCon").html(
						'<div class="workStandard">'+
                            '<span class="spanChar">作品规格</span>'+
                            '<input class="numinput" type="text" onkeyup="onlyWriteNum(this);" onafterpaste="onlyWriteNum(this);"/>'+
                            '<span>×</span>'+
                            '<input class="numinput" type="text" onkeyup="onlyWriteNum(this);"  onafterpaste="onlyWriteNum(this);"/>'+
                            '<span class="mm">cm</span><span>不填即不限</span>'+
                       '</div>'+
                        
                        '<div class="shootWayCon shootSourceFileFormat">'+
                            '<span class="spanChar">源文件格式</span>'+
                            '<ul id="chooseShootSourceFileFormat">'+
                                '<li class="active"><span>矢量</span><i></i></li>'+
                            '</ul>'+
                        '</div>'+
                    
                        '<div class="divNum">'+
                           '<span class="spanChar">征集数量</span>'+
                           '<input class="subtract" type="button" onclick="subtractProductNum(' + 'inputproductNum'  +  ');"/>'+
                           '<input class="numinput" type="text" id="inputproductNum" value="1" onkeyup="onlyWriteNum(this);" onafterpaste="onlyWriteNum(this);"/>'+
                           '<input class="plus" type="button" onclick="plusProductNum(' + 'inputproductNum'  +  ');"/>'+
                           '<span class="nums">件</span>'+
                        '</div>'+
                        
                        '<div class="time" id="choseTime2">'+
                            '<span class="spanChar">征集截止日期</span>'+
                            '<input class="timeInputStr" id="txtEndDate" type="text" readonly="true"/>'+
                        '</div>');
						timInit();
						$("#uploadAccessory").show();				//显示上传附件
						
						$("#pricespSpan").html('元/件');
					  break;
					  
					  
					case "网站设计":
					case "UI界面设计":
					  $("#divThreeCon").html(
						'<div class="workStandard">'+
                            '<span class="spanChar">作品规格</span>'+
                            '<input class="numinput" type="text" onkeyup="onlyWriteNum(this);" onafterpaste="onlyWriteNum(this);"/>'+
                            '<span>×</span>'+
                            '<input class="numinput" type="text" onkeyup="onlyWriteNum(this);"  onafterpaste="onlyWriteNum(this);"/>'+
                            '<span class="mm">px</span><span>不填即不限</span>'+
                       '</div>'+
                        
                        '<div class="shootWayCon shootSourceFileFormat">'+
                            '<span class="spanChar">源文件格式</span>'+
                            '<ul id="chooseShootSourceFileFormat">'+
                                '<li class="active"><span>位图</span><i></i></li>'+
                            '</ul>'+
                        '</div>'+
                        
                        '<div class="workStandard workStandardcytp" id="divWorkStandardcytp">'+
                            '<span class="spanChar">作品精度/分辨率</span>'+
                            '<input class="numinput" type="text" onkeyup="onlyWriteNum(this);" onafterpaste="onlyWriteNum(this);"/>'+
                            '<span>dpi</span>'+
                       	'</div>'+
                    
                        '<div class="divNum">'+
                           '<span class="spanChar">征集数量</span>'+
                           '<input class="subtract" type="button" onclick="subtractProductNum(' + 'inputproductNum'  +  ');"/>'+
                           '<input class="numinput" type="text" id="inputproductNum" value="1" onkeyup="onlyWriteNum(this);" onafterpaste="onlyWriteNum(this);"/>'+
                           '<input class="plus" type="button" onclick="plusProductNum(' + 'inputproductNum'  +  ');"/>'+
                           '<span class="nums">页</span>'+
                        '</div>'+
                        
                        '<div class="time" id="choseTime2">'+
                            '<span class="spanChar">征集截止日期</span>'+
                            '<input class="timeInputStr" id="txtEndDate" type="text" readonly="true"/>'+
                        '</div>');
						timInit();
						$("#uploadAccessory").show();				//显示上传附件
						
						$("#pricespSpan").html('元/页');
					  break;
					  
					  case "海报招贴设计" :
					  case "平面广告设计":
					  case "产品手册":
					  case "宣传手册":
					  	$("#divThreeCon").html(
						'<div class="workStandard">'+
                            '<span class="spanChar">作品规格</span>'+
                            '<input class="numinput" type="text" onkeyup="onlyWriteNum(this);" onafterpaste="onlyWriteNum(this);"/>'+
                            '<span>×</span>'+
                            '<input class="numinput" type="text" onkeyup="onlyWriteNum(this);"  onafterpaste="onlyWriteNum(this);"/>'+
                            '<span class="mm">cm</span><span>不填即不限</span>'+
                       '</div>'+
                                            
                        '<div class="divNum">'+
                           '<span class="spanChar">征集数量</span>'+
                           '<input class="subtract" type="button" onclick="subtractProductNum(' + 'inputproductNum'  +  ');"/>'+
                           '<input class="numinput" type="text" id="inputproductNum" value="1" onkeyup="onlyWriteNum(this);" onafterpaste="onlyWriteNum(this);"/>'+
                           '<input class="plus" type="button" onclick="plusProductNum(' + 'inputproductNum'  +  ');"/>'+
                           '<span class="nums">页</span>'+
                        '</div>'+
                        
                        '<div class="time" id="choseTime2">'+
                            '<span class="spanChar">征集截止日期</span>'+
                            '<input class="timeInputStr" id="txtEndDate" type="text" readonly="true"/>'+
                        '</div>');
						timInit();
						$("#uploadAccessory").show();				//显示上传附件
						
						$("#pricespSpan").html('元/页');
					  break;
					  
					  
					  case "展览展厅设计" :
					  
					  $("#divThreeCon").html(
						'<div class="workStandard">'+
                            '<span class="spanChar">展厅规格</span>'+
                            '<input class="numinput" type="text" onkeyup="onlyWriteNum(this);" onafterpaste="onlyWriteNum(this);"/>'+
                            '<span>×</span>'+
                            '<input class="numinput" type="text" onkeyup="onlyWriteNum(this);"  onafterpaste="onlyWriteNum(this);"/>'+
                            '<span class="mm">m</span><span>不填即不限</span>'+
                       '</div>'+
                                            
                        '<div class="divNum">'+
                           '<span class="spanChar">征集数量</span>'+
                           '<input class="subtract" type="button" onclick="subtractProductNum(' + 'inputproductNum'  +  ');"/>'+
                           '<input class="numinput" type="text" id="inputproductNum" value="1" onkeyup="onlyWriteNum(this);" onafterpaste="onlyWriteNum(this);"/>'+
                           '<input class="plus" type="button" onclick="plusProductNum(' + 'inputproductNum'  +  ');"/>'+
                           '<span class="nums">㎡</span>'+
                        '</div>'+
                        
                        '<div class="time" id="choseTime2">'+
                            '<span class="spanChar">征集截止日期</span>'+
                            '<input class="timeInputStr" id="txtEndDate" type="text" readonly="true"/>'+
                        '</div>');
						timInit();
					  
						$("#uploadAccessory").show();				//显示上传附件
						
						$("#pricespSpan").html('元/㎡');
					  break;
					  
					  
					  
					  case "产品造型设计":
					  $("#divThreeCon").html(
                        '<div class="divNum">'+
                           '<span class="spanChar">征集数量</span>'+
                           '<input class="subtract" type="button" onclick="subtractProductNum(' + 'inputproductNum'  +  ');"/>'+
                           '<input class="numinput" type="text" id="inputproductNum" value="1" onkeyup="onlyWriteNum(this);" onafterpaste="onlyWriteNum(this);"/>'+
                           '<input class="plus" type="button" onclick="plusProductNum(' + 'inputproductNum'  +  ');"/>'+
                           '<span class="nums">件</span>'+
                        '</div>'+
                        
                        '<div class="time" id="choseTime2">'+
                            '<span class="spanChar">征集截止日期</span>'+
                            '<input class="timeInputStr" id="txtEndDate" type="text" readonly="true"/>'+
                        '</div>');
						timInit();
						$("#uploadAccessory").show();				//显示上传附件
						
						$("#pricespSpan").html('元/件');
						
						
						$("#aboutIndustryOne").hide();				//所属行业
					  break;
					  
					  case "包装设计":
					  $("#divThreeCon").html(
						'<div class="workStandard">'+
                            '<span class="spanChar">包装尺寸</span>'+
                            '<input class="numinput" type="text" onkeyup="onlyWriteNum(this);" onafterpaste="onlyWriteNum(this);"/>'+
                            '<span>×</span>'+
                            '<input class="numinput" type="text" onkeyup="onlyWriteNum(this);"  onafterpaste="onlyWriteNum(this);"/>'+
                            '<span class="mm">cm</span><span>不填即不限</span>'+
                       '</div>'+
                        
                        '<div class="shootWayCon shootSourceFileFormat">'+
                            '<span class="spanChar">源文件格式</span>'+
                            '<ul id="chooseShootSourceFileFormat">'+
                                '<li class="active"><span>矢量</span><i></i></li>'+
                            '</ul>'+
                        '</div>'+
						
                        '<div class="divNum">'+
                           '<span class="spanChar">征集数量</span>'+
                           '<input class="subtract" type="button" onclick="subtractProductNum(' + 'inputproductNum'  +  ');"/>'+
                           '<input class="numinput" type="text" id="inputproductNum" value="1" onkeyup="onlyWriteNum(this);" onafterpaste="onlyWriteNum(this);"/>'+
                           '<input class="plus" type="button" onclick="plusProductNum(' + 'inputproductNum'  +  ');"/>'+
                           '<span class="nums">件</span>'+
                        '</div>'+
                        
                        '<div class="time" id="choseTime2">'+
                            '<span class="spanChar">征集截止日期</span>'+
                            '<input class="timeInputStr" id="txtEndDate" type="text" readonly="true"/>'+
                        '</div>');
						timInit();
						$("#uploadAccessory").show();				//显示上传附件
						
						$("#pricespSpan").html('元/件');
						
						$("#aboutIndustryOne").hide();				//所属行业
					  break;
					  
					  case "建筑设计":
					  $("#divThreeCon").html(
                        '<div class="shootWayCon shootSourceFileFormat">'+
                            '<span class="spanChar">源文件格式</span>'+
                            '<ul id="chooseShootSourceFileFormat">'+
                                '<li class="active"><span>矢量</span><i></i></li>'+
                            '</ul>'+
                        '</div>'+
						
                        '<div class="divNum">'+
                           '<span class="spanChar">征集数量</span>'+
                           '<input class="subtract" type="button" onclick="subtractProductNum(' + 'inputproductNum'  +  ');"/>'+
                           '<input class="numinput" type="text" id="inputproductNum" value="1" onkeyup="onlyWriteNum(this);" onafterpaste="onlyWriteNum(this);"/>'+
                           '<input class="plus" type="button" onclick="plusProductNum(' + 'inputproductNum'  +  ');"/>'+
                           '<span class="nums">件</span>'+
                        '</div>'+
                        
                        '<div class="time" id="choseTime2">'+
                            '<span class="spanChar">征集截止日期</span>'+
                            '<input class="timeInputStr" id="txtEndDate" type="text" readonly="true"/>'+
                        '</div>');
						timInit();
						
						$("#pricespSpan").html('元/件');
						
						$("#aboutIndustryOne").hide();				//所属行业
					  break;
					  
					  case "服装设计":
					  $("#divThreeCon").html(
						
                        '<div class="divNum">'+
                           '<span class="spanChar">征集数量</span>'+
                           '<input class="subtract" type="button" onclick="subtractProductNum(' + 'inputproductNum'  +  ');"/>'+
                           '<input class="numinput" type="text" id="inputproductNum" value="1" onkeyup="onlyWriteNum(this);" onafterpaste="onlyWriteNum(this);"/>'+
                           '<input class="plus" type="button" onclick="plusProductNum(' + 'inputproductNum'  +  ');"/>'+
                           '<span class="nums">件</span>'+
                        '</div>'+
                        
                        '<div class="time" id="choseTime2">'+
                            '<span class="spanChar">征集截止日期</span>'+
                            '<input class="timeInputStr" id="txtEndDate" type="text" readonly="true"/>'+
                        '</div>');
						timInit();
						
						$("#pricespSpan").html('元/件');
					  break;
					  
					   case "标识符号设计":
					  $("#divThreeCon").html(
						'<div class="workStandard">'+
                            '<span class="spanChar">作品规格</span>'+
                            '<input class="numinput" type="text" onkeyup="onlyWriteNum(this);" onafterpaste="onlyWriteNum(this);"/>'+
                            '<span>×</span>'+
                            '<input class="numinput" type="text" onkeyup="onlyWriteNum(this);"  onafterpaste="onlyWriteNum(this);"/>'+
                            '<span class="mm">cm</span><span>不填即不限</span>'+
                       '</div>'+
                        
                        '<div class="shootWayCon shootSourceFileFormat">'+
                            '<span class="spanChar">源文件格式</span>'+
                            '<ul id="chooseShootSourceFileFormat">'+
                                '<li class="active"><span>位图</span><i></i></li>'+
                                '<li><span>矢量</span><i></i></li>'+
                            '</ul>'+
                        '</div>'+
						
                        '<div class="workStandard workStandardcytp" id="divWorkStandardcytp">'+
                            '<span class="spanChar">作品精度/分辨率</span>'+
                            '<input class="numinput" type="text" onkeyup="onlyWriteNum(this);" onafterpaste="onlyWriteNum(this);"/>'+
                            '<span>dpi</span>'+
                       	'</div>'+
						
                        '<div class="divNum">'+
                           '<span class="spanChar">征集数量</span>'+
                           '<input class="subtract" type="button" onclick="subtractProductNum(' + 'inputproductNum'  +  ');"/>'+
                           '<input class="numinput" type="text" id="inputproductNum" value="1" onkeyup="onlyWriteNum(this);" onafterpaste="onlyWriteNum(this);"/>'+
                           '<input class="plus" type="button" onclick="plusProductNum(' + 'inputproductNum'  +  ');"/>'+
                           '<span class="nums">套</span>'+
                        '</div>'+
                        
                        '<div class="time" id="choseTime2">'+
                            '<span class="spanChar">征集截止日期</span>'+
                            '<input class="timeInputStr" id="txtEndDate" type="text" readonly="true"/>'+
                        '</div>');
						timInit();
						
						$("#pricespSpan").html('元/套');
						
						$("#aboutIndustryOne").hide();				//所属行业
					  break;
					  
					}
				//switch结束
				
				divLiBarClickFileFormat("chooseShootSourceFileFormat");		//源文件格式
				$("#chooseShootSourceFileFormat > li:first-child").click();
				
			});	
  });
  
  
  $(allCustomli).each(function(){
			$(this).click(function(){
				$("#divThreeCon").html(
						'<div class="workStandard">'+
                            '<span class="spanChar">作品规格</span>'+
                            '<input class="numinput" type="text" onkeyup="onlyWriteNum(this);" onafterpaste="onlyWriteNum(this);"/>'+
                            '<span>×</span>'+
                            '<input class="numinput" type="text" onkeyup="onlyWriteNum(this);"  onafterpaste="onlyWriteNum(this);"/>'+
                            '<span class="mm">cm</span><span>不填即不限</span>'+
                       '</div>'+
                        
                        '<div class="shootWayCon shootSourceFileFormat">'+
                            '<span class="spanChar">源文件格式</span>'+
                            '<ul id="chooseShootSourceFileFormat">'+
                                '<li class="active"><span>位图</span><i></i></li>'+
                                '<li><span>矢量</span><i></i></li>'+
                            '</ul>'+
                        '</div>'+
						
                        '<div class="workStandard workStandardcytp" id="divWorkStandardcytp">'+
                            '<span class="spanChar">作品精度/分辨率</span>'+
                            '<input class="numinput" type="text" onkeyup="onlyWriteNum(this);" onafterpaste="onlyWriteNum(this);"/>'+
                            '<span>dpi</span>'+
                       	'</div>'+
						
                        '<div class="divNum">'+
                           '<span class="spanChar">征集数量</span>'+
                           '<input class="subtract" type="button" onclick="subtractProductNum(' + 'inputproductNum'  +  ');"/>'+
                           '<input class="numinput" type="text" id="inputproductNum" value="1" onkeyup="onlyWriteNum(this);" onafterpaste="onlyWriteNum(this);"/>'+
                           '<input class="plus" type="button" onclick="plusProductNum(' + 'inputproductNum'  +  ');"/>'+
                           '<span class="nums">套</span>'+
                        '</div>'+
                        
                        '<div class="time" id="choseTime2">'+
                            '<span class="spanChar">征集截止日期</span>'+
                            '<input class="timeInputStr" id="txtEndDate" type="text" readonly="true"/>'+
                        '</div>');
						timInit();
					divLiBarClickFileFormat("chooseShootSourceFileFormat");		//源文件格式
					$("#chooseShootSourceFileFormat > li:first-child").click();
					
				});	
			
  });
}	


function timInit(){
	$("#txtEndDate").calendar({
                controlId: "divDate2",                                       // 弹出的日期控件ID，默认: $(this).attr("id") + "Calendar"
                speed: 200,                                                 // 三种预定速度之一的字符串("slow", "normal", or "fast")或表示动画时长的毫秒数值(如：1000),默认：200
                complement: true,                                           // 是否显示日期或年空白处的前后月的补充,默认：true
                readonly: true,                                             // 目标对象是否设为只读，默认：true
               	addToDiv: "choseTime2"
                
            });
}

	
//源文件格式
function divLiBarClickFileFormat(divName){
	var allMainBarLi=$("#"+divName).find("li");
	
	$(allMainBarLi).each(function(){
			$(this).click(function(){
				$("#divWorkStandardcytp").show();				//显示图片精度
				var allMainBarLi=$("#"+divName).find("li").each(function() {$(this).removeClass("active");});
				$(this).addClass("active");
				
				var value = $(this).find("span").html();
				
				
				if(value == "矢量"){
					$("#divWorkStandardcytp").hide();				//影藏图片精度
					return;
					}
			});	
  });
  
}	











function viewCustom(){
	$("#customDiv").show();
	}



/*增加自定义标签个人*/
function addCustom(value,addDiv){
	var option = "" ;
	var addvalue = $("#"+value).val();
	
	$("#"+value).val("");
	
	
	var allSpan=$("#"+addDiv).find("li").find("span");
	
		
		//判断新增字段是否已存在
		
		for(var i = 0; i<allSpan.length; i++){
			if($(allSpan[i]).html() != addvalue ){
				}
			else{
				alert("不好意思，该标签已存在！");
				return;
				}
		}
	if(addvalue == '' || addvalue == null){
		alert("不好意思，职业标签名不能为空！");
		}
	else{
		option = '<li class="customli"><span>'+addvalue+'</span><i></i><a onclick="deleteLiFile(this);"></a></li>';
		}
	
	var customLi = $("#"+addDiv).find(".addCustomLi").html();
	var divClear = $("#"+addDiv).find(".divClear").html();
	$("#"+addDiv).find(".addCustomLi").remove();
	$("#"+addDiv).find(".divClear").remove();
				
	$("#"+addDiv).append(option);
	
	divLiBarClick("chooseProductType");	
	divLiBarClickProduct("chooseProductType");			//活动主题
	$("#chooseProductType >li:last-child").click();
	
	
	
	var customLiTo = '<div class="addCustomLi">' + customLi + '</div>';
	$("#"+addDiv).append(customLiTo);
	$("#customDiv").hide();
	$("#"+addDiv).append('<div class="divClear" style="clear:both;"></div>');
	
	
}
/*增加自定义标签个人*/



function plusProductNum(obj){
	var value = parseInt($(obj).val());
	$(obj).val(value+1);
	}
function subtractProductNum(obj){
	var value = parseInt($(obj).val());
	if(value>1){
		$(obj).val(value-1);
		}
	}




//计价方式
function divLiBarClickValuation(divName){
	var allMainBarLi=$("#"+divName).find("li");

	$(allMainBarLi).each(function(){
			$(this).click(function(){
				$("#collectUnivalence").hide();
				$("#collectTotalValue").hide();
				var allMainBarLi=$("#"+divName).find("li").each(function() {$(this).removeClass("active");});
				$(this).addClass("active");
				
				var value = $(this).find("span").html();
				if(value == "按件"){
					$("#collectUnivalence").show();
					}
				if(value == "总价"){
					$("#collectTotalValue").show();
					}
			});	
    });	
}



//招标方式
function divLiBarClickBid(divName){
	
	var allMainBarLi=$("#"+divName).find("li");
	
	$(allMainBarLi).each(function(){
			$(this).click(function(){
				
				$("#shootWayConSpanYQ").hide();
				$("#finished").removeAttr("disabled");
				$("#finished").css({"background":"url(../../../public/images/buttonGroup01.png) no-repeat 0 -1168px","color":"#fff","cursor":"pointer"});
				var allMainBarLi=$("#"+divName).find("li").each(function() {$(this).removeClass("active");});
				$(this).addClass("active");
				
				var values = $(this).find("span").html();
				
				if(values == "私密"){
	
					if(parseInt($("#invitationNum").html()) == 0){
						//alert(valuea);
						$("#shootWayConSpanYQ").show();
						$("#finished").attr("disabled","disabled");
						$("#finished").css({"background":"url(../../../public/images/buttonGroup01.png) no-repeat 0 -1136px","color":"#000","cursor":"default"});
					}
					return;
					}
			});	
    });
}

function verifyForm(){
	alert("333");
	}
function yyyyyyyy(){
	openPopUpBox('iframeChooseFriend');
	$("#iframeChooseFriend").html('<iframe name="child" style="border:0px;width:875px;height:765px" src="chooseFriend.html"></iframe>');
	
	
	
}

function openIndustry(){
	openPopUpBoxhy('iframeChooseIndustry');
	$("#iframeChooseIndustry").html('<iframe name="childIndustry" style="border:0px;width:980px;height:1155px;overflow:hidden;" src="../../../public/chooseIndustry.html"></iframe>');
	}

function submitBox(chooseed){
	$("#chooseIndustryValue").html(chooseed);
	}
	
	
	
	
	
function openIndustryVI(){
	openPopUpBoxhy('iframeChooseIndustryVI');
	$("#iframeChooseIndustryVI").html('<iframe name="childIndustryVI" style="border:0px;width:980px;height:1155px;overflow:hidden;" src="../../../public/chooseVI.html"></iframe>');
	}

function submitBoxVI(chooseed){
	$("#iframeChooseIndustryVI").html(chooseed);
	}
	
	

/*弹出层*/
function openPopUpBoxhy(divPopUpBox){
	var htmlWidth = document.body.clientWidth;
	var htmlHeight = document.body.clientHeight;
	var borwerViewWidth =  document.documentElement.clientWidth;
	var borwerViewHeight =  document.documentElement.clientHeight;
	
	var scrollTop = getScrollTop();
	
	
	var getw =$("#"+divPopUpBox).width();
	var geth = $("#"+divPopUpBox).height();
	
	if(getheight == '' || getheight == null){
		getheight = 0;
		}
		
	var getwidth = parseInt(getw);
	var getheight = parseInt(geth);
	
	var topWidth = (borwerViewWidth - getwidth)/2;
	var topHeight = (borwerViewHeight - getheight)/ 2;
	
	$("#greybackground").remove();
	$("body").prepend('<div id="greybackground" style="position:absolute; z-index:9999;background:black;display:none"></div>');
	$("html,body").animate({ scrollTop:0},0);
	//$("html,body").css({ "overflow": "hidden"});
	$("#greybackground").css({ "opacity": "0.8", "height": htmlHeight+"px","display":"block","width": htmlWidth+"px","background":"black","top":"0px","left":"0px"});
	$("#greybackground").show();
	
	$("#"+divPopUpBox).show();
	$("#"+divPopUpBox).css({ "position": "absolute","z-index":"10000","top": 40 + "px" , "left": topWidth + "px"});
	
	/*var qq = $("#greybackground").css("z-index");
	/*window.scrollTo(0,$(document).scrollTop());*/
	
}

//获取选择个数
function acheiveNumFriend(length){
	
	
	$("#invitationNum").html(length);
	judgePrivacy(length);
	}


//判断私密
function judgePrivacy(length){
	
	var allMainBarLi=$("#chooseShootzbfs").find("li");
	$(allMainBarLi).each(function(){
		if($(this).attr("class") == "active"){
			if($(this).find("span").html() == "私密"){
				
				if(length != 0){
					$("#shootWayConSpanYQ").hide();
					$("#finished").removeAttr("disabled");
					$("#finished").css({"background":"url(../../../public/images/buttonGroup01.png) no-repeat 0 -1168px","color":"#fff","cursor":"pointer"});
				}
			}
		}
	});
	
	}