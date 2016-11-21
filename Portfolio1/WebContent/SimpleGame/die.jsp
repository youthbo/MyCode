<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="style.css" />
</head>
<%@ page session="true" %>
<body background="greengrass.jpg">
  <h1>OrcSlayer!</h1>
  <div class="diewrapper">
   <p id="died">You have died with ${player.exp}  exp!</p>
   
   <img id="myfigure1" src="tomb.png" alt="me" />
   <form method="get" target="_self" action="die"
		accept-charset="UTF-8">
	<div class="diewrapper1">	
      <input type="submit" name="restart" value="Restart">
      <a href="../index.jsp">
      <input type="button" name="home" value="Home">
      </a>
     </div>
   </form>
   </div>
</body>
</html>