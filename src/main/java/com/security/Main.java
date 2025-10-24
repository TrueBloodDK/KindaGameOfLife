package com.security;

public class Main {
    public static void main(String[] args) {
        Map map = new Map();
        map.setMaxCoordinates(50, 100);
        System.out.println(map.getMAX_X());
        System.out.println(map.getMAX_Y());
    }
}