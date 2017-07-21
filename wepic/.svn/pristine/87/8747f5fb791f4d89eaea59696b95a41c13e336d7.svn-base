$(function(){
	
	divLiBar2("mainbar","personalCenter");   //主导航背景底边框
	
	divLiBar("divTopBarContainer");   //展开头部右边详细
	
	userBuyCart();  				/*头部展开用户/购物车信息详细 */
	
	achieveBelow("divdropDownPartType","divdropDownViewPartType");					/*获取下拉框值并隐藏	默认专辑*/
	
	
	//changeHead("divChangeHead","divViewHead");			//更换头像
	
});


function openSpecial2(){
	openPopUpBox("moveTozj");
	addClickzj3('zhuanjiadd');
	
}


function addClickzj3(divName){
		var allMainBarLi=$("#"+divName).find("li");
		
		$(allMainBarLi).each(function(){
				$(this).click(function(){			
					   // alert($(this).attr("id"));
					  $("#spcialChangeForPublish").val($(this).attr("id"));
					var allMainBarLi=$("#"+divName).find("li").each(function() {
	                    $(this).removeClass("active");
						$(this).children().find(".click").remove();
	                });
						$(this).addClass("active");
						$(this).children().append('<div class="click"></div>');
						 });
						
	    });	
	}


function changeSpeicals(){
	  $.ajax({
			type : "POST",
			url : "userstory_changeSpecialPic.do",
			data : "storyId="+$("#publishIdforchange").val()+"&publishSpecialCatId="+$("#spcialChangeForPublish").val(),				
			success : function(data) {
		  var msg=data.mylist;
		  if(msg[0]=="suc"){
			  alert("更换专辑成功"); 
			  var specialname=$("#spcialnameofstory").val();
			  $("#dropDownBoxPartType").html(msg[1]);
			  cloosePopBox('moveTozj');
		  }
		  else if(msg=="error"){
			  alert("更换专辑失败");
			  
		  }
		  else if(msg=="login"){
			//  alert("更换专辑失败");
			  
		  }

		  
		  
	  }
	  });
 }