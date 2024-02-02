package com.backend.server.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.backend.server.model.GatePassEntries;

public interface GatePassEntriesRepository extends org.springframework.data.mongodb.repository.MongoRepository<GatePassEntries, String> {

}
