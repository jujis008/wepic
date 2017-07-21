$(function(){
	
	divLiBar2("mainbar","personalCenter");   //主导航背景底边框
	
	
	divLiBar("divTopBarContainer");   //展开头部右边详细
	
	userBuyCart();  				/*头部展开用户/购物车信息详细 */
	
	
	achieveBelow("divdropDownPartType","divdropDownViewPartType")					/*获取下拉框值并隐藏	拍摄类型*/
	
	achieveBelow("divdropDownCopyright","divdropDownViewCopyright")					/*获取下拉框值并隐藏	拍摄类型*/
	
	achieveBelow("divdropDownBidType","divdropDownViewBidType")					/*获取下拉框值并隐藏	招标方式*/
	
	createHour("divdropDownStartHour");		/*获取小时	00-23时*/
	
	achieveBelow("divdropDownStartHour","divdropDownViewStartHour")					/*获取下拉框值并隐藏	24小时1*/


	
	divLiBar("ULUpload");   //显示上传删除
	
	
	
	//hideSelect();
});

function deleteFile(obj){
	if(confirm("确定删除吗?")){
		
	//$("#filename").val();
	deleteajaxFileName($(obj).parents("li"));
		$(obj).parents("li").remove();
	}
	function deleteajaxFileName(obj){
		var fileName=$(obj).find("#filename").val();
		var fileurl=$(obj).find("#url").val();
	
		$.ajax({
		      type:"Post",
			  url: "bidAction_deleteFiled.do",
			  data:"fileName="+fileName,		
			  success : function(data) { 
			   var attachmentUrl=$("#attachmentUrl").val();
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
			   $("#attachmentUrl").val(newurl);
             
		      }
		});
		
		
	}
	
}


function subForm(){
	$("#bidtag").val($("#divdropDownViewPartType").html());
	var workEndTime=$("#txtEndDate").val()+" "+$("#divdropDownViewStartHour2").text()+":"+$("#workEndTimefen").val();
	$("#workEndTime").val(workEndTime);
	
	
	var isneedmodel=$.trim($("#divdropDownViewCopyright").html());
	var needmodel="1";
	if(isneedmodel=="征集版权作品"){
		needmodel="0";	
	}
	$("#copyRighyt").val(needmodel);
	var isnum=0;
	var publicOrPrivate=$.trim($("#divdropDownViewBidType").html());
	if(publicOrPrivate=="私密招标"){
		isnum=1;
	}
	
	$("#publicOrPrivate").val(isnum);
	validateBidForm();
}