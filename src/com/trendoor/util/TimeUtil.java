package com.trendoor.util;

import java.util.Date;

public class TimeUtil {

	
	
	public static String timeSincePost(Date postTime, Date currentTime){
		
		String timeSincePost = "just now.";
		
		if(postTime == null){
			return timeSincePost;
		}
		
		long diff = currentTime.getTime() - postTime.getTime();
		 
		long diffSeconds = diff / 1000 % 60;
		long diffMinutes = diff / (60 * 1000) % 60;
		long diffHours = diff / (60 * 60 * 1000) % 24;
		long diffDays = diff / (24 * 60 * 60 * 1000);

		if(diffDays != 0){
			if(diffDays == 1){
				timeSincePost = diffDays + " day ago";
			}else{
				timeSincePost = diffDays + " days ago";
			}
			
			return timeSincePost;
		}
		if(diffHours != 0){
			if(diffHours == 1){
				timeSincePost = diffHours + " hour ago";
			}else{
				timeSincePost = diffHours + " hours ago";
			}
			
			return timeSincePost;
		}
		if(diffMinutes != 0){
			if(diffMinutes == 1){
				timeSincePost = diffMinutes + " minute ago";
			}else{
				timeSincePost = diffMinutes + " minutes ago";
			}
			
			return timeSincePost;
		}
		if(diffSeconds != 0){
			timeSincePost = " just now";
			return timeSincePost;
		}
		
		
		return timeSincePost;
		
	}
	
	public static boolean is15MinutesPassed(Date lastUpdatedTime){
		
		if(lastUpdatedTime == null){
			return true;
		}
		
		Date date = new Date();
		long difference = date.getTime() - lastUpdatedTime.getTime(); 
		
		long minutes = difference / (60 * 1000) % 60;
		if(minutes >= 15){
			return true;
		}
		return false;
	}
}
