package com.wetuo.wepic.publish.actions ;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.swing.ImageIcon;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import sun.reflect.Reflection;

import com.opensymphony.xwork2.ActionContext;
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.struts.PageAction;
import com.wetuo.wepic.common.util.PropertiesRead;
import com.wetuo.wepic.common.util.UploadUtils;
import com.wetuo.wepic.common.util.WepicReback;
import com.wetuo.wepic.core.beans.RoleTags;
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.core.tools.ModelDriverReflect;
import com.wetuo.wepic.publish.beans.CutImg;
import com.wetuo.wepic.publish.beans.Publish;
import com.wetuo.wepic.publish.beans.PublishCat;
import com.wetuo.wepic.publish.beans.PublishCat_Publish;
import com.wetuo.wepic.publish.beans.PublishSpecialCat;
import com.wetuo.wepic.publish.beans.PublishStatus;
import com.wetuo.wepic.publish.service.PublishCatService;
import com.wetuo.wepic.publish.service.PublishCat_PublishService;
import com.wetuo.wepic.publish.service.PublishService;

public class PublishAction extends PageAction {
	private PublishService publishService;
	private Publish publish;
	private Publish publishTest;
	private List<Publish> imgChangeList;
	private String resMsg;
	private Integer publishId;
	private File upfile;
	private  WepicReback reback;
	private List<PublishSpecialCat> myUnderCatList;
	private String upfileFileName;
	private String upfileContentType;
	private String path="";
	private int publishSpecialCatId;
	private String[] count;
	private int userId;
	private String downloadFileName;
	public List<Publish> publishs;
	private PublishCatService publishCatService;
	private List<PublishCat> publishChiledCats;
	private String publishCatId;
	private String[] copyrightType;
	//附件
	private File accessories;
	private String accessoriesFileName;
	private  String accessoriesContentType;
	//上传文件网络路径
	private String httpurl;
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private String smallurlPath;
	private String fileName;
	private int[] ids;
	private PublishCat_PublishService publishCatPublishService;
	 private List<PublishCat> publishCats;
	 public String buypublish() {
			imgChangeList=this.getPublishService().findAll();
			return "buypublish";
		}
	public PublishAction(String className) {
		try {
			model=Class.forName(className).newInstance();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@JSON(serialize=false)
	public String worklibrary() {
		int uId=Integer.parseInt(ActionContext.getContext().getSession().get("id").toString());
		imgChangeList=this.getPublishService().worklibrary(uId);
		return "worklibrary";
	}
	
	
	@JSON(serialize=false)
	public String findthumbnailbyId() {
		resMsg=this.getPublishService().findthumbnailbyId(publishId);
		return "findthumbnailbyId";
	}
	
	
	@JSON(serialize=false)
	public String findthumbnailbyId2() {
		resMsg=this.getPublishService().createcutpic(publishId);
		return "findthumbnailbyId2";
	}
	
	
	public String test() {
		String currentAbsoulutePath=Thread.currentThread().getContextClassLoader().getResource("").getPath();
        PropertiesRead readPro = new PropertiesRead(currentAbsoulutePath+"picpath.properties");//相对路径
        String originalPro = readPro.getValue("original");//以下读取properties文件的值
        System.out.println(originalPro);
        String weboriginal=readPro.getValue("weboriginal");
        System.out.println(weboriginal);
		return "";
	}
	
	
	
	
	
	//文件上传
   public String uploadOpus(){
	 
	  Publish publish=new Publish();
      User user=new User();
      user.setId(userId);
      publish.setUser(user);
      PublishSpecialCat publishSpecialCat=new PublishSpecialCat();
      publishSpecialCat.setId(publishSpecialCatId);
	  publish.setPublishSpecialCat(publishSpecialCat);
	  String path=publishService.uploadOpus(super.getRequest(),upfile,upfileFileName,publish);
	  reback=new WepicReback();
	  reback.setUrl(path.split(",")[0]);
	  reback.setFileType(upfileContentType);
	  reback.setState("SUCCESS");
	  reback.setOriginal(upfileFileName);
	  reback.setPublishId(publish.getId()+"");
	  
	  
       return  "uploadOpus";
	}
   
   
   
   public String findbyCountBySpecialCat(){
	   int id=super.getLonginUserId();
	   if(id==0){
		   return "findbyCountBySpecialCat";  
		   
		   
	   }
	   
	   
	   DetachedCriteria criteria=DetachedCriteria.forClass(Publish.class);
	   criteria.createAlias("publishSpecialCat", "publishSpecialCat");
	   criteria.createAlias("user", "user");
	   criteria.add(Restrictions.eq("publishSpecialCat.id", publishSpecialCatId));
	   criteria.add(Restrictions.eq("user.id", id));
	   String total=publishService.findbyCountBySpecialCat(criteria);
	   
	   
	   DetachedCriteria criteria1=DetachedCriteria.forClass(Publish.class);
	   criteria1.createAlias("publishSpecialCat", "publishSpecialCat");
	   criteria1.createAlias("publishStatus", "publishStatus");
	   criteria1.createAlias("user", "user");
	   criteria1.add(Restrictions.eq("user.id", id));
	   criteria1.add(Restrictions.eq("publishStatus.unreleased",1));
	   criteria1.add(Restrictions.eq("publishSpecialCat.id", publishSpecialCatId));
	 
	   String fabutotal=publishService.findbyCountBySpecialCat(criteria1);
	   count=new String[]{total,fabutotal};
	   System.out.println(count);
	   return "findbyCountBySpecialCat";
   }
   
   
   public String findAllMyLib(){
	   int id=super.getLonginUserId();
	   if(id==0){
		   
		   return "login";
	   }
	    User user=new User();
	    user.setId(id);
	         //publishCat=publishCatService.selectByName("isDefault");
	   
         super.pager=publishService.findPublishBySpcialCat(id,16,pageNo);
 		 // myUnderCatList=publishSpecialCatService.AllSpecialByUser(user);
	  // System.out.println(super.pager.getLastPageNo());
	   return "findAllMyLib";
   }
   
   public InputStream getInputStream() throws Exception{
	   Publish publish=(Publish)model;
	   Publish downPublish=publishService.select(publish.getId());
	   File file=new File(downPublish.getOriginalPic());
	   downloadFileName=file.getName();
	   //InputStream inputStream=ServletActionContext.getServletContext().getResourceAsStream(downPublish.getOriginalPic());
	   // if(null==inputStream){
	     System.out.println("Can not find a java.io.InputStream with the name [inputStream] in the invocation stack. Check the <param name=\"inputName\"> tag specified for this action.检查action中文件下载路径是否正确.");  
	   // }
	    return new FileInputStream(file);
   }
   public String downloadPic(){
    int id=super.getLonginUserId();
	if(id==0){
		return "login";
		
	}
	
	
	
	
	return "downloadPic";
     }
   
     public String deletePublishPic(){
    	 
    	 
    	 
    	 
    	 
    	 UploadUtils uploadUtils=new UploadUtils();
    	 Publish publish=(Publish)model;
    	 Publish deletPub= publishService.select(publish.getId());
    	 PublishStatus publishStatus=deletPub.getPublishStatus();
    	 
    	 publishStatus.setUserDelete(1);
    	 publish.setDeleteTime(new Timestamp(new Date().getTime()));
    	 publishService.deleteUpdate(deletPub);
    	// deletPub.get
    	 
//    	 if(publishStatus.getPass()==1||publishStatus.getUserSoldout()||publishStatus.get){
//    		 
//    		 
//    		 return "deletePublishPic";
//    	 }
    	 
    	 
    	 
//    	 
//    	 uploadUtils.deleteFile(deletPub.getSmallPic(), "small");
//    	 uploadUtils.deleteFile(deletPub.getThumbnailUrl(),"thumbnail");
//    	 uploadUtils.deleteFile(deletPub.getThumbnail125(),"thumbnail125");
//    	 File file=new File(deletPub.getOriginalPic());
//    	 if(file.exists()){
//    		 file.delete();
//    		 
//    	 }
    	 
    	publishService.delete(deletPub);
    	 

	   return "deletePublishPic";
   }
     
     
     
     
     public String getMyWorkLib(){
    	 int id=super.getLonginUserId();
    	 User user=new User();
    	 user.setId(id);
    	 publishs=publishService.findUserOfPublish(user);
    	 super.pager=new Pager(publishs);
    	 
    	 return "getMyWorkLib";
    	 
    	 
     }
     
     public String findEditePublish(){
    	 publish=publishService.select(((Publish)model).getId());
    	 List<PublishCat> publishCats=publishCatService.getPublishCatListUnderPid(0);
    	 int catId = 0;
    	 String type="photography";
    	 if(publish.getType()!=null&&publish.getType()==2){
    		 type="originality";
    		 
    	 }
    	 for (PublishCat publishCat : publishCats) {
   			if(publishCat.getType().equals(type)){
   				catId=publishCat.getId();
   				break;
   			}
       	 
    	 }
    	 
    	
    	publishChiledCats=publishCatService.getPublishCatListUnderPid(catId);
//    	
//    	
   	 publishCats=new ArrayList<PublishCat>();
    	List<PublishCat_Publish> list=publishCatPublishService.list(publish.getId());
    	for (PublishCat_Publish publishCatPublish : list) {
    	PublishCat publishCat=publishCatService.select(publishCatPublish.getPublishCat().getId());
    	publishCats.add(publishCat);
		}
    	for (int i=0;i<publishCats.size();i++) {
    		for(int j=0;j<publishChiledCats.size();j++){
    			PublishCat exits=publishCats.get(i);
    			PublishCat delete=publishChiledCats.get(j);
    			if(exits.getName().equals(delete.getName())){
    				publishChiledCats.remove(j);
    				
    				
    			}
    			
    			
    			
    			
    			
    		}
    		
			
		}

    	
    	publish.setPublishCats(publishCats);
//    	
    	
    	
    	
    	//publish.getSize()
    	
    	 return "findEditePublish";
     }
     
     
     //修改已发布的图片
 public String findEditereleasPublish(){
	 publish=publishService.select(((Publish)model).getId());
    	 List<PublishCat> publishCats=publishCatService.getPublishCatListUnderPid(0);
    	 int catId = 0;
    	 for (PublishCat publishCat : publishCats) {
    	  if(publish.getType()==1){
    		 
			if(publishCat.getType().equals("photography")){
				catId=publishCat.getId();
				break;
			}
    	 }else{
    		 
 			if(publishCat.getType().equals("originality")){
 				catId=publishCat.getId();
 				break;
 			} 
    		 
    	 }
		}
    	 
    	 
    	 
    	 
    	 
    	publishChiledCats=publishCatService.getPublishCatListUnderPid(catId);
//    	
    	
    	 publishCats=new ArrayList<PublishCat>();
     	List<PublishCat_Publish> list=publishCatPublishService.list(publish.getId());
     	for (PublishCat_Publish publishCatPublish : list) {
     	PublishCat publishCat=publishCatService.select(publishCatPublish.getPublishCat().getId());
     	publishCats.add(publishCat);
 		}
     	for (int i=0;i<publishCats.size();i++) {
     		for(int j=0;j<publishChiledCats.size();j++){
     			PublishCat exits=publishCats.get(i);
     			PublishCat delete=publishChiledCats.get(j);
     			if(exits.getName().equals(delete.getName())){
     				publishChiledCats.remove(j);
     			}
     		}
		} 	
     	publish.setPublishCats(publishCats);
//     	 
     	
    	
    	
    	//publish.getSize()
    	
    	 return "findEditereleasPublish";
     }
     
        
 
   //用户下架自己的作品
   public String userSoldout(){
	 publishService.userSoldout(((Publish)model).getId());//select(((Publish)model).getId()).getPublishStatus();  
	 //publishStatus.setUserSoldout(1);
	 
	   
	 
	 
	 return "userSoldout";
       }
     
   //改变图片专辑
 public String changeSpecialPic(){
	 int id=super.getLonginUserId();
	 if(id==0){
		 resMsg="login";
		 
		 return "changeSpecialPic";
		 
	 }
	 try{
		 resMsg="suc";
	 Publish publish=publishService.select(((Publish)model).getId());
	 PublishSpecialCat publishSpecialCat=new PublishSpecialCat();
	 publishSpecialCat.setId(publishSpecialCatId);
	 publish.setPublishSpecialCat(publishSpecialCat);
	 publishService.update(publish);
	 }catch (Exception e) {
		 resMsg="error";
		e.printStackTrace();
	}
	 
	 return "changeSpecialPic";
 }
     
     public String findEditeUnPublish(){
    	 publish=publishService.select(((Publish)model).getId());
    	 List<PublishCat> publishCats=publishCatService.getPublishCatListUnderPid(0);
    	 int catId = 0;
    	 String type="photography";
    	 if(publish.getType()!=null&&publish.getType()==2){
    		 type="originality";
    		 
    	 }
    	 
    	 
    	 for (PublishCat publishCat : publishCats) {
   			if(publishCat.getType().equals(type)){
   				catId=publishCat.getId();
   				break;
   			}
       	 
    	 }
    	 
    	 
    	 
    	 
    	 
    	publishChiledCats=publishCatService.getPublishCatListUnderPid(catId); 
//    	
    	 publishCats=new ArrayList<PublishCat>();
     	List<PublishCat_Publish> list=publishCatPublishService.list(publish.getId());
     	for (PublishCat_Publish publishCatPublish : list) {
     	PublishCat publishCat=publishCatService.select(publishCatPublish.getPublishCat().getId());
     		publishCats.add(publishCat);
 		}   	 
     	publish.setPublishCats(publishCats);
//     	UploadUtils uploadUtils=new UploadUtils(); 
//     	
    	
    	
    	//publish.getSize()
    	
    	 return "findEditeUnPublish";
     }
     
     
     //发布图片
     public String updatePublish(){
    	  int id=super.getLonginUserId();
    	  User user=new User();
    	  user.setId(id);
    	  if(id==0){
    		  return "login";
    		  
    	  }
    	Publish newPublish=(Publish)model;
    	Publish oldPublish=publishService.select(newPublish.getId());
    	 newPublish.setCopyrightArea("中国大陆");
    	 if(copyrightType!=null&&copyrightType.length!=0){
    		 if(copyrightType.length==2){
    			 newPublish.setCopyright(3); 
     	    }else{
     	    	newPublish.setCopyright(Integer.parseInt(copyrightType[0]));
     	    	
     	    }
    		 
    	 }
    	
    	// newPublish.setWidth(oldPublish.getWidth());
    	 if(newPublish.getType()==3){
    		 newPublish.setPicNumber("pg-"+oldPublish.getPicNumber());
    	 }else if (newPublish.getType()==2){
    		 newPublish.setPicNumber("cg-"+oldPublish.getPicNumber());
		}
    	 if(!oldPublish.getPicMode().equals("Psd")){
    	 newPublish.setHeight(oldPublish.getHeight());
    	 newPublish.setWidth(oldPublish.getWidth());
    	 }
    	 newPublish.setHit(oldPublish.getHit());
    	 newPublish.setThumbnail125(oldPublish.getThumbnail125());
    	 newPublish.setThumbnailUrl(oldPublish.getThumbnailUrl());
    	 newPublish.setSmallPic(oldPublish.getSmallPic());
    	 newPublish.setPicNumber(oldPublish.getPicNumber());
    	 newPublish.setStatus(1);	 
    	 newPublish.setPublishSpecialCat(oldPublish.getPublishSpecialCat());
    	 newPublish.setOriginalPic(oldPublish.getOriginalPic());
    	 newPublish.setUpTime(oldPublish.getUpTime());
    	 newPublish.setSize(oldPublish.getSize());
    	 newPublish.setUser(user);
    	 newPublish.setLogo(oldPublish.getLogo());
    	 newPublish.setPicMode(oldPublish.getPicMode());
    	// newPublish.setPublishTime(new Timestamp(new Date().getTime()));
    	 
    	 
    	 
         PublishStatus publishStatus=new PublishStatus();
    	 publishStatus.setId(oldPublish.getPublishStatus().getId());
    	
    	 
    	 newPublish.setPublishStatus(publishStatus);
    	
    	 
    	 publishService.update(newPublish);
    	 
    	 
    	 List<PublishCat_Publish> catPublishs= publishCatPublishService.list(newPublish.getId());
     	for (PublishCat_Publish publishCatPublish : catPublishs) {
     		publishCatPublishService.delete(publishCatPublish);
 		}
     	
    	 
    	 String[] publishCatIds=publishCatId.trim().split(" ");
    	
    	 for (String string : publishCatIds) {
    		 if(!string.trim().equals("")){
			PublishCat_Publish publishCatPublish=new PublishCat_Publish();
			PublishCat publishCat=new PublishCat();
			publishCat.setId(new Integer(string));
			publishCatPublish.setPublish(newPublish);
			publishCatPublish.setPublishCat(publishCat);
			publishCatPublishService.insert(publishCatPublish);
    		 }
			//publishCat
		}
    	 
    	 return "updatePublish";
     }
   public String updateLogo(){
	   Publish  publish=publishService.select(((Publish)model).getId());
	   publish.setLogo("3");
	   publishService.update(publish);
	   path="ok";
	   
	   
	   
	   
	   
	   
	   return "updateLogo";
   }
     
     //附件上传
     public String uploadAccessories() {
     	
     	String savePath=ServletActionContext.getServletContext().getRealPath("/back/personalCentr/bid/accessories");
     	
     	HttpServletRequest request =ServletActionContext.getRequest();
     	
 		String path = request.getContextPath();
 		
 		String httpPath =request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 		
     	try {
 			httpurl=publishService.uploadFile(accessories,savePath,httpPath,accessoriesFileName);
 		} catch (Exception e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}	
     	
 	    return "uploadAccessories";
  }
     
     public String editeSamplePic() throws IOException{
    	
    	 publish=publishService.select(((Publish)model).getId()); 
    	 String picurl=publish.getSmallPic();
    	 String path=super.getRequest().getRealPath("/temImg");
    	 String[] str=picurl.split("/small");
    	 HttpServletRequest request=super.getRequest();
    	 UploadUtils uploadUtils=new UploadUtils();
    	 String path1 = request.getContextPath();
    	 String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path1+"/";
    	// String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    	 smallurlPath=uploadUtils.createTemSmall(str[1],path,basePath);
    	 File file=new File(path+"/"+smallurlPath.split(",")[0]);
//    	    ImageIcon img= new ImageIcon(file.getAbsolutePath());
//			int width= img.getIconWidth();
//			int height= img.getIconHeight();
//    	    publish.setWidth(width);
//    	    publish.setHeight(height);
    	    
    	    BufferedImage bufferedImage = null;
    		try {
    			bufferedImage = ImageIO.read(file);
    			publish.setHeight(bufferedImage.getHeight());
    			publish.setWidth(bufferedImage.getWidth());
    			//publish.setLogo("0");
    		} catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		
    		
    	    
    	 return "editeSamplePic";
     }
     
     public String updateSamplePic(){
    	 
    	CutImg cutImg=new CutImg();
    	cutImg.setX1(x1);
    	cutImg.setX2(x2);
    	cutImg.setY1(y1);
    	cutImg.setY2(y2);
    	/*
    	
    	 */
    	String path=super.getRequest().getRealPath("/temImg");
    	File file=new File(path+"/"+fileName);
    	 publishService.ChangeImg(cutImg, file, ((Publish)model).getId());
    	 return "updateSamplePic";
     }
     
     public String uploadSimpleSamll(){
    	 publishService.uploadSimpleSmall(((Publish)model).getId(), upfile,super.getRequest(),upfileFileName);
    	 
    	 path="ok";
    	 
    	 
    	 
    	 
    	 return "uploadSimpleSamll";
     }
     
     
     
     
     public String findPublish(){
    	 
    	 publish=publishService.select(((Publish)model).getId());
    	
    	 
    	
    	 publishCats=new ArrayList<PublishCat>();
    	List<PublishCat_Publish> list=publishCatPublishService.list(publish.getId());
    	for (PublishCat_Publish publishCatPublish : list) {
    	PublishCat publishCat=publishCatService.select(publishCatPublish.getPublishCat().getId());
    		publishCats.add(publishCat);
		}   	 
    	publish.setPublishCats(publishCats);
    	 
    	 
    	 
    	 
    	 
    	 DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Publish.class);
    	 detachedCriteria.createAlias("publishSpecialCat", "publishSpecialCat");
    	 detachedCriteria.createAlias("publishStatus", "publishStatus");
    	 detachedCriteria.add(Restrictions.eq("publishSpecialCat.id", publish.getPublishSpecialCat().getId()));
    	 detachedCriteria.add(Restrictions.eq("publishStatus.adminDelete", 0));
    	 detachedCriteria.add(Restrictions.eq("publishStatus.userDelete", 0));
    	 detachedCriteria.add(Restrictions.not(Restrictions.eq("logo", "1")));
    	 detachedCriteria.add(Restrictions.not(Restrictions.eq("id", publish.getId())));
    	 //detachedCriteria.add(Restrictions.not(Restrictions.eq("id", publish.getId())));
    	 super.pager=publishService.findbyDetachedCriteria(detachedCriteria,pageNo,16);
    	 
 
    	 return "findPublish";
     }
     
     
     
     
     
     
     
  @SuppressWarnings("unchecked")
public String findRelesePublish(){
    	 
    	 publish=publishService.select(((Publish)model).getId());
    	
    	 String reson=publish.getNotPassedCause();
			List listres=new ArrayList<String>();
			if(reson!=null&&!reson.trim().equals("")){
				String[] resons=reson.split(",");
				for (String string : resons) {
					if(string.equals("1")){
						listres.add("您上传的证件不清晰");
						
					}
					else if(string.equals("2")) {
						listres.add("证件照片有改动");
						
					}
					else if(string.equals("3")) {
						listres.add("您提交的身份信息不正确");
						
					}
					else {
						listres.add(string);
						
					}
					
				}
				
				
				
			}
			publish.setResons(listres);
    	
    	publishCats=new ArrayList<PublishCat>();
    	List<PublishCat_Publish> list=publishCatPublishService.list(publish.getId());
    	for (PublishCat_Publish publishCatPublish : list) {
    	PublishCat publishCat=publishCatService.select(publishCatPublish.getPublishCat().getId());
    		publishCats.add(publishCat);
		}   	 
    	publish.setPublishCats(publishCats);
    	 
    	 
    	 
    	 
    	 
    	 DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Publish.class);
    	 detachedCriteria.createAlias("user", "user");
    	 detachedCriteria.createAlias("publishSpecialCat", "publishSpecialCat");
    	 detachedCriteria.createAlias("publishStatus", "publishStatus");
    	 detachedCriteria.add(Restrictions.eq("publishSpecialCat.id", publish.getPublishSpecialCat().getId()));
    	 detachedCriteria.add(Restrictions.eq("publishStatus.adminDelete", 0));
    	 detachedCriteria.add(Restrictions.eq("publishStatus.userDelete", 0));
    	 //detachedCriteria.add(Restrictions.or(Restrictions.eq("publishStatus.justShow", 1),Restrictions.eq("publishStatus.onOffer", 1)));
    	 detachedCriteria.add(Restrictions.not(Restrictions.eq("logo", "1")));
    	 detachedCriteria.add(Restrictions.not(Restrictions.eq("id", publish.getId())));
    	 detachedCriteria.add(Restrictions.eq("user.id", super.getLonginUserId()));
    	 detachedCriteria.add(Restrictions.not(Restrictions.eq("id", publish.getId())));
    	 //detachedCriteria.add(Restrictions.not(Restrictions.eq("id", publish.getId())));
    	 super.pager=publishService.findbyDetachedCriteria(detachedCriteria,pageNo,16);
    	 
 
    	 return "findRelesePublish";
     }
  
  
  
     
     public String testpicInfo(){
    	 
    	 
    	 
    	 return "testpicInfo";
     }
     
     
     public String getPicInfo(){
    	 
    	 publishTest=publishService.select(((Publish)model).getId());
    	 publishTest.setSetpublishCat_Publish(null);
    	 publishCats=new ArrayList<PublishCat>();
     	List<PublishCat_Publish> list=publishCatPublishService.list(publishTest.getId());
     	for (PublishCat_Publish publishCatPublish : list) {
     	PublishCat publishCat=publishCatService.select(publishCatPublish.getPublishCat().getId());
     		publishCats.add(publishCat);
 		}   	 
     	publishTest.setPublishCats(publishCats);
     	
    	 return "picInfo";
     }
     
     
     //查找待审核的图片
     
