package com.example.Forum.controllers;

import com.example.Forum.models.User;
import com.example.Forum.models.enums.Role;
import com.example.Forum.services.UserService;
import jakarta.validation.Valid;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    public String adminRegistration(Model model) {
        model.addAttribute("admin", new User());
        return "admin-registration";
    }

    @PostMapping("/admin-registration")
    public String addAdmin(@Valid @ModelAttribute("admin") User admin, BindingResult bindingResult,
                           @RequestParam("adminKey") String adminKey, Model model) {
        if (bindingResult.hasErrors()) {
            return "admin-registration";
        }

        if (!adminKey.equals("TEST-KEY")) {
            model.addAttribute("error", "Помилковий ключ адміністратора :(");
            return "admin-registration";
        }

        User userDb = userService.findByUsername(admin.getUsername());
        if (userDb != null) {
            model.addAttribute("error", "Користувач вже існує :(");
            return "admin-registration";
        }

        String encodedPassword = new BCryptPasswordEncoder().encode(admin.getPassword());
        String encodedAdminKey = new BCryptPasswordEncoder().encode(adminKey);
        admin.setPassword(encodedPassword);
        admin.setAdminKey(encodedAdminKey);
        admin.setActive(true);
        admin.setRoles(Collections.singleton(Role.ADMIN));
        userService.saveAdmin(admin);

        return "redirect:/login";
    }
}