<%-- 
    Document   : primerapagina
    Created on : 25-oct-2020, 11:41:51
    Author     : Hernan Mauricio Pena leg: 111708
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%! private int precio; %>
        <h1>Esta es mi primer pagina con JSP</h1>
        <ul>
        <% 
            for (int i = 0; i < 10; i++) 
            {
                  out.println("<li>" + i);  
                }
                int x = 343;
        
        %>
        </ul>
        <h2>asdad13123</h2>
        <p>el precio es: <%= x %></p>
    </body>
</html>
