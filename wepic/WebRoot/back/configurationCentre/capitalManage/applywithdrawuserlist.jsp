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

<title>wepic管理_配置中心_资金管理_提现记录</title>


<script type="text/javascript" src="<%=basePath %>public/js/jquery.js"></script>


<!--公共js-->
<script type="text/javascript" src="<%=basePath %>back/js/publicBack.js"></script>
<script type="text/javascript" src="<%=basePath %>public/js/public.js"></script>
<script type="text/javascript" src="<%=basePath %>public/js/topBar.js"></script>
<script type="text/javascript" src="<%=basePath %>public/js/header.js"></script>

<!--公共css-->
<link type="text/css" rel="stylesheet" href="<%=basePath %>back/pubimg/css/backMainBar.css" />
<link type="text/css" rel="stylesheet" href="<%=basePath %>public/css/topBarMain.css" />
<link type="text/css" rel="stylesheet" href="<%=basePath %>public/css/header.css" />
<link type="text/css" rel="stylesheet" href="<%=basePath %>public/css/footer.css" />
<link type="text/css" rel="stylesheet" href="<%=basePath %>public/css/public.css" />



<link type="text/css" rel="stylesheet" href="<%=basePath %>back/configurationCentre/capitalManage/css/withdrawDepositRecord.css" />
<script type="text/javascript" src="<%=basePath %>back/configurationCentre/capitalManage/js/withdrawDeposit.js"></script>


 <link type="text/css" rel="stylesheet" href="<%=basePath %>back/pubimg/css/lyz.calendar.css"  />
    <script src="<%=basePath %>public/js/lyz.calendar.min.js" type="text/javascript"></script>
<script>
$(function (){
var start='<s:property value="startdate"/>';
var end='<s:property value="enddate"/>';
if(start =="" && end ==""){
$(".withdrawDeposit_cont_char").hide();
}else{
$(".withdrawDeposit_cont_char").show();
$("#txtBeginDate").val(start);
$("#txtEndDate").val(end);
}
});
        $(function () {
			//表格奇偶数行背景颜色
			tableOddEvenBackground('#tableWithdrawDeposit'); 
			
			
			
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
               	addToDiv: "choseTime2"
                
            });
		
		
		
		});
		
function query(){
	var startTime = $("#txtBeginDate").val();
	var endTime = $("#txtEndDate").val();
	
	var startTimeV = parseInt(trimH(trim(startTime)));
	var endTimeV = parseInt(trimH(trim(endTime)));
	if(startTime == null || startTime == ''){
		alert("请选择开始日期");
		return;
		}
	if(endTime == null || endTime == ''){
		alert("请选择截止日期");
		return;
		}
	if(endTimeV < startTimeV){
		alert("请重新选择日期");
		$("#tableWithdrawDeposit").html("<tr><th class='td_one'>序号</th><th class='td_two'>时间</th><th class='td_three'>提现账户</th><th class='td_four'>流水号</th><th class='td_five'>提现金额（元）</th></tr>");
		return;
		}
	if(endTimeV >= startTimeV){
	    $(".withdrawDeposit_cont_char").show();
	    $("#startdate").val(startTime);
	    $("#enddate").val(endTime);
	    $("#searchaccountwithdraw").submit();
	    /*
	    <form action="searchaboutaccount!searchaccountwithdrawbydate.do" method="post" id="searchaccountwithdraw">
    	            <input type="hidden" name="startdate" id="startdate" />
    	            <input type="hidden" name="enddate" id="enddate" />
	            	<input type="hidden" name="accountId"  id="accountId" value="<s:property value="accountId"/>"/>
	            	</form>
	    */
	    
		}
	
	}

//去掉字符串头尾空格   
function trimH(str) { 
	var re = new RegExp("[-]", "g");			

	return str=str.replace(re, "");
  
} 

