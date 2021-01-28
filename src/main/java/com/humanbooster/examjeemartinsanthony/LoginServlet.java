/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.humanbooster.examjeemartinsanthony;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.User;
import services.UserService;

/**
 *
 * @author HB
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
        requestDispatcher.include(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Boolean security = securityForm(request, response);
        if (security == true) {
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            UserService newUserService = new UserService();
            try {
                User checkUser = newUserService.checkPasswordUser(login);
                if (checkUser == null) {
                    response.getWriter().append("Mauvais login");
                    processRequest(request, response);
                } else if (checkUser.getPassword().equals(password)) {
                    
                    request.getSession().setAttribute("login", login);
                    request.getSession().setAttribute("lastname", checkUser.getLastname());
                    request.getSession().setAttribute("firstname", checkUser.getFirstname());
                    request.getSession().setAttribute("role", checkUser.getRole());
                    
                    if (checkUser.getRole().equals("admin")) {
                        response.sendRedirect(request.getContextPath() + "/admin");
                    } else {
                        response.sendRedirect(request.getContextPath() + "/list_user");
                    }

                } else {
                    response.getWriter().append("Mauvais password");
                    processRequest(request, response);
                }
            } catch (SQLException ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            processRequest(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    protected boolean securityForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Boolean security = false;
        if (request.getParameter("login").isEmpty()) {
            response.getWriter().append("Champ login obligatoire");
            return security;
        } else if (request.getParameter("password").isEmpty()) {
            response.getWriter().append("Champ password obligatoire");
            return security;
        } else if (request.getParameter("login").contains("<") || request.getParameter("login").contains(">") || request.getParameter("password").contains("<") || request.getParameter("password").contains(">")) {
            response.getWriter().append("Caractère non valide");
            return security;
        } else {
            security = true;
            return security;
        }
    }

}
