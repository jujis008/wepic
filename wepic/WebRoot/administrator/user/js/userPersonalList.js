$(function(){
	addChildActiveDiv("allJobFiltrate");				//职业筛选
	
	
	
	
	//表格奇偶数行背景颜色
	tableOddEvenBackground("#tablePersonList");
	})
	
	
	
	//表格奇偶数行背景颜色
function tableOddEvenBackground(id){  
    odd = {"background":"#F9F9F9"};				//奇数样式  
    even = {"background":"#FFFFFF"};			//偶数样式 
	
    $(id).find("tr").each(function(index,element){  
        if(index % 2 == 1)  
            $(this).css(odd);  
        else  
            $(this).css(even);  
    });  
} 