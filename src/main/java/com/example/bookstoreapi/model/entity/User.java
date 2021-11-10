package com.example.bookstoreapi.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@NoArgsConstructor
@Document(collection = "user")
public class User {

    @Id
    private int id;
    private String username;
    private String password;
}
