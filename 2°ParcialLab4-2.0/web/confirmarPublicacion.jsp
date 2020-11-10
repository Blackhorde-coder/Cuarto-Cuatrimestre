<%-- 
    Document   : confirmarPublicacion
    Created on : 05-nov-2020, 15:39:52
    Author     : Hernan Mauricio Pena leg: 111708
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="publicacion" scope="session" class="Modelos.Publicacion" />
<jsp:setProperty name="publicacion" property="*" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
            <h1>Editar Publicacion</h1>
            <p>Esta cargando una nueva publicacion, esta seguro?</p>
            <tr><td>${publicacion.idPublicacion}</td></tr>
            <tr><td>${publicacion.idActividad}</td></tr>
            <tr><td>${publicacion.texto}</td></tr>
            <tr><td>${publicacion.fecha}</td></tr>
            <tr><td>${publicacion.habilitado}</td></tr>
            <form action="PublicacionServlet?tipo=1" method="post">
                <input type="submit" value="Cargar" />  
            </form>
</body>
</html>
