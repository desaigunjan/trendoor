package com.trendoor.vo;

import com.google.gson.annotations.SerializedName;

public class VinePostRecordHolder{
	
	@SerializedName("size")
	int size;
	
	@SerializedName("records")
	VinePost[]  VinePostResult;

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public VinePost[] getVinePostResult() {
		return VinePostResult;
	}

	public void setVinePostResult(VinePost[] vinePostResult) {
		VinePostResult = vinePostResult;
	}
	
}