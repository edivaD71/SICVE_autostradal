<%@include  file="inizioAdmin.jsp" %>
    <div class="cont">
    
    	<%@page import="java.util.ArrayList"%>      <%--Importing all the dependent classes--%>
		<%@page import="com.dao.Tratta"%>
		<%@page import="java.util.Iterator"%> 
		
		<% ArrayList<Tratta> trList = (ArrayList) request.getAttribute("ListT");%>
		
		<%if(request.getAttribute("ListT") != null)  // Null check for the object
		{
			Iterator<Tratta> iterator = trList.iterator();  // Iterator interface
			
			while(iterator.hasNext())  // iterate through all the data until the last record
			{
				Tratta infoTr = iterator.next(); //assign individual employee record to the employee class object
				%>
		    <form method="post" action="updateTrattaServlet">
		    	<input type="hidden" name="cod_t" value="<%=infoTr.getTrattaId()%>"/>
		        <table >
		            <tr>
		                <td height="50">Nome tratta</td> <td> <input type="text" name="nome_a" value="<%=infoTr.getTrattaNome()%>"/></td>
		            </tr>
		            <tr>
		                <td height="50">Inizio tratta</td> <td><input type="text" name="inizio_t" value="<%=infoTr.getTrattaInizio()%>"/></td>
		            </tr>
		            <tr>
		                <td height="50">Fine tratta</td> <td> <input type="text" name="fine_t" value="<%=infoTr.getTrattaFine()%>"/></td>
		            </tr>
		            <tr>
		                <td height="50" >Lunghezza (km)</td> <td> <input type="number" step="any" min="0" name="lunghezza" value="<%=infoTr.getTrattaLun()%>" /></td>
		            </tr>
		            <tr>
		                <td height="50">Limite (km/h)</td> <td> <input type="number" step="any" min="0" name="limite" value="<%=infoTr.getTrattaLim()%>" /></td>
		            </tr>
		            <tr>
		                <td height="50">Controllato da tutor </td>
		                <td><input type="radio" name="con" value=0 <% if(infoTr.getTrattaCon()==0){%>checked<%}%> >No<br>
		                <input type="radio" name="con" value=1 <% if(infoTr.getTrattaCon()==1){%>checked<%}%> >Si</td>
		            </tr>
		            <tr>
		                <td colspan="2" height="50" align="center"><input class="button-64" type="submit" value="Modifica tratta" /><input class="button-64" type="reset" value="Resetta" /></td>
		            </tr>
		        </table>
		    </form>
		    <% }
			}
			else{
				%>Errore nel passaggio del codice
				<%}%>
</div>
</body>
</html>