<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
    	<%response.addHeader("Cache-Control","no-cache");%>
   	 	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <title>TrenDoor</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/globaljs.js"></script>
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
		  	background-image: -webkit-linear-gradient(top, #888888, #666666);
		  	background-image: -moz-linear-gradient(top, #888888, #666666);
		  	background-image: -ms-linear-gradient(top, #888888, #666666);
		  	background-image: -o-linear-gradient(top, #888888, #666666);
		  	background-image: linear-gradient(to bottom, #888888, #666666);
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
			text-shadow: 1px 1px 0 #606060,-1px 1px 0 #606060, 1px -1px 0 #606060, -1px -1px 0 #606060, 0px 1px 0 #606060, 0px -1px 0 #606060, -1px 0px 0 #606060,
    				1px 0px 0 #606060, 2px 2px 0 #606060, -2px 2px 0 #606060,2px -2px 0 #606060,-2px -2px 0 #606060,0px 2px 0 #606060,0px -2px 0 #606060,-2px 0px 0 #606060,
    				2px 0px 0 #606060,1px 2px 0 #606060,-1px 2px 0 #606060,1px -2px 0 #606060,-1px -2px 0 #606060,2px 1px 0 #606060,-2px 1px 0 #606060,2px -1px 0 #606060,-2px -1px 0 #606060;	
		}
		
		.logoSmall{
			font-family:theLeagueOf; 
			font-size: 55px; 
			font-weight: bold; 
			color: blue; 
			text-shadow: 1px 1px 0 #606060,-1px 1px 0 #606060, 1px -1px 0 #606060, -1px -1px 0 #606060, 0px 1px 0 #606060, 0px -1px 0 #606060, -1px 0px 0 #606060,
    				1px 0px 0 #606060, 2px 2px 0 #606060, -2px 2px 0 #606060,2px -2px 0 #606060,-2px -2px 0 #606060,0px 2px 0 #606060,0px -2px 0 #606060,-2px 0px 0 #606060,
    				2px 0px 0 #606060,1px 2px 0 #606060,-1px 2px 0 #606060,1px -2px 0 #606060,-1px -2px 0 #606060,2px 1px 0 #606060,-2px 1px 0 #606060,2px -1px 0 #606060,-2px -1px 0 #606060;	
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
		  	
		  	font-weight: bold;
		  	font-family: Georgia;
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
    
    
    </style>
    <body id="mainContent">
   
   	<div class="mainArea">
    	<input id="isInstagramPlaceHolder" value="${isInstagram}" style="display: none;"/>
     	<input id="isTwitterPlaceHolder" value="${isTwitter}" style="display: none;"/>
    
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
				<label style="font-weight: bold; padding-top:10px; color: white; font-size: 16px;">trending now in NYC: </label>
				<div align="center" valign="top" style="padding-top: 5px;">
					<c:forEach items="${trendingNow}" var="trend">
						<label style="color: blue; cursor: pointer;" onClick="getPostsFromTrend('${trend}')">${trend}</label>&nbsp;&nbsp;
					</c:forEach>
				</div>
			</div>
			
			<div id="mobileMenu" align="center">
				<label style="font-weight: bold; color: white;">trending now in NYC: </label>
				<div align="center" style="margin-top: 5px;">
					<c:forEach items="${trendingNow}" var="trend">
						<label style="color: blue; cursor: pointer;" onClick="getPostsFromTrend('${trend}')">${trend}</label>&nbsp;&nbsp;
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
	<div style="width:100%; font-family:theLeagueOf; font-size: 28px; margin-top: 20px;">
		<table width="100%" align="center">
			<tr valign="top">
				<td width="45%" colspan="0" align="right">
					<img width="220px" height="100px" src="${pageContext.request.contextPath}/assets/images/trendingBlack.png">
				</td>
				<td width="55%" colspan="0" align="left" valign="middle">
					<table width="100%" valign="top">
						<tr valign="top">
							<td colspan="0" align="left" valign="top">
								<label >Keep up!</label>
							</td>
						</tr>
						<tr valign="top">
							<td colspan="0" align="left" valign="top">
								<label >Dont miss out on any stories that is trending in your area.</label>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>

</html>
