$(function(){
	
	
	divLiBar2("mainbar","personalCenter");   //主导航背景底边框
	
	divLiBar("divTopBarContainer");   //展开头部右边详细
	
	userBuyCart();  				/*头部展开用户/购物车信息详细 */
	
	
	changeHead("divChangeHead","divViewHead");
	$("#inpcheckuesr").attr("disabled","disabled");
	$("#inpcheckuesr2").attr("disabled","disabled");
	
});

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
option = "<div class='retag' id='"+dataId+"'><input type='hidden' name='temppublishcat' value="+dataId+"><span>"  +  $(obj).prev().html() + "</span><a title='删除' onclick='deleteProModelPic(this);'></a></div>";
$("#"+addDiv).append(option);
getCatTags();
	}
}



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
		
	
	 addreProfTagPic(obj,'divAddReTagPerson');	//移除到divAddReTagPerson中
		getCatTags();
	}


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


	function addOwnBoxloading(){
		var option = "" ;
		
		option = "<div id='detailloading' class='addcon-de'><a class='delcon' href='javascript:' onclick='delcon(this);'>×</a><div class='head'><img src='public/images/loader01.gif' style='width: 32px; height: 32px' align='center' class='imgC' /></div><div class='area'><textarea name='storycxt' id='storycxt'></textarea></div></div>";
		
		
		$("#divallDe").append(option);
	}
	function removedetailloading(){
		$("#detailloading").remove();
		addSubStory();
	}
function addOwnBox(url,id){
	$("#detailloading").remove();
	var urlc =url;
	var option = "" ;
	
	option = "<div class='addcon-de'><a class='delcon' href='javascript:' onclick='delcon(this);'>×</a><div class='head'><input name='temppublish' type='hidden' id='temppublish' value="+id+"></input><img src='" + urlc + "' /></div><div class='area'><textarea name='storycxt' id='storycxt'></textarea></div></div>";
	
	
	$("#divallDe").append(option);
	}
	
	

//打开裁切
function fucropHead(url,id){	
	openPopUpBox('cropHead');
	var frobj = window.frames['child2'].document.getElementById('imghead');
	//var position=url.indexOf(".");
    //var testurl=url.substring(0,position)+"_smalldraw"+url.substring(position);
	
	$(frobj).attr("src",url);


	var obj = window.frames['child2'].document.getElementById('preview');
	$(obj).find("input").attr("value",id);
	$(obj).find("img").attr({"src":"","class":"imgbj"});
	$(obj).find("img").attr("src",url);
	//$(obj).find("img").attr("src",url);
	}

function fucropHeadloading(){
	openPopUpBox('cropHead');
	var frobj = window.frames['child2'].document.getElementById('preview');
	
	$(frobj).find("img").attr("src","");
	$(frobj).find("img").attr({"src":"../../../public/images/loader01.gif","class":"imgB"});
	//var position=url.indexOf(".");
    //var testurl=url.substring(0,position)+"_smalldraw"+url.substring(position);
	var obj = window.frames['child2'].document.getElementById('divImg');
	$(obj).find("img").attr("src","");
	$(obj).find("img").attr("src","../../../public/images/loader01.gif");
}
function removefucropHeadloading(){
	closeOwnBox("cropHead");
	changeHeadStory('cropHead');
}

//跟换头像
	
function changehh(url,id){		
	var urlc = url;
	var hiddenId=id;
	
	
	$("#divChangeHead").find("img").attr("src",urlc);
	$("#divChangeHead").find("input").attr("value",hiddenId);
	
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
	alert("xxxxxxxxxxxxxxxxxxxxx");
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
			if($(allSpan[i]).html().trim() != addvalue ){
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
		option = "<div class='tag'><input name='mytags' type='hidden' value="+addvalue+"></input><span>"  + addvalue + "</span><a title='删除' onclick='deleteProModel(this);'></a></div>";
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
	openPopUpBox('chooseworkdetail');
	window.frames['child1'].initdata();
	window.frames['child1'].document.getElementById('hiddenv').value = "addSubStory";			//传值给 iframe text
	}

function changeHeadStory(opendiv){
	
	openPopUpBox('chooseWork');
	window.frames['child'].initdata();
	window.frames['child'].document.getElementById('hiddenv').value = opendiv;			//传值给 iframe text
	}