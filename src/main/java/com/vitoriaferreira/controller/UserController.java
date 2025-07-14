package com.vitoriaferreira.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.vitoriaferreira.entities.User;
import com.vitoriaferreira.services.UserServices;

@RestController
@RequestMapping("/users") // mapeamento para todos os endpoints
public class UserController {

    @Autowired
    private UserServices userServices;

    // endpoints
    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> lista = userServices.findAll();
        return ResponseEntity.ok().body(lista);
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User user) {
        user = userServices.insert(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.ok().body(user);
    }

}
