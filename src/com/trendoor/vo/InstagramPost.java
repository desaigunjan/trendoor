package com.trendoor.vo;

import java.util.ArrayList;

public class InstagramPost {

	private String attribution;
	private String type;
	private String link;
	private String created_time;
	private String id;
	private InstagramMediaEntity images;
	private InstagramMediaEntity videos;
	private Caption caption;
	private InstagramPostUser user;
	private ArrayList<String> tags;
	
	public String getAttribution() {
		return attribution;
	}
	public void setAttribution(String attribution) {
		this.attribution = attribution;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getCreated_time() {
		return created_time;
	}
	public void setCreated_time(String created_time) {
		this.created_time = created_time;
	}
	public InstagramMediaEntity getImages() {
		return images;
	}
	public void setImages(InstagramMediaEntity images) {
		this.images = images;
	}
	public InstagramPostUser getUser() {
		return user;
	}
	public void setUser(InstagramPostUser user) {
		this.user = user;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Caption getCaption() {
		return caption;
	}
	public void setCaption(Caption caption) {
		this.caption = caption;
	}
	public ArrayList<String> getTags() {
		return tags;
	}
	public void setTags(ArrayList<String> tags) {
		this.tags = tags;
	}

	public InstagramMediaEntity getVideos() {
		return videos;
	}
	public void setVideos(InstagramMediaEntity videos) {
		this.videos = videos;
	}


	public class Caption{
		String text;

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}
		
	}
	
	
}
