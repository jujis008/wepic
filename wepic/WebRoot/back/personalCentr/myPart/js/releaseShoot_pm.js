$(function(){



divLiBarClick("chooseShootEnv");			//拍摄环境



divLiBarClickProduct("chooseProductType");			//产品类型

divLiBarClickShoot("chooseShootWay");			//拍摄方式






divLiBarClickBid("chooseShootzbfs");			//招标方式
divLiBarClickValuation("chooseShootjijia");			//计价方式

document.getElementById("formshootProduct").reset();

weizhi();
});

//产品类型
function divLiBarClickProduct(divName){
	var allMainBarLi=$("#"+divName).find("li");
	
	var allCustomli=$("#"+divName).find(".customli");
	
	$(allMainBarLi).each(function(){
			$(this).click(function(){
				
	
				
				$("#shootAddress").show();
				$("#chooseShootWay").html('<li class="active"><span>跟拍</span><i></i></li>');
				divLiBarClickShoot("chooseShootWay");			//拍摄方式
				
				$("#chooseShootjijia").html('<li class="active"><span>按片</span><i></i></li><li><span>按天</span><i></i></li><li><span>按时</span><i></i></li>');
				divLiBarClickValuation("chooseShootjijia");			//计价方式
				$("#chooseShootjijia >li:first-child").click();
				
				var allMainBarLi=$("#"+divName).find("li").each(function() {$(this).removeClass("active");});
				$(this).addClass("active");
				
				var value = $(this).find("span").html();
				
				if(value == "创意广告"){
					//alert("000");
					$("#shootAddress").hide();
					$("#chooseShootWay").html('<li class="active"><span>不限</span><i></i></li><li><span>跟拍</span><i></i></li><li><span>寄拍</span><i></i></li>');
					divLiBarClickShoot("chooseShootWay");			//拍摄方式
					return;
					}
			});	
  });
  

	$(allCustomli).each(function(){
			$(this).click(function(){
				$("#chooseShootWay").html('<li class="active"><span>不限</span><i></i></li><li><span>跟拍</span><i></i></li><li><span>寄拍</span><i></i></li>');
				divLiBarClickShoot("chooseShootWay");			//拍摄方式
				});	
  });
}	


//拍摄方式
function divLiBarClickShoot(divName){
	var allMainBarLi=$("#"+divName).find("li");
	
	
	var allMainBarLiB=$("#chooseProductType").find("li");
	
	$(allMainBarLi).each(function(){
			$(this).click(function(){
				
				$("#divantian").hide();
				$("#divanxiaoshi").hide();
				$("#shootAddress").show();
				$("#chooseShootjijia").html('<li class="active"><span>按片</span><i></i></li><li><span>按天</span><i></i></li><li><span>按时</span><i></i></li>');
				divLiBarClickValuation("chooseShootjijia");			//计价方式
				
				$(allMainBarLiB).each(function(){
					if($(this).attr("class") == "active" && $(this).find("span").html() == "创意广告"){
						$("#shootAddress").hide();
						}
					});
				//divLiBarClickProduct("chooseProductType");
				
				
				var allMainBarLi=$("#"+divName).find("li").each(function() {$(this).removeClass("active");});
				$(this).addClass("active");
				
				var value = $(this).find("span").html();
				
				if(value == "寄拍"){
					$("#shootAddress").hide();
					$("#chooseShootjijia").html('<li class="active"><span>按片</span><i></i></li>');
					divLiBarClickValuation("chooseShootjijia");			//计价方式
					//divLiBarClickProduct("chooseProductType");
					return;
					}
			});	
    });
}



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
		alert("不好意思，职业标签名不能为空！");
		}
	else{
		option = '<li class="customli"><span>'+addvalue+'</span><i></i><a onclick="deleteLiFile(this);"></a></li>';
		}
	
		
	/*input自定义推荐标签*/
			var tags=$("#hiddenChooseProductType").val();
			if(tags!=""){
				tags+=" "+addvalue;		//已经有值
				}
			else{
				tags=addvalue;			//赋第一个值
				}
			$("#hiddenChooseProductType").val(tags);
	
	/*input自定义推荐标签*/	
			
	$("#"+addDiv).append(option);
divLiBarClickProduct("chooseProductType");
$("#chooseProductType >li:last-child").click();
$(".top").scrollTop(parseInt($(".top").css("height")));
$("#chooseShootWay").html('<li class="active"><span>不限</span><i></i></li><li><span>跟拍</span><i></i></li><li><span>寄拍</span><i></i></li>');

