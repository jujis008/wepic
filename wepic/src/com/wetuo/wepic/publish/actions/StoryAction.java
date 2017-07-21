package com.wetuo.wepic.publish.actions;

import java.awt.Stroke;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;
import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import sun.print.resources.serviceui;

import com.opensymphony.xwork2.ActionContext;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.org.apache.regexp.internal.recompile;
import com.sun.xml.internal.bind.v2.runtime.Name;
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.struts.Constants;
import com.wetuo.wepic.common.struts.PageAction;
import com.wetuo.wepic.common.util.ConvertChinese;
import com.wetuo.wepic.common.util.HtmlToDoc;
import com.wetuo.wepic.common.util.OperateImage;
import com.wetuo.wepic.common.util.PropertiesRead;
import com.wetuo.wepic.common.util.UploadUtils;
import com.wetuo.wepic.common.util.zipcompression;

import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.core.service.UserService;
import com.wetuo.wepic.publish.beans.Publish;
import com.wetuo.wepic.publish.beans.PublishCat;
import com.wetuo.wepic.publish.beans.PublishCat_Story;
import com.wetuo.wepic.publish.beans.PublishSpecialCat;
import com.wetuo.wepic.publish.beans.PublishStatus;
import com.wetuo.wepic.publish.beans.Story;
import com.wetuo.wepic.publish.beans.StoryDetail;
import com.wetuo.wepic.publish.service.PublishCatService;
import com.wetuo.wepic.publish.service.PublishCat_StorySevice;
import com.wetuo.wepic.publish.service.PublishService;
import com.wetuo.wepic.publish.service.PublishSpecialCatService;
import com.wetuo.wepic.publish.service.StoryDetailService;
import com.wetuo.wepic.publish.service.StoryService;
@SuppressWarnings({ "unchecked", "serial" ,"unused"})
public class StoryAction extends PageAction{
	private StoryService storyService;
	private File mycover; 
	private String mycoverFileName; 
	private String mycoverContentType;
	private String msg;
	private Integer publishId;
	private Story story;
	private List<PublishCat> publishCats;
	private List<PublishSpecialCat> specialCats;
	private List<Story> stories;
	private Integer x1;
	private Integer y1;
	private Integer x2;
	private Integer y2;
	private Integer picNum;
	private Integer textNum;
	private List<StoryDetail> storyDetails;
	private PublishSpecialCat specialCat;
	private List<PublishCat_Story> publishCatStories;
	private Integer flag;
	private Integer storyId;
	private List storytags;
	private String downFileName;
	private String copyrightuseprice;
	private String copyrightcopyrightprice;
	private Integer totalRes;
	private String[] count;
	private int publishSpecialCatId;
	private int storystatu;
	private Integer toolStory;
	private Integer publishedStory;
	private List<Story> stroys;
	private Integer specialId;
	private String operateIds;
	private String resMsg;
	private OutputStream res;
	private ZipOutputStream zos;
	
	
	
	public String releasestory() {
		return "releasestory";
	}
	
	public String buystory() {
		stories=this.getStoryService().findAll();
		return "buystory";
	}
	
	public String newandcreatestory() {
		int id=super.getLonginUserId();
		   if(id==0){
			   return "findstorybyCountBySpecialCat";  
			   
		   }
		publishCats=this.getStoryService().publishCats();
		specialCats=this.getStoryService().specialCats(id);
		return "newandcreatestory";
	}
	
	@JSON(serialize=false)
	public String existsstory() {
		int id=super.getLonginUserId();
		stories=this.getStoryService().existsstory(id);
		return "existsstory";
	}
	
	///////////////////////管理员审核///////////////////////////////
	public String waitcheck() {
		DetachedCriteria criteria1=DetachedCriteria.forClass(Story.class);
		criteria1.createAlias("publishStatus", "publishStatus");
		criteria1.add(Restrictions.or(Restrictions.ne("publishStatus.onOffer",1), Restrictions.ne("publishStatus.pass",1)));
		criteria1.add(Restrictions.or(Restrictions.ne("publishStatus.unreleased",0),Restrictions.ne("publishStatus.awaitingReview",0)));
		criteria1.add(Restrictions.ne("publishStatus.noPass",1));
		criteria1.add(Restrictions.eq("publishStatus.adminDelete",0));
//		criteria1.add(Restrictions.ne("publishStatus.awaitingReview",0));
//		criteria1.add(Restrictions.or(Restrictions.ne("publishStatus.unreleased",0), Restrictions.or(Restrictions.ne("publishStatus.awaitingReview",0)
//				,Restrictions.or(Restrictions.ne("publishStatus.onOffer",1), Restrictions.ne("publishStatus.pass",1)))));
		super.pager=this.getStoryService().findbyDetachedCriteria(criteria1, pageNo,5);
		//super.pager=this.getStoryService().listofstatu(5,pageNo);
		return "waitcheck";
	}
	
	public String adminsearch() {
		story=this.getStoryService().select(storyId);
		publishCatStories=this.getStoryService().findStoryCat(storyId);
		return "adminsearch";
	}
	
	public String searchnopass() {
		story=this.getStoryService().select(storyId);
		publishCatStories=this.getStoryService().findStoryCat(storyId);
		return "searchnopass";
	}
	
	public String adminSoldout() {
		DetachedCriteria criteria1=DetachedCriteria.forClass(Story.class);
		criteria1.createAlias("publishStatus", "publishStatus");
		criteria1.add(Restrictions.eq("publishStatus.adminSoldout",1));
		criteria1.add(Restrictions.eq("publishStatus.adminDelete",0));
		super.pager=this.getStoryService().findbyDetachedCriteria(criteria1, pageNo,16);
		return "adminSoldout";
	}
	public String searchadminsoldout() {
		story=this.getStoryService().select(storyId);
		publishCatStories=this.getStoryService().findStoryCat(storyId);
		return "searchadminsoldout";
	}
	
	public String adminsinglesoldout() {
//		story=this.getStoryService()
		this.getStoryService().adminsoldout(storyId,story);
		return "adminsinglesoldout";
	}
	
	public String soldoutdel() {
		this.getStoryService().admindelchecking(storyId);
		return "soldoutdel";
	}
	
	public String recoverupload() {
		this.getStoryService().adminrecover(storyId);
		return "recoverupload";
	}
	/**
	 * 管理员删除
	 * @return
	 */
	public String admindelchecking() {
		this.getStoryService().admindelchecking(storyId);
		
		return "admindelchecking";
	}
	
	public String adminchecksuc() {
		this.getStoryService().adminchecksuc(storyId);
		return "adminchecksuc";
	}
	public String adminchecksucsearch() {
		story=this.getStoryService().select(storyId);
		publishCatStories=this.getStoryService().findStoryCat(storyId);
		return "adminchecksucsearch";
	}
	public String adminedit() {
		story=this.getStoryService().select(storyId);
		return "adminedit";
	}
	public String checksuclist() {
		DetachedCriteria criteria1=DetachedCriteria.forClass(Story.class);
		criteria1.createAlias("publishStatus", "publishStatus");
		criteria1.add(Restrictions.or(Restrictions.ne("publishStatus.onOffer",0), Restrictions.ne("publishStatus.pass",0)));
		criteria1.add(Restrictions.eq("publishStatus.adminSoldout",0));
		super.pager=this.getStoryService().findbyDetachedCriteria(criteria1, pageNo,16);
		//super.pager=this.getStoryService().listofstatu(5,pageNo);
		return "checksuclist";
	}
	public String checknopass() {
//		story=this.getStoryService().select(storyId);
		this.getStoryService().checknopass(story,storyId);
		return "checknopass";
	}
	
