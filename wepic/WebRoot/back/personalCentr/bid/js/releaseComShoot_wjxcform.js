   function validateBidForm(){
    var name=$("#namebidFor").val();
    if(name==null||$.trim(name)==""||name.length>20){
    	$("#namebidFor").css({"border":"1px solid #F09494"});
          return false;
    	}
    
    var bidtag=$("#bidtag").val();
    if(bidtag==null||$.trim(bidtag)==""){
    	$("#divdropDownViewPartType").parent().css({"border":"1px solid #F09494"});
          return false;
    	}
    
    var textareapart=$("#textareapart").val();
    if(textareapart==null||$.trim(textareapart)==""){
    	$("#textareapart").css({"border":"1px solid #F09494"});
          return false;
    	}
    
    var contextHtml=$("#contextHtml").val();
    if(contextHtml==null||$.trim(contextHtml)==""){
    	$("#contextHtml").css({"border":"1px solid #F09494"});
          return false;
    	}
    // 时间
    var txtBeginDate=$("#txtBeginDate").val();
    if(txtBeginDate==null||$.trim(txtBeginDate)==""){
    	$("#txtBeginDate").css({"border":"1px solid #F09494"});
          return false;
    	}
    
    var divdropDownViewStartHour=$("#divdropDownViewStartHour").html();
    
    if(divdropDownViewStartHour==null||$.trim(divdropDownViewStartHour)==""){
    	$("#divdropDownViewStartHour").parents(".divdropDown").css({"border":"1px solid #F09494"});
          return false;
    	}
    var workStartTimefen=$("#workStartTimefen").val();
    if(workStartTimefen==null||$.trim(workStartTimefen)==""){
    	$("#workStartTimefen").css({"border":"1px solid #F09494"});
          return false;
    	}
    //拍摄时间 workEndTime
    var txtEndDate=$("#txtEndDate").val();
    if(txtEndDate==null||$.trim(txtEndDate)==""){
    	$("#txtEndDate").css({"border":"1px solid #F09494"});
          return false;
    	}
    
    var divdropDownViewStartHour2=$("#divdropDownViewStartHour2").html();
    if(divdropDownViewStartHour2==null||$.trim(divdropDownViewStartHour2)==""){
    	$("#divdropDownViewStartHour2").parents(".divdropDown").css({"border":"1px solid #F09494"});
          return false;
    	}
    var workEndTimefen=$("#workEndTimefen").val();
    if(workEndTimefen==null||$.trim(workEndTimefen)==""){
    	$("#workEndTimefen").css({"border":"1px solid #F09494"});
          return false;
    	}
    
    //应约截至时间
    var txtEndDate2=$("#txtEndDate2").val();
    if(txtEndDate2==null||$.trim(txtEndDate2)==""){
    	$("#txtEndDate2").css({"border":"1px solid #F09494"});
          return false;
    	}
    
    var divdropDownViewStartHour3=$("#divdropDownViewStartHour3").html();
    if(divdropDownViewStartHour3==null||$.trim(divdropDownViewStartHour3)==""){
    	$("#divdropDownViewStartHour3").parents(".divdropDown").css({"border":"1px solid #F09494"});
          return false;
    	}
    var periodfen=$("#periodfen").val();
    if(periodfen==null||$.trim(periodfen)==""){
    	$("#periodfen").css({"border":"1px solid #F09494"});
          return false;
    	}
    
    
    
    
      if(txtEndDate2>=txtBeginDate){
    	  $("#txtBeginDate").css({"border":"1px solid #F09494"});
          return false;
    }
      
      if(txtBeginDate>=txtEndDate){
    	  $("#txtEndDate").css({"border":"1px solid #F09494"});
          return false;
    }
      
      
    
    var divdropDownViewPartEnv=$("#divdropDownViewPartEnv").html();
    if(divdropDownViewPartEnv==null||$.trim(divdropDownViewPartEnv)==""){
    	$("#divdropDownViewPartEnv").parents(".divdropDown").css({"border":"1px solid #F09494"});
          return false;
    	}  
      var sumProductPhoto=$("input[name=sumProductPhoto]").val();
      if(sumProductPhoto==null||$.trim(sumProductPhoto)==""||isNaN(sumProductPhoto)){
    	$("input[name=sumProductPhoto]").css({"border":"1px solid #F09494"});
          return false;
    	}
   
    	var object=$('input[name="unitpriceType"]:checked')
    	 var sth=object.val();
      if(sth==2){
    	  var textObj=$(object).parent().next().next().find("input");
    	  var value=$(textObj).val();
    	   // $(textObj).attr("name","unitprice");
    	    if(value==null||value==""||value==0){
     		   $(textObj).css({"border":"1px solid #F09494"});
     		   
     		   return false;
     	   }
    	  
      }
      else if(sth==3){
    	    var textObj=$(object).parent().next().next().find("input");
    	    var value=$(textObj).val();
    	  //  $(textObj).attr("name","totalMoney");
    	    //$(textObj).css({"border":"1px solid #F09494"});
    	    if(value==null||value==""||value==0){
     		   $(textObj).css({"border":"1px solid #F09494"});
     		   
     		   return false;
     	   }
      }
    
      
      
      
      
      
      
      
      $("#bidaddForm").submit();
      
      
 
     } 
   
   $(function(){
	   
	   checkOnclick();
	   
	   
   });
   
   function checkOnclick(){
	   $("input[type='radio']").each(function (){
		  $(this).change(function(){
			 var parent= $(this).parents(".tablePartOffer");
			 $(parent).find("input[type='text']").each(function(){
				 $(this).attr("name","");
				 $(this).attr("readonly","readonly");
				 $(this).val("");
				 clear(this);
			 }); 
			 var value= $(this).val();
			 $(this).parent().next().next().find("input").attr("name","unitpriceProduct");
			 $(this).parent().next().next().find("input").removeAttr("readonly");
			 if(value==3){
				 $(this).parent().next().next().find("input").attr("name","totalMoney");
				 $(this).parent().next().next().find("input").removeAttr("readonly");
			 }
			
		  }) ;
		   
		   
	   });
   }
