package com.example.Forum.services;

import com.example.Forum.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    void save(User user);

    User findByUsername(String username);
}