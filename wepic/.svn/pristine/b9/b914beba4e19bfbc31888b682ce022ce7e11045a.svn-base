<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="shortcut icon" href="${pageContext.request.contextPath}/public/images/logoSmall.ico"/>

<title>wepic管理_个人中心_我的作品库_图片作品</title>


<script type="text/javascript" src="<%=basePath %>public/js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath %>back/personalCentr/myworklib/js/picWork.js"></script>


<!--公共fjs-->
<script type="text/javascript" src="<%=basePath %>back/js/publicBack.js"></script>
<script type="text/javascript" src="<%=basePath %>public/js/public.js"></script>
<script type="text/javascript" src="<%=basePath %>public/js/topBar.js"></script>
<script type="text/javascript" src="<%=basePath %>public/js/header.js"></script>
<script type="text/javascript" src="<%=basePath %>/back/js/ajaxforUserInfo.js"></script>

<!--公共css1111-->
<link type="text/css" rel="stylesheet" href="<%=basePath %>public/css/backMainBar.css" />
<link type="text/css" rel="stylesheet" href="<%=basePath %>public/css/topBarMain.css" />
<link type="text/css" rel="stylesheet" href="<%=basePath %>public/css/header.css" />
<link type="text/css" rel="stylesheet" href="<%=basePath %>public/css/footer.css" />
<link type="text/css" rel="stylesheet" href="<%=basePath %>public/css/public.css" />


<link type="text/css" rel="stylesheet" href="<%=basePath %>back/personalCentr/myworklib/css/picWork.css" />
<script type="text/javascript">
  $(function(){
	  var sp='<s:property value="specialName"/>';
	  if(sp==''){
          sp="默认专辑";
		  }else{
			  getImgSUnm('<s:property value="specalCatId"/>');
			  }
	  
        $("#selectdespecialValue").html(sp);
    	$.ajax({
  	      type:"Post",
  		  url: "specialcat_getpublishSpecialCats.do",
  		  data:"",		
  		  success : function(data) {
  	  		  
  	  	  var list=data.publishSpecialCats;
  	  	  var html='';
  	  	  for(var i=0;i<list.length;i++){
  	  	  	  publishCat=list[i];
  	  	  	  if(publishCat.type=='isDefault'){
  	  	  	    getImgSUnm(publishCat.id);
  	  	  	 $("#specalCatId").val(publishCat.id);
        	 $("#specialName").val(publishCat.name);

  	  	  	  	  }
  	  		html+='<span class="selectValueIn" id='+publishCat.id+'>'+publishCat.name+'</span>';
  	  	  	  } 
              // selectdespecialValue
  	  	    $("#divSelectdespecialValue").html(html);
  	  	    achieveBelow("divSelectdespecialValue","selectdespecialValue");
  	  		   
  		  }
    	});

       $("#divSelectdeCategoryValue").find("span").each(function(){
               $(this).click(function(){
            	  getCat($(this).attr("id"));
            	 $("#publishParentTypeId").val($(this).attr("id"));
            	 $("#publishParentTypeName").val(this.innerHTML);
            	 $("#publishTypeId").val("");
            	 $("#publishTypeName").val("");
            	    
            	 // selectdeCategoryValue 
            	 $("#selectdeCategoryValue").html(this.innerHTML);
     			 $("#divSelectdeCategoryValue").hide();
     			 searchByterm();
     			// $("#divSelectdeCategoryValue").parent().parent().css("z-index","0");//rrrr
                 });
 

           });
          //  searchByterm();

         $("#divSelectdeStateValue").find("span").each(function(){
          $(this).click(function(){
              $("#publishStaute").val($(this).attr("id"));
              $("#publishStauteName").val($(this).html());
              $("#selectdeStateValue").html($(this).html());
              $("#divSelectdeStateValue").hide();
              searchByterm();
              });
             });
          searchBack();
         


       
        });
  function getCat(id){

		$.ajax({
		      type:"Post",
			  url: "projectCat_getTypeCat.do",
			  data:"id="+id,		
			  success : function(data) { 
	         var html="";
	         for(var i=0;i<data.publishChiledCats.length;i++){
	           var cat=data.publishChiledCats[i];
	           html+='<span class="selectValueIn" onclick="hideType(this)" id='+cat.id+'>'+cat.name+'</span>';
	             }
	          $("#divSelectdeTypeValue").html(html);
	          
	         // $("#divAddReTagPersonrr").html("");ssss
				// $("#hiddenReTassgs").val("");ee sss
				    
			  }
		});
  }

    function getImgSUnm(id){
    	$.ajax({
    	      type:"Post",
    		  url: "jsonpublish_findbyCountBySpecialCat.do",
    		  data:"publishSpecialCatId="+id,		
    		  success : function(data) {
              var c=data.count;
    	  	$("#totalPic").html(c[0]);
    	  	$("#fabutotalPic").html(c[1]);
    		  }
      	});
        }
    
    function achieveBelow(bolewDiv,showValue){
    	var bolewDiv=document.getElementById(bolewDiv);
    	var bolewDivSpan=bolewDiv.getElementsByTagName("span");
    	/*alert("11");*/
    				
    	for(var i=0;i<bolewDivSpan.length;i++){
    		   bolewDivSpan[i].onclick=function (){
    			/*document.getElementById(showValue).innerHTML = this.innerHTML;*/
    			 getImgSUnm($(this).attr("id"));

    			 $("#specalCatId").val($(this).attr("id"));
            	 $("#specialName").val(this.innerHTML);
            	 searchByterm();
    			//swfupload.addPostParam("publishSpecialCatIssd",$(this).attr("id"))ss
    			
    			$("#"+showValue).html(this.innerHTML);
    			$(bolewDiv).hide();
    			$(bolewDiv).parent().parent().css("z-index","0");
    			};
    		}
    }
