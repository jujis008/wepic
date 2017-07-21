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
				var hiddenvalue=$(this).find("input").val();
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
				var hiddenId=$(this).find("input").val();
				$("#divdropDownViewBlank").find("input").val(hiddenId);
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

function validateform(){
	var inputOpenName=$("#inputOpenName").val();
	var inputOpenBlank=$("#inputOpenBlank").val();
	var inputBlankNumber=$("#inputBlankNumber").val();
	if(inputOpenName != "" && inputOpenBlank !="" && inputBlankNumber!=""){
		$("#remindOpenName").hide();
		$("#remindOpenBlank").hide();
		$("#remindBlankNumber").hide();
		return true;
	}
	if(inputOpenName ==""){
		$("#remindOpenName").show();
		return false;
	}
	if(inputOpenBlank ==""){
		$("#remindOpenBlank").show();
		return false;
	}
	if(inputBlankNumber ==""){
		$("#remindBlankNumber").show();
		return false;
	}
}
function submitapplyFor(){
	var moneyDepositValue = $("#moneyDeposit").val();
	var hiddenbank=$("input[name='withdrawbankaccount']").val();
	if(moneyDepositValue =="" || moneyDepositValue ==null){
		alert("请输入提现金额");
		$("#moneyDeposit").focus();
	}else{
	if( moneyDepositValue % 100 != 0){
		alert("请检查提现金额是否符合要求");
		$("#moneyDeposit").val("");
		$("#moneyDeposit").focus();
		}
	else{
		$.ajax({
			type : "POST",
			url : "withdrawHistory_validateInputCash.do",
			data : "userwithdrawMoney="+moneyDepositValue+"&hiddenbank="+hiddenbank,
			success : function(data) {
			var resmap = data.resMap;
			var cashId;
			var flag;
			for (cashId in resmap) {
			var arr=resmap[cashId];
			flag=arr[0];
			if(cashId == -1){
				if(flag==1){
				    alert("请等待管理员审批该提现！！");
				    document.getElementById("moneyDeposit").disabled=true;
				    document.getElementById('availbaleUser').innerHTML=arr[1];
					document.getElementById('freezeBalance').innerHTML=arr[2];
					document.getElementById("applywithdraw").disabled=true;
				    }else if(flag==2){
							alert("您的余额不足！！");
							$("#moneyDeposit").val("");
							$("#moneyDeposit").focus();
							}else if(flag==3){
							alert("网络请求中断！！");
							}else if(flag==4){
							alert("您的开户行为空,系统不允许您提现！！！");
							$("#moneyDeposit").val("");
							$("#moneyDeposit").focus();
							}
			}else{
					if(flag==1){
				    alert("请等待管理员审批该提现！！");
				    document.getElementById("moneyDeposit").disabled=true;
				    document.getElementById('availbaleUser').innerHTML=arr[1];
					document.getElementById('freezeBalance').innerHTML=arr[2];
					document.getElementById("applywithdraw").disabled=true;
				    }else if(flag==2){
							alert("您的余额不足！！");
							$("#moneyDeposit").val("");
							}else if(flag==3){
							alert("网络请求中断！！");
							}else if(flag==4){
							alert("您的开户行为空,系统不允许您提现！！！");
							document.getElementById("textWithdrawal").value="";
							}	
				}
			}
			}
		});
		}
	}
	}

