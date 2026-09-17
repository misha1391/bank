package com.FPIBank.bank.service;

import com.FPIBank.bank.controller.CardController;
import com.FPIBank.bank.controller.UserController;
import com.FPIBank.bank.model.Card;
import com.FPIBank.bank.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CardService {
    private static List<Card> cards = new ArrayList<Card>();
    private static Card getById(int id) {
        for (Card card : cards) {
            if (card.getId() == id) {
                return card;
            }
        }
        return null;
    }

    public static Card createCard(int id, String number, String cvv, User user) {
        return new Card(id, number, cvv, user);
    }
    public List<Card> getAllCards() { return cards; }
    public static Map<String, Object> deleteCard(int id) {
        //TODO: Сделать проверку, на отсутствие id
        cards.remove(getById(id)); // TODO: Проверить, как именно удаляет
        Map<String, Object> answer = new HashMap<>();
        answer.put("Success", true);
        return answer;
    }
    public static Map<String, Object> updateCard(int id, String number, String cvv,  User user) {
        //TODO: Добавить проверку на отсутствие id
        Card card = cards.get(id);
        card.setNumber(number);
        card.setCvv(cvv);

        Map<String, Object> answer = new HashMap<>();
        answer.put("success", true);
        return answer;
    }

    public Map<String, Object> blockCard(int id) {
        for (Card card : cards) {
            if (card.getId() == id) {
                card.block();
            }
        }
        Map<String, Object> answer = new HashMap<>();
        answer.put("Success", true);
        return answer;
    }
}
