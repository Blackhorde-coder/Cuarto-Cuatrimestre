<%-- 
    Document   : listadopersonas3
    Created on : 26-oct-2020, 16:34:59
    Author     : Hernan Mauricio Pena leg: 111708
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Persona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="gestor" scope="request" class="gestores.GestorPersonas"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .destacado{
                font-weight: bold;
                background-color: lightblue;
            }
            .normal
            {
                font-weight: bold;
                background-color: lightgreen;                 
            }
        </style>
    </head>
    <body>
        <%@include file="menu.jsp" %>
        <h1>Listado Personas 2 con servlet y EL</h1>
        <table border ="1">

            <C:forEach items="${gestor.obtenerTodos()}" var="persona">
                <C:if test="${not empty persona.apellido}">
                    <tr 
                        <c:choose>
                            <c:when test="${persona.estadoCivil.id == 4}">class="destacado"</c:when>
                            <c:otherwise>class="normal"</c:otherwise>
                        </c:choose>                                    
                        >
                        <td>${persona.nombreCompleto}</td>
                        <td>${persona.apellido}</td>
                        <td>${persona.estadoCivil}
                            <c:if test="${persona.estadoCivil.id == 4}">   
                                <a href="modificarEstado">Cambiar estado civil</a>
                            </c:if> 
                        </td>
                    </tr>
                </C:if>
            </C:forEach>
        </table>
    </body>
</html>