	public String test() {
		String temp="10八,香港总部,颠覆中国政权,烟草局,温总理,文革,文化部,文化大革命,文物局,文学城,自由亚州,自由运动,对日强硬,一部分人因年龄或健康原因将不得不退下去,一党专政,一党专制,一贯道,一国两制,国际法院,新疆独,新疆独立,找政府评理,贾庆,林黄菊,18大的人事,政变,政府,政局雾里看花,银行联合管理局,政权,正法,镇压,政治,中功,伊拉克,伊斯兰,伊斯兰运动,中共,一中一台,政治反对派,政治犯,政治风波,政治局十八,政治字眼（如两岸关系等）,郑恩宠,蒋介石,中南海,中南海波澜起伏,中南海斗争,中南海高层权利斗争,中南海惊现东宫小朝廷,中南海秘闻,原子能机构,中共权斗,中共权利斗争,中南海权力斗争,中宣部,中央,治军方针定调,中央军委,中央派系斗争,中央团系,李三共志,国家安全,造反,李克强第五代领导人,李克强接班人,国家机密,国家主要部委,国军,国民党,胡紧掏,胡锦涛,胡锦滔,胡锦淘,胡景涛,国民根本大法,国庆,非典,东突厥斯坦伊斯兰运动,海关总署,国务院,国贼,海洋局,海外民运,国资委,封杀,东西南北论坛,分析,中共派系力量再达成妥协,反革命,反攻,反攻大陆,反共,反华,反恐委员会,反社会,游龙商务联盟,游戏管理员,反政府,反目,优化官员,应召,印章,反日,反人类,反腐败,反封锁,颠覆中华人民共和国政,东北独立,帝国之梦,帝国主义,弟大物勃,北京市亿霖,公司,布局十八大,藏独,党政一把手,党中央,党风日下,邓小平,邓晓平,党禁,党退,布什,大纪元,测绘局,大陆当局,分裂,压迫,分裂中国,分裂中华人民共和国,第5代领导,第四代,多党,第五代领导,第五代领导人,第五代领导新星,第五代中共领导人,独裁,独裁政治,独夫,独立,动乱,北京,18大,1717wg.88448.com,北京当局,绑架,18da,暗杀,报警,北京政权,暴力,暴乱,暴政,爆炸,安理会,安全部,安全监管,安全局,保监会,保密室,西藏,西藏独,西藏独立,西藏天葬,西山会议,打压,爱滋,出卖,18届,18届常委,18届名单,18届委员,18届中央,18权力布局,18预测,爱国运动正名,爱国者同盟,奥运,奥运会,18大的人事安排意见,18大人事变动,连战,两岸关系,两岸三地论坛,亡党,两个中国,两会,连准,秘书长,密码,南联盟,内幕,深圳国领,深圳红岭,年轻高知团系接班,收货,收容所,示威,世华商务,事实独立,廉政大论坛,柳树中学,六四,卖国,卖国唐捷,人弹,人民,人民报,人民报讯,天安门,天安门录影带,天安门母亲,天安门事件,天安门屠杀,天安门一代,末世论,人民大会堂,绵恒,绵恒异议人士,人民大众,人民大众时事参考,人民内情真相,人民日报,人民真实,人民真实报道,人民真实报告,人民之声,人民之声论坛,人权,人事变动,人事布局出手既稳又重,人事接班,人体炸弹,人员安排,人员变动,人渣,人质,六四民主运动,天府广场集会,通信维权,铁道部,统独,统计局,统战,美国参考,美国佬,美国之音,台*湾,台办,台独,台盟,台湾,台湾独,台湾独立,台湾共合国,台湾狗,台湾建国运动组织,台湾联盟,台湾青年独立联盟,台湾政论区,台湾自由联盟,摊牌要权,贪官,贪污犯,唐人电视台,讨伐,讨伐中宣部,缅甸,美利坚,权威主义国家的合法性理论,全国两会,蒙独,蒙古独,亲美,亲民党,亲日,青天白日旗,蒙古独立,六四事件,六四学生运动,领事馆,令狐计划,同胞书,令计划,透支,突厥斯坦,涂运普,屠杀,团派,团派政治明星,推翻,推翻社会主义制度,退党,外汇局,外交部,外交论坛,外交与方略,外蒙,外围,晚年周恩来,平反,迫害,罗蒙马格赛基金会,十大穷人,十六大,十八大,十八大权力变更,十八大人事,十八大人事安排意见,十八大人事调整,十八大未来,十八大预测,省市换班第五代冒起,省委大门集合,省政府大门集合,十八大政治局,萨达姆,萨拉托加,三个代表,如何推翻中共,瑞士金融大学,上访,上海帮,上海孤儿院,上海垮台,上海市劳动和社会保障局违规使用社保资金,社保基金会,社会主义,融资,审计署,生当作人杰之昨日重现,十八换血,十八届,十八年,商务部,商务领航,十八庆红,数据中国,刷卡,刷卡消费,双十节,刘奇葆热门人选,四川独,四川独立,出台,膏药旗,高层人事变动,加拿大皇家骑警,胡权利瓜分,胡书记,胡温,胡晓炼,胡耀邦,胡玉敏,胡泽君,胡振民,胡总书记,建国党,检查部,韩长赋,韩东方,韩联潮,韩正,韩正降职副市长,捍卫社会主义共和国,监管局,建设部,僵贼,僵贼民,姜春云,姜大明,姜洪禄,姜建清,姜伟新,姜异康,将则民,江Core,江core.江ze民,江澤民.江八,江八点.江独裁,江蛤蟆.江核心,江流氓,江戏子,江责民,江则民,江泽慧江泽林,江泽民.江贼,江贼民.江折民,江猪.江猪媳,江主,酱猪媳,抗日,抗议,教养院,教育部,老人政治,公证,公证处,共军,锦涛,共青团背景,共铲党,老江,联合行动,联大,联合国,联合起诉最高人民法院,老毛,老毛子,积克馆,共产,共产党,回民,回民暴,回民,暴动,换届隐忧,共党,大史,复转军人,公关,公馆,军长发威,军事委员会,军委,军委主席,军转安置,军转干部,公开批评中央高层领导人,公开信胡,公开信胡书记空中民主墙,鸡毛信文汇,恐怖份子,恐怖主义,纪元,公投,理想信念斗争,持不同政见,腐败,从陈良宇倒台看中国政局走势,周恩来后悔,周恩来自责,周刊纪事,周恩来忏悔,中央召开北戴河会议决定十八大高层人事,中国在统一问题上的投降主义,中国真实内容,子女任职名单,咨讯紫阳,中国政坛“清华帮”盛极而衰,中国政坛新星中的四大天王,中国政治新星,中国泛蓝联盟,中国复兴论坛,中国改革年代政治斗争,西藏论坛,中国高层权力斗争,中国高层人事变动解读,中国六四真相,中国论坛,中国媒体十大事件,中国民主党联合总部,中国社会的艾滋病,中国社会进步党,中国社会论坛,中国共产党,中国孤儿院,中国和平,中国联通,中国太子,中国网通,中共当局,中共独裁,中共反腐风暴大背景揭秘,中共高层变动：王兆国将任常委或取代贾庆龄,中共领导人黑幕,香港明报,星亚网络影视公司,中共十八布局,中共十八大的基层选举,中共十八大前夕,中共十八大前夕人事布局出手既稳又重,中共十八大热门人选,中共十八热门人选,中共十八人事,中共十八人事变动,中共十八人选,中国威胁论,中国问题论坛,中国移动,中国移动通信,中国银联,18大委员名单,大中国论坛,大中华论坛,18高官互调,4．25事件,钟山风雨论坛,重新评定,邮政局,印尼伊斯兰祈祷团,中央政治局,中医药局,40万名车车主名单,信访局,信号,信息产业部,信用卡,信用卡空卡,信用危机,星相,版署,新生网,新势力,英雄纪念碑,九评共产党,新党,中华人民正邪,中华时事,燕南评论,央视内部晚会,中华养生益智功,中华真实报道,中华大地思考,宇明网,宇宙真理,语音,中华大众,中华讲清,阿拉,安南,东洲,北韩,鲜族,俄国,民告官,民国,民航局,民进党,民联,民意,民意论坛,民运,民阵,民政部,民猪,民主,民主潮,民主墙,民族矛盾,民族问题,诺贝尔和平奖,,大法,大法弟子,dpp大法,fa lun,falu,发抡,发抡功,洗脑,下法轮,发轮,发伦,发伦功,发仑,发沦,发纶,发论,发论功,发论公,发正念,发囵,发愣,发瞟,罚抡,罚伦,罚仑,罚沦,罚纶,罚囵,筏抡,筏轮,筏伦,筏仑,筏沦,筏纶,筏论,筏囵,伐抡,伐轮,伐伦,伐仑,伐沦,伐论,伐囵,乏抡,乏轮,乏伦,乏仑,乏沦,乏纶,乏论,乏囵,阀抡,阀伦,阀仑,阀沦,阀纶,阀论,阀囵,法 轮 功,法*功,法.轮.功,法L功,法lun功,法功,法会,法抡,法抡功,法轮,法轮大法,法轮佛法,法轮功,法伦,法仑,法沦,法纶,法论,法十轮十功,法西斯,法院,法正,法谪,法谪功,法輪,法囵,法愣,珐.輪功,珐抡,珐轮,珐伦,珐仑,珐沦,五不,五不争鸣论坛,五出三进,五套功法,邝锦文,垡抡,垡轮,垡伦,垡仑,垡沦,垡纶,垡论,垡囵,茳澤民,荭志,闳志,闵维方,氵去,氵去车仑工力,转法轮,砝抡,砝轮,砝伦,砝仑,砝沦,砝纶,真、善、忍,真理教,真善美,真善忍,砝论,砝囵,泓志,屙民,珐纶,珐论,珐囵,falun,Falundafa,fa轮,Flg,弟子,地下教会,炼功,梦网洪志,轮大,抡功,轮功,伦功,摩门教,三水法轮,三唑仑,天皇,天怒,天葬,车臣,达赖,功法,讲法,基督,基督教,护法,回教,教徒,功友,大师,达赖喇嘛,虹志,鸿志,洪传,贯通两极法,光祖,洪吟,洪哲胜,洪志,宏法,观世音,宏志,弘志,古兰经,红志,车库,车仑,经文,,东方红时空,风水宝地,舆论,舆论反制,风雨神州,自杀手册,自杀指南,自已的故事,自由,自由民主论坛,自由网,自由写作奖,自制手枪,自主择业,宗教压迫,先天健康法,阻止中华人民共和国统,昨日重现,咨询,咨讯,风雨神州论坛,东方时空,独立台湾会,访问链接,飞扬论坛,独立中文笔会,东南西北论谈,真相,真象,侦探设备,争鸣论坛,正帮通信公司,正见,正邪大决战,正义党论坛,北京之春民主论坛,北美讲坛,倒陈运动的最大受益人,反封锁技术,反腐败论坛,地下刊物,恶搞晚会,北美讲坛,北美论坛,地铁十号线塌方,逊克农场26队,春夏论坛,邓颖超日记,国研新闻邮件,国色天香网,春夏之交,春夏自由论坛,亚洲周刊,亚洲自由之声,博讯,邓小平和他的儿子,政坛两黑马,政坛明日之星,中國當局,中朝,中电信,中俄边界,中俄边界新约,中俄密约,致胡书记的公开信,指点江山论坛,北美自由论坛,参加者回忆录,大纪元新闻网,九-评,九.评,九、评,九—评,九成,九成新,九码,九评,新观察论坛,新华举报,新华内情,新华社,新华通论坛,大众真人真事,大家论坛,新唐人,新唐人电视台,新闻办,新闻封锁,新语丝,印尼伊斯兰祈祷团,北大三角,地论坛,9.635,9评,中华人民实话实说,杂志,E周刊,安装卫星电视,代表大会,论坛,南大论坛,南大自由论坛,强硬发言,南华早报,你说我说论坛,木子论坛,两会报道,两会新闻,轻舟快讯,热站政论网,时代论坛,时事参考,时事论坛,万维读者论坛,统独论坛,特讯,世界经济导报,世界通,超常科学,传说的胡曾联手是一种假象,大纪元,港澳办,跨世纪的良心犯,告全国股民同胞书,华岳,华岳时事论坛,华夏文摘快递,华语世界论坛,和平请愿书,华人媒体,华通时事论坛,华夏文摘,广 闻,广电局,广东五元集团,广告,广闻,红潮谎言录,告全体网民书,告中国人民解放军广大官兵书,港料,大史记,联总之声,集会,集体上访,讲事实,要说法,霍英东临终遗言,大史纪,高校群体事件,传中共中央关于18大的人事安排意见,,安眠酮,代血浆,普萘洛尔,呋塞米,西布曲明,testosterone,胰岛素样生长因子,促红细胞生成素,地西泮,尼可刹米,甲睾酮,adrenaline,erythropoietin,地奈德,莫达非尼,氯噻嗪,苯巴比妥,促性腺激素,泼尼松,麻黄草,雄烯二醇,地塞米松,tamoxifen,strychnine,androst,新型毒品,杜冷丁,兴奋剂,mdma,海洛因,海luo因,heroin,diamorphine,diacetylmorphine,鸦片,阿芙蓉,咖啡因,cocain,三唑仑,美沙酮,麻古,k粉,凯他敏,ketamine,冰毒,苯丙胺,cannabis,大麻,爱他死,氯胺酮,benzodiazepines,甲基安非他明,安非他命,吗啡,morphine,摇头丸,迷药,乖乖粉,narcotic,麻醉药,精神药品,爱女人,爱液,按摩棒,拔出来,爆草,包二奶,暴干,暴奸,暴乳,爆乳,暴淫,屄,被操,被插,被干,逼奸,仓井空,插暴,操逼,操黑,操烂,肏你,肏死,操死,操我,厕奴,插比,插b,插逼,插进,插你,插我,插阴,潮吹,潮喷,成人电影,成人论坛,成人色情,成人网站,成人文学,成人小说,艳情小说,成人游戏,吃精,赤裸,抽插,扌由插,抽一插,春药,大波,大力抽送,大乳,荡妇,荡女,盗撮,多人轮,发浪,放尿,肥逼,粉穴,封面女郎,风月大陆,干死你,干穴,肛交,肛门,龟头,裹本,国产av,好嫩,豪乳,黑逼,后庭,后穴,虎骑,花花公子,换妻俱乐部,黄片,几吧,鸡吧,鸡巴,鸡奸,寂寞男,寂寞女,妓女,激情,集体淫,奸情,叫床,脚交,金鳞岂是池中物,金麟岂是池中物,精液,就去日,巨屌,菊花洞,菊门,巨奶,巨乳,菊穴,开苞,口爆,口活,口交,口射,口淫,裤袜,狂操,狂插,浪逼,浪妇,浪叫,浪女,狼友,聊性,流淫,铃木麻,凌辱,漏乳,露b,乱交,乱伦,轮暴,轮操,轮奸,裸陪,买春,美逼,美少妇,美乳,美腿,美穴,美幼,秘唇,迷奸,密穴,蜜穴,蜜液,摸奶,摸胸,母奸,奈美,奶子,男奴,内射,嫩逼,嫩女,嫩穴,捏弄,女优,炮友,砲友,喷精,屁眼,品香堂,前凸后翘,强jian,强暴,强奸处女,情趣用品,情色,拳交,全裸,群交,惹火身材,人妻,人兽,日逼,日烂,肉棒,肉逼,肉唇,肉洞,肉缝,肉棍,肉茎,肉具,揉乳,肉穴,肉欲,乳爆,乳房,乳沟,乳交,乳头,三级片,骚逼,骚比,骚女,骚水,骚穴,色逼,色界,色猫,色盟,色情网站,色区,色色,色诱,色欲,色b,少年阿宾,少修正,射爽,射颜,食精,释欲,兽奸,兽交,手淫,兽欲,熟妇,熟母,熟女,爽片,爽死我了,双臀,死逼,丝袜,丝诱,松岛枫,酥痒,汤加丽,套弄,体奸,体位,舔脚,舔阴,调教,偷欢,偷拍,推油,脱内裤,文做,我就色,无码,舞女,无修正,吸精,夏川纯,相奸,小逼,校鸡,小穴,小xue,写真,性感妖娆,性感诱惑,性虎,性饥渴,性技巧,性交,性奴,性虐,性息,性欲,胸推,穴口,学生妹,穴图,亚情,颜射,阳具,杨思敏,要射了,夜勤病栋,一本道,一夜欢,一夜情,一ye情,阴部,淫虫,阴唇,淫荡,阴道,淫电影,阴阜,淫妇,淫河,阴核,阴户,淫贱,淫叫,淫教师,阴茎,阴精,淫浪,淫媚,淫糜,淫魔,淫母,淫女,淫虐,淫妻,淫情,淫色,淫声浪语,淫兽学园,淫书,淫术炼金士,淫水,淫娃,淫威,淫亵,淫样,淫液,淫照,阴b,应召,幼交,幼男,幼女,欲火,欲女,玉女心经,玉蒲团,玉乳,欲仙欲死,玉穴,援交,原味内衣,援助交际,张筱雨,招鸡,招妓,中年美妇,抓胸,自拍,自慰,作爱,18禁,99bb,a4u,a4y,adult,amateur,anal,a片,fuck,gay片,g点,g片,hardcore,h动画,h动漫,incest,porn,secom,sexinsex,sm女王,xiao77,xing伴侣,tokyohot,yin荡,,KC短信,KC嘉年华,短信,短信:广告,短信广告,短信平台,短信群发,小灵通,短信群发器,小6灵通,短信商务广告,段录定,无界浏览,无界浏览器,无界,无网界,无网界浏览,无帮国,KC提示,KC网站,电信,UP8新势力,动5感地带,白皮书,UP新势力,移3动,移动,移动公司,移动集团,移民,易达网络卡,安魂网,罢工,罢课,铃声下载,纽崔莱七折,手机复制,手机铃声,手机铃声下载,手机游戏,神7州行,网关,神通加持法,全1球通,如6意通,清仓,灵动卡,超市,答案卫星接收机,打折机票,高薪养廉,考后付款,佳静安定片,号,航班,航空,航空母舰,航空售票,航天,号码百事通,考前发放,成本价,诚信通手机商城,大2众卡,辅导,高利贷,联 通 贵宾 卡,联4通,黑庄,黑马,黑手党,黑车,联通,联通贵宾卡,联通商务通,联总,联总这声传单,联总之声传单,高息贷款,高干子弟,恭喜你的号码,恭喜您的号码,高干子女,各个银行全称,各种发票,高官,高官互调,高官子女,辅导班,复式,喝一送一,卡号,复制,监听王,传:单,传单,旦科,钓鱼岛,钓鱼台,当官靠后台,党校安插亲信,传九促三,客户端非法字符,刻章,大麻树脂,大麻油,,陈宝生,程凯,程铁军,程真,陈炳德,陈炳基,陈车,陈川平,陈存根,戴秉国,戴海静,戴相龙,陈德铭,陈国令,董贵山,董万才,懂文华,陈冀平,冯东海,冯敏刚,冯寿淼,冯素英,陈际瓦,陈建国,陈军,陈奎元,陈雷,傅成玉,傅申奇,傅志寰,傅怡彬,贾安,贾庆林,贾廷安,贾育台,贾治邦,希拉克,希特勒,傅雯娟,符贵,符强,符跃兰,陈良宇,陈蒙,陈敏尔,陈破空,陈润儿,陈水扁,陈文清,邓楠,迪里夏提,陈希,颜射,阎明复,焉荣竹,严家其,严家祺,陈希同,陈小同,陈新权,陈宣良,陈训秋,陈一谘,丁关根,丁元,丁子霖,陈元,陈政高,陈至,李 洪 志,李安东,李斌,李长才,李长春,李长江,李成玉,李崇禧,李从军,李大师,李登辉,李法泉,李刚,李海峰,李汉柏,李鸿忠,李洪峰,李洪宽,李洪志,李宏志,李宏治,李红痔,李继耐,李纪恒,李建国,于大海,于浩成,于起龙,于幼军,李金城,李金章,李景田,李康,李克,李克强,李兰菊,李老师,李立国,李禄,徐邦秦,徐斌,徐才厚,徐粉林,徐光春,徐建国,徐敬业,徐匡迪,徐乐江,徐绍史,徐守,徐水良,徐天亮,徐一天,许达哲,许家屯,许其亮,许云昭,肖爱玲,肖钢,肖捷,肖强,肖亚庆,李录,李买富,李鹏,李契克,李荣融,李瑞环,李少民,李盛霖,李世明,李适时,李淑娴,李铁映,李旺阳,李文斌,李熙,李希,李向东,李小朋,李小鹏,李小雪,李学举,李学勇,李延芝,李毅中,李玉赋,李玉妹,李源潮,李月鸟,李月月鸟,余欣荣,余英时,余远辉,俞杰,俞正声,李兆焯,李志绥,李总理,李总统,李幛喆,李岚清,列宁,列确,林保华,林彪,林长盛,林军,廖锡龙,林明月,林慎立,廖晖,林树森,林业局,林幼芳,凌锋,林左鸣,林樵清,令狐安,刘宾深,刘宾雁,刘成军,刘春良,刘冬冬,刘刚,刘国凯,刘华清,刘慧,刘家义,刘建华,刘京,刘俊国,刘凯中,刘明康,刘鹏,刘奇葆,刘千石,刘青,刘山青,刘石泉,刘士贤,刘士贤司马晋,刘伟,刘伟平,刘文胜,刘文瑜,刘晓波,刘晓江,刘晓凯,刘晓竹,刘晓榕,刘学普,刘亚洲,刘延东,刘永川,刘永治,刘玉浦,刘玉亭,刘源,刘粤军,刘云山,刘振来,刘振起,刘振亚,刘志军,刘淇,陈至立,陈子明,陈总统,陈左宁,邓昌友,邓可人,邓天生,邓笑贫,阿拉法特,蔡崇国,蔡继华,蔡挺,蔡武,蔡振华,艾斯海提·克里木拜,安立敏,巴赫,巴特尔,巴音,朝鲁,白志健,白春礼,范长龙,范印华,万晓东,汪梦飞,汪洋,汪岷,王宝森,王炳章,王策,王超华,王传平,王丹,王东明,王辅臣,王刚,王冠中,王光亚,王国生,王涵万,周强,周生贤,周天法,周旋,周英,周永康,朱保成,朱成虎,朱丹,朱德,朱嘉明,朱金基,朱琳,朱明国,朱溶剂,朱容基,朱维群,朱之鑫,朱总理,朱镕基,王和民,王鸿举,王洪章,王沪,王沪宁,王华庆,王华元,王家瑞,王建军,王建平,王金山,王进东,王军涛,王俊莲,王乐泉,王莉莉,王立英,王力雄,王明方,王荣,王儒林,王瑞林,王润生,王若望,王三运,王胜俊,王寿祥,王太华,王通智,王万宾,王为璐,王维民,王伟,王伟光,王希哲,王喜斌,王侠,王宪魁,王晓初,王新宪,王秀丽,王旭东,王学军,王冶坪,王毅,王勇,王玉普,王兆国,王正福,王正伟,王志刚,王忠民,王岐山,方励之,方舟子,曹长青,郭伯雄,郭庚茂,章虹,章沁生,张宝顺,张博涵,张伯笠,张成寅,张春贤,张德江,张钢,张高丽,张耕,张国清,张海阳,张宏堡,张惠新,张基,张纪南,张健,张建平,张杰,张军,张开双腿,张连珍,张林,张平,张庆黎,张庆伟,张汝成,张仕波,张铁健,张万年,张伟国,张文岳,张先玲,吴爱,吴百益,吴邦国,吴定富,吴方城,吴官正,吴宏达,吴弘达,吴仁华,吴胜利,吴双战,吴新雄,吴学灿,吴学璨,吴仪,吴玉良,吴镇南,吴毓萍,武吉海,吾尔开希,张晓刚,张晓平,张小平,张轩,张研农,张阳,张裔炯,张毅,张又侠,张玉台,张云川,张昭富,张志清,张中伟,张左己,张岱梨,何德普,何峰,何家栋,何平,何清涟,何勇,郭金龙,黄局,黄康生 ,晴宜 ,黄菊,黄树贤,黄献中,黄翔,黄兴国,黄作兴,黄慈萍,黄殿中,魏凤和,魏家福,魏京生,魏礼群,魏新生,尉健行,袁纯清,袁贵仁,袁家军,袁荣祥,卫留成,卫生部,温家宝,赵爱明,赵海青,赵洪祝,赵克石,赵乐际,赵南,赵品潞,赵铁锤,赵宪庚,赵晓微,郑义,郑源,郑中,温加饱,温元凯,温云松,邢元敏,邢铮,黄华华,黄祸,黄建国,黄晶,郭罗基,郭平,郭声琨,郭树清,郭岩华,郭炎炎,郭永平,曹刚川,杨崇汇,杨传升,杨传堂,杨刚,杨怀安,杨焕宁,杨建利,杨建亭,杨洁篪,杨晶,杨利民,杨利伟,杨士秋,杨松,杨巍,杨衍银,杨元元,杨月清,杨周,姚月谦,姚增科,耶和华,叶冬松,叶剑英,叶青纯,曹建明,曹康泰,曹清,白恩培,薄熙来,白景富,白军,白立忱,白立朴,白梦,鲍戈,鲍彤,杜导斌,谢长廷,谢和平,谢小庆,谢旭人,谢选骏,谢中之,辛灏年,杜恒岩,杜鹃,费良勇,杜青林,杜学芳,杜宇新,杜智富,贝领,本.拉登,不来提不都热西提,柴玲,梁保华,柳斌杰,楼继伟,邱学强,齐墨,仁吉旺姆,仁青加,卢越刚,马大维,莫伟强,申维辰,任亚平,蔣彥永,舒晓琴,盛华仁,努尔白克力,彭枫,彭清华,欧泽高,宋xx,司马晋,司马义·铁力瓦尔地,水扁,史莲喜,石宗源,石大华,司马璐,司徒华,宋爱荣,宋楚瑜,宋平,宋平一句话,宋书元,宋秀岩,宋育英,宋祖英,苏家屯,苏荣,苏绍智,田成平,田力普,田修思,童世平,童屹,童增,铁凝,苏士亮,苏树林,苏晓康,孙宝树,孙春兰,孙大发,孙建国,孙金龙,孙思敬,孙晓群,孙政才,孙忠同,汤光中,汤涛,唐柏桥,唐家璇,唐捷,陶驷驹,潘国平,钦本立,普京,尚福林,尚勇,邵家健,穆斯林,秦光荣,乔石,秦晋,秦银河,邵明立,邵琪伟,沈德咏,沈浩波,沈素琍,沈彤,沈跃跃,潘云鹤,孟建柱,孟令伟,孟学农,聂卫国,祁建,钱达,钱国梁,钱其琛,钱运录,马会,马凯,马克思,罗保铭,罗干,毛一鲜,毛泽东,毛泽东123,毛泽东2,毛贼东,梅克保,罗礼诗,罗清泉,罗正富,罗志军,骆惠宁,骆琳,马良骏,马强,马三家,马时敏,马晓天,马英九,马志鹏,马飚,马馼,卢展工,路甬祥,鹿心社,陆兵,陆浩,陆委会,吕京花,吕秀莲,吕祖善,梁光烈,梁擎墩,常万全,克林顿,雷春美,东突厥斯坦伊斯兰,迟浩田,克劳塞维茨,迟万春,仇保兴,康日新,康涛杰,黎安友,黎阳平,拉丹,拉登,拉姆斯菲尔德,高瞻,葛振峰,金道铭,金日成,金书波,金尧如,金振吉,华过锋,胡春华,胡绩伟,胡江,胡平,华惠棋,华建敏,华莱士,金正日,金壮龙,靖志远,高自联,高莺莺,高强,高文谦,焦国标,焦焕成,蒋峰,蒋洁敏,蒋经国,蒋文兰,蒋彦永,高武生,付申奇,连胜德,贺邦靖,关卓中,贺国强,干以胜,简鸿章,回良玉,江罗,冠希,江绵恒,江棋生,江青,恩格斯,,常劲,本田,鲍筒,拨打,伴游,QQ宠物,本公司2,世纪中国基金会,610洗脑班,帮穷人,2004年公共服务奖,2006年十句最真实的谎言,001工程,分家在,大红赤龙七头十角,第一批下海经商的人富,俄罗斯,周年庆,苗圩,明斯克号,清纯,穷 人,穷人,屈万祥,善恶有报,汕尾,生态区,生肖,盛雪,盛雪辛灏年,师傅,师父,石戈,食捻屎,使馆,驶你老母,驶你母,试卷,试题答案,圣战,权柄,全哲洙,瘸腿帮,群体灭绝,燃烧辅助工具,热比娅,热线,忍,忍无可忍,明心,水去车仑,斯诺,四级答案,四联航空,透视镜,透视眼镜,万能钥匙,万润南,网管,网上赚钱,网特,网通,网赚队伍,往事并不如烟,威而柔,威海,素人,宿命论,隧道,檀鑫,名山县,体健貌端,天鹅之旅,名师,慕歌,木犀地,穆罕默德,倪育贤,年福纯,捻,潜在用户,抢粮记,龙虎豹,瞒报,毛片,绿色环保手机,绿色雨,龙虎豹宋书元,龙卷风,领取,长期,城堡,担保,吹喇叭,歌,歌德,歌功颂德,高丽棒子,蛤蟆,个人崇拜,看中国,凯旋,口蹄疫,来京上访,蓝光,蓝丝带,举行,均价,靖国神社,警察,静坐,揭批书,接班,结欠,结帐,戒严,刀林荫,登辉,登天梯,翟渠,翟小衡,点金,东突,东突厥斯坦,东土耳其斯坦,吨,多维,二码,二乙基酰胺,二注,发~票,发财诗,发改委,分众,封从德,疯狂掠夺大陆股民,凤凰,佛展千手法,戈扬,鸽派,工力,工自联,共黨,古怪歌,管理员,哈批,114,1258,1259,12590,12593,1 0 1 5 9,10000,10010,10086,10159,13423205670,13725516608,13875448369,15112886328,189,6-4tianwang,64,68170802,6a6.net,7.31,7.310,89-64cdjp,8945212,23条,259o,381929279,3P,4-Jun,AV,BJ,CBD,CCTV,CDMA,DICK,Dick,FLG,FOCUSC,FUCK,Fuck,GAMEMASTER,GCD,GameMaster,IP17908,KEY_TEXT,NMD,QQb,SM,Soccer01.com,TMD,UltraSurf,bignews,Bitch,boxun,Chinaliberal,chinamz,Chinesenewsnet,cnd,Creaders,dafa,Dajiyuan,df'd,Dfdz,die,dpp,Freechina,freedom,Freenet,fuck,fuck your mother,hongzhi,hrichina,huanet,hypermart.net,incest,jiangdongriji,l2590803027,lihongzhi,ma,making,minghui,minghuinews,nacb,na?ve,nmis,paper64,peacehall,piao,playboy,renminbao,renmingbao,rfa,safeweb,sex,shit,simple,svdc,taip,tibetalk,triangle,triangleboy,txwq.net,unixbox,ustibet,voa,voachinese,wangce,wstaiji,www,xinsheng,yuming,yy通讯录,zhengjian,zhengjianwang,zhenshanren,zhuanfalu,zhuanfalun,八九,八老,";
		String a[]=temp.split(",");
		for (int i = 0; i < a.length; i++) {
			this.getStoryService().insert(a[i]);
		}
		
		
		return "";
	}
	
	
	
	
	public String checkfaillist() {
		DetachedCriteria criteria1=DetachedCriteria.forClass(Story.class);
		criteria1.createAlias("publishStatus", "publishStatus");
		criteria1.add(Restrictions.eq("publishStatus.noPass",1));
		criteria1.add(Restrictions.eq("publishStatus.adminDelete",0));
		super.pager=this.getStoryService().findbyDetachedCriteria(criteria1, pageNo,5);
		return "checkfaillist";
	}
	
