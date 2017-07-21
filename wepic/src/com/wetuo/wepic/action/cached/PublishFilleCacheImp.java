package com.wetuo.wepic.action.cached;
import java.util.ArrayList;
import java.util.List;
import com.wetuo.wepic.publish.beans.Publish;
import com.wetuo.wepic.publish.service.PublishService;
import com.tools.MemcachedUtil;

public class PublishFilleCacheImp implements FillCache {
	private String ip = "211.152.43.67";
    private int time= 60 * 60 * 24 * 7;
	private int port = 11211;
	private PublishService publishService;
	

	@SuppressWarnings("static-access")
	public Object fillCached(String key) {
		Object object = null;
		MemcachedUtil util = new MemcachedUtil();
		boolean b = util.checkedMemcachedOpen(ip, port);
		if (b) {
			try{
			object = util.getCache(ip, port, key);
			}catch (Exception e) {
				enteryCache(key);
			}

		}
		if (object == null) {
			object = enteryCache(key);

		}

		return object;
	}

	public Object enteryCache(String key) {
		if (key.equals("mainPublishs")) {

			return SethomePageMainPic(key);
		} else if (key.equals("modelWorkList")) {

			return SetmodelWorkList(key);

		} else if (key.equals("photographyList")) {

			return SetPhotographyWork(key);

		} else if (key.equals("sheyingtupian")) {

			return SetFrontFistPage(key);

		}

		return null;

	} // 推荐到首页的大图

	public List<Publish>SethomePageMainPic (String key) {
		List<Publish> mainPublishs = null;
		boolean b = MemcachedUtil.checkedMemcachedOpen(ip, port);
		mainPublishs = publishService.homePageMainPicNew();
		if (b) {
			MemcachedUtil.setCache(ip, port,time,key,mainPublishs);
		}
		return mainPublishs;
	}

	// 推荐到首页的model
	public List<Publish> SetmodelWorkList(String key) {
		List<Publish> modelWorkList = null;
		boolean b = MemcachedUtil.checkedMemcachedOpen(ip, port);
		modelWorkList = publishService.modelPic();
		if (b) {
			MemcachedUtil.setCache(ip, port, time, key,modelWorkList);
		}

		return modelWorkList;
	}

	// 推荐到首页的摄影师
	public List<Publish> SetPhotographyWork(String key) {
		List<Publish> photographyList = null;
		boolean b = MemcachedUtil.checkedMemcachedOpen(ip, port);
		photographyList = publishService.photographyPic();
		if (b) {
			MemcachedUtil.setCache(ip, port, time,key, photographyList);
		}
		// }

		return photographyList;
	}
	// 推荐到摄影图片和创意图片
@SuppressWarnings("unchecked")
public List<Publish> SetFrontFistPage(String key){
	boolean b = MemcachedUtil.checkedMemcachedOpen(ip, port);
		String type="sheyingtuypian";
		int pageNO=1;
		int pageSize=3;
			List publishlist=new ArrayList<List<Publish>>();
			List<Publish> list=publishService.selectByFrontPage(type,pageNO,pageSize);
			publishlist.add(list);
			 type="chuangyitupian";
			 List<Publish> list1=publishService.selectByFrontPage(type,pageNO,pageSize);
			  publishlist.add(list1);
			if(b){
				MemcachedUtil.setCache(ip, port,time, key,publishlist);
			}
			return publishlist;
			
		}




			  public PublishService getPublishService() {
				return publishService;
			}
			
			public void setPublishService(PublishService publishService) {
				this.publishService = publishService;
			}



   






}


