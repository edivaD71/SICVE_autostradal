
<head>
    <link rel="stylesheet" href="css/fromAuto.css">
</head>
<%@include  file="normalUserPage.jsp" %>
<h1>Inserisci la tua auto</h1>
<form  action="autoServlet"  method="POST"> 
  <input name="targa" type="text" class="feedback-input" placeholder="Inserisci la targa" />   
  <input name="marca" type="text" class="feedback-input" placeholder="Inserisci la marca" />
  <input name="modello" type="text" class="feedback-input" placeholder="Inserisci il modello" />
  <input name="anno" type="text" class="feedback-input" placeholder="Inserisci l' anno" />
  <input type="submit" value="SUBMIT"/>
</form>