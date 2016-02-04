var isTwitter = true;
var isInstagram = true;
var isVine = true;
var isText = true;
var isImage = true;
var isVideo = true;

var currentSubject = "";

(function ($) {
	if($("#subjectField").html() != "" && $("#subjectField").html() != "null"){
		getPosts($("#subjectField").html());
		window.history.replaceState("object or string", "Title", "");
	}else{
	}
  
})(jQuery);

(function ($) {
	
	$('html, body').animate({ scrollTop: $('#page-top').offset().top }, 'slow');
	  $.each(['show', 'hide'], function (i, ev) {
	    var el = $.fn[ev];
	    $.fn[ev] = function () {
	      this.trigger(ev);
	      return el.apply(this, arguments);
	    };
	  });
	  
	})(jQuery);

$(function() {
    $('a.page-scroll').bind('click', function(event) {
        var $anchor = $(this);
        $('html, body').stop().animate({
            scrollTop: $($anchor.attr('href')).offset().top
        }, 800, 'easeInOutExpo');
        event.preventDefault();
    });
});

var idCounter = 1;
// Highlight the top nav as scrolling occurs
$('body').scrollspy({
    target: '.navbar-fixed-top'
})

// Closes the Responsive Menu on Menu Item Click
$('.navbar-collapse ul li a').click(function() {
    $('.navbar-toggle:visible').click();
});

$('.homePage').click(function() {
	$('#post').css("display","none");
	$('#about').css("display","");
	$('#contact').css("display","");
});

var $viewportMeta = $('meta[name="viewport"]');
$('input, select, textarea').bind('focus blur', function(event) {
$viewportMeta.attr('content', 'width=device-width,initial-scale=1,maximum-scale=' +        (event.type == 'blur' ? 10 : 1));
});

function loadWaiter(){
	$.loader({
	        className:"blue-with-image-2",
	        content:''
	    });
}

function killWaiter(){
	$.loader('close');
}

function searchClicked(e){
	if (e.which && e.which == 13) {
		subject = document.getElementById("searchField").value;
		getPosts(subject);
    }
}

$('#horizontalLine').on('show', function(){
	$grid.masonry();
});

$('.search').click(function() {
	subject = document.getElementById("searchField").value;
	getPosts(subject);
});

$('.trend').click(function(event) {
	//var target = event.target;
	//var subject = $(target).parent().find("b").text();
	
	//getPosts(subject);
});

