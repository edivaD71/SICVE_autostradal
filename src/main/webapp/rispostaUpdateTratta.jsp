<%@include  file="inizioAdmin.jsp" %>
    <div class="cont">
    	<ul>
		    <li>
		    	<h1><%= request.getAttribute("t")%></h1>
		    </li>
		    <li>
		    	<p align="center"><a href="viewTratteServlet">Torna alla lista delle tratte</a></p>
		    </li>
	    </ul>
    </div>
</body>
</html>