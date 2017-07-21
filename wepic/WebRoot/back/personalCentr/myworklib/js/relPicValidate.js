function valiateForm(){
	
	
	if($("#piclogo").val()==1){
		
		alert("请先上传预览图");
		
		return;
	}
	
	
	
	
	$("#formrelwork").find("em").each(function(){
		//alert($(this).attr("name"))
		var child=$(this).first();
		//alert($(this).children().html());
		$(this).children().removeAttr("style"); 
		// alert($(ss).html(ddddsss));
	});
	
	var title=$("#texttitleinp").val();
	if(title==null||$.trim(title)==""){
		var obj=$("#texttitleinp").parent().html();
		var saval=$("#texttitleinp").parent().attr("name");
		if(saval!="error"){
		$("#texttitleinp").parent().html("<em name='error'>"+obj+"</em>")
		}
		$("#texttitleinp").css({"border":"1px solid red"});
		$("#titleprompt").find("div").html("<div class='divprompt'><span>标题不能为空</span></div>");
		getpos($("#texttitleinp"));
		return;
		
	}
	
	
	
	var publishwish=$("input[name='publishwish']:checked").val();
	//alert(publishwish);
	if(publishwish==2){
		verifyForm();
	}
	
	var divAddEnTagpho=$("#divAddEnTagpho").find("div");
	//alert(divAddEnTagpho.length<=0);
	if(divAddEnTagpho==null||divAddEnTagpho.length<=0){
		var saval=$("#divAddEnTagpho").parent().parent().parent().attr("name");
		//alert(saval+"sssssqqs");
		if(saval!="error"){
		$("#divAddEnTagpho").parent().parent().wrap("<em name='error'></em>");
		}
		$("#divAddEnTagpho").parent().parent().css({"border":"1px solid red"});		
		getpos($("#divAddEnTagpho"));
		return;
	}
	
	
	
	var divAddPersonTag=$("#divAddPersonTag").find("div");
	//alert(divAddEnTagpho.length<=0);
	if(divAddPersonTag==null||divAddPersonTag.length<=0){
		var saval=$("#divAddPersonTag").parent().parent().parent().attr("name");
		if(saval!="error"){
		$("#divAddPersonTag").parent().parent().wrap("<em name='error'></em>");
		}
		$("#divAddPersonTag").parent().parent().css({"border":"1px solid red"});		
		getpos($("#divAddPersonTag"));
		return;
	}
	var copyrightType=$("input[name='copyrightType']:checked");
	//alert(copyrightType.length);
	if(copyrightType.length<=0){
		var priceInfo=$("#divnoSell").find(".priceInfo");
		var saval=$(priceInfo).parent().attr("name");
		if(saval!="error"){
		$(priceInfo).wrap("<em name='error'></em>");
		}
		$(priceInfo).css({"border":"1px solid red"});		
		getpos($(priceInfo));
		return;
	}
	$(copyrightType).each(function(){
		var valu=$(this).val();
		//alert("sssss"+valu);
		if(valu==1){
			var inpcheckuesr=$("#inpcheckuesr").val();
			if(inpcheckuesr==null||$.trim(inpcheckuesr)==""){
			//	alert(isNaN(inpcheckuesr))
				
				var saval=$("#inpcheckuesr").parent().attr("name");
				if(saval!="error"){
				$("#inpcheckuesr").wrap("<em name='error'></em>");
				}
				$("#inpcheckuesr").css({"border":"1px solid red"});
				getpos(	$("#inpcheckuesr"));
				return;
				
			}else if(isNaN(inpcheckuesr)){
				var saval=$("#inpcheckuesr").parent().attr("name");
				if(saval!="error"){
				$("#inpcheckuesr").wrap("<em name='error'></em>");
				}
				$("#inpcheckuesr").css({"border":"1px solid red"});
				getpos(	$("#inpcheckuesr"));
				return;
				
				
			}
			
			
			
		}
		
		if(valu==2){
			var inpcheckuesr2=$("#inpcheckuesr2").val();
			if(inpcheckuesr2==null||$.trim(inpcheckuesr2)==""||isNaN(inpcheckuesr2)){
				
					var saval=$("#inpcheckuesr2").parent().attr("name");
					if(saval!="error"){
				$("#inpcheckuesr2").wrap("<em name='error'></em>");
					}
				$("#inpcheckuesr2").css({"border":"1px solid red"});
				getpos($("#inpcheckuesr2"));
				return;
				
			}
			
			
			
		}
		
	});
	
	var banquan=$("input[name='banquan']:checked").val();
	if(banquan!='noCopyright'){
		$("input[name='portraRight']checked").each(function(){
		var	portraRight=$(this).val();
		if(portraRight==1){
			var portraitprotocol=$("#portraitprotocol").val();
			if(portraitprotocol==null||$.trim(portraitprotocol)==""){
				var saval=$("#divbanquan2").parent().attr("name");
				if(saval!="error"){
				$("#divbanquan2").wrap("<em name='error'></em>");
				}
				$("#divbanquan2").css({"border":"1px solid red"});
				getpos($("#divbanquan2"));
				return;
			}
			
		}
		if(portraRight==2){
			var productsprotocol=$("#productsprotocol").val();
			if(productsprotocol==null||$.trim(productsprotocol)==""){
				var saval=$("#divbanquan2").parent().attr("name");
				if(saval!="error"){
				$("#divbanquan2").wrap("<em name='error'></em>");
				}
				$("#divbanquan2").css({"border":"1px solid red"});
				getpos($("#divbanquan2"));
				return;
			}
			
		}
			
			
			
		});
		
		
		
		
	   }
	verifyForm();
	
	
	
	
	
	
	
}