     public String adminCheckPhotoPic(){
    	 
    	 
    	super.pager=publishService.adminCheckPhotoPic(pageNo,16);
    	 
    	 
    	 return "adminCheckPhotoPic";
     }
     
     
     

     //查找审核通过图片
     public String adminPassPhotoPic(){
    	 
    	 
    	super.pager=publishService.adminPassPhotoPic(pageNo,16);
    	 
    	 
    	 return "adminPassPhotoPic";
     }
     
     
     
     //审核通过 图片作品
     public String adminPassPhoto(){
    	 int id=super.getLonginUserId();
    	 if(id==0){
    		 
    		return "login"; 
    	 }
    	 publishService.adminPassPhoto(((Publish)model).getId(),id);
    	 
    	 return "adminPassPhoto";
     }
     
     //审核不通过 图片作品
     public String adminNoPassPhoto(){
    	 int id=super.getLonginUserId();
    	 if(id==0){
    		 
    		return "login"; 
    	 }
    	 String reson="";
    	 
    	 if(count!=null&&count.length>0){
    		 for (String str : count) {
    			 if(reson.trim().equals("")){
    				 reson=str;
    			 }else{
    				 reson+=","+str;
    				 
    				 
    			 }
				
			}
    		 
    		 
    	 }
    	 publishService.adminNoPassPhoto(((Publish)model).getId(),id,reson);
    	 
    	 return "adminPassPhoto";
     }
     
