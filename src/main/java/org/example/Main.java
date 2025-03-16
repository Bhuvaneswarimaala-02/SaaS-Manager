package org.example;

//import java.util.List;
//
//public class Main {
//    public static void main(String[] args) {
//        SubscriptionDAO dao = new SubscriptionDAO();
//
//        // Add a Subscription
//        dao.addSubscription(new Subscription(0, "Netflix", 15.99));
//        dao.addSubscription(new Subscription(0, "Spotify", 9.99));
//
//        // Retrieve and Print All Subscriptions
//        List<Subscription> subscriptions = dao.getAllSubscriptions();
//        for (Subscription sub : subscriptions) {
//            System.out.println(sub);
//        }
//    }
//}

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Main {

    private final SubscriptionDAO dao;

    @Autowired
    public Main(SubscriptionDAO dao) {
        this.dao = dao;

        // Add Subscriptions
        dao.addSubscription(new Subscription(0, "Netflix", 15.99));
        dao.addSubscription(new Subscription(0, "Spotify", 9.99));

        // Retrieve and Print All Subscriptions
        List<Subscription> subscriptions = dao.getAllSubscriptions();
        subscriptions.forEach(System.out::println);
    }
}
