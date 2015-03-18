		var isMobile = "N";
		var width = screen.width;
		var subject="";
		
		var isInstagram = "Y";
		var isTwitter = "Y";
	
		$(document).ready(function(){
			
			readyScreen();
			
			var logoLeft = ($(window).width()  -  $(".logoBar").width() ) / 2;
	    	$(".logoBar").css("left",logoLeft);
	    	
	    	if(isMobile == 'Y'){
	    		$(".postBox").css("width",$(window).width()-15);
	    	}
	    	
	    	
		});
		
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
		
		function getPosts() {
			$('body').addClass('wait');
			if(screen.width > 500){
				subject = document.getElementById("subjectField").value;
			}else{
				subject = document.getElementById("subjectFieldMobile").value;
			}
			
			if(validate(subject)){
				$.ajax({
					url: "/trendoor/search?subject="+subject+"&isMobile="+isMobile+"&isInstagram="+isInstagram+"&isTwitter="+isTwitter,
			        data:"",
			        cache:false,
			        success: function(data) {
			        	$('body').removeClass('wait');
			    		$('#mainContent').html(data);
			    		
			    		var logoLeft = ($(window).width()  -  $(".logoBar").width() ) / 2;
				        $(".logoBar").css("left",logoLeft);
				        
				        if(isMobile == 'Y'){
				    		$(".postBox").css("width",$(window).width()-15);
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
			$('body').addClass('wait');
			
			$.ajax({
		        url: "/trendoor/welcome?isInstagram="+isInstagram+"&isTwitter="+isTwitter,
		        data:"",
		        cache:false,
		        success: function(data) {
		        	$('body').removeClass('wait');
		        	
		    		$('#mainContent').html(data);
		    		
		    		isInstagram = document.getElementById("isInstagramPlaceHolder").value;
		    		isTwitter = document.getElementById("isTwitterPlaceHolder").value;
		    		
		    		readyScreen();
		    		setSwitches();
		        }
			});
			
		}


		function getPostsFromTrend(trend){
			subject = trend;
			$('body').addClass('wait');
			if(validate(subject)){
				$.ajax({
			
			        url: "/trendoor/search?subject="+subject+"&isMobile="+isMobile+"&isInstagram="+isInstagram+"&isTwitter="+isTwitter,
			        data:"",
			        cache:false,
			        success: function(data) {
			        	$('body').removeClass('wait');
			    		$('#mainContent').html(data);
			    		
			    		var logoLeft = ($(window).width()  -  $(".logoBar").width() ) / 2;
				        $(".logoBar").css("left",logoLeft);
				        
				        if(isMobile == 'Y'){
				    		$(".postBox").css("width",$(window).width()-15);
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
		        url: "/trendoor/feedPreference?from="+from+"&value="+value+"&isMobile="+isMobile,
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
					x.setAttribute('src', '/trendoor/assets/images/off.png');
					isTwitter = "N";
					
					/*$('.twPostBox').css("display","none");
					$('#container').masonry({
						   // options
						   itemSelector : '.item',
						   //columnWidth : 300
					 });*/
					
				}
				else if(isTwitter = "N"){
					x.setAttribute('src', '/trendoor/assets/images/on.png');
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
					x.setAttribute('src', '/trendoor/assets/images/off.png');
					isInstagram = "N";
					
				}
				else if(isInstagram = "N"){
					x.setAttribute('src', '/trendoor/assets/images/on.png');
					isInstagram = "Y";
					
				}
			}
			
		}
		
		function setSwitches(){
			
				var x = document.getElementById("twitterSwitch");
				if(isTwitter == "Y"){
					x.setAttribute('src', '/trendoor/assets/images/on.png');
				}
				else if(isTwitter = "N"){
					x.setAttribute('src', '/trendoor/assets/images/off.png');
					
				}
				var y = document.getElementById("instaSwitch");
				if(isInstagram == "Y"){
					y.setAttribute('src', '/trendoor/assets/images/on.png');
				}
				else if(isInstagram = "N"){
					y.setAttribute('src', '/trendoor/assets/images/off.png');
					
				}
		}
		
		function  getHashTags(id){
			
			string = document.getElementById(id).innerHTML;
			var array = string.split(' ', 50);

			var text = "";
			for (i = 0; i < array.length; i++) {
			    if( array[i].indexOf("#") > -1 && array[i].indexOf("?") == -1){
			        text = text + " " + "<a class='linked' onClick='getPostsFromTrend("+array[i]+")'>" + array[i] + "</a> ";
			    }
			    else if(array[i].indexOf("http://") > -1){
			    	text = text + " " + "<a class='linkedUnderlined' onClick='openPost("+array[i]+")'>" + array[i] + "</a> ";
			    }
			    else if(array[i].indexOf("@") > -1 && array[i-1] == 'RT' ){
			    	text = text + "" + "<a class='boldFont'>" + array[i-1] + " " + array[i] + "</a> ";
			    }
			    else if(array[i] == 'RT'){
			    	//do nothing, will take care in next loop.
			    }
			    else{
			     text = text +" " + array[i]   
			    }
			    
			}
			document.getElementById(id).innerHTML = text;

		}