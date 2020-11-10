<%-- 
    Document   : listadopersonas
    Created on : 25-oct-2020, 16:20:33
    Author     : Hernan Mauricio Pena leg: 111708
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Persona"%>
<%@page import="gestores.GestorPersonas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listado de personas sin servlets</h1>
        
        <table border="1">
            <% 
                GestorPersonas gestor = new GestorPersonas();
                ArrayList <Persona> lista = gestor.obtenerTodos();
                for (Persona persona : lista) 
                {
                      out.print("<tr><td>"+persona.getNombre()+"</td><td>"+persona.getApellido()+"</td><td>"+persona.getEstadoCivil()+"</td><tr>");  
                }
              
            %>
        </table>
    </body>
</html>
