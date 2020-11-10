<%-- 
    Document   : listadoSocios
    Created on : 01-nov-2020, 18:54:44
    Author     : Hernan Mauricio Pena leg: 111708
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelos.Socio"%>
<jsp:useBean id="gestor" class="Gestores.GestorSocios" scope="request" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    </head>
    <body>
        <%@include file="menuprincipal.jsp"%>
        <c:choose>
            <c:when test="${ usuario != null}">
                <h1>Listado de socios</h1>
                <div class="row">
                    <div class="col-1"></div>
                    <div class="col-10">
                        <table class="table table-sm">
                            <thead class="thead-dark">
                                <tr>
                                    <th scope="col">NOMBRE</th>
                                    <th scope="col">APELLIDO</th>
                                    <th scope="col">DOCUMENTO</th>
                                    <th scope="col">DIRECCION</th>
                                    <th scope="col">NUMERO</th>
                                    <th scope="col">LOCALIDAD</th>
                                    <th scope="col">TELEFONO</th>
                                    <th scope="col">EMAIL</th>  
                                    <th scope="col">HABILITADO</th>  
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${gestor.listaSocios}" var="socio">
                                    <tr 
                                        <c:choose>
                                            <c:when test="${socio.habilitado == true}">class="table-success"</c:when>
                                            <c:otherwise>class="table-warning"</c:otherwise>
                                        </c:choose> 
                                        >
                                        <td>${socio.nombre}</td>
                                        <td>${socio.apellido}</td>
                                        <td>${socio.documento}</td>
                                        <td>${socio.direccion}</td>
                                        <td>${socio.numero}</td>
                                        <td>${socio.localidad}</td>
                                        <td>${socio.telefono}</td>
                                        <td>${socio.email}</td>
                                        <td>
                                            <c:choose>
                                                <c:when test="${socio.habilitado == true}">SI</c:when>
                                                <c:otherwise>NO</c:otherwise>
                                            </c:choose> 
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>    
                        </table>
                    </div>
                    <div class="col-1"></div>
                </div>
            </c:when>
            <c:otherwise>
                <%
                    {
                        request.setAttribute("error", "Usuario o contraseña incorrecta incorrecto");
                        RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
                        rd.forward(request, response);
                    }
                %>
            </c:otherwise>
        </c:choose>
    </body>
</html>
