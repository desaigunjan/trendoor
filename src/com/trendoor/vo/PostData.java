package com.trendoor.vo;

import java.util.ArrayList;

public class PostData {

	ArrayList<Post> postList = new ArrayList<Post>();
	String subject;
	
	boolean isSuccess = false;
	String errorMessage;
	String subscriptionId;
	
	boolean fromFacebook = false;
	boolean fromInstagram = false;
	boolean fromTwitter = false;
	boolean fromVine = false;
	
	
	public ArrayList<Post> getPostList() {
		return postList;
	}
	public void setPostList(ArrayList<Post> postList) {
		this.postList = postList;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public boolean isFromFacebook() {
		return fromFacebook;
	}
	public void setFromFacebook(boolean fromFacebook) {
		this.fromFacebook = fromFacebook;
	}
	public boolean isFromInstagram() {
		return fromInstagram;
	}
	public void setFromInstagram(boolean fromInstagram) {
		this.fromInstagram = fromInstagram;
	}
	public boolean isFromTwitter() {
		return fromTwitter;
	}
	public void setFromTwitter(boolean fromTwitter) {
		this.fromTwitter = fromTwitter;
	}
	public boolean isFromVine() {
		return fromVine;
	}
	public void setFromVine(boolean fromVine) {
		this.fromVine = fromVine;
	}
	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getSubscriptionId() {
		return subscriptionId;
	}
	public void setSubscriptionId(String subscriptionId) {
		this.subscriptionId = subscriptionId;
	}
	
	
}
