$(function(){
	xuan();
	
	//clock();				//倒计时
	
	share();
});

/*取消报价1*/
function cloosePopBoxQuote(form){
	cloosePopBox('popupIQuoteForm');
	document.getElementById(form).reset();
	$("#priceTD").html('<td class="td_one"><span>总价</span>:</td><td class="td_two"><input id="inputPrices" class="inputPrices" type="text"/><span class="yuan">元</span></td>');
	}

/*取消报价1*/



/*提交报价1*/
function submitIQuote(form){
	cloosePopBoxQuote('popupIQuoteForm');
	}	
/*提交报价1*/	


/*单价总价*/	
function changePriceLabel(obj){
	var nowVal = trim($(obj).prev().val());
	if(nowVal == '单价'){
		$("#priceTD").html('<td class="td_one"><span>单价</span>:</td><td class="td_two"><input id="inputPrices" class="inputPrices" type="text"/><span class="yuan">元/天</span></td>');
		return;
		}
	if(nowVal == '总价'){
		$("#priceTD").html('<td class="td_one"><span>总价</span>:</td><td class="td_two"><input id="inputPrices" class="inputPrices" type="text"/><span class="yuan">元</span></td>');
		return;
		}
	}
function changePrice(obj){
	var nowVal = trim($(obj).val());
	if(nowVal == '单价'){
		$("#priceTD").html('<td class="td_one"><span>单价</span>:</td><td class="td_two"><input id="inputPrices" class="inputPrices" type="text"/><span class="yuan">元/天</span></td>');
		return;
		}
	if(nowVal == '总价'){
		$("#priceTD").html('<td class="td_one"><span>总价</span>:</td><td class="td_two"><input id="inputPrices" class="inputPrices" type="text"/><span class="yuan">元</span></td>');
		return;
		}
	}
/*单价总价*/	
	
	
function submitIRespond(){
	
	
	cloosePopBox('popupIRespondForm');
	
	var scrollTop = getScrollTop();
	$("#popupIRespondSuccess").css("top",scrollTop+200 + 'px');
	
	$("#popupIRespondSuccess").fadeIn(1000);
	//window.scroll(0,0);
	var timer = setTimeout(function(){
		$("#popupIRespondSuccess").fadeOut(1000);
		},2000);
	}

function share(){
	$("#shareToTerrace").hover(function(){
			$("#shareToTerrace").hide();
			$("#shareTerrace").show();
		},function(){
		});
		
	$("#shareTerrace").hover(function(){
		},function(){
			$("#shareToTerrace").show();
			$("#shareTerrace").hide();
		});
	}
	
function xuan(){
	var scrollTop = getScrollTop();
        var cardLi=$("#recruitCameristTimelyStateCard").find("li");
		var oDivSon = $(".divStateCardCon").children();
		
        for(var i=0;i<cardLi.length;i++){  
            cardLi[i].index=i; //input[0].index=0 index是自定义属性
            cardLi[i].onclick=function(){
               for(var i=0;i<cardLi.length;i++){  //循环历遍去掉button样式和把div隐藏
                  cardLi[i].className='';
                  oDivSon[i].style.display='none';
               };
			   
               this.className='active';  //当前按钮添加样式
               oDivSon[this.index].style.display='block';  //div显示 this.index是当前div 即div[0]之类的
           };
         };
}


