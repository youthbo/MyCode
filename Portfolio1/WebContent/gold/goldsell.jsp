<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/gold1.css" />
</head>
<body>
   <div class="head">
      <h1 >Köp och sälj guld här!</h1>
      
    </div>
  
    <div>
     <p class="dittpris">Tack för ditt guld, du fick <%= request.getAttribute("amount") %> kr, känn dig blåst</p>
      <div class="back">
      <a href="index.jsp">Back</a>
      </div>
	 			
  </div>
</body>
</html>