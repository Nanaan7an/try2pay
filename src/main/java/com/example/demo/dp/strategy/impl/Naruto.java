package com.example.demo.dp.strategy.impl;

import com.example.demo.dp.strategy.Character;
import org.springframework.stereotype.Service;

@Service
public class Naruto extends Character {
    private final String CATEER = "NINNJA";

    @Override
    public String career() {
        return CATEER;
    }
}
