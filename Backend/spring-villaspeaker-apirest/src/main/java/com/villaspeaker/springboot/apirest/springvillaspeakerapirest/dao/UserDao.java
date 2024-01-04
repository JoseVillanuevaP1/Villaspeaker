package com.villaspeaker.springboot.apirest.springvillaspeakerapirest.dao;

import com.villaspeaker.springboot.apirest.springvillaspeakerapirest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDao extends JpaRepository<User,Integer> {
    Optional<User> findByUsername(String username);
}
