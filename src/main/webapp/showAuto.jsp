<head>
<meta charset="ISO-8859-1">
<title>Garage</title>
<link rel="stylesheet" href="css/garage.css">
</head>
<body>
	<%@include  file="normalUserPage.jsp" %>
	<%@page import="java.util.ArrayList"%>
        <%@page import="com.bean.auto"%>
        <%@page import="java.util.Iterator"%> 

        <% ArrayList<auto> tList = (ArrayList) request.getAttribute("showAuto"); %>

        <table class="center">

        <tr ><th > Targa</th><th width=300px>Marca</th><th width=300px>Modello</th><th width=100px>Anno</th><th width=100px>Proprietario</th></tr>
        <%
        // Iterating through subjectList

        if(request.getAttribute("showAuto") != null)  // Null check for the object
        {
            Iterator<auto> iterator = tList.iterator();  // Iterator interface

            while(iterator.hasNext())  // iterate through all the data until the last record
            {
            	auto infoT = iterator.next(); //assign individual employee record to the employee class object
            %>
            <tr height=50px align="center">
                <td><%=infoT.getTarga()%></td>
                <td><%=infoT.getMarca()%></td>
                <td><%=infoT.getModello()%></td>
                <td><%=infoT.getAnno()%></td>
                <td><%=infoT.getEmail()%></td>
            </tr>
            <%
            }
        }
        else{%>
            <tr><td colspan="5">Non ci sono tratte</td></tr>
        <%
        }
        %>
        </table>
</body>
