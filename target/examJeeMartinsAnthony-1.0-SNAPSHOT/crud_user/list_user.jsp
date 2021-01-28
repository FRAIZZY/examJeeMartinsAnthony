<%-- 
    Document   : list_user
    Created on : 28 janv. 2021, 10:43:12
    Author     : HB
--%>

<%@page import="models.User"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Utilisateur</title>
        <%@include file="../parts/includeCssFile.jsp" %>
    </head>
    <body>
        <h1 class="text-center my-5">List Utilisateur</h1>
        <div class="container-fluid verticalAlign p-0">
            <table class="table">
                <thead>
                    <tr class="text-center">
                        <th class="border border-dark">ID</th>
                        <th class="border border-dark">Login</th>
                        <th class="border border-dark">Nom</th>
                        <th class="border border-dark">Prenom</th>
                        <th class="border border-dark">Role</th>
                        <th class="border border-dark">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <% ArrayList<User> listUsers = (ArrayList<User>) request.getAttribute("listUsers");
                        for (User user : listUsers) {%>
                    <tr>
                        <td class="border border-dark text-center"><%= user.getId()%></td>
                        <td class="border border-dark text-center"><%= user.getLogin()%></td>
                        <td class="border border-dark text-center"><%= user.getLastname()%></td>
                        <td class="border border-dark text-center"><%= user.getFirstname()%></td>
                        <td class="border border-dark text-center"><%= user.getDateEntryCompany()%></td>
                        <td class="border border-dark text-center">
                            <a href="read_user?id=<%= user.getId()%>""><i class="fas fa-eye"></i></a>
                                <% if (request.getSession().getAttribute("role") != null && request.getSession().getAttribute("role").equals("admin")) {%>
                            <a href="update_user?id=<%= user.getId()%>" class="mx-3"><i class="fas fa-user-edit"></i></a>
                            <a href="list_user?delete=<%= user.getId()%>"><i class="far fa-trash-alt"></i></a>
                                <% } %>
                        </td>
                    </tr>
                    <% }%>
                </tbody>
            </table>
            <% if (request.getSession().getAttribute("role") != null && request.getSession().getAttribute("role").equals("admin")) {%>
            <button onclick="location.href = 'admin'" type="button" class="btn btnPrimary m-auto">ADMINISTRATION DASHBOARD</button>
            <% }%>
            <button onclick="location.href = 'list_user?logout'" type="button" class="btn btnSecondary m-auto">DECONNEXION</button>
        </div>

        <%@include file="../parts/includeJsFile.jsp" %>
    </body>
</html>
