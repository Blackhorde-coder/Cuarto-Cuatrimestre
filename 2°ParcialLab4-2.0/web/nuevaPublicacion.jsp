<%-- 
    Document   : nuevaPublicacion
    Created on : 05-nov-2020, 15:36:37
    Author     : Hernan Mauricio Pena leg: 111708
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean  id="GS" scope="request" class="Gestores.GestorActividades"/>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    </head>
    <body>
        <%@include file="menuprincipal.jsp" %>
        <c:choose>
            <c:when test="${ usuario != null}">
                <h1>Cargar Publicacion</h1>
                <div class="row">
                    <div class="col-1"></div>
                    <div class="col-10">
                        <form action="confirmarPublicacion.jsp?tipo=1" method="post">
                            <div class="form-group row">
                                <lavel class="col-sm-4 col-form-label">ACTIVIDAD</lavel>
                                <div class="col-sm-8">
                                    <select name="idActividad" class="form-control"/>
                                    <c:forEach var="a" items="${GS.listaActividad}">
                                        <option value="${a.idActividad}">${a.detalle}</option>
                                    </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-4 col-form-label">TEXTO DE LA PUBLICACION</label>
                                <div class="col-sm-8">
                                    <textarea type="text" name="texto" class="form-control" rows="5"></textarea>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-4 col-form-label">FECHA</label>
                                <div class="col-sm-8">
                                    <input type="text" name="fecha" class="form-control"/>
                                </div>
                            </div>
                            <fieldset class="form-group">
                                <div class="row">
                                    <legend class="col-form-label col-sm-4 pt-0">HABILITADO</legend>
                                    <div class="col-sm-8">
                                        <div class="form-check">
                                            <input type="radio" name ="habilitado" id="true" value="true" class="form-check-input"/>
                                            <label for="SI" class="form-check-label">SI</label>
                                        </div>
                                        <div class="form-check">
                                            <input type="radio" name ="habilitado" id="false" value="false" class="form-check-input"/>
                                            <label for="NO" class="form-check-label">NO</label>
                                        </div>
                                    </div>
                                </div>
                            </fieldset>
                            <input type="submit" value="PUBLICAR"/>
                        </form>
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