	/**
	 * 全部不通过
	 * @return
	 */
	public String admincheckallfail() {
		String ids=operateIds;
		String []temp=ids.split(",");
		for (int i = 0; i < temp.length; i++) {
			this.getStoryService().allnopass(Integer.valueOf(temp[i]));
		}
		return "admincheckallfail";
	}
	/**
	 * 全部通过
	 * @return
	 */
	public String admincheckallsuc() {
		String ids=operateIds;
		String []temp=ids.split(",");
		for (int i = 0; i < temp.length; i++) {
			this.getStoryService().adminchecksuc(Integer.valueOf(temp[i]));
		}
		
		return "admincheckallsuc";
	}
	
    ///////////////////////管理员审核///////////////////////////////
	public InputStream getInputStream() throws Exception{
		/*下载原图*/
		story=this.getStoryService().select(storyId);
		List<StoryDetail> storyDetails=this.getStoryService().findDetailsById(storyId);
		String tag="cut285175";
		String cut285175=story.getCover().substring(story.getCover().indexOf(tag)+1+tag.length(),story.getCover().length());
		String currentAbsoulutePath=Thread.currentThread().getContextClassLoader().getResource("").getPath();
        PropertiesRead readPro = new PropertiesRead(currentAbsoulutePath+"picpath.properties");//相对路径
        String cut = readPro.getValue(tag)+"/"+cut285175;
        String downdir=readPro.getValue("downloaddir");
        String downzip=readPro.getValue("downzip");
		File file=new File(cut);
		File file2=new File(downdir+"/"+"download");
		if (!file2.exists()) {
			file2.mkdir();
		}
		File targetFile=new File(file2.getAbsoluteFile()+"/"+file.getName());
		UploadUtils  uploadUtils=new UploadUtils();
		uploadUtils.copyFile(file,targetFile);
		for (int i = 0; i < storyDetails.size(); i++) {
			Publish publish=this.getStoryService().selectPublish(storyDetails.get(i).getPublishId());
			String originalpic=publish.getOriginalPic();
			File tempFile=new File(originalpic);
			File targetFile2=new File(file2.getAbsoluteFile()+"/"+tempFile.getName());
			uploadUtils.copyFile(tempFile,targetFile2);
		}
		String targetDirectory = ServletActionContext.getRequest().getRealPath("/back/personalCentr/myworklib/storydownload.html");
		this.getStoryService().createstatic(storyId);
		new HtmlToDoc().writeWordFile(targetDirectory,file2.getAbsolutePath(),currenttime());//,file2.getAbsolutePath(),currenttime()
		downFileName=currenttime()+".zip";
		File file3=new File(downzip+downFileName);
		zipcompression myzip=new zipcompression();
		myzip.zip(file2.getAbsolutePath(),file3.getPath());
		return new FileInputStream(file3.getAbsolutePath());
	}
	public String currenttime() {
		SimpleDateFormat df=new SimpleDateFormat("yyyyMMddHHmmSSS");
    	return df.format(new Date());	
	}
	public String downloadstory() throws Exception {
		String currentAbsoulutePath=Thread.currentThread().getContextClassLoader().getResource("").getPath();
		PropertiesRead readPro = new PropertiesRead(currentAbsoulutePath+"picpath.properties");//相对路径
		String downdir=readPro.getValue("downloaddir");
		File file2=new File(downdir+"/"+"download");
		new UploadUtils().deleteFile(file2);
		int id=super.getLonginUserId();
		if(id==0){
			return "login";
		}
		return "downloadstory";
	}
	
