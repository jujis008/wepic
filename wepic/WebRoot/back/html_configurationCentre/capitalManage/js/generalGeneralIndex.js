$(function(){
	hoverAddClassB("allBlank");   //显示图片上隐藏信息
	
	
	settingDefaultCard();					//设置默认银行卡
	deleteBlank();					//删除银行卡
	
	defaultCard();					//初始化样式
	
	achieveBlank("divdropDownViewBlank","divdropDownBlank");
	});	
	
	
	
//删除银行卡	
function deleteBlank(){
	var allDelete=$("#allBlank").find(".opyDelete");
	
	$(allDelete).each(function(){
			$(this).click(
				function(){
					$(this).parents(".blank").remove();
				}
			);
    });	

}	
	
	
	
	
/* active 动作	---jquery*/
function hoverAddClassB(divName){
	var allOption=$("#"+divName).find(".blank_option");
	
	$(allOption).each(function(){
			$(this).hover(
				function(){$(this).addClass("active");},
				function(){$(this).removeClass("active");}
			);
    });	

}


//初始化样式
function defaultCard(){
	var alBlank=$("#allBlank").find(".blank");
	
	//变成默认样式
	$(alBlank).each(function(){
		$(this).find(".default_card").remove();
		$(this).find(".option_to").remove();
		$(this).find(".blank_option").append(
		'<div class="option_to">'+
				'<div class="bj"></div>'+
				'<div class="bjc">'+
					'<a href="javascript:" class="opyDefault">设为默认</a>'+
					'<a href="javascript:" class="opyDelete">删除</a>'+
				'</div>'+
			'</div>');
    });	
	
	
	
	
	var firstDiv=$("#allBlank > div:first-child");
	
	
	
	if($(firstDiv).find(".blank_option").find(".default_card").length == 1){
		//如果有了，则不做操作
		}
	else{
		//如果没有，增加默认提现标志
		$(firstDiv).find(".blank_option").append('<div class="default_card"><font>默认提现卡</font></div>');
		}
	
	$(firstDiv).find(".blank_option").find(".opyDefault").remove();			//删除第一个设置默认操作
	$(firstDiv).find(".blank_option").removeClass("active");				//删除第一个隐藏显示 的active
	
	
	hoverAddClassB("allBlank");   //显示图片上隐藏信息
	settingDefaultCard();					//设置默认银行卡
	deleteBlank();					//删除银行卡
}	


//设置默认银行卡		添加事件
function settingDefaultCard(){
	var allSetDefaultCard=$("#allBlank").find(".opyDefault");
	
	$(allSetDefaultCard).each(function(){
			$(this).click(
				function(){
					var defultBlank = $(this).parents(".blank").html();
					var defultBlankDiv = '<div class="blank">' + defultBlank + '</div>';
					
					$(this).parents(".blank").remove();
					
					$("#allBlank").prepend(defultBlankDiv);
					
					defaultCard();					//增加默认银行卡
					}
				
			);
    });	
}	


var flag = 0;
function showBlank(showDiv){
	if(flag == 0){
		$("#"+showDiv).show();
		flag = 1;
	}
	else{
		$("#"+showDiv).hide();
		flag = 0;
		}
}
	
	

/*银行下拉框*/
function achieveBlank(showValue,bolewDiv){
	var bolewDivDiv=$("#"+bolewDiv).find("div");

	
	$(bolewDivDiv).each(function() {
		$(this).click(
			function(){
				var classBlank = $(this).attr("class");
				$("#"+showValue).attr("class",classBlank);
				$("#"+bolewDiv).hide();
				flag = 0;
				});
	
		});	
	$(".divdropDown").each(function() {
        $(this).hover(
		function(){
			//$(this).find(".belowValue").show();
		},
		function(){
			$(this).find(".dropDownBoxValue").hide();
				flag = 0;
		});
    });
	
}



/*银行下拉框*/



