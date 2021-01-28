<%-- 
    Document   : login
    Created on : 28 janv. 2021, 09:42:35
    Author     : HB
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <%@include file="parts/includeCssFile.jsp" %>
    </head>
    <body>
        <h1 class="text-center mt-5">Authentification</h1>
        <form method="POST" action="login">
            <div class="m-auto text-center">
                <input type="text" name="login" placeholder="VOTRE LOGIN" class="form-control text-center formTextStyle">
            </div>
            <div class="m-auto text-center">
                <input type="password" name="password" placeholder="VOTRE MOT DE PASSE" class="form-control text-center formTextStyle">
            </div>
            <div class="m-auto text-center">
                <input type="submit" value="CONNEXION" name="submit" class="btn btnPrimary">
            </div>
        </form>

        <%@include file="parts/includeJsFile.jsp" %>
    </body>
</html>
