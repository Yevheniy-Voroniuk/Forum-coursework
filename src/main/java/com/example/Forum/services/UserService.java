package com.example.Forum.services;

import com.example.Forum.models.enums.Role;
import com.example.Forum.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.example.Forum.models.User;


@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public boolean createUser(User user) {
        String email = user.getEmail();
        if (userRepository.findByEmail(user.getEmail()) != null) return false;
        user.setActive(true);
        user.getRoles().add(Role.ROLE_USER);
        log.info("Збережено нового користувача з поштою: {}", email);
        return true;


    }
}
