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
    
    <title>My JSP 'listsuccessfultenderer.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<!-- 
                       中标者列表
 -->
 
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
   <div id="divListFour" class="divList" style="display: block;">
                <!--还有一人款项未结-->
                    <div class="divList_one">
                    	<div class="divList_one_top">
                            <div class="divPicInfoLeft">
                            	<div class="yaoqing"></div>
                                <div class="divTop">
                                    <div class="divImg">
                                        <img src="/wepic/public/pic/head/1.png">
                                        <div class="divBackGround">
                                            <div class="opacity"></div>
                                            <div class="info">
                                          
                                                <p class="one">报价：</p>
                                                <p class="two">￥<span>576675765</span></p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="divUserName">
                                        <div class="pUserName">
                                            <span>你是谁</span>
                                           	<!-- <a class="approveNo" title="未实名认证"></a>-->
                                             <a title="个人实名认证" class="approveHave"></a>
                                            <!-- <a class="approveQy" title="企业实名认证"></a>-->
                                            
                                            <a class="gradeThree"></a>
                                        </div>
                                       
                                        <div class="userPosition">
                                            <a title="年龄" class="ageMan">20岁</a>
                                            <a title="工作地" class="address"><span>上海</span><span>嘉定</span></a>
                                        </div>
                                        
                                        <div class="userType">
                                            <div title="职业" class="job"><span>摄影师</span><a></a></div>
                                            <div style="clear:both;"></div>
                                        </div>
                                        
                                        <div class="userAppraise">
                                            <div class="userAppraiseOne">
                                                <p class="userAppraiseOneTop">89789</p>
                                                <p>关注</p>
                                            </div>
                                            
                                            <div class="userAppraiseOne">
                                                <p class="userAppraiseOneTop">89898789</p>
                                                <p>粉丝</p>
                                            </div> 
                                            
                                            <div class="userAppraiseOne">
                                                <p class="userAppraiseOneTop">898789</p>
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
                                        <p class="number">89789</p>
                                        <p>约拍项目</p>
                                    </div>
                                    
                                    <div class="child">
                                        <p class="number">89898789</p>
                                        <p>项目收入</p>
                                    </div> 
                                    
                                    <div class="child">
                                        <p class="number">90%</p>
                                        <p>应约成功率</p>
                                    </div> 
                                    
                                    <div class="child lastchild">
                                        <p class="number">4545</p>
                                        <p>发布作品</p>
                                    </div>  
                                </div>
                            </div>
                               
                            <div class="div_evaluate">
                            	<div class="evaluate_grade">
                                	<span>我评价他：</span>
                                    <a class="evaluate_gradeicogood">好评</a>
                                </div>
                                
                                
                            	<div class="evaluate_star_level">
                                	<span>工作能力</span>
                                    <img src="/wepic/public/images/grade/star.png">
                                    <img src="/wepic/public/images/grade/star.png">
                                    <img src="/wepic/public/images/grade/star.png">
                                    <img src="/wepic/public/images/grade/star.png">
                                    <img src="/wepic/public/images/grade/star.png">
                                    
                                    
                                    
                                    <span class="star_level_span">专业水平</span>
                                    
                                    <img src="/wepic/public/images/grade/star.png">
                                    <img src="/wepic/public/images/grade/star.png">
                                    <img src="/wepic/public/images/grade/star.png">
                                    <img src="/wepic/public/images/grade/star0.png">
                                    <img src="/wepic/public/images/grade/star0.png">
                                    
                                    <span class="star_level_span">工作态度</span>
                                    <img src="/wepic/public/images/grade/star.png">
                                    <img src="/wepic/public/images/grade/star.png">
                                    <img src="/wepic/public/images/grade/star.png">
                                    <img src="/wepic/public/images/grade/star0.png">
                                    <img src="/wepic/public/images/grade/star0.png">
                                    
                                </div>
                            	<div class="evaluate_con">
                                	商品不错商品不错商品不错商品不错商品不错商品不错商品不错商品不错商品不错商品不错商品不错商品不错商品不错商品不错商品不错商品不错商品不错商品不错商品不错商品不错
                                </div>
                            
                            	
                                
                                <div class="evaluate_grade">
                                	<span>他评价我：</span>
                                    <a class="evaluate_gradeicobad">差评</a>
                                </div>
                                
                                
                            	<div class="evaluate_star_level">
                                	<span>工作能力</span>
                                    <img src="/wepic/public/images/grade/star.png">
                                    <img src="/wepic/public/images/grade/star.png">
                                    <img src="/wepic/public/images/grade/star.png">
                                    <img src="/wepic/public/images/grade/star.png">
                                    <img src="/wepic/public/images/grade/star.png">
                                    
                                    
                                    
                                    <span class="star_level_span">专业水平</span>
                                    
                                    <img src="/wepic/public/images/grade/star.png">
                                    <img src="/wepic/public/images/grade/star.png">
                                    <img src="/wepic/public/images/grade/star.png">
                                    <img src="/wepic/public/images/grade/star0.png">
                                    <img src="/wepic/public/images/grade/star0.png">
                                    
                                    <span class="star_level_span">工作态度</span>
                                    <img src="/wepic/public/images/grade/star.png">
                                    <img src="/wepic/public/images/grade/star.png">
                                    <img src="/wepic/public/images/grade/star.png">
                                    <img src="/wepic/public/images/grade/star0.png">
                                    <img src="/wepic/public/images/grade/star0.png">
                                    
                                </div>
                            	<div class="evaluate_con">
                                	商品不错商品不错商品不错商品不错商品不错商品不错商品不错商品不错商品不错商品不错商品不错商品不错商品不错商品不错商品不错商品不错商品不错商品不错商品不错商品不错
                                </div>
                            </div>
                            
                            
                        </div> 
                        
                        
                        <div class="complain">
                        	<div class="complain_one">
                            	<span class="meToYou">我投诉他：</span>
                            
                            	<span class="star_level_span">工作能力</span>
                                <img src="/wepic/public/images/grade/star.png">
                                <img src="/wepic/public/images/grade/star.png">
                                <img src="/wepic/public/images/grade/star.png">
                                <img src="/wepic/public/images/grade/star.png">
                                <img src="/wepic/public/images/grade/star.png">
                                
                                
                                
                                <span class="star_level_span">专业水平</span>
                                
                                <img src="/wepic/public/images/grade/star.png">
                                <img src="/wepic/public/images/grade/star.png">
                                <img src="/wepic/public/images/grade/star.png">
                                <img src="/wepic/public/images/grade/star0.png">
                                <img src="/wepic/public/images/grade/star0.png">
                                
                                <span class="star_level_span">工作态度</span>
                                <img src="/wepic/public/images/grade/star.png">
                                <img src="/wepic/public/images/grade/star.png">
                                <img src="/wepic/public/images/grade/star.png">
                                <img src="/wepic/public/images/grade/star0.png">
                                <img src="/wepic/public/images/grade/star0.png">
                            </div>
                        	
                            <div class="complain_two">
                            	商品不错商品不错商品不错商品不错商品不错商品不错商品不错商品不错商品不错商品不错商品不错商品不错商品不错商品不错商品不错商品不错商品不错商品不错商品不错商品不错
                                商品不错商品不错商品不错商品不错商品不错商品不错商品不错商品不错商品不错商品不错商品不错商品不错商品不错商品不错商品不错商品不错商品不错商品不错商品不错商品不错                                 
                            </div>
                            
                            <div class="complain_three">
                           		<div class="complain_three_top">投诉处理结果：</div>  
                           		<div class="complain_three_con">32132132321213231</div>                    
                            </div>
                        </div>
                        
                        <div class="option">
                        	<div class="option_money">
                            	<table>
                                	<tbody><tr>
                                    	<td class="td_one">应结酬金：</td>
                                    	<td class="td_two"><span>￥</span>600</td>
                                    	<td class="td_three">我的发布出价：<span>234</span></td>
                                    	<td class="td_four"><div class="havejk">已结款</div></td>
                                    </tr>
                                </tbody></table>
                            </div>
                            
                            
                            
                            <a href="javascript:" class="additional_comments">追加评论</a>
                            <a href="javascript:" class="answer">投诉</a>
                        </div>
                                
                    </div>
                <!--还有一人款项未结--> 
                
                
                
                
                
                
                <!--还有一人款项未结-->
                    <div class="divList_one">
                    	<div class="divList_one_top">
                            <div class="divPicInfoLeft">
                            	<div class="yaoqing"></div>
                                <div class="divTop">
                                    <a href="javascript:;" class="recommendeli2"><img src="/wepic/public/pic/head/1.png"></a>
                                    <div class="divUserName">
                                        <div class="pUserName">
                                            <span>你是谁</span>
                                           	<!-- <a class="approveNo" title="未实名认证"></a>-->
                                             <a title="个人实名认证" class="approveHave"></a>
                                            <!-- <a class="approveQy" title="企业实名认证"></a>-->
                                            
                                            <a class="gradeThree"></a>
                                        </div>
                                       
                                        <div class="userPosition">
                                            <a title="年龄" class="ageMan">20岁</a>
                                            <a title="工作地" class="address"><span>上海</span><span>嘉定</span></a>
                                        </div>
                                        
                                        <div class="userType">
                                            <div title="职业" class="job"><span>摄影师</span><a></a></div>
                                            <div style="clear:both;"></div>
                                        </div>
                                        
                                        <div class="userAppraise">
                                            <div class="userAppraiseOne">
                                                <p class="userAppraiseOneTop">89789</p>
                                                <p>关注</p>
                                            </div>
                                            
                                            <div class="userAppraiseOne">
                                                <p class="userAppraiseOneTop">89898789</p>
                                                <p>粉丝</p>
                                            </div> 
                                            
                                            <div class="userAppraiseOne">
                                                <p class="userAppraiseOneTop">898789</p>
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
                                        <p class="number">89789</p>
                                        <p>约拍项目</p>
                                    </div>
                                    
                                    <div class="child">
                                        <p class="number">89898789</p>
                                        <p>项目收入</p>
                                    </div> 
                                    
                                    <div class="child">
                                        <p class="number">90%</p>
                                        <p>应约成功率</p>
                                    </div> 
                                    
                                    <div class="child lastchild">
                                        <p class="number">4545</p>
                                        <p>发布作品</p>
                                    </div>  
                                </div>
                            </div>
                               
                            <div class="checkPic">
                                <div class="topdb">
                                    <ul>
                                        <li class="active">联系信息</li>
                                        <li>模特信息</li>
                                        <li>代表作品</li>
                                        <li>代表项目</li>
                                        <li>他的荣誉</li>
                                    </ul>
                                </div>
                                <div class="sliderContactWay">
                                	<div class="slider_div_contact_way">
                                    	<div onclick="viewcontact(this);" class="info_way">
                                        	<div class="info_way_ico"></div>
                                        	<div class="info_way_con">点击获取该应约者联系信息</div>
                                        </div>
                                        
                                        <!--显示联系信息-->
                                        <div class="info_way_info">
                                        	<div class="info_way_infoleft">
                                            	<div class="name">胡锦涛</div>
                                            	<div class="char">先生</div>
                                            </div>
                                        	<div class="info_way_inforight">
                                            	<div class="phone">手机：<span>1212421242</span></div>
                                            	<div class="email">邮箱：<span>121fsdf42@163.com</span></div>
                                            	<div class="qq">QQ号：<span>21212121</span></div>
                                            </div>
                                        </div>
                                        <!--显示联系信息-->
                                        
                                        
                                        <div class="info_way_message">您可再此记录您与应约者的沟通您可再此记录您与应约者的沟通您可再此记录您与应约者的沟通您可再此记录您与应约者的沟通您可再此记录您与应约者的沟通您可再此记录您与应约者的沟通您可再此记录您与应约者的沟通您可再此记录您与应约者的沟通您可再此记录您与应约者的沟通您可再此记录您与应约者的沟通您可再此记录您与应约者的沟通您可再此记录您与应约者的沟通您可再此记录您与应约者的沟通您可再此记录您与应约者的沟通您可再此记录您与应约者的沟通您可再此记录您与应约者的沟通</div>
                                    </div>
                                    
                                	<div class="slider_div_model">
                                        <div class="slider_div_model_top">
                                           <div class="slider_children">
                                           		<div class="height_ico"></div>
                                           		<div class="ico_value">170cm</div>
                                           </div>
                                           
                                           <div class="slider_children">
                                           		<div class="weight_ico"></div>
                                           		<div class="ico_value">58kg</div>
                                           </div>
                                           
                                           <div class="slider_children">
                                           		<div class="BWH_ico"></div>
                                           		<div class="ico_value">88-65-88</div>
                                           </div>
                                           
                                           <div class="slider_children">
                                           		<div class="xxx_ico"></div>
                                           		<div class="ico_value">70D</div>
                                           </div>
                                           
                                           <div class="slider_children">
                                           		<div class="shoe_size_ico"></div>
                                           		<div class="ico_value">245(欧码)</div>
                                           </div>
                                        </div>
                                        <div class="slider_div_model_con">
                                           淘宝是利用了很多小商户聚集了流量和用户，为自己的商城做了铺垫。但是，反过来想，这些商户也没少从淘宝赚到钱啊。不能只看到现在的怨怒，不想到感恩。 你依附于渠道赚钱，必也会受制于渠道，你可以想解决方案，但绝不是目前这种行径
                                        </div>
                                    </div>
                                    
                                    <div class="slider_div_work">
                                        <div class="slider_box_ul">
                                            <a title="下一张" class="slider_next" href="javascript:;"></a>
                                            <div class="slider-wrapper">
                                                <ul class="slider-move" style="width: 820px;">
                                                    <li style="">
                                                        <div class="img"><img src="/wepic/back/pubimg/pic/1.png"></div>
                                                        <div class="nowtop">
                                                            <div class="bj"></div>
                                                            <div class="bjc">
                                                            <a class="del" href="javascript:"></a></div>
                                                        </div>
                                                    </li>
                                                    <li>
                                                        <div class="img"><img src="/wepic/back/pubimg/pic/2.png"></div>
                                                    </li>
                                                    <li>
                                                        <div class="img"><img src="/wepic/back/pubimg/pic/3.png"></div>
                                                    </li>
                                                    <li>
                                                        <div class="img"><img src="/wepic/back/pubimg/pic/4.png"></div>
                                                    </li>
                                                </ul>
                                            </div>
                                            <a title="上一张" class="slider_prev" href="javascript:;"></a>
                                        </div>
                                        
                                    </div>
                                    
                                    <div class="slider_div_project">
                                        <div class="slider_box_ul">
                                            <a title="下一张" class="slider_next" href="javascript:;"></a>
                                            <div class="slider-wrapper">
                                                <ul class="slider-move" style="width: 1600px;">
                                                    <li style="">
                                                        <div class="divimg"><img src="/wepic/back/pubimg/pic/1.png"></div>
                                                        <div class="divimgDetail">
                                                            <div>2005年</div>
                                                            <div>国际商务礼仪示范拍摄国际商务礼仪</div>
                                                            <div>德国柏林</div>
                                                        </div>
                                                    </li>
                                                    
                                                    <li>
                                                        <div class="divimg"><img src="/wepic/back/pubimg/pic/2.png"></div>
                                                        <div class="divimgDetail">
                                                            <div>2005年</div>
                                                            <div>国际商务礼仪示范拍摄国际商务礼仪</div>
                                                            <div>德国柏林</div>
                                                        </div>
                                                    </li>
                                                    
                                                    <li>
                                                        <div class="divimg"><img src="/wepic/back/pubimg/pic/3.png"></div>
                                                        <div class="divimgDetail">
                                                            <div>2005年</div>
                                                            <div>国际商务礼仪示范拍摄国际商务礼仪</div>
                                                            <div>德国柏林</div>
                                                        </div>
                                                    </li>
                                                    
                                                    <li>
                                                        <div class="divimg"><img src="/wepic/back/pubimg/pic/4.png"></div>
                                                        <div class="divimgDetail">
                                                            <div>2005年</div>
                                                            <div>国际商务礼仪示范拍摄国际商务礼仪</div>
                                                            <div>德国柏林</div>
                                                        </div>
                                                    </li>
                                                </ul>
                                            </div>
                                            <a title="上一张" class="slider_prev" href="javascript:;"></a>
                                        </div>
                                    </div>
                                    
                                    <div class="slider_div_honor">
                                        <div class="slider_box_ul">
                                            <a title="下一张" class="slider_next" href="javascript:;"></a>
                                            <div class="slider-wrapper">
                                               <ul class="slider-move" style="width: 1600px;">
                                                    <li style="">
                                                        <div class="divimg"><img src="/wepic/back/pubimg/pic/1.png"></div>
                                                        <div class="divimgDetail">
                                                            <div>奖项：</div>
                                                            <div>我的奖项我的奖项我的奖项我的奖项我的奖项我的奖项我的奖项我的奖项我的奖项</div>
                                                            <div>颁发时间：2013年09月</div>
                                                        </div>
                                                    </li>
                                                    
                                                    <li>
                                                        <div class="divimg"><img src="/wepic/back/pubimg/pic/2.png"></div>
                                                        <div class="divimgDetail">
                                                            <div>奖项：</div>
                                                            <div>我的奖项我的奖项我的奖项我的奖项我的奖项我的奖项我的奖项我的奖项我的奖项</div>
                                                            <div>颁发时间：2013年09月</div>
                                                        </div>
                                                    </li>
                                                    
                                                    <li>
                                                        <div class="divimg"><img src="/wepic/back/pubimg/pic/3.png"></div>
                                                        <div class="divimgDetail">
                                                            <div>奖项：</div>
                                                            <div>我的奖项我的奖项我的奖项我的奖项我的奖项我的奖项我的奖项我的奖项我的奖项</div>
                                                            <div>颁发时间：2013年09月</div>
                                                        </div>
                                                    </li>
                                                    
                                                    <li>
                                                        <div class="divimg"><img src="/wepic/back/pubimg/pic/4.png"></div>
                                                        <div class="divimgDetail">
                                                            <div>奖项：</div>
                                                            <div>我的奖项我的奖项我的奖项我的奖项我的奖项我的奖项我的奖项我的奖项我的奖项</div>
                                                            <div>颁发时间：2013年09月</div>
                                                        </div>
                                                    </li>
                                                </ul>
                                            </div>
                                            <a title="上一张" class="slider_prev" href="javascript:;"></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div> 
                        
                        <div class="option">
                        	<div class="option_money">
                            	<table>
                                	<tbody><tr>
                                    	<td class="td_one">应结酬金：</td>
                                    	<td class="td_two"><span>￥</span>600</td>
                                    	<td class="td_three">我的发布出价：<span>234</span></td>
                                    	<td class="td_four"><a class="view_detail" href="javascript:;">查看明细</a></td>
                                    </tr>
                                </tbody></table>
                            </div>
                            
                            
                            
                            <a href="javascript:" class="answer">投诉</a>
                            <input type="button" value="结款" class="red_button">
                        </div>
                                
                    </div>
                <!--还有一人款项未结-->   
                
                
                
                <!--企业-->   
                    <div class="divList_one">
                    	<div class="divList_one_top">
                            <div class="divPicInfoLeft">
                            	<div class="yaoqing"></div>
                                <div class="divTop">
                                    <a href="javascript:;" class="recommendeli2"><img src="/wepic/public/pic/head/1.png"></a>
                                    <div class="divUserName">
                                        <div class="pUserNameqy">
                                            <span class="name">企业名称企业名称企业名称</span>
                                             <a title="企业实名认证" class="approveQy"></a>
                                            
                                            <a class="gradeThree"></a>
                                        </div>
                                       
                                        <div class="userPosition">
                                            <a title="公司所在地" class="address"><span>上海</span></a>
                                        </div>
                                        
                                        <div class="userType">
                                            <div title="公司类型" class="job"><span>私营企业</span><a></a></div>
                                            <div style="clear:both;"></div>
                                        </div>
                                        
                                        <div class="userAppraise">
                                            <div class="userAppraiseOne">
                                                <p class="userAppraiseOneTop">89789</p>
                                                <p>关注</p>
                                            </div>
                                            
                                            <div class="userAppraiseOne">
                                                <p class="userAppraiseOneTop">89898789</p>
                                                <p>粉丝</p>
                                            </div> 
                                            
                                            <div class="userAppraiseOne">
                                                <p class="userAppraiseOneTop">898789</p>
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
                                        <p class="number">89789</p>
                                        <p>约拍项目</p>
                                    </div>
                                    
                                    <div class="child">
                                        <p class="number">89898789</p>
                                        <p>项目收入</p>
                                    </div> 
                                    
                                    <div class="child">
                                        <p class="number">90%</p>
                                        <p>应约成功率</p>
                                    </div> 
                                    
                                    <div class="child lastchild">
                                        <p class="number">4545</p>
                                        <p>发布作品</p>
                                    </div>  
                                </div>
                            </div>
                               
                            <div class="checkPic">
                                <div class="topdb">
                                    <ul>
                                        <li class="active">代表作品</li>
                                        <li>代表项目</li>
                                        <li>他的荣誉</li>
                                    </ul>
                                </div>
                                <div class="sliderPersonal">
                                    <div class="slider_div_work">
                                        <div class="slider_box_ul">
                                            <a title="下一张" class="slider_next" href="javascript:;"></a>
                                            <div class="slider-wrapper">
                                                <ul class="slider-move" style="width: 820px;">
                                                    <li style="">
                                                        <div class="img"><img src="/wepic/back/pubimg/pic/1.png"></div>
                                                        <div class="nowtop">
                                                            <div class="bj"></div>
                                                            <div class="bjc">
                                                            <a class="del" href="javascript:"></a></div>
                                                        </div>
                                                    </li>
                                                    <li>
                                                        <div class="img"><img src="/wepic/back/pubimg/pic/2.png"></div>
                                                    </li>
                                                    <li>
                                                        <div class="img"><img src="/wepic/back/pubimg/pic/3.png"></div>
                                                    </li>
                                                    <li>
                                                        <div class="img"><img src="/wepic/back/pubimg/pic/4.png"></div>
                                                    </li>
                                                </ul>
                                            </div>
                                            <a title="上一张" class="slider_prev" href="javascript:;"></a>
                                        </div>
                                        
                                    </div>
                                    
                                    <div class="slider_div_project">
                                        <div class="slider_box_ul">
                                            <a title="下一张" class="slider_next" href="javascript:;"></a>
                                            <div class="slider-wrapper">
                                                <ul class="slider-move" style="width: 1600px;">
                                                    <li style="">
                                                        <div class="divimg"><img src="/wepic/back/pubimg/pic/1.png"></div>
                                                        <div class="divimgDetail">
                                                            <div>2005年</div>
                                                            <div>国际商务礼仪示范拍摄国际商务礼仪</div>
                                                            <div>德国柏林</div>
                                                        </div>
                                                    </li>
                                                    
                                                    <li>
                                                        <div class="divimg"><img src="/wepic/back/pubimg/pic/2.png"></div>
                                                        <div class="divimgDetail">
                                                            <div>2005年</div>
                                                            <div>国际商务礼仪示范拍摄国际商务礼仪</div>
                                                            <div>德国柏林</div>
                                                        </div>
                                                    </li>
                                                    
                                                    <li>
                                                        <div class="divimg"><img src="/wepic/back/pubimg/pic/3.png"></div>
                                                        <div class="divimgDetail">
                                                            <div>2005年</div>
                                                            <div>国际商务礼仪示范拍摄国际商务礼仪</div>
                                                            <div>德国柏林</div>
                                                        </div>
                                                    </li>
                                                    
                                                    <li>
                                                        <div class="divimg"><img src="/wepic/back/pubimg/pic/4.png"></div>
                                                        <div class="divimgDetail">
                                                            <div>2005年</div>
                                                            <div>国际商务礼仪示范拍摄国际商务礼仪</div>
                                                            <div>德国柏林</div>
                                                        </div>
                                                    </li>
                                                </ul>
                                            </div>
                                            <a title="上一张" class="slider_prev" href="javascript:;"></a>
                                        </div>
                                    </div>
                                    
                                    <div class="slider_div_honor">
                                        <div class="slider_box_ul">
                                            <a title="下一张" class="slider_next" href="javascript:;"></a>
                                            <div class="slider-wrapper">
                                               <ul class="slider-move" style="width: 1600px;">
                                                    <li style="">
                                                        <div class="divimg"><img src="/wepic/back/pubimg/pic/1.png"></div>
                                                        <div class="divimgDetail">
                                                            <div>奖项：</div>
                                                            <div>我的奖项我的奖项我的奖项我的奖项我的奖项我的奖项我的奖项我的奖项我的奖项</div>
                                                            <div>颁发时间：2013年09月</div>
                                                        </div>
                                                    </li>
                                                    
                                                    <li>
                                                        <div class="divimg"><img src="/wepic/back/pubimg/pic/2.png"></div>
                                                        <div class="divimgDetail">
                                                            <div>奖项：</div>
                                                            <div>我的奖项我的奖项我的奖项我的奖项我的奖项我的奖项我的奖项我的奖项我的奖项</div>
                                                            <div>颁发时间：2013年09月</div>
                                                        </div>
                                                    </li>
                                                    
                                                    <li>
                                                        <div class="divimg"><img src="/wepic/back/pubimg/pic/3.png"></div>
                                                        <div class="divimgDetail">
                                                            <div>奖项：</div>
                                                            <div>我的奖项我的奖项我的奖项我的奖项我的奖项我的奖项我的奖项我的奖项我的奖项</div>
                                                            <div>颁发时间：2013年09月</div>
                                                        </div>
                                                    </li>
                                                    
                                                    <li>
                                                        <div class="divimg"><img src="/wepic/back/pubimg/pic/4.png"></div>
                                                        <div class="divimgDetail">
                                                            <div>奖项：</div>
                                                            <div>我的奖项我的奖项我的奖项我的奖项我的奖项我的奖项我的奖项我的奖项我的奖项</div>
                                                            <div>颁发时间：2013年09月</div>
                                                        </div>
                                                    </li>
                                                </ul>
                                            </div>
                                            <a title="上一张" class="slider_prev" href="javascript:;"></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div> 
                        
                        <div class="option">
                            <a href="javascript:" class="answer">投诉</a>
                            <input type="button" value="重新选择" class="white_button">
                        </div>
                                
                    </div> 
                <!--企业-->     
                
                
                
                <!--被选中后初始状态-->
                    <div class="divList_one">
                    	<div class="divList_one_top">
                            <div class="divPicInfoLeft">
                            	<div class="yaoqing"></div>
                                <div class="divTop">
                                    <a href="javascript:;" class="recommendeli2"><img src="/wepic/public/pic/head/1.png"></a>
                                    <div class="divUserName">
                                        <div class="pUserName">
                                            <span>你是谁</span>
                                           	<!-- <a class="approveNo" title="未实名认证"></a>-->
                                             <a title="个人实名认证" class="approveHave"></a>
                                            <!-- <a class="approveQy" title="企业实名认证"></a>-->
                                            
                                            <a class="gradeThree"></a>
                                        </div>
                                       
                                        <div class="userPosition">
                                            <a title="年龄" class="ageMan">20岁</a>
                                            <a title="工作地" class="address"><span>上海</span><span>嘉定</span></a>
                                        </div>
                                        
                                        <div class="userType">
                                            <div title="职业" class="job"><span>摄影师</span><a></a></div>
                                            <div style="clear:both;"></div>
                                        </div>
                                        
                                        <div class="userAppraise">
                                            <div class="userAppraiseOne">
                                                <p class="userAppraiseOneTop">89789</p>
                                                <p>关注</p>
                                            </div>
                                            
                                            <div class="userAppraiseOne">
                                                <p class="userAppraiseOneTop">89898789</p>
                                                <p>粉丝</p>
                                            </div> 
                                            
                                            <div class="userAppraiseOne">
                                                <p class="userAppraiseOneTop">898789</p>
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
                                        <p class="number">89789</p>
                                        <p>约拍项目</p>
                                    </div>
                                    
                                    <div class="child">
                                        <p class="number">89898789</p>
                                        <p>项目收入</p>
                                    </div> 
                                    
                                    <div class="child">
                                        <p class="number">90%</p>
                                        <p>应约成功率</p>
                                    </div> 
                                    
                                    <div class="child lastchild">
                                        <p class="number">4545</p>
                                        <p>发布作品</p>
                                    </div>  
                                </div>
                            </div>
                               
                            <div class="checkPic">
                                <div class="topdb">
                                    <ul>
                                        <li class="active">联系信息</li>
                                        <li>模特信息</li>
                                        <li>代表作品</li>
                                        <li>代表项目</li>
                                        <li>他的荣誉</li>
                                    </ul>
                                </div>
                                <div class="sliderContactWay">
                                	<div class="slider_div_contact_way">
                                    	<div class="info_way">
                                        	<div class="info_way_ico"></div>
                                        	<div class="info_way_con">点击获取该应约者联系信息</div>
                                        </div>
                                        <div class="info_way_message">您可再此记录您与应约者的沟通您可再此记录您与应约者的沟通您可再此记录您与应约者的沟通您可再此记录您与应约者的沟通您可再此记录您与应约者的沟通您可再此记录您与应约者的沟通您可再此记录您与应约者的沟通您可再此记录您与应约者的沟通您可再此记录您与应约者的沟通您可再此记录您与应约者的沟通您可再此记录您与应约者的沟通您可再此记录您与应约者的沟通您可再此记录您与应约者的沟通您可再此记录您与应约者的沟通您可再此记录您与应约者的沟通您可再此记录您与应约者的沟通</div>
                                    </div>
                                    
                                	<div class="slider_div_model">
                                        <div class="slider_div_model_top">
                                           <div class="slider_children">
                                           		<div class="height_ico"></div>
                                           		<div class="ico_value">170cm</div>
                                           </div>
                                           
                                           <div class="slider_children">
                                           		<div class="weight_ico"></div>
                                           		<div class="ico_value">58kg</div>
                                           </div>
                                           
                                           <div class="slider_children">
                                           		<div class="BWH_ico"></div>
                                           		<div class="ico_value">88-65-88</div>
                                           </div>
                                           
                                           <div class="slider_children">
                                           		<div class="xxx_ico"></div>
                                           		<div class="ico_value">70D</div>
                                           </div>
                                           
                                           <div class="slider_children">
                                           		<div class="shoe_size_ico"></div>
                                           		<div class="ico_value">245(欧码)</div>
                                           </div>
                                        </div>
                                        <div class="slider_div_model_con">
                                           淘宝是利用了很多小商户聚集了流量和用户，为自己的商城做了铺垫。但是，反过来想，这些商户也没少从淘宝赚到钱啊。不能只看到现在的怨怒，不想到感恩。 你依附于渠道赚钱，必也会受制于渠道，你可以想解决方案，但绝不是目前这种行径
                                        </div>
                                    </div>
                                    
                                    <div class="slider_div_work">
                                        <div class="slider_box_ul">
                                            <a title="下一张" class="slider_next" href="javascript:;"></a>
                                            <div class="slider-wrapper">
                                                <ul class="slider-move" style="width: 820px;">
                                                    <li style="">
                                                        <div class="img"><img src="/wepic/back/pubimg/pic/1.png"></div>
                                                        <div class="nowtop">
                                                            <div class="bj"></div>
                                                            <div class="bjc">
                                                            <a class="del" href="javascript:"></a></div>
                                                        </div>
                                                    </li>
                                                    <li>
                                                        <div class="img"><img src="/wepic/back/pubimg/pic/2.png"></div>
                                                    </li>
                                                    <li>
                                                        <div class="img"><img src="/wepic/back/pubimg/pic/3.png"></div>
                                                    </li>
                                                    <li>
                                                        <div class="img"><img src="/wepic/back/pubimg/pic/4.png"></div>
                                                    </li>
                                                </ul>
                                            </div>
                                            <a title="上一张" class="slider_prev" href="javascript:;"></a>
                                        </div>
                                        
                                    </div>
                                    
                                    <div class="slider_div_project">
                                        <div class="slider_box_ul">
                                            <a title="下一张" class="slider_next" href="javascript:;"></a>
                                            <div class="slider-wrapper">
                                                <ul class="slider-move" style="width: 1600px;">
                                                    <li style="">
                                                        <div class="divimg"><img src="/wepic/back/pubimg/pic/1.png"></div>
                                                        <div class="divimgDetail">
                                                            <div>2005年</div>
                                                            <div>国际商务礼仪示范拍摄国际商务礼仪</div>
                                                            <div>德国柏林</div>
                                                        </div>
                                                    </li>
                                                    
                                                    <li>
                                                        <div class="divimg"><img src="/wepic/back/pubimg/pic/2.png"></div>
                                                        <div class="divimgDetail">
                                                            <div>2005年</div>
                                                            <div>国际商务礼仪示范拍摄国际商务礼仪</div>
                                                            <div>德国柏林</div>
                                                        </div>
                                                    </li>
                                                    
                                                    <li>
                                                        <div class="divimg"><img src="/wepic/back/pubimg/pic/3.png"></div>
                                                        <div class="divimgDetail">
                                                            <div>2005年</div>
                                                            <div>国际商务礼仪示范拍摄国际商务礼仪</div>
                                                            <div>德国柏林</div>
                                                        </div>
                                                    </li>
                                                    
                                                    <li>
                                                        <div class="divimg"><img src="/wepic/back/pubimg/pic/4.png"></div>
                                                        <div class="divimgDetail">
                                                            <div>2005年</div>
                                                            <div>国际商务礼仪示范拍摄国际商务礼仪</div>
                                                            <div>德国柏林</div>
                                                        </div>
                                                    </li>
                                                </ul>
                                            </div>
                                            <a title="上一张" class="slider_prev" href="javascript:;"></a>
                                        </div>
                                    </div>
                                    
                                    <div class="slider_div_honor">
                                        <div class="slider_box_ul">
                                            <a title="下一张" class="slider_next" href="javascript:;"></a>
                                            <div class="slider-wrapper">
                                               <ul class="slider-move" style="width: 1600px;">
                                                    <li style="">
                                                        <div class="divimg"><img src="/wepic/back/pubimg/pic/1.png"></div>
                                                        <div class="divimgDetail">
                                                            <div>奖项：</div>
                                                            <div>我的奖项我的奖项我的奖项我的奖项我的奖项我的奖项我的奖项我的奖项我的奖项</div>
                                                            <div>颁发时间：2013年09月</div>
                                                        </div>
                                                    </li>
                                                    
                                                    <li>
                                                        <div class="divimg"><img src="/wepic/back/pubimg/pic/2.png"></div>
                                                        <div class="divimgDetail">
                                                            <div>奖项：</div>
                                                            <div>我的奖项我的奖项我的奖项我的奖项我的奖项我的奖项我的奖项我的奖项我的奖项</div>
                                                            <div>颁发时间：2013年09月</div>
                                                        </div>
                                                    </li>
                                                    
                                                    <li>
                                                        <div class="divimg"><img src="/wepic/back/pubimg/pic/3.png"></div>
                                                        <div class="divimgDetail">
                                                            <div>奖项：</div>
                                                            <div>我的奖项我的奖项我的奖项我的奖项我的奖项我的奖项我的奖项我的奖项我的奖项</div>
                                                            <div>颁发时间：2013年09月</div>
                                                        </div>
                                                    </li>
                                                    
                                                    <li>
                                                        <div class="divimg"><img src="/wepic/back/pubimg/pic/4.png"></div>
                                                        <div class="divimgDetail">
                                                            <div>奖项：</div>
                                                            <div>我的奖项我的奖项我的奖项我的奖项我的奖项我的奖项我的奖项我的奖项我的奖项</div>
                                                            <div>颁发时间：2013年09月</div>
                                                        </div>
                                                    </li>
                                                </ul>
                                            </div>
                                            <a title="上一张" class="slider_prev" href="javascript:;"></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div> 
                        
                        <div class="option">
                            <a href="javascript:" class="answer">投诉</a>
                            <input type="button" value="重新选择" class="white_button">
                        </div>
                                
                    </div>
                <!--被选中后初始状态-->   
                   
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
  </body>
</html>
