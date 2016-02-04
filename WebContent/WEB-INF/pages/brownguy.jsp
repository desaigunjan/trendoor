<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Gunjan Desai</title>

    <!-- Bootstrap Core CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/creative/css/bootstrap.min.css" type="text/css">

    <!-- Custom Fonts -->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/creative/font-awesome/css/font-awesome.min.css" type="text/css">

    <!-- Plugin CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/creative/css/animate.min.css" type="text/css">

    <!-- Custom CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/creative/css/creative.css" type="text/css">

</head>

<body id="page-top">

    <nav id="mainNav" class="navbar navbar-default navbar-fixed-top">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand page-scroll" href="#page-top">
                      <i class="fa fa-user fa-1x"></i> <span class="light" style="font-size: 14px;">brown  guy</span>
                </a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a class="page-scroll" href="#about">Who am I?</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#services">Portfolio</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#photography">Photography</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#journey">Journey</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#contact">Contact</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>

    <header>
        <div class="header-content">
            <div class="header-content-inner">
                <h1>Gunjan Desai</h1>
                <hr>
                <p class="normal">... just another developer! </p>
                <a href="#about" class="btn btn-circle page-scroll">
                    <i class="fa fa-angle-double-down animated"></i>
                </a>
            </div>
        </div>
    </header>

    <section class="bg-primary" id="about">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2 text-center">
                    <h2 class="section-heading">Gunjan Desai</h2>
                    <hr class="light">
                    <p class="text-faded">Hi! If you are reading this, my guess is you already know me - #smallFish. I am just that average developer who likes to code those 'Hello World' programs with soda bottle next to him. Lavishly #sarcastic. O yea, Go Patriots!</p>
                    <a href="#services" class="btn btn-circle page-scroll">
	                    <i class="fa fa-angle-double-down animated"></i>
	                </a>
                </div>
            </div>
        </div>
    </section>

    <section id="services">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2 class="section-heading">Things I have done..</h2>
                    <hr class="primary">
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
            	<div class="col-lg-12 text-center">
                <div class="col-lg-3 col-lg-offset-3 col-md-6 text-center">
                    <div class="service-box">
                        <a class="normal" href="http://trendoor.thruhere.net/trend" target="_blank">
                        	<i class="fa fa-4x fa-newspaper-o wow bounceIn text-primary" data-wow-delay=".2s"></i>
                        	<h3>Trendoor</h3>
                        	<p class="text-muted"> Know what's trending. See what people are posting.</p>
                        </a>
            			<div class="row mrgnTop20"><a href="http://trendoor.thruhere.net/trend" class="btn-xl animated wow tada" data-wow-delay=".3s">Try Trendoor!</a></div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 text-center">
                    <div class="service-box">
	                    <a class="normal" href="localhost:8080/giraffe" target="_blank">
	                        <i class="fa fa-4x fa-bar-chart-o wow bounceIn text-primary" data-wow-delay=".3s"></i>
	                        <h3>Giraffe</h3>
	                        <p class="text-muted"> Create interactive custom graphs and dashboards.</p>
	                        
	                    </a>
	            		<div class="row mrgnTop20"><a href="http://trendoor.thruhere.net/trend" class="btn-xl animated wow tada" data-wow-delay=".3s">Try Giraffe!</a></div>
                    </div>
                </div>
                </div>
            </div>
        </div>
    </section>

    <section class="no-padding" id="photography">
        <div class="container-fluid">
            <div class="row no-gutter">
                <div class="col-lg-4 col-sm-6">
                    <a class="portfolio-box">
                        <img src="${pageContext.request.contextPath}/assets/creative/img/portfolio/1.jpg" class="img-responsive" alt=""/>
                        <div class="portfolio-box-caption">
                            <div class="portfolio-box-caption-content">
                                <div class="project-name">
                                    <i class="fa fa-1x fa-map-marker wow bounceIn" data-wow-delay=".2s"></i> Hamptons, NY
                                </div>
                            </div>
                        </div>
                    </a>
                </div>
                
                <div class="col-lg-4 col-sm-6">
                    <a class="portfolio-box">
                        <img src="${pageContext.request.contextPath}/assets/creative/img/portfolio/4.jpg" class="img-responsive" alt=""/>
                        <div class="portfolio-box-caption">
                            <div class="portfolio-box-caption-content">
                                <div class="project-name">
                                    <i class="fa fa-1x fa-map-marker wow bounceIn" data-wow-delay=".2s"></i> Shelton, CT
                                </div>
                            </div>
                        </div>
                    </a>
                </div>
                <div class="col-lg-4 col-sm-6">
                    <a class="portfolio-box">
                        <img src="${pageContext.request.contextPath}/assets/creative/img/portfolio/3.jpg" class="img-responsive" alt=""/>
                        <div class="portfolio-box-caption">
                            <div class="portfolio-box-caption-content">
                            <div class="project-name">
                                <i class="fa fa-1x fa-map-marker wow bounceIn" data-wow-delay=".2s"></i> Morristown, NJ
                            </div>
                            </div>
                        </div>
                    </a>
                </div>
                <div class="col-lg-4 col-sm-6 bottom-border" style="background-image: url(../img/portfolio/car.jpg);">
                        <video controls class="img-responsive"><source src="${pageContext.request.contextPath}/assets/creative/img/portfolio/Car2.mov" type="video/mp4"></video>
                </div>
                <div class="col-lg-4 col-sm-6 bottom-border" style="background-image: url(../img/portfolio/rango.jpg);">
                        <video controls class="img-responsive"><source src="${pageContext.request.contextPath}/assets/creative/img/portfolio/rangol.mov" type="video/mp4"></video>
                </div>
                <div class="col-lg-4 col-sm-6 bottom-border" style="background-image: url(../img/portfolio/car2.jpg);">
                        <video controls class="img-responsive"><source src="${pageContext.request.contextPath}/assets/creative/img/portfolio/carFinal.mov" type="video/mp4"></video>
                </div>
            </div>
        </div>
    </section>
    
   <section id="journey">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2 class="section-heading">This is how I got here..</h2>
                    <hr class="primary">
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
            	<div class="col-lg-12 text-center">
                <div class="col-lg-2 col-lg-offset-0 col-md-6 text-center">
                    <div class="service-box" >
                        	<h2>1986</h2>
                        	<div class="btn btn-circle" style="cursor:text; background-color: #f05f40;padding-top: 5px; padding-bottom:5px;">
			                    <i class="fa fa-gift animated wow bounceIn" data-wow-delay=".2s" style="color: white;"></i>
			                </div>
                        	<h3>Born</h3>
                        	<p class="text-muted">Happy Birthday to me!</p>
                    </div>
                </div>
                <div class="col-lg-2 col-md-6 text-center">
                    <div class="service-box">
                        <h2>2008</h2>
                        <div class="btn-circle btn" style="cursor:text; background-color: #f05f40; padding-right: 10px;">
		                    <i class="fa fa-mortar-board animated wow bounceIn" data-wow-delay=".5s" style="color: white;padding-right: 5px;"></i>
		                </div>
                        <h3>Bachelor's</h3>
                        <p class="text-muted">S.P. University, India.</p>
                    </div>
                </div>
                <div class="col-lg-2 col-md-6 text-center">
                    <div class="service-box">
                        <h2>2010</h2>
                        <div class="btn btn-circle" style="cursor:text; background-color: #f05f40; padding-left: 15px;padding-top: 4px;">
		                    <i class="fa fa-university animated wow bounceIn" data-wow-delay=".8s" style="color: white;padding-right: 5px;"></i>
		                </div>
                        <h3>Master's</h3>
                        <p class="text-muted">New Jersey Institute of Technology, NJ</p>
                    </div>
                </div>
                <div class="col-lg-2 col-md-6 text-center">
                    <div class="service-box">
                        <h2>2010</h2>
                        <div class="btn btn-circle" style="cursor:text; background-color: #f05f40; padding-top: 5px; ">
		                    <i class="fa fa-suitcase animated wow bounceIn" data-wow-delay=".8s" style="color: white;"></i>
		                </div>
                        <h3>First Job</h3>
                        <p class="text-muted">Mercedes-Benz of USA</p>
                    </div>
                </div>
                <div class="col-lg-2 col-md-6 text-center">
                    <div class="service-box">
                        <h2>2012</h2>
                        <div class="btn btn-circle" style="cursor:text; background-color: #f05f40;">
		                    <i class="fa fa-heart animated wow bounceIn" data-wow-delay="1.2s" style="color: white;"></i>
		                </div>
                        <h3>Married</h3>
                        <p class="text-muted">.. and she said 'Yes'!</p>
                    </div>
                </div>
                <div class="col-lg-2 col-md-6 text-center">
                    <div class="service-box">
                        <h2>2015</h2>
                        <div class="btn btn-circle" style="cursor:text; background-color: #f05f40;padding-top: 5px;">
		                    <i class="fa fa-user animated wow bounceIn" data-wow-delay="1.5s" style="color: white;"></i>
		                </div>
                        <h3>Brown Guy</h3>
                        <p class="text-muted">Brown guy's journey begins..</p>
                    </div>
                </div>
                </div>
            </div>
        </div>
    </section>

	<div class="contct">
     <section id="contact">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2 text-center">
                    <h2 class="section-heading">Let's Get In Touch!</h2>
                    <hr class="primary">
                    <p>Feel free to email us to provide some feedback, suggestions, report bugs or to just say hello!</p>
                </div>
                <div class="col-lg-2 col-lg-offset-1 text-center normal">
                    <i class="fa fa-phone fa-3x wow bounceIn"></i>
                    <p>201 888 3954</p>
                </div>
                <div class="col-lg-3 text-center">
                    <a class="normal" href="mailto:desai.gunjan@yahoo.com" target="_blank"><i class="fa fa-envelope-o fa-3x wow bounceIn" data-wow-delay=".1s"></i>
                    <p>desai.gunjan@yahoo.com</p></a>
                </div>
                <div class="col-lg-2 text-center">
                    <a class="normal" href="https://www.linkedin.com/in/desaigunjan" target="_blank"><i class="fa fa-linkedin-square fa-3x wow bounceIn" data-wow-delay=".1s"></i>
                    <p>linkedin</p></a>
                </div>
                <div class="col-lg-2 text-center">
                    <a class="normal" href="https://www.facebook.com/DesaiG" target="_blank"><i class="fa fa-facebook-square fa-3x wow bounceIn" data-wow-delay=".1s"></i>
                    <p>facebook</p></a>
                </div>
                <div class="col-lg-2 text-center">
                    <a class="normal" href="https://instagram.com/desaigunjan/" target="_blank">
	                    <i class="fa fa-instagram fa-3x animated wow bounceIn"></i>
                    <p>instagram</p>
                    </a>
                </div>
            </div>
        </div>
    </section>
    </div>

    <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/assets/creative/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${pageContext.request.contextPath}/assets/creative/js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="${pageContext.request.contextPath}/assets/creative/js/jquery.easing.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/creative/js/jquery.fittext.js"></script>
    <script src="${pageContext.request.contextPath}/assets/creative/js/wow.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="${pageContext.request.contextPath}/assets/creative/js/creative.js"></script>
    
    <script>
    
    $("#birthday").click(function(e) {
       
       $.ajax({
	        url: "/birthdaylike?from=me",
	        data:"",
	        cache:false,
	        success: function(data) {
	        	alert("All posts on your wall are acknowledged!");
	    	}
		});
    });
    </script>

</body>

</html>
