package com.security;

import com.security.entity.*;
import com.security.map.Coordinates;
import com.security.map.Map;
import com.security.map.MapConsoleRenderer;

public class Main {
    public static void main(String[] args) {
        Map map = new Map(45,45);

        map.putEntity(new Predator(), new Coordinates(1, 2));
        map.putEntity(new Predator(), new Coordinates(9, 13));
        map.putEntity(new Predator(), new Coordinates(3, 4));
        map.putEntity(new Rock(), new Coordinates(5, 2));
        map.putEntity(new Herbivore(), new Coordinates(10, 11));
        map.putEntity(new Herbivore(), new Coordinates(12, 14));

        MapConsoleRenderer.render(map);

        int a = 10;
    }
}