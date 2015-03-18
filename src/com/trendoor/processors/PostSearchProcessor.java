package com.trendoor.processors;

import java.util.ArrayList;
import java.util.Collections;

import com.trendoor.vo.PostData;

public class PostSearchProcessor {

	ServiceCaller serviceCaller = new ServiceCaller();
	
	public PostData getPosts(PostData postData) throws Exception{
		
		ServiceCaller.requestCounter++;
		
		try{
		if(postData.isFromInstagram()){
			
			postData.getPostList().addAll(serviceCaller.getInstagramPosts(postData.getSubject()));
		}
		if(postData.isFromTwitter()){
			postData.getPostList().addAll(serviceCaller.getTwitterPosts(postData.getSubject()));
		}
		}catch(Exception e){
			System.out.println("something went wrong:" + e.toString());
		}
		Collections.sort(postData.getPostList());
		postData.setSuccess(true);
		
		return postData;
	}
	
	public void stopPosts(String id) throws Exception{
		
		serviceCaller.stopInstagramPosts(id);
	}
	
	public ArrayList<String> getTrends() throws Exception{
		
		return serviceCaller.getTrends();
	}
	
}
