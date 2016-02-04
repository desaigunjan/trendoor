package com.trendoor.controllers;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.trendoor.processors.PostSearchProcessor;
import com.trendoor.processors.ServiceCaller;
import com.trendoor.util.TimeUtil;
import com.trendoor.vo.Location;
import com.trendoor.vo.Post;
import com.trendoor.vo.PostData;


@Controller
public class HomeController{
	
	private static List<String> trendingNow;
	private static Date lastTrendingCheckAt;
	private Location location;
	
	
	@RequestMapping("/welcome")
	ModelAndView homePage(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		 String ipAddress = request.getRemoteAddr(); 
		 
		 ipAddress = request.getHeader("X-FORWARDED-FOR");  
		   if (ipAddress == null) {  
			   ipAddress = request.getRemoteAddr();  
		   }
		   
		 System.out.println(ipAddress);
		 
		 ModelAndView modelAndView = new ModelAndView("brownguy");
		
		 return modelAndView;
	}
	
	@RequestMapping("/giraffe")
	ModelAndView giraffePage(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		 String ipAddress = request.getRemoteAddr(); 
		 
		 ipAddress = request.getHeader("X-FORWARDED-FOR");  
		   if (ipAddress == null) {  
			   ipAddress = request.getRemoteAddr();  
		   }
		   
		 System.out.println(ipAddress);
		
		 ModelAndView modelAndView = new ModelAndView("giraffe");
		
		 return modelAndView;
	}
	
	@RequestMapping("/birthdaylike")
	ModelAndView likeBirthdayPosts(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		 PostSearchProcessor searchProcessor = new PostSearchProcessor();
		 searchProcessor.likeBirthdayPosts();
		 
		 ModelAndView modelAndView = new ModelAndView("brownguy");
		
		 return modelAndView;
	}
	
	@RequestMapping("/graph")
	ModelAndView giraffeGraphPage(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		 String ipAddress = request.getRemoteAddr(); 
		 
		 ipAddress = request.getHeader("X-FORWARDED-FOR");  
		   if (ipAddress == null) {  
			   ipAddress = request.getRemoteAddr();  
		   }
		   
		 System.out.println(ipAddress);
		
		 ModelAndView modelAndView = new ModelAndView("graph");
		
		 return modelAndView;
	}
	
	@RequestMapping("/trend")
	ModelAndView welcomePage(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		 String ipAddress = request.getRemoteAddr(); 
		 
		 String subject = request.getParameter("subject");
		 
		 ipAddress = request.getHeader("X-FORWARDED-FOR");  
		   if (ipAddress == null) {  
			   ipAddress = request.getRemoteAddr(); 
		   }
		   
		 System.out.println(ipAddress);
		 
		
		 ModelAndView modelAndView = new ModelAndView("trend");
		
		 String isInstagram = request.getParameter("isInstagram");
		 String isTwitter = request.getParameter("isTwitter");
		 String place = request.getParameter("location");
		
		 if(isInstagram == null || isTwitter == null){
			 isInstagram = "Y";
			 isTwitter = "Y";
		 }
			
		 PostSearchProcessor searchProcessor = new PostSearchProcessor();
		 if(StringUtils.isEmpty(place)){
			 location = searchProcessor.getLocation(ipAddress);
			 
			 if(location.getLoc() == null){
				 location.setLoc("41.1454,73.9949");
			 }
			 
			 if(location.getCity() != null){
				 place = location.getCity();
			 }
			 if(location.getRegion() != null && StringUtils.isEmpty(place)){
				 place = location.getRegion();
			 }else if(location.getRegion() != null && !StringUtils.isEmpty(place)){
				 place = place + ", " + location.getRegion();
			 }
			 
			 if(StringUtils.isEmpty(place)){
				 place = "Srinagar, IN";
			 }
		 }
		 System.out.println(place);
		 
		if(trendingNow == null || TimeUtil.is15MinutesPassed(lastTrendingCheckAt)){
			 trendingNow = searchProcessor.getTrends(location);
			 lastTrendingCheckAt = new Date();
			 
			 if("null, null".equalsIgnoreCase(place)){
				 place = trendingNow.get(0);
			 }else{
				 trendingNow.remove(0);
			 }
		}
		 
		if(!"".equalsIgnoreCase(subject)){
			modelAndView.addObject("subject",""+subject);
		}else{
			modelAndView.addObject("subject","");
		}
		
		 modelAndView.addObject("trendingNow",trendingNow);
		 
		 modelAndView.addObject("isInstagram",isInstagram);
		 modelAndView.addObject("isTwitter",isTwitter);
		 modelAndView.addObject("location",place);
		
		 return modelAndView;
	}

