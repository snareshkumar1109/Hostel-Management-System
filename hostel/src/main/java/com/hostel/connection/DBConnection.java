package com.hostel.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:8082/hostel"; // Replace with your database
    private static final String USER = "root"; // Replace with your username
    private static final String PASSWORD = "12345"; // Replace with your password

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL JDBC Driver
        return DriverManager.getConnection(URL, USER, PASSWORD); // Establish connection
    }
}
