package com.example.bookstoreapi.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;


@Data
@NoArgsConstructor
@Document(collection = "database_sequences")
public class Sequence {

    @Id
    private String id;
    private int seq;
}
