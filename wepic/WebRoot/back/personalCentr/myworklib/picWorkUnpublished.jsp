<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib  prefix="s" uri="/struts-tags"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="shortcut icon" href="${pageContext.request.contextPath}/public/images/logoSmall.ico"/>

<title>wepic管理_个人中心_我的作品库_图片作品_未发布详情</title>



<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/back/pubimg/css/backMainBar.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/back/personalCentr/myworklib/css/picWorkUnpublished.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/imgsf.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/back/personalCentr/myworklib/js/picWorkReleased.js"></script>




<!--公共js-->
<script type="text/javascript" src="${pageContext.request.contextPath}/back//js/publicBack.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/public.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/topBar.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/header.js"></script>


<!--公共css-->
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public/css/topBarMain.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public/css/header.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public/css/footer.css" />

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/pubimg/css/index.css" />








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
                            	<img src="${pageContext.request.contextPath}/public/images/pic/topUser.jpg" />
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
            
            <a href="javascript:"><div class='bar active'><span>图片作品</span><i></i></div></a>
            
            <a href="javascript:"><div class='bar'><span>摄影故事</span><i></i></div></a>
            
            <a href="javascript:"><div class='bar'><span>视频作品</span><i></i></div></a>
            
            <a href="javascript:"><div class='bar'><span>上传作品</span><i></i></div></a>
            
            <a href="javascript:"><div class='bar'><span>创建故事</span><i></i></div></a>
            
            <a href="javascript:"><div class='bar'><span>发布作品</span><i></i></div></a>
        </div>
        </div>
    </div>
    <!-- 导航  end-->
    
    <!--内容-->
    <div id="divPhoStroyHead">
   		<div class="head">
            <table>
            	<tr>
                	<td class="td1">
                    	<div class="divdropDown">
                    		<div class="dropDownBox" id="dropDownBoxPartType" onclick="showBelow('divdropDownPartType')">
                    			<span id="divdropDownViewPartType"></span>
                        		<div class="dropDownBoxR"><i></i></div>
                    		</div>
                    
                    		<div class="dropDownBoxValue" id="divdropDownPartType">
                    			
                 			 </div>
                  		</div>
                    </td>
                	
                    <td class="td2"><a href="manageSpecial.html" class="glz">管理专辑</a></td>
                    <td class="td3">
                    	<span class="sp1">当前专辑作品数</span>
                    	<span class="num" id="totalPic">0</span>张
                    
                    	<span class="sp2">已发布</span>
                    	<span class="num" id="fabutotalPic">0</span>张
                    	
                    	<span class="sp2">显示顺序：</span>
                    	<span class="sp3">上传时间</span>
                    </td>
                </tr>
            
            </table>
            <div class="inp">
               	<input class="inputup" type="button" value="返回上一页"/>
            </div>
            
        </div>
            
    </div>
    
    <div id="previewPic">
    	<div class="scroll">
        	<a id="left_img_btn" class="s_pre" href="javascript:void(0)"></a>
      		<div class="current" id="current"></div>
      		<div class="outScroll_pic">
        		<ul class="scroll_pic cls" id="small_pic">
        			
        		</ul>
      		</div>
            <a id="right_img_btn" class="s_next" href="javascript:void(0)"></a> 
        </div>
    </div>   
        
        
        
        
        <!--摄影故事tss内容-->
        <div id="phoStroyDetail">
        
        
        	<div class="phoStroyDetailLeft"  id="phoStroyDetailLeft">
        		<div class="divPicimg">
        	
       				<ul class="imagebg" id="imagebg">
       					
       					
       			<li class="bannerbg" data-sPic="<s:property value="publish.thumbnail125"/>" id="<s:property value="publish.id"/>">
    					
      						<div class="bannerbg_main">
      							<img src="<s:property value="publish.smallPic"/>" onload="javascript:DrawImage(this,800,800)" />
						    </div>
    					</li>
    					
    					
       				<s:iterator value="pager.resultList" var="publish">
       				
    					<li class="bannerbg" data-sPic="<s:property value="#publish.thumbnail125"/>" id="<s:property value="#publish.id"/>">
    					
      						<div class="bannerbg_main">
      							<img src="<s:property value="#publish.smallPic"/>" onload="javascript:DrawImage(this,800,800)" />
						    </div>
    					</li>
    					</s:iterator>
    					
  					</ul>
        			
        		</div>
      
           <div class="edit" id="editzpgs">
                    	<div class="bj"></div>
                    	<div class="bjc">
                        	<div class="left">
                            	<div class="one">
                            		<a class="view" title="浏览次数"><span>0</span></a>
                                	<a class="collect" title="收藏次数"><span>0</span></a>
                            	</div>
                                <div class="two">
                            		<a class="good" title="推荐次数"><span>0</span></a>
                            	</div>
                                <div class="three">
                            		<span class="sp1">￥</span>使用权已出售<span class="sp2">0</span>次
                            	</div>
                            </div>
                            <div class="right">
                            	<a href="publish!downloadPic.do?id=<s:property value="publish.id"/>" class="dowload" id="downLoadPic">
                            		<div class="backimg"></div>
									<p>下载原图</p>
                            	</a>
                            	<a href="javascript:" class="delete">
                            		<div class="backimg"></div>
									<p>删除作品</p>
                           		</a>
                            </div>
                        	
                        </div>
                 </div>
                
                
            </div>
        
        <!--右部内容-->
         	<div class="phoStroyDetailRight">
        		               
                <div class="storyCon">
                	<div class="top" id="picNamechn"   title="<s:property value="publish.name"/>"><s:property value="publish.name"/></div>
                	<div class="head">
                        <div class="storyInfo" id="table1" >
                        	<table>
                            	<tr>
                                	<td><span>作品编号：</span></td>
                                    <td class="td2"><span><s:property value="publish.picNumber"/></span></td>
                                    <td><span>上传时间：</span></td>
                                    <td><span><s:property value="publish.upTime"/></span></td>
                                </tr>
                            	
                                <tr>
                                	<td><span>原始尺寸：</span></td> 
                                	
                                    <td><s:if test="#publish.logo==0"><span>
                                    
                                    <s:property value="publish.width"/>
                                    </span>*<span><s:property value="publish.height"/></span>px<span class="s">|</s:if></span><span><s:property value="publish.size"/></span>M</td>
                                </tr>
                            </table>
                        		
                        	
                        </div>
                    </div>
                    <div class="typeone" id="picInfo">
                    		<table>
                            	<tr>
                                	<td class="td1">作品类别</td>
                                    <td class="td2">
                                    <s:if test="publish.type==null||publish.type==''">
                                                                                                  暂无
                                    </s:if>
                                    <s:else>
                                    <s:if test="publish.type==3">
                                                                                                      摄影图片
                                     </s:if>
                                     <s:elseif test="publish.type==2">
                                                                                               创意图片
                                     </s:elseif>
                                   
                                    </s:else>
                                    
                                    </td>
                                	<td class="td3">所属专辑</td>
                                    <td class="td4">
                                      <s:property value="publish.publishSpecialCat.name"/>                                                                
                                    
                                    
                                    
                                    </td>
                                    <td class="td5"><a href="javascript:" onclick="openPopUpBox('moveTozj');">移动到</a></td>
                                </tr>
                            	
                                <tr>
                                	<td class="td1">作品状态</td>
                                    <td class="td2">未发布</td>
                                </tr>
                                
                                <tr>
                                	<td class="td1">作品说明</td>
                                	<td class="td2">
                                	<s:if test="publish.content!=null&&publish.content!=''">
                                	<s:property value="publish.content"/>
                                	</s:if><s:else>
                                	暂无
                                	
                                	</s:else>
                                	
                                	
                                	
                                	
                                	</td>
                                </tr>
                            </table>
                    </div>
                    
                    
                    <div class="gjctd" id="catpicInfo"> 
                    	<table>
                            	<tr>
                                	<td class="td1">作品类型</td>
                                    <td class="td2">
                                   
                                    <s:iterator value="publish.publishCats" var="cat">
                                    <s:property value="#cat.name"/>
                                    
                                    </s:iterator>
                                    
                                    </td>
                                </tr>
                            	
                                <tr>
                                	<td class="td1">关键词</td>
                                    <td class="td2" style="width:300px">
                                    
                                   <s:iterator value="publish.roleTags" var="roltag">
                                   
                                   <s:property value="#roltag.tag"/>
                                   
                                   
                                   </s:iterator> 
                                                                       
                                    
                                    
                                    </td>
                                </tr>
                                
                            </table>
                    </div>
                   
                    <div class="edt" id="changeedturl">
                    	<input class="inputyq" type="button" value="编辑属性" onclick="location.href='publish!findEditeUnPublish.do?id=<s:property value="publish.id"/>'"/>
						<input class="inputfb" type="button" value="发布该作品" onclick="location.href='publish!findEditePublish.do?id=<s:property value="publish.id"/>'"/>
                    </div>
                </div>
            </div>
       <!--右部内容-->
        
        
        </div>
        
        
        
        
        <!--摄影故事内容-->
    
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
    
    
    <div id="moveTozj">
    	<div class="top">
    		<h2>选择专辑</h2>
			<a href="javascript:cloosePopBox('moveTozj');"></a>
    	</div>
        
    	<div class="zhuanji" id="zhuanjiadd">
        	<ul>
            	<li>
                	<div class="special">
						<div class="tone tone1"></div>
						<div class="name">最炫名族风</div>
					</div>
                </li>
                
                <li>
                	<div class="special">
						<div class="tone tone2"></div>
						<div class="name">最炫名族风</div>
					</div>
                </li>
                
                <li>
                	<div class="special">
						<div class="tone tone3"></div>
						<div class="name">最炫名族风</div>
                        
					</div>
                </li>
                
                <li>
                	<div class="special">
						<div class="tone tone4"></div>
						<div class="name">最炫名族风</div>
					</div>
                </li>
                <li>
                	<div class="special">
						<div class="tone tone2"></div>
						<div class="name">最炫名族风</div>
					</div>
                </li>
                
                <li>
                	<div class="special">
						<div class="tone tone3"></div>
						<div class="name">最炫名族风</div>
                        
					</div>
                </li>
                
                <li>
                	<div class="special">
						<div class="tone tone4"></div>
						<div class="name">最炫名族风</div>
					</div>
                </li>
                <li>
                	<div class="special">
						<div class="tone tone2"></div>
						<div class="name">最炫名族风</div>
					</div>
                </li>
                
                <li>
                	<div class="special">
						<div class="tone tone3"></div>
						<div class="name">最炫名族风</div>
                        
					</div>
                </li>
                
                <li>
                	<div class="special">
						<div class="tone tone4"></div>
						<div class="name">最炫名族风</div>
					</div>
                </li>
                
            </ul>
    		
            
            <div class="divAddSpecial">
				<a href="manageSpecial.html">管理专辑</a>
			</div>
    	</div>
        
        <div class="tijaio">
        	<input class="reset" type="button" value="取消"  onclick="cloosePopBox('moveTozj');"/>
			<input class="sub" type="button" value="确定" onclick="cloosePopBox('moveTozj');"/>
    	</div>
    </div>
    
    
    
