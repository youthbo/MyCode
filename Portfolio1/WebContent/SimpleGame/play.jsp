<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="style.css" />
</head>
<%@ page import="java.util.Random"%>
<%@ page session="true"%>



<body background="greengrass.jpg">


	<h1>OrcSlayer!</h1>
	<div class="wrapper">
		<form method="get" target="_self" action="servlet"
			accept-charset="UTF-8">

			<div class="me">
				<h2>Player</h2>
				<img id="myfigure" src="figure1.jpg" alt="me" />
				<table id="mytable">
					<tr>
						<td><img alt="hp" src="blood.jpg" class="mypic">${player.hp}hp</td>
					
						<td><img alt="exp" src="exp.jpg" class="mypic">${player.exp}exp</td>
					
						<td><img alt="damage" src="sword.png" class="mypic">${player.damage}dam</td>
					</tr>
				</table>
			</div>

			<div class="enemydiv">
				<h2>Click a monster to do an attack:</h2>
				<table>
					<tr>
						<td class="sub"><input type="submit" name="submit"
							value="Ant" class="enemy"></td>
						<td><img alt="hp" src="blood.jpg" class="monsterpic">2hp</td>
						<td><img alt="exp" src="exp.jpg" class="monsterpic">1exp</td>
						<td><img alt="damage" src="sword.png" class="monsterpic">2dam</td>
						<td class="killed">${antout}</td>
					</tr>

					<tr>
						<td class="sub"><input type="submit" name="submit"
							value="Goblin" class="enemy"></td>
						<td><img alt="hp" src="blood.jpg" class="monsterpic">6hp</td>
						<td><img alt="exp" src="exp.jpg" class="monsterpic">6exp</td>
						<td><img alt="damage" src="sword.png" class="monsterpic">6dam</td>
						<td class="killed">${goout}</td>
					</tr>

					<tr>
						<td class="sub"><input type="submit" name="submit"
							value="Troll" class="enemy"></td>
						<td><img alt="hp" src="blood.jpg" class="monsterpic">${troll.hp}hp</td>
						<td><img alt="exp" src="exp.jpg" class="monsterpic">50exp</td>
						<td><img alt="damage" src="sword.png" class="monsterpic">1-25dam</td>
						<td class="killed">${trollout}</td>
					</tr>
				</table>

			</div>

		</form>
		<div class="restart">
			<form method="get" target="_self" action="die" accept-charset="UTF-8">
				<input type="submit" name="restart" value="Restart"> <a
					href="../index.jsp"> <input type="button" name="home"
					value="Home">
				</a>
			</form>

		</div>
		<p id="output">${output}</p>
	</div>
</body>
</html>