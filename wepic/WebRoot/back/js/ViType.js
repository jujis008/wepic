
function sortArrayss(obj){
	$("#selectParentType").val(1);
	//alert("死死死死死死死死死死死死死死死死死"+$("#selectParentType"));
	var ViType=[['企业标志设计'],['企业标志及标志创意说明','标志墨稿','标志反白效果图','标志标准化制图','标志方格坐标制图','标志预留空间与最小比例限定','标志特定色彩效果展示'],['企业标准字体'],['企业全称中文字体','企业简称中文字体','企业全称中文字体方格坐标制图','企业简称中文字体方格坐标制图','企业全称英文字体','企业简称英文字体','企业全称英文字体方格坐标制图',' 企业简称英文字体方格坐标制图 '],['企业标准色（色彩计划）'],['企业标准色（印刷色）','辅助色系列','下属产业色彩识别','背景色使用规定','色彩搭配组合专用表','背景色色度、色相 '],['企业造型（吉祥物）'],['吉祥物彩色稿及造型说明','吉祥物立体效果图','吉祥物基本动态造型','企业吉祥物造型单色印刷规范','吉祥物展开使用规范'],['企业象征图形'],['象征图形彩色稿（单元图形）','象征图形延展效果稿','象征图形使用规范','象征图形组合规范'],['企业专用印刷字体'],['企业专用印刷字体'],['基本要素组合规范'],['标志与标准字组合多种模式','标志与象征图形组合多种模式','标志吉祥物组合多种模式','标志与标准字、象征图形、吉祥物组合多种模式','基本要素禁止组合多种模式'],['办公事物用品设计'],['高级主管名片','中级主管名片','员工名片','信封','国内信封 ','国际信封','大信封','信纸','国内信纸','国际信纸','特种信纸','便笺','传真纸','票据夹','合同夹','合同书规范格式','档案盒','薪资袋','识别卡（工作证）','临时工作证','出入证','工作记事簿','文件夹','文件袋','档案袋','卷宗纸','公函信纸','备忘录','简报','签呈','文件题头','直式、横式表格规范','电话记录','办公文具','聘书','岗位聘用书','奖状','公告','维修网点名址封面及内页版式','产品说明书封面及内页版式','考勤卡','请假单','名片盒','名片台','办公桌标识牌','及时贴标签','意见箱','稿件箱','企业徽章','纸杯','茶杯、杯垫','办公用笔、笔架','笔记本','记事本','公文包 ','通讯录','财产编号牌','培训证书','国旗、企业旗、吉祥物旗旗座造型','挂旗','屋喜欢你的作品,向你学习吊旗','竖旗','桌旗 '],['公共关系赠品设计'],['贺卡','专用请柬','邀请函及信封','手提袋','包装纸','钥匙牌','鼠标垫','挂历版式规范 ','台历版式规范','日历卡版式规范','明信片版式规范','小型礼品盒','礼赠用品','标识伞'],['员工服装、服饰规范'],['管理人员男装（西服礼装/白领/领带/领带夹）','管理人员女装（裙装/西式礼装/领花/胸饰）','春秋装衬衣（短袖）','春秋装衬衣（长袖）','员工男装（西装/蓝领衬衣/马甲）','员工女装（裙装/西装/领花/胸饰）','冬季防寒工作服','运动服外套','运动服、运动帽、Ｔ恤（文化衫）','外勤人员服装','安全盔','工作帽'],['企业车体外观设计'],['公务车','面包车','班车','大型运输货车','小型运输货车','集装箱运输车','特殊车型 '],['标志符号指示系统'],['企业大门外观','企业厂房外观','办公大楼体示意效果图','大楼户外招牌','公司名称标识牌','公司名称大理石坡面处理','活动式招牌','公司机构平面图',' 大门入口指示','玻璃门','楼层标识牌','方向指引标识牌','公共设施标识','布告栏','生产区楼房标志设置规范','立地式道路导向牌','立地式道路指示牌','立地式标识牌','欢迎标语牌','户外立地式灯箱','停车场区域指示牌','立地式道路导向牌','车间标识牌与地面导向线  ','车间标识牌与地面导向线','生产车间门牌规范','分公司及工厂竖式门牌','门牌','生产区平面指示图','生产区指示牌','接待台及背景板','室内企业精神口号标牌','玻璃门窗醒示性装饰带','车间室内标识牌','警示标识牌','公共区域指示性功能符号','公司内部参观指示','各部门工作组别指示','内部作业流程指示','各营业处出口／通路规划'],['销售店面标识系统'],['小型销售店面','大型销售店面','店面横、竖、方招牌','导购流程图版式规范','店内背景板（形象墙）','店内展台','配件柜及货架','店面灯箱','立墙灯箱','资料架','垃圾筒','室内环境 '],['企业商品包装识别系统'],['大件商品运输包装','外包装箱（木质、纸质）','商品系列包装','礼品盒包装','包装纸','配件包装纸箱','合格证','产品标识卡','存放卡','保修卡','质量通知书版式规','说明书版式规范','封箱胶','会议事务用品 '],['企业广告宣传规范'],['电视广告标志定格','报纸广告系列版式规范（整版、半版、通栏）','杂志广告规范','海报版式规范 ','系列主题海报','大型路牌版式规范','灯箱广告规范','公交车体广告规范','双层车体车身广告规范','Ｔ恤衫广告','横竖条幅广告规范','大型氢气球广告规范','霓红灯标志表现效果','直邮ＤＭ宣传页版式','广告促销用纸杯','直邮宣传三折页版式规范','企业宣传册封面、版式规范','年度报告书封面版式规范','宣传折页封面及封底版式规范','产品单页说明书规范','对折式宣传卡规范','网络主页版式规范','分类网页版式规范','光盘封面规范','擎天拄灯箱广告规范','墙体广告','楼喜欢你的作品,向你学习灯箱广告规范','户外标识夜间效果','展板陈列规范','柜台立式ＰＯＰ广告规范','立地式ＰＯＰ规范','悬挂式ＰＯＰ规范','产品技术资料说明版式规范','产品说明书','路牌广告版式'],['展览指示系统'],['标准展台、展板形式','特装展位示意规范','标准展位规范','样品展台','样品展板','产品说明牌','资料架','会议事务用品 '],['再生工具'],['色票样本标准色','色票样本辅助色','标准组合形式','象征图案样本','吉祥物造型样本']];
	 $("#haveChooseChild").html($("#chooseULChild").find('input:checked').length);
	// $("#haveChooseChild").html($('input:checked').length);
	$.each(ViType,function(key,val){
			        //回调函数有两个参数,第一个是元素索引,第二个为当前值
		if($.trim(val)==$.trim(obj)){
		// alert('fruit数组中，索引：'+key+1+'对应的值为：'+ViType[key+1]);
			var child=ViType[key+1];
			var sele="";
			
			for(var i=0;i<child.length;i++){
				var bool=false;
				$("#"+$.trim(obj)).find("li").each(function(){
					if($.trim(child[i])==$.trim($(this).find("span").text())){
						bool=true;
						
						return true;
					}
					
					
					
				});
				 
				if(bool){
				sele+='<li><input type="checkbox" checked="checked" value="'+child[i]+'" class="childIndustryValueCheck"> <span class="childIndustryValueSpan">'+child[i]+'</span></li>';
				}else{
				sele+='<li><input type="checkbox" value="'+child[i]+'" class="childIndustryValueCheck"> <span class="childIndustryValueSpan">'+child[i]+'</span></li>';
				}
				$("#chooseULChild").html(sele);
				 countCheck();
				 $("#selectParent").val(obj);
				
			}
		}
	});
	
}





