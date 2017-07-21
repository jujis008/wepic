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



/*第一步  手机验证码下一步1111*/

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
function achieveMobile(userId,nextOnePasswordPhone){
	$("#"+nextOnePasswordPhone).removeAttr("disabled");
	$("#"+nextOnePasswordPhone).css("background","#fff");
	$("#"+nextOnePasswordPhone).focus();
	var id=$("#"+userId).val();
	$.ajax({
	      type:"Post",
		  url: "configurajson_sendmobilecode.do",
		  data:"userId="+id,
		  success : function(data) {
          var statu=data.state;
		  }
	  });
	fun_timedown(60);
}
function achieveMobile2(mobile,userId,nextOnePasswordPhone,oldmobile,passReminds){
	var id=$("#"+userId).val();
	var newmobile=$("#"+mobile).val();
	var oldmobile=$("#"+oldmobile).val();
	if(newmobile == oldmobile){
		$("#passReminds").html("新输入新手机号");
		$("#passReminds").css("color","#FF0000");
		$("#"+mobile).val("");
	}else{
	$.ajax({
	      type:"Post",
		  url: "configurajson_sendmobilecode.do",
		  data:"userId="+id+"&newmobile="+newmobile,
		  success : function(data) {
          var statu=data.state;
          if(statu == 0){
        	  $("#passReminds").html("此号码已被注册,请输入其他号码");
        	  $("#passReminds").css("color","#FF0000");
//      		  $("#"+mobile).val("");
          }else{
        	 $("#"+nextOnePasswordPhone).removeAttr("disabled");
      		$("#"+nextOnePasswordPhone).css("background","#fff");
      		$("#"+nextOnePasswordPhone).focus();
        	  fun_timedown(60);
          }
		  }
	  });
	
	}
	
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
    $("#nextOnePasswordPhone").attr("disabled","false");
	$("#nextOnePasswordPhone").css("background","none repeat scroll 0 0 #EDEDED");
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
function achieveMobileMail(mobile,achieveBut){
	$.ajax({
	      type:"Post",
		  url: "configurajson_sendemail.do",
		  data:"",
		  success : function(data) {
            var statu=data.state;
            if(statu == 0){
            }else if(statu == 2){
            	$("#passRemind").val("邮件发送失败,请检查邮箱是否有效.");
            }else{
            	$("#"+mobile).removeAttr("disabled");
            	$("#"+mobile).css("background","#fff");
            	$("#"+achieveBut).css({"background":"#f5f5f5","color":"#8c8c8c"});
            	$("#"+mobile).focus();
            	$("#goToView").show();
            	$("#trRemind").show();
            	fun_timedown(60);        	
            }
		  }
	  });
	
	
	}



