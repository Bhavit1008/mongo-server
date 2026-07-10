package com.backend.server.repository;

import com.backend.server.model.FollowUpTask;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowUpTaskRepository extends MongoRepository<FollowUpTask, String> {
    List<FollowUpTask> findByArchitectIdOrderByCreatedAtDesc(String architectId);
}
