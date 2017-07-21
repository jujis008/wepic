$(function(){
	document.getElementById("formEnterprise2").reset();
	$(".upload_pho").removeAttr("disabled");
	$("#verificationCodeB").removeAttr("disabled");					//验证码按钮
	$("#verificationCodeT").attr("disabled","disabled");			//验证码输入框
	});

	
//姓名验证
function verifyName(){
	$("#nameRemind").html("");
	var val = $("#releName").val();
	var length = characterLength(val);
	
	if(val=='') {
		$("#nameRemind").html("请输入真实姓名");
		return false;
		}
	if(length < 4){
		$("#nameRemind").html('姓名最少两个汉字');
		return false;
		}
	else{
		return true;
		}
	}





//身份证号验证
function verifyIdentity(idCard){
	var cardVal = $("#"+idCard).val();
	var card = IdCardValidate(cardVal);
	$("#identityRemind").html("");
	if(card == false){
		$("#identityRemind").html("请输入正确有效的身份证号码");
		return false;
		}
	if(card == true){
		return true;
		}
	}


//部门职务
function verifyDepartmentDuty(){
	
	var depart = $("#departmentDuty").val();
	$("#departmentDutyRemind").html("");
    if(depart == "" || depart == null){ 
    $("#departmentDutyRemind").html("部门职务不能为空"); 
	
    $("#departmentDuty").focus(); 
    return false; 
   } 

   return true; 
}



//手机号验证
function verifyMobilePhone(){
	
	var phone = $("#mobilePhone").val();
	$("#mobilePhoneRemind").html("");
    if(phone == "" || phone == null){ 
    $("#mobilePhoneRemind").html("手机号码不能为空"); 
	
    $("#mobilePhone").focus(); 
    return false; 
   } 

   if(!phone.match(/^1[3|4|5|8][0-9]\d{4,8}$/)){ 
    $("#mobilePhoneRemind").html("手机号码格式不正确"); 
    $("#mobilePhone").focus(); 
    return false; 
   } 
   return true; 
}

//获取手机验证码
function achieveMobile(mobile,writemobile,userId){
	var id=$("#"+userId).val();
	var mobile2=$("#"+writemobile).val();
	$.ajax({
	      type:"Post",
		  url: "configurajson_sendmobilecode.do",
		  data:"userId="+id+"&newmobile="+mobile2,
		  async:false,
		  success : function(data) {
        var statu=data.state;
        if(statu==0){
      	  $("#mobilePhoneRemind").html("此号码已被注册,输入其他号码");
      	  $("#mobilePhoneRemind").css("color","#FF0000");
        }else{
        	$("#"+mobile).removeAttr("disabled");
        	$("#"+mobile).css("background","#fff");
        	$("#"+mobile).focus();
        	fun_timedown(60);
        }
		  }
	  });
	
	}
	
function fun_timedown(time){
	clearTimeout(timer);
    if(time=='undefined')
        time = 60;
    $("#verificationCodeB").val(time+"秒后可重新获取");
    
    time = time-1;
    if(time >= 0)
    {
		$("#verificationCodeB").attr("disabled","disabled");
		$("#verificationCodeB").css("cursor","default");
       var timer = setTimeout("fun_timedown("+time+")",1000);
    }else
    {
    	$("#verificationCodeB").val("获取短信验证码");				//倒计时结束啦
		$("#verificationCodeB").removeAttr("disabled");
		$("#verificationCodeB").css("cursor","pointer");
        						
    }
}



/*手机验证码*/
function verifyCode(phone){
	var phoneV = $("#"+phone).val();
	$("#verificationCodeRemind").html("");
	var res=0;
	if(phoneV == "" || phoneV == null){
		$("#verificationCodeRemind").html("请输入手机验证码");
		return false;
	}else{
	$.ajax({
	      type:"Post",
		  url: "configurajson_validatemobilecode2.do",
		  data:"mobilecode="+phoneV,
		  async:false,
		  success : function(data) {
          var statu=data.state;
          if(statu == "1"){
        	res=1;
          }else{
        	res=0;
          }
		  }
	  });
	}
	if(res == 0){
		return false;
	}else{
		return true;
	}
}


/*身份证件*/
function verifyImg(){
	$("#uploadRemind").html("");
	
	var img = $("#imgPpreviewPhotograph").find("img");
		if(img.length == 0 || img.length == null){
			$("#uploadRemind").html("请上传证件照片");
			return false;
			}
		else if(img.length > 0){
			return true;
			}
	}
