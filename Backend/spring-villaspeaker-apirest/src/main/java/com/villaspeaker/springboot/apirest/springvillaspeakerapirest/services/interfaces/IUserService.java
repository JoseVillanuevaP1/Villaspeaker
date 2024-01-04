package com.villaspeaker.springboot.apirest.springvillaspeakerapirest.services.interfaces;

import com.villaspeaker.springboot.apirest.springvillaspeakerapirest.entity.User;

import java.util.Optional;

public interface IUserService {

    User save(User user);

    Optional<User> findByUsername(String username);
}
