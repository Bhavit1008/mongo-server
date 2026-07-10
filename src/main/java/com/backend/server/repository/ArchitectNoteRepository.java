package com.backend.server.repository;

import com.backend.server.model.ArchitectNote;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArchitectNoteRepository extends MongoRepository<ArchitectNote, String> {
    List<ArchitectNote> findByArchitectIdOrderByCreatedAtDesc(String architectId);
}
