<!DOCTYPE html>


<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap 101 Template</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  </head>
  <body>
    <h1><span class="glyphicon glyphicon-plus"></span>Hello, world!</h1>
	<button type="button" class="btn btn-default" aria-label="Left Align">
  		<span class="glyphicon glyphicon-align-left" aria-hidden="true"></span>
	</button>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
  	<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
	
	<div id="draggable" class="ui-widget-content">
  		<p>Drag me to my target</p>
	</div>
 
	<div id="droppable" class="ui-widget-header">
	  <p>Drop here</p>
	</div>
 </body>
  
  <script>
  $(function() {
    $( "#draggable" ).draggable();
    $( "#droppable" ).droppable({
      drop: function( event, ui ) {
        $( this )
          .addClass( "ui-state-highlight" )
          .find( "p" )
            .html( "Dropped!" );
      },
      out: function( event, ui ) {
    	  $( this )
          .find( "p" )
            .html( "Dragged Out!" );
      }
    });
  });
  </script>
  
  <style>
  #draggable { width: 100px; height: 100px; padding: 0.5em; float: left; margin: 10px 10px 10px 0;  background-color: yellow;}
  #droppable { width: 150px; height: 150px; padding: 0.5em; float: left; margin: 10px; }
  </style>
</html>