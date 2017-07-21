<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<!-- 
  应约者列表
 -->
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'listAtPerson.jsp' starting page</title>
    
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
  
  <body>
   
   <div class="recruitCameristSmall" style="width:857px;height: 30px;background: #FFFFFF">
   
   <div class="recruitCameristSmall_one">
                        <a href="${pageContext.request.contextPath}/responseInvitednew!findlistApplyBid.do?flag=1&id=<s:property value="bidId"/>"><div class="shaixuan <s:if test="flag==1">actives</s:if>">新应约</div></a>
    	                <a href="${pageContext.request.contextPath}/responseInvitednew!findlistApplyBid.do?flag=2&id=<s:property value="bidId"/>"><div class="shaixuan <s:if test="flag==2">actives</s:if>">全部应约者</div></a>
                    	<a href="${pageContext.request.contextPath}/responseInvitednew!findlistApplyBid.do?flag=3&id=<s:property value="bidId"/>"><div class="shaixuan <s:if test="flag==3">actives</s:if>">不选的人</div></a>
                    </div>
   
   
   </div>
                	
            
                
   <div class="divList" id="divListOne">
                <!--非模特-->
            
                <s:iterator value="pager.resultList">
                
                
            
               
                <!--模特-->
                    <div class="divList_one">
                    	<div class="divList_one_top">
                            <div class="divPicInfoLeft">
                            <s:if test="isInvited==1">
                            	<div class="yaoqing"></div>
                            	</s:if>
                                <div class="divTop">
                                    <a class="recommendeli2" href="javascript:;"><img src="<s:property value="user.portrait"/>" /></a>
                                    <div class="divUserName">
                                        <div class="pUserName">
                                            <span><s:property value="user.nickName"/></span>
                                           
                                           	<!-- <a class="approveNo" title="未实名认证"></a>
                                             <a class="approveHave" title="个人实名认证"></a>
                                            <!-- <a class="approveQy" title="企业实名认证"></a>-->
                                            
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
                                        <a class="gradeThree"></a>
                                        </div>
                                       
                                        <div class="userPosition">
                                          <s:if test='user.sex=="男"'>
                                	<a title="年龄" class="ageMan">
                                	</s:if>
                                	<s:elseif test='user.sex=="女"'>
                                	<!-- sss -->
                                	</s:elseif>
                                	<s:property value="user.age.trim()"/>
                                            <s:property value="user.age"/>
                                                                                                                            岁</a>
                                            <a class="address" title="工作地"><span>
                                             <s:property value="user.workPlace"/>
                                            </span></a>
                                        </div>
                                        
                                        <div class="userType">
                                            <div class="job" title="职业"><span>
                                       
                                             <s:property value="user.userCat.name"/>
                                            </span><a></a></div>
                                            <div style="clear:both;"></div>
                                        </div>
                                        
                                        <div class="userAppraise">
                                            <div class="userAppraiseOne">
                                                <p class="userAppraiseOneTop">  <s:property value="user.userMess.attentionNumber"/></p>
                                                <p>关注</p>
                                            </div>
                                            
                                            <div class="userAppraiseOne">
                                                <p class="userAppraiseOneTop"><s:property value="user.userMess.fansNumber"/></p>
                                                <p>粉丝</p>
                                            </div> 
                                            
                                            <div class="userAppraiseOne">
                                                <p class="userAppraiseOneTop"><s:property value="user.userMess.credit.bidGoodRemarkNum"/></p>
                                                <p>好评</p>
                                            </div> 
                                            
                                            <div class="userAppraiseOne userAppraiseLast">
                                                <p class="userAppraiseOneTop">90%</p>
                                                <p>好评率</p>
                                            </div>  
                                        </div>
                                    </div>
                                </div>
                                
                                
                                <div class="divUserGrade">
                                   <div class="child">
                                        <p class="number"><s:property value="user.userMess.credit.bidNum"/></p>
                                        <p>约拍项目</p>
                                    </div>
                                    
                                    <div class="child">
                                        <p class="number"><s:property value="user.userMess.credit.bidGetMoney"/></p>
                                        <p>项目收入</p>
                                    </div> 
                                    
                                    <div class="child">
                                        <p class="number">90%</p>
                                        <p>应约成功率</p>
                                    </div> 
                                    
                                    <div class="child lastchild">
                                        <p class="number"><s:property value="user.userMess.credit.productsNum"/></p>
                                        <p>发布作品</p>
                                    </div>  
                                </div>
                            </div>
                               
                            <div class="checkPic">
                                <div class="topdb">
                                    <ul>
                                    <s:if test="user.role=='model'">
                                        <li class="active">模特信息</li>
                                        </s:if>
                                         <s:if test="user.role!='model'">
                                        <li class="active">代表作品</li>
                                        </s:if>
                                        <s:else>
                                           <li>代表作品</li>
                                         </s:else>
                                        <li>代表项目</li>
                                        <li>他的荣誉</li>
                                    </ul>
                                </div>
                                <div class="sliderModel">
                                <s:if test="user.role=='model'">
                                	<div class="slider_div_model">
                                        <div class="slider_div_model_top">
                                           <div class="slider_children">
                                           		<div class="height_ico"></div>
                                           		<div class="ico_value">
                                           		<s:property value="user.height"/>cm
                                           		
                                           		</div>
                                           </div>
                                           
                                           <div class="slider_children">
                                           		<div class="weight_ico"></div>
                                           		<div class="ico_value">
                                           		<s:property value="user.weight"/>
                                           		kg</div>
                                           </div>
                                           
                                           <div class="slider_children">
                                           		<div class="BWH_ico"></div>
                                           		<div class="ico_value"><s:property value="user.bust"/>-<s:property value="user.waist"/>-<s:property value="user.newhip"/></div>
                                           </div>
                                           
                                           <div class="slider_children">
                                           		<div class="xxx_ico"></div>
                                           		<div class="ico_value">70D</div>
                                           </div>
                                           
                                           <div class="slider_children">
                                           		<div class="shoe_size_ico"></div>
                                           		<div class="ico_value">
                                           		<s:property value="user.shoeSize"/>
                                           		(欧码)</div>
                                           </div>
                                        </div>
                                        <!-- 
                                        <div class="slider_div_model_con">
                                           淘宝是利用了很多小商户聚集了流量和用户，为自己的商城做了铺垫。但是，反过来想，这些商户也没少从淘宝赚到钱啊。不能只看到现在的怨怒，不想到感恩。 你依附于渠道赚钱，必也会受制于渠道，你可以想解决方案，但绝不是目前这种行径
                                        </div>
                                         -->
                                    </div>
                                    </s:if>
                                    
                                       <s:if test="user.role!='model'">
                                        <div class="slider_div_work" style="display:block">
                                        </s:if>
                                        <s:else>
                                           <div class="slider_div_work">
                                         </s:else>
                                        <div class="slider_box_ul">
                                            <a href='javascript:;' class="slider_next" title="下一张"></a>
                                            <div class="slider-wrapper">
                                                <ul class='slider-move'>
                                                <s:iterator value="user.userMess.userPowers" >
                                                <s:iterator value="userDetails" status="index">
                                                    <li>
                                                 
                                                        <div class="img"><img src="<s:property value="picUrl"/>"/></div>
                                                       
                                                    </li>
                                                    </s:iterator>
                                                    </s:iterator>
                                                    <!-- 
                                                    <li>
                                                        <div class="img"><img src="${pageContext.request.contextPath}/back/pubimg/pic/3.png" /></div>
                                                    </li>
                                                    <li>
                                                        <div class="img"><img src="${pageContext.request.contextPath}/back/pubimg/pic/4.png" /></div>
                                                    </li>
                                                     -->
                                                </ul>
                                            </div>
                                            <a href='javascript:;' class="slider_prev" title="上一张"></a>
                                        </div>
                                        
                                    </div>
                                    
                                    <div class="slider_div_project">
                                        <div class="slider_box_ul">
                                            <a href='javascript:;' class="slider_next" title="下一张"></a>
                                            <div class="slider-wrapper">
                                                <ul class='slider-move'>
                                                  <s:iterator value="user.userMess.projectuserPowers">
                                                    <li>
                                                   
                                                     <s:iterator value="userDetails" status="index">
                                                    <s:if test="#index.index==0">
                                                    <div class="img"><img src="<s:property value="picUrl"/>"/></div>
                                                    </s:if>
                                                    </s:iterator>
                                                        
                                                        <div class="divimgDetail">
                                                            <div><s:property value="entrytime"/>年</div>
                                                            <div><s:property value="name"/></div>
                                                            <div><s:property value="entryAdress"/></div>
                                                        </div>
                                                    </li>
                                                    </s:iterator>
                                                    <!-- 
                                                    <li>
                                                        <div class="divimg"><img src="${pageContext.request.contextPath}/back/pubimg/pic/2.png" /></div>
                                                        <div class="divimgDetail">
                                                            <div>2005年</div>
                                                            <div>国际商务礼仪示范拍摄国际商务礼仪</div>
                                                            <div>德国柏林</div>
                                                        </div>
                                                    </li>
                                                    
                                                    <li>
                                                        <div class="divimg"><img src="${pageContext.request.contextPath}/back/pubimg/pic/3.png" /></div>
                                                        <div class="divimgDetail">
                                                            <div>2005年</div>
                                                            <div>国际商务礼仪示范拍摄国际商务礼仪</div>
                                                            <div>德国柏林</div>
                                                        </div>
                                                    </li>
                                                    
                                                    <li>
                                                        <div class="divimg"><img src="${pageContext.request.contextPath}/back/pubimg/pic/4.png" /></div>
                                                        <div class="divimgDetail">
                                                            <div>2005年</div>
                                                            <div>国际商务礼仪示范拍摄国际商务礼仪</div>
                                                            <div>德国柏林</div>
                                                        </div>
                                                    </li>
                                                     -->
                                                </ul>
                                            </div>
                                            <a href='javascript:;' class="slider_prev" title="上一张"></a>
                                        </div>
                                    </div>
                                    
                                    <div class="slider_div_honor">
                                        <div class="slider_box_ul">
                                            <a href='javascript:;' class="slider_next" title="下一张"></a>
                                            <div class="slider-wrapper">
                                               <ul class='slider-move'>
                                               <s:iterator value="user.userMess.hornoList">
                                                    <li>
                                                      <s:iterator value="userDetails">
                                                    
                                                     <div class="divimg"><img src="<s:property value="picUrl"/>" /></div>
                                                    
                                                    </s:iterator>
                                                      
                                                        <div class="divimgDetail">
                                                            <div>奖项：</div>
                                                            <div><s:property value="awardwinningworks"/></div>
                                                            <div>颁发时间：<s:property value="entrytime"/></div>
                                                        </div>
                                                    </li>
                                                    </s:iterator>
                                                    <!-- 
                                                    <li>
                                                        <div class="divimg"><img src="${pageContext.request.contextPath}/back/pubimg/pic/2.png" /></div>
                                                        <div class="divimgDetail">
                                                            <div>奖项：</div>
                                                            <div>我的奖项我的奖项我的奖项我的奖项我的奖项我的奖项我的奖项我的奖项我的奖项</div>
                                                            <div>颁发时间：2013年09月</div>
                                                        </div>
                                                    </li>
                                                    
                                                    <li>
                                                        <div class="divimg"><img src="${pageContext.request.contextPath}/back/pubimg/pic/3.png" /></div>
                                                        <div class="divimgDetail">
                                                            <div>奖项：</div>
                                                            <div>我的奖项我的奖项我的奖项我的奖项我的奖项我的奖项我的奖项我的奖项我的奖项</div>
                                                            <div>颁发时间：2013年09月</div>
                                                        </div>
                                                    </li>
                                                    
                                                    <li>
                                                        <div class="divimg"><img src="${pageContext.request.contextPath}/back/pubimg/pic/4.png" /></div>
                                                        <div class="divimgDetail">
                                                            <div>奖项：</div>
                                                            <div>我的奖项我的奖项我的奖项我的奖项我的奖项我的奖项我的奖项我的奖项我的奖项</div>
                                                            <div>颁发时间：2013年09月</div>
                                                        </div>
                                                    </li>
                                                     -->
                                                </ul>
                                            </div>
                                            <a href='javascript:;' class="slider_prev" title="上一张"></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div> 
                       <s:if test="flag!=3">
                        <div class="option">
                        	<form action="responseInvitednew!setPeopleNO.do" method="post" id="resform">
                        	<input type="hidden" value="<s:property value="id"/>" name="id">
                        	<input type="hidden" value="<s:property value="flag"/>" name="flag">
                        	<input type="hidden" value="<s:property value="bid.id"/>" name="bidId">
                            <input class="white_button" type="button" value="选中" onclick="subForm(1)"/>
                            <input class="white_button" type="button" value="不选" onclick="subForm(2)"/>
                            <input class="red_button" type="button" value="待定" onclick="subForm(3)"/>
                            </form>
                        </div>
                             </s:if>   
                    </div>
                        </s:iterator>
                <!--模特-->   
                    
                <!--翻页-->
                    <div class="ppointPagingthis">
                        <div class="ppointPaging">            
                            <table class="tablePpointPaging">
                                    <tr>
                                        <td class="ppointPagingOne"><a href="javascript:"></a></td>
                                        <td class="ppointPagingPre"><a href="javascript:"></a></td>
                                           <s:bean name="org.apache.struts2.util.Counter" id="counter">  
                                           <s:param name="first" value="1"/>  
                                           <s:param name="last" value="pager.lastPageNo"/>  
                                           <s:iterator> 
                                          <td class="ppointPagingN"><a href="${pageContext.request.contextPath}/<s:property value="url"/>&nowPage=<s:property/>"><s:property/></a></td>
                                                
                                         </s:iterator>  
                                        </s:bean>  
                                        
                                        
                                        <!-- 
                                        <td class="ppointPagingN"><a href="javascript:">2</a></td>
                                        <td class="ppointPagingN"><a href="javascript:">3</a></td>
                                        <td class="ppointPagingN"><a href="javascript:">4</a></td>
                                        <td class="ppointPagingN"><a href="javascript:">5</a></td>
                                        <td class="ppointPagingN"><a href="javascript:">6</a></td>
                                        <td class="ppointPagingN"><a href="javascript:">7</a></td>
                                        <td class="ppointPagingN"><a href="javascript:">8</a></td>
                                        <td class="ppointPagingN"><a href="javascript:">9</a></td>
                                        <td class="ppointPagingN"><a href="javascript:">10</a></td>
                                                     -->
                                        <td class="ppointPagingNext"><a href="javascript:"></a></td>
                                        <td class="ppointPagingLast"><a href="javascript:"></a></td>
                            
                                    </tr>
                                </table>
                        </div>
                    </div>
                <!--翻页-->
                </div>
                
   
   
   
   
   
   
   
   
  </body>
  
  
  <script type="text/javascript">
  
  function subForm(type){
	  if(type==1){
		  $("#resform").attr("action","responseInvitednew!confirmPerople.do");
		  $("#resform").submit();

		  }
	  else if(type==2){
		  $("#resform").attr("action","responseInvitednew!setPeopleNO.do");
		  $("#resform").submit();

		  }
	  else if(type==3){
		  $("#resform").attr("action","responseInvitednew!waitingSetconfirmPerople.do");
		  $("#resform").submit();

		  }


	  }
  
  
  
  </script>
  
</html>
