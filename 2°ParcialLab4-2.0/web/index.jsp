<%-- 
    Document   : index
    Created on : 05-nov-2020, 15:16:24
    Author     : Hernan Mauricio Pena leg: 111708
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    </head>
    <body>
        <%@include file="menuprincipal.jsp" %>
        <div class="container">
            <div class="row">
                <div class="alert alert-warning">
                    <%
                        if (request.getAttribute("error") != null && !request.getAttribute("error").equals(""))
                        {
                    %>
                    <h2>${ error }</h2>
                    <% }%>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
                    <div class="card card-signin my-5">
                        <div class="card-body">
                            <h5 class="card-title text-center">LOGEARSE</h5>
                            <form class="form-signin" method="post" action="ServletLogeo">
                                <div class="form-label-group">
                                    <img src="Img/default-user.png" height="80" width="80" class="rounded mx-auto d-block"/>
                                </div>
                                <div class="form-label-group">
                                    <label class="col-12 col-form-label">USUARIO</label>
                                    <div class="col-12">
                                        <input type="text" name="usuario" class="form-control" placeholder="Usuario" required/>     
                                    </div>
                                </div>
                                <div class="form-label-group">
                                    <label class="col-sm-12 col-form-label">CONTRASEÑA</label>
                                    <div class="col-sm-12">
                                        <input type="text" name="contr" class="form-control" placeholder="Contraseña" required/>     
                                    </div>
                                </div>
                                <br>
                                <div class="form-label-group">
                                    <div class="col-sm-12">
                                        <input type="submit" class="btn btn-lg btn-primary btn-block text-uppercase" value="LOGIN"/>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
