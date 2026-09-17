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
    public List<User> getAllUsers() { return userService.getAllUsers(); }

    @PostMapping("/register")
    public User register(@RequestBody Map<String, Object> body) {
        //TODO: Сделать обработчик ошибок
        return userService.registerUser(Integer.parseInt((String)body.get("id")), (String)body.get("name"), (List<Card>)body.get("cards"), (String)body.get("password"));
    }
    @DeleteMapping("/user")
    public Map<String, Object> deleteUser(@RequestBody Map<String, Object> body) {
        return userService.deleteUser((int)body.get("id"));
    }
    @PutMapping("/user")
    public Map<String, Object> updateUser(@RequestBody Map<String, Object> body) {
        return userService.updateUser((int)body.get("id"), (String)body.get("name"), (List<Card>)body.get("cards"), (String)body.get("password"));
    }

    @PostMapping("/card")
    public Card createCard(@RequestBody Map<String, Object> body) {
        //TODO: Сделать обработчик ошибок
        return userService.createCard((int)body.get("userId"), (int)body.get("id"), (String)body.get("number"), (String)body.get("cvv"));
    }
    @DeleteMapping("/card")
    public Map<String, Object> deleteCard(@RequestBody Map<String, Object> body) {
        return userService.deleteCard((int)body.get("userId"), (int)body.get("id"));
    }
    @PutMapping("/card")
    public Map<String, Object> updateCard(@RequestBody Map<String, Object> body) {
        return userService.updateCard((int)body.get("userId"), (int)body.get("id"), (String)body.get("number"), (String)body.get("cvv"));
    }
}
