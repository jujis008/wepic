function editMobilePhone(obj){
	var oldValue = $(obj).parent().prev().find("span").html();				//当前信息的值

	var inputV = '<input id="mobilePhone" class="input_text mobile_phone" type="text" onkeyup="onlyWriteNum(this);" onafterpaste="onlyWriteNum(this);"/>';
	$(obj).parent().prev().html(inputV);				//显示input标签
	$("#mobilePhone").val(oldValue);					//原来值赋给当前对象值
		
	var ownA ='<a onclick="editMobilePhone(this);" class="cancelEdit">修改</a>';
	var editA ='<a onclick="sureMobilePhone(this);" id="sureMobilePhone">确定</a><a onclick="cancelMobilePhone(this,'+oldValue+');" class="cancelEdit">取消</a>';
	$(obj).parent().html(editA);					//显示确定和取消按钮
	
	
	
	}
	
//取消还原原来值
function cancelMobilePhone(obj,oldValue){
	
	var ownA ='<a onclick="editMobilePhone(this);" id="editMobilePhone">修改</a>';
	var editA ='<a onclick="sureMobilePhone(this);" id="sureMobilePhone">确定</a><a onclick="cancelMobilePhone(this,'+oldValue+');" class="cancelEdit">取消</a>';
	$(obj).parent().prev().html('<span>'+oldValue+'</span>');				//显示span标签
	
	$(obj).parent().html(ownA);					//还原按钮链接
	
	}	

//确定修改
function sureMobilePhone(obj){
	var ownA ='<a onclick="editMobilePhone(this);" id="editMobilePhone">修改</a>';
	var phoneResult = verifyMobilePhone();
	if(phoneResult == true){
		var newPhone = $(obj).parent().prev().find("input").val();
		$.ajax({
		      type:"Post",
			  url: "configurajson_modifyphonevalidatesuc.do",
			  data:"newmobile="+newPhone,
			  async:false,
			  success : function(data) {
	          var statu=data.state;
	          if(statu==0){
	        	  alert("此号码已被注册,输入其他号码");
	          }else{
	        	  $.ajax({
	        	      type:"Post",
	        		  url: "configurajson_updatephonesuc.do",
	        		  data:"newmobile="+newPhone,
	        		  async:false,
	        		  success : function(data) {
	                  var statu=data.state;
	                  $(obj).parent().prev().html('<span>'+newPhone+'</span>');				//显示span标签
		      		  $(obj).parent().html(ownA);	
	        		  }
	        	  });
	          }
			  }
		  });
		}
	}

//手机号验证
function verifyMobilePhone(){
	
	var phone = $("#mobilePhone").val();
    if(phone == "" || phone == null){ 
    alert("手机号码不能为空"); 
    return false; 
	
   } 

   if(!phone.match(/^1[3|4|5|8][0-9]\d{4,8}$/)||phone.length!=11){ 
   	alert("手机号码格式不正确"); 
    return false; 
   } 
   return true; 
}


//只可输入数字
function onlyWriteNum(obj){
	if(obj.value.length==1){
		obj.value=obj.value.replace(/[^1-9]/g,'');
		}
	else{
		obj.value=obj.value.replace(/\D/g,'');
		}
}
function editObj(obj,inputObj){
	var oldValuea = $(obj).parent().prev().find("span").html();				//当前信息的值
	var oldValue = "'" + oldValuea  + "'";
	
	var inputV = '<input id='+inputObj+' class="input_text mobile_phone" type="text"/>';
	$(obj).parent().prev().html(inputV);				//显示input标签
	$("#"+inputObj).val(oldValuea);					//原来值赋给当前对象值
		
	var ownA ='<a onclick="editObj(this);">修改</a>';
	var editA ='<a onclick="sureObj(this);">确定</a><a onclick="cancelObj(this,'+oldValue+');" class="cancelEdit">取消</a>';
	
	$(obj).parent().html(editA);					//显示确定和取消按钮
	
	}
function editObjduty(obj,inputObj){
	var oldValuea = $(obj).parent().prev().find("span").html();				//当前信息的值
	var oldValue = "'" + oldValuea  + "'";
	
	var inputV = '<input id='+inputObj+' class="input_text mobile_phone" type="text"/>';
	$(obj).parent().prev().html(inputV);				//显示input标签
	$("#"+inputObj).val(oldValuea);					//原来值赋给当前对象值
		
	var ownA ='<a onclick="editObjduty(this);">修改</a>';
	var editA ='<a onclick="suredutyObj(this);">确定</a><a onclick="cancelObj(this,'+oldValue+');" class="cancelEdit">取消</a>';
	
	$(obj).parent().html(editA);					//显示确定和取消按钮
	
	}


