<%-- 
    Document   : noticias
    Created on : 29-oct-2020, 20:47:20
    Author     : Hernan Mauricio Pena leg: 111708
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="gestor" class="Gestores.GestorActividades" scope="request" />
<jsp:useBean  id="GS" scope="request" class="Gestores.GestorActividades"/>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="menuprincipal.jsp"%>
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
                        <% request.getSession().setAttribute("origen", "noticias"); %>
                  
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
                        </tr>
                    </thead>
                    <tbody>
                        
                        <c:forEach items="${listapublicaciones}" var="publicacion">
                            <tr> 
                                <c:if test="${publicacion.habilitado == true}">
                                    <td>${publicacion.fecha}</td>
                                    <td>${publicacion.texto}</td>
                                </c:if>    
                            </tr>
                        </c:forEach>
                    </tbody>    
                </table>
            </div>
            <div class="col-1"></div>
        </div>
    </body>
</html>
