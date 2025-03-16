package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubscriptionDAO {

    // Add Subscription
    public void addSubscription(Subscription sub) {
        String query = "INSERT INTO subscriptions (name, price) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, sub.getName());
            stmt.setDouble(2, sub.getPrice());
            stmt.executeUpdate();
            System.out.println("Subscription Added: " + sub.getName());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get All Subscriptions
    public List<Subscription> getAllSubscriptions() {
        List<Subscription> subscriptions = new ArrayList<>();
        String query = "SELECT * FROM subscriptions";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                subscriptions.add(new Subscription(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subscriptions;
    }
}

