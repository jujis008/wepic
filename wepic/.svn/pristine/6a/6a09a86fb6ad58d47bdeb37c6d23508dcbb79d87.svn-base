<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/jquery.js"></script>


<!--公共js-->


<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/topBar.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/header.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/publicBackPublic.js"></script>
<!--公共css-->
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public/css/public.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/back/pubimg/css/backMainBar.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public/css/topBarMain.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public/css/header.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public/css/footer.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/back/personalCentr/myPart/releaseRecord/css/popupShoot.css" />



<script type="text/javascript">
	
	$(function(){
		divLiBarClickCollect();
		
		
		allPrevNext();
		});
	
	
	function allPrevNext(){
		var allPrev = $(".slider_next");				//下一张向左移动
		var allNext = $(".slider_prev");				//上一张向右移动
		
		$(allPrev).each(function(index, element) {
			var $item,$iSteep;
			var $sliderMove = $(this).next().children();		//获取所要对象
			
			$item = $sliderMove.children();					//所有孩子
			$iSteep = $item.outerWidth();					//孩子的宽度
			
			$sliderMove.css('width',$item.length * $iSteep +'px' );
							
	    });
			
			//上一张向右移动
		$(allPrev).each(function(index, element) {
			
			var $sliderMove = $(this).next().children();		//获取所要对象
			
			var $item,$iSteep;
			var $sliderMove = $(this).next().children();		//获取所要对象
		
			$item = $sliderMove.children();					//所有孩子
			$iSteep = $item.outerWidth();					//孩子的宽度
			
	        $(this).click(function(){
				
				
				//先把最后一个放第一个排序
				$sliderMove.css( "left", -$iSteep+'px').children().last().prependTo( $sliderMove );
				//向右移动
				$sliderMove.animate({left:"0px"});
				});
							//滚动
	    });
		
		
		
		
		$(allNext).each(function(index, element) {
			var $sliderMove = $(this).prev().children();		//获取所要对象
			
			
			var $item,$iSteep;
			var $sliderMove = $(this).prev().children();		//获取所要对象
		
			$item = $sliderMove.children();					//所有孩子
			$iSteep = $item.outerWidth();					//孩子的宽度
	        $(this).click(function(){
				$sliderMove.animate({left:-$iSteep+'px'},function(){
				
					$sliderMove.css( "left" , 0 ).children().first().appendTo( $sliderMove );
				});	
				
				});
			
	    });
		
		
		
		}
		
		






	/* 切换荣誉 代表作品*/
	function divLiBarClickCollect(divName){
		var allMainDB=$(".topdb");
		$(allMainDB).each(function(indexDB, elementDB){
			
			// alltopLi 选择选项卡top
			var alltopLi = $(elementDB).find("ul").children();
			var allConDiv = $(elementDB).next().children();
			
			
			$(alltopLi).each(function(indexTopLi, elementTopLi) {
				alltopLi[indexTopLi].index = indexTopLi; 
	            $(alltopLi).click(function(){
					//加选中样式
						
					$(alltopLi).each(function( i , ele) {
						$(ele).removeClass("active");
						allConDiv[i].style.display = 'none';
					});
					
					$(this).addClass("active");
					allConDiv[this.index].style.display = 'block';
					
					
					
					
					});
	        });
	    });	
		
		
		
	}
	
   
   
	</script>
	
	
	
  </head>
  <div id="recruitCameristSmall" style="width:857px;height: 30px; background: #FFFFFF">
                	
                	<div class="recruitCameristSmall_two" style="display: block;">
                    <a href="responseInvitednew!isInvitedForMyBid.do?id=<s:property value="bidId"/>&flag=1"><div class="shaixuan <s:if test="flag==1">actives</s:if>">全部</div></a>
                    	 <a href="responseInvitednew!isInvitedForMyBid.do?id=<s:property value="bidId"/>&flag=2"><div class="shaixuan <s:if test="flag==2">actives</s:if>">已回应</div></a>
                    	 <a href="responseInvitednew!isInvitedForMyBid.do?id=<s:property value="bidId"/>&flag=3"><div class="shaixuan <s:if test="flag==3">actives</s:if>">无回应</div></a>
                    </div>
                	
                	
                </div>
                
  <div id="divListTwo" class="divList" style="display:block;width:857px">
                    <ul id="divListTwoUl">
                    	<!--已报价-->
                    	<s:iterator value="pager.resultList">
                        <li class="lilist_two">
                        <s:if test="isResponse==1">
                        	<div class="ying"></div>
                        	</s:if>
                        	<div class="divImg">
                               <img src="<s:property value="user.portrait"/>" />
                                <s:if test="reponseMoney==null||reponseMoney.trim()==''">
                                <div class="divBackGround">
                                    <div class="opacity"></div>
                                   
                                    <div class="info">
                                        <p class="one">报价：</p>
                                        <p class="two">￥<span><s:property value="reponseMoney"/></span></p>
                                    </div>
                                    
                                </div>
                                </s:if>
                            </div>
                            
                            <div class="divUserInfo">
                            	<div class="one">
                                	<span class="name"><s:property value="user.nickName"/></span>
                                	
                                	     <s:if test="user.personOrCompany==2">
                            
                             <s:if test="user.ifIdentityTrue==2">
                             <a href="javascript:" class="approveQy" title="企业身份已认证"></a>
                             </s:if>
                             
                             <s:else>
                        	<a href="javascript:" class="approveNo" title="企业身份未认证"></a>
                        	</s:else>
                            </s:if>
                            <s:else>
                             <s:if test="user.ifIdentityTrue==2">
                            <a href="javascript:" class="approveHave" title="个人身份已认证"></a>
                            </s:if>
                            <s:else>
                        	<a href="javascript:" class="approveNo" title="个人身份未认证"></a>
                            </s:else>
                        	</s:else>
                        	
                        	
                                   
                                   <!-- <a class="approveHave" title="个人实名认证"></a>-->
                                   <!-- <a class="approveQy" title="企业实名认证"></a>-->
                                </div>
                            	<div class="two">
                            	<s:if test='user.sex=="男"'>
                                	<a title="年龄" class="ageMan">
                                	</s:if>
                                	<s:elseif test='user.sex=="女"'>
                                	<a title="年龄" class="age">
                                	</s:elseif>
                                	<s:property value="user.age.trim()"/>
                                
                                	
                                	岁</a>
                                    <a title="工作地" class="address"><span><s:property value="user.workPlace"/></span></a>
                                </div>
                            	<div class="three"><div title="职业" class="job"><span><s:property value="user.userCat.name"/></span><a></a></div>
                                </div>
                                <div class="four"><a title="浏览次数" class="view"><s:property value="user.hit"/></a></div>
                            </div>
                        </li>
                        <!--已报价-->
                        </s:iterator>
                        <!--已报价-->
             
                        
                        
                        <div style="clear:both;"></div>
                    </ul>
                    
                    
                    <!--翻页-->
                    <div class="ppointPagingthis">
                        <div class="ppointPaging">            
                            <table class="tablePpointPaging">
                                    <tbody><tr>
                                        <td class="ppointPagingOne"><a href="javascript:"></a></td>
                                        <td class="ppointPagingPre"><a href="javascript:"></a></td>
                                        <td class="ppointPagingN"><a href="javascript:">1</a></td>
                                        <td class="ppointPagingN"><a href="javascript:">2</a></td>
                                        <td class="ppointPagingN"><a href="javascript:">3</a></td>
                                        <td class="ppointPagingN"><a href="javascript:">4</a></td>
                                        <td class="ppointPagingN"><a href="javascript:">5</a></td>
                                        <td class="ppointPagingN"><a href="javascript:">6</a></td>
                                        <td class="ppointPagingN"><a href="javascript:">7</a></td>
                                        <td class="ppointPagingN"><a href="javascript:">8</a></td>
                                        <td class="ppointPagingN"><a href="javascript:">9</a></td>
                                        <td class="ppointPagingN"><a href="javascript:">10</a></td>
                                        <td class="ppointPagingNext"><a href="javascript:"></a></td>
                                        <td class="ppointPagingLast"><a href="javascript:"></a></td>
                                    </tr>
                                </tbody></table>
                        </div>
                    </div>
                    <!--翻页-->
                </div>
  
  
  
  
  
  
  
  <body>
 
  </body>
</html>
