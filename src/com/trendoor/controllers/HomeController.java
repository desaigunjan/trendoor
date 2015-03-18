package com.trendoor.controllers;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.trendoor.vo.PostData;


@Controller
public class HomeController{
	
	private static String subid;
	
	private static ArrayList<String> trendingNow;
	private static Date lastTrendingCheckAt;
	
	private String from;
	private boolean isOn;

	final Logger logger = Logger.getLogger(HomeController.class.getName());
	
	@RequestMapping("/welcome")
	ModelAndView welcomePage(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		 
		 ModelAndView modelAndView = new ModelAndView();
		
		 String isInstagram = request.getParameter("isInstagram");
		 String isTwitter = request.getParameter("isTwitter");
		
		 if(isInstagram == null || isTwitter == null){
			 isInstagram = "Y";
			 isTwitter = "Y";
		 }
			
		 PostSearchProcessor searchProcessor = new PostSearchProcessor();
		 
		 if(trendingNow == null || TimeUtil.is15MinutesPassed(lastTrendingCheckAt)){
			 trendingNow = searchProcessor.getTrends();
			 lastTrendingCheckAt = new Date();
		 }
		 
		 modelAndView.addObject("trendingNow",trendingNow);
		 
		 modelAndView.addObject("isInstagram",isInstagram);
		 modelAndView.addObject("isTwitter",isTwitter);
		
		 return modelAndView;
	}
	
	@RequestMapping("/home")
	ModelAndView homePage(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("message","Welcome to Trendoor!");
		
		DateFormat dateFormat = new SimpleDateFormat("ddd MMM yyyy/MM/dd HH:mm:ss"); //Sun Jan 25 16:24:52 EST 2015
		   //get current date time with Date()
		return modelAndView;
	}
	
	@RequestMapping("/search")
	ModelAndView searchPage(HttpServletRequest request, HttpServletResponse response) throws Exception{
		

		String subject = request.getParameter("subject");
		String isMobile = request.getParameter("isMobile");
		String isInstagram = request.getParameter("isInstagram");
		String isTwitter = request.getParameter("isTwitter");
		
		PostData postData = new PostData();
		
		postData.setSubject(subject);
		postData.setFromFacebook(false);
		postData.setFromInstagram("Y".equalsIgnoreCase(isInstagram));
		postData.setFromTwitter("Y".equalsIgnoreCase(isTwitter));
		
		PostSearchProcessor searchProcessor = new PostSearchProcessor();
		postData = searchProcessor.getPosts(postData);
		
		if(postData.isSuccess()){
			subid = postData.getSubscriptionId();
		}else{
			System.out.println("Error occured while gethering posts for "+postData.getSubject());
		}
		
		
		subject = subject.substring(1);
		
		if(trendingNow == null || TimeUtil.is15MinutesPassed(lastTrendingCheckAt)){
			ArrayList<String> trendingNow = searchProcessor.getTrends();
		}
		ModelAndView modelAndView;
		if("Y".equalsIgnoreCase(isMobile)){
			modelAndView = new ModelAndView("mobileposts");
		}else{
			modelAndView = new ModelAndView("posts");
		}
		
		
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
