package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/subscriptions_db"; // Change 'subs_db' to your database name
    private static final String USER = "root";  // Change this to your MySQL username
    private static final String PASSWORD = "Bhuvan*24";  // Change this to your MySQL password

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
