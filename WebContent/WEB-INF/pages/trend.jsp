<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<title>Trendoor - Know whats trending!</title>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
    <meta name="author" content="">
	<meta itemprop="description" name="description" content="Trendoor is a tool which gathers posts from various social media sites and present them in a rich user interface. It also enables users with trending hashtags based on their location."/> 
	<meta name="news_keywords" content="Social, Posts, News, Media, Images, Meme, Video"/> 
	<!--  meta name="twitter:site" value="@WashingtonPost"/--> 
	<meta property="og:description" content="Trendoor is a tool which gathers posts from various social media sites and present them in a rich user interface. It also enables users with trending hashtags based on their location."/> 
	<meta property="og:site_name" content="Trendoor"/> 
	<meta itemprop="mainEntityOfPage" content="True"/> 
	<meta itemprop="image" property="og:image" content="http://trendoor.thruhere.net/assets/images/trendoor.png"/> 
	<meta property="og:title" content="Trendoor"/> 
	
	
	<link rel='shortcut icon' href='${pageContext.request.contextPath}/assets/images/favicon.ico' type='image/x-icon'>
	 <link rel="image_src" href="http://trendoor.thruhere.net/assets/images/trendoor.png">
	
    <link href="${pageContext.request.contextPath}/assets/trend/css/bootstrap.min.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/assets/trend/css/bootstrap-switch.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/assets/trend/css/agency.css" rel="stylesheet">

    <link href="${pageContext.request.contextPath}/assets/trend/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/creative/css/animate.min.css" type="text/css">
</head>

