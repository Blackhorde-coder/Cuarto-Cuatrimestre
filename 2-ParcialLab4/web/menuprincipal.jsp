<%-- 
    Document   : menuprincipal
    Created on : 29-oct-2020, 20:34:49
    Author     : Hernan Mauricio Pena leg: 111708
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<nav class="navbar navbar-light bg-info justify-content-center">
    <form class="form-inline">
        <a href="noticias.jsp" class="btn btn-lg btn-info">NOTICIAS</a>
        <a href="index.jsp" class="btn btn-lg btn-info">LOGIN</a>
        <c:choose>
            <c:when test="${ usuario != null}">
                <a href="altaSocio.jsp" class="btn btn-lg btn-info">ALTA SOCIO</a>
                <a href="cargarPublicacion.jsp" class="btn btn-lg btn-info">NUEVA PUBLICACION</a>
                <a href="listadoPublicaciones.jsp" class="btn btn-lg btn-info">LISTADO PUBLICACIONES</a>
                <a href="listadoSocios.jsp" class="btn btn-lg btn-info">LISTADO SOCIOS</a>
                <a href="ServletLogout" class="btn btn-lg btn-warning" />Cerrar Session</a>
                <label class="text-white">Usuario: </label>
                <label class="text-white">${ usuario } </label>
            </c:when>
            <c:otherwise>
                <label class="text-white">Usuario: </label>
                <label class="text-white">Invitado </label>
            </c:otherwise>
        </c:choose>
    </form>
</nav>
