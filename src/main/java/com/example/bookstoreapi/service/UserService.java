package com.example.bookstoreapi.service;

import com.example.bookstoreapi.model.entity.User;
import com.example.bookstoreapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.bookstoreapi.exeption.NotFoundException;

import java.util.Objects;

@Component
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService (UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User login(User userRequest) {
        User user = userRepository.findByUsername(userRequest.getUsername());

        if (Objects.nonNull(user)) {
            if (!user.getPassword().equalsIgnoreCase(userRequest.getPassword())) {
                throw new NotFoundException("Password is wrong");
            }
            return user;
        }
        else {
            throw new NotFoundException("User Not Found");
        }
    }
}
