$(function(){
	divLiBar2("mainbar","personalCenter");   //主导航背景底边框
	
	divLiBar("divTopBarContainer");   //展开头部右边详细
	
	userBuyCart();  				/*头部展开用户/购物车信息详细 */
	
	/*changehead("divheadChange","headChange");*/
	
	
	
	/*choosePopUpBox(obj);*/
	
	changeHead("divheadChange","headChange");
	});

function changeHead(div,viewDiv){
$('#'+div).hover(
function(){
	$('#'+viewDiv).stop().fadeTo('slow',1);
},
function(){
	$('#'+viewDiv).stop().fadeTo('slow',0);
});
	}
function changehead(div,obj){
	document.getElementById(div).onmouseover = function(){
		
		}
	document.getElementById(div).onmouseout = function(){
		
		}
	}
function upHead(obj){
	$("#"+obj).animate({bottom:'0px'});
	}
function downHead(obj){
	$("#"+obj).animate({bottom:'-35px'});
	}
	
function hoverHead(obj){
	$(obj).addClass("active");
	}
function overHead(obj){
	$(obj).removeClass("active");
	/*$("#div1").fadeTo("slow",0.15);*/	
	}

/*重新选择*/
function reChose(obj,opendiv){
	$(obj).parent().parent().hide();
	
	openPopUpBox(opendiv);
	}
/*重新选择*/


/*重新选择角色*/
function reChosePart(obj,opendiv){
	
	var gradpa=$(obj).parents(".chooseTag");
	var gra=$(gradpa).children(".choosed");
	var pa1=$(gra).children(".con");
	var pa2=$(pa1).children("#divAddEnTagmodel");
	var pa3=$(pa2).children(".tagDe");
	$(pa2).html("");
	$(pa2).append(pa3);
	$("#userRole").val("");
	$("#userTag").val("");
	$(obj).parent().parent().parent().hide();
	
	openPopUpBox(opendiv);
	}
/*重新选择角色*/


/*选择跳转	个人标签选择	企业标签选择*/
function choosePopUpBox(obj,opendiv){
	if(opendiv=="divChosePart"){
		$("#userType").val("1");
	}else if(opendiv=="divChoseTrade"){
		$("#userType").val("2");
	}else if(opendiv=="formPersonTagpho"){
		$("#userRole").val("photography");
	}else if(opendiv=="formPersonTagmodel"){
		$("#userRole").val("model");
		
	}else if(opendiv=="formPersonTagagent"){
		$("#userRole").val("broker");
		
	}else if(opendiv=="formPersonTagArt"){
		$("#userRole").val("art");
		
	}else if(opendiv=="formPersonTagdesigner"){
		$("#userRole").val("designer");	
	}else if(opendiv=="formPersonTagUser"){
		$("#userRole").val("commen");	
		
	}
	else {
		$("#userRole").val($("#"+opendiv+"1").val());
		
	}
	
	$(obj).parent().parent().hide();
	
	openPopUpBox(opendiv);
	}
/*选择跳转	个人标签选择	企业标签选择*/


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

function addProfTag(value,addDiv){
	var option = "" ;
	var addvalue = $("#"+value).val();
	var tag=$("#hiddenReTags").val();
	if(tag==null||tag==""){
		tag=addvalue;
	}else{
		tag+=" "+addvalue;
	}
	$("#hiddenReTags").val(tag);
	$("#"+value).val("");
	
	var addoDiv=document.getElementById(addDiv);
	
	var addDivCon=addoDiv.getElementsByTagName("div");
	
		var addObj = [];
		for(var i=0;i<addDivCon.length;i++){
			if(addDivCon[i].className == "tag"){
				addObj[addObj.length] = addDivCon[i];
				}
		}
	if(addvalue == '' || addvalue == null){
		alert("不好意思，职业标签名不能为空！");
		}
	else if(addObj.length < 2){
		option = "<div class='tag'><span>"  + addvalue + "</span><a title='删除' onclick=deleteProModel(this);''></a></div>";
		}
	else{
		alert("不好意思，新增项目只可以有两个！");
		}
		
	$("#"+addDiv).append(option);
	}
	
function addreProfTag(obj,addDiv){
	var option = "" ;
	var addvalue = $(obj).prev().html();
	//alert("sssssssssssss");
	
	$(obj).parent().remove();
	
	option = "<div class='retag'><span>"  + addvalue + "</span><a title='删除' onclick=deleteProModel(this);''></a></div>";
	$("#"+addDiv).append(option);
	var tag=$("#hiddenReTags").val();
	if(tag==null||tag==""){
	$("#hiddenReTags").val(addvalue);
	}else{
	$("#hiddenReTags").val(tag+" "+addvalue);
	}
	}	

function deleteProModel(obj){
	 if(confirm("确定删除吗?")){
		 var addvalue = $(obj).prev().html();
		 var tag=$("#hiddenReTags").val();
		 var newtags="";
		 var tags=tag.split(" ")
		  
		 for(var i=0;i<tags.length;i++){
			 if(addvalue!=tags[i]){
				 if(newtags==""){
					 newtags=tags[i];
				 }else{
					 newtags+=" "+tags[i]; 
				 }
			 }
			 
			 
		 }
		 
		 var tag=$("#hiddenReTags").val(newtags);
		$(obj).parent().remove();
	}
}