package com.wetuo.wepic.publish.beans ;
 
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
 
public class PublishCat_Story  implements Serializable {
	private static final long serialVersionUID = 1L;
	protected int id;
	protected PublishCat publishCat;
	protected Story story;

	public Story getStory() {
		return story;
	}

	public void setStory(Story story) {
		this.story = story;
	}

	protected String relation;
	public PublishCat_Story(){
		super();
	}
	/////getter////setter//////
 
	public int  getId(){
		return this.id;
	}
	public void  setId(int id){
		this.id = id ;
	}
 
	public PublishCat  getPublishCat(){
		return this.publishCat;
	}
	public void  setPublishCat(PublishCat publishCat){
		this.publishCat = publishCat ;
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

	public PublishCat_Story(PublishCat publishCat, Story story) {
		super();
		this.publishCat = publishCat;
		this.story=story;
		
	}
	
 
}//end class
