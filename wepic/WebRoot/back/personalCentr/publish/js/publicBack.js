$(function(){
	
	/*bar("divTwoStage","divThreeStage","threeStage");*/
	divLiBar2("mainbar","personalCenter");   //主导航背景底边框
	
	divLiBar("divTopBarContainer");   //展开头部右边详细
	
	userBuyCart();  				/*头部展开用户/购物车信息详细 */
	});	

/*function bar(twoStage,threeStage,classThreeStage){
	var divTwoStage = document.getElementById(twoStage);
	var allTwoStage = divTwoStage.getElementsByTagName("div");
	
	var divThreeStage = document.getElementById(threeStage);
	var allThreeStage = divThreeStage.getElementsByTagName("div");
	
	var threeStageObj = [];
		for(var i=0;i<allThreeStage.length;i++){
			if(allThreeStage[i].className == classThreeStage){
				threeStageObj[threeStageObj.length] = allThreeStage[i];
				}
		}
	for(var i=0;i<allTwoStage.length;i++){
		allTwoStage[i].index = i;
		allTwoStage[i].onclick = function(){
			for(var i=0;i<threeStageObj.length;i++){
				threeStageObj[i].style.display = "none";
				allTwoStage[i].className = "";
				
				allTwoStage[i].style.color = "#4a4a4a";
				allTwoStage[i].style.background = "";
				}
				threeStageObj[this.index].style.display = "block";
				this.className = "active";
				this.style.color = "#c29494";
				this.style.background = "#ffffff";
				barThree(threeStageObj[this.index]);
		}
	}
}

function barThree(threeStage){
	var allthreeStage = threeStage.getElementsByTagName("div");
	
	for(var i=0;i<allthreeStage.length;i++){
		allthreeStage[i].onclick = function(){
			for(var i=0;i<allthreeStage.length;i++){
				allthreeStage[i].className = "";
				allthreeStage[i].style.color = "#4a4a4a";
				allthreeStage[i].style.background = "#ffffff";
				}
			this.className = "active";
			this.style.color = "#ffffff";
			this.style.background = "#c29494";
		}
	}
}*/

/*显示下拉框列表*/
function showBelow(showDiv){
	$("#"+showDiv).show();
	$("#"+showDiv).parent().parent().css("z-index","1000");
	
	$(".editSelect").each(function() {
        $(this).hover(
		function(){
			//$(this).find(".belowValue").show();
		},
		function(){
			$(this).find(".belowValue").hide();
		});
    });
	}
	
	
	
function locatArea(province,city,district,box){
	this.Are = new getArea(province,city,district);
	this.tag = [box.getElementsByTagName('dt'),box.getElementsByTagName('dd')];
	this.setAreaDat(0);
                                box.onclick = function(areaObj){ 
                                        return function(e){
                                                var evt = e || event, span = evt.srcElement || evt.target;
                                                var mName = span.parentNode.nodeName.toLowerCase();
                                                if(mName === 'dt'){
                                                        for(var i=0,j; j=areaObj.tag[1][i++];) j.style.display = 'none';
                                                        span.parentNode.nextSibling.style.display = 'block';
                                                }else if(mName === 'dd'){
                                                        span.firstChild.parentNode.parentNode.style.display = 'none';
                                                        areaObj.setProvince(span);
                                                }
                                        } 
                                }(this);
                        }
                        locatArea.prototype.setAreaDat = function(i) {
                                this.Name = [this.Are.pName,this.Are.cName,this.Are.dName];
                                this.Dat = [this.Are.pDat,this.Are.cDat,this.Are.dDat];
                                for(i; i<3; i++) {
                                        this.tag[0][i].getElementsByTagName('span')[0].innerHTML = this.Name[i];
                                        this.tag[0][i].getElementsByTagName('input')[0].value = this.Name[i];
                                        this.tag[1][i].innerHTML = this.createHTML(this.Dat[i],i);
                                }
                        }
                        locatArea.prototype.createHTML = function(arr,a) {
                                if(arr==null) return '请先选择城市';
                                var html = '';
                                for(var i = 0, j; j = arr[i++]; )
                                html += '<span rel="'+a+'">'+j+'</span>';
                                return html;
                        }
                        locatArea.prototype.setDistrict = function(district) { this.Are.dName = district; }
                        locatArea.prototype.setProvince = function(mouseTag) {
                                var a = Number(mouseTag.getAttribute('rel'));
                                var areaName = mouseTag.innerHTML;
                                switch (a) {
                                        case 0: this.Are.getCity(areaName);
                                        break;
                                        case 1: this.Are.getDistrict(areaName);
                                        break;
                                        case 2: this.setDistrict(areaName);
                                        break;
                                } this.setAreaDat(a);
                        }