</div>
<!--[if lte IE 6]>
<script src="${pageContext.request.contextPath}/public/js/DD_belatedPNG_0.0.8a.js" type="text/javascript"></script>
    <script type="text/javascript">
        DD_belatedPNG.fix('div, ul, img, li, input , a , i');
    </script>
<![endif]-->

<!--焦点图结束-->
<script type="text/javascript" src="${pageContext.request.contextPath}/back/js/jquery.imgSlider.js"></script>
<script type="text/javascript">
img.init();
img.play(0);
//阻止事件冒泡sssaa
function estop(e){
	var e=arguments.callee.caller.arguments[0]||event;
	if (e && e.stopPropagation){
	//因此它支持W3C的stopPropagation()方法
	   e.stopPropagation();
	}else{
	//否则，我们需要使用IE的方式来取消事件冒泡sss
	   window.event.cancelBubble = true;
	   return false;
	}
}




function changePicInfo(id){
    if(isNaN(id)){
      return ;
        }
//sss
	$.ajax({
		type : "POST",
		url : "jsonpublish_getPicInfo.do",
		data : "id="+id,				
		success : function(data) {
			
			var publish=data.publishTest;
			$("#picNamechn").html(publish.name);
			var type='暂无';
			if(publish.type==2){
				type="创意图片";
				}
			else if(publish.type==3){
            type="摄影图片";
				}
			var spcat=publish.publishSpecialCat.name;
			var content=publish.content;
			if(content==''||content==null){
             content='暂无';
				}
			
         var html='<table><tbody><tr>'+
          	'<td class="td1">作品类别</td>'+
            '<td class="td2">'+type+'</td>'+
        	'<td class="td3">所属专辑</td>'+
            '<td class="td4"> '+spcat+'   </td>'+
            '<td class="td5"><a onclick=openPopUpBox("moveTozj"); href="javascript:">移动到</a></td></tr>'+
            '<tr><td class="td1">作品状态</td><td class="td2">未发布</td></tr> <tr><td class="td1">作品说明</td><td class="td2">'+content+'</td></tr>'+
            '</tbody></table>'
            var tags=publish.roleTags;
            var tag="";
            if(tags!=null){
            for(var i=0;i<tags.length;i++){
            	 tag+="&nbsp"+tags[i].tag;
                }
            }
				if(tag==""){
					tag="暂无"
					}
		
          var cat=data.publishTest.publishCats;
          var catHtml="";
          if(cat!=null){
          for(var i=0;i<cat.length;i++){
        	  catHtml+=cat[i].name;
              }
          }
         if(catHtml==""){
        	 catHtml="暂无";
             }
				
            var table2='<table>	<tbody><tr><td class="td1">作品类型</td><td class="td2">'+catHtml+'</td></tr>'+
            '<tr><td class="td1">关键词</td><td style="width:300px" class="td2">'+tag+
             '</td></tr></tbody></table>';
             var sizeInfo="";
            if(publish.logo==0){
              sizeInfo='<span>'+publish.width+
              '</span>*<span>'+publish.height+'</span>px<span class="s">|'
              '</span><span>';
                }
 
          
             
            var table1='<table><tr><td><span>作品编号：</span></td><td class="td2"><span>'+publish.picNumber+
                '</span></td><td><span>上传时间：</span></td>'+
            '<td><span>'+publish.upTime+'</span></td></tr><tr>'+
        	'<td><span>原始尺寸：</span></td><td><span <span>'+sizeInfo+publish.size+'</span>M</td> </tr> </table>';



   




    
                 $("#downLoadPic").attr("href","publish!downloadPic.do?id="+publish.id)
        	 $("#table1").html(table1);
             
              $("#picInfo").html(html);
              $("#catpicInfo").html(table2);
              var editeButon='<input type="button" onclick=location.href="publish!findEditeUnPublish.do?id='+publish.id+'" value="编辑属性" class="inputyq">'+
                             '<input type="button" onclick=location.href="publish!findEditePublish.do?id='+publish.id+'" value="发布该作品" class="inputfb">';
              $("#changeedturl").html(editeButon);


              

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
			//swfupload.addPostParam("publishSpecialCatId",$(this).attr("id"))
			
			$("#"+showValue).html(this.innerHTML);
			$(bolewDiv).hide();
			$(bolewDiv).parent().parent().css("z-index","0");
			};
		}
}


$(function(){
    $("#divdropDownViewPartType").html("请选择");
	$.ajax({
	      type:"Post",
		  url: "specialcat_getpublishSpecialCats.do",
		  data:"",		
		  success : function(data) {
	  		  
	  	  var list=data.publishSpecialCats;
	  	  var html='<span class="dropValue">请选择</span>';
	  	  for(var i=0;i<list.length;i++){
	  	  	  publishCat=list[i];
	  		html+='<span class="dropValue" id='+publishCat.id+'>'+publishCat.name+'</span>';
	  	  	  } 

	  	    $("#divdropDownPartType").html(html);
	  	    achieveBelow("divdropDownPartType","divdropDownViewPartType");
	  		   
		  }
	});  	
    });


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


</script>
</body>
</html>
