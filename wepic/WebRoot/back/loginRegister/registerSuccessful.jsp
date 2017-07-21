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
<link rel="shortcut icon" href="${pageContext.request.contextPath}//public/images/logoSmall.ico"/>
<title>唯图网  账户激活成功</title>

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/back/loginRegister/css/registerSuccessful.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/back/loginRegister/js/registerSuccess.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/jquery.js"></script>

<!--公共js-->
<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/topBar.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/header.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/public.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/jquery.js"></script>


<!--公共css-->
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public/css/topBarMain.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public/css/header.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public/css/footer.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public/css/registerLogin.css" />


<script>
window.onload = function(){

	
	divLiBar("divTopBarContainer");   //展开头部右边详细
	
	divLiBar("topBarShoppingDetailed");   //头部购物车展开列表背景
	
	userBuyCart();
	}
function tiaozhuan(){

	window.location.href="${pageContext.request.contextPath}/user!getFistPageUserInfo.do"


	
}
</script>


</head>

<body>
<div id="container">
	<!-- 头部开始						样式在	registerLogin.css -->	
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
                    	<a href="javascript:"><span><s:property value="user.nickName"/>  </span><i></i></a>
                    </div>
                    
                	<div id="topBarUserDetailed">
                    	<div id="topBarUserOne">
                        	<div id="topBarUserOneHead">
                            	<img src="${pageContext.request.contextPath}//public/images/pic/topUser.jpg" />
                                <div id="topBarUserOneHeadChange">
                                	<div><a href="${pageContext.request.contextPath}/back/personalCentr/user/accountPic.jsp">更改头像</a></div>
                                </div>
                            </div>
                            <div id="topBarUserOneDetailed">
                            	<div id="topBarUserOneDetailedOne">
                                	<img id="topBarUserOneDetailedimg" src="${pageContext.request.contextPath}//public/images/grade/uesrLogo.png"/>
                                   
                                    <a href="${pageContext.request.contextPath}/user!getFistPageUserInfo.do" id="topBarUserOneComeZom">进入空间</a>
                                    <a href="${pageContext.request.contextPath}/loginout.do" id="topBarUserOneExit">退出登录</a>
                                </div>
                                <div id="topBarUserOneDetailedTwo">
                                	<div id="topBarUserInfo">
                                    	<span> <a href="javascript:void(0)">去设置个性信息</a>  </span>
                                    </div>
                                    <div id="topBarUserAccount">
                                    	<span>余额：</span>&nbsp;&nbsp;
                                        <span is="topBarUserAccountYE">0</span>
                                        <a href="javascript:" id="topBarUserAccountcz">充值</a>
                                        <a href="javascript:" id="topBarUserAccounttx">提现</a>
                                    </div>
                                    <div id="topBarUserPart">
                                    	
                                    </div>
                                </div>
                            </div>
                            
                            <div id="topBarUserTwo">
                            	<div class="topBarUserTwo" id="topBarUserFollowed">
                                	<p class="topBarUserTwoPOne">0</p>
                                    <p class="topBarUserTwoPTwo">已关注</p>
                                </div>
                                <div class="topBarUserTwo" id="topBarUserFollower">
                                	<p class="topBarUserTwoPOne">0</p>
                                    <p class="topBarUserTwoPTwo">粉丝</p>
                                </div>
                                <div class="topBarUserTwo" id="topBarUserGoodDiscuss">
                                	<p class="topBarUserTwoPOne">0</p>
                                    <p class="topBarUserTwoPTwo">好评</p>
                                </div>
                                <div class="topBarUserTwo" id="topBarUserBadDiscuss">
                                	<p class="topBarUserTwoPOne">0</p>

                                    <p class="topBarUserTwoPTwo">差评</p>
                                </div>
                                
                                
                            </div>
                            
                            <div id="topBarUserThree">
                                	<div id="topBarUserThreeInOutCome">
                                    	<p><span class="topBarUserThreeInOutComeAtt">收入排名</span><span class="topBarUserThreeInOutComeNum">暂无排名</span></p>
                                        <p><span class="topBarUserThreeInOutComeAtt">支出排名</span><span class="topBarUserThreeInOutComeNum">暂无排名</span></p>
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
                    		<a href="#" id="topshopping">购物车<span>0</span>件<i></i></a>
                    	</div>
                        
                        <div id="topBarShoppingDetailed">
                        	
                            
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
	
    
<!-- logo开始					样式在	header.css -->
    <div id="header">
    	<div id="headerCenter">
        	<div id="divlogo">
    			<a id="imgLogo" href="http://www.wepic.cn/" target="_self" title="唯图网 商业拍摄 原创商业图片交易平台">
    				<img src="${pageContext.request.contextPath}//public/images/wepic_logo.png" alt="唯图网" title="唯图   "/>
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
<!-- logo结束 -->
	
    <!-- 分割线 					样式在	registerLogin.css-->
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
    
    
	<!-- 注册成功开始 -->
    <div id="divRegisterSuccessful">
    	<div id="divRegisterSuccessfulTitle">
        	<div id="successfulTitleWecom">
            	<span>欢迎来到唯图网</span>
            </div>
            <div id="successfulTitleInfo">
            	<p>您的邮箱<a href="javascript:"><span><s:property value="user.email"/></span></a>已通过验证，这是您第一次登录到唯图网，欢迎您的加入。</p>
            	<p id="successfulOrderTitle">您是否订阅以下内容：</p>
            </div>
        </div>
        
        <div id="divRegisterSuccessfulSubscribe">
        	<div id="divRegisterSuccessfulSubscribeCon">
            	<ul>
                	<li>
                    	<div class="divRegisterSuccessfulSubscribeIco" id="subscribeIcoOriginality"></div>
                        <div class="divRegisterSuccessfulSubscribeSubstance">
                        	<p class="substanceTitleP">创意图片</p>
                            <p class="substanceNumberP"><span class="substanceNumberS">5655665</span>人订阅</p>
                        	<input type="button"  class="substanceButton" value="+&nbsp;订阅"/>
                        </div>
                    	
                    </li>
                    <li>
                    	<div class="divRegisterSuccessfulSubscribeIco" id="subscribeIcoPhotograph"></div>
                        <div class="divRegisterSuccessfulSubscribeSubstance">
                        	<p class="substanceTitleP">摄影图片</p>
                            <p class="substanceNumberP"><span class="substanceNumberS">5655665</span>人订阅</p>
                        	<input type="button"  class="substanceButtonNot" value=" -&nbsp;取消订阅"/>
                        </div>
                    	
                    </li>
                    <li>
                    	<div class="divRegisterSuccessfulSubscribeIco" id="subscribeIcoPhotographStory"></div>
                        <div class="divRegisterSuccessfulSubscribeSubstance">
                        	<p class="substanceTitleP">摄影故事</p>
                            <p class="substanceNumberP"><span class="substanceNumberS">5655665</span>人订阅</p>
                        	<input type="button"  class="substanceButtonNot" value="+&nbsp;取消订阅"/>
                        </div>
                    	
                    </li>
                    <li>
                    	<div class="divRegisterSuccessfulSubscribeIco" id="subscribeIcoUpToPats"></div>
                        <div class="divRegisterSuccessfulSubscribeSubstance">
                        	<p class="substanceTitleP">最新约拍项目</p>
                            <p class="substanceNumberP"><span class="substanceNumberS">5655665</span>人订阅</p>
                        	<input type="button"  class="substanceButton" value="+&nbsp;订阅"/>
                        </div>
                    	
                    </li>
                    <li>
                    	<div class="divRegisterSuccessfulSubscribeIco" id="subscribeIcoRecruitPhotograph"></div>
                        <div class="divRegisterSuccessfulSubscribeSubstance">
                        	<p class="substanceTitleP">招募摄影师项目</p>
                            <p class="substanceNumberP"><span class="substanceNumberS">5655665</span>人订阅</p>
                        	<input type="button"  class="substanceButtonNot" value="+&nbsp;取消订阅"/>
                        </div>
                    	
                    </li>
                    <li>
                    	<div class="divRegisterSuccessfulSubscribeIco" id="subscribeIcoRecruitModel"></div>
                        <div class="divRegisterSuccessfulSubscribeSubstance">
                        	<p class="substanceTitleP">招募模特项目</p>
                            <p class="substanceNumberP"><span class="substanceNumberS">5655665</span>人订阅</p>
                        	<input type="button"  class="substanceButton" value="+&nbsp;订阅"/>
                        </div>
                    	
                    </li>
                    <li>
                    	<div class="divRegisterSuccessfulSubscribeIco" id="subscribeIcoPicCollect"></div>
                        <div class="divRegisterSuccessfulSubscribeSubstance">
                        	<p class="substanceTitleP">图片征集项目</p>
                            <p class="substanceNumberP"><span class="substanceNumberS">5655665</span>人订阅</p>
                        	<input type="button"  class="substanceButtonNot" value="+&nbsp;取消订阅"/>
                        </div>
                    	
                    </li>
                    <li>
                    	<div class="divRegisterSuccessfulSubscribeIco" id="subscribeIcoModelPhotographInfo"></div>
                        <div class="divRegisterSuccessfulSubscribeSubstance">
                        	<p class="substanceTitleP">模特/摄影资讯</p>
                            <p class="substanceNumberP"><span class="substanceNumberS">5655665</span>人订阅</p>
                        	<input type="button"  class="substanceButton" value="+&nbsp;订阅"/>
                        </div>
                    	
                    </li>
                </ul>
            </div>
        </div>
        
        <div id="divRegisterSuccessfulIntruction">
        	<div id="divRegisterSuccessfulIntructionCon">
            	<p id="divRegisterSuccessfulIntructionConOne">订阅说明：</p>
                <p class="divRegisterSuccessfulIntructionConP">一、您订阅的内容我们将会定期发送到您的邮箱，请注意查阅。</p>
                <p class="divRegisterSuccessfulIntructionConP">二、如想取消订阅，请到<a href="javascript:">个人中心</a>取消订阅。</p>
            </div>
            
            <div id="divRegisterSuccessfulGoPersonCen">
            	<input type="button" value="前往个人中心" id="buttonGoPersonCen" onclick="tiaozhuan()" />
            </div>
        </div>
    </div>
    
    
    <!-- 注册结束 -->
    
    
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
            	<img src="${pageContext.request.contextPath}//public/images/weixin.png"/>
                <p>微信公众账号</p>
            </div>
            
            <div id="DimensionCodeServer">
            	<p class="serverConStr">客服电话</p>
                <p id="serverPhone">400-809-9060</p>
                <p>（周一至周五：9:00-18:00）</p>
                <div id="serverShare">
                	<ul>
                    	<li><a href="javascript:" id="shareSina" class="shareSina"></a></li>
                        <li><a href="javascript:" id="shareQqzone" class="shareQqzone"></a></li>
                        <li><a href="javascript:" id="shareQqblog" class="shareQqblog"></a></li>
                        <li><a href="javascript:" id="shareTwitter" class="shareTwitter"></a></li>
                        <li><a href="javascript:" id="shareFacebook" class="shareFacebook"></a></li>
                        <li><a href="javascript:" id="shareRenren" class="shareRenren"></a></li>
                        <li><a href="javascript:" id="shareDouban" class="shareDouban"></a></li>
                    </ul>
                    	
                </div>
            </div>
        </div>
    </div>
    </div>
    <!--foot 结束-->
</div>
<div id="goTopBtn" style="display:none;"></div>
<!--[if lte IE 6]>
<script src="../public/js/DD_belatedPNG_0.0.8a.js" type="text/javascript"></script>
    <script type="text/javascript">
        DD_belatedPNG.fix('div, ul, img, li, input , a , i');
    </script>
<![endif]-->
</body>
</html>