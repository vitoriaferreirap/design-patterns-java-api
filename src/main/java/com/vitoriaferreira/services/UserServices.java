package com.vitoriaferreira.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vitoriaferreira.entities.User;
import com.vitoriaferreira.repositories.UserRepository;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    // Métodos usados do JPA Repository
    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User insert(User user) {
        return userRepository.save(user);
    }
}
