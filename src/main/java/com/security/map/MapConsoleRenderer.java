package com.security.map;

import com.security.entity.Entity;

public class MapConsoleRenderer {

    public static void render(Map map){
        StringBuilder sb = new StringBuilder();

        for (int y = 0; y < map.getMAX_Y(); y++) {
            for (int x = 0; x < map.getMAX_X(); x++) {
                Coordinates coordinates = new Coordinates(x, y);
                if (map.cellIsEmpty(coordinates))
                    sb.append("__");
                else
                    sb.append(chooseSpriteForEntity(map.getEntity(coordinates)));
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    private static String chooseSpriteForEntity(Entity entity){
        return switch (entity.getClass().getSimpleName()) {
            case "Rock"     ->  "##";
            case "Tree"     ->  "!!";
            case "Grass"    ->  "$$";
            case "Herbivore"->  "HE";
            case "Predator" ->  "PR";
            default -> null;
        };
    }
}

