package com.wetuo.wepic.common.util;
import java.io.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.Graphics;
import javax.imageio.ImageIO;
public class ImageCut1 {
	public static void abscut(String srcImageFile, int x, int y, int destWidth,
            int destHeight) {
        try {
            Image img;
            ImageFilter cropFilter;
            // 读取源图像
            BufferedImage bi = ImageIO.read(new File(srcImageFile));
            int srcWidth = bi.getWidth(); // 源图宽度
            int srcHeight = bi.getHeight(); // 源图高度
            System.out.println("srcWidth= " + destWidth + "/tsrcHeight= "
                    + destHeight);
            if (srcWidth >= destWidth && srcHeight >= destHeight) {
                Image image = bi.getScaledInstance(srcWidth, srcHeight,
                        Image.SCALE_DEFAULT);
                // 改进的想法:是否可用多线程加快切割速度
                // 四个参数分别为图像起点坐标和宽高
                // 即: CropImageFilter(int x,int y,int width,int height)
                cropFilter = new CropImageFilter(x, y, destWidth, destHeight);
                img = Toolkit.getDefaultToolkit().createImage(
                        new FilteredImageSource(image.getSource(), cropFilter));
                BufferedImage tag = new BufferedImage(destWidth, destHeight,
                        BufferedImage.TYPE_INT_RGB);
                Graphics g = tag.getGraphics();
                g.drawImage(img, destWidth,destHeight, null); // 绘制缩小后的图
                g.dispose();
                // 输出为文件
                ImageIO.write(tag, "JPEG", new File(srcImageFile));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
