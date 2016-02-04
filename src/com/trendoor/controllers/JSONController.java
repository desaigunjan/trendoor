package com.trendoor.controllers;

import java.util.ArrayList;
import java.util.Collection;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.trendoor.processors.PostSearchProcessor;
import com.trendoor.util.TimeUtil;
import com.trendoor.vo.Post;
import com.trendoor.vo.PostData;

@Controller
@RequestMapping("/livefeed/")
public class JSONController {

	@RequestMapping(value = "{subject}/{twitter}/{instagram}/{vine}", method = RequestMethod.GET)
	public @ResponseBody
	Shop getLiveFeed(@PathVariable String subject,@PathVariable("twitter") boolean isTwitter, @PathVariable("instagram") boolean isInstagram, @PathVariable("vine") boolean isVine) {

		System.out.println("Request came for : "+subject);
		
		PostData postData = new PostData();
		
		postData.setSubject(subject);
		postData.setFromFacebook(false);
		postData.setFromInstagram(isInstagram);
		postData.setFromTwitter(isTwitter);
		postData.setFromVine(isVine);
		PostSearchProcessor searchProcessor = new PostSearchProcessor();
		Shop shop = new Shop();
		try {
			postData = searchProcessor.getPosts(postData);
		
			if(subject.indexOf("#") > -1){
				subject = subject.substring(1);
			}
			shop.setSubject(subject);
			shop.setPostList(postData.getPostList());
			
		}	catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return shop;

	}

}