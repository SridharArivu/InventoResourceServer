package com.example.resourceserver.repository;

import com.example.resourceserver.entity.LowStokeNotifyURL;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotifyUrlRepository extends MongoRepository<LowStokeNotifyURL, ObjectId> {

    LowStokeNotifyURL findByClientId(String clientId);
}