function accountwithdraw(){
location.href="accountWithdraw!applywithdraw.do";
}
function gobackList(){
	$(".withdrawDeposit_cont_char").hide();
	$("#txtBeginDate").val('');
	$("#txtEndDate").val('');
	location.href="<%=basePath %>accountWithdraw!userwithdrawlist.do";
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
            		<a href="../../html_newsCentre/partNews/partNewsIndex.html">消息中心</a>
           	 	</li>
            	<li id="myRoom">
            		<a href="../../html_myZone/myZoneIndex.html">我的空间</a>
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
        	<a href="<%=basePath %>configure!securityIndex.do"><div class='bar'><span>账户安全</span><i></i></div></a>
            
            <a href="<%=basePath %>account!cashoverview.do"><div class='bar active'><span>资金管理</span><i></i></div></a>
            
            <a href="javascript:"><div class='bar'><span>交易管理</span><i></i></div></a>
            
            <a href="javascript:"><div class='bar'><span>推广赚钱</span><i></i></div></a>
        </div>
    	
        <div id="divThreeStage">
            <div class="threeStage">
                <a href="<%=basePath %>account!cashoverview.do"><div class='bar'><span>资金概况</span><i></i></div></a>
                
                <a href="javascript:"><div class='bar'><span>充值记录</span><i></i></div></a>
                
                <a href="<%=basePath %>accountWithdraw!userwithdrawlist.do"><div class='bar active'><span>提现记录</span><i></i></div></a>
                
                <a href="javascript:"><div class='bar'><span>收入记录</span><i></i></div></a>
                
                <a href="javascript:"><div class='bar'><span>支出记录</span><i></i></div></a>
            </div>
        </div>
        
        
    </div>
    <!-- 导航  end-->
    
    <!--内容-->
    <div class="withdrawDeposit_record">
    	<div class="withdrawDeposit_record_top">
    	            <form action="searchaboutaccount!searchaccountwithdrawbydate.do" method="post" id="searchaccountwithdraw">
    	            <input type="hidden" name="startdate" id="startdate" value="<s:property value="startdate"/>" />
    	            <input type="hidden" name="enddate" id="enddate" value="<s:property value="enddate"/>"/>
	            	<input type="hidden" name="accountId"  id="accountId" value="<s:property value="accountId"/>"/>
	            	</form>
        	<table>
            	<tr>
                	<td class="char">提现记录</td>
                	<td class="totalwith">目前累计提现金额：<span> <s:property value="totalMoney"/> </span>元</td>
                	<td class="totalnt">累计提现次数：<span><s:property value="totalWithdrawNumber"/></span>次</td>
                	<td class="char_start_end">起止日期：</td>
                	<td id="choseTime"><input class="timeInputStr" id="txtBeginDate" type="text"/>-</td>
                	<td id="choseTime2"><input class="timeInputStr" id="txtEndDate" type="text"/></td>
                    
                	<td class="inquire_td"><input class="inquire" type="button" value="查询" onclick="query();"/></td>
                	<td class="deposit_td"><input class="recharge" type="button" value="申请提现" onclick="accountwithdraw()"/></td>
                </tr>
            </table>
        </div>
        
        
        <div class="withdrawDeposit_cont">
        <div class="withdrawDeposit_cont_char">
            	<span>当前累计提现金额：</span><span><s:property value="currenttotalMoney"/></span>元
            	<span class="count">当前累计提现次数：</span><span><s:property value="currenttotalWithdrawNumber"/></span>次
                <a class="gobackA" href="javascript:gobackList();">返回列表页面</a>
                
            </div>
            <table id="tableWithdrawDeposit">
            	<tr>
                    <th class="td_one">序号</th>
                    <th class="td_two">时间</th>
                    <th class="td_three">提现账户</th>
                    <th class="td_four">流水号</th>
                    <th class="td_five">提现金额（元）</th>
                    <th class="td_five">状态</th>
                </tr>
                <s:iterator value="pager.resultList" var="list" status="statu">
                <tr>
                    <td class="td_one"><s:property value="#statu.count"/></td>
                    
                    <td class="td_two"><span class="time"><s:date name="#list.withdrawTime" format="yyyy/MM/dd HH:mm:ss"/></span></td>
                    
                    <td class="td_three"><span><s:property value="#list.accountBankWithdraw.bankwithdrawbelongbank"/></span>
                    <span class="weihao">尾号: <s:property value="#list.accountBankWithdraw.bankwithdrawaccountNumber.substring(#list.accountBankWithdraw.bankwithdrawaccountNumber.length()-4,#list.accountBankWithdraw.bankwithdrawaccountNumber.length())"/>
                    </span>
                    </td>
                    
                    <td class="td_four"><span><s:property value="#list.serialnumber"/></span></td>
                    
                    <td class="td_five"><span><s:property value="#list.withdrawMoney"/></span></td>
                    <!-- 0申请提现失败(网络不通或 账户余额不够) 1 申请提现成功  2 管理员提现通过 3 管理员提现不通过 4体现通过之后打款失败  5管理员打款成功 -->
                    <s:if test="#list.status ==1">
                    <td class="td_five"><a class="check">审核中</a></td>
                    </s:if>
                    <s:if test="#list.status ==2">
                    <td class="td_five"><a class="success">成功</a></td>
                    </s:if>
                    <s:if test="#list.status ==3">
                    <td class="td_five">
                    	<div class="div_fail">
                        	<a href="javascript:" class="fail">失败</a>
                            <div class="fail_reason">
                            	<div class="sanjiao"></div>
                            	<p class="tit">失败原因：</p>
                                <p>账户信息不正账户信息不正确账户信息不正确账户信息不正确账户信息不正确确</p>
                            </div>
                        </div>
                    </td>
                    </s:if>
                </tr>
                </s:iterator>
        	</table>
        </div>
        
        
         <!--翻页-->
        <s:if test="pager.rowCount >= 20">
     <div class="ppointPagingthis">
        <div class="ppointPaging">            
            <table class="tablePpointPaging">
                	<tr>
                    	
                    	<s:bean name="org.apache.struts2.util.Counter" id="counter">  
                    	<td class="ppointPagingOne"><a href="accountWithdraw!userwithdrawlist.do?pageNo=1"></a></td>
                    	<s:if test="pager.pageCount ==1">
                        <td class="ppointPagingPre"><a href="accountWithdraw!userwithdrawlist.do?pageNo=1"></a></td>
                        </s:if>
                        <s:else>
                        <td class="ppointPagingPre"><a href="accountWithdraw!userwithdrawlist.do?pageNo=<s:property value='pager.prePageNo'/>"></a></td>
                        </s:else>
         <s:param name="first" value="1"/>  
          <s:param name="last" value="pager.pageCount"/>  
          <s:iterator>  
          <s:if test="pager.pageNo==current-1">
          <td class="ppointPagingN"><a href="accountWithdraw!userwithdrawlist.do?pageNo=<s:property />"><s:property /></a></td>
          </s:if>
          <s:else>
            <td class="ppointPagingN"><a href="accountWithdraw!userwithdrawlist.do?pageNo=<s:property />"><s:property /></a></td>
          </s:else>
           </s:iterator> 
           <s:if test="pager.pageCount ==1"> 
           <td class="ppointPagingNext"><a href="accountWithdraw!userwithdrawlist.do?pageNo=1"></a></td>
           </s:if>
           <s:else >
           <td class="ppointPagingNext"><a href="accountWithdraw!userwithdrawlist.do?pageNo=<s:property value='pager.nextPageNo'/>"></a></td>
           </s:else>
           <td class="ppointPagingLast"><a href="accountWithdraw!userwithdrawlist.do?pageNo=<s:property value='pager.pageCount'/>"></a></td>
            </s:bean>  
                    	
                    </tr>
                </table>
        </div>
        		</div>
        		</s:if>
         <!--翻页-->
         
         
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
<script src="<%=basePath %>public/js/DD_belatedPNG_0.0.8a.js" type="text/javascript"></script>
    <script type="text/javascript">
        DD_belatedPNG.fix('div, ul, img, li, input , a , i');
    </script>
<![endif]-->
</body>
</html>

