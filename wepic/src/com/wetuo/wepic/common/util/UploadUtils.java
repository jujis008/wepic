package com.wetuo.wepic.common.util;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

import org.apache.commons.io.FileUtils;  
  
import javax.imageio.ImageIO;
import javax.media.jai.JAI;  
import javax.media.jai.RenderedOp;  
import javax.swing.ImageIcon;
import com.sun.media.jai.codec.ImageCodec;  
import com.sun.media.jai.codec.ImageEncoder;  
import com.sun.media.jai.codec.JPEGEncodeParam;  
import com.wetuo.wepic.publish.beans.CutImg;

public class UploadUtils  {
	
	public  void copyFile(File file,File target)  {
		try{
			InputStream is = new FileInputStream(file);

			OutputStream os = new FileOutputStream(target);
			byte[] b = new byte[1024];
			int len = 0;
			while((len = is.read(b)) != -1){
				os.write(b, 0, len);
			}
			os.flush();
			os.close();
			is.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	private  static String[] str=new String[]{"psd","ai","cdr","max","eps"};
	private  static String[] appendstr=new String[]{"psd","ai","cdr","max","eps","jpg","jpeg","png",
		"pdf","tif","tiff","rar","zip","doc","docx","ppt","pptx","excel","excelx","xls","xlsx"};
	private String pathFizx;
	/**
	 * tif转成jpg
	 * @param tifpath
	 * @param jpgpath
	 * @return
	 * @throws Exception 
	 */
	
	
	// private String[] filetype={"jpg","gif","jpeg","bmp",""}
	public static String convert(String tifpath) throws Exception {
		String input=tifpath;
		String output="";
		int temp=tifpath.lastIndexOf(".");
		String tempPath=tifpath.substring(0,temp)+"."+"jpg";
		System.out.println(tempPath);
		RenderedOp src2 = JAI.create("fileload", input);  
	    OutputStream os2 = new FileOutputStream(tempPath);  
	    JPEGEncodeParam param2 = new JPEGEncodeParam();  
	    //指定格式类型，jpg 属于 JPEG 类型  
	    ImageEncoder enc2 = ImageCodec.createImageEncoder("JPEG", os2, param2);  
	    enc2.encode(src2);  
	    os2.close();  
		return tempPath;
	}
	//生成小样图
	public String createSmalldrawUrl(File file){
		String path=getPath(file.getAbsolutePath(),"small");
		int suowidth=getWidth(file, 1000, 1000);
		int suoheight=getHeight(file, 1000, 1000);
       
        try {
        	///storage/wepicimages/wepic/small
			Thumbnails.of(file)
			.size(suowidth,suoheight)
			.keepAspectRatio(true) //默认是true,按比例缩小
			//.outputFormat("JPEG")
			.toFile(path.split(",")[1]);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pathFizx=path.split(",")[1];
		return path.split(",")[0];
	}
	
	public String createCutPic(File file){
		String path=getPath2(file.getAbsolutePath(),"cut285175");
		int suowidth=getWidth(file, 800, 800);
		int suoheight=getHeight(file, 800, 800);
       
        try {
        	///storage/wepicimages/wepic/small
			Thumbnails.of(file)
			.size(suowidth,suoheight)
			.keepAspectRatio(true) //默认是true,按比例缩小
			//.outputFormat("JPEG")
			.toFile(path.split(",")[1]);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path.split(",")[0];
	}
	public String cutcomplete(File file,Integer x1,Integer x2,Integer y1,Integer y2) throws Exception {
		String path=getPath2(file.getAbsolutePath(),"cut285175");
		BufferedImage bufferedImage = null;
		bufferedImage = ImageIO.read(new FileInputStream(new File(file.getAbsolutePath())));
		try {
			if (bufferedImage.getWidth() > 285 && bufferedImage.getHeight() >175) {
				Thumbnails.of(file)
				.sourceRegion(x1,y1,x2-x1,y2-y1)
				.size(x2-x1,y2-y1)
				    .keepAspectRatio(true) //默认是true,按比例缩小
				    .toFile(path.split(",")[1]);	
				File file2=new File(file.getAbsolutePath());
					file.delete();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path.split(",")[0];
	}
	public String getPathFizx(){
		
		
		
		return pathFizx;
	}
	
	public int getWidth(File file,int widthbi,int heightbi){
		
		ImageIcon img= new ImageIcon(file.getAbsolutePath());
		int width= img.getIconWidth();
		int height= img.getIconHeight();
		int cutWidth=widthbi;
		int cutheight=heightbi;
		if(width<widthbi&&height<heightbi){
			cutWidth=width;
			cutheight=height;
			
			
		}
		
		return cutWidth;
		
	}
	
	
public int getHeight(File file,int widthbi,int heightbi){
		
		ImageIcon img= new ImageIcon(file.getAbsolutePath());
		int width= img.getIconWidth();
		int height= img.getIconHeight();
		int cutWidth=widthbi;
		int cutheight=heightbi;
		if(width<widthbi&&height<heightbi){
			cutWidth=width;
			cutheight=height;
		}
		
		return cutheight;
		
	}
	
	//生成缩略图285
	public String createThumbnailUrl(File file){
		String path=getPath(file.getAbsolutePath(),"thumbnail");
		int suowidth=getWidth(file, 285, 285);
		int suoheight=getHeight(file, 285, 285);
       
        try {
        	//file.
        	BufferedImage image=ImageIO.read(new FileInputStream(file));
        	int width=image.getWidth();
        	int height=image.getHeight();
        	int cutwidth=width;
        	if(width>height){
        		cutwidth=height;
        	}	
			Thumbnails.of(file)
			.sourceRegion(Positions.CENTER, cutwidth,cutwidth)  
			.size(suowidth,suoheight)
			.keepAspectRatio(true) //默认是true,按比例缩小
			//.outputFormat("JPEG")
			.toFile(path.split(",")[1]);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path.split(",")[0];
	}
	
	
	//生成缩略图125
	public String createThumbnailUrl125(File file){
		String path=getPath(file.getAbsolutePath(),"thumbnail125");
		int suowidth=getWidth(file, 125, 125);
		int suoheight=getHeight(file, 125, 125);
       
        try {
        	//file.
        	BufferedImage image=ImageIO.read(new FileInputStream(file));
        	int width=image.getWidth();
        	int height=image.getHeight();
        	int cutwidth=width;
        	if(width>height){
        		cutwidth=height;
        	}	
			Thumbnails.of(file)
			.sourceRegion(Positions.CENTER, cutwidth,cutwidth)  
			.size(suowidth,suoheight)
			.keepAspectRatio(true) //默认是true,按比例缩小
			//.outputFormat("JPEG")
			.toFile(path.split(",")[1]);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path.split(",")[0];
	}
	
	//生成缩略图125
	public String userCreateThumbnailUrl125(File file, CutImg cutImg){
		String path=getPath(file.getAbsolutePath(),"thumbnail125");
		
       
        try {
//        	//file.
//        	BufferedImage image=ImageIO.read(new FileInputStream(file));
//        	int width=image.getWidth();
//        	int height=image.getHeight();
//        	int cutwidth=width;
//        	if(width>height){
//        		cutwidth=height;
//        	}	
        	
			Thumbnails.of(file)
			.sourceRegion(cutImg.getX1(),cutImg.getY1(),cutImg.getX2(), cutImg.getY2())
			.size(125,125)
			.keepAspectRatio(true) //默认是true,按比例缩小
			//.outputFormat("JPEG")
			.toFile(path.split(",")[1]);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path.split(",")[0];
	}
	
	//生成缩略图285
	public String UsercreateThumbnailUrl(File file,CutImg cutImg){
		String path=getPath(file.getAbsolutePath(),"thumbnail");
		
       
        try {
        	//file.
//        	BufferedImage image=ImageIO.read(new FileInputStream(file));
//        	int width=image.getWidth();
//        	int height=image.getHeight();
//        	int cutwidth=width;
//        	if(width>height){
//        		cutwidth=height;
//        	}	
			Thumbnails.of(file)
			.sourceRegion(cutImg.getX1(),cutImg.getY1(),cutImg.getX2(), cutImg.getY2()) 
			.size(285,285)
			.keepAspectRatio(true) //默认是true,按比例缩小
			//.outputFormat("JPEG")
			.toFile(path.split(",")[1]);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path.split(",")[0];
	}
	//800*800
	public String createTemSmall(String url,String path,String webPath) throws IOException{
		String currentAbsoulutePath=Thread.currentThread().getContextClassLoader().getResource("").getPath();
		 PropertiesRead readPro = new PropertiesRead(currentAbsoulutePath+"picpath.properties");//相对路径
		 String small = readPro.getValue("small");//以下读取properties文件的值
		 File file=new File(small+url);
		 
		 int suowidth=getWidth(file, 800, 800);
		 int suoheight=getHeight(file, 800, 800);
			
			
		 System.out.println(path+"/"+file.getName());
		   Thumbnails.of(file)
			.size(suowidth,suoheight)
			.keepAspectRatio(true) //默认是true,按比例缩小
			.toFile(path+"/"+file.getName());
   		
		
		return file.getName()+","+webPath+"/temImg/"+file.getName();
	}
	public String getPath2(String upfileFileName,String key){
		String currentAbsoulutePath=Thread.currentThread().getContextClassLoader().getResource("").getPath();
        PropertiesRead readPro = new PropertiesRead(currentAbsoulutePath+"picpath.properties");//相对路径
		 String small = readPro.getValue(key);//以下读取properties文件的值
		 String topOriginalFile=small;
		 String websmall = readPro.getValue("web"+key);//以下读取properties文件的值
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
		// String name1 = format.format(date);
		
		//String baseName = getRandomStr();
		String picType = upfileFileName.substring(upfileFileName.lastIndexOf(".")+1);
		//原图(不显示，存在数据库中)
		String picName = name1+"."+picType;//图片名称
		String resPath = websmall+"/"+currentYear+"/"+currentMonth+"/"+currentDay+"/"+picName;
		                             
		String retuenPath=resPath+","+originalPath+"/"+picName;
		return retuenPath;
		
	}
	public String getPath(String upfileFileName,String key){
		String currentAbsoulutePath=Thread.currentThread().getContextClassLoader().getResource("").getPath();
        PropertiesRead readPro = new PropertiesRead(currentAbsoulutePath+"picpath.properties");//相对路径
		 String small = readPro.getValue(key);//以下读取properties文件的值
		 String topOriginalFile=small;
		 String websmall = readPro.getValue("web"+key);//以下读取properties文件的值
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
		// String name1 = format.format(date);
		
		//String baseName = getRandomStr();
		String picType = upfileFileName.substring(upfileFileName.lastIndexOf(".")+1);
		//原图(不显示，存在数据库中)
		String picName = name1+"."+picType;//图片名称
		String resPath = websmall+"/"+currentYear+"/"+currentMonth+"/"+currentDay+"/"+picName;
		                             
		String retuenPath=resPath+","+originalPath+"/"+picName;
		return retuenPath;
		
	}
	public String getSaveAndWebPath(String pathName){
		
		String currentAbsoulutePath=Thread.currentThread().getContextClassLoader().getResource("").getPath();
		PropertiesRead readPro = new PropertiesRead(currentAbsoulutePath+"picpath.properties");//相对路径
		 String path = readPro.getValue(pathName);//以下读取properties文件的值
		
		
		return path;
	}
	public static String getFileType(String upfileFileName){
		
		
		
		return upfileFileName.substring(upfileFileName.lastIndexOf(".")+1);
	}
	
	public  boolean checkFiletype(String filetype){
		for(int i=0;i<str.length;i++){
			if(filetype.toLowerCase().equals(str[i])){
				
				return false;
			}
			
			
		}
		return true;
	}
	public void deleteFile(String urlFile,String key){
		String url=getSaveAndWebPath(key);
		// String[] str=urlFile.split("/"+key);
		 File file=new File(url+"/"+urlFile);
		 System.out.println(file.getAbsolutePath());
		 if(file.exists()){
			 file.delete(); 
		 }
		
		
	}
	
	
	
	/******
	 * 
	 * 
	 * 
	 * 
	 * @param publishwish1
	 * @return
	 * 
	 * 
	
	public String  uploadImage(int publishwish1) {
		//如果上传的图片为tif格式的图片，则转换成为jpg格式的图片
		
		String convertImagName="";//转换之后图片的名称
		String convertImagType="";//转换之后图片的类型
		publishwish=publishwish1;
		String resPath="";
		List resPathList=new LinkedList();
		try{
			HttpServletRequest request=ServletActionContext.getRequest();
			//获取项目根目录
			String path=request.getContextPath();
			//当前访问项目的urlhttp://hehaixia1314.xicp.net:23512/photography/
			String basePath=request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+path + "/";
			//(取得上传的目录
		
			String currentAbsoulutePath=Thread.currentThread().getContextClassLoader().getResource("").getPath();
	        PropertiesRead readPro = new PropertiesRead(currentAbsoulutePath+"properties/picpath.properties");//相对路径
	        String originalPro = readPro.getValue("original");//以下读取properties文件的值
	        String thumbnailPro=readPro.getValue("thumbnail");
	        String smallPro=readPro.getValue("small");
	        String waterPro=readPro.getValue("water");
	        String fixwidthPro=readPro.getValue("fixwidth");
	        
	        String weboriginal=readPro.getValue("weboriginal");
	        String webthumbnail=readPro.getValue("webthumbnail");
	        String websmall=readPro.getValue("websmall");
	        String webwater=readPro.getValue("webwater");
	        String webfixwidth=readPro.getValue("webfixwidth");
	        
	        System.out.println(originalPro);
			String targetDirectory = ServletActionContext.getServletContext().getRealPath("/storage/wepicimages/wepic");
			
			
			String topOriginalFile=ServletActionContext.getServletContext().getRealPath(originalPro);
			String topThumbnailFile=ServletActionContext.getServletContext().getRealPath(thumbnailPro);
			String topSmallFile=ServletActionContext.getServletContext().getRealPath(smallPro);
			String topWaterFile=ServletActionContext.getServletContext().getRealPath(waterPro);
			String topFixWidthFile=ServletActionContext.getServletContext().getRealPath(fixwidthPro);
			
			
			
			Calendar c=Calendar.getInstance();
			int currentYear=c.get(Calendar.YEAR); 
			int currentMonth=c.get(Calendar.MONTH)+1;
			int currentDay=c.get(Calendar.DATE);
			/**
			 * 原图路径
			 *
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
			/**
			 * 缩略图路径
			 *
			File thumbnailYearFile=new File(topThumbnailFile+"/"+currentYear);
			File thumbnailMonthFile=new File(topThumbnailFile+"/"+currentYear+"/"+currentMonth);
			File thumbnailDayFile=new File(topThumbnailFile+"/"+currentYear+"/"+currentMonth+"/"+currentDay);
			if (!thumbnailYearFile.exists()) {
				thumbnailYearFile.mkdir();
			}
			if (!thumbnailMonthFile.exists()) {
				thumbnailMonthFile.mkdir();
				}
			if (!thumbnailDayFile.exists()) {
			thumbnailDayFile.mkdir();
	     	}
			String thumbnailPath=thumbnailDayFile.getPath();
			
			/**
			 * 小样图路径
			 *
			File smallYearFile=new File(topSmallFile+"/"+currentYear);
			File smallMonthFile=new File(topSmallFile+"/"+currentYear+"/"+currentMonth);
			File smallDayFile=new File(topSmallFile+"/"+currentYear+"/"+currentMonth+"/"+currentDay);
			if (!smallYearFile.exists()) {
				smallYearFile.mkdir();
			}
			if (!smallMonthFile.exists()) {
				smallMonthFile.mkdir();
			}
			if (!smallDayFile.exists()) {
				smallDayFile.mkdir();
			}
			String smallPath=smallDayFile.getPath();
			
			/**
			 * 水印图路径
			 *
			File waterYearFile=new File(topWaterFile+"/"+currentYear);
			File waterMonthFile=new File(topWaterFile+"/"+currentYear+"/"+currentMonth);
			File waterDayFile=new File(topWaterFile+"/"+currentYear+"/"+currentMonth+"/"+currentDay);
			if (!waterYearFile.exists()) {
				waterYearFile.mkdir();
			}
			if (!waterMonthFile.exists()) {
				waterMonthFile.mkdir();
			}
			if (!waterDayFile.exists()) {
				waterDayFile.mkdir();
			}
			String waterPath=waterDayFile.getPath();
			/**
			 * 宽度固定的图片路径
			 *
			File fixwidthYearFile=new File(topFixWidthFile+"/"+currentYear);
			File fixwidthMonthFile=new File(topFixWidthFile+"/"+currentYear+"/"+currentMonth);
			File fixwidthDayFile=new File(topFixWidthFile+"/"+currentYear+"/"+currentMonth+"/"+currentDay);
			
			if (!fixwidthYearFile.exists()) {
				fixwidthYearFile.mkdir();
			}
			if (!fixwidthMonthFile.exists()) {
				fixwidthMonthFile.mkdir();
			}
			if (!fixwidthDayFile.exists()) {
				fixwidthDayFile.mkdir();
			}
			String fixwidthPath=fixwidthDayFile.getPath();
			
			
			
			
			String bigwaterPath=ServletActionContext.getServletContext().getRealPath("/back/images/bigwater.png");
			String smallwaterPath=ServletActionContext.getServletContext().getRealPath("/back/images/smallwater.png");
			Date date = new Date();
			DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
			String name1 = format.format(date);
			
			String baseName = getRandomStr();
			String originalPicType = this.getPictureFileName().substring(this.getPictureFileName().lastIndexOf(".")+1);
			
			//原图(不显示，存在数据库中)
			String picName = name1+baseName+"."+originalPicType;//图片名称
			
			File original=new File(originalPath,picName);//原图
			
			File target=new File(originalPath,picName);//临时图
			UploadUtils.copyFile(picture,original);
			UploadUtils.copyFile(picture,target);
			String jpgpath="";
			//jpgpath=originalPath;
			ImageIcon img;
			if (originalPicType.equals("tif")) {
				jpgpath=UploadUtils.convert(target.getPath());
				convertImagName=picName.substring(0,picName.lastIndexOf("."))+".jpg";
				convertImagType=jpgpath.substring(jpgpath.lastIndexOf(".")+1);
				System.out.println(convertImagType);
				System.out.println(jpgpath);
				img=new ImageIcon(jpgpath);
				width= img.getIconWidth();
				height= img.getIconHeight();
			}else {
				String tempPath=target.getPath();
				convertImagName=picName;
				convertImagType=originalPicType;
				img=new ImageIcon(tempPath);
				width= img.getIconWidth();
				height= img.getIconHeight();
			}
			 
			//缩略图（151*150）
			String thumbnailImg=name1+baseName+"_thumbnail"+"."+convertImagType;
			Thumbnails.of(originalPath+"/"+convertImagName)
	        .size(151,150)
		        .keepAspectRatio(true) //默认是true,按比例缩小
		        .outputFormat("JPEG")
		        .toFile(thumbnailPath+"/"+thumbnailImg);//如果为宽图片，生成的宽度为指定的宽度，高度自适应
			
			
			//水印图（585*585<如果为仅展示，水印在右下角，如果为可购买图片，水印在中间>）
			String watermarkImg=name1+baseName+"_water"+"."+convertImagType;
			if (publishwish==1) {
				Thumbnails.of(new File(originalPath+"/"+convertImagName)) 
		         .size(585,585)
			     .keepAspectRatio(true) 
		         .watermark(Positions.CENTER, ImageIO.read(new File(bigwaterPath)),1.0f) 
		         .outputQuality(1.0f) 
		         .toFile(new File(waterPath+"/"+watermarkImg)); 
			}if (publishwish==2) {
				Thumbnails.of(new File(originalPath+"/"+convertImagName)) 
		         .size(585,585)
			     .keepAspectRatio(true) 
		         .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(smallwaterPath)),1.0f) 
		         .outputQuality(1.0f) 
		         .toFile(new File(waterPath+"/"+watermarkImg)); 
			}
			
			
			//小样图（1000*690）(水印在右下角)
			String smalldrawImg=name1+baseName+"_smalldraw"+"."+convertImagType;
			Thumbnails.of(originalPath+"/"+convertImagName)
	        .size(1000,690)
		        .keepAspectRatio(true) //默认是true,按比例缩小
		        .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(smallwaterPath)),1.0f) 
		        .outputFormat("JPEG")
		        .toFile(smallPath+"/"+smalldrawImg);//如果为宽图片，生成的宽度为指定的宽度，高度自适应
			
			
			
			
			//宽度固定的图（192）
			String fixwidthImg=name1+baseName+"_fixwidth"+"."+convertImagType;
			Thumbnails.of(new File(originalPath+"/"+convertImagName)) 
			 .width(240)	         
		     .keepAspectRatio(true) 
	         .outputQuality(1.0f) 
	         .toFile(new File(fixwidthPath+"/"+fixwidthImg)); 
			
			
			String resOriginalPath = weboriginal+"/"+currentYear+"/"+currentMonth+"/"+currentDay+"/"+picName;
			String resThumbnailPath =webthumbnail+"/"+currentYear+"/"+currentMonth+"/"+currentDay+"/"+thumbnailImg;
			String resWaterPath = webwater+"/"+currentYear+"/"+currentMonth+"/"+currentDay+"/"+watermarkImg;
			String resSmallPath = websmall+"/"+currentYear+"/"+currentMonth+"/"+currentDay+"/"+smalldrawImg;
			String resFixwidthPath =webfixwidth+"/"+currentYear+"/"+currentMonth+"/"+currentDay+"/"+fixwidthImg;
			resPathList.add(resOriginalPath);
			resPathList.add(resThumbnailPath);
			resPathList.add(resWaterPath);
			resPathList.add(resSmallPath);
			resPathList.add(resFixwidthPath);
			 File f = new File(jpgpath);
			 if (f.exists()) {
				f.delete();
			 }
			System.out.println(resPath);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return "xiangyang,shuiyin,";
	}
	
	 * 
	 * 
	 */
	public void deleteFile(File file) {  
	    if (file.exists()) {//判断文件是否存在  
	     if (file.isFile()) {//判断是否是文件  
	      file.delete();//删除文件   
	     } else if (file.isDirectory()) {//否则如果它是一个目录  
	      File[] files = file.listFiles();//声明目录下所有的文件 files[];  
	      for (int i = 0;i < files.length;i ++) {//遍历目录下所有的文件  
	       this.deleteFile(files[i]);//把每个文件用这个方法进行迭代  
	      }  
	      file.delete();//删除文件夹  
	     }  
	    } else {  
	     System.out.println("所删除的文件不存在");  
	    }  
	   }  


//文件上传 之附件上传
public String upAppendix(File myfile,String fileName) throws Exception{
	
	
	//clearErrorsAndMessages();
	String savePath=getSaveAndWebPath("appendix");
	String httpPath=getSaveAndWebPath("webappendix");
	//String fileName=myfile.getName();
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
	boolean bl=false;
	for(int i=0;i<appendstr.length;i++){
		if(picType.toLowerCase().equals(appendstr[i])){
			bl=true;
			break;
		}
		
		
		
		
	}
	if(!bl){
		return "fileError";
		
	}



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
	String resPath = basePath+"/"+picName;
	return resPath+","+fileName+","+picName;
}
}
