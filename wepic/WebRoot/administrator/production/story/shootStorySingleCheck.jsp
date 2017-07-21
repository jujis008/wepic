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

<title>wepic管理员_作品_摄影故事_单个审核</title>
<script type="text/javascript" src="<%=basePath %>public/js/imgsf.js"></script>
<script type="text/javascript" src="<%=basePath %>public/js/jquery.js"></script>




<!--公共js-->

<script type="text/javascript" src="<%=basePath %>administrator/publicAdministrator/js/publicAdministrator.js"></script>

<!--公共css-->
<link type="text/css" rel="stylesheet" href="<%=basePath %>administrator/publicAdministrator/css/publicAdministrator.css" />
<link type="text/css" rel="stylesheet" href="<%=basePath %>public/css/public.css" />



<script type="text/javascript" src="<%=basePath %>administrator/production/js/shootStorySingleCheck.js"></script>
<script type="text/javascript">
function storypass(id){
location.href="story!adminchecksuc.do?storyId="+id;
}
</script>

<link type="text/css" rel="stylesheet" href="<%=basePath %>administrator/production/css/shootStorySingleCheck.css" />
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
            	<li id="production" class="active">
            		<a href="<%=basePath %>administrator/production/story/shootStoryAuthstrList.jsp">作品</a>
           	 	</li>
            	<li id="project">
            		<a href="javascript:">项目</a>
            	</li>
                <li id="capital">
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
        	<a href="<%=basePath %>publish!adminCheckPhotoPic.do"><div class='bar'><span>图片作品</span><i></i></div></a>
            
            <a href="<%=basePath %>story!waitcheck.do"><div class='bar active'><span>摄影故事</span><i></i></div></a>
            
        </div>
    	
        <div id="divThreeStage">
        
            <div class="threeStage">
               <a href="<%=basePath %>story!waitcheck.do"><div class='bar active'><span>待审核作品</span><i></i></div></a>
                
                <a href="<%=basePath %>story!checksuclist.do"><div class='bar'><span>作品列表</span><i></i></div></a>
                <a href="<%=basePath %>story!checkfaillist.do"><div class='bar'><span>未通过审核作品</span><i></i></div></a>
                <a href="<%=basePath %>story!adminSoldout.do"><div class='bar'><span>被下架列表</span><i></i></div></a>
                
            </div>
        </div>
    </div>
    <!-- 二sss级导航  end-->
    
    
    
    
    
    <!--内容-->
    <div id="divContent">
        
    	
        <!--摄影故事内容-->
        <div id="phoStroyDetail">
        	<div class="phoStroyDetailLeft"  id="phoStroyDetailLeft">
        		<div class="divHead">
                	<div class="name" title="<s:property value="story.title"/>"><s:property value="story.title"/></div>
                </div>
                
                <div class="divDescribe">
                	<div class="edit" id="editzpgs">
                    	<div class="bj"></div>
                    	<div class="bjc">
                        	<a href="story!downloadstory.do?storyId=<s:property value="story.id"/>" class="dowload">
                            	<div class="backimg"></div>
								<p>下载故事</p>
                            </a>
                            <a href="story!admindelchecking.do?storyId=<s:property value="story.id"/>" class="delete">
                            	<div class="backimg"></div>
								<p>删除作品</p>
                            </a>
                        </div>
                    </div>
                	<div class="character">故事描述：</div>
                    <div class="dec"> <s:property value="story.storydescription"/> </div>
                </div>
                
                <div class="storyzw">故事正文：</div>
                <s:iterator value="story.storyDetailSet" var="detail">
                <div class="divContent">
                    <div class="picStory"><img src=" <s:property value='#detail.samllPic'/>" onload="javascript:DrawImage(this,750,750)"/></div>
                	<div class="char">图片尺寸：<span><s:property value="#detail.width"/></span>*<span><s:property value="#detail.height"/></span>px</div>
                    <div class="info">
                    <s:set value="#detail.detailContext" var="cxt" scope="request"></s:set>
                    <s:set value="#detail.specialwords" var="words" scope="request"></s:set>
                    <%
                   String detailcxt=request.getAttribute("cxt").toString();
                    String words;
                    if(request.getAttribute("words") == null){
                    out.print(detailcxt);
                    }else{
                    words=request.getAttribute("words").toString();
                    String mywords[]=words.split(",");
                    String style="<em>";
                    String endstyle="</em>";
                    int mylength=mywords.length;
                    if(mylength ==0){
                    out.print(detailcxt);
                    }else{
                    for(int i=0;i<mywords.length;i++){
                    if(mywords[i] != null && mywords[i] != ""){
                         if(detailcxt.contains(mywords[i])){
                         out.print(detailcxt.replace(mywords[i],style+mywords[i]+endstyle));
                         }
                    }else{
                         out.print(detailcxt);
                    }
                    
                    }
                    }
                    
                    }
                    
                    
                     %>
                    </div>
                </div>
                </s:iterator>
            </div>
        
        <!--右部内容-->
         	<div class="phoStroyDetailRight">
