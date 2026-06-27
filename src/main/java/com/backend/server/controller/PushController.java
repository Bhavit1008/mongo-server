package com.backend.server.controller;

import com.backend.server.model.PushSubscription;
import com.backend.server.repository.PushSubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/push")
public class PushController {

    @Autowired
    PushSubscriptionRepository subscriptionRepo;

    @PostMapping("/subscribe")
    public ResponseEntity<?> subscribe(@RequestBody Map<String, String> body) {
        String endpoint = body.get("endpoint");
        if (endpoint == null || endpoint.isBlank()) {
            return ResponseEntity.badRequest().body("endpoint is required");
        }

        // Upsert — replace existing subscription for the same endpoint
        Optional<PushSubscription> existing = subscriptionRepo.findByEndpoint(endpoint);
        PushSubscription sub = existing.orElse(new PushSubscription());

        sub.setEndpoint(endpoint);
        sub.setP256dh(body.get("p256dh"));
        sub.setAuth(body.get("auth"));
        sub.setUserId(body.getOrDefault("userId", "unknown"));
        sub.setRole(body.getOrDefault("role", "store_manager"));
        sub.setCreatedAt(System.currentTimeMillis());

        return new ResponseEntity<>(subscriptionRepo.save(sub), HttpStatus.CREATED);
    }

    @DeleteMapping("/unsubscribe")
    public ResponseEntity<?> unsubscribe(@RequestBody Map<String, String> body) {
        String endpoint = body.get("endpoint");
        if (endpoint != null) {
            subscriptionRepo.deleteByEndpoint(endpoint);
        }
        return ResponseEntity.ok("Unsubscribed");
    }
}
