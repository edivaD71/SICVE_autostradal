<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
    <link rel="stylesheet" href="style.css">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
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
            <h3>Area admin</h3>
        </div>
        <!--Voci di menu-->
        <ul>
            <li>
                <a href="homeAdmin.jsp" class="active">
                    <span class="icon"><i class="fas fa-home"></i></span>
                    <span class= "item">Home</span>
                </a>
            </li>
            <li>
            	<a href="viewTratteServlet">
                    <span class="item">Lista tratte</span>
                </a>
                
            </li>
            <li>
                <a href="newTratta.jsp">
                    <span class="item">Inserisci tratta</span>
                </a>
            </li>
            <li>
                <a href="listaTratteServlet">
                    <span class="item">Mostra statistiche</span>
                </a>
            </li>
            <li>
                <a href="simulazioneAuto.jsp">
                    <span class="item">Simulazione</span>
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