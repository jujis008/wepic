<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib  prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>唯图网  欢迎您</title>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/public/images/logoSmall.ico"/>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/back/loginRegister/css/login.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}//public/js/jquery.min.js"></script>

<!--公共js-->
<script type="text/javascript" src="${pageContext.request.contextPath}//public/js/topBar.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}//public/js/header.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}//public/js/public.js"></script>


<!--公共css-->
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}//public/css/footer.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}//public/css/header.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}//public/css/registerLogin.css" />

<script language="javascript">
$(function(){
	document.getElementById("formLogin").reset();		//form表单重置
    var urls=window.location.href;
     urls=urls.split("url=");
     $("#url").val(urls[1]);



	
	
	});



function refreshcode(){
	 document.getElementById("codeImg").src="user!validateCode.do?update="+Math.random();
	 return false;
	}



</script>


</head>

<body>
<div id="container">
	<!-- 头部开始						样式在	registerLogin.css -->						
    <div id="topBar">
	<div id="topbar">
    	<div id="topcenterbar">
        	<div id="topbarCollect">
    			<a id="topcollect" href="javascript:addToFavorite('http://www.wepic.cn/','唯图网_商业拍摄 原创商业图片交易平台')">
                	<span>收藏唯图</span>			
        		</a>
       		</div>
            
            <div id="topbarRegisterLogin">
            	<a href="${pageContext.request.contextPath}/back/loginRegister/login.jsp" id="topbarLogin"><span>登录</span></a>
                <a href="${pageContext.request.contextPath}/back/loginRegister/register.jsp" id="topbarRegister"><span>注册</span></a>
            </div>
        </div>
    </div>
    </div>
    <!-- 头部结尾 -->
    
<!-- logo开始					样式在	header.css -->
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
    
    
    <!-- 注册开始 -->
    <div id="divLogin">
    <form action="user!loginformWinth.do" id="formLogin" method="post">
   	<div id="divLoginContent">
        <input name="url" id="url" type="hidden"/>
    	<div id="divRegisterTitle">
            <span>登录唯图网</span>
        </div>
    	<span style="color:red">
    	<s:property value="errorMap['vlidateCode']"/>
    	<s:property value="errorMap['userError']"/>
    	</span>
        <div id="divUserName">
        
			<input id="inputUserName" class="text" type="text"  name="username" value="邮箱/用户名/手机号" onblur="if(this.value=='') {this.value='邮箱/用户名/手机号';this.style.color='#7f7f7f'}" onfocus="if(this.value=='邮箱/用户名/手机号') this.value='';this.style.color='#333'"/>
            <i class="i-name" id="i-name"></i>
		</div>
        
        <div id="divUserPassword">
			<input id="inputPassword" class="text" type="password" value="" name="password"/>
            <i class="i-name" id="i-password"></i>
		</div>
		 <div id="code" style="text-align: left">
			<input id="code1" class="text" type="text" name="vlidateCode" value="" style="width:100px;margin-left:78px;">
          <img id="codeImg"  src="user!validateCode.do" title="看不清楚？换一张"  style="cursor : pointer; vertical-align: middle;" onclick="return refreshcode()" ></img>
		</div>
        <div id="divLoginSubmit">
        	<div id="divLoginSubmitA">
        
        	 	<s:if test="#session.openID==null&&#session.weiboOpenId==null"> 
            	<input type="submit" value="登录"  id="loginSubmit"/>
            	</s:if>
            	<s:else>
            	<input type="submit" value="绑定账户"  id="loginSubmit"/>
            	
            	
            	</s:else>
            </div>
        </div>
        
        <div id="divSecrchPassword">
            <a href="javascript:">忘记密码</a>
            <a href="${pageContext.request.contextPath}/back/loginRegister/register.jsp" class="regedit">注册账户</a>
        </div>
        
        <div id="quickLogin">
        	<a href="${pageContext.request.contextPath}/back/loginRegister/sendqqLogin.jsp"> 
        	<div class="qq"><i></i><span>使用QQ登录</span></div></a>
        	<a href="${pageContext.request.contextPath}/back/loginRegister/sendWeibo.jsp"> 
            <div class="sina"><i></i><span>新浪微博登录</span></div>
            </a>
            
        </div>
    </div>
 	</form>
    </div>
    
    
    
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
        DD_belatedPNG.fix('div, ul, img, li, input , a');
    </script>
<![endif]-->
</body>
</html>
