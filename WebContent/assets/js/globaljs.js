		var isMobile = "N";
		var width = screen.width;
		var subject="";
		
		var isInstagram = "Y";
		var isTwitter = "Y";
		var location;
		var script;
	
		$(document).ready(function(){
			
			readyScreen();
			
			var logoLeft = ($(window).width()  -  $(".logoBar").width() ) / 2;
	    	$(".logoBar").css("left",logoLeft);
	    	
	    	if(isMobile == 'Y'){
	    		$(".textContent").css("width",$(window).width()-75);
	    		$(".postBox").css("width",$(window).width()-15);
	    		$(".menuBottom").css("width",$(window).width());
	    		$(".mobileInputField").css("width",$(window).width()-70);
	    	}
	    	
	    	
	        if(script == null){
	        	script = document.createElement('script');
		        script.type = 'text/javascript';
		        script.src = "/trendoor/assets/js/jquery.loader.js";
		        var head = document.getElementsByTagName('head')[0];
		        head.appendChild(script);
	        } 
	    	
	        //getLocation();
	    	
		});
		
		function getLocation() {
		    if (navigator.geolocation) {
		        navigator.geolocation.getCurrentPosition(showPosition);
		    } else { 
		       alert("Geolocation is not supported by this browser");
		    }
		}

		function showPosition(position) {
		    alert("Latitude: " + position.coords.latitude + "  Longitude: " + position.coords.longitude);	
		}
		
		function readyScreen(){
			
			var menuBottom = $(window).width() - 980;
			$(".menuBottom").css("width",width);
			var isActive = true;
		
			if( screen.width > 500 ) {
				isMobile = "N";
				$("#mobileMenu").hide();
				$("#desktopMenu").show();
			}else{
				isMobile = "Y";
				$("#mobileMenu").show();
				$("#desktopMenu").hide();
			}
			
		}
		
		function loadMasonary(){
			 $('#container').masonry({
				   // options
				   itemSelector : '.item',
				   //columnWidth : 300
			 });
			 $('#container').masonry('reloadItems');
		}
		
		function loadWaiter(){
			 $.loader({
			        className:"blue-with-image-2",
			        content:''
			    });
		}
		
		function getPosts() {
			
			if(screen.width > 500){
				subject = document.getElementById("subjectField").value;
			}else{
				subject = document.getElementById("subjectFieldMobile").value;
			}
			
			if(validate(subject)){
				loadWaiter();
				$.ajax({
					url: "/search?subject="+subject+"&isMobile="+isMobile+"&isInstagram="+isInstagram+"&isTwitter="+isTwitter,
			        data:"",
			        cache:false,
			        success: function(data) {
			    		$('#mainContent').html(data);
			    		
			    		var logoLeft = ($(window).width()  -  $(".logoBar").width() ) / 2;
				        $(".logoBar").css("left",logoLeft);
				        
				        if(isMobile == 'Y'){
				    		$(".postBox").css("width",$(window).width()-30);
				    	}
			    		
			    		readyScreen();
			    		loadMasonary();
				    	setSwitches();
				    	
				    	var i = 1;
				    	$('.text').each(function(){
				    		
				    		 $(this).attr('id',i);
				    		getHashTags(this.id);
				    	   i++;
				    	   
				    	});
				    	
				    	$('.linked').click(function(){
				    		getPostsFromTrend(this.innerHTML);
				    	});
				    	
				    	$('.linkedUnderlined').click(function(){
				    		openPost(this.innerHTML);
				    	});
				    	
				}
			});
			
		}}
		
		function goToHomePage() {
			loadWaiter();
			
			location = "";
			
			$.ajax({
		        url: "/trend?isInstagram="+isInstagram+"&isTwitter="+isTwitter+"&location="+location,
		        data:"",
		        cache:false,
		        success: function(data) {
		        	$('body').removeClass('wait');
		        	
		    		$('#mainContent').html(data);
		    		
		    		isInstagram = document.getElementById("isInstagramPlaceHolder").value;
		    		isTwitter = document.getElementById("isTwitterPlaceHolder").value;
		    		location = document.getElementById("locationPlaceHolder").value;
		    		readyScreen();
		    		setSwitches();
		    		
		    		var url = "/trendoor/assets/js/jquery.loader.js";
		    		$.getScript( url, function() {
		    			
		    			
		    		});
		        }
			});
			
		}


		function getPostsFromTrend(trend){
			subject = trend;
			
			loadWaiter();
			if(validate(subject)){
				$.ajax({
			
			        url: "/search?subject="+subject+"&isMobile="+isMobile+"&isInstagram="+isInstagram+"&isTwitter="+isTwitter,
			        data:"",
			        cache:false,
			        success: function(data) {
			    		$('#mainContent').html(data);
			    		
			    		var logoLeft = ($(window).width()  -  $(".logoBar").width() ) / 2;
				        $(".logoBar").css("left",logoLeft);
				        
				        if(isMobile == 'Y'){
				    		$(".postBox").css("width",$(window).width()-30);
				    	}
				        
			    		readyScreen();
			    		loadMasonary();
				    	setSwitches();
				    	
				    	var i = 1;
				    	$('.text').each(function(){
				    		
				    		 $(this).attr('id',i);
				    		getHashTags(this.id);
				    	   i++;
				    	   
				    	});
				    	
				    	$('.linked').click(function(){
				    		getPostsFromTrend(this.innerHTML);
				    	});
				    	
				    	$('.linkedUnderlined').click(function(){
				    		openPost(this.innerHTML);
				    	});
				    	
			    	}
				});
			}
		}
		
		function validate(){
			alert(2);
			if(subject.trim() == ""){
				alert("C'mon, give me something to work with!");
				return false;
			}
			
			if(subject.indexOf("#") > -1){
				subject = subject.substring(1);
			}
			
			return true;
		}
		
		function openPost(url) {
			window.open(url);
		}
		
		function checkKey(e){
			if (e.which && e.which == 13) {
				getPosts();
            }
	    }
		
		function toggleMenu(){
			$( "#menu" ).toggle();
			$( ".triangle" ).toggle();
		}
		
		
		function toggleFeed(from, value){
			
			$.ajax({
		        url: "/feedPreference?from="+from+"&value="+value+"&isMobile="+isMobile,
		        data:"",
		        cache:false,
		        success: function(data) {
		    	}
			});
		}
		
		function toggleSwitches(from){
			if(from == 'TW'){
				
				var x = document.getElementById("twitterSwitch");
				if(isTwitter == "Y"){
					x.setAttribute('src', '/assets/images/off.png');
					isTwitter = "N";
					
					/*$('.twPostBox').css("display","none");
					$('#container').masonry({
						   // options
						   itemSelector : '.item',
						   //columnWidth : 300
					 });*/
					
				}
				else if(isTwitter = "N"){
					x.setAttribute('src', '/assets/images/on.png');
					isTwitter = "Y";
					
					/*$('.twPostBox').each(function(){
						$(this).css("display","block");
			    	   
			    	});
					$('#container').masonry({
						   // options
						   itemSelector : '.item',
						   //columnWidth : 300
					 });*/
				}
				
			}
			else if(from == 'IN'){
				var x = document.getElementById("instaSwitch");
				if(isInstagram == "Y"){
					x.setAttribute('src', '/assets/images/off.png');
					isInstagram = "N";
					
				}
				else if(isInstagram = "N"){
					x.setAttribute('src', '/assets/images/on.png');
					isInstagram = "Y";
					
				}
			}
			
		}
		
		function setSwitches(){
			
				var x = document.getElementById("twitterSwitch");
				if(isTwitter == "Y"){
					x.setAttribute('src', '/assets/images/on.png');
				}
				else if(isTwitter = "N"){
					x.setAttribute('src', '/assets/images/off.png');
					
				}
				var y = document.getElementById("instaSwitch");
				if(isInstagram == "Y"){
					y.setAttribute('src', '/assets/images/on.png');
				}
				else if(isInstagram = "N"){
					y.setAttribute('src', '/assets/images/off.png');
					
				}
		}
		
		function  getHashTags(id){
			
			string = document.getElementById(id).innerHTML;
			var array = string.split(' ', 200);

			var text = "";
			for (i = 0; i < array.length; i++) {
				if( array[i].indexOf("#") > -1 && array[i].indexOf("?") == -1 && array[i].length < 50){
			        text = text + " " + "<a class='linked' onClick='getPostsFromTrend("+array[i]+")'>" + array[i] + "</a> ";
			    }
			    else if(array[i].indexOf("http://") > -1){
			    	if(i != 0){
			    		if(i == array.length-1)
			    			text = text + " " + "<a class='linkedUnderlined' onClick='openPost("+array[i]+")'>" + array[i] + "</a> ";
			    		else
			    			text = text + " " + "<a class='linkedUnderlined' onClick='openPost("+array[i]+")'>" + array[i] + "</a>";
			    	}
			    	else if(i == 0){
			    		text = text + " " + "<a class='linkedUnderlined' onClick='openPost("+array[i]+")'>" + array[i] + "</a>";
			    	}
			    }
			    else if(array[i].indexOf("@") > -1 && array[i-1] == 'RT' ){
			    	text = text + "" + "<a class='boldFont'>" + array[i-1] + " " + array[i] + "</a> ";
			    }
			    else if(array[i] == 'RT'){
			    	//do nothing, will take care in next loop.
			    }
			    else{//if(array[i].length < 50)
			     text = text +" " + array[i]   
			    }
			    
			}
			document.getElementById(id).innerHTML = text;

		}