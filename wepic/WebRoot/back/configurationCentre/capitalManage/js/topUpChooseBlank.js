$(function(){	
	addActiveByClass3("topUpBlank","blank");
	});	
function addActiveByClass3(divName,classname){
	var allMainBarLi=$("#"+divName).find("."+classname);
	
	$(allMainBarLi).each(function(){
			$(this).click(function(){
				var allMainBarLi=$("#"+divName).find("."+classname).each(function() {$(this).removeClass("active");$(this).find("input").removeAttr("checked");});
				$(this).addClass("active");
				$(this).find("input").attr("checked","checked");
			});	
    });	
}
function next(){
	var allBlank = $("#topUpBlank").find(".blank");
	var length = 0;
	var radioV;
	
	$(allBlank).each(function(index, element) {
        if($(this).attr("class") != 'blank'){
			radioV = trim($(this).find("input").val());
			}
    });
	
	$(allBlank).each(function(index, element) {
        if($(this).attr("class") == 'blank'){
			length++;
			}
    });
	
	if($("#topUpMoney").val() == '' || $("#topUpMoney").val() == null){
		alert("请输入充值金额");
		return;
		}
	
	if(length == allBlank.length){
		alert("请选择银行");
		return;
		}
		
	if(radioV == '支付宝'){
		$("#formBlank").attr("action","https://www.alipay.com/").submit();
		}
	if(radioV == '中国银联'){
		$("#formBlank").attr("action","http://cn.unionpay.com/").submit();
		}
	if(radioV == '转账支付'){
		$("#formBlank").attr("action","topUpChooseBlankTransfer.html").submit();
		}
	if(radioV == '中国银行'){
		$("#formBlank").attr("action","http://www.boc.cn/ebanking/").submit();
		}
	
	}
function submitBlank(){
	var allspan = $(".table_transferInfo").find(".spanOne");
	$(allspan).each(function(index, element) {
        $(this).remove();
    });
	
	var transferCardNumber = trim($("#transferCardNumber").val());
	var blankCardName = trim($("#blankCardName").val());
	var transferedMoney = trim($("#transferedMoney").val());
	var transferTime = trim($("#transferTime").val());
	
	
	if(transferCardNumber == null || transferCardNumber == ''){
		$("#transferCardNumber").parent().append("<span class='spanOne'>请输入转账银行账号</span>");
		return;
		}
	if(blankCardName == null || blankCardName == ''){
		$("#blankCardName").parent().append("<span class='spanOne'>请输入银行开户名</span>");
		return;
		}
	if(transferedMoney == null || transferedMoney == ''){
		$("#transferedMoney").parent().append("<span class='spanOne'>请输入已转账金额</span>");
		return;
		}
	if(transferTime == null || transferTime == ''){
		$("#transferTime").parent().append("<span class='spanOne'>请选择转账日期</span>");
		return;
		}
	
//	window.location = 'topUpChooseBlankTransferSuccess.html';
	
	}