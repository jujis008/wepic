$(function(){
	
	divLiBar2("mainbar","personalCenter");   //主导航背景底边框
	
	divLiBar("divTopBarContainer");   //展开头部右边详细
	
	userBuyCart();  				/*头部展开用户/购物车信息详细 */
	
	achieveBelow("divdropDownPartType","divdropDownViewPartType");					/*获取下拉框值并隐藏	默认专辑*/
	
	
	changeHead("divChangeHead","divViewHead");			//更换头像
	
	
	
	changeHead("phoStroyDetailLeft","editzpgs");			//显示编辑删除
	
	
	picCenter();
	
	
	$("#redRemin").hover(
		function(){
			$("#stateRemind").show();
			},function(){
			$("#stateRemind").hide();
			}
	
	);
});


function addClickzj(divName){
//alert("dsssssssssssssssssssssssss");
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
function openSpecial(){
	openPopUpBox("moveTozj");
	addClickzj('zhuanjiadd');
	
}

function changeHeadStory(opendiv){
	openPopUpBox('chooseWork');
	
	window.frames['child'].document.getElementById('hiddenv').value = opendiv;			//传值给 iframe text
	}

function openedit(){
	
 
}



function picCenter(){
	var allLi = $("#imagebg").find("li");
	$(".divPicimg").removeAttr("style");
	//alert($("#phoStroyDetailLeft").css("width"));
	
	//$(this).parents(".#phoStroyDetailLeft").css({"top":"0px","left":"0px"});
	
	
	
	/*var allimg = $("#imagebg").find("img");
	
	$(allimg).each(function(){
		$(this).bind("load", function(){
			$(this).DrawImage(this,800,800);
			alert("33");
			});
		
		})*/
	
	
	$(allLi).each(function(){
		if($(this).css("display") == "block"){
			var imgwidth = parseInt($(this).find("img").css("width"));
			var imgheight = parseInt($(this).find("img").css("height"));
			var top = (800- imgheight)/2;
			var left = (800- imgwidth)/2;
			//alert(imgwidth);
			if(imgwidth < 800 || imgheight < 800){

	//alert(imgwidth+""+imgheight);
				$(".divPicimg").css({"width":imgwidth+"px","height":imgheight+"px"});
				$(this).parents(".divPicimg").css({"top":top+"px","left":left+"px"});
			}
			//$("#editzpgs").css({"margin-left":left+"px"});
			
			//$(this).find(".bannerbg_main").css("height") = $(this).find("img").css("height");
			
		}
	
});	
}

  function changeSpeicals(){
	  var is=$("#publishIdforchange").val();
//	  alert(is);
//	  alert();
	//  alert();
	
	  $.ajax({
			type : "POST",
			url : "jsonpublish_changeSpecialPic.do",
			data : "id="+$("#publishIdforchange").val()+"&publishSpecialCatId="+$("#spcialChangeForPublish").val(),				
			success : function(data) {
		  var msg=data.resMsg;
		  if(msg=="suc"){
			  alert("更换专辑成功"); 
			  cloosePopBox('moveTozj');
			 window.location.href='publish!findRelesePublish.do?id='+$("#small_pic").find("#"+is).next().attr("id")
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


