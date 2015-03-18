<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Hello jQuery</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    </head>

<script type="text/javascript">

</script>
<style>
.wrapper {
    outline: 2px dotted blue;
    width: 500px;
    height: 400px;
    padding-top: 200px;
}
.parent {
    position: relative;
    background-color: green;
}
.child {
    position: absolute;
    bottom: 100%;
    left: 100%;
    margin: 0 0 20px 20px;
    background-color: yellow;
}


</style>
	<body>
     <div class="wrapper">
    <div class="parent">Lorem ipsum dolor sit amet...
        <div class="child">Aliquam convallis rhoncus lacus...</div>
    </div>
</div>
    </body>
</html>