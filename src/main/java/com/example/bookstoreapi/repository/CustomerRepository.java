package com.example.bookstoreapi.repository;

import com.example.bookstoreapi.model.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, Integer> {

    List<Customer> findAllBy();

    Customer findById(@Param("customerId") int customerId);

    void deleteById(@Param("customerId") int customerId);
}
