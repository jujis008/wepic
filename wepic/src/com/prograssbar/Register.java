package com.prograssbar;

import java.io.IOException;

import com.opensymphony.xwork2.ActionSupport;

public class Register extends ActionSupport {
	// 上传工具的引用
	private FileUploadTools fileUploadTools = new FileUploadTools();

	public FileUploadTools getFileUploadTools() {
		return fileUploadTools;
	}

	public void setFileUploadTools(FileUploadTools fileUploadTools) {
		this.fileUploadTools = fileUploadTools;
	}

	@Override
	public void validate() {

	}

	public String execute() throws IOException {
		// 调用beginUpload方法开始上传
		fileUploadTools.beginUpload();

		return "register";
	}

}
