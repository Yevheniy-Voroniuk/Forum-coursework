package com.example.Forum.controllers;

import com.example.Forum.models.User;
import com.example.Forum.models.enums.Role;
import com.example.Forum.services.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;

@Controller
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin-registration")
    public String adminRegistration() {
        return "admin-registration";
    }

    @PostMapping("/admin-registration")
    public String addAdmin(User user, @RequestParam("adminKey") String adminKey, Model model) {
        if (!adminKey.equals("TEST-KEY")) {
            model.addAttribute("error", "Помилковий ключ адміністратора :(");
            return "admin-registration";
        }

        User userDb = userService.findByUsername(user.getUsername());
        if (userDb != null) {
            model.addAttribute("error", "Користувач вже існує :(");
            return "admin-registration";
        }
        String encodedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.ADMIN));
        userService.saveAdmin(user);

        return "redirect:/login";
    }
}