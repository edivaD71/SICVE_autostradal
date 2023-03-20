<head>
<link rel="stylesheet" href="css/fromAuto.css">
</head>
<%@include file="normalUserPage.jsp"%>
<div class="cont">
	<h1>L'avviso quando attraversi una tratta controllata da tutor è
		<%
		if (request.getSession().getAttribute("sms").equals("N")) {
		%> disattivato<%
		} else {
		%> attivo<%
		}
		%><br>
		<a href="avvisoServlet">
		<%
		if (request.getSession().getAttribute("sms").equals("Y")) {
		%>Disattiva <%
		} else {
		%>Attiva <%
		}
		%>
		 avviso</a>
	</h1>
</div>