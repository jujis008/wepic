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

<title>wepic管理员_资金_总概况</title>

<script type="text/javascript" src="<%=basePath %>public/js/jquery.js"></script>




<!--公共js-->

<script type="text/javascript" src="<%=basePath %>administrator/publicAdministrator/js/publicAdministrator.js"></script>

<!--公共css-->
<link type="text/css" rel="stylesheet" href="<%=basePath %>administrator/publicAdministrator/css/publicAdministrator.css" />
<link type="text/css" rel="stylesheet" href="<%=basePath %>public/css/public.css" />


<link type="text/css" rel="stylesheet" href="<%=basePath %>administrator/capital/css/withdrawDepositList.css" />




 <link type="text/css" rel="stylesheet" href="<%=basePath %>back/pubimg/css/lyz.calendar.css"  />
    <script src="<%=basePath %>public/js/lyz.calendar.min.js" type="text/javascript"></script>
<script>
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
		return;
		}
		
	if(endTimeV >= startTimeV){
		alert("成功去查询");
		$(".withdrawDeposit_cont_char").show();
		return;
		}
	
	}

function trimH(str) { 
	var re = new RegExp("[-]", "g");			

	return str=str.replace(re, "");
  
} 
</script>

</head>

<body>
<div id="container">
	
    
<!-- 头部结束-->
	<!-- logo行-->
    <div id="divTop">
    	<div class="divtop">
        	<div class="divLogo">
                <a class="imgLogo" href="http://www.wepic.cn/" target="_self" title="唯图网_商业拍摄 原创商业图片交易平台">
                    <img src="<%=basePath %>public/images/wepic_logo.png" alt="唯图网"/>
                    <p><span class="spanLogo">商业拍摄</span><span>原创商业图片交易平台</p>
                </a>
            </div>
            
            <div class="divAdminSpan">
                <span class="center">管理员中心</span>
                <span>V.2.0.0</span>
            </div>
            
            <div class="divTopPperation">
                <div class="left">
                	<div class="one">SuperAdmin</div>
                	<div class="two">超级管理员</div>
                </div>
                <div class="configuration">
                	<a href="javascript:">
                    	<div class="config"></div>
						<p>配置中心</p>
                    </a>
                </div>
                <div class="divExit">
                	<a href="javascript:">
                    	<div class="exit"></div>
						<p>安全退出</p>
                    </a>
                </div>
            </div>
    	</div>
    
                    
   	</div>
    <!-- logo行-->
    
    
    
    
    <!-- 分割线-->
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
    
	
    <!-- 导航 -->
  	<div id="mainbar">
    	<div id="mainbarCenter">
    		<ul>
        		<li id="index">
            		<a href="javascript:">首页</a>
            	</li>
            	<li id="user">
            		<a href="<%=basePath %>administrator/user/adminCheckPersonalList.jsp">用户</a>
            	</li>
            	<li id="production">
            		<a href="<%=basePath %>administrator/production/story/shootStoryAuthstrList.jsp">作品</a>
           	 	</li>
            	<li id="project">
            		<a href="javascript:">项目</a>
            	</li>
                <li id="capital" class="active">
            		<a href="<%=basePath %>administrator/capital/captialadminlist.jsp">资金</a>
            	</li>
            	<li id="transaction">
            		<a href="javascript:">交易</a>
           	 	</li>
            	<li id="complaint">
            		<a href="javascript:">投诉</a>
            	</li>
                <li id="subscription">
            		<a href="javascript:">订阅</a>
            	</li>
                <li id="message">
            		<a href="javascript:">消息</a>
            	</li>
        	</ul>
            
            <div class="onLine">
                <span>当前在线：</span>
                <span>423432</span>人
            </div>
        </div>
        
        
	</div>
    <!-- 导航  end-->
    
     <!-- 二级导航 -->
  	<div id="assistantBar">
    	<div class="twoStage" id="divTwoStage">
       	 	<a href="userSituationIndex.html"><div class='bar active'><span>资金总览</span><i></i></div></a>
            
        	<a href="<%=basePath %>accountWithdraw!adminwithdrawlist.do"><div class='bar'><span>提现列表</span><i></i></div></a>
            
            <a href="autonymAttestationCheckPresonalList.html"><div class='bar'><span>发票列表</span><i></i></div></a>
            
            <a href="userDateIndex.html"><div class='bar'><span>转账支付</span><i></i></div></a>
            
        </div>
    	
        <div id="divThreeStage">
        
            <div class="threeStage">
                <a href="<%=basePath %>accountWithdraw!adminwaitingwithdrawlist.do"><div class='bar active'><span>提现待审核</span><i></i></div></a>
                <a href="autonymAttestationCheckEnterpriseList.html"><div class='bar'><span>已通过审核提现</span><i></i></div></a>
                
                <a href="autonymAttestationCheckPresonalNoPassList.html"><div class='bar'><span>未通过审核</span><i></i></div></a>
                
            </div>
        </div>
    </div>
    <!-- 二级导航  end-->
    
    
    
    
    
    <!--内容-->
    <div class="withdrawDeposit_record">
    	<div class="withdrawDeposit_record_top">
    	            <form action="searchaboutaccount!adminsearchbydate.do" method="post" id="searchaccountwithdraw">
    	            <input type="hidden" name="startdate" id="startdate" value="<s:property value="startdate"/>" />
    	            <input type="hidden" name="enddate" id="enddate" value="<s:property value="enddate"/>"/>
	            	</form>
        	<table>
            	<tr>
                	<td class="char">待审核提现列表</td>
                	<td class="totalwith">当前提现总额：<span><s:property value="totalMoney"/></span>元</td>
                	<td class="char_start_end">起止日期：</td>
                	<td id="choseTime"><input class="timeInputStr" id="txtBeginDate" type="text"/>-</td>
                	<td id="choseTime2"><input class="timeInputStr" id="txtEndDate" type="text"/></td>
                    
                	<td class="inquire_td"><input class="inquire" type="button" value="查询" onclick="query();"/></td>
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
                    <th>序号</th>
                    <th>提现编号</th>
                    <th>申请用户</th>
                    <th>用户总额</th>
                    <th>冻结金额</th>
                    <th>可用金额</th>
                    <th>充值总额</th>
                    <th>提现总额</th>
                    <th>申请提现金额</th>
                    <th>操作</th>
                    
                </tr>
               <s:iterator value="pager.resultList" var="list" status="statu">
               <tr>
                    <td><s:property value="#statu.count"/></td>
                    
                    <td><span><s:property value="#list.serialnumber"/></span></td>
                    
                    <td><span class="name"><s:property value="#list.account.user.username"/></span></td>
                    
                    <td><span><s:property value="#list.account.totalMoney"/></span></td>
                    
                    <td><span><s:property value="#list.account.totalMoney - #list.account.remainingMoney"/></span></td>
                    
                    <td><span><s:property value="#list.account.remainingMoney"/></span></td>
                    
                    <td><span>21454234</span></td>
                    
                    <td><span><s:property value="#list.totalwithdrawMoney"/></span></td>
                    
                    <td><span class="money"><s:property value="#list.withdrawMoney"/></span></td>
                    
                    <td class="td_opt">
                    	<a class="view" href="javascript:">查看</a>
                    
                    	<a class="pass" href="javascript:">通过</a>
                    
                    	<a class="nopass" href="javascript:">不通过</a>
                    </td>
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
                    	<td class="ppointPagingOne"><a href="accountWithdraw!adminwaitingwithdrawlist.do?pageNo=1"></a></td>
                    	<s:if test="pager.pageCount ==1">
                        <td class="ppointPagingPre"><a href="accountWithdraw!adminwaitingwithdrawlist.do?pageNo=1"></a></td>
                        </s:if>
                        <s:else>
                        <td class="ppointPagingPre"><a href="accountWithdraw!adminwaitingwithdrawlist.do?pageNo=<s:property value='pager.prePageNo'/>"></a></td>
                        </s:else>
         <s:param name="first" value="1"/>  
          <s:param name="last" value="pager.pageCount"/>  
          <s:iterator>  
          <s:if test="pager.pageNo==current-1">
          <td class="ppointPagingN"><a href="accountWithdraw!adminwaitingwithdrawlist.do?pageNo=<s:property />"><s:property /></a></td>
          </s:if>
          <s:else>
            <td class="ppointPagingN"><a href="accountWithdraw!adminwaitingwithdrawlist.do?pageNo=<s:property />"><s:property /></a></td>
          </s:else>
           </s:iterator> 	
           <s:if test="pager.pageCount ==1"> 
           <td class="ppointPagingNext"><a href="accountWithdraw!adminwaitingwithdrawlist.do?pageNo=1"></a></td>
           </s:if>
           <s:else >
           <td class="ppointPagingNext"><a href="accountWithdraw!adminwaitingwithdrawlist.do?pageNo=<s:property value='pager.nextPageNo'/>"></a></td>
           </s:else>
           <td class="ppointPagingLast"><a href="accountWithdraw!adminwaitingwithdrawlist.do?pageNo=<s:property value='pager.pageCount'/>"></a></td>
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
    <div id="divFooter">
    	<div class="divfooter">
        	<a href="http://www.wepic.cn"  target="_blank" class="toIndex">网站首页</a>|
        	<a href="http://www.cnzz.com"  target="_blank" class="toStation">站长统计</a>|
            <a href="http://tongji.baidu.com/web/welcome/login"  target="_blank" class="toBaiduStation">百度站长工具</a>|
            <a href="http://e.baidu.com" target="_blank" class="toBaiduGeneralize">百度推广</a>
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

