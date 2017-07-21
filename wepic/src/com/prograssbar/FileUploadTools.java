package com.prograssbar;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

public class FileUploadTools {

	private String username;

	private File uploadFile[];// 允许上传多个文件，所以是数组类型

	private String uploadFileFileName[];// 允许上传多个文件，所以文件名是数组类型

	private String uploadFileContentType[];// 允许上传多个文件，文件的类型是数组类型

	public String[] getUploadFileContentType() {
		return uploadFileContentType;
	}

	public void setUploadFileContentType(String[] uploadFileContentType) {
		this.uploadFileContentType = uploadFileContentType;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public File[] getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(File[] uploadFile) {
		this.uploadFile = uploadFile;
	}

	public String[] getUploadFileFileName() {
		return uploadFileFileName;
	}

	public void setUploadFileFileName(String[] uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}

	public String beginUpload() throws IOException {
		// 开始上传
		System.out.println("username的值是：" + username);
		// 取得上传的目录
		String targetDirectory = ServletActionContext.getRequest().getRealPath(
				"/upload");
		// 循环取得每个文件，然后依次上传
		for (int i = 0; i < uploadFile.length; i++) {

			File target = new File(targetDirectory, new SimpleDateFormat(
					"yyyy_MM_dd_HH_mm_ss").format(new Date()).toString()
					+ System.nanoTime() + uploadFileFileName[i]);

			FileUtils.copyFile(uploadFile[i], target);
		}

		return "register";
	}

}
