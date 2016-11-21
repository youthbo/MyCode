<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--Author: Bo Yang-->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Portfolio</title>
<link rel="stylesheet" type="text/css" href="mystyle.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
</head>
<body>
	<div class="head">
		<h1>Portfolio f�r Bo Yang</h1>
		<div class="headlang">
			<p>
				<a href="index.jsp">Svenska</a>
			</p>
			<p>
				<a href="index-en.html">Engelska</a>
			</p>
		</div>
	</div>
	<ul id="navigator">
		<li id="home"><a href="index.jsp">Hem</a>
		<li id="menuedu">Utbildning</li>
		<li id="menuexp">Erfarenhet</li>

		<li id="menuproject">Projekt</li>
		<li id="menulang">Spr�k</li>
	</ul>
	<div class="container">
		<div class="info">
			<div class="myphoto">
				<img src="mypic.jpg" alt="my photo" height="auto" width="200px" />
			</div>
			<p>Bo Yang</p>
			<p>youthbo@hotmail.com</p>

		</div>
		<div id="detail">
			<div id="intro">
				<p>Hej!Mitt namn �r Bo Yang.Jag �r fr�n Kina och har varit
					Sverige i 8 �r.</p>
				<p>Jag gillar l�sa problem och har alltid lust att l�ra mig nya
					grejer.Nu �r jag javautvecklare-student p� Plush�gskolan i
					Stockholm.</p>
				<p>Jag gillar att l�sa, resa, tr�na och laga goda mat.</p>
			</div>
			<div id="education" class="detail">
				<h2 id="showedu">Utbildning</h2>
				<dl id="showeducation">
					<dt>2015.08-</dt>
					<dd>Javautvecklare, Teknikh�gskolan, Stockholm</dd>
					<dt>2007.08-2010.06</dt>
					<dd>Datavetenskap(120p), Uppsala Universitet, Uppsala</dd>
					<dd>Examenarbete:"JSON Streams Querying System", p� Uppsala
						Databas Laboratorium</dd>
					<dt>2000.09-2004.06</dt>
					<dd>Datavetenskap, Beijing University of Posts och
						Telecommunications, Beijing, Kina</dd>

				</dl>
			</div>
			<div id="experience" class="detail">
				<h2 id="clicktoshow">Erfarenheter</h2>
				<dl id="showexperience">
					<dt>2016.04-2016.06 Praktik, Aurora Innovation, Sverige</dt>
					<dd>Mitt jobb var att f�rs�tta utveckla f�retags webbaserat
						system. Jag fixade m�nga bug i systemet, skapade nya rapporter och
						lade till nya funktioner.</dd>
					<dt>2012.04-2013.04 Konsult, Aicent Inc, Sverige</dt>
					<dd>Ansvarig f�r Wi-Fi signaler test i Sverige och att hj�lpa
						kollegor att l�sa tekniska problem.</dd>
					<dt>2011.01-2011.07 2nd line SMS supporttekniker, Aicent lnc,
						Beijing, Kina</dt>
					<dd>Mitt jobb best�r av tv� delar. En del �r teknisk
						probleml�sning till kunderna, den annan delen �r pre-sale support
						som ing�r teknisk l�sning, tekniskt utf�rande och kontakt med
						�vriga arbetslag. Jag tar ocks� ansvar att underh�lla
						servicedokument.</dd>
					<dt>2004.07-2007.06 Assistent system ingenj�r, Data Center,
						Bank of Kina, Beijing</dt>
					<dd>I rollen ing�r att installera, konfigurera och underh�lla
						middleware MQ p� IBM mainframe. Jag tar ocks� ansvar att testera
						kommunikation med grenar, system fels�kning och probleml�sning,
						skapa och underh�lla servicedokument.</dd>

				</dl>
			</div>

			<div id="project" class="detail">
				<h2 id="showprojekt">Projekt</h2>
				<!-- <p class="projektlink">
				<a href="background/choosebackground.jsp">Choose picture and
					background</a>
			</p> -->
			    <p class="projektlink">
			        <a href="https://github.com/youthbo/Database-Project" target="_blank">
						Database project</a>
			    </p>
				<p class="projektlink">
					<a
						href="https://play.google.com/store/apps/details?id=bo.com.camera3d">Bo's
						interval camera</a>
				</p>
				<p class="projektlink">
					<a href="gold/index.jsp">Gold project</a>
				</p>
				<p class="projektlink">
					<a href="SimpleGame/index.jsp">A simple game</a>
				</p>
				<p class="projektlink">
					<a href="Book House/index1.html">Book House</a>
				</p>
			</div>
			<div id="language" class="detail">
				<h2 id="showlang">Spr�k</h2>
				<table id="showlangs">
					<tr>
						<td class="showlang">-Kinesiska</td>
						<td class="showlang">Modersm�l</td>
					</tr>
					<tr>
						<td class="showlang">-Engelska</td>
						<td class="showlang">Flytande i b�de tal och skrift</td>
					</tr>
					<tr>
						<td class="showlang">-Svenska</td>
						<td class="showlang">Mycket goda kunskaper i tal och skrift</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
	<div id="footer">
		<div id="contact-text">
			<h4>Copyright Bo Yang 2016 youthbo@hotmail.com</h4>
		</div>
	</div>
	<script>
		$(document).ready(function() {
			$("#home").addClass("active");
			$("#project").show();
			$("li").click(function(e) {
				$("li").removeClass("active");
				$(this).addClass("active");
			});
			$("#menuedu").click(function() {
				$(".detail").hide();
				$("#intro").hide();
				$("#education").show();
			});
			$("#menuexp").click(function() {
				$(".detail").hide();
				$("#intro").hide();
				$("#experience").show();
			});
			$("#menuproject").click(function() {
				$(".detail").hide();
				$("#intro").hide();
				$("#project").show();
			});
			$("#menulang").click(function() {
				$(".detail").hide();
				$("#intro").hide();
				$("#language").show();
			});

		});
	</script>
</body>
</html>