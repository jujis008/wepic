$(function(){
	
	
	divLiBar2("mainbar","personalCenter");   //主导航背景底边框
	
	divLiBar("divTopBarContainer");   //展开头部右边详细
	
	userBuyCart();  				/*头部展开用户/购物车信息详细 */
	
	
	
	
	hoverAddClass("diveditSpecial");		//显示编辑按钮
	
	
	tabControl2("diveditSpecial","diveddelAll");					//点击看专辑详情
	
	divLiBarClick("chooseColorb");
	divLiBarClick("chooseColorb2");
	
});

function verifyForm(){
	promptInfo('textname','promptname',10);
	promptInfo('textarezjsm','promptzjsm',100);
	choosecolor("promptzjcolor","chooseColorb");
}
function verifyForm2(){
	promptInfo('textname2','promptname2',10);
	promptInfo('textarezjsm2','promptzjsm2',100);
	choosecolor("promptzjcolor2","chooseColorb2");
}

//  showdiv		显示的div
//  div		查找i的div

function choosecolor(showdiv,div){
	$("#"+showdiv).children().remove();			//先清空当前div里元素
	var addI = $("#"+div).find("i");
	var view = [];
	$(addI).each(function() {
        if($(this).css("display") == "block"){
			view[view.length] = this;
			}
    });
		if(view.length <= 0){
			option = "<div class='divprompt'><span>请选择颜色</span></div>";
			$("#"+showdiv).append(option);
			}
	
	}
function editzj(viewDiv){
	$("#diveddelAll").hide();
	$("#divAddZj").hide();
	$("#divEditZj").hide();
	
	$("#"+viewDiv).show();
	return;
	}

function resetzj(obj){
	$(obj).parent().parent().hide();
	}
	

/*选项卡*/
function tabControl2(chooseDiv,viewDiv){
        var cardLi=$("#"+chooseDiv).find('.special');
		
		var viewLi=$("#"+viewDiv).find('li');

		for(var i=0;i<cardLi.length;i++){  //循环历遍onclick事件
            cardLi[i].index=i; //input[0].index=0 index是自定义属性
            cardLi[i].onclick = function(){
				
				$("#divAddZj").hide();
				$("#divEditZj").hide();
	
				$("#diveddelAll").show();
				
               for(var i=0;i<cardLi.length;i++){  //循环历遍去掉button样式和把div隐藏
                  $(cardLi[i]).addClass("active");
                  viewLi[i].style.display='none';
               };
               $(this).addClass("active");  //当前按钮添加样式
               viewLi[this.index].style.display='block';  //div显示 this.index是当前div 即div[0]之类的
           };
         };
}
	

/*选项卡*/