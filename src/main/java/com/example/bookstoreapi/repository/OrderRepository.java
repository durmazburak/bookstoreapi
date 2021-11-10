package com.example.bookstoreapi.repository;

import com.example.bookstoreapi.model.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends MongoRepository<Order, Integer> {

    List<Order> findAllBy();

    List<Order> findOrderByCustomerId(@Param("customerId") int customerId);
}


