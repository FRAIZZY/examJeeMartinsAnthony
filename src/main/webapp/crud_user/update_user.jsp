<%-- 
    Document   : update_user
    Created on : 28 janv. 2021, 14:17:46
    Author     : HB
--%>

<%@page import="models.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Utilisateur</title>
        <%@include file="../parts/includeCssFile.jsp" %>
    </head>
    <body>
        <% User detailUser = (User) request.getAttribute("detailUser");%>
        <h1 class="text-center my-5">Update Utilisateur <%= detailUser.getLogin()%></h1>
        
        <form method="POST" action="update_user?id=<%= detailUser.getId() %>">
            <div class="m-auto text-center my-3">
                <input type="text" name="login" value="<%= detailUser.getLogin()%>" class="form-control text-center formTextStyle">
            </div>
            <div class="m-auto text-center my-3">
                <input type="password" name="password" value="<%= detailUser.getPassword()%>" class="form-control text-center formTextStyle">
            </div>
            <div class="m-auto text-center my-3">
                <label for="role">Role de l'utilisateur : </label>
                <select name="role" id="role" class="form-select text-center formTextStyle" aria-label="Default select example">
                    <option value="admin" <% if (detailUser.getRole().equals("admin")) { %>selected<% } %>>Administrateur</option>
                    <option value="user" <% if (detailUser.getRole().equals("user")) { %>selected<% } %>>Utilisateur</option>
                </select>
            </div>
            <div class="m-auto text-center my-3">
                <input type="text" name="lastname" value="<%= detailUser.getLastname()%>" class="form-control text-center formTextStyle">
            </div>
            <div class="m-auto text-center my-3">
                <input type="text" name="firstname" value="<%= detailUser.getFirstname()%>" class="form-control text-center formTextStyle">
            </div>
            <div class="m-auto text-center my-3">
                <input type="date" name="dateEntryCompany" class="form-control text-center formTextStyle">
            </div>
            <div class="m-auto text-center my-3">
                <input type="text" name="phone" value="<%= detailUser.getPhone()%>" class="form-control text-center formTextStyle">
            </div>
            <div class="m-auto text-center my-3">
                <input type="text" name="imageLink" value="<%= detailUser.getImageLink()%>" class="form-control text-center formTextStyle">
            </div>
            <div class="m-auto text-center my-3">
                <input type="submit" value="VALIDER" class="btn btnPrimary">
            </div>
        </form>

        <%@include file="../parts/includeJsFile.jsp" %>
    </body>
</html>
