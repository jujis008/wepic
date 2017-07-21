package com.wetuo.wepic.publish.beans ;
 
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
 
public class VideoCat_Video  implements Serializable {
	private static final long serialVersionUID = 1L;
	protected int id;
	protected VideoCat VideoCat;
	protected Video video;
	protected String relation;
	public VideoCat_Video(){
		super();
	}
	/////getter////setter//////
 
	public int  getId(){
		return this.id;
	}
	public void  setId(int id){
		this.id = id ;
	}
 
	public VideoCat getVideoCat() {
		return VideoCat;
	}

	public void setVideoCat(VideoCat videoCat) {
		VideoCat = videoCat;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public String  getRelation(){
		return this.relation;
	}
	public void  setRelation(String relation){
		this.relation = relation ;
	}
	public String toString() {
		return new ToStringBuilder(this)
			.append("id", getId())
			.toString();
	}//
	
 
}//end class
