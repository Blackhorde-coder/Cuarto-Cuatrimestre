<%-- 
    Document   : cargarSocio
    Created on : 29-oct-2020, 21:00:30
    Author     : Hernan Mauricio Pena leg: 111708
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean  id="GS" scope="request" class="Gestores.GestorSocios"/>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    </head>
    <%@include file="menuprincipal.jsp" %>
    <body>
        <c:choose>
            <c:when test="${usuario == null}">
                <%
                    request.setAttribute("error", "Usuario o contraseña incorrecta incorrecto");
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
                    rd.forward(request, response);
                %>
            </c:when>
            <c:otherwise>
                <div class="row">
                    <div class="col-1"></div>
                    <div class="col-10 ">
                        <h1 class="">Cargar Socio</h1>
                        <form action="confirmarsocio.jsp" method="post" >
                            <div class = "form-group row">
                                <label class="col-sm-3 col-form-label">NOMBRES</label>
                                <div class="col-sm-9">
                                    <input id="nombre" type="text" name ="nombre" class="form-control" placeholder="ingrese el nombre" required="true" minlength="1" maxlength="20"/>
                                </div>
                            </div>
                            <div class = "form-group row">
                                <label class="col-sm-3 col-form-label">APELLIDOS</label>
                                <div class="col-sm-9"> 
                                    <input id="apellido" type="text" name ="apellido" class="form-control" placeholder="ingrese el apellido" required="true" minlength="1" maxlength="20"/>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-3 col-form-label">TIPO DE DOCUMENTO</label>
                                <div class="col-sm-3">
                                    <select name="tipodocumento" class="form-control"/>
                                    <c:forEach var="td" items="${GS.tipoDocumentos}">
                                        <option value="${td.idtipodoc}">${td.detalle}</option>
                                    </c:forEach>
                                    </select>
                                </div>
                                <label class="col-sm-2 col-form-label">DOCUMENTO</label>
                                <div class="col-sm-4">                     
                                    <input id="documento" type="number" name ="documento" class="form-control" placeholder="ingrese el documento" required="true" min="1000000" max="99999999"/>
                                </div>
                            </div>                                   
                            <div class="form-group row">
                                <lavel class="col-sm-3 col-form-label">CIUDAD</lavel>
                                <div class="col-sm-9">
                                    <input id="ciudad" type="text" name ="localidad" class="form-control" placeholder="ciudad/localidad" required="true" minlength="1" maxlength="20"/>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-3 col-form-label">DIRECCION</label>
                                <div class="col-sm-4">                    
                                    <input id="direccion" type="text" name ="direccion" class="form-control" placeholder="Direccion" required="true" minlength="1" maxlength="20"/>
                                </div>
                                <label class="col-sm-2 col-form-label">NUMERO</label>
                                <div class="col-sm-3">
                                    <input id="numero" type="number" name ="numero" class="form-control" placeholder="N° casa" required="true" min="1" max="99999"/>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-3 col-form-label">TELEFONO</label>
                                <div class="col-sm-3">
                                    <input id="telefono" type="number" name ="telefono" class="form-control" placeholder="Ingrese el telefono" required="true" min="1" max="999999999"/>
                                </div>
                                <label class="col-sm-2 col-form-label">EMAIL</label>
                                <div class="col-sm-4">
                                    <input id="email" type="email" name ="email" class="form-control" placeholder="Ingrese el correo electronico" required="true" minlength="1" maxlength="20"/>
                                </div>
                            </div>
                            <fieldset class="form-group">
                                <div class="row">
                                    <legend class="col-form-label col-sm-3 pt-0">HABILITADO</legend>
                                    <div class="col-sm-9">
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
                            <div class="row">
                                <div class="col-sm-2"></div>
                                <div class="col-sm-8"><input type="submit" value="CARGAR SOCIO" class="btn btn-primary btn-lg btn-block" onclick="return validar()"/></div>
                                <div class="col-sm-2"></div>
                            </div>
                    </div>
                </form>
                <div class="col-1"></div>
            </div>
        </c:otherwise>
    </c:choose>
</body>

<script>
    function validar()
    {
        let nombre = document.getElementById("nombre");
        let apellido = document.getElementById("apellido");
        let documento = document.getElementById("documento");
        let ciudad = document.getElementById("ciudad");
        let direccion = document.getElementById("direccion");
        let numero = document.getElementById("numero");
        let telefono = document.getElementById("telefono");
        let email = document.getElementById("email");

        if (nombre.value === "")
        {
            alert("Por favor, ingrese un nombre");
            nombre.focus();
            return false;
        }
        if (apellido.value === "")
        {
            alert("Ingrese un apellido");
            apellido.focus();
            return false;
        }
        if (documento.value === "")
        {
            alert("Ingrese un documento");
            documento.focus();
            return false;
        }
        if (ciudad.value === "")
        {
            alert("Ingrese la localidad");
            ciudad.focus();
            return false;
        }
        if (direccion.value === "")
        {
            alert("Ingrese una direccion");
            direccion.focus();
            return false;
        }
        if (numero.value === "")
        {
            alert("Ingrese un numero de direccion");
            numero.focus();
            return false;
        }
        if (telefono.value === "")
        {
            alert("Ingrese un numero de telefono");
            telefono.focus();
            return false;
        }
        if (email.value === "")
        {
            alert("Ingrese un email");
            email.focus();
            return false;
        }
    }

</script>
</html>