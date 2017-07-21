$(function(){
	
	achieveBlankOO();
	
	
	achieveBlank("divdropDownViewBlank","divdropDownBlank");
	});	





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
function achieveBlankOO(){
	var bolewDivDiv=$("#divdropDownBlankOO").children();

	
	$(bolewDivDiv).each(function() {
		$(this).click(
			function(){
				var classBlank = $(this).html();
				$("#dropDownBoxParentOO").html(classBlank);
				$("#dropDownBoxParentOO").append('<div class="dropDownBoxR"><i></i></div>');
				$("#divdropDownBlankOO").hide();
				flag = 0;
				});
	
		});	
	$(".divdropDown").each(function() {
        $(this).hover(
		function(){
			//$(this).find(".belowValue").show();
		},
		function(){
			$(this).find(".selectBlankList").hide();
				flag = 0;
		});
    });
	
}



/*银行下拉框*/





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




function saveBlank(){
	var openNameValue = $("#inputOpenName").val();
	var openBlankValue = $("#inputOpenBlank").val();
	var blankNumberValue = $("#inputBlankNumber").val();
	
	var remarkCardValue = $("#remarkCard").val();
	
	if(remarkCardValue == null || remarkCardValue == null){
		remarkCardValue = '提现卡';
		}
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

	var addBlank =  '<div class="selectblankDiv">'+
						'<div class="'+ blankIco+'"></div>'+
						'<div class="blankValue">'+remarkCardValue+'</div>'+
						'<div class="tailNumber">尾号：'+blankNumberLastFour+'</div'+
				   '</div>';
				
			
						
	if(openNameValueRemind && openBlankValueRemind && blankNumberValueRemind){
		clooseBlank();
		
		$("#divdropDownBlankOO").append(addBlank);
		
		
		//defaultCard();					//初始化样式
		
		
		achieveBlankOO();
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



function clooseBlank(){
	cloosePopBox('divChooseBlank');
	document.getElementById("formChooseBlank").reset();
	}


function submitapplyFor(){
	var moneyDepositValue = $("#moneyDeposit").val();

	if( moneyDepositValue % 100 != 0){
		alert("请检查提现金额是否符合要求");
		}
	else{
		alert("成功");
		}
	}

