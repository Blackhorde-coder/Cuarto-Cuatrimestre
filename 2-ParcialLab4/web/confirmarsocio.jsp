<%-- 
    Document   : confirmarsocio
    Created on : 01-nov-2020, 17:18:42
    Author     : Hernan Mauricio Pena leg: 111708
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="cargarSocio" scope="session" class="Modelos.Socio" />
<jsp:setProperty name="cargarSocio" property="*" />


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    </head>
    <body>
        <%@include file="menuprincipal.jsp"%>
        <h1>Datos Nuevo Socio</h1>
        <p>Esta cargando un nuevo socio. Esta seguro?</p>
    <tr><td>${cargarSocio.nombre}</td></tr>
    <tr><td>${cargarSocio.apellido}</td></tr>
    <tr><td>${cargarSocio.documento}</td></tr>
    <tr><td>${cargarSocio.direccion}</td></tr>
    <tr><td>${cargarSocio.numero}</td></tr>
    <tr><td>${cargarSocio.localidad}</td></tr>
    <tr><td>${cargarSocio.telefono}</td></tr>
    <tr><td>${cargarSocio.email}</td></tr>
    <tr><td>${cargarSocio.habilitado}</td></tr>
    <form action="CargarSocio" method="post">
        <input type="submit" value="Agregar" />  
    </form>
</body>
</html>