	@RequestMapping("/search")
	ModelAndView searchPage(HttpServletRequest request, HttpServletResponse response) throws Exception{
		

		String subject = request.getParameter("subject");
		String isMobile = request.getParameter("isMobile");
		String isInstagram = request.getParameter("isInstagram");
		String isTwitter = request.getParameter("isTwitter");
		String isVine = request.getParameter("isTwitter");
		
		System.out.println("Request came for : "+subject);
		
		PostData postData = new PostData();
		
		postData.setSubject(subject);
		postData.setFromFacebook(false);
		postData.setFromInstagram("Y".equalsIgnoreCase(isInstagram));
		postData.setFromTwitter("Y".equalsIgnoreCase(isTwitter));
		postData.setFromVine("Y".equalsIgnoreCase(isVine));
		
		PostSearchProcessor searchProcessor = new PostSearchProcessor();
		postData = searchProcessor.getPosts(postData);
		
		if(subject.indexOf("#") > -1){
			subject = subject.substring(1);
		}
		
		if(trendingNow == null || TimeUtil.is15MinutesPassed(lastTrendingCheckAt)){
			trendingNow = searchProcessor.getTrends(location);
		}
		ModelAndView modelAndView;
		modelAndView = new ModelAndView("post");
		
		
		Collection<JSONObject> postList = new ArrayList<JSONObject>();
		
		for(Post post : postData.getPostList()){
			JSONObject p = new JSONObject();
			p.put("caption",post.getCaption());
			p.put("from",post.getFrom());
			p.put("link",post.getLink());
			p.put("message",post.getMessage());
			p.put("picture",post.getPicture());
			p.put("screenName",post.getPostUser().getScreenName());
			p.put("name",post.getPostUser().getName());
			p.put("profilePicture",post.getPostUser().getProfilePicture());
			p.put("time",post.getTime());
			p.put("type",post.getType());
			p.put("videoLink",post.getMediaLink());
			postList.add(p);
		}
		
		JSONObject finalObj = new JSONObject();
		finalObj.append("posts", postList);
		modelAndView.addObject("posts", finalObj);
		modelAndView.addObject("results",postData.getPostList());
		modelAndView.addObject("subject",postData.getSubject());
		modelAndView.addObject("trendingNow",trendingNow);
		modelAndView.addObject("isMobile",isMobile);
		modelAndView.addObject("isInstagram",isInstagram);
		modelAndView.addObject("isTwitter",isTwitter);
		
		
		return modelAndView;
	}
	
	 @RequestMapping(value = "/subscription", method = RequestMethod.GET, produces = {"text/html"})
	    public HttpServletResponse findByResourceID(HttpServletRequest request, HttpServletResponse response)  throws Exception{
		 String mode = request.getParameter("hub.mode");
			String challenge = request.getParameter("hub.challenge");
			System.out.println("Request came for: " + mode + " : "+challenge);
			
			response.setContentType("text/html");
			  PrintWriter out = response.getWriter();
			  out.append(challenge);
			  out.close();
			return response;
			
	 }
	 
	 @RequestMapping(value = "/subscription", method = RequestMethod.POST)
	 public void findByResourceIDPOST(HttpServletRequest request, HttpServletResponse response)  throws Exception{
		 BufferedReader body = request.getReader();
	        String inputLine;
	        StringBuffer result = new StringBuffer();
	        while ((inputLine = body.readLine()) != null)
	        {
	            result.append(inputLine);
	        }
	        body.close();
	        String str = result.toString();
	        
	        System.out.println(str);
			
	 }
	 
}
