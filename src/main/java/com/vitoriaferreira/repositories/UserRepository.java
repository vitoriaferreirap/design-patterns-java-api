package com.vitoriaferreira.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vitoriaferreira.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}