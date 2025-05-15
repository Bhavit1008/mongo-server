package com.backend.server.repository;

import com.backend.server.model.Block;

public interface BlockRepository extends org.springframework.data.mongodb.repository.MongoRepository<Block,String>{
}