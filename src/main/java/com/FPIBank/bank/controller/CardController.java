package com.FPIBank.bank.controller;

import com.FPIBank.bank.model.Card;
import com.FPIBank.bank.model.User;
import com.FPIBank.bank.service.CardService;
import com.FPIBank.bank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/card")
public class CardController {
    @Autowired
    private CardService cardService;
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public Card createCard(@RequestBody Map<String, Object> body) {
        //TODO: Сделать обработчик ошибок
        User user = null;
        for (User usr : userService.getAllUsers()) {
            if (usr.getId() == (int)body.get("userId")) {
                user = usr;
            }
        }

        return CardService.createCard((int)body.get("id"), (String)body.get("number"), (String)body.get("cvv"), user);
    }
    @DeleteMapping("/")
    public Map<String, Object> deleteCard(@RequestBody Map<String, Object> body) {
        return CardService.deleteCard((int)body.get("id"));
    }
    @PutMapping("/")
    public Map<String, Object> updateCard(@RequestBody Map<String, Object> body) {
        User user = userService.getAllUsers().get((Integer)body.get("userId"));
        return CardService.updateCard((int)body.get("id"), (String)body.get("number"), (String)body.get("cvv"), user);
    }
    @PostMapping("/block/")
    public Map<String, Object> blockCard(@RequestBody Map<String, Object> body) {
        return cardService.blockCard((int)body.get("id"));
    }
}
