<%-- 
    Document   : confirmarpublicacion
    Created on : 02-nov-2020, 20:39:24
    Author     : Hernan Mauricio Pena leg: 111708
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="publicaion" scope="session" class="Modelos.Publicacion" />
<jsp:setProperty name="publicacion" property="*" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="menuprincipal.jsp"%>
        <c:choose>
            <c:when test="${estado == 1}">
                <h1>Editar Publicacion</h1>
                <p>Esta cargando una nueva publicacion, esta seguro?</p>
            <tr><td>${cargarPublicacion.idPublicacion}</td></tr>
            <tr><td>${cargarPublicacion.idActividad}</td></tr>
            <tr><td>${cargarPublicacion.texto}</td></tr>
            <tr><td>${cargarPublicacion.fecha}</td></tr>
            <tr><td>${cargarPublicacion.habilitado}</td></tr>
            <form action="ModificarPublicacion" method="post">
                <input type="submit" value="Cargar" />  
            </form>
        </c:when>
        <c:otherwise>
            <h1>Editar Publicacion</h1>
            <p>Esta cargando una nueva publicacion, esta seguro?</p>
            <tr><td>${cargarPublicacion.idPublicacion}</td></tr>
            <tr><td>${cargarPublicacion.idActividad}</td></tr>
            <tr><td>${cargarPublicacion.texto}</td></tr>
            <tr><td>${cargarPublicacion.fecha}</td></tr>
            <tr><td>${cargarPublicacion.habilitado}</td></tr>
            <form action="CargarPublicacion" method="post">
                <input type="submit" value="Cargar" />  
            </form>
        </c:otherwise>
    </c:choose>

</body>
</html>
