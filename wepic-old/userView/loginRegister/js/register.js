function checkUserName(){
	var username=document.getElementById("inputUserName");
	var bremind=document.getElementById("bremind");	
	var divremindnull=document.getElementById("divremindnull");				//正确的图标
	var divremind=document.getElementById("divremind");					//错误提醒
	var divremindhave=document.getElementById("divremindhave");
	
	
	var usernmaeV = username.value;
		if(usernmaeV==""||usernmaeV==null){
			divremindnull.style.display="block";				//为空
			divremind.style.display="none";
			divremindhave.style.display="none";
			bremind.style.display="none";
			username.style.background="#FDDEDC";
			username.style.border="1px solid #FFBFBF";
			
			}
		else{
			var nameSize = isRegisterUserName(usernmaeV);
			if(nameSize==false){
				divremind.style.display="block";				//错误
				divremindnull.style.display="none";
				divremindhave.style.display="none";
				bremind.style.display="none";
				username.style.background="#FDDEDC";
				username.style.border="1px solid #FFBFBF";
				}
			else{
				bremind.style.display="block";					//正确
				divremindnull.style.display="none";
				divremind.style.display="none";
				divremindhave.style.display="none";
				}
    		}
			
	var usernameC = chechHave(usernmaeV);					//模拟检测用户名是否已被注册
		if(usernameC==false){
			divremindnull.style.display="none";
			divremind.style.display="none";
			divremindhave.style.display="block";
			bremind.style.display="none";
			}
	}
	
function chechHave(value){
	if(value=="wepic"){return false}
	else{return true}
	}


//校验登录名：只能输入5-12个以字母开头、可带数字、“_”、“.”的字串
function isRegisterUserName(s){
	var patrn=/^[a-zA-Z0-9]{1}([a-zA-Z0-9]|[_]){4,11}$/;
	if (!patrn.exec(s)) return false
	return true
} 
         

 //对电子邮件的验证
function checkEmail(){
	var email = document.getElementById("inputEmail");
	var divremindEmailnull = document.getElementById("divremindEmailnull");
	var bremindEmail = document.getElementById("bremindEmail");
	var divremindEmailError = document.getElementById("divremindEmailError");
	var divremindEmailhave = document.getElementById("divremindEmailhave");
	
   var emailV = email.value;
		if(emailV==""||emailV==null){
			divremindEmailnull.style.display="block";
			bremindEmail.style.display="none";
			divremindEmailError.style.display="none";
			divremindEmailhave.style.display="none";
			email.style.background="#FDDEDC";
			email.style.border="1px solid #FFBFBF";
			}
		else{
		 	var emailcheck = isEmail(emailV);
			if(emailcheck==false){
				divremindEmailError.style.display="block";
				divremindEmailnull.style.display="none";
				bremindEmail.style.display="none";
				divremindEmailhave.style.display="none";
				email.style.background="#FDDEDC";
				email.style.border="1px solid #FFBFBF";
				}
			else{
				bremindEmail.style.display="block";
				divremindEmailError.style.display="none";
				divremindEmailnull.style.display="none";
				divremindEmailhave.style.display="none";
				}
           }
	var EmailC = chechHaveEmail(emailV);					//模拟检测邮箱是否已被注册
		if(EmailC==false){
			bremindEmail.style.display="none";
			divremindEmailError.style.display="none";
			divremindEmailnull.style.display="none";
			divremindEmailhave.style.display="block";
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

 //对密码的验证
function checkPassword(){
	var password = document.getElementById("inputPassword");
	var bremindPassword = document.getElementById("bremindPassword");
	var divremindPasswordnull = document.getElementById("divremindPasswordnull");
	var divremindPasswordError = document.getElementById("divremindPasswordError");
	
   var passwordV = password.value;
		if(passwordV==""||passwordV==null){
			divremindPasswordnull.style.display="block";
			bremindPassword.style.display="none";
			divremindPasswordError.style.display="none";;
			password.style.background="#FDDEDC";
			password.style.border="1px solid #FFBFBF";
			}
		else{
		 	var passwordcheck = isRegisterUserName(passwordV);
			if(passwordcheck==false){
				password.value="";
				divremindPasswordError.style.display="block";
				bremindPassword.style.display="none";
				divremindPasswordnull.style.display="none";
				password.style.background="#FDDEDC";
				password.style.border="1px solid #FFBFBF";
				}
			else{
				bremindPassword.style.display="block";
				divremindPasswordError.style.display="none";
				divremindPasswordnull.style.display="none";
				}
           }
       }
	   
	   
 //确认密码验证
function checkPasswordAffirm(){
	var password = document.getElementById("inputPassword");
	var passwordAffirm = document.getElementById("inputPasswordAffirm");
	
	var bremindPasswordAffirm = document.getElementById("bremindPasswordAffirm");
	var divbremindPasswordAffirm = document.getElementById("divbremindPasswordAffirm");
	var divbremindPasswordAffirmNull = document.getElementById("divbremindPasswordAffirmNull");
	
   	var passwordV = password.value;
	var passwordAffirmV = passwordAffirm.value;
		if((passwordV == "" || passwordV == null)||(passwordAffirmV == "" || passwordAffirmV == null)){
			bremindPasswordAffirm.style.display="none";
			divbremindPasswordAffirm.style.display="none";
			divbremindPasswordAffirmNull.style.display="block";
			passwordAffirm.style.background="#FDDEDC";
			passwordAffirm.style.border="1px solid #FFBFBF";
			}
		else{
			if(passwordV == passwordAffirmV){
			bremindPasswordAffirm.style.display="block";
			divbremindPasswordAffirm.style.display="none";
			divbremindPasswordAffirmNull.style.display="none";
				}
			else{
			passwordAffirm.value="";
		 	bremindPasswordAffirm.style.display="none";
			divbremindPasswordAffirm.style.display="block";
			divbremindPasswordAffirmNull.style.display="none";
			passwordAffirm.style.background="#FDDEDC";
			passwordAffirm.style.border="1px solid #FFBFBF";
           		}
			}
		
       }

// 同意唯图网的 用户服务条款
function changeCheckboxTerm(obj){
	//$("#createAccount").attr("disabled",false);
	//$("#createAccount").addClass("classCreateAccount");
		if(obj.checked){
			
			$("#createAccount").attr("disabled",false);
			//$("#createAccount").addClass("classCreateAccount");
			document.getElementById("createAccount").className="classCreateAccount";
			//alert(document.getElementById("createAccount").className);
			$("#createAccount").css({"background":"#A22C31"});
			}
		else{
			
			$("#createAccount").attr("disabled",true);
			$("#createAccount").css({"background":"#CCCCCC"});
			document.getElementById("createAccount").className="";
			//$("#createAccount").removeClass("classCreateAccount");
			//alert(document.getElementById("createAccount").className);
			}
    	 
		 }




//进入输入框
function tableInputOnfocus(obj){
	obj.style.background="#FFFCE1";
	obj.style.border="1px solid #D5CF9B";
	//$(obj).css({"border":"1px solid #D5CF9B"});
	}