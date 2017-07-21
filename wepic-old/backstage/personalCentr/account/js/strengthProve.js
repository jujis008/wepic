$(function(){
	divLiBar2("mainbar","personalCenter");   //主导航背景底边框
	
	divLiBar("divTopBarContainer");   //展开头部右边详细
	
	userBuyCart();  				/*头部展开用户/购物车信息详细 */
	
	
	
	divLiBar("divMyReHead");				//查看头像
	
	projectHead("divContinueHead");				//查看头像
	
	
	
	divLiBar("divMyReWork");					//查看头像 代表作品
	
	divLiBar("divReProject");					//查看头像 代表作品项目
	
	divLiBar("divMyReHonor");					//查看头像 我的荣誉
	
	
	
	
	
	edit();									//显示删除和编辑承接的代表性项目
	
	createYear("divSelectCreYearValue");		/*获取年份		1914--2013*/
	
	
	achieveBelow("divSelectWorkTypeValue","selectWorkTypeValue");		/*获取下拉框值并隐藏	最高学历*/
	
	achieveBelow("divSelectCreYearValue","selectCreYearValue");		/*获取下拉框值并隐藏	年份*/
	
	
	});	

//代表项目显示	
function projectHead(){
	var oDiv = document.getElementById("divContinue");
	
	var alldiv = oDiv.getElementsByTagName("div");
	var allcHead =[];
	
	for(var i= 0; i<alldiv.length;i++){
		if($(alldiv[i]).attr("id") == "divContinueHead"){
			allcHead[allcHead.length] = alldiv[i];
			}
	}
	
for( var j= 0;j<allcHead.length;j++){
		var allMainBarLi=allcHead[j].getElementsByTagName("li");
	
	for(var i=0;i<allMainBarLi.length;i++){
			allMainBarLi[i].onmouseover = function(){
			
		for(var i=0;i<allMainBarLi.length;i++){
				allMainBarLi[i].className = "";
			}
			this.className="active";
		};
		allMainBarLi[i].onmouseout = function(){
			for(var i=0;i<allMainBarLi.length;i++){
				this.className="";
			}
		};
		}
	}

	
}
	
function edit(){				
	var oDivEdit = document.getElementById("divContinue");
	var oDivEdttDiv=oDivEdit.getElementsByTagName("div");
	
	
	
		var getObj = [];
		for(var i=0;i<oDivEdttDiv.length;i++){
			if(oDivEdttDiv[i].className == 'cont' || oDivEdttDiv[i].className == 'cont conno'){
				getObj[getObj.length] = oDivEdttDiv[i];
				}
		}
		
		for(var i = 0;i<getObj.length;i++){
			getObj[i].index = i;
			
			/*alert("33");*/
			getObj[i].onmouseover = function(){
			
			for(var i=0;i<getObj.length;i++){
				$(getObj[i]).addClass("");
			}
			$(getObj[this.index]).addClass("active");
		};
		getObj[i].onmouseout = function(){
			for(var i=0;i<getObj.length;i++){
				$(getObj[this.index]).removeClass("active");
			}
		};
	}
}


/*关闭三级弹出框-iframe*/
function closeOwnBox(){
	$("#greybackground").remove();
	$("#chooseWork").hide();
	}
/*关闭三级弹出框-iframe*/	
	
	
function changeBox(hiddenDiv){
	
	cloosePopBox(hiddenDiv);		//隐藏二级div
	
	openPopUpBox('chooseWork');		//显示iframe div
	
	window.frames['child'].document.getElementById('hiddenv').value = hiddenDiv;			//传值给 iframe text
	}

