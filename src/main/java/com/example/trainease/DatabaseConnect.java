package com.example.trainease;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnect {

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/trainease";
        String username = "root";
        String password = "";
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
