package com.wetuo.wepic.publish.beans ;
import java.io.Serializable;
public class StorySystemFilterWords  implements Serializable {
 
	/////instantce variable//////
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String words;
	private String remark;
	
	public StorySystemFilterWords(Integer id,String words) {
		this.id = id;
		this.words = words;
	}//
	
	public StorySystemFilterWords(){
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWords() {
		return words;
	}

	public void setWords(String words) {
		this.words = words;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
 
}//end class
