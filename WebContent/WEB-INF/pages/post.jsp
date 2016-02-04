<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="${pageContext.request.contextPath}/assets/js/masonry.pkgd.min.js"></script>
<div class="col-lg-10 col-lg-offset-1 col-sm-10 col-sm-offset-1 boxShadow text-center paddingtop50" style="background: #f1f1f1;">
<h1 id="subjectField"></h1>
<div id="postBox" class="grid text-center nopadding">

    	<c:forEach  items="${results}" var="post">
    		<div class="col-lg-4 col-md-6 col-sm-12 item nopadding">
		    	<div class="panel panel-warning borderWhite boxShadow nopadding">
				  <div class="panel-body">
				    <div class="row margntopminus50 team-member nopadding" >
				    	<img src="${post.postUser.profilePicture}" height="85px" width="85px" class="img-circle boxShadowTop" alt="">
				    	<div class="row margntop5">
				    		<span class="col-md-12 text-center nopadding username" > ${post.postUser.name}  ·  ${post.postUser.screenName}</span>
				    	</div>
				    	<div class="row">
				    		<span class="col-lg-12 text-center"><c:if test="${post.from == 'TW'}"><span style="color:#fed136"><i class="fa fa-2x fa-twitter"></i></span></c:if><c:if test="${post.from == 'IG'}"><span style="color:#fed136"><i class="fa fa-2x fa-instagram"></i></span></c:if></span>
				    	</div>
				    </div>
				    <hr class="nopadding nomargin" />
				    <c:if test="${post.type == 'image'}">
	       						<img height="350px;" width="95%" src="${post.picture}">
					</c:if>
					<c:if test="${post.type == 'video'}">
						<c:if test="${post.videoLink != null}">
       						<div class="embed-responsive embed-responsive-16by9">
							  <iframe class="embed-responsive-item" src="${post.videoLink}"></iframe>
							</div>
						</c:if>
					</c:if>
					
					<c:if test="${post.caption != null}">
						<p class="text-left text paddingtop5">${post.caption}</p>
					</c:if>
				    <c:if test="${post.message != null}">
						<p class="text-left text paddingtop5">${post.message}</p>
					</c:if>
					<span class="col-lg-12 boldFont text-center"> ${post.time}</span>
					
				  </div>
				</div>
			</div>
    	</c:forEach>
</div>
</div>		