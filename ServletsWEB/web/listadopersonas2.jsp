<%-- 
    Document   : listadopersonas2
    Created on : 25-oct-2020, 16:46:43
    Author     : Hernan Mauricio Pena leg: 111708
--%>

<%@page import="modelo.Persona"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listado Personas 2 con servlet y sciplets</h1>
        <table border ="1">
            
            <% 
                ArrayList<Persona> lista =(ArrayList<Persona>) request.getAttribute("lista");
                for (Persona p : lista) 
                {
                      out.print ("<tr><td>"+ p.getNombre()+"</td><td>"+p.getApellido()+"</td><td>"+p.getEstadoCivil()+"</td></tr>"); 
                }
            %>
                              
        </table>
    </body>
</html>
