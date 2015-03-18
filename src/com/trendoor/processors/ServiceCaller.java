package com.trendoor.processors;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import twitter4j.Location;
import twitter4j.MediaEntityJSONImpl;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Trend;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.trendoor.util.TimeUtil;
import com.trendoor.vo.InstagramPost;
import com.trendoor.vo.InstagramPostResult;
import com.trendoor.vo.PostUser;

public class ServiceCaller{

	public static int requestCounter = 0;
	public static int counter = 0;
	
    /*public ArrayList<com.trendoor.vo.Post> getFacebookPosts(String subject) throws FacebookException{
    	
    	facebook4j.conf.ConfigurationBuilder cb = new facebook4j.conf.ConfigurationBuilder();
    	cb.setDebugEnabled(true).setRestBaseURL("https://graph.facebook.com/v1.0/");
    	FacebookFactory ff = new FacebookFactory(cb.build());
    	Facebook facebook = ff.getInstance();
    	
    	facebook.setOAuthAppId("160334017388232", "98554e0684ff9c8cc166c46d2b3684f2");
    	facebook.setOAuthAccessToken(new AccessToken("160334017388232|59QHrOu0Ygb-h-J6puOxqYTtMSY", null));
    	facebook.setOAuthPermissions("public_profile");
    	ArrayList<com.trendoor.vo.Post> finalList = new ArrayList<com.trendoor.vo.Post>();
    	
    	try{
    	ResponseList<Post> allPosts = facebook.searchPosts(subject);
    	
    	HashMap<String, Post> results = new HashMap<String, Post>();
    	
    	
    	
    	for(Post p :allPosts){
    		results.put(p.getObjectId(), p);
    	}
    	
    	for(Post p :results.values()){
    		
    		com.trendoor.vo.Post post = new com.trendoor.vo.Post();
    		
    		post.setCaption(p.getCaption());
    		post.setFrom("FB");
    		post.setLink(p.getLink()+"");
    		post.setMessage(p.getMessage());
    		post.setPicture(p.getPicture()+"");
    		post.setTime(TimeUtil.timeSincePost(p.getCreatedTime(), new Date()));
    		PostUser postUser = new PostUser();
     		postUser.setName(p.getFrom().getName());
     		post.setPostUser(postUser);
    		post.setIcon(p.getIcon()+"");
    		post.setId(p.getId());
    		post.setTimestamp(p.getCreatedTime());
    		finalList.add(post);
    	}
    	}catch(FacebookException fe){
    		System.out.println("Could not get facebook posts!");
    	}
    	return finalList;
    }*/
	
	public void stopInstagramPosts(String id) throws Exception{
		RestTemplate restTemplate = new RestTemplate();
    	Map<String, String> vars = new HashMap<String, String>();
    	vars.put("accessToken", "12402890.791c656.c0d8f0ae12bb4397b213aac30fa7d1af");
    	
    	//String result = restTemplate.getForObject("https://api.instagram.com/v1/media/popular?access_token={accessToken}", String.class, vars);
    	System.out.println("https://api.instagram.com/v1/subscriptions?id="+id+"17033031&object=all&client_id=791c6561e7934d62a434f02b302d406b&client_secret=0e0bf08f972b472f94079506359a33f9");
    	String result = restTemplate.postForObject("https://api.instagram.com/v1/subscriptions?verify_token=12402890.791c656.c0d8f0ae12bb4397b213aac30fa7d1af&client_id=791c6561e7934d62a434f02b302d406b&client_secret=0e0bf08f972b472f94079506359a33f9&aspect=media&object=tag&object_id=gopats&callback_url=http://trendoor.thruhere.net:8080/trendoor/subscription", String.class, String.class, vars);
    	
	}
    
    public ArrayList<com.trendoor.vo.Post> getInstagramPosts(String subject) throws Exception{
    	
    	ArrayList<com.trendoor.vo.Post> posts = new ArrayList<com.trendoor.vo.Post>();
    	RestTemplate restTemplate = new RestTemplate();
    	Map<String, String> vars = new HashMap<String, String>();
    	vars.put("accessToken", "12402890.791c656.c0d8f0ae12bb4397b213aac30fa7d1af");
    	vars.put("subject", subject);
    	vars.put("clientId", "791c6561e7934d62a434f02b302d406b");
    	vars.put("clientSecret", "0e0bf08f972b472f94079506359a33f9");
    	vars.put("callbackUrl", "http://trendoor.thruhere.net:8080/trendoor/subscription");
    	
    	
    	
    	//String result = restTemplate.getForObject("https://api.instagram.com/v1/media/popular?access_token={accessToken}", String.class, vars);
    	//System.out.println("https://api.instagram.com/v1/tags/"+subject+"/media/recent?access_token=12402890.791c656.c0d8f0ae12bb4397b213aac30fa7d1af");
    	//String result = restTemplate.getForObject("https://api.instagram.com/v1/subscriptions?verify_token={accessToken}&client_id={clientId}&client_secret={clientSecret}&aspect=media&object=tag&object_id={subject}&callback_url={callbackUrl}", String.class, vars);
    	String result = restTemplate.getForObject("https://api.instagram.com/v1/tags/"+subject+"/media/recent?access_token=12402890.791c656.c0d8f0ae12bb4397b213aac30fa7d1af", String.class);
    	
    	//System.out.println(result);
        
    	Gson gson = new Gson();
    	InstagramPostResult instagramPostResult = gson.fromJson(result, InstagramPostResult.class);

    	for(InstagramPost p : instagramPostResult.getInstagramPost()){
    		com.trendoor.vo.Post post = new com.trendoor.vo.Post();
    		
    		if(p.getCaption() != null){
    			post.setCaption(p.getCaption().getText());
    		}
    		
    		post.setFrom("IG");
    		post.setLink(p.getLink()+"");
    		post.setMessage("");
    		
    		post.setType(p.getType());
    		
    		if("image".equalsIgnoreCase(p.getType())){
    			if(p.getImages() != null){
        			post.setPicture(p.getImages().getMediaEntity().getUrl()+"");
        		}
    		}
    		else if("video".equalsIgnoreCase(p.getType())){
    			if(p.getVideos() != null){
    				post.setVideoLink(p.getVideos().getMediaEntity().getUrl()+"");
    			}
    		}
    		
    		post.setTime(TimeUtil.timeSincePost(new Date(Long.parseLong(p.getCreated_time())*1000) , new Date()));
    		PostUser postUser = new PostUser();
    		postUser.setName(p.getUser().getName());
     		postUser.setProfilePicture(p.getUser().getProfilePicture());
     		postUser.setScreenName("@"+p.getUser().getScreenName());
     		post.setPostUser(postUser);
    		post.setId(p.getId());
    		post.setTimestamp(new Date(Long.parseLong(p.getCreated_time())*1000));
    		posts.add(post);
    	}
    	
    	return posts;
    }
    
