package com.example.ObserverPattern.controller;

import com.example.ObserverPattern.dto.User;
import com.example.ObserverPattern.dto.Users;
import com.example.ObserverPattern.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public void createUser(@RequestParam String username) {
        userService.createUser(username);
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

}
