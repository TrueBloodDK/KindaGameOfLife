package com.security.map;

public class MapConsoleRenderer {

    public void render(Map map){
        StringBuilder sb = new StringBuilder();

        for (int y = 0; y < map.getMAX_Y(); y++) {
            for (int x = 0; x < map.getMAX_X(); x++) {
                if (map.cellIsEmpty(new Coordinates(x, y)))
                    sb.append("__");
                else
                    sb.append(map.getEntity(new Coordinates(x, y)).getSprite());
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}