/*显示下拉框列表*/


/*获取下拉框值并隐藏*/
//		bolewDiv		下拉框div列表
//		showValue		显示值
function achieveBelow(bolewDiv,showValue){
	var bolewDiv=document.getElementById(bolewDiv);
	var bolewDivSpan=bolewDiv.getElementsByTagName("span");
	/*alert("11");*/
				
	for(var i=0;i<bolewDivSpan.length;i++){
		bolewDivSpan[i].onclick=function (){
			/*document.getElementById(showValue).innerHTML = this.innerHTML;*/
			$("#"+showValue).html(this.innerHTML);
			$(bolewDiv).hide();
			$(bolewDiv).parent().parent().css("z-index","0");
			};
		}
}
/*获取下拉框值并隐藏*/


/*获取年份		1914--2013*/
function createYear(addDiv){
	var option = "" ;
	
	var oDate=new Date();
	var iYear=oDate.getYear();
	
	if(iYear<1900)
	{
		iYear+=1900;
	}
	
	for(var i = 0; i<100; i++){
		option += "<span class='selectValueIn'>" + iYear-- +"</span>";
		}
		
	$("#"+addDiv).append(option);
	}
/*获取年份		1914--2013*/

/*获取月份		1-12月*/
function createMonth(addDiv){
	var option = "" ;
	
	for(var  i= 0; i<12; i++){
		month = i + 1;
		option += "<span class='selectValueIn'>" + month +"月</span>";
		}
		
	$("#"+addDiv).append(option);
	}
/*获取月份		1-12月*/

/*获取日		1-30日*/
function createDay(addDiv){
	var option = "" ;
	
	for(var  i= 0; i<30; i++){
		day = i + 1;
		option += "<span class='selectValueIn'>" + day +"日</span>";
		}
		
	$("#"+addDiv).append(option);
	}
/*获取日		1-30日*/



/*创建24小时		*/
function createHour(addDiv){
	var option = "" ;
	var hour;
	for(var  i= 0; i < 24; i++){
		if(i < 10){
			hour = "0" + i;
			}
		else{
			hour =  i;
			}
		option += "<span class='dropValue'>" + hour +"</span>";
		}
		
	$("#"+addDiv).append(option);
	}
/*创建24小时		*/


/*增加推荐标签*/
function addreProfTag(obj,addDiv){
	
	var id =($(obj).parent().parent().attr("id"));
	var classN =$(obj).parent().attr("class");
	
	if($(obj).attr('title') == '删除'){
		var divAdd;
		if(addDiv == "divAddReTagPerson"){
			divAdd = "divAddPersonTag";
			}
		else{
			divAdd = "divAddEnTagpho";
			}
	var option = "" ;
	var addvalue = $(obj).prev().html();
	
	$(obj).parent().remove();
	option = "<div class='retag'><span>"  + addvalue + "</span><a title='增加' onclick=addreProfTag(this,'"+ divAdd +"');></a></div>";
	$("#"+addDiv).append(option);
	}
	else{
		var option = "" ;
		
			/*隐藏推荐标签*/
		if(classN == "retag" && id == "divAddReTag"){
			var addvalue = $(obj).prev().html(); 
			var tags=$("#hiddenReTags").val();
			if(tags!=""){
				tags+=" "+$(obj).prev().html();		//已经有值
				}
			else{
				tags=$(obj).prev().html();			//赋第一个值
				}
			$("#hiddenReTags").val(tags);
		}
			/*隐藏推荐标签*/
		
			/*隐藏推荐标签个人*/
		if(classN == "retag" && id == "divAddReTagPerson"){
			var addvalue = $(obj).prev().html(); 
			var tags=$("#hiddenReTagsP").val();
			if(tags!=""){
				tags+=" "+$(obj).prev().html();		//已经有值
				}
			else{
				tags=$(obj).prev().html();			//赋第一个值
				}
			$("#hiddenReTagsP").val(tags);
		}
			/*隐藏推荐标签个人*/
			
	$(obj).parent().remove();
	
	option = "<div class='retag'><span>"  + addvalue + "</span><a title='删除' onclick='deleteProModel(this);'></a></div>";
	$("#"+addDiv).append(option);
	
		}
}
/*增加推荐标签*/


