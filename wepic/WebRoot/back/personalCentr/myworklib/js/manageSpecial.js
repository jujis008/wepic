$(function(){
	
	
	divLiBar2("mainbar","personalCenter");   //主导航背景底边框
	
	divLiBar("divTopBarContainer");   //展开头部右边详细
	
	userBuyCart();  				/*头部展开用户/购物车信息详细 */
	
	
	
	
	hoverAddClass("diveditSpecial");		//显示编辑按钮
	
	
	tabControl2("diveditSpecial","diveddelAll");					//点击看专辑详情
	
	divLiBarClick("chooseColorb");
	colorTab("chooseColorb2");
	colorTabedtie("chooseColorb");
	
});

function verifyForm(){
	promptInfo('textname','promptname',10);
	promptInfo('textarezjsm','promptzjsm',100);
	choosecolor("promptzjcolor","chooseColorb");
}
function verifyForm2(){
	promptInfo('textname2','promptname2',10);
	promptInfo('textarezjsm2','promptzjsm2',100);
	choosecolor("promptzjcolor2","chooseColorb2");
}

//  showdiv		显示的div
//  div		查找i的div

function choosecolor(showdiv,div){
	$("#"+showdiv).children().remove();			//先清空当前div里元素
	var addI = $("#"+div).find("i");
	var view = [];
	$(addI).each(function() {
        if($(this).css("display") == "block"){
			view[view.length] = this;
			}
    });
		if(view.length <= 0){
			option = "<div class='divprompt'><span>请选择颜色</span></div>";
			$("#"+showdiv).append(option);
			}
	
	}
function editzj(viewDiv){
	$("#diveddelAll").hide();
	$("#divAddZj").hide();
	$("#divEditZj").hide();
	$("#displaySp").parents("id");
	
	getSpecialedite($("#displaySp").parents("li").attr("id"));
	$("#"+viewDiv).show();
	return;
	}

function addzj(viewDiv){
	$("#diveddelAll").hide();
	$("#divAddZj").hide();
	$("#divEditZj").hide();
//	$("#displaySp").parents("id");
	
//	getSpecialedite($("#displaySp").parents("li").attr("id"));
	$("#"+viewDiv).show();
	return;
	
}


function getSpecialedite(id){
//	if(id==""){qq
//		  $("#dispssssslayDefault").html("默认专辑");
//		  $("#displaySp").css({"background-color":"#FF9933"});
//		  $("#editeSp").hide();
//		  return;
//	}
		  $.ajax({
		      type:"Post",
			  url: "specialcat_findSpecialById.do",
			  data:"id="+id,		
			  success : function(data) {
			  var sp=data.specialCat;
			$("#spid").val(sp.id);
			$("#textnamespe").val(sp.name);
			$("#textarezjsmspe").val(sp.discription);
			$("#enNameed").val(sp.enName);
			$("#iconed").val(sp.icon);
			  $("#chooseColorb").find("li").each(function() {
				    $(this).removeClass("active");});

			$("#chooseColorb").find("."+sp.enName).addClass("active");
		  }
		  });
				 
	
	
	
}

function resetzj(obj){
	$(obj).parent().parent().hide();
	}
	

/*选项卡*/
function tabControl2(chooseDiv,viewDiv){
        var cardLi=$("#"+chooseDiv).find('.special');
      
        
		$($("#"+chooseDiv).find('li')).each(function(){
			//alert($(this).attr("id"));
			$(this).click(function(){
				//alert("ssssss");
				
				$("#divAddZj").hide();
				$("#divEditZj").hide();
	
				$("#diveddelAll").show();

				
				getSpecial($(this).attr("id"));
              $(this).addClass("active");  //当前按钮添加样式FFF
				
			});
			
			
			
			
		});
/*
		for(var i=0;i<cardLi.length;i++){  //循环历遍onclick事件
            cardLi[i].index=i; //input[0].index=0 index是自定义属性sss
            cardLi[i].onclick = function(){xx
            	alert("sssswewrrs444ssss");dddd
				
				gg
            //   viewLi[this.index].style.display='block';  //div显示 this.index是当前div 即div[0]之类的
           };
         };
         */
}
	

/*选项卡eeeefffeee*/







function getSpecial(id){
	if(id==""){
		  $("#displayDefault").html("默认专辑");
		  $("#displaySp").css({"background-color":"#FF9933"});
		  $("#editeSp").hide();
		  return;
	}
		  $.ajax({
		      type:"Post",
			  url: "specialcat_findSpecialById.do",
			  data:"id="+id,		
			  success : function(data) {
			  var sp=data.specialCat;
			  $("#displayDefault").parents("li").attr("id",sp.id);
			  $("#displayDefault").html(sp.name);
			  $("#displayDefault").attr("title",sp.name)
			  $("#displayDefault").next().html(sp.discription);
			  var time=sp.uploadTime;
			  if(time == null || time == ""){
				    
			  }else{
				  time=time.substring(0,10);				  
			  }
			  $("#displayDefault").next().next().html(time);
			  $("#displaySp").css({"background-color":sp.icon});
			  $("#editeSp").show();
		  }
		  });
				 
	
	
	
}

function colorTab(divName){
	
	var allMainBarLi=$("#"+divName).find("li");
	
	$(allMainBarLi).each(function(){
			$(this).click(function(){
				var allMainBarLi=$("#"+divName).find("li").each(function() {
			    $(this).removeClass("active");});
				//alert($(this).attr("class"));				
				$("#enName").val($(this).attr("class"));
				$(this).addClass("active");
				$("#icon").val($(this).css("background-color"));
				//alert($(this).css("background-color"));
			});	
    });	
	
	
	
}



function colorTabedtie(divName){
	
	var allMainBarLi=$("#"+divName).find("li");
	
	$(allMainBarLi).each(function(){
			$(this).click(function(){
				var allMainBarLi=$("#"+divName).find("li").each(function() {
			    $(this).removeClass("active");});
				//alert($(this).attr("class"));				
				$("#enNameed").val($(this).attr("class"));
				$(this).addClass("active");
				$("#iconed").val($(this).css("background-color"));
				//alert($(this).css("background-color"));
			});	
    });	
	
	
	
}