function editObj(obj,inputObj){
	var oldValuea = $(obj).parent().prev().find("span").html();				//当前信息的值
	var oldValue = "'" + oldValuea  + "'";
	
	var inputV = '<input id='+inputObj+' class="input_text mobile_phone" type="text"/>';
	$(obj).parent().prev().html(inputV);				//显示input标签
	$("#"+inputObj).val(oldValuea);					//原来值赋给当前对象值
		
	var ownA ='<a onclick="editObj(this);">修改</a>';
	var editA ='<a onclick="sureObj(this);">确定</a><a onclick="cancelObj(this,'+oldValue+');" class="cancelEdit">取消</a>';
	
	$(obj).parent().html(editA);					//显示确定和取消按钮
	
	}
function editObjtel(obj,inputObj){
	var oldValuea = $(obj).parent().prev().find("span").html();				//当前信息的值
	var oldValue = "'" + oldValuea  + "'";
	
	var inputV = '<input id='+inputObj+' class="input_text mobile_phone" type="text"/>';
	$(obj).parent().prev().html(inputV);				//显示input标签
	$("#"+inputObj).val(oldValuea);					//原来值赋给当前对象值
		
	var ownA ='<a onclick="editObjtel(this);">修改</a>';
	var editA ='<a onclick="suretelObj(this);">确定</a><a onclick="cancelObj(this,'+oldValue+');" class="cancelEdit">取消</a>';
	
	$(obj).parent().html(editA);					//显示确定和取消按钮
	
	}
function editObjqq(obj,inputObj){
	var oldValuea = $(obj).parent().prev().find("span").html();				//当前信息的值
	var oldValue = "'" + oldValuea  + "'";
	
	var inputV = '<input id='+inputObj+' class="input_text mobile_phone" type="text"/>';
	$(obj).parent().prev().html(inputV);				//显示input标签
	$("#"+inputObj).val(oldValuea);					//原来值赋给当前对象值
		
	var ownA ='<a onclick="editObjqq(this);">修改</a>';
	var editA ='<a onclick="sureqqObj(this);">确定</a><a onclick="cancelObj(this,'+oldValue+');" class="cancelEdit">取消</a>';
	
	$(obj).parent().html(editA);					//显示确定和取消按钮
	
	}
function editObjcompanyAddr(obj,inputObj){
	var oldValuea = $(obj).parent().prev().find("span").html();				//当前信息的值
	var oldValue = "'" + oldValuea  + "'";
	
	var inputV = '<input id='+inputObj+' class="input_text mobile_phone" type="text"/>';
	$(obj).parent().prev().html(inputV);				//显示input标签
	$("#"+inputObj).val(oldValuea);					//原来值赋给当前对象值
		
	var ownA ='<a onclick="editObjcompanyAddr(this);">修改</a>';
	var editA ='<a onclick="surecompanyAddrObj(this);">确定</a><a onclick="cancelObj(this,'+oldValue+');" class="cancelEdit">取消</a>';
	
	$(obj).parent().html(editA);					//显示确定和取消按钮
	
	}
function editaddrObj(obj,inputObj){
	var oldValuea = $(obj).parent().prev().find("span").html();				//当前信息的值
	var oldValue = "'" + oldValuea  + "'";
	
	var inputV = '<input id='+inputObj+' class="input_text mobile_phone" type="text"/>';
	$(obj).parent().prev().html(inputV);				//显示input标签
	$("#"+inputObj).val(oldValuea);					//原来值赋给当前对象值
		
	var ownA ='<a onclick="editaddrObj(this);">修改</a>';
	var editA ='<a onclick="sureaddrObj(this);">确定</a><a onclick="cancelObj(this,'+oldValue+');" class="cancelEdit">取消</a>';
	
	$(obj).parent().html(editA);					//显示确定和取消按钮
}
function editbusinessScopeObj(obj,inputObj){
	var oldValuea = $(obj).parent().prev().find("span").html();				//当前信息的值
	var oldValue = "'" + oldValuea  + "'";
	
	var inputV = '<input id='+inputObj+' class="input_text mobile_phone" type="text"/>';
	$(obj).parent().prev().html(inputV);				//显示input标签
	$("#"+inputObj).val(oldValuea);					//原来值赋给当前对象值
		
	var ownA ='<a onclick="editbusinessScopeObj(this);">修改</a>';
	var editA ='<a onclick="surebusinessScopeObj(this);">确定</a><a onclick="cancelObj(this,'+oldValue+');" class="cancelEdit">取消</a>';
	
	$(obj).parent().html(editA);					//显示确定和取消按钮
}
//取消还原原来值
function cancelObj(obj,oldValue){
	var ownA ='<a onclick="editObj(this);">修改</a>';
	$(obj).parent().prev().html('<span>'+oldValue+'</span>');				//显示span标签
	
	$(obj).parent().html(ownA);					//还原按钮链接
	
	}	

