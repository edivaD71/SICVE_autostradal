<%@include file="inizioAdmin.jsp"%>
<div class="cont">

	<%@page import="java.util.ArrayList"%>
	<%@page import="com.dao.Tratta"%>
	<%@page import="java.util.Iterator"%>

	<%ArrayList<Tratta> tList = (ArrayList) request.getAttribute("ListTr");%>
	<table>
		<tr>
			<th>Nome autostrada</th>
			<th width=300px>Inizio</th>
			<th width=300px>Fine</th>
			<th width=100px>Lunghezza</th>
			<th width=100px>Limite</th>
			<th width=100px>Tutor</th>
			<th width=100px>-</th>
			<th width=100px>-</th>
		</tr>
		<%
		// Iterating through subjectList

		if (request.getAttribute("ListTr") != null) // Null check for the object
		{
			Iterator<Tratta> iterator = tList.iterator(); // Iterator interface

			while (iterator.hasNext()) // iterate through all the data until the last record
			{
				Tratta infoT = iterator.next(); //assign individual employee record to the employee class object
		%>
		<tr height=50px align="center">
			<td><%=infoT.getTrattaNome()%></td>
			<td><%=infoT.getTrattaInizio()%></td>
			<td><%=infoT.getTrattaFine()%></td>
			<td><%=infoT.getTrattaLun()%></td>
			<td><%=infoT.getTrattaLim()%></td>
			<td>
				<%
				if (infoT.getTrattaCon() == 1) {
				%>Si<%
				} else {
				%>No<%
				}
				%>
			</td>
			<td><a href="preUpdateTratta?c=<%=infoT.getTrattaId()%>">Modifica</a></td>
			<td><a href="deleteTratta?c=<%=infoT.getTrattaId()%>">Elimina</a></td>
		</tr>
		<%
		}
		} else {
		%>
		<tr>
			<td colspan="5">Non ci sono tratte</td>
		</tr>
		<%
		}
		%>
	</table>
</div>
</body>
</html>