   //审核直接删除作品
     public String adminDeletePhoto(){
    	 publishService.adminDeletePic(((Publish)model).getId());
    	 
    	 return "adminPassPhoto";
     }
     
     
     //批量通过     
     public String adminPassPatchPhotoPic(){
    	 int id=super.getLonginUserId();
    	 if(id==0){
    		 
    		return "login"; 
    	 }
    	 
    	 if(ids!=null&&ids.length>0){
    		 for(int i=0;i<ids.length;i++){   		 
    		 publishService.adminPassPhoto(ids[i],id);
    		 }
    		 
    	 }
     	 
    	 return "adminPassPhoto";
     }
     
     //批量Butong通过     
     public String adminNopassPatchPhotoPic(){
    	 int id=super.getLonginUserId();
    	 if(id==0){
    		 
    		return "login"; 
    	 }
    	 
    	 if(ids!=null&&ids.length>0){
    		 for(int i=0;i<ids.length;i++){   		 
    		 publishService.adminNoPassPhoto(ids[i],id,"");
    		 }
    		 
    	 }
     	 
    	 return "adminPassPhoto";
     }
     //管理员查看未审核详情
     public String adminfindDetail(){
    	 publish=publishService.select(((Publish)model).getId());
    	 
    	
     	//UploadUtils uploadUtils=new UploadUtils(); 
     	
    	 return "adminfindDetail";
     }
     
