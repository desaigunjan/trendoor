package com.trendoor.vo;

import java.util.Comparator;
import java.util.Date;

public class Post implements Comparable<Post>{
	
	private String  picture;
	private PostUser  postUser;
	private String  message;
	private String  link;
	private String  caption;
	private String  time;
	private String  from;
	private String  icon;
	private String  id; 
	private Date timestamp;
	private String screenName;
	private String mediaLink;
	private String type;
	
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public PostUser getPostUser() {
		return postUser;
	}
	public void setPostUser(PostUser user) {
		this.postUser = user;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getScreenName() {
		return screenName;
	}
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	public String getMediaLink() {
		return mediaLink;
	}
	public void setMediaLink(String mediaLink) {
		this.mediaLink = mediaLink;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public int compareTo(Post o) {
		
		return o.getTimestamp().compareTo(this.getTimestamp());
			
	}
	
}
