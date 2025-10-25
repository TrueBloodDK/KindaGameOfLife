package com.security.map;

public class MapConsoleRenderer {

    public void render(Map map){
        for (int y = 0; y < map.getMAX_Y(); y++) {
            for (int x = 0; x < map.getMAX_X(); x++) {
                if (map.cellIsEmpty(new Coordinates(x, y))){
                    System.out.print("_");
                }
                else
                    System.out.print("#");
            }
            System.out.println();
        }
    }


}

