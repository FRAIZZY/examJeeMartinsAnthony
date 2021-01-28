/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author HB
 */
public class DataConnect {

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/exam_jee_martins_anthony?serverTimezone=UTC";
        String user = "root";
        String password = "";

        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }

    public static void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }
}
