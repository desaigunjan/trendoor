<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
    	<%response.addHeader("Cache-Control","no-cache");%>
   	 	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <title>TrenDoor</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/globaljs.js"></script>
        <link href='http://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet' type='text/css'>
        <link href='${pageContext.request.contextPath}/assets/css/jquery.loader.css' rel='stylesheet' type='text/css'>
        
    </head>
    
    <style>
    	
		#subjectField{
			font-size:16px; 
			width:500px; 
			font-weight:bold; 
			height: 30px;
			-webkit-border-radius: 6 6 6 6;
		  	-moz-border-radius: 6 6 6 6;
		  	border-radius: 6px 6px 6px 6px;
		  	border: 0px;
		  	padding-left: 8px;
		}
		
		.mainArea { 
		
		  	background-image: -webkit-linear-gradient(top, #37426E, #37426E);
		  	background-image: -moz-linear-gradient(top, #37426E, #37426E);
		  	background-image: -ms-linear-gradient(top, #37426E, #37426E);
		  	background-image: -o-linear-gradient(top, #37426E, #37426E);
		  	background-image: linear-gradient(to bottom, #37426E, #37426E);
		  	
		  	/*background-image: -webkit-linear-gradient(top, #888888, #666666);
		  	background-image: -moz-linear-gradient(top, #888888, #666666);
		  	background-image: -ms-linear-gradient(top, #888888, #666666);
		  	background-image: -o-linear-gradient(top, #888888, #666666);
		  	background-image: linear-gradient(to bottom, #888888, #666666);*/
		  	filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#888888', endColorstr='#666666',GradientType=1 );
		  	
		  	background-repeat: no-repeat;
		  	padding-bottom: 10px;
		  	width: 100%;
		}
		
		@font-face {
		  	font-family: theLeagueOf;
		  	src: url("${pageContext.request.contextPath}/assets/fonts/theleagueof-league-gothic-64c3ede/webfonts/leaguegothic-regular-webfont.woff");
		}

		body.wait *, body.wait{
		  	cursor: progress !important;
		}

		.handCursor{
			cursor: pointer;
		} 
		
		.logo{
			font-family:theLeagueOf; 
			font-size: 50px; 
			font-weight: bold; 
			color: white; 
			text-shadow: 1px 1px 0 #37426E,-1px 1px 0 #37426E, 1px -1px 0 #37426E, -1px -1px 0 #37426E, 0px 1px 0 #37426E, 0px -1px 0 #37426E, -1px 0px 0 #37426E,
    				1px 0px 0 #37426E, 2px 2px 0 #37426E, -2px 2px 0 #37426E,2px -2px 0 #37426E,-2px -2px 0 #37426E,0px 2px 0 #37426E,0px -2px 0 #37426E,-2px 0px 0 #37426E,
    				2px 0px 0 #37426E,1px 2px 0 #37426E,-1px 2px 0 #37426E,1px -2px 0 #37426E,-1px -2px 0 #37426E,2px 1px 0 #37426E,-2px 1px 0 #37426E,2px -1px 0 #37426E,-2px -1px 0 #37426E;	
		}
		
		.logoSmall{
			font-family:theLeagueOf; 
			font-size: 55px; 
			font-weight: bold; 
			color: blue; 
			text-shadow: 1px 1px 0 #37426E,-1px 1px 0 #37426E, 1px -1px 0 #37426E, -1px -1px 0 #37426E, 0px 1px 0 #37426E, 0px -1px 0 #37426E, -1px 0px 0 #37426E,
    				1px 0px 0 #37426E, 2px 2px 0 #37426E, -2px 2px 0 #37426E,2px -2px 0 #37426E,-2px -2px 0 #37426E,0px 2px 0 #37426E,0px -2px 0 #37426E,-2px 0px 0 #37426E,
    				2px 0px 0 #37426E,1px 2px 0 #37426E,-1px 2px 0 #37426E,1px -2px 0 #37426E,-1px -2px 0 #37426E,2px 1px 0 #37426E,-2px 1px 0 #37426E,2px -1px 0 #37426E,-2px -1px 0 #37426E;	
		}

		img.expand { 
			width: 18em; 
		}
		
		.menuBottom{
			padding: 1px;
			position: fixed;
			bottom:0;
			left:0;
			z-index:1000;
			border-top: 2px solid black;
			background-color: white;

		}
		
		#subjectFieldMobile{
			font-size:16px; 
			font-weight:bold; 
			height: 20px;
			-webkit-border-radius: 6 6 6 6;
		  	-moz-border-radius: 6 6 6 6;
		  	border-radius: 6px 6px 6px 6px;
		  	border: 0px;
		  	padding-left: 8px;
		}
		
		.menuRight{
		  	position: fixed; 
		  	top:55px; 
		  	right: 10px;
		  	z-index: 1000;
		  	color: black;
		  	width: 170px;
		  	background-image: -webkit-linear-gradient(top, #EEEEEE, #DDDDDD);
		  	background-image: -moz-linear-gradient(top, #EEEEEE, #DDDDDD);
		  	background-image: -ms-linear-gradient(top, #EEEEEE, #DDDDDD);
		  	background-image: -o-linear-gradient(top, #EEEEEE, #DDDDDD);
		  	background-image: linear-gradient(to bottom, #EEEEEE, #DDDDDD);
		  	
		  	-webkit-border-radius: 4 4 4 4;
		  	-moz-border-radius: 4 4 4 4;
		  	border-radius: 4px 4px 4px 4px;
		  	padding: 10px;
		  	padding-right: 10px;
		  	
		  	font-family: 'Montserrat', sans-serif;
		    color: #000000;
		    font-size: 12px;
		  	
		  	display: none;
		  	
		}
		
		.triangle {
		    width: 0;
		    height: 0;
		    border: solid 23px;
		    border-color: transparent transparent #EEEEEE transparent;
		    
		    top:20px; 
		  	right: 12px;
		  	z-index: 1010;
		  	position: fixed;
		  	
		  	display: none;
		}
		
		.menuButtonRight{
			position: fixed; 
		  	top:3px; 
		  	right: 5px;
		  	z-index: 2005;
		  	padding-right: 10px;
		  	padding-top: 3px;
		  	cursor:pointer;
		  	
		}
		
		#instaSwitch{
			cursor: pointer;
			background-color: #EEEEEE;
		}
		
		#twitterSwitch{
			cursor: pointer;
			background-color: #EEEEEE;
		}
		body { margin: 0px; }
    
    	.ui-dialog-titlebar {display:none}
    	
    	.textContent{
    		width:37%;
    		font-family: 'Montserrat', sans-serif;
    		font-size: 18px; 
    		margin-top: 50px;
    		/*border: 1px solid #37426E;*/
    		color: white;
    		padding: 15px;
    		-webkit-border-radius: 6 6 6 6;
		  	-moz-border-radius: 6 6 6 6;
		  	border-radius: 6px 6px 6px 6px;
		  	
		  	background-image: -webkit-linear-gradient(bottom, #677091, #677091);
		  	background-image: -moz-linear-gradient(bottom, #677091, #677091);
		  	background-image: -ms-linear-gradient(bottom, #677091, #677091);
		  	background-image: -o-linear-gradient(bottom, #677091, #677091);
		  	background-image: linear-gradient(to top, #677091, #677091);
  
    	}
    	
    	
		#jquery-loader.blue-with-image-2{
		    border:none;
		    padding-top:35px;
		    background-color: transparent;
		    text-align: center;
		    background-image: url("${pageContext.request.contextPath}/assets/images/ajax-loader.gif");
		    background-position: center center;
		    background-repeat: no-repeat;
		 
		}
    	
    </style>
    <input id="locationPlaceHolder" value="${location}" style="display: none;"/>
    <body id="mainContent">
    	<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
    	<script src="${pageContext.request.contextPath}/assets/js/jquery.loader.js"></script>
    
    	<input id="isInstagramPlaceHolder" value="${isInstagram}" style="display: none;"/>
     	<input id="isTwitterPlaceHolder" value="${isTwitter}" style="display: none;"/>
     	<input id="locationPlaceHolder" value="${location}" style="display: none;"/>
   	<div class="mainArea">
    	
		<div class="menuButtonRight" title="Menu">
			<img class="postImage" width="40px" height="35px" onClick="toggleMenu()" src="${pageContext.request.contextPath}/assets/images/menu.png">
		</div>	
		<div class="triangle" ></div>
		<div id="menu" class="menuRight" align="center">
			<table width="100%"><tr><td align="left" style="border-bottom: 1px solid black;"><label>Feed from: </label></td></tr></table>
			<table style="margin-bottom: 15px; margin-top: 5px; ">
				<tr>
					<td align="right">twitter: </td><td align="left"></td>
					<td><img id="twitterSwitch" width="60px" height="20px" onClick="toggleSwitches('TW')" src="${pageContext.request.contextPath}/assets/images/on.png"></td>
				</tr>
				<tr><td></tr>
				<tr>
					<td align="right">instagram: </td><td align="left"></td>
					<td><img id="instaSwitch" width="60px" height="20px" onClick="toggleSwitches('IN')" src="${pageContext.request.contextPath}/assets/images/on.png"></td>
				</tr>
			</table>
			
			<button class="handCursor" onClick="toggleMenu()">close</button>
		</div>
		
		
		
			<div align="center">
				<label class="logo">trendoor</label><!--label class="logo">r </label><label class="logo">e </label><label class="logo">n </label><label class="logo">d </label><label class="logo">o </label><label class="logo">o </label><label class="logo">r </label--> 
			</div>
			
			<div id="desktopMenu" align="center">	
				<table id="searchBox" align="center" cellspacing="0">
					<tr valign="middle">
						<td align="left" colspan="0"><input id="subjectField" onkeypress=" return checkKey(event)" value="${subject}" size="30" type="text" placeholder=" Search here for trending stories with hashtag." tabindex="0" autocomplete="off" maxlength="240" /></td>
						<!-- td align="right" colspan="0"><button class="btn" type="submit" onClick="getPosts()">trendoor</button></td width="290px" height="200px" -->
					</tr>
				</table>
				<br/>
				<label style="padding-top:10px; color: white; font-size: 14px; font-family: 'Montserrat', sans-serif;">trending now in </label><label style="padding-top:10px; color: gray; font-size: 14px; font-family: 'Montserrat', sans-serif;"> ${location} : </label>
				<div align="center" valign="top" style="padding-top: 5px;">
					<c:forEach items="${trendingNow}" var="trend">
						<label style="padding-top:10px;color: green; cursor: pointer;" onClick="getPostsFromTrend('${trend}')">${trend}</label>&nbsp;&nbsp;
					</c:forEach>
				</div>
			</div>
			
			<div id="mobileMenu" align="center">
				<label style="color: white;">trending now in: </label><label style="font-weight: bold; color: gray;"> ${location} </label>
				<div align="center" style="margin-top: 5px;">
					<c:forEach items="${trendingNow}" var="trend">
						<label style="color: green; cursor: pointer;" onClick="getPostsFromTrend('${trend}')">${trend}</label>&nbsp;&nbsp;
					</c:forEach>
				</div>
				<table class="menuBottom" id="searchBox" valign="bottom" cellspacing="0">
					<tr valign="middle">
						<td align="left" colspan="0"><input class="mobileInputField" style="height:20px;" onkeypress=" return checkKey(event)" id="subjectFieldMobile" type="text" placeholder=" Search here for trending stories." value="${subject}"></td>
						<td align="right" valign="bottom" colspan="0" style="margin-top:2px; margin-right: 10px;"><img width="30px" height="30px" onclick="getPosts()" src="${pageContext.request.contextPath}/assets/images/search.png"></td>
					</tr>
				</table>	
				
				
			</div>
			
		</div>
	</body>
	<div align="center">
		<div class="textContent" align="left">
			<label style="font-weight: bold; font-size: 24px; margin-bottom: 10px;">Stay Connected!</label><br><br>
			<label style="color:#fcfcfc;">Dont miss out on any stories trending in your area.</label>
		</div>
	</div>
	<div align="center">
		<div class="textContent" align="left">
			<label style="font-weight: bold; font-size: 24px; margin-bottom: 10px;">Stay Tuned!</label><br><br>
			<label style="color:#fcfcfc;">Know everything about what you care for.</label>
	</div>
	</div>

</html>
