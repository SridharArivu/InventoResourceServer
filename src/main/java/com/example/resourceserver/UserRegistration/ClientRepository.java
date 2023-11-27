package com.example.resourceserver.UserRegistration;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends MongoRepository<Client, ObjectId> {

    Client findByEmail (String email);
}