function sortArrayssApplication(obj){
//	alert("asdffadsfsdsggsg");
	$("#selectParentType").val(2);
	var ViType=[['企业标志设计'],['企业标志及标志创意说明','标志墨稿','标志反白效果图','标志标准化制图','标志方格坐标制图','标志预留空间与最小比例限定','标志特定色彩效果展示'],['企业标准字体'],['企业全称中文字体','企业简称中文字体','企业全称中文字体方格坐标制图','企业简称中文字体方格坐标制图','企业全称英文字体','企业简称英文字体','企业全称英文字体方格坐标制图',' 企业简称英文字体方格坐标制图 '],['企业标准色（色彩计划）'],['企业标准色（印刷色）','辅助色系列','下属产业色彩识别','背景色使用规定','色彩搭配组合专用表','背景色色度、色相 '],['企业造型（吉祥物）'],['吉祥物彩色稿及造型说明','吉祥物立体效果图','吉祥物基本动态造型','企业吉祥物造型单色印刷规范','吉祥物展开使用规范'],['企业象征图形'],['象征图形彩色稿（单元图形）','象征图形延展效果稿','象征图形使用规范','象征图形组合规范'],['企业专用印刷字体'],['企业专用印刷字体'],['基本要素组合规范'],['标志与标准字组合多种模式','标志与象征图形组合多种模式','标志吉祥物组合多种模式','标志与标准字、象征图形、吉祥物组合多种模式','基本要素禁止组合多种模式'],['办公事物用品设计'],['高级主管名片','中级主管名片','员工名片','信封','国内信封 ','国际信封','大信封','信纸','国内信纸','国际信纸','特种信纸','便笺','传真纸','票据夹','合同夹','合同书规范格式','档案盒','薪资袋','识别卡（工作证）','临时工作证','出入证','工作记事簿','文件夹','文件袋','档案袋','卷宗纸','公函信纸','备忘录','简报','签呈','文件题头','直式、横式表格规范','电话记录','办公文具','聘书','岗位聘用书','奖状','公告','维修网点名址封面及内页版式','产品说明书封面及内页版式','考勤卡','请假单','名片盒','名片台','办公桌标识牌','及时贴标签','意见箱','稿件箱','企业徽章','纸杯','茶杯、杯垫','办公用笔、笔架','笔记本','记事本','公文包 ','通讯录','财产编号牌','培训证书','国旗、企业旗、吉祥物旗旗座造型','挂旗','屋喜欢你的作品,向你学习吊旗','竖旗','桌旗 '],['公共关系赠品设计'],['贺卡','专用请柬','邀请函及信封','手提袋','包装纸','钥匙牌','鼠标垫','挂历版式规范 ','台历版式规范','日历卡版式规范','明信片版式规范','小型礼品盒','礼赠用品','标识伞'],['员工服装、服饰规范'],['管理人员男装（西服礼装/白领/领带/领带夹）','管理人员女装（裙装/西式礼装/领花/胸饰）','春秋装衬衣（短袖）','春秋装衬衣（长袖）','员工男装（西装/蓝领衬衣/马甲）','员工女装（裙装/西装/领花/胸饰）','冬季防寒工作服','运动服外套','运动服、运动帽、Ｔ恤（文化衫）','外勤人员服装','安全盔','工作帽'],['企业车体外观设计'],['公务车','面包车','班车','大型运输货车','小型运输货车','集装箱运输车','特殊车型 '],['标志符号指示系统'],['企业大门外观','企业厂房外观','办公大楼体示意效果图','大楼户外招牌','公司名称标识牌','公司名称大理石坡面处理','活动式招牌','公司机构平面图',' 大门入口指示','玻璃门','楼层标识牌','方向指引标识牌','公共设施标识','布告栏','生产区楼房标志设置规范','立地式道路导向牌','立地式道路指示牌','立地式标识牌','欢迎标语牌','户外立地式灯箱','停车场区域指示牌','立地式道路导向牌','车间标识牌与地面导向线  ','车间标识牌与地面导向线','生产车间门牌规范','分公司及工厂竖式门牌','门牌','生产区平面指示图','生产区指示牌','接待台及背景板','室内企业精神口号标牌','玻璃门窗醒示性装饰带','车间室内标识牌','警示标识牌','公共区域指示性功能符号','公司内部参观指示','各部门工作组别指示','内部作业流程指示','各营业处出口／通路规划'],['销售店面标识系统'],['小型销售店面','大型销售店面','店面横、竖、方招牌','导购流程图版式规范','店内背景板（形象墙）','店内展台','配件柜及货架','店面灯箱','立墙灯箱','资料架','垃圾筒','室内环境 '],['企业商品包装识别系统'],['大件商品运输包装','外包装箱（木质、纸质）','商品系列包装','礼品盒包装','包装纸','配件包装纸箱','合格证','产品标识卡','存放卡','保修卡','质量通知书版式规','说明书版式规范','封箱胶','会议事务用品 '],['企业广告宣传规范'],['电视广告标志定格','报纸广告系列版式规范（整版、半版、通栏）','杂志广告规范','海报版式规范 ','系列主题海报','大型路牌版式规范','灯箱广告规范','公交车体广告规范','双层车体车身广告规范','Ｔ恤衫广告','横竖条幅广告规范','大型氢气球广告规范','霓红灯标志表现效果','直邮ＤＭ宣传页版式','广告促销用纸杯','直邮宣传三折页版式规范','企业宣传册封面、版式规范','年度报告书封面版式规范','宣传折页封面及封底版式规范','产品单页说明书规范','对折式宣传卡规范','网络主页版式规范','分类网页版式规范','光盘封面规范','擎天拄灯箱广告规范','墙体广告','楼喜欢你的作品,向你学习灯箱广告规范','户外标识夜间效果','展板陈列规范','柜台立式ＰＯＰ广告规范','立地式ＰＯＰ规范','悬挂式ＰＯＰ规范','产品技术资料说明版式规范','产品说明书','路牌广告版式'],['展览指示系统'],['标准展台、展板形式','特装展位示意规范','标准展位规范','样品展台','样品展板','产品说明牌','资料架','会议事务用品 '],['再生工具'],['色票样本标准色','色票样本辅助色','标准组合形式','象征图案样本','吉祥物造型样本']];
	 $("#haveChooseChild").html($("#chooseULChild").find('input:checked').length);
	// $("#haveChooseChild").html($('input:checked').length);
	$.each(ViType,function(key,val){
			        //回调函数有两个参数,第一个是元素索引,第二个为当前值
		if($.trim(val)==$.trim(obj)){
		// alert('fruit数组中，索引：'+key+1+'对应的值为：'+ViType[key+1]);
			var child=ViType[key+1];
			var sele="";
			
			for(var i=0;i<child.length;i++){
				var bool=false;
				$("#"+$.trim(obj)).find("li").each(function(){
					if($.trim(child[i])==$.trim($(this).find("span").text())){
						bool=true;
						
						return true;
					}
					
					
					
				});
				 
				if(bool){
				sele+='<li><input type="checkbox" checked="checked" value="'+child[i]+'" class="childIndustryValueCheck"> <span class="childIndustryValueSpan">'+child[i]+'</span></li>';
				}else{
				sele+='<li><input type="checkbox" value="'+child[i]+'" class="childIndustryValueCheck"> <span class="childIndustryValueSpan">'+child[i]+'</span></li>';
				}
				$("#chooseULChild").html(sele);
				 countCheck();
				 $("#selectParent").val(obj);
				
			}
		}
	});
	
}
