package com.wetuo.wepic.common.util;

import java.io.File;
import org.apache.tools.zip.ZipOutputStream; //这个包在ant.jar里，要到官方网下载
import java.io.FileInputStream;
import java.io.FileOutputStream;
public class zipcompression {
	/**
	 * zip压缩文件
	 */
	public zipcompression() {}

	   
    public void zip(String inputFileName,String zipfilename) throws Exception {
        zip(zipfilename, new File(inputFileName));
    }

    private void zip(String zipFileName, File inputFile) throws Exception {
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFileName));
        out.setEncoding("utf-8");
        zip(out, inputFile, "");
        out.close();
    }

    private void zip(ZipOutputStream out, File f, String base) throws Exception {
        if (f.isDirectory()) {
           File[] fl = f.listFiles();
           out.putNextEntry(new org.apache.tools.zip.ZipEntry(base + "/"));
           base = base.length() == 0 ? "" : base + "/";
           for (int i = 0; i < fl.length; i++) {
           zip(out, fl[i], base + fl[i].getName());
         }
        }else {
           out.putNextEntry(new org.apache.tools.zip.ZipEntry(base));
           FileInputStream in = new FileInputStream(f);
           int b;
           while ( (b = in.read()) != -1) {
            out.write(b);
         }
         in.close();
       }
    }

    public static void main(String [] temp){
//    	zipcompression book = new zipcompression();
//        try {
//           book.zip("d:\\hhx");//你要压缩的文件夹
//        }catch (Exception ex) {
//           ex.printStackTrace();
//       }
    }
}
