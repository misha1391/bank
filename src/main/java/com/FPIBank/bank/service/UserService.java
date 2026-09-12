package com.FPIBank.bank.service;

import com.FPIBank.bank.model.Card;
import com.FPIBank.bank.model.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private List<User> users = new ArrayList<User>();

    public User registerUser(int id, String name, List<Card> cards, String password) {
        User user = new User(id, name, password, cards, LocalDateTime.now());
        users.add(user);
        return user;
    }
    public List<User> getAllUsers() {
        return users;
    }
}
