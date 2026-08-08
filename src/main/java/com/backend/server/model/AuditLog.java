package com.backend.server.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * One entry per Product create/update/delete, for admin-only audit review.
 * Written by AuditLogService, hooked into ProductService.saveProduct /
 * deleteProduct — every write to a Block or Slab goes through there, so this
 * is the single choke point that captures them all (manual edits, status
 * changes like Sold/Process, approvals, etc.).
 */
@Document("AuditLog")
public class AuditLog {

    @Id
    private String id;

    /** CREATE, UPDATE or DELETE */
    private String action;

    private String entityType;
    private String entityId;

    // Denormalized for easy display without re-joining against Product.
    private String category;
    private String productCode;
    private String slabNumber;

    private String performedBy;
    private String performedByRole;
    private Long timestamp;

    /** Human-readable one-liner, e.g. "Updated Slab MB-666 (2 fields changed)". */
    private String summary;

    /** Field-level diff — only populated for UPDATE. */
    private List<AuditChange> changes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getSlabNumber() {
        return slabNumber;
    }

    public void setSlabNumber(String slabNumber) {
        this.slabNumber = slabNumber;
    }

    public String getPerformedBy() {
        return performedBy;
    }

    public void setPerformedBy(String performedBy) {
        this.performedBy = performedBy;
    }

    public String getPerformedByRole() {
        return performedByRole;
    }

    public void setPerformedByRole(String performedByRole) {
        this.performedByRole = performedByRole;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<AuditChange> getChanges() {
        return changes;
    }

    public void setChanges(List<AuditChange> changes) {
        this.changes = changes;
    }
}
