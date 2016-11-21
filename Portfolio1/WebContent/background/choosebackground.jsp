<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="jquery-1.11.3.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>

 <form action="result.jsp" target="_blank">
 Titel: <input type="text" name="titel" value="Titel" />
 
 <div class="pictures" id="pics1">
 <h2>Välj huvudbild</h2>
 <input type="radio" name="hb" value="images/forest.jpg" checked>
 <img  class="pic2" src="images/forest.jpg" alt="forest" />

 <input type="radio" name="hb" value="images/grass.jpg">
 <img  class="pic2" src="images/grass.jpg" alt="grass" />

 <input type="radio" name="hb" value="images/sunset.jpg">
 <img  class="pic2" src="images/sunset.jpg" alt="sunset" />

 <input type="radio" name="hb" value="images/torn.jpg">
 <img  class="pic2" src="images/torn.jpg" alt="torn" />
 <br>
 
 </div>
 
 
 <div class="pictures" id="pics2">
 <h2>Välj bakgrund</h2>

 <input type="radio" name="bg" value="images/forest.jpg" checked>
 <img  class="pic2" src="images/forest.jpg" alt="forest" id="forest"/>

 <input type="radio" name="bg" value="images/grass.jpg">
 <img  class="pic2" src="images/grass.jpg" alt="grass" id="grass"/>

 <input type="radio" name="bg" value="images/sunset.jpg">
 <img  class="pic2" src="images/sunset.jpg" alt="sunset" id="sunset"/>

 <input type="radio" name="bg" value="images/torn.jpg">
 <img  class="pic2" src="images/torn.jpg" alt="torn" id="torn"/>
 <br>
 <input type="submit" name="submit" value="Submit" />
 <a href="../index.jsp">
      <input type="button" name="home" value="Home">
      </a>
  </div>
</form>

 
 <script type="text/javascript">
 $(document).ready(function () {
	 $("#forest").on("click",function () {
		    //$("#text").text("new");
		    $("body").css({'background-image':'url(images/forest.jpg)'});
		});
	 $("#grass").on("click",function () {
		    //$("#text").text("new");
		    $("body").css({'background-image':'url(images/grass.jpg)'});
		});
	 $("#sunset").on("click",function () {
		    //$("#text").text("new");
		    $("body").css({'background-image':'url(images/sunset.jpg)'});
		});
	 $("#torn").on("click",function () {
		    //$("#text").text("new");
		    $("body").css({'background-image':'url(images/torn.jpg)'});
		});
 })
 
 </script>

</body>
</html>