package com.wetuo.wepic.publish.beans ;
 
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
 
public class PublishCat_Publish  implements Serializable {
	private static final long serialVersionUID = 1L;
	protected int id;
	protected PublishCat publishCat;
	protected Publish publish;
	protected String relation;
	public PublishCat_Publish(){
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
 
	public Publish  getPublish(){
		return this.publish;
	}
	public void  setPublish(Publish publish){
		this.publish = publish ;
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

	public PublishCat_Publish(PublishCat publishCat, Publish publish) {
		super();
		this.publishCat = publishCat;
		this.publish = publish;
	}
	
 
}//end class
