$(function(){
	
	
	nextPrePage(														
			"#generalizeUL",															//	ul
			".generalizeCon",															//	ul父节点
			"url(../../pubimg/images/popPaging.png) 0 -112px no-repeat",				//	已经是第一张
			"url(../../pubimg/images/popPaging.png) 0 0 no-repeat",						//	左边默认
			"url(../../pubimg/images/popPaging.png) 0 -56px no-repeat",					//	左边hover
			"url(../../pubimg/images/popPaging.png) -57px -112px no-repeat",			//	已经是最后一张
			"url(../../pubimg/images/popPaging.png) -57px 0 no-repeat",					//	右边默认
			"url(../../pubimg/images/popPaging.png) -57px -56px no-repeat");			//	右边hover
			
			
	
	
	
	achieveBelowIncord("divdropDownIncome","divdropDownViewIncome","#textareaInfo");
	achieveBelowIncord("divdropDownIncome2","divdropDownViewIncome2","#textareaInfo2");
	
	});




function copyToClipboard(txt) {
    if (window.clipboardData) {
        window.clipboardData.clearData();
        window.clipboardData.setData("Text", txt);
        alert("已经成功复制到剪帖板上！");
    } else if (navigator.userAgent.indexOf("Opera") != -1) {
        window.location = txt;
    } else if (window.netscape) {
        try {
            netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect");
        } catch (e) {
            alert("被浏览器拒绝！\n请在浏览器地址栏输入'about:config'并回车\n然后将'signed.applets.codebase_principal_support'设置为'true'");
        }
        var clip = Components.classes['@mozilla.org/widget/clipboard;1'].createInstance(Components.interfaces.nsIClipboard);
        if (!clip) return;
        var trans = Components.classes['@mozilla.org/widget/transferable;1'].createInstance(Components.interfaces.nsITransferable);
        if (!trans) return;
        trans.addDataFlavor('text/unicode');
        var str = new Object();
        var len = new Object();
        var str = Components.classes["@mozilla.org/supports-string;1"].createInstance(Components.interfaces.nsISupportsString);
        var copytext = txt;
        str.data = copytext;
        trans.setTransferData("text/unicode", str, copytext.length * 2);
        var clipid = Components.interfaces.nsIClipboard;
        if (!clip) return false;
        clip.setData(trans, null, clipid.kGlobalClipboard);
        alert("已经成功复制到剪帖板上！");
    }
}














function achieveBelowIncord(bolewDiv,showValue,textarea){
	var bolewDivSpan=$("#"+bolewDiv).find("span");
	var url = 'http://www.wepic.cn';
	
	$(bolewDivSpan).each(function() {
		$(this).click(
			function(){
				
				$("#"+showValue).html(this.innerHTML);
				$("#"+bolewDiv).hide();
				
				var thisV = trim(this.innerHTML);
				if(thisV == '产品拍摄' ){
					$(textarea).html('我要开网店，产品没有漂亮的图片怎么办？唯图网为您提供专业拍摄。（'+url+'）');
					}
				else if(thisV == '商业摄影' ){
					$(textarea).html('专业商业摄影，百万位专业摄影师供您选择。（'+url+'）');
					}
				else if(thisV == '婚纱写真' ){
					$(textarea).html('专业个性写真、婚纱摄影，就在唯图网。（'+url+'）');
					}
				else if(thisV == '找模特' ){
					$(textarea).html('我要找模特，哪里找？唯图网给您专业的选择。（'+url+'）');
					}
				else if(thisV == '创意素材' ){
					$(textarea).html('创意素材，高品质、正版、原创就是我的选择，原创正版创意素材尽在唯图网！（'+url+'）');
					}
				});
	
		});	
	$(".divdropDown").each(function() {
        $(this).hover(
		function(){
			//$(this).find(".belowValue").show();
		},
		function(){
			$(this).find(".dropDownBoxValue").hide();
			$(this).parent().css("z-index","0");
		});
    });
	
}
/*获取下拉框值并隐藏*/	
	
function nextPrePage(ul,parent,firstURL,firstURLNormal,firstURLHover,lastURL,lastURLNormal,lastURLHover){
	var allLi = $(ul).children();		
	var liWidth = $(allLi).outerWidth();					//孩子的宽度
	
	var nowLeft;
	
	$(ul).css('width',allLi.length * liWidth +'px' );
	$(ul).parents(parent).prev().css("background",firstURL);
	$(ul).parents(parent).prev().attr("disabled","disabled");
	
	
	
	$(ul).parents(parent).prev().click(
		function(){
			if($(this).attr("disabled") !="disabled"){
				nowLeft = parseInt($(ul).css('left'));
			
				$(ul).parents(parent).next().css("background",lastURLNormal);
				$(ul).parents(parent).next().removeAttr("disabled");
			
			
				if(nowLeft == 0-liWidth){
					$(ul).parents(parent).prev().css("background",firstURL);
					$(ul).parents(parent).prev().attr("disabled","disabled");
					}
				else{
					$(ul).parents(parent).prev().css("background",firstURLNormal);
					$(ul).parents(parent).prev().removeAttr("disabled");
					}	
					
				
				
					$(ul).animate({left:nowLeft+liWidth+'px'},function(){
					});	
					
				}
			
		});
	
	
	$(ul).parents(parent).next().click(
		function(){
			if($(this).attr("disabled") !="disabled"){
				$(ul).parents(parent).prev().css("background",firstURLNormal);
				$(ul).parents(parent).prev().removeAttr("disabled");
				
				
				
				nowLeft = parseInt($(ul).css('left'));
				
				if(nowLeft == -(allLi.length-2) * liWidth){
					$(ul).parents(parent).next().css("background",lastURL);
					$(ul).parents(parent).next().attr("disabled","disabled");
					}
				else{
					$(ul).parents(parent).next().css("background",lastURLNormal);
					$(ul).parents(parent).next().removeAttr("disabled");
					}	
					
					
				$(ul).animate({left:nowLeft-liWidth+'px'},function(){
					
				});	
			}
		});
		
/*解决hover问题*/
$(ul).parents(parent).prev().hover(
	function(){
		if($(this).attr("disabled") !="disabled"){
			$(this).css("background",firstURLHover);
			}
		},
	function(){
		if($(this).attr("disabled") !="disabled"){
			$(this).css("background",firstURLNormal);
		}
		}
);


$(ul).parents(parent).next().hover(
	function(){
		if($(this).attr("disabled") !="disabled"){
			$(this).css("background",lastURLHover);
			}
		},
	function(){
		if($(this).attr("disabled") !="disabled"){
			$(this).css("background",lastURLNormal);
		}
		}
);



}	
