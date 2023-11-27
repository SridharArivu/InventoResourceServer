package com.example.resourceserver.repository;

import com.example.resourceserver.entity.Product;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface addProductRepository extends MongoRepository<Product, ObjectId> {

    Product findByClientIdAndProductId(String ClientId,String productId);

    List<Product> findAllByClientId(String ClientId);
    void deleteByClientIdAndProductId(String ClientId, String productId );

}
