<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
    <%response.addHeader("Cache-Control","no-cache");%>
   	 <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <title>TrenDoor</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/global.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/desktop.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/mobile.css" />
    </head>

	<body id="mainContent">
		<div align="center">
			<label class="logo" style="">trendoor</label> 
		</div>
		
		<div id="desktopMenu" align="center">	
		
			<table id="searchBox" align="center" cellspacing="0">
				<tr valign="middle">
					<td align="left" colspan="0"><input id="subjectField" onkeypress=" return checkKey(event)" value="${subject}" size="30" type="text" placeholder=" Search here for trending stories." tabindex="0" autocomplete="off" maxlength="240" /></td>
					<!-- td align="right" colspan="0"><button class="btn" type="submit" onClick="getPosts()">trendoor</button></td width="290px" height="200px" -->
				</tr>
			</table>
		</div>
		
			<div align="center" style="margin-top: 25px;">
			
	        <c:forEach items="${results}" var="post">
			        		<div class="postBox" onclick="openPost('${post.link}')">
			        			<table>
			        				<c:if test="${post.picture != null}">
			        					<tr><td align="center" style="border: 1px solid;" colspan="0" width="290px"><img class="expand"  src="${post.picture}"></td></tr>
									</c:if>
									<tr><td align="left" colspan="0" width="290px"><label width="290px" style="font-weight: bold; color: #3cb0fd;">${post.user} </label><label style="font-weight: normal; color: gray; font-size: 10px;"> - ${post.time}</label></td></tr>
									<c:if test="${post.message != null}">
										<tr><td align="left" colspan="0" width="290px"><label style="word-wrap: break-word; font-weight: normal; color: black;">${post.message}</label></td></tr>
									</c:if>
									<c:if test="${post.caption != null}" >
										<tr><td align="left" colspan="0" width="290px"><label width="290px" style="font-weight: normal; color: black;font-size: 10px;">${post.caption}</label></td></tr>
									</c:if>
									<c:if test="${post.from == 'FB'}">
										<tr valign="top"><td align="left" valign="top"><img style="border: 2px solid; position:relative; right:3%; bottom: 300%;" width="20px" height="20px" src="${pageContext.request.contextPath}/assets/images/facebook.png">
										<img style="position:relative; right:3%; bottom: 300%;" width="20px" height="20px" src="${post.icon}"></td></tr>
									</c:if>
									<c:if test="${post.from == 'TW'}">
										<tr valign="top"><td align="left" valign="top"><img style="border: 2px solid; position:relative; right:3%; bottom: 300%;" width="20px" height="20px" src="${pageContext.request.contextPath}/assets/images/twitter.png"></td></tr>
									</c:if>
									
								</table>
			        		</div>
	        				
	       	</c:forEach>
	    </div>
		
		
	</body>

</html>