	public Object getModel() {
		if (story == null) {
			story = new Story();
		}
		return story;
	}
	/**
	 * 获得摄影故事列表
	 * @return
	 */
	public String storylist() {
		/**
		 * private int unreleased;//未发布 0未发布1已发布
    private int awaitingReview;//1审核中0初始状态
    private int noPass;//0初始状态 1是不通过
    private int pass;// 0 初始状态 1 审核通过
    private int justShow;//0初始化状态1仅展示
    private int onOffer;//0是初始化状态1是销售中
    private int copyrightBuyout;//0初始化状态 1版权被买断
    private int userSoldout;//0初始化状态 1用户自己下架
    private int adminSoldout;//0 1,管理员给作品下架
    private int publishToStroy;//0 1发布到摄影故事
    private int userDelete;//0初始状态 1用户自己删除
    private int adminDelete;//0初始化状态1 管理员删除
    private int publishorstory;//0 初始化状态publish 1 story
		 */
		int id=super.getLonginUserId();
		publishCats=this.getStoryService().publishCats();
		specialCats=this.getStoryService().specialCats(id);
		super.pager = this.getStoryService().storylist(id,16,pageNo);
		toolStory=pager.getRowCount();
		DetachedCriteria criteria1=DetachedCriteria.forClass(Story.class);
		criteria1.createAlias("publishStatus", "publishStatus");
		criteria1.add(Restrictions.or(Restrictions.ne("publishStatus.pass",0), Restrictions.ne("publishStatus.onOffer",0)));
		criteria1.add(Restrictions.eq("publishStatus.userSoldout", 0));
		criteria1.add(Restrictions.eq("publishStatus.adminSoldout", 0));
		criteria1.add(Restrictions.or(Restrictions.ne("publishStatus.userDelete",1), Restrictions.ne("publishStatus.adminDelete",1)));
		String fabutotal=storyService.findbyCountBySpecialCat(criteria1);
		publishedStory=Integer.valueOf(fabutotal);
		return "storylist";
	}
	@JSON(serialize=false)
	 public String findstorybyCountBySpecialCat(){
		   int id=super.getLonginUserId();
		   if(id==0){
			   return "findstorybyCountBySpecialCat";  
			   
		   }
		   DetachedCriteria criteria=DetachedCriteria.forClass(Story.class);
		   criteria.createAlias("publishSpecialCat", "publishSpecialCat");
		   if (publishSpecialCatId != 0) {
			   criteria.add(Restrictions.eq("publishSpecialCat.id", publishSpecialCatId));
		   }		   
		   String total=storyService.findbyCountBySpecialCat(criteria);
		   
		   
		   DetachedCriteria criteria1=DetachedCriteria.forClass(Story.class);
		   criteria1.createAlias("publishSpecialCat", "publishSpecialCat");
		   criteria1.createAlias("publishStatus", "publishStatus");
		   if (publishSpecialCatId != 0) {
			   criteria.add(Restrictions.eq("publishSpecialCat.id", publishSpecialCatId));
		   }
		   if (storystatu == 0) {
			   criteria1.add(Restrictions.ne("publishStatus.onOffer", 0));
			   criteria1.add(Restrictions.ne("publishStatus.pass", 0));
			   criteria1.add(Restrictions.ne("publishStatus.userSoldout", 1));
			   criteria1.add(Restrictions.ne("publishStatus.adminSoldout", 1));
			   criteria1.add(Restrictions.ne("publishStatus.copyrightBuyout", 1));
//		       criteria1.add(Restrictions.or(Restrictions.ne("publishStatus.unreleased", 1), Restrictions.or(Restrictions.ne("publishStatus.pass", 0),
//		    		   Restrictions.or(Restrictions.ne("publishStatus.onOffer", 0), Restrictions.or(Restrictions.ne("publishStatus.copyrightBuyout", 1),
//		    		   Restrictions.or(Restrictions.ne("publishStatus.userSoldout", 1),Restrictions.or(Restrictions.ne("publishStatus.adminSoldout", 1), Restrictions.eq("publishStatus.awaitingReview", 1))))))));
		   }else if (storystatu == 1) {
			   /**
			    * private int id;
	private int unreleased;//未发布 0未发布1已发布
    private int awaitingReview;//1审核中0初始状态
    private int noPass;//0初始状态 1是不通过
    private int pass;// 0 初始状态 1 审核通过
    private int justShow;//0初始化状态1仅展示
    private int onOffer;//0是初始化状态1是销售中
    private int copyrightBuyout;//0初始化状态 1版权被买断
    private int userSoldout;//0初始化状态 1用户自己下架
    private int adminSoldout;//0 1,管理员给作品下架
    private int publishToStroy;//0 1发布到摄影故事
    private int userDelete;//0初始状态 1用户自己删除
    private int adminDelete;//0初始化状态1 管理员删除
    private int publishorstory;//0 初始化状态publish 1 story
			    */
			   /**criteria1.add(Restrictions.eq("publishStatus.unreleased", 1));
			   criteria1.add(Restrictions.eq("publishStatus.awaitingReview",1));
			   criteria1.add(Restrictions.eq("publishStatus.noPass",0));*/
			   criteria1.add(Restrictions.eq("publishStatus.pass",1));
		   }else if (storystatu == 2) {
			   criteria1.add(Restrictions.eq("publishStatus.pass",1));
		   }else if (storystatu == 3) {
			   criteria1.add(Restrictions.or(Restrictions.ne("publishStatus.copyrightBuyout", 0), Restrictions.or(Restrictions.ne("publishStatus.userSoldout", 0),Restrictions.ne("publishStatus.adminSoldout", 0))));
		   }
		   String fabutotal=storyService.findbyCountBySpecialCat(criteria1);
		   count=new String[]{total,fabutotal};
		   return "findstorybyCountBySpecialCat";
	   }
	/**
	 * 摄影故事封面裁剪效果
	 * @return
	 * @throws Exception
	 */
	@JSON(serialize=false)
	public String cutcover() throws Exception {
		List tempList=new ArrayList();
		tempList=this.getStoryService().cutcover(publishId,x1,x2,y1,y2);
		msg=tempList.get(0).toString();
		publishId=Integer.valueOf(tempList.get(1).toString());
		return "cutcover";
	}
	/**
	 * 上传摄影故事封面
	 * @return
	 */
	@JSON(serialize=false)
	public String uploadimg() {
//		msg=publish.gett;
			int uId=Integer.parseInt(ActionContext.getContext().getSession().get("id").toString());
			List tempList=null;
			
			BufferedImage bufferedImage = null;
			try {
				bufferedImage = ImageIO.read(mycover);
				String coverpath=mycover.getAbsolutePath();
				String covertype=mycoverFileName.substring(mycoverFileName.lastIndexOf(".")+1);
				if (covertype.equalsIgnoreCase("jpg") || covertype.equalsIgnoreCase("tif") || covertype.equalsIgnoreCase("tiff")) {
					if (bufferedImage.getWidth() >=2000 || bufferedImage.getHeight() >=2000) {
						tempList=this.getStoryService().uploadimg(uId, mycover, mycoverFileName,mycoverContentType);
						flag=1;//成功
						publishId=Integer.valueOf(tempList.get(0).toString());
						Publish publish=this.getStoryService().selectPublish(publishId);
						msg=publish.getSmallDrawCut();
					}else {
						flag=0;//图片太小
						publishId=0;
						msg="fail";
					}
				}else {
					flag=2;// 图片格式不对
					publishId=0;
					msg="fail";
				}
				}catch (Exception e) {
					e.printStackTrace();
				}
		return "uploadimg";
	}
	
