<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s" %>
 <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="shortcut icon" href="<%=basePath %>public/images/logoSmall.ico"/>

<title>wepic管理_配置中心_账户安全_实名认证_政府填写信息</title>
<script type="text/javascript" src="<%=basePath %>public/js/imgsf.js"></script>

<link type="text/css" rel="stylesheet" href="<%=basePath %>back/configurationCentre/accountSecurity/css/authentGovernment.css" />
<script type="text/javascript" src="<%=basePath %>public/js/jquery.js"></script>
<script language="javascript" src="<%=basePath%>public/js/jquery.ocupload-1.1.2.js"></script>
<!--公共js-->
<script type="text/javascript" src="<%=basePath %>back/js/publicBack.js"></script>
<script type="text/javascript" src="<%=basePath %>public/js/public.js"></script>
<script type="text/javascript" src="<%=basePath %>public/js/topBar.js"></script>
<script type="text/javascript" src="<%=basePath %>public/js/header.js"></script>
<script type="text/javascript" src="<%=basePath %>public/js/identityCardValidate.js"></script>

<!--公共css-->
<link type="text/css" rel="stylesheet" href="<%=basePath %>back/pubimg/css/backMainBar.css" />
<link type="text/css" rel="stylesheet" href="<%=basePath %>public/css/topBarMain.css" />
<link type="text/css" rel="stylesheet" href="<%=basePath %>public/css/header.css" />
<link type="text/css" rel="stylesheet" href="<%=basePath %>public/css/footer.css" />
<script type="text/javascript" src="<%=basePath %>back/configurationCentre/accountSecurity/js/authentGovernment.js"></script>
<script type="text/javascript">
          $(function () {
            uploadlicense();
            uploadletters();
            uploadmyupfile();
		});
/*政府信息登记表*/
		function uploadlicense(){
          $("#upgovermentInfo").upload({
			name : 'goverregister',
			enctype : 'multipart/form-data',
			action : 'configurajson_uploadgoverregister.do',
			autoSubmit : true,
			onSubmit: function (self, element) {
			//cloosePopBox();
            },  
            onComplete: function (data, self, element) {  
                var data = eval("(" +data +")");
				if (data.param!=''){
				if(data.uploadres == 0){
				alert("此图片像素太小,请上传不小于800 * 800 像素的证件照" );
				}else{
				var cxt="<img id='myidcardpic' src="+data.param+" onload='javascript:DrawImage(this,285,285)' />";
                 $("#imgRegistryForm").html(cxt);
                 $("#zhengfuinforegister").val(data.param);
                 $("#uploadSuccessIcoo").show();
                 $("#uploadRemind").css('display','none'); 
                 }
				}
			}
		});
    }
    /*上传申请公函*/
    function uploadletters(){
          $("#upgovermentInfo2").upload({
			name : 'letters',
			enctype : 'multipart/form-data',
			action : 'configurajson_uploadletters.do',
			autoSubmit : true,
			onSubmit: function (self, element) {
			//cloosePopBox();
            },  
            onComplete: function (data, self, element) {  
                var data = eval("(" +data +")");
				if (data.param!=''){
				if(data.uploadres == 0){
				alert("此图片像素太小,请上传不小于800 * 800 像素的证件照" );
				}else{
				var cxt="<img id='myidcardpic' src="+data.param+" onload='javascript:DrawImage(this,285,285)' />";
                 $("#imgOfficialLetter").html(cxt);
                 $("#shenqinggonghan").val(data.param);
                 $("#uploadSuccessIcot").show();
                 $("#uploadRemind").css('display','none'); 
                 }
				}
			}
		});
    }
    /*上传证件照*/
    function uploadmyupfile(){
          $("#uploadBut").upload({
			name : 'myupfile',
			enctype : 'multipart/form-data',
			action : 'configurajson_uploadimg.do',
			autoSubmit : true,
			onSubmit: function (self, element) {
			//cloosePopBox();
            },  
            onComplete: function (data, self, element) {  
                var data = eval("(" +data +")");
				if (data.param!=''){
				if(data.uploadres == 0){
				alert("此图片像素太小,请上传不小于800 * 800 像素的证件照" );
				}else{
				var cxt="<img id='myidcardpic' src="+data.param+" onload='javascript:DrawImage(this,285,285)' />";
                 $("#imgPpreviewPhotograph").html(cxt);
                 $("#zhengjianzhao").val(data.param);
                 $("#uploadSuccessIcow").show();
                 $("#uploadRemind").css('display','none'); 
                 }
				}
			}
		});
    }
    function govermentsubmit(){
     var form = document.getElementById("formEnterprise");
     var validateres=submitVerification();
     if(validateres == false){
     }else{
     var zhengfuinforegister=$("#zhengfuinforegister").val();
     alert(zhengfuinforegister);
     var shenqinggonghan=$("#shenqinggonghan").val();
     var zhengjianzhao=$("#zhengjianzhao").val();
     
	 form.action="configure!govermentvalidateing.do?govermentenrollment="+zhengfuinforegister+"&licenseagreement="+shenqinggonghan+"&idCardFrontPic="+zhengjianzhao;  
	 form.submit();  
     }
    
    }
