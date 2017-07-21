package com.wetuo.wepic.core.beans;

import java.util.HashSet;
import java.util.Set;

import org.apache.struts2.json.annotations.JSON;

/**
 * BlogCat entity. @author MyEclipse Persistence Tools
 */

public class BlogCat implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String blogCat;
	private User user;
	private String context;
	private Set blogs = new HashSet(0);

	// Constructors

	/** default constructor */
	public BlogCat() {
	}

	

	public BlogCat(Integer id, String blogCat, User user, String context) {
		super();
		this.id = id;
		this.blogCat = blogCat;
		this.user = user;
		this.context = context;
	}



	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBlogCat() {
		return this.blogCat;
	}

	public void setBlogCat(String blogCat) {
		this.blogCat = blogCat;
	}

	

	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public String getContext() {
		return this.context;
	}

	public void setContext(String context) {
		this.context = context;
	}
	@JSON(serialize=false)
	public Set getBlogs() {
		return this.blogs;
	}
	@JSON(serialize=false)
	public void setBlogs(Set blogs) {
		this.blogs = blogs;
	}

}