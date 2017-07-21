$(function(){
	
	
	divLiBar2("mainbar","personalCenter");   //主导航背景底边框
	
	divLiBar("divTopBarContainer");   //展开头部右边详细
	
	userBuyCart();  				/*头部展开用户/购物车信息详细 */
	
	
	achieveBelow("divdropDownPartType","divdropDownViewPartType");					/*获取下拉框值并隐藏	默认专辑*/
	
	achieveBelow("divSelectHighestDegreeValue","selectHighestDegreeValue")					/*获取下拉框值并隐藏	 作品类型*/
	
	changeHead("divChangeHead","divViewHead");
	
	document.getElementById("formrelwork").reset();
	$("#inpcheckuesr").attr("disabled","disabled");
	$("#inpcheckuesr2").attr("disabled","disabled");
	$("#butportraRight").attr("disabled","disabled");
	$("#butrealRight").attr("disabled","disabled");
	
	backToPrevious();
	
	
	divLiBar("ULUpload");   //显示上传删除
	
});


function deleteFile(obj,objId){
	if(confirm("确定删除吗?")){		
	deleteajaxFileName($(obj).parents("li"),objId);
	$(obj).parents("li").remove();
	}
}
	function deleteajaxFileName(obj,objId){
		var fileName=$(obj).find("#filename").val();
		var fileurl=$(obj).find("#url").val();
	
		$.ajax({
		      type:"Post",
			  url: "bidAction_deleteFiled.do",
			  data:"fileName="+fileName,		
			  success : function(data) { 
			   var attachmentUrl=$("#"+objId).val();
			   //alert(attachmentUrl);
			   var attachmentUrls=attachmentUrl.split(" ");
			   //alert(attachmentUrls.length);
			   var newurl="";
			   for ( var  i= 0; i < attachmentUrls.length; i++) {
				  // alert(attachmentUrls[i]!=fileurl);
				   if(attachmentUrls[i]!=fileurl){
					   if(newurl==null&&newurl==""){
						   newurl=attachmentUrls[i];
	 		                 }else{
	 		                	newurl=newurl+" "+attachmentUrls[i];
	 		                     }
					   
		                 }
				
			}
			   $("#"+objId).val(newurl);
             
		      }
		});
		
		
	}
	
function addwenjian(){
	var allli = $("#ULUpload").children().find("li");
	if(allli.length < 4){
		option = '<li><div class="success"><div class="contenttd"><div class="divtd"><i class="file"></i><i class="true" title="上传成功"></i></div><div class="infos" title="这里是全名称">附件三等份收复失地附件三等份收复失地附件附件三等份收复失地附件附件三等份收复失地附件1111111111111111111111111111.pdf(56.KB)</div></div><div class="bjcon"><div class="bj"></div><div class="bjc"><i class="del" title="删除" onclick="deleteFile(this);"></i></div></div></div></li>';
	$("#ULUpload").children().append(option);
		}
	else{
		alert("不好意思，只能添加四个附件");
		}
	
	}
function verifyForm(){
	promptInfo('texttitleinp','titleprompt',40);		//标题
	
	promptlength('textareastorytt','textareaStory',400);		//描述
	
	cssyq("inpcheckuesr2","csbq");		//出售版权
	
	cssyq("inpcheckuesr","cssyq");		//出售使用权
	
	lookfor("divAddEnTagpho","choosetypeCha","retag");		//作品类型
	
	lookfor2("divAddPersonTag","choosegjc");		//关键词
	
	lookforli("ULUpload");
	
	}
function changesell(obj,othridao,showhide,showhidepd){
	/*$(this).removeAttr("disabled");
	$("#"+othridao).removeAttr("disabled");*/
	$(obj).attr("checked","checked");
	$("#"+othridao).removeAttr("checked");
	
	var check = $("#"+showhidepd).attr("checked");
	
	if(!check){
		$("#"+showhide).show();
		}
	else{
		$("#"+showhide).hide();
		}
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
function lookforli(lookdiv){
	$("#choosefj").hide();
	var allli = $("#"+lookdiv).find("li");
	if(allli.length==0){
		$("#choosefj").show();
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
function changexkxy(obj,view){
	var che = $(obj).attr("checked");
	
	$("#"+view).next().hide();
	
	if(che){
		$("#"+view).removeAttr("disabled");
		}
	else{
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
function fucropHead(){	
	openPopUpBox('cropHead');
	//var urlc = "../../public/" + url;
	var urlc = "pic/1000.png";
	
	var frobj = window.frames['child2'].document.getElementById('imghead');
	
	$(frobj).attr("src",urlc);
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



