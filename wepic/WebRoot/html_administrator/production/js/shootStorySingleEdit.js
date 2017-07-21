$(function(){
	
	liBarChangeStyle("mainbarCenter");   //主导航背景底边框
	
	
	changeHead("divChangeHead","divViewHead");
	
	achieveBelow("divdropDownCategory","divdropDownViewCategory")					/*获取下拉框值并隐藏	拍摄类别*/
	
	document.getElementById("formrelwork").reset();
	$("#inpcheckuesr").attr("disabled","disabled");
	$("#inpcheckuesr2").attr("disabled","disabled");
	
	backToPrevious();
});

function verifyForm(){
	promptInfo('texttitleinp','titleprompt',40);
	
	promptInfo('textareastorytt','textareaStory',400);
	
	cssyq("inpcheckuesr2","csbq");
	
	cssyq("inpcheckuesr","cssyq");
	
	lookfor("divAddEnTagpho","choosetypeCha","retag");
	
	lookfor2("divAddPersonTag","choosegjc");
	
	lookfor("divallDe","chooseconn","addcon-de");
	}
	
function lookfor(lookdiv,show,clname){
	var addoDiv=document.getElementById(lookdiv);
	
	var addDivCon=addoDiv.getElementsByTagName("div");
	
		var addObj = [];
		for(var i=0;i<addDivCon.length;i++){
			if(addDivCon[i].className == clname){
				addObj[addObj.length] = addDivCon[i];
				}
		}
		
		var length = addObj.length;
		if(length == 0){
			$("#"+show).show();
			}
		else{
			$("#"+show).hide();
			}
}

function lookfor2(lookdiv,show){
	var addoDiv=document.getElementById(lookdiv);
	
	var addDivCon=addoDiv.getElementsByTagName("div");
	
		var addObj = [];
		for(var i=0;i<addDivCon.length;i++){
			if(addDivCon[i].className == "retag" || addDivCon[i].className == "tag"){
				addObj[addObj.length] = addDivCon[i];
				}
		}
		
		var length = addObj.length;
		if(length == 0){
			$("#"+show).show();
			}
		else{
			$("#"+show).hide();
			}
}
	
function cssyq(view,show){
	if(!$("#"+view).attr("disabled")){
		var value = $("#"+view).val();
		if(value == "" || value == null){
			
			
			$("#"+show).show();
			}
		else{
		$("#"+show).hide();
			}
		}
	
	}
	
function addpromptInfo(promptInfo,addToDiv){
	option = "<div class='divprompt'><span>"+promptInfo+"</span></div>";
	$("#"+addToDiv).append(option);
	}	
 /*字节不超过20	*/
function getByteCount(str){
	return str.replace(/[^\x00-\xff]/g, "**").length;
	}
 
/*字节不超过20	*/


function changeuse(obj,view){
	var che = $(obj).attr("checked");
	
	$("#"+view).next().hide();
	
	if(che){
		$("#"+view).val("");
		$("#"+view).removeAttr("disabled");
		}
	else{
		$("#"+view).val("");
		$("#"+view).attr("disabled","disabled");
		
		}
	}
function closeOwnBox(obj){
	$("#greybackground").remove();
	$("#"+obj).hide();
	}



	
function delcon(obj){
	if (confirm("确认要删除？")) {
		$(obj).parent().remove();
	}
}


	
function addOwnBox(url){
	
	var urlc = "../../public/" + url;
	
	var option = "" ;
	
	option = "<div class='addcon-de'><a class='delcon' href='javascript:' onclick='delcon(this);' title='删除'></a><div class='head'><img src='" + urlc + "' /></div><div class='area'><textarea></textarea></div></div>";
	
	
	$("#divallDe").append(option);
	}
	
	

//打开裁切
function fucropHead(url){	
				
	openPopUpBox('cropHead');
	var urlc = "../../public/" + url;
	
	
	var frobj = window.frames['child2'].document.getElementById('imghead');
	
	$(frobj).attr("src",url);
	
	var frobjz = window.frames['child2'].document.getElementById('prebiewImg');
	$(frobjz).attr("src",url);
	
	}

//跟换头像
	
function changehh(url){					
	
	var urlc = "../../public/" + url;
	
	
	
	$("#divChangeHead").find("img").attr("src",urlc);
	
	}
	
function changeHead(div,viewDiv){
	$('#'+div).hover(
		function(){
			$('#'+viewDiv).stop().fadeTo('slow',1);
		},
		function(){
			$('#'+viewDiv).stop().fadeTo('slow',0);
		});
}

 /*字节不超过20	*/
function getByteCount(str){
	return str.replace(/[^\x00-\xff]/g, "**").length;
	}
	var value;
function doit(obj){
	if(getByteCount(obj.value)>20){
		obj.value=value;
	}
	value=obj.value
} 
/*字节不超过20	*/

/*增加自定义标签个人*/
function addProfTagPerson(value,addDiv){
	var option = "" ;
	var addvalue = $("#"+value).val();
	
	$("#"+value).val("");
	
	var addoDiv=document.getElementById(addDiv);
	
	var addDivCon=addoDiv.getElementsByTagName("div");
	
		var addObj = [];
		for(var i=0;i<addDivCon.length;i++){
			if(addDivCon[i].className == "tag"){
				addObj[addObj.length] = addDivCon[i];
				}
		}
		
		
			//判断新增字段是否已存在
	var allSpan = $(addoDiv).find("span") ;
		
		for(var i = 0; i<allSpan.length; i++){
			if($(allSpan[i]).html() != addvalue ){
				}
			else{
				alert("不好意思，该标签已存在！");
				return;
				}
		}
	if(addvalue == '' || addvalue == null){
		alert("不好意思，职业标签名不能为空！");
		}
	else if(addObj.length < 10){
		option = "<div class='tag'><span>"  + addvalue + "</span><a title='删除' onclick='deleteProModel(this);'></a></div>";
		}
	else{
		alert("不好意思，新增项目只可以有十个！");
		}
		
	/*input自定义推荐标签*/
			var tags=$("#hiddenUserTagsP").val();
			if(tags!=""){
				tags+=" "+addvalue;		//已经有值
				}
			else{
				tags=addvalue;			//赋第一个值
				}
			$("#hiddenUserTagsP").val(tags);
	
	/*input自定义推荐标签*/	
			
	$("#"+addDiv).append(option);
}
/*增加自定义标签个人*/



function addSubStory(){
	openPopUpBox('chooseWork');
	
	window.frames['child'].document.getElementById('hiddenv').value = "addSubStory";			//传值给 iframe text
	}

function changeHeadStory(opendiv){
	openPopUpBox('chooseWork');
	
	window.frames['child'].document.getElementById('hiddenv').value = opendiv;			//传值给 iframe text
	}