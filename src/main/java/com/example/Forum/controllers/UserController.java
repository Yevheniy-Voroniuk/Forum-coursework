package com.example.Forum.controllers;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.example.Forum.models.User;
import com.example.Forum.models.enums.Role;
import com.example.Forum.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {
        User userDb = userService.findByUsername(user.getUsername());
        if (userDb != null) {
            model.put("error", "Користувач вже існує :(");
            return "registration";
        }
        String encodedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userService.save(user);

        return "redirect:/login";
    }
}