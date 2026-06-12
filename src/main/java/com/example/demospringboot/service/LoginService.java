package com.example.demospringboot.service;

import com.example.demospringboot.entity.User;
import com.example.demospringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    public User login(String username){

        return userRepository.findByUsername(username);

    }

}