function linkgoverment(type){
	    if(type == 1){
	       location.href="configure!govermentvalidate.do";
	    }if(type == 2){
	       location.href="configure!mediavalidate.do";
	    }if(type == 3){
	       location.href="configure!enterpricevalidate.do";
	    }if(type == 4){
	       location.href="configure!othervalidate.do";
	    }    
    }
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
                    	<a href="javascript:"><span>你是WHO</span><i></i></a>
                    </div>
                    
                	<div id="topBarUserDetailed">
                    	<div id="topBarUserOne">
                        	<div id="topBarUserOneHead">
                            	<img src="<%=basePath %>public/images/pic/topUser.jpg" />
                                <div id="topBarUserOneHeadChange">
                                	<div><a href="javascript:">更改头像</a></div>
                                </div>
                            </div>
                            <div id="topBarUserOneDetailed">
                            	<div id="topBarUserOneDetailedOne">
                                	<img id="topBarUserOneDetailedimg" src="<%=basePath %>public/images/grade/uesrLogo.png"/>
                                    <img src="<%=basePath %>public/images/grade/diamond.png"/>
                                    <img src="<%=basePath %>public/images/grade/diamond.png"/>
                                    <img src="<%=basePath %>public/images/grade/star.png"/>
                                    <img src="<%=basePath %>public/images/grade/star.png"/>
                                    <img src="<%=basePath %>public/images/grade/star.png"/>
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
                            		<img src="<%=basePath %>public/images/pic/topUser.jpg"/>
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
                            		<img src="<%=basePath %>public/images/pic/topUser.jpg"/>
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
                            		<img src="<%=basePath %>public/images/pic/topUser.jpg"/>
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
    				<img src="<%=basePath %>public/images/wepic_logo.png" alt="唯图网"/>
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
        		<li id="personalCenter">
            		<a href="<%=basePath %>user!getFistPageUserInfo.do">个人中心</a>
            	</li>
            	<li id="configureCenter" class="active">
            		<a href="<%=basePath %>configure!securityIndex.do">配置中心</a>
            	</li>
            	<li id="inforCenter">
            		<a href="../../../html_newsCentre/partNews/partNewsIndex.html">消息中心</a>
           	 	</li>
            	<li id="myRoom">
            		<a href="../../../html_myZone/myZoneIndex.html">我的空间</a>
            	</li>
        	</ul>
            
            <div class="divTime">
            	<span class="loginTime">注册时间：</span><span> <s:date name="user.regTime" format="yyyy-MM-dd"/> </span>
            	<span class="preLogin">上次登录时间：</span><span><s:date name="loginHistory.loginTime" format="yyyy-MM-dd HH:mm:ss"/></span>
            </div>
            
        </div>
	</div>
    
	<!-- logo行 end-->
	
     <!-- 导航 -->
  	<div id="assistantBar">
    	<div class="twoStage" id="divTwoStage">
        	<a href="<%=basePath %>configure!securityIndex.do"><div class='bar active'><span>账户安全</span><i></i></div></a>
            
            <a href="<%=basePath %>account!cashoverview.do"><div class='bar'><span>资金管理</span><i></i></div></a>
            
            <a href="javascript:"><div class='bar'><span>交易管理</span><i></i></div></a>
            
            <a href="javascript:"><div class='bar'><span>推广赚钱</span><i></i></div></a>
        </div>
    	
        <div id="divThreeStage">
            <div class="threeStage">
                <a href="<%=basePath %>configure!securityIndex.do"><div class='bar active'><span>基本安全信息</span><i></i></div></a>
                <!-- 0刚注册（未认证）  1申请实名认证（显示为审核） 2 通过 3 不通过 -->
                <s:if test="user.personOrCompany == 1 && user.ifIdentityTrue == 0">
                <a href="configure!personvalidate.do"><div class='bar'><span>实名认证</span><i></i></div></a>
                </s:if>
                <s:if test="user.personOrCompany == 1 && user.ifIdentityTrue == 1">
                <a href="configure!personvalidateprocess.do"><div class='bar'><span>实名认证</span><i></i></div></a>
                </s:if>
                <s:if test="user.personOrCompany == 1 && user.ifIdentityTrue == 2">
                <a href="configure!personvalidatesuc.do"><div class='bar'><span>实名认证</span><i></i></div></a>
                </s:if>
                <s:if test="user.personOrCompany == 1 && user.ifIdentityTrue == 3">
                <a href="configure!personvalidatefail.do"><div class='bar'><span>实名认证</span><i></i></div></a>
                </s:if>
                <s:if test="user.personOrCompany == 2 && user.ifIdentityTrue == 0">
                <a href="configure!enterpricevalidate.do"><div class='bar'><span>实名认证</span><i></i></div></a>
                </s:if>
                <s:if test="user.personOrCompany == 2 && user.ifIdentityTrue == 1 && user.enterpriceType ==1">
                <a href="configure!govermentvalidateingprocess.do"><div class='bar'><span>实名认证</span><i></i></div></a>
                </s:if>
                <s:if test="user.personOrCompany == 2 && user.ifIdentityTrue == 2 && user.enterpriceType ==1">
                <a href="configure!govermentvalidatesuc.do"><div class='bar'><span>实名认证</span><i></i></div></a>
                </s:if>
                <s:if test="user.personOrCompany == 2 && user.ifIdentityTrue == 3 && user.enterpriceType ==1">
                <a href="configure!organzitionvalidatefail.do"><div class='bar'><span>实名认证</span><i></i></div></a>
                </s:if>
                <s:if test="user.personOrCompany == 2 && user.ifIdentityTrue == 1 && user.enterpriceType ==2">
                <a href="configure!mediavalidateingprocess.do"><div class='bar'><span>实名认证</span><i></i></div></a>
                </s:if>
                <s:if test="user.personOrCompany == 2 && user.ifIdentityTrue == 2 && user.enterpriceType ==2">
                <a href="configure!mediavalidatesuc.do"><div class='bar'><span>实名认证</span><i></i></div></a>
                </s:if>
                <s:if test="user.personOrCompany == 2 && user.ifIdentityTrue == 3 && user.enterpriceType ==2">
                <a href="configure!organzitionvalidatefail.do"><div class='bar'><span>实名认证</span><i></i></div></a>
                </s:if>
                <s:if test="user.personOrCompany == 2 && user.ifIdentityTrue == 1 && user.enterpriceType ==3">
                <a href="configure!enterpricevalidateprocess.do"><div class='bar'><span>实名认证</span><i></i></div></a>
                </s:if>
                <s:if test="user.personOrCompany == 2 && user.ifIdentityTrue == 2 && user.enterpriceType ==3">
                <a href="configure!enterpricevalidatesuc.do"><div class='bar'><span>实名认证</span><i></i></div></a>
                </s:if>
                <s:if test="user.personOrCompany == 2 && user.ifIdentityTrue == 3 && user.enterpriceType ==3">
                <a href="configure!organzitionvalidatefail.do"><div class='bar'><span>实名认证</span><i></i></div></a>
                </s:if>
                <s:if test="user.personOrCompany == 2 && user.ifIdentityTrue == 1 && user.enterpriceType ==4">
                <a href="configure!othervalidateingprocess.do"><div class='bar'><span>实名认证</span><i></i></div></a>
                </s:if>
                <s:if test="user.personOrCompany == 2 && user.ifIdentityTrue == 2 && user.enterpriceType ==4">
                <a href="configure!othervalidatesuc.do"><div class='bar'><span>实名认证</span><i></i></div></a>
                </s:if>
                <s:if test="user.personOrCompany == 2 && user.ifIdentityTrue == 3 && user.enterpriceType ==4">
                <a href="configure!organzitionvalidatefail.do"><div class='bar'><span>实名认证</span><i></i></div></a>
                </s:if>
