package com.trendoor.vo;

import com.google.gson.annotations.SerializedName;

public class VineResult {

	@SerializedName("success")
	boolean success;
	
	@SerializedName("error")
	String error;
	
	@SerializedName("data") 
	VinePostRecordHolder vinePostHolder;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public VinePostRecordHolder getVinePostHolder() {
		return vinePostHolder;
	}

	public void setVinePostHolder(VinePostRecordHolder vinePostHolder) {
		this.vinePostHolder = vinePostHolder;
	}
	
}
