<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
    <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
    <link rel="stylesheet" href="css/sidebar.css">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Home</title>
    <style>
	    tr:nth-child(even) {
	  		background-color: #D6EEEE;
		}
    </style>
        <link rel="stylesheet" href="css/homeUserStyle.css">

</head>

<body>

    <!--Navigation Bar-->
    <nav>
	    <ul class="menu">
	        <li class="item"><h2><a href="homeUser.jsp">Home</a></h2></li>
	        <li class="item"><h2><a href="autoForm.jsp">Inserisci autoveicolo</a></h2></li>
	        <li class="item"><h2><a href="garageView">Garage</a></h2></li>
	        <li class="item"><h2><a href="richiestaAvvisoServlet">Richiesta avviso tutor</a></h2></li>
	        <li class="item"><h2><a href="LogoutServlet">Logout</a></h2></li>
	        <li class="toggle"><span class="bars"></span></li>
	    </ul>
	</nav>
	
    <div class="img">
	</div>
	<div class="contenitore">
		<ul>
			<li><h1>SICVE Autostradale</h1></li>
			<li><h2>La sicurezza non è un limite<br> 
					Viaggia in modo prudente, sii responzabile</h2></li>
		</ul>
	</div>
</body>
</html>