function hideType(obj){
$("#selectdeTypeValue").html($(obj).html());
$("#divSelectdeTypeValue").hide();
$("#publishTypeId").val($(obj).attr("id"));
$("#publishTypeName").val($(obj).html());
searchByterm();


} 
    //提交查询
    function searchByterm(){
        $("#searchByTermfromMylib").submit();
        }
 function searchBack(){
     var parenttype='<s:property value="publishParentTypeName"/>';
     if(parenttype==''){
    	 parenttype="所有类别";
         }else{
        	 getCat('<s:property value="publishParentTypeId"/>');
             }
     $("#selectdeCategoryValue").html(parenttype);
     

     var type='<s:property value="publishTypeName"/>';
     if(type==''){
    	 type="所有类型";
         }
     $("#selectdeTypeValue").html(type);

     var staut='<s:property value="publishStauteName" escape="false"/>';
     if(staut==''){
    	 staut="作品状态";
         }
     $("#selectdeStateValue").html(staut);
     $("#publishStauteName").val(staut);
	 

	 }
//ddd

    
</script>




</head>

<body>
<div id="container">
	<div id="topBar">
	<div id="topbar">
    	<div id="topcenterbar">
    		<div id="topbar-collect">
    			<a id="topcollect" href="javascript:addToFavorite('http://www.wepic.cn/','唯图网_商业拍摄 原创商业图片交易平台')">
                	<span>收藏唯图</span>			
        		</a>
       		</div>
        	<div id="topbar-toolbar">
    			
                <div id="divTopBarUesr">
                	<div id="topBarUser">
                    	<a href="javascript:"><span>
                    	<s:property value="#session.nickName"/>
                    	</span><i></i></a>
                    </div>
                    
                	<div id="topBarUserDetailed">
                    	<div id="topBarUserOne">
                        	<div id="topBarUserOneHead">
                            	<img src="${pageContext.request.contextPath}/public/images/pic/topUser.jpg"  id="porperties"/>
                                <div id="topBarUserOneHeadChange">
                                	<div><a href="javascript:">更改头像</a></div>
                                </div>
                            </div>
                            <div id="topBarUserOneDetailed">
                            	<div id="topBarUserOneDetailedOne">
                                	<img id="topBarUserOneDetailedimg" src="${pageContext.request.contextPath}/public/images/grade/uesrLogo.png"/>
                                    <img src="${pageContext.request.contextPath}/public/images/grade/diamond.png"/>
                                    <img src="${pageContext.request.contextPath}/public/images/grade/diamond.png"/>
                                    <img src="${pageContext.request.contextPath}/public/images/grade/star.png"/>
                                    <img src="${pageContext.request.contextPath}/public/images/grade/star.png"/>
                                    <img src="${pageContext.request.contextPath}/public/images/grade/star.png"/>
                                    <a href="javascript:" id="topBarUserOneComeZom">进入空间</a>
                                    <a href="javascript:" id="topBarUserOneExit">退出登录</a>
                                </div>
                                <div id="topBarUserOneDetailedTwo">
                                	<div id="topBarUserInfo">
                                    	<span>男</span>&nbsp;&nbsp;|<span>中国</span><span>上海</span><span>嘉定</span>
                                    </div>
                                    <div id="topBarUserAccount">
                                    	<span>余额：</span>&nbsp;&nbsp;
                                        <span is="topBarUserAccountYE">888888888</span>
                                        <a href="javascript:" id="topBarUserAccountcz">充值</a>
                                        <a href="javascript:" id="topBarUserAccounttx">提现</a>
                                    </div>
                                    <div id="topBarUserPart">
                                    	<span>用户</span>&nbsp;|
                                        <span>摄影师</span>&nbsp;|
                                        <span>模特</span>&nbsp;|
                                        <span>经纪人</span>
                                    </div>
                                </div>
                            </div>
                            
                            <div id="topBarUserTwo">
                            	<div class="topBarUserTwo" id="topBarUserFollowed">
                                	<p class="topBarUserTwoPOne">4546544</p>
                                    <p class="topBarUserTwoPTwo">已关注</p>
                                </div>
                                <div class="topBarUserTwo" id="topBarUserFollower">
                                	<p class="topBarUserTwoPOne">87987987</p>
                                    <p class="topBarUserTwoPTwo">粉丝</p>
                                </div>
                                <div class="topBarUserTwo" id="topBarUserGoodDiscuss">
                                	<p class="topBarUserTwoPOne">666666</p>
                                    <p class="topBarUserTwoPTwo">好评</p>
                                </div>
                                <div class="topBarUserTwo" id="topBarUserBadDiscuss">
                                	<p class="topBarUserTwoPOne">7777777</p>
                                    <p class="topBarUserTwoPTwo">差评</p>
                                </div>
                                
                                
                            </div>
                            
                            <div id="topBarUserThree">
                                	<div id="topBarUserThreeInOutCome">
                                    	<p><span class="topBarUserThreeInOutComeAtt">收入排名</span><span class="topBarUserThreeInOutComeNum">454545</span></p>
                                        <p><span class="topBarUserThreeInOutComeAtt">支出排名</span><span class="topBarUserThreeInOutComeNum">4545</span></p>
                                    </div>
                                    <div id="topBarUserThreePersonalManagement">
                                    	<input type="button" value="个人管理中心" />
                                    </div>
                                </div>
                        </div>
                    </div>
                </div>
            	<div id="divTopBarShopping">    
                    	<div id="topBarShopping">
                    		<a href="#" id="topshopping">购物车<span>888</span>件<i></i></a>
                    	</div>
                        
                        <div id="topBarShoppingDetailed">
                        	<ul>
                            <li>
                            	<div class="topBarShoppingDetailedHead">
                            		<img src="${pageContext.request.contextPath}/public/images/pic/topUser.jpg"/>
                           		</div>
                            
                            	<div class="topBarShoppingDetailedOpert">
                                	<p class="topBarShoppingDetailedOpertPOne">
                                    	<span>作品标题锦屏1</span>
                                        <b class="topBarShoppingDetailedOpertPOneExit" onclick="topBarShoppingDetailedOpertPOneExit(this)">×</b>
                                    </p>
                                    <p class="topBarShoppingDetailedOpertPTwo">编号：
                                    	<span>4445454464564</span>
                                        <span class="topBarShoppingDetailedOpertPTwoPice">21221</span>
                                    </p>
                                </div>
                            </li>
                            
                            <li>
                            	<div class="topBarShoppingDetailedHead">
                            		<img src="${pageContext.request.contextPath}/public/images/pic/topUser.jpg"/>
                           		</div>
                            
                            	<div class="topBarShoppingDetailedOpert">
                                	<p class="topBarShoppingDetailedOpertPOne">
                                    	<span>作品标题锦屏2</span>
                                        <b class="topBarShoppingDetailedOpertPOneExit" onclick="topBarShoppingDetailedOpertPOneExit(this)">×</b>
                                    </p>
                                    <p class="topBarShoppingDetailedOpertPTwo">编号：
                                    	<span>4445454464564</span>
                                        <span class="topBarShoppingDetailedOpertPTwoPice">21221</span>
                                    </p>
                                </div>
                            </li>
                            <li>
                            	<div class="topBarShoppingDetailedHead">
                            		<img src="${pageContext.request.contextPath}/public/images/pic/topUser.jpg"/>
                           		</div>
                            
                            	<div class="topBarShoppingDetailedOpert">
                                	<p class="topBarShoppingDetailedOpertPOne">
                                    	<span>作品标题锦屏3</span>
                                        <b class="topBarShoppingDetailedOpertPOneExit" onclick="topBarShoppingDetailedOpertPOneExit(this)">×</b>
                                    </p>
                                    <p class="topBarShoppingDetailedOpertPTwo">编号：
                                    	<span>4445454464564</span>
                                        <span class="topBarShoppingDetailedOpertPTwoPice">21221</span>
                                    </p>
                                </div>
                            </li>
                            <!--<li><img src="images/pic1/topUser.jpg"/></li>
                            <li><img src="images/pic1/topUser.jpg"/></li>-->
                            </ul>
                            
                            <div id="topBarShoppingDetailedFoot">
                            	<input type="button" value="查看购物车">
                            </div>
                        </div>     
                </div>
                
                <div id="divTopBarContainer"> 
                	<ul>
                    	<li>
                        	<div id="divTopBarWorks">
                            	<div id="topBarWorks" class="topBarContainer">
                                	<a href="javascript:"><span>我的作品</span></a>
                                </div>
                            	
                                <div id="divTopBarWorksDetailed" class="topBarDetailed">
                                	<p><a href="javascript:">我的作品库</a></p>
                                    <p><a href="javascript:">我买到的作品</a></p>
                                    <p><a href="javascript:">我出售的作品</a></p>                                   
                                </div>
                            </div> 
                        </li>
                        
                        
                        <li>
                        	<div id="divTopBarPats">
                            	<div id="topBarPats" class="topBarContainer">
                                	<a href="javascript:"><span>我的约拍</span></a>
                                </div>
                            	
                                <div id="divTopBarPatsDetailed" class="topBarDetailed">
                                	<p><a href="javascript:">新约拍项目</a></p>
                                    <p><a href="javascript:">我发布的约拍</a></p>
                                    <p><a href="javascript:">应约中的约拍</a></p>  
                                    <p><a href="javascript:">约拍日程</a></p>
                                    <p><a href="javascript:">约拍记录</a></p>                                 
                                </div>
                            </div> 
                        </li>
                        
                        <li>
                        	<div id="divTopBarInform">
                            	<div id="topBarInform" class="topBarContainer">
                                	<a href="javascript:"><span>消息中心</span>
                                    	<i></i>
                                    </a>
                                </div>
                            	
                                <div id="divTopBarInformDetailed" class="topBarDetailed">
                                	<p><a href="javascript:">查看粉丝</a></p>
                                    <p><a href="javascript:">查看评价</a></p>
                                    <p><a href="javascript:">交易提醒</a></p>  
                                    <p><a href="javascript:">日程提醒</a></p>
                                    <p><a href="javascript:">被邀提醒</a></p> 
                                    <p><a href="javascript:">有新应约者</a></p>  
                                    <p><a href="javascript:">经纪人申请</a></p>
                                    <p><a href="javascript:">系统通知</a></p>                                
                                </div>
                            </div> 
                        </li>
                        
                        
                        <li>
                        	<div id="divTopBarUpload">
                            	<div id="topBarUpload" class="topBarContainer">
                                	<a href="javascript:"><span>上传作品</span></a>
                                </div>
                            	
                                <div id="divTopBarUploadDetailed" class="topBarDetailed">
                                	<p><a href="javascript:">上传到作品库</a></p>
                                    <p><a href="javascript:">发布图片</a></p>
                                    <p><a href="javascript:">发布摄影故事</a></p>  
                                    <p><a href="javascript:">发布视频</a></p>                                
                                </div>
                            </div> 
                        </li>
                        
                        
                        <li>
                        	<div id="divTopBarPublish">
                            	<div id="topBarPublish" class="topBarContainer">
                                	<a href="javascript:"><span>发布约拍</span></a>
                                </div>
                            	
                                <div id="divTopBarPublishDetailed" class="topBarDetailed">
                                	<p><a href="javascript:">发布约拍的项目</a></p>
                                    <p><a href="javascript:">招募摄影师</a></p>
                                    <p><a href="javascript:">招募模特</a></p>  
                                    <p><a href="javascript:">发布征集作品项目</a></p>                                
                                </div>
                            </div> 
                        </li>
                    </ul>
                </div>
            	<!--<a href="#" id="topworks">我的作品</a>
            	<a href="#" id="toppats">我的约拍</a>
           	 	<a href="#" id="topinform">消息中心</a>
            	<a href="#" id="topupload">上传作品</a>
            	<a href="#" id="toppublish">发布约拍</a>-->
        	</div>
        </div>
    </div> 
	</div>
    
