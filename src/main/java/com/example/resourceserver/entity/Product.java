package com.example.resourceserver.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties("_class")
public class Product {
    @Id
    private ObjectId id;
    private String clientId;
    private String productId;
    private String category;
    private String title;
    private String description;
    private Integer price;
    private Integer quantity;
    private String size;
    private String imageURL;
}
