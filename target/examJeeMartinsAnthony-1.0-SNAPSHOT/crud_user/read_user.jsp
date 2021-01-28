<%-- 
    Document   : read_user
    Created on : 28 janv. 2021, 12:10:34
    Author     : HB
--%>

<%@page import="models.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Détail Utilisateur</title>
        <%@include file="../parts/includeCssFile.jsp" %>
    </head>
    <body>
        <% User detailUser = (User) request.getAttribute("detailUser");%>
        <h1 class="text-center my-5">Détail de l'utilisateur <%= detailUser.getLogin()%></h1>
        
        <div class="container-fluid verticalAlign p-0 row">
            <div class="m-auto text-center my-3 col-12">
                <img src="<%= detailUser.getImageLink()%>" alt="Image de <%= detailUser.getLogin()%>">
            </div>
            <div class="m-auto text-center my-3 col-12">
                <p>Login : <%= detailUser.getLogin()%></p>
            </div>
            <div class="m-auto text-center my-3 col-12">
                <p>Nom : <%= detailUser.getLastname()%></p>
            </div>
            <div class="m-auto text-center my-3 col-12">
                <p>Prénom : <%= detailUser.getFirstname()%></p>
            </div>
            <div class="m-auto text-center my-3 col-12">
                <p>Role : <%= detailUser.getRole()%></p>
            </div>
            <div class="m-auto text-center my-3 col-12">
                <p>Date entrée en entreprise : <%= detailUser.getDateEntryCompany()%></p>
            </div>
            <div class="m-auto text-center my-3 col-12">
                <p>N° Tel : <%= detailUser.getPhone()%></p>
            </div>

            <button onclick="location.href = 'list_user'" type="button" class="btn btnSecondary m-auto">RETOUR</button>
        </div>

        <%@include file="../parts/includeJsFile.jsp" %>
    </body>
</html>