//确定修改
function sureObj(obj){
		var ownA ='<a onclick="editObj(this);">修改</a>';		
		var newObj = $(obj).parent().prev().find("input").val();
		$.ajax({
  	      type:"Post",
  		  url: "configurajson_modifyaddr.do",
  		  data:"residence="+newObj,
  		  async:false,
  		  success : function(data) {
            var statu=data.state;
            $(obj).parent().prev().html('<span>'+newObj+'</span>');							//显示span标签
    		$(obj).parent().html(ownA);	
  		  }
  	    });
	}

function sureaddrObj(obj){
var ownA ='<a onclick="editObjduty(this);">修改</a>';		
	
	var newObj = $(obj).parent().prev().find("input").val();
	$.ajax({
	    type:"Post",
		  url: "configurajson_modifycompanyaddr.do",
		  data:"companyAddr="+newObj,
		  async:false,
		  success : function(data) {
	      var statu=data.state;
          $(obj).parent().prev().html('<span>'+newObj+'</span>');							//显示span标签
		  $(obj).parent().html(ownA);	
		  }
	  });
}

function suredutyObj(obj){
	var ownA ='<a onclick="editObjduty(this);">修改</a>';		
	
	var newObj = $(obj).parent().prev().find("input").val();
	$.ajax({
	    type:"Post",
		  url: "configurajson_modifyduty.do",
		  data:"markerduty="+newObj,
		  async:false,
		  success : function(data) {
	      var statu=data.state;
          $(obj).parent().prev().html('<span>'+newObj+'</span>');							//显示span标签
		  $(obj).parent().html(ownA);	
		  }
	  });
}

function sureqqObj(obj){
	var ownA ='<a onclick="editObj(this);">修改</a>';		
	
		var newObj = $(obj).parent().prev().find("input").val();
		$.ajax({
  	      type:"Post",
  		  url: "configurajson_modifyqq.do",
  		  data:"qq="+newObj,
  		  async:false,
  		  success : function(data) {
            var statu=data.state;
            $(obj).parent().prev().html('<span>'+newObj+'</span>');							//显示span标签
    		$(obj).parent().html(ownA);	
  		  }
  	    });
	}
function surecompanyAddrObj(obj){
	var ownA ='<a onclick="editObj(this);">修改</a>';		
	
	var newObj = $(obj).parent().prev().find("input").val();
	$.ajax({
	      type:"Post",
		  url: "configurajson_modifycompanyAddr.do",
		  data:"companyAddr="+newObj,
		  async:false,
		  success : function(data) {
        var statu=data.state;
        $(obj).parent().prev().html('<span>'+newObj+'</span>');							//显示span标签
		$(obj).parent().html(ownA);	
		  }
	    });
}
function surebusinessScopeObj(obj){
	var ownA ='<a onclick="editObj(this);">修改</a>';		
	
	var newObj = $(obj).parent().prev().find("input").val();
	$.ajax({
	      type:"Post",
		  url: "configurajson_modifybusinessScope.do",
		  data:"businessScope="+newObj,
		  async:false,
		  success : function(data) {
        var statu=data.state;
        $(obj).parent().prev().html('<span>'+newObj+'</span>');							//显示span标签
		$(obj).parent().html(ownA);	
		  }
	    });
}
function suretelObj(obj){
	var ownA ='<a onclick="editObj(this);">修改</a>';		
	
		var newObj = $(obj).parent().prev().find("input").val();
		$.ajax({
  	      type:"Post",
  		  url: "configurajson_modifytel.do",
  		  data:"worktel="+newObj,
  		  async:false,
  		  success : function(data) {
            var statu=data.state;
            $(obj).parent().prev().html('<span>'+newObj+'</span>');							//显示span标签
    		$(obj).parent().html(ownA);	
  		  }
  	    });
	}
function showImg(obj){
	
	var img = '<img src="'+obj+'"  id="imgIdentV" /><a onclick="cloosePopBoxI();"></a>';
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
