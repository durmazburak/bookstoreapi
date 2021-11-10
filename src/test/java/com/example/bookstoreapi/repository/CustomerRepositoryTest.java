package com.example.bookstoreapi.repository;

import com.example.bookstoreapi.model.entity.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@AutoConfigureMockMvc
@AutoConfigureDataMongo
@SpringBootTest
public class CustomerRepositoryTest {

    @Autowired
    CustomerRepository repository;

    @BeforeEach
    public void setUp() {
        repository.save(new Customer(1, "Ali","Işık", "ali", "222-111-333", "ali@gmail.com", "Sakarya"));
        repository.save(new Customer(2, "Veli","Koru", "veli", "234-121-645", "veli@gmail.com", "Manisa"));
    }

    @Test
    public void findAllBy() {
        List<Customer> list = repository.findAllBy();
        Customer customer = new Customer();
        customer.setId(3);
        customer.setName("Burak");
        customer.setSurname("Durmaz");
        customer.setEmail("bd@gmail.com");
        customer.setAddress("Istanbul");
        customer.setPhone("555-222-111");
        customer.setUserName("bdurmaz");
        list.add(customer);
        assertNotNull(repository.findAllBy());
    }

    @Test
    public void givenByIdReturnValid(){
        Customer customer = repository.findById(1);
        assertThat(customer.getId()).isEqualTo(1);
    }

    @Test
    public void deleteById(){
        repository.deleteById(1);
        List<Customer> list = repository.findAllBy();
        assertThat(list.size()).isEqualTo(2);
    }
}
