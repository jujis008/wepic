package com.wetuo.wepic.core.beans ;
 
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
import com.wetuo.wepic.publish.beans.Publish;
 
public class PublishFavorite  implements Serializable {
 
	/////instantce variable//////
	private static final long serialVersionUID = 1L;
	private Integer id;
	protected Publish publish;
	private String description;
 
	////start OneToMany
	private User user;//
	public User getUser() {
		return user;
	}//end get()
	public void setUser(User user) {
		this.user = user;
	}//end set()
	/////////constructor//////////////////
	
	public PublishFavorite(Integer id,Publish publish,String description) {
		this.id = id;
		this.publish = publish;
		this.description = description;
	}//
	
	public PublishFavorite(){
		super();
	}
 
	/////getter////setter//////
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Publish  getPublish(){
		return this.publish;
	}
	public void  setPublish(Publish publish){
		this.publish = publish ;
	}
	public String  getDescription(){
		return this.description;
	}
	public void  setDescription(String description){
		this.description = description ;
	}
 
}//end class
