$(function(){ 
		$("#tableR tr:odd").addClass("alt");
		$("#tableR tr").mouseover(function(){  
                //如果鼠标移到class为stripe的表格的tr上时，执行函数
        $(this).addClass("over");}).mouseout(function(){ 
                                //给这行添加class值为over，并且当鼠标一出该行时执行函数
        $(this).removeClass("over");})//点击变色,注意：因为有隔行变色，所以这里必须在触发toggleClass时,remove("alt").

    
         //给class为stripe的表格的偶数行添加class值为alt
});
