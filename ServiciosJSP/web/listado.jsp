<%-- 
    Document   : listado
    Created on : 12-oct-2020, 20:41:37
    Author     : Hernan Mauricio Pena leg: 111708
--%>

<%@page import="Modelos.Servicio"%>
<%@page import="java.util.ArrayList"%>
<%
    ArrayList<Servicio> lista = (ArrayList<Servicio>) request.getAttribute("listado");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Bienvenido ${usuario}</h1>
        <table>
            <tr><th>tipo</th><th>Descripcion</th><th>Costo</th>
                <%
                    for (Servicio servicio : lista) 
                    {                
                    %>
            <tr>
                <td><%=servicio.getTipo()%></td>
                <td><%=servicio.getDescripcion() %></td>
                <td><%=servicio.getCosto() %></td>
            </tr>
            <%
                }
                %>
        </table>
    </body>
    
</html>
