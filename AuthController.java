package com.example.ticket.controller;

import com.example.ticket.dto.LoginRequest;
import com.example.ticket.model.User;
import com.example.ticket.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        User savedUser = userService.register(user);
        return ResponseEntity.ok(savedUser);
    }
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        return "Login successful";
    }
}