     //管理员查看已通过详情
     public String adminfindPassDetail(){
    	 publish=publishService.select(((Publish)model).getId());
    	 
    	
     	//UploadUtils uploadUtils=new UploadUtils(); 
     	
    	 return "adminfindPassDetail";
     }
     
     //管理员查看未通过的图片
     public String adminNoPassList(){
    	 
    	 
    	 super.pager=publishService.adminNoPassPhotoPicList(pageNo,16);
    	 
    	 return "adminNoPassList";
     }
     
     
   //管理员查看未通过的图片
     public String adminNoPassDetail(){
    	 
    	 
    	 publish=publishService.select(((Publish)model).getId());
    	 String reson= publish.getNotPassedCause();
    	 List<String> list=new ArrayList<String>();
    	if(reson!=""&&!reson.trim().equals("")){
    	 String[] resons=reson.split(",");
    	for (String string : resons) {
    		list.add(string);
		}	
    	}
    	 publish.setResons(list);
    	 
    	 
    	 
    	 
    	 
    	 return "adminNoPassDetail";
     }
     //管理员查看下架列表
    public String adminUndercarriageList(){
    	
    	super.pager=publishService.adminUndercarriageList(pageNo,16);
	    return "adminUndercarriageList"; 
     }
     
     
    //管理员给图片下架
    public String adminUndercarriage(){
    	String reson="";
    	 if(count!=null&&count.length>0){
    		 for (String str : count) {
    			 if(reson.trim().equals("")){
    				 reson=str;
    			 }else{
    				 reson+=","+str;
    			 }
			}
    	 }
    	 User user=new User();
    	 user.setId(super.getLonginUserId());
    	publishService.adminUndercarriage(((Publish)model).getId(),reson,user);
    	
	    return "adminUndercarriage"; 
     }
    
