package com.example.Forum.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {

    @GetMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());

            if (statusCode == HttpStatus.NOT_FOUND.value() ||
                    statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value() ||
                    statusCode == HttpStatus.FORBIDDEN.value()) {
                model.addAttribute("errorCode", statusCode);
                if (statusCode == HttpStatus.NOT_FOUND.value()) {
                    model.addAttribute("errorMessage", "Page Not Found");
                } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                    model.addAttribute("errorMessage", "Internal Server Error");
                } else if (statusCode == HttpStatus.FORBIDDEN.value()) {
                    model.addAttribute("errorMessage", "Access Forbidden");
                }
                return "error";
            }
        }

        model.addAttribute("errorCode", "Unknown Error");
        model.addAttribute("errorMessage", "An error occurred");
        return "error";
    }
}