package com.example.resourceserver.repository;

import com.example.resourceserver.entity.Category;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends MongoRepository<Category, ObjectId> {

    List<Category> findAllByClientId (String ClientId);

    void deleteByValue(String value);

}
