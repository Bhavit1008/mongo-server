package com.backend.server.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.backend.server.model.AuditChange;
import com.backend.server.model.AuditLog;
import com.backend.server.model.Employee;
import com.backend.server.model.Product;
import com.backend.server.repository.AuditLogRepository;
import com.backend.server.repository.EmployeeRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AuditLogService {

    @Autowired
    private AuditLogRepository auditLogRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Fields excluded from the diff — either too large/noisy to be useful in
     * an audit trail (pieces, images) or not meaningful business data (id,
     * createdAt is handled separately from user-driven edits).
     */
    private static final Set<String> DIFF_IGNORE_FIELDS = Set.of(
        "id", "createdAt", "pieces", "imageUrl", "imageUrls", "sourceBlock"
    );

    /**
     * Records a CREATE or UPDATE for a product. `before` is the pre-save
     * snapshot (null for a brand-new product); `after` is what was actually
     * persisted. For UPDATE, a no-op save (nothing actually changed) is
     * silently skipped so the log doesn't fill up with noise.
     */
    public void recordProductChange(String action, Product before, Product after, String performedBy) {
        List<AuditChange> changes = "UPDATE".equals(action) ? diff(before, after) : List.of();
        if ("UPDATE".equals(action) && changes.isEmpty()) return;

        Product reference = after != null ? after : before;
        Employee performer = resolveEmployee(performedBy);

        AuditLog log = new AuditLog();
        log.setAction(action);
        log.setEntityType("Product");
        log.setEntityId(reference.getId());
        log.setCategory(reference.getCategory());
        log.setProductCode(reference.getProductCode());
        log.setSlabNumber(reference.getSlabNumber());
        log.setPerformedBy(performedBy);
        log.setPerformedByRole(performer != null ? performer.getRole() : null);
        log.setPerformedByStoreLocation(performer != null ? performer.getStoreLocation() : null);
        log.setTimestamp(System.currentTimeMillis());
        log.setChanges(changes);
        log.setSummary(buildSummary(action, reference, changes));

        auditLogRepository.save(log);
    }

    public Page<AuditLog> getAll(Pageable pageable) {
        return auditLogRepository.findAllByOrderByTimestampDesc(pageable);
    }

    public void deleteAuditLog(String id) {
        if (!auditLogRepository.existsById(id)) {
            throw new IllegalArgumentException("Audit log entry not found: " + id);
        }
        auditLogRepository.deleteById(id);
    }

    private Employee resolveEmployee(String employeeName) {
        if (employeeName == null || employeeName.isBlank()) return null;
        return employeeRepository.findByEmployeeNameIgnoreCase(employeeName.trim()).orElse(null);
    }

    private String displayLabel(Product p) {
        if ("Slab".equalsIgnoreCase(p.getCategory()) && p.getSlabNumber() != null && !p.getSlabNumber().isBlank()) {
            return p.getSlabNumber();
        }
        return p.getProductCode() != null && !p.getProductCode().isBlank() ? p.getProductCode() : p.getId();
    }

    private String buildSummary(String action, Product p, List<AuditChange> changes) {
        String label = (p.getCategory() != null ? p.getCategory() : "Product") + " " + displayLabel(p);
        switch (action) {
            case "CREATE": return "Added " + label;
            case "DELETE": return "Deleted " + label;
            default:
                return "Updated " + label + " (" + changes.size() + " field" + (changes.size() == 1 ? "" : "s") + " changed)";
        }
    }

    @SuppressWarnings("unchecked")
    private List<AuditChange> diff(Product before, Product after) {
        if (before == null || after == null) return List.of();

        Map<String, Object> beforeMap = objectMapper.convertValue(before, new TypeReference<Map<String, Object>>() {});
        Map<String, Object> afterMap = objectMapper.convertValue(after, new TypeReference<Map<String, Object>>() {});

        List<AuditChange> result = new ArrayList<>();
        for (String key : afterMap.keySet()) {
            if (DIFF_IGNORE_FIELDS.contains(key)) continue;

            Object oldVal = beforeMap.get(key);
            Object newVal = afterMap.get(key);
            if (!Objects.equals(oldVal, newVal)) {
                result.add(new AuditChange(key, asString(oldVal), asString(newVal)));
            }
        }
        return result;
    }

    private String asString(Object value) {
        return value == null ? null : String.valueOf(value);
    }
}
