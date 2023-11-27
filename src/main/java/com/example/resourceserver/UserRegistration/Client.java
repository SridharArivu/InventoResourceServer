package com.example.resourceserver.UserRegistration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "clients")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Client {

    @Id
    private ObjectId id;
    private String clientId;
    private String secret;
    private String email;
}