/*政府信息登记表*/
function verifyImg1(){
	$("#uploadRemind1").html("");
	
	var img = $("#imgRegistryForm").find("img");
		if(img.length == 0 || img.length == null){
			$("#uploadRemind1").html("政府信息登记表");
			return false;
			}
		else if(img.length > 0){
			return true;
			}
	}
/*上传申请公函*/
function verifyImg2(){
	$("#uploadRemind2").html("");
	
	var img = $("#imgOfficialLetter").find("img");
		if(img.length == 0 || img.length == null){
			$("#uploadRemind2").html("上传申请公函");
			return false;
			}
		else if(img.length > 0){
			return true;
			}
	}

function uploadPhotographImg(obj,addImg,ico,remind){
	$(obj).attr("disabled","disabled");
	var option;
	
	option = '<img src="../../../pubimg/pic/pho.png" id="imgIdentV" onload="javascript:DrawImage(this,200,200)" onclick="showImg(this);"/>';
	
	$("#"+addImg).append(option);
	$("#"+remind).html("");
	$("#"+ico).show();
	}

function showImg(obj){
	var img = '<img src="../../../pubimg/pic/pho.png"  id="imgIdentV" /><a onclick="cloosePopBoxI();"></a>';
	
	$("#viewBigPic").show();
	$("#viewBigPic").html('');
	$("#viewBigPic").html(img);
	
	openPopUpBoxObj("viewBigPic","imgIdentV");
	}

function cloosePopBoxI(divPopUpBox){
	$("#viewBigPic").hide();
	$("#greybackground").remove();
	$("#viewBigPic").html('');
}




//检测是否为空
function checkNull(inpu,remind){
	var inputVal = $("#"+inpu).val();
	
	$("#"+remind).html("");
	/*$("#"+inpu).css({"border":"1px solid #CCCCCC","background":"#FCFCFC"});*/
		if(inputVal == "" || inputVal == null){
			$("#"+remind).html("此项不能为空");
			/*$("#"+inpu).css({"border":"1px solid #ff0000","background":"#FFEBEB"});*/
			return false;
			}
		else{
			return true;
			}
	}

//对电子邮件的验证
function checkEMail(email,remind){
	var emailV = $("#"+email).val();
	$("#"+remind).html("");
	
		if(emailV == "" || emailV == null){
			$("#"+remind).html("请输入新邮箱");
			return false;
			}
		else{
		 	var emailcheck = isEmail(emailV);
			if(emailcheck==false){
				$("#"+remind).html("请输入正确的邮箱地址");
				return false;
				}
			else{
				return true;
				
				}
           }

       }

function isEmail(s){
	var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
     if(!myreg.test(s)){
            return false;
		}
} 





var allResule;
function submitVerification2(){
	var resultName = verifyName();						//姓名结果
	var resultIdentity = verifyIdentity('identityCard');				//身份证结果
	var resultDepartmentDuty = verifyDepartmentDuty();		//手机号结果
	var resultMobilePhone = verifyMobilePhone();		//手机号结果
	var resultCode = verifyCode('verificationCodeT');						//验证码结果
	var resultImgo = verifyImg1();							//政府信息登记表
	var resultImgt = verifyImg2();							//上传申请公函
	var resultImg = verifyImg();							//验证上传证件
	
	
	var resultEMail = checkEMail('enterpriseEMail','enterpriseEMailRemind');
	allResule = (resultName && resultIdentity && resultMobilePhone && resultCode && resultImg && resultDepartmentDuty &&resultImgo && resultImgt && resultEMail);
	
	var nameNull = checkNull('enterpriseName','enterpriseNameRemind');
//	var dateNull = checkNull('txtBeginDate','txtBeginDateRemind');
//	alert(dateNull+"dateNull");
	
	
	var qydzNull = checkNull('enterpriseAddress','enterpriseAddressRemind');
	var yyzzNull = checkNull('businessLicense','businessLicenseRemind');
	var zzjgNull = checkNull('organization','organizationRemind');
	var zyfwNull = checkNull('manageScope','manageScopeRemind');
	alltResule = (nameNull && qydzNull && yyzzNull &&zzjgNull && zyfwNull);
	
	if(allResule && alltResule == true){
		//验证成功
		alert("验证成功");
		return true;
		}else{
			return false;
			
		}
	}