<!-- 头部结束-->
	
    <!-- logo行-->
	<div id="header">
    	<div id="headerCenter">
        	<div id="divlogo">
    			<a id="imgLogo" href="http://www.wepic.cn/" target="_self" title="唯图网_商业拍摄 原创商业图片交易平台">
    				<img src="${pageContext.request.contextPath}/public/images/wepic_logo.png" alt="唯图网"/>
        			<p><span id="spanLogo">商业拍摄</span><span>原创商业图片交易平台</p>
   				</a>
    		</div>
            <div id="divKeyWord">
                    	<input id="inputkeyword" type="text" value="搜索" 
                    		onfocus="searchonfocus();" onblur="searchonblur()"/>
            </div>
                   
            <div id="divSelect">
                    <input  type="text" value="选择类型"  onclick="hide('selectValue')" 
                    		id="inputselect" class="inputselect" readonly="value"/>
                           
                    <div id="selectValue" style="display:none;" class="selectValue" onmouseout="hidemouseout('selectValue')" onmouseover="hidemouseover('selectValue')">
  						<span id="a1" onclick="pick('测试一','inputselect','selectValue')" onmouseover="bgcolor('a1')" 
                        	onMouseOut="nocolor('a1')" class="cur">测试一</span> 
  						<span id="a2" onclick="pick('测试二','inputselect','selectValue')" onMouseOver="bgcolor('a2')" 
                        	onMouseOut="nocolor('a2')" class="cur">测试二</span> 
  						<span id="a3" onclick="pick('测试三','inputselect','selectValue')" onMouseOver="bgcolor('a3')" 
                        	onMouseOut="nocolor('a3')" class="cur">测试三</span> 
  						<span id="a4" onclick="pick('测试四','inputselect','selectValue')" onMouseOver="bgcolor('a4')" 
                       		onMouseOut="nocolor('a4')" class="cur">测试四</span> 
 						<span id="a5" onclick="pick('测试五','inputselect','selectValue')" onMouseOver="bgcolor('a5')" 
                        	onMouseOut="nocolor('a5')" class="cur">测试五</span> 
 	    				<span id="a6" onclick="pick('测试六','inputselect','selectValue')" onMouseOver="bgcolor('a6')" 
                        	onMouseOut="nocolor('a6')" class="cur">测试六</span>            
 					</div>
                    
            </div>
            
            <div id="divButtonSecrch">
            	<div id="buttonsearch"></div>
            </div>
            
            <div id="divSeniorSecrch">
            	<input type="button" value="高级搜索" id="higtsearch"/>
            </div>
       </div>
	</div>
    
    <!-- 分割线 	样式在	registerLogin.css-->
    <div id="divSeparation">
    	<div id="divSeparation2">
        	<div id="divSeparation3">
            	<div id="divSeparation4">
                	<div id="divSeparation5">
                    </div>
                </div>
        	</div>
        </div>
    </div>
    <!-- 分割线over -->
    
    <!-- logo行-->
    
    <div id="mainbar">
    	<div id="mainbarCenter">
    		<ul>
        		<li id="personalCenter" class="active">
            		<a href="<%=basePath %>user!getFistPageUserInfo.do">个人中心</a>
            	</li>
            	<li id="configureCenter">
            		<a href="<%=basePath %>configure!securityIndex.do">配置中心</a>
            	</li>
            	<li id="inforCenter">
            		<a href="javascript:void(0)">消息中心</a>
           	 	</li>
            	<li id="myRoom">
            		<a href="javascript:void(0)">我的空间</a>
            	</li>
        	</ul>
        </div>
	</div>
    
	<!-- logo行 end-->
	
     <!-- 导航 -->
  	<div id="assistantBar">
    	<div class="twoStage" id="divTwoStage">
        	<a href="<%=basePath %>user!getFistPageUserInfo.do"><div class='bar'><span>首页</span><i></i></div></a>
            
            <a href="<%=basePath %>user!baseUseInfo.do?message=all"><div class='bar'><span>账户基本资料</span><i></i></div></a>
            
            <a href="<%=basePath %>publish!findAllMyLib.do"><div class='bar active'><span>我的作品库</span><i></i></div></a>
            
            <a href="<%= basePath%>catBid!findByrootType.do"><div class='bar'><span>我的约拍</span><i></i></div></a>
            
            <a href="javascript:"><div class='bar'><span>我买到的作品</span><i></i></div></a>
            
           <a href="javascript:"> <div class='bar'><span>收藏/订阅/推荐</span><i></i></div></a>
        </div>
    	
        <div id="divThreeStage">
        
        <div class="threeStage">
        	<a href="javascript:"><div class='bar'><span>作品库概况</span><i></i></div></a>
            
            <a href="<%=basePath %>publish!findAllMyLib.do"><div class='bar active'><span>图片作品</span><i></i></div></a>
            
            <a href="<%=basePath %>story!storylist.do"><div class='bar'><span>摄影故事</span><i></i></div></a>
            
            <a href="javascript:"><div class='bar'><span>视频作品</span><i></i></div></a>
            
            <a href="${pageContext.request.contextPath}/back/personalCentr/myworklib/workUpload.jsp"><div class='bar'><span>上传作品</span><i></i></div></a>
            
            <a href="<%=basePath %>story!initdata.do"><div class='bar'><span>创建故事</span><i></i></div></a>
            
            <a href="${pageContext.request.contextPath}/back/personalCentr/myworklib/chooseRelWork.jsp"><div class='bar'><span>发布作品</span><i></i></div></a>
        </div>
        </div>
    </div>
    <!-- 导航  end-->
    
    <!--内容-->
    <div id="divPicWork">
   		<div class="head">
        
        	<!--编辑-->
        	<div class="edit">
            	<form action="searchPublishPic!searchByTermfromMylib.do" method="post" id="searchByTermfromMylib">
            	<input type="hidden" name="specalCatId"  id="specalCatId" value="<s:property value="specalCatId"/>"/>
            	<input type="hidden" name="specialName"  id="specialName" value="<s:property value="specialName"/>"/>
            	<input type="hidden" name="publishParentTypeId"  id="publishParentTypeId" value="<s:property value="publishParentTypeId"/>"/>
            	<input type="hidden" name="publishParentTypeName"  id="publishParentTypeName" value="<s:property value="publishParentTypeName"/>"/>
            	<input type="hidden" name="publishTypeId"  id="publishTypeId" value="<s:property value="publishTypeId"/>"/>
            	<input type="hidden" name="publishTypeName"  id="publishTypeName" value="<s:property value="publishTypeName"/>"/>
            	<input type="hidden" name="publishStaute"  id="publishStaute" value="<s:property value="publishStaute"/>"/>
            	<input type="hidden" name="publishStauteName"  id="publishStauteName" value="<s:property value="publishStauteName"/>"/>
            	</form>
            	
            	
            	
            	
            		<div class="editSelect" id="divdespecial">
                    	<div class="viewBelow" onclick="showBelow('divSelectdespecialValue')" id="viewBelowdespecial">
                        	<div id="selectdespecialValue">默认专辑</div>
                       		<div class="viewBelowRight"><i></i></div>    
                    	</div>
                           
                    	<div class="belowValue" id="divSelectdespecialValue" style="display:none;">
                        	<span class='selectValueIn'>请选择</span>
                        	
 						</div>
            		</div>
               
               
              	<div class="char">
              	  
              	
              	
              	
              	
              	
               		<a href="specialPublish!findSpecialByUser.do" class="glz">管理专辑</a>
               		<span class="sp1">当前专辑作品数</span>
                    <span class="num" id="totalPic">0</span>张
                    
                    <span class="sp2">已发布</span>
                    <span class="num" id="fabutotalPic">0</span>张
               	</div>
               
               	<div class="inp">
               		<input class="inputup" type="button" value="上传作品" onclick="location.href='${pageContext.request.contextPath}/back/personalCentr/myworklib/workUpload.jsp'"/>
					<input class="finished" type="button" value="发布作品" onclick="location.href='${pageContext.request.contextPath}/back/personalCentr/myworklib/chooseRelWork.jsp'"/>
               	</div>
        	</div>
            <!--编辑s-->
            
            <!--排序-->
            
            <div class="sort">
            	<span class="sp1">筛选：</span>
                
                <div class="editSelect" id="divCategory">
                    	<div class="viewBelow" onclick="showBelow('divSelectdeCategoryValue')" id="viewBelowdeCategory">
                        	<div id="selectdeCategoryValue">所有类别</div>
                       		<div class="viewBelowRight"><i></i></div>    
                    	</div>
                           
                    	<div class="belowValue" id="divSelectdeCategoryValue" style="display:none;">
                        	<span class='selectValueIn'>所有类别</span>
                        	<span class='selectValueIn' id="2">创意图片</span>
                            <span class='selectValueIn' id="1">摄影图片</span>
 						</div>
            	</div>
                
                
                
                <div class="editSelect" id="divType" style="display: none">
                    	<div class="viewBelow" onclick="showBelow('divSelectdeTypeValue')" id="viewBelowdeType">
                        	<div id="selectdeTypeValue">所有类型</div>
                       		<div class="viewBelowRight"><i></i></div>    
                    	</div>
                           
                    	<div class="belowValue" id="divSelectdeTypeValue" style="display:none;">
                        	<span class='selectValueIn'>请选择</span>
 						</div>
            	</div>
                
                <div class="editSelect" id="divState">
                    	<div class="viewBelow" onclick="showBelow('divSelectdeStateValue')" id="viewBelowdeState">
                        	<div id="selectdeStateValue">作品状态</div>
                       		<div class="viewBelowRight"><i></i></div>    
                    	</div>
                           
                    	<div class="belowValue" id="divSelectdeStateValue" style="display:none;">
                        	<span class='selectValueIn'>所有状态</span>
                            <span class='selectValueIn' id="1">未发布</span>
                            <span class='selectValueIn' id="2">已发布为仅展示</span>
                            <span class='selectValueIn' id="3">已发布为可销售</span>
                            <span class='selectValueIn' id="4">已下架</span>
                            <span class='selectValueIn' id="5">审核未通过</span>
 						</div>
            	</div>
                
                <span class="sp2">默认排序：上传时间</span>
                
                <!--<div class="viewType">
                	<span>显示方式：</span>
                    <a href="javascript:" class="view1"></a>
                    <a href="javascript:" class="view2"></a>
                </div>-->
            </div>
            
            <!--排序-->
        </div>
            
        </div>
        
        
        
        
        
        <!--图片内容-->
        <div id="picWorkContent">
        	<div class="picWorkContentUl">
        		<ul>
        		
            	
                    
                	<!--已发布为仅展示-->
                    
                    <s:iterator value="pager.resultList" var="publish">
                    
                     
                	<!--已发布为可出售-->
                	<s:if test="#publish.publishStatus.onOffer==1">
                    <li>
                    	
                    	<div class="picWorkContentLi">
                        	<!--默认显示-->
                        	
                            <div class="defaultView">
                    		<div class="photographyStoryLiHead">
                        		<img src="<s:property value="thumbnailUrl"/>" />
                       	 	</div>
                        	
                            </div>
                        	<!--默认显示-->
                            
                              <s:if test="#publish.publishStatus.pass==1">
                            <!-- 图片右上角显示-->
                            
                            <s:if test="#publish.publishStatus.adminSoldout!=1&&#publish.publishStatus.copyrightBuyout!=1&&#publish.publishStatus.userSoldout!=1">
                          
                            <!-- 图片右上角显示-->
                            <div class="divOnlyView">
                                <div class="onlyView">
                                	<div class="bj"></div>
                                    <div class="bjccs"></div>
                                </div>
                               
                                <div class="onlyViewChar">
                                	<div class="sanjiao"> </div>
                                	<div class="sp">已发布为可出售</div>
                                </div>
                               
                            </div>
                            <!-- 图片右上角显示-->
                             </s:if>
                            </s:if>
                            <!--鼠标滑过显示-->
                            <div class="nowtop">
                        		<div class="bj"></div>
                        		<div class="bjc">
                        			<div class="picInf">
                                    	<div class="ifone"><span class="name" title="<s:property value="name"/>">
                                    	<s:property value="name"/>
                                    	
                                    	</span></div>
                                        <div class="iftwo">作品编号：
                                        <span class="worknum">
                                        <s:property value="picNumber"/>
                                        </span>
                                        
                                                                      <s:if test="#publish.publishStatus.pass!=1">
                                                                      <s:if test="#publish.publishStatus.noPass==0">
                                                                      <span class="orange">审核中</span>
                                                                      </s:if>  
                                                                      <s:if test="#publish.publishStatus.noPass==1">
                                                                      <span class="red">审核未通过</span>
                                                                       </s:if>  
                                                                      </s:if> 
                                                                      
                                                                      <s:if test="#publish.publishStatus.adminSoldout==1">
                                                                      <span class="red">被管理员下架</span>
                                                                      </s:if>
                                                                      <s:elseif test="#publish.publishStatus.copyrightBuyout==1">
                                                                      <span class="orange">被下架</span>
                                                                      </s:elseif>
                                                                       <s:elseif test="#publish.publishStatus.userSoldout==1">
                                                                      <span class="grey">已下架</span> 
                                                                      </s:elseif>                      
                                        </div>
                                        <div class="ifthree">
                                        	<a class="time" title="上传时间"><span><s:property value="upTime"/></span></a>
                                        	<a class="time2" title="发布时间">
                                        	
                                        	<span>
                                        	<s:date name="publishTime" format="yyyy-MM-dd"/>
                                        	
                                        	
                                        	
                                        	
                                        	</span></a>
                                        </div>
                                    </div>
                                    <s:if test="#publish.publishStatus.noPass!=1">
                                    <div class="picUser">
                                    	<div class="vcg">
                                        	<a class="view" title="浏览次数"><s:property value="hit"/></a>
                                        	<a class="collect" title="收藏次数">0</a>
                                        	<a class="good" title="推荐次数">0</a>
                                        </div>
                                        <s:if test="#publish.publishStatus.adminSoldout!=1&&#publish.publishStatus.copyrightBuyout!=1&&#publish.publishStatus.userSoldout!=1">
                                    	<div class="usti">使用权<span class="syq"><s:property value="usagePrice"/></span>元<span class="sp2">已出售</span><span class="syq">121</span>次</div>
                                    	<div class="usti">版权<span class="syq"><s:property value="copyrightPrice"/></span>元<span class="sp2">未出售</span></div>
                                        </s:if>
                                        
                                         <s:if test="#publish.publishStatus.copyrightBuyout==1&&#publish.publishStatus.adminSoldout!=1">
                                        <div class="bqmd">
                                        	<span class="orange">版权被买断</span>
                                        </div>
                                        </s:if>
                                        <s:if test="#publish.publishStatus.adminSoldout==1">
                                        
                                        <div class="divNoPassRea">
                                        
                                         <s:iterator value="resons" id="reson">
                                            <div class="rea"><s:property value="reson"/></div>
                                          
                                            </s:iterator>
                                    </div>
                                        
                                        
                                        
                                        
                                        </s:if>
                                        
                                        
                                    </div>
                                    </s:if>
                                    <s:else>
                                    
                                    <div class="divNoPassRea">
                                        
                                         <s:iterator value="resons" id="reson">
                                            <div class="rea"><s:property value="reson"/></div>
                                          
                                            </s:iterator>
                                    </div>
                                    
                                    
                                    
                                    
                                    </s:else>
                                    
                                    <div class="picEdit">
                                       <s:if test="#publish.publishStatus.adminSoldout==1||#publish.publishStatus.copyrightBuyout==1||#publish.publishStatus.userSoldout==1||#publish.publishStatus.pass!=1">
                                       
                                      <a class="del" href="publish!deletePublishPic.do?id=<s:property value="id"/>" title="删除作品"></a>
                                      </s:if>
                                     
                                      <s:else>
                                        <a class="xj" href="publish!userSoldout.do?id=<s:property value="id"/>" title="作品下架"></a>
                                     
                                      </s:else>
                                        <a class="down" title="下载作品" href="publish!downloadPic.do?id=<s:property value="id"/>"></a>
                                        
                                      <s:if test="#publish.publishStatus.adminSoldout==1||#publish.publishStatus.copyrightBuyout==1||#publish.publishStatus.userSoldout==1||#publish.publishStatus.pass!=1">
                                         <a class="edit" href="  publish!findEditeUnPublish.do?id=<s:property value="id"/>" title="编辑作品"></a>
                                     
                                      </s:if>
                                     
                                      <s:else>
                                     <a class="edit" href="publish!findEditereleasPublish.do?id=<s:property value="id"/>" title="编辑作品"></a>                                     
                                      </s:else>
                                      
                                        <a class="view"  href="publish!findRelesePublish.do?id=<s:property value="id"/>"  title="查看作品"></a>
                                    </div>
                                   
                                    
                                </div>
                        	</div>
                            <!--鼠标滑过显示-->
                            
                        </div>
                	</li>
                	 </s:if>
                	 <s:elseif test="#publish.publishStatus.justShow==1">
                	 
                	 	<!--已发布为仅展示-->
            		<li class="">
                    	<div class="picWorkContentLi">
                        	<!--默认显示    ${pageContext.request.contextPath}/public/pic/1.png -->
                            <div class="defaultView">
                    		<div class="photographyStoryLiHead">
                        		<img src="<s:property value="thumbnailUrl"/>" />
                       	 	</div>
                        	
                            </div>
                        	<!--默认显示-->
                            
                            
                            
                            
                             <s:if test="#publish.publishStatus.pass==1">
                            <!-- 图片右上角显示-->
                            
                            <s:if test="#publish.publishStatus.adminSoldout!=1&&#publish.publishStatus.copyrightBuyout!=1&&#publish.publishStatus.userSoldout!=1">
                            <div class="divOnlyView">
                                <div class="onlyView">
                                	<div class="bj"></div>
                                    <div class="bjc"></div>
                                </div>
                                
                                <div class="onlyViewChar">
                                	<div class="sanjiao"> </div>
                                	<div class="sp">已发布为仅展示</div>
                                </div>
                            </div>
                            </s:if>
                           </s:if>
                            <!-- 图片右上角显示-->
                            
                            <!--鼠标滑过显示-->
                            <div class="nowtop">
                        		<div class="bj"></div>
                        		<div class="bjc">
                        			<div class="picInf">
                                    	<div class="ifone"><span class="name" title="<s:property value="name"/>"><s:property value="name"/></span></div>
                                        <div class="iftwo">作品编号：<span class="worknum"><s:property value="picNumber"/></span>
                                        
                                                                  <s:if test="#publish.publishStatus.pass!=1">
                                                                      <s:if test="#publish.publishStatus.noPass==0">
                                                                      <span class="orange">审核中</span>
                                                                      </s:if>  
                                                                      <s:if test="#publish.publishStatus.noPass==1">
                                                                      <span class="red">审核未通过</span>
                                                                       </s:if>  
                                                                      </s:if> 
                                                                      
                                                                      <s:if test="#publish.publishStatus.adminSoldout==1">
                                                                      <span class="red">被管理员下架</span>
                                                                      </s:if>
                                                                      <s:elseif test="#publish.publishStatus.copyrightBuyout==1">
                                                                      <span class="orange">被下架</span>
                                                                      </s:elseif>
                                                                       <s:elseif test="#publish.publishStatus.userSoldout==1">
                                                                      <span class="grey">已下架</span> 
                                                                      </s:elseif>                      
                                        
                                        </div>
                                        <div class="ifthree">
                                        	<a class="time" title="上传时间"><span><s:property value="upTime"/></span></a>
                                        	<a class="time2" title="发布时间"><span><s:date name="publishTime" format="yyyy-MM-dd"/></span></a>
                                        </div>
                                    </div>
                                    
                                    <div class="picUser">
                                    	<div class="vcg">
                                        	<a class="view" title="浏览次数"><s:property value="hit"/></a>
                                        	<a class="collect" title="收藏次数">2222</a>
                                        	<a class="good" title="推荐次数">3333</a>
                                        </div>
                                        
                                    	<div class="usti">此作品已发布为仅展示</div>
                                    	
                                        
                                    </div>
                                 <div class="picEdit">
                                       <s:if test="#publish.publishStatus.adminSoldout==1||#publish.publishStatus.copyrightBuyout==1||#publish.publishStatus.userSoldout==1||#publish.publishStatus.pass!=1">
                                       
                                      <a class="del" href="publish!deletePublishPic.do?id=<s:property value="id"/>" title="删除作品"></a>
                                      </s:if>
                                     
                                      <s:else>
                                        <a class="xj" href="publish!userSoldout.do?id=<s:property value="id"/>" title="作品下架"></a>
                                     
                                      </s:else>
                                        <a class="down" title="下载作品" href="publish!downloadPic.do?id=<s:property value="id"/>"></a>
                                        <s:if test="#publish.publishStatus.adminSoldout==1||#publish.publishStatus.copyrightBuyout==1||#publish.publishStatus.userSoldout==1||#publish.publishStatus.pass!=1">
                                         <a class="edit" href="  publish!findEditeUnPublish.do?id=<s:property value="id"/>" title="编辑作品"></a>
                                     
                                      </s:if>
                                     
                                      <s:else>
                                     <a class="edit" href="publish!findEditereleasPublish.do?id=<s:property value="id"/>" title="编辑作品"></a>                                     
                                      </s:else>
                                        <a class="view"  href="publish!findRelesePublish.do?id=<s:property value="id"/>"  title="查看作品"></a>
                                    </div>
                                </div>
                        	</div>
                            <!--鼠标滑过显示-->
                            
                        </div>
                	</li>
                	 </s:elseif>
                	
                	 <s:elseif test="#publish.publishStatus.unreleased==0">
                	 
                	 
                <s:if test="logo==1">       
                <li class="">
                    	
                    	<div class="picWorkContentLi">
                        	<!--默认显示-->
                            <div class="defaultView">
                    		<div class="photographyStoryLiHead">
                        		<!--<img src="../../public/pic/1.png" />-->
                                <div class="div<s:property value="picMode"/>">
                                	<div class="specialLayout">
                                	
                                	<s:property value="picMode"/>
                                	
                                	</div>
                                	<div class="specialLayoutTitle"><s:property value="name"/></div>
                                	<div class="specialLayoutTime"><s:property value="upTime"/></div>
                                </div>
                       	 	</div>
                        	
                            </div>
                        	<!--默认显示-->
                                                      
                            
                            <!--鼠标滑过显示-->
                            <div class="nowtop">
                        		<div class="bj"></div>
                        		<div class="bjc">
                        			<div class="picInf">
                                    	<div class="ifone"><span title="<s:property value="name"/>" class="name"><s:property value="name"/></span></div>
                                        <div class="iftwo">作品编号：<span class="worknum"><s:property value="picNumber"/></span></div>
                                        <div class="ifthree">
                                        	<a title="上传时间" class="time"><span><s:property value="upTime"/></span></a>
                                        </div>
                                    </div>
                                    
                                    
                                    
                                    <div class="picEdit">
                                    		<a class="del" href="publish!deletePublishPic.do?id=<s:property value="id"/>" title="删除作品"></a>
                                        <a class="down" title="下载作品" href="publish!downloadPic.do?id=<s:property value="id"/>"></a>
                                        <a class="edit" href="publish!findEditeUnPublish.do?id=<s:property value="id"/>" title="编辑作品"></a>
                                      
                                        <!--<a class="view" title="查看作品"></a>-->
                                    </div>
                                </div>
                        	</div>
                            <!--鼠标滑过显示-->
                            
                        </div>
                	</li>
                
                
                </s:if>
                <s:else>
                	      <!--未发布-->
            		<li class="">
                    	<div class="picWorkContentLi">
                        	<!--默认显示-->
                            <div class="defaultView">
                    		<div class="photographyStoryLiHead">
                        		<img src="<s:property value="thumbnailUrl"/>" />
                                
                       	 	</div>
                        	
                            </div>
                        	<!--默认显示-->
                            
                            
                            <!--鼠标滑过显示-->
                            <div class="nowtop">
                        		<div class="bj"></div>
                        		<div class="bjc">
                        			<div class="picInf">
                                    	<div class="ifone"><span class="name" title="<s:property value="name"/>"><s:property value="name"/></span></div>
                                        <div class="iftwo">作品编号：<span class="worknum"><s:property value="picNumber"/></span></div>
                                        <div class="ifthree">
                                        	<a class="time" title="上传时间"><span><s:property value="upTime"/></span></a>
                                        </div>
                                    </div>
                                    
                                    
                                    
                                    <div class="picEdit">
                                    	<a class="del" href="publish!deletePublishPic.do?id=<s:property value="id"/>" title="删除作品"></a>
                                        <a class="down" title="下载作品" href="publish!downloadPic.do?id=<s:property value="id"/>"></a>
                                        <a class="edit" href="publish!findEditeUnPublish.do?id=<s:property value="id"/>" title="编辑作品"></a>
                                       <a class="view"  href="publish!findRelesePublish.do?id=<s:property value="id"/>"  title="查看作品"></a>
                                    </div>
                                </div>
                        	</div>
                            <!--鼠标滑过显示-->
                            
                        </div>
                	</li>
                    
                   <!--未发布-->
                	</s:else> 
                	 </s:elseif>
                	<!--已发布为可出售-->
                    </s:iterator>
                    
                    
              
                  
                   
                   
                    <div style="clear:both;"></div>
            	</ul>
            </div>
        
        
        
        
        
        
        
        
        <!--图片内容-->
    </div>
    <!--内容-->
    
    
    <!--翻页ddd-->
    
                <s:if test="pager.lastPageNo>1">
                             
                    <div class="ppointPagingthis">
                        <div class="ppointPaging">            
                            <table class="tablePpointPaging">
                                    <tr>
                                   
                                        <td class="ppointPagingOne"><a href="${pageContext.request.contextPath}/publish!findAllMyLib.do?pageNo=1"></a></td>
                                        <td class="ppointPagingPre">
                                        <s:if test="pager.pageNo-1>0">
                                        <a href="${pageContext.request.contextPath}/publish!findAllMyLib.do?pageNo=<s:property value="pager.pageNo-1"/>"></a>
                                        </s:if>
                                        
                                        <s:else>
                                        
                                        <a href="${pageContext.request.contextPath}/publish!findAllMyLib.do?pageNo=<s:property value="pager.pageNo"/>"></a>
                                        </s:else>
                                        </td>
                                        <s:iterator begin="1" end="pager.lastPageNo" status="ind">
                                         <td class="ppointPagingN"><a href="${pageContext.request.contextPath}/publish!findAllMyLib.do?pageNo=<s:property value="#ind.index+1"/>">
                                         <s:property value="#ind.index+1"/>
                                         </a></td>      
                                        
                                        </s:iterator>
                                                    <s:if test="pager.lastPageNo>pager.pageNo">
                                                    
                                                    <td class="ppointPagingNext"><a href="${pageContext.request.contextPath}/publish!findAllMyLib.do?pageNo=<s:property value="pager.pageNo+1"/>"></a></td>
                                                    </s:if>
                                                    <s:else>
                                                     <td class="ppointPagingNext"><a href="${pageContext.request.contextPath}/publish!findAllMyLib.do?pageNo=<s:property value="pager.lastPageNo"/>"></a></td>
                                                    </s:else>               
                                        
                                        <td class="ppointPagingLast"><a href="${pageContext.request.contextPath}/publish!findAllMyLib.do?pageNo=<s:property value="pager.lastPageNo"/>"></a></td>
                                    </tr>
                                </table>
                        </div>
                    </div>
              </s:if>
                    <!--翻页-->
        
    <!--foot 开始-->
    <div id="footer">
    <div id="footCenter">
    	<div id="footServer">
        	<div id="aboutOur" class="footServerCon">
            	<div class="serverConStr"><a href="javascript:">关于我们</a></div>
                <p><a href="javascript:">服务内容</a></p>
                <p><a href="javascript:">身份注册</a></p>
                <p><a href="javascript:">积分等级</a></p>
                <p><a href="javascript:">交易流程</a></p>
            </div>
            <div id="rechargeDefray" class="footServerCon">
            	<div class="serverConStr"><a href="javascript:">充值支付</a></div>
                <p><a href="javascript:">账户管理</a></p>
                <p><a href="javascript:">充值方式</a></p>
                <p><a href="javascript:">交易记录</a></p>
                <p><a href="javascript:">充值</a></p>
                <p><a href="javascript:">提现</a></p>
            </div>
            <div id="personnelRecruitment" class="footServerCon">
            	<div class="serverConStr"><a href="javascript:">人才招聘</a></div>
                <p><a href="javascript:">人才计划</a></p>
                <p><a href="javascript:">招聘职位</a></p>
            </div>
            <div id="legalColumn" class="footServerCon">
            	<div class="serverConStr"><a href="javascript:">法律专栏</a></div>
                <p><a href="javascript:">使用条款</a></p>
                <p><a href="javascript:">相关协议</a></p>
                <p><a href="javascript:">版权声明</a></p>
                <p><a href="javascript:">隐私政策</a></p>
                <p><a href="javascript:">免责声明</a></p>
                <p><a href="javascript:">法律知识</a></p>
            </div>
            <div id="footProblem" class="footServerCon">
            	<div class="serverConStr"><a href="javascript:">疑难解答</a></div>
            	<div class="serverConStr"><a href="javascript:">投诉建议</a></div>
            	<div class="serverConStr"><a href="javascript:">广告服务</a></div>
            	<div class="serverConStr"><a href="javascript:">信息中心</a></div>
            </div>
        </div>
        
        <div id="footCopyright">
        	<div class="serverConStr" id="serverConStrid">版权声明</div>
            <div id="footCopyrightCon">
            	<p>所有图片及文件都受著作权保护，未经允许不得使用，</p>
                <p>不得转载编辑</p>
            	<p>Copyright&copy;2012-2013 wepic.cn</p>
                <p>上海维拓网络科技有限公司</p>
                <p>ICP备案/许可证：沪ICP备13010366号</p>
            </div>
        </div>
        
        <div id="footCustom">
        	<div id="twoDimensionCode">
            	<img src="${pageContext.request.contextPath}/public/images/weixin.png"/>
                <p>微信公众账号</p>
            </div>
            
            <div id="DimensionCodeServer">
            	<p class="serverConStr">客服电话</p>
                <p id="serverPhone">400-809-9060</p>
                <p>（周一至周五：9:00-18:00）</p>
                <div id="serverShare">
                	<ul>
                    	<li><a href="javascript:" id="shareSina" class="shareSina" title="分享到新浪微博"></a></li>
                        <li><a href="javascript:" id="shareQqzone" class="shareQqzone" title="分享到QQ空间"></a></li>
                        <li><a href="javascript:" id="shareQqblog" class="shareQqblog" title="分享到腾讯微博"></a></li>
                        <li><a href="javascript:" id="shareTwitter" class="shareTwitter" title="分享到twitter"></a></li>
                        <li><a href="javascript:" id="shareFacebook" class="shareFacebook" title="分享到facebook"></a></li>
                        <li><a href="javascript:" id="shareRenren" class="shareRenren" title="分享到人人网"></a></li>
                        <li><a href="javascript:" id="shareDouban" class="shareDouban" title="分享到豆瓣"></a></li>
                    </ul>
                    	
                </div>
            </div>
        </div>
    </div>
    </div>
    <!--foot 结束-->
    
	<div id="goTopBtn" style="display:none;"></div>
</div>
<!--[if lte IE 6]>
<script src="${pageContext.request.contextPath}/public/js/DD_belatedPNG_0.0.8a.js" type="text/javascript"></script>
    <script type="text/javascript">
        DD_belatedPNG.fix('div, ul, img, li, input , a , i');
    </script>
<![endif]-->


</body>
</html>

