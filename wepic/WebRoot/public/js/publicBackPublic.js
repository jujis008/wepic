

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
	option = "<div class='retag'><span><input type='hidden' name='temppublishcat' value="+addvalue+" ></input>"  + addvalue + "</span><a title='增加' onclick=addreProfTag(this,'"+ divAdd +"');></a></div>";
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
	
	option = "<div class='retag'><span><input type='hidden' name='temppublishcat' value="+addvalue+" ></input>"  + addvalue + "</span><a title='删除' onclick='deleteProModel(this);'></a></div>";
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
//////////////////////////////////////////////////////////////////////////////////////////////////////////

/* active 动作*/
function divLiBar(divName){
	var mainDiv=document.getElementById(divName);
	var allMainBarLi=mainDiv.getElementsByTagName("li");
	
	for(var i=0;i<allMainBarLi.length;i++){
		allMainBarLi[i].onmouseover = function(){
			
			for(var j=0;j<allMainBarLi.length;j++){
				allMainBarLi[j].className = "";
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

/* active 动作*/

/* active 动作	恢复默认样式*/
function divLiBar2(divName,li){
	var mainDiv=document.getElementById(divName);
	var allMainBarLi=mainDiv.getElementsByTagName("li");
	
	var nowLi=document.getElementById(li);
	
	for(var i=0;i<allMainBarLi.length;i++){
		allMainBarLi[i].onmouseover = function(){
			for(var i=0;i<allMainBarLi.length;i++){
				allMainBarLi[i].className = "";
			}
			this.className="active";
		};
		allMainBarLi[i].onmouseout = function(){
			for(var i=0;i<allMainBarLi.length;i++){
				allMainBarLi[i].className = "";
			}
			nowLi.className="active";
		};
		
		
	}
}


/* active 动作	恢复默认样式*/


/* click 动作*/
/*function divLiBarClick(divName){
	
	var mainDiv=document.getElementById(divName);
	var allMainBarLi=mainDiv.getElementsByTagName("li");
	
	for(var i=0;i<allMainBarLi.length;i++){
		allMainBarLi[i].onclick = function(){
			
			for(var i=0;i<allMainBarLi.length;i++){
				allMainBarLi[i].className = "";
			}
			this.className="click";
		};
	}
}*/

/* click 动作*/

function userBuyCart(){
/*展开用户信息详细 */

	
	var topBarUser=document.getElementById("topBarUser");
	var topBarUserDetailed=document.getElementById("topBarUserDetailed");
		
		topBarUserDetailed.onmouseover=topBarUser.onmouseover = function(){
				topBarUserDetailed.style.display="block";
				topBarUser.className="active1";
					};
		
		topBarUserDetailed.onmouseout=topBarUser.onmouseout = function(){
			topBarUserDetailed.style.display="none";
			topBarUser.className="";
				};

	/* 展开用户信息详细 */

	
	/*展开购物车详细 */

	
	var topBarShopping=document.getElementById("topBarShopping");
	var topBarShoppingDetailed=document.getElementById("topBarShoppingDetailed");
		
		topBarShoppingDetailed.onmouseover=topBarShopping.onmouseover = function(){
				topBarShoppingDetailed.style.display="block";
				topBarShopping.className='active1';
					};
		
		topBarShoppingDetailed.onmouseout=topBarShopping.onmouseout = function(){
			topBarShoppingDetailed.style.display="none";
			topBarShopping.className='';
				};

	/* 展开购物车详细 */
}

/*弹出层*/
function openPopUpBox(divPopUpBox){
	var htmlWidth = document.body.clientWidth;
	var htmlHeight = document.body.clientHeight;
	var borwerViewWidth =  document.documentElement.clientWidth;
	var borwerViewHeight =  document.documentElement.clientHeight;
	
	var scrollTop = getScrollTop();
	
	
	var getw =$("#"+divPopUpBox).width();
	var geth = $("#"+divPopUpBox).height();
	
	if(getheight == '' || getheight == null){
		getheight = 0;
		}
		
	var getwidth = parseInt(getw);
	var getheight = parseInt(geth);
	
	var topWidth = (borwerViewWidth - getwidth)/2;
	var topHeight = (borwerViewHeight - getheight)/ 2;
	
	$("#greybackground").remove();
	$("body").prepend('<div id="greybackground" style="position:absolute; z-index:700000;background:black;display:none"></div>');
	//$("html,body").animate({ scrollTop:0},0);
	//$("html,body").css({ "overflow": "hidden"});
	$("#greybackground").css({ "opacity": "0.8", "height": htmlHeight+"px","display":"block","width": htmlWidth+"px","background":"black","top":"0px","left":"0px"});
	$("#greybackground").show();
	
	$("#"+divPopUpBox).show();
	$("#"+divPopUpBox).css({ "position": "absolute","z-index":"800000","top": scrollTop + "px" , "left": topWidth+"px"});
	
	/*var qq = $("#greybackground").css("z-index");
	/*window.scrollTo(0,$(document).scrollTop());*/
	
}
function cloosePopBox(divPopUpBox){
	$("#greybackground").remove();
	$("#"+divPopUpBox).hide();
	document.body.style.overflow="auto";
}	
/*弹出层*/



function getScrollTop(){
	if(document.documentElement.scrollTop)
		{return document.documentElement.scrollTop;}
	else	
		{return document.body.scrollTop}
}


/* 回顶部 */
function goTopEx(){
	
    var aHeight = window.screen.availHeight; //   获取客户端分辨率的高度
	
    var sHeight = document.body.scrollHeight; //    获取浏览器的高度
	//alert(sHeight);
        var obj=document.getElementById("goTopBtn");
		//要获取当前页面的滚动条纵坐标位置
        function getScrollTop(){
			if(document.documentElement.scrollTop)
            	{return document.documentElement.scrollTop;}
			else	
				{return document.body.scrollTop}
            }
		//判断
        window.onscroll = function(){
			getScrollTop() > 0 ? obj.style.display="" : obj.style.display="none";
			//$("#qqq").val(getScrollTop());
			//moveTips(obj);
			//getScrollTop() >= sHeight-aHeight-50 ?  $("#goTopBtn").css("bottom",getScrollTop()-aHeight+440+"px") :  $("#goTopBtn").css("bottom","80px");
			}
		
		//window.onscroll = function(){getScrollTop() > 0 ? obj.style.display="" : obj.style.display="none";}
		
        function setScrollTop(value){
			if(document.documentElement.scrollTop){
				//alert(value);
				document.documentElement.scrollTop = value;}
			else	
				{document.body.scrollTop = value;}
            }    
		
		
		
        obj.onclick = function(){
            var goTop=setInterval(scrollMove,10);
            function scrollMove(){
                    setScrollTop(getScrollTop()/1.1);
			
                    if(getScrollTop()<1)clearInterval(goTop);
                }
        }
    }
	
/* 回顶部 */



/////跟着滚动条的高度
//var tips; 
var theTop = 100; /*这是默认高度,越大越往下*/
var old = theTop;

function moveTips(tips) {
    var tt = 0;
    if (window.innerHeight) {
        pos = window.pageYOffset
    } else if (document.documentElement && document.documentElement.scrollTop) {
        pos = document.documentElement.scrollTop
    } else if (document.body) {
        pos = document.body.scrollTop;
    }

    pos = pos - tips.offsetTop + theTop;
    pos=tips.offsetTop+pos/10;
    if (pos < theTop) pos = theTop;
    if (pos != old) {
        tips.style.top = pos+"px";
        tt = 0;
    }
    old = pos;
    setTimeout(moveTips,tt);
}
/////跟着滚动条的高度





/* 获取非行间样式 */
function getStyle(obj,name){

if(obj.currentStyle){
        return obj.currentStyle[name]
            }
else{
    return getComputedStyle(obj,false)[name]
        }
}
/* 获取非行间样式 */

/*低版本浏览器提示*/
function lowBrowser(){
	
	
	if (window.ActiveXObject) {
 		var ua = navigator.userAgent.toLowerCase();
  		var ie=ua.match(/msie ([\d.]+)/)[1]
		if(ie==6.0){
			var remindIE="";
			remindIE='<div id="divRemindIE" style="width:100%;height:40px;line-height:40px;background:#FFFF9B;font-size:15px;color:#BA903A;position:relative;top:0px;left:0px;font-family:宋体;"><font>您的浏览器版本过低，为了您的财产安全，及获得更佳的浏览体验，建议您</font><a href="http://windows.microsoft.com/zh-cn/windows/upgrade-your-browser" target="_blank" style="text-decoration:underline;">立即升级</a>浏览器！</div>';
			$("#topbar").append(remindIE);	
			$("#topBar").css("height","80px");
			/*alert("您的浏览器版本过低，在本系统中不能达到良好的视觉效果，建议你升级到ie8以上！");
			window.close();*/
		}
	}
}

/*低版本浏览器提示*/

// 判断是否IE浏览器
function iehover(){
	
if(document.all){ 
	var obj=document.all;
	for(var i=0;i<obj.length;i++){
		obj[i].onmouseover=function(){
			this.className='hover';
		};
		obj[i].onmouseout=function(){
			this.className='';
		};
	}
	}
}

/*达到图片数显示分页*/
function judgeLi(obj,num){
	var allli = $("#"+obj).find("li");
	if(allli.length > num){
		$(".ppointPagingthis").show();
		}
	}
/*达到图片数显示分页*/

//验证是否为空和长度
function promptInfo(obj,addToDiv,length){
	
	$("#"+addToDiv).children().remove();			//先清空当前div里元素
	var option = "";
	var promptInfo = "";
	var len = length/2;
	
	
	var val = $("#"+obj).val();
	var byteCount = getByteCount(val);
	
	/*alert(length+byteCount);*/
		if(val == "" || val == null){
			promptInfo = "标题不能为空";
			addpromptInfo(promptInfo,addToDiv);			//增加div
			return;
			}
		
		else if(byteCount > length){
			promptInfo = "";
			promptInfo = "标题长度不能超过"+len+"字";
			
			addpromptInfo(promptInfo,addToDiv);			//增加div
			return;
			}	
}
//验证长度
function promptlength(obj,addToDiv,length){
	
	$("#"+addToDiv).children().remove();			//先清空当前div里元素
	var option = "";
	var promptInfo = "";
	var len = length/2;
	
	
	var val = $("#"+obj).val();
	var byteCount = getByteCount(val);
	
	if(byteCount > length){
			promptInfo = "";
			promptInfo = "长度不能超过"+len+"字";
			
			addpromptInfo(promptInfo,addToDiv);			//增加div
			return;
			}	
}
//验证长度

function addpromptInfo(promptInfo,addToDiv){
	option = "<div class='divprompt'><span>"+promptInfo+"</span></div>";
	$("#"+addToDiv).append(option);
	}	
 /*字节不超过	*/
function getByteCount(str){
	return str.replace(/[^\x00-\xff]/g, "**").length;
	}
 
/*字节不超过	*/


/* active 动作	---jquery*/
function hoverAddClass(divName){
	var allLi=$("#"+divName).find("li");
	$(allLi).each(function(){
			$(this).hover(
				function(){$(this).addClass("active");},
				function(){$(this).removeClass("active");}
			);
    });	

}

/* active 动作		---jquery*/
// 判断是否IE浏览器


/*function IE6BorwerPNG(){
	if (window.ActiveXObject) {
 		var ua = navigator.userAgent.toLowerCase();
  		var ie=ua.match(/msie ([\d.]+)/)[1]
		if(ie==6.0){
			document.write("<script src='DD_belatedPNG_0.0.8a.js'><\/script>");
			 DD_belatedPNG.fix('div, ul, img, li, input , a');
		}
	}
}*/


/*更换头像*/
function changeHead(div,viewDiv){
	$('#'+div).hover(
		function(){
			$('#'+viewDiv).stop().fadeTo('slow',1);
		},
		function(){
			$('#'+viewDiv).stop().fadeTo('slow',0);
		});
}
/*更换头像*/



/*选项卡*/
function tabControl(chooseDiv,viewDiv){
        var cardLi=$("#"+chooseDiv).find('li');
		
		var viewLi=$("#"+viewDiv).find('li');

		for(var i=0;i<cardLi.length;i++){  //循环历遍onclick事件
            cardLi[i].index=i; //input[0].index=0 index是自定义属性
            cardLi[i].onclick = function(){
               for(var i=0;i<cardLi.length;i++){  //循环历遍去掉button样式和把div隐藏
                  cardLi[i].className='';
                  viewLi[i].style.display='none';
               };
               this.className='active';  //当前按钮添加样式
               viewLi[this.index].style.display='block';  //div显示 this.index是当前div 即div[0]之类的
           };
         };
}
	

/*选项卡*/




/* click 动作		jquery*/
function divLiBarClick(divName){
	var allMainBarLi=$("#"+divName).find("li");
	
	$(allMainBarLi).each(function(){
			$(this).click(function(){
				var allMainBarLi=$("#"+divName).find("li").each(function() {$(this).removeClass("active");});
				$(this).addClass("active");
			});	
    });	
}


/* click 动作		jquery*/
function addActiveByClass(divName,classname){
	var allMainBarLi=$("#"+divName).find("."+classname);
	
	$(allMainBarLi).each(function(){
			$(this).click(function(){
				var allMainBarLi=$("#"+divName).find("."+classname).each(function() {$(this).removeClass("active");});
				$(this).addClass("active");
			});	
    });	
}





/*倒计时*/






/*返回上一页*/
function backToPrevious(){
	$(".backToPrevious").click(function(){
			history.go(-1);
			});
}

/*返回上一页*/


/*验证字数限制 剩余字数*/
function checktext(text){
   	allValid = true;
   	for (i = 0; i < text.length; i++){
   		if (text.charAt(i) != " "){
     		allValid = false;
     		break;
    	}
   }
	return allValid;
}

function gbcount(message,total,used){
	var max;
	max = total.value;
	if (message.value.length > max) {
		message.value = message.value.substring(0,max);
		used.value = max;
		
	}
	else {
		used.value = message.value.length;
	}
}
/*验证字数限制 剩余字数*/




/*验证字数限制*/
function getByteCount(str){
	return str.replace(/[^\x00-\xff]/g, "**").length;
	}
	var value;

function checkwords(obj,length){
	if(getByteCount(obj.value)>length){
		obj.value=value;
	}
	value=obj.value
	}
/*验证字数限制*/


/*发布约拍页面位置*/
function weizhi(){
	var aWidth = window.screen.availWidth; //   获取客户端分辨率的宽度
    var aHeight = window.screen.availHeight; //   获取客户端分辨率的高度
    var sWidth = document.body.scrollWidth; //    获取浏览器的宽度
    var sHeight = document.body.scrollHeight; //    获取浏览器的高度
    var tWidth = sWidth - aWidth;
    var tHeight = sHeight - aHeight;
    window.scrollTo((tWidth / 2), (310));
	}
/*发布约拍页面位置*/




//判断字符长度
function characterLength(s) {
	var length = 0;
	var blank = s.split("");
	for (var i=0;i<blank.length;i++) {
		if (blank[i].charCodeAt(0)<299) {
			length++;
		}
		else {
			length+=2;
		}
	}
return length;
}





	
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



//去掉字符串头尾空格   
function trim(str) {   
    return str.replace(/(^\s*)|(\s*$)/g, "");   
} 

