function saveBlank(){
	var openNameValue = $("#inputOpenName").val();
	var openBlankValue = $("#inputOpenBlank").val();
	var blankNumberValue = $("#inputBlankNumber").val();
	
	var openNameValueRemind = true,openBlankValueRemind = true,blankNumberValueRemind = true;
	
	$(".tr_remind").hide();
	if(openNameValue == null || openNameValue == '' ){
		$("#remindOpenName").show();
		openNameValueRemind = false;
		return;
		}
	if(openBlankValue == null || openBlankValue == '' ){
		$("#remindOpenBlank").show();
		openBlankValueRemind = false;
		return;
		}
	if(blankNumberValue == null || blankNumberValue == '' ){
		$("#remindBlankNumber").show();
		blankNumberValueRemind = false;
		return;
		}
	
	
	
	var blankIco = $("#divdropDownViewBlank").attr("class");
	var blankNumberLastFour = blankNumberValue.replace(/[ ]/g,"").slice(-4);

	var addBlank = '<div class="blank">'+
                	'<div class="blank_top">'+
                    	'<div class="card_use">工资卡</div>'+
                       '<div class="card_tail_number">'+
                        	'<span class="span_tail">尾号：</span>'+
                    		'<span class="tail_val">'+blankNumberLastFour+'</span>'+
                        '</div>'+
                   ' </div>'+
                    '<div class="blank_ico">'+
                    	'<div class="'+ blankIco +'"></div>'+		
                    '</div>'+
                    '<div class="blank_option">'+
                    	'<div class="deposit_time">'+
                        	'<span class="spano">提现次数：</span>'+
                    		'<span class="tailt">12</span>次'+
                        
                        '</div>'+
                        
                        '<div class="option_to">'+
                        	'<div class="bj"></div>'+
                        	'<div class="bjc">'+
                        		'<a href="javascript:" class="opyDefault">设为默认</a>'+
                        		'<a href="javascript:" class="opyDelete">删除</a>'+
                            '</div>'+
                        '</div>'+
                    '</div>'+
                '</div>';
				
	var addLast = 
		'<div class="add_blank" onclick="openPopUpBoxBlank(divChooseBlank);">'+
                	'<div class="add_ico"></div>'+
                	'<div class="add_character">添加银行卡</div>'+
                '</div>'+
            '<div class="clearDiv" style="clear:both;"></div>';
			
						
	if(openNameValueRemind && openBlankValueRemind && blankNumberValueRemind){
		clooseBlank();
		$("#allBlank").find('.add_blank').remove();
		$("#allBlank").find('.clearDiv').remove();
		$("#allBlank").append(addBlank);
		
		$("#allBlank").append(addLast);
		
		defaultCard();					//初始化样式
		}
	}
	


function clooseBlank(){
	cloosePopBox('divChooseBlank');
	document.getElementById("formChooseBlank").reset();
	}



function addCard(){
	}


function openPopUpBoxBlank(divPopUpBox){
	var htmlWidth = document.body.clientWidth;
	var htmlHeight = document.body.clientHeight;
	var borwerViewWidth =  document.documentElement.clientWidth;
	var borwerViewHeight =  document.documentElement.clientHeight;
	
	var scrollTop = getScrollTop();
	
	
	var getw =$(divPopUpBox).width();
	var geth = $(divPopUpBox).height();
	
	if(getheight == '' || getheight == null){
		getheight = 0;
		}
		
	var getwidth = parseInt(getw);
	var getheight = parseInt(geth);
	
	var topWidth = (borwerViewWidth - getwidth)/2;
	var topHeight = (borwerViewHeight - getheight)/ 2;
	
	$("#greybackground").remove();
	$("body").prepend('<div id="greybackground" style="position:absolute; z-index:700000;background:black;display:none"></div>');
	$("#greybackground").css({ "opacity": "0.8", "height": htmlHeight+"px","display":"block","width": htmlWidth+"px","background":"black","top":"0px","left":"0px"});
	$("#greybackground").show();
	
	$(divPopUpBox).show();
	$(divPopUpBox).css({ "position": "absolute","z-index":"800000","top": scrollTop + "px" , "left": topWidth+"px"});
	
	
}