function getPosts(subject) {
	loadWaiter();
	if(validate(subject)){
		
		if(subject.indexOf("#") > -1){
			subject = subject.substring(1);
		}
		
		$.ajax({
			url: "/rest/livefeed/"+subject+"/"+isTwitter+"/"+isInstagram+"/"+isVine,
			data: "", 
	        cache:false,
	        success: function(data) {
	        	
	        	currentSubject = subject;
	        	$('.item').remove();
	        	
	        	$('#post').css("display","");
	        	$('#horizontalLine').hide();
	        	
	        	var boxList = '';
	        	
	        	for(i in data.postList){
	        		var post = data.postList[i];
	        		
	        		var classList = "";
	        		var socialIcon;
	        		
	        		if(post["from"] == "TW"){
	        			socialIcon = '<i class="fa fa-2x fa-twitter" ></i>';
	        			classList = " tw";
	        			if(!isTwitter){
	        				classList = classList + " hidePost";
	        			}
	        		}else if(post["from"] == "IG"){
	        			socialIcon = '<i class="fa fa-2x fa-instagram"></i>';
	        			classList = " ig";
	        			if(!isInstagram){
	        				classList = classList + " hidePost";
	        			}
	        		}else if(post["from"] == "VINE"){
	        			socialIcon = '<i class="fa fa-2x fa-vine"></i>';
	        			classList = " vine";
	        			if(!isVine){
	        				classList = classList + " hidePost";
	        			}
	        		}

	        		var img = '';
	        		if(post["type"] == "image"){
	        			img = '<img class="roundBorder" height="350px;" width="100%" src="'+post["mediaLink"]+'">';
	        			classList = classList + " image";
	        			if(!isImage){
	        				classList = classList + " hidePost";
	        			}
	        		}
	        		var video = '';
	        		if(post["type"] == "video"){
	        			video = '<div width="100%" class="col-sm-12 roundBorder"><video width="100%" height="340px" controls muted><source src="'+post["mediaLink"]+'" type="video/mp4"></source></video></div>';
	        			//video = '<div class="col-sm-12"><video width="100%" muted controls preload="auto"><source src="'+post["videoLink"]+'" type="video/mp4"></source></video></div>';
	        			classList = classList + " video";
	        			if(!isVideo){
	        				classList = classList + " hidePost";
	        			}
	        		}
	        		var caption = '';
	        		if(post["caption"] != null && post["caption"].trim() != ""){
	        			caption = '<p class="roundBorder text-left text padding10" style="background-color:#ffffff; padding-bottom:5px;">'+post["caption"]+'</p>';
	        		}
	        		var message = '';
	        		if(post["message"] != null && post["message"].trim() != ""){
	        			message = '<p class="roundBorder text-left text padding10" style="background-color:#ffffff; padding-bottom:5px;">'+post["message"]+'</p>';
	        		}
	        		var userInfo = '<div class="col-xs-12 text-left">'+post["postUser"].name+'</div><div class="col-xs-12">'+post["postUser"].screenName+'</div>';
	        		
	        		var time = '<span class="col-xs-12 text-right" style="padding-right:3px;color:gray;font-weight:bold;"> - '+post.time+'</span>';
	        		
	        		var postBox = '<div class="col-lg-4 col-md-6 col-sm-12 col-xs-12 roundBorderAll item nopadding">'+
			    	'<div class="panel nopadding" style="border: 0px solid white;">'+
		    	    '<div class="panel-body nopadding">'+
			    		'<div class="" >'+
			    			img+video+caption+message+time+
					    '</div>'+
					    '<div class="roundBorderBottom nomargin nopadding col-xs-12" style="margin:0px;padding:0px;border:1px solid #888888;height: 40px;background: #888888;">'+
					    	'<div class="col-xs-2 team-member" style="margin:0px;padding:0px;margin-top:-10px;">'+
					    		'<img src="'+post["postUser"].profilePicture+'" height="60px" width="60px" class="img-circle" alt="" style="z-index:100;">'+
					     	'</div>'+
					     	'<span class="col-xs-8 text-left" style="font-weight:bold;color:white;padding:0px;">'+userInfo+'</span>'+
					     	'<div class="col-xs-2 text-right" style="padding:0px;margin:0px;padding:7px;color:white;">'+socialIcon+'</div>'+
					    '</div>'+
			    	'</div>'+
			     '</div>'+
			  '</div>';
	        		/*var postBox = '<div class="col-lg-4 col-md-6 col-sm-12 col-xs-12 roundBorderAll item nopadding">'+
							    	'<div class="panel nopadding" style="border: 0px solid white;">'+
							    	    '<div class="panel-body nopadding">'+
								    		'<div class="" >'+
										    	img+video+caption+message+
										    '</div>'+
								    	'</div>'+
								    	'<div class="panel-footer" >'+
											  '<div class="team-member margntopminus75">'+
										    	'<img src="'+post["postUser"].profilePicture+'" height="60px" width="60px" class="img-circle boxShadowTop" alt="" style="z-index:100;">'+
										      '</div>'+userInfo+
										      '<div style="padding:0px;margin:0px;">'+socialIcon+'</div>'+
					    			    '</div>'+
								     '</div>'+
								   '</div>';*/
	        		if(postBox != undefined){
	        			//$('#postBox').append(postBox);
	        			boxList = boxList + postBox;
	        		}
	        	}
			    
	        	$('html, body').animate({ scrollTop: $('#post').offset().top }, 'slow');
	            
	        	loadMasonary($(boxList));
	        	
	        	$('#about').css("display","none");
	        	$('#contact').css("display","none");
	    		
	    		$('#subjectField').html("#"+data.subject);
	    		
	    		idCounter = 1;
		    	$('.text').each(function(){
		    		
		    		 $(this).attr('id',idCounter);
		    		getHashTags(this.id);
		    		idCounter++;
		    	   
		    	});
		    	
		    	$('.linked').click(function(){
		    		getPosts(this.innerHTML);
		    	});
		    	
		    	$('.linkedUnderlined').click(function(){
		    		openPost(this.innerHTML);
		    	});
		    	
		    	$('#horizontalLine').show();
		    	
		    	killWaiter();
	        }
		});
	}
	
}

