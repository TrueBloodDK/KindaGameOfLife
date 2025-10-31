package com.security;

import com.security.entity.*;
import com.security.map.Coordinates;
import com.security.map.Map;
import com.security.map.MapConsoleRenderer;

public class Main {
    public static void main(String[] args) {
        Map map = new Map(45,45);

        MapConsoleRenderer.render(map);

        int a = 10;
    }
}