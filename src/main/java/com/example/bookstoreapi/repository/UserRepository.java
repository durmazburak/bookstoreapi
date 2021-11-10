package com.example.bookstoreapi.repository;

import com.example.bookstoreapi.model.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends MongoRepository<User, Integer> {

    User findByUsername (@Param("username") String username);
}
