$(function(){
	    
	$('#newPassword').strength();
	})
	


/*旧密码验证*/
function oldPassword(oldpassword,remind){
	
	var oldV = $("#"+oldpassword).val();
	$("#"+remind).html("");
	
	var myOldV = "000000";
		if(oldV == "" || oldV == null){
			$("#"+remind).html("请输入原密码");
			return false;
			}
		else if(oldV != myOldV ){
			$("#"+remind).html("原密码输入错误");
			return false;
			}
		else{
			return true;
			}

}

/*旧密码验证2*/
function oldPasswordTwo(oldpassword,remind){
	
	var oldV = $("#"+oldpassword).val();
	$("#"+remind).html("");
	
		if(oldV == "" || oldV == null){
			$("#"+remind).html("请输入原密码");
			return false;
			}
		else{
			return true;
			}

}


/*新密码验证*/
function newPassword(newpassword,remind){
	var newV = $("#"+newpassword).val();
	$("#"+remind).html("");
	
	var passwordcheck = isPassword(newV);
	
	var myNewV = "000000";
		if(newV == "" || newV == null){
			$("#"+remind).html("请输入新密码");
			return false;
			}
		else if(passwordcheck == false){
			$("#"+remind).html("请输入5-12位字符的密码");
			return false;
			}
		else{
			return true;
			}

}
	
//校验密码：只能输入5-12个以字母开头、可带数字、“_”、“.”的字串
function isPassword(s){
	var patrn=/^[a-zA-Z0-9]{1}([a-zA-Z0-9]|[_]){4,11}$/;
	if (!patrn.exec(s)) return false
	return true
} 	
	

/*新密码确认*/
function rePassword(newpassword,rePassword){
	var newV = $("#"+newpassword).val();
	var reV = $("#"+rePassword).val();
	$("#rePasswordRemind").html("");
	
	
		if(reV == "" || reV == null){
			$("#rePasswordRemind").html("请输入确认密码");
			return false;
			}
		else if(newV != reV){
			$("#rePasswordRemind").html("确认密码输入错误");
			return false;
			}
		else if(newV == reV){
			return true;
			}

}


//提交修改
function changePassSubmit(){
	var oldResult = oldPassword('oldPassword','oldPasswordRemind');					/*旧密码验证*/
	var newResult = newPassword('newPassword','newPasswordRemind');					/*新密码验证验证*/
	var reResult = rePassword('newPassword','rePassword');					/*新密码确认*/
	if(oldResult&&newResult&&reResult){
		window.location = 'changePasswordSuccess.html';
		}
	}