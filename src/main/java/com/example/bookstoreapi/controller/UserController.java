package com.example.bookstoreapi.controller;

import com.example.bookstoreapi.model.entity.User;
import com.example.bookstoreapi.security.JwtTokenService;
import com.example.bookstoreapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE, path = "/user/")
public class UserController {
    private final UserService userService;
    private final JwtTokenService jwtTokenService;

    @Autowired
    public UserController (UserService userService, JwtTokenService jwtTokenService){
        this.userService = userService;
        this.jwtTokenService = jwtTokenService;
    }

    @PostMapping("/login")
    public String login(@Valid @RequestBody User userRequset) {
        User user = userService.login(userRequset);
        return jwtTokenService.generateToken(user);
    }
}
