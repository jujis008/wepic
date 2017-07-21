$(function(){


divLiBarClickProduct("chooseProductType");			//作品类型


divLiBarClick("chooseShootCopyright");			//版权需求


divLiBarClickBid("chooseShootzbfs");			//招标方式

document.getElementById("formshootProduct").reset();


weizhi();


divLiBarClickFileFormat("chooseShootSourceFileFormat");			//源文件格式


//divLiBar("ULUpload");   //显示上传删除
	
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
				$("#customDiv").hide();
				
				$("#uploadAccessory").show();				//显示上传附件
				
				$("#chooseShootSourceFileFormat").html('<li class="active"><span>位图</span><i></i></li><li><span>矢量</span><i></i></li><li><span>3D</span><i></i></li>');
				
				divLiBarClickFileFormat("chooseShootSourceFileFormat");		//源文件格式
				$("#chooseShootSourceFileFormat > li:first-child").click();
				
				
				var allMainBarLi=$("#"+divName).find("li").each(function() {$(this).removeClass("active");});
				$(this).addClass("active");
				
				var value = $(this).find("span").html();
				
				
				
				if(value == "壁纸"){
					$("#uploadAccessory").hide();				//影藏上传附件
					
					$("#chooseShootSourceFileFormat").html('<li class="active"><span>位图</span><i></i></li>');
					divLiBarClickFileFormat("chooseShootSourceFileFormat");			//源文件格式
					
					$("#chooseShootSourceFileFormat > li:first-child").click();
					return;
					}
			});	
  });
  
}	



//源文件格式
function divLiBarClickFileFormat(divName){
	var allMainBarLi=$("#"+divName).find("li");
	
	$(allMainBarLi).each(function(){
			$(this).click(function(){
				$("#spanWorkStandardcytp").show();				//显示图片精度
				$("#divWorkStandardcytp").show();				//显示图片精度
				var allMainBarLi=$("#"+divName).find("li").each(function() {$(this).removeClass("active");});
				$(this).addClass("active");
				
				var value = $(this).find("span").html();
				
				
				
				if(value == "矢量"){
					$("#spanWorkStandardcytp").hide();			//影藏图片精度
					$("#divWorkStandardcytp").hide();
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
	var value = parseInt($("#"+obj).val());
	$("#"+obj).val(value+1);
	}
function subtractProductNum(obj){
	var value = parseInt($("#"+obj).val());
	if(value>1){
		$("#"+obj).val(value-1);
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