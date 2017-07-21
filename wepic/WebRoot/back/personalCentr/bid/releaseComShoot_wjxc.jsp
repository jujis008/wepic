<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="shortcut icon" href="../../../userView/public/images/logoSmall.ico"/>

<title>wepic管理-个人中心-我的约拍-发布-商业拍摄-平面广告+人物</title>


<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/jquery.js"></script>


<!--公共js-->
<script type="text/javascript" src="${pageContext.request.contextPath}/back/js/provinceCityDistrict.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/back/js/publicBack.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}//public/js/public.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/topBar.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}//public/js/header.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}//back/js/ajaxforUserInfo.js"></script>
<!--公共css-->
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public/css/backMainBar.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public/css/topBarMain.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public/css/header.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public/css/footer.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/back/personalCentr/bid/js/releaseComShoot_wjxcform.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/back/personalCentr/bid/js/releaseComShoot_wjxc.js"></script>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/back/personalCentr/bid/css/releaseComShoot.css" />
<script type="text/javascript" src="<%=basePath %>back/chajian/jquery.ocupload-1.1.2.js"></script>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public/css/lyz.calendar.css"  />
<script src="${pageContext.request.contextPath}/public/js/lyz.calendar.min.js" type="text/javascript"></script>

</head>
<script>
        $(function () {
            $("#txtBeginDate").calendar({
                controlId: "divDate",                                       // 弹出的日期控件ID，默认: $(this).attr("id") + "Calendar"
                speed: 200,                                                 // 三种预定速度之一的字符串("slow", "normal", or "fast")或表示动画时长的毫秒数值(如：1000),默认：200
                complement: true,                                           // 是否显示日期或年空白处的前后月的补充,默认：true
                readonly: true,                                             // 目标对象是否设为只读，默认：true
               	addToDiv: "choseTime"
                
            });
			
			
			$("#txtEndDate").calendar({
                controlId: "divDate2",                                       // 弹出的日期控件ID，默认: $(this).attr("id") + "Calendar"
                speed: 200,                                                 // 三种预定速度之一的字符串("slow", "normal", or "fast")或表示动画时长的毫秒数值(如：1000),默认：200
                complement: true,                                           // 是否显示日期或年空白处的前后月的补充,默认：true
                readonly: true,                                             // 目标对象是否设为只读，默认：true
               	addToDiv: "choseTime"
                
            });

			$("#txtEndDate2").calendar({
                controlId: "divDate3",                                       // 弹出的日期控件ID，默认: $(this).attr("id") + "Calendar"
                speed: 200,                                                 // 三种预定速度之一的字符串("slow", "normal", or "fast")或表示动画时长的毫秒数值(如：1000),默认：200
                complement: true,                                           // 是否显示日期或年空白处的前后月的补充,默认：true
                readonly: true,                                             // 目标对象是否设为只读，默认：true
               	addToDiv: "choseTime2"
                
            });
        });


        $(function(){
            $("#fileipload").upload({
    		name : 'accessories', // <input type="file" name="upload" />
    		enctype : 'multipart/form-data',
    		action : '${pageContext.request.contextPath}/bidAction_uploadAccessories.do',
    		autoSubmit : true,
    		onSubmit: function (self, element) { 
    		var url=$("#fileipload").next().next().find("input").val();
    		var fileName=getFileName(url);
    		    var wait='<li><div class="loadingtd">'+
                	'<div class="divtd"><i title="上传中" class="loading"></i></div>'+
                    '<div class="loadingname">'+
                    	'<span>'+fileName+'</span></div>'+
                    '<div class="loadingname2">'+
                    '<span>上传中...</span>'+
                    '<i onclick="deleteFile(this);" title="删除"></i></div></div></li>';
    			$("#ULUpload").find("ul").append(wait);  
            },  
            onComplete: function (data, self, element){  
                $("#ULUpload").find("ul").children().last().remove();
                var date=eval("("+data+")");
                var file=date.httpurl.split(",");
               // alert(file);
                var attachmentUrl=$("#attachmentUrl").val();
                if(attachmentUrl!=null&&attachmentUrl!=""){
                	attachmentUrl=attachmentUrl+" "+file[0];
                    }else{
                    	attachmentUrl=file[0];

                        }
                $("#attachmentUrl").val(attachmentUrl);
            	 var div='<li>'+
                 '<div class="success">'+
         	     '<div class="contenttd">'+
             	'<div class="divtd"><i class="file"></i><i class="true" title="上传成功"></i></div>'+
             	'<div class="infos">'+file[1]+'<input type="hidden" id="url" value='+file[0]+' /><input type="hidden" id="filename" value='+file[2]+' /></div></div><div class="bjcon">'+
             	'<div class="bj"></div>'+
                 '<div class="bjc"><i class="del" title="删除" onclick="deleteFile(this);"></i></div>'+
             '</div>'+
         '</div></li>';
         $("#ULUpload").find("ul").append(div);
         divLiBar("ULUpload"); 
         }
    	});
    });
      function getFileName(path){
        	var pos1 = path.lastIndexOf('/');
        	var pos2 = path.lastIndexOf('\\');
        	var pos  = Math.max(pos1, pos2)
        	if( pos<0 )
        	return path;
        	else
        	return path.substring(pos+1);
        	}  
    </script>
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
                    	<a href="javascript:"><span>你是WHO</span><i></i></a>
                    </div>
                    
                	<div id="topBarUserDetailed">
                    	<div id="topBarUserOne">
                        	<div id="topBarUserOneHead">
                            	<img src="${pageContext.request.contextPath}/public/images/pic/topUser.jpg" id="porperties"/>
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
            		<a href="javascript:void(0)">个人中心</a>
            	</li>
            	<li id="configureCenter">
            		<a href="javascript:void(0)">配置中心</a>
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
        	<a href="javascript:"><div class='bar'><span>首页</span><i></i></div></a>
            
            <a href="javascript:"><div class='bar'><span>账户基本资料</span><i></i></div></a>
            
            <a href="javascript:"><div class='bar'><span>我的作品库</span><i></i></div></a>
            
            <a href="javascript:"><div class='bar active'><span>我的约拍</span><i></i></div></a>
            
            <a href="javascript:"><div class='bar'><span>我买到的作品</span><i></i></div></a>
            
           <a href="javascript:"> <div class='bar'><span>收藏/订阅/推荐</span><i></i></div></a>
        </div>
    	
        <div id="divThreeStage">
        
        <div class="threeStage">
        	<a href="javascript:"><div class='bar'><span>应约记录</span><i></i></div></a>
            
            <a href="javascript:"><div class='bar'><span>发布记录</span><i></i></div></a>
            
            <a href="javascript:"><div class='bar'><span>约拍日程</span><i></i></div></a>
            
            <a href="relProjectChoose.html"><div class='bar active'><span>发布约拍</span><i></i></div></a>
        </div>
        </div>
    </div>
    <!-- 导航  end-->
    
    
    <!--内容-->
    <div id="divReleaseComShoot">
   		<div class="divHead">
        	<p class="title-name">发布商业拍摄</p>
            <input class="viewRecord" type="button" value="查看发布记录"/>
        </div>
        
        
        
        <div class="content">
        <form action="${pageContext.request.contextPath}/bid!addBid.do" method="post" id="bidaddForm">

        	<div class="center">
            
            	<div class="title">
                <table>
                	<tr>
                    	<td><span class="left">项目标题</span></td>
                        <td class="tdtitleinput"><input class="titleinput" type="text" name="name" id="namebidFor"/></td>
                        <td><span class="left">拍摄类型</span></td>
                        <td>
                        	<div class="divdropDown" id="divdropDown-1">
                    			<div class="dropDownBox" onclick="showBelow('divdropDownPartType')">
                    				<span id="divdropDownViewPartType">产品拍摄</span>
                        			<div class="dropDownBoxR"><i></i></div>
                        			<input type="hidden" name="tag" id="bidtag" />
                    			</div>
                    
                    			<div class="dropDownBoxValue" id="divdropDownPartType">
                    				<span class='dropValue' id="1">产品拍摄</span>
                        			<span class='dropValue' id="2">平面广告拍摄</span>
                        			<span class='dropValue' id="3">人物拍摄</span>
                        			<span class='dropValue' id="4">建筑内外景拍摄</span>
                        			<span class='dropValue' id="5">活动现场拍摄</span>
                        			<span class='dropValue' id="6">宣传片拍摄</span>
                        			<span class='dropValue' id="7">广告片拍摄</span>
                        			<span class='dropValue' id="8">其他</span>
                      
                    			</div>
                  			</div>
                        </td>
                    </tr>
                </table>
                </div>
            
            
            
            	
                
                <div class="parttextarea">
                	<div class="tea">
                		<span class="leftte">拍摄内容及要求</span>
                   	 	<textarea id="textareapart" name="context"></textarea>
                    </div>
                    
                    <div class="tea">
                		<span class="left">应约条件</span>
                   	 	<textarea  name="contextHtml" id="contextHtml"></textarea>
                    </div>
                </div>
                
                
                <div class="divPartTime">
                	<div class="one" id="choseTime">
                    	<table>
                			<tr>
                    			<td><span class="left">拍摄时间</span></td>
                				<td><input class="timeInputStr" id="txtBeginDate" type="text"/>
                				<input class="timeInputStr" id="workStartTime" type="hidden" name="workStartTime"/>
                				</td>
                        		<td>
                                	<div class="divdropDown">
                    					<div class="dropDownBox" id="dropDownBox1" onclick="showBelow('divdropDownStartHour')">
                    						<span id="divdropDownViewStartHour">00</span>
                        					<div class="dropDownBoxR"><i></i></div>
                    						</div>
                    
                    					<div class="dropDownBoxValue" id="divdropDownStartHour">
                    			
                    					</div>
                  					</div>
                                 </td>
                        		<td>
                                	<span class="spantime">时</span>
                                    <input class="timeInputMin" type="text" id="workStartTimefen"/>
                                    <span class="spantime">分</span>
                                </td>
                                <td><span class="spantime spantimez">至</span></td>
                                <td><input class="timeInputStr" id="txtEndDate" type="text"/>
                                 <input class="timeInputStr"  id="workEndTime" type="hidden" name="workEndTime"/>
                                </td>
                               
                                <td>
                                	<div class="divdropDown">
                    					<div class="dropDownBox" id="dropDownBox2" onclick="showBelow('divdropDownStartHour2')">
                    						<span id="divdropDownViewStartHour2">00</span>
                        					<div class="dropDownBoxR"><i></i></div>
                    					</div>
                    
                    					<div class="dropDownBoxValue" id="divdropDownStartHour2">
                    			
                    					</div>
                  					</div>
                                </td>
                                <td>
                                	<span class="spantime">时</span>
                                    <input class="timeInputMin" type="text" id="workEndTimefen"/>
                                    <span class="spantime">分</span>
                                </td>
                            </tr>
                        </table>
                    </div>
                    
                    <div class="two" id="choseTime2">
                    	<table>
                        	<tr>
                            	<td><span class="left">招募截止</span></td>
                            	<td><input class="timeInputStr" id="txtEndDate2" type="text"/>
                            	<input class="timeInputStr" id="period" type="hidden" name="period"/>
                            	
                            	</td>
                            	<td>
                                	<div class="divdropDown">
                    					<div class="dropDownBox" id="dropDownBox3" onclick="showBelow('divdropDownStartHour3')">
                    						<span id="divdropDownViewStartHour3">00</span>
                        					<div class="dropDownBoxR"><i></i></div>
                    					</div>
                    
                    					<div class="dropDownBoxValue" id="divdropDownStartHour3">
                    			
                    					</div>
                  					</div>
                                </td>
                            	<td>
                                	<span class="spantime">时</span>
                                    <input class="timeInputMin" type="text" id="periodfen"/>
                                    <span class="spantime">分</span>
                                </td>
                            </tr>
                        </table>
                    	
                    </div>
                </div>
                
                <div class="divPartAddress address">
                	<div class="ad">
                	<span class="left">拍摄地点
                	<input type="hidden" name="bidderAssess" id="bidderAssess" />
                	
                	</span>
                	<div class="adr" id="citySelectTag">
                    	<dl>
                       	 	<dt>
                            	<span class="arr"></span>
                            	<div class="xl"><i></i></div> 
                            	<input name="Area_province" type="hidden" value="" />
                        	</dt><dd></dd>
                    	</dl>
                    	<dl>
                        	<dt>
                        		<span class="arr"></span>
                            	<div class="xl"><i></i></div> 
                        		<input name="Area_city" type="hidden" value="" />
                        	</dt><dd></dd>
                    	</dl>
                    	<dl>
                        	<dt>
                        	   	<span class="arr"></span>
                           		<div class="xl"><i></i></div> 
                           		<input name="Area_District" type="hidden" value="" />
                        	</dt><dd></dd>
                    	</dl>
                	<script type="text/javascript">
                    	    new locatArea("北京市","市辖区","东城区",document.getElementById('citySelectTag'));
                	</script>
                	</div>
                    </div>
                    
                    <div class="divPartEnv">
                    	<table>
                        	<tr>
                            	<td><span class="left">拍摄环境
                            	<input type="hidden" name="shootingEnvironment" id="shootingEnvironment" />
                            	</span></td>
                                <td>
                                	<div class="divdropDown">
                    					<div class="dropDownBox" id="dropDownBoxPartEnv" onclick="showBelow('divdropDownPartEnv')">
                    						<span id="divdropDownViewPartEnv"></span>
                        					<div class="dropDownBoxR"><i></i></div>
                    					</div>
                    
                    					<div class="dropDownBoxValue" id="divdropDownPartEnv">
                    						<span class='dropValue'>在摄影师处摄影棚拍摄</span>
                       						<span class='dropValue'>在我公司室内场地拍摄</span>
                       						<span class='dropValue'>外景拍摄我公司指明</span>
                       						<span class='dropValue'>外景拍摄摄影师指明</span>
                 			   			</div>
                  					</div>
                                </td>
                                
                              
                            </tr>
                        </table>
                		
                        
                    </div>
                </div>
                
                <div class="divPartNum">
                    <span class="spanPerNumcp">正片数量</span>
                	<input class="inputPartNum" type="text" name="sumProductPhoto"/>
                    <span class="spanPartNumz">张</span>
                </div>
                
                
                <div class="divPartOffer divPartOffercp">
                	<table class="tablePartOffer">
                    	<tr>
                        	<td rowspan="3" class="td1"><span class="">邀约报价</span></td>
                            <td class="td2"><input type="radio" name="unitpriceType" value="2" id="perPrice" checked="checked"/></td>
                            <td class="td3"><label for="perPrice">每件正片价格</label></td>
                            <td class="td4"><input type="text" name="unitprice" onblur="CounttotalMoney(this)"  onfocus="checkedRadio(this)"/></td>
                            <td class="td5"><span>总计：</span><span class="y">0</span><span>元</span></td>
                            <td class="td6"><input type="checkbox" name="ifAskPrice" id="checkkbj" value ="1"><label for="checkkbj">应约者可报价</label></td>
                            <td class="td7"><span>当对市场价格不了解时，可选择让应约者自行报价。</span></td>
                        </tr>
                        
                       
                        
                        <tr>
                            <td class="td2"><input type="radio" name="unitpriceType" value="3" id="totalPrice"/></td>
                            <td class="td3"><label for="totalPrice">邀约总价</label></td>
                            <td class="td4"><input type="text" onblur="CounttotalMoney(this)" onfocus="checkedRadio(this)"/></td>
                            <td class="td5"><span>每张正片：</span><span class="y">0</span><span>元</span></td>
                            
                        </tr>
                    </table>
                </div>
                
                
                <div class="divBidType">
                	<table>
                    	<tr>
                        	<td><span class="left">招标方式
                        	<input type="hidden" value="" id="publicOrPrivate" name="publicOrPrivate" />
                        	</span></td>
                        	<td class="dropDownBoxBidTypetd">
                            	<div class="divdropDown">
			                    		<div class="dropDownBox" id="dropDownBoxBidType" onclick="showBelow('divdropDownBidType')">
            			        			<span id="divdropDownViewBidType"></span>
                        					<div class="dropDownBoxR"><i></i></div>
			                    		</div>
            			        
			                    		<div class="dropDownBoxValue" id="divdropDownBidType">
             				       			<span class='dropValue' id="1">公开招标</span>
                       						<span class='dropValue' id="2">私密招标</span>	        
        			            		</div>
                  					</div>
                            </td>
                            <td><input class="buttoninvite" type="button" value="点击邀请好友/粉丝参加" /></td>
                            <td>已邀请<span class="inviteNum">24</span>人</td>
                            <td><span class="invitesp1">上传附件</span></td>
                            <td><input class="buttonadd" type="button" value="上传附件" id="fileipload" />
                            <input type="hidden" name="attachmentUrl" id="attachmentUrl" />
                            
                            </td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                    
                    </table>
                        
                </div>
                
                
                
                
                <div class="divPartOffer">
                	<div class="tableUpload" id="ULUpload">
                    	<ul>
                       <!-- 
                        <li>
                        	<div class="faled">
                            	<div class="contenttd">
                            		<div class="divtd"><i class="file"></i><i class="false" title="上传失败"></i></div>
                                	<div class="infosf">附件三等份收.pdf(56.KB)</div>
                                	<div class="infosf2">上传失败</div>
                                </div>
                                <div class="bjcon">
                                	<div class="bj"></div>
                                    <div class="bjc">
                                    	<i class="reload" title="重新上传"></i>
                                        <i class="del" title="删除" onclick="deleteFile(this);"></i>
                                    </div>
                                </div>
                            </div>
                        </li>
                         -->
                       
                        </ul>
                        	
                            
                            
                        
                    </div>
                </div>
                
                <div class="submit">
               		<div class="inp">
               		<input type="hidden" value="2" name="type" />
               			<input class="inputup" type="button" value="取消"/>
						<input class="finished" type="button" value="发布" onclick="subForm();"/>
               		</div>
        		</div>
                
            </div>
        	
            
            </form>
        
        
        </div>
        	
        
        
        
    </div>
    
    
    
    
    <!--内容-->
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
