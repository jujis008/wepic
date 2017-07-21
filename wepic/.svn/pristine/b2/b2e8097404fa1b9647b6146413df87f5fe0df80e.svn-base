//第一步验证
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
		window.location = "changeEmailStepTwo.html";
		}
}



//对电子邮件的验证
function nextTwo(email,remind){
	var emailV = $("#"+email).val();
	$("#"+remind).html("");
	
		if(emailV == "" || emailV == null){
			$("#"+remind).html("请输入新邮箱");
			$("#"+remind).css("color","#FF0000");
			}
		else{
		 	var emailcheck = isEmail(emailV);
			if(emailcheck==false){
				$("#"+remind).html("请输入正确的邮箱地址");
				$("#"+remind).css("color","#FF0000");
				}
			else{
				window.location = "changeEmailStepThree.html";
				
				}
           }
	var EmailC = chechHaveEmail(emailV);					//模拟检测邮箱是否已被注册
		if(EmailC==false){
			$("#"+remind).html("该邮箱已注册");
			}
       }
function chechHaveEmail(value){
	if(value=="wepic@wepic.com"){return false}
	else{return true}
	}
function isEmail(s){
	var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
     if(!myreg.test(s)){
            return false;
		}
} 



//对验证码验证
function nextThree(code,remind){
	var codeV = $("#"+code).val();
	$("#"+remind).html("");
	
	var myCode = "000000";
		if(codeV == "" || codeV == null){
			$("#"+remind).html("请输入验证码");
			$("#"+remind).css("color","#FF0000");
			}
		else if(codeV !=myCode ){
			$("#"+remind).html("验证码输入错误");
			$("#"+remind).css("color","#FF0000");
			}
		else{
			window.location = "changeEmailStepSuccess.html";
			}

}

/*手机验证码*/
function achieveMobile(mobile){
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
		$("#achieveBut").css("cursor","pointer");
        						
    }
}



/*手机验证码下一步*/

function nextMobile(phone,remind){
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
			window.location = "changeEmailStepTwo.html";
			}

}