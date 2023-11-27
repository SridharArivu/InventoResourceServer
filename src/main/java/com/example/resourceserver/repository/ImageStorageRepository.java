package com.example.resourceserver.repository;

import com.example.resourceserver.entity.ImageData;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ImageStorageRepository extends MongoRepository<ImageData, ObjectId> {

   Optional<ImageData> findByName (String fileName);

}
