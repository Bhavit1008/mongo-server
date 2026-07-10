package com.backend.server.repository;

import com.backend.server.model.Sample;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SampleRepository extends MongoRepository<Sample, String> {
    List<Sample> findByArchitectIdOrderByCreatedAtDesc(String architectId);
}
