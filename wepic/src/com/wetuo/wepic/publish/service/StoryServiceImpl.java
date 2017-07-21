package com.wetuo.wepic.publish.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.util.PropertiesRead;
import com.wetuo.wepic.common.util.UploadUtils;
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.core.service.UserService;
import com.wetuo.wepic.publish.beans.Publish;
import com.wetuo.wepic.publish.beans.PublishCat;
import com.wetuo.wepic.publish.beans.PublishCat_Story;
import com.wetuo.wepic.publish.beans.PublishSpecialCat;
import com.wetuo.wepic.publish.beans.PublishStatus;
import com.wetuo.wepic.publish.beans.Story;
import com.wetuo.wepic.publish.beans.StoryDetail;
import com.wetuo.wepic.publish.beans.StorySystemFilterWords;
import com.wetuo.wepic.publish.dao.StoryDao;
@SuppressWarnings("unchecked")
public class StoryServiceImpl implements StoryService{
	private StoryDao storyDao;
	
	/////////////////////wepic2.0///////////////////
	private UserService userService;
	private PublishService publishService;
	private PublishCat_StorySevice publishCatStorySevice;
	private StoryDetailService storyDetailService;
	private PublishCatService publishCatService;
	private PublishSpecialCatService publishSpecialCatService; 
	private PublishStatusService publishStatusService;
	private StoryFilterWordsService storyFilterWordsService;
	
	public StoryDao getStoryDao() {
		return storyDao;
	}

	public void setStoryDao(StoryDao storyDao) {
		this.storyDao = storyDao;
	}
	///////////////////////////wepic2.0  getter setter//////////////////////////////

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public PublishService getPublishService() {
		return publishService;
	}

	public void setPublishService(PublishService publishService) {
		this.publishService = publishService;
	}

	public PublishCat_StorySevice getPublishCatStorySevice() {
		return publishCatStorySevice;
	}

	public void setPublishCatStorySevice(
			PublishCat_StorySevice publishCatStorySevice) {
		this.publishCatStorySevice = publishCatStorySevice;
	}

	public StoryDetailService getStoryDetailService() {
		return storyDetailService;
	}

	public void setStoryDetailService(StoryDetailService storyDetailService) {
		this.storyDetailService = storyDetailService;
	}

	public PublishCatService getPublishCatService() {
		return publishCatService;
	}

	public void setPublishCatService(PublishCatService publishCatService) {
		this.publishCatService = publishCatService;
	}

	public PublishSpecialCatService getPublishSpecialCatService() {
		return publishSpecialCatService;
	}

	public void setPublishSpecialCatService(
			PublishSpecialCatService publishSpecialCatService) {
		this.publishSpecialCatService = publishSpecialCatService;
	}

	
	
	
	
   ///////////////////////////wepic2.0 method//////////////////////////////
	public List<Story> existsstory(Integer userid){
		User user=this.getUserService().selectById(userid);
		DetachedCriteria criteria=DetachedCriteria.forClass(Story.class);
		criteria.createAlias("user", "tempuser");
		criteria.createAlias("publishStatus", "publishStatus");
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
		criteria.add(Restrictions.eq("tempuser.id",user.getId()));
		criteria.add(Restrictions.ne("publishStatus.pass",1));
		criteria.add(Restrictions.ne("publishStatus.noPass",1));
		criteria.add(Restrictions.ne("publishStatus.onOffer",1));
		criteria.add(Restrictions.ne("publishStatus.adminSoldout",1));
		criteria.add(Restrictions.ne("publishStatus.userSoldout",1));
		criteria.add(Restrictions.ne("publishStatus.userDelete",1));
		criteria.add(Restrictions.ne("publishStatus.adminDelete",1));
		criteria.add(Restrictions.eq("publishStatus.publishorstory",1));
		return this.storyDao.findbyDetached(criteria);
	}
	public void storyoffsale(Integer storyid) {
		Story story=this.storyDao.select(storyid);
		PublishStatus publishStatus=story.getPublishStatus();
		publishStatus.setUserSoldout(1);
		publishStatus.setOnOffer(0);
		publishStatus.setPass(0);
		this.getPublishStatusService().updatePublishStatus(publishStatus);
	}
	
	public PublishStatusService getPublishStatusService() {
		return publishStatusService;
	}

	public void setPublishStatusService(PublishStatusService publishStatusService) {
		this.publishStatusService = publishStatusService;
	}

	public StoryFilterWordsService getStoryFilterWordsService() {
		return storyFilterWordsService;
	}

	public void setStoryFilterWordsService(
			StoryFilterWordsService storyFilterWordsService) {
		this.storyFilterWordsService = storyFilterWordsService;
	}

