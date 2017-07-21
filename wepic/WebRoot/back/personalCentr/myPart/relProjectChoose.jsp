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

<title>wepic管理_个人中心_我的约拍_选择要发布项目类型</title>

<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/jquery.js"></script>




<script type="text/javascript">
window.onload = function(){

	var htmlWidth = document.body.clientWidth;
	var htmlHeight = document.body.clientHeight;
	var borwerViewWidth =  document.documentElement.clientWidth;
	var borwerViewHeight =  document.documentElement.clientHeight;
	
	
	var getwidth = parseInt($("#divChoseUser").css("width"));
	var getheight = parseInt($("#divChoseUser").css("height"));
	
	var topWidth = (borwerViewWidth - getwidth)/2;
	var topHeight = (borwerViewHeight - getheight)/ 2;
	
	
	$("#divChoseUser").css({"position": "absolute","z-index":"10000","top":200 + "px" , "left": topWidth+"px"});
	
	}
	
function cloosePopBox(obj){
	window.location.href='<%=request.getHeader("REFERER")%>'
	}
</script>

<style type="text/css">
body{
	background:#333333;
	}
*{padding:0;margin:0;}
.userBox{
	left: 0;
    position: relative;
    top: 0;
	width:876px;
	height:370px;
	background:#ffffff;
	}
.userBox .top {
    background:#F6F6F6;
    border-bottom: 1px solid #E3E3E3;
    height: 56px;
    left: 0;
    position: relative;
    top: 0;
    width: 876px;
}
.userBox .top h2 {
    color: #585858;
    font-family: "微软雅黑";
    font-size: 22px;
    font-weight: normal;
    height: 56px;
    line-height: 56px;
    padding-left: 30px;
    width: 500px;
	text-align:left;
	}
.userBox .top a {
    background:url(${pageContext.request.contextPath}/public/images/closeBox.png) no-repeat 0 0;
    height: 56px;
    position: absolute;
    right: 0;
    top: 0;
    width: 58px;
	}
.userBox .top a:hover{
	background:url(${pageContext.request.contextPath}/public/images/closeBox.png) no-repeat 0 -58px;
	}
.userBox .top a:active{
	background:url(${pageContext.request.contextPath}/public/images/closeBox.png) no-repeat 0 -116px;
	}
.userBox .ico {
    height: 314px;
    left: 0;
    position: relative;
    top: 0;
    width: 876px;
}
.userBox .ico .icoa{
    width: 218px;
	text-align:center;
	margin:0 auto;
	margin-top:45px;
	float:left;
	}
.userBox .ico .icoa p{
	font-family:"微软雅黑";
	color:#595959;
	margin-top:30px;
	}
.userBox .ico input{
    width: 115px;
    height: 115px;
	display:inline-block;
	cursor:pointer;
	border:0;
	}
.userBox .ico .pho{
	background:url(${pageContext.request.contextPath}/back/pubimg/images/chooserel.png) 0 0 no-repeat;
	}
.userBox .ico .pho:hover{
	background:url(${pageContext.request.contextPath}/back/pubimg/images/chooserel.png) 0 -357px no-repeat;
	}
.userBox .ico .phoOuter{
	background:url(${pageContext.request.contextPath}/back/pubimg/images/chooserel.png) 0 -714px no-repeat;
	}
.userBox .ico .phoOuter:hover{
	background:url(${pageContext.request.contextPath}/back/pubimg/images/chooserel.png) 0 -832px no-repeat;
	}
.userBox .ico .work{
	background:url(${pageContext.request.contextPath}/back/pubimg/images/chooserel.png) 0 -119px no-repeat;
	}
.userBox .ico .work:hover{
	background:url(${pageContext.request.contextPath}/back/pubimg/images/chooserel.png) 0 -476px no-repeat;
	}
.userBox .ico .talents{
	background:url(${pageContext.request.contextPath}/back/pubimg/images/chooserel.png) 0 -238px no-repeat;
	}
.userBox .ico .talents:hover{
	background:url(${pageContext.request.contextPath}/back/pubimg/images/chooserel.png) 0 -594px no-repeat;
	}
</style>
</head>


<body>

<!--[if lte IE 6]>
<script src="${pageContext.request.contextPath}/public/js/DD_belatedPNG_0.0.8a.js" type="text/javascript"></script>
    <script type="text/javascript">
        DD_belatedPNG.fix('div, ul, img, li, input , a , i');
    </script>
<![endif]-->

<form action="">
	<div class="userBox" id="divChoseUser">
		<div class="top">
    		<h2>选择发布项目类型</h2>
			<a class="closeUserBox" href="javascript:cloosePopBox();"></a>
   	 	</div>
    	
    	<div class="ico">
    	
    	<s:iterator value="bidcats">
        	<div class="icoa">
        	<s:if test="discription=='bid'">
	    		<input type= "button" class="pho" value="" onclick="subForm(this,'${pageContext.request.contextPath}/catBid!findByParentId.do')"/>
                 <input type="hidden" value="<s:property value="id"/>" />
              <p><s:property value="name"/></p>
              </s:if>
              <s:if test="discription=='subcrib'">
	    	<input type= "button" class="phoOuter" onclick="subForm(this,'${pageContext.request.contextPath}/catBid!findByParentId.do')"/>
             <input type="hidden" value="<s:property value="id"/>" />
              <p><s:property value="name"/></p>
              </s:if>
              <s:if test="discription=='photogrphy'">
	    		<input type= "button" class="work" onclick="subForm(this,'${pageContext.request.contextPath}/catBid!findByParentId.do')"/>
              <input type="hidden" value="<s:property value="id"/>" />
               <p><s:property value="name"/></p>
              </s:if>
              <s:if test="discription=='model'">
	    		<input type= "button" class="talents" onclick="subForm(this,'${pageContext.request.contextPath}/catBid!findByParentId.do')"/>
               <input type="hidden" value="<s:property value="id"/>" />
               <p><s:property value="name"/></p>
              </s:if>
                
               
            </div>
            <!-- rrr   ee         <div class="icoa">
	    		<input type= "button" class="phoOuter" onclick="this.form.action = 'choosePhoType.html';this.form.submit()"/>
                <p>外拍活动</p>
            </div>
            <div class="icoa">
    	    	<input type= "button" class="work" onclick="this.form.action = 'chooseWorkType.html';this.form.submit()"/>
                <p>征集作品</p>
            </div>
            <div class="icoa">
    	    	<input type= "button" class="talents" onclick="this.form.action = 'chooseModelType.html';this.form.submit()"/>
                <p>找模特</p>
            </div>
             -->
            
            </s:iterator>
            <input type="hidden"  name="id" id="catId"/> 
	    </div>
	</div>
</form>  


<script type="text/javascript">
function subForm(obj,url){
	$("#catId").val($(obj).next().val());
	obj.form.action = url//'?';
	obj.form.submit()
	

}


</script>  
</body>
</html>