<!--                 <s:if test="user.personOrCompany == 2 && user.ifIdentityTrue == 2">-->
<!--                <a href="javascript:"><div class='bar'><span>实名认证</span><i></i></div></a>-->
<!--                </s:if>-->
<!--                 <s:if test="user.personOrCompany == 2 && user.ifIdentityTrue == 3">-->
<!--                <a href="javascript:"><div class='bar'><span>实名认证</span><i></i></div></a>-->
<!--                </s:if>-->
            </div>
        </div>
        
        
    </div>
    <!-- 导航  end-->
    
    <!--内容-->
    <form id="formEnterprise" method="post">
    <input type="hidden" id="userId" value="<s:property value="user.id"/>"/>
     <input type="hidden" id="zhengfuinforegister" />
     <input type="hidden" id="shenqinggonghan" />
     <input type="hidden" id="zhengjianzhao" />
    <div class="container_body">
    	<div class="info_top">
        	<span class="top_one">实名认证</span>
            <label class="top_must">*</label>
            <span class="top_mustBe">为必填项</span>
        </div>
        
        
        <div class="info_table">
        	<table>
            	<tr class="tr_enterprise">
                	<td class="td_one"><label>*</label><span>企业类型</span></td>
                	<td class="td_two">
                    	<input type="radio" name="enterpriceType" value="1" id="radioGoverment" checked="checked" onclick="linkgoverment(this.value)"/>
                        <label for="radioGoverment" class="">政府</label>
                        
						<input type="radio" name="enterpriceType" value="2" id="radioMedia" class="rightI" onclick="linkgoverment(this.value)"/>
                        <label for="radioMedia">媒体</label>
                        
                    	<input type="radio" name="enterpriceType" value="3" id="radioEnterprise" class="rightI" onclick="linkgoverment(this.value)"/>
                        <label for="radioEnterprise">企业</label>
                        
						<input type="radio" name="enterpriceType" value="4" id="radioOther" class="rightI" onclick="linkgoverment(this.value)"/>
                        <label for="radioOther">其他组织</label>
                    </td>
                </tr>
                
                
            	<tr class="tr_enterpriseRemind">
                	<td class="td_one"></td>
                    <td colspan="3"><div class="remind_enterprise"><div class="sanjiao"></div>政府包括：国内外、各级政府机构、事业单位。具有行政智能的社会组织等。<br />目前主要覆盖公安机构、党团机构、司法机构、交通机构、旅游机构、工商税务机构、市政机构、涉外机构</div></td>
                </tr>
                
                <tr class="tr_prove">
                	<td class="td_one"><label>*</label><span>政府信息登记表</span></td>
                    <td class="td_two">请下载<a href="<%=basePath %>validatedownfile/govermentenrollment.doc">政府信息登记表</a>按要求填写表格后,上传加盖公章的扫描件,支持jpg、jpeg、bmp、gif格式照片，大小不超过5M。</td>
                	<td class="td_one"><label>*</label><span>企业认证申请公函</span></td>
                    <td class="td_two">请下载<a href="<%=basePath %>validatedownfile/applyletters.doc">企业认证申请公函</a>按要求填写表格后,上传加盖公章的扫描件,支持jpg、jpeg、bmp、gif格式照片，大小不超过5M。</td>
                </tr>
                
                <tr class="tr_chooseFile">
                	<td class="td_one"></td>
                    <td class="td_two">
                    	<input type="button" value="选择文件"  class="upload_pho" id="upgovermentInfo" onclick="uploadPhotographImg(this,'imgRegistryForm','uploadSuccessIcoo','uploadRemind1');"/>
                        <span class="span_upPho" id="uploadSuccessIcoo">上传成功</span>
                        <label class="label_remind" id="uploadRemind1"></label>
                    </td>
                	<td class="td_one"></td>
                    <td class="td_two">
                    	<input type="button" value="上传申请公函"  class="upload_pho" id="upgovermentInfo2" onclick="uploadPhotographImg(this,'imgOfficialLetter','uploadSuccessIcot','uploadRemind2');"/>
                        <span class="span_upPho" id="uploadSuccessIcot">上传成功</span>
                        <label class="label_remind" id="uploadRemind2"></label>
                    </td>
                </tr>
                </table>
                <div class="tr_chooseFileImg">
                    <div class="img_preview">
                        <table><tr><td id="imgRegistryForm"></td></tr></table>
                        <i></i>
                        <div class="character">您的政府信息风机表将显示在此处</div>
                    </div>
                    <div class="img_preview">
                        <table><tr><td id="imgOfficialLetter"></td></tr></table>
                        <i></i>
                        <div class="character">您的申请公函将显示在此处</div>
                    </div>
           		</div>
        
        </div>
        
        <div class="user_table">
        	<table>
            	<tr class="tr_one">
                	<td class="td_one"><label>*</label><span>运行者姓名</span></td>
                	<td class="td_two"><input id="releName" name="markerName" class="input_text true_name" type="text" onblur="verifyName();"/><label class="label_remind" id="nameRemind"></label></td>
                </tr>
            	
                
            	<tr class="tr_two">
                	<td class="td_one"><label>*</label><span>运行者身份证号</span></td>
                	<td class="td_two" colspan="2">
                    	<div class="divinput">
                        	<input id="identityCard"  name="markerIDCard" class="input_text identity_card" type="text" onblur="verifyIdentity('identityCard');"/>
                    		<span>您的证件信息我们不会透漏给任何人，仅用于实名认证</span>
                        </div>
                        <div class="divRemindIdentity"><label class="label_remind" id="identityRemind"></label></div>
                    </td>
                </tr>
                
                <tr class="tr_three">
                	<td class="td_one" valign="top"><label>*</label><span>证件照片</span></td>
                	<td class="td_two">
                    	<div class="photograph_left">
                        	<img src="<%=basePath %>back/pubimg/images/identityPhotograph.jpg"/>
                        </div>
                    	<div class="photograph_right">
                        	<div class="character_right">身份证上的所有信息必须清晰可见，照片需免冠，未化妆，手持证件人的五官清晰可见。照片内容必须真实，不得做任何图像处理、修改。支持jpg、jpeg、bmp、gif格式，大小不超过5M。</div>
                        	<div class="upload_right">
                            	<input type="button" value="上传证件照"  class="upload_pho" id="uploadBut" onclick="uploadPhotographImg(this,'imgPpreviewPhotograph','uploadSuccessIcow','uploadRemind');"/>
                            	<span class="span_upPho" id="uploadSuccessIcow">上传成功</span>
                                <label class="label_remind" id="uploadRemind"></label>
                            </div>
                        </div>
                    </td>
                    <td class="td_three" rowspan="4">
                    	<div class="img_preview">
                        	<table><tr><td id="imgPpreviewPhotograph"></td></tr></table>
                            <i></i>
                        	<div class="character">您的身份证件将显示在此处</div>
                        </div>
                    </td>
                </tr>
            
            	<tr class="tr_info">
                	<td class="td_one"><label>*</label><span>部门职务</span></td>
                	<td class="td_two">
                    	<input id="departmentDuty" name="markerduty" class="input_text department_duty" type="text" onblur="verifyDepartmentDuty();"/>
                    	<label class="label_remind" id="departmentDutyRemind"></label>
                    </td>
                </tr>
                
            	<tr class="tr_info">
                	<td class="td_one"><label>*</label><span>手机号码</span></td>
                	<td class="td_two">
                    	<input id="mobilePhone" name="mobile" class="input_text mobile_phone" type="text" onblur="verifyMobilePhone();"
                         					onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}"  
                                            onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'0')}else{this.value=this.value.replace(/\D/g,'')}"/>
                    	<label class="label_remind" id="mobilePhoneRemind"></label>
                    </td>
                </tr>
                
                <tr class="tr_info">
                	<td class="td_one"><label>*</label><span>验证码</span></td>
                	<td class="td_two">
                    	<input id="verificationCodeT" class="input_text verification_codeT" type="text" onblur=""  disabled="disabled"  onblur="verifyCode('verificationCodeT');"/>
                    	<input id="verificationCodeB" class="verification_codeB" type="button" value="获取验证码" onclick="achieveMobile('verificationCodeT','mobilePhone','userId');"/>
                        <label class="label_remind" id="verificationCodeRemind"></label>
                    </td>
                </tr>
                
                <tr class="tr_info">
                	<td class="td_one"><span>固定电话</span></td>
                	<td class="td_two">
                    	<input id="areaCode" name="areaCode" class="input_text area_code" type="text" 
                        					onfocus="if(this.value=='区') this.value='';this.style.color='#000'" 
                                            onblur="if(this.value=='') {this.value='区';this.style.color='#7f7f7f'}" value="区"
                         					onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^0-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}"  
                                            onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^0-9]/g,'0')}else{this.value=this.value.replace(/\D/g,'')}"/>-
                    	<input id="phoneNumber" name="phoneNumber" class="input_text phone_number" type="text" 
                        					onfocus="if(this.value=='电话号码') this.value='';this.style.color='#000'" 
                                            onblur="if(this.value=='') {this.value='电话号码';this.style.color='#7f7f7f'}" value="电话号码"
                         					onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}"  
                                            onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'0')}else{this.value=this.value.replace(/\D/g,'')}"/>
                    </td>
                </tr>
            
                <tr class="tr_info">
                	<td class="td_one"><span>联系地址</span></td>
                	<td class="td_two">
                    	<input id="relationAddress" name="residence" class="input_text relation_address" type="text"/>
                    </td>
                </tr>
                
                <tr class="tr_info">
                	<td class="td_one"><span>QQ号码</span></td>
                	<td class="td_two">
                    	<input id="qqNum" name="qq" class="input_text qq_num" type="text"
                         					onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}"  
                                            onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'0')}else{this.value=this.value.replace(/\D/g,'')}"/>
                    </td>
                </tr>
                
                <tr class="tr_button">
                	<td class="td_button" colspan="3"><span>您所提交的信息将作为您今后交易、提现、权利保护等行为的唯一信息来源。请务必填写真实邮箱信息。</span></td>
                </tr>
            </table>
        </div>
        
        
        <div class="submit">
               <div class="inp">
               		<input class="inputup" type="button" value="取消"/>
					<input class="finished" type="button" value="提交" onclick="govermentsubmit();"/>
               </div>
        </div>
        </form>
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
            	<img src="<%=basePath %>public/images/weixin.png"/>
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
<script src="../../../public/js/DD_belatedPNG_0.0.8a.js" type="text/javascript"></script>
    <script type="text/javascript">
        DD_belatedPNG.fix('div, ul, img, li, input , a , i');
    </script>
<![endif]-->
</body>
</html>

