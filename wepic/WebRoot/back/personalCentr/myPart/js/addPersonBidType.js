function addperson(){
  
	$.ajax({
	      type:"Post",
		  url: "bidCatAction_addpersonCat.do",
		  data:"name="+$("#addCustomInput").val()+"&pId="+$("input[name='type']").val(),		
		  success : function(data) {
		   var backmsg=data.backMsg;
		   if(backmsg=="ok"){
			 alert("添加成功");
			 window.location.reload();
			 addCustom('addCustomInput','chooseProductType');
		   }
		   else if(backmsg=="error"){
			   alert("添加失败");  
		   }
		   else if(backmsg=="login"){
			   alert("登录信息已过期,请重新登录");  
		   }
		
		 
	      }
	});
	
	
}

function deletePersonCat(obj,id){
	if(confirm("确定删除吗?")){
	
	$.ajax({
	      type:"Post",
		  url: "bidCatAction_deletepersonCat.do",
		  data:"id="+id,	
		  success : function(data) {
		   var backmsg=data.backMsg;
		   if(backmsg=="ok"){
			// alert("删除成功");
			 deleteLiFile(obj);
			 	window.location.reload();
		   }
		   else if(backmsg=="error"){
			   alert("删除失败");  
		   }
		   else if(backmsg=="login"){
			   alert("登录信息已过期,请重新登录");  
		   }
		
		 
	      }
	});
	
	}
	
	
}

function addpersonStyle(){
	  
	$.ajax({
	      type:"Post",
		  url: "bidCatAction_addpersonCatStyle.do",
		  data:"icon="+$("#addCustomInputStyle").val()+"&pId="+$("input[name='type']").val(),		
		  success : function(data) {
		   var backmsg=data.backMsg;
		   if(backmsg=="ok"){
			 alert("添加成功");
			// window.location.reload();
			 addCustom('addCustomInputStyle','chooseModelStyle');
		   }
		   else if(backmsg=="error"){
			   alert("添加失败");  
		   }
		   else if(backmsg=="login"){
			   alert("登录信息已过期,请重新登录");  
		   }
		
		 
	      }
	});
	
	
}

function deletePersonCatStyle(obj,id){
	if(confirm("确定删除吗?")){
	
	$.ajax({
	      type:"Post",
		  url: "bidCatAction_deletepersonCatStyle.do",
		  data:"id="+id,	
		  success : function(data) {
		   var backmsg=data.backMsg;
		   if(backmsg=="ok"){
			    alert("删除成功");
			    deleteLiFile(obj);
			 	window.location.reload();
		   }
		   else if(backmsg=="error"){
			   alert("删除失败");  
		   }
		   else if(backmsg=="login"){
			   alert("登录信息已过期,请重新登录");  
		   }
		
		 
	      }
	});
	
	}
	
	
}

