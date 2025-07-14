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

    public User findById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));
    }

    public User insert(User user) {
        return userRepository.save(user);
    }

    public User update(Integer id, User user) {
        User existingUser = findById(id);
        updateDate(existingUser, user);
        return userRepository.save(existingUser);
    }

    public void updateDate(User existingUser, User user) {
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
    }

    public void delete(Integer id) {
        User user = findById(id);
        userRepository.delete(user);
    }
}