function CounttotalMoney(obj){
	var value=$(obj).parent().prev().prev().find("input").val();
	if(value==3){
		var sumProductPhoto=$("input[name=sumProductPhoto]").val();
		var unitMoney=$(obj).val()/sumProductPhoto;
		 unitMoney = unitMoney.toFixed(2) 
	    var html='<span>每张正片：</span><span class="y">'+unitMoney+'</span><span>元</span>';
		$(obj).parent().next().html(html);
	}
	else if(value==2){
		var sumProductPhoto=$("input[name=sumProductPhoto]").val();
		var unitMoney=$(obj).val()*sumProductPhoto;
	    var html='<span>每件产品：</span><span class="y">'+unitMoney+'</span><span>元</span>';
		$(obj).parent().next().html(html);
	}
	
}

function clear(obj){
	var value=$(obj).parent().prev().prev().find("input").val();
	//alert(value);
	if(value==3){
		
	    var html='<span>每张正片：</span><span class="y">0</span><span>元</span>';
		$(obj).parent().next().html(html);
	}
	else if(value==2){
		
	    var html='<span>每件产品：</span><span class="y">0</span><span>元</span>';
	    $(obj).parent().next().html(html);
	}
	
}
   
function checkedRadio(obj){
	 var parent= $(obj).parents(".tablePartOffer");
	 $(parent).find("input[type='text']").each(function(){
		 $(this).attr("name","");
		 $(this).attr("readonly","readonly");
		 $(this).val("");
		 clear(this);
	 }); 
	 var value=$(obj).parent().prev().prev().find("input").val();
	 $(obj).attr("name","unitpriceProduct");
	 $(obj).removeAttr("readonly");
	 if(value==3){
		 $(obj).attr("name","totalMoney");
		 $(obj).removeAttr("readonly");
	 }
	 
	$(obj).parent().prev().prev().find("input").attr("checked","checked");
	//$
	
	
}