//第一步  密码验证
function nextOne(password,remind){
	var pass = $("#"+password).val();
	$("#"+remind).html("");
	var mypass = "wepic";
	if(pass == '' || pass == null){
		$("#"+remind).html("请输入当前密码");
		$("#"+remind).css("color","#FF0000");
		}
	else if(pass != mypass){
		$("#"+remind).html("密码输入错误");
		$("#"+remind).css("color","#FF0000");
		}
	else{
		window.location = "changePhoneTwo.html";
		}
}



/*第一步  手机验证码下一步*/
function nextOneMobile(phone,remind){
	var phoneV = $("#"+phone).val();
	$("#"+remind).html("");
	
	var myPhone = "000000";
		if(phoneV == "" || phoneV == null){
			$("#"+remind).html("请输入手机验证码");
			$("#"+remind).css("color","#FF0000");
			}
		else if(phoneV != myPhone ){
			$("#"+remind).html("手机验证码输入错误");
			$("#"+remind).css("color","#FF0000");
			}
		else{
			window.location = "changePhoneTwo.html";
			}

}


/*手机验证码*/
function achieveMobile(mobile,achieveBut){
	$("#"+mobile).removeAttr("disabled");
	$("#"+mobile).css("background","#fff");
	$("#"+achieveBut).css({"background":"#f5f5f5","color":"#8c8c8c"});
	$("#"+mobile).focus();
	fun_timedown(60);
	
	}


/*手机验证码	邮箱用*/
function achieveMobileMail(mobile,achieveBut){
	$("#"+mobile).removeAttr("disabled");
	$("#"+mobile).css("background","#fff");
	$("#"+achieveBut).css({"background":"#f5f5f5","color":"#8c8c8c"});
	$("#"+mobile).focus();
	$("#goToView").show();
	$("#trRemind").show();
	fun_timedown(60);
	
	}

//验证手机
function checkSubmitMobil(){ 
	
	var phone = $("#nextOnePassword").val();
	$("#passReminds").html("");
    if(phone == "" || phone == null){ 
    $("#passReminds").html("手机号码不能为空"); 
		$("#passReminds").css("color","#FF0000");
	
    $("#nextOnePassword").focus(); 
    return false; 
   } 

   if(!phone.match(/^1[3|4|5|8][0-9]\d{4,8}$/)){ 
    $("#passReminds").html("手机号码格式不正确！请重新输入！"); 
	$("#passReminds").css("color","#FF0000");
    $("#nextOnePassword").focus(); 
    return false; 
   } 
   return true; 
}


/*手机验证码下一步*/
function nextMobile(phone,remind){
	checkSubmitMobil();
	
	
	var phoneV = $("#"+phone).val();
	$("#"+remind).html("");
	
	var myPhone = "000000";
		if(phoneV == "" || phoneV == null){
			$("#"+remind).html("请输入手机验证码");
			$("#"+remind).css("color","#FF0000");
			}
		else if(phoneV != myPhone ){
			$("#"+remind).html("手机验证码输入错误");
			$("#"+remind).css("color","#FF0000");
			}
		else{
			window.location = "changePhoneSuccess.html";
			}

}
function achieveMobile2(mobile){
	$("#"+mobile).removeAttr("disabled");
	$("#"+mobile).css("background","#fff");
	$("#"+mobile).focus();
	fun_timedown(60);
	}

function fun_timedown(time){
	clearTimeout(timer);
    if(time=='undefined')
        time = 60;
    $("#achieveBut").val(time+"秒后可重新获取");
    
    time = time-1;
    if(time >= 0)
    {
		$("#achieveBut").attr("disabled","disabled");
		$("#achieveBut").css("cursor","default");
       var timer = setTimeout("fun_timedown("+time+")",1000);
    }else
    {
    	$("#achieveBut").val("获取短信验证码");				//倒计时结束啦
		$("#achieveBut").removeAttr("disabled");
		$("#achieveBut").css({"cursor":"pointer","color":"#000","background":"#dedede"});
        						
    }
}