	public List<PublishCat> publishCats() {
	return	publishCatService.allstorycats();
	}
	public List<PublishSpecialCat> specialCats(Integer uid) {
		// TODO Auto-generated method stub
		return publishSpecialCatService.specialCatuserOfStory(uid);
	}
	public List uploadimg(Integer uid,File mycover,String mycoverFilename,String mycoverFiletype){
		HttpServletRequest request=ServletActionContext.getRequest();
		List tempList=new LinkedList();
		try{
			User user=new User();
			user.setId(uid);
			Publish publish=new Publish();
			publish.setUser(user);
			PublishSpecialCat publishSpecialCat=new PublishSpecialCat();
		    publishSpecialCat.setId(8);
			publish.setPublishSpecialCat(publishSpecialCat);
			String path=publishService.uploadOpusOfStory(request, mycover,mycoverFilename,publish);
			tempList.add(publish.getId());
			}catch (Exception e) {
				e.printStackTrace();
			}
		return tempList;
	}
	
	
	public List cutcover(Integer publishId,Integer x1,Integer x2,Integer y1,Integer y2){
		List temList=new LinkedList();
		Publish publish=this.getPublishService().select(publishId);
		publish.setId(publishId);
		String tempPicName=publish.getSmallDrawCut();
		String tag="cut285175";
		String cut285175=tempPicName.substring(tempPicName.indexOf(tag)+1+tag.length(),tempPicName.length());
		String currentAbsoulutePath=Thread.currentThread().getContextClassLoader().getResource("").getPath();
        PropertiesRead readPro = new PropertiesRead(currentAbsoulutePath+"picpath.properties");//相对路径
        String cut = readPro.getValue(tag)+"/"+cut285175;
		File file=new File(cut);
		UploadUtils uploadUtils=new UploadUtils();
		String cutcover="";
		try {
			cutcover = uploadUtils.cutcomplete(file,x1,x2,y1,y2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		publish.setSmallDrawCut(cutcover);
		publishService.updateCut(publish);
		temList.add(cutcover);
		temList.add(publish.getId());
		return temList;
		
	}
	public int publishstorysucofboth(Integer storyId,Story story2,Integer uid,Integer publishId,String mytags[],String special,String temppublishcat[],String publish[],String cxt[],String copyrightprice,String useprice) {
		List<StorySystemFilterWords> filterWords=this.getStoryFilterWordsService().findAll();
		Story story=this.storyDao.select(storyId);
		User user1=new User();
		user1.setId(uid);
		Publish tempPublish=this.getPublishService().select(publishId);
		story.setUser(user1);
		story.setCover(tempPublish.getSmallDrawCut());
		story.setPublishid(tempPublish.getId());//封面引用的publish
		story.setTitle(story2.getTitle());
		String description=story2.getStorydescription().trim().replaceAll("\t*", "");
		String storysummarywords="";
		int repeat2 = 0;
		for (int j = 0; j < filterWords.size(); j++) {
			if (description.contains(filterWords.get(j).getWords())) {
				storysummarywords+=filterWords.get(j).getWords()+",";
				repeat2++;
			}
		}
		
		story.setStorydescription(description);
		story.setSpecialWords(storysummarywords);
		
//		story.setUploadTime(story2.getUploadTime());
		story.setPublishTime(getcurrent());
		story.setHit(story.getHit()+1);
	    story.setStatu(1);	
	    story.setTags("");
		List tagList=new ArrayList();
		for (int i = 0; i < mytags.length; i++) {
			tagList.add(mytags[i]);
		}
		String temptag="";
		for (int i = 0; i < tagList.size(); i++) {
			temptag+=tagList.get(i)+" ";
		}
		story.setTags(temptag);
		PublishSpecialCat specialCat=this.getPublishSpecialCatService().select(Integer.parseInt(special));
		story.setPublishSpecialCat(specialCat);
		delstorydetailofstory(storyId);
		delcatstory(storyId);
		story.setCopyrightPrice(Integer.valueOf(copyrightprice));
		story.setUsagePrice(Integer.valueOf(useprice));
		story.setCopyrightres("2");
		story.setCopyrightProperty(story2.getCopyrightProperty());
		story.setMoneyType(story2.getMoneyType());
		story.setCopyrightArea(story2.getCopyrightArea());
		String str="ep0";
		int tempNum=10000;
		tempNum=tempNum+storyId;
		story.setRemark(str+""+tempNum);
		this.storyDao.update(story);
		PublishStatus publishStatus=story.getPublishStatus();
		publishStatus.setUnreleased(1);
		publishStatus.setAwaitingReview(1);
		this.getPublishStatusService().updatePublishStatus(publishStatus);
	    List tempList=new ArrayList();
		for (int i = 0; i < temppublishcat.length; i++) {
			tempList.add(temppublishcat[i].replaceAll("\\s*", ""));
		}
		for(int i=0;i<tempList.size();i++){
			PublishCat oneInstance2 = this.getPublishCatService().select(Integer.valueOf(tempList.get(i).toString()));
			PublishCat_Story catstory=new PublishCat_Story();
			catstory.setStory(story);
			catstory.setPublishCat(oneInstance2);
			publishCatStorySevice.insert(catstory);
		}
		List publishList=new LinkedList();
		for (int i = 0; i < publish.length; i++) {
			publishList.add(publish[i]);
		}
		
		List cxtList=new LinkedList();
		for (int i = 0; i < cxt.length; i++) {
			cxtList.add(cxt[i]);
		}
		String words="";
		for (int i = 0; i < publishList.size(); i++) {
			StoryDetail storyDetail=new StoryDetail();
			int tempid=Integer.valueOf(publishList.get(i).toString());
			Publish publish2=this.getPublishService().select(tempid);
			storyDetail.setPublishId(tempid);
			storyDetail.setDetailContext(cxtList.get(i).toString().trim().replaceAll("\t*", ""));
			int repeat = 0;
			for (int j = 0; j < filterWords.size(); j++) {
				if (cxtList.get(i).toString().contains(filterWords.get(j).getWords())) {
					words+=filterWords.get(j).getWords()+",";
					repeat++;
				}
			}
			storyDetail.setStory(story);
			storyDetail.setWidth(publish2.getWidth());
			storyDetail.setHeight(publish2.getHeight());
			storyDetail.setSamllPic(publish2.getSmallPic());
			storyDetail.setThumbnailUrl(publish2.getThumbnailUrl());
			storyDetail.setSpecialwords(words);
			this.storyDetailService.insert(storyDetail);
			PublishStatus publishStatus2=publish2.getPublishStatus();
			publishStatus2.setPublishToStroy(1);
			this.getPublishStatusService().updatePublishStatus(publishStatus2);
		}
		return storyId;
	}
	public int publishstorysucofcopyright(Integer storyId,Story story2,Integer uid,Integer publishId,String mytags[],String special,String temppublishcat[],String publish[],String cxt[],String copyrightuseprice) {
		List<StorySystemFilterWords> filterWords=this.getStoryFilterWordsService().findAll();
		Story story=this.storyDao.select(storyId);
		User user1=new User();
		user1.setId(uid);
		Publish tempPublish=this.getPublishService().select(publishId);
		story.setUser(user1);
		story.setCover(tempPublish.getSmallDrawCut());
		story.setPublishid(tempPublish.getId());//封面引用的publish
		story.setTitle(story2.getTitle());
		String description=story2.getStorydescription().trim().replaceAll("\t*", "");
		String storysummarywords="";
		int repeat2 = 0;
		for (int j = 0; j < filterWords.size(); j++) {
			if (description.contains(filterWords.get(j).getWords())) {
				storysummarywords+=filterWords.get(j).getWords()+",";
				repeat2++;
			}
		}
		
		story.setStorydescription(description);
		story.setSpecialWords(storysummarywords);
//		story.setUploadTime(story2.getUploadTime());
		story.setPublishTime(getcurrent());
		story.setHit(story.getHit()+1);
	    story.setStatu(1);	
	    story.setTags("");
		List tagList=new ArrayList();
		for (int i = 0; i < mytags.length; i++) {
			tagList.add(mytags[i]);
		}
		String temptag="";
		for (int i = 0; i < tagList.size(); i++) {
			temptag+=tagList.get(i)+" ";
		}
		story.setTags(temptag);
		PublishSpecialCat specialCat=this.getPublishSpecialCatService().select(Integer.parseInt(special));
		story.setPublishSpecialCat(specialCat);
		delstorydetailofstory(storyId);
		delcatstory(storyId);
		story.setCopyrightPrice(Integer.valueOf(copyrightuseprice));
		story.setCopyrightres("1");
		story.setCopyrightProperty(story2.getCopyrightProperty());
		story.setMoneyType(story2.getMoneyType());
		story.setCopyrightArea(story2.getCopyrightArea());
		String str="ep0";
		int tempNum=10000;
		tempNum=tempNum+storyId;
		story.setRemark(str+""+tempNum);
		this.storyDao.update(story);
		PublishStatus publishStatus=story.getPublishStatus();
		publishStatus.setUnreleased(1);
		publishStatus.setAwaitingReview(1);
		this.getPublishStatusService().updatePublishStatus(publishStatus);
	    List tempList=new ArrayList();
		for (int i = 0; i < temppublishcat.length; i++) {
			tempList.add(temppublishcat[i].replaceAll("\\s*", ""));
		}
		for(int i=0;i<tempList.size();i++){
			PublishCat oneInstance2 = this.getPublishCatService().select(Integer.valueOf(tempList.get(i).toString()));
			PublishCat_Story catstory=new PublishCat_Story();
			catstory.setStory(story);
			catstory.setPublishCat(oneInstance2);
			publishCatStorySevice.insert(catstory);
		}
		List publishList=new LinkedList();
		for (int i = 0; i < publish.length; i++) {
			publishList.add(publish[i]);
		}
		
		List cxtList=new LinkedList();
		for (int i = 0; i < cxt.length; i++) {
			cxtList.add(cxt[i]);
		}
		String words="";
		for (int i = 0; i < publishList.size(); i++) {
			StoryDetail storyDetail=new StoryDetail();
			int tempid=Integer.valueOf(publishList.get(i).toString());
			Publish publish2=this.getPublishService().select(tempid);
			storyDetail.setPublishId(tempid);
			storyDetail.setDetailContext(cxtList.get(i).toString().trim().replaceAll("\t*", ""));
			int repeat = 0;
			for (int j = 0; j < filterWords.size(); j++) {
				if (cxtList.get(i).toString().contains(filterWords.get(j).getWords())) {
					words+=filterWords.get(j).getWords()+",";
					repeat++;
				}
			}
			storyDetail.setStory(story);
			storyDetail.setWidth(publish2.getWidth());
			storyDetail.setHeight(publish2.getHeight());
			storyDetail.setSamllPic(publish2.getSmallPic());
			storyDetail.setThumbnailUrl(publish2.getThumbnailUrl());
			storyDetail.setSpecialwords(words);
			this.storyDetailService.insert(storyDetail);
			PublishStatus publishStatus2=publish2.getPublishStatus();
			publishStatus2.setPublishToStroy(1);
			this.getPublishStatusService().updatePublishStatus(publishStatus2);
		}
		return storyId;
	}
	public int publishstorysucofusecopyright(Integer storyId,Story story2,Integer uid,Integer publishId,String mytags[],String special,String temppublishcat[],String publish[],String cxt[],String copyrightuseprice) {
		List<StorySystemFilterWords> filterWords=this.getStoryFilterWordsService().findAll();
		Story story=this.storyDao.select(storyId);
		User user1=new User();
		user1.setId(uid);
		Publish tempPublish=this.getPublishService().select(publishId);
		story.setUser(user1);
		story.setCover(tempPublish.getSmallDrawCut());
		story.setPublishid(tempPublish.getId());//封面引用的publish
		story.setTitle(story2.getTitle());
		String description=story2.getStorydescription().trim().replaceAll("\t*", "");
		String storysummarywords="";
		int repeat2 = 0;
		for (int j = 0; j < filterWords.size(); j++) {
			if (description.contains(filterWords.get(j).getWords())) {
				storysummarywords+=filterWords.get(j).getWords()+",";
				repeat2++;
			}
		}
		
		story.setStorydescription(description);
		story.setSpecialWords(storysummarywords);
//		story.setUploadTime(story2.getUploadTime());
		story.setPublishTime(getcurrent());
		story.setHit(story.getHit()+1);
	    story.setStatu(1);	
	    story.setTags("");
		List tagList=new ArrayList();
		for (int i = 0; i < mytags.length; i++) {
			tagList.add(mytags[i]);
		}
		String temptag="";
		for (int i = 0; i < tagList.size(); i++) {
			temptag+=tagList.get(i)+" ";
		}
		story.setTags(temptag);
		PublishSpecialCat specialCat=this.getPublishSpecialCatService().select(Integer.parseInt(special));
		story.setPublishSpecialCat(specialCat);
		delstorydetailofstory(storyId);
		delcatstory(storyId);
		story.setUsagePrice(Integer.valueOf(copyrightuseprice));
		story.setCopyrightres("0");
		story.setCopyrightProperty(story2.getCopyrightProperty());
		story.setMoneyType(story2.getMoneyType());
		story.setCopyrightArea(story2.getCopyrightArea());
		String str="ep0";
		int tempNum=10000;
		tempNum=tempNum+storyId;
		story.setRemark(str+""+tempNum);
		this.storyDao.update(story);
		PublishStatus publishStatus=story.getPublishStatus();
		publishStatus.setUnreleased(1);
		publishStatus.setAwaitingReview(1);
		this.getPublishStatusService().updatePublishStatus(publishStatus);
	    List tempList=new ArrayList();
		for (int i = 0; i < temppublishcat.length; i++) {
			tempList.add(temppublishcat[i].replaceAll("\\s*", ""));
		}
		for(int i=0;i<tempList.size();i++){
			PublishCat oneInstance=this.getPublishCatService().select(Integer.valueOf(tempList.get(i).toString()));
			PublishCat_Story catstory=new PublishCat_Story();
			catstory.setStory(story);
			catstory.setPublishCat(oneInstance);
			publishCatStorySevice.insert(catstory);
		}
		List publishList=new LinkedList();
		for (int i = 0; i < publish.length; i++) {
			publishList.add(publish[i]);
		}
		
		List cxtList=new LinkedList();
		for (int i = 0; i < cxt.length; i++) {
			cxtList.add(cxt[i]);
		}
		String words="";
		for (int i = 0; i < publishList.size(); i++) {
			StoryDetail storyDetail=new StoryDetail();
			int tempid=Integer.valueOf(publishList.get(i).toString());
			Publish publish2=this.getPublishService().select(tempid);
			storyDetail.setPublishId(tempid);
			storyDetail.setDetailContext(cxtList.get(i).toString().trim().replaceAll("\t*", ""));
			int repeat = 0;
			for (int j = 0; j < filterWords.size(); j++) {
				if (cxtList.get(i).toString().contains(filterWords.get(j).getWords())) {
					words+=filterWords.get(j).getWords()+",";
					repeat++;
				}
			}
			storyDetail.setStory(story);
			storyDetail.setWidth(publish2.getWidth());
			storyDetail.setHeight(publish2.getHeight());
			storyDetail.setSamllPic(publish2.getSmallPic());
			storyDetail.setThumbnailUrl(publish2.getThumbnailUrl());
			storyDetail.setSpecialwords(words);
			this.storyDetailService.insert(storyDetail);
			PublishStatus publishStatus2=publish2.getPublishStatus();
			publishStatus2.setPublishToStroy(1);
			this.getPublishStatusService().updatePublishStatus(publishStatus2);
		}
		return storyId;
	}
	
	
	public void insert(String name) {
		StorySystemFilterWords storySystemFilterWords=new StorySystemFilterWords();
		storySystemFilterWords.setWords(name);
		this.getStoryFilterWordsService().insert(storySystemFilterWords);
	}
	public int publishstorysuc(Integer storyId,Story story2,Integer uid,Integer publishId,String mytags[],String special,String temppublishcat[],String publish[],String cxt[]) {
		Story story=this.storyDao.select(storyId);
		User user1=new User();
		user1.setId(uid);
		Publish tempPublish=this.getPublishService().select(publishId);
		story.setUser(user1);
		story.setCover(tempPublish.getSmallDrawCut());
		story.setPublishid(tempPublish.getId());//封面引用的publish
		story.setTitle(story2.getTitle());
		story.setStorydescription(story2.getStorydescription().trim().replaceAll("\t*", ""));
		story.setUploadTime(story2.getUploadTime());
		story.setPublishTime(getcurrent());
		story.setHit(story.getHit()+1);
	    story.setStatu(1);	
	    story.setTags("");
		List tagList=new ArrayList();
		for (int i = 0; i < mytags.length; i++) {
			tagList.add(mytags[i]);
		}
		String temptag="";
		for (int i = 0; i < tagList.size(); i++) {
			temptag+=tagList.get(i)+" ";
		}
		story.setTags(temptag);
		PublishSpecialCat specialCat=this.getPublishSpecialCatService().select(Integer.parseInt(special));
		story.setPublishSpecialCat(specialCat);
		delstorydetailofstory(storyId);
		delcatstory(storyId);
//		String copyres=story2.getCopyrightres();
//		if (copyres.contains("0") && (!copyres.contains("1"))) {
//			story.setUsagePrice(story2.getUsagePrice());
//			story.setCopyrightres("0");
//		}else if ((!copyres.contains("0")) && copyres.contains("1")) {
//			story.setCopyrightPrice(story2.getCopyrightPrice());
//			story.setCopyrightres("1");
//		}else {
//			story.setUsagePrice(story2.getUsagePrice());
//			story.setCopyrightPrice(story2.getCopyrightPrice());
//			story.setCopyrightres("2");
//		}
//		story.setCopyright(story2.getCopyright());
//		story.setUsagePrice(story2.getUsagePrice());
		story.setCopyrightProperty(story2.getCopyrightProperty());
		story.setMoneyType(story2.getMoneyType());
		story.setCopyrightArea(story2.getCopyrightArea());
		String str="ep0";
		int tempNum=10000;
		tempNum=tempNum+storyId;
		story.setRemark(str+""+tempNum);
		this.storyDao.update(story);
		
	    List tempList=new ArrayList();
		for (int i = 0; i < temppublishcat.length; i++) {
			tempList.add(temppublishcat[i].replaceAll("\\s*", ""));
		}
		for(int i=0;i<tempList.size();i++){
			PublishCat oneInstance2 = this.getPublishCatService().selectOfName(tempList.get(i).toString());
			PublishCat_Story catstory=new PublishCat_Story();
			catstory.setStory(story);
			catstory.setPublishCat(oneInstance2);
			publishCatStorySevice.insert(catstory);
		}
		List publishList=new LinkedList();
		for (int i = 0; i < publish.length; i++) {
			publishList.add(publish[i]);
		}
		
		List cxtList=new LinkedList();
		for (int i = 0; i < cxt.length; i++) {
			cxtList.add(cxt[i]);
		}
		for (int i = 0; i < publishList.size(); i++) {
			StoryDetail storyDetail=new StoryDetail();
			int tempid=Integer.valueOf(publishList.get(i).toString());
			Publish publish2=this.getPublishService().select(tempid);
			storyDetail.setPublishId(tempid);
			storyDetail.setDetailContext(cxtList.get(i).toString().trim().replaceAll("\t*", ""));
			storyDetail.setStory(story);
			storyDetail.setWidth(publish2.getWidth());
			storyDetail.setHeight(publish2.getHeight());
			storyDetail.setSamllPic(publish2.getSmallPic());
			storyDetail.setThumbnailUrl(publish2.getThumbnailUrl());
			this.storyDetailService.insert(storyDetail);
		}
		return storyId;
	}
	public int editunpublishedstory(Integer storyId,Story story2,Integer uid,Integer publishId,String mytags[],String special,String temppublishcat[],String publish[],String cxt[]) {
		Story story=this.storyDao.select(storyId);
		User user1=new User();
		user1.setId(uid);
		Publish tempPublish=this.getPublishService().select(publishId);
		story.setUser(user1);
		story.setCover(tempPublish.getSmallDrawCut());
		story.setPublishid(tempPublish.getId());//封面引用的publish
		story.setTitle(story2.getTitle());
		story.setStorydescription(story2.getStorydescription().trim().replaceAll("\t*", ""));
		//story.setUploadTime(getcurrent());
		story.setHit(story.getHit()+1);
	    story.setStatu(0);	
	    story.setTags("");
		List tagList=new ArrayList();	
		for (int i = 0; i < mytags.length; i++) {
			tagList.add(mytags[i]);
		}
		String temptag="";
		for (int i = 0; i < tagList.size(); i++) {
			temptag+=tagList.get(i)+" ";
		}
		story.setTags(temptag);
		PublishSpecialCat specialCat=this.getPublishSpecialCatService().select(Integer.parseInt(special));
		story.setPublishSpecialCat(specialCat);
		delstorydetailofstory(storyId);
		delcatstory(storyId);
		
		String str="ep0";
		int tempNum=10000;
		tempNum=tempNum+storyId;
		story.setRemark(str+""+tempNum);
		this.storyDao.update(story);
		
	    List tempList=new ArrayList();
		for (int i = 0; i < temppublishcat.length; i++) {
			tempList.add(temppublishcat[i].replaceAll("\\s*", ""));
		}
		for(int i=0;i<tempList.size();i++){
			PublishCat oneInstance2 = this.getPublishCatService().select(Integer.valueOf(tempList.get(i).toString()));
			PublishCat_Story catstory=new PublishCat_Story();
			catstory.setStory(story);
			catstory.setPublishCat(oneInstance2);
			publishCatStorySevice.insert(catstory);
		}
		List publishList=new LinkedList();
		for (int i = 0; i < publish.length; i++) {
			publishList.add(publish[i]);
		}
		
		List cxtList=new LinkedList();
		for (int i = 0; i < cxt.length; i++) {
			cxtList.add(cxt[i]);
		}
		for (int i = 0; i < publishList.size(); i++) {
			StoryDetail storyDetail=new StoryDetail();
			int tempid=Integer.valueOf(publishList.get(i).toString());
			Publish publish2=this.getPublishService().select(tempid);
			storyDetail.setPublishId(tempid);
			storyDetail.setDetailContext(cxtList.get(i).toString().trim().replaceAll("\t*", ""));
			storyDetail.setStory(story);
			storyDetail.setWidth(publish2.getWidth());
			storyDetail.setHeight(publish2.getHeight());
			storyDetail.setSamllPic(publish2.getSmallPic());
			storyDetail.setThumbnailUrl(publish2.getThumbnailUrl());
			this.storyDetailService.insert(storyDetail);
		}
		return storyId;
	}
	public void adminchecksuc(Integer storyid) {
		Story story=storyDao.select(storyid);
		PublishStatus publishStatus=story.getPublishStatus();
		publishStatus.setPass(1);//审核通过
		publishStatus.setOnOffer(1);//销售中
		this.getPublishStatusService().updatePublishStatus(publishStatus);
		story.setCheckTime(getcurrent());//审核通过时间
		storyDao.update(story);
	}
	public void adminrecover(Integer storyid) {
		Story story=storyDao.select(storyid);
		PublishStatus publishStatus=story.getPublishStatus();
		publishStatus.setPass(1);//审核通过
		publishStatus.setOnOffer(1);//销售中
		publishStatus.setAdminSoldout(0);
		this.getPublishStatusService().updatePublishStatus(publishStatus);
		story.setCheckTime(getcurrent());//审核通过时间
		storyDao.update(story);
	}
	
	public void allnopass(Integer id) {
		Story story2=this.getStoryDao().select(id);
		this.getStoryDao().update(story2);
		PublishStatus publishStatus=story2.getPublishStatus();
		publishStatus.setNoPass(1);
		this.getPublishStatusService().updatePublishStatus(publishStatus);
	}
	public void checknopass(Story story,Integer id){
		Story story2=this.getStoryDao().select(id);
		String nopassreason="";
		String write="";
		if (story.getNopasscause().contains("1")) {
			nopassreason+="您上传的证件不清晰.";
		}
		if (story.getNopasscause().contains("2")) {
			nopassreason+="证件照片有改动.";
			
		}
		if (story.getNopasscause().contains("3")) {
			nopassreason+="您提交的身份信息不正确.";
		}
		if(story.getNopasscause().contains("0")) {
			write=story.getWritereason();
		}
		story2.setWritereason(write);
		story2.setNopassration(nopassreason);
		story2.setNopasscause(story.getNopasscause());
		this.getStoryDao().update(story2);
		PublishStatus publishStatus=story2.getPublishStatus();
		publishStatus.setNoPass(1);
		this.getPublishStatusService().updatePublishStatus(publishStatus);
	}
	public void admindelchecking(Integer storyid){
		this.delstorydetailofstory(storyid);
		this.delcatstory(storyid);
//		this.delete(storyid);
		Story story=this.getStoryDao().select(storyid);
//		PublishStatus publishStatus2=story.getPublishStatus();
		PublishStatus publishStatus=this.getPublishStatusService().findById(storyid);
		this.getPublishStatusService().deletePublishStatues(publishStatus);
		storyDao.delete(story);
	}
	
	public void createstatic(Integer id) throws Exception, FileNotFoundException{

		Story story=this.getStoryDao().select(id);
		List<StoryDetail> storyDetails=this.getStoryDetailService().showThePublishofdetais(story.getId());
        String path=ServletActionContext.getRequest().getRealPath("back/personalCentr/myworklib/");
        String filename=path+"/"+"storydownload.html";
        File file=new File(filename);
        if (!file.exists()) { 
        	file.createNewFile(); 
        	}else {
				file.delete();
				file.createNewFile();	
			}
        PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"utf-8")));
        
