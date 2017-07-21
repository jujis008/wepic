$(function(){
	//divLiBar("divMainList");   //list内容显示收藏
	
	divLiBar2("mainbar","mainbarCenterLi2");   //主导航背景底边框
	
	divLiBar("divTopBarContainer");   //展开头部右边详细
	
	divLiBar("topBarShoppingDetailed");   //头部购物车展开列表背景
	
	userBuyCart();  				/*头部展开用户/购物车信息详细 */
	
	xuan();
	
	priceButton('appointProjectTitleTopQuotedPrice','appointProjectConInfoWinBidsInfoP','appointProjectConInfoSubmitBut1','appointProjectConInfoSubmitBut2');
	
	});
	



function xuan(){
        var card=document.getElementById('recruitCameristTimelyStateCard');
        var cardLi=card.getElementsByTagName('li');
		
		var div=document.getElementById('recruitCameristTimelyStateCardCon');
        var oDiv=div.getElementsByTagName('div');

		
		var oDivSon = [];
		for(var i=0;i<oDiv.length;i++){
			if(oDiv[i].className == 'recruitCameristTimelyStateCardConSon'){
				oDivSon[oDivSon.length] = oDiv[i];
				}
		}
		
        for(var i=0;i<cardLi.length;i++){  //循环历遍onclick事件
            cardLi[i].index=i; //input[0].index=0 index是自定义属性
            cardLi[i].onmouseover=function(){
               for(var i=0;i<cardLi.length;i++){  //循环历遍去掉button样式和把div隐藏
                  cardLi[i].className='';
                  oDivSon[i].style.display='none';
               };
               this.className='active';  //当前按钮添加样式
               oDivSon[this.index].style.display='block';  //div显示 this.index是当前div 即div[0]之类的
           };
         };
		 
       }
	   
function priceButton(tag,price,ying,bao){
	var oTag = document.getElementById(tag);
	var oPrice = document.getElementById(price);
	var oYing = document.getElementById(ying);
	var oBao = document.getElementById(bao);
	
	var oTagDis = getStyle(oTag,"display");
		if(oTagDis == 'none'){
			oYing.style.display ='';
			oBao.style.display ='none';
			}
		else if(oTagDis != 'none'&&oPrice.innerHTML=="——"){
			oYing.style.display ='none';
			oBao.style.display ='';
			}
		else{
			oYing.style.display ='';
			oBao.style.display ='';
			}
	}

/*弹出框显示隐藏*/
function openOfferProductShoot(){
	var height = document.body.clientHeight;
	var width = document.body.clientWidth;
	var h =  document.documentElement.clientHeight;
	var w =  document.documentElement.clientWidth;
	
	var offerProductShootForm = document.getElementById("offerProductShootForm");
	
	var getwidth = parseInt(getStyle(offerProductShootForm,"width"));
		
	$("body").prepend('<div id="greybackground" style="position:absolute; z-index:9999;background:black;display:none"></div>');
	$("html,body").animate({ scrollTop:0},0);
	//$("html,body").css({ "overflow": "hidden"});
	$("#greybackground").css({ "opacity": "0.8", "height": height+"px","display":"block","width":"100%","background":"black","top":"0px","left":"0px"});
	$("#greybackground").show();
	$("#offerProductShootForm").show();
	/*document.body.style.overflow="hidden";*/
	$("#offerProductShootForm").css({ "position": "absolute","z-index":"9999","top": 50+"px","left": (w-getwidth)/2+"px"});
	}
function closeOfferProductShoot(){
	$("#greybackground").remove();
	$("#offerProductShootForm").hide();
	/*document.body.style.overflow="auto";*/
}
/*弹出框显示隐藏*/


/*仅报总价和详报价细*/
function viewTotal(viewmx,viewto){
	var viewmx = document.getElementById(viewmx);
	var viewto = document.getElementById(viewto);
	
	var getviewmx = getStyle(viewmx,"display");
	var getviewto = getStyle(viewto,"display");
	if(getviewmx == "block"){
		viewmx.style.display = "none";
		viewto.style.display = "block";
		}
	else{
		viewmx.style.display = "block";
		viewto.style.display = "none";
		}
	}
/*仅报总价和详报价细*/

/*表格操作*/
var i = 1;
function addViewTr(){
		
		
		var addTr = '';
		addTr= "<tr><td class='th th-num'>"+ i++ +"</td><td class='th th-info'>计费项目简介</td><td class='th th-money'>454.00</td><td class='th th-op'><span onclick='deleteViewTr(this);'>删除该条</span></td></tr>";
			
	
	$("#viewTable").append(addTr);	
}


function deleteViewTr(obj){
	$(obj).parent().parent().remove();
	}
/*表格操作*/