/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.User;

/**
 *
 * @author HB
 */
public class UserService implements DAO<User, Integer> {

    @Override
    public ArrayList<User> findAll() throws SQLException {
        ArrayList<User> listUsers = new ArrayList<User>();
        User newUser = null;
        Connection connection = DataConnect.getConnection();
        ResultSet resultSet = null;
        String query = null;

        query = "SELECT * FROM user;";
        PreparedStatement psmt = connection.prepareStatement(query);
        resultSet = psmt.executeQuery();

        while (resultSet.next()) {
            Integer id = resultSet.getInt("id");
            String login = resultSet.getString("login");
            String password = resultSet.getString("password");
            String role = resultSet.getString("role");
            String lastname = resultSet.getString("lastname");
            String firstname = resultSet.getString("firstname");
            Date dateEntryCompany = resultSet.getDate("date_entry_company");
            String phone = resultSet.getString("phone");
            String imageLink = resultSet.getString("imageLink");

            newUser = new User(login, password, role, lastname, firstname, dateEntryCompany, phone, imageLink);
            newUser.setId(id);
            listUsers.add(newUser);
        }

        psmt.close();
        resultSet.close();
        DataConnect.closeConnection(connection);
        return listUsers;
    }

    @Override
    public User getById(Integer id) throws SQLException {
        User newUser = null;
        Connection connection = DataConnect.getConnection();
        ResultSet resultSet = null;
        String query = null;

        query = "SELECT * FROM user WHERE id=?;";
        PreparedStatement psmt = connection.prepareStatement(query);
        psmt.setInt(1, id);
        resultSet = psmt.executeQuery();

        if (resultSet.next()) {
            Integer idUser = resultSet.getInt("id");
            String login = resultSet.getString("login");
            String password = resultSet.getString("password");
            String role = resultSet.getString("role");
            String lastname = resultSet.getString("lastname");
            String firstname = resultSet.getString("firstname");
            Date dateEntryCompany = resultSet.getDate("date_entry_company");
            String phone = resultSet.getString("phone");
            String imageLink = resultSet.getString("imageLink");

            newUser = new User(login, password, role, lastname, firstname, dateEntryCompany, phone, imageLink);
            newUser.setId(idUser);
        }

        psmt.close();
        resultSet.close();
        DataConnect.closeConnection(connection);
        return newUser;
    }

    @Override
    public Integer create(User t) throws SQLException {
        String query = null;
        Integer generatedId = null;
        Connection connection = DataConnect.getConnection();
        ResultSet resultSet = null;

        query = "INSERT INTO user (login, password, role, lastname, firstname, date_entry_company, phone, imageLink) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement psmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        psmt.setString(1, t.getLogin());
        psmt.setString(2, t.getPassword());
        psmt.setString(3, t.getRole());
        psmt.setString(4, t.getLastname());
        psmt.setString(5, t.getFirstname());
        if (t.getDateEntryCompany() == null) {
            psmt.setNull(6, java.sql.Types.DATE);
        } else {
            psmt.setDate(6, t.getDateEntryCompany());
        }
        psmt.setString(7, t.getPhone());
        psmt.setString(8, t.getImageLink());
        psmt.executeUpdate();

        resultSet = psmt.getGeneratedKeys();
        if (resultSet.next()) {
            generatedId = resultSet.getInt(1);
        }

        psmt.close();
        resultSet.close();
        DataConnect.closeConnection(connection);
        return generatedId;
    }

    @Override
    public Integer update(User t) throws SQLException {
        Integer nbUpdate = 0;
        String query = null;
        Connection connection = DataConnect.getConnection();

        query = "UPDATE user SET login = ?, password = ?, role = ?, lastname = ?, firstname = ?, date_entry_company = ?, phone = ?, imageLink = ?  WHERE id = ?;";
        PreparedStatement psmt = connection.prepareStatement(query);
        psmt.setString(1, t.getLogin());
        psmt.setString(2, t.getPassword());
        psmt.setString(3, t.getRole());
        psmt.setString(4, t.getLastname());
        psmt.setString(5, t.getFirstname());
        if (t.getDateEntryCompany() == null) {
            psmt.setNull(6, java.sql.Types.DATE);
        } else {
            psmt.setDate(6, t.getDateEntryCompany());
        }
        psmt.setString(7, t.getPhone());
        psmt.setString(8, t.getImageLink());
        psmt.setInt(9, t.getId());
        nbUpdate = psmt.executeUpdate();
        
        psmt.close();
        DataConnect.closeConnection(connection);
        return nbUpdate;
    }

    @Override
    public void delete(User t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteById(Integer id) throws SQLException {
        String query = null;
        Connection connection = DataConnect.getConnection();

        query = "DELETE FROM user WHERE id=?;";
        PreparedStatement psmt = connection.prepareStatement(query);
        psmt.setInt(1, id);
        psmt.executeUpdate();

        psmt.close();
        DataConnect.closeConnection(connection);
    }

    public User checkPasswordUser(String l) throws SQLException {
        User checkUser = null;
        Connection connection = DataConnect.getConnection();
        ResultSet resultSet = null;
        String query = null;

        query = "SELECT * FROM user WHERE login = ?;";
        PreparedStatement psmt = connection.prepareStatement(query);
        psmt.setString(1, l);
        resultSet = psmt.executeQuery();

        if (resultSet.next()) {
            Integer id = resultSet.getInt("id");
            String login = resultSet.getString("login");
            String password = resultSet.getString("password");
            String role = resultSet.getString("role");
            String lastname = resultSet.getString("lastname");
            String firstname = resultSet.getString("firstname");
            Date dateEntryCompany = resultSet.getDate("date_entry_company");
            String phone = resultSet.getString("phone");
            String imageLink = resultSet.getString("imageLink");

            checkUser = new User(login, password, role, lastname, firstname, dateEntryCompany, phone, imageLink);
            checkUser.setId(id);
        }

        psmt.close();
        resultSet.close();
        DataConnect.closeConnection(connection);
        return checkUser;
    }

}
