<%@include  file="inizioAdmin.jsp" %>
<div class="cont">
    <form method="post" action="newTrattaServlet">
        <table >
            <tr>
                <td height="50">Codice della tratta  </td> <td><input type="text" name="cod_t" value=""/></td>
            </tr>
            <tr>
                <td height="50">Nome autostrada</td> <td> <input type="text" name="nome_a" value=""/></td>
            </tr>
            <tr>
                <td height="50">Inizio tratta</td> <td><input type="text" name="inizio_t" value=""/></td>
            </tr>
            <tr>
                <td height="50">Fine tratta</td> <td> <input type="text" name="fine_t" value=""/></td>
            </tr>
            <tr>
                <td height="50" >Lunghezza (km)</td> <td> <input type="number" step="any" value="0" min="0" name="lunghezza" /></td>
            </tr>
            <tr>
                <td height="50">Limite (km/h)</td> <td> <input type="number" step="any" value="0" min="0" name="limite" /></td>
            </tr>
            <tr>
                <td height="50">Controllato da tutor </td>
                <td><input type="radio" name="con" value=0 checked>No<br>
                <input type="radio" name="con" value=1 >Si</td>
            </tr>
            <tr>
                <td colspan="2" height="50" align="center"><input class="button-64" type="submit" value="Aggiungi tratta" /></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>