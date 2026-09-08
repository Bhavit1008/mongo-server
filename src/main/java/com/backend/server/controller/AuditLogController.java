package com.backend.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.server.model.AuditLog;
import com.backend.server.service.AuditLogService;

@RestController
@CrossOrigin(origins = "*")
public class AuditLogController {

    @Autowired
    private AuditLogService auditLogService;

    /** Newest-first, paginated. Access is gated client-side (admin-only route), same as the rest of this app. */
    @GetMapping("/audit-logs")
    public ResponseEntity<Page<AuditLog>> getAuditLogs(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "50") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(auditLogService.getAll(pageable));
    }

    /**
     * Full history for one product — powers the "Added by / Last edited by"
     * panel on View Product. Unlike the rest of this controller, this one is
     * NOT admin-gated: both roles can see who added/edited a product and
     * what changed, they just can't browse the global audit log.
     */
    @GetMapping("/audit-logs/entity/{entityId}")
    public ResponseEntity<java.util.List<AuditLog>> getAuditLogsForEntity(@PathVariable String entityId) {
        return ResponseEntity.ok(auditLogService.getForEntity(entityId));
    }

    /** Access is gated client-side (admin-only route + admin-only delete button), same as the rest of this app. */
    @DeleteMapping("/audit-logs/{id}")
    public ResponseEntity<?> deleteAuditLog(@PathVariable String id) {
        try {
            auditLogService.deleteAuditLog(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
