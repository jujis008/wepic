$(function(){


divLiBarClickProduct("chooseProductType");			//作品类型


divLiBarClick("chooseShootCopyright");			//版权需求


divLiBarClickBid("chooseShootzbfs");			//招标方式

document.getElementById("formshootProduct").reset();


weizhi();


divLiBarClickFileFormat("chooseShootSourceFileFormat");			//源文件格式
//divLiBar("ULUpload");   //显示上传删除

});




//作品类型
function divLiBarClickProduct(divName){
	var allMainBarLi=$("#"+divName).find("li");
	
	var allCustomli=$("#"+divName).find(".customli");
	
	$(allMainBarLi).each(function(){
			$(this).click(function(){
			//	alert("s三三他他他四四");
				$("#customDiv").hide();
				
				$("#uploadAccessory").show();				//显示上传附件
				
				$("#chooseShootSourceFileFormat").html('<li class="active"><span>位图</span><i></i></li><li><span>矢量</span><i></i></li>');
				
				divLiBarClickFileFormat("chooseShootSourceFileFormat");		//源文件格式
				$("#chooseShootSourceFileFormat > li:first-child").click();
				
				
				var allMainBarLi=$("#"+divName).find("li").each(function() {$(this).removeClass("active");});
				$(this).addClass("active");
				
				var value = $(this).find("span").html();
				
				
				
				if($.trim(value) == "壁纸"){
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
function submit_Sytp(){
	
	
	$("#tag").val($.trim($("#chooseProductType").find(".active").text()));
	//isCopyright 
	var bidty=$.trim($("#chooseShootzbfs").find(".active").text());
	if(bidty=="私密"){
		$("#publicOrPrivate").val(2);
		
	}else{
		$("#publicOrPrivate").val(1);
		
	}
	var chooseShootCopyright=$.trim($("#chooseShootCopyright").find(".active").text());
	if(chooseShootCopyright=="买断版权"){
		$("#isCopyright").val(2);
		
	}else{
		
		$("#isCopyright").val(1);
	}
	
	
	
	if(bidValidateCollect()){
	$("#formshootProduct").submit();
	}
	
	
	
	
	
	
	
}





function deleteFile(obj){
	if(confirm("确定删除吗?")){
	deleteajaxFileName($(obj).parents("li"));	
	}
	function deleteajaxFileName(obj){
		var fileName=$(obj).find("#filename").val();
		var fileurl=$(obj).find("#url").val();
	
		$.ajax({
		      type:"Post",
			  url: "bidAction_deleteFiled.do",
			  data:"fileName="+fileName,		
			  success : function(data) {
			$(obj).parents("li").remove();
			   var attachmentUrl=$("#attachmentUrl").val();
			   //alert(attachmentUrl);
			   var attachmentUrls=attachmentUrl.split(" ");
			   //alert(attachmentUrls.length);
			   var newurl="";
			   for ( var  i= 0; i < attachmentUrls.length; i++) {
				  // alert(attachmentUrls[i]!=fileurl);
				   if(attachmentUrls[i]!=fileurl){
					   if(newurl==null&&newurl==""){
						   newurl=attachmentUrls[i];
	 		                 }else{
	 		                	newurl=newurl+" "+attachmentUrls[i];
	 		                     }
					   
		                 }
				
			}
			   $("#attachmentUrl").val(newurl);
             
		      }
		});
		
		
	}
	
}




function submit_Cytp(){
	
	
	$("#tag").val($.trim($("#chooseProductType").find(".active").text()));
	//isCopyright 
	var bidty=$.trim($("#chooseShootzbfs").find(".active").text());
	if(bidty=="私密"){
		$("#publicOrPrivate").val(2);
		
	}else{
		$("#publicOrPrivate").val(1);
		
	}
	var chooseShootCopyright=$.trim($("#chooseShootCopyright").find(".active").text());
	if(chooseShootCopyright=="买断版权"){
		$("#isCopyright").val(2);
		
	}else{
		
		$("#isCopyright").val(1);
	}
	
var chooseShootSourceFileFormat=$.trim($("#chooseShootSourceFileFormat").find(".active").text());
       if(chooseShootSourceFileFormat=="位图"){
    	   $("#workPrecision").val(1);
	     $("#fileType").val(1);
    }else{
    	  $("#workPrecision").val(1);
    	$("#fileType").val(2);
    	
    }
       
       
	
       if(bidValidateCollect()){
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
	
	var total="";
	var unitPrice=$("input[name='unitpriceProduct']").val();
	if(unitPrice==null||unitPrice==""){
		unitPrice=0;
	}
	var prodctNus=$("#inputproductNum").val();
	total=unitPrice*prodctNus;
	$("#totalCount").html(total);
	
	
	
	/*
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
	
	*/
	
	
	
	
}




