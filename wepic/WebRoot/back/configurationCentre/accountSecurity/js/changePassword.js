$(function(){
	    
	$('#newPassword').strength();
	})

/*旧密码验证*/
function oldPassword(oldpassword,remind){
	var res=0;
	var oldV = $("#"+oldpassword).val();
	$("#"+remind).html("");
	if(oldV == "" || oldV == null){
		$("#"+remind).html("请输入原密码");
		res=0;
	}else{
	$.ajax({
	      type:"Post",
		  url: "configurajson_validatepwd.do",
		  data:"oldpwd="+oldV,
		  async:false,
		  success : function(data) {
          var statu=data.state;
          if(statu == 0){
        	  res=0;
        	  $("#oldPassword").val("");
        	  $("#newPassword").val("");
        	  $("#rePassword").val("");
          }else{
        	  var newV = $("#newPassword").val();
        	  var reV = $("#rePassword").val();
        	  $("#rePasswordRemind").html("");
	      	  if(reV == "" || reV == null){
	      		 $("#rePasswordRemind").html("请输入确认密码");
	      		res=0;
	      		}else{
      			if(newV != reV){
      				$("#rePasswordRemind").html("确认密码输入错误");
      				$("#newPassword").val("");
              	    $("#rePassword").val("");
      				res=0;
      				}else{
      					$.ajax({
      					      type:"Post",
      						  url: "configurajson_modifysucpwd.do",
      						  data:"newpwd="+newV,
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
      		}
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
	




//提交修改
function changePassSubmit(){
	
	var oldResult = oldPassword('oldPassword','oldPasswordRemind');					/*旧密码验证*/
	var newResult = newPassword('newPassword','newPasswordRemind');					/*新密码验证验证*/
	
	if(oldResult && newResult){
		location.href="configure!modifypwdsuc.do";
		}
	}