package com.trendoor.vo;

import com.google.gson.annotations.SerializedName;

public class InstagramMediaEntity {

	@SerializedName("standard_resolution") 
	private InstagramMedia mediaEntity;

	public InstagramMedia getMediaEntity() {
		return mediaEntity;
	}

	public void setMediaEntity(InstagramMedia mediaEntity) {
		this.mediaEntity = mediaEntity;
	}
	
	
}
