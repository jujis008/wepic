$(function(){
	//divLiBar("divMainList");   //list内容显示收藏
	
	divLiBar2("mainbar","mainbarCenterLi2");   //主导航背景底边框
	
	divLiBar("divTopBarContainer");   //展开头部右边详细
	
	divLiBar("topBarShoppingDetailed");   //头部购物车展开列表背景
	
	userBuyCart();  				/*头部展开用户/购物车信息详细 */
	
	xuan();

	clock();				//倒计时
	
	priceButton('worksCollectTitleTopQuotedPrice','tableworksCollectConInfoInviteBidsWinPrice','worksCollectConInfoSubmitBut1','worksCollectConInfoSubmitBut2');
	});
	



function xuan(){
        var card=document.getElementById('worksCollectTimelyStateCard');
        var cardLi=card.getElementsByTagName('li');
		
		var div=document.getElementById('worksCollectTimelyStateCardCon');
        var oDiv=div.getElementsByTagName('div');

		
		var oDivSon = [];
		for(var i=0;i<oDiv.length;i++){
			if(oDiv[i].className == 'worksCollectTimelyStateCardConSon'){
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