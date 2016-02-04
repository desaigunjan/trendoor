package com.trendoor.vo;

import com.google.gson.annotations.SerializedName;

public class VinePost{
	
	@SerializedName("permalinkUrl")
	private String link;
	
	@SerializedName("created")
	private String createdTime;
	
	@SerializedName("postId")
	private String id;
	
	@SerializedName("videoUrl")
	private String videoLink;
	
	@SerializedName("description")
	private String caption;
	
	@SerializedName("username")
	private String userName;
	
	@SerializedName("avatarUrl")
	private String userAvatar;

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getVideoLink() {
		return videoLink;
	}

	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAvatar() {
		return userAvatar;
	}

	public void setUserAvatar(String userAvatar) {
		this.userAvatar = userAvatar;
	}
	
}