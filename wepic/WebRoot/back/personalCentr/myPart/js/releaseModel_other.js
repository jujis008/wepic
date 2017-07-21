$(function(){

divLiBarClickValuation("chooseValuation");			//计价方式



divLiBarClickBid("chooseShootzbfs");			//招标方式







divLiBarClick("chooseProductType");			//拍摄内容

divLiBarClick("chooseModelStyle");			//模特风格

divLiBarClick("chooseAgeReq");			//年龄要求

divLiBarClick("chooseSexReq");			//性别要求

//divLiBarClick("chooseShootType");			//工作内容

divLiBarClick("chooseShootEnv");			//拍摄环境





document.getElementById("formshootProduct").reset();

weizhi();
});


/*增加自定义标签个人*/
function addCustom(value,addDiv){
	var option = "" ;
	var addvalue = $("#"+value).val();
	
	$("#"+value).val("");
	
	var addoDiv=document.getElementById(addDiv);
	
	var addDivCon=addoDiv.getElementsByTagName("li");
	
		var addObj = [];
		for(var i=0;i<addDivCon.length;i++){
			if(addDivCon[i].className == "tag"){
				addObj[addObj.length] = addDivCon[i];
				}
		}
		
		
			//判断新增字段是否已存在
	var allSpan = $(addDivCon).find("span") ;
		
		for(var i = 0; i<allSpan.length; i++){
			if($(allSpan[i]).html() != addvalue ){
				}
			else{
				alert("不好意思，该标签已存在！");
				return;
				}
		}
	if(addvalue == '' || addvalue == null){
		alert("不好意思，标签名不能为空！");
		}
	else{
		option = '<li class="customli"><span>'+addvalue+'</span><i></i><a onclick="deleteLiFile(this);"></a></li>';
		}
	
		
	
			
	$("#"+addDiv).append(option);
	
	if(addDiv == "chooseProductType"){
		
		divLiBarClick("chooseProductType");			//拍摄内容
		$("#chooseProductType >li:last-child").click();
		$(".top").scrollTop(parseInt($(".top").css("height")));
		
		
		}
	else if(addDiv == "chooseModelStyle"){
		divLiBarClick("chooseModelStyle");			//模特风格
		$("#chooseModelStyle >li:last-child").click();
		$("#chooseModelStyle").scrollTop(parseInt($("#chooseModelStyle").css("height")));
		}
}
/*增加自定义标签个人*/


function plusProductNum(obj){
	var value = parseInt($("#"+obj).val());
	$("#"+obj).val(value+1);
	countTotalMoey();
	}
function subtractProductNum(obj){
	var value = parseInt($("#"+obj).val());
	if(value>1){
		$("#"+obj).val(value-1);
		}
	countTotalMoey();
	}
	



//计价方式
function divLiBarClickValuation(divName){
	var allMainBarLi=$("#"+divName).find("li");

	$(allMainBarLi).each(function(){
			$(this).click(function(){
				$("#divantian").hide();
				$("#divanxiaoshi").hide();
				var allMainBarLi=$("#"+divName).find("li").each(function() {$(this).removeClass("active");});
				$(this).addClass("active");
				
				var value = $(this).find("span").html();
				if(value == "按天"){
					$("#yuanAndPer").html("元/天");
					$("#divantian").show();
					}
				if(value == "按时"){
					$("#yuanAndPer").html("元/时");
					$("#divanxiaoshi").show();
					}
			});	
    });	
}