	/**
	 * 保存摄影故事初始化数据
	 * @return
	 */
	public String initdata() {
		int id=super.getLonginUserId();
		   if(id==0){
			   return "findstorybyCountBySpecialCat";  
			   
		   }
		publishCats=this.getStoryService().publishCats();
		specialCats=this.getStoryService().specialCats(id);
		return "initdata";
	}
	/**
	 * 准备发布 保存摄影故事
	 * @return
	 * @throws Exception
	 */
	public String savestory() throws Exception {
		////flag 为1 发布摄影故事           0 保存摄影故事
		int uId=Integer.parseInt(ActionContext.getContext().getSession().get("id").toString());
		int coverId=Integer.valueOf(ServletActionContext.getRequest().getParameter("coverId"));
		String mytags[]=ServletActionContext.getRequest().getParameterValues("mytags");
		String specialId=ServletActionContext.getRequest().getParameter("special");
		String publishCats[]=ServletActionContext.getRequest().getParameterValues("temppublishcat");//摄影故事类别
		String publishIds[]=ServletActionContext.getRequest().getParameterValues("temppublish");//作品库
		String storycxts[]=ServletActionContext.getRequest().getParameterValues("storycxt");//故事详细内容
		if (flag==0) {
			int res=this.getStoryService().savestory(story,uId,coverId, mytags, specialId, publishCats, publishIds, storycxts);	
			return "insertsuc";
		}else if (flag==1) {
			storyId=this.getStoryService().savestory(story,uId,coverId, mytags, specialId, publishCats, publishIds, storycxts);
			return "startpubish";
		} 
		return null;
		
	}
	
	
	/**
	 * 编辑摄影故事
	 * @return
	 */
	public String editstory() {
		int mystoryid=storyId;
		int uId=Integer.parseInt(ActionContext.getContext().getSession().get("id").toString());
		int coverId=Integer.valueOf(ServletActionContext.getRequest().getParameter("coverId"));
		String mytags[]=ServletActionContext.getRequest().getParameterValues("mytags");
		String specialId=ServletActionContext.getRequest().getParameter("special");
		String publishCats[]=ServletActionContext.getRequest().getParameterValues("temppublishcat");//摄影故事类别
		String publishIds[]=ServletActionContext.getRequest().getParameterValues("temppublish");//作品库
		String storycxts[]=ServletActionContext.getRequest().getParameterValues("storycxt");//故事详细内容
		//flag 0 修改未发布的摄影故事成功    1 将未发布的摄影故事发布
		if (flag==0) {
			int res=this.getStoryService().editunpublishedstory(storyId,story,uId,coverId, mytags, specialId, publishCats, publishIds, storycxts);
			return "editsuc";
		}else if (flag==1) {
			storyId=this.getStoryService().editunpublishedstory(storyId,story,uId,coverId, mytags, specialId, publishCats, publishIds, storycxts);
			return "startpubish";
		} 
		return "";
	}
	/**
	 * 开始发布摄影故事
	 * @return
	 */
	public String startpublish2() {
		int id=super.getLonginUserId();
		   if(id==0){
			   return "findstorybyCountBySpecialCat";  
			   
		   }
		publishCats=this.getStoryService().publishCats();
		specialCats=this.getStoryService().specialCats(id);
		story=this.getStoryService().select(storyId);
		storyDetails=this.getStoryService().findDetailsById(storyId);
		publishCatStories=this.getStoryService().findStoryCat(storyId);
		specialCat=story.getPublishSpecialCat();
		picNum=this.getStoryService().picNumber(storyId);
		textNum=this.getStoryService().textNumber(storyId);
		storytags=new ArrayList();
		String []a=story.getTags().split(" ");
		for (int i = 0; i < a.length; i++) {
			storytags.add(a[i]);
		}
		
		
		
		return "startpublish2";
	}	
	