<body id="page-top" class="index">

    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container">
            <div class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand page-scroll homePage" href="#page-top">Trendoor</a>
            </div>
            
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="hidden">
                        <a href="#page-top"></a>
                    </li>
                    <li>
                        <a class="page-scroll homePage" href="#about">About</a>
                    </li>
                    <li>
                        <a class="page-scroll homePage" href="#contact">Contact</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <header>
        <div class="container">
            <div class="intro-text">
                <div class="col-lg-4 col-lg-offset-4 col-sm-8 col-sm-offset-2 input-group custom-search-form">
                    <input type="text" id="searchField" class="form-control" placeholder="#hashtag" onkeypress=" return searchClicked(event)">
                    <span class="input-group-btn">
                    	<button class="search btn btn-default" type="button">
                        	<i class="fa fa-search"></i>
                    	</button>
                	</span>
               	</div>
                <hr>
                <p class="boldFont"  style="color:white;">  <b class="trendBody padding10 trendHolder"> Trending in <i class="fa fa-map-marker"></i> ${location} </b></p>
                <div class="trendingLocation" style="margin-top:-3px;" >
                	<c:forEach items="${trendingNow}" var="trend">
                		<a class="btn btn-default btn-md animated wow bounceIn trend" onclick="getPosts('${trend}')"><b>${trend}</b></a>
                	</c:forEach>
            	</div>
            	<div class="row margntop">
            		<a class="page-scroll btn btn-xl animated wow tada homePage" data-wow-duration="9s" href="#about">What's Trendoor?</a>
            	</div>
            </div>
        </div>
        
    </header>
    
    <div id="menu-toggle" class="settingsButton">
    	<i id="sButtom" style="color:white;" class="fa fa-cogs fa-2x"></i>
    </div>
    
    <div id="sidebar-wrapper">
        <div class="settings nopadding row">
	    	<h4 class="text-center nopadding nomargin themeColor" style="color:white;margin-top:20px;">SETTINGS</h4>
	    	<hr>
	    	<div class="col-xs-12" style="background:black; margin-top:20px;">
	    		<p class="text-left nopadding nomargin" style="padding-left:10px;color:gray;">Feed From:</p>
	    	</div>
	    	<div class="col-xs-12" style="margin-top:20px;margin-bottom:20px;">
	    		<div class="col-xs-4 text-center">
	    			<div id="isTwitter"  class="on" onclick="settingChanged('isTwitter')">
	    				<i class="fa fa-twitter fa-2x"></i><br>
	    				<span class="text-center">Twitter</span>
	    			</div>
	    		</div>
	    		<div class="col-xs-4 text-center">
	    			<div id="isInstagram" class="on" onclick="settingChanged('isInstagram')">
	    				<i class="fa fa-instagram fa-2x"></i><br>
	    				<span class="text-center">Instagram</span>
	    			</div>
	    		</div>
	    		<div class="col-xs-4 text-center">
	    			<div id="isVine" class="on" onclick="settingChanged('isVine')">
	    				<i class="fa fa-vine fa-2x"></i><br>
	    				<span class="text-center">Vine</span>
	    			</div>
	    		</div>
	    	</div>
	    	<br>
	    	<div class="col-xs-12" style="background:black; margin-top:10px;">
	    		<p class="text-left nopadding nomargin" style="padding-left:10px;color:gray;">Feed Type:</p>
	    	</div>
	    	<div class="col-xs-12" style="margin-top:20px;margin-bottom:20px;">
	    		<div class="col-xs-4 text-center active">
	    			<div id="isText" class="on">
		    			<i class="fa fa-text-height fa-2x"></i><br>
		    			<span class="text-center">Text</span>
		    		</div>
	    		</div>
	    		<div class="col-xs-4 text-center active">
		    		<div id="isImage" class="on" onclick="settingChanged('isImage')">
		    			<i class="fa fa-picture-o fa-2x"></i><br>
		    			<span class="text-center">Image</span>
	    			</div>
	    		</div>
	    		<div class="col-xs-4 text-center active">
		    		<div id="isVideo" class="on" onclick="settingChanged('isVideo')">
		    			<i class="fa fa-video-camera fa-2x"></i><br>
		    			<span class="text-center">Video</span>
	    			</div>
	    		</div>
	    	</div>
	    	
    	</div>
    </div>
    
    
    <div id="post" class="col-sm-12 nopadding nomargin" style="display: ;">
    
		    <div class="col-sm-10 col-sm-offset-1 nopadding margnBottom text-center paddingtop50">
				<div class="col-sm-12 text-center nopadding nomargin"><p id="subjectField" class="hugeText col-sm-12 text-center nopadding nomargin" >${subject}</p></div>
				<div id="horizontalLine" class="col-sm-12 text-center"><hr class="text-center"/></div>
				<div id="postBox" class="col-sm-12 grid text-center nopadding paddingtop10">
				</div>
				
			</div>
    </div>
    
    <section id="about">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2 class="logoFont section-heading">Trendoor</h2>
                    <h3 class="col-md-8 col-md-offset-2 section-subheading text-muted">Trendoor is a tool which gathers posts from various social media sites and present them in a rich user interface. It also enables users with trending hashtags based on their location.</h3>
                </div>
            </div>
            <div class="row text-center">
                <div class="col-md-4">
                    <span class="fa-stack fa-4x">
                        <i class="fa fa-circle fa-stack-2x text-primary"></i>
                        <i class="fa fa-signal fa-stack-1x fa-inverse"></i>
                    </span>
                    <h4 class="service-heading">Know Whats Trending</h4>
                    <p class="text-muted">Dont miss out on any stories trending in your area.</p>
                </div>
                
                <div class="col-md-4">
                    <span class="fa-stack fa-4x">
                        <i class="fa fa-circle fa-stack-2x text-primary"></i>
                        <i class="fa fa-comments fa-stack-1x fa-inverse"></i>
                    </span>
                    <h4 class="service-heading">Hear Opinion</h4>
                    <p class="text-muted">Search with hashtag and hear public voice</p>
                </div>
                
                <div class="col-md-4">
                    <span class="fa-stack fa-4x">
                        <i class="fa fa-circle fa-stack-2x text-primary"></i>
                        <i class="fa fa-check fa-stack-1x fa-inverse"></i>
                    </span>
                    <h4 class="service-heading">Stay up to date</h4>
                    <p class="text-muted">Know everything about what you care for.</p>
                </div>
                
            </div>
            <hr>
            <div class="row margntop">
                <div class="col-lg-12 text-center">
                    <h2 class="col-md-6 col-md-offset-3 text-muted" style="color:#fed136">STEP INTO THE DOOR AND DISCOVER WHAT'S TRENDING!</h2>
                </div>
            </div>
        </div>
    </section>
    
    <!-- Contact Section -->
    <section id="contact">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2 class="section-heading">Contact Us</h2>
                    <p style="color:#ddd">Feel free to email us to provide some feedback, suggestions, report bugs or to just say hello!</p>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <form name="sentMessage" id="contactForm" novalidate>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="Your Name *" id="name" required data-validation-required-message="Please enter your name.">
                                    <p class="help-block text-danger"></p>
                                </div>
                                <div class="form-group">
                                    <input type="email" class="form-control" placeholder="Your Email *" id="email" required data-validation-required-message="Please enter your email address.">
                                    <p class="help-block text-danger"></p>
                                </div>
                                <div class="form-group">
                                    <input type="tel" class="form-control" placeholder="Your Phone *" id="phone" required data-validation-required-message="Please enter your phone number.">
                                    <p class="help-block text-danger"></p>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <textarea class="form-control" placeholder="Your Message *" id="message" required data-validation-required-message="Please enter a message."></textarea>
                                    <p class="help-block text-danger"></p>
                                </div>
                            </div>
                            <div class="clearfix"></div>
                            <div class="col-lg-12 text-center">
                                <div id="success"></div>
                                <button type="submit" class="btn btn-xl">Send Message</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </section>

    <footer class="">
        <div class="col-sm-12" style="padding-top:5px;padding-bottom:5px;">
            <div class="col-sm-4" style="padding-top:5px;padding-bottom:5px;">
               <ul class="col-sm-12 list-inline quicklinks">
                    <li class="col-sm-6 homePage"><a class="homePage" href="#about">About</a>
                    </li>
                    <li class="col-sm-6 homePage"><a class="homePage" href="#contact">Contact</a>
                    </li>
                </ul>
            </div>
            <div class="col-sm-4" style="padding-top:5px;padding-bottom:5px;">
                <ul class="list-inline social-buttons">
                    <li><a href="#"><i class="fa fa-twitter"></i></a>
                    </li>
                    <li><a href="#"><i class="fa fa-facebook"></i></a>
                    </li>
                    <li><a href="#"><i class="fa fa-linkedin"></i></a>
                    </li>
                </ul>
            </div>
            <div class="col-sm-4" style="padding-top:5px;padding-bottom:5px;">
                 <span class="copyright">Copyright &copy; Trendoor 2015</span>
            </div>
        </div>
    </footer>

    <script>
  window.fbAsyncInit = function() {
    FB.init({
      appId      : '272743909422482',
      xfbml      : true,
      version    : 'v2.5'
    });
  };

  (function(d, s, id){
     var js, fjs = d.getElementsByTagName(s)[0];
     if (d.getElementById(id)) {return;}
     js = d.createElement(s); js.id = id;
     js.src = "//connect.facebook.net/en_US/sdk.js";
     fjs.parentNode.insertBefore(js, fjs);
   }(document, 'script', 'facebook-jssdk'));
