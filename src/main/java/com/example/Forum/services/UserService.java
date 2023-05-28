package com.example.Forum.services;

import com.example.Forum.models.User;

public interface UserService {

    void save(User user);

    User findByUsername(String username);
}