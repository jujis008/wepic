package com.wetuo.wepic.publish.service ;
 
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.swing.ImageIcon;

import org.apache.commons.io.FileUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import net.coobird.thumbnailator.Thumbnails;

import com.opensymphony.xwork2.ActionContext;
import com.tools.Cleandar;
import com.wetuo.wepic.publish.beans.CutImg;
import com.wetuo.wepic.publish.beans.Publish;
import com.wetuo.wepic.publish.beans.PublishCat;
import com.wetuo.wepic.publish.beans.PublishCat_Publish;
import com.wetuo.wepic.publish.beans.PublishSpecialCat;
import com.wetuo.wepic.publish.beans.PublishStatus;
import com.wetuo.wepic.publish.dao.PublishDao;
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.util.PropertiesRead;
import com.wetuo.wepic.common.util.UploadUtils;
import com.wetuo.wepic.core.beans.RoleTags;
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.core.service.MessageService;
import com.wetuo.wepic.core.service.SiteConfigService;
import com.wetuo.wepic.core.service.UserCatService;
import com.wetuo.wepic.core.service.UserCreditService;
import com.wetuo.wepic.core.service.UserService;
import com.wetuo.wepic.deal.service.BuyAccountOperationService;
import com.wetuo.wepic.deal.service.BuyCartDealService;
import com.wetuo.wepic.deal.service.BuyCommoditiesService;
import common.quickvalid.validators.float_range;
 
