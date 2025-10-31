package com.security.entity;

import lombok.Getter;

public class Predator extends Animal{
    @Getter
    private final int attackPower;


    public Predator(int speed, int hp, int attackPower) {
        super(speed, hp);
        this.attackPower = attackPower;
    }
}
