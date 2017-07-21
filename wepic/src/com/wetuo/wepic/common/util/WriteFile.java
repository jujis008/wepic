package com.wetuo.wepic.common.util;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
public class WriteFile {
private String filename = null;
	
	public WriteFile(String filename) {
		this.filename = filename;
	}
	
	public void writeFileByName(String content) {
		File docFile = new File(filename);
		try {
			docFile.createNewFile();
			FileOutputStream txtfile = new FileOutputStream(docFile);
			PrintStream p = new PrintStream(txtfile);
			p.println(content);
			txtfile.close();
			p.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException {
		File newFile = new File("Text.txt");   
			 
			String data ="你好,Android.2011";
			 
			FileWriter write = new FileWriter(newFile,true);
			 
			BufferedWriter bufferedWriter = new BufferedWriter(write);
			 
			bufferedWriter.write(data);
	}
}
