$(function(){
	hoverAddClass("divMainListUL");   //list内容显示收藏
	

	divLiBarClick("filterWrapperSort");   //排序
	
	
	filterSure();						//确定按钮显示
	
	});
	
	
function filterSure(){
	$("#filterWrapperSortRR").hover(
		function(){$("#sureMoneySubmit").show();},
		function(){$("#sureMoneySubmit").hide();}
	);
}

function suerSubmit(minMoney,maxMoney){
	minVal = $("#"+minMoney).val();
	maxVal = $("#"+maxMoney).val();
	
	if(minVal > maxVal){
		$("#"+minMoney).val(maxVal);
		$("#"+maxMoney).val(minVal);
		}
	
}

function divLiBarClick(divName){
	var allMainBarLi=$("#"+divName).find("li");
	
	$(allMainBarLi).each(function(){
			$(this).click(function(){
			 var allMainBarLi=$("#"+divName).find("li").each(function() {$(this).removeClass("active");});
			$(this).addClass("active");
			var tag=$.trim($(this).text());
			if(tag=="最新发布"){
				$("#searTag").val("new");
				$("#searTag").attr("name","newbid");
			}
			else if(tag=="即将开始"){
				$("#searTag").val("willStrat");
				$("#searTag").attr("name","willStartBid");
				
			}
			else if(tag=="薪酬"){
				$("#searTag").val("hightMoney");
				$("#searTag").attr("name","hightTotalMoney");
				
			}
			//sss
			$("#nowPage").val(1);
			$("#tagBidreSearAction").submit();
			
			
			
			
			
			});	
    });	
}