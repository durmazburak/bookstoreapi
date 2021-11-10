package com.example.bookstoreapi.model.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@Document(collection = "customer")
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    private int id;

    /**
     * Customer Name
     */
    private String name;

    /**
     * Customer Surname
     */
    private String surname;

    /**
     * Customer userName
     */
    private String userName;

    /**
     * Customer Phone
     */
    private String phone;

    /**
     * Customer E-mail
     */
    private String email;

    /**
     * Customer Address
     */
    private String address;

    @Transient
    public static final String SEQUENCE_NAME = "customer_sequence";


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