    //管理员查看下架图片
    public String adminUndercarriageDetail(){
    	
      publish=publishService.select(((Publish)model).getId());
      String reson= publish.getNotPassedCause();
 	 List<String> list=new ArrayList<String>();
 	if(reson!=""&&!reson.trim().equals("")){
 	 String[] resons=reson.split(",");
 	for (String string : resons) {
 		list.add(string);
		}	
 	}
 	 publish.setResons(list);
	  return "adminUndercarriageDetail"; 
     }
    
    
     
//////////////////////////////	/////////////getter setter/////////////
	
	
	
	public File getUpfile() {
		return upfile;
	}
	public void setUpfile(File upfile) {
		this.upfile = upfile;
	}
	public String getUpfileFileName() {
		return upfileFileName;
	}
	public void setUpfileFileName(String upfileFileName) {
		this.upfileFileName = upfileFileName;
	}
	public String getUpfileContentType() {
		return upfileContentType;
	}
	public void setUpfileContentType(String upfileContentType) {
		this.upfileContentType = upfileContentType;
	}
	

	public PublishService getPublishService() {
		return publishService;
	}
	public void setPublishService(PublishService publishService) {
		this.publishService = publishService;
	}
	public List<Publish> getImgChangeList() {
		return imgChangeList;
	}
	public void setImgChangeList(List<Publish> imgChangeList) {
		this.imgChangeList = imgChangeList;
	}
	public Publish getPublish() {
		return publish;
	}
	public void setPublish(Publish publish) {
		this.publish = publish;
	}
	public String getResMsg() {
		return resMsg;
	}
	public void setResMsg(String resMsg) {
		this.resMsg = resMsg;
	}
	public Integer getPublishId() {
		return publishId;
	}
	public void setPublishId(Integer publishId) {
		this.publishId = publishId;
	}


	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}


	public WepicReback getReback() {
		return reback;
	}


	public void setReback(WepicReback reback) {
		this.reback = reback;
	}


	public int getPublishSpecialCatId() {
		return publishSpecialCatId;
	}


	public void setPublishSpecialCatId(int publishSpecialCatId) {
		this.publishSpecialCatId = publishSpecialCatId;
	}


	public String[] getCount() {
		return count;
	}


	public void setCount(String[] count) {
		this.count = count;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getDownloadFileName() {
		return downloadFileName;
	}


	public void setDownloadFileName(String downloadFileName) {
		this.downloadFileName = downloadFileName;
	}


	public List<Publish> getPublishs() {
		return publishs;
	}


	public void setPublishs(List<Publish> publishs) {
		this.publishs = publishs;
	}


  


	public PublishCatService getPublishCatService() {
		return publishCatService;
	}


	public void setPublishCatService(PublishCatService publishCatService) {
		this.publishCatService = publishCatService;
	}


	public List<PublishCat> getPublishChiledCats() {
		return publishChiledCats;
	}


	public void setPublishChiledCats(List<PublishCat> publishChiledCats) {
		this.publishChiledCats = publishChiledCats;
	}


	public String getPublishCatId() {
		return publishCatId;
	}


	public void setPublishCatId(String publishCatId) {
		this.publishCatId = publishCatId;
	}


	public String[] getCopyrightType() {
		return copyrightType;
	}


	public void setCopyrightType(String[] copyrightType) {
		this.copyrightType = copyrightType;
	}


	public File getAccessories() {
		return accessories;
	}


	public void setAccessories(File accessories) {
		this.accessories = accessories;
	}


	public String getAccessoriesFileName() {
		return accessoriesFileName;
	}


	public void setAccessoriesFileName(String accessoriesFileName) {
		this.accessoriesFileName = accessoriesFileName;
	}


	public String getAccessoriesContentType() {
		return accessoriesContentType;
	}


	public void setAccessoriesContentType(String accessoriesContentType) {
		this.accessoriesContentType = accessoriesContentType;
	}


	public String getHttpurl() {
		return httpurl;
	}


	public void setHttpurl(String httpurl) {
		this.httpurl = httpurl;
	}


	public int getX1() {
		return x1;
	}


	public void setX1(int x1) {
		this.x1 = x1;
	}


	public int getY1() {
		return y1;
	}


	public void setY1(int y1) {
		this.y1 = y1;
	}


	public int getX2() {
		return x2;
	}


	public void setX2(int x2) {
		this.x2 = x2;
	}


	public int getY2() {
		return y2;
	}


	public void setY2(int y2) {
		this.y2 = y2;
	}


	public String getSmallurlPath() {
		return smallurlPath;
	}


	public void setSmallurlPath(String smallurlPath) {
		this.smallurlPath = smallurlPath;
	}


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public PublishCat_PublishService getPublishCatPublishService() {
		return publishCatPublishService;
	}


	public void setPublishCatPublishService(
			PublishCat_PublishService publishCatPublishService) {
		this.publishCatPublishService = publishCatPublishService;
	}


	public List<PublishCat> getPublishCats() {
		return publishCats;
	}


	public void setPublishCats(List<PublishCat> publishCats) {
		this.publishCats = publishCats;
	}


	public Publish getPublishTest() {
		return publishTest;
	}


	public void setPublishTest(Publish publishTest) {
		this.publishTest = publishTest;
	}


	public int[] getIds() {
		return ids;
	}


	public void setIds(int[] ids) {
		this.ids = ids;
	}
	
	 
	
	
}//end class
