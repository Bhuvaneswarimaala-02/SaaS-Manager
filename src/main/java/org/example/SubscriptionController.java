package org.example;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

//@RestController
//@RequestMapping("/api/subscriptions")
//@CrossOrigin(origins = "http://localhost:5173") // Update with frontend URL
//public class SubscriptionController {
//    private final SubscriptionService subscriptionService;
//
//    public SubscriptionController(SubscriptionService subscriptionService) {
//        this.subscriptionService = subscriptionService;
//    }
//
//    @GetMapping
//    public List<Subscription> getSubscriptions() {
//        return subscriptionService.getAllSubscriptions();
//    }
//}

@RestController
@RequestMapping("/subscriptions")
@CrossOrigin(origins = "http://localhost:5173") // Allow frontend to access API
public class SubscriptionController {
    private final SubscriptionDAO subscriptionDAO;

    @Autowired
    public SubscriptionController(SubscriptionDAO subscriptionDAO) {
        this.subscriptionDAO = subscriptionDAO;
    }

    @GetMapping("/all")
    public List<Subscription> getAllSubscriptions() {
        return subscriptionDAO.findAll(); // Fetches all subscriptions
    }
}
