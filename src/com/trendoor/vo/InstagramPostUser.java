package com.trendoor.vo;

import com.google.gson.annotations.SerializedName;

public class InstagramPostUser {

	@SerializedName("full_name")
	String name;
	@SerializedName("username")
	String screenName;
	@SerializedName("profile_picture")
	String profilePicture;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getScreenName() {
		return screenName;
	}
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	public String getProfilePicture() {
		return profilePicture;
	}
	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}
	
	
}