/*增加其他标签*/
function addOtherTag(obj,addDiv){
	if($(obj).attr('title') == '删除'){
		var option = "" ;
	var addvalue = $(obj).prev().html();
	
	$(obj).parent().remove();
	
	option = "<div class='othtag'><span>"  + addvalue + "</span><a title='增加' onclick=addOtherTag(this,'divAddEnTagpho');></a></div>";
	$("#"+addDiv).append(option);
		}
	else{
		
			/*input隐藏推荐标签*/
			var tags=$("#hiddenOtherTags").val();
			if(tags!=""){
				tags+=" "+$(obj).prev().html();		//已经有值
				}
			else{
				tags=$(obj).prev().html();			//赋第一个值
				}
			$("#hiddenOtherTags").val(tags);
	
			/*input隐藏推荐标签*/
			
		var option = "" ;
		var addvalue = $(obj).prev().html();
	
	$(obj).parent().remove();
	
	option = "<div class='othtag'><span>"  + addvalue + "</span><a title='删除' onclick='deleteProModel(this);'></a></div>";
	$("#"+addDiv).append(option);
	
		}
	
	}
/*增加其他标签*/


/*增加自定义标签*/
function addProfTag(value,addDiv){
	var option = "" ;
	var addvalue = $("#"+value).val();
	$("#"+value).val("");
	
	var addoDiv=document.getElementById(addDiv);
	
	var addDivCon=addoDiv.getElementsByTagName("div");
	
		var addObj = [];
		for(var i=0;i<addDivCon.length;i++){
			if(addDivCon[i].className == "tag"){
				addObj[addObj.length] = addDivCon[i];
				}
		}
	//判断新增字段是否已存在
	var allSpan = $(addoDiv).find("span") ;
		
		for(var i = 0; i<allSpan.length; i++){
			if($(allSpan[i]).html() != addvalue ){
				}
			else{
				alert("不好意思，该标签已存在！");
				return;
				}
		}
		
	//判断新增字段是否为空
	if(addvalue == '' || addvalue == null){
		alert("不好意思，职业标签名不能为空！");
		}
	else if(addObj.length < 2){
		option = "<div class='tag'><span>"  + addvalue + "</span><a title='删除' onclick='deleteProModel(this);'></a></div>";
		}
	else{
		alert("不好意思，新增项目只可以有两个！");
		}
	
			/*input自定义推荐标签*/
			var tags=$("#hiddenUserTags").val();
			if(tags!=""){
				tags+=" "+addvalue;		//已经有值
				}
			else{
				tags=addvalue;			//赋第一个值
				}
			$("#hiddenUserTags").val(tags);
	
			/*input自定义推荐标签*/
	$("#"+addDiv).append(option);
}
/*增加自定义标签*/



/*删除标签*/	
function deleteProModel(obj){
	var id =($(obj).parent().parent().attr("id"));
	var classN =$(obj).parent().attr("class");
	
	 if(confirm("确定删除吗?")){
		 
		/* 删除隐藏推荐标签*/
		if(classN == "retag" && id == "divAddEnTagpho"){
			var detag=$(obj).prev().html();
		
			var tags=$("#hiddenReTags").val();		//隐藏Input的值
			var tag=tags.split(" ");
		
			var newtag="";							//d定义一个新数组
			for(var i=0;i<tag.length;i++){			//循环旧数组
				if(tag[i]==detag){
					}
				else{
					if(newtag!=""){					//讲遍历出来与要删除不相等的数据删掉
		        	newtag+=" "+tag[i];
		   				}
					else{
					newtag=tag[i];
						}
					}
			}
		$("#hiddenReTags").val(newtag);
		
		}
		/* 删除隐藏推荐标签*/
		
		/* 删除隐藏推荐标签个人*/
		if(classN == "retag" && id == "divAddPersonTag"){
			var detag=$(obj).prev().html();
		
			var tags=$("#hiddenReTagsP").val();		//隐藏Input的值
			var tag=tags.split(" ");
		
			var newtag="";							//d定义一个新数组
			for(var i=0;i<tag.length;i++){			//循环旧数组
				if(tag[i]==detag){
					}
				else{
					if(newtag!=""){					//讲遍历出来与要删除不相等的数据删掉
		        	newtag+=" "+tag[i];
		   				}
					else{
					newtag=tag[i];
						}
					}
			}
		$("#hiddenReTagsP").val(newtag);
		
		}
		/* 删除隐藏推荐标签个人*/
		
		
		/* 删除隐藏其他标签*/
		if(classN == "othtag" && id=="divAddEnTagpho"){
			var detag=$(obj).prev().html();
		
			var tags=$("#hiddenOtherTags").val();		//隐藏Input的值
			var tag=tags.split(" ");
		
			var newtag="";							//d定义一个新数组
			for(var i=0;i<tag.length;i++){			//循环旧数组
				if(tag[i]==detag){
					}
				else{
					if(newtag!=""){					//讲遍历出来与要删除不相等的数据删掉
		        	newtag+=" "+tag[i];
		   				}
					else{
					newtag=tag[i];
						}
					}
			}
		$("#hiddenOtherTags").val(newtag);
		}
		/* 删除隐藏其他标签*/
		
		
		/* 删除隐藏自定义标签职业*/
		if(classN == "tag" && id=="divAddEnTagpho"){
			var detag=$(obj).prev().html();
		
			var tags=$("#hiddenUserTags").val();		//隐藏Input的值
			var tag=tags.split(" ");
		
			var newtag="";							//d定义一个新数组
			for(var i=0;i<tag.length;i++){			//循环旧数组
				if(tag[i]==detag){
					}
				else{
					if(newtag!=""){					//讲遍历出来与要删除不相等的数据删掉
		        	newtag+=" "+tag[i];
		   				}
					else{
					newtag=tag[i];
						}
					}
			}
		$("#hiddenUserTags").val(newtag);
		}
		/* 删除隐藏自定义标签职业*/
		
		/* 删除隐藏自定义标签个人*/
		if(classN == "tag" && id=="divAddPersonTag"){
			var detag=$(obj).prev().html();
		
			var tags=$("#hiddenUserTagsP").val();		//隐藏Input的值
			var tag=tags.split(" ");
		
			var newtag="";							//d定义一个新数组
			for(var i=0;i<tag.length;i++){			//循环旧数组
				if(tag[i]==detag){
					}
				else{
					if(newtag!=""){					//讲遍历出来与要删除不相等的数据删掉
		        	newtag+=" "+tag[i];
		   				}
					else{
					newtag=tag[i];
						}
					}
			}
		$("#hiddenUserTagsP").val(newtag);
		}
		/* 删除隐藏自定义标签个人*/
		
		$(obj).parent().remove();
		
		if($(obj).parent().attr('class') == 'othtag'){
		addOtherTag(obj,'divAddOtherTag');
		
		}
	else if(classN == 'retag' && id == "divAddPersonTag"){
		
		addreProfTag(obj,'divAddReTagPerson');	//移除到divAddReTagPerson中
		}
			
	else if(classN == 'retag' && id == "divAddEnTagpho"){
		addreProfTag(obj,'divAddReTag');
		}
	}
	
	
		
	
	
}

