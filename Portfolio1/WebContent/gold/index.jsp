<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>K�p och s�lj guld h�r</title>
<link rel="stylesheet" type="text/css" href="css/gold1.css" />
</head>
<body>
	<div class="head">
		<h1>K�p och s�lj guld h�r!</h1>
	</div>
    <a href="../index.jsp">Home</a>
	<div class="bscontainer">

		<form method="get" target="_self" action="myservlet"
			accept-charset="UTF-8">

			<div id="bsdiv">
				<p>
					K�p(<span class="pris">pris:301.10kr/g</span>):
				</p>
				<input type="text" name="bamount" value="0">g <input
					type="submit" name="trans" value="Buy"><br>

				<p>
					S�lj(<span class="pris">pris:210.77kr/g</span>):
				</p>
				<input type="text" name="samount" value="0">g <input
					type="submit" name="trans" value="Sell">
			</div>

		</form>
		<div class="goldpicdiv">
			<img id="gold" src="images/gold.jpg" alt="gold" />
		</div>
		
	</div>
	
</body>
</html>