package com.example.bookstoreapi.controller;

import com.example.bookstoreapi.model.entity.Customer;
import com.example.bookstoreapi.service.CustomerService;
import com.example.bookstoreapi.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping(
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE, path = "/customer/")
public class CustomerController {

    private static final Logger LOG = LoggerFactory.getLogger(CustomerController.class);
    private final CustomerService customerService;
    private final SequenceGeneratorService sequenceGeneratorService;


    @Autowired
    public CustomerController (CustomerService customerService, SequenceGeneratorService sequenceGeneratorService){
        this.customerService = customerService;
        this.sequenceGeneratorService = sequenceGeneratorService;
    }

    @PostMapping(value = "/createCustomer")
    public Customer createCustomer(@RequestBody Customer customer) {
        customer.setId(sequenceGeneratorService.generateSequence(Customer.SEQUENCE_NAME));
        return customerService.save(customer);
    }

    @DeleteMapping("deleteCustomer/{customerId}")
    public void deleteCustomer(@PathVariable int customerId) {
        customerService.deleteCustomer(customerId);
        LOG.info("Delete is successfully.");
    }

    @GetMapping(value = "/getCustomer/{customerId}")
    public Customer getCustomerById(@PathVariable int customerId){
        return customerService.findByCustomerId(customerId);
    }

    @GetMapping(value = "/getCustomer")
    public List<Customer> getAllCustomer(){
        return customerService.findAllBy();
    }
}
