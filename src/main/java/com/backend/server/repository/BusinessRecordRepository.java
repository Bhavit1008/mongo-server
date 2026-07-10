package com.backend.server.repository;

import com.backend.server.model.BusinessRecord;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusinessRecordRepository extends MongoRepository<BusinessRecord, String> {
    List<BusinessRecord> findByArchitectIdOrderByCreatedAtDesc(String architectId);
}