        writer.write("<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'><html xmlns='http://www.w3.org/1999/xhtml'>"+
"<head><meta http-equiv='Content-Type' content='text/html; charset=utf-8' /><title>"+story.getTitle()+"</title></head><body><style type='text/css'>"+
"body {color: #848484;font-family: '微软雅黑';font-size: 12px;}*{margin:0;padding:0;}.phoStroyDetailLeft{	margin:0 auto;	position: relative;top: 0;left: 0;" +
"padding-left:25px;padding-right:25px;width:450px;border:1px solid #e6e6e6;background:#ffffff;text-align:left;}" +
".phoStroyDetailLeft .divHead{width:750px;min-height:60px;border-bottom:1px solid #c0c0c0;}.phoStroyDetailLeft .divHead .name{color: #000000;font-weight:normal;font-family: '微软雅黑';font-size:20px;width:750px;min-height:30px;text-align:center;margin-top:25px;display:inline-block;}" +
".phoStroyDetailLeft .divAuthor{margin-top:20px;color: #000000;min-height:30px;line-height:30px;font-size:15px;}" +
".phoStroyDetailLeft .divDescribe{position: relative; top: 0; left: 0;width:750px;min-height:115px;}.phoStroyDetailLeft .divDescribe .character{height:35px;" +
"line-height:40px;color: #000000;}.phoStroyDetailLeft .divDescribe .dec{text-indent: 2em;min-height:70px;width:750px;font-family: '宋体';}.phoStroyDetailLeft .divContent{" +
"width:750px;padding-bottom:40px;color:#000000;}.phoStroyDetailLeft  .storyzw{height:35px;line-height:40px;color: #000000;}.phoStroyDetailLeft .divContent .picStory{" +
"max-height:500px;max-width:750px;}.phoStroyDetailLeft .divContent .char{height:30px;line-height:30px;color: #8a8a8a;}.end{color: #000000;height:30px;width: 750px;margin:0 auto;" +
"margin-top:20px;font-size:16px;font-family: '宋体';font-weight:bold;}.int{text-align:center;color: #fff;background:#ef9200;height:30px;	line-height:30px;width: 750px;" +
"margin:0 auto;margin-top:20px;font-size:18px;margin-bottom:40px;}.phoStroyDetailLeft .divContent .info{text-indent: 2em;}</style>" +
"<div class='phoStroyDetailLeft'  id='phoStroyDetailLeft'><div class='divHead'><div class='name' title='"+story.getTitle()+"'>"+story.getTitle()+"</div></div>" +
"<div class='divAuthor'>作者：<span>"+story.getUser().getNickName()+"</span>(唯图网会员昵称)</div><div class='divDescribe'><div class='character'>故事简介：</div><div class='dec'>"+story.getStorydescription()+"</div>" +
"</div><div class='storyzw'>故事正文：</div>");
        for (int i = 0; i < storyDetails.size(); i++) {
        	Publish publish=this.getPublishService().select(storyDetails.get(i).getPublishId());
			writer.write("<div class='divContent'><div class='picStory'>" +
					"<img src='"+storyDetails.get(i).getSamllPic()+"' /></div><div class='char'>图片编号：<span>"+publish.getPicNumber()+"</span></div>" +
			"<div class='info'>"+storyDetails.get(i).getDetailContext()+"</div></div>");
		}
        writer.write("</div><div class='end'>正文结束</div><div class='int'>此故事仅可用于传媒/媒体，其中图片不可单独用于其他商业用途，版权所有，违者必究！</div></body></html>");
        writer.close();
		
	}
	public int releasenewstory(Story story,Integer uid,Integer publishId,String mytags[],String special,String temppublishcat[],String publish[],String cxt[]) {
		List<StorySystemFilterWords> filterWords=this.getStoryFilterWordsService().findAll();
		User user1=new User();
		user1.setId(uid);
		Publish tempPublish=this.getPublishService().select(publishId);
		PublishStatus publishStatus=tempPublish.getPublishStatus();
		publishStatus.setPublishToStroy(1);
		this.getPublishStatusService().updatePublishStatus(publishStatus);//用作摄影故事封面
		story.setUser(user1);
		story.setCover(tempPublish.getSmallDrawCut());
		story.setPublishid(tempPublish.getId());//封面引用的publish
		story.setTitle(story.getTitle());
		String description=story.getStorydescription().trim().replaceAll("\t*", "");
		String storysummarywords="";
		int repeat2 = 0;
		for (int j = 0; j < filterWords.size(); j++) {
			if (description.contains(filterWords.get(j).getWords())) {
				storysummarywords+=filterWords.get(j).getWords()+",";
				repeat2++;
			}
		}
		
		story.setStorydescription(description);
		story.setSpecialWords(storysummarywords);
		
		
		story.setUploadTime(getcurrent());
		story.setPublishTime(getcurrent());
		story.setHit(0);
	    story.setStatu(0);	
		List tagList=new ArrayList();
		for (int i = 0; i < mytags.length; i++) {
			tagList.add(mytags[i]);
		}
		String temptag="";
		for (int i = 0; i < tagList.size(); i++) {
			temptag+=tagList.get(i)+" ";
		}
		story.setTags(temptag);
		PublishSpecialCat specialCat=null;
		if (special.equals("0")) {
			specialCat=this.getPublishSpecialCatService().defaultOfSpecial();
		}else {
			specialCat=this.getPublishSpecialCatService().select(Integer.parseInt(special));	
		}
		
		story.setPublishSpecialCat(specialCat);
		int res=this.storyDao.insert(story);
		System.out.println(res);
		String str="ep0";
		int tempNum=10000;
		tempNum=tempNum+story.getId();
		story.setRemark(str+""+tempNum);
		this.storyDao.update(story);
	    List tempList=new ArrayList();
		for (int i = 0; i < temppublishcat.length; i++) {
			tempList.add(temppublishcat[i].replaceAll("\\s*", ""));
		}
		for(int i=0;i<tempList.size();i++){
			PublishCat oneInstance2 = this.getPublishCatService().select(Integer.valueOf(tempList.get(i).toString()));
			PublishCat_Story catstory=new PublishCat_Story();
			catstory.setStory(story);
			catstory.setPublishCat(oneInstance2);
			publishCatStorySevice.insert(catstory);
		}
		List publishList=new LinkedList();
		for (int i = 0; i < publish.length; i++) {
			publishList.add(publish[i]);
		}
		
		List cxtList=new LinkedList();
		for (int i = 0; i < cxt.length; i++) {
			cxtList.add(cxt[i]);
		}
		
		String words="";
		for (int i = 0; i < publishList.size(); i++) {
			StoryDetail storyDetail=new StoryDetail();
			int tempid=Integer.valueOf(publishList.get(i).toString());
			Publish publish2=this.getPublishService().select(tempid);
			//更新图片状态为用作摄影故事
			PublishStatus publishStatus2=publish2.getPublishStatus();
			publishStatus2.setPublishToStroy(1);
			this.getPublishStatusService().updatePublishStatus(publishStatus2);
			storyDetail.setPublishId(tempid);
			storyDetail.setDetailContext(cxtList.get(i).toString().trim().replaceAll("\t*", ""));
			int repeat = 0;
			for (int j = 0; j < filterWords.size(); j++) {
				if (cxtList.get(i).toString().contains(filterWords.get(j).getWords())) {
					words+=filterWords.get(j).getWords()+",";
					repeat++;
				}
			}
			
			
			storyDetail.setStory(story);
			storyDetail.setWidth(publish2.getWidth());
			storyDetail.setHeight(publish2.getHeight());
			storyDetail.setSamllPic(publish2.getSmallPic());
			storyDetail.setThumbnailUrl(publish2.getThumbnailUrl());
			storyDetail.setSpecialwords(words);
			this.storyDetailService.insert(storyDetail);
		}
		
		
		List<StoryDetail> storyDetails=this.storyDetailService.showThePublishofdetais(story.getId());
		int num=0;
		int txtNum=0;
		for (int i = 0; i < storyDetails.size(); i++) {
			txtNum+=storyDetails.get(i).getDetailContext().length();
			Publish publish2=this.getPublishService().select(storyDetails.get(i).getPublishId());
			if (publish2 != null) {
				num++;
			}
		}
		story.setDetailpicNum(num);
		story.setDetailtextNum(txtNum);
		
		
		PublishStatus publishStatus2=new PublishStatus();
		publishStatus2.setUnreleased(1);
		publishStatus2.setAwaitingReview(1);
		publishStatus2.setNoPass(0);
		publishStatus2.setJustShow(0);
		publishStatus2.setOnOffer(0);
		publishStatus2.setCopyrightBuyout(0);
		publishStatus2.setUserSoldout(0);
		publishStatus2.setAdminSoldout(0);
		publishStatus2.setPublishToStroy(0);
		publishStatus2.setUserDelete(0);
		publishStatus2.setAdminDelete(0);
		publishStatus2.setPublishorstory(1);
		publishStatusService.savePublishStatus(publishStatus2);
		story.setPublishStatus(publishStatus2);
		this.storyDao.update(story);
		
		return story.getId();
	}
	public int savestory(Story story,Integer uid,Integer publishId,String mytags[],String special,String temppublishcat[],String publish[],String cxt[]) {
		List<StorySystemFilterWords> filterWords=this.getStoryFilterWordsService().findAll();
		User user1=new User();
		user1.setId(uid);
		Publish tempPublish=this.getPublishService().select(publishId);
		PublishStatus publishStatus=tempPublish.getPublishStatus();
		publishStatus.setPublishToStroy(1);
		this.getPublishStatusService().updatePublishStatus(publishStatus);//用作摄影故事封面
		story.setUser(user1);
		story.setCover(tempPublish.getSmallDrawCut());
		story.setPublishid(tempPublish.getId());//封面引用的publish
		story.setTitle(story.getTitle());
		String description=story.getStorydescription().trim().replaceAll("\t*", "");
		String storysummarywords="";
		int repeat2 = 0;
		for (int j = 0; j < filterWords.size(); j++) {
			if (description.contains(filterWords.get(j).getWords())) {
				storysummarywords+=filterWords.get(j).getWords()+",";
				repeat2++;
			}
		}
		
		story.setStorydescription(description);
		story.setSpecialWords(storysummarywords);
		
		
		story.setUploadTime(getcurrent());
		story.setHit(0);
	    story.setStatu(0);	
		List tagList=new ArrayList();
		for (int i = 0; i < mytags.length; i++) {
			tagList.add(mytags[i]);
		}
		String temptag="";
		for (int i = 0; i < tagList.size(); i++) {
			temptag+=tagList.get(i)+" ";
		}
		story.setTags(temptag);
		PublishSpecialCat specialCat=null;
		if (special.equals("0")) {
			specialCat=this.getPublishSpecialCatService().defaultOfSpecial();
		}else {
			specialCat=this.getPublishSpecialCatService().select(Integer.parseInt(special));	
		}
		
		story.setPublishSpecialCat(specialCat);
		int res=this.storyDao.insert(story);
		System.out.println(res);
		String str="ep0";
		int tempNum=10000;
		tempNum=tempNum+story.getId();
		story.setRemark(str+""+tempNum);
		this.storyDao.update(story);
	    List tempList=new ArrayList();
		for (int i = 0; i < temppublishcat.length; i++) {
			tempList.add(temppublishcat[i].replaceAll("\\s*", ""));
		}
		for(int i=0;i<tempList.size();i++){
			PublishCat oneInstance2 = this.getPublishCatService().select(Integer.valueOf(tempList.get(i).toString()));
			PublishCat_Story catstory=new PublishCat_Story();
			catstory.setStory(story);
			catstory.setPublishCat(oneInstance2);
			publishCatStorySevice.insert(catstory);
		}
		List publishList=new LinkedList();
		for (int i = 0; i < publish.length; i++) {
			publishList.add(publish[i]);
		}
		
		List cxtList=new LinkedList();
		for (int i = 0; i < cxt.length; i++) {
			cxtList.add(cxt[i]);
		}
		
		String words="";
		for (int i = 0; i < publishList.size(); i++) {
			StoryDetail storyDetail=new StoryDetail();
			int tempid=Integer.valueOf(publishList.get(i).toString());
			Publish publish2=this.getPublishService().select(tempid);
			//更新图片状态为用作摄影故事
			PublishStatus publishStatus2=publish2.getPublishStatus();
			publishStatus2.setPublishToStroy(1);
			this.getPublishStatusService().updatePublishStatus(publishStatus2);
			storyDetail.setPublishId(tempid);
			storyDetail.setDetailContext(cxtList.get(i).toString().trim().replaceAll("\t*", ""));
			int repeat = 0;
			for (int j = 0; j < filterWords.size(); j++) {
				if (cxtList.get(i).toString().contains(filterWords.get(j).getWords())) {
					words+=filterWords.get(j).getWords()+",";
					repeat++;
				}
			}
			
			
			storyDetail.setStory(story);
			storyDetail.setWidth(publish2.getWidth());
			storyDetail.setHeight(publish2.getHeight());
			storyDetail.setSamllPic(publish2.getSmallPic());
			storyDetail.setThumbnailUrl(publish2.getThumbnailUrl());
			storyDetail.setSpecialwords(words);
			this.storyDetailService.insert(storyDetail);
		}
		
		
		List<StoryDetail> storyDetails=this.storyDetailService.showThePublishofdetais(story.getId());
		int num=0;
		int txtNum=0;
		for (int i = 0; i < storyDetails.size(); i++) {
			txtNum+=storyDetails.get(i).getDetailContext().length();
			Publish publish2=this.getPublishService().select(storyDetails.get(i).getPublishId());
			if (publish2 != null) {
				num++;
			}
		}
		story.setDetailpicNum(num);
		story.setDetailtextNum(txtNum);
		
		
		PublishStatus publishStatus2=new PublishStatus();
		publishStatus2.setUnreleased(1);
		publishStatus2.setAwaitingReview(0);
		publishStatus2.setNoPass(0);
		publishStatus2.setJustShow(0);
		publishStatus2.setOnOffer(0);
		publishStatus2.setCopyrightBuyout(0);
		publishStatus2.setUserSoldout(0);
		publishStatus2.setAdminSoldout(0);
		publishStatus2.setPublishToStroy(0);
		publishStatus2.setUserDelete(0);
		publishStatus2.setAdminDelete(0);
		publishStatus2.setPublishorstory(1);
		publishStatusService.savePublishStatus(publishStatus2);
		story.setPublishStatus(publishStatus2);
		this.storyDao.update(story);
		
		return story.getId();
	}
	public Pager storylist(Integer uid,Integer pageSize,Integer pageNo){
		
		
	     DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Story.class);
	     detachedCriteria.createAlias("publishStatus", "publishStatus");
	     detachedCriteria.add(Restrictions.eq("user.id", uid));
	     detachedCriteria.add(Restrictions.eq("publishStatus.publishorstory", 1));
	     detachedCriteria.add(Restrictions.ne("publishStatus.userDelete", 1));
		 detachedCriteria.add(Restrictions.ne("publishStatus.adminDelete", 1));
	   return storyDao.findbyDetachedCriteria(detachedCriteria,pageNo,pageSize);//
}
//	public Pager storylist(Integer uid,Integer pageSize,Integer pageNo){
//		 User user=new User();
//		 user.setId(uid);
//		 
//		 return this.storyDao.findStoryByUser(user, pageSize, pageNo);
//	}
	public Pager findStoryByUserAndSpecial(Integer user,Integer publishSpecialCat, int pageNo, int pageSize){
		User user2=new User();
		user2.setId(user);
		 PublishSpecialCat publishSpecialCat2=new PublishSpecialCat();
		 publishSpecialCat2.setId(publishSpecialCat);
		 return this.storyDao.findStoryByUserAndSpecial(user2,publishSpecialCat2,pageSize,pageNo);
	}
	public Pager searchbyspecial(Integer uid,Integer specialId,Integer pageSize,Integer pageNo){
		User user=new User();
        user.setId(uid);
        PublishSpecialCat specialCat=new PublishSpecialCat();
        specialCat.setId(specialId);
		return this.storyDao.searchbyspecial(user, specialCat, pageSize, pageNo);
	}
	
	public Integer total(Integer uId) {
		return this.storyDao.total(uId);
	}
	public String getRandomStr(){
		Random random = new Random();
		String baseStr = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuffer buffer = new StringBuffer();
		for(int i=0;i<10;i++){
			int num = random.nextInt(baseStr.length());
			buffer.append(baseStr.charAt(num));
		}
		return buffer.toString();
	}
	public Timestamp getcurrent() {
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String a=df.format(new Date());
		Timestamp ts = new Timestamp(System.currentTimeMillis());  
		ts.valueOf(a);
		return ts;
	}
	
	public PublishSpecialCat selectSpecialCat(Integer id){
		PublishSpecialCat publishSpecialCat=this.getPublishSpecialCatService().select(id);
		return publishSpecialCat;
	}
	public int picNumber(Integer id){
		List<StoryDetail> storyDetail=storyDetailService.showThePublishofdetais(id);
		int num=0;
		for (int i = 0; i < storyDetail.size(); i++) {
			Publish publish=this.getPublishService().select(storyDetail.get(i).getPublishId());
			if (publish != null) {
				num++;
			}
		}
		return num;
	}
	public int textNumber(Integer id){
		int txtNum=0;
		Story story=storyDao.select(id);
		txtNum=story.getStorydescription().length();
		List<StoryDetail> storyDetail=storyDetailService.showThePublishofdetais(id);
		for (int i = 0; i < storyDetail.size(); i++) {
			txtNum+=storyDetail.get(i).getDetailContext().length();
		}
	    return txtNum;	
	}
	
	public Story findbyStory(Integer id){
		Story story=this.storyDao.select(id);
		return story;
	}
	public List<StoryDetail> findDetailsById(Integer id){
		List<StoryDetail> storyDetails=this.storyDetailService.showThePublishofdetais(id);
		return storyDetails;
	}
	
	public List<PublishCat_Story> findStoryCat(Integer id){
		return publishCatStorySevice.list(id);
	}
	public void delstorydetailofstory(int id) {
		Story story=this.storyDao.select(id);
		List<StoryDetail> storyDetails=this.getStoryDetailService().showThePublishofdetais(story.getId());
		for (int i = 0; i < storyDetails.size(); i++) {
			Publish publish=this.getPublishService().select(storyDetails.get(i).getPublishId());
			PublishStatus publishStatus=publish.getPublishStatus();
			publishStatus.setPublishToStroy(0);
			this.getPublishStatusService().updatePublishStatus(publishStatus);
			this.getStoryDetailService().delete(storyDetails.get(i));
		}
		
	}
	
	public void delcatstory(int id) {
		List<PublishCat_Story> storycat=this.getPublishCatStorySevice().list(id);
		for (int i = 0; i < storycat.size(); i++) {
			this.getPublishCatStorySevice().delete(storycat.get(i));
		}
		
	}
	public void delstoryofcat(int catid,int storyId){
		List<PublishCat_Story> storycat=this.getPublishCatStorySevice().list(storyId);
		for (int i = 0; i < storycat.size(); i++) {
			if (storycat.get(i).getPublishCat().getId() == catid) {
				this.getPublishCatStorySevice().delete(storycat.get(i));
			}
		}
	}
	public Publish selectPublish(Integer id) {
		return publishService.select(id);
	}
	
	
	
     public Pager findbyDetachedCriteria(DetachedCriteria detachedCriteria,int pageNo,int pageSize){		 
		 
		 return storyDao.findbyDetachedCriteria(detachedCriteria,pageNo,pageSize);
	 }
     public List<Story> findbyDetached(DetachedCriteria detachedCriteria){
    	 return storyDao.findbyDetached(detachedCriteria);
     }
     
	public String findbyCountBySpecialCat(DetachedCriteria detachedCriteria){
			 return storyDao.findbyCountBySpecialCat(detachedCriteria);
		 }
	
	public List<Story> storyadminsoldoutbyspecial(Integer specialId) {
		return storyDao.storyadminsoldoutbyspecial(specialId);
	}
	
	public void adminsoldout(Integer id,Story story){
		Story story2=storyDao.select(id);
		story2.setSoldoutreason(story.getSoldoutreason());
		PublishStatus publishStatus=story2.getPublishStatus();
		publishStatus.setAdminSoldout(1);
		this.getPublishStatusService().updatePublishStatus(publishStatus);
		story2.setCheckTime(getcurrent());//下架时间
		storyDao.update(story2);
		
	}
	
	
	public List<Story> userdel(){
//		List<Story> stories=storyDao.userdel();
//		for (int i = 0; i < stories.size(); i++) {
//			this.delstorydetailofstory(stories.get(i).getId());
//			this.delcatstory(stories.get(i).getId());
//			Story story=this.getStoryDao().select(stories.get(i).getId());
//			PublishStatus publishStatus=this.getPublishStatusService().findById(stories.get(i).getId());
//			this.getPublishStatusService().deletePublishStatues(publishStatus);
//			storyDao.delete(story);
//		}
		return storyDao.userdel();
	}
	
	public List<Story> admindel(){
//		List<Story> stories=storyDao.userdel();
//		for (int i = 0; i < stories.size(); i++) {
//			this.delstorydetailofstory(stories.get(i).getId());
//			this.delcatstory(stories.get(i).getId());
//			Story story=this.getStoryDao().select(stories.get(i).getId());
//			PublishStatus publishStatus=this.getPublishStatusService().findById(stories.get(i).getId());
//			this.getPublishStatusService().deletePublishStatues(publishStatus);
//			storyDao.delete(story);
//		}
		return storyDao.admindel();
	}
	//////////设置删除操作
	/**
	 * Story story=this.storyDao.select(id);
		List<StoryDetail> storyDetails=this.getStoryDetailService().showThePublishofdetais(story.getId());
		for (int i = 0; i < storyDetails.size(); i++) {
			Publish publish=this.getPublishService().select(storyDetails.get(i).getPublishId());
			PublishStatus publishStatus=publish.getPublishStatus();
			publishStatus.setPublishToStroy(0);
			this.getPublishStatusService().updatePublishStatus(publishStatus);
			this.getStoryDetailService().delete(storyDetails.get(i));
		}
	 */
	public void userdeloperate(Integer id) {
		Story story=this.storyDao.select(id);
    	story.setDeltime(getcurrent());
    	this.storyDao.update(story);
		PublishStatus publishStatus=story.getPublishStatus();
		publishStatus.setUserDelete(1);
		this.getPublishStatusService().updatePublishStatus(publishStatus);
	}
    public void admindeloperate(Integer id) {
    	Story story=this.storyDao.select(id);
    	story.setDeltime(getcurrent());
    	this.storyDao.update(story);
		PublishStatus publishStatus=story.getPublishStatus();
		publishStatus.setAdminDelete(1);
		this.getPublishStatusService().updatePublishStatus(publishStatus);
	}
	
	///////////////////////////////////wepic 1.0//////////////////////////
	
	public boolean delete(Story record) {
		// TODO Auto-generated method stub
		return storyDao.delete(record);
	}

	public boolean delete(Integer id) {
		// TODO Auto-generated method stub
		return storyDao.delete(id);
	}

	public List<Story> findAll() {
		// TODO Auto-generated method stub
		return storyDao.findAll();
	}

	public List<Story> findPart(String strFields, String[] strArrValues) {
		// TODO Auto-generated method stub
		return storyDao.findPart(strFields, strArrValues);
	}

	public Pager findStoryByUser(User user, int pageSize, int pageNo) {
		// TODO Auto-generated method stub
		return storyDao.findStoryByUser(user, pageSize, pageNo);
	}

	public Integer insert(Story record) {
		// TODO Auto-generated method stub
		return storyDao.insert(record);
	}

	public Pager list(int pageSize, int pageNo) {
		// TODO Auto-generated method stub
		return storyDao.list(pageSize, pageNo);
	}

	public Pager list(String username, int pageSize, int pageNo) {
		// TODO Auto-generated method stub
		return storyDao.list(username, pageSize, pageNo);
	}

	public Pager list(Map<String, Object> mapSqlParam, int pageSize, int pageNo) {
		// TODO Auto-generated method stub
		return storyDao.list(mapSqlParam, pageSize, pageNo);
	}

	public Story select(Integer id) {
		// TODO Auto-generated method stub
		return storyDao.select(id);
	}

	public boolean update(Story record) {
		// TODO Auto-generated method stub
		return storyDao.update(record);
	}

	public List<Story> storybyuserandspecial(Integer uid, Integer specialId) {
		// TODO Auto-generated method stub
		return storyDao.storybyuserandspecial(uid, specialId);
	}
	public Pager listofstatu(final int pageSize,final int pageNo){
		return storyDao.listofstatu(pageSize, pageNo);
		
	}
	public List<Story> storychecksucbyspecial(Integer specialId){
		return storyDao.storychecksucbyspecial(specialId);
	}

	

	
}
