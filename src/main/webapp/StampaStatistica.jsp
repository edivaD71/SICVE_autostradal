<%@include  file="inizioAdmin.jsp" %>
    <div class="cont">
    
    	<%@page import="java.util.ArrayList"%>      
		<%@page import="com.dao.avgVelocita"%>
		<%@page import="java.util.Iterator"%> 
		
		<% ArrayList<avgVelocita> tList = (ArrayList) request.getAttribute("listAVG"); %>
		
		<table>

		<tr ><th width=300px> Nome autostrada</th><th width=300px>Velocità media</th></tr>
		<%
		// Iterating through subjectList
		
		if(request.getAttribute("listAVG") != null)  // Null check for the object
		{
			Iterator<avgVelocita> iterator = tList.iterator();  // Iterator interface
			
			while(iterator.hasNext())  // iterate through all the data until the last record
			{
				avgVelocita infoT = iterator.next(); //assign individual employee record to the employee class object
			%>
			<tr height=50px align="center">
				<td><%=infoT.getAvgNome()%></td>
				<td><%=infoT.getAvgMedia()%></td>
			</tr>
			<%
			}
		}
		else{%>
			<tr><td colspan="2">Non sono disponibili le statistiche</td></tr>
		<%
		}
		%>
		</table>
    </div>
</body>
</html>