	/**
	 * 查看摄影故事详情
	 * @return
	 */
	public String searchStoryunpublish(){
		int id=Integer.parseInt(ServletActionContext.getRequest().getParameter("id"));
		story=this.getStoryService().findbyStory(id);
		storyDetails=this.getStoryService().findDetailsById(id);
		publishCatStories=this.getStoryService().findStoryCat(id);
		specialCat=story.getPublishSpecialCat();
		int uId=Integer.parseInt(ActionContext.getContext().getSession().get("id").toString());
		super.pager=this.getStoryService().findStoryByUserAndSpecial(uId,specialCat.getId(),1,pageNo);
		toolStory=pager.getRowCount();
		DetachedCriteria criteria1=DetachedCriteria.forClass(Story.class);
		criteria1.createAlias("publishStatus", "publishStatus");
		criteria1.add(Restrictions.or(Restrictions.ne("publishStatus.pass",0), Restrictions.ne("publishStatus.onOffer",0)));
		String fabutotal=storyService.findbyCountBySpecialCat(criteria1);
		publishedStory=Integer.valueOf(fabutotal);
		return "searchStoryunpublish";
	}
	
	@JSON(serialize=false)
	public String storyprenext() {
		int uId=Integer.parseInt(ActionContext.getContext().getSession().get("id").toString());
		
		stories=this.getStoryService().storybyuserandspecial(uId,specialId);
		return "storyprenext";
	}
	@JSON(serialize=false)
	public String storychecksucprenext() {
		stories=this.getStoryService().storychecksucbyspecial(specialId);
		return "storychecksucprenext";
	}
	
