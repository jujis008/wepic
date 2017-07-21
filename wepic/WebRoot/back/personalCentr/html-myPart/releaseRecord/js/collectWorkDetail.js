$(function(){
	
	
	
	judgeLi("divListOneUl",16);	//达到图片数显示分页
	judgeLi("divListTwoUl",16);	//达到图片数显示分页
	judgeLi("divListThreeUl",16);	//达到图片数显示分页
	judgeLi("divListFourUl",16);	//达到图片数显示分页
	
	
	xuan();				//选项卡
	
	//clock();				//倒计时
	
	
	objscroll("divApointProjectRight",260);
	
	divLiBarClick("divsxOne");
	divLiBarClick("divsxTwo");
	divLiBarClick("divsxThree");
	
	
	
	
	/*新增*/
	hoverImgHead('.selected_work_img');
	achieveBelow("divdropDownPartType","divdropDownViewPartType")				
	/*新增*/
	
	
	
	nextPrePage(														
			"#generalizeUL",															//	ul
			".divViewPic_left",															//	ul父节点
			"url(../../../pubimg/images/popPaging.png) 0 -112px no-repeat",				//	已经是第一张
			"url(../../../pubimg/images/popPaging.png) 0 0 no-repeat",						//	左边默认
			"url(../../../pubimg/images/popPaging.png) 0 -56px no-repeat",					//	左边hover
			"url(../../../pubimg/images/popPaging.png) -57px -112px no-repeat",			//	已经是最后一张
			"url(../../../pubimg/images/popPaging.png) -57px 0 no-repeat",					//	右边默认
			"url(../../../pubimg/images/popPaging.png) -57px -56px no-repeat");			//	右边hover
			
			
	
	clickPopPic();					//筛选图片作品
	
	viewPic();						//查看图片
	
	/*监听点击事件*/
	$("body").click(function(e){
			var have = $("body").find("#popOnlyPic");
                 if ($(e.target).is('a')||$(e.target).is('input:button')||$(e.target).attr("class") == "imgbgc"||$(e.target).attr("class") == "imgbg")
                     return;
                 else{
					 if(have.length == 1){
						$("#greybackground").remove();
                     	$("#popOnlyPic").remove();
						 
						 }
					else{
						return;
						}
                 }
                  
           });
	
	});
	/*监听点击事件*/

function clickPopPic(){
	var allPic = $(".lilistOnly");
	$(allPic).each(function(index, element) {
        $(this).click(
			function(){
				openPopUpBox('divViewPicCon');
				}
		);
    });
}

	
	
function poptousu(){
	cloosePopBox('divWorkAbarbeitung');
	openPopUpBox('divComplaint');
	}

/*投诉*/
function submitComplaint(){
	var num = $("#inputWorkNum").val();
	var numtextarea= $("#textareacomplaint").val();
	
	if(num == "请输入作品编号"){
		alert("请输入作品编号");
		return;
		}
	if(numtextarea == "" || numtextarea== null){
		alert("请输入投诉原因");
		return;
		}
	else{
		cloosePopBox('divComplaint');
		openPopUpBox('divComplaint2');
		}

}



function submitComplaint2(){
	var Linkman = $("#inputComplaintLinkman").val();
	var Phone= $("#inputComplaintPhone").val();
	var Address= $("#inputComplaintAddress").val();
	
	if(Linkman == "" || Linkman== null){
		alert("请输入联系人");
		return;
		}
	if(Phone == "" || Phone== null){
		alert("请输入联系电话");
		return;
		}
	if(Address == "" || Address== null){
		alert("请输入联系地址");
		return;
		}
	else{
		alert("成功");
		}

}

/*投诉*/





/*结款评价*/
function submitPayment(){
	var num = $("#inputnumber").val();
	
	if(num == "请输入验证码"){
		alert("请输入验证码");
		}
	}

function hoverImgHead(divName){
	var Onesel=$(divName);
	$(Onesel).each(function(index, element) {
        $(this).hover(
			function(){$(this).addClass("active");},
			function(){$(this).removeClass("active");}
		);
    });
}

/*结款评价*/




/*开具发票*/
function submitInvoice(){
	var title = $("#inputInvoiceTitle").attr("disabled");
	var titleV = $("#inputInvoiceTitle").val();
	var addressV = $("#inputReceiptAddress").val();
	var recipientsV = $("#inputRecipients").val();
	var phoneV = $("#inputContactPhone").val();
	
	
	if(title != 'disabled'){
		if(titleV == '' || titleV == null){
			alert("请输入企业名");
			return;
		}
	}

	if(addressV == '' || addressV == null){
		alert("请输入发票邮寄地址");
		return;
	}
	
	if(recipientsV == '' || recipientsV == null){
		alert("请输入收件人");
		return;
	}
	
	if(phoneV == '' || phoneV == null){
		alert("请输入联系电话");
		return;
	}
	
	alert("chenggong");
	cloosePopBox('divInvoice');

}

/*开具发票*/



var flag = 0;
function xuan(){
        var cardLi=$("#recruitCameristTimelyStateCard").find("li");
		var oDivSon =$(".divStateCardCon").find(".divList");
		
		
        for(var i=0;i<cardLi.length;i++){  
            cardLi[i].index=i; //input[0].index=0 index是自定义属性
            cardLi[i].onclick=function(){
               for(var i=0;i<cardLi.length;i++){  //循环历遍去掉button样式和把div隐藏
                  cardLi[i].className='';
                  oDivSon[i].style.display='none';
               };
			   
			 if(flag == 0){
				$("#divStageTop").slideUp();
				$("#divFold").slideUp();
				$("#rightDetail").hide();
				$("#rightFiltrate").show();
				$("#stateCardBackDetail").show();
   				window.scrollTo((0), (90));
				flag = 1;
				 }
				 
               this.className='active';  //当前按钮添加样式
               oDivSon[this.index].style.display='block';  //div显示 this.index是当前div 即div[0]之类的
           };
         };
		 
       }
	


function showDetail(){
	 if(flag == 0){
		$("#divStageTop").slideUp();
		$("#divFold").slideUp();
		$("#rightDetail").hide();
		$("#rightFiltrate").show();
		$("#stateCardBackDetail").show();
		flag = 1;
   		window.scrollTo((0), (90));
		return;
	}
	
	
	if(flag == 1){
		$("#divStageTop").slideDown();
		$("#divFold").slideDown();
		$("#rightDetail").show();
		$("#rightFiltrate").hide();
		$("#stateCardBackDetail").hide();
		flag = 0;
		return;
	}		 
	
}

