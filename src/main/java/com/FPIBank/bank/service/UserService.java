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

    public User registerUser(int id, String name, List<Card> cards, String password) {
        User user = new User(id, name, password, cards, LocalDateTime.now());
        users.add(user);
        return user;
    }
    public List<User> getAllUsers() { return users; }
    public Map<String, Object> deleteUser(int id) {
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

    public Card createCard(int userId, int id, String number, String cvv) {
        Card card = new Card(id, number, cvv);
        for (User user : users) {
            if(user.getId() == userId) {
                user.getCards().add(card);
            }
        }
        return card;
    }
    public List<Card> getAllCards() { return users.get(0).getCards(); }
    public Map<String, Object> deleteCard(int userId, int id) {
        //TODO: Сделать проверку, на отсутствие id
        for (User user : users) {
            if(user.getId() == userId) {
                user.getCards().remove(id);
            }
        }
        Map<String, Object> answer = new HashMap<>();
        answer.put("Success", true);
        return answer;
    }
    public Map<String, Object> updateCard(int userId, int id, String number, String cvv) {
        //TODO: Добавить проверку на отсутствие id
        for (User user : users) {
            if (user.getId() == userId) {
                for (Card card : user.getCards()) {
                    card.setNumber(number);
                    card.setCvv(cvv);
                }
            }
        }
        Map<String, Object> answer = new HashMap<>();
        answer.put("success", true);
        return answer;
    }
}