</script>

    <script src="${pageContext.request.contextPath}/assets/trend/js/jquery.js"></script>



    <script src="${pageContext.request.contextPath}/assets/trend/js/bootstrap.min.js"></script>

    <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/trend/js/classie.js"></script>
    <script src="${pageContext.request.contextPath}/assets/trend/js/cbpAnimatedHeader.js"></script>

    <script src="${pageContext.request.contextPath}/assets/trend/js/jqBootstrapValidation.js"></script>
    <script src="${pageContext.request.contextPath}/assets/trend/js/contact_me.js"></script>

    
    <script src="${pageContext.request.contextPath}/assets/js/masonry.pkgd.min.js"></script>
    
    <script src="${pageContext.request.contextPath}/assets/js/jquery.loader.js"></script>
	<script src="${pageContext.request.contextPath}/assets/trend/js/bootstrap-switch.js"></script>
	<script src="${pageContext.request.contextPath}/assets/trend/js/agency.js"></script>
	<script>
    
    $("#menu-toggle").click(function() {
    	
    	if($("#sButtom").hasClass("fa-cogs")){
    		$("#sButtom").removeClass("fa-cogs");
    		$("#sButtom").addClass("fa-times");
    	}else{
    		
    		$("#sButtom").removeClass("fa-times");
    		$("#sButtom").addClass("fa-cogs");
    	}
    	
        $("#sidebar-wrapper").toggleClass("active");
        $("#menu-toggle").toggleClass("active");
        
    });

    $("#menu-close").click(function() {
        $("#sidebar-wrapper").toggleClass("active");
    });
    

    // Scrolls to the selected menu item on the page
    $(function() {
        $('a[href*=#]:not([href=#])').click(function() {
            if (location.pathname.replace(/^\//, '') == this.pathname.replace(/^\//, '') || location.hostname == this.hostname) {

                var target = $(this.hash);
                target = target.length ? target : $('[name=' + this.hash.slice(1) + ']');
                if (target.length) {
                    $('html,body').animate({
                        scrollTop: target.offset().top
                    }, 1000);
                    return false;
                }
            }
        });
    });
    
    
    </script>

</body>

</html>