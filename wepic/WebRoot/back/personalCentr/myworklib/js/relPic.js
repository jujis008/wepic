$(function(){
	
	
	divLiBar2("mainbar","personalCenter");   //主导航背景底边框
	
	divLiBar("divTopBarContainer");   //展开头部右边详细
	
	userBuyCart();  				/*头部展开用户/购物车信息详细 */
	
	
	achieveBelow("divSelectHighestDegreeValue","selectHighestDegreeValue")					/*获取下拉框值并隐藏	 作品类型*/
	
	changeHead("divChangeHead","divViewHead");
	
	document.getElementById("formrelwork").reset();
	$("#inpcheckuesr").attr("disabled","disabled");
	$("#inpcheckuesr2").attr("disabled","disabled");
	$("#butportraRight").attr("disabled","disabled");
	$("#butrealRight").attr("disabled","disabled");
	
	//backToPrevious();
	
	
	divLiBar("ULUpload");   //显示上传删除
	
});


function deleteFile(obj,objId){
	if(confirm("确定删除吗?")){
		
	//$("#filename").val();
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
			  alert("ssssssssssssssss");
			
			//  alert($("#"+objId));
			  var pro=$("#"+objId);
			   var attachmentUrl=$(pro).val();
			//   alert(attachmentUrl);
			   var attachmentUrls=attachmentUrl.split(" ");
			   //alert(attachmentrrrrrrrUrls.length);sssss
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
	
//	promptlength('textareastorytt','textareaStory',400);xxx		//描述
	
	cssyq("inpcheckuesr2","csbq");		//出售版权
	
	cssyq("inpcheckuesr","cssyq");		//出售使用权
	
	lookfor("divAddEnTagpho","choosetypeCha","retag");		//作品类型
	
	lookfor2("divAddPersonTag","choosegjc");		//关键词
	
	lookforli("ULUpload");
	var puType=$("#selectHighestDegreeValue").text();
	$("#typePublish").val(1);
	if(puType=="创意图片"){
		$("#typePublish").val(2);	
	}
	// alert($("#typePublish").val());
	
	/*
	
	$("#divAddPersonTag").find("div").each(function(){
		
		
		
	});
	*/
	var tagsvalue="";
	var temppublishcat=$("input[name='mytags']");
	for(var i=0;i<temppublishcat.length;i++){
	//	alert($(temppublishcat[i]).val());
		if(tagsvalue==""){
			tagsvalue=$(temppublishcat[i]).val();	
			
		}else{
			tagsvalue+=" "+$(temppublishcat[i]).val();
			// alert(tagsvalue+"===")
		}
		
		
	}
	// alert(tagsvalue);
	$("#tagsPublish").val(tagsvalue);
	
	
	$("#formrelwork").submit();
	
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
function changexkxy(obj,view,clas){
	var che = $(obj).attr("checked");
	
	$("#"+view).next().hide();
	
	if(che){
		$("#"+view).removeAttr("disabled");
		$("#"+view).next().next().find("input").css({"margin-top":"-40px"});
		}
	else{
		$("#"+view).attr("disabled","disabled");
		$("#"+view).next().next().find("input").css({"margin-top":"-10px"});
		$("."+clas).each(function(){
		$(this).remove();
		});
		if(view=="butportraRight"){
			 $("#portraitprotocol").val("");
		}else{
			
			$("#productsprotocol").val("");
			
		}
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

//跟换头像
	
function changehh(url){					
	alert(url);
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


       /*增加推荐标签*/
   function addreProfTagPic(obj,addDiv){
    	//  alert("ddddd");
	var option = "" ;
	var addvalue = $(obj).prev().html();
	var id =($(obj).parent().parent().attr("id"));
	var classN =$(obj).parent().attr("class");
	//alert(classN+"classN");
	if($(obj).attr('title') == '删除'){
		var divAdd;
		if(addDiv == "divAddReTagPerson"){
			divAdd = "divAddPersonTag";
			}
		else{
			divAdd = "divAddEnTagpho";
			}
	var option = "" ;
	var addvalue = $(obj).prev().html();
	
	var dataId=$(obj).parent().attr("id");
	//alert("ddddddddd=");
	$(obj).parent().remove();
	option = "<div class='retag' id='"+dataId+"'><span>"  + addvalue + "</span><a title='增加' onclick=addreProfTagPic(this,'"+ divAdd +"');></a></div>";
	$("#"+addDiv).append(option);
	}
	else{
		var option = "" ;			
			// alert("sssssssssssss");
			var addvalue = $(obj).parent().attr("id"); 
			var tags=$("#hiddenReTags").val();
			if(tags!=""){
				
				tags+=" "+$.trim($(obj).parent().attr("id"));		//已ssssss经有值
				}
			else{
				tags=$.trim($(obj).parent().attr("id"));			//赋第一个值
				}
			$("#hiddenReTags").val(tags);
		
			
	$(obj).parent().remove();
	var dataId=$(obj).parent().attr("id");
	option = "<div class='retag' id='"+dataId+"'><span>"  +  $(obj).prev().html() + "</span><a title='删除' onclick='deleteProModelPic(this);'></a></div>";
	$("#"+addDiv).append(option);
	getCatTags();
		}
}
/*增加推荐标签*/

   
   
   function getCatTags(){
	   //alert("ddddddd");
	   var id=$("#hiddenReTags").val();
		$.ajax({
		      type:"Post",
			  url: "projectCat_getTypeCatTags.do",
			  data:"id="+id,		
			  success : function(data) { 
	         var html="";
	         if(data.catTagsList==null||data.catTagsList==""){
	        	 $("#divAddReTagPerson").html(html);
	        	 $("#chageGrop").html("");
	        	 return;
	         }
	         var tags=data.catTagsList.split(",");
	         for(var i=0;i<tags.length;i++){
	          // var cat=data.publishChilessssdCats[i];
	           html+='<div class="retag"><span>'+
	           tags[i]+
			"</span><a title='增加' onclick=addreProfTag(this,'divAddPersonTag');></a></div>";
	             }
	          $("#divAddReTagPerson").html(html);
	          $("#chageGrop").html("换一组");
				  
				    
			  }
		});
	}
   
   

/*增加其他标签*/
function addOtherTag(obj,addDiv){
	if($(obj).attr('title') == '删除'){
		var option = "" ;
	var addvalue = $(obj).prev().html();
	
	$(obj).parent().remove();
	
	option = "<div class='othtag'><span>"  + addvalue + "</span><a title='增加' onclick=addOtherTag(this,'divAddEnTagpho');></a></div>";
	$("#"+addDiv).append(option);
		}
	else{
		
		
		var addvalue = $(obj).prev().text(); 
		var tags=$("#hiddenReTags").val();
		if(tags!=""){
			tags+=" "+$.trim($(obj).prev().text());		//已经有值
			}
		else{
			tags=$.trim($(obj).prev().text());		//赋第一个值
			}
		$("#hiddenReTags").val(tags);
		
	
			/*input隐藏推荐标签*/
			
		var option = "" ;
		var addvalue = $(obj).prev().html();
	
	$(obj).parent().remove();
	
	option = "<div class='othtag'><span>"  + addvalue + "</span><a title='删除' onclick='deleteProModel(this);'></a></div>";
	$("#"+addDiv).append(option);
	
		}
	
	}
/*增加其他标签*/






/*删除标签*/	
function deleteProModelPic(obj){
	var id =($(obj).parent().parent().attr("id"));
	var classN =$(obj).parent().attr("class");
	
	 if(confirm("确定删除吗?")){
		 
			var detag=$(obj).parent().attr("id");
		
			var tags=$("#hiddenReTags").val();		//隐藏Input的值
			var tag=tags.split(" ");
		
			var newtag="";							//d定义一个新数组
			for(var i=0;i<tag.length;i++){			//循环旧数组
				if(tag[i]==detag){
					}
				else{
					if(newtag!=""){					//讲遍历出来与要删除不相等的数据删掉
		        	newtag+=" "+$.trim(tag[i]);
		   				}
					else{
					newtag=tag[i];
						}
					}
			}
			//alert(newtag);
			//alert(detag);
		$("#hiddenReTags").val(newtag);
		
		}
		/* 删除隐藏推荐标签*/
		
	
		addreProfTag(obj,'divAddReTagPerson');	//移除到divAddReTagPerson中
		getCatTags();
	}
	
	
		
	


/*删除标签*/

