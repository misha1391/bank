package com.FPIBank.bank.controller;

import com.FPIBank.bank.model.Card;
import com.FPIBank.bank.model.User;
import com.FPIBank.bank.service.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/register")
    public User register(@RequestBody Map<String, String> body) {
        List<Card> cards = new ArrayList<>();

        return userService.registerUser(Integer.parseInt(body.get("id")), body.get("name"), cards, body.get("password"));
    }
}
