package com.example.demo.dp.strategy.impl;

import com.example.demo.dp.strategy.Character;
import org.springframework.stereotype.Service;

@Service
public class Bleach extends Character {
    private final String CATEER = "SHINIGAMO";

    @Override
    public String career() {
        return CATEER;
    }
}
