package com.backend.server.service;

import com.backend.server.model.PushSubscription;
import com.backend.server.repository.PushSubscriptionRepository;
import jakarta.annotation.PostConstruct;
import nl.martijndwars.webpush.Notification;
import nl.martijndwars.webpush.PushService;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Security;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class PushNotificationService {

    @Value("${vapid.public-key}")
    private String vapidPublicKey;

    @Value("${vapid.private-key}")
    private String vapidPrivateKey;

    @Autowired
    private PushSubscriptionRepository subscriptionRepo;

    private PushService pushService;

    @PostConstruct
    public void init() throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        pushService = new PushService(vapidPublicKey, vapidPrivateKey, "mailto:bhavitkanthalia16@gmail.com");
    }

    public void notifyAdmins(String title, String body, String url) {
        List<PushSubscription> adminSubs = subscriptionRepo.findByRole("admin");
        if (adminSubs.isEmpty()) return;

        String payload = buildPayload(title, body, url);

        CompletableFuture.runAsync(() -> {
            for (PushSubscription sub : adminSubs) {
                try {
                    Notification notification = new Notification(
                            sub.getEndpoint(),
                            sub.getP256dh(),
                            sub.getAuth(),
                            payload.getBytes(java.nio.charset.StandardCharsets.UTF_8)
                    );
                    pushService.send(notification);
                } catch (Exception e) {
                    System.err.println("[Push] Failed to notify " + sub.getUserId() + ": " + e.getMessage());
                }
            }
        });
    }

    private String buildPayload(String title, String body, String url) {
        return String.format(
            "{\"title\":\"%s\",\"body\":\"%s\",\"url\":\"%s\"}",
            escape(title), escape(body), url
        );
    }

    private String escape(String s) {
        return s == null ? "" : s.replace("\\", "\\\\").replace("\"", "\\\"");
    }
}
