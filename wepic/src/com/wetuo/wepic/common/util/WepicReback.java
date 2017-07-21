package com.wetuo.wepic.common.util;

public class WepicReback {
	// path="{'url':'"+path.split(",")[0]+"','fileType':'"+this.getUpfileContentType()+"','state':'SUCCESS','original':'"+upfileFileName+"'}";
  private String url;
  private String fileType;
  private String state;
  private String original;
  private String publishId;
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public String getFileType() {
	return fileType;
}
public void setFileType(String fileType) {
	this.fileType = fileType;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getOriginal() {
	return original;
}
public void setOriginal(String original) {
	this.original = original;
}
public String getPublishId() {
	return publishId;
}
public void setPublishId(String publishId) {
	this.publishId = publishId;
}
  
  
  

}