	@JSON(serialize=false)
	public String storyadminsoldoutprenext() {
		stories=this.getStoryService().storyadminsoldoutbyspecial(specialId);
		return "storychecksucprenext";
	}
	
	/**
	 * 查看已发布的摄影故事详情
	 * @return
	 */
	public String searchStorypublish(){
		
		/**
		 * private int unreleased;//未发布 0未发布1已发布
    private int awaitingReview;//1审核中0初始状态
    private int noPass;//0初始状态 1是不通过
    private int pass;// 0 初始状态 1 审核通过
    private int justShow;//0初始化状态1仅展示
    private int onOffer;//0是初始化状态1是销售中
    private int copyrightBuyout;//0初始化状态 1版权被买断
    private int userSoldout;//0初始化状态 1用户自己下架
    private int adminSoldout;//0 1,管理员给作品下架
    private int publishToStroy;//0 1发布到摄影故事
    private int userDelete;//0初始状态 1用户自己删除
    private int adminDelete;//0初始化状态1 管理员删除
    private int publishorstory;//0 初始化状态publish 1 story
		 */
		int id=Integer.parseInt(ServletActionContext.getRequest().getParameter("id"));
		story=this.getStoryService().findbyStory(id);
		storyDetails=this.getStoryService().findDetailsById(id);
		publishCatStories=this.getStoryService().findStoryCat(id);
		specialCat=story.getPublishSpecialCat();
		int uId=Integer.parseInt(ActionContext.getContext().getSession().get("id").toString());
		super.pager=this.getStoryService().findStoryByUserAndSpecial(uId,specialCat.getId(),1,pageNo);
		toolStory=pager.getRowCount();
		DetachedCriteria criteria1=DetachedCriteria.forClass(Story.class);
		criteria1.createAlias("publishStatus", "publishStatus");
		criteria1.add(Restrictions.or(Restrictions.ne("publishStatus.pass",0), Restrictions.ne("publishStatus.onOffer",0)));
		criteria1.add(Restrictions.eq("publishStatus.adminSoldout", 0));
		criteria1.add(Restrictions.eq("publishStatus.userSoldout", 0));
		String fabutotal=storyService.findbyCountBySpecialCat(criteria1);
		publishedStory=Integer.valueOf(fabutotal);
//		int id=Integer.parseInt(ServletActionContext.getRequest().getParameter("id"));
//		story=this.getStoryService().findbyStory(id);
//		storyDetails=this.getStoryService().findDetailsById(id);
//		picNum=this.getStoryService().picNumber(id);
//		textNum=this.getStoryService().textNumber(id);
//		publishCatStories=this.getStoryService().findStoryCat(id);
		return "searchStorypublish";
	}
	/**
	 * 编辑未发布的摄影故事
	 * @return
	 */
	public String editunpublishedstory() {
		int id=super.getLonginUserId();
		   if(id==0){
			   return "findstorybyCountBySpecialCat";  
			   
		   }
		publishCats=this.getStoryService().publishCats();
		specialCats=this.getStoryService().specialCats(id);
		story=this.getStoryService().select(storyId);
		storyDetails=this.getStoryService().findDetailsById(storyId);
		publishCatStories=this.getStoryService().findStoryCat(storyId);
		specialCat=story.getPublishSpecialCat();
		storytags=new ArrayList();
		String []a=story.getTags().split(" ");
		for (int i = 0; i < a.length; i++) {
			storytags.add(a[i]);
		}
		return "editunpublishedstory";
	}
	
	public String editpublishedstory() {
		int id=super.getLonginUserId();
		   if(id==0){
			   return "findstorybyCountBySpecialCat";  
			   
		   }
		publishCats=this.getStoryService().publishCats();
		specialCats=this.getStoryService().specialCats(id);
		story=this.getStoryService().select(storyId);
		storyDetails=this.getStoryService().findDetailsById(storyId);
		publishCatStories=this.getStoryService().findStoryCat(storyId);
		specialCat=story.getPublishSpecialCat();
//		picNum=this.getStoryService().picNumber(storyId);
//		textNum=this.getStoryService().textNumber(storyId);
		storytags=new ArrayList();
		String []a=story.getTags().split(" ");
		for (int i = 0; i < a.length; i++) {
			storytags.add(a[i]);
		}
		return "editpublishedstory";
	}
	
	public String userdelstory() {
		this.getStoryService().userdeloperate(storyId);
//		this.getStoryService().delcatstory(storyId);
//		this.getStoryService().delete(storyId);
		return "userdelstory";
	}
	
	public String admindelstory() {
		this.getStoryService().admindeloperate(storyId);
		return "admindelstory";
	}
	
	public String admindelstoryofnopass() {
		this.getStoryService().admindeloperate(storyId);
		return "admindelstoryofnopass";
	}
	public String admindelstoryofsoldout() {
		this.getStoryService().admindeloperate(storyId);
		return "admindelstoryofsoldout";
	}
	
//	/**
//	 * 删除摄影故事(彻底删除)
//	 * @return
//	 */
//	public String delstory() {
//		this.getStoryService().delstorydetailofstory(storyId);
//		this.getStoryService().delcatstory(storyId);
//		this.getStoryService().delete(storyId);
//		return "delstory";
//	}
	/**
	 * 已发布的摄影故事下架
	 * @return
	 */
	public String offsale() {
		this.getStoryService().storyoffsale(storyId);
		return "offsale";
	}
	private List mylist;
	public String changeSpecialPic(){
		mylist=new LinkedList();
		 int id=super.getLonginUserId();
		 if(id==0){
			 resMsg="login";
			 
			 return "changeSpecialPic";
			 
		 }
		 try{
			 Story story=storyService.select(storyId);
			 PublishSpecialCat specialCat=this.getStoryService().selectSpecialCat(publishSpecialCatId);
		 story.setPublishSpecialCat(specialCat);
		 storyService.update(story);
		 resMsg="suc";
		 mylist.add(resMsg);
		 mylist.add(specialCat.getName());
		 }catch (Exception e) {
			 resMsg="error";
			e.printStackTrace();
		}
		 
		 return "changeSpecialPic";
	 }
	
	
	public String releasenewstory() {
		int uId=Integer.parseInt(ActionContext.getContext().getSession().get("id").toString());
		int coverId=Integer.valueOf(ServletActionContext.getRequest().getParameter("coverId"));
		String mytags[]=ServletActionContext.getRequest().getParameterValues("mytags");
		String specialId=ServletActionContext.getRequest().getParameter("special");
		String publishCats[]=ServletActionContext.getRequest().getParameterValues("temppublishcat");//摄影故事类别
		String publishIds[]=ServletActionContext.getRequest().getParameterValues("temppublish");//作品库
		String storycxts[]=ServletActionContext.getRequest().getParameterValues("storycxt");//故事详细内容
		storyId=this.getStoryService().releasenewstory(story,uId,coverId, mytags, specialId, publishCats, publishIds, storycxts);
		return "releasenewstory";
	}
	public String preparepublishstory() {
		int mystoryid=storyId;
		int uId=Integer.parseInt(ActionContext.getContext().getSession().get("id").toString());
		int coverId=Integer.valueOf(ServletActionContext.getRequest().getParameter("coverId"));
		String mytags[]=ServletActionContext.getRequest().getParameterValues("mytags");
		String specialId=ServletActionContext.getRequest().getParameter("special");
		String publishCats[]=ServletActionContext.getRequest().getParameterValues("temppublishcat");//摄影故事类别
		String publishIds[]=ServletActionContext.getRequest().getParameterValues("temppublish");//作品库
		String storycxts[]=ServletActionContext.getRequest().getParameterValues("storycxt");//故事详细内容
		String copyres=story.getCopyrightres();
		if (copyres.contains("0") && (!copyres.contains("1"))) {
			storyId=this.getStoryService().publishstorysucofusecopyright(storyId,story,uId,coverId, mytags, specialId, publishCats, publishIds, storycxts,copyrightuseprice);
		}else if ((!copyres.contains("0")) && copyres.contains("1")) {
			storyId=this.getStoryService().publishstorysucofcopyright(storyId,story,uId,coverId, mytags, specialId, publishCats, publishIds, storycxts,copyrightcopyrightprice);
		}else {
			storyId=this.getStoryService().publishstorysucofboth(storyId,story,uId,coverId, mytags, specialId, publishCats, publishIds, storycxts,copyrightcopyrightprice,copyrightuseprice);
		}
		return "publishstorysuc";
	}
	
	
	
