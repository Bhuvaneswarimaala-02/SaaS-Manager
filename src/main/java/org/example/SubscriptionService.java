package org.example;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SubscriptionService {
    private final SubscriptionDAO subscriptionDAO;

    public SubscriptionService(SubscriptionDAO subscriptionDAO) {
        this.subscriptionDAO = subscriptionDAO;
    }

    public List<Subscription> getAllSubscriptions() {
        return subscriptionDAO.findAll();
    }
}