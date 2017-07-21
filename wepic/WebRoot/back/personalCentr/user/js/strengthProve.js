$(function(){
	divLiBar2("mainbar","personalCenter");   //主导航背景底边框
	
	divLiBar("divTopBarContainer");   //展开头部右边详细
	
	userBuyCart();  				/*头部展开用户/购物车信息详细 */
	
	
//	divMyReHead
	//divLiBar("divMyReHead");				//查看头像
	ajaxGetUserPower("divMyReHead");
	projectHead("divContinueHead");				//查看头像
	
	
	
	divLiBar("divMyReWork");					//查看头像 代表作品
	
	divLiBar("divReProject");					//查看头像 代表作品项目
	
	divLiBar("divMyReHonor");					//查看头像 我的荣誉
	delPowerZuopinUser();
	
	editPowerZuopinUser();
	
	
	edit();									//显示删除和编辑承接的代表性项目
	
	edit2();
	
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


function edit2(){				
	var oDivEdit = document.getElementById("divMyHonor");
	var oDivEdttDiv=oDivEdit.getElementsByTagName("div");
	
	
	
		var getObj = [];
		for(var i=0;i<oDivEdttDiv.length;i++){
			if(oDivEdttDiv[i].className == 'cont'){
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
function closeOwnBox1(div){
	//alert("dddddddddddd");
	$("#greybackground").remove();
	$("#"+div).hide();
	//alert("ddddddddddddddd");
	}


/*关闭三级弹出框-iframe*/
function closeOwnBox(){
	//alert("dddddddddddd");
	//$("#greybackground").remove();
	$("#chooseWork").hide();
	//alert("ddddddddddddddd");
	}
/*关闭三级弹出框-iframe*/	
function closeOwnBoxHonor(){
	//$("#greybackground").remove();
	$("#chooseWork2").hide();
	}
	
function changeBox(hiddenDiv){
	
	cloosePopBox(hiddenDiv);		//隐藏二级div
	
	openPopUpBox('chooseWork');		//显示iframe div
	
	window.frames['child'].document.getElementById('hiddenv').value = hiddenDiv;			//传值给 iframe text
	}

function ajaxGetUserPower(divName){
		var mainDiv=document.getElementById(divName);
		if(mainDiv==null){
			
			return;
		}
		var allMainBarLi=mainDiv.getElementsByTagName("li");
		
		for(var i=0;i<allMainBarLi.length;i++){
			allMainBarLi[i].onmouseover = function(){
				
				for(var j=0;j<allMainBarLi.length;j++){
					allMainBarLi[j].className = "";
				}
				//delPowerZuopinUser(this);
				this.className="active";
				  var id=$(this).find("input").val();
                   $.ajax({
					type:"post",
					url:"userPower_getByUserPoweId.do",
					data:"id="+id,
					success:function(data){
                	  var type=data.userPower.name;
                	  var text="";
                	  if(type!=1){
                		  text="作品图片"
                		  
                	  }else{
                		  
                		  text="摄影故事"  
                	  }
                	   var href='<div class="one"><span class="cha">作 品 名：</span>'+
                		   '<span class="name">'+data.userPower.name+' </span>'+
                		   '<span class="cha">创作年份：</span>'+
                		   '<span class="year">'+data.userPower.entrytime+'</span>'+
                		   '<span class="cha">作品类型：</span>'+
                		   '<span class="type">'+text+'</span></div>'
                		   +'<div class="two"><span class="cha">作品说明：</span><span class="intt">'+data.userPower.entry+'</span></div><input type="button" onclick=openPopUpBox("divMyRePop"); class="add" value="添加作品代表">';
                	   $("#divMyRepresentative").find(".worksInfo").html(href);
                	   
				    }
				});
				
				
				
				
			};
			allMainBarLi[i].onmouseout = function(){
				for(var i=0;i<allMainBarLi.length;i++){
					this.className="";
				}
			};
		}
	}
	function  delPowerZuopinUser(){
		$("#divMyReHead").find(".del").each(function(){
			$(this).click(function(){
				if(confirm("您确定要删除这个代表作品吗?")){
					window.location.href="usperPower!deleteUserPower.do?id="+$($(this).parents("li")).find("input").val();
					}
				
				
			});
			
		});
		
		
		
		
	}
	//修改代表作品
	function  editPowerZuopinUser(){
		$("#divMyReHead").find(".edi").each(function(){
			$(this).click(function(){
				
				ajaxgetdaibiao($($(this).parents("li")).find("input").val());
				
			});
			
		});
	}
	
	function ajaxgetdaibiao(id){
		$("#divMyRePop").find("h2").html("修改代表作品");
		  $.ajax({
				type:"post",
				url:"userPower_getediteUserPoweId.do",
				data:"id="+id,
				success:function(data){
			   var userPower=data.userPower;
				$("#divMyRePop").find(".inputworkname").val(userPower.name);
				var type="图片作品";
				if(userPower.opustype!=2){
					type="摄影故事";
					
				}
			    $("#selectWorkTypeValue").html(type);
			    $("#selectCreYearValue").html(userPower.entrytime);
				$("#divMyRePop").find(".workIntro").find("textarea").val(userPower.entry);
				var htm="";
				var ids="";
				for(var i=0;i<userPower.userDetails.length;i++){
					if(i==0){
						ids=userPower.userDetails[i].name;
					}else{
						ids+=" "+userPower.userDetails[i].name;
						
					}
                    htm+='<li id="'+userPower.userDetails[i].name+'">'
					+'<div class="img">'
					+'<img src="back/pubimg/pic/'+userPower.userDetails[i].picUrl+'">'
					+'</div><div class="nowtop">'
					+'<div class="bj"></div>'
					+'<div class="bjc">'
					+'<a href="javascript:" class="del">'
					+'</a></div></div></li>';
					
				}
				$("#opusIds").val(ids);
				$("#divMyReWork").find("ul").css({"width":userPower.userDetails.length*132});
				$("#divMyReWork").find("ul").html(htm);
				$("#opusIds").parent().append('<input  type="hidden" name="id" value='+userPower.id+'>');
				$("#daibiaoform").attr("action","usperPower!updateUserPower.do");
				$("#opustypeId").val(userPower.opustype);
				$("#entrytime").val(userPower.entrytime);
				divLiBar("divMyReWork");
				delPic();
				openPopUpBox("divMyRePop");
				
		         }
		  });
		
		
		
	}
	
	
	function delPic(){
		
		  $("#divMyReWork a").each(function(){
	    	    $(this).click(function(){
	    	    	var orgId=$(this).parents("li").attr("id");
	    	    	 delHiddenInput(orgId);
	        	    $(this).parents("li").remove();
	        	   
	    	    });
	     });
		
		
	}
	function delHiddenInput(id){
		var newpicIds="";
		 var picIds=$("#opusIds").val().split(" ");
		 for(var i=0;i<picIds.length;i++){
			   if(picIds[i]!=id){
				   if(newpicIds==""){
					   newpicIds=picIds[i];
					   }else{
						   newpicIds+=" "+picIds[i];
						   }

				   }
			   }
		 
		 $("#opusIds").val(newpicIds)
		
	}
	
	
	
	
	
	function deldaibiaoPic(){
		
		  $("#divProjectPop a").each(function(){
	    	    $(this).click(function(){
	    	    	var orgId=$(this).parents("li").attr("id");
	    	    	 deldaibiaoHiddenInput(orgId);
	        	    $(this).parents("li").remove();
	        	   
	    	    });
	     });
		
		
	}
	function deldaibiaoHiddenInput(id){
		var newpicIds="";
		 var picIds=$("#divProjectPop").find("#opusIds").val().split(" ");
		 for(var i=0;i<picIds.length;i++){
			   if(picIds[i]!=id){
				   if(newpicIds==""){
					   newpicIds=picIds[i];
					   }else{
						   newpicIds+=" "+picIds[i];
						   }

				   }
			   }
		 
		 $("#divProjectPop").find("#opusIds").val(newpicIds);
		
	}
	
	function editeProject(id){	
		$("#divProjectPop").find("h2").html("修改代表作品");
		  $.ajax({
				type:"post",
				url:"userPower_getediteUserPoweId.do",
				data:"id="+id,
				success:function(data){
			   var userPower=data.userPower;
				$("#divProjectPop").find(".inputworkname").val(userPower.name);
				$("#divProjectPop").find(".workIntro").find("textarea").val(userPower.entry);
				$("#divProjectPop").find("#workIntroPersonALResblit").find("textarea").val(userPower.projectresponsibilities);
				$("#divProjectPop").find(".address").val(userPower.entryAdress);
				var htm="";
				var ids="";
				var startVa=userPower.entrytime;
				var startyea="";
				var startMonth="";
				if(startVa.indexOf("年")>-1&&startVa.indexOf("月")>-1){
					startyea=startVa.split("年")[0];
					startMonth=startVa.split("年")[1].split("月")[0];
				}
				$("#proYear").val(startyea);
				$("#proMonth").val(startMonth);
				var endVa=userPower.endTime;
				var endyea="";
				var endMonth="";
				//alert(endVa.indexOf("年"));
				if(endVa!=null&&endVa.indexOf("年")>-1&&endVa.indexOf("月")>-1){
					endyea=endVa.split("年")[0];
					endMonth=endVa.split("年")[1].split("月")[0];
					$("#proYearney").val(endyea);
					$("#proMonthnem").val(endMonth);
				}
				
				for(var i=0;i<userPower.userDetails.length;i++){
					if(i==0){
						ids=userPower.userDetails[i].name;
					}else{
						ids+=" "+userPower.userDetails[i].name;
						
					}
                  htm+='<li id="'+userPower.userDetails[i].name+'">'
					+'<div class="img">'
					+'<img src="back/pubimg/pic/'+userPower.userDetails[i].picUrl+'">'
					+'</div><div class="nowtop">'
					+'<div class="bj"></div>'
					+'<div class="bjc">'
					+'<a href="javascript:" class="del">'
					+'</a></div></div></li>';
					
				}
				$("#daibiaoproject").attr("action","usperPower!updateUserPower.do");
				$("#divProjectPop").find("#opusIds").val(ids);
				$("#divProjectPop").find("ul").css({"width":userPower.userDetails.length*132});
				$("#divProjectPop").find("ul").html(htm);
				$("#divProjectPop").find("#opusIds").parent().append('<input  type="hidden" name="id" value='+userPower.id+'>');
				$("#daibiaoform").attr("action","usperPower!updateUserPower.do");
				openPopUpBox("divProjectPop");
				divLiBar("divProjectPop");
				deldaibiaoPic();
		         }
		  });
		
	}
	function yongyu(){
		
		cloosePopBox('divHonorPop');		//隐藏二级div
		
		openPopUpBox('chooseWork2');		//显示iframe div
		
		window.frames['child2'].document.getElementById('hiddenv').value ="divHonorPop";		
	//	changeBox('divHonorPop')
		
	}
	function editeHoron(id){
		
		$("#divHonorPop").find("h2").html("修改获奖作品");
		  $.ajax({
				type:"post",
				url:"userPower_getediteUserPoweId.do",
				data:"id="+id,
				success:function(data){
			   var userPower=data.userPower;
				$("#divHonorPop").find(".inputworkname").val(userPower.name);
				$("#divHonorPop").find(".workIntro").find("textarea").val(userPower.entry);
				$("#divHonorPop").find("#inputawardsibputry").val(userPower.awardwinningworks);
				$("#divHonorPop").find("#inputissueibputry").val(userPower.ssuedbytheorganization);
				$("#divHonorPop").find("#inputtimeibputry").val(userPower.entrytime);
				$("#divHonorPop").find("#inputaddibputry").val(userPower.ssuedAddress);
				var htm="";
				var ids="";
				for(var i=0;i<userPower.userDetails.length;i++){
				//	alert(i);
					if(i==0){
						ids=userPower.userDetails[i].name;
					}else{
						ids+=" "+userPower.userDetails[i].name;
						
					}
                htm+='<li id="'+userPower.userDetails[i].name+'">'
					+'<div class="img">'
					+'<img src="back/pubimg/pic/'+userPower.userDetails[i].picUrl+'">'
					+'</div><div class="nowtop">'
					+'<div class="bj"></div>'
					+'<div class="bjc">'
					+'<a href="javascript:" class="del">'
					+'</a></div></div></li>';
					
				}
				$("#divHonorPop").attr("action","usperPower!updateUserPower.do");
				$("#divHonorPop").find("#honorpicId").val(ids);
				$("#divHonorPop").find("ul").css({"width":userPower.userDetails.length*132});
				$("#divHonorPop").find("ul").html(htm);
				$("#divHonorPop").find("#honorpicId").parent().append('<input  type="hidden" name="id" value='+userPower.id+'>');
				$("#honorFormIds").attr("action","usperPower!updateUserPower.do");
				openPopUpBox("divHonorPop");
				// divLiBar("divProjectPop");
				// deldaibiaoPic();
		         }
		  });
		  
		
		
		
	}
	
	
	
	function openDiv(divId){
		openPopUpBox(divId);
	//	$("#"+divId).find("form").reset();
		
	}
	