package com.example.resourceserver.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "notifyurl")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LowStokeNotifyURL {

    @Id
    private ObjectId id;

    private String url;
    private String clientId;
}
