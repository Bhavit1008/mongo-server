package com.backend.server.repository;

import com.backend.server.model.Interaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InteractionRepository extends MongoRepository<Interaction, String> {
    List<Interaction> findByArchitectIdOrderByCreatedAtDesc(String architectId);
}
