package com.backend.server.repository;

import com.backend.server.model.ApprovalRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApprovalRequestRepository extends MongoRepository<ApprovalRequest, String> {
    List<ApprovalRequest> findByStatus(String status);
    List<ApprovalRequest> findByProductIdAndStatus(String productId, String status);
}
