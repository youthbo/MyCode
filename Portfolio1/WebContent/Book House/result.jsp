<!-- Author:Bo Yang -->
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="css/style.css">
<link href='https://fonts.googleapis.com/css?family=Quicksand' rel='stylesheet' type='text/css'>
<title>Booking</title>
  <title>Confirm Booking</title>
 
</head>
<body id="housebookbody">
 <div id="bookinfo">
 <h1 id="bookinfotitle">Your Booking Information</h1>
 <img src="${house.url}" alt="${bi.itemnum}" />
 <p>Your house is: ${bi.itemnum}</p>
 <p>Your name is: ${bi.name}</p>
 <p>Your email is: ${bi.email}</p>
 <p>Check-in date is: ${bi.startDate}</p>
 <p>Check-out date is: ${bi.endDate}</p>
 <p>Message: ${bi.message} </p>
 <form method="get" target="_self" action="Servlet"
		accept-charset="UTF-8">
 <input type="submit" name="submit" value="Confirm">
 </form>
 </div>
 <div class="centerhome">
   <a href="../index.jsp" >Home</a>
</div>
</body>
</html>