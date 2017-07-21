package com.wetuo.wepic.core.beans;

import com.wetuo.wepic.core.beans.User;

/**
 * Blog entity. @author MyEclipse Persistence Tools
 */

public class Blog implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	// Fields

	private Integer blogId;
	private User user;
	private String blogName;
	private String blogContext;
	private String publishTime;
	private Integer hit;
	private Integer share;
	private Integer transport;//转载的原始文件
	private Integer good;
	private Integer type;//1发表博客2是转载
	private BlogCat blogCat;
	private int origBlog;//转载的源文件
	private String context;
	private String picurl;

	// Constructors

	/** default constructor */
	public Blog() {
	}


	public Blog(Integer blogId, User user, String blogName, String blogContext,
			String publishTime, Integer hit, Integer share, Integer transport,
			Integer good, Integer type, BlogCat blogCat, int origBlog) {
		super();
		this.blogId = blogId;
		this.user = user;
		this.blogName = blogName;
		this.blogContext = blogContext;
		this.publishTime = publishTime;
		this.hit = hit;
		this.share = share;
		this.transport = transport;
		this.good = good;
		this.type = type;
		this.blogCat = blogCat;
		this.origBlog = origBlog;
	}


	public Integer getBlogId() {
		return this.blogId;
	}

	public void setBlogId(Integer blogId) {
		this.blogId = blogId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getBlogName() {
		return this.blogName;
	}

	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}

	public String getBlogContext() {
		return this.blogContext;
	}

	public void setBlogContext(String blogContext) {
		this.blogContext = blogContext;
	}

	public String getPublishTime() {
		return this.publishTime;
	}

	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}

	public Integer getHit() {
		return this.hit;
	}

	public void setHit(Integer hit) {
		this.hit = hit;
	}

	public Integer getShare() {
		return this.share;
	}

	public void setShare(Integer share) {
		this.share = share;
	}

	public Integer getTransport() {
		return this.transport;
	}

	public void setTransport(Integer transport) {
		this.transport = transport;
	}

	public Integer getGood() {
		return this.good;
	}

	public void setGood(Integer good) {
		this.good = good;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}


	public void setBlogCat(BlogCat blogCat) {
		this.blogCat = blogCat;
	}

	public BlogCat getBlogCat() {
		return blogCat;
	}


	public int getOrigBlog() {
		return origBlog;
	}


	public void setOrigBlog(int origBlog) {
		this.origBlog = origBlog;
	}


	public String getContext() {
		return context;
	}


	public void setContext(String context) {
		this.context = context;
	}


	public String getPicurl() {
		return picurl;
	}


	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}


	
	

}