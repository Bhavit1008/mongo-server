package com.backend.server.controller;

import com.backend.server.model.ApprovalRequest;
import com.backend.server.repository.ApprovalRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/notification")
public class ApprovalController {

    @Autowired
    ApprovalRequestRepository approvalRepo;

    // ── Submit a new request (store_manager → admin) ─────────────────────────

    @PostMapping("/submit")
    public ResponseEntity<ApprovalRequest> submit(@RequestBody ApprovalRequest request) {
        request.setStatus("pending");
        request.setRequestedAt(System.currentTimeMillis());
        request.setResolvedAt(null);
        ApprovalRequest saved = approvalRepo.save(request);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // ── Retrieval ─────────────────────────────────────────────────────────────

    @GetMapping("/all")
    public ResponseEntity<List<ApprovalRequest>> getAll() {
        return ResponseEntity.ok(approvalRepo.findAll());
    }

    @GetMapping("/pending")
    public ResponseEntity<List<ApprovalRequest>> getPending() {
        return ResponseEntity.ok(approvalRepo.findByStatus("pending"));
    }

    @GetMapping("/count")
    public ResponseEntity<Long> getPendingCount() {
        return ResponseEntity.ok((long) approvalRepo.findByStatus("pending").size());
    }

    // ── Check whether a specific product has a pending request ────────────────

    @GetMapping("/product/{productId}/pending")
    public ResponseEntity<ApprovalRequest> getProductPending(@PathVariable String productId) {
        List<ApprovalRequest> found = approvalRepo.findByProductIdAndStatus(productId, "pending");
        return ResponseEntity.ok(found.isEmpty() ? null : found.get(0));
    }

    // ── Admin actions ─────────────────────────────────────────────────────────

    @PutMapping("/{id}/approve")
    public ResponseEntity<?> approve(@PathVariable String id) {
        Optional<ApprovalRequest> opt = approvalRepo.findById(id);
        if (opt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Request not found");
        }
        ApprovalRequest req = opt.get();
        if (!"pending".equals(req.getStatus())) {
            return ResponseEntity.badRequest().body("Request is not pending");
        }
        req.setStatus("approved");
        req.setResolvedAt(System.currentTimeMillis());
        return ResponseEntity.ok(approvalRepo.save(req));
    }

    @PutMapping("/{id}/reject")
    public ResponseEntity<?> reject(@PathVariable String id) {
        Optional<ApprovalRequest> opt = approvalRepo.findById(id);
        if (opt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Request not found");
        }
        ApprovalRequest req = opt.get();
        if (!"pending".equals(req.getStatus())) {
            return ResponseEntity.badRequest().body("Request is not pending");
        }
        req.setStatus("rejected");
        req.setResolvedAt(System.currentTimeMillis());
        return ResponseEntity.ok(approvalRepo.save(req));
    }

    // ── Filtering ─────────────────────────────────────────────────────────────

    @GetMapping("/filter")
    public ResponseEntity<List<ApprovalRequest>> filter(
            @RequestParam(required = false) String status,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String requestedBy) {

        List<ApprovalRequest> all = approvalRepo.findAll();

        return ResponseEntity.ok(all.stream()
            .filter(r -> status == null || status.isBlank() || status.equalsIgnoreCase(r.getStatus()))
            .filter(r -> type == null || type.isBlank() || type.equalsIgnoreCase(r.getType()))
            .filter(r -> requestedBy == null || requestedBy.isBlank()
                         || requestedBy.equalsIgnoreCase(r.getRequestedBy()))
            .sorted((a, b) -> Long.compare(
                b.getRequestedAt() == null ? 0 : b.getRequestedAt(),
                a.getRequestedAt() == null ? 0 : a.getRequestedAt()))
            .toList());
    }
}
