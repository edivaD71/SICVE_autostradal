<%@include file="inizioAdmin.jsp"%>
<div class="cont">
	<h2 align="center"><%=request.getAttribute("s")%>
		<%=request.getAttribute("c")%><br>
		<a href="simulazioneServlet">Avvia una nuova simulazione</a>
	</h2>
</div>
</body>
</html>