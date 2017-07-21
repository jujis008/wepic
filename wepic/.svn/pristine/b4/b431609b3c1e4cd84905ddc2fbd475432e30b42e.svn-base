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