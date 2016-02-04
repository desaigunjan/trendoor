package com.trendoor.processors;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;

import com.trendoor.vo.Location;
import com.trendoor.vo.PostData;

import facebook4j.FacebookException;

public class PostSearchProcessor {

	ServiceCaller serviceCaller = new ServiceCaller();
	
	private static String APP_ID = "160334017388232";
	private static String APP_SECRET = "98554e0684ff9c8cc166c46d2b3684f2";
	private static String APP_TOKEN = "CAACEdEose0cBAB1xV8j7mAU8ueAtanZBz4kBv8VAoAKfFZCWdU3S7RistqN76ZAF1nAc6cDOIbZCMFprhkmqy3borqSEHiMq0NwlkUqV9f1cr8ZAkZC9ArrKCysjMW6BMcSPs2h24QB6RznNFZACh6Ra02UHxFoXzZAHgFa2ojUCnG1R6N39gQFjpPPWdFjjJ14ESmm8jvHujc1MQjeGgwrL";
	
	public PostData getPosts(PostData postData) throws Exception{
		
		ServiceCaller.requestCounter++;
		
		try{
		if(postData.isFromInstagram()){
			
			postData.getPostList().addAll(serviceCaller.getInstagramPosts(postData.getSubject()));
		}
		if(postData.isFromTwitter()){
			postData.getPostList().addAll(serviceCaller.getTwitterPosts(postData.getSubject()));
		}
		if(postData.isFromVine()){
			postData.getPostList().addAll(serviceCaller.getVinePosts(postData.getSubject()));
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
	
	public java.util.List<String> getTrends(Location location) throws Exception{
		
		return serviceCaller.getTrends(location);
	}
	
	public Location getLocation(String ip) throws Exception{
		
		return serviceCaller.getLocation(ip);
	}
	
	public void sendEmail() throws Exception{
		serviceCaller.sendEmail();
	}
	
	public void likeBirthdayPosts() throws FacebookException{
		try{
			serviceCaller.likeBirthdayPosts(APP_ID, APP_SECRET, APP_TOKEN);
		}catch(facebook4j.FacebookException e){
			System.out.println(e);
		}
		
	}
	
}