public class PublishServiceImpl implements PublishService {
	PublishDao domainDao;
	///////////////wepic2.0///////////////
	private PublishSpecialCatService publishSpecialCatService;
	private PublishCatService publishCatService;
	private AssessComplaintService assessComplaintService;
	private UserService userService;
	private MessageService messageService;
	private UserCatService userCatService;
	private PublishCat_PublishService catPublishService;
	private BuyCommoditiesService buyCommoditiesService;
	private BuyAccountOperationService buyAccountOperationService;
	private BuyCartDealService buyCartDealService;
	private UserCreditService creditService;
	private SiteConfigService siteConfigService;
	private PublishStatusService publishStatusService;
	///////////////////////getter setter/////////////////////
	public PublishSpecialCatService getPublishSpecialCatService() {
		return publishSpecialCatService;
	}
	public void setPublishSpecialCatService(
			PublishSpecialCatService publishSpecialCatService) {
		this.publishSpecialCatService = publishSpecialCatService;
	}
	public PublishCatService getPublishCatService() {
		return publishCatService;
	}
	public void setPublishCatService(PublishCatService publishCatService) {
		this.publishCatService = publishCatService;
	}
	public AssessComplaintService getAssessComplaintService() {
		return assessComplaintService;
	}
	public void setAssessComplaintService(
			AssessComplaintService assessComplaintService) {
		this.assessComplaintService = assessComplaintService;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public MessageService getMessageService() {
		return messageService;
	}
	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}
	public UserCatService getUserCatService() {
		return userCatService;
	}
	public void setUserCatService(UserCatService userCatService) {
		this.userCatService = userCatService;
	}
	public PublishCat_PublishService getCatPublishService() {
		return catPublishService;
	}
	public void setCatPublishService(PublishCat_PublishService catPublishService) {
		this.catPublishService = catPublishService;
	}
	public BuyCommoditiesService getBuyCommoditiesService() {
		return buyCommoditiesService;
	}
	public void setBuyCommoditiesService(BuyCommoditiesService buyCommoditiesService) {
		this.buyCommoditiesService = buyCommoditiesService;
	}
	public BuyAccountOperationService getBuyAccountOperationService() {
		return buyAccountOperationService;
	}
	public void setBuyAccountOperationService(
			BuyAccountOperationService buyAccountOperationService) {
		this.buyAccountOperationService = buyAccountOperationService;
	}
	public BuyCartDealService getBuyCartDealService() {
		return buyCartDealService;
	}
	public void setBuyCartDealService(BuyCartDealService buyCartDealService) {
		this.buyCartDealService = buyCartDealService;
	}
	public UserCreditService getCreditService() {
		return creditService;
	}
	public void setCreditService(UserCreditService creditService) {
		this.creditService = creditService;
	}
	public SiteConfigService getSiteConfigService() {
		return siteConfigService;
	}
	public void setSiteConfigService(SiteConfigService siteConfigService) {
		this.siteConfigService = siteConfigService;
	}
	public PublishDao getPublishDao() {
		return domainDao;
	}//
	public void setPublishDao(PublishDao  domainDao) {
		this.domainDao = domainDao;
	}//
	public String uploadOpus(HttpServletRequest request) {
		domainDao.ChangeImage();
		return null;
	}
	public String uploadOpus(HttpServletRequest request, File upfile,String upfileFileName,Publish publish){
		String path=uploadImg(request, upfile, upfileFileName);
		File file=new File(path.split(",")[1]);
		long filelength=file.length();
		if(filelength>(1024*1024)){
			float size=(float) filelength/(1024*1024);
			DecimalFormat decimalFormat=new DecimalFormat("##0.00");
			size=Float.parseFloat(decimalFormat.format(size));
			publish.setSize(size);
		}else{
			float f=(float)filelength/(1024*1024);
			DecimalFormat decimalFormat=new DecimalFormat("##0.00");
			f=Float.parseFloat(decimalFormat.format(f));
			publish.setSize(f);
		}
		
		
		UploadUtils uploadUtils=new UploadUtils();
		if(UploadUtils.getFileType(file.getName()).equals("tif")||UploadUtils.getFileType(file.getName()).equals("tiff")){
			try {
				String tifcov=UploadUtils.convert(file.getAbsolutePath());
				file=new File(tifcov);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		publish.setLogo("1");
		String fileType=UploadUtils.getFileType(file.getName());
		if(uploadUtils.checkFiletype(fileType)){
			
		String sytem=uploadUtils.createSmalldrawUrl(file);
		String sytem2=uploadUtils.createThumbnailUrl(file);
		String sytem3=uploadUtils.createThumbnailUrl125(file);
		publish.setSmallPic(sytem);
		publish.setThumbnailUrl(sytem2);
		publish.setThumbnail125(sytem3);
		
		BufferedImage bufferedImage = null;
		try {
			bufferedImage = ImageIO.read(new FileInputStream(file));
			publish.setHeight(bufferedImage.getHeight());
			publish.setWidth(bufferedImage.getWidth());
			publish.setLogo("0");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		PublishStatus publishStatus=new PublishStatus();
		
		publishStatus.setAdminDelete(0);
		publishStatus.setAdminSoldout(0);
		publishStatus.setAwaitingReview(0);
		publishStatus.setCopyrightBuyout(0);
		publishStatus.setJustShow(0);
		publishStatus.setNoPass(0);
		publishStatus.setOnOffer(0);
		publishStatus.setPass(0);
		publishStatus.setPublishorstory(0);
		//publishStatus.setOnOffer(0);
		publishStatus.setPublishToStroy(0);
		publishStatus.setUnreleased(0);
		publishStatus.setUserDelete(0);
		publishStatus.setUserSoldout(0);
		publishStatusService.savePublishStatus(publishStatus);
		
		
		fileType  = fileType.substring(0,1).toUpperCase()+fileType.substring(1);
		publish.setPicMode(fileType);
        publish.setName(upfileFileName.substring(0,upfileFileName.lastIndexOf(".")-1));
		publish.setStatus(0);
		publish.setPublishStatus(publishStatus);
		publish.setOriginalPic(path.split(",")[1]);
		
		
		publish.setHit(0);
		
        //publish.setPublishSpecialCat(publishSpecialCat)
		publish.setUpTime(Cleandar.getTime(new Date()));
		domainDao.insert(publish);
		publish.setPicNumber("0"+(10000+publish.getId()));
		
		domainDao.update(publish);
		
		
	    return path;
}
	
	public String uploadOpusOfStory(HttpServletRequest request, File upfile,String upfileFileName,Publish publish){
		String path=uploadImg(request, upfile, upfileFileName);
		File file=new File(path.split(",")[1]);
		long filelength=file.length();
		if(filelength>(1024*1024)){
			int size=(int) (filelength/(1024*1024));
			publish.setSize(size);
		}else{
			publish.setSize(0);
			
			
		}
		
		
		UploadUtils uploadUtils=new UploadUtils();
		if(UploadUtils.getFileType(file.getName()).equals("tif")||UploadUtils.getFileType(file.getName()).equals("tiff")){
			try {
				String tifcov=uploadUtils.convert(file.getAbsolutePath());
				file=new File(tifcov);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		publish.setLogo("1");
		String fileType=UploadUtils.getFileType(file.getName());
		if(uploadUtils.checkFiletype(fileType)){
			
		String sytem=uploadUtils.createSmalldrawUrl(file);
		String sytem2=uploadUtils.createThumbnailUrl(file);
		String sytem3=uploadUtils.createThumbnailUrl125(file);
		String cut=uploadUtils.createCutPic(file);
		publish.setSmallPic(sytem);
		publish.setThumbnailUrl(sytem2);
		publish.setThumbnail125(sytem3);
		publish.setSmallDrawCut(cut);
		BufferedImage bufferedImage = null;
		try {
			bufferedImage = ImageIO.read(new FileInputStream(file));
			publish.setHeight(bufferedImage.getHeight());
			publish.setWidth(bufferedImage.getWidth());
			publish.setLogo("0");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		PublishStatus publishStatus=new PublishStatus();
		
		publishStatus.setAdminDelete(0);
		publishStatus.setAdminSoldout(0);
		publishStatus.setAwaitingReview(0);
		publishStatus.setCopyrightBuyout(0);
		publishStatus.setJustShow(0);
		publishStatus.setNoPass(0);
		publishStatus.setOnOffer(0);
		//publishStatus.setOnOffer(0);
		publishStatus.setPublishToStroy(0);
		publishStatus.setUnreleased(0);
		publishStatus.setUserDelete(0);
		publishStatus.setUserSoldout(0);
		publishStatusService.savePublishStatus(publishStatus);
		
		
		
		publish.setPicMode(fileType);
        publish.setName(upfileFileName);
		publish.setStatus(0);
		publish.setPublishStatus(publishStatus);
		publish.setOriginalPic(path.split(",")[1]);
		
		
		publish.setHit(0);
		
        //publish.setPublishSpecialCat(publishSpecialCat)
		publish.setUpTime(Cleandar.getTime(new Date()));
		domainDao.insert(publish);
		publish.setPicNumber("0"+(10000+publish.getId()));
		
		domainDao.update(publish);
		
		
	    return path;
}
	
	@SuppressWarnings("deprecation")
	public String uploadSimpleSmall(int id,File file,HttpServletRequest request,String upfileFileName){
		Publish publish=domainDao.select(id);
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String name1 = format.format(date);
		String originalPath=request.getRealPath("/temImg");
		//String baseName = getRandomStr();
		String picType = upfileFileName.substring(upfileFileName.lastIndexOf(".")+1);
		//原图(不显示，存在数据库中)
		String picName = name1+"."+picType;//图片名称
		File target=new File(originalPath,picName);
		UploadUtils uploadUtils=new UploadUtils();
		uploadUtils.copyFile(file,target);
		//UploadUtils uploadUtils=new UploadUtils();
		String sytem=uploadUtils.createSmalldrawUrl(target);
		String sytem2=uploadUtils.createThumbnailUrl(target);
		String sytem3=uploadUtils.createThumbnailUrl125(target);
		publish.setSmallPic(sytem);
		publish.setThumbnailUrl(sytem2);
		publish.setThumbnail125(sytem3);
		publish.setLogo("2");
		
		BufferedImage bufferedImage = null;
		try {
			bufferedImage = ImageIO.read(new FileInputStream(new File(uploadUtils.getPathFizx())));
			publish.setHeight(bufferedImage.getHeight());
			publish.setWidth(bufferedImage.getWidth());
			//publish.setLogo("0");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		domainDao.update(publish);
		
		
		
		return "uploadSimpleSmall";
	}
	
	
	
	
	
	
	
	
	
	@SuppressWarnings("deprecation")
	public String uploadImg(HttpServletRequest request,File upfile,String upfileFileName){
		//publishwish=publishwish1;
		String resPath="";
		String retuenPath = null;
		try{
			//HttpServletRequest request=super.getRequest();
			//获取项目根目录
			String path=request.getContextPath();
			//当前访问项目的urlhttp://hehaixia1314.xicp.net:23512/photography/
			String basePath=request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+path + "/";
			//(取得上传的目录
			/**
			 * "Java\\apache-tomcat-6.0.26\\webapps\\photography\\uploadImag"
			 */
			//String targetDirectory = request.getRealPath("/storage/wepicimages/wepic");
			String currentAbsoulutePath=Thread.currentThread().getContextClassLoader().getResource("").getPath();
	        PropertiesRead readPro = new PropertiesRead(currentAbsoulutePath+"picpath.properties");//相对路径
	        String originalPro = readPro.getValue("original");//以下读取properties文件的值
	        String topOriginalFile=originalPro;
	        String weboriginal=readPro.getValue("weboriginal");
	        
			
			Calendar c=Calendar.getInstance();
			int currentYear=c.get(Calendar.YEAR); 
			int currentMonth=c.get(Calendar.MONTH)+1;
			int currentDay=c.get(Calendar.DATE);
			
			File originalYearFile=new File(topOriginalFile+"/"+currentYear);
			File originalMonthFile=new File(topOriginalFile+"/"+currentYear+"/"+currentMonth);
			File originalDayFile=new File(topOriginalFile+"/"+currentYear+"/"+currentMonth+"/"+currentDay);
			if (!originalYearFile.exists() && !originalYearFile.isDirectory()) {
				originalYearFile.mkdir();
			}
			if (!originalMonthFile.exists()) {
				originalMonthFile.mkdir();
			}
			if (!originalDayFile.exists()) {
				originalDayFile.mkdir();
			}
			String originalPath=originalDayFile.getPath();
			
			
			Date date = new Date();
			DateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
			String name1 = format.format(date);
			
			//String baseName = getRandomStr();
			String picType = upfileFileName.substring(upfileFileName.lastIndexOf(".")+1);
			//原图(不显示，存在数据库中)
			String picName = name1+"."+picType;//图片名称
			File target=new File(originalPath,picName);
			UploadUtils uploadUtils=new UploadUtils();
			uploadUtils.copyFile(upfile,target);
			ImageIcon img= new ImageIcon(originalPath);
			int width= img.getIconWidth();
			int height= img.getIconHeight();
			resPath = weboriginal+"/"+currentYear+"/"+currentMonth+"/"+currentDay+"/"+picName;
			retuenPath=resPath+","+originalPath+"/"+picName;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return retuenPath;
	}
	
	
	 public String findbyCountBySpecialCat(DetachedCriteria detachedCriteria){
		 
		 
		 
		 return domainDao.findbyCountBySpecialCat(detachedCriteria);
		 
	 }
	 public Pager findbyDetachedCriteria(DetachedCriteria detachedCriteria,int pageNo,int pageSize){		 
		 
		 return domainDao.findbyDetachedCriteria(detachedCriteria,pageNo,pageSize);
	 }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//附件上传
	//文件上传 之附件上传
		public String uploadFile(File myfile,String savePath,String httpPath,String fileName) throws Exception{
			//clearErrorsAndMessages();
			InputStream is = new FileInputStream(myfile);
			//设置文件上传的位置
			String uploadPath = savePath;//ServletActionContext.getServletContext().getRealPath("/bidForOpus");
			System.out.println("文件位置："+uploadPath);
			//System.out.println("服务器路径："+ServletActionContext.getRequest().getRealPath("/uploadImag"));
			
			//HttpServletRequest request = ServletActionContext.getRequest();
			//String path = request.getContextPath();
			String basePath = httpPath;//request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
			//System.out.println("path:"+path);
			System.out.println("basePath:"+basePath);
			//设置目标文件
			
			
			Date date = new Date();
			DateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
			String picType = fileName.substring(fileName.lastIndexOf(".")+1);
			//String randomStr = getRandomStr();
			String picName = format.format(date)+"."+picType;
			File toFile = new File(uploadPath,picName);
			//创建一个输出流
			OutputStream os = new FileOutputStream(toFile);
			byte[] buffer = new byte[1024];
			int length = 0;
			while((length = is.read(buffer)) >0){
				os.write(buffer, 0, length);
			}
			is.close();
			os.close();
			String resPath = basePath+"/back/personalCentr/bid/accessories/"+picName;
			return resPath+","+fileName+","+picName;
		}
	
	//用户自定义缩略图
	public void ChangeImg(CutImg cutImg, File file, int id){
		
		UploadUtils uploadUtils=new UploadUtils();
        String path285=uploadUtils.UsercreateThumbnailUrl(file,cutImg);
        String path125=uploadUtils.userCreateThumbnailUrl125(file,cutImg);
        Publish publish=domainDao.select(id);
        String thumpath258=publish.getThumbnailUrl();
        String thumbnail=uploadUtils.getSaveAndWebPath("thumbnail");
        String[] paths=thumpath258.split("thumbnail");
        File deleteFile=new File(thumbnail+"/"+paths[1]);
        if(deleteFile.exists()){
        	deleteFile.delete();
        }

        
        String thumpath125=publish.getThumbnail125();
        String thumbnail125=uploadUtils.getSaveAndWebPath("thumbnail125");
        String[] paths125=thumpath125.split("thumbnail125");
        File deleteFile125=new File(thumbnail125+"/"+paths125[1]);
        if(deleteFile125.exists()){
        	deleteFile125.delete();
        }
        publish.setThumbnailUrl(path285);
        publish.setThumbnail125(path125);
        domainDao.update(publish);
        
	}
	
	
	//////////////wepic2.0///////////////////////////////////////////////////////////////////////////
	
	public List<Publish> worklibrary(Integer uid) {
	    User user=new User();
	    user.setId(uid);
	    List<Publish>  imgChangeList= this.domainDao.findpublishByUser2(user);
	    List<Publish> newlist=new ArrayList<Publish>();
	    for (Publish publish : imgChangeList) {
	          PublishStatus publishStatus=publishStatusService.findById(publish.getPublishStatus().getId());
	          publish.setPublishStatus(publishStatus);
	          newlist.add(publish); 
			}
		return imgChangeList;
	}
	public String findthumbnailbyId(Integer id) {
		Publish publish=this.domainDao.select(id);
		return publish.getThumbnailUrl();
	}
	
	
	public String findthumbnailbyId2(Integer id) {
		Publish publish=this.domainDao.select(id);
		return publish.getThumbnail125();
	}
	
	public String createcutpic(Integer id){
		Publish publish=this.domainDao.select(id);
		String  origin=publish.getOriginalPic();
		File upfile=new File(origin);
		UploadUtils uploadUtils=new UploadUtils();
		String cutpath=uploadUtils.createCutPic(upfile);
		publish.setSmallDrawCut(cutpath);
		domainDao.update(publish);
		return cutpath;
	}
	public Publish findById(Integer id) {
		//Publish publish=
		return this.domainDao.select(id);
	}
	
	
	
	
	public Pager findpublishByUser(User user, int pageSize, int pageNo) {
		// TODO Auto-generated method stub
		Pager pager=domainDao.findpublishByUser(user, pageSize, pageNo);
		List <Publish> list=(List<Publish>)pager.getResultList();
		List<Publish> newlist=new ArrayList<Publish>();
		for (Publish publish : list) {
          PublishStatus publishStatus=publishStatusService.findById(publish.getPublishStatus().getId());
          publish.setPublishStatus(publishStatus);
          newlist.add(publish);
		}
		pager.setResultList(newlist);
		return pager;
	}
	
	public Pager findPublishBySpcialCat(int userId,int pageSize,int pageNo){
		
		
		     DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Publish.class);
		     PublishSpecialCat publishCat=publishSpecialCatService.selectByName("isDefault");
		     detachedCriteria.createAlias("publishStatus", "publishStatus");
		     detachedCriteria.add(Restrictions.eq("user.id", userId));
		     detachedCriteria.add(Restrictions.eq("publishSpecialCat.id", publishCat.getId()));
		     //detachedCriteria.add(Restrictions.eq("publishSpecialCat.id", publishCat.getId()));
		     //  detachedCriteria.add(Restrictions.not(Restrictions.eq("publishStatus.adminSoldout", 1)));
				detachedCriteria.add(Restrictions.not(Restrictions.eq("publishStatus.userDelete", 1)));
				detachedCriteria.add(Restrictions.not(Restrictions.eq("publishStatus.adminDelete", 1)));
				Pager pager=domainDao.findbyDetachedCriteria(detachedCriteria,pageNo,pageSize);//
			  List<Publish> listPublish=(List<Publish>)pager.getResultList();
			    for (Publish publish : listPublish) {
				 String reson=publish.getNotPassedCause();
					List list=new ArrayList<String>();
					if(reson!=null&&!reson.trim().equals("")){
						String[] resons=reson.split(",");
						for (String string : resons) {
							if(string.equals("1")){
								list.add("您上传的证件不清晰");
								
							}
							else if(string.equals("2")) {
								list.add("证件照片有改动");
								
							}
							else if(string.equals("3")) {
								list.add("您提交的身份信息不正确");
								
							}
							else {
								list.add(string);
								
							}
							
						}
						
						
						
					}
					publish.setResons(list);
				 
				
			}
	       
		   return pager;//domainDao.findbyDetachedCriteria(detachedCriteria,pageNo,pageSize);//
		
		
		
		
		
	}
	
	
	
	
	
	
//////////////wepic1.0////////////////
	public List<Publish> findByPublishSpecialIdReadOnly( PublishSpecialCat publishSpecialCat){
		return domainDao.findByPublishSpecialIdReadOnly(publishSpecialCat);
	}
	public List<Publish> findUserOfPublishReadOnly(User user){
		return domainDao.findUserOfPublishReadOnly(user);
	}
	public List<Publish> findUserOfPublish(User user){
		return domainDao.findUserOfPublish(user);
	}
	public List<Publish> findAll(){ 
		return domainDao.findAll();
	}
	
	public List<Publish> findPart(String strFields, String[] arrStrValues){ 
		return domainDao.findPart(strFields,arrStrValues);
	}
	
	public Pager list(int pageSize, int pageNo)  {
		return domainDao.list(pageSize,pageNo);
	}//end list()
	
	public Pager list(String username, int pageSize, int pageNo)  {
		return domainDao.list(username,pageSize,pageNo);
	}//end list()
	
	public Pager list(Map<String,Object> mapSqlParam, int pageSize, int pageNo)  {
		return domainDao.list(mapSqlParam,pageSize,pageNo);
	}//end list()
	
	/////insert///
	public Integer insert(Publish record) {
		return domainDao.insert(record) ;
	}//end insert()
			
	/////delete///
	public boolean delete(Publish record)  {
		
		domainDao.delete(record);
		
		return publishStatusService.deletePublishStatues(record.getPublishStatus());
	}//end delete()
			
	public boolean delete(Integer id)  {
		return domainDao.delete(id);
	}//end delete()
	
	/////update///
	public boolean update(Publish record){
		PublishStatus publishStatus= publishStatusService.findById(record.getPublishStatus().getId());
		int wish=record.getPublishwish();
		
		if(wish!=0){
			//可销售
		if(wish==1){
		if(publishStatus.getJustShow()==1){
			publishStatus.setOnOffer(1);
			publishStatus.setJustShow(0);
			publishStatus.setNoPass(0);
			publishStatus.setPass(0);
			}else{
			publishStatus.setOnOffer(1);
            }
		
			
		}//仅展示
		else if(wish==2){
			
			publishStatus.setJustShow(1);
			//if(publishStatus.getOnOffer()==1){
			 publishStatus.setOnOffer(0);
			// }
			
		}
		if(publishStatus.getUnreleased()==0){
		   record.setPublishTime(new Timestamp(new Date().getTime()));
//			publishStatus.setOnOffer(1);
//			publishStatus.setJustShow(0);
			publishStatus.setNoPass(0);
		}
		publishStatus.setUnreleased(1);
		
		}
		
		publishStatusService.updatePublishStatus(publishStatus);
		record.setPublishStatus(publishStatus);
		return domainDao.update(record);
	}//end update()
	
	//标记删除
	public void  deleteUpdate(Publish publish){
		domainDao.update(publish);
		publishStatusService.updatePublishStatus(publish.getPublishStatus());
		
		
		
	}
			
	public boolean updateCut(Publish record){
		return domainDao.update(record);
	}
	/////select///
	public Publish select(Integer id)  {
		
		Publish publish=domainDao.select(id);
		publish.setTypeName("摄影图片");//(type)
		if(publish.getType()!=null){
		if(publish.getType()==2){
			publish.setTypeName("创意图片");//(type)
		}
		}
		PublishStatus publishStatus=publishStatusService.findById(publish.getPublishStatus().getId());
		publish.setPublishStatus(publishStatus);
		String str=publish.getTags();
		if(str!=null){
		 
    	 String[] tagsArray=str.split(" ");
    	 List<RoleTags> listTags=new ArrayList<RoleTags>();
    	 for (String string : tagsArray) {
    		 if(!string.trim().equals("")){
    		 RoleTags roleTags=new RoleTags();
    		 roleTags.setTag(string);
    		 listTags.add(roleTags);
    		 }
  		// System.out.println(string+"==xxx================================");
		}
    	 publish.setRoleTags(listTags);
		}
    	 if(publish.getPublishSpecialCat().getId()!=null){
    		
    	 PublishSpecialCat specialCat= publishSpecialCatService.select(publish.getPublishSpecialCat().getId());
    	 specialCat.setUser(null);
    	 specialCat.setPublishSet(null);
    	 specialCat.setStorySet(null);
    	 publish.setPublishSpecialCat(specialCat);
    	 }
    	 
    	 
//    	 List<PublishCat> publishCats=publishCatService.getPublishCatListUnderPid(0);
//    	 int catId = 0;
//    	 String type="photography";
//    	 if(publish.getType()!=null&&publish.getType()==2){
//    		 type="originality";
//    		 
//    	 }
//    	 
//    	 
//    	 for (PublishCat publishCat : publishCats) {
//   			if(publishCat.getType().equals(type)){
//   				catId=publishCat.getId();
//   				break;
//   			}
//       	 
//    	 }
    	 
    	 
    	 
    	 
    	 
    //	List<PublishCat> publishChiledCats=publishCatService.getPublishCatListUnderPid(catId); 
    	
//    	 List<PublishCat>   publishCats=new ArrayList<PublishCat>();
//     	List<PublishCat_Publish> list=catPublishService.list(publish.getId());
//     	for (PublishCat_Publish publishCatPublish : list) {
//     	PublishCat publishCat=publishCatService.select(publishCatPublish.getPublishCat().getId());
//     		publishCats.add(publishCat);
// 		}   	 
//     	publish.setPublishCats(publishCats);
     	
     	
		return publish;
	}//end select()
	//查看待审核的作品
	public Pager adminCheckPhotoPic(int pageNo,int pageSize){
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Publish.class);
		detachedCriteria.createAlias("publishStatus", "publishStatus");
		detachedCriteria.add(Restrictions.eq("publishStatus.unreleased", 1));
		detachedCriteria.add(Restrictions.eq("publishStatus.noPass", 0));
		detachedCriteria.add(Restrictions.eq("publishStatus.pass", 0));	
		Pager old=domainDao.findbyDetachedCriteria(detachedCriteria, pageNo, pageSize);
		List<Publish> oldlist=(List<Publish>)old.getResultList();
		for (Publish publish : oldlist) {
			User user=publish.getUser();
			String work=user.getWorkPlace();
			if(work!=null&&!work.trim().equals("")){
			if(work.contains("北京")){
				user.setWorkPlace("北京");
				publish.setUser(user);
				continue;
			}
			else if(work.contains("上海")){
				user.setWorkPlace("上海");
				continue;
			}
			
			else if(work.contains("重庆")){
				user.setWorkPlace("重庆");
				continue;
			}
			else if(work.contains("天津")){
				user.setWorkPlace("天津");
                  continue;
			}
			}
			if(work!=null&&!work.trim().equals("")){
				String[] works=work.split(" ");
				
				if(works.length>2){
					user.setWorkPlace(works[1]);
					
					
				}
			}
//		String role=user.getRole();
//		System.out.println(user.getUserCat().getName());

			
		}
		
		
		
		return old;
	}
	
	
	
	
	
	//通过审核的作品
	public Pager adminPassPhotoPic(int pageNo,int pageSize){
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Publish.class);
		detachedCriteria.createAlias("publishStatus", "publishStatus");
		detachedCriteria.add(Restrictions.eq("publishStatus.unreleased", 1));
		detachedCriteria.add(Restrictions.eq("publishStatus.noPass", 0));
		detachedCriteria.add(Restrictions.eq("publishStatus.pass", 1));	
		detachedCriteria.add(Restrictions.not(Restrictions.eq("publishStatus.adminSoldout", 1)));	
		Pager old=domainDao.findbyDetachedCriteria(detachedCriteria, pageNo, pageSize);
		List<Publish> oldlist=(List<Publish>)old.getResultList();
		for (Publish publish : oldlist) {
			User user=publish.getUser();
			String work=user.getWorkPlace();
			if(work.contains("北京")){
				user.setWorkPlace("北京");
				publish.setUser(user);
				continue;
			}
			else if(work.contains("上海")){
				user.setWorkPlace("上海");
				continue;
			}
			
			else if(work.contains("重庆")){
				user.setWorkPlace("重庆");
				continue;
			}
			else if(work.contains("天津")){
				user.setWorkPlace("天津");
                  continue;
			}
			
			if(work!=null&&!work.trim().equals("")){
				String[] works=work.split(" ");
				
				if(works.length>2){
					user.setWorkPlace(works[1]);
					
					
				}
			}
//		String role=user.getRole();
//		System.out.println(user.getUserCat().getName());

			
		}
		
		
		
		return old;
	}
	
	
	
	
	//未通过审核的作品列表
	public Pager adminNoPassPhotoPicList(int pageNo,int pageSize){
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Publish.class);
		detachedCriteria.createAlias("publishStatus", "publishStatus");
		detachedCriteria.add(Restrictions.eq("publishStatus.unreleased", 1));
		detachedCriteria.add(Restrictions.eq("publishStatus.noPass", 1));
		detachedCriteria.add(Restrictions.eq("publishStatus.pass", 0));	
		Pager old=domainDao.findbyDetachedCriteria(detachedCriteria, pageNo, pageSize);
		List<Publish> oldlist=(List<Publish>)old.getResultList();
		for (Publish publish : oldlist) {
			User user=publish.getUser();
			String work=user.getWorkPlace();
			if(work.contains("北京")){
				user.setWorkPlace("北京");
				publish.setUser(user);
				continue;
			}
			else if(work.contains("上海")){
				user.setWorkPlace("上海");
				continue;
			}
			
			else if(work.contains("重庆")){
				user.setWorkPlace("重庆");
				continue;
			}
			else if(work.contains("天津")){
				user.setWorkPlace("天津");
                  continue;
			}
			
			if(work!=null&&!work.trim().equals("")){
				String[] works=work.split(" ");
				
				if(works.length>2){
					user.setWorkPlace(works[1]);
					
					
				}
			}
			
			String reson=publish.getNotPassedCause();
			List list=new ArrayList<String>();
			if(reson!=null&&!reson.trim().equals("")){
				String[] resons=reson.split(",");
				for (String string : resons) {
					if(string.equals("1")){
						list.add("您上传的证件不清晰");
						
					}
					else if(string.equals("2")) {
						list.add("证件照片有改动");
						
					}
					else if(string.equals("3")) {
						list.add("您提交的身份信息不正确");
						
					}
					else {
						list.add(string);
						
					}
					
				}
				
				
				
			}
			publish.setResons(list);

			
		}
		
		
		
		return old;
	}
	//用户下架
	public void userSoldout(int id){
	 Publish publish=domainDao.select(id);
	 int statid=publish.getPublishStatus().getId();
	 PublishStatus publishStatus= publishStatusService.findById(statid);
	 publishStatus.setUserSoldout(1);
     publishStatusService.updatePublishStatus(publishStatus);	
		//return "userSoldout";
	}
	//审核通过作品
	public boolean adminPassPhoto(int id,int userId){
		Publish publish=domainDao.select(id);
		PublishStatus publishStatus=publishStatusService.findById(publish.getPublishStatus().getId());
		publishStatus.setPass(1);
		publishStatus.setNoPass(0);
		User user=new User();
		user.setId(userId);
		publish.setAdmin(user);
		domainDao.update(publish);
		publishStatusService.updatePublishStatus(publishStatus);
	     
		return  false;
		
	}
	
	//审核不通过的作品
	public boolean adminNoPassPhoto(int id,int userId,String noPassreason){
		
		Publish publish=domainDao.select(id);
		PublishStatus publishStatus=publishStatusService.findById(publish.getPublishStatus().getId());
		publishStatus.setPass(0);
		publishStatus.setNoPass(1);
		
		publish.setNotPassedCause(noPassreason);
		User user=new User();
		user.setId(userId);
		publish.setAdmin(user);
		domainDao.update(publish);
		publishStatusService.updatePublishStatus(publishStatus);
		return  false;
	}
	//直接删除作品
	public boolean adminDeletePic(int id){
		
		 UploadUtils uploadUtils=new UploadUtils();
    	 //Publish publish=(Publish)model;
    	 Publish deletPub= domainDao.select(id);
    	 PublishStatus publishStatus=publishStatusService.findById(deletPub.getPublishStatus().getId());
    	 
    	deletPub.setDeleteTime(new Timestamp(new Date().getTime()));
    	publishStatus.setAdminDelete(1);
    	domainDao.update(deletPub);
    	publishStatusService.updatePublishStatus(publishStatus);
   
//    	 uploadUtils.deleteFile(deletPub.getSmallPic(), "small");
//    	 uploadUtils.deleteFile(deletPub.getThumbnailUrl(),"thumbnail");
//    	 uploadUtils.deleteFile(deletPub.getThumbnail125(),"thumbnail125");
//    	 File file=new File(deletPub.getOriginalPic());
//    	 if(file.exists()){
//    		 file.delete();
//    		 
//    	 }
//    	 
//    	domainDao.delete(deletPub);
//    	 publishStatusService.deletePublishStatues(publishStatus); 
		return false;
	}
	

	
	
	//已下架的图片
	public Pager adminUndercarriageList(int pageNo,int pageSize){
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Publish.class);
		detachedCriteria.createAlias("publishStatus", "publishStatus");
		//detachedCriteria.add(Restrictions.eq("publishStatus.unreleased", 1));
		//detachedCriteria.add(Restrictions.eq("publishStatus.noPass", 0));
		detachedCriteria.add(Restrictions.eq("publishStatus.adminSoldout", 1));	
		Pager old=domainDao.findbyDetachedCriteria(detachedCriteria, pageNo, pageSize);
		List<Publish> oldlist=(List<Publish>)old.getResultList();
		for (Publish publish : oldlist) {
			User user=publish.getUser();
			String work=user.getWorkPlace();
			if(work.contains("北京")){
				user.setWorkPlace("北京");
				publish.setUser(user);
				continue;
			}
			else if(work.contains("上海")){
				user.setWorkPlace("上海");
				continue;
			}
			
			else if(work.contains("重庆")){
				user.setWorkPlace("重庆");
				continue;
			}
			else if(work.contains("天津")){
				user.setWorkPlace("天津");
                  continue;
			}			
			if(work!=null&&!work.trim().equals("")){
				String[] works=work.split(" ");
				
				if(works.length>2){
					user.setWorkPlace(works[1]);
					
					
				}
			}
			String reson=publish.getNotPassedCause();
			List list=new ArrayList<String>();
			if(reson!=null&&!reson.trim().equals("")){
				String[] resons=reson.split(",");
				for (String string : resons) {
					if(string.equals("1")){
						list.add("您上传的证件不清晰");
						
					}
					else if(string.equals("2")) {
						list.add("证件照片有改动");
						
					}
					else if(string.equals("3")) {
						list.add("您提交的身份信息不正确");
						
					}
					else {
						list.add(string);
						
					}
					
				}
				
				
				
			}
			publish.setResons(list);

			
		}
		
		
		
		
		return old;
	}
	
	
	public String adminUndercarriage(int id,String reson,User user){
		
    Publish publish=domainDao.select(id);
    PublishStatus publishStatus=publishStatusService.findById(publish.getPublishStatus().getId());
    publishStatus.setAdminSoldout(1);
//    publishStatus.setJustShow(0);
//    publishStatus.setOnOffer(0);
   // publishStatus.setPass(0);
  //  publishStatus.set
    publish.setNotPassedCause(reson);
    publishStatusService.updatePublishStatus(publishStatus);
    
    publish.setAdmin(user);
    domainDao.update(publish);
	return "adminUndercarriage";
	}
	
	
	
	
	public Pager listUnderCat(Integer catId, int pageSize, int pageNo) {
		// TODO Auto-generated method stub
		return domainDao.listUnderCat(catId, pageSize, pageNo);
	}
	public Pager listUnderCatCurrentUser(Integer catId, String username,
			int pageSize, int pageNo) {
		// TODO Auto-generated method stub
		return domainDao.listUnderCatCurrentUser(catId, username, pageSize, pageNo); 
	}
	public List<Publish> publishByName() {
		return domainDao.publishByName();
	}
	public List<Publish> publishByUser(User user){
		return domainDao.publishByUser(user);
	}
	public List<Publish>  publishByFirImage(){
		return domainDao.publishByFirImage();
	}
	public List<Publish> publishBySecImage(){
		return domainDao.publishBySecImage();
	}
	public Pager findByContent(String searchText, int pageSize, int pageNo) {
		// TODO Auto-generated method stub
		return domainDao.findByContent(searchText, pageSize, pageNo);
	}
	public Pager findByName(String searchText, int pageSize, int pageNo) {
		// TODO Auto-generated method stub
		return domainDao.findByName(searchText, pageSize, pageNo); 
	}

	public Pager findLikeContent(String searchText, int pageSize, int pageNo) {
		// TODO Auto-generated method stub
		return domainDao.findLikeContent(searchText, pageSize, pageNo);
	}
	public Pager findLikeName(String searchText, int pageSize, int pageNo) {
		// TODO Auto-generated method stub
		return domainDao.findLikeName(searchText, pageSize, pageNo); 
	}

	public Pager payList(int id,int pageSize,int pageNo){
		return domainDao.findById(id, pageSize, pageNo);
	}
	public List getPublishIdByUid(int uid){
		return domainDao.getPublishIdByUid(uid);
	}
	public List<Publish> getPublishListBycatId(String catId) {
		return domainDao.getPublishListBycatId(catId);
	}
	public List<Publish> getRecommendPublishUnderCat(String pubCatId) {
		// TODO Auto-generated method stub
		return domainDao.getRecommendPublishUnderCat(pubCatId);
	}
	
	public List<Publish> NameByCat(int id){
		return domainDao.NameByCat(id);
	}
	public List<Publish> ChangeImage() {
		// TODO Auto-generated method stub
		return domainDao.ChangeImage();
	}
	public Pager ImgChange(int pageSize, int pageNo) {
		// TODO Auto-generated method stub
		return domainDao.ImgChange(pageSize, pageNo);
	}
	public Pager ImgChangeByCat(Integer catId, int pageSize, int pageNo) {
		// TODO Auto-generated method stub
		return domainDao.ImgChangeByCat(catId, pageSize, pageNo);
	}
	public Pager getPublishListBycatId(Integer catId, int pageSize, int pageNo) {
		// TODO Auto-generated method stub
		return domainDao.getPublishListBycatId(catId, pageSize, pageNo);
	}
	public List<Publish> findByPublishSpecialId(PublishSpecialCat publishSpecialCat) {
		// TODO Auto-generated method stub
		return domainDao.findByPublishSpecialId(publishSpecialCat);
	}

	public List<Publish> selectByFrontPage(String type, int pageNo, int pageSize) {
		return domainDao.selectByFrontPage( type,  pageNo,  pageSize);
	}




	public Pager newestUploadedPicUnderTopPublishCat(String publishCatType,int pageSize, int pageNo) {
		// TODO Auto-generated method stub
		return domainDao.newestUploadedPicUnderTopPublishCat(publishCatType, pageSize, pageNo) ;
	}
		
	public Publish getMainPicOfTopPublishCat(String publishCatType) {
		// TODO Auto-generated method stub
		return domainDao.getMainPicOfTopPublishCat(publishCatType);
	}

	public Pager searchUnderTopPublishCat(String publishCatType,
			String[] searchKeys, int pageSize, int pageNo) {
		// TODO Auto-generated method stub
		return domainDao.searchUnderTopPublishCat(publishCatType, searchKeys, pageSize, pageNo) ;
	}
	public Integer getPublishCatIdByType(String publishCatType) {
		// TODO Auto-generated method stub
		return domainDao.getPublishCatIdByType(publishCatType) ;
	}
	public List<PublishCat> getPublishCatsUnderByType(String publishCatType) {
		// TODO Auto-generated method stub
		return domainDao.getPublishCatsUnderByType(publishCatType) ;
	}
	
	public List<?> selectBuyMsg(int userId) {

		// TODO Auto-generated method stub
		return domainDao.selectBuyMsg(userId);
	}
	public List<?> selectSellerMsg( int userId){
		
		return domainDao.selectSellerMsg(userId);
		
	}
	public List<Publish> findResemble(String tags) {
		// TODO Auto-generated method stub
		return domainDao.findResemble(tags);
	}
	public Publish getMainPicOfTopPublishCat(List<PublishCat> publishCats,
			int commnendShould) {
		// TODO Auto-generated method stub
		return domainDao.getMainPicOfTopPublishCat(publishCats, commnendShould);
	}
	public Pager newestUploadedPicUnderTopPublishCat(
			List<PublishCat> publishCats, int pageSize, int pageNo) {
		// TODO Auto-generated method stub
		return domainDao.newestUploadedPicUnderTopPublishCat(publishCats, pageSize, pageNo);
	}
	public Publish homePageMainPic() {
		// TODO Auto-generated method stub
		return domainDao.homePageMainPic();
	}
	public PublishCat getPublishCatByPublish(Integer id) {
		// TODO Auto-generated method stub
		return domainDao.getPublishCatByPublish(id);
	}
	public List<Publish> homePageMainPicNew() {
		// TODO Auto-generated method stub
		return  domainDao.homePageMainPicNew();
	}
	
	public Pager userAlbumnBySpecial(PublishSpecialCat publishSpecialCat,
			int pageSize, int pageNo) {
		// TODO Auto-generated method stub
		return domainDao.userAlbumnBySpecial(publishSpecialCat, pageSize, pageNo);
	}
	public List<Publish> modelPic() {
		// TODO Auto-generated method stub
		return domainDao.modelPic();
	}
	public List<Publish> photographyPic() {
		// TODO Auto-generated method stub
		return domainDao.photographyPic();
	}
	public List<Publish> findpublishByUser1(User user) {
		// TODO Auto-generated method stub
		return domainDao.findpublishByUser1(user);
	}
	public Pager findpublishByStatu(int pageSize, int pageNo) {
		// TODO Auto-generated method stub
		return domainDao.findpublishByStatu(pageSize, pageNo);
		
	}
	public Pager workStatistics(int pageSize, int pageNo) {
		// TODO Auto-generated method stub
		return domainDao.workStatistics(pageSize, pageNo);
	}
	public Pager waitcheck(User user, int pageSize, int pageNo) {
		// TODO Auto-generated method stub
		return domainDao.waitcheck(user, pageSize, pageNo);
	}
	public Pager checknopass(User user,final int pageSize,final int pageNo){
		return domainDao.checknopass(user, pageSize, pageNo);
	}
	public List<Publish> findbydelpublish(){
		return domainDao.findbydelpublish();
	}
	public List<Publish> findpublishByUser2(User user) {
		// TODO Auto-generated method stub
		return domainDao.findpublishByUser2(user);
	}
	public PublishStatusService getPublishStatusService() {
		return publishStatusService;
	}
	public void setPublishStatusService(PublishStatusService publishStatusService) {
		this.publishStatusService = publishStatusService;
	}
	
}//end class
