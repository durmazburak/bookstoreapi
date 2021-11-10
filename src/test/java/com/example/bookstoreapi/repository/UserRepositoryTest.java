package com.example.bookstoreapi.repository;

import com.example.bookstoreapi.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@AutoConfigureMockMvc
@AutoConfigureDataMongo
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void givenByUsernameReturnValid(){
        User user = userRepository.findByUsername("root");
        assertThat(user.getUsername()).isEqualTo("root");
    }

}