function validate(subject){
	
	if(subject.trim() == ""){
		alert("C'mon, give us something to work with!");
		return false;
	}
	
	return true;
}

function  getHashTags(id){
	
	string = document.getElementById(id).innerHTML;
	string = string.replace(/#/gi, " #");
	var array = string.split(' ', 200);

	var text = "";
	for (i = 0; i < array.length; i++) {
		if( array[i].indexOf("#") > -1 && array[i].indexOf("?") == -1 && array[i].length < 50){
			
	        text = text + " " + "<a class='linked boldFont' onClick='getPosts("+array[i]+")'>" + array[i] + "</a> ";
	    }
	    else if((array[i].indexOf("http://") > -1 || array[i].indexOf("https://") > -1) && !array[i].indexOf("..") > -1){
	    	text = text + " " + "<br/><a class='linkedUnderlined' onClick='openPost("+array[i]+")'>" + array[i] + "</a> ";
	    }
	    else if(array[i].indexOf("@") == 0 && array[i-1] != 'RT' ){
	    	text = text + "" + "<span class='boldFont username'> " + array[i] + " </span> ";
	    }
	    else if(array[i].indexOf("@") > -1 && array[i-1] == 'RT' ){
	    	text = text + "" + "<p class='boldFont'>" + array[i-1] + " " + array[i] + "</p> ";
	    }
	    else if(array[i] == 'RT'){
	    	//do nothing, will take care in next loop.
	    }
	    else if((array[i].indexOf("http://") > -1 || array[i].indexOf("https://") > -1) && array[i].indexOf("..") > -1){
	    	//do nothing. We dont need http://....
	    }
	    else{//if(array[i].length < 50)
	     text = text +" " + array[i]   
	    }
	    
	}
	document.getElementById(id).innerHTML = text;

}

function openPost(url) {
	window.open(url);
}

function loadMasonary(items){
	$grid = $('.grid').masonry({
  		 itemSelector : '.item'
  	 	});
   	
   $grid.append(items);
   $('.grid').masonry('reloadItems');
   
   /*$('.grid').masonry({
		 itemSelector : '.item'
	 });
	 $('.grid').masonry('reloadItems');*/
}

function settingChanged(element){
	
	var isData = $("#post").is(":visible");
	
	var isOn;
	var changed =  false;
	if($("#"+element).hasClass("on")){
		isOn = false;
	}else{
		isOn = true;
	}
	
	if(element == "isTwitter" && (isOn || (!isOn && (isInstagram || isVine)))){
		isTwitter = isOn;
		changed =  true;
	}else if(element == "isInstagram" && (isOn || (!isOn && (isTwitter || isVine)))){
		isInstagram = isOn;
		changed =  true;
	}else if(element == "isVine" && (isOn || (!isOn && (isInstagram || isTwitter)))){
		isVine = isOn;
		changed =  true;
	}else if(element == "isText" && (isOn || (!isOn && (isVideo || isImage)))){
		isText = isOn;
		changed =  true;
		
	}else if(element == "isImage" && (isOn || (!isOn && (isVideo || isText)))){
		isImage = isOn;
		changed =  true;
	}else if(element == "isVideo" && (isOn || (!isOn && (isText || isImage)))){
		isVideo = isOn;
		changed =  true;
	}
	
	if(isData){
		
		getPosts(currentSubject);
		$("#sidebar-wrapper").toggleClass("active");
        $("#menu-toggle").toggleClass("active");
        $("#sButtom").removeClass("fa-times");
		$("#sButtom").addClass("fa-cogs");
	}
	if(isOn){
		$("#"+element).removeClass("off");
		$("#"+element).addClass("on");
	}else{
		$("#"+element).removeClass("on");
		$("#"+element).addClass("off");
	}
	
	
	
}