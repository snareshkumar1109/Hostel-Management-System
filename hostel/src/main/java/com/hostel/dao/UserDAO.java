package com.hostel.dao;

import com.hostel.connection.DBConnection;
import com.hostel.model.User;

import java.sql.*;

public class UserDAO {
    public User getUserByEmailAndPassword(String email, String password) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet rs = null;

        try {
            con = DBConnection.getConnection();
            String q = "SELECT * FROM users WHERE email = ? AND password = ?";
            statement = con.prepareStatement(q);
            statement.setString(1, email);
            statement.setString(2, password);
            rs = statement.executeQuery();

            if (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
                return user;
            }
        } finally {
            // Close ResultSet, Statement, and Connection in reverse order of their creation
            if (rs != null) rs.close();
            if (statement != null) statement.close();
            if (con != null) con.close();
        }
        return null;
    }

    public boolean registerUser(User user) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement statement = null;

        try {
            con = DBConnection.getConnection();
            String q = "INSERT INTO users(name, email, password, role) VALUES (?, ?, ?, ?)";
            statement = con.prepareStatement(q);
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setString(4, "USER");

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } finally {
            // Close the statement and connection in reverse order of their creation
            if (statement != null) statement.close();
            if (con != null) con.close();
        }
    }
}
