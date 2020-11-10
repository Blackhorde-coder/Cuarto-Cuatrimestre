<%-- 
    Document   : nuevaPersona
    Created on : 26-oct-2020, 17:24:21
    Author     : Hernan Mauricio Pena leg: 111708
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="gestor" scope="request" class="gestores.GestorPersonas"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        
        <%@include file="menu.jsp" %>

        <div><h1>Alta de nueva persona</h1></div>
        <form action="confirmacion.jsp" method="post">
        <table>
            <tr><td>Nombre</td><td><input type="text" name ="nombre"/></td></tr>
            <tr><td>Apellido</td><td><input type="text" name="apellido" /></td><td></td></tr>
            <tr><td>Edad</td><td><input type="number" name="edad" /></td><td></td></tr>
            <tr><td>Estado Civil</td><td>
                    <select name="idEstadoCivil">
                        <c:forEach var="ec" items="${gestor.estadosCiviles}">
                            <option value="${ec.id}">${ec.nombre}
                        </c:forEach>
                    </select>
            </td></tr>
            <tr><td></td><td><input type="submit" value="Agregar persona"></td><td></td></tr>
        </table>
        </form>
    </body>
</html>
