package com.backend.server.repository;

import com.backend.server.model.User;

import java.util.Optional;

public interface UserRepository extends org.springframework.data.mongodb.repository.MongoRepository<User,String>{

    Optional<User> findByUsername(String username);
    void deleteByisSuperuserFalse();
}
