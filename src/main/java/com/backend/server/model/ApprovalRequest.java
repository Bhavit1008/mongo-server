package com.backend.server.model;

import java.util.Map;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("approval_requests")
public class ApprovalRequest {

    @Id
    private String id;

    private String type;             // "delete" | "sell"
    private String productId;
    private String productCode;
    private String productCategory;
    private Map<String, Object> productSnapshot;
    private String requestedBy;
    private Long requestedAt;        // epoch ms — set by server on submit
    private String status;           // "pending" | "approved" | "rejected"
    private Long resolvedAt;         // epoch ms — null until resolved

    public ApprovalRequest() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getProductId() { return productId; }
    public void setProductId(String productId) { this.productId = productId; }

    public String getProductCode() { return productCode; }
    public void setProductCode(String productCode) { this.productCode = productCode; }

    public String getProductCategory() { return productCategory; }
    public void setProductCategory(String productCategory) { this.productCategory = productCategory; }

    public Map<String, Object> getProductSnapshot() { return productSnapshot; }
    public void setProductSnapshot(Map<String, Object> productSnapshot) { this.productSnapshot = productSnapshot; }

    public String getRequestedBy() { return requestedBy; }
    public void setRequestedBy(String requestedBy) { this.requestedBy = requestedBy; }

    public Long getRequestedAt() { return requestedAt; }
    public void setRequestedAt(Long requestedAt) { this.requestedAt = requestedAt; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Long getResolvedAt() { return resolvedAt; }
    public void setResolvedAt(Long resolvedAt) { this.resolvedAt = resolvedAt; }
}
