<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="style.css" />
</head>
<% 
  String bg=request.getParameter("bg");
  String hb=request.getParameter("hb");
  String titel=request.getParameter("titel");
%>
<body background=<%= bg %> id="resultbody">
   <h1><%= titel %></h1><br>
   <img  id="huvudbild" src=<%= hb %> alt="forest" />
</body>
</html>