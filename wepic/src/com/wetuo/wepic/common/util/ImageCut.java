package com.wetuo.wepic.common.util;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;  
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.io.File;  
import java.io.IOException;  
import javax.imageio.ImageIO;  

import org.apache.struts2.ServletActionContext;
public class ImageCut {
	 private String srcpath;  
	    // ===剪切图片存放路径名称.如:c:\2.jpg  
	    private String subpath;  
	    // ===剪切点x坐标  
	    private int x;  
	    private int y;  
	    private int w;
	    private int h;
	    public ImageCut() {  
	    }  
	    public void cutImage(String imagePath, int x ,int y ,int w,int h){  
	        try {  
	            Image img;  
	            ImageFilter cropFilter;  
	            // 读取源图像  
	            String path=ServletActionContext.getRequest().getRealPath("userInfoImg");
	            int index=imagePath.indexOf("userInfoImg");
	            String newName=imagePath.substring(index,imagePath.length());
	            int a=newName.indexOf("/");
	            System.out.println(a);
	            String b=newName.substring(a+1,newName.length());
	            String c=path+"/"+b;
	            System.out.println(index);
	            System.out.println(path);
	            BufferedImage bi = ImageIO.read(new File(c));  
	            int srcWidth = bi.getWidth();      // 源图宽度  
	            int srcHeight = bi.getHeight();    // 源图高度  
	              
	            //若原图大小大于切片大小，则进行切割  
	            if (srcWidth >= w && srcHeight >= h) {  
	                Image image = bi.getScaledInstance(srcWidth, srcHeight,Image.SCALE_DEFAULT);  
	                  
	                int x1 = x*srcWidth/133;  
	                int y1 = y*srcHeight/133;  
	                int w1 = w*srcWidth/133;  
	                int h1 = h*srcHeight/133;  
	                  
	                cropFilter = new CropImageFilter(x1, y1, w1, h1);  
	                img = Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(image.getSource(), cropFilter));  
	                BufferedImage tag = new BufferedImage(w1, h1,BufferedImage.TYPE_INT_RGB);  
	                Graphics g = tag.getGraphics();  
	                g.drawImage(img, 0, 0, null); // 绘制缩小后的图  
	                g.dispose();  
	                // 输出为文件  
	                ImageIO.write(tag, "JPEG", new File(c));  
	            }  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  
	    }  
//	    /** 对图片裁剪，并把裁剪完的新图片保存 */  
//	    public void cut() throws IOException {  
//	    	int X=Integer.parseInt(ServletActionContext.getRequest().getParameter("x"));
//	    	int Y=Integer.parseInt(ServletActionContext.getRequest().getParameter("y"));
//	    	int W=Integer.parseInt(ServletActionContext.getRequest().getParameter("w"));
//	    	int H=Integer.parseInt(ServletActionContext.getRequest().getParameter("h"));
//	        FileInputStream is = null;  
//	        ImageInputStream iis = null;  
//	        try {  
//	            // 读取图片文件  
//	            is = new FileInputStream(srcpath);  
//	            /* 
//	             * 返回包含所有当前已注册 ImageReader 的 Iterator，这些 ImageReader 声称能够解码指定格式。 
//	             * 参数：formatName - 包含非正式格式名称 . （例如 "jpeg" 或 "tiff"）等 。 
//	             */  
//	            Iterator<ImageReader> it = ImageIO.getImageReadersByFormatName("jpg");  
//	            ImageReader reader = it.next();  
//	            // 获取图片流  
//	            iis = ImageIO.createImageInputStream(is);  
//	            /* 
//	             * <p>iis:读取源.true:只向前搜索 </p>.将它标记为 ‘只向前搜索’。 
//	             * 此设置意味着包含在输入源中的图像将只按顺序读取，可能允许 reader 避免缓存包含与以前已经读取的图像关联的数据的那些输入部分。 
//	             */  
//	            reader.setInput(iis, true);  
//	            /* 
//	             * <p>描述如何对流进行解码的类<p>.用于指定如何在输入时从 Java Image I/O 
//	             * 框架的上下文中的流转换一幅图像或一组图像。用于特定图像格式的插件 将从其 ImageReader 实现的 
//	             * getDefaultReadParam 方法中返回 ImageReadParam 的实例。 
//	             */  
//	            ImageReadParam param = reader.getDefaultReadParam();  
//	            /* 
//	             * 图片裁剪区域。Rectangle 指定了坐标空间中的一个区域，通过 Rectangle 对象 
//	             * 的左上顶点的坐标（x，y）、宽度和高度可以定义这个区域。 
//	             */  
//	            Rectangle rect = new Rectangle(X, Y,W,H);  
//	            // 提供一个 BufferedImage，将其用作解码像素数据的目标。  
//	            param.setSourceRegion(rect);  
//	            /* 
//	             * 使用所提供的 ImageReadParam 读取通过索引 imageIndex 指定的对象，并将 它作为一个完整的 
//	             * BufferedImage 返回。 
//	             */  
//	            BufferedImage bi = reader.read(0, param);  
//	            // 保存新图片  
//	            ImageIO.write(bi, "jpg", new File(subpath));  
//	        } finally {  
//	            if (is != null)  
//	                is.close();  
//	            if (iis != null)  
//	                iis.close();  
//	        }  
//	  
//	    }
		public String getSrcpath() {
			return srcpath;
		}
		public void setSrcpath(String srcpath) {
			this.srcpath = srcpath;
		}
		public String getSubpath() {
			return subpath;
		}
		public void setSubpath(String subpath) {
			this.subpath = subpath;
		}
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
		public int getW() {
			return w;
		}
		public void setW(int w) {
			this.w = w;
		}
		public int getH() {
			return h;
		}
		public void setH(int h) {
			this.h = h;
		}
		 public static void main(String[] args) {  
			  try {  
			   System.out.println(saveImage(new File("d:\\15.jpg"),"d:\\abc2.jpg",2,2,274,217));  
//			   System.out.println(saveImage(new File("d:\\abc.jpg"),"d:\\abc3.jpg",87,106,289,217));
//			   System.out.println(saveImage(new File("d:\\abc.jpg"),"d:\\abc4.jpg",87,106,289,217));
//			   System.out.println(saveImage(new File("d:\\abc.jpg"),"d:\\abc5.jpg",87,106,289,217));
//			   System.out.println(saveImage(new File("d:\\abc.jpg"),"d:\\abc6.jpg",87,106,289,217));
//			   System.out.println(saveImage(new File("d:\\abc.jpg"),"d:\\abc7.jpg",87,106,289,217));
			  } catch (IOException e) {  
			   // TODO Auto-generated catch block  
			   e.printStackTrace();  
			  }  
			 } 
		 public static boolean saveImage(File img,      
		            String dest,      
		            int top,      
		            int left,      
		            int width,      
		            int height) throws IOException {     
		  File fileDest = new File(dest);     
		  if(!fileDest.getParentFile().exists())     
		      fileDest.getParentFile().mkdirs();     
		  String ext = Utils.getExtension(dest).toLowerCase();     
		  BufferedImage bi = (BufferedImage)ImageIO.read(img);     
		  height = Math.min(height, bi.getHeight());     
		  width = Math.min(width, bi.getWidth());     
		  if(height <= 0) height = bi.getHeight();     
		  if(width <= 0) width = bi.getWidth();     
		  top = Math.min(Math.max(0, top), bi.getHeight()-height);     
		  left = Math.min(Math.max(0, left), bi.getWidth()-width);     
		       
		  BufferedImage bi_cropper = bi.getSubimage(left, top, width, height);     
		  return ImageIO.write(bi_cropper, ext.equals("png")?"png":"jpeg", fileDest);     
		 }    
}
