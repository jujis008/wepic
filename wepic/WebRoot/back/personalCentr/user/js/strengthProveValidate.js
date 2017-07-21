function validatedaibiaoform(){
	var name=$("#divMyRePop").find(".inputworkname").val();
	var entry=$("#divMyRePop").find("textarea").val()
	var type=$("#divMyRePop").find("#selectWorkTypeValue").text();
	var time=$("#divMyRePop").find("#selectCreYearValue").text();
	var sum=$("#divMyRePop").find("#opusIds").val();
	if(name==null||$.trim(name)==""||name.length>30||name.length<5){
		$("#divMyRePop").find(".inputworkname").css({"border":"1px solid #F09494"});
		return false;
		
	}
	if(entry==null||$.trim(entry)==""){
		$("#divMyRePop").find("textarea").css({"border":"1px solid #F09494"});
		return false;
		
	}
	if(type==null||$.trim(type)==""||$.trim(type)=="请选择"){
		$("#divMyRePop").find("#viewBelowWorkType").css({"border":"1px solid #F09494"});
		return false;
		
	}
	if(time==null||$.trim(time)==""||$.trim(type)=="请选择"){
		$("#divMyRePop").find("#viewBelowCreYear").css({"border":"1px solid #F09494"});
		return false;
		
	}
	
	if(sum==null||$.trim(sum)==""){
		$("#divMyRePop").find("#divMyReWork").css({"border":"1px solid #F09494"});
		return false;
		
	}
	return true;
	
}



function validateddaibiaoproject(){
	var name=$("#divProjectPop").find(".inputworkname").val();
	var entry=$("#projectContext").find("textarea").val();
	var projectresponsibilities=$("#workIntroPersonALResblit").find("textarea").val()
	var entryAdress=$("#divProjectPop").find(".address").val();
	var sum=$("#divProjectPop").find("#opusIds").val();
	if(name==null||$.trim(name)==""||name.length>30||name.length<5){
		$("#divProjectPop").find(".inputworkname").css({"border":"1px solid #F09494"});
		return false;
		
	}
	if(entry==null||$.trim(entry)==""){
		$("#projectContext").find("textarea").css({"border":"1px solid #F09494"});
		return false;
		
	}
	if(projectresponsibilities==null||$.trim(projectresponsibilities)==""){
		$("#workIntroPersonALResblit").find("textarea").css({"border":"1px solid #F09494"});
		return false;
		
	}
	if(entryAdress==null||$.trim(entryAdress)==""){
		$("#divProjectPop").find(".address").css({"border":"1px solid #F09494"});
		return false;
		
	}
	
	if(sum==null||$.trim(sum)==""){
		$("#divProjectPop").find("#divReProject").css({"border":"1px solid #F09494"});
		return false;
	}
	var ids=["proYear","proMonth","proMonthnem","proYearney"];
	for(var i=0;i<ids.length;i++){
		var value=$("#"+ids[i]).val();
		if(value==null||$.trim(value)==""||isNaN(value)){
			
			$("#divProjectPop").find("#"+ids[i]).css({"border":"1px solid #F09494"});
			return false;
		}
		
	}
	return true;
	
}


function validatehonorFormIds(){
	var name=$("#divHonorPop").find(".inputworkname").val();
	var entry=$("#divHonorPop").find("textarea").val();
	var inputawardsibputry=$("#divHonorPop").find("#inputawardsibputry").val();
	var inputissueibputry=$("#divHonorPop").find("#inputissueibputry").val();
	var inputtimeibputry=$("#divHonorPop").find("#inputtimeibputry").val();
	var inputaddibputry=$("#divHonorPop").find("#inputaddibputry").val();
	var sum=$("#divHonorPop").find("#honorpicId").val();
	if(name==null||$.trim(name)==""||name.length>30||name.length<5){
		$("#divHonorPop").find(".inputworkname").css({"border":"1px solid #F09494"});
		return false;
		
	}
	if(entry==null||$.trim(entry)==""){
		$("#divHonorPop").find("textarea").css({"border":"1px solid #F09494"});
		return false;
		
	}
	if(inputawardsibputry==null||$.trim(inputawardsibputry)==""){
		$("#divHonorPop").find("#inputawardsibputry").css({"border":"1px solid #F09494"});
		return false;
		
	}
	if(inputissueibputry==null||$.trim(inputissueibputry)==""){
		$("#divHonorPop").find("#inputissueibputry").css({"border":"1px solid #F09494"});
		return false;
		
	}
	
	if(inputtimeibputry==null||$.trim(inputtimeibputry)==""){
		$("#divHonorPop").find("#inputtimeibputry").css({"border":"1px solid #F09494"});
		return false;
		
	}
	
	if(inputaddibputry==null||$.trim(inputaddibputry)==""){
		$("#divHonorPop").find("#inputaddibputry").css({"border":"1px solid #F09494"});
		return false;
		
	}
	if(sum==null||$.trim(sum)==""){
		$("#divHonorPop").find("#divMyReHonor").css({"border":"1px solid #F09494"});
		return false;
	}
	
	return true;
	
}