    public ArrayList<com.trendoor.vo.Post> getTwitterPosts(String subject){
    	
    	Twitter twitter = getTwitterInstance();
    	
    	ArrayList<com.trendoor.vo.Post> finalList = new ArrayList<com.trendoor.vo.Post>();
    	
    	if(!StringUtils.startsWithIgnoreCase(subject, "#")){
			subject = "#" + subject;
		}
    	 
    	try {
             twitter4j.Query query = new twitter4j.Query(subject);
             QueryResult result;
             
                 result = twitter.search(query);
                 List<Status> tweets = result.getTweets();
                 for (Status tweet : tweets) {
                     //System.out.println("@" + tweet.getUser().getScreenName() + " - " + tweet.getText());
                     com.trendoor.vo.Post post = new com.trendoor.vo.Post();
             		
             		post.setFrom("TW");
             		//post.setLink(tweet.get+"");
             		post.setMessage(tweet.getText());
             		
             		if(tweet.getMediaEntities() != null && tweet.getMediaEntities().length > 0){
             			post.setPicture(tweet.getMediaEntities()[0].getMediaURL()+"");
             		}
             		post.setTime(TimeUtil.timeSincePost(tweet.getCreatedAt(), new Date()));
             		PostUser postUser = new PostUser();
             		postUser.setName(tweet.getUser().getName());
             		postUser.setProfilePicture(tweet.getUser().getBiggerProfileImageURL());
             		postUser.setScreenName("@"+tweet.getUser().getScreenName());
             		post.setPostUser(postUser);
             		post.setId(tweet.getId()+"");
             		post.setTimestamp(tweet.getCreatedAt());
             		finalList.add(post);
                 }
                 
                 
         } catch (TwitterException te) {
             te.printStackTrace();
             System.out.println("Failed to search tweets: " + te.getMessage());
             System.exit(-1);
         }
    	 return finalList;

    }
    
    public ArrayList<String> getTrends(){
    	Twitter twitter = getTwitterInstance();
    	twitter4j.ResponseList<Location> locations;
    	ArrayList<String> trendingNow = new ArrayList<String>();
    	try{locations = twitter.getAvailableTrends();
    	int i=0;
    	int index=0;
    	for (Location location : locations) {
    	    if("New York".equalsIgnoreCase(location.getName())){
	    	    index = i;	
	    	    break;
    	    }
    	    i++;
    	}
    	
    	 twitter4j.Trends trends = twitter.getPlaceTrends(locations.get(index).getWoeid());
    	 
    	 for(Trend trend : trends.getTrends()){
    		 String t = trend.getName();
    		 if(!"".equals(t) && !t.contains(" ")){
    			 if(t.charAt(0) == '#'){
    				 trendingNow.add(trend.getName());
    			 }else{
    				 trendingNow.add("#"+trend.getName());
    			 }
    		 }
    	 }
    	
    	}catch(Exception e){}
    	return trendingNow;
    }
    
    public Twitter getTwitterInstance(){
    	
    	ConfigurationBuilder cb = new ConfigurationBuilder();
    	cb.setDebugEnabled(true).setOAuthConsumerKey("5aUW5yRHEZD0UV1xcQHE9OH7F").setOAuthConsumerSecret("4Wzl5Gk8UxR7rHkdcbtz6lKthHHkDcHlL8ioHYNTC40BYHimuS")
    	  .setOAuthAccessToken("1900638187-E73Y0rHrolzprNnatIEgcjaKB3quKzzYqTZngWK").setOAuthAccessTokenSecret("Nhft6a6nu1hjx3CzSEVt3WrsDYTKLuFT7J2NrUrPnsUkQ");
    	
    	TwitterFactory tf = new TwitterFactory(cb.build());
    	Twitter twitter = tf.getInstance();
    	
    	return twitter;
    	
    }

 

}