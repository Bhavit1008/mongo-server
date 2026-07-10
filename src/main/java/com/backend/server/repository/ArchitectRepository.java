package com.backend.server.repository;

import com.backend.server.model.Architect;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArchitectRepository extends MongoRepository<Architect, String> {
}
