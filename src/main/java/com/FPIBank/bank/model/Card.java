package com.FPIBank.bank.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Card {
    int id;
    String number;
    String cvv;
    User user;
    boolean isBlocked;
    public Card(int id, String number, String cvv, User user) {
        this.id = id;
        this.number = number;
        this.cvv = cvv;
        this.user = user;
        this.isBlocked = false;
    }
    public void block() { isBlocked = true; }
    public void unblock() { isBlocked = false; }
}
