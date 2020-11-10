<%-- 
    Document   : index
    Created on : 16-oct-2020, 18:14:06
    Author     : Hernan Mauricio Pena leg: 111708
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LOGIN</title>
    </head>
    <body>
        <h1>Iniciar Sesion</h1>
        <%
            if( request.getAttribute("mensajeError") != null && !request.getAttribute("mensajeError").equals(""))
            {       
        %>
        <h2>${ mensajeError }</h2>
        <% } %>
        <form method="post" action="Login">
            <p>
                <label>USUARIO </label>
                <input name="txtUsuario"/>
            </p>
            <p>
                <label>CONTRASEÑA: </label>
                <input type="password" name="txtPassword"/>
            </p>
            <input type ="submit" value ="Iniciar Sesion"/>          
        </form>
    </body>
</html>