divLiBarClickShoot("chooseShootWay");			//拍摄方式
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
				if(value == "按片"){
					$("#yuanAndPer").html("元/片");
					countTotalMoey();
					}
				if(value == "按套"){
					$("#yuanAndPer").html("元/套");
					}
				if(value == "按片长"){
					$("#yuanAndPer").html("元/秒");
					}
				if(value == "按天"){
					$("#yuanAndPer").html("元/天");
					$("#divantian").show();
					$("#inputproductDay").val(1);
					countTotalMoey();
					}
				if(value == "按时"){
					$("#yuanAndPer").html("元/时");
					$("#divanxiaoshi").show();
					$("#inputproductHour").val(1);
					countTotalMoey();
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
	/*var value = parseInt($("#invitationNum").html());
	
	$("#invitationNum").html(value+1);
	value+=1;*/
	
	openPopUpBox('iframeChooseFriend');
	$("#iframeChooseFriend").html('<iframe name="child" style="border:0px;width:875px;height:765px" src="chooseFriend.html"></iframe>');
	
	/*$(allMainBarLi).each(function(){
		if($(this).attr("class") == "active"){
			if($(this).find("span").html() == "私密"){
				
				if(value != 0){
					$("#finished").removeAttr("disabled");
					$("#finished").css({"background":"url(../../../public/images/buttonGroup01.png) no-repeat 0 -1168px","color":"#fff","cursor":"pointer"});
				}
			}
		}
	});*/
	
	
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





function verifyFormPm(){
	$("#chooseProductType").find("li").each(function(){
		if($(this).attr("class") == "active"||$(this).attr("class") =="customli active"){
			//alert($.trim($(this).text()));
			$("#tag").val($.trim($(this).text()));
		}
	});
	
	var photoType=$.trim($("#chooseShootWay").find(".active").text());//
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
	
	
	var unitpriceType=$.trim($("#chooseShootjijia").find(".active").text());
	//alert(unitpriceType=="按件");
	if(unitpriceType=="按片"){//
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
	
	if(!$("#divantian").is(":hidden")){
		$("#inputproductDay").attr("name","recruitNum")
		}
	if(!$("#divanxiaoshi").is(":hidden")){
		$("#inputproductHour").attr("name","recruitNum")
		}
	if(vlidateFormCp()){
	//	alert("vlidateForm");
	$("#formshootProduct").submit();
//		
	}
   //  $("#formshootProduct").submit();	
	}



function verifyFormHd(){
	$("#chooseProductType").find("li").each(function(){
		if($(this).attr("class") == "active"||$(this).attr("class") =="customli active"){
			//alert($.trim($(this).text()));
			$("#tag").val($.trim($(this).text()));
		}
	});
	
	
	var photoType=$.trim($("#chooseShootWay").find(".active").text());//
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
	
	
	var unitpriceType=$.trim($("#chooseShootjijia").find(".active").text());
	//alert(unitpriceType=="按件");
	if(unitpriceType=="按片"){//
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
	if(vlidateFormCp()){
		//	alert("vlidateForm");
		$("#formshootProduct").submit();
//			
		}
     //$("#formshootProduct").submit();	
	}


function verifyFormGg(){
	$("#chooseProductType").find("li").each(function(){
		if($(this).attr("class") == "active"||$(this).attr("class") =="customli active"){
			//alert($.trim($(this).text()));
			$("#tag").val($.trim($(this).text()));
		}
	});
	
	
	var photoType=$.trim($("#chooseShootWay").find(".active").text());//
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
	
	
	var unitpriceType=$.trim($("#chooseShootjijia").find(".active").text());
	//alert(unitpriceType=="按件");
	if(unitpriceType=="按片长"){//
		unitpriceType=4;	
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
	if(vlidateFormCp()){
			//alert("vlidateForm");
		$("#formshootProduct").submit();
			
		}
    // $("#formshootProduct").submit();	
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
	var unitpriceType=$.trim($("#chooseShootjijia").find(".active").text());
	if(unitpriceType=="按片"){//
		 total=$("#inputproductNum").val()*unitPrice;
	}
	if(unitpriceType=="按片长"){//
		 total=$("#inputproductNum").val()*unitPrice;
	}
	else if(unitpriceType=="按天"){
		 total=$("#inputproductDay").val()*unitPrice;		
	}
	else if(unitpriceType=="按时"){
		 total=$("#inputproductHour").val()*unitPrice;	
	}
	$(".divTotalPrice").html("总价：<span>"+total+"</span>元");
	
	
	
	
	
	
}