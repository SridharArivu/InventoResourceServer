package com.example.resourceserver.UserRegistration;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {

     boolean existsByEmail(String email);

     boolean existsByPassword(String password);
}