	public String publishstory() {
		return "publishstory";
	}
	
	public StoryService getStoryService() {
		return storyService;
	}
	public void setStoryService(StoryService storyService) {
		this.storyService = storyService;
	}
	public File getMycover() {
		return mycover;
	}

	public void setMycover(File mycover) {
		this.mycover = mycover;
	}

	public String getMycoverFileName() {
		return mycoverFileName;
	}

	public void setMycoverFileName(String mycoverFileName) {
		this.mycoverFileName = mycoverFileName;
	}

	public String getMycoverContentType() {
		return mycoverContentType;
	}

	public void setMycoverContentType(String mycoverContentType) {
		this.mycoverContentType = mycoverContentType;
	}

	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Story getStory() {
		return story;
	}

	public void setStory(Story story) {
		this.story = story;
	}

	public List<PublishCat> getPublishCats() {
		return publishCats;
	}

	public void setPublishCats(List<PublishCat> publishCats) {
		this.publishCats = publishCats;
	}

	public List<PublishSpecialCat> getSpecialCats() {
		return specialCats;
	}

	public void setSpecialCats(List<PublishSpecialCat> specialCats) {
		this.specialCats = specialCats;
	}
	public Integer getPublishId() {
		return publishId;
	}
	public void setPublishId(Integer publishId) {
		this.publishId = publishId;
	}
	public Integer getX1() {
		return x1;
	}
	public void setX1(Integer x1) {
		this.x1 = x1;
	}
	public Integer getY1() {
		return y1;
	}
	public void setY1(Integer y1) {
		this.y1 = y1;
	}
	public Integer getX2() {
		return x2;
	}
	public void setX2(Integer x2) {
		this.x2 = x2;
	}
	public Integer getY2() {
		return y2;
	}
	public void setY2(Integer y2) {
		this.y2 = y2;
	}
	public List<Story> getStories() {
		return stories;
	}
	public void setStories(List<Story> stories) {
		this.stories = stories;
	}
	public Integer getPicNum() {
		return picNum;
	}
	public void setPicNum(Integer picNum) {
		this.picNum = picNum;
	}
	public Integer getTextNum() {
		return textNum;
	}
	public void setTextNum(Integer textNum) {
		this.textNum = textNum;
	}
	public List<StoryDetail> getStoryDetails() {
		return storyDetails;
	}
	public void setStoryDetails(List<StoryDetail> storyDetails) {
		this.storyDetails = storyDetails;
	}
	public PublishSpecialCat getSpecialCat() {
		return specialCat;
	}
	public void setSpecialCat(PublishSpecialCat specialCat) {
		this.specialCat = specialCat;
	}
	public List<PublishCat_Story> getPublishCatStories() {
		return publishCatStories;
	}
	public void setPublishCatStories(List<PublishCat_Story> publishCatStories) {
		this.publishCatStories = publishCatStories;
	}
	
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public Integer getStoryId() {
		return storyId;
	}
	public void setStoryId(Integer storyId) {
		this.storyId = storyId;
	}
	public List getStorytags() {
		return storytags;
	}
	public void setStorytags(List storytags) {
		this.storytags = storytags;
	}
	
	public String getDownFileName() {
		return downFileName;
	}
	public void setDownFileName(String downFileName) {
		this.downFileName = downFileName;
	}
	public String getCopyrightuseprice() {
		return copyrightuseprice;
	}
	public void setCopyrightuseprice(String copyrightuseprice) {
		this.copyrightuseprice = copyrightuseprice;
	}
	public String getCopyrightcopyrightprice() {
		return copyrightcopyrightprice;
	}
	public void setCopyrightcopyrightprice(String copyrightcopyrightprice) {
		this.copyrightcopyrightprice = copyrightcopyrightprice;
	}
	public Integer getTotalRes() {
		return totalRes;
	}
	public void setTotalRes(Integer totalRes) {
		this.totalRes = totalRes;
	}
	public String[] getCount() {
		return count;
	}
	public void setCount(String[] count) {
		this.count = count;
	}
	public int getPublishSpecialCatId() {
		return publishSpecialCatId;
	}
	public void setPublishSpecialCatId(int publishSpecialCatId) {
		this.publishSpecialCatId = publishSpecialCatId;
	}
	public int getStorystatu() {
		return storystatu;
	}
	public void setStorystatu(int storystatu) {
		this.storystatu = storystatu;
	}
	public Integer getToolStory() {
		return toolStory;
	}
	public void setToolStory(Integer toolStory) {
		this.toolStory = toolStory;
	}
	public Integer getPublishedStory() {
		return publishedStory;
	}
	public void setPublishedStory(Integer publishedStory) {
		this.publishedStory = publishedStory;
	}
	public OutputStream getRes() {
		return res;
	}
	public void setRes(OutputStream res) {
		this.res = res;
	}
	public ZipOutputStream getZos() {
		return zos;
	}
	public void setZos(ZipOutputStream zos) {
		this.zos = zos;
	}
	public List<Story> getStroys() {
		return stroys;
	}
	public void setStroys(List<Story> stroys) {
		this.stroys = stroys;
	}
	public Integer getSpecialId() {
		return specialId;
	}
	public void setSpecialId(Integer specialId) {
		this.specialId = specialId;
	}
	public String getOperateIds() {
		return operateIds;
	}

	public void setOperateIds(String operateIds) {
		this.operateIds = operateIds;
	}

	public String getResMsg() {
		return resMsg;
	}

	public void setResMsg(String resMsg) {
		this.resMsg = resMsg;
	}

	public List getMylist() {
		return mylist;
	}

	public void setMylist(List mylist) {
		this.mylist = mylist;
	}

	public static void main(String[] args) throws Exception {
		//new HtmlToDoc().writeWordFile("D:\\Java\\apache-tomcat-6.0.26\\webapps\\wepic\\back\\personalCentr\\myworklib\\storydownload.html");//,file2.getAbsolutePath(),currenttime()
//		String temp[]={"aaa","sssssssss","eee","bbbb","xxxxx"};
//		List a=new ArrayList();
//		for (int i = 0; i < temp.length; i++) {
//			a.add(temp[i]);
//		}
//		String abc="";
//		for (int i = 0; i < a.size(); i++) {
//			abc+=a.get(i)+" ";
//		}
//		System.out.println(abc);
//		String b=a.toString();
//		String s[]=b.split(" ,");
//		System.out.println(s);
//		String myArray[]={"aa","bb","cc","dd","ee","ff","gg","hh","abc"};
//		String pre="";
//		String next="";
//		for(int i=0; i<myArray.length;i++){
//	  	      //alert(i+"**********************");  	  	  
//	  	      if(i==0){
//	  	        pre=myArray[0];
//	  	        next=myArray[i+1];
//	  	        }
//	  	        else{
//	  	  	      if(myArray[i].equals("ee")){
//	  	  	          pre=myArray[i-1];
//	  	  	          next=myArray[i+1];
//	  	  	      }else if((i+1) == (myArray.length-1)){
//	  	  	      pre=myArray[i-1];
//	  	  	          next=myArray[i];
//	  	  	      }
//	  	      }  	  	  
//	  	  }
		
		
	}
}
