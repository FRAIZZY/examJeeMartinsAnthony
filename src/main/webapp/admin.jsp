<%-- 
    Document   : admin
    Created on : 28 janv. 2021, 10:32:41
    Author     : HB
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administration</title>
        <%@include file="parts/includeCssFile.jsp" %>
    </head>
    <body>
        <h1 class="text-center my-5">Administration</h1>
        <div class="container-fluid verticalAlign p-0">
            <button onclick="location.href = 'create_user'" type="button" class="btn btnPrimary m-auto">CREATION UTILISATEUR</button>
            <button onclick="location.href = 'list_user'" type="button" class="btn btnPrimary m-auto">LIST UTILISATEUR</button>
            <button onclick="location.href = 'admin?logout'" type="button" class="btn btnSecondary m-auto">DECONNEXION</button>
        </div>

        <%@include file="parts/includeJsFile.jsp" %>
    </body>
</html>
