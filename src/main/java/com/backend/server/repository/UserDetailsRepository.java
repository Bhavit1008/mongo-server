package com.backend.server.repository;

import com.backend.server.model.UserDetails;

public interface UserDetailsRepository extends org.springframework.data.mongodb.repository.MongoRepository<UserDetails,String>{
}
