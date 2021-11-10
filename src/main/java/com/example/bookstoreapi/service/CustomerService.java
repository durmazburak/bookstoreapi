package com.example.bookstoreapi.service;

import com.example.bookstoreapi.model.entity.Customer;
import com.example.bookstoreapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAllBy(){
        return customerRepository.findAllBy();
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public void deleteCustomer(int customerId) {
        customerRepository.deleteById(customerId);
    }

    public Customer findByCustomerId(int customerId){
        return customerRepository.findById(customerId);
    }

}
