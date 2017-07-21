$(function(){
	
	$.ajax({
	      type:"Post",
		  url: "frontlogin_getUserInfo.do",
		  data:"",		
		  success : function(data) {   
	          var userInfo=data.userInfoBeans;
	          var jewel=userInfo.jewel;
	          var star=userInfo.star;
	          var jewels="";
	          var stars="";
	          for(var i=0;i<jewel;i++){
	          jewels+='<img id="topBarUserOneDetailedimg" src="'+path+'/public/images/grade/uesrLogo.png"/>';  
	          }
              
	          for(var i=0;i<star;i++){
	        	  stars+= '<img src='+path+'/public/images/grade/diamond.png"/>';  
		          }
	          var chinaroles="";
	          var rol=userInfo.occupation;
	          if(rol!=""&&rol!=null){
	          var rols=rol.split("_");
	        
	          for(var i=0;i<rols.length;i++){
	        	  chinaroles+= '<span>'+rols[i]+'</span>&nbsp;|';
	        	  }
	          }else{ 
	        	  var chinaroles="职业暂无信息"; 
	          }
	          var sex=userInfo.sex;
	          if(sex==null||sex==""){
	        	  sex="暂无";
	          }
	          var workPlace=userInfo.workPlace;
	          if(workPlace==null){
	        	  workPlace="暂无";
	        	  
	          }
	          
	          var result='<div id="topBarUserOneDetailedOne">'+
	          jewels+stars+
              '<a href="javascript:" id="topBarUserOneComeZom">进入空间</a>'+
              '<a href="logout.do" id="topBarUserOneExit">退出登录</a>'+
              '</div>'+
              '<div id="topBarUserOneDetailedTwo">'+
          	  '<div id="topBarUserInfo">'+
              '<span>'+sex+'</span>&nbsp;&nbsp;|<span>'+workPlace+'</span>'+
              '</div>'+
              '<div id="topBarUserAccount">'+
              '<span>余额：</span>&nbsp;&nbsp;'+
              '<span is="topBarUserAccountYE">'+userInfo.moeny+'</span>'+
              '<a href="javascript:" id="topBarUserAccountcz">充值</a>'+
              '<a href="javascript:" id="topBarUserAccounttx">提现</a>'+
              '</div>'+
              '<div id="topBarUserPart">'+
              chinaroles+
              '</div>'+
              '</div>';
	          //alert(result);
	
	 $("#topBarUserOneDetailed").html(result);
	 
	 // 关注和粉丝
	 
	 var ganzhu='<div class="topBarUserTwo" id="topBarUserFollowed">'+
 	            '<p class="topBarUserTwoPOne">'+userInfo.userMess.attentionNumber+'</p>'+
                '<p class="topBarUserTwoPTwo">已关注</p>'+
                '</div>'+
                '<div class="topBarUserTwo" id="topBarUserFollower">'+
 	            '<p class="topBarUserTwoPOne">'+userInfo.userMess.fansNumber+'</p>'+
                '<p class="topBarUserTwoPTwo">粉丝</p>'+
                '</div>'+
                '<div class="topBarUserTwo" id="topBarUserGoodDiscuss">'+
 	            '<p class="topBarUserTwoPOne">'+userInfo.userMess.goodRemark+'</p>'+
                '<p class="topBarUserTwoPTwo">好评</p>'+
                '</div>'+
                '<div class="topBarUserTwo" id="topBarUserBadDiscuss">'+
 	            '<p class="topBarUserTwoPOne">'+userInfo.userMess.badRemark+'</p>'+
                '<p class="topBarUserTwoPTwo">差评</p>'+
                '</div>';
	 $("#topBarUserTwo").html(ganzhu);
	 $("#porperties")[0].src=userInfo.portrait;
	 if(userInfo.portrait==null){
		 
		 $("#porperties")[0].src=path+"/back/pubimg/porties.png" 
		 
	 }
	 var paixu='<p><span class="topBarUserThreeInOutComeAtt">收入排名</span><span class="topBarUserThreeInOutComeNum">暂无排序</span></p>'+
     '<p><span class="topBarUserThreeInOutComeAtt">支出排名</span><span class="topBarUserThreeInOutComeNum">暂无排序</span></p>';
	 $("#topBarUserThreeInOutCome").html(paixu);
				
				//alert(result)
			}
		});
});