/*收藏唯图*/
function addToFavorite(url,title)
{
	var fav_url = url; 
	var fav_title = title; 
		if (document.all && window.external){ 
			window.external.AddFavorite(fav_url,fav_title); 
		}
		else{ 
			alert("浏览器不支持，请手动Ctrl+D加入收藏夹"); 
			} 
} 

/*收藏唯图*/


/* 删除购物车*/
function topBarShoppingDetailedOpertPOneExit(obj){
		if (confirm("确认要删除？")) {
			$(obj).parent().parent().parent().remove();
		}
}
		
/* 删除购物车*/
