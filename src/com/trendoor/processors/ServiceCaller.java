package com.trendoor.processors;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import twitter4j.GeoLocation;
import twitter4j.QueryResult;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Trend;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import com.google.gson.Gson;
import com.trendoor.util.EmailUtil;
import com.trendoor.util.TimeUtil;
import com.trendoor.vo.ContactUs;
import com.trendoor.vo.InstagramPost;
import com.trendoor.vo.InstagramPostResult;
import com.trendoor.vo.Location;
import com.trendoor.vo.PostUser;
import com.trendoor.vo.VinePost;
import com.trendoor.vo.VineResult;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.auth.AccessToken;
import facebook4j.conf.ConfigurationBuilder;
import static java.nio.charset.StandardCharsets.*;

public class ServiceCaller{

	public static int requestCounter = 0;
	
	public void likeBirthdayPosts(String APP_ID, String APP_SECRET, String APP_TOKEN) throws FacebookException{
		
		System.out.println("Ready to acknowledge birthday wishes..");
		
		long start = System.currentTimeMillis(); 
		
		ConfigurationBuilder cb = new ConfigurationBuilder();
    	cb.setDebugEnabled(true).setRestBaseURL("https://graph.facebook.com/v2.1/");
    	FacebookFactory ff = new FacebookFactory(cb.build());
    	Facebook facebook = ff.getInstance();
    	
    	facebook.setOAuthAppId(APP_ID, APP_SECRET);
    	facebook.setOAuthAccessToken(new AccessToken(APP_TOKEN, null));
    	facebook.setOAuthPermissions("public_profile");
    	
    	ArrayList<String> birthdayPosts = getBirthdayPosts();
    	
    	for(String postID : birthdayPosts){
    		System.out.println("Liking post : " + postID);
    		try{
    			facebook.likePost(postID);
    		}catch(FacebookException fe){
    			System.out.println(fe);
    		}
    	}
    	
    	long elapsedTime = (System.currentTimeMillis() - start) ;
    	
    	System.out.println("Total time to like "+ birthdayPosts.size() + " posts : " + elapsedTime + "milli seconds!");
    	
	}
	
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
        			post.setMediaLink(p.getImages().getMediaEntity().getUrl()+"");
        		}
    		}
    		else if("video".equalsIgnoreCase(p.getType())){
    			if(p.getVideos() != null){
    				post.setMediaLink(p.getVideos().getMediaEntity().getUrl()+"");
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
    
    /*public ArrayList<com.trendoor.vo.Post> getFacebookPosts(String subject) throws facebook4j.FacebookException{
	
	facebook4j.conf.ConfigurationBuilder cb = new facebook4j.conf.ConfigurationBuilder();
	cb.setDebugEnabled(true).setRestBaseURL("https://graph.facebook.com/v1.0/");
	FacebookFactory ff = new FacebookFactory(cb.build());
	Facebook facebook = ff.getInstance();
	
	facebook.setOAuthAppId("160334017388232", "98554e0684ff9c8cc166c46d2b3684f2");
	facebook.setOAuthAccessToken(new AccessToken("CAACEdEose0cBAOiH4ma8c1QNyrfAalgE4ZCA67DKXkG5q0hZBAsT7dwEyKQZBLsvU0AmJOZB3vsgCcqtTdmR8h7MlVC3QoTdMWeAUgL2OGHaaTpgvohSYZCczQvuSXEpjdJZCZAXZBHWnqBoGkSHMVG2UyzUKRrrZBGoOyZApEOIh2mcJIMvYtLHJZCqZA9J7q02hYYR1Mj6zUIK32BQq2OZAZBZB1i", null));
	facebook.setOAuthPermissions("public_profile");

	
	facebook4j.ResponseList<Post> postList = facebook.getFeed();
	
	
	facebook.likePost("10205380892670627_10207996710064427");
		
	
	return finalList;
}*/
    
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
             		//post.setMessage(tweet.getText());
             		//byte ptext[] = tweet.getText().getBytes(ISO_8859_1); 
             		//String value = new String(ptext, UTF_8); 
             		post.setMessage(tweet.getText());
             		if(tweet.getMediaEntities() != null && tweet.getMediaEntities().length > 0){
             			if("PHOTO".equalsIgnoreCase(tweet.getMediaEntities()[0].getType())){
             				post.setMediaLink(tweet.getMediaEntities()[0].getMediaURL()+"");
             				post.setType("image");
             			}
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
    
    public ArrayList<com.trendoor.vo.Post> getVinePosts(String subject) throws Exception{
    	
    	ArrayList<com.trendoor.vo.Post> posts = new ArrayList<com.trendoor.vo.Post>();
    	RestTemplate restTemplate = new RestTemplate();
    	String result = restTemplate.getForObject("https://api.vineapp.com/timelines/tags/"+subject, String.class);
        
    	Gson gson = new Gson();
    	VineResult vineResult = gson.fromJson(result, VineResult.class);

    	if(vineResult != null && vineResult.isSuccess() && vineResult.getVinePostHolder() != null && vineResult.getVinePostHolder().getSize() > 0){
    	
	    	for(VinePost p : vineResult.getVinePostHolder().getVinePostResult()){
	    		com.trendoor.vo.Post post = new com.trendoor.vo.Post();
	    		
	    		if(p.getCaption() != null){
	    			post.setCaption(p.getCaption());
	    		}
	    		
	    		post.setFrom("VINE");
	    		post.setLink(p.getLink()+"");
	    		post.setMessage("");
	    		
	    		post.setType("video");
	    		
    			if(!"".equalsIgnoreCase(p.getVideoLink())){
    				post.setMediaLink(p.getVideoLink()+"");
    			}
	    		
    			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    			Date postDate = formatter.parse(p.getCreatedTime());
    			
	    		post.setTime(TimeUtil.timeSincePost(postDate , new Date()));
	    		PostUser postUser = new PostUser();
	    		postUser.setName(p.getUserName());
	     		postUser.setProfilePicture(p.getUserAvatar());
	     		postUser.setScreenName("");
	     		post.setPostUser(postUser);
	    		post.setId(p.getId());
	    		post.setTimestamp(postDate);
	    		posts.add(post);
	    	}
    	}
    	
    	return posts;
    }
    
    public List<String> getTrends(Location location){
    	Twitter twitter = getTwitterInstance();
    	List<String> trendingNow = new ArrayList<String>();
    	
    	/*try{locations = twitter.getAvailableTrends();
    	int i=0;
    	int cityIndex=0;
    	int countryIndex=0;
    	for (twitter4j.Location loc : locations) {
    		System.out.println(loc.getWoeid() +" : "+loc.getName() +" : "+ loc.getCountryName() +" : "+ loc.getCountryCode());
    	    if(location.getCity().equalsIgnoreCase(loc.getName())){
	    	    cityIndex = i;	
	    	    break;
    	    }
    	    if(){
    	    	countryIndex = i;
    	    }
    	    i++;
    	}*/
    	
    	try{
    		
    	String[] letLong = location.getLoc().split(",");
    	double latitude = Double.valueOf(letLong[0]);
    	double longitude = Double.valueOf(letLong[1]);
    	
    	GeoLocation geo = new GeoLocation(latitude, longitude);
    	ResponseList<twitter4j.Location> locations = twitter.getClosestTrends(geo);
    	
    	twitter4j.Trends trends;
    	if(locations.size() > 0){
    		trends = twitter.getPlaceTrends(locations.get(0).getWoeid());
    		trendingNow.add(locations.get(0).getWoeid()+"");
    		trendingNow.add(locations.get(0).getName() +", "+locations.get(0).getCountryCode());
    	}else{
    		trends = twitter.getPlaceTrends(1);
    	}
    	
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
    	
    	if(trendingNow.size() > 10){
    		trendingNow = trendingNow.subList(0, 9);
    	}
    	
    	}catch(Exception e){
    		System.out.println(e);
    	}
    	return trendingNow;
    }
    
    public Location getLocation(String ip){
    	RestTemplate restTemplate = new RestTemplate();
    	String result = restTemplate.getForObject("http://ipinfo.io/"+ip+"/json", String.class);
    	
    	Gson gson = new Gson();
    	Location location = gson.fromJson(result, Location.class);
    	System.out.println(location.getCity()+", "+location.getRegion()+", "+location.getCountry()+", "+location.getLoc());
    	return location;
    }
    
    public void sendEmail(){
    	
    	ContactUs contact = new ContactUs();
    	contact.setEmail("desai.gunjan@yahoo.com");
    	contact.setMessage("hi");
    	contact.setName("Gunjan Desai");
    	contact.setPhone("2018883954");
    	EmailUtil.sendEmail(contact);
    }
    
    public Twitter getTwitterInstance(){
    	
    	twitter4j.conf.ConfigurationBuilder cb = new twitter4j.conf.ConfigurationBuilder();
    	cb.setDebugEnabled(true).setOAuthConsumerKey("5aUW5yRHEZD0UV1xcQHE9OH7F").setOAuthConsumerSecret("4Wzl5Gk8UxR7rHkdcbtz6lKthHHkDcHlL8ioHYNTC40BYHimuS")
    	  .setOAuthAccessToken("1900638187-E73Y0rHrolzprNnatIEgcjaKB3quKzzYqTZngWK").setOAuthAccessTokenSecret("Nhft6a6nu1hjx3CzSEVt3WrsDYTKLuFT7J2NrUrPnsUkQ");
    	
    	TwitterFactory tf = new TwitterFactory(cb.build());
    	Twitter twitter = tf.getInstance();
    	
    	return twitter;
    	
    }
    
    private ArrayList<String> getBirthdayPosts(){
    	ArrayList<String> birthdayPosts = new ArrayList<String>();
    	
    	birthdayPosts.add("10205380892670627_10207998540510187");
    	birthdayPosts.add("10205380892670627_10207996562580740");
    	birthdayPosts.add("10205380892670627_10207997795051551");
    	birthdayPosts.add("10205380892670627_10207997365840821");
    	birthdayPosts.add("10205380892670627_10207997717409610");
    	birthdayPosts.add("10205380892670627_10207994852017977");
    	birthdayPosts.add("10205380892670627_10207994905459313");
    	birthdayPosts.add("10205380892670627_10207994985901324");
    	birthdayPosts.add("10205380892670627_10207995005821822");
    	birthdayPosts.add("10205380892670627_10207995024462288");
    	birthdayPosts.add("10205380892670627_10207995057063103");
    	birthdayPosts.add("10205380892670627_10207995112064478");
    	birthdayPosts.add("10205380892670627_10207995112544490");
    	birthdayPosts.add("10205380892670627_10207995134025027");
    	birthdayPosts.add("10205380892670627_10207995251187956");
    	birthdayPosts.add("10205380892670627_10207995463273258");
    	birthdayPosts.add("10205380892670627_10207995470073428");
    	birthdayPosts.add("10205380892670627_10207995471073453");
    	birthdayPosts.add("10205380892670627_10207995670198431");
    	birthdayPosts.add("10205380892670627_10207996466378335");
    	birthdayPosts.add("10205380892670627_10207996562580740");
    	birthdayPosts.add("10205380892670627_10207996571100953");
    	birthdayPosts.add("10205380892670627_10207996702664242");
    	birthdayPosts.add("10205380892670627_10207996710064427");
    	birthdayPosts.add("10205380892670627_10207997365840821");
    	birthdayPosts.add("10205380892670627_10207997568725893");
    	birthdayPosts.add("10205380892670627_10207994832337485");
    	birthdayPosts.add("10205380892670627_10207994827857373");
    	birthdayPosts.add("10205380892670627_10207994448007877");
    	birthdayPosts.add("10205380892670627_10207993694069029");
    	birthdayPosts.add("10205380892670627_10207993503944276");
    	birthdayPosts.add("10205380892670627_10207993501864224");
    	birthdayPosts.add("10205380892670627_10207993492423988");
    	birthdayPosts.add("10205380892670627_10207993477983627");
    	birthdayPosts.add("10205380892670627_10207993473303510");
    	birthdayPosts.add("10205380892670627_10207993390101430");
    	birthdayPosts.add("10205380892670627_10207993380021178");
    	birthdayPosts.add("10205380892670627_10207993362420738");
    	birthdayPosts.add("10205380892670627_10207993339100155");
    	birthdayPosts.add("10205380892670627_10207993331259959");
    	birthdayPosts.add("10205380892670627_10207993329419913");
    	birthdayPosts.add("10205380892670627_10207993293459014");
    	birthdayPosts.add("10205380892670627_10207993211976977");
    	birthdayPosts.add("10205380892670627_10207993196656594");
    	birthdayPosts.add("10205380892670627_10207993195496565");
    	birthdayPosts.add("10205380892670627_10207993180096180");
    	birthdayPosts.add("10205380892670627_10207993179256159");
    	birthdayPosts.add("10205380892670627_10207993161935726");
    	birthdayPosts.add("10205380892670627_10207993151215458");
    	birthdayPosts.add("10205380892670627_10207993136375087");
    	birthdayPosts.add("10205380892670627_10207993109974427");
    	birthdayPosts.add("10205380892670627_10207993037532616");
    	birthdayPosts.add("10205380892670627_10207992925089805");
    	birthdayPosts.add("10205380892670627_10207992754685545");
    	birthdayPosts.add("10205380892670627_10207992615762072");
    	birthdayPosts.add("10205380892670627_10207992593521516");
    	birthdayPosts.add("10205380892670627_10207992482198733");
    	birthdayPosts.add("10205380892670627_10207992449197908");
    	birthdayPosts.add("10205380892670627_10207992265593318");
    	birthdayPosts.add("10205380892670627_10207992254833049");
    	birthdayPosts.add("10205380892670627_10207992248592893");
    	birthdayPosts.add("10205380892670627_10207992234912551");
    	birthdayPosts.add("10205380892670627_10207992213512016");
    	birthdayPosts.add("10205380892670627_10207992184791298");
    	birthdayPosts.add("10205380892670627_10207992155790573");
    	birthdayPosts.add("10205380892670627_10207992146310336");
    	birthdayPosts.add("10205380892670627_10207992133310011");
    	birthdayPosts.add("10205380892670627_10207992021907226");
    	birthdayPosts.add("10205380892670627_10207991999626669");
    	birthdayPosts.add("10205380892670627_10207991969385913");
    	birthdayPosts.add("10205380892670627_10207991957465615");
    	birthdayPosts.add("10205380892670627_10207991931064955");
    	birthdayPosts.add("10205380892670627_10207991856503091");
    	birthdayPosts.add("10205380892670627_10207991869023404");
    	birthdayPosts.add("10205380892670627_10207991856463090");
    	birthdayPosts.add("10205380892670627_10207991802341737");
    	birthdayPosts.add("10205380892670627_10207991766860850");
    	birthdayPosts.add("10205380892670627_10207991756860600");
    	birthdayPosts.add("10205380892670627_10207991754180533");
    	birthdayPosts.add("10205380892670627_10207991746100331");
    	birthdayPosts.add("10205380892670627_10207991735540067");
    	birthdayPosts.add("10205380892670627_10207991726739847");
    	birthdayPosts.add("10205380892670627_10207991715619569");
    	birthdayPosts.add("10205380892670627_10207991714859550");
    	birthdayPosts.add("10205380892670627_10207991709019404");
    	birthdayPosts.add("10205380892670627_10207991656658095");
    	birthdayPosts.add("10205380892670627_10207991655458065");
    	birthdayPosts.add("10205380892670627_10207991651217959");
    	birthdayPosts.add("10205380892670627_10207991649697921");
    	birthdayPosts.add("10205380892670627_10207991648217884");
    	birthdayPosts.add("10205380892670627_10207991637097606");
    	birthdayPosts.add("10205380892670627_10207991618137132");
    	birthdayPosts.add("10205380892670627_10207991606016829");
    	birthdayPosts.add("10205380892670627_10207991596576593");
    	birthdayPosts.add("10205380892670627_10207991583176258");
    	birthdayPosts.add("10205380892670627_10207991582416239");
    	birthdayPosts.add("10205380892670627_10207991573896026");
    	birthdayPosts.add("10205380892670627_10207991563895776");
    	birthdayPosts.add("10205380892670627_10207991558215634");
    	birthdayPosts.add("10205380892670627_10207991548895401");
    	birthdayPosts.add("10205380892670627_10207991548335387");
    	birthdayPosts.add("10205380892670627_10207991546815349");
    	birthdayPosts.add("10205380892670627_10207991535175058");
    	birthdayPosts.add("10205380892670627_10207991535095056");
    	birthdayPosts.add("10205380892670627_10207991532414989");
    	birthdayPosts.add("10205380892670627_10207991530734947");
    	birthdayPosts.add("10205380892670627_10207991488493891");
    	birthdayPosts.add("10205380892670627_10207991472053480");
    	birthdayPosts.add("10205380892670627_10207991468653395");
    	birthdayPosts.add("10205380892670627_10207991462693246");
    	birthdayPosts.add("10205380892670627_10207991441212709");
    	birthdayPosts.add("10205380892670627_10207991435412564");
    	birthdayPosts.add("10205380892670627_10207991434332537");
    	birthdayPosts.add("10205380892670627_10207991392051480");
    	birthdayPosts.add("10205380892670627_10207991334690046");
    	birthdayPosts.add("10205380892670627_10207991267248360");
    	birthdayPosts.add("10205380892670627_10207991219527167");
    	birthdayPosts.add("10205380892670627_10207991216447090");
    	birthdayPosts.add("10205380892670627_10207991140445190");
    	birthdayPosts.add("10205380892670627_10207990680673696");
    	birthdayPosts.add("10205380892670627_10207990357545618");
    	birthdayPosts.add("10205380892670627_10207990341985229");
    	birthdayPosts.add("10205380892670627_10207989988816400");
    	birthdayPosts.add("10205380892670627_10207989709049406");
    	birthdayPosts.add("10205380892670627_10207989407521868");
    	birthdayPosts.add("10205380892670627_10207985245137811");
    	birthdayPosts.add("10205380892670627_10207998540510187");
    	birthdayPosts.add("10205380892670627_10208002081758716");
    	birthdayPosts.add("10205380892670627_898779693551693");
    	
    	
    	return birthdayPosts;
    }

}



