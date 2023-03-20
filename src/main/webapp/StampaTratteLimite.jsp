<%@include  file="inizioAdmin.jsp" %>
    <div class="cont">
    
    	<%@page import="java.util.ArrayList"%>      <%--Importing all the dependent classes--%>
		<%@page import="com.dao.Tratta"%>
		<%@page import="java.util.Iterator"%> 
		
		<% ArrayList<Tratta> tList = (ArrayList) request.getAttribute("ListTr");
		// Iterating through subjectList
		
		if(request.getAttribute("ListTr") != null)  // Null check for the object
		{%>
			<table>
			<tr ><th colspan="5" height=50px><h1>Tutte le tratte con il limite massimo di <%= request.getAttribute("limite")%> KM/H</h1></th></tr>	
			
			<tr ><th > Nome autostrada</th><th width=300px>Inizio</th><th width=300px>Fine</th><th width=100px>Lunghezza</th><th width=100px>Limite</th></tr>
			<%
			Iterator<Tratta> iterator = tList.iterator();  // Iterator interface
			int i=0;
			while(iterator.hasNext())  // iterate through all the data until the last record
			{
				i=1;
				Tratta infoT = iterator.next(); //assign individual employee record to the employee class object
			%>
			<tr height=50px align="center">
				<td><%=infoT.getTrattaNome()%></td>
				<td><%=infoT.getTrattaInizio()%></td>
				<td><%=infoT.getTrattaFine()%></td>
				<td><%=infoT.getTrattaLun()%></td>
				<td><%=infoT.getTrattaLim()%></td>
			</tr>
			
			<%
			}
			if(i==0){
				%>
				<tr height=50px align="center">
				<td colspan="5">Non sono state trovate tratte che hanno un tale limite</td>
				</tr>
				<%
			}%>
			</table><%
		}
		else{%>
			Non ci sono tratte
		<%
		}
		%>
    </div>
</body>
</html>