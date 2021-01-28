/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud_user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
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
@WebServlet(name = "UpdateUserServlet", urlPatterns = {"/update_user"})
public class UpdateUserServlet extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");

        if (request.getSession().getAttribute("role") == null || !request.getSession().getAttribute("role").equals("admin")) {
            response.sendRedirect(request.getContextPath() + "/login");
        }

        UserService newUserService = new UserService();
        Integer id = Integer.parseInt(request.getParameter("id"));
        User detailUser = newUserService.getById(id);
        request.setAttribute("detailUser", detailUser);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("crud_user/update_user.jsp");
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateUserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        String lastname = request.getParameter("lastname");
        String firstname = request.getParameter("firstname");

        Date dateEntryCompany = null;

        try {
            Instant instant = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dateEntryCompany")).toInstant();

            ZoneId zoneID = ZoneId.of("Europe/Paris");
            ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(instant, zoneID);

            dateEntryCompany = Date.valueOf(zonedDateTime.toLocalDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String phone = request.getParameter("phone");
        String imageLink = request.getParameter("imageLink");
        UserService newUserService = new UserService();
        User newUser = new User(login, password, role, lastname, firstname, dateEntryCompany, phone, imageLink);
        Integer id = Integer.parseInt(request.getParameter("id"));
        newUser.setId(id);

        try {
            Integer checkUpdate = newUserService.update(newUser);
            if (checkUpdate == null) {
                response.getWriter().append("Erreur, la creation n'a pas pu etre effectuer !");
            } else {
                response.sendRedirect(request.getContextPath() + "/list_user");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CreateUserServlet.class.getName()).log(Level.SEVERE, null, ex);
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

}
