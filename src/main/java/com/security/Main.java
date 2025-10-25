package com.security;

import com.security.entity.Animal;
import com.security.entity.Predator;
import com.security.map.Coordinates;
import com.security.map.Map;
import com.security.map.MapConsoleRenderer;

public class Main {
    public static void main(String[] args) {
        Map map = new Map(30,20);
        MapConsoleRenderer renderer = new MapConsoleRenderer();

        Predator predator = new Predator();
        map.putEntity(predator, new Coordinates(1, 2));
        map.putEntity(predator, new Coordinates(5, 9));
        map.putEntity(predator, new Coordinates(7, 1));

        renderer.render(map);

        int a = 10;
    }
}