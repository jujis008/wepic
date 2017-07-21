   function validateBidForm(){
    var name=$("#namebidFor").val();
    if(name==null||$.trim(name)==""||name.length>20){
    	getpos($("#namebidFor"));
    	$("#namebidFor").css({"border":"1px solid #F09494"});
          return false;
    	}
    
    var bidtag=$("#bidtag").val();
    if(bidtag==null||$.trim(bidtag)==""||$.trim(bidtag)=="选择招募人才"){
    	getpos($("#divdropDownViewInviteType"));
    	$("#divdropDownViewInviteType").parent().css({"border":"1px solid #F09494"});
          return false;
    	}
    
    var textareapart=$("#textareapart").val();
    if(textareapart==null||$.trim(textareapart)==""){
    	getpos($("#textareapart"));
    	$("#textareapart").css({"border":"1px solid #F09494"});
          return false;
    	}
    
    var contextHtml=$("#contextHtml").val();
    if(contextHtml==null||$.trim(contextHtml)==""){
    	getpos($("#contextHtml"));
    	$("#contextHtml").css({"border":"1px solid #F09494"});
          return false;
    	}
    // 时间
    var txtBeginDate=$("#txtBeginDate").val();
    if(txtBeginDate==null||$.trim(txtBeginDate)==""){
    	getpos($("#txtBeginDate"));
    	$("#txtBeginDate").css({"border":"1px solid #F09494"});
          return false;
    	}
    
    var divdropDownViewStartHour=$("#divdropDownViewStartHour").html();
    
    if(divdropDownViewStartHour==null||$.trim(divdropDownViewStartHour)==""){
    	getpos($("#divdropDownViewStartHour"));
    	$("#divdropDownViewStartHour").parents(".divdropDown").css({"border":"1px solid #F09494"});
          return false;
    	}
    var workStartTimefen=$("#workStartTimefen").val();
    if(workStartTimefen==null||$.trim(workStartTimefen)==""){
    	$("#workStartTimefen").css({"border":"1px solid #F09494"});
    	getpos($("#workStartTimefen"));
          return false;
    	}
    //拍摄时间 workEndTime
    var txtEndDate=$("#txtEndDate").val();
    if(txtEndDate==null||$.trim(txtEndDate)==""){
    	getpos($("#txtEndDate"));
    	$("#txtEndDate").css({"border":"1px solid #F09494"});
          return false;
    	}
    
    var divdropDownViewStartHour2=$("#divdropDownViewStartHour2").html();
    if(divdropDownViewStartHour2==null||$.trim(divdropDownViewStartHour2)==""){
    	getpos($("#divdropDownViewStartHour2"));
    	$("#divdropDownViewStartHour2").parents(".divdropDown").css({"border":"1px solid #F09494"});
          return false;
    	}
    var workEndTimefen=$("#workEndTimefen").val();
    if(workEndTimefen==null||$.trim(workEndTimefen)==""){
    	getpos($("#workEndTimefen"));
    	$("#workEndTimefen").css({"border":"1px solid #F09494"});
          return false;
    	}
    
    //应约截至时间
    var txtEndDate2=$("#txtEndDate2").val();
    if(txtEndDate2==null||$.trim(txtEndDate2)==""){
    	getpos($("#txtEndDate2"));
    	$("#txtEndDate2").css({"border":"1px solid #F09494"});
          return false;
    	}
    
    var divdropDownViewStartHour3=$("#divdropDownViewStartHour3").html();
    if(divdropDownViewStartHour3==null||$.trim(divdropDownViewStartHour3)==""){
    	getpos($("#divdropDownViewStartHour3"));
    	$("#divdropDownViewStartHour3").parents(".divdropDown").css({"border":"1px solid #F09494"});
          return false;
    	}
    var periodfen=$("#periodfen").val();
    if(periodfen==null||$.trim(periodfen)==""){
    	getpos($("#periodfen"));
    	$("#periodfen").css({"border":"1px solid #F09494"});
          return false;
    	}
    
    
    
    
      if(txtEndDate2>=txtBeginDate){
    	  getpos($("#txtBeginDate"));
    	  $("#txtBeginDate").css({"border":"1px solid #F09494"});
          return false;
    }
      
      if(txtBeginDate>=txtEndDate){
    	  getpos($("#txtEndDate"));
    	  $("#txtEndDate").css({"border":"1px solid #F09494"});
          return false;
    }
      
      
    
    var divdropDownViewPartEnv=$("#divdropDownViewPartEnv").html();
    if(divdropDownViewPartEnv==null||$.trim(divdropDownViewPartEnv)==""){
    	getpos($("#divdropDownViewPartEnv"));
    	$("#divdropDownViewPartEnv").parents(".divdropDown").css({"border":"1px solid #F09494"});
          return false;
    	}  
      var sumProductPhoto=$("input[name=recruitNum]").val();
      if(sumProductPhoto==null||$.trim(sumProductPhoto)==""||isNaN(sumProductPhoto)){
    	  getpos($("input[name=recruitNum]"));
    	$("input[name=recruitNum]").css({"border":"1px solid #F09494"});
          return false;
    	}
   
    	var object=$('input[name="unitpriceType"]:checked');
    	 var sth=object.val();
      if(sth==2){
    	  var textObj=$(object).parent().next().next().find("input");
    	  var value=$(textObj).val();
    	   // $(textObj).attr("name","unitprice");
    	    if(value==null||value==""||value==0){
     		   $(textObj).css({"border":"1px solid #F09494"});
     		  getpos($(textObj));
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
     		  getpos($(textObj));
     		   return false;
     	   }
      }
    
      
      
      
      
      
      
      
      $("#bidaddForm").submit();
      
      
 
     } 
   
   
   
   function getpos(e){
	    var t=$(e).offset().top -100; 
	   
	  //  alert(t);
	    goErrorTopEx(t);
	} 

	/////////////////////////////////////////////////////////////错误跳转
	function goErrorTopEx(value){
		//要获取当前页面的滚动条纵坐标位置
	    function getScrollTop(){
			if(document.documentElement.scrollTop)
	        	{
				return document.documentElement.scrollTop;
				}
			else	
				{
				return document.body.scrollTop}
	        }
		
	    function setScrollTop(value){
			if(document.documentElement.scrollTop)
	        	{document.documentElement.scrollTop = value;}
			else	
				{document.body.scrollTop = value;}
	        }    
		
	        var goTop=setInterval(scrollMove,10);
	        function scrollMove(){
	                setScrollTop(getScrollTop()/1.1);
			        
	                if(getScrollTop()<value)
	                	clearInterval(goTop);
	            }
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
	var txtBeginDate=$("#txtBeginDate").val();
	var txtEndDate=$("#txtEndDate").val();
	var re = new RegExp("{-}", "g");
	var txtEndDate1=txtEndDate.replace(re,"/");
	//alert(txtEndDate1);
	var txtBeginDate1=txtBeginDate.replace(re,"/");
	
	 var cha = (Date.parse(txtEndDate1) - Date.parse(txtBeginDate1)) / 86400000;
	//alert(cha);
	if(value==3){
		var sumProductPhoto=$("input[name=recruitNum]").val();
		var unitMoney=$(obj).val()/sumProductPhoto/cha;
		 unitMoney = unitMoney.toFixed(2) 
	    var html='<span>每人每天：</span><span class="y">'+unitMoney+'</span><span>元</span>';
		$(obj).parent().next().html(html);
	}
	else if(value==2){
		var sumProductPhoto=$("input[name=recruitNum]").val();
		var unitMoney=$(obj).val()*sumProductPhoto*cha;
	    var html='<span>总计：</span><span class="y">'+unitMoney+'</span><span>元</span>';
		$(obj).parent().next().html(html);
	}
	
}

function clear(obj){
	var value=$(obj).parent().prev().prev().find("input").val();
	//alert(value);
	if(value==3){
		
	    var html='<span>每人每天：</span><span class="y">0</span><span>元</span>';
		$(obj).parent().next().html(html);
	}
	else if(value==2){
		
	    var html='<span>总计：</span><span class="y">0</span><span>元</span>';
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