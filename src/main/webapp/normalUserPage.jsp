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

</head>
<body data-rsssl=1>


<div class="wrapper">
    <!--Menu principale e pulsante Menu-->
    <div class="sidebar">
        <div class="profile">
            <!--Titolo e descrizione profilo-->
            <h3>Area user</h3>
        </div>
        <!--Voci di menu-->
        <ul>
            <li>
                <a href="homeUser.jsp" class="active">
                    <span class="icon"><i class="fas fa-home"></i></span>
                    <span class= "item">Home</span>
                </a>
            </li>
            <li>
            	<a href="autoForm.jsp">
            		<span class="icon"><i class="uil uil-car"></i></span>
                    <span class="item">Inserisci autoveicolo</span>
                </a>
                
            </li>
            <li>
                <a href="garageView">
                    <span class="item">Garage</span>
                </a>
            </li>
            <li>
                <a href="richiestaAvvisoServlet">
                    <span class="item">Richesta avviso tutor</span>
                </a>
            </li>
            <li>
                <a href="LogoutServlet">
                    <span class="item">Logout</span>
                </a>
            </li>
        </ul>
    </div>

</div>
