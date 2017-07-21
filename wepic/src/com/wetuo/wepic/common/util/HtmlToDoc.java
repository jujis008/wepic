package com.wetuo.wepic.common.util;

import java.io.BufferedReader;

import java.io.ByteArrayInputStream;

import java.io.File;

import java.io.FileOutputStream;

import java.io.FileReader;

import java.io.IOException;

import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.DocumentEntry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class HtmlToDoc {
	/**
	 * 
	 * 读取html文件到word
	 * 
	 * @param filepath
	 *            html文件的路径
	 * 
	 * @return
	 * ,String targetpath,String title
	 * @throws Exception
	 */

	public boolean writeWordFile(String filepath,String source,String title) throws Exception {
		boolean flag = false;

		ByteArrayInputStream bais = null;

		FileOutputStream fos = null;

		String path = "C:/"; // 根据实际情况写路径

		try {

			if (!"".equals(source)) {

				File fileDir = new File(source);

				if (fileDir.exists()) {

					String content = readFile(filepath);
					byte b[] = content.getBytes();
					
					bais = new ByteArrayInputStream(b);

					POIFSFileSystem poifs = new POIFSFileSystem();
					DirectoryEntry directory = poifs.getRoot();
					directory.createDocument("WordDocument", bais);
					fos = new FileOutputStream(source+"/"+title+".doc");

					poifs.writeFilesystem(fos);

					bais.close();

					fos.close();

				}

			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			if (fos != null)
				fos.close();

			if (bais != null)
				bais.close();

		}
		return flag;

	}

	public String readFile(String filename) throws Exception {

		StringBuffer buffer = new StringBuffer("");

		BufferedReader br = null;

		try {

			br = new BufferedReader(new FileReader(filename));

			buffer = new StringBuffer();

			while (br.ready())

				buffer.append((char) br.read());

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			if (br != null)
				br.close();

		}

		return buffer.toString();

	}

	/**
	 * 将静态页面转换为word
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
//		new HtmlToDoc().writeWordFile("D:/myeclipseworkspace/wepic/WebRoot/pageconvertword.html");
		System.out.println("success");

	}

}
