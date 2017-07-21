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
    
    var divdropDownViewModelDemand=$("#divdropDownViewModelDemand").html();
    if(divdropDownViewModelDemand==null||$.trim(divdropDownViewModelDemand)==""){
    	$("#divdropDownViewModelDemand").parents(".divdropDown").css({"border":"1px solid #F09494"});
          return false;
    	}
    
      var sumProductPhoto=$("input[name=sumProductPhoto]").val();
      if(sumProductPhoto==null||$.trim(sumProductPhoto)==""||isNaN(sumProductPhoto)){
    	$("input[name=sumProductPhoto]").css({"border":"1px solid #F09494"});
          return false;
      }
      
      var sumProductPhoto=$("input[name=totalMoney]").val();
      if(sumProductPhoto==null||$.trim(sumProductPhoto)==""||isNaN(sumProductPhoto)){
    	$("input[name=totalMoney]").css({"border":"1px solid #F09494"});
          return false;
      }
      
      
      $("#bidaddForm").submit();
      
      
 
     } 
   
  