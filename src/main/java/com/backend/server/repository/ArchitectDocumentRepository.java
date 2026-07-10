package com.backend.server.repository;

import com.backend.server.model.ArchitectDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArchitectDocumentRepository extends MongoRepository<ArchitectDocument, String> {
    List<ArchitectDocument> findByArchitectIdOrderByUploadedAtDesc(String architectId);
}
