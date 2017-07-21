$(function(){
	
	divLiBar2("mainbar","personalCenter");   //主导航背景底边框
	
	divLiBar("divTopBarContainer");   //展开头部右边详细
	
	userBuyCart();  				/*头部展开用户/购物车信息详细 */
	
	achieveBelow("divdropDownPartType","divdropDownViewPartType");					/*获取下拉框值并隐藏	默认专辑*/
	
	
	changeHead("divChangeHead","divViewHead");			//更换头像
	
	
	
	changeHead("phoStroyDetailLeft","editzpgs");			//显示编辑删除
	addClickzj('zhuanjiadd');
	
	$("#redRemin").hover(
			function(){
				$("#stateRemind").show();
				},function(){
				$("#stateRemind").hide();
				}
		
		);
});


function changeHeadStory(opendiv){
	openPopUpBox('chooseWork');
	
	window.frames['child'].document.getElementById('hiddenv').value = opendiv;			//传值给 iframe text
	}

function openedit(){
	
 
}

function openSpecial(){
	openPopUpBox("moveTozj");
	addClickzj2('zhuanjiadd');
	
}


function addClickzj2(divName){
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