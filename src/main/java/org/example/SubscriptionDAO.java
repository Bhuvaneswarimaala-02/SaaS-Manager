//package org.example;

//import org.springframework.stereotype.Repository;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public class SubscriptionDAO {
//
//    // Add Subscription
//    public void addSubscription(Subscription sub) {
//        String query = "INSERT INTO subscriptions (name, price) VALUES (?, ?)";
//        try (Connection conn = DatabaseConnection.getConnection();
//             PreparedStatement stmt = conn.prepareStatement(query)) {
//
//            stmt.setString(1, sub.getName());
//            stmt.setDouble(2, sub.getPrice());
//            stmt.executeUpdate();
//            System.out.println("Subscription Added: " + sub.getName());
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    // Get All Subscriptions
//    public List<Subscription> getAllSubscriptions() {
//        List<Subscription> subscriptions = new ArrayList<>();
//        String query = "SELECT * FROM subscriptions";
//        try (Connection conn = DatabaseConnection.getConnection();
//             Statement stmt = conn.createStatement();
//             ResultSet rs = stmt.executeQuery(query)) {
//
//            while (rs.next()) {
//                subscriptions.add(new Subscription(
//                        rs.getInt("id"),
//                        rs.getString("name"),
//                        rs.getDouble("price")
//                ));
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return subscriptions;
//    }
//}

package org.example;

import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Repository
public class SubscriptionDAO {
    private static final Logger logger = Logger.getLogger(SubscriptionDAO.class.getName());

    // Add Subscription
    public void addSubscription(Subscription sub) {
        String query = "INSERT INTO subscriptions (name, price) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, sub.getName());
            stmt.setDouble(2, sub.getPrice());
            stmt.executeUpdate();
            logger.info("Subscription Added: " + sub.getName());

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error adding subscription: " + e.getMessage(), e);
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
            logger.log(Level.SEVERE, "Error fetching subscriptions: " + e.getMessage(), e);
        }
        return subscriptions;
    }

    public List<Subscription> findAll() {
        List<Subscription> subscriptions = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM subscriptions")) {

            while (rs.next()) {
                Subscription sub = new Subscription();
                sub.setId(rs.getInt("id"));
                sub.setName(rs.getString("name"));
                sub.setPrice(rs.getDouble("price"));
                subscriptions.add(sub);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subscriptions;
    }
}


