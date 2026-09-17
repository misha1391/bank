package com.FPIBank.bank.service;

import com.FPIBank.bank.model.Card;
import com.FPIBank.bank.model.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    private List<User> users = new ArrayList<User>();
    private User getById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User registerUser(int id, String name, List<Card> cards, String password) {
        User user = new User(id, name, password, cards, LocalDateTime.now());
        users.add(user);
        return user;
    }
    public List<User> getAllUsers() { return users; }
    public Map<String, Object> deleteUser(int id) {
        users.remove(getById(id));
        Map<String, Object> answer = new HashMap<>();
        answer.put("success", true);
        return answer;
    }
    public Map<String, Object> updateUser(int id, String name, List<Card> cards, String password) {
        //TODO: Добавить проверку на отсутствие id
        for (User user : users) {
            if (user.getId() == id) {
                user.setName(name);
                user.setCards(cards);
                user.setPassword(password);
            }
        }
        Map<String, Object> answer = new HashMap<>();
        answer.put("success", true);
        return answer;
    }
}