/*删除标签*/







/*删除li*/
function deleteLiFile(obj){
	if(confirm("确定删除吗?")){
		$(obj).parents("li").remove();
	}
}

/*删除li*/


/*获取下拉框值并隐藏	input*/
//		bolewDiv		下拉框div列表
//		showValue		显示值
function achieveBelowInput(bolewDiv,showValue){
	var bolewDiv=document.getElementById(bolewDiv);
	var bolewDivSpan=bolewDiv.getElementsByTagName("span");
	/*alert("11");*/
				
	for(var i=0;i<bolewDivSpan.length;i++){
		bolewDivSpan[i].onclick=function (){
			/*document.getElementById(showValue).innerHTML = this.innerHTML;*/
			$("#"+showValue).val(this.innerHTML);
			$(bolewDiv).hide();
			};
		}
}
/*获取下拉框值并隐藏	input*/




/*选择发布类型*/
function chooseRelType(obj){
	var option = "";
	
	$("#"+obj).click(function(){
		var htmlWidth = document.body.clientWidth;
		var htmlHeight = document.body.clientHeight;
		var borwerViewWidth =  document.documentElement.clientWidth;
		var borwerViewHeight =  document.documentElement.clientHeight;
		/*alert(htmlHeight);*/
	
		var getwidth = parseInt($("#divChoseUser").css("width"));
		var getheight = parseInt($("#divChoseUser").css("height"));
	
		var topWidth = (borwerViewWidth - getwidth)/2;
		var topHeight = (borwerViewHeight - getheight)/ 2;
	
	
		$("body").prepend('<div id="iframechooseRelType" style="width:'+borwerViewWidth+'px;height:'+htmlHeight+'px; background:454;z-index:100000000;overflow:hidden;"></div>');
		$("#iframechooseRelType").prepend('<iframe name="child" style="border:0px;width:'+borwerViewWidth+'px;height:'+htmlHeight+'px;z-index:100000000" src="chooseRelProject.html"></iframe>');
		$("#iframechooseRelType").css({ "position": "absolute","z-index":"10000","top":topHeight + "px" , "left": topWidth+"px"});
		
	
		});
	}
/*选择发布类型*/


function addClickzj(divName){
	var allMainBarLi=$("#"+divName).find("li");
	
	$(allMainBarLi).each(function(){
			$(this).click(function(){
				var allMainBarLi=$("#"+divName).find("li").each(function() {
                    $(this).removeClass("active");
					$(this).children().find(".click").remove();
                });
					$(this).addClass("active");
					$(this).children().append('<div class="click"></div>');
					 });
					
    });	
}