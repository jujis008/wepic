package com.wetuo.wepic.publish.beans ;
 
import java.io.Serializable;
import java.sql.Blob;

import org.apache.commons.lang.builder.ToStringBuilder;
 
public class PublishDetail  implements Serializable {
 
	/////instantce variable//////
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String value;
	private String picUrl;
	//private Blob picture;   
	private String position;
	private Integer order2;
    private Integer marquee;
    private Integer layout;
	////start OneToMany
	private Publish publish;//
	public Publish getPublish() {
		return publish;
	}//end get()
	public void setPublish(Publish publish) {
		this.publish = publish;
	}//end set()
	/////////constructor//////////////////
	
	public PublishDetail(Integer id,String name,String value,String picUrl,String position,Integer order2) {
		this.id = id;
		this.name = name;
		this.value = value;
		this.picUrl = picUrl;
		this.position = position;
		this.order2 = order2;
	}//
	
	public PublishDetail(){
		super();
	}
 
	/////getter////setter//////
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String  getName(){
		return this.name;
	}
	public void  setName(String name){
		this.name = name ;
	}
	public String  getValue(){
		return this.value;
	}
	public void  setValue(String value){
		this.value = value ;
	}
	public String  getPicUrl(){
		return this.picUrl;
	}
	public void  setPicUrl(String picUrl){
		this.picUrl = picUrl ;
	}
	public String  getPosition(){
		return this.position;
	}
	public void  setPosition(String position){
		this.position = position ;
	}
	public Integer  getOrder2(){
		return this.order2;
	}
	public void  setOrder2(Integer order2){
		this.order2 = order2 ;
	}
//	public Blob getPicture() {
//		return picture;
//	}
//	public void setPicture(Blob picture) {
//		this.picture = picture;
//	}
	public Integer getMarquee() {
		return marquee;
	}
	public void setMarquee(Integer marquee) {
		this.marquee = marquee;
	}
	public Integer getLayout() {
		return layout;
	}
	public void setLayout(Integer layout) {
		this.layout = layout;
	}
	
	
 
}//end class
