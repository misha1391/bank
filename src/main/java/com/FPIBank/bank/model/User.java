package com.FPIBank.bank.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class User {
    private int id;
    private String name;
    private String password;
    private List<Card> cards;
    private LocalDateTime createdAt;
}
