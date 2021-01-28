<%-- 
    Document   : create_user
    Created on : 28 janv. 2021, 10:52:11
    Author     : HB
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nouveau Utilisateur</title>
        <%@include file="../parts/includeCssFile.jsp" %>
    </head>
    <body>
        <h1 class="text-center my-5">Nouveau Utilisateur</h1>
        <form method="POST" action="create_user">
            <div class="m-auto text-center my-3">
                <input type="text" name="login" placeholder="LOGIN" class="form-control text-center formTextStyle">
            </div>
            <div class="m-auto text-center my-3">
                <input type="password" name="password" placeholder="MOT DE PASSE" class="form-control text-center formTextStyle">
            </div>
            <div class="m-auto text-center my-3">
                <label for="role">Role de l'utilisateur : </label>
                <select name="role" id="role" class="form-select text-center formTextStyle" aria-label="Default select example">
                    <option value="admin">Administrateur</option>
                    <option value="user">Utilisateur</option>
                </select>
            </div>
            <div class="m-auto text-center my-3">
                <input type="text" name="lastname" placeholder="NOM" class="form-control text-center formTextStyle">
            </div>
            <div class="m-auto text-center my-3">
                <input type="text" name="firstname" placeholder="PRENOM" class="form-control text-center formTextStyle">
            </div>
            <div class="m-auto text-center my-3">
                <input type="date" name="dateEntryCompany" class="form-control text-center formTextStyle">
            </div>
            <div class="m-auto text-center my-3">
                <input type="text" name="phone" placeholder="TELEPHONE" class="form-control text-center formTextStyle">
            </div>
            <div class="m-auto text-center my-3">
                <input type="text" name="imageLink" placeholder="IMAGE" class="form-control text-center formTextStyle">
            </div>
            <div class="m-auto text-center my-3">
                <input type="submit" value="VALIDER" class="btn btnPrimary">
            </div>
        </form>
        
        <%@include file="../parts/includeJsFile.jsp" %>
    </body>
</html>
