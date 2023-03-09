package com.example.trainease.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnect {

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/trainease";
        String username = "root";
        String password = "p@ssw0rdEASE";
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}