package com.trendoor.vo;

import com.google.gson.annotations.SerializedName;

public class InstagramPostResult {

	@SerializedName("pagination")
	private InstagramPagination pagination;
	
	@SerializedName("meta")
	Status status;
	
	@SerializedName("data") 
	private InstagramPost[] instagramPost;
	
	
	public InstagramPagination getPagination() {
		return pagination;
	}
	public void setPagination(InstagramPagination pagination) {
		this.pagination = pagination;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public InstagramPost[] getInstagramPost() {
		return instagramPost;
	}
	public void setInstagramPost(InstagramPost[] instagramPost) {
		this.instagramPost = instagramPost;
	}
	
	
}
