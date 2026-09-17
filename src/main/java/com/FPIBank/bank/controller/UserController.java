package com.FPIBank.bank.controller;

import com.FPIBank.bank.model.Card;
import com.FPIBank.bank.model.User;
import com.FPIBank.bank.service.CardService;
import com.FPIBank.bank.service.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() { return userService.getAllUsers(); }

    @PostMapping("/register/")
    public User register(@RequestBody Map<String, Object> body) {
        //TODO: Сделать обработчик ошибок
        return userService.registerUser((int)body.get("id"), (String)body.get("name"), (List<Card>)body.get("cards"), (String)body.get("password"));
    }
    @DeleteMapping("/")
    public Map<String, Object> deleteUser(@RequestBody Map<String, Object> body) {
        return userService.deleteUser((int)body.get("id"));
    }
    @PutMapping("/")
    public Map<String, Object> updateUser(@RequestBody Map<String, Object> body) {
        return userService.updateUser((int)body.get("id"), (String)body.get("name"), (List<Card>)body.get("cards"), (String)body.get("password"));
    }
}
