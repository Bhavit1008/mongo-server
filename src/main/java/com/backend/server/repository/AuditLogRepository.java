package com.backend.server.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.backend.server.model.AuditLog;

@Repository
public interface AuditLogRepository extends MongoRepository<AuditLog, String> {

    Page<AuditLog> findAllByOrderByTimestampDesc(Pageable pageable);

    /** Full history for one product, oldest first — powers the "Added by / Last edited by" panel on View Product. */
    List<AuditLog> findByEntityIdOrderByTimestampAsc(String entityId);

}