<!--        		<form id="formPhoStroyDetail">-->
                
                       
                <div class="storyCon">
                
                	<!--不通过原因1111111-->
                	<div class="noPassReason" id="noPassReason">
                    	<div class="top">不通过原因</div>
                    	<form action="story!checknopass.do" method="post" id="fir">
                    	<input type="hidden" name="storyId" value="<s:property value="story.id"/>"/>
                        <div class="editNoPass">
                            <table id="tablePass">
                <tr>
                    <td class="td1"><input id="checkzjwt" type="checkbox" name="nopasscause" value="1"/></td>
                    <td><label for="checkzjwt">您上传的证件不清晰</label></td>
                </tr>
            
                <tr>
                    <td class="td1"><input id="checkzjgd" type="checkbox" name="nopasscause" value="2"/></td>
                    <td><label for="checkzjgd">证件照片有改动</label></td>
                </tr>
                
                <tr>
                    <td class="td1"><input id="checksfz" type="checkbox" name="nopasscause" value="3"/></td>
                    <td><label for="checksfz">您提交的身份信息不正确</label></td>
                </tr>
                
                <tr class="other">
                    <td class="td1" valign="top"><input id="checkqit" type="checkbox" name="nopasscause" value="0"/></td>
                    <td class="otherCon"><label for="checkqit">其他</label><textarea name="writereason"></textarea></td>
                </tr>
            </table>
                            <div class="opeation" id="opeationPass">
                                <input class="pass" type="button" value="取消" onclick="noPassReason(this,'noPassReason','autonyMaudit')"/>
                                <input class="noPass" type="submit" value="保存"/>
                            </div>
                        </div>
                        </form>
                    </div>
                    <!--不通过原因-->
                    
                    
                    
                    
                    <!--操作是否通过-->
                	<div class="autonyMaudit" id="autonyMaudit">
                    	<div class="top">作品审核</div>
                    	<div class="opeation">
                        	<input class="pass" type="button" id="noPassId" value="不通过" onclick="noPassReason(this,'autonyMaudit','noPassReason')"/>
							<input class="noPass" type="button" value="通过" onclick="storypass(<s:property value='story.id'/>)"/>
                        </div>
                    </div>
                    <!--操作是否通过-->
                    
                    
                    
                	<div class="photographyStoryInfo">
                    	<div class="divTop">作者：</div>
                        <div class="headImg">
                        	<div class="headImgCon">
                            	<img src="<s:property value='story.user.portrait'/>" class="headimg"/>
                              	<img src="<%=basePath %>back/pubimg/images/radHead.png" class="radius"/>
                               
                          	</div>
                         </div>
                         <div class="info">
                            <div class="name">
                            	<span><s:property value='story.user.nickName'/></span>
                            	<!--22<a class="approveNo" title="未实名认证"></a>-->
                                <a class="approveHave" title="个人实名认证"></a>
                                <!--aa <a class="approveQy" title="企业实名认证"></a>-->
                                <a class="gradeFour"></a>
                                <input type="button" value="看资料" class="viewInfo"/>
                            </div>
                            <div class="detail">
                            <s:if test='story.user.sex == "男"'>
                            	<a class="userPositionNameG" title="年龄">
                            	
                            	<span><s:property value='story.user.age'/></span>岁</a>
                            	</s:if>
                            	<s:else>
                            	<a class="userPositionName" title="年龄"><span><s:property value='story.user.age'/></span>岁</a>
                            	</s:else>
                                <!--<a class="userPositionName" title="年龄"><span>56</span>岁</a>-->
                                <a class="userPositionAddress" title="地址"><span>上海</span><span class="shi">嘉定</span></a>
                                <a class="pstype" title="职业"><div class='bar active'><span> <s:property value="story.user.userCat.name"/> </span><i></i></div></a>
                            </div>
                        </div>
                    </div>
                                
                	<div class="head">
                    	<div class="char">故事封面</div>
                        <div class="pic" id="divChangeHead">
                        	<img src="<s:property value='story.cover'/>" onload="javascript:DrawImage(this,285,175)" />
                        	<div class="nowtop" id="divViewHead">
                        		<div class="bj"></div>
                        		<div class="bjc">
                        			<div class="sp1"><a onclick="changeHeadStory('cropHead');">更换故事封面</a></div>
                                	<div class="sp2">故事封面仅供故事展示使用</div>
                            	</div>
                        	</div>
                        </div>
                        
                        <div class="storyInfo">
                        	<table>
                            	<tr>
                                	<td><span class="character">作品编号：</span></td>
                                    <td class="td2"><span><s:property value="story.remark"/></span></td>
                                    <td><span class="character">创建时间：</span></td>
                                    <td><span><s:date name="story.uploadTime" format="yyyy-MM-dd"/></span></td>
                                </tr>
                            	
                                <tr>
                                	<td><span class="character">图片张数：</span></td>
                                    <td><span><s:property value="story.detailpicNum"/></span>张</td>
                                    <td><span class="character">字数：</span></td>
                                    <td><span><s:property value="story.detailtextNum"/></span>字</td>
                                </tr>
                            </table>
                        		
                        	
                        </div>
                    </div>
                    
                    <div class="typeone">
                    		<table>
                            	<tr>
                                	<td class="td3 character">所属专辑</td>
                                    <td class="td4">默认专辑</td>
                                    <td class="td5"><a href="javascript:" onclick="openPopUpBox('moveTozj');">移动到</a></td>
                                </tr>
                            	
                                <tr>
                                	<td class="td1 character">作品状态</td>
                                    <td class="td2">审核中</td>
                                    <td class="td3 character">发布时间</td>
                                    <td class="td4">
                                    <s:date name="story.publishTime" format="yyyy-MM-dd"/>
                                    </td>
                                </tr>
                                
                            </table>
                    </div>
                    
                    
                    <div class="gjctd"> 
                    	<div class="chaa">作品类型</div>
                        <div class="type">
                        
                        <s:iterator value="publishCatStories" var="cats">
                        <div class="retag">
								<span><s:property value="#cats.publishCat.name"/></span>
								<a></a>
							</div>
						</s:iterator> 
                        
                        	
                            
                        </div>
                        <div style="clear:both;"></div>
                        
                    	<div class="chaa">关键词</div>
                        <div class="keyword">
                        <s:generator separator=" " val="story.tags">  
								        <s:iterator>  
								          <a href="javascript:"><s:property/> </a>  
								        </s:iterator>  
								    </s:generator>  
                        	
                       	</div>
                    </div>
                    
                    
                     <div class="property">
                            <table>
                                
                                <tr>
                                    <td class="td1">商业用途</td>
                                    <td class="tdp" colspan="3">仅用于传媒，不可用于其他商业用途</td>
                                </tr>
                                <s:if test="story.copyrightres == 0">
                                <tr>
                                    <td class="td1">出售使用权</td>
                                    <td class="td2">￥<span><s:property value="story.usagePrice"/></span></td>
                                    <td class="td3">授权期限</td>
                                    <td class="td4"><span>1</span>年</td>
                                </tr>
                                </s:if>
                                <s:if test="story.copyrightres == 1">
                                <tr>
                                    <td class="td1">出售版权</td>
                                    <td class="td2"><span><s:property value="story.copyrightPrice"/></span>年</td>
                                </tr>
                                </s:if>
                                <s:if test="story.copyrightres == 2">
                                <tr>
                                    <td class="td1">出售使用权</td>
                                    <td class="td2">￥<span><s:property value="story.usagePrice"/></span></td>
                                    <td class="td3">授权期限</td>
                                    <td class="td4"><span>1</span>年</td>
                                </tr>
                                 <tr>
                                    <td class="td1">出售版权</td>
                                    <td class="td2">￥<span><s:property value="story.copyrightPrice"/></span></td>
                                </tr>
                                </s:if>
                            </table>
                    </div>
                </div>
                
                
<!--                </form>   -->
            </div>
       <!--右部内容-->
        
        
        </div>
        
        
        
        
        <!--摄影故事内容-->
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
    
    <div id="chooseWork" style="width:1000px;height:800px; display:none;">
    	<iframe name='child' style="border:0px;width:1000px;height:800px" src="<%=basePath %>public/chooseHead.html"></iframe>
    </div>
    
    <div id="cropHead" style="width:1130px;height:900px; z-index:100000000;display:none;overflow:hidden;">
    	<iframe name='child2' style="border:0px;width:1200px;height:900px;overflow:hidden;z-index:100000000" src="../../public/cropHead.html"></iframe>
    </div>
    
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
<script src="../../public/js/DD_belatedPNG_0.0.8a.js" type="text/javascript"></script>
    <script type="text/javascript">
        DD_belatedPNG.fix('div, ul, img, li, input , a , i');
    </script>
<![endif]-->


</body>
</html>

