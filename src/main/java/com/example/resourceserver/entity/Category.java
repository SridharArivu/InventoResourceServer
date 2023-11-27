package com.example.resourceserver.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "category")
public class Category {

    @Id
    private ObjectId id;
    private String clientId;
    private String label;
    private String value;
}
