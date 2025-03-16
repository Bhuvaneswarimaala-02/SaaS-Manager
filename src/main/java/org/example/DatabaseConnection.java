package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/subscriptions_db"; // Change 'subs_db' to your database name
    private static final String USER = "root";  // Change this to your MySQL username
    private static final String PASSWORD = "Bhuvan24";  // Change this to your MySQL password

    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Database connection established!");
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("❌ Error: Could not establish database connection.");
            return null;
        }
    }

}