//招标方式
function divLiBarClickBid(divName){
	
	var allMainBarLi=$("#"+divName).find("li");
	
	$(allMainBarLi).each(function(){
			$(this).click(function(){
				
				$("#shootConSpanYQ").hide();
				$("#finished").removeAttr("disabled");
				$("#finished").css({"background":"url(../../../public/images/buttonGroup01.png) no-repeat 0 -1168px","color":"#fff","cursor":"pointer"});
				var allMainBarLi=$("#"+divName).find("li").each(function() {$(this).removeClass("active");});
				$(this).addClass("active");
				
				var values = $(this).find("span").html();
				
				if(values == "私密"){
	
					if(parseInt($("#invitationNum").html()) == 0){
						$("#shootConSpanYQ").show();
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
					$("#shootConSpanYQ").hide();
					$("#finished").removeAttr("disabled");
					$("#finished").css({"background":"url(../../../public/images/buttonGroup01.png) no-repeat 0 -1168px","color":"#fff","cursor":"pointer"});
				}
			}
		}
	});
	}



function verifyFormTt(){
	 var tag=$.trim($("#chooseProductType").find(".active").text());
	 $("#tag").val(tag);
	var modeType=$.trim($("#chooseModelType").find(".active").text());
	$("#modeType").val(modeType);
	
	var modelStyle=$.trim($("#chooseModelStyle").find(".active").text());
	$("#modelStyle").val(modelStyle);
	
	
	var isAgeRequest=$.trim($("#chooseAgeReq").find(".active").text());
	$("#isAgeRequest").val(isAgeRequest);
	
	
	var isSexRequest=$.trim($("#chooseSexReq").find(".active").text());
	$("#isSexRequest").val(isSexRequest);
	
	var photoTerm=$.trim($("#chooseShootTeam").find(".active").text());
	  if(photoTerm=="我方提供"){
		  $("#photoTerm").val(1);
		  
	  }else   if(photoTerm=="模特提供") {
		  $("#photoTerm").val(2);
		  
	  }
	
	
	  
	  $("#chooseProductType").find("li").each(function(){
			if($(this).attr("class") == "active"){
				$("#tag").val($.trim($(this).text()));
			}
		});
		
		
		var photoType=$.trim($("#chooseShootType").find(".active").text());//
		if(photoType=="不限"){//
			photoType=0;	
		}
		else if(photoType=="跟拍"){
			photoType=1;			
		}
		else if(photoType=="寄拍"){
			photoType=2;			
		}
		$("#photoType").val(photoType);
		
		
		var shootingEnvironment=$.trim($("#chooseShootEnv").find(".active").text());
		if(shootingEnvironment=="不限"){//
			shootingEnvironment=0;	
		}
		else if(shootingEnvironment=="内景"){
			shootingEnvironment=1;			
		}
		else if(shootingEnvironment=="外景"){
			shootingEnvironment=2;			
		}
		$("#shootingEnvironment").val(shootingEnvironment);
		
		
		var unitpriceType=$.trim($("#chooseValuation").find(".active").text());
		//alert(unitpriceType=="按件");
		if(unitpriceType=="按片长"){//
			unitpriceType=4;	
		}
		if(unitpriceType=="按件"){//
			unitpriceType=1;	
		}
		else if(unitpriceType=="按天"){
			unitpriceType=2;			
		}
		else if(unitpriceType=="按时"){
			unitpriceType=3;			
		}
		$("#unitpriceType").val(unitpriceType);
		
		var publicOrPrivate=$.trim($("#chooseShootzbfs").find(".active").text());
		if(publicOrPrivate=="公开"){//
			publicOrPrivate=1;	
		}
		else if(publicOrPrivate=="私密"){
			publicOrPrivate=2;			
		}
		$("#publicOrPrivate").val(publicOrPrivate);
		//publicOrPrivatevar temp= $("#test").is(":hidden");//是否隐藏 
		if(!$("#shootAddress").is(":hidden")){
		 var provice=$("input[name='Area_province']").val();
		 var city=$("input[name='Area_city']").val();
		 var qu=$("input[name='Area_District']").val();
		 $("input[name='workPlace']").val(provice+","+city+","+qu);
		}
		//alert($("#divantian").is(":hidden")+"sssssssssssssss");
		if(!$("#divantian").is(":hidden")){
			$("#inputproductDay").attr("name","recruitNum");
			$("#inputproductHour").attr("name","");
			}
		if(!$("#divanxiaoshi").is(":hidden")){
			$("#inputproductDay").attr("name","");
			$("#inputproductHour").attr("name","recruitNum");
			}
		if(vlidateFormOther()){
		
	     $("#formshootProduct").submit();	
		}
	
	
	}


function verifyFormCm(){
	 var tag=$.trim($("#chooseProductType").find(".active").text());
	 $("#tag").val(tag);
	var modeType=$.trim($("#chooseModelType").find(".active").text());
	$("#modeType").val(modeType);
	
	var modelStyle=$.trim($("#chooseModelStyle").find(".active").text());
	$("#modelStyle").val(modelStyle);
	
	
	var isAgeRequest=$.trim($("#chooseAgeReq").find(".active").text());
	$("#isAgeRequest").val(isAgeRequest);
	
	
	var isSexRequest=$.trim($("#chooseSexReq").find(".active").text());
	$("#isSexRequest").val(isSexRequest);
	
	var photoTerm=$.trim($("#chooseShootTeam").find(".active").text());
	  if(photoTerm=="我方提供"){
		  $("#photoTerm").val(1);
		  
	  }else   if(photoTerm=="模特提供") {
		  $("#photoTerm").val(2);
		  
	  }
	
	
	  
	  $("#chooseProductType").find("li").each(function(){
			if($(this).attr("class") == "active"){
				$("#tag").val($.trim($(this).text()));
			}
		});
		
		
		var photoType=$.trim($("#chooseShootType").find(".active").text());//
		if(photoType=="不限"){//
			photoType=0;	
		}
		else if(photoType=="跟拍"){
			photoType=1;			
		}
		else if(photoType=="寄拍"){
			photoType=2;			
		}
		$("#photoType").val(photoType);
		
		
		var shootingEnvironment=$.trim($("#chooseShootEnv").find(".active").text());
		if(shootingEnvironment=="不限"){//
			shootingEnvironment=0;	
		}
		else if(shootingEnvironment=="内景"){
			shootingEnvironment=1;			
		}
		else if(shootingEnvironment=="外景"){
			shootingEnvironment=2;			
		}
		$("#shootingEnvironment").val(shootingEnvironment);
		
		
		var unitpriceType=$.trim($("#chooseValuation").find(".active").text());
		//alert(unitpriceType=="按件");
		if(unitpriceType=="按片长"){//
			unitpriceType=4;	
		}
		if(unitpriceType=="按件"){//
			unitpriceType=1;	
		}
		else if(unitpriceType=="按天"){
			unitpriceType=2;			
		}
		else if(unitpriceType=="按时"){
			unitpriceType=3;			
		}
		$("#unitpriceType").val(unitpriceType);
		
		var publicOrPrivate=$.trim($("#chooseShootzbfs").find(".active").text());
		if(publicOrPrivate=="公开"){//
			publicOrPrivate=1;	
		}
		else if(publicOrPrivate=="私密"){
			publicOrPrivate=2;			
		}
		$("#publicOrPrivate").val(publicOrPrivate);
		//publicOrPrivatevar temp= $("#test").is(":hidden");//是否隐藏 
		if(!$("#shootAddress").is(":hidden")){
		 var provice=$("input[name='Area_province']").val();
		 var city=$("input[name='Area_city']").val();
		 var qu=$("input[name='Area_District']").val();
		 $("input[name='workPlace']").val(provice+","+city+","+qu);
		}
		//alert($("#divantian").is(":hidden")+"sssssssssssssss");
		if(!$("#divantian").is(":hidden")){
			$("#inputproductDay").attr("name","recruitNum");
			$("#inputproductHour").attr("name","");
			}
		if(!$("#divanxiaoshi").is(":hidden")){
			$("#inputproductDay").attr("name","");
			$("#inputproductHour").attr("name","recruitNum");
			}
		
		if(vlidateFormOther()){
			
		     $("#formshootProduct").submit();	
			}	
	
	
	
	}



function verifyFormHd(){
	 var tag=$.trim($("#chooseProductType").find(".active").text());
	 $("#tag").val(tag);
	var modeType=$.trim($("#chooseModelType").find(".active").text());
	$("#modeType").val(modeType);
	
	var modelStyle=$.trim($("#chooseModelStyle").find(".active").text());
	$("#modelStyle").val(modelStyle);
	
	
	var isAgeRequest=$.trim($("#chooseAgeReq").find(".active").text());
	$("#isAgeRequest").val(isAgeRequest);
	
	
	var isSexRequest=$.trim($("#chooseSexReq").find(".active").text());
	$("#isSexRequest").val(isSexRequest);
	
	var photoTerm=$.trim($("#chooseShootTeam").find(".active").text());
	  if(photoTerm=="我方提供"){
		  $("#photoTerm").val(1);
		  
	  }else   if(photoTerm=="模特提供") {
		  $("#photoTerm").val(2);
		  
	  }
	
	
	  
	  $("#chooseProductType").find("li").each(function(){
			if($(this).attr("class") == "active"){
				$("#tag").val($.trim($(this).text()));
			}
		});
		
		
		var photoType=$.trim($("#chooseShootType").find(".active").text());//
		if(photoType=="不限"){//
			photoType=0;	
		}
		else if(photoType=="跟拍"){
			photoType=1;			
		}
		else if(photoType=="寄拍"){
			photoType=2;			
		}
		$("#photoType").val(photoType);
		
		
		var shootingEnvironment=$.trim($("#chooseShootEnv").find(".active").text());
		if(shootingEnvironment=="不限"){//
			shootingEnvironment=0;	
		}
		else if(shootingEnvironment=="内景"){
			shootingEnvironment=1;			
		}
		else if(shootingEnvironment=="外景"){
			shootingEnvironment=2;			
		}
		$("#shootingEnvironment").val(shootingEnvironment);
		
		
		var unitpriceType=$.trim($("#chooseValuation").find(".active").text());
		//alert(unitpriceType=="按件");
		if(unitpriceType=="按片长"){//
			unitpriceType=4;	
		}
		if(unitpriceType=="按件"){//
			unitpriceType=1;	
		}
		else if(unitpriceType=="按天"){
			unitpriceType=2;			
		}
		else if(unitpriceType=="按时"){
			unitpriceType=3;			
		}
		$("#unitpriceType").val(unitpriceType);
		
		var publicOrPrivate=$.trim($("#chooseShootzbfs").find(".active").text());
		if(publicOrPrivate=="公开"){//
			publicOrPrivate=1;	
		}
		else if(publicOrPrivate=="私密"){
			publicOrPrivate=2;			
		}
		$("#publicOrPrivate").val(publicOrPrivate);
		//publicOrPrivatevar temp= $("#test").is(":hidden");//是否隐藏 
		if(!$("#shootAddress").is(":hidden")){
		 var provice=$("input[name='Area_province']").val();
		 var city=$("input[name='Area_city']").val();
		 var qu=$("input[name='Area_District']").val();
		 $("input[name='workPlace']").val(provice+","+city+","+qu);
		}
		//alert($("#divantian").is(":hidden")+"sssssssssssssss");
		if(!$("#divantian").is(":hidden")){
			$("#inputproductDay").attr("name","recruitNum");
			$("#inputproductHour").attr("name","");
			}
		if(!$("#divanxiaoshi").is(":hidden")){
			$("#inputproductDay").attr("name","");
			$("#inputproductHour").attr("name","recruitNum");
			}
		
		if(vlidateFormOther()){
			
		     $("#formshootProduct").submit();	
			}	
	
	
	
	
	}


function verifyFormPm(){
	 var tag=$.trim($("#chooseProductType").find(".active").text());
	 $("#tag").val(tag);
	var modeType=$.trim($("#chooseModelType").find(".active").text());
	$("#modeType").val(modeType);
	
	var modelStyle=$.trim($("#chooseModelStyle").find(".active").text());
	$("#modelStyle").val(modelStyle);
	
	
	var isAgeRequest=$.trim($("#chooseAgeReq").find(".active").text());
	$("#isAgeRequest").val(isAgeRequest);
	
	
	var isSexRequest=$.trim($("#chooseSexReq").find(".active").text());
	$("#isSexRequest").val(isSexRequest);
	
	var photoTerm=$.trim($("#chooseShootTeam").find(".active").text());
	  if(photoTerm=="我方提供"){
		  $("#photoTerm").val(1);
		  
	  }else   if(photoTerm=="模特提供") {
		  $("#photoTerm").val(2);
		  
	  }
	
	
	  
	  $("#chooseProductType").find("li").each(function(){
			if($(this).attr("class") == "active"){
				$("#tag").val($.trim($(this).text()));
			}
		});
		
		
		var photoType=$.trim($("#chooseShootType").find(".active").text());//
		if(photoType=="不限"){//
			photoType=0;	
		}
		else if(photoType=="跟拍"){
			photoType=1;			
		}
		else if(photoType=="寄拍"){
			photoType=2;			
		}
		$("#photoType").val(photoType);
		
		
		var shootingEnvironment=$.trim($("#chooseShootEnv").find(".active").text());
		if(shootingEnvironment=="不限"){//
			shootingEnvironment=0;	
		}
		else if(shootingEnvironment=="内景"){
			shootingEnvironment=1;			
		}
		else if(shootingEnvironment=="外景"){
			shootingEnvironment=2;			
		}
		$("#shootingEnvironment").val(shootingEnvironment);
		
		
		var unitpriceType=$.trim($("#chooseValuation").find(".active").text());
		//alert(unitpriceType=="按件");
		if(unitpriceType=="按片长"){//
			unitpriceType=4;	
		}
		if(unitpriceType=="按件"){//
			unitpriceType=1;	
		}
		else if(unitpriceType=="按天"){
			unitpriceType=2;			
		}
		else if(unitpriceType=="按时"){
			unitpriceType=3;			
		}
		$("#unitpriceType").val(unitpriceType);
		
		var publicOrPrivate=$.trim($("#chooseShootzbfs").find(".active").text());
		if(publicOrPrivate=="公开"){//
			publicOrPrivate=1;	
		}
		else if(publicOrPrivate=="私密"){
			publicOrPrivate=2;			
		}
		$("#publicOrPrivate").val(publicOrPrivate);
		//publicOrPrivatevar temp= $("#test").is(":hidden");//是否隐藏 
		if(!$("#shootAddress").is(":hidden")){
		 var provice=$("input[name='Area_province']").val();
		 var city=$("input[name='Area_city']").val();
		 var qu=$("input[name='Area_District']").val();
		 $("input[name='workPlace']").val(provice+","+city+","+qu);
		}
		//alert($("#divantian").is(":hidden")+"sssssssssssssss");
		if(!$("#divantian").is(":hidden")){
			$("#inputproductDay").attr("name","recruitNum");
			$("#inputproductHour").attr("name","");
			}
		if(!$("#divanxiaoshi").is(":hidden")){
			$("#inputproductDay").attr("name","");
			$("#inputproductHour").attr("name","recruitNum");
			}
		
		if(vlidateFormOther()){
			
		     $("#formshootProduct").submit();	
			}	
	
	
	
	}


//function verifyFormGg(){
//	 var tag=$.trim($("#chooseProductType").find(".active").text());
//	 $("#tag").val(tag);
//	var modeType=$.trim($("#chooseModelType").find(".active").text());
//	$("#modeType").val(modeType);
//	
//	var modelStyle=$.trim($("#chooseModelStyle").find(".active").text());
//	$("#modelStyle").val(modelStyle);
//	
//	
//	var isAgeRequest=$.trim($("#chooseAgeReq").find(".active").text());
//	$("#isAgeRequest").val(isAgeRequest);
//	
//	
//	var isSexRequest=$.trim($("#chooseSexReq").find(".active").text());
//	$("#isSexRequest").val(isSexRequest);
//	
//	var photoTerm=$.trim($("#chooseShootTeam").find(".active").text());
//	  if(photoTerm=="我方提供"){
//		  $("#photoTerm").val(1);
//		  
//	  }else   if(photoTerm=="模特提供") {
//		  $("#photoTerm").val(2);
//		  
//	  }
//	
//	
//	  
//	  $("#chooseProductType").find("li").each(function(){
//			if($(this).attr("class") == "active"){
//				$("#tag").val($.trim($(this).text()));
//			}
//		});
//		
//		
//		var photoType=$.trim($("#chooseShootType").find(".active").text());//
//		if(photoType=="不限"){//
//			photoType=0;	
//		}
//		else if(photoType=="跟拍"){
//			photoType=1;			
//		}
//		else if(photoType=="寄拍"){
//			photoType=2;			
//		}
//		$("#photoType").val(photoType);
//		
//		
//		var shootingEnvironment=$.trim($("#chooseShootEnv").find(".active").text());
//		if(shootingEnvironment=="不限"){//
//			shootingEnvironment=0;	
//		}
//		else if(shootingEnvironment=="内景"){
//			shootingEnvironment=1;			
//		}
//		else if(shootingEnvironment=="外景"){
//			shootingEnvironment=2;			
//		}
//		$("#shootingEnvironment").val(shootingEnvironment);
//		
//		
//		var unitpriceType=$.trim($("#chooseValuation").find(".active").text());
//		//alert(unitpriceType=="按件");
//		if(unitpriceType=="按片长"){//
//			unitpriceType=4;	
//		}
//		if(unitpriceType=="按件"){//
//			unitpriceType=1;	
//		}
//		else if(unitpriceType=="按天"){
//			unitpriceType=2;			
//		}
//		else if(unitpriceType=="按时"){
//			unitpriceType=3;			
//		}
//		$("#unitpriceType").val(unitpriceType);
//		
//		var publicOrPrivate=$.trim($("#chooseShootzbfs").find(".active").text());
//		if(publicOrPrivate=="公开"){//
//			publicOrPrivate=1;	
//		}
//		else if(publicOrPrivate=="私密"){
//			publicOrPrivate=2;			
//		}
//		$("#publicOrPrivate").val(publicOrPrivate);
//		//publicOrPrivatevar temp= $("#test").is(":hidden");//是否隐藏 
//		if(!$("#shootAddress").is(":hidden")){
//		 var provice=$("input[name='Area_province']").val();
//		 var city=$("input[name='Area_city']").val();
//		 var qu=$("input[name='Area_District']").val();
//		 $("input[name='workPlace']").val(provice+","+city+","+qu);
//		}
//		//alert($("#divantian").is(":hidden")+"sssssssssssssss");
//		if(!$("#divantian").is(":hidden")){
//			$("#inputproductDay").attr("name","recruitNum");
//			$("#inputproductHour").attr("name","");
//			}
//		if(!$("#divanxiaoshi").is(":hidden")){
//			$("#inputproductDay").attr("name","");
//			$("#inputproductHour").attr("name","recruitNum");
//			}
//		
//		if(vlidateFormOther()){
//			alert("死死死死死死");
//		    // $("#formshootProduct").submit();	
//			}	
//	
//	
//	
//	
//	
//	}


function verifyFormGg(){
	 var tag=$.trim($("#chooseProductType").find(".active").text());
	 $("#tag").val(tag);
	var modeType=$.trim($("#chooseModelType").find(".active").text());
	$("#modeType").val(modeType);
	
	var modelStyle=$.trim($("#chooseModelStyle").find(".active").text());
	$("#modelStyle").val(modelStyle);
	
	
	var isAgeRequest=$.trim($("#chooseAgeReq").find(".active").text());
	$("#isAgeRequest").val(isAgeRequest);
	
	
	var isSexRequest=$.trim($("#chooseSexReq").find(".active").text());
	$("#isSexRequest").val(isSexRequest);
	
	var photoTerm=$.trim($("#chooseShootTeam").find(".active").text());
	  if(photoTerm=="我方提供"){
		  $("#photoTerm").val(1);
		  
	  }else   if(photoTerm=="模特提供") {
		  $("#photoTerm").val(2);
		  
	  }
	
	
	  
	  $("#chooseProductType").find("li").each(function(){
			if($(this).attr("class") == "active"){
				$("#tag").val($.trim($(this).text()));
			}
		});
		
		
		var photoType=$.trim($("#chooseShootType").find(".active").text());//
		if(photoType=="不限"){//
			photoType=0;	
		}
		else if(photoType=="跟拍"){
			photoType=1;			
		}
		else if(photoType=="寄拍"){
			photoType=2;			
		}
		$("#photoType").val(photoType);
		
		
		var shootingEnvironment=$.trim($("#chooseShootEnv").find(".active").text());
		if(shootingEnvironment=="不限"){//
			shootingEnvironment=0;	
		}
		else if(shootingEnvironment=="内景"){
			shootingEnvironment=1;			
		}
		else if(shootingEnvironment=="外景"){
			shootingEnvironment=2;			
		}
		$("#shootingEnvironment").val(shootingEnvironment);
		
		
		var unitpriceType=$.trim($("#chooseValuation").find(".active").text());
		//alert(unitpriceType=="按件");
		if(unitpriceType=="按片长"){//
			unitpriceType=4;	
		}
		if(unitpriceType=="按件"){//
			unitpriceType=1;	
		}
		else if(unitpriceType=="按天"){
			unitpriceType=2;			
		}
		else if(unitpriceType=="按时"){
			unitpriceType=3;			
		}
		$("#unitpriceType").val(unitpriceType);
		
		var publicOrPrivate=$.trim($("#chooseShootzbfs").find(".active").text());
		if(publicOrPrivate=="公开"){//
			publicOrPrivate=1;	
		}
		else if(publicOrPrivate=="私密"){
			publicOrPrivate=2;			
		}
		$("#publicOrPrivate").val(publicOrPrivate);
		//publicOrPrivatevar temp= $("#test").is(":hidden");//是否隐藏 
		if(!$("#shootAddress").is(":hidden")){
		 var provice=$("input[name='Area_province']").val();
		 var city=$("input[name='Area_city']").val();
		 var qu=$("input[name='Area_District']").val();
		 $("input[name='workPlace']").val(provice+","+city+","+qu);
		}
		//alert($("#divantian").is(":hidden")+"sssssssssssssss");
		if(!$("#divantian").is(":hidden")){
			$("#inputproductDay").attr("name","recruitNum");
			$("#inputproductHour").attr("name","");
			}
		if(!$("#divanxiaoshi").is(":hidden")){
			$("#inputproductDay").attr("name","");
			$("#inputproductHour").attr("name","recruitNum");
			}
		
		if(vlidateFormOther()){
			//alert("死死死死死死");
		     $("#formshootProduct").submit();	
			}		
	
	
	
	}




function verifyFormWp(){
	 var tag=$.trim($("#chooseProductType").find(".active").text());
	 $("#tag").val(tag);
	var modeType=$.trim($("#chooseModelType").find(".active").text());
	$("#modeType").val(modeType);
	
	var modelStyle=$.trim($("#chooseModelStyle").find(".active").text());
	$("#modelStyle").val(modelStyle);
	
	
	var isAgeRequest=$.trim($("#chooseAgeReq").find(".active").text());
	$("#isAgeRequest").val(isAgeRequest);
	
	
	var isSexRequest=$.trim($("#chooseSexReq").find(".active").text());
	$("#isSexRequest").val(isSexRequest);
	
	var photoTerm=$.trim($("#chooseShootTeam").find(".active").text());
	  if(photoTerm=="我方提供"){
		  $("#photoTerm").val(1);
		  
	  }else   if(photoTerm=="模特提供") {
		  $("#photoTerm").val(2);
		  
	  }
	
	
	  
	  $("#chooseProductType").find("li").each(function(){
			if($(this).attr("class") == "active"){
				$("#tag").val($.trim($(this).text()));
			}
		});
		
		
		var photoType=$.trim($("#chooseShootType").find(".active").text());//
		if(photoType=="不限"){//
			photoType=0;	
		}
		else if(photoType=="跟拍"){
			photoType=1;			
		}
		else if(photoType=="寄拍"){
			photoType=2;			
		}
		$("#photoType").val(photoType);
		
		
		var shootingEnvironment=$.trim($("#chooseShootEnv").find(".active").text());
		if(shootingEnvironment=="不限"){//
			shootingEnvironment=0;	
		}
		else if(shootingEnvironment=="内景"){
			shootingEnvironment=1;			
		}
		else if(shootingEnvironment=="外景"){
			shootingEnvironment=2;			
		}
		$("#shootingEnvironment").val(shootingEnvironment);
		
		
		var unitpriceType=$.trim($("#chooseValuation").find(".active").text());
		//alert(unitpriceType=="按件");
		if(unitpriceType=="按片长"){//
			unitpriceType=4;	
		}
		if(unitpriceType=="按件"){//
			unitpriceType=1;	
		}
		else if(unitpriceType=="按天"){
			unitpriceType=2;			
		}
		else if(unitpriceType=="按时"){
			unitpriceType=3;			
		}
		$("#unitpriceType").val(unitpriceType);
		
		var publicOrPrivate=$.trim($("#chooseShootzbfs").find(".active").text());
		if(publicOrPrivate=="公开"){//
			publicOrPrivate=1;	
		}
		else if(publicOrPrivate=="私密"){
			publicOrPrivate=2;			
		}
		$("#publicOrPrivate").val(publicOrPrivate);
		//publicOrPrivatevar temp= $("#test").is(":hidden");//是否隐藏 
		if(!$("#shootAddress").is(":hidden")){
		 var provice=$("input[name='Area_province']").val();
		 var city=$("input[name='Area_city']").val();
		 var qu=$("input[name='Area_District']").val();
		 $("input[name='workPlace']").val(provice+","+city+","+qu);
		}
		//alert($("#divantian").is(":hidden")+"sssssssssssssss");
		if(!$("#divantian").is(":hidden")){
			$("#inputproductDay").attr("name","recruitNum");
			$("#inputproductHour").attr("name","");
			}
		if(!$("#divanxiaoshi").is(":hidden")){
			$("#inputproductDay").attr("name","");
			$("#inputproductHour").attr("name","recruitNum");
			}
		
		if(vlidateFormOther()){
			//alert("死死死死死死");
		     $("#formshootProduct").submit();	
			}		
	
	
	
	}

function verifyFormFz(){
	 var tag=$.trim($("#chooseProductType").find(".active").text());
	 $("#tag").val(tag);
	var modeType=$.trim($("#chooseModelType").find(".active").text());
	$("#modeType").val(modeType);
	
	var modelStyle=$.trim($("#chooseModelStyle").find(".active").text());
	$("#modelStyle").val(modelStyle);
	
	
	var isAgeRequest=$.trim($("#chooseAgeReq").find(".active").text());
	$("#isAgeRequest").val(isAgeRequest);
	
	
	var isSexRequest=$.trim($("#chooseSexReq").find(".active").text());
	$("#isSexRequest").val(isSexRequest);
	
	var photoTerm=$.trim($("#chooseShootTeam").find(".active").text());
	  if(photoTerm=="我方提供"){
		  $("#photoTerm").val(1);
		  
	  }else   if(photoTerm=="模特提供") {
		  $("#photoTerm").val(2);
		  
	  }
	
	
	  
	  $("#chooseProductType").find("li").each(function(){
			if($(this).attr("class") == "active"){
				$("#tag").val($.trim($(this).text()));
			}
		});
		
		
		var photoType=$.trim($("#chooseShootType").find(".active").text());//
		if(photoType=="不限"){//
			photoType=0;	
		}
		else if(photoType=="跟拍"){
			photoType=1;			
		}
		else if(photoType=="寄拍"){
			photoType=2;			
		}
		$("#photoType").val(photoType);
		
		
		var shootingEnvironment=$.trim($("#chooseShootEnv").find(".active").text());
		if(shootingEnvironment=="不限"){//
			shootingEnvironment=0;	
		}
		else if(shootingEnvironment=="内景"){
			shootingEnvironment=1;			
		}
		else if(shootingEnvironment=="外景"){
			shootingEnvironment=2;			
		}
		$("#shootingEnvironment").val(shootingEnvironment);
		
		
		var unitpriceType=$.trim($("#chooseValuation").find(".active").text());
		//alert(unitpriceType=="按件");
		if(unitpriceType=="按片长"){//
			unitpriceType=4;	
		}
		if(unitpriceType=="按件"){//
			unitpriceType=1;	
		}
		else if(unitpriceType=="按天"){
			unitpriceType=2;			
		}
		else if(unitpriceType=="按时"){
			unitpriceType=3;			
		}
		$("#unitpriceType").val(unitpriceType);
		
		var publicOrPrivate=$.trim($("#chooseShootzbfs").find(".active").text());
		if(publicOrPrivate=="公开"){//
			publicOrPrivate=1;	
		}
		else if(publicOrPrivate=="私密"){
			publicOrPrivate=2;			
		}
		$("#publicOrPrivate").val(publicOrPrivate);
		//publicOrPrivatevar temp= $("#test").is(":hidden");//是否隐藏 
		if(!$("#shootAddress").is(":hidden")){
		 var provice=$("input[name='Area_province']").val();
		 var city=$("input[name='Area_city']").val();
		 var qu=$("input[name='Area_District']").val();
		 $("input[name='workPlace']").val(provice+","+city+","+qu);
		}
		//alert($("#divantian").is(":hidden")+"sssssssssssssss");
		if(!$("#divantian").is(":hidden")){
			$("#inputproductDay").attr("name","recruitNum");
			$("#inputproductHour").attr("name","");
			}
		if(!$("#divanxiaoshi").is(":hidden")){
			$("#inputproductDay").attr("name","");
			$("#inputproductHour").attr("name","recruitNum");
			}
		
		if(vlidateFormOther()){
			//alert("死死死死死死");
		     $("#formshootProduct").submit();	
			}		
	
	
	
	}
function countTotalMoeyEvent(obj){
	if(obj.value.length==1)
	{
		obj.value=obj.value.replace(/[^1-9]/g,'')
		}else{
			obj.value=obj.value.replace(/\D/g,'')
			}
	countTotalMoey();
}




function countTotalMoey(){
	
	//alert("sss");
	var total="";
	var unitPrice=$("input[name='unitpriceProduct']").val();
	//alert(unitPrice);
	if(unitPrice==null||unitPrice==""){
		unitPrice=0;
	}
	var unitpriceType=$.trim($("#chooseValuation").find(".active").text());
	if(unitpriceType=="按片"){//
		 total=$("#inputproductNum").val()*unitPrice;
	}
	if(unitpriceType=="按件"){//
		 total=$("#inputproductNum").val()*unitPrice;
	}
	if(unitpriceType=="按片长"){//
		 total=$("#inputproductNum").val()*unitPrice;
	}
	else if(unitpriceType=="按天"){
		 total=$("#inputproductDay").val()*unitPrice*$("#inputPersonNum").val();		
	}
	else if(unitpriceType=="按时"){
		 total=$("#inputproductHour").val()*unitPrice*$("#inputPersonNum").val();	
	}
	$("#totalCount").html("模特酬金（总价："+total+"元）");
	
	
	
	
	
	
}







