package com.backend.server.controller;

import com.backend.server.model.PushSubscription;
import com.backend.server.repository.PushSubscriptionRepository;
import com.backend.server.service.PushNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/push")
public class PushController {

    @Autowired
    PushSubscriptionRepository subscriptionRepo;

    @Autowired
    PushNotificationService pushNotificationService;

    // ── Save subscription from browser ────────────────────────────────────────

    @PostMapping("/subscribe")
    public ResponseEntity<?> subscribe(@RequestBody Map<String, String> body) {
        String endpoint = body.get("endpoint");
        if (endpoint == null || endpoint.isBlank()) {
            return ResponseEntity.badRequest().body("endpoint is required");
        }

        Optional<PushSubscription> existing = subscriptionRepo.findByEndpoint(endpoint);
        PushSubscription sub = existing.orElse(new PushSubscription());

        sub.setEndpoint(endpoint);
        sub.setP256dh(body.get("p256dh"));
        sub.setAuth(body.get("auth"));
        sub.setUserId(body.getOrDefault("userId", "unknown"));
        sub.setRole(body.getOrDefault("role", "store_manager"));
        sub.setCreatedAt(System.currentTimeMillis());

        PushSubscription saved = subscriptionRepo.save(sub);
        System.out.println("[Push] Subscription saved for user: " + saved.getUserId()
                + " | role: " + saved.getRole());
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // ── Remove subscription ───────────────────────────────────────────────────

    @DeleteMapping("/unsubscribe")
    public ResponseEntity<?> unsubscribe(@RequestBody Map<String, String> body) {
        String endpoint = body.get("endpoint");
        if (endpoint != null) {
            subscriptionRepo.deleteByEndpoint(endpoint);
            System.out.println("[Push] Unsubscribed endpoint: " + endpoint.substring(0, Math.min(50, endpoint.length())));
        }
        return ResponseEntity.ok("Unsubscribed");
    }

    // ── Debug: list all stored subscriptions (admin use only) ────────────────

    @GetMapping("/subscriptions")
    public ResponseEntity<List<PushSubscription>> listSubscriptions() {
        return ResponseEntity.ok(subscriptionRepo.findAll());
    }

    // ── Test: fire a real push to all admin subscriptions ────────────────────

    @PostMapping("/test")
    public ResponseEntity<?> sendTestNotification() {
        List<PushSubscription> adminSubs = subscriptionRepo.findByRole("admin");
        if (adminSubs.isEmpty()) {
            return ResponseEntity.ok("No admin subscriptions stored — subscribe first.");
        }
        pushNotificationService.notifyAdmins(
                "Test Push",
                "Push notifications are working correctly!",
                "/approvals"
        );
        return ResponseEntity.ok("Test push triggered for " + adminSubs.size() + " admin subscription(s).");
    }
}
