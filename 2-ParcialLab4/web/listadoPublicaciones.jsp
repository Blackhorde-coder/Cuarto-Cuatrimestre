<%-- 
    Document   : listadoPublicaciones
    Created on : 04-nov-2020, 16:26:12
    Author     : Hernan Mauricio Pena leg: 111708
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean  id="GS" scope="request" class="Gestores.GestorActividades"/>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
            <c:when test="${usuario == null}">
                <%
                    request.setAttribute("error", "Usuario o contraseña incorrecta incorrecto");
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
                    rd.forward(request, response);
                %>
            </c:when>
            <c:otherwise>
                <br>
                <div class="row">
                    <div class="col-4"></div>
                    <div class="col-4"><h1>PUBLICACIONES</h1></div>
                    <div class="col-4">
                        <div class="col-3"></div>
                        <div class="col-8">
                            <form action="ListadoPublicaciones" method="post" >
                                <select name="actividad" class="form-control"/>
                                <c:forEach var="a" items="${GS.listaActividad}">
                                    <option value="${a.idActividad}">${a.detalle}</option>
                                </c:forEach>
                                </select>
                                <% request.getSession().setAttribute("origen", "publicaciones");%>
                                <input type="submit" value="BUSCAR"/>
                            </form>
                        </div>
                        <div class="col-1"></div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-1"></div>
                    <div class="col-10">
                        <table class="table table-sm">
                            <thead class="thead-dark">
                                <tr>
                                    <th scope="col">FECHA</th>
                                    <th scope="col">TEXTO</th>
                                    <th scope="col">HABILITADO</th>
                                    <th scope="col"></th>
                                    <th scope="col"></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${listapublicaciones}" var="publicacion">
                                    <tr 
                                        <c:choose>
                                            <c:when test="${publicacion.habilitado == true}">class="table-success"</c:when>
                                            <c:otherwise>class="table-warning"</c:otherwise>
                                        </c:choose> 
                                        >
                                        <td>${publicacion.fecha}</td>
                                        <td>${publicacion.texto}</td>
                                        <td>
                                            <c:choose>
                                                <c:when test="${publicacion.habilitado == true}">SI</c:when>
                                                <c:otherwise>NO</c:otherwise>
                                            </c:choose> 
                                        </td>
                                        <td><a href="/2-ParcialLab4/ModificarPublicacion?id=${publicacion.idPublicacion}&estado=1">Modificar</a></td>
                                        <td><a href="/2-ParcialLab4/ModificarPublicacion?id=${publicacion.idPublicacion}&estado=2">Baja</a></td>
                                    </tr>
                                </c:forEach>
                            </tbody>    
                        </table>
                    </div>
                    <div class="col-1"></div>
                </div>
            </c:otherwise>
        </c:choose>
    </body>
</html>
