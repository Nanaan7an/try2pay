package com.example.demo.dp.strategy;

import com.example.demo.dp.strategy.impl.Bleach;
import org.springframework.stereotype.Service;

@Service
public class StrategyTest {
    public void  test(){
        Character ichigo=new Bleach();
        ichigo.